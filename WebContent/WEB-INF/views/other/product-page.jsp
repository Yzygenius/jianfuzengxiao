<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>
            X-admin v1.0
        </title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="/tchyuanlin/statics/system/css/xadmin.css" media="all">
        <style>
        	.yincang{
        		display: none;
        	}
        </style>
    </head>
    <body>
        <div class="x-nav">
            <span class="layui-breadcrumb">
              <a><cite>首页</cite></a>
              <a><cite>产品列表</cite></a>
            </span>
            <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">&#xe666;</i></a>
        </div>
        <div class="x-body">
            <xblock>
            <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon">&#xe640;</i>批量删除</button>
            <button class="layui-btn" onclick="banner_add('新增','/tchyuanlin/system/product/toProductAdd.html')"><i class="layui-icon">&#xe608;</i>添加</button><span id="total" class="x-right" style="line-height:40px"></span></xblock>
            <table class="layui-table">
                <thead>
                    <tr>
                        <th>
                            <input type="checkbox" value="" name="" id="checkAll" onclick="checkAll(this)">
                        </th>
                        <th>排序</th>
                        <th>产品名称</th>
                        <th>类别</th>
                        <th>缩略图</th>
                        <th>描述</th>
                        <th>创建时间</th>
                        <th>操作</th>
                    </tr>
                </thead>	
                <tbody id="x-img">
                    
                </tbody>
            </table>

            <div id="page"></div>
        </div>
        
        <table id="clone-tr" style="display:none;">
			<tr>
                <td row="checkBoxId">
                    <input type="checkbox" class="checkId" value="" name="">
                </td>
                <td row="listOrder"></td>
                <td row="productName"></td>
                <td row="typeName"></td>
                <td row="img">
                    <img  src="" width="200" height="70" alt="" onclick="openImg(this)">
                </td>
                <td row="productRemark"><div style="width:200px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap"></div></td>
                <td row="createTime"></td>
                <td class="td-manage">
                	<button class="layui-btn layui-btn layui-btn-xs"  onclick="banner_edit(this,'编辑','/tchyuanlin/system/product/toProductEdit.html')" ><i class="layui-icon">&#xe642;</i>编辑</button>
           <button class="layui-btn-danger layui-btn layui-btn-xs"  onclick="banner_del(this)" href="javascript:;" ><i class="layui-icon">&#xe640;</i>删除</button>
                </td>
            </tr>
		</table>
        
        <script type="text/javascript" src="/tchyuanlin/statics/system/js/jquery.min.js"></script>
        <script src="/tchyuanlin/statics/system/lib/layui/layui.js" charset="utf-8"></script>
        <script src="/tchyuanlin/statics/system/js/xadmin.js" charset="utf-8"></script>
        
        <script>
        $(function () {
            layui.use(['laydate','form','element','laypage','layer'], function(){
            	var total;
              $ = layui.jquery;//jquery
              var form = layui.form
              ,layer = layui.layer//弹出层
              ,laydate = layui.laydate//日期插件
              ,lement = layui.element//面包导航
              ,laypage = layui.laypage;//分页
			  
              //以上模块根据需要引入
              
              $.ajax({  
       			  url : "/tchyuanlin/system/product/getProductPage.html",  
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
        			url : "/tchyuanlin/system/product/getProductPage.html",  
        			type : 'post',
        			dataType: "json",
        			data: data,
        			success : function(result){
        				$('#total').text('共有数据：'+result.total+'条');
        				$('#x-img').html('');
        				var data = result.rows;
        				for(var i=0;i<data.length;i++){
        					var tr = $('#clone-tr').find('tr').clone();
        					tr.find('[row=checkBoxId]').children().val(data[i].productId)
        					tr.find('[row=listOrder]').text(data[i].listOrder)
        					tr.find('[row=productName]').text(data[i].productName)
        					tr.find('[row=typeName]').text(data[i].typeName)
        					tr.find('[row=img]').children('img').attr('src', '/tchyuanlin/'+data[i].img)
        					tr.find('[row=productRemark]').children().text(data[i].productRemark)
        					tr.find('[row=createTime]').text(data[i].createTime)
        					$('#x-img').append(tr);
        				}
        				layer.photos({
       	                   photos: ''
       	                  //,shift: 5 //0-6的选择，指定弹出图片动画类型，默认随机
       	                });
        			},
        			error : function(result){
        				layer.alert("加载数据出错，请刷新页面后，重新操作")
        			}
        		});
            }
            
            function openImg(obj){
            	console.log(obj)
            	layer.photos({
                   photos: '#x-img'
                  //,shift: 5 //0-6的选择，指定弹出图片动画类型，默认随机
                });
            }
            //批量删除提交
             function delAll () {
                layer.confirm('确认要删除吗？',function(index){
                	var arr = new Array();
                	$('.checkId:checked').each(function(i,obj){
                		arr[i] = $(obj).val();
                	})
                	var sel = arr.join(",");
                	
                	$.ajax({  
	        			url : "/tchyuanlin/system/product/updateStsProduct.html",  
	        			type : 'post',
	        			dataType: "json",
	        			data: {'productId': sel},
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
             }
             /*添加*/
            function banner_add(title,url,w,h){
                x_admin_show(title,url,w,h);
            }
         	// 编辑
            function banner_edit(obj,title,url,w,h) {
            	var productId = $(obj).parent('td').siblings('[row=checkBoxId]').children('input').val();
            	x_admin_show(title,url+'?productId='+productId,w,h); 
            }
            
            
            /*删除*/
            function banner_del(obj){
                layer.confirm('确认要删除吗？',function(index){
                	var productId = $(obj).parent('td').siblings('[row=checkBoxId]').children('input').val();
                	$.ajax({  
	        			url : "/tchyuanlin/system/product/updateStsProduct.html",  
	        			type : 'post',
	        			dataType: "json",
	        			data: {'productId': productId},
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
            }
            </script>
    </body>
</html>