<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>admin</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="/jianfuzengxiao/statics/system/css/xadmin.css" media="all">
<style>
	.td-width{width: 200px;}
	.layui-table tr{
		float:left;
		width:50%;
		color: #000;
	}
	.layui-form-item{
		color:#000;
	}
	.title{
		font-weight: bold;
		font-size: 16px !important;
	}
</style>
</head>
<body>
	<table class="layui-table" lay-size="lg" lay-skin="nob">
		
		<tbody id="x-img">
			<tr>
		    	<td class="title">小区/道路信息</td>
		  	</tr>
		  	<tr>
		    	<td>&nbsp;</td>
		  	</tr>
		  	<tr>
		    	<td><span>省：</span>${communityStreet.provName }</td>
		  	</tr>
		  	<tr>
		    	<td><span>市：</span>${communityStreet.cityName }</td>
		  	</tr>
		  	<tr>
		    	<td><span>区/县：</span>${communityStreet.areaName }</td>
		  	</tr>
		  	<tr>
		    	<td><span>管委会：</span>${communityStreet.gwhName }</td>
		  	</tr>
		  	<tr>
		    	<td><span>社区：</span>${communityStreet.communityName }</td>
		  	</tr>
		  	<tr>
		    	<td><span>小区/道路：</span>${communityStreet.communityStreetName }</td>
		  	</tr>
		  	<tr>
		    	<td><span>排序：</span>${communityStreet.listOrder }</td>
		  	</tr>
		  	<tr>
		    	<td>&nbsp;</td>
		  	</tr>
		  	<tr>
		    	<td>首次上报时间：${communityStreet.createTime }</td>
		  	</tr>
		  	<c:if test="${communityStreet.updateTime == null || communityStreet.updateTime == '' }">
			  	<tr>
			    	<td>最新上报时间：${communityStreet.createTime }</td>
			  	</tr>
		  	</c:if>
		  	<c:if test="${communityStreet.updateTime != null && communityStreet.updateTime != '' }">
			  	<tr>
			    	<td>最新上报时间：${communityStreet.updateTime }</td>
			  	</tr>
		  	</c:if>
		  	
		</tbody>
	</table>
	
	<script type="text/javascript" src="/jianfuzengxiao/statics/system/js/jquery.min.js"></script>
	<script src="/jianfuzengxiao/statics/system/lib/layui/layui.js" charset="utf-8"></script>
	<script src="/jianfuzengxiao/statics/system/js/xadmin.js" charset="utf-8"></script>
	<script type="text/javascript">
		var $, form, layer;
		layui.use(['form', 'layer' ], function() {
			$ = layui.jquery//jquery
			, form = layui.form
			, layer = layui.layer;//弹出层
			
		})
		
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