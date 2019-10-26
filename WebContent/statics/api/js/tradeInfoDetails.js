var urltransactionid;
$(function(){
	var urltransactionid=GetQueryString('transactionid');
	
	tradeInfoType = new Label("#tradeInfoType",Label.DisTypeLong);
	tradeInfoStyle = new Label("#tradeInfoStyle",Label.DisTypeLong);
	tradeInfoYield = new Label("#tradeInfoYield",Label.DisTypeLong);
	tradeInfoPrice = new Label("#tradeInfoPrice",Label.DisTypeLong);
	tradeInfoContactName = new Label("#tradeInfoContactName",Label.DisTypeLong);
	tradeInfoContactPhone = new Label("#tradeInfoContactPhone",Label.DisTypeLong);
	tradeInfoDate = new Label("#tradeInfoDate",Label.DisTypeLong);
	tradeInfoRemark = new Label("#tradeInfoRemark",Label.DisTypeLong);
	$('#tradeInfoRemark').css('height','150px')
	
	$.ajax({
		url: "/jikuang/transactioninfo/getTransactionInfoDetails.html",
		type: "POST",
		dataType: "json",
		data:{'transactionId': urltransactionid},
		success: function(data){
			if(data.success == true){
				var rows= data.data;console.log(rows)
				tradeInfoType.setContent(rows.type)
				if(rows.transactionType == 'B'){
					tradeInfoStyle.setContent('购买')
				}else if(rows.transactionType == 'S'){
					tradeInfoStyle.setContent('出售')
				}
				tradeInfoYield.setContent(rows.weight)
				tradeInfoPrice.setContent(rows.price)
				tradeInfoContactName.setContent(rows.contactName)
				tradeInfoContactPhone.setContent('查看联系方式')
				$('#tradeInfoContactPhone label').css({'color':'#fa6d35'})
				tradeInfoDate.setContent(rows.validStartTime + ' - ' + rows.validStopTime)
				tradeInfoRemark.setContent(rows.remark)
				clickRateNum(rows.contactPhone,rows.transactionId)
			}else{
				alert(data.message)
			}
		},
		error: function(data){
			alert(data.message)
		}
		
	})
	
	
	
	
	
});
//累计联系方式点击量
function clickRateNum(contactPhone,transactionid){
	$('#tradeInfoContactPhone label').click(function(){
		$.ajax({
			url: "/jikuang/transactioninfo/updateClicks.html",
			type: "POST",
			dataType: "json",
			data:{"transactionId":transactionid},
			success: function(data){
				$('#tradeInfoContactPhone label').css({'color':'#666666'})
				tradeInfoContactPhone.setContent(contactPhone)
				$('#tradeInfoContactPhone label').unbind('click')
			},
			error: function(data){
				alert('请重新点击')
			}
		})
	})
}
function menuTriangle(){
	$('#menuTitleNav ul li').eq(4).addClass('active');
}