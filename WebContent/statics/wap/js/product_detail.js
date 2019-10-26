	
var urltransactionid;
$(function(){
	urltransactionid=GetQueryString('transactionId');
	tradeInfoContactPhone = new Label("#tradeInfoContactPhone",Label.DisTypeLong);
	var contactPhone;
	var transactionid;
	$.ajax({
		url: "/jikuang/transactioninfo/getTransactionInfoDetails.html",
		type: "POST",
		dataType: "json",
		data:{'transactionId':urltransactionid},
		success: function(data){
			var rows= data.data;
			var Type=rows.transactionType;
			if(Type == 'B'){
				Type="购买";
			}else if(rows.transactionType == 'S'){
				Type="出售";
			}
			
			$('#tradeInfoContentDetail').html('');
			var str = '';
			str='<div class="box"><span>类别</span><p>'+rows.type+'</p></div>'+
			'<div class="box"><span>交易类型</span><p>'+Type+'</p></div>'+
			'<div class="box"><span>用量(吨)</span><p>'+rows.weight+'</p></div>'+
			'<div class="box"><span>价格(元/吨)</span><p>'+rows.price+'</p></div>'+
			'<div class="box"><span>联系人</span><p>'+rows.contactName+'</p></div>'+
			'<div class="box"><span>联系电话</span><p id="tradeInfoContactPhone">查看联系方式</p></div>'+
			'<div class="box"><span>有效期</span><p>'+rows.validStartTime +' - '+rows.validStopTime+'</p></div>'+
			'<div class="box"><span>备注</span><p>'+rows.remark+'</p></div>';
			$('#tradeInfoContentDetail').append(str);
			contactPhone=rows.contactPhone;
			transactionid=rows.transactionId;
			clickRateNum(contactPhone,transactionid);
		},
		error: function(data){
			console.log(data)
		}
	})
	//累计联系方式点击量
	function clickRateNum(contactPhone,transactionid){
		$('#tradeInfoContactPhone').click(function(){
			$.ajax({
				url: "/jikuang/transactioninfo/updateClicks.html",
				type: "POST",
				dataType: "json",
				data:{"transactionId":transactionid},
				success: function(data){
					$('#tradeInfoContactPhone label').css({'color':'#666666'})
					$('#tradeInfoContactPhone').text(contactPhone)
					$('#tradeInfoContactPhone').unbind('click')
				},
				error: function(data){
					alert('请重新点击')
				}
			})
		})
	}
	
})