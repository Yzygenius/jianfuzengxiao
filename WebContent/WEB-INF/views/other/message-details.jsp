<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<style>
	.title{
		font-weight: bold;
	}
</style>
</head>
<body>
<div style="padding: 30px 50px;">
	<div><span class="title">姓名：</span>   ${message.username }</div>
	<br>
	<div><span class="title">邮箱：</span>   ${message.email }</div>
	<br>
	<div><span class="title">电话：</span>   ${message.telephone }</div>
	<br>
	<div><span class="title">时间：</span>   ${message.createTime }</div>
	<br>
	<div>
		<span class="title">留言：</span>
		<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		${message.message }
	</div>
</div>

</body>
</html>