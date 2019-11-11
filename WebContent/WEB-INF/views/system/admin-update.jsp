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
				<label class="layui-form-label">
					<span>用户名</span>
				</label>
				<div class="layui-input-inline">
					<input type="text" id="loginName" name="loginName" value="${admin.loginName }" disabled="true" required="" autocomplete="off" class="layui-input">
					<span id="loginNameAlt" class="x-red"></span>
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red"></span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
					<span>姓名</span>
				</label>
				<div class="layui-input-inline">
					<input type="text" id="username" name="username" value="${admin.username }" lay-verify="required" required="" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
					<span>联系电话</span>
				</label>
				<div class="layui-input-inline">
					<input type="text" id="telephone" name="telephone" value="${admin.telephone }" lay-verify="required" required="" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn" lay-filter="update" lay-submit="">提交</button>
			</div>
		</form>
	</div>
<script src="/jianfuzengxiao/statics/system/lib/layui/layui.js" charset="utf-8"></script>
<script src="/jianfuzengxiao/statics/system/js/xadmin.js" charset="utf-8"></script>
<script>

var form, layer, upload;

var adminId = ${admin.adminId }
layui.use(['form','layer', 'upload'], function(){
	var $ = layui.jquery;
    form = layui.form;
    layer = layui.layer;
    upload = layui.upload;
    
    
    
    
   
  	//监听提交
	form.on('submit(update)', function(data){
		if($('#loginName').val().length < 6 || $('#loginName').val().length > 16){
			layer.msg("请输入6-16位的用户名", {icon: 7});
			return false;
		}
		if($('#username').val().length < 1){
			layer.msg("请输入有效姓名", {icon: 7});
			return false;
		}
		if($('#telephone').val().length != 11){
			layer.msg("请输入有效电话", {icon: 7});
			return false;
		}
	    $.ajax({  
			url : "/jianfuzengxiao/system/admin/updateAdmin.html",  
			type : 'post',
			dataType: "json",
			data: {
				'adminId': adminId,
				'username': $('#username').val(),
				'telephone': $('#telephone').val()
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
				layer.msg("更新出错，请重新操作", {icon : 2})
			}
		}); 
	   	return false;
	});
  
});

</script>
</body>

</html>