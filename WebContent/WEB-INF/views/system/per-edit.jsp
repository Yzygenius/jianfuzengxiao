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
<style>
	.facePhoto{
		width: 200px;
	}
	.certPhoto{
		width: 400px;
	}
</style>
</head>

<body>
	<input id="id" type="hidden" value="">
	<div id="x-img" class="x-body">
		<form class="layui-form" lay-filter="example">
			<div class="layui-form-item">
				<label class="layui-form-label">人脸照片</label>
				<div class="layui-input-inline"><img id="facePhoto" class="facePhoto" onclick="opneimg(this)" src=""/></div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">身份证正面照片</label>
				<div class="layui-input-inline"><img id="certificatesPositivePhoto" class="certPhoto" onclick="opneimg(this)" src=""/></div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">身份证反面照片</label>
				<div class="layui-input-inline"><img id="certificatesNegativePhoto" class="certPhoto" onclick="opneimg(this)" src=""/></div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">联系电话</label>
				<div class="layui-input-inline">
					<input type="text" id="telephone" name="telephone" value="" lay-verify="required" required="" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">姓名</label>
				<div class="layui-input-inline">
					<input type="text" id="username" name="username" value="" lay-verify="required" required="" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">性别</label>
				<div class="layui-input-inline">
					<select id="gender" name="gender" lay-filter="gender" lay-search="">
						<option value="">请选择性别</option>
						<option value="1">男</option>
						<option value="2">女</option>
			        </select>
			    </div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">生日</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="birthDate" name="birthDate" placeholder="yyyy-MM-dd">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">民族</label>
				<div class="layui-input-inline">
					<select id="nationId" name="nationId" lay-filter="nationId" lay-search="">
						<option value="">请选择民族</option>
			        </select>
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">证件号码</label>
				<div class="layui-input-inline">
					<input type="text" id="certificatesNumber" name="certificatesNumber" value="" lay-verify="required" required="" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">证件时效</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="certificatesStartTime" name="certificatesStartTime" placeholder="yyyy-MM-dd">
				</div>
				<div class="layui-inline">
			      	<input type="text" class="layui-input" id="certificatesStopTime" name="certificatesStopTime" placeholder="">
			    </div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">办证机关</label>
				<div class="layui-input-inline">
					<input type="text" id="certificatesOffice" name="certificatesOffice" value="" lay-verify="required" required="" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">证件地址</label>
				<div class="layui-input-inline">
					<textarea placeholder="请输入内容" id="certificatesAddress" name="certificatesAddress" lay-verify="required" class="layui-textarea"></textarea>
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
var form, layer, laydate
var perId='', nationName = '';
layui.use(['form','layer','laydate'], function(){
    form = layui.form
    layer = layui.layer
    laydate = layui.laydate
    
    getNationList();
  
    form.on('select(nationId)', function(data){
    	nationName = data.elem[data.elem.selectedIndex].text;
    })
    
  	//监听提交
  	form.on('submit(update)', function(data){
  		data.field.personnelId = perId;
  		data.field.nationName = nationName;
      	$.ajax({  
			url : "/jianfuzengxiao/system/per/updatePer.html",  
			type : 'post',
			dataType: "json",
			data: data.field,
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

function serchData(){
	$.ajax({  
		url : "/jianfuzengxiao/system/per/getPerDetail.html",  
		type : 'post',
		dataType: "json",
		data: {
			'personnelId': GetQueryString('personnelId')
		},
		success : function(result){
			//console.log(result)
			if(result.code == 1){
				var data = result.data;
				form.val('example', {
					"telephone": data.telephone, // "name": "value"
					"username": data.username,
					"birthDate": data.birthDate,
					"certificatesNumber": data.certificatesNumber, 
					"certificatesStartTime": data.certificatesStartTime, 
					"certificatesStopTime": data.certificatesStopTime,
					"certificatesOffice": data.certificatesOffice,
					'certificatesAddress': data.certificatesAddress,
					'gender': data.gender,
					'nationId': data.nationId,
				});
				$('#facePhoto').attr('src', data.facePhoto)
				$('#certificatesPositivePhoto').attr('src', data.certificatesPositivePhoto)
				$('#certificatesNegativePhoto').attr('src', data.certificatesNegativePhoto)
				laydate.render({
			    	elem: '#birthDate'
			    });
				laydate.render({
			    	elem: '#certificatesStartTime'
			    });
				if(data.certificatesStopTime != '长期'){
					laydate.render({
				    	elem: '#certificatesStopTime'
				    });
				}
				perId = data.personnelId;
				nationName = data.nationName;
			}else{
				layer.msg(result.msg, {icon: 7});
			}
		},
		error : function(result){
			layer.msg("更新出错，请重新操作", {icon : 2})
		}
	}); 
}

function getNationList(){
	$.ajax({
		url : "/jianfuzengxiao/common/getNationList.html",
		type : 'post',
		dataType : "json",
		data : {
		},
		success : function(result) {
			if (result.code == 1) {
				var str = '';
				$.each(result.data, function (index, item) {
					str += "<option value='" + item.nationId + "'>" + item.nationName + "</option>";
		        });
		        $("#nationId").append(str);
		        //append后必须从新渲染
		        form.render('select')
		        //下拉框加载完成后，渲染页面
		        serchData();
			} else {
				layer.msg("加载数据出错，请刷新页面", {icon : 2});
			}
		},
		error : function(result) {
			layer.msg("加载数据出错，请刷新页面", {icon: 2})
		}
	});
}

function opneimg(obj){
	//console.log(obj)
	layer.photos({
       photos: '#x-img'
      //,shift: 5 //0-6的选择，指定弹出图片动画类型，默认随机
    });
}
</script>
</body>

</html>