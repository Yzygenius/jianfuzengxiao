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
				
				<div class="layui-input-inline">
					<select id="province" name="province" lay-filter="province" lay-search="">
						<option value="">请选择省</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<select id="city" name="city" lay-filter="city" lay-search="">
						<option value="">请选择市</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<select id="area" name="area" lay-filter="area" lay-search="">
						<option value="">请选择县/区</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<select id="communitySel" name="communitySel" lay-filter="communitySel" lay-search="">
						<option value="">请选择社区</option>
			        </select>
				</div>
				<div class="layui-input-inline">
					<select id="communityStreetSel" name="communityStreetSel" lay-filter="communityStreetSel" lay-search="">
						<option value="">请选择小区</option>
			        </select>
				</div>
				<input type="text" name="storiedBuildingNumber" placeholder="请输入楼号" autocomplete="off" class="layui-input">
				<input type="text" name="unit" placeholder="请输入单元号" autocomplete="off" class="layui-input">
				<input type="text" name="houseNumber" placeholder="请输入门牌号" autocomplete="off" class="layui-input">
				<input type="text" name="keyword" placeholder="姓名/手机号/身份证号" autocomplete="off" class="layui-input">
				<button class="layui-btn" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
			</form>
		</div>
		
		<xblock>
			<button class="layui-btn layui-btn-danger" onclick="delAll()">
				<i class="layui-icon">&#xe640;</i>批量删除
			</button>
			<button class="layui-btn"
				onclick="banner_add('新增','/jianfuzengxiao/system/houses/toAddHousesFw.html', 820)">
				<i class="layui-icon">&#xe608;</i>添加
			</button>
			<button type="button" class="layui-btn" id="uploadExcel"><i class="layui-icon">&#xe608;</i>excel导入</button>
			<button type="button" class="layui-btn" onclick="banner_download()"><i class="layui-icon">&#xe608;</i>excel导入</button>
			<span id="total" class="x-right" style="line-height: 40px"></span>
		</xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th><input type="checkbox" value="" name="" id="checkAll"
						onclick="checkAll(this)"></th>
					<th>社区</th>
					<th>小区</th>
					<th>楼号</th>
					<th>单元</th>
					<th>门牌号</th>
					<th>包户干部</th>
					<th>干部电话</th>
					<th>居住人数</th>
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
			<td row="communityName"></td>
			<td row="communityStreetName">
				<!-- <div style="width:200px;height:22px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap"></div> -->
			</td>
			<td row="storiedBuildingNumber"></td>
			<td row="unit"></td>
			<td row="houseNumber"></td>
			<td row="username"></td>
			<td row="adminTelephone"></td>
			<td row="leaseCount"></td>
			<td class="td-manage">
				<button class="layui-btn layui-btn layui-btn-xs"
					onclick="banner_details(this,'查看','/jianfuzengxiao/system/houses/toHousesFwDetail.html', 1000, 620)">
					<i class="layui-icon">&#xe615;</i>查看
				</button>
				<button class="layui-btn layui-btn layui-btn-xs"
					onclick="banner_edit(this,'编辑','/jianfuzengxiao/system/houses/toUpdateHousesFw.html', 820)">
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
		var $, form, layer, laydate, lement, laypage, upload;
		var provinceList, cityList, areaList = "";
		var provCode = ''
		var cityCode = ''
		var areaCode = ''
		var communityId = ''
		var communityStreetId = ''
		var storiedBuildingNumber = ''
		var unit = ''
		var keyword  = '';
		var houseNumber = '';
		var provCodeSreach, cityCodeSreach, areaCodeSreach, communityIdSreach, communityStreetIdSreach, storiedBuildingNumberSreach, unitSreach, houseNumberSreach, keywordSreach = '';
		$(function() {
			layui.use([ 'laydate', 'form', 'element', 'laypage', 'layer' ,'upload'], function() {
				//var total;
				$ = layui.jquery//jquery
				, form = layui.form
				, layer = layui.layer//弹出层
				, laydate = layui.laydate//日期插件
				, lement = layui.element//面包导航
				, upload = layui.upload
				, laypage = layui.laypage;//分页
				//lPage = layui.laypage
				//以上模块根据需要引入
				//loading
				layer.load(1)
				layer.ready(function() { //为了layer.ext.js加载完毕再执行

					layer.photos({
						photos : '#x-img'
					//,shift: 5 //0-6的选择，指定弹出图片动画类型，默认随机
					});

				});
				
				//导入excel
				upload.render({
		        	elem: '#uploadExcel',
		            url: '/jianfuzengxiao/system/common/uploadExcel.html', //上传接口
		            accept: 'file', //普通文件
		            data: {},
		            before: function(obj){
		                //loading
		                layer.load(1)
		            },
		            done: function(res){ //上传成功后的回调
		            	if(res.code==1){
		            		layer.msg('导入成功', {icon: 1})
							page();
		            	}else{
		            		layer.msg('导入失败，请重新操作', {icon: 2})
		            	}
		            }
		            ,error: function(){
		            	layer.msg('导入失败，请重新操作', {icon: 2});
		            }
		        });
				
				//监听检索
				form.on('submit(sreach)', function(data){
					//console.log(data)
					provCodeSreach = data.field.province;
					cityCodeSreach = data.field.city;
					areaCodeSreach = data.field.area;
					communityIdSreach = data.field.communitySel;
					communityStreetIdSreach = data.field.communityStreetSel;
					storiedBuildingNumberSreach = data.field.storiedBuildingNumber;
					unitSreach = data.field.unit;
					houseNumberSreach = data.field.houseNumber;
					keywordSreach = data.field.keyword;
					
					page()
					//loading
					layer.load(1)
			      	return false;
			    });
				
				/*加载页面数据*/
				page();
				
				/*加载社区下拉*/
				serchCommunity()
				
				/*加载小区下拉*/
				serchCommunityStreet()
				
				/*加载省市区*/
				serchArea()
				
				//监听省下拉框
		        form.on('select(province)', function(data){
		        	//provName = data.elem[data.elem.selectedIndex].text;
		        	provCode = data.value;
		        	$.each(provinceList, function (index, item) {
						if(item.code == data.value){
							cityList = item.childList;
						}
			        });
			        //移除城市下拉框所有选项
			        $("#city").empty();
			        var cityHtml = '<option value="">请选择市</option>';
			        $("#city").html(cityHtml);
			        var areaHtml = '<option value="">请选择县/区</option>';
			        $("#area").html(areaHtml);
			        var str = '';
			        $.each(cityList, function (index, item) {
		               	str += "<option value='" + item.code + "'>" + item.name + "</option>";
		            });
			        $("#city").append(str);
			      	//append后必须从新渲染
		            form.render('select');
			      	
		            serchCommunity();
		        });
		      	
		     	//监听市下拉框
		        form.on('select(city)', function(data){
		        	//cityName = data.elem[data.elem.selectedIndex].text;
		        	cityCode = data.value;
		        	
		        	$.each(cityList, function (index, item) {
						if(item.code == data.value){
							areaList = item.childList;
						}
			        });
			        //移除城区下拉框所有选项
			        $("#area").empty();
			        var areaHtml = '<option value="">请选择县/区</option>';
			        $("#area").html(areaHtml);
			        var str = '';
			        $.each(areaList, function (index, item) {
		               	str += "<option value='" + item.code + "'>" + item.name + "</option>";
		            });
			        $("#area").append(str);
			      	//append后必须从新渲染
		            form.render('select');
			      	
		            serchCommunity();
		        });
		     	
		      	//监听区/县
		        form.on('select(area)', function(data){
		        	//areaName = data.elem[data.elem.selectedIndex].text;
		        	areaCode = data.value;
		        	
		        	serchCommunity();
		        });
		      	
		      	//监听社区
		        form.on('select(communitySel)', function(data){
		        	//communityName = data.elem[data.elem.selectedIndex].text;
		        	communityId = data.value;
		        	
		        	serchCommunityStreet();
		        });
		      
		      	//监听社区
		        form.on('select(communityStreetSel)', function(data){
		        	//communityStreetName = data.elem[data.elem.selectedIndex].text;
		        	communityStreetId = data.value;
		        	
		        });
			});
			
		});
		
		function serchArea(){
			$.ajax({  
				url : "/jianfuzengxiao/common/getAreaList.html",  
				type : 'post',
				dataType: "json",
				data: {
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
		
	    /* 社区加载 */
	    function serchCommunity(){
	    	$.ajax({  
				url : "/jianfuzengxiao/system/community/getCommunityList.html",  
				type : 'post',
				dataType: "json",
				data: {
					'provCode': provCode,
					'cityCode': cityCode,
					'areaCode': areaCode
				},
				success : function(result){
					if(result.code == 1){
						$('#communitySel').html('');
						var str = '<option value="">请选择社区</option>';
						for(var i=0;i<result.data.length;i++){
							str += '<option value="'+result.data[i].communityId+'">'+result.data[i].communityName+'</option>'
						}
						$('#communitySel').append(str);
						form.render('select');
					}
				},
				error : function(result){
					layer.msg("数据加载出错，请刷新页面", {icon: 2})
				}
			})
	    }
	    
	    /* 小区或街道加载 */
	    function serchCommunityStreet(){
	    	$.ajax({  
				url : "/jianfuzengxiao/system/communityStreet/getCommunityStreetList.html",  
				type : 'post',
				dataType: "json",
				data: {
					'communityId': communityId,
				},
				success : function(result){
					if(result.code == 1){
						$('#communityStreetSel').html('');
						var str = '<option value="">请选择小区</option>';
						for(var i=0;i<result.data.length;i++){
							str += '<option value="'+result.data[i].communityStreetId+'">'+result.data[i].communityStreetName+'</option>'
						}
						$('#communityStreetSel').append(str);
						form.render('select');
					}
				},
				error : function(result){
					layer.msg("数据加载出错，请刷新页面", {icon: 2})
				}
			})
	    }
	   
		//分页
		function page() {
			var data = {
				'housesStatus': '1',
				'provCode': provCodeSreach,
				'cityCode': cityCodeSreach,
				'areaCode': areaCodeSreach,
				'communityId': communityIdSreach,
				'communityStreetId': communityStreetIdSreach,
				'storiedBuildingNumber': storiedBuildingNumberSreach,
				'unit': unitSreach,
				'houseNumber': houseNumberSreach,
				'keyword': keywordSreach
			};
			$.ajax({
				url : "/jianfuzengxiao/system/houses/getHousesPage.html",
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
				'housesStatus': '1',
				'provCode': provCodeSreach,
				'cityCode': cityCodeSreach,
				'areaCode': areaCodeSreach,
				'communityId': communityIdSreach,
				'communityStreetId': communityStreetIdSreach,
				'storiedBuildingNumber': storiedBuildingNumberSreach,
				'unit': unitSreach,
				'houseNumber': houseNumberSreach,
				'keyword': keywordSreach
			};
			$.ajax({
				url : "/jianfuzengxiao/system/houses/getHousesPage.html",
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
							tr.find('[row=checkBoxId]').children().val(
									data[i].housesId);
							tr.find('[row=ids]').text(data[i].housesId);
							tr.find('[row=communityName]').text(data[i].communityName);
							tr.find('[row=communityStreetName]').text(data[i].communityStreetName);
							tr.find('[row=storiedBuildingNumber]').text(data[i].storiedBuildingNumber);
							tr.find('[row=unit]').text(data[i].unit);
							tr.find('[row=houseNumber]').text(data[i].houseNumber);
							tr.find('[row=username]').text(data[i].username);
							tr.find('[row=adminTelephone]').text(data[i].adminTelephone);
							tr.find('[row=leaseCount]').text(data[i].leaseCount);

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
					url : "/jianfuzengxiao/system/houses/delHouses.html",
					type : 'post',
					dataType : "json",
					data : {
						'housesId' : sel
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
		/*导出excel*/
		function banner_download() {
			var param = "?housesStatus=1&provCode="+provCodeSreach+"&cityCode="+cityCodeSreach+"&areaCode="+areaCodeSreach+"&communityId="+communityIdSreach
				+ "&communityStreetId="+communityStreetIdSreach+"&storiedBuildingNumberSreach="+storiedBuildingNumber+"&unit="+unitSreach
				+ "&houseNumber="+houseNumberSreach+"&keyword="+keywordSreach;
			location.href = "/jianfuzengxiao/system/common/downloadExcel.html" + param; 
		}
		/*添加*/
		function banner_add(title, url, w, h) {

			x_admin_show(title, url, w, h);
		}
		function banner_details(obj, title, url, w, h) {
			var id = $(obj).parent('td').siblings('[row=ids]').text();
			x_admin_show(title, url + '?housesId=' + id, w, h);
		}
		// 编辑
		function banner_edit(obj, title, url, w, h) {
			var id = $(obj).parent('td').siblings('[row=ids]').text();
			x_admin_show(title, url + '?housesId=' + id, w, h);
		}

		/*删除*/
		function banner_del(obj) {
			layer.confirm('确认要删除吗？', function(index) {
				var id = $(obj).parent('td').siblings('[row=ids]').text();
				$.ajax({
					url : "/jianfuzengxiao/system/houses/delHouses.html",
					type : 'post',
					dataType : "json",
					data : {
						'housesId' : id
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
	</script>
</body>
</html>