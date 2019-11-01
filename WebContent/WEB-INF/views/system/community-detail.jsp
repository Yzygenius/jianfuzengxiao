<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
</head>
<body>
	<div><span>省：</span>${community.provName }</div>
	<div><span>市：</span>${community.cityName }</div>
	<div><span>区/县：</span>${community.areaName }</div>
	<div><span>社区名称：</span>${community.communityName }</div>
	<div><span>排序：</span>${community.listOrder }</div>
	<div><span>创建时间：</span>${community.createTime }</div>
	<div><span>最近更新时间：</span>${community.updateTime }</div>
</body>
</html>