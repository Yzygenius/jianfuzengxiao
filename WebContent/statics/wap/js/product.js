var pageSize = 10; //页面大小
var before; //上次请求页码
$(function(){seachData()});

function seachData(page){
	if(page == '' || page == null){
		page = 1;
	}
	$.ajax({
		url: "/jikuang/transactioninfo/getTransactionInfoPage.html",
		type: "POST",
		dataType: "json",
		data:{
			'page': page, 
			'pageSize': pageSize,
			'type': $('#productTypeChoose .active input').val(), 
			'moreSearch': $('#keyWord').val(),
			'transactionType': $('#tradeStyleChoose .active input').val()
		},
		success: function(data){
			pageinfo(data.page, data.pageCount,"#mainArea")
			var rows = data.rows
			$('#tradeInfoContentLists').html('');
			var str = '';
			for(var i=0;i<rows.length;i++){
				if(rows[i].transactionType == 'B'){
					var transactionType = '购买'
				}else if(rows[i].transactionType == 'S'){
					var transactionType = '出售'
				}
				str += '<ul><li class="first"><a href="/jikuang/wap/product_detail.html?transactionId='+rows[i].transactionId+'"><font color="#fa6d35">'+rows[i].type+'</font></a></li>'
				+ '<li class="second">'+transactionType+'</li>'
				+'<li class="third">'+rows[i].weight+'</li>'
				+'<li class="fourth">'+rows[i].price+'</li></ul>'
				/*+'<li class="fifth" id="lookDeail"><a href="/jikuang/wap/product_detail.html?transactionId='+rows[i].transactionId+'">查看详情</a></li>'*/;
			}													
			$('#tradeInfoContentLists').append(str);
		},
		error: function(data){
			console.log(data)
		}
	})
}
	$(function(){
		 $('#productTypeChoose').click(function(){
			 $(this).addClass('active').siblings().removeClass('active')
			 seachData();
		 })
		    
		 $('#tradeStyleChoose').click(function(){
			 $(this).addClass('active').siblings().removeClass('active')
			 seachData();
		 })
	
		 $('#searchBtn').click(function(){
			 more = $('#keyWord').val();
			 seachData();
		 })
	})
function tradeInfoDetails(transactionid){
	window.open('/jikuang/transactioninfo/toTradeInfoDetails.html?transactionid='+transactionid)
}
function menuTriangle(){
	$('#menuTitleNav ul li').eq(4).addClass('active');
}