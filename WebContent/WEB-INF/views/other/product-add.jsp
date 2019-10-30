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
<link type="text/css" rel="stylesheet" href="/tchyuanlin/statics/system/simditor/styles/simditor.css" />
<script type="text/javascript" src="/tchyuanlin/statics/system/simditor/scripts/jquery.min.js"></script>
<script type="text/javascript" src="/tchyuanlin/statics/system/simditor/scripts/module.js"></script>
<script type="text/javascript" src="/tchyuanlin/statics/system/simditor/scripts/hotkeys.js"></script>
<script type="text/javascript" src="/tchyuanlin/statics/system/simditor/scripts/uploader.js"></script>
<script type="text/javascript" src="/tchyuanlin/statics/system/simditor/scripts/simditor.js"></script>
</head>

<body>
	<div class="x-body">
		<form class="layui-form">
			<div class="layui-form-item">
				<label for="productName" class="layui-form-label"> <span
					class="x-red">*</span>产品名称
				</label>
				<div class="layui-input-inline">
					<input type="text" id="productName" name="productName" required=""
						lay-verify="required" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="listOrder" class="layui-form-label"> <span
					class="x-red">*</span>排序
				</label>
				<div class="layui-input-inline">
					<input type="text" id="listOrder" name="listOrder" required=""
						lay-verify="required" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="type" class="layui-form-label"> <span
					class="x-red">*</span>类别
				</label>
				<div class="layui-input-inline">
					<select id="selectType" name="modules" lay-verify="required" lay-filter="selectType" lay-search="">
			          	
			        </select>
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			
			<div class="layui-form-item">
				<label for="link" class="layui-form-label"> <span
					class="x-red">*</span>缩略图
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
				<label for="productRemark" class="layui-form-label"> <span
					class="x-red">*</span>产品描述
				</label>
				<div class="layui-input-block">
					<textarea id="content" name="content" autofocus></textarea>
					
				</div>
			</div>
			
			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn" lay-filter="add" lay-submit="">
					增加</button>
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
	var saveName, fileId, type;
    layui.use(['form','layer','upload'], function(){
    	var $ = layui.jquery
        ,form = layui.form
        ,layer = layui.layer
        ,upload = layui.upload;
    	
    	$.ajax({  
			url : "/tchyuanlin/system/productType/getProductTypeList.html",  
			type : 'post',
			dataType: "json",
			data: {
			},
			success : function(result){
				$('#selectType').html('');
				var str = '<option value="">请选择</option>';
				for(var i=0;i<result.length;i++){
					str += '<option value="'+result[i].producttypeId+'">'+result[i].typeName+'</option>'
				}
				$('#selectType').append(str);
				form.render('select');
			},
			error : function(result){
				layer.alert("数据加载出错，请刷新页面", {icon: 5})
			}
		})
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
        
        form.on('select(selectType)', function(data){
        	type = data.value;
       	}); 
      //监听提交
      form.on('submit(add)', function(data){
    	 // console.log(data)
          $.ajax({  
			url : "/tchyuanlin/system/product/addProduct.html",  
			type : 'post',
			dataType: "json",
			data: {
				'productName': data.field.productName,
				'listOrder': data.field.listOrder,
				'type': type,
				'img': saveName,
				'imgFile': fileId,
				'productRemark': editor.getValue()
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