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
</head>

<body>
	<div class="x-body">
		<form class="layui-form">
			<div class="layui-form-item">
				<label for="link" class="layui-form-label"> <span
					class="x-red">*</span>轮播图
				</label>
				<div class="layui-input-inline">
					<div class="layui-upload">
					  <button type="button" class="layui-btn" id="uploadImg">上传图片</button>
					  <div class="layui-upload-list">
					    <img width="400" class="layui-upload-img" id="img">
					  </div>
					</div>  
				</div>
			</div>
			
			<div class="layui-form-item">
				<label for="remark" class="layui-form-label"> <span
					class="x-red">*</span>描述
				</label>
				<div class="layui-input-inline">
					<input type="text" id="remark" name="remark" required=""
						lay-verify="required" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>

			<div class="layui-form-item">
				<label for="isEnable" class="layui-form-label">
					<span class="x-red">*</span>显示状态
				</label>
			    <div class="layui-input-inline">
			      <input type="checkbox" name="close" lay-skin="switch" lay-filter="switchTest" lay-text="ON|OFF">
			    </div>
			</div>
			
			<div class="layui-form-item">
				<label for="listOrder" class="layui-form-label"> <span
					class="x-red">*</span>排序
				</label>
				<div class="layui-input-inline">
					<input type="text" id="listOrder" name="listOrder" required=""
						lay-verify="required" autocomplete="off" class="layui-input">
						<span style="color:red;font-size:12px;">（说明：轮播图顺序排序，1-999 数值越小展示顺序越靠前）</span>
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
	var saveName, fileId;
    layui.use(['form','layer','upload'], function(){
    	var $ = layui.jquery
        ,form = layui.form
        ,layer = layui.layer
        ,upload = layui.upload;
        //图片上传接口
        upload.render({
        	elem: '#uploadImg'
            ,url: '/tchyuanlin/system/attachfile/uploadImage.html' //上传接口
            ,done: function(res){ //上传成功后的回调
                $('#img').attr('src','/tchyuanlin/'+res.data.saveName);
				saveName = res.data.saveName;
				fileId = res.data.fileId;
            }
            ,error: function(){
            	layer.msg('上传失败，请重新操作', {icon: 5});
            }
        });
        
    	var enable = 'N';
        form.on('switch(switchTest)', function(data){
            if(this.checked){
            	enable = 'Y';
            }else{
            	enable = 'N';
            }
       	});
      //监听提交
      form.on('submit(add)', function(data){
          $.ajax({  
			url : "/tchyuanlin/system/carouselimg/addCarouselImg.html",  
			type : 'post',
			dataType: "json",
			data: {
				'img': saveName,
				'imgFile': fileId,
				'remark': data.field.remark,
				'isEnable': enable,
				'listOrder': data.field.listOrder
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