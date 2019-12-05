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
					<span>角色</span>
				</label>
				<div class="layui-input-inline">
					<select id="roleSel" name="roleSel" lay-filter="roleSel" disabled="true" lay-verify="required" lay-search="">
						<option value="">请选择</option>
						<c:if test="${admin.roleId == 3}">
							<option value="3" selected>流管专干</option>
						</c:if>
						<c:if test="${admin.roleId == 2}">
							<option value="2" selected>包户干部</option>
						</c:if>
						
			        </select>
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red"></span>
				</div>
			</div>
			<c:if test="${admin.roleId == 2}">
				<div class="layui-form-item">
					<label class="layui-form-label">
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
			</c:if>
			<c:if test="${admin.roleId == 3}">
				<div class="layui-form-item">
					<label class="layui-form-label">管委会</label>
					<div class="layui-input-inline">
						<select id="gwh" name="gwh" lay-filter="gwh" lay-verify="required" lay-search="">
							<option value="">请选择管委会</option>
						</select>
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red">*</span>
					</div>
				</div>
			</c:if>
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
	<input type="text" id="communityId" value="${admin.communityId}" style="display: none;">
	<input type="text" id="gwhId" value="${admin.gwhId}" style="display: none;">
<script src="/jianfuzengxiao/statics/system/lib/layui/layui.js" charset="utf-8"></script>
<script src="/jianfuzengxiao/statics/system/js/xadmin.js" charset="utf-8"></script>
<script>

var form, layer, upload;
var communityId = $('#communityId').val();
var gwhId = $('#gwhId').val();
var adminId = ${admin.adminId }
var roleId = ${admin.roleId }

layui.use(['form','layer', 'upload'], function(){
	var $ = layui.jquery;
    form = layui.form;
    layer = layui.layer;
    upload = layui.upload;
    
    serchCommunity()
    getGwhList()
   
  	//监听提交
	form.on('submit(update)', function(data){
		
		if($('#username').val().length < 1){
			layer.msg("请输入有效姓名", {icon: 7});
			return false;
		}
		if($('#telephone').val().length != 11){
			layer.msg("请输入有效电话", {icon: 7});
			return false;
		}
		var param;
		if(roleId == 2){
			param =  {
					'adminId': adminId,
					'username': $('#username').val(),
					'telephone': $('#telephone').val(),
					'communityId': data.field.communitySel
				}
		}else if(roleId == 3){
			param =  {
					'adminId': adminId,
					'username': $('#username').val(),
					'telephone': $('#telephone').val(),
					'gwhId': data.field.gwh
				}
		}
		 
	    $.ajax({  
			url : "/jianfuzengxiao/system/admin/updateAdmin.html",  
			type : 'post',
			dataType: "json",
			data: param,
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
function serchCommunity(){
	$.ajax({  
		url : "/jianfuzengxiao/system/community/getCommunityList.html",  
		type : 'post',
		dataType: "json",
		data: {
		},
		success : function(result){
			if(result.code == 1){
				$('#communitySel').html('');
				var str = '<option value="">请选择社区</option>';
				for(var i=0;i<result.data.length;i++){
					if(communityId == result.data[i].communityId){
						str += '<option value="'+result.data[i].communityId+'" selected>'+result.data[i].communityName+'</option>'
					}else{
						str += '<option value="'+result.data[i].communityId+'">'+result.data[i].communityName+'</option>'
					}
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
function getGwhList(){
	
	//console.log(data)
	$.ajax({  
		url : "/jianfuzengxiao/system/gwh/getGwhList.html",  
		type : 'post',
		dataType: "json",
		data: {},
		success : function(result){
			//console.log(result)
			if(result.code == 1){
				$("#gwh").html('');
				var str = '<option value="">请选择管委会</option>';
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