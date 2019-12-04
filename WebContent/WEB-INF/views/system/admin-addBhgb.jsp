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
		<form class="layui-form" >
			
			<div class="layui-form-item">
				<label class="layui-form-label">
					<span>用户名</span>
				</label>
				<div class="layui-input-inline">
					<input type="text" id="loginName" name="loginName" lay-verify="required" placeholder="请输入用户名" required="" maxlength="16" autocomplete="off" class="layui-input">
					<span id="loginNameAlt" class="x-red"></span>
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
					<span>密码</span>
				</label>
				<div class="layui-input-inline">
					<input type="password" id="password" name="password" lay-verify="required" placeholder="请输入6-16位的密码" maxlength="16" required="" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">
					<span>角色</span>
				</label>
				<div class="layui-input-inline">
					<select id="roleSel" name="roleSel" lay-filter="roleSel" disabled="true" lay-verify="required" lay-search="">
						<option value="">请选择</option>
						<option value="3">流动专干</option>
						<option value="2" selected>包户干部</option>
			        </select>
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red"></span>
				</div>
			</div>
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
			<div class="layui-form-item">
				<label class="layui-form-label">
					<span>姓名</span>
				</label>
				<div class="layui-input-inline">
					<input type="text" id="username" name="username" lay-verify="required" required="" maxlength="30" autocomplete="off" class="layui-input">
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
					<input type="text" id="telephone" name="telephone" lay-verify="required" required="" maxlength="11" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			
			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn" lay-filter="add" lay-submit="">提交</button>
			</div>
		</form>
	</div>
<script src="/jianfuzengxiao/statics/system/lib/layui/layui.js" charset="utf-8"></script>
<script src="/jianfuzengxiao/statics/system/js/xadmin.js" charset="utf-8"></script>
<script>
	var form, layer, upload;
	
	var loginName, password, username, telephone = '';
	var roleId = '';
	var communityId = '', communityName = '';
    layui.use(['form','layer','upload'], function(){
    	var $ = layui.jquery
        form = layui.form
        layer = layui.layer
        upload = layui.upload;
    	
    	serchCommunity()
    	
    	form.on('select(roleSel)', function(data){
    		roleId = data.value;
        });
    	//监听社区
        form.on('select(communitySel)', function(data){
        	communityName = data.elem[data.elem.selectedIndex].text;
        	communityId = data.value;
        });
	    //监听提交
		form.on('submit(add)', function(data){
			if($('#password').val().length < 6 || $('#password').val().length > 16){
				layer.msg("请输入6-16位的密码", {icon: 7});
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
				url : "/jianfuzengxiao/system/admin/addAdmin.html",  
				type : 'post',
				dataType: "json",
				data: {
					'loginName': $('#loginName').val(),
					'password': $('#password').val(),
					'username': $('#username').val(),
					'telephone': $('#telephone').val(),
					'roleId': 2,
					'communityId': communityId
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
</script>
</body>

</html>