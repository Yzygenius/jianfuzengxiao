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
<link rel="stylesheet" href="/tchyuanlin/statics/system/css/xadmin.css"
	media="all">
<style>
.yincang {
	display: none;
}
</style>
</head>
<body>
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a><cite>首页</cite></a> <a><cite>关于我们</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="layui-icon" style="line-height: 30px">&#xe666;</i></a>
	</div>
	<div class="x-body">
		<xblock>
		<!-- <button class="layui-btn layui-btn-danger" onclick="delAll()">
			<i class="layui-icon">&#xe640;</i>批量删除
		</button> -->
		<div id="visitSumCount" style="width:113px; height:38px;display: inline-block; line-height: 38px;">总访问量：</div>
		<span id="total" class="x-right" style="line-height: 40px"></span></xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>IP</th>
					<th>地址1</th>
					<th>地址2</th>
					<th>地址3</th>
					<th>访问次数</th>
					<th>初次访问时间</th>
					<th>最后访问时间</th>
				</tr>
			</thead>
			<tbody id="x-img">
				
			</tbody>
		</table>

		<div id="page"></div>
	</div>
	
	<table id="clone-tr" style="display:none;">
		<tr>
			<td row="visitIp"></td>
			<td row="visitAddress1"></td>
			<td row="visitAddress2"></td>
			<td row="visitAddress3"></td>
			<!-- <td row="message"><div style="width:200px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap"></div></td> -->
			<td row="visitCount"></td>
			<td row="createTime"></td>
			<td row="updateTime"></td>
		</tr>
	</table>

	<script type="text/javascript"
		src="/tchyuanlin/statics/system/js/jquery.min.js"></script>
	<script src="/tchyuanlin/statics/system/lib/layui/layui.js" charset="utf-8"></script>
	<script src="/tchyuanlin/statics/system/js/xadmin.js" charset="utf-8"></script>

<script>
$(function () {
    layui.use(['laydate','form','element','laypage','layer'], function(){
    	var total;
      var $ = layui.jquery//jquery
      ,form = layui.form
      ,layer = layui.layer//弹出层
      ,laydate = layui.laydate//日期插件
      ,lement = layui.element//面包导航
      ,laypage = layui.laypage;//分页

      //以上模块根据需要引入
      
      $.ajax({  
		  url : "/tchyuanlin/system/visitor/getVisitorPage.html",  
		  type : 'post',
		  dataType: "json",
		  success : function(result){
			  laypage.render({
				  elem: 'page'
     			  ,count: result.total
   	              ,jump: function(obj){
   				     serchData(obj.curr)
   			     }
     	      })
		  }
	  })
      
    });
    
	  //总数
	  $.ajax({  
		  url : "/tchyuanlin/system/visitor/getVisitorCount.html",  
		  type : 'post',
		  dataType: "json",
		  success : function(result){
			  $('#visitSumCount').text('').text('总访问量：'+result);
		  }
	  })
});
    
    function checkAll(obj){
    	if($(obj).prop('checked')){
    		$('.checkId').prop('checked', true)
    	}else{
    		$('.checkId').prop('checked', false)
    	}
    }

    function serchData(page){
    	
    	var data = {
    		'page': page,
    	};
   		$.ajax({  
			url : "/tchyuanlin/system/visitor/getVisitorPage.html",  
			type : 'post',
			dataType: "json",
			data: data,
			success : function(result){
				$('#total').text('共有数据：'+result.total+'条');
				
				$('#x-img').html('');
				var data = result.rows;
				for(var i=0;i<data.length;i++){
					var tr = $('#clone-tr').find('tr').clone();
	
					tr.find('[row=visitIp]').text(data[i].visitIp);
					tr.find('[row=visitAddress1]').text(data[i].visitAddress1);
					tr.find('[row=visitAddress2]').text(data[i].visitAddress2);
					tr.find('[row=visitAddress3]').text(data[i].visitAddress3);
					tr.find('[row=visitCount]').text(data[i].visitCount);
					tr.find('[row=createTime]').text(data[i].createTime);
					tr.find('[row=updateTime]').text(data[i].updateTime);
					
					$('#x-img').append(tr);
				}
			},
			error : function(result){
				layer.alert("加载数据出错，请刷新页面后，重新操作")
			}
		});
    }
    //批量删除提交
/*      function delAll () {
        layer.confirm('确认要删除吗？',function(index){
        	var arr = new Array();
        	$('.checkId:checked').each(function(i,obj){
        		arr[i] = $(obj).val();
        	})
        	var sel = arr.join(",");
        	$.ajax({  
 			url : "/tchyuanlin/system/message/updateStsMessage.html",  
 			type : 'post',
 			dataType: "json",
 			data: {'messageId': sel},
 			success : function(result){
 				if(result.success){
 					layer.msg('删除成功', {icon: 1});
 					location.reload();
 				}else{
 					layer.msg('删除失败，请重新操作', {icon: 5});
 					location.reload();
 				}
 			},
 			error : function(result){
 				layer.alert("加载数据出错，请刷新页面后，重新操作")
 			}
 		});
        });
     } */
    
/*     function banner_details(obj,title,url,w,h){
    	var id = $(obj).parent('td').siblings('[row=ids]').text();
    	x_admin_show(title,url+'?messageId='+id,w,h); 
    } */
 	
    /*删除*/
/*     function banner_del(obj){
        layer.confirm('确认要删除吗？',function(index){
        	var id = $(obj).parent('td').siblings('[row=ids]').text();
        	$.ajax({  
 			url : "/tchyuanlin/system/message/updateStsMessage.html",  
 			type : 'post',
 			dataType: "json",
 			data: {'messageId': id},
 			success : function(result){
 				if(result.success){
 					$(obj).parents("tr").remove();
                     layer.msg('已删除!',{icon:1,time:1000});
 				}else{
 					layer.msg('删除失败，请重新操作',{icon: 5,time:1000});
 				}
 			},
 			error : function(result){
 				layer.alert("加载数据出错，请刷新页面后，重新操作")
 			}
 		});
            
        });
    } */
    </script>
</body>
</html>