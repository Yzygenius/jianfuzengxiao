<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>X-admin v1.0</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="/tchyuanlin/statics/system/css/xadmin.css" media="all">
<link type="text/css" href="/tchyuanlin/statics/system/kindeditor/themes/default/default.css" />
<script type="text/javascript" src="/tchyuanlin/statics/system/kindeditor/kindeditor-min.js"></script>
<script type="text/javascript" src="/tchyuanlin/statics/system/kindeditor/lang/zh-CN.js"></script>
</head>

<body>
	<div class="x-body">
		<form class="layui-form">
			<div class="layui-form-item">
				<label for="typeName" class="layui-form-label"> <span
					class="x-red">*</span>类别
				</label>
				<div class="layui-input-inline">
					<input type="text" id="typeName" name="typeName" required="" lay-verify="required" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
				</div>
			</div>
			
			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn" lay-filter="add" lay-submit="">
					增加</button>
			</div>
		</form>
	</div>
<script type="text/javascript" src="/tchyuanlin/statics/system/js/jquery.min.js"></script>
<script src="/tchyuanlin/statics/system/lib/layui/layui.js" charset="utf-8"></script>
<script src="/tchyuanlin/statics/system/js/xadmin.js" charset="utf-8"></script>
<script>

    layui.use(['form','layer','upload'], function(){
    	var $ = layui.jquery
        ,form = layui.form
        ,layer = layui.layer
       
      //监听提交
      form.on('submit(add)', function(data){
          $.ajax({  
			url : "/tchyuanlin/system/productType/addProductType.html",  
			type : 'post',
			dataType: "json",
			data: {
				'typeName': $('#typeName').val()
			},
			success : function(result){
				if(result.success){
					layer.alert("增加成功", {icon: 6},function () {
			            // 获得frame索引
			            var index = parent.layer.getFrameIndex(window.name);
			            //关闭当前frame
			            parent.layer.close(index);
			            window.parent.location.reload();
			        });
				}else{
					layer.alert("增加出错", {icon: 5},function () {
			            // 获得frame索引
			            var index = parent.layer.getFrameIndex(window.name);
			            //关闭当前frame
			            parent.layer.close(index);
			            window.parent.location.reload();
			        });
				}
			},
			error : function(result){
				layer.alert("添加出错，请重新添加")
			}
		}); 
        return false;
      });
      
    });
</script>
</body>

</html>