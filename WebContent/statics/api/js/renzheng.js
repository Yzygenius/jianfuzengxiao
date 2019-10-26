$(function(){
	
	getUserInfo()
	
	//认证信息
	userName = new InputText("#userName",InputText.TypeNormal,InputText.DisTypeTable,30);
	localBelong_AB = new AreaBox('#localBelong_AB',AreaBox.TypeCounty);
	address = new InputText("#address",InputText.TypeNormal,InputText.DisTypeTable,30);
	contactName = new InputText("#contactName",InputText.TypeNormal,InputText.DisTypeTable,30);
	contactPhone = new InputText("#contactPhone",InputText.TypeTel,InputText.DisTypeTable,11);
	qq = new InputText("#qq",InputText.TypeInt,InputText.DisTypeTable,30);
	wechat = new InputText("#wechat",InputText.TypeNormal,InputText.DisTypeTable,30);
	
	$('#submitBasicInfo').click(function(){
		if(userName.getText() == ''){
			alert('请输入用户名称！')
			return
		}
		if(localBelong_AB.getProvinceValue() == ''){
			alert('请选择所在地省！')
			return
		}
		if(localBelong_AB.getCityValue() == ''){
			alert('请选择所在地市！')
			return
		}
		if(localBelong_AB.getCountyValue() == ''){
			alert('请选择所在地区/县！')
			return
		}
		if(address.getText() == ''){
			alert('请输入详细地址！')
			return
		}
		if(contactName.getText() == ''){
			alert('请输入联系人！')
			return
		}
		if(contactPhone.getText() == ''){
			alert('请输入联系电话！')
			return
		}
		if(qq.getText() == ''){
			alert('请输入QQ号！')
			return
		}
		if(wechat.getText() == ''){
			alert('请输入微信号！')
			return
		}
		$.ajax({
			url: "/jikuang/api/main/submitAuthorized.html",
			type: "POST",
			dataType: "json",
			data:{
				"companyName": userName.getText(),
				"provCode": localBelong_AB.getProvinceValue(),
				"cityCode": localBelong_AB.getCityValue(),
				"areaCode": localBelong_AB.getCountyValue(),
				"address": address.getText(),
				"contactName": contactName.getText(),
				"contactTel": contactPhone.getText(),
				"qq": qq.getText(),
				"wx": wechat.getText()
			},
			success: function(data){
				if(data.success == true){
					alert(data.message)
					window.location.href='/jikuang/api/companyinfo/generalManagementCenter.html';
				}else{
					alert(data.message)
				}
			},
			error: function(data){console.log(data)
				alert(data.message)
			}
		})
	})
})
function getUserInfo(companyId){
	$.ajax({
		url: '/jikuang/api/companyinfo/getCompanyDetails.html',
		type: 'POST',
		dataType: 'json',
		success: function(data){
			var rows = data.data;
			if(rows.certState == 'R'){
				$('#infoTitle').html('您的认证信息被驳回，原因是 '+rows.auditRemark+',请修改后重新提交')
				userName.setText(rows.companyName),
				setTimeout(function(){
					localBelong_AB.setProvinceSelect(rows.provCode)
					localBelong_AB.setCitySelect(rows.cityCode)
					localBelong_AB.setCountySelect(rows.areaCode)
				},250)
				address.setText(rows.address),
				contactName.setText(rows.contactName),
				contactPhone.setText(rows.contactTel),
				qq.setText(rows.qq),
				wechat.setText(rows.wx)
			}
		},
		error: function(data){
			
		}
	})
}




