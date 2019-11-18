<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>admin</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="/jianfuzengxiao/statics/system/css/xadmin.css" media="all">
<link type="text/css" rel="stylesheet" href="/jianfuzengxiao/statics/system/simditor/styles/simditor.css" />
<script type="text/javascript" src="/jianfuzengxiao/statics/system/simditor/scripts/jquery.min.js"></script>
<script type="text/javascript" src="/jianfuzengxiao/statics/system/simditor/scripts/module.js"></script>
<script type="text/javascript" src="/jianfuzengxiao/statics/system/simditor/scripts/hotkeys.js"></script>
<script type="text/javascript" src="/jianfuzengxiao/statics/system/simditor/scripts/uploader.js"></script>
<script type="text/javascript" src="/jianfuzengxiao/statics/system/simditor/scripts/simditor.js"></script>
</head>

<body>
	
	<div class="x-body">
		<form class="layui-form" lay-filter="example">
			<div class="layui-form-item">
				<label class="layui-form-label">地址</label>
				<div class="layui-input-inline">
					<select id="province" name="province" lay-filter="province" lay-verify="required" lay-search="">
						<option value="">请选择省</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<select id="city" name="city" lay-filter="city" lay-verify="required" lay-search="">
						<option value="">请选择市</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<select id="area" name="area" lay-filter="area" lay-verify="required" lay-search="">
						<option value="">请选择县/区</option>
					</select>
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">管委会</label>
				<div class="layui-input-inline">
					<select id="gwh" name="gwh" lay-filter="gwh" lay-verify="required" lay-search="">
						<option value="">请选择</option>
					</select>
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="remark" class="layui-form-label">
				<span>社区</span>
				</label>
				<div class="layui-input-inline">
					<select id="communitySel" name="communitySel" lay-verify="required" lay-filter="communitySel" lay-search="">
						
			        </select>
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
				<span>小区/道路</span>
				</label>
				<div class="layui-input-inline">
					<select id="communityStreetSel" name="communityStreetSel" lay-verify="required" lay-filter="communityStreetSel" lay-search="">
						
			        </select>
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<c:if test="${houses.communityStreetStatus == 1 }">
			<div class="layui-form-item" id="storeLocationSel2">
				<label class="layui-form-label">
					<span>内/外铺</span>
				</label>
				<div class="layui-input-inline">
					<select id="storeLocationSel" name="storeLocationSel" lay-filter="storeLocationSel" lay-search="">
						<option value="">请选择</option>
						<option value="1">内铺</option>
						<option value="2">外铺</option>
			        </select>
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red"></span>
				</div>
			</div>
			</c:if>
			<c:if test="${houses.communityStreetStatus == 2 }">
			<div class="layui-form-item" id="storeLocationSel2" style="display:none;">
				<label class="layui-form-label">
					<span>内/外铺</span>
				</label>
				<div class="layui-input-inline">
					<select id="storeLocationSel" name="storeLocationSel" lay-filter="storeLocationSel" lay-search="">
						<option value="">请选择</option>
						<option value="1">内铺</option>
						<option value="2">外铺</option>
			        </select>
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red"></span>
				</div>
			</div>
			</c:if>
			<div class="layui-form-item">
				<label for="remark" class="layui-form-label">
				<span>门牌号</span>
				</label>
				<div class="layui-input-inline">
					<input type="text" id="houseNumber" name="houseNumber" value="${houses.houseNumber }" lay-verify="required" required="" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="remark" class="layui-form-label">
				<span>详细地址</span>
				</label>
				<div class="layui-input-inline">
					<input type="text" id="housesAddress" name="housesAddress" value="${houses.housesAddress }" lay-verify="required" required="" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="remark" class="layui-form-label">
				<span>房屋户型</span>
				</label>
				<div class="layui-input-inline"> 
					<input type="text" id="houseType" name="houseType" value="${houses.houseType }" lay-verify="required" required="" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
				<span>房屋类型</span>
				</label>
				<div class="layui-input-inline">
					<select id="housesTypeSel" name="housesTypeSel" lay-verify="required" lay-filter="housesTypeSel" lay-search="">
						
			        </select>
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
					<span>产权证号</span>
				</label>
				<div class="layui-input-inline">
					<input type="text" id="propertyCertificatesNumber" name="propertyCertificatesNumber" value="${houses.propertyCertificatesNumber }" lay-verify="required" required="" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
					<span>产权人姓名</span>
				</label>
				<div class="layui-input-inline">
					<input type="text" id="propertyOwnerName" name="propertyOwnerName" value="${houses.propertyOwnerName }" lay-verify="required" required="" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
					<span>产权人联系电话</span>
				</label>
				<div class="layui-input-inline">
					<input type="text" id="propertyOwnerTel" name="propertyOwnerTel" value="${houses.propertyOwnerTel }" lay-verify="required" required="" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
					<span>产权人身份证号</span>
				</label>
				<div class="layui-input-inline">
					<input type="text" id="propertyOwnerIdcard" name="propertyOwnerIdcard" value="${houses.propertyOwnerIdcard }" lay-verify="required" required="" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			
			<div class="layui-form-item">
				<label class="layui-form-label">
					<span>房产证照片</span>
				</label>
				<div class="layui-input-inline">
					<div class="layui-upload">
						<button type="button" class="layui-btn" id="uploadPropertyCertificatesPhoto">上传图片</button>
					  	<div class="layui-upload-list">
					    	<img class="layui-upload-img" id="propertyCertificatesPhoto" src="${houses.propertyCertificatesPhoto }">
					  	</div>
					</div>  
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
					<span>房产户型图</span>
				</label>
				<div class="layui-input-inline">
					<div class="layui-upload">
						<button type="button" class="layui-btn" id="uploadHouseTypePhoto">上传图片</button>
					  	<div class="layui-upload-list">
					    	<img width="400" class="layui-upload-img" id="houseTypePhoto" src="${houses.houseTypePhoto }">
					    	
					  	</div>
					</div>  
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn" lay-filter="update" lay-submit="">更新</button>
			</div>
		</form>
	</div>
<script src="/jianfuzengxiao/statics/system/lib/layui/layui.js" charset="utf-8"></script>
<script src="/jianfuzengxiao/statics/system/js/xadmin.js" charset="utf-8"></script>
<script>

var form, layer, upload;

var housesId = '${houses.housesId }';
var provCode = '${houses.provCode }';
var provName = '${houses.provName }';
var cityCode = '${houses.cityCode }';
var cityName = '${houses.cityName }';
var areaCode = '${houses.areaCode }';
var areaName = '${houses.areaName }';
var communityId = '${houses.communityId }';
var communityName = '${houses.communityName }';
var communityStreetId = '${houses.communityStreetId }';
var communityStreetName = '${houses.communityStreetName }';
var housesTypeId = '${houses.housesTypeId }';
var housesTypeName = '${houses.housesTypeName }';
var propertyCertificatesPhoto = '${houses.propertyCertificatesPhoto }';
var houseTypePhoto = '${houses.houseTypePhoto }';
var storeLocation = '${houses.storeLocation }';
var gwhId = '${houses.gwhId}'
var gwhName = '${houses.gwhName}'
var provinceList = "";
var cityList = "";
var areaList = "";
var communityStreetStatus = '';
var communityStreetList = '';
layui.use(['form','layer', 'upload'], function(){
	var $ = layui.jquery;
    form = layui.form;
    layer = layui.layer;
    upload = layui.upload;
    
    /* 省市区加载 */
    serchArea();
    
    /* 社区加载 */
	serchCommunity();
	
	/* 加载小区街道 */
	serchCommunityStreet();
	
	/* 房屋类型加载 */
	serchHousesType();
	
	getGwhList();
    
	form.val('example', {
	    "storeLocationSel": storeLocation
	});
    
	//监听省下拉框
    form.on('select(province)', function(data){
    	provName = data.elem[data.elem.selectedIndex].text;
    	provCode = data.value;
    	cityCode = '';
    	areaCode = '';
    	gwhId = '';
    	communityId ='';
    	$.each(provinceList, function (index, item) {
			if(item.code == data.value){
				cityList = item.childList;
			}
        });
        //移除城市下拉框所有选项
        $("#city").empty();
        var cityHtml = '<option value="">请选择市</option>';
        $("#city").html(cityHtml);
        var areaHtml = '<option value="">请选择县/区</option>';
        $("#area").html(areaHtml);
        var str = '';
        $.each(cityList, function (index, item) {
           	str += "<option value='" + item.code + "'>" + item.name + "</option>";
        });
        $("#city").append(str);
      	//append后必须从新渲染
        form.render('select');
      	
        getGwhList()
        serchCommunity();
        serchCommunityStreet();
    });
  	
 	//监听市下拉框
    form.on('select(city)', function(data){
    	cityName = data.elem[data.elem.selectedIndex].text;
    	cityCode = data.value;
    	areaCode = '';
    	gwhId = '';
    	communityId ='';
    	$.each(cityList, function (index, item) {
			if(item.code == data.value){
				areaList = item.childList;
			}
        });
        //移除城区下拉框所有选项
        $("#area").empty();
        var areaHtml = '<option value="">请选择县/区</option>';
        $("#area").html(areaHtml);
        var str = '';
        $.each(areaList, function (index, item) {
           	str += "<option value='" + item.code + "'>" + item.name + "</option>";
        });
        $("#area").append(str);
      	//append后必须从新渲染
        form.render('select');
      	
        getGwhList()
        serchCommunity();
        serchCommunityStreet();
    });
 	//监听区/县
    form.on('select(area)', function(data){
    	areaName = data.elem[data.elem.selectedIndex].text;
    	areaCode = data.value;
   
    	gwhId = '';
    	communityId ='';
    	getGwhList()
        serchCommunity();
        serchCommunityStreet();
    });
  	//监听管委会
    form.on('select(gwh)', function(data){
    	gwhName = data.elem[data.elem.selectedIndex].text;
    	gwhId = data.value;
    	
    	communityId ='';
        serchCommunity();
        serchCommunityStreet();
    });
  	//监听社区
    form.on('select(communitySel)', function(data){
    	communityName = data.elem[data.elem.selectedIndex].text;
    	communityId = data.value;
    	
        serchCommunityStreet();
    });
  
  	//监听社区
    form.on('select(communityStreetSel)', function(data){
    	communityStreetName = data.elem[data.elem.selectedIndex].text;
    	communityStreetId = data.value;
    	$.each(communityStreetList, function (index, item) {
       		if(item.communityStreetId == communityStreetId){
       			communityStreetStatus = item.status;
       			if(item.status == 2){
       				$('#storeLocationSel2').hide();
       			}else{
       				$('#storeLocationSel2').show();
       			}
       		}
        });
    });
  	
  	//监听房屋类型
    form.on('select(housesTypeSel)', function(data){
    	housesTypeName = data.elem[data.elem.selectedIndex].text;
    	housesTypeId = data.value;
    	
    });
  	
  	//监听内外铺
    form.on('select(storeLocationSel)', function(data){
    	storeLocation = data.value;
    }); 
  	
    /*上传房产证*/
    upload.render({
    	elem: '#uploadPropertyCertificatesPhoto'
        ,url: '/jianfuzengxiao/system/common/uploadFile.html' //上传接口
        ,data: {'picType': 'D'}
        ,done: function(res){ //上传成功后的回调
        	if(res.code){
        		$('#propertyCertificatesPhoto').attr('src', res.data.absolutePath);
            	propertyCertificatesPhoto = res.data.absolutePath;
        	}else{
        		layer.msg('上传失败，请重新操作', {icon: 2})
        	}
        }
        ,error: function(){
        	layer.msg('上传失败，请重新操作', {icon: 2});
        }
    });
    
    /*上传户型图*/
    upload.render({
    	elem: '#uploadHouseTypePhoto'
        ,url: '/jianfuzengxiao/system/common/uploadFile.html' //上传接口
        ,data: {'picType': 'E'}
        ,done: function(res){ //上传成功后的回调
        	if(res.code){
        		$('#houseTypePhoto').attr('src', res.data.absolutePath);
        		houseTypePhoto = res.data.absolutePath;
        	}else{
        		layer.msg('上传失败，请重新操作', {icon: 2})
        	}
        }
        ,error: function(){
        	layer.msg('上传失败，请重新操作', {icon: 2});
        }
    });
   	
  	//监听提交
	form.on('submit(update)', function(data){
	    $.ajax({  
			url : "/jianfuzengxiao/system/houses/updateHouses.html",  
			type : 'post',
			dataType: "json",
			data: {
				'housesId': housesId,
				'provCode': $("#province option:selected").val(),
				'cityCode': $("#city option:selected").val(),
				'areaCode': $("#area option:selected").val(),
				'provName': $("#province option:selected").text(),
				'cityName': $("#city option:selected").text(),
				'areaName': $("#area option:selected").text(),
				'gwhId': $('#gwh option:selected').val(),
				'gwhName': $('#gwh option:selected').text(),
				'communityId': $('#communitySel option:selected').val(),
				'communityName': $('#communitySel option:selected').text(),
				'communityStreetId': $('#communityStreetSel option:selected').val(),
				'communityStreetName': $('#communityStreetSel option:selected').text(),
				'housesTypeId': housesTypeId,
				'housesTypeName': housesTypeName,
				'propertyCertificatesPhoto': propertyCertificatesPhoto,
				'houseTypePhoto': houseTypePhoto,
				'storeLocation': storeLocation,
				'houseNumber': $('#houseNumber').val(),
				'housesAddress': $('#housesAddress').val(),
				'houseType': $('#houseType').val(),
				'propertyOwnerName': $('#propertyOwnerName').val(),
				'propertyOwnerTel': $('#propertyOwnerTel').val(),
				'propertyOwnerIdcard': $('#propertyOwnerIdcard').val(),
				'propertyCertificatesNumber': $('#propertyCertificatesNumber').val()
			},
			success : function(result){
				if(result.code == 1){
					layer.msg("更新成功", {icon: 1},function () {
			            // 获得frame索引
			            var index = parent.layer.getFrameIndex(window.name);
			            //关闭当前frame
			            parent.layer.close(index);
			            window.parent.location.reload();
			        });
				}else{
					layer.msg(result.msg, {icon: 7});
				}
			},
			error : function(result){
				layer.msg("更新出错，请重新操作", {icon: 2})
			}
		}); 
	   	return false;
	});
  
});

function serchArea(){
	$.ajax({  
		url : "/jianfuzengxiao/common/getAreaList.html",  
		type : 'post',
		dataType: "json",
		data: {
		},
		success : function(result){
			if(result.code == 1){
				var str = '';
				$.each(result.data, function (index, item) {
					str += "<option value='" + item.code + "'>" + item.name + "</option>";
		        });
		        $("#province").append(str);
		        //append后必须从新渲染
		        form.render('select')
		        provinceList = result.data;
		        
		        form.val('example', {
		    	    "province": provCode
		    	});
		        
				/* 市列表 */
		    	$.each(provinceList, function (index, item) {
					if(item.code == provCode){
						cityList = item.childList;
					}
		        });
		        //移除城市下拉框所有选项
		        $("#city").empty();
		        var cityHtml = '<option value="">请选择市</option>';
		        $("#city").html(cityHtml);
		        var areaHtml = '<option value="">请选择县/区</option>';
		        $("#area").html(areaHtml);
		        var str = '';
		        $.each(cityList, function (index, item) {
		           	str += "<option value='" + item.code + "'>" + item.name + "</option>";
		        });
		        $("#city").append(str);
		      	//append后必须从新渲染
		        form.render('select');
		      	
		    	form.val('example', {
				    "city": cityCode
				});
		    	
		    	/* 区列表 */
		    	$.each(cityList, function (index, item) {
					if(item.code == cityCode){
						areaList = item.childList;
					}
		        });
		        //移除城区下拉框所有选项
		        $("#area").empty();
		        var areaHtml = '<option value="">请选择县/区</option>';
		        $("#area").html(areaHtml);
		        var str = '';
		        $.each(areaList, function (index, item) {
		           	str += "<option value='" + item.code + "'>" + item.name + "</option>";
		        });
		        $("#area").append(str);
		      	//append后必须从新渲染
		        form.render('select');
      	
				form.val('example', {
				    "area": areaCode
				});
			}else{
				layer.msg("数据加载出错，请刷新页面", {icon: 2});
			}
			
		},
		error : function(result){
			layer.msg("数据加载出错，请刷新页面", {icon: 2})
		}
	});
}

/* 社区加载 */
function serchCommunity(){
	$.ajax({  
		url : "/jianfuzengxiao/system/community/getCommunityList.html",  
		type : 'post',
		dataType: "json",
		data: {
			'provCode': provCode,
			'cityCode': cityCode,
			'areaCode': areaCode,
			'gwhId': gwhId
		},
		success : function(result){
			if(result.code == 1){
				$('#communitySel').html('');
				var str = '<option value="">请选择</option>';
				for(var i=0;i<result.data.length;i++){
					str += '<option value="'+result.data[i].communityId+'">'+result.data[i].communityName+'</option>'
				}
				$('#communitySel').append(str);
				form.render('select');
				
				form.val('example', {
				    "communitySel": communityId
				});
			}
		},
		error : function(result){
			layer.msg("数据加载出错，请刷新页面", {icon: 2})
		}
	})
}
/* 小区或街道加载 */
function serchCommunityStreet(){
	$.ajax({  
		url : "/jianfuzengxiao/system/communityStreet/getCommunityStreetList.html",  
		type : 'post',
		dataType: "json",
		data: {
			'provCode': provCode,
			'cityCode': cityCode,
			'areaCode': areaCode,
			'gwhId': gwhId,
			'communityId': communityId
		},
		success : function(result){
			if(result.code == 1){
				$('#communityStreetSel').html('');
				var str = '<option value="">请选择</option>';
				for(var i=0;i<result.data.length;i++){
					str += '<option value="'+result.data[i].communityStreetId+'">'+result.data[i].communityStreetName+'</option>'
				}
				$('#communityStreetSel').append(str);
				form.render('select');
				communityStreetList = result.data;
				form.val('example', {
				    "communityStreetSel": communityStreetId
				});
			}
		},
		error : function(result){
			layer.msg("数据加载出错，请刷新页面", {icon: 2})
		}
	})
}

/* 房屋类型 */
function serchHousesType(){
	$.ajax({  
		url : "/jianfuzengxiao/system/common/getHousesTypeList.html",  
		type : 'post',
		dataType: "json",
		data: {
		},
		success : function(result){
			if(result.code == 1){
				$('#housesTypeSel').html('');
				var str = '<option value="">请选择</option>';
				for(var i=0;i<result.data.length;i++){
					str += '<option value="'+result.data[i].housesTypeId+'">'+result.data[i].housesTypeName+'</option>'
				}
				$('#housesTypeSel').append(str);
				form.render('select');
				
				form.val('example', {
				    "housesTypeSel": housesTypeId
				});
			}
		},
		error : function(result){
			layer.msg("数据加载出错，请刷新页面", {icon: 2})
		}
	})
}

function getGwhList(){
	var data = {
			'provCode': provCode,
			'cityCode': cityCode,
			'areaCode': areaCode
			}
	$.ajax({  
		url : "/jianfuzengxiao/system/gwh/getGwhList.html",  
		type : 'post',
		dataType: "json",
		data: data,
		success : function(result){
			//console.log(result)
			if(result.code == 1){
				$("#gwh").html('')
				var str = '<option value="">请选择</option>';
				$.each(result.data, function (index, item) {
					if(item.gwhId == gwhId){
						str += "<option value='" + item.gwhId + "' selected>" + item.gwhName + "</option>";
					}else{
						str += "<option value='" + item.gwhId + "'>" + item.gwhName + "</option>";
					}
		        });
		        $("#gwh").append(str);
		        //append后必须从新渲染
		        form.render('select')
		       
			}else{
				layer.msg(result.msg, {icon: 7});
			}
			
		},
		error : function(result){
			layer.msg("加载数据出错，请刷新页面", {icon : 2})
		}
	});
}
</script>
</body>

</html>