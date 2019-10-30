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
		<form class="layui-form">
			<div class="layui-form-item">
				<label for="remark" class="layui-form-label"> 
					<span class="x-red">*</span>内容
				</label>
				<div class="layui-input-inline">
					<input type="text" id=communityName name="communityName" value="${community.communityName }" required="" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="remark" class="layui-form-label"> 
					<span class="x-red">*</span>备注
				</label>
				<div class="layui-input-inline">
					<input type="text" id="listOrder" name="listOrder" value="${community.listOrder }" required="" autocomplete="off" class="layui-input">
					<span class="x-red">展示顺序，填写1-9999，数值越小展示顺序越靠前</span>
				</div>
				<div class="layui-form-mid layui-word-aux">
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
    
    
  //监听提交
  form.on('submit(update)', function(data){
      $.ajax({  
		url : "/jianfuzengxiao/system/community/updateCommunity.html",  
		type : 'post',
		dataType: "json",
		data: {
			'communityId': $('#id').val(),
			'communityName': $('#communityName').val(),
			'listOrder': $('#listOrder').val()
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