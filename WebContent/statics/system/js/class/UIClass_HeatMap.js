function HeatMap(targetId){
    //绑定元素
	this.element = $(targetId);
	this.map = new AMap.Map(targetId, {
		mapStyle: 'amap://styles/grey',
	});
	
	this.iniHeatMap();
}
HeatMap.prototype.iniHeatMap = function(){
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
	// //地图加载后
	// AMapUI.loadUI(['control/BasicControl'], function(BasicControl) {
	// 	//缩放控件，显示Zoom值
	// 	thisObj.map.addControl(new BasicControl.Zoom({
	// 		position: 'rt',
	// 		showZoomNum: true
	// 	}));
	// });
	this.loca = Loca.create(this.map);
	this.loca.on('mapload', function () {
        thisObj.loca.getMap().plugin(['AMap.ControlBar'], function () {
            var controlBar = new AMap.ControlBar();
            thisObj.loca.getMap().addControl(controlBar);
        });
	});
	this.layer = Loca.visualLayer({
        container: this.loca,
        fitView: true,
        type: 'point',
		shape: 'circle',
		eventSupport: true,
    });
}
HeatMap.prototype.setHeatMap = function(heatData,tarKey,option){
	this.layer.setData(heatData, {
        lnglat: 'lnglat'
    });

	option = {
        style: {
            radius: {
                key: tarKey, // 映射字段
                scale: 'linear', // 比例尺
                value: [10, 50], // 输出范围
            },
            color: '#ffc000',
            opacity: 0.4,
            borderWidth: 2,
            borderColor: '#f5a930',
        }
	}
    this.layer.setOptions(option);
	this.layer.render();
	this.layer.setFitView();
	//this.map.setZoom(this.map.getZoom()-1);
	//
}
HeatMap.prototype.clearMap = function(){
	// if(this.layer!=null && this.layer!= undefined){
	// 	this.layer.remove();
	// 	this.layer.destroy();
	// }
}
HeatMap.prototype.bindEvent = function(eventName,eventFun){
	this.layer.on(eventName,eventFun,this);
}
HeatMap.prototype.unbindEvent = function(eventName,eventFun){
	this.layer.off(eventName,eventFun,this);
}