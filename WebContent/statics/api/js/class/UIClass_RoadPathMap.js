function RoadPathMap(targetId){
    //绑定元素
	this.element = $(targetId);
	this.map = new AMap.Map(targetId, {
		jogEnable: false,//保证显示准确性 取消拖拽缓动
		resizeEnable: true,//保证显示准确性 添加窗口变化响应
	});
	
	this.iniRoadPathMap();
}
RoadPathMap.prototype.iniRoadPathMap = function(){
	var thisObj = this;

	//同时引入工具条插件，比例尺插件和鹰眼插件
	AMap.plugin([
		'AMap.Scale',
		'AMap.OverView',
	], function(){
		// 在图面添加比例尺控件，展示地图在当前层级和纬度下的比例尺
		thisObj.map.addControl(new AMap.Scale());
		// 在图面添加鹰眼控件，在地图右下角显示地图的缩略图
		thisObj.map.addControl(new AMap.OverView({isOpen:true}));
	});
	
	this.markerStart = new AMap.Marker({
		map: this.map,
		icon: ImageIcon.MapStart,
		offset: new AMap.Pixel(-22, -54),
		zIndex: 300, //zIndex相同时按对象生成顺序显示
		animation: "AMAP_ANIMATION_DROP",
	});
	this.markerEnd = new AMap.Marker({
		map: this.map,
		icon: ImageIcon.MapEnd,
		offset: new AMap.Pixel(-22, -54),
		zIndex:300,
		animation: "AMAP_ANIMATION_DROP",
	});
	this.markerCar = new AMap.Marker({
		map: this.map,
		//icon: "https://webapi.amap.com/images/car.png",
		//offset: new AMap.Pixel(-26, -13),
		//icon: 'http://47.104.70.216/dazong/statics/manager/image/icons/mapcar.png',
		//offset: new AMap.Pixel(-13, -27),
		icon: ImageIcon.MapCarNormal,
		offset: new AMap.Pixel(-22, -54),
		autoRotation: false,
		zIndex:400,
		animation: "AMAP_ANIMATION_DROP",
	});
	this.polyline = new AMap.Polyline({
		map: this.map,
		showDir:true,
		strokeColor: "#28F",  //线颜色
		strokeOpacity: 1,     //线透明度
		strokeWeight: 6,      //线宽
		// strokeStyle: "solid"  //线样式
		zIndex:100,
	});
	this.passedPolyline = new AMap.Polyline({
		map: this.map,
		//strokeColor: "#AF5",  //线颜色
		strokeColor: "#AE5",
		strokeOpacity: 0.7,     //线透明度
		strokeWeight: 4,      //线宽
		// strokeStyle: "solid"  //线样式
		zIndex:100,
	});

	this.loca = Loca.create(this.map);

	this.clearMap();
}
//添加Marker
RoadPathMap.prototype.addMapMarker = function(marker,position){
	this.map.add(marker);
	marker.setPosition(position);
}
RoadPathMap.prototype.setRoadPathMap = function(pathData,start,end,moveFlg){
	var thisObj = this;
	//
	this.addMapMarker(this.markerCar,start);
	this.addMapMarker(this.markerStart,start);
	this.addMapMarker(this.markerEnd,end);
	//
	this.getGraspPath(pathData,function(graspPath){
		thisObj.polyline.setPath(graspPath);
		thisObj.drawPathPoint(pathData);
		if(moveFlg){
			thisObj.drawMove(graspPath);
		}
	});
}
//获得纠偏数据
RoadPathMap.prototype.getGraspPath = function(pathData,getGraspBack){
	//纠偏数据
	var graspPath = [];
	graspPath[0]={"x":parseFloat(pathData[0].longitude),"y":parseFloat(pathData[0].latitude),"sp":Math.round(pathData[0].speed),"ag":Math.round(pathData[0].bearing), "tm":Date.parse(pathData[0].createTime)/1000};
	for(var i = 1; i < pathData.length; i++){
		graspPath[i]={"x":parseFloat(pathData[i].longitude),"y":parseFloat(pathData[i].latitude),"sp":Math.round(pathData[i].speed),"ag":Math.round(pathData[i].bearing), "tm":(Date.parse(pathData[i].createTime)-Date.parse(pathData[i-1].createTime))/1000};
	}
	AMap.plugin('AMap.GraspRoad',function(){
		//纠偏调用
		var graspRoad = new AMap.GraspRoad();
		graspRoad.driving(graspPath,function(error,result){
			var returnPath=[];
			var newPath;
			if(!error){
				newPath = result.data.points;
				for(var i=0; i<newPath.length; i++){
					returnPath[i]=[newPath[i].x,newPath[i].y];
				}
			}else{
				//new PopInfo(PopInfo.TypeAlertWarning,"车辆行驶路线数据纠偏失败！<br><br> 展示路线会有部分偏差");
				//new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"警告", "车辆行驶路线数据纠偏失败！<br><br> 展示路线会有部分偏差");
				newPath = pathData;
				for(var i=0; i<newPath.length; i++){
					returnPath[i]=[newPath[i].longitude,newPath[i].latitude];
				}
			}
			getGraspBack(returnPath);
		})
	})
}
//生成路线点MarkerList
RoadPathMap.prototype.drawPathPoint = function(pathData){
	console.log(pathData)
	//
	var pathLayerData = [];
	var pointFlg = Math.ceil(pathData.length/(this.getMarkerPointCount(pathData,30000)+1));//取点间隔值
	for(var i = 0; i<pathData.length; i++){
		if(i%pointFlg==pointFlg-1 && i != pathData.length-1){//i在间隔值上且不是最后一个点
			pathLayerData.push({
				lnglat: pathData[i].longitude + "," + pathData[i].latitude,
				createTime: pathData[i].createTime,
				depth: 100 + i,
			});
		}
	}

	//
	this.pathLayer = Loca.visualLayer({
        container: this.loca,
        fitView: true,
        type: 'point',
		shape: 'circle',
		eventSupport: true,
		zIndex: 200,
	});

	this.pathLayer.setData(pathLayerData, {
        lnglat: 'lnglat'
    });

	option = {
        style: {
            radius: 5,
            color: "#ffc000",
            opacity: 1,
            borderWidth: 2,
            borderColor: "#ffffff",//'#f5a930',
        }
	}
    this.pathLayer.setOptions(option);
	this.pathLayer.render();
	this.pathLayer.setFitView();

	var tip;
	this.bindEvent("mouseenter",function(ev){
		var tipData = ev.rawData;
		var tipText = "<span style='font-weight:bold;'>采集时间：</span><br>"+ tipData.createTime;
		tip = new Tip(tipText);
	})
	this.bindEvent("mouseleave",function(){
		if(tip!=null && tip!=undefined){
			tip.closeTip();
		}
	})
}
RoadPathMap.prototype.drawMove = function(pathData){
	//画路经
	this.polyline.setPath(pathData);
	//5秒完成动画
	this.startAnimation(this.markerCar,pathData,this.getMoveSpeed(this.getPathDis(pathData),5));
}
//获取移动速度-在某个时间（秒）完成移动距离
RoadPathMap.prototype.getMoveSpeed = function(distance,moveTime){
	return Math.floor(distance/1000/moveTime*3600);
}
//获得路径总距离
RoadPathMap.prototype.getPathDis = function(path){
	return AMap.GeometryUtil.distanceOfLine(path);
}
//获取路径点数量 30KM间隔
RoadPathMap.prototype.getMarkerPointCount = function(pathData,dis){
	var pathList=[];
	for(var i=0; i<pathData.length; i++){
		pathList.push([pathData[i].longitude,pathData[i].latitude]);
	}
	return Math.ceil(this.getPathDis(pathList)/dis);
}
//标签运动
RoadPathMap.prototype.startAnimation = function(tarMarker, path, speed){
	tarMarker.moveAlong(path, speed);
	//运动轨迹
	tarMarker.on('moving',this.markerMove,this);
}
RoadPathMap.prototype.pauseAnimation = function(tarMarker){
	tarMarker.pauseMove();
}
RoadPathMap.prototype.resumeAnimation = function(tarMarker){
	tarMarker.resumeMove();
}
RoadPathMap.prototype.stopAnimation = function(tarMarker){
	tarMarker.stopMove();
}
//创建移动
RoadPathMap.prototype.markerMove = function(e){
	this.passedPolyline.setPath(e.passedPath);
};
RoadPathMap.prototype.clearMap = function(){
	//清除Marker
	this.map.remove(this.markerStart);
	this.map.remove(this.markerEnd);
	this.map.remove(this.markerCar);
	
	//清除线路
	this.polyline.setPath([]);
	this.passedPolyline.setPath([]);
}
RoadPathMap.prototype.bindEvent = function(eventName,eventFun){
	this.pathLayer.on(eventName,eventFun,this);
}
RoadPathMap.prototype.unbindEvent = function(eventName,eventFun){
	this.pathLayer.off(eventName,eventFun,this);
}