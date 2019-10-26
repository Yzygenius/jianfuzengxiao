var pageSize = 10; //页面大小
var before; //上次请求页码
$(function(){
	$('.productTypeChoose span').click(function(){
		$(this).addClass('active').siblings().removeClass('active')
		searchData();
	})
	$('.tradeStyleChoose span').click(function(){
		$(this).addClass('active').siblings().removeClass('active')
		searchData();
	})
	$('#searchBtn').click(function(){
		searchData();
	})
		
	
	
	searchData();
	
	
	
})

function searchData(page){
	if(page == '' || page == null){
		page = 1;
	}
	$.ajax({
		url: "/jikuang/transactioninfo/getTransactionInfoPage.html",
		type: "POST",
		dataType: "json",
		data: {
			'page': page, 
			'pageSize': pageSize,
			'type': $('.productTypeChoose .active').attr('value'), 
			'moreSearch': $('#keyWord').val(),
			'transactionType': $('.tradeStyleChoose .active').attr('value')
		},
		success: function(data){
			pageinfo(data.page, data.pageCount,"#mainArea")
			var rows = data.rows
			$('#tradeInfoContentList').html('');
			var str = '';
			str += '<tr style="background: #faf2e7;height: 50px;"><th>类别</th><th>交易类型</th><th>用量（吨）</th><th>单价（元/吨）</th><th>联系人</th><th>有效期</th></tr>';
			for(var i=0;i<rows.length;i++){
				if(rows[i].transactionType == 'B'){
					var transactionType = '购买'
				}else if(rows[i].transactionType == 'S'){
					var transactionType = '出售'
				}
				str += '<tr><td><div style="color: #fa6d35;cursor: pointer;" onclick="tradeInfoDetails('+rows[i].transactionId+')">'+rows[i].type+'</div></td>';
				str += '<td>'+transactionType+'</td>';
				str += '<td>'+rows[i].weight+'</td>';
				str += '<td>'+rows[i].price+'</td>';
				str += '<td>'+rows[i].contactName+'</td>';
				str += '<td>'+rows[i].validStartTime +' - '+rows[i].validStopTime +'</td></tr>';
			}
			$('#tradeInfoContentList').append(str);
		},
		error: function(data){
			console.log(data)
		}
	})
	
}
function tradeInfoDetails(transactionid){
	window.open('/jikuang/transactioninfo/toTradeInfoDetails.html?transactionid='+transactionid)
}
function menuTriangle(){
	$('#menuTitleNav ul li').eq(4).addClass('active');
}