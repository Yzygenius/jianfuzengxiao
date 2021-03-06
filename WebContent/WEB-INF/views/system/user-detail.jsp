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
		    	<td class="title">身份信息</td>
		  	</tr>
		  	<tr>
		    	<td>&nbsp;</td>
		  	</tr>
		  	<tr>
		    	<td><span>姓名：</span>${user.username }</td>
		  	</tr>
		  	<c:if test="${user.gender == 1}">
			  	<tr>
			    	<td>性别：男</td>
			  	</tr>
		  	</c:if>
		  	<c:if test="${user.gender == 2}">
			  	<tr>
			    	<td>性别：女</td>
			  	</tr>
		  	</c:if>
		  	<c:if test="${user.gender == '' || user.gender == null}">
			  	<tr>
			    	<td>性别：</td>
			  	</tr>
		  	</c:if>
		  	<tr>
		    	<td>年龄：${user.age }岁（${user.birthDate }）</td>
		  	</tr>
		  	<tr>
		    	<td>民族：${user.nationName }</td>
		  	</tr>
		  	<tr>
		    	<td style="height: 120px;">人脸照片：<img onclick="opneimg(this)" src="${user.facePhoto }"/></td>
		  	</tr>
		  	<tr>
		    	<td style="height: 120px;">联系电话：${user.telephone }</td>
		  	</tr>
		  	<tr>
		    	<td>证件正面：<img onclick="opneimg(this)" src="${user.certificatesPositivePhoto }"/></td>
		  	</tr>
		  	<tr>
		    	<td>证件反面：<img onclick="opneimg(this)" src="${user.certificatesNegativePhoto }"/></td>
		  	</tr>
		  	<tr>
		    	<td>证件号码：${user.certificatesNumber }</td>
		  	</tr>
		  	<tr>
		    	<td>证件时效：${user.certificatesStartTime } - ${user.certificatesStopTime }</td>
		  	</tr>
		  	<tr>
		    	<td>证件地址：${user.certificatesAddress }</td>
		  	</tr>
		  	<tr>
		    	<td>办证机关：${user.certificatesOffice }</td>
		  	</tr>
		  	<c:if test="${user.status == 1 }">
			  	<tr>
			    	<td>状态：待审核</td>
			  	</tr>
		  	</c:if>
		  	<c:if test="${user.status == 2 }">
			  	<tr>
			    	<td>状态：已通过审核</td>
			  	</tr>
		  	</c:if>
		  	<c:if test="${user.status == 3 }">
			  	<tr>
			    	<td>状态：未通过审核</td>
			  	</tr>
		  	</c:if>
		  	<c:if test="${user.status == '' ||  user.status == null}">
			  	<tr>
			    	<td>状态： </td>
			  	</tr>
		  	</c:if>
		  	<tr>
		    	<td>&nbsp;</td>
		  	</tr>
		  	<tr>
		    	<td>上报时间：${user.createTime }</td>
		  	</tr>
		  	<c:if test="${user.updateTime == null || user.updateTime == '' }">
			  	<tr>
			    	<td>最新上报时间：${user.createTime }</td>
			  	</tr>
		  	</c:if>
		  	<c:if test="${user.updateTime != null && user.updateTime != '' }">
			  	<tr>
			    	<td>最新上报时间：${user.updateTime }</td>
			  	</tr>
		  	</c:if>
		</tbody>
	</table>

	
	<c:if test="${user.status == 1 ||  user.status == 3}">
		<form class="layui-form" action="">
			<div class="layui-form-item">
				<label class="layui-form-label" style="text-align: left;padding: 9px 0 9px 30px;font-size:16px;font-weight: bold;">审核</label>
				<div class="layui-input-block" style="font-size:16px;font-weight: bold;">
					<c:if test="${user.status == 1}">
						<input type="radio" name="audit" lay-filter="ra" value="2" title="通过" checked >
						<input type="radio" name="audit" lay-filter="ra" value="3" title="驳回" >
					</c:if>
					<c:if test="${user.status == 3}">
						<input type="radio" name="audit" lay-filter="ra" value="2" title="通过" >
						<input type="radio" name="audit" lay-filter="ra" value="3" title="驳回" checked >
					</c:if>
				</div>
			</div>
			<c:if test="${user.status == 1}">
				<div id="desc" class="layui-form-item layui-form-text" style="display: none;">
				    <label class="layui-form-label" style="text-align: left;padding: 9px 0 9px 30px;font-size:16px;font-weight: bold;">驳回原因</label>
				    <div class="layui-input-block">
				      <textarea name="desc" placeholder="请输入内容，1000字符以内" class="layui-textarea" maxlength="1000"></textarea>
				    </div>
				</div>
			</c:if>
			<c:if test="${user.status == 3}">
				<div id="desc" class="layui-form-item layui-form-text">
				    <label class="layui-form-label" style="text-align: left;padding: 9px 0 9px 30px;font-size:16px;font-weight: bold;">驳回原因</label>
				    <div class="layui-input-block">
				      <textarea name="desc" placeholder="请输入内容，1000字符以内" class="layui-textarea" maxlength="1000">${user.auditRemark }</textarea>
				    </div>
				</div>
			</c:if>
			<div class="layui-form-item">
		    	<div class="layui-input-block">
		      		<button class="layui-btn" lay-submit lay-filter="formDemo">提交</button>
		    	</div>
		  	</div>
		</form>
	</c:if>
	<script type="text/javascript" src="/jianfuzengxiao/statics/system/js/jquery.min.js"></script>
	<script src="/jianfuzengxiao/statics/system/lib/layui/layui.js" charset="utf-8"></script>
	<script src="/jianfuzengxiao/statics/system/js/xadmin.js" charset="utf-8"></script>
	<script type="text/javascript">
		var userId = '${user.userId }'
		var $, form, layer;
		layui.use(['form', 'layer' ], function() {
			$ = layui.jquery//jquery
			, form = layui.form
			, layer = layui.layer;//弹出层
			
			form.on('radio(ra)', function(data){
				if(data.value == 3){
					$('#desc').show();
				}else if(data.value == 2){
					$('#desc').hide();
				}
				return false;
			})
		
			form.on('submit(formDemo)', function(data){
				
				if(data.field.audit == 3 && data.field.desc.replace(/\s+/g,"") == ''){
					layer.msg('请填写驳回原因', {
						icon : 7
					});
					return false;
				}
				var data = {
					'userId': userId,
					'status': data.field.audit,
					'auditRemark': data.field.desc
				};
				$.ajax({
					url : "/jianfuzengxiao/system/user/auditUser.html",
					type : 'post',
					dataType : "json",
					data: data,
					success : function(result) {
						if (result.code == 1) {
							layer.msg('审核成功', {icon : 1}, function () {
					            // 获得frame索引
					            var index = parent.layer.getFrameIndex(window.name);
					            //关闭当前frame
					            parent.layer.close(index);
					            window.parent.location.reload();
							});
						} else {
							layer.msg(result.msg, {
								icon : 2
							});
						}
					}
				})
				return false;
			})
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