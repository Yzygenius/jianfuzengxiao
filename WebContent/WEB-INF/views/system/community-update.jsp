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
	<input id="id" type="hidden" value="${community.communityId }">
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
				<label class="layui-form-label">社区</label>
				<div class="layui-input-inline">
					<input type="text" id=communityName name="communityName" value="${community.communityName }" required="" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label"> 
					<span>排序</span>
				</label>
				<div class="layui-input-inline">
					<input type="text" id="listOrder" name="listOrder" value="${community.listOrder }" required="" autocomplete="off" class="layui-input">
					<span class="x-red">展示顺序，填写1-9999，数值越小展示顺序越靠前</span>
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			
			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn" lay-filter="update" lay-submit="">
					更新</button>
			</div>
		</form>
	</div>
<script src="/jianfuzengxiao/statics/system/lib/layui/layui.js" charset="utf-8"></script>
<script src="/jianfuzengxiao/statics/system/js/xadmin.js" charset="utf-8"></script>
<script>


layui.use(['form','layer'], function(){
	var $ = layui.jquery
    ,form = layui.form
    ,layer = layui.layer
    
    
    var provinceList = "";
    var cityList = "";
    var areaList = "";
    
    var provName = '${community.provName }';
    var cityName = '${community.cityName }';
    var areaName = '${community.areaName }';
    var provCode = ${community.provCode };
    var cityCode = ${community.cityCode };
    var areaCode = ${community.areaCode };
     
    $.ajax({  
		url : "/jianfuzengxiao/common/getAreaList.html",  
		type : 'post',
		dataType: "json",
		data: {
		},
		success : function(result){
			console.log(result)
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
		    	//console.log(cityList)
		        //移除城市下拉框所有选项
		        $("#city").empty();
		        var cityHtml = '<option value="">请选择市</option>';
		        $("#city").html(cityHtml);
		        var areaHtml = '<option value="">请选择县/区</option>';
		        $("#area").html(areaHtml);
		        //provinceText = $("#province").find("option:selected").text();
		        //var value = $("#province").val();
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
		    	//console.log(dataObj)
		    	//console.log(cityList)
		        //移除城区下拉框所有选项
		        $("#area").empty();
		        var areaHtml = '<option value="">请选择县/区</option>';
		        $("#area").html(areaHtml);
		        //provinceText = $("#province").find("option:selected").text();
		        //var value = $("#province").val();
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
				layer.alert(result.msg, {icon: 5});
			}
			
		},
		error : function(result){
			layer.alert("添加出错，请重新添加")
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
    	//console.log(cityList)
        //移除城市下拉框所有选项
        $("#city").empty();
        var cityHtml = '<option value="">请选择市</option>';
        $("#city").html(cityHtml);
        var areaHtml = '<option value="">请选择县/区</option>';
        $("#area").html(areaHtml);
        //provinceText = $("#province").find("option:selected").text();
        //var value = $("#province").val();
        var str = '';
        $.each(cityList, function (index, item) {
           	str += "<option value='" + item.code + "'>" + item.name + "</option>";
        });
        $("#city").append(str);
      	//append后必须从新渲染
        form.render('select');
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
    	//console.log(dataObj)
    	//console.log(cityList)
        //移除城区下拉框所有选项
        $("#area").empty();
        var areaHtml = '<option value="">请选择县/区</option>';
        $("#area").html(areaHtml);
        //provinceText = $("#province").find("option:selected").text();
        //var value = $("#province").val();
        var str = '';
        $.each(areaList, function (index, item) {
           	str += "<option value='" + item.code + "'>" + item.name + "</option>";
        });
        $("#area").append(str);
      	//append后必须从新渲染
        form.render('select');
    });
 	//监听区/
    form.on('select(area)', function(data){
    	areaName = data.elem[data.elem.selectedIndex].text;
    	areaCode = data.value;
    });
 	
    
	/* form.val('example', {
	    "city": cityCode
	})
	form.val('example', {
	    "area": areaCode
	}) */
  //监听提交
  form.on('submit(update)', function(data){
      $.ajax({  
		url : "/jianfuzengxiao/system/community/updateCommunity.html",  
		type : 'post',
		dataType: "json",
		data: {
			'communityId': $('#id').val(),
			'communityName': $('#communityName').val(),
			'listOrder': $('#listOrder').val(),
			'provCode': provCode,
			'provName': provName,
			'cityCode': cityCode,
			'cityName': cityName,
			'areaCode': areaCode,
			'areaName': areaName
		},
		success : function(result){
			if(result.code == 1){
				layer.alert("更新成功", {icon: 6},function () {
		            // 获得frame索引
		            var index = parent.layer.getFrameIndex(window.name);
		            //关闭当前frame
		            parent.layer.close(index);
		            window.parent.location.reload();
		        });
			}else{
				layer.alert(result.msg, {icon: 5});
			}
		},
		error : function(result){
			layer.alert("更新出错，请重新操作")
		}
	}); 
    return false;
  });
  
});
</script>
</body>

</html>