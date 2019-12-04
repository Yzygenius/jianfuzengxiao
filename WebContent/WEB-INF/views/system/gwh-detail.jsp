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
	.table-detail tr{
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
		line-height: 40px;
	}
</style>
</head>
<body>
	<table class="layui-table table-detail" lay-size="lg" lay-skin="nob">
		
		<tbody id="x-img">
			<tr>
		    	<td class="title">社区信息</td>
		  	</tr>
		  	<tr>
		    	<td>&nbsp;</td>
		  	</tr>
		  	<tr>
		    	<td><span>省：</span>${gwh.provName }</td>
		  	</tr>
		  	<tr>
		    	<td><span>市：</span>${gwh.cityName }</td>
		  	</tr>
		  	<tr>
		    	<td><span>区/县：</span>${gwh.areaName }</td>
		  	</tr>
		  	<tr>
		    	<td><span>管委会：</span>${gwh.gwhName }</td>
		  	</tr>
		  	<tr>
		    	<td><span>排序：</span>${gwh.gwhId }</td>
		  	</tr>
		  	<tr>
		    	<td>&nbsp;</td>
		  	</tr>
		  	<tr>
		    	<td>首次上报时间：${gwh.createTime }</td>
		  	</tr>
		  	<c:if test="${gwh.updateTime == null || gwh.updateTime == '' }">
			  	<tr>
			    	<td>最新上报时间：${gwh.createTime }</td>
			  	</tr>
		  	</c:if>
		  	<c:if test="${gwh.updateTime != null && gwh.updateTime != '' }">
			  	<tr>
			    	<td>最新上报时间：${gwh.updateTime }</td>
			  	</tr>
		  	</c:if>
		  	
		</tbody>
	</table>
	
	<div class="x-body">
		<xblock style="height: 38px;">
		<%-- <c:if test="${sessionScope.SESSION_ADMIN.roleId == 1}">
		<button class="layui-btn layui-btn-danger" onclick="delAll()">
			<i class="layui-icon">&#xe640;</i>批量删除
		</button>
		<button class="layui-btn"
			onclick="banner_add('新增','/jianfuzengxiao/system/communityStreet/toAddCommunityStreet.html', 780, 520)">
			<i class="layui-icon">&#xe608;</i>添加
		</button>
		</c:if> --%>
		<span class="title">社区</span>
		<span id="total" class="x-right" style="line-height: 40px"></span></xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<%-- <c:if test="${sessionScope.SESSION_ADMIN.roleId == 1}">
					<th><input type="checkbox" value="" name="" id="checkAll" onclick="checkAll(this)"></th>
					</c:if> --%>
					<th>排序</th>
					<th>社区名称</th>
					<th>创建时间</th>
					<!-- <th>更新时间</th> -->
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="data-list">

			</tbody>
		</table>

		<div id="page"></div>
	</div>
	
	
	
	<script type="text/javascript" src="/jianfuzengxiao/statics/system/js/jquery.min.js"></script>
	<script src="/jianfuzengxiao/statics/system/lib/layui/layui.js" charset="utf-8"></script>
	<script src="/jianfuzengxiao/statics/system/js/xadmin.js" charset="utf-8"></script>
	<script type="text/javascript">
		var $, form, layer, laypage;
		var gwhId = ${gwh.gwhId };
		layui.use(['form', 'layer', 'laypage'], function() {
			$ = layui.jquery//jquery
			, form = layui.form
			, layer = layui.layer//弹出层
			, laypage = layui.laypage;//分页
			
			page()
		})
		
		//分页
		function page() {
			$.ajax({
				url : "/jianfuzengxiao/system/community/getCommunityPage.html",
				type : 'post',
				dataType : "json",
				data: {'gwhId': gwhId},
				success : function(result) {
					laypage.render({
						elem : 'page',
						count : result.data.total,
						jump : function(obj) {
							serchData(obj.curr)
						}
					})
					if(result.data.total == 0){
						//close loading
						layer.closeAll('loading');
						$('#page').hide();
					}else{
						$('#page').show();
					}
				}
			})
		}

		function serchData(page) {

			var data = {
				'page' : page,
				'gwhId': gwhId
			};
			$.ajax({
				url : "/jianfuzengxiao/system/community/getCommunityPage.html",
				type : 'post',
				dataType : "json",
				data : data,
				success : function(result) {
					if (result.code == 1) {
						$('#total').text('共有数据：' + result.data.total + '条');

						$('#data-list').html('');
						var data = result.data.rows;
						for (var i = 0; i < data.length; i++) {
							var tr = $('#clone-tr').find('tr').clone();
							tr.find('[row=checkBoxId]').children().val(data[i].communityId);
							tr.find('[row=ids]').text(data[i].communityId);
							tr.find('[row=listOrder]').text(data[i].communityId);
							tr.find('[row=communityName]').text(data[i].communityName);
							
							tr.find('[row=createTime]').text(data[i].createTime);
							tr.find('[row=updateTime]').text(data[i].updateTime);

							$('#data-list').append(tr);
							//close loading
							layer.closeAll('loading');
						}
					} else {
						layer.msg("加载数据出错，请刷新页面", {icon : 2})
					}

				},
				error : function(result) {
					layer.msg("加载数据出错，请刷新页面", {icon : 2})
				}
			});
		}
		
		function opneimg(obj){
        	//console.log(obj)
        	layer.photos({
               photos: '#x-img'
              //,shift: 5 //0-6的选择，指定弹出图片动画类型，默认随机
            });
        }
		
		function banner_details(obj, title, url, w, h) {
			var id = $(obj).parent('td').siblings('[row=ids]').text();
			x_admin_show(title, url + '?communityId=' + id, w, h);
		}
		
		function banner_edit(obj, title, url, w, h) {
			var id = $(obj).parent('td').siblings('[row=ids]').text();
			x_admin_show(title, url + '?communityId=' + id, w, h);
		}
		
		function banner_del(obj) {
			layer.confirm('确认要删除吗？', function(index) {
				var id = $(obj).parent('td').siblings('[row=ids]').text();
				$.ajax({
					url : "/jianfuzengxiao/system/community/delCommunity.html",
					type : 'post',
					dataType : "json",
					data : {
						'communityId' : id
					},
					success : function(result) {
						if (result.code == 1) {
							page();
							layer.msg('删除成功', {icon : 1});
						} else {
							layer.msg(result.msg, {icon : 7});
						}
					},
					error : function(result) {
						layer.msg("加载数据出错，请刷新页面后，重新操作", {icon : 2})
					}
				});

			});
		}

	</script>
	
	<table id="clone-tr" style="display: none;">
		<tr>
			<%-- <c:if test="${sessionScope.SESSION_ADMIN.roleId == 1}">
			<td row="checkBoxId"><input type="checkbox" class="checkId" value="" name=""></td>
			</c:if> --%>
			<td row="ids" style="display: none;"></td>
			<td row="listOrder"></td>
			<td row="communityName">
				<!-- <div style="width:200px;height:22px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap"></div> -->
			</td>
			<td row="createTime"></td>
			<!-- <td row="updateTime"></td> -->
			<td class="td-manage">
				<button class="layui-btn layui-btn layui-btn-xs"
					onclick="banner_details(this,'查看','/jianfuzengxiao/system/community/toCommunityDetail.html', 1000, 620)">
					<i class="layui-icon">&#xe615;</i>查看
				</button>
				<c:if test="${sessionScope.SESSION_ADMIN.roleId == 1}">
				<button class="layui-btn layui-btn layui-btn-xs"
					onclick="banner_edit(this,'编辑','/jianfuzengxiao/system/community/toUpdateCommunity.html', 780, 520)">
					<i class="layui-icon">&#xe642;</i>编辑
				</button>
				<button class="layui-btn-danger layui-btn layui-btn-xs"
					onclick="banner_del(this)" href="javascript:;">
					<i class="layui-icon">&#xe640;</i>删除
				</button>
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>