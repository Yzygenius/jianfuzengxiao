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
				<input type="text" name="username" placeholder="请输入姓名" autocomplete="off" class="layui-input">
				<div class="layui-input-inline">
					<select id="genderSel" name="genderSel" lay-filter="genderSel" lay-search="">
						<option value="">请选择性别</option>
						<option value="1">男</option>
						<option value="2">女</option>
			        </select>
				</div>
				<div class="layui-input-inline">
					<select id="nationSel" name="nationSel" lay-filter="nationSel" lay-search="">
						<option value="">请选择民族</option>
			        </select>
				</div>
				<div class="layui-input-inline">
					<select id="liveTypeSel" name="liveTypeSel" lay-filter="liveTypeSel" lay-search="">
						<option value="5,6,7">请选择类型</option>
			        </select>
				</div>
				<input type="text" name="idcard" placeholder="请输入身份证号" autocomplete="off" class="layui-input">
				<input type="text" name="telephone" placeholder="请输入手机号" autocomplete="off" class="layui-input">
				<button class="layui-btn" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
			</form>
		</div>
		
		<xblock style="height: 38px;">
			<!-- <button class="layui-btn layui-btn-danger" onclick="delAll()">
				<i class="layui-icon">&#xe640;</i>批量删除
			</button> -->
			<!-- <button class="layui-btn"
				onclick="banner_add('新增','/jianfuzengxiao/system/houses/toAddHousesFw.html', 820)">
				<i class="layui-icon">&#xe608;</i>添加
			</button> -->
			<button class="layui-btn" onclick="downloadExcel()">
				<i class="layui-icon">&#xe608;</i>导出Excel
			</button>
			<span id="total" class="x-right" style="line-height: 40px"></span>
		</xblock>
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
					<th>居住地址</th>
					<th>居住时间</th>
					<th>状态</th>
					<th>最新上报时间</th>
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
			<td row="leaseAddress"></td>
			<td row="leaseTime"></td>
			<td row="status"></td>
			<td row="auditTime"></td>
			<td class="td-manage">
				<button class="layui-btn layui-btn layui-btn-xs"
					onclick="banner_details(this,'查看','/jianfuzengxiao/system/per/toAuditYezhuDetail.html', 1200, 620)">
					<i class="layui-icon">&#xe615;</i>查看
				</button>
				<button class="layui-btn layui-btn layui-btn-xs" onclick="banner_edit(this,'编辑','/jianfuzengxiao/system/per/toPerEdit.html')">
					<i class="layui-icon">&#xe642;</i>编辑
				</button>
				<!-- <button class="layui-btn layui-btn layui-btn-xs"
					onclick="banner_edit(this,'编辑','/jianfuzengxiao/system/houses/toUpdateHousesFw.html', 820)">
					<i class="layui-icon">&#xe642;</i>编辑
				</button> -->
				<!-- <button class="layui-btn-danger layui-btn layui-btn-xs"
					onclick="banner_del(this)" href="javascript:;">
					<i class="layui-icon">&#xe640;</i>删除
				</button> -->
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
		var username='',  gender='', nationId='', certificatesNumber='', telephone = '';
		var keyword  = '';
		var status = '';
		var liveTypeId = '5,6,7';
		$(function() {
			layui.use([ 'laydate', 'form', 'element', 'laypage', 'layer' ], function() {
				//var total;
				$ = layui.jquery//jquery
				, form = layui.form, layer = layui.layer//弹出层
				, laydate = layui.laydate//日期插件
				, lement = layui.element//面包导航
				, laypage = layui.laypage;//分页
				//lPage = layui.laypage
				//以上模块根据需要引入
				layer.load(1);
				
				layer.ready(function() { //为了layer.ext.js加载完毕再执行

					layer.photos({
						photos : '#x-img'
					//,shift: 5 //0-6的选择，指定弹出图片动画类型，默认随机
					});

				});
				
				//加载民族
				getNationList();
				
				//加载类型
				getLiveTypeList();
				
				//监听检索
				form.on('submit(sreach)', function(data){
					//console.log(data)
					username = data.field.username;
					gender = data.field.genderSel;
					nationId = data.field.nationSel;
					liveTypeId = data.field.liveTypeSel;
					certificatesNumber = data.field.idcard;
					telephone = data.field.telephone;
					
					page()
					//loading
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
				'status': status,
				'username': username,
				'gender': gender,
				'nationId': nationId,
				'liveTypeId': liveTypeId,
				'certificatesNumber': certificatesNumber,
				'telephone': telephone
			};
			$.ajax({
				url : "/jianfuzengxiao/system/per/getPerPage.html",
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
				'page': page,
				'keyword': keyword,
				'status': status,
				'username': username,
				'gender': gender,
				'nationId': nationId,
				'liveTypeId': liveTypeId,
				'certificatesNumber': certificatesNumber,
				'telephone': telephone
			};
			$.ajax({
				url : "/jianfuzengxiao/system/per/getPerPage.html",
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
							//tr.find('[row=checkBoxId]').children().val(data[i].personnelId);
							tr.find('[row=ids]').text(data[i].personnelId);
							tr.find('[row=username]').text(data[i].username);
							if(data[i].gender == 1){
								tr.find('[row=gender]').text('男');
							}else if(data[i].gender == 2) {
								tr.find('[row=gender]').text('女');
							}else{
								tr.find('[row=gender]').text('');
							}
							tr.find('[row=nationName]').text(data[i].nationName);
							tr.find('[row=telephone]').text(data[i].telephone);
							tr.find('[row=liveTypeName]').text(data[i].liveTypeName);
							//居住时间
							/* if(data[i].liveTypeId == 1 || data[i].liveTypeId == 2 || data[i].liveTypeId == 7){//长期
								tr.find('[row=leaseTime]').text('长期');
							}else{
								tr.find('[row=leaseTime]').text(data[i].leaseStartTime+' - '+data[i].leaseStopTime);
							} */
							tr.find('[row=leaseTime]').text('长期');
							if(data[i].status == 1){
								tr.find('[row=status]').text('待审核');
							}else if(data[i].status == 2){
								tr.find('[row=status]').text('已通过审核');
							}else if(data[i].status == 3){
								tr.find('[row=status]').text('未通过审核');
							}

							//居住地址
							if(data[i].housesStatus == 1){
								tr.find('[row=leaseAddress]').text(data[i].communityName+data[i].communityStreetName+data[i].storiedBuildingNumber+'号楼'+data[i].unit+'单元'+data[i].houseNumber+'号');
							}else if(data[i].housesStatus == 2){
								if(data[i].storeLocation == 1){
									tr.find('[row=leaseAddress]').text(data[i].communityName+data[i].communityStreetName+'内铺'+data[i].houseNumber+'号');
								}else if(data[i].storeLocation == 2){
									tr.find('[row=leaseAddress]').text(data[i].communityName+data[i].communityStreetName+'外铺'+data[i].houseNumber+'号');
								}else{
									tr.find('[row=leaseAddress]').text(data[i].communityName+data[i].communityStreetName+data[i].houseNumber+'号');
								}
								
							}else{
								tr.find('[row=leaseAddress]').text('');
							}
							//最新上报时间
							tr.find('[row=auditTime]').text(data[i].updateTime);
							$('#x-img').append(tr);
							//close loading
							layer.closeAll('loading');
						}
					} else {
						layer.msg("加载数据出错，请刷新页面", {icon: 2})
					}

				},
				error : function(result) {
					layer.msg("加载数据出错，请刷新页面", {icon: 2})
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
					url : "/jianfuzengxiao/system/per/delPer.html",
					type : 'post',
					dataType : "json",
					data : {
						'personnelId' : sel
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
						layer.msg("加载数据出错，请刷新页面", {icon: 2})
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
			x_admin_show(title, url + '?personnelId=' + id, w, h);
		}
		// 编辑
		function banner_edit(obj, title, url, w, h) {
			var id = $(obj).parent('td').siblings('[row=ids]').text();
			x_admin_show(title, url + '?personnelId=' + id, w, h);
		}

		/*删除*/
		function banner_del(obj) {
			layer.confirm('确认要删除吗？', function(index) {
				var id = $(obj).parent('td').siblings('[row=ids]').text();
				$.ajax({
					url : "/jianfuzengxiao/system/per/delPer.html",
					type : 'post',
					dataType : "json",
					data : {
						'personnelId' : id
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
						layer.msg("加载数据出错，请刷新页面", {icon: 2})
					}
				});

			});
		}
		
		function getLiveTypeList(){
			$.ajax({
				url : "/jianfuzengxiao/common/getLiveTypeList.html",
				type : 'post',
				dataType : "json",
				data : {
				},
				success : function(result) {
					if (result.code == 1) {
						var str = '';
						$.each(result.data, function (index, item) {
							if(index <= 3){
								return true;
							}
							str += "<option value='" + item.liveTypeId + "'>" + item.liveTypeName + "</option>";
				        });
				        $("#liveTypeSel").append(str);
				        //append后必须从新渲染
				        form.render('select')
					} else {
						layer.msg("加载数据出错，请刷新页面", {icon :2});
					}
				},
				error : function(result) {
					layer.msg("加载数据出错，请刷新页面", {icon: 2})
				}
			});
		}
		
		function getNationList(){
			
			$.ajax({
				url : "/jianfuzengxiao/common/getNationList.html",
				type : 'post',
				dataType : "json",
				data : {
				},
				success : function(result) {
					if (result.code == 1) {
						var str = '';
						$.each(result.data, function (index, item) {
							str += "<option value='" + item.nationId + "'>" + item.nationName + "</option>";
				        });
				        $("#nationSel").append(str);
				        //append后必须从新渲染
				        form.render('select')
					} else {
						layer.msg("加载数据出错，请刷新页面", {icon : 2});
					}
				},
				error : function(result) {
					layer.msg("加载数据出错，请刷新页面", {icon: 2})
				}
			});
		}
		
		function downloadExcel(){
			
			var param = "?status="+status+"&username="+username+"&gender="+gender+"&nationId="+nationId+"&liveTypeId="+liveTypeId+"&certificatesNumber="+certificatesNumber+"&telephone="+telephone;

			location.href = "/jianfuzengxiao/system/common/downloadPerExcel.html" + param; 
			
		}
	</script>
</body>
</html>