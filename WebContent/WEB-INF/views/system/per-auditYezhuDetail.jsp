<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
	
	<form class="layui-form" action="">
		<div class="layui-form-item">
			<label class="layui-form-label">审核</label>
			<div class="layui-input-inline">
				<input type="radio" name="audit" lay-filter="ra" value="2" title="通过" checked>
				<input type="radio" name="audit" lay-filter="ra" value="3" title="驳回">
			</div>
		</div>
		<div id="desc" class="layui-form-item layui-form-text" style="display: none;">
		    <label class="layui-form-label">驳回原因</label>
		    <div class="layui-input-inline">
		      <textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>
		    </div>
		</div>
		<div class="layui-form-item">
	    	<div class="layui-input-block">
	      		<button class="layui-btn" lay-submit lay-filter="formDemo">提交</button>
	    	</div>
	  	</div>
	</form>
	
	<script type="text/javascript" src="/jianfuzengxiao/statics/system/js/jquery.min.js"></script>
	<script src="/jianfuzengxiao/statics/system/lib/layui/layui.js" charset="utf-8"></script>
	<script src="/jianfuzengxiao/statics/system/js/xadmin.js" charset="utf-8"></script>
	<script type="text/javascript">
		var personnelId = ${per.personnelId }
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
					'personnelId': personnelId,
					'status': data.field.audit,
					'auditRemark': data.field.desc
				};
				$.ajax({
					url : "/jianfuzengxiao/system/per/auditPer.html",
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
	</script>
</body>
</html>