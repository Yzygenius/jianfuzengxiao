//订单Marker类---------------------------------------------------------------------------------------------
MarkerDemind.TypeSingle = "Single";
MarkerDemind.TypeGroup = "Group";
MarkerDemind.StateNormal = "Normal";
MarkerDemind.StateWarning = "Warning";
MarkerDemind.StateDelay = "Delay";
MarkerDemind.StateDamege = "Damege";
function MarkerDemind(pageMap,dataList){
    this.marker = new AMap.Marker({
        map: pageMap,
        offset: new AMap.Pixel(-22, -54),
        autoRotation: true,
        zIndex: 300,
    });
    this.dataList = dataList; //携带数据

    this.iniMarkerDemind();
}
MarkerDemind.prototype.iniMarkerDemind = function(){
    this.type = this.getMarkerType(); //Marker类型 Single/Group
    this.state = this.getMarkerState(); //Marker状态
    this.setPosition([this.dataList[0].custLongitude,this.dataList[0].custLatitude]);
    this.setDisplay();
    this.marker.evtData=this;

    this.bindEvent('mouseover',this.openTipInfo);
    this.bindEvent('mouseout',this.closeTipInfo);
    this.bindEvent('click', markerDemindOnclick);
}
//获取订单Marker类型
MarkerDemind.prototype.getMarkerType = function(){
    if(this.dataList.length==1){
        return MarkerDemind.TypeSingle;
    }else if(this.dataList.length>1){
        return MarkerDemind.TypeGroup;
    }
}
//获取订单Marker状态
MarkerDemind.prototype.getMarkerState = function(){
    var nowDate = new Date(),overDate;
    var stateFlgList=[];
    for(var i=0; i<this.dataList.length; i++){
        overDate = new Date(this.dataList[i].loadEndtime);
        if((overDate.getTime()-nowDate.getTime())/(1000*60*60*24)==1){//运输剩余时间少于一天警告
            stateFlgList.push(MarkerDemind.StateWarning);
        }else if((overDate.getTime()-nowDate.getTime())/(1000*60*60*24)<0){//运输超时标注
            stateFlgList.push(MarkerDemind.StateDelay);
        }else{//正常运输
            stateFlgList.push(MarkerDemind.StateNormal);
        }
    }
    
    if(stateFlgList.indexOf(MarkerDemind.StateDamege)>=0){
        return MarkerDemind.StateDamege;
    }else if(stateFlgList.indexOf(MarkerDemind.StateDelay)>=0){
        return MarkerDemind.StateDelay;
    }else if(stateFlgList.indexOf(MarkerDemind.StateWarning)>=0){
        return MarkerDemind.StateWarning;
    }else{
        return MarkerDemind.StateNormal;
    }
}
//设置订单Marker显示
MarkerDemind.prototype.setDisplay = function(){
    if(this.getMarkerType()==MarkerDemind.TypeSingle){
        switch(this.getMarkerState()){
            case MarkerDemind.StateNormal:
                this.marker.setIcon(ImageIcon.MapDemindNormal);
                break;
            case MarkerDemind.StateWarning:
                this.marker.setIcon(ImageIcon.MapDemindWarning);
                break;
            case MarkerDemind.StateDelay:
                this.marker.setIcon(ImageIcon.MapDemindDelay);
                break;
        }
    }else{
        var icon,color;
        switch(this.getMarkerState()){
            case MarkerDemind.StateNormal:
                icon=ImageIcon.MapGroupNormal;
                color="#1e5b9b";break;
            case MarkerDemind.StateWarning:
                icon=ImageIcon.MapGroupWarning;
                color="#b2933e";break;
            case MarkerDemind.StateDelay:
                icon=ImageIcon.MapGroupDelay;
                color="#952424";break;
            case MarkerDemind.StateDamege:
                icon=ImageIcon.MapGroupDamage;
                color="#000000";break;
        }
        this.marker.setContent("<div style='width:44px;height:54px;background:url("+icon+
                ") no-repeat 100% 100%;color:"+color+
                ";text-align:center;line-height:45px;font-size:20px;font-weight:bold;'>"+this.getDataCount()+"</div>");
    }
}
//添加DemindMark的Tip
MarkerDemind.prototype.openTipInfo = function(){
	var demindData = this.getTarMarkerData(0);
	if(this.getMarkerType()==MarkerDemind.TypeSingle){
		var title = {"icon": ImageIcon.Dingdan_G,"text": demindData.demindNum};
		var content = "<img src='"+ImageIcon.Start+"'style='vertical-align:middle;margin-right:5px;'></img><span style='font-weight:bold;'>"+demindData.shipFactory +"</span>"+
		"</br>" + demindData.originProvinceName + "-" + demindData.originCityName + 
		"</br>" + demindData.originAddr +
		"</br><img src='"+ImageIcon.End+"'style='vertical-align:middle;margin-right:5px;'></img><span style='font-weight:bold;'>"+demindData.custFactory +"</span>"+
		"</br>" + demindData.custProvName + "-" + demindData.custCityName + 
		"</br>" + demindData.destAddr +
		"</br></br>货物类型：" + demindData.goodsName +
		"</br>货物重量：" + demindData.weight + " 吨" +
		"</br>已运重量：" + demindData.weight + " 吨" +
		"</br>开始日期：" + demindData.loadStarttime +
		"</br>截止日期：" + demindData.loadEndtime;
		var bottom = {"icon": ImageIcon.Huoche_G,"text": "正在运输车辆："+ demindData.transitVehicleCount};
		this.tipInfo = new TipInfo(title.icon,title.text,content,bottom.icon,bottom.text);
	}else{
		//TODO
	}
}
MarkerDemind.prototype.closeTipInfo = function(){
    if(this.tipInfo != null && this.tipInfo != undefined){
        this.tipInfo.closeTipInfo();
    }
}
MarkerDemind.prototype.getMarkerData = function(){ //获取Marker数据
    return this.dataList;
}
MarkerDemind.prototype.getTarMarkerData = function(index){ //获取指定位置数据
    return this.dataList[index];
}
MarkerDemind.prototype.setPosition = function(lnglat){ //设置Marker位置
    this.marker.setPosition(lnglat);
}
MarkerDemind.prototype.getPosition = function(){ //获取Marker位置
    return this.marker.getPosition();
}
MarkerDemind.prototype.getPositionList = function(){ //获取包含代表的所有坐标点
    var positionList = [];
    for(var i=0; i<this.dataList.length; i++){
        positionList.push({
            longitude: this.dataList[i].custLongitude,
            latitude: this.dataList[i].custLatitude,
        });
    }
    return positionList;
}
MarkerDemind.prototype.getDataCount = function(){ //获取数量
    return this.dataList.length;
}
MarkerDemind.prototype.bindEvent = function(eventName,eventFun){ //添加Marker事件
    this.marker.on(eventName,eventFun,this);
}
MarkerDemind.prototype.unbindEvent = function(eventName,eventFun){ //移除Marker事件
    this.marker.off(eventName,eventFun,this);
}
MarkerDemind.prototype.remove = function(){ //移除Marker
    if(this.marker.getMap()!=null){
        this.marker.getMap().remove(this.marker);
    }
}