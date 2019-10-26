var searchArea,searchKey,factoryLng,factoryLat;
$(function(){
	mapCompany_IT = new InputText("#mapCompany_IT",InputText.TypeNormal,InputText.DisTypeMiddle,30);
	mapAddress_IT = new InputText("#mapAddress_IT",InputText.TypeNormal,InputText.DisTypeMiddle,30);

	//选择企业地址
	$('#chooseAddressBtn').click(function(){
		if(companyName_IT.getText() == ''){
			alert('请输入企业名称！')
			return
		}
		if(localProvince_AB.getProvinceValue() == ''){
			alert('请选择所在地省份！')
			return
		}
		if(localProvince_AB.getCityValue() == ''){
			alert('请选择所在地城市！')
			return
		}
		if(localProvince_AB.getCountyValue() == ''){
			alert('请选择所在地县镇！')
			return
		}
		searchArea=localProvince_AB.getProvinceText() + localProvince_AB.getCityText() + localProvince_AB.getCountyText()
		searchKey=companyName_IT.getText()
		mapCompany_IT.setText(companyName_IT.getText())
		mapSearchFunctions()
		$('#windowPanel').show()
	})
	
	
	
	//点击搜索按钮
	$('#mapSearch').click(function(){
		mapSearchFunctions()
	})
 	//点击确认按钮
 	$('#mapConfirm').click(function(){
 		mapLng = factoryLng;
 		mapLat = factoryLat;
 		companyName_IT.setText(mapCompany_IT.getText())
 		localAddress_IT.setText(mapAddress_IT.getText())
 		$('#windowPanel').hide()
 	})
	//关闭按钮
 	$('#closeBtn').click(function(){
 		$('#windowPanel').hide()
 	})
	
	
	
	
	
	
	

})

function mapSearchFunctions(){
	var searchaddr=searchArea +mapCompany_IT.getText();
	console.log(searchaddr)
	var map = new AMap.Map("container", {
        resizeEnable: true
    });
    map.plugin(["AMap.ToolBar"], function() {
		map.addControl(new AMap.ToolBar());
	});
	if(location.href.indexOf('&guide=1')!==-1){
		map.setStatus({scrollWheel:false})
	}
 	AMap.service(["AMap.PlaceSearch"], function() {
        var placeSearch = new AMap.PlaceSearch({ //构造地点查询类
            pageSize: 1000,
            // pageIndex: 1,
            citylimit: true,
            map: map,
            panel: "panel",
            autoFitView: true 
        });
        //关键字查询
        placeSearch.search(searchaddr, function(status, result){
        	$('#panel .poibox').click(function(){
        		var i=$(this).index();
        		mapAddress_IT.setText(result.poiList.pois[i].address)
		        mapCompany_IT.setText(result.poiList.pois[i].name)
		        factoryLng=result.poiList.pois[i].location.lng
		        factoryLat=result.poiList.pois[i].location.lat
		    	
        	})
        });
        AMap.event.addListener(placeSearch, "markerClick", function(mapPoint){
        	mapAddress_IT.setText(mapPoint.data.address)
	        mapCompany_IT.setText(mapPoint.data.name)
	        factoryLng=mapPoint.data.location.lng
		    factoryLat=mapPoint.data.location.lat
	    })
    });
}
