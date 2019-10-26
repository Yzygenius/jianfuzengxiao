//标注点Marker类---------------------------------------------------------------------------------------------
function MarkerPathPoint(pageMap,pointData){
    this.marker = new AMap.Marker({
        map: pageMap,
        offset: new AMap.Pixel(-7.5, -7.5),
        zIndex: 200,
    });
    this.pointData = pointData;

    this.iniMarkerPathPoint();
}
MarkerPathPoint.prototype.iniMarkerPathPoint = function(){
    this.setPosition([this.pointData.longitude,this.pointData.latitude]);
    this.setDisplay();
    this.marker.evtData=this;

    this.bindEvent('mouseover',this.openTipInfo);
    this.bindEvent('mouseout',this.closeTipInfo);
}
//添加markPoint的Tip
MarkerPathPoint.prototype.openTipInfo = function(){
    var pointData = this.getMarkerData();
	// var title = {"icon": ImageIcon.Huoche_G,"text": pointData.plateNumber};
	// var content = "<img src='"+ImageIcon.Start+"'style='vertical-align:middle;margin-right:5px;'></img>" + pointData.originProvinceName + "-" + pointData.originCityName + 
	// "</br>" + pointData.originAddr +
	// "</br><img src='"+ImageIcon.End+"'style='vertical-align:middle;margin-right:5px;'></img>" + pointData.custProvName + "-" + pointData.custCityName+
	// "</br>" + pointData.destAddr;
    // var bottom = {"icon": "","text": "采集时间："+ this.getMarkerData().createTime};
    // this.tipInfo = new TipInfo(title.icon,title.text,content,bottom.icon,bottom.text);
    var tipText = "<span style='font-weight:bold;'>采集时间：</span><br>"+ pointData.createTime;
	this.tipInfo = new Tip(tipText);
}
MarkerPathPoint.prototype.closeTipInfo = function(){
    if(this.tipInfo != null && this.tipInfo != undefined){
        this.tipInfo.closeTip();
    }
}
MarkerPathPoint.prototype.setDisplay = function(){
    this.marker.setIcon(ImageIcon.MapPoint);
}
MarkerPathPoint.prototype.getMarkerData = function(){ //获取Marker数据
    return this.pointData;
}
MarkerPathPoint.prototype.setPosition = function(lnglat){ //设置Marker位置
    this.marker.setPosition(lnglat);
}
MarkerPathPoint.prototype.getPosition = function(){ //获取Marker位置
    return this.marker.getPosition();
}
MarkerPathPoint.prototype.bindEvent = function(eventName,eventFun){ //添加Marker事件
    this.marker.on(eventName,eventFun,this);
}
MarkerPathPoint.prototype.unbindEvent = function(eventName,eventFun){ //移除Marker事件
    this.marker.off(eventName,eventFun,this);
}
MarkerPathPoint.prototype.remove = function(){ //移除Marker
    if(this.marker.getMap()!=null){
        this.marker.getMap().remove(this.marker);
    }
}