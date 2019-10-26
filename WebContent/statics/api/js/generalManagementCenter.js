var pageSize =10;
var mapLng,mapLat,companyid,submitnewsid,editorAddContent,editor;
var goodTrendid,goodsid;
var edittransactionid;
$(function(){
	getBasicInfo()
	//点击左侧菜单
	$('.menuPenal li').click(function(){
		$(this).addClass('active').siblings().removeClass('active')
		$('.contentList .contentli').eq($(this).index()).addClass('active').siblings().removeClass('active');
		$('.menuPenal li').each(function(){
			var imgSrc = $(this).find('img').eq(0).attr('src');
			var src = imgSrc.replace('.png','');
			if($(this).hasClass('active')){
				if(src.indexOf('_active') == -1){
					src = src + '_active.png';
					$(this).find('img').eq(0).attr('src',src)
				}
			}else{
				if(src.indexOf('_active') != -1){
					src = src.replace('_active','.png');
					$(this).find('img').eq(0).attr('src',src)
				}
			}
			if($('.jiaoyixinxi').hasClass('active')){
				getTradeMessage()
			}
			if($('.fabulishi').eq(2).hasClass('active')){
				$('#myTradeInfo').show().siblings().hide()
				getMyTradeMessage()
			}
		})
	})
	

	
//交易信息
	tradeInfoType = new InputText("#tradeInfoType",InputText.TypeNormal,InputText.DisTypeTable,30);
	var tradeStyleData = [{"value":"B","text":"购买"},{"value":"S","text":"出售"}];
	tradeInfoStyle = new RadioBox("#tradeInfoStyle",tradeStyleData);
	tradeInfoYield = new InputText("#tradeInfoYield",InputText.TypeFloor,InputText.DisTypeTable,30);
	tradeInfoPrice = new InputText("#tradeInfoPrice",InputText.TypeFloor,InputText.DisTypeTable,30);
	tradeInfoContactName = new InputText("#tradeInfoContactName",InputText.TypeNormal,InputText.DisTypeTable,30);
	tradeInfoContactPhone = new InputText("#tradeInfoContactPhone",InputText.TypeInt,InputText.DisTypeTable,30);
	tradeInfoStartDate = new DateBox('#tradeInfoStartDate',DateBox.TypeDay);
	tradeInfoEndDate = new DateBox('#tradeInfoEndDate',DateBox.TypeDay);
	tradeInfoSearchStartDate = new DateBox('#tradeInfoSearchStartDate',DateBox.TypeDay);
	$('#tradeInfoSearchStartDate').css({'float':'left','text-align':'left','border-radius':'5px'})
	tradeInfoSearchEndDate = new DateBox('#tradeInfoSearchEndDate',DateBox.TypeDay);
	$('#tradeInfoSearchEndDate').css({'float':'left','text-align':'left','border-radius':'5px'})
	
	supplyContactName = new InputText("#supplyContactName",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#supplyContactName input').attr('placeholder','请输入联系人')
	supplyContactPhone = new InputText("#supplyContactPhone",InputText.TypeTel,InputText.DisTypeTable,11);
	$('#supplyContactPhone input').attr('placeholder','请输入联系电话')
	supplyWeight = new InputText("#supplyWeight",InputText.Typefloor,InputText.DisTypeTable,30);
	$('#supplyWeight input').attr('placeholder','请输入供应量')
	supplyPrice = new InputText("#supplyPrice",InputText.Typefloor,InputText.DisTypeTable,30);
	$('#supplyPrice input').attr('placeholder','请输入报价')
	supplyDate = new DateBox('#supplyDate',DateBox.TypeDay);
	
	//获取交易信息列表
	getTradeMessage()
	
	//点击搜索按钮
	$('#tradeInfoSearchBtn').click(function(){
		getTradeMessage()
	})
	//点击返回按钮
	$('#tradeInfoReturnBtn').click(function(){
		$('#tradeInfoDetail').hide()
		$('#tradeInfoContent').show()
	})
	$('#supplyReturnBtn').click(function(){
		$('#goodsSupply').hide()
		$('#tradeInfoDetail').show()
	})
	//点击我要供货按钮
	$('#supplyGoodsBtn').click(function(){
		$('#tradeInfoDetail').hide()
		$('#goodsSupply').show()
		
	})

//发布交易信息
	publishTradeInfoType = new InputText("#publishTradeInfoType",InputText.TypeNormal,InputText.DisTypeTable,30);
	var tradeStyleData = [{"value":"B","text":"购买","radio":true},{"value":"S","text":"出售"}];
	publishTradeInfoStyle = new RadioBox("#publishTradeInfoStyle",tradeStyleData);
	publishTradeInfoYield = new InputText("#publishTradeInfoYield",InputText.TypeFloor,InputText.DisTypeTable,30);
	publishTradeInfoPrice = new InputText("#publishTradeInfoPrice",InputText.TypeFloor,InputText.DisTypeTable,30);
	publishTradeInfoStartDate = new DateBox('#publishTradeInfoStartDate',DateBox.TypeDay);
	publishTradeInfoEndDate = new DateBox('#publishTradeInfoEndDate',DateBox.TypeDay);
	publishTradeInfoContactName = new InputText("#publishTradeInfoContactName",InputText.TypeNormal,InputText.DisTypeTable,30);
	publishTradeInfoContactPhone = new InputText("#publishTradeInfoContactPhone",InputText.TypeInt,InputText.DisTypeTable,30);
	publishTradeInfoRemark_TA = new TextArea('#publishTradeInfoRemark_TA',TextArea.DisTypeTable);
	publishTradeInfoSearchStartDate = new DateBox('#publishTradeInfoSearchStartDate',DateBox.TypeDay);
	$('#publishTradeInfoSearchStartDate').css({'float':'left','text-align':'left','border-radius':'5px'})
	publishTradeInfoSearchEndDate = new DateBox('#publishTradeInfoSearchEndDate',DateBox.TypeDay);
	$('#publishTradeInfoSearchEndDate').css({'float':'left','text-align':'left','border-radius':'5px'})

	//点击确认按钮
	$('#publishTradeInfoSubmitBtn').click(function(){
		addMyTradeMessage()
	})
	//点击取消按钮
	$('#publishTradeInfoCancleBtn').click(function(){
		clearPulishTradInfo()
	})
	
	
	
	
	
//发布历史
	myTradeInfoType = new InputText("#myTradeInfoType",InputText.TypeNormal,InputText.DisTypeTable,30);
	var tradeStyleData = [{"value":"B","text":"购买"},{"value":"S","text":"出售"}];
	myTradeInfoStyle = new RadioBox("#myTradeInfoStyle",tradeStyleData);
	myTradeInfoYield = new InputText("#myTradeInfoYield",InputText.TypeFloor,InputText.DisTypeTable,30);
	myTradeInfoPrice = new InputText("#myTradeInfoPrice",InputText.TypeFloor,InputText.DisTypeTable,30);
	myTradeInfoStartDate = new DateBox('#myTradeInfoStartDate',DateBox.TypeDay);
	myTradeInfoEndDate = new DateBox('#myTradeInfoEndDate',DateBox.TypeDay);
	myTradeInfoContactName = new InputText("#myTradeInfoContactName",InputText.TypeNormal,InputText.DisTypeTable,30);
	myTradeInfoContactPhone = new InputText("#myTradeInfoContactPhone",InputText.TypeInt,InputText.DisTypeTable,30);
	myTradeInfoRemark_TA = new TextArea('#myTradeInfoRemark_TA',TextArea.DisTypeTable);
	myTradeInfoSearchStartDate = new DateBox('#myTradeInfoSearchStartDate',DateBox.TypeDay);
	$('#myTradeInfoSearchStartDate').css({'float':'left','text-align':'left','border-radius':'5px'})
	myTradeInfoSearchEndDate = new DateBox('#myTradeInfoSearchEndDate',DateBox.TypeDay);
	$('#myTradeInfoSearchEndDate').css({'float':'left','text-align':'left','border-radius':'5px'})
	
	supplierCompanyName = new InputText("#supplierCompanyName",InputText.TypeNormal,InputText.DisTypeTable,30);
	supplierContactName = new InputText("#supplierContactName",InputText.TypeNormal,InputText.DisTypeTable,30);
	supplierContactPhone = new InputText("#supplierContactPhone",InputText.TypeTel,InputText.DisTypeTable,11);
	supplierWeight = new InputText("#supplierWeight",InputText.TypeFloor,InputText.DisTypeTable,30);
	supplierPrice = new InputText("#supplierPrice",InputText.TypeFloor,InputText.DisTypeTable,30);
	supplierDate = new DateBox('#supplierDate',DateBox.TypeDay);
	var supplierStateData = [{"value":"1","text":"待选"},{"value":"2","text":"已选"},{"value":"3","text":"放弃"}];
	supplierState = new RadioBox("#supplierState",supplierStateData);
	
	
	//获取交易历史列表
	getMyTradeMessage()
	//点击搜索按钮
	$('#myTradeInfoSearchBtn').click(function(){
		getMyTradeMessage()
	})
	//点击确认修改按钮
	$('#myTradeInfoEditBtn').click(function(){
		editMyTradeMessage()
	})
	//点击删除按钮
	$('#deleteMyTradeInfo').click(function(){
		deleteMyTradeInfo()
	})
	//点击取消按钮
	$('#myTradeInfoCancleBtn').click(function(){
		$('#addMyTradeInfo').hide()
		$('#myTradeInfo').show()
		$('#myTradeInfoEditBtn').hide()
		$('#myTradeInfoSubmitBtn').hide()
		$('#deleteMyTradeInfo').hide()
		clearMyTradInfo()
	})
	//点击返回按钮
	$('#supplierReturnBtn').click(function(){
		$('#supplierList').show().siblings().hide()
	})
	$('#supplierListTableReturnBtn').click(function(){
		$('#myTradeInfo').show().siblings().hide()
	})
	
	
//修改密码
	oldPassword = new InputText("#oldPassword",InputText.TypePassword,InputText.DisTypeTable,16);
	$('#oldPassword input').attr('placeholder','请输入原密码').css('width','560px')
	newPassword = new InputText("#newPassword",InputText.TypePassword,InputText.DisTypeTable,16);
	$('#newPassword input').attr('placeholder','请输入6-16位新密码').css('width','560px')
	againNewPassword = new InputText("#againNewPassword",InputText.TypePassword,InputText.DisTypeTable,16);
	$('#againNewPassword input').attr('placeholder','请再次输入新密码').css('width','560px')
	//确认修改
	$('#revisePasswordSubmit').click(function(){
		if(oldPassword.getPassword() == ''){
			alert('请输入原密码！')
			return
		}
		if(newPassword.getPassword() == ''){
			alert('请输入新密码！')
			return
		}
		if(againNewPassword.getPassword() == ''){
			alert('请再次输入新密码！')
			return
		}
		if(newPassword.getPassword() != againNewPassword.getPassword()){
			alert('新密码两次输入不一致！')
			return
		}
		$.ajax({
			url: "/jikuang/api/main/updatePassword.html",
			type:"POST",
			dataType:"json",
			data:{
				"oldPassword": encrypt(oldPassword.getPassword()),
				"password": encrypt(newPassword.getPassword())
			},
			success: function(data){
				if(data.success == true){
					alert(data.message)
					$('#revisePasswordCancle').click()
				}else{
					alert(data.message)
				}
			},
			error: function(data){
				alert(data.message)
			}
		})
	})
	//取消
	$('#revisePasswordCancle').click(function(){
		oldPassword.setPassword('')
		newPassword.setPassword('')
		againNewPassword.setPassword('')
		$('#revisePassword').hide()
		$('#content').show()
	})	
	
	
	
})
//获取基本信息
function getBasicInfo(){
	$.ajax({
		url: "/jikuang/api/companyinfo/getCompanyDetails.html",
		type: "POST",
		dataType: "json",
		success: function(data){
			if(data.success == true){
				$('#enterpriseName').html(data.data.username)
				$('.enterprisePhone').html(data.data.contactTel)
				$('#enterpriseImage img').attr('src','/jikuang/'+data.data.companyThumb)
				if(data.data.certState != 'C'){
					$('#content .menuPenal li').eq(1).hide()
				}
			}else{
				alert('信息获取失败！')
			}
		},
		error: function(data){
			alert('信息获取失败！')
		}
	})
}

//提交基本信息
function submitBasicInfo(){
	if(userName.getText() == ''){
		alert('请输入用户名称！')
		return
	}
	if(localProvince_AB.getProvinceValue() == ''){
		alert('请选择所在地省份！')
		return
	}
	if(localProvince_AB.getCityValue() == ''){
		alert('请选择所在地市！')
		return
	}
	if(localProvince_AB.getCountyValue() == ''){
		alert('请选择所在地区/县！')
		return
	}
	if(localAddress_IT.getText() == ''){
		alert('请输入详细地址！')
		return
	}
	if(contactName_IT.getText() == ''){
		alert('请输入联系人名称！')
		return
	}
	if(contactPhone_IT.getText() == ''){
		alert('请输入联系电话！')
		return
	}
	if(contactQQ_IT.getText() == ''){
		alert('请输入QQ号！')
		return
	}
	if(contactWeChat_IT.getText() == ''){
		alert('请输入微信号！')
		return
	}
	$.ajax({
		url: "/jikuang/api/companyinfo/updateCompanyInfo.html",
		type: "POST",
		dataType: "json",
		data: {
			"companyName": userName.getText(),
			"provCode": localProvince_AB.getProvinceValue(),
			"cityCode": localProvince_AB.getCityValue(),
			"areaCode": localProvince_AB.getCountyValue(),
			"address": localAddress_IT.getText(),
			"contactName": contactName_IT.getText(),
			"contactTel": contactPhone_IT.getText(),
			"qq": contactQQ_IT.getText(),
			"wx": contactWeChat_IT.getText()
		},
		success: function(data){
			console.log(data)
			if(data.success == true){
				alert('信息提交成功！')
			}else{
				alert('信息提交失败！')
			}
		},
		error: function(data){
			alert('信息提交失败！')
		}
	})
}

//获取交易信息列表
function getTradeMessage(page){
	var searchStarTime = tradeInfoSearchStartDate.getDateText();
	var searchEndTime = tradeInfoSearchEndDate.getDateText();
	if(page == '' || page == null){
		page=1;
	}
	$.ajax({
		url: "/jikuang/api/transactioninfo/getTransactionInfoPage.html",
		type: "POST",
		dataType: "json",
		data: {
			'page': page, 
			'pageSize': pageSize,
			'validStartTime': searchStarTime,
			'validStopTime': searchEndTime
		},
		success: function(data){
			pageinfoTradeInfo(data.page,data.pageCount,'.tradeInfo');
			var rows = data.rows;
			$('.tradeInfo .tradeInfoList tr').eq(0).siblings().remove();
			for(var i=0;i<rows.length;i++){
				if(rows[i].transactionType == 'B'){
					var tradeStyle = '购买';
				}else if(rows[i].transactionType == 'S'){
					var tradeStyle = '出售';
				}
				$('.tradeInfo .tradeInfoList').append('<tr>'+
												'<td style="text-align: center;">'+(i + 1)+'</td>'+
												'<td style="text-align: center;"><div style="color: #fa6d35;cursor:pointer;" onclick="tradeInfoDetail('+rows[i].transactionId+')">'+rows[i].type+'</div></td>'+
												'<td style="text-align: center;">'+tradeStyle+'</td>'+
												'<td style="text-align: center;">'+rows[i].weight+'</td>'+
												'<td style="text-align: center;">'+rows[i].price+'</td>'+
												'<td style="text-align: center;">'+rows[i].contactName+'</td>'+
												'<td style="text-align: center;">'+rows[i].validStartTime+' - '+rows[i].validStopTime+'</td>'+
											'</tr>')
			}
		},
		error: function(data){
			alert('获取交易信息失败')
		}
	})
}
//查看交易信息详情
function tradeInfoDetail(transactionid){
	$.ajax({
		url: "/jikuang/api/transactioninfo/getTransactionInfoDetails.html",
		type: "POST",
		dataType: "json",
		data: {"transactionId": transactionid},
		success: function(data){
			if(data.success == true){
				var rows= data.data;
				tradeInfoType.setText(rows.type)
				tradeInfoStyle.setRadioValue(rows.transactionType)
				tradeInfoYield.setText(rows.weight)
				tradeInfoPrice.setText(rows.price)
				tradeInfoContactName.setText(rows.contactName)
				tradeInfoContactPhone.setText('查看联系方式')
				tradeInfoStartDate.setDateText(rows.validStartTime)
				tradeInfoEndDate.setDateText(rows.validStopTime)
				clickRateNum(rows.contactPhone,rows.transactionId)
			}
		},
		error: function(data){
			alert('获取交易信息详情失败')
		}
	})
	$('#tradeInfoContent').hide()
	$('#tradeInfoDetail').show()
}
//累计联系方式点击量
function clickRateNum(contactPhone,transactionid){
	tradeInfoContactPhone.bindEvent('click',function(){
		$.ajax({
			url: "/jikuang/transactioninfo/updateClicks.html",
			type: "POST",
			dataType: "json",
			data:{"transactionId":transactionid},
			success: function(data){
				tradeInfoContactPhone.setText(contactPhone)
				tradeInfoContactPhone.unbindEvent('click')
			},
			error: function(data){
				alert('请重新点击')
			}
		})
	})
}

//获取发布历史列表
function getMyTradeMessage(page){
	var searchStarTime = myTradeInfoSearchStartDate.getDateText();
	var searchEndTime = myTradeInfoSearchEndDate.getDateText();
	if(page == '' || page == null){
		page=1;
	}
	$.ajax({
		url: "/jikuang/api/transactioninfo/getTransactionInfoPage.html",
		type: "POST",
		dataType: "json",
		data: {
			'page': page, 
			'pageSize': pageSize,
			'validStartTime': searchStarTime,
			'validStopTime': searchEndTime
		},
		success: function(data){
			pageinfoMyTradeInfo(data.page,data.pageCount,'#myTradeInfo');
			var rows = data.rows;
			$('#myTradeInfo .tradeInfoList tr').eq(0).siblings().remove()
			for(var i=0;i<rows.length;i++){
				if(rows[i].transactionType == 'B'){
					var tradeStyle = '购买';
				}else if(rows[i].transactionType == 'S'){
					var tradeStyle = '出售';
				}
				$('#myTradeInfo .tradeInfoList').append('<tr>'+
															'<td style="text-align: center;">'+(i + 1)+'</td>'+
															'<td style="text-align: center;"><div style="color: #fa6d35;cursor:pointer;" onclick="myTradeInfoDetail('+rows[i].transactionId+')">'+rows[i].type+'</div></td>'+
															'<td style="text-align: center;">'+tradeStyle+'</td>'+
															'<td style="text-align: center;">'+rows[i].weight+'</td>'+
															'<td style="text-align: center;">'+rows[i].price+'</td>'+
															'<td style="text-align: center;">'+rows[i].contactName+'</td>'+
															'<td style="text-align: center;">'+rows[i].contactPhone+'</td>'+
															'<td style="text-align: center;">'+rows[i].validStartTime+' - '+rows[i].validStopTime+'</td>'+
															'<td style="text-align: center;"><div style="text-align:center;color: #fa6d35;cursor:pointer;" onclick="supplierList()">3</div></td>'+
														'</tr>')
			}
			
		},
		error: function(data){
			console.log('获取交易信息失败')
		}
	})
}
//供应商列表
function supplierList(){
	$('#myTradeInfo').hide()
	$('#supplierList').show()
	$('.supplierListTable tr').eq(0).siblings().remove()
	$('.supplierListTable').append('<tr><td style="text-align: center;">1</td>'+
										'<td style="text-align: center;"><div style="color: #fa6d35;cursor:pointer;" onclick="supplierDetails(1)">美钙粉有限公司</div></td>'+
										'<td style="text-align: center;">10000</td>'+
										'<td style="text-align: center;">60</td>'+
										'<td style="text-align: center;">企业</td>'+
										'<td style="text-align: center;">待选</td>'+
										'<td style="text-align: center;">2019-04-15</td>'+
									'</tr>'+
									'<tr><td style="text-align: center;">2</td>'+
										'<td style="text-align: center;"><div style="color: #fa6d35;cursor:pointer;" onclick="supplierDetails(2)">美钙粉有限公司</div></td>'+
										'<td style="text-align: center;">10000</td>'+
										'<td style="text-align: center;">60</td>'+
										'<td style="text-align: center;">平台</td>'+
										'<td style="text-align: center;">已选</td>'+
										'<td style="text-align: center;">2019-04-15</td>'+
									'</tr>'+
									'<tr><td style="text-align: center;">3</td>'+
										'<td style="text-align: center;"><div style="color: #fa6d35;cursor:pointer;" onclick="supplierDetails(3)">美钙粉有限公司</div></td>'+
										'<td style="text-align: center;">10000</td>'+
										'<td style="text-align: center;">60</td>'+
										'<td style="text-align: center;">企业</td>'+
										'<td style="text-align: center;">放弃</td>'+
										'<td style="text-align: center;">2019-04-15</td>'+
									'</tr>')
}
//供应商详情
function supplierDetails(num){
	$('#supplierList').hide()
	$('#supplierDetails').show()
	supplierCompanyName.setText('美钙粉有限公司');
	supplierContactName.setText('周幼琳');
	supplierContactPhone.setText('15100023658');
	supplierWeight.setText('10000');
	supplierPrice.setText('60');
	supplierDate.setDateText('2019-04-15');
	supplierState.setRadioValue(num)
	
}
//我的交易信息详情
function myTradeInfoDetail(transactionid){
	edittransactionid = transactionid
	$.ajax({
		url: "/jikuang/api/transactioninfo/getTransactionInfoDetails.html",
		type: "POST",
		dataType: "json",
		data: {"transactionId": transactionid},
		success: function(data){
			if(data.success == true){
				var rows= data.data;
				myTradeInfoType.setText(rows.type)
				myTradeInfoStyle.setRadioValue(rows.transactionType)
				myTradeInfoYield.setText(rows.weight)
				myTradeInfoPrice.setText(rows.price)
				myTradeInfoContactName.setText(rows.contactName)
				myTradeInfoContactPhone.setText(rows.contactPhone)
				myTradeInfoStartDate.setDateText(rows.validStartTime)
				myTradeInfoEndDate.setDateText(rows.validStopTime)
				myTradeInfoRemark_TA.setText(rows.remark)
				$('#myTradeInfoSubmitBtn').hide()
				$('#myTradeInfoEditBtn').show()
				$('#deleteMyTradeInfo').show()
			}
		},
		error: function(data){
			alert('获取交易信息详情失败')
		}
	})
	$('#myTradeInfo').hide()
	$('#addMyTradeInfo').show()
}
//确认修改我的交易信息
function editMyTradeMessage(){
	if(myTradeInfoType.getText() == ''){
		alert('请输入类别！')
		return
	}
	if(myTradeInfoStyle.getRadioValue() == ''){
		alert('请选择交易类型！')
		return
	}
	if(myTradeInfoYield.getText() == ''){
		alert('请输入用量！')
		return
	}
	if(myTradeInfoPrice.getText() == ''){
		alert('请输入价格！')
		return
	}
	if(myTradeInfoContactName.getText() == ''){
		alert('请输入联系人！')
		return
	}
	if(myTradeInfoContactPhone.getText() == ''){
		alert('请输入联系电话！')
		return
	}
	if(myTradeInfoStartDate.getDateText() == ''){
		alert('请选择有效期开始时间！')
		return
	}
	if(myTradeInfoEndDate.getDateText() == ''){
		alert('请输入有效期结束时间！')
		return
	}
	$.ajax({
		url: "/jikuang/api/transactioninfo/updateTransactionInfo.html",
		type: "POST",
		dataType: "json",
		data:{
			"transactionId": edittransactionid,
			"type": myTradeInfoType.getText(),
			"transactionType": myTradeInfoStyle.getRadioValue(),
			"weight": myTradeInfoYield.getText(),
			"price": myTradeInfoPrice.getText(),
			"contactName": myTradeInfoContactName.getText(),
			"contactPhone": myTradeInfoContactPhone.getText(),
			"remark": myTradeInfoRemark_TA.getText(),
			"validStartTime": myTradeInfoStartDate.getDateText(),
			"validStopTime": myTradeInfoEndDate.getDateText()
		},
		success: function(data){
			if(data.success == true){
				alert('我的交易信息修改成功！')
				getMyTradeMessage()
				$('#myTradeInfoCancleBtn').click()
			}else{
				alert('我的交易信息修改失败')
			}
		},
		error: function(data){
			alert('我的交易信息修改失败')
		}
	})
}
//发布交易信息
function addMyTradeMessage(){
	if(publishTradeInfoType.getText() == ''){
		alert('请输入类别！')
		return
	}
	if(publishTradeInfoStyle.getRadioValue() == ''){
		alert('请选择交易类型！')
		return
	}
	if(publishTradeInfoYield.getText() == ''){
		alert('请输入用量！')
		return
	}
	if(publishTradeInfoPrice.getText() == ''){
		alert('请输入价格！')
		return
	}
	if(publishTradeInfoContactName.getText() == ''){
		alert('请输入联系人！')
		return
	}
	if(publishTradeInfoContactPhone.getText() == ''){
		alert('请输入联系电话！')
		return
	}
	if(publishTradeInfoStartDate.getDateText() == ''){
		alert('请选择有效期开始时间！')
		return
	}
	if(publishTradeInfoEndDate.getDateText() == ''){
		alert('请输入有效期结束时间！')
		return
	}
	$.ajax({
		url: "/jikuang/api/transactioninfo/addTransactionInfo.html",
		type: "POST",
		dataType: "json",
		data:{
			"type": publishTradeInfoType.getText(),
			"transactionType": publishTradeInfoStyle.getRadioValue(),
			"weight": publishTradeInfoYield.getText(),
			"price": publishTradeInfoPrice.getText(),
			"contactName": publishTradeInfoContactName.getText(),
			"contactPhone": publishTradeInfoContactPhone.getText(),
			"remark": publishTradeInfoRemark_TA.getText(),
			"validStartTime": publishTradeInfoStartDate.getDateText(),
			"validStopTime": publishTradeInfoEndDate.getDateText()
		},
		success: function(data){
			if(data.success == true){
				alert('发布交易信息成功！')
				getMyTradeMessage()
				$('#publishTradeInfoCancleBtn').click()
			}else{
				alert('发布交易信息失败')
			}
		},
		error: function(data){
			alert('发布交易信息失败')
		}
	})
}
//删除我的交易信息
function deleteMyTradeInfo(){
	$.ajax({
		url: "/jikuang/api/transactioninfo/updateStsTransactionInfo.html",
		type: "POST",
		dataType: "json",
		data:{"transactionId": edittransactionid},
		success: function(data){
			if(data.success == true){
				alert('交易历史删除成功！')
				getMyTradeMessage()
				$('#myTradeInfoCancleBtn').click()
			}else{
				alert('交易历史删除失败')
			}
		},
		error: function(data){
			alert('交易历史删除失败')
		}
	})
}
//清空交易信息详情页面
function clearMyTradInfo(){
	myTradeInfoType.setText('')
	myTradeInfoStyle.setRadioValue('')
	myTradeInfoYield.setText('')
	myTradeInfoPrice.setText('')
	myTradeInfoContactName.setText('')
	myTradeInfoContactPhone.setText('')
	myTradeInfoStartDate.setDateText('')
	myTradeInfoEndDate.setDateText('')
	myTradeInfoRemark_TA.setText('')
}
//清空发布交易信息页面
function clearPulishTradInfo(){
	publishTradeInfoType.setText('')
	publishTradeInfoStyle.setRadioValue('')
	publishTradeInfoYield.setText('')
	publishTradeInfoPrice.setText('')
	publishTradeInfoContactName.setText('')
	publishTradeInfoContactPhone.setText('')
	publishTradeInfoStartDate.setDateText('')
	publishTradeInfoEndDate.setDateText('')
	publishTradeInfoRemark_TA.setText('')
}





function menuTriangle(){
	$('#menuTitleNav ul li').eq(8).addClass('active');
}
function getObjectURL(file) {
    var url = null ;
    if (window.createObjectURL!=undefined) { // basic
        url = window.createObjectURL(file) ;
    } else if (window.URL!=undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file) ;
    } else if (window.webkitURL!=undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file) ;
    }
    return url ;
}