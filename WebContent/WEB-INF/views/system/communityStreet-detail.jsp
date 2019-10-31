<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
</head>
<body>
	<div><span>社区：</span>${communityStreet.communityName }</div>
	<div><span>小区/街道：</span>${communityStreet.communityStreetName }</div>
	<%-- <div><span>类型：</span>${communityStreet.communityName }</div> --%>
	<div><span>排序：</span>${communityStreet.listOrder }</div>
	<div><span>创建时间：</span>${communityStreet.createTime }</div>
	<div><span>最近更新时间：</span>${communityStreet.updateTime }</div>
</body>
</html>