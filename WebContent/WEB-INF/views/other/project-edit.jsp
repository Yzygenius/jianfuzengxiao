<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<link type="text/css" rel="stylesheet" href="/tchyuanlin/statics/system/simditor/styles/simditor.css" />
<script type="text/javascript" src="/tchyuanlin/statics/system/simditor/scripts/jquery.min.js"></script>
<script type="text/javascript" src="/tchyuanlin/statics/system/simditor/scripts/module.js"></script>
<script type="text/javascript" src="/tchyuanlin/statics/system/simditor/scripts/hotkeys.js"></script>
<script type="text/javascript" src="/tchyuanlin/statics/system/simditor/scripts/uploader.js"></script>
<script type="text/javascript" src="/tchyuanlin/statics/system/simditor/scripts/simditor.js"></script>
</head>

<body>
	<input id="projectId" type="hidden" value="${project.projectId }">
	<div class="x-body">
		<form class="layui-form">
			<div class="layui-form-item">
				<label for="title" class="layui-form-label"> <span
					class="x-red">*</span>标题
				</label>
				<div class="layui-input-inline">
					<input type="text" id="title" name="title" lay-verify="required" value="${project.title }" required="" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="listOrder" class="layui-form-label"> <span
					class="x-red">*</span>标题
				</label>
				<div class="layui-input-inline">
					<input type="text" id="listOrder" name="listOrder" lay-verify="required" value="${project.listOrder }" required="" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="link" class="layui-form-label"> <span
					class="x-red">*</span>封面
				</label>
				<div class="layui-input-inline">
					<div class="layui-upload">
					  <button type="button" class="layui-btn" id="uploadImg">上传图片</button>
					  <div class="layui-upload-list">
					    <img width="200" src="/tchyuanlin/${project.cover }" class="layui-upload-img" id="img">
					  </div>
					</div>  
				</div>
			</div>
			<div class="layui-form-item">
				<label for="remark" class="layui-form-label"> <span
					class="x-red">*</span>内容
				</label>
				<div class="layui-input-block">
					<textarea id="content" name="content" autofocus></textarea>
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
<script src="/tchyuanlin/statics/system/lib/layui/layui.js" charset="utf-8"></script>
<script src="/tchyuanlin/statics/system/js/xadmin.js" charset="utf-8"></script>
<script>

Simditor.locale = 'zh-CN';
var editor = new Simditor({
	textarea: $("#content"),  //textarea的id
    placeholder: '',
    toolbar:  ['title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale', 'color', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|', 'link', 'image', 'hr', '|', 'indent', 'outdent', 'alignment'], //工具条都包含哪些内容
    pasteImage: true,//允许粘贴图片
   // defaultImage: '/simditor/images/image.png',//编辑器插入的默认图片，此处可以删除
    upload : {
        url : '/tchyuanlin/system/attachfile/uploadKindEditor.html', //文件上传的接口地址
        params: null, //键值对,指定文件上传接口的额外参数,上传的时候随文件一起提交
        fileKey:'uploadFile', //服务器端获取文件数据的参数名
        connectionCount: 3,
        leaveConfirm: '正在上传文件'
    }
});
	var saveName, fileId;
	$.ajax({  
		url : "/tchyuanlin/system/project/getProjectDetails.html",  
		type : 'post',
		dataType: "json",
		data: {
			'projectId': $('#projectId').val(),
		},
		success : function(result){
			editor.setValue(result.content);
			saveName = result.cover;
			fileId = result.coverFile;
		}
	})


layui.use(['form','layer','upload'], function(){
	var $ = layui.jquery
    ,form = layui.form
    ,layer = layui.layer
    ,upload = layui.upload
    
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
  //监听提交
  form.on('submit(update)', function(data){
      $.ajax({  
		url : "/tchyuanlin/system/project/updateProject.html",  
		type : 'post',
		dataType: "json",
		data: {
			'projectId': $('#projectId').val(),
			'listOrder': $('#listOrder').val(),
			'content': editor.getValue(),
			'title': $('#title').val(),
			'cover': saveName,
			'coverFile': fileId
		},
		success : function(result){
			if(result.success){
				layer.alert("更新成功", {icon: 6},function () {
		            // 获得frame索引
		            var index = parent.layer.getFrameIndex(window.name);
		            //关闭当前frame
		            parent.layer.close(index);
		            window.parent.location.reload();
		        });
			}else{
				layer.alert("更新出错", {icon: 5},function () {
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