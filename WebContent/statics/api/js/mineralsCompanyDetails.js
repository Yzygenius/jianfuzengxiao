var urlpagetype=GetQueryString('id');
var mapPosition=[];
$.ajax({
	url: '/jikuang/goods/getGoodsInfoList.html',
	type: 'POST',
	dataType: 'json',
	data: {'goodsId':urlpagetype},
	success: function(data){
		var rows = data.data[0];
		$('#infoImage img').attr('src','/jikuang/'+rows.companyThumb)
		$('.companyName').html(rows.companyName)
		$('#companyContactName').html(rows.contactName)
		//$('#companyContactPhone').html(rows.contactTel)
		$('#companyContactPhone').html('')
		$('#location').html(rows.provName + rows.cityName + rows.areaName)
		mapPosition = [rows.longitude,rows.latitude];
		//$('#registeredCapital span').html(rows.regCapital);
		//$('#companyType span').html();
		$('#mineLicense span').html(rows.isMineLicense)
		$('#mineLicenseValidTime span').html(rows.mineLicenseValidStartTime+' 至 '+rows.mineLicenseValidStopTime)
		$('#sewageLicense span').html(rows.isSewageLicense)
		$('#sewageLicenseValidTime span').html(rows.sewageLicenseValidStartTime+' 至 '+rows.sewageLicenseValidStopTime)
		$('#productionLicense span').html(rows.isProductionLicense)
		$('#productionLicenseValidTime span').html(rows.productionLicenseValidStartTime+' 至 '+rows.productionLicenseValidStopTime)
		$('#mainType').html(rows.minesTypeName)
		$('#companyImage img').attr('src','/jikuang/'+rows.companyThumb)
		companyMap()
		$('#messageText').html(rows.companySynopsis)
		$('.productTitle').html(rows.productName)
		$('.productPrice').html(rows.price)
		$('.localState').html(rows.provName + rows.cityName + rows.areaName)
		$('.contactName').html(rows.contactName)
		$('.contactPhone').html(rows.contactTel)
		$('.keepWeight').html(rows.reserves)
		$('.yearWeight').html(rows.productionYear)
		
		$('.swiper-container img').eq(0).attr('src','/jikuang/'+rows.imgThumb)
		$('.swiper-container img').eq(1).attr('src','/jikuang/'+rows.imgThumb2)
		$('.swiper-container img').eq(2).attr('src','/jikuang/'+rows.imgThumb3)
		$('.swiper-container img').eq(3).attr('src','/jikuang/'+rows.imgThumb4)
		
	}
	
	
	
	
	
	
	
	
})



















function menuTriangle(){
	$('#menuTitleNav ul li').eq(1).addClass('active');
}
function companyMap(){
	var map = new AMap.Map('companyLocationMap', {
		zoom:11,//级别
		center: mapPosition,//中心点坐标
		viewMode:'3D'//使用3D视图
	}); 
	var marker = new AMap.Marker({
		 position: mapPosition
	})
	map.add(marker);
}


var mySwiper = new Swiper('.swiper-container',{
	navigation: {
      nextEl: '.productRight',
      prevEl: '.productLeft',
    }
})
$(document).ready(function(){
	var sliderImageHeight = $('.swiper-container .swiper-slide').width()/1.2;
	$('.swiper-container .swiper-slide img').css('height',sliderImageHeight)
})