<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
</head>
<body>

	<div><span>姓名：</span>${per.username }</div>
	<div><span>性别：</span>${per.gender }</div>
	<div><span>年龄：</span>${per.age }</div>
	<div><span>民族：</span>${per.nationName }</div>
	<div><span>联系电话：</span>${per.telephone }</div>
	<div><span>证件正面：</span><img src="${per.certificatesPositivePhoto }"/></div>
	<div><span>证件反面：</span><img src="${per.certificatesNegativePhoto }"/></div>
	<div><span>证件号码：</span>${per.certificatesNumber }</div>
	<div><span>证件时效：</span>${per.certificatesStartTime } - ${per.certificatesStopTime }</div>
	<div><span>证件地址：</span>${per.certificatesAddress }</div>
	<div><span>办证机关：</span>${per.certificatesOffice }</div>
</body>
</html>