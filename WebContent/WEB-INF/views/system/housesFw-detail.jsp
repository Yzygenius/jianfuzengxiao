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
		<colgroup>
		  	<col width="150">
		  	<col width="200">
		  	<col>
		</colgroup>
		<tbody id="x-img">
			<tr>
		    	<td class="title">房产信息</td>
		  	</tr>
		  	<tr>
		    	<td>&nbsp;</td>
		  	</tr>
		  	<tr>
		    	<td><span>省：</span>${houses.provName }</td>
		  	</tr>
		  	<tr>
		    	<td><span>市：</span>${houses.cityName }</td>
		  	</tr>
		  	<tr>
		    	<td><span>区/县：</span>${houses.areaName }</td>
		  	</tr>
		  	<tr>
		    	<td><span>社区：</span>${houses.communityName }</td>
		  	</tr>
		  	<tr>
		    	<td><span>小区：</span>${houses.communityStreetName }</td>
		  	</tr>
		  	<c:if test="${houses.housesStatus == 1}">
			  	<tr>
			    	<td><span>楼栋：</span>${houses.storiedBuildingNumber }</td>
			  	</tr>
			  	<tr>
			    	<td><span>单元：</span>${houses.unit }</td>
			  	</tr>
			  	<tr>
			    	<td><span>门牌号：</span>${houses.houseNumber }</td>
			  	</tr>
			</c:if>
			<c:if test="${houses.housesStatus == 2}">
			  	<tr>
			    	<td><span>内/外铺：</span>
			    		<c:if test="${houses.storeLocation == 1}">
			    			内铺
			    		</c:if>
			    		<c:if test="${houses.storeLocation == 2}">
			    			外铺
			    		</c:if>
			    	</td>
			  	</tr>
			  	<tr>
			    	<td><span>门牌号：</span>${houses.houseNumber }</td>
			  	</tr>
			  	<tr>
			    	<td>&nbsp;</td>
			  	</tr>
			</c:if>
		  	<tr>
		    	<td><span>详细地址：</span>${houses.housesAddress }</td>
		  	</tr>
		  	<tr>
		    	<td><span>户型：</span>${houses.houseType }</td>
		  	</tr>
		  	<tr>
		    	<td><span>房屋类型：</span>${houses.housesTypeName }</td>
		  	</tr>
		  	<tr>
		    	<td><span>产权人：</span>${houses.propertyOwnerName }</td>
		  	</tr>
		  	<tr>
		    	<td><span>产权人身份证号：</span>${houses.propertyOwnerIdcard }</td>
		  	</tr>
		  	<tr>
		    	<td><span>产权证号：</span>${houses.propertyCertificatesNumber }</td>
		  	</tr>
		  	<tr>
		    	<td style="height: 120px;"><span>房产证照片：</span><img onclick="opneimg(this)" src="${houses.propertyCertificatesPhoto }" alt="房产证照片" /></td>
		  	</tr>
		  	<tr>
		    	<td style="height: 120px;"><span>户型图：</span><img onclick="opneimg(this)" src="${houses.houseTypePhoto }" alt="户型图" /></td>
		  	</tr>
		  	<tr>
		    	<td>首次上报时间：${houses.createTime }</td>
		  	</tr>
		  	<c:if test="${houses.updateTime == null || houses.updateTime == '' }">
			  	<tr>
			    	<td>最新上报时间：${houses.createTime }</td>
			  	</tr>
		  	</c:if>
		  	<c:if test="${houses.updateTime != null && houses.updateTime != '' }">
			  	<tr>
			    	<td>最新上报时间：${houses.updateTime }</td>
			  	</tr>
		  	</c:if>
		  	
		</tbody>
	</table>
	
	<table class="layui-table">
		<thead>
			<tr>
				<!-- <th><input type="checkbox" value="" name="" id="checkAll"
					onclick="checkAll(this)"></th> -->
				<th>姓名</th>
				<th>性别</th>
				<th>民族</th>
				<th>联系电话</th>
				<th>类型</th>
				<th>居住时间</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="x-img">
			
		</tbody>
	</table>

	<div id="page"></div>
	
	
	
	<script type="text/javascript" src="/jianfuzengxiao/statics/system/js/jquery.min.js"></script>
	<script src="/jianfuzengxiao/statics/system/lib/layui/layui.js" charset="utf-8"></script>
	<script src="/jianfuzengxiao/statics/system/js/xadmin.js" charset="utf-8"></script>
	<script type="text/javascript">
		var $, form, layer;
		var housesId = '${houses.housesId}';
		$(function(){
			layui.use(['form', 'layer' ], function() {
				$ = layui.jquery//jquery
				, form = layui.form
				, layer = layui.layer;//弹出层
				
			})
			
			personnelList()
		})
		
		//居住人员列表
		function personnelList(){
			$.ajax({  
				url : "/jianfuzengxiao/system/houses/getPerPage.html",  
				type : 'post',
				dataType: "json",
				data: {
					'housesId': housesId
				},
				success : function(result){
					if(result.code == 1){
						var str = '';
						$.each(result.data, function (index, item) {
							str += "<option value='" + item.code + "'>" + item.name + "</option>";
				        });
				        $("#province").append(str);
				        //append后必须从新渲染
				        form.render('select')
				        provinceList = result.data;
					}else{
						layer.msg("数据加载错误，请刷新页面", {icon: 2});
					}
					
				},
				error : function(result){
					layer.msg("数据加载错误，请刷新页面", {icon: 2})
				}
			});
		}
		
		//查看图片
		function opneimg(obj){
        	//console.log(obj)
        	layer.photos({
               photos: '#x-img'
              //,shift: 5 //0-6的选择，指定弹出图片动画类型，默认随机
            });
        }

	</script>
	
	<table id="clone-tr" style="display: none;">
		<tr>
			<!-- <td row="checkBoxId"><input type="checkbox" class="checkId"
				value="" name=""></td> -->
			<td row="ids" style="display: none;"></td>
			<td row="username"></td>
			<td row="gender">
				<!-- <div style="width:200px;height:22px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap"></div> -->
			</td>
			<td row="nationName"></td>
			<td row="telephone"></td>
			<td row="liveTypeName"></td>
			<td row="leaseTime"></td>
			<td row="status"></td>
			<td class="td-manage">
				<button class="layui-btn layui-btn layui-btn-xs"
					onclick="banner_details(this,'查看','/jianfuzengxiao/system/per/toAuditYezhuDetail.html', 1000, 620)">
					<i class="layui-icon">&#xe615;</i>查看
				</button>
				<!-- <button class="layui-btn layui-btn layui-btn-xs"
					onclick="banner_edit(this,'编辑','/jianfuzengxiao/system/houses/toUpdateHousesFw.html', 820)">
					<i class="layui-icon">&#xe642;</i>编辑
				</button> -->
				<button class="layui-btn-danger layui-btn layui-btn-xs"
					onclick="banner_del(this)" href="javascript:;">
					<i class="layui-icon">&#xe640;</i>删除
				</button>
			</td>
		</tr>
	</table>
</body>
</html>