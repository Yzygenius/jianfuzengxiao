<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>admin</title>
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
		<div class="layui-row">
			<form class="layui-form layui-col-md12 x-so">
				<input type="text" name="keyword" style="width: 190px;" placeholder="请输入用户名/姓名/手机号" autocomplete="off" class="layui-input">
				<button class="layui-btn" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
			</form>
		</div>
		
		<xblock>
			<button class="layui-btn layui-btn-danger" onclick="delAll()">
				<i class="layui-icon">&#xe640;</i>批量删除
			</button>
			<button class="layui-btn"
				onclick="banner_add('添加','/jianfuzengxiao/system/admin/toAddAdmin.html', 460, 410)">
				<i class="layui-icon">&#xe608;</i>添加
			</button>
			<span id="total" class="x-right" style="line-height: 40px"></span>
		</xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th><input type="checkbox" value="" name="" id="checkAll"
						onclick="checkAll(this)"></th>
					<th>用户名</th>
					<th>姓名</th>
					<th>电话</th>
					<th>微信</th>
					<th>管辖社区</th>
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
			<td row="loginName"></td>
			<td row="username">
				<!-- <div style="width:200px;height:22px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap"></div> -->
			</td>
			<td row="telephone"></td>
			<td row="wxAccountNumber"></td>
			<td row="count"></td>
			<!-- <td row="username"></td>
			<td row="adminTelephone"></td>
			<td row="leaseCount"></td> -->
			<td class="td-manage">
				<!-- <button class="layui-btn layui-btn layui-btn-xs"
					onclick="banner_details(this,'查看','/jianfuzengxiao/system/admin/toAdminDetail.html')">
					<i class="layui-icon">&#xe615;</i>查看
				</button> -->
				
				<button class="layui-btn layui-btn layui-btn-xs" onclick="banner_manageHouses(this)">
					<i class="layui-icon">&#xe615;</i>管辖社区
				</button>
				<button class="layui-btn layui-btn layui-btn-xs"
					onclick="banner_edit(this,'编辑','/jianfuzengxiao/system/admin/toUpdateAdmin.html', 460, 370)">
					<i class="layui-icon">&#xe642;</i>编辑
				</button>
				<button class="layui-btn layui-btn layui-btn-xs"
					onclick="banner_edit(this,'重置密码','/jianfuzengxiao/system/admin/toResetPwd.html', 460, 370)">
					<i class="layui-icon">&#xe642;</i>重置密码
				</button>
				<button class="layui-btn-danger layui-btn layui-btn-xs"
					onclick="banner_del(this)" href="javascript:;">
					<i class="layui-icon">&#xe640;</i>删除
				</button>
			</td>
		</tr>
	</table>

	<script type="text/javascript" src="/jianfuzengxiao/statics/system/js/jquery.min.js"></script>
	<script src="/jianfuzengxiao/statics/system/lib/layui/layui.js" charset="utf-8"></script>
	<script type="text/javascript" src="/jianfuzengxiao/statics/system/js/xadmin.js" charset="utf-8"></script>

	<script>
		//var lPage;
		var $, form, layer, laydate, element, laypage;
		var keyword  = '';
		$(function() {
			layui.use([ 'laydate', 'form', 'element', 'laypage', 'layer' ], function() {
				//var total;
				$ = layui.jquery//jquery
				, form = layui.form, layer = layui.layer//弹出层
				, laydate = layui.laydate//日期插件
				, element = layui.element//面包导航
				, laypage = layui.laypage;//分页
				//lPage = layui.laypage
				//以上模块根据需要引入
				//loading..
				layer.load(1)
				layer.ready(function() { //为了layer.ext.js加载完毕再执行

					layer.photos({
						photos : '#x-img'
					//,shift: 5 //0-6的选择，指定弹出图片动画类型，默认随机
					});

				});
				
				//监听检索
				form.on('submit(sreach)', function(data){
					
					keyword = data.field.keyword;
					
					page()
					//loading..
					layer.load(1)
			      	return false;
			    });
				
				/*加载页面数据*/
				page();
				
			});
			
		});

		//分页
		function page() {
			var data = {
				'keyword': keyword,
				'roleId': 3
			};
			$.ajax({
				url : "/jianfuzengxiao/system/admin/getAdminPage.html",
				type : 'post',
				dataType : "json",
				data: data,
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
				'keyword': keyword,
				'roleId': 3
			};
			$.ajax({
				url : "/jianfuzengxiao/system/admin/getAdminPage.html",
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
							tr.find('[row=checkBoxId]').children().val(data[i].adminId);
							tr.find('[row=ids]').text(data[i].adminId);
							tr.find('[row=loginName]').text(data[i].loginName);
							tr.find('[row=username]').text(data[i].username);
							tr.find('[row=telephone]').text(data[i].telephone);
							tr.find('[row=wxAccountNumber]').text(data[i].wxName);
							tr.find('[row=count]').text(data[i].manageCommunityCount);
							$('#x-img').append(tr);
							//close loading
							layer.closeAll('loading');
						}
					} else {
						layer.msg("加载数据出错，请刷新页面", {icon : 7})
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
				layer.load(1)
				var arr = new Array();
				$('.checkId:checked').each(function(i, obj) {
					arr[i] = $(obj).val();
				})
				var sel = arr.join(",");
				$.ajax({
					url : "/jianfuzengxiao/system/admin/delAdmin.html",
					type : 'post',
					dataType : "json",
					data : {
						'adminId' : sel
					},
					success : function(result) {
						if (result.code == 1) {
							layer.msg('删除成功', {icon : 1});
							page();
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
		function banner_details(obj, title, url) {
			var id = $(obj).parent('td').siblings('[row=ids]').text();
			x_admin_show(title, url + '?housesId=' + id);
		}
		// 编辑
		function banner_edit(obj, title, url, w, h) {
			var id = $(obj).parent('td').siblings('[row=ids]').text();
			x_admin_show(title, url + '?adminId=' + id, w, h);
		}
		
		//管辖房屋
		function banner_manageHouses(obj){
			var id = $(obj).parent('td').siblings('[row=ids]').text();
			var username = $(obj).parent('td').siblings('[row=username]').text();
			window.parent.x_admin_open_ifram('/jianfuzengxiao/system/lgzg/toManagePage.html?adminId='+id, username+'：管辖社区', 200)
		}

		/*删除*/
		function banner_del(obj) {
			layer.confirm('确认要删除吗？', function(index) {
				layer.load(1)
				var id = $(obj).parent('td').siblings('[row=ids]').text();
				$.ajax({
					url : "/jianfuzengxiao/system/admin/delAdmin.html",
					type : 'post',
					dataType : "json",
					data : {
						'adminId' : id
					},
					success : function(result) {
						if (result.code == 1) {
							layer.msg('删除成功', {icon : 1});
							page();
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