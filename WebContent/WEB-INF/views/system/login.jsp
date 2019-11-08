<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>后台管理</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/jianfuzengxiao/statics/system/css/font.css">
	<link rel="stylesheet" href="/jianfuzengxiao/statics/system/css/xadmin.css">
    <script type="text/javascript" src="/jianfuzengxiao/statics/system/js/jquery.min.js"></script>
    <script src="/jianfuzengxiao/statics/system/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/jianfuzengxiao/statics/system/js/xadmin.js"></script>
	<script>
	if(window != top){top.location.href = location.href;}
	</script>
</head>
<body class="login-bg">
    
    <div class="login layui-anim layui-anim-up">
        <div class="message">后台管理登录</div>
        <div id="darkbannerwrap"></div>
        
        <form method="post" class="layui-form" >
            <input name="loginName" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
            <hr class="hr15">
            <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
            <hr class="hr20" >
        </form>
    </div>

<script>
    $(function  () {
        layui.use('form', function(){
          var form = layui.form;
          
          form.on('submit(login)', function(data){
        	  $.ajax({  
      			url : "/jianfuzengxiao/system/login.html",  
      			type : 'post',
      			dataType: "json",
      			data: data.field,
      			success : function(result){
      				if(result.code == 1){
      					layer.msg("登录成功", {icon: 1, time: 1000},function () {
      						location.href = "/jianfuzengxiao/system.html";
    			        });
      				}else{
      					layer.msg("用户名密码错误，请重新输入", {icon: 2})
      				}
      			},
      			error : function(result){
      				layer.msg("服务器繁忙，请稍后再试", {icon: 2})
      			}
      		});
             return false;
          });
        });
    })

    
</script>
</body>
</html>