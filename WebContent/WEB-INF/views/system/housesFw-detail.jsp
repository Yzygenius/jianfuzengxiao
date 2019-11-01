<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
</head>
<body>

	<div><span>省：</span>${houses.provName }</div>
	<div><span>市：</span>${houses.cityName }</div>
	<div><span>区/县：</span>${houses.areaName }</div>
	<div><span>社区：</span>${houses.communityName }</div>
	<div><span>小区：</span>${houses.communityStreetName }</div>
	<div><span>楼栋：</span>${houses.storiedBuildingNumber }</div>
	<div><span>单元：</span>${houses.unit }</div>
	<div><span>门牌号：</span>${houses.houseNumber }</div>
	<div><span>详细地址：</span>${houses.housesAddress }</div>
	<div><span>户型：</span>${houses.houseType }</div>
	<div><span>房屋类型：</span>${houses.housesTypeName }</div>
	<div><span>产权人：</span>${houses.propertyOwnerName }</div>
	<div><span>产权人身份证号：</span>${houses.propertyOwnerIdcard }</div>
	<div><span>产权证号：</span>${houses.propertyCertificatesNumber }</div>
	<div><span>房产证照片：</span><img src="${houses.propertyCertificatesPhoto }" alt="房产证照片" /></div>
	<div><span>户型图：</span><img src="${houses.houseTypePhoto }" alt="户型图" /></div>
	<div><span>首次上报时间：</span>${houses.createTime }</div>
	<div><span>最近更新时间：</span>${houses.updateTime }</div>
</body>
</html>