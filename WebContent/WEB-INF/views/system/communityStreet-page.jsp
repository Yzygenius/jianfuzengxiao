<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>X-admin v1.0</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet"
	href="/jianfuzengxiao/statics/system/css/xadmin.css" media="all">
<style>
.yincang {
	display: none;
}
</style>
</head>
<body>
	<div class="x-nav">
		<span class="layui-breadcrumb"><!--  <a><cite>首页</cite></a> <a><cite>关于我们</cite></a> -->
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="layui-icon" style="line-height: 30px">&#xe666;</i></a>
	</div>
	<div class="x-body">
		<xblock>
		<button class="layui-btn layui-btn-danger" onclick="delAll()">
			<i class="layui-icon">&#xe640;</i>批量删除
		</button>
		<button class="layui-btn"
			onclick="banner_add('新增','/jianfuzengxiao/system/communityStreet/toAddCommunityStreet.html', 780, 520)">
			<i class="layui-icon">&#xe608;</i>添加
		</button>
		<span id="total" class="x-right" style="line-height: 40px"></span></xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th><input type="checkbox" value="" name="" id="checkAll"
						onclick="checkAll(this)"></th>
					<th>排序</th>
					<th>小区街道名称</th>
					<th>类别</th>
					<th>社区名称</th>
					<th>创建时间</th>
					<th>更新时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="x-img">

			</tbody>
		</table>

		<div id="page"></div>
	</div>

	<table id="clone-tr" style="display: none;">
		<tr>
			<td row="checkBoxId"><input type="checkbox" class="checkId"
				value="" name=""></td>
			<td row="ids" style="display: none;"></td>
			<td row="listOrder"></td>
			<td row="communityStreetName">
			<td row="status">
			<td row="communityName">
				<!-- <div style="width:200px;height:22px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap"></div> -->
			</td>
			<td row="createTime"></td>
			<td row="updateTime"></td>
			<td class="td-manage">
				<button class="layui-btn layui-btn layui-btn-xs"
					onclick="banner_details(this,'查看','/jianfuzengxiao/system/communityStreet/toCommunityStreetDetail.html', 1000, 620)">
					<i class="layui-icon">&#xe615;</i>查看
				</button>
				<button class="layui-btn layui-btn layui-btn-xs"
					onclick="banner_edit(this,'编辑','/jianfuzengxiao/system/communityStreet/toUpdateCommunityStreet.html', 780, 520)">
					<i class="layui-icon">&#xe642;</i>编辑
				</button>
				<button class="layui-btn-danger layui-btn layui-btn-xs"
					onclick="banner_del(this)" href="javascript:;">
					<i class="layui-icon">&#xe640;</i>删除
				</button>
			</td>
		</tr>
	</table>

	<script type="text/javascript"
		src="/jianfuzengxiao/statics/system/js/jquery.min.js"></script>
	<script src="/jianfuzengxiao/statics/system/lib/layui/layui.js"
		charset="utf-8"></script>
	<script src="/jianfuzengxiao/statics/system/js/xadmin.js"
		charset="utf-8"></script>

	<script>
		//var lPage;
		var $, form, layer, laydate, lement, laypage;
		$(function() {
			layui.use([ 'laydate', 'form', 'element', 'laypage', 'layer' ],
					function() {
						//var total;
						$ = layui.jquery//jquery
						, form = layui.form, layer = layui.layer//弹出层
						, laydate = layui.laydate//日期插件
						, lement = layui.element//面包导航
						, laypage = layui.laypage;//分页
						//lPage = layui.laypage
						//以上模块根据需要引入
						//loading
						layer.load(1)
						//加载数据
						page();

						layer.ready(function() { //为了layer.ext.js加载完毕再执行

							layer.photos({
								photos : '#x-img'
							//,shift: 5 //0-6的选择，指定弹出图片动画类型，默认随机
							});

						});

					});
		});

		//分页
		function page() {
			$.ajax({
				url : "/jianfuzengxiao/system/communityStreet/getCommunityStreetPage.html",
				type : 'post',
				dataType : "json",
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
					}
				}
			})
		}

		function checkAll(obj) {
			if ($(obj).prop('checked')) {
				$('.checkId').prop('checked', true)
			} else {
				$('.checkId').prop('checked', false)
			}
		}

		function serchData(page) {

			var data = {
				'page' : page,
			};
			$.ajax({
				url : "/jianfuzengxiao/system/communityStreet/getCommunityStreetPage.html",
				type : 'post',
				dataType : "json",
				data : data,
				success : function(result) {
					if (result.code == 1) {
						$('#total').text('共有数据：' + result.data.total + '条');

						$('#x-img').html('');
						var data = result.data.rows;
						for (var i = 0; i < data.length; i++) {
							var tr = $('#clone-tr').find('tr').clone();
							tr.find('[row=checkBoxId]').children().val(data[i].communityStreetId);
							tr.find('[row=ids]').text(data[i].communityStreetId);
							tr.find('[row=listOrder]').text(data[i].listOrder);
							tr.find('[row=communityStreetName]').text(data[i].communityStreetName);
							if(data[i].status == 1){
								tr.find('[row=status]').text('小区');
							}else if(data[i].status == 2){
								tr.find('[row=status]').text('街道');
							}else{
								tr.find('[row=status]').text('其他');
							}
							
							tr.find('[row=communityName]').text(data[i].communityName);
							tr.find('[row=createTime]').text(data[i].createTime);
							tr.find('[row=updateTime]').text(data[i].updateTime);

							$('#x-img').append(tr);
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
		//批量删除提交
		function delAll() {
			layer.confirm('确认要删除吗？', function(index) {
				var arr = new Array();
				$('.checkId:checked').each(function(i, obj) {
					arr[i] = $(obj).val();
				})
				var sel = arr.join(",");
				$.ajax({
					url : "/jianfuzengxiao/system/communityStreet/delCommunityStreet.html",
					type : 'post',
					dataType : "json",
					data : {
						'communityStreetId' : sel
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
						layer.msg("加载数据出错，请刷新页面", {icon : 2})
					}
				});
			});
		}
		/*添加*/
		function banner_add(title, url, w, h) {

			x_admin_show(title, url, w, h);
		}
		function banner_details(obj, title, url, w, h) {
			var id = $(obj).parent('td').siblings('[row=ids]').text();
			x_admin_show(title, url + '?communityStreetId=' + id, w, h);
		}
		// 编辑
		function banner_edit(obj, title, url, w, h) {
			var id = $(obj).parent('td').siblings('[row=ids]').text();
			x_admin_show(title, url + '?communityStreetId=' + id, w, h);
		}

		/*删除*/
		function banner_del(obj) {
			layer.confirm('确认要删除吗？', function(index) {
				var id = $(obj).parent('td').siblings('[row=ids]').text();
				$.ajax({
					url : "/jianfuzengxiao/system/communityStreet/delCommunityStreet.html",
					type : 'post',
					dataType : "json",
					data : {
						'communityStreetId' : id
					},
					success : function(result) {
						if (result.code == 1) {
							page();
							serchData();
							layer.msg('删除成功', {icon : 1});
						} else {
							layer.msg(result.msg, {icon : 7});
						}
					},
					error : function(result) {
						layer.msg("加载数据出错，请刷新页面", {icon : 2})
					}
				});

			});
		}
	</script>
</body>
</html>