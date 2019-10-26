MarkerCar.TypeSingle = "Single";
MarkerCar.TypeGroup = "Group";
MarkerCar.StateNormal = "Normal";
MarkerCar.StateWarning = "Warning";
MarkerCar.StateDelay = "Delay";
MarkerCar.StateDamege = "Damege";
//车次Marker类---------------------------------------------------------------------------------------------
function MarkerCar(pageMap,dataList){
    this.marker = new AMap.Marker({
        map: pageMap,
        offset: new AMap.Pixel(-22, -54),
        autoRotation: true,
        zIndex: 300,
    });
    this.dataList = dataList; //携带数据

    this.iniMarkerCar();
}
MarkerCar.prototype.iniMarkerCar = function(){
    this.type = this.getMarkerType(); //Marker类型 Single/Group
    this.state = this.getMarkerState(); //Marker状态
    this.setPosition([this.dataList[0].longitude,this.dataList[0].latitude]);
    this.setDisplay();
    this.marker.evtData=this;

    this.bindEvent('mouseover',this.openTipInfo);
    this.bindEvent('mouseout',this.closeTipInfo);
    this.bindEvent('click', markerCarOnclick);
}
//获取车次Marker类型
MarkerCar.prototype.getMarkerType = function(){
    if(this.dataList.length==1){
        return MarkerCar.TypeSingle;
    }else if(this.dataList.length>1){
        return MarkerCar.TypeGroup;
    }
}
//获取车次Marker状态
MarkerCar.prototype.getMarkerState = function(){
    var nowDate = new Date(),overDate;
    var stateFlgList=[];
    for(var i=0; i<this.dataList.length; i++){
        overDate = new Date(this.dataList[i].endTime);
        if((overDate.getTime()-nowDate.getTime())/(1000*60*60*24)==1){//运输剩余时间少于一天警告
            stateFlgList.push(MarkerCar.StateWarning);
        }else if((overDate.getTime()-nowDate.getTime())/(1000*60*60*24)<0){//运输超时标注
            stateFlgList.push(MarkerCar.StateDelay);
        }else{//正常运输
            stateFlgList.push(MarkerCar.StateNormal);
        }
    }
    
    if(stateFlgList.indexOf(MarkerCar.StateDamege)>=0){
        return MarkerCar.StateDamege;
    }else if(stateFlgList.indexOf(MarkerCar.StateDelay)>=0){
        return MarkerCar.StateDelay;
    }else if(stateFlgList.indexOf(MarkerCar.StateWarning)>=0){
        return MarkerCar.StateWarning;
    }else{
        return MarkerCar.StateNormal;
    }
}
//设置车次Marker显示
MarkerCar.prototype.setDisplay = function(){
    if(this.getMarkerType()==MarkerCar.TypeSingle){
        switch(this.getMarkerState()){
            case MarkerCar.StateNormal:
                this.marker.setIcon(ImageIcon.MapCarNormal);
                break;
            case MarkerCar.StateWarning:
                this.marker.setIcon(ImageIcon.MapCarWarning);
                break;
            case MarkerCar.StateDelay:
                this.marker.setIcon(ImageIcon.MapCarDelay);
                break;
            case MarkerCar.StateDamege:
                this.marker.setIcon(ImageIcon.MapCarDamage);
                break;
        }
    }else{
        var icon,color;
        switch(this.getMarkerState()){
            case MarkerCar.StateNormal:
                icon=ImageIcon.MapGroupNormal;
                color="#1e5b9b";break;
            case MarkerCar.StateWarning:
                icon=ImageIcon.MapGroupWarning;
                color="#b2933e";break;
            case MarkerCar.StateDelay:
                icon=ImageIcon.MapGroupDelay;
                color="#952424";break;
            case MarkerCar.StateDamege:
                icon=ImageIcon.MapGroupDamage;
                color="#000000";break;
        }
        this.marker.setContent("<div style='width:44px;height:54px;background:url("+icon+
                ") no-repeat 100% 100%;color:"+color+
                ";text-align:center;line-height:45px;font-size:20px;font-weight:bold;'>"+this.getDataCount()+"</div>");
    }
}
//添加CarMark的Tip
MarkerCar.prototype.openTipInfo = function(){
	var carData = this.getTarMarkerData(0);
	if(this.getMarkerType()==MarkerCar.TypeSingle){
		var title = {"icon": ImageIcon.Huoche_G,"text": carData.plateNumber};
		var content = "<img src='"+ImageIcon.Start+"'style='vertical-align:middle;margin-right:5px;'></img><span style='font-weight:bold;'>"+carData.shipFactory +"</span>"+
		"</br>" + carData.originProvinceName + "-" + carData.originCityName + 
		"</br>" + carData.originAddr +
		"</br><img src='"+ImageIcon.End+"'style='vertical-align:middle;margin-right:5px;'></img><span style='font-weight:bold;'>"+carData.custFactory +"</span>"+
		"</br>" + carData.custProvName + "-" + carData.custCityName + 
		"</br>" + carData.destAddr +
		"</br></br>货物类型：" + carData.goodsName +
		"</br>运输重量：" + carData.primaryWeight + " 吨" +
		"</br>开始时间：" + carData.loadStarttime;
		var bottom = {"icon": ImageIcon.Rili_G,"text": "截止日期："+ carData.loadEndtime};
		this.tipInfo = new TipInfo(title.icon,title.text,content,bottom.icon,bottom.text);
	}else{
		//TODO
	}
}
MarkerCar.prototype.closeTipInfo = function(){
    if(this.tipInfo != null && this.tipInfo != undefined){
        this.tipInfo.closeTipInfo();
    }
}
MarkerCar.prototype.getMarkerData = function(){ //获取Marker数据
    return this.dataList;
}
MarkerCar.prototype.getDataCount = function(){ //获取数量
    return this.dataList.length;
}
MarkerCar.prototype.getTarMarkerData = function(index){ //获取指定位置数据
    return this.dataList[index];
}
MarkerCar.prototype.setPosition = function(lnglat){ //设置Marker位置
    this.marker.setPosition(lnglat);
}
MarkerCar.prototype.getPosition = function(){ //获取Marker位置
    return this.marker.getPosition();
}
MarkerCar.prototype.getPositionList = function(){ //获取包含代表的所有坐标点
    var positionList=[];
    for(var i=0; i<this.dataList.length; i++){
        positionList.push({
            longitude: this.dataList[i].longitude,
            latitude: this.dataList[i].latitude,
        });
    }
    return positionList;
}
MarkerCar.prototype.bindEvent = function(eventName,eventFun){ //添加Marker事件
    this.marker.on(eventName,eventFun,this);
}
MarkerCar.prototype.unbindEvent = function(eventName,eventFun){ //移除Marker事件
    this.marker.off(eventName,eventFun,this);
}
MarkerCar.prototype.remove = function(){ //移除Marker
    if(this.marker.getMap()!=null){
        this.marker.getMap().remove(this.marker);
    }
}