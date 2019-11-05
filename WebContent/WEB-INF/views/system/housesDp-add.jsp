<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
		<form class="layui-form">
			<div class="layui-form-item">
				<label class="layui-form-label">地址</label>
				<div class="layui-input-inline">
					<select id="province" name="province" lay-filter="province" lay-verify="required" lay-search="">
						<option value="">请选择省</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<select id="city" lay-filter="city" lay-verify="required" lay-search="">
						<option value="">请选择市</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<select id="area" lay-filter="area" lay-verify="required" lay-search="">
						<option value="">请选择县/区</option>
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
				<label for="remark" class="layui-form-label">
				<span>小区/街道</span>
				</label>
				<div class="layui-input-inline">
					<select id="communityStreetSel" name="communityStreetSel" lay-verify="required" lay-filter="communityStreetSel" lay-search="">
						
			        </select>
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
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
			<div class="layui-form-item">
				<label  class="layui-form-label">
					<span>门牌号</span>
				</label>
				<div class="layui-input-inline">
					<input type="text" id="houseNumber" name="houseNumber" lay-verify="required" required="" autocomplete="off" class="layui-input">
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
					<input type="text" id="housesAddress" name="housesAddress" lay-verify="required" required="" autocomplete="off" class="layui-input">
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
					<input type="text" id="houseType" name="houseType" lay-verify="required" required="" autocomplete="off" class="layui-input">
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
					<input type="text" id="propertyCertificatesNumber" name="propertyCertificatesNumber" lay-verify="required" required="" autocomplete="off" class="layui-input">
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
					<input type="text" id="propertyOwnerName" name="propertyOwnerName" lay-verify="required" required="" autocomplete="off" class="layui-input">
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
					<input type="text" id="propertyOwnerTel" name="propertyOwnerTel" lay-verify="required" required="" autocomplete="off" class="layui-input">
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
					<input type="text" id="propertyOwnerIdcard" name="propertyOwnerIdcard" lay-verify="required" required="" autocomplete="off" class="layui-input">
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
					    	<img class="layui-upload-img" id="propertyCertificatesPhoto" src="">
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
					    	<img width="400" class="layui-upload-img" id="houseTypePhoto">
					    	
					  	</div>
					</div>  
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn" lay-filter="add" lay-submit="">
					增加</button>
			</div>
		</form>
	</div>
<script src="/jianfuzengxiao/statics/system/lib/layui/layui.js" charset="utf-8"></script>
<script src="/jianfuzengxiao/statics/system/js/xadmin.js" charset="utf-8"></script>
<script>
	var form, layer, upload;
	
	var provCode = '';
	var provName = '';
	var cityCode = '';
	var cityName = '';
	var areaCode = '';
	var areaName = '';
	var communityId = '';
	var communityName = '';
	var communityStreetId = '';
	var communityStreetName = '';
	var storeLocation = '';
	var housesTypeId = '';
	var housesTypeName = '';
	var propertyCertificatesPhoto = '';
	var houseTypePhoto = '';
    layui.use(['form','layer','upload'], function(){
    	var $ = layui.jquery
        form = layui.form
        layer = layui.layer
        upload = layui.upload;

	    //监听提交
		form.on('submit(add)', function(data){
			if(propertyCertificatesPhoto == ''){
				layer.msg('请上传房产证照片', {icon: 7});
			}
			if(houseTypePhoto == ''){
				layer.msg('请上传户型图照片', {icon: 7});
			}
		    $.ajax({  
				url : "/jianfuzengxiao/system/houses/addHouses.html",  
				type : 'post',
				dataType: "json",
				data: {
					'housesStatus': '2',
					'provCode': provCode,
					'provName': provName,
					'cityCode': cityCode,
					'cityName': cityName,
					'areaCode': areaCode,
					'areaName': areaName,
					'communityId': communityId,
					'communityName': communityName,
					'communityStreetId': communityStreetId,
					'communityStreetName': communityStreetName,
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
						layer.msg("添加成功", {icon: 1},function () {
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
					layer.msg("添加出错，请重新操作", {icon: 2})
				}
			}); 
	      	return false;
	    });
    	
    	/* 社区加载 */
    	serchCommunity();
    	
    	/* 加载小区街道 */
    	serchCommunityStreet();
    	
    	/* 房屋类型加载 */
    	serchHousesType();
    	
    	/* 省市区加载 */
    	var provinceList = "";
        var cityList = "";
        var areaList = "";
         
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
				}else{
					layer.msg("加载数据出错，请刷新页面", {icon: 2});
				}
				
			},
			error : function(result){
				layer.msg("加载数据出错，请刷新页面", {icon: 2})
			}
		});
        
      	//监听省下拉框
        form.on('select(province)', function(data){
        	provName = data.elem[data.elem.selectedIndex].text;
        	provCode = data.value;
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
	      	
            serchCommunity();
        });
      	
     	//监听市下拉框
        form.on('select(city)', function(data){
        	cityName = data.elem[data.elem.selectedIndex].text;
        	cityCode = data.value;
        	
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
	      	
            serchCommunity();
        });
     	//监听区/县
        form.on('select(area)', function(data){
        	areaName = data.elem[data.elem.selectedIndex].text;
        	areaCode = data.value;
        	
        	serchCommunity();
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

    });
    
    /* 社区加载 */
    function serchCommunity(){
    	$.ajax({  
			url : "/jianfuzengxiao/system/community/getCommunityList.html",  
			type : 'post',
			dataType: "json",
			data: {
				'provCode': provCode,
				'cityCode': cityCode,
				'areaCode': areaCode
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
				'communityId': communityId,
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
				}
			},
			error : function(result){
				layer.msg("数据加载出错，请刷新页面", {icon: 2})
			}
		})
    }
</script>
</body>

</html>