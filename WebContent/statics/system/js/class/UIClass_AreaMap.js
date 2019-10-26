function AreaMap(targetId){
    //绑定元素
	this.element = $(targetId);
	
	this.map = new AMap.Map(targetId, {
		jogEnable: false,//保证显示准确性 取消拖拽缓动
		resizeEnable: true,//保证显示准确性 添加窗口变化响应
	});
	
	this.iniAreaMap();
}
AreaMap.prototype.iniAreaMap = function(){
	var thisObj = this;
	this.markerDemindList = [];
	this.markerCarList = [];
	this.markerPointList = [];

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
	//地图加载后
	// AMapUI.loadUI(['control/BasicControl'], function(BasicControl) {
	// 	//缩放控件，显示Zoom值
	// 	thisObj.map.addControl(new BasicControl.Zoom({
	// 		position: 'rt',
	// 		showZoomNum: true
	// 	}));
	// });
	this.setFitViewArea = new AMap.Rectangle({
		map: this.map,
		strokeOpacity: 0,//轮廓线透明度
		fillOpacity: 0,//填充透明度
	})
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

	this.clearMap();
}
//创建缩放视角设置适应
AreaMap.prototype.setFitViewByPositionList = function(positionList){
	var nelng,nelat,swlng,swlat;
	nelng=positionList[0].longitude;
	nelat=positionList[0].latitude;
	swlng=positionList[0].longitude;
	swlat=positionList[0].latitude;
	for(var i=1; i<positionList.length; i++){
		if(positionList[i].longitude>nelng){
			nelng=positionList[i].longitude;
		}else if(positionList[i].longitude<swlng){
			swlng=positionList[i].longitude;
		}
		if(positionList[i].latitude>nelat){
			nelat=positionList[i].latitude;
		}else if(positionList[i].latitude<swlat){
			swlat=positionList[i].latitude;
		}
	}
	this.setFitViewArea.setBounds(new AMap.Bounds([swlng,swlat],[nelng,nelat]));
	this.map.add(this.setFitViewArea);
	//设置地图缩放适应
	this.setFitView();
}
AreaMap.prototype.setFitView = function(){
	this.map.setFitView();
}
//生成订单MarkerList
AreaMap.prototype.drawMarkerDemindList = function(demindList){
	this.markerDemindList=[];
	var groupList = this.markerDemindGroup(demindList);

	for(var i=0; i<groupList.length; i++){
		var newMarkerDemind = new MarkerDemind(this.map,groupList[i]);
		this.markerDemindList.push(newMarkerDemind);
	}
	
	console.log("订单Marker数量："+this.markerDemindList.length);
}
//生成车辆MarkerList
AreaMap.prototype.drawMarkerCarList = function(vehicleList){
	this.markerCarList=[];
	var groupList = this.markerCarGroup(vehicleList);
	
	for(var i=0; i<groupList.length; i++){
		var newMarkerCar = new MarkerCar(this.map,groupList[i]);
		this.markerCarList.push(newMarkerCar);
	}
	
	console.log("车辆Marker数量："+this.markerCarList.length);
}
//生成路线点MarkerList
AreaMap.prototype.drawMarkerPointList = function(pathData){
	this.markerPointList=[];
	var pointFlg = Math.ceil(pathData.length/(this.getMarkerPointCount(pathData,30000)+1));//取点间隔值
	for(var i = 0; i<pathData.length; i++){
		if(i%pointFlg==pointFlg-1 && i != pathData.length-1){//i在间隔值上且不是最后一个点
			var newMarkerPoint = new MarkerPathPoint(this.map,pathData[i]);
			this.markerPointList.push(newMarkerPoint);
		}
	}

	console.log("路线Marker数量："+this.markerPointList.length);
}
//设置订单标签聚合
AreaMap.prototype.markerDemindGroup = function(demindList){
	this.inMapMarkerList=[];
	
	for(var i=0; i<demindList.length; i++){
		if(this.getInMap([demindList[i].custLongitude,demindList[i].custLatitude])){
			this.inMapMarkerList.push({
				id:demindList[i].demindId,
				position:[demindList[i].custLongitude,demindList[i].custLatitude],
				data:demindList[i],
			});
		}
	}
	return this.getGroupList(this.inMapMarkerList);
}
//设置车次标签聚合
AreaMap.prototype.markerCarGroup = function(vehicleList){
	this.inMapMarkerList=[];

	for(var i=0; i<vehicleList.length; i++){
		if(this.getInMap([vehicleList[i].longitude,vehicleList[i].latitude])){
			this.inMapMarkerList.push({
				id:vehicleList[i].demindVehicleId,
				position:[vehicleList[i].longitude,vehicleList[i].latitude],
				data:vehicleList[i],
			});
		}
	}
	return this.getGroupList(this.inMapMarkerList);
}
//将地图显示内标签打组
AreaMap.prototype.getGroupList = function(inMapMarkerList){
	var checkedList=[];//聚合检验过的订单列表
	var startPosition,endPosition;
	var dis;//订单间实际距离
	var groupList=[];

	for(var i=0; i<inMapMarkerList.length; i++){
		if(checkedList.indexOf(inMapMarkerList[i].id)==-1){
			groupList[groupList.length]=[];
			groupList[groupList.length-1].push(inMapMarkerList[i].data);
			checkedList.push(inMapMarkerList[i].id);
			startPosition=inMapMarkerList[i].position;
			//TODO 优化算法 选中的不再执行
			for(var j=1; j<inMapMarkerList.length; j++){
				if(checkedList.indexOf(inMapMarkerList[j].id)==-1){
					endPosition=inMapMarkerList[j].position;
					dis = this.getPositionDis(startPosition,endPosition);
					if(dis<this.getZoomScaleDis()*50){//50是Marker图标的拟合尺寸
						groupList[groupList.length-1].push(inMapMarkerList[j].data);
						checkedList.push(inMapMarkerList[j].id);
					}
				}
			}
		}
	}
	return groupList;
}
//绘制路线
AreaMap.prototype.drawPath = function(pathData,drawPathBack){
	var thisObj = this;
	this.getGraspPath(pathData,function(graspPath){
		thisObj.polyline.setPath(graspPath);
		thisObj.drawMarkerPointList(pathData);
		if(drawPathBack!=null && drawPathBack!=undefined){
			drawPathBack(graspPath);
		}
	});
}
//获得纠偏数据
AreaMap.prototype.getGraspPath = function(pathData,getGraspBack){
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
//判断是否在Map边界内
AreaMap.prototype.getInMap = function(position){
	var bounds = this.map.getBounds();
	return bounds.contains(position);
}
//获得两点间距离
AreaMap.prototype.getPositionDis = function(startPosition,endPosition){
	return AMap.GeometryUtil.distance(startPosition,endPosition);
}
//获得路径总距离
AreaMap.prototype.getPathDis = function(path){
	return AMap.GeometryUtil.distanceOfLine(path);
}
//获得当前zoom和比例尺下的像素距离
AreaMap.prototype.getZoomScaleDis = function(){
	var distance=$('.amap-scale-text').html();
	var scaleWidth=$('.amap-scale-middle').css('width')
	
	if(distance.search("公里") != -1){
		distance=distance.replace(" 公里","000");
	}else if(distance.search("米") != -1){
		distance=distance.replace(" 米","");
	}
	scaleWidth=scaleWidth.replace("px","");
	
	return Math.floor(Number(distance)/Number(scaleWidth));
}
//获取移动速度-在某个时间（秒）完成移动距离
AreaMap.prototype.getMoveSpeed = function(distance,moveTime){
	return Math.floor(distance/1000/moveTime*3600);
}
//获取路径点数量 30KM间隔
AreaMap.prototype.getMarkerPointCount = function(pathData,dis){
	var pathList=[];
	for(var i=0; i<pathData.length; i++){
		pathList.push([pathData[i].longitude,pathData[i].latitude]);
	}
	return Math.ceil(this.getPathDis(pathList)/dis);
}
//添加Marker
AreaMap.prototype.addMapMarker = function(marker,position){
	this.map.add(marker);
	marker.setPosition(position);
}
//添加Marker
AreaMap.prototype.removeMapMarker = function(marker){
	this.map.remove(marker);
}
//设置场景名称
AreaMap.prototype.setStageName = function(stageName){
	this.stageName = stageName;
}
//设置重绘
AreaMap.prototype.setReDrawMap = function(redrawFun){
	this.reDrawMap = redrawFun;
}
//地图移动时
AreaMap.prototype.moveEnd = function(){
	console.log("moveEnd")
	this.reDrawMap();
	this.bindEvent('zoomstart', this.zoomStart);
	this.bindEvent('zoomend', this.zoomEnd);
	this.bindEvent('dragstart', this.dragStart);
	this.bindEvent('dragend', this.dragEnd);
	this.bindEvent('resize', this.reSize);
}
//zoom变化时
AreaMap.prototype.zoomStart = function(){
	console.log("zoomStart")
	this.unbindEvent('moveend',this.moveEnd);
}
AreaMap.prototype.zoomEnd = function(){
	console.log("zoomEnd")
	this.bindEvent('moveend',this.moveEnd);
}
//地图拖拽时
AreaMap.prototype.dragStart = function(){
	console.log("dragStart")
	this.unbindEvent('moveend',this.moveEnd);
}
AreaMap.prototype.dragEnd = function(){
	console.log("dragEnd");
	this.bindEvent('moveend',this.moveEnd);
}
//地图容器尺寸变化时
AreaMap.prototype.reSize = function(){
	console.log("resize");
	this.reDrawMap();
}
AreaMap.prototype.bindEvent = function(eventName,eventFun){
	this.map.on(eventName,eventFun,this);
}
AreaMap.prototype.unbindEvent = function(eventName,eventFun){
	this.map.off(eventName,eventFun,this);
}
//标签运动
AreaMap.prototype.startAnimation = function(tarMarker, path, speed){
	tarMarker.moveAlong(path, speed);
	//运动轨迹
	tarMarker.on('moving',this.markerMove,this);
}
AreaMap.prototype.pauseAnimation = function(tarMarker){
	tarMarker.pauseMove();
}
AreaMap.prototype.resumeAnimation = function(tarMarker){
	tarMarker.resumeMove();
}
AreaMap.prototype.stopAnimation = function(tarMarker){
	tarMarker.stopMove();
}
//创建移动
AreaMap.prototype.markerMove = function(e){
	this.passedPolyline.setPath(e.passedPath);
};
AreaMap.prototype.drawMove = function(tarMarker,pathData){
	//画路经
	this.polyline.setPath(pathData);
	//5秒完成动画
	this.startAnimation(tarMarker,pathData,this.getMoveSpeed(this.getPathDis(pathData),5));
}
//清理基础地图
AreaMap.prototype.clearBaseMap = function(){
	//清除适应区域
	this.map.remove(this.setFitViewArea);
	//清除Marker
	this.map.remove(this.markerStart);
	this.map.remove(this.markerEnd);
	this.map.remove(this.markerCar);
	if(this.markerDemindList.length>0){
		for(var i = 0; i<this.markerDemindList.length; i++){
			this.markerDemindList[i].remove();
		}
	}
	if(this.markerCarList.length>0){
		for(var i = 0; i<this.markerCarList.length; i++){
			this.markerCarList[i].remove();
		}
	}
	if(this.markerPointList.length>0){
		for(var i = 0; i<this.markerPointList.length; i++){
			this.markerPointList[i].remove();
		}
	}
	//清除线路
	this.polyline.setPath([]);
	this.passedPolyline.setPath([]);
}
//清理地图
AreaMap.prototype.clearMap = function(){
	this.clearBaseMap();
}
//
AreaMap.prototype.setZoom = function(zoomFlg){
	this.map.setZoom(zoomFlg);
}
AreaMap.prototype.setCenter = function(lnglatFlg){
	this.map.setCenter(lnglatFlg);
}
//测试数据
AreaMap.prototype.createRandomPoint = function(vehicleList,randomCount,centerPosition,randomFlg){
    // for (var i=0; i<randomCount; i++) {
    // 	if(Math.random()>0.5){
    // 		vehicleList.push({
	// 			demindVehicleId:("test"+i),
    //         	longitude:(Math.floor(centerPosition[0]) + Math.random()*randomFlg),
    //         	latitude:(Math.floor(centerPosition[1]) + Math.random()*randomFlg)
    //         });
    // 	}else{
    // 		vehicleList.push({
	// 			demindVehicleId:("test"+i),
    //         	longitude:(Math.floor(centerPosition[0]) - Math.random()*randomFlg),
    //         	latitude:(Math.floor(centerPosition[1]) - Math.random()*randomFlg)
    //         });
    // 	}
    // }
}