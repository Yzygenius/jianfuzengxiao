$(function(){
	
	$.ajax({
		url: "/jikuang/transactioninfo/getTransactionInfoPage.html",
		type: "POST",
		dataType: "json",
		data:{'transactionId':$('#transactionId').val()},
		success: function(data){
			var rows = data.rows
			$('#tradeInfoContentLists').html('');
			var str = '';
			for(var i=0;i<rows.length;i++){
				if(rows[i].transactionType == 'B'){
					var transactionType = '购买'
				}else if(rows[i].transactionType == 'S'){
					var transactionType = '出售'
				}
				str+='<div class="box"><span>类别</span><p>'+rows[i].type+'</p></div>';
				str+='<div class="box"><span>交易类型</span><p>'+transactionType+'</p></div>';
				str+='<div class="box"><span>用量(吨)</span><p>'+rows[i].weight+'</p></div>';
				str+='<div class="box"><span>价格(元/吨)</span><p>'+rows[i].price+'</p></div>';
				str+='<div class="box"><span>联系人</span><p>'+rows[i].contactName+'</p></div>';
				str+='<div class="box"><span>联系电话</span><p>'+rows[i].contactPhone+'</p></div>';
				str+='<div class="box"><span>有效期</span><p>'+rows[i].validStartTime +' - '+rows[i].validStopTime+'</p></div>';
				str+='<div class="box"><span>备注</span><p>'+rows[i].remark+'</p></div>';
			}
			$('#tradeInfoContentLists').append(str);
		},
		error: function(data){
			console.log(data)
		}
	})
	
})