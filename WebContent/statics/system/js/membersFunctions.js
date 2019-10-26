//添加政府用户
function saveNewGoverment(){
	if(govermentName.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入机关名称');
		return
	}
	if(contactName.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入姓名');
		return
	}
	if(positionName.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入职务');
		return
	}
	if(contactPhone.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入联系电话');
		return
	}
	if(contactPhone.getText().length !=11){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入11位联系电话');
		return
	}
	if(administrationLevel.getRadioValue()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请选择行政级别');
		return
	}
	if(userName.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入用户名');
		return
	}
	if(belongArea_AB.getProvinceValue()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请选择所属省');
		return
	}
	if(belongArea_AB.getCityValue()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请选择所属市');
		return
	}
	if(belongArea_AB.getCountyValue()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请选择所属县');
		return
	}
	if(address.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入详细地址');
		return
	}
	$.ajax({
	    url: "/jikuang/system/company/addCompany.html",
	    type: "POST",
	    dataType: "json",
	    data:{
	    	"companyName": govermentName.getText(),
	    	"contactName": contactName.getText(),
	    	"position": positionName.getText(),
	    	"contactTel": contactPhone.getText(),
	    	"accountType": administrationLevel.getRadioValue(),
	    	"username": userName.getText(),
	    	"provCode": belongArea_AB.getProvinceValue(),
	    	"cityCode": belongArea_AB.getCityValue(),
	    	"areaCode": belongArea_AB.getCountyValue(),
	    	"address": address.getText(),
	    	"sysRemark": $.trim(remark.getText())
	    },
	    success: function(returnValue){console.log(returnValue)
	    	if(returnValue.success == true){
	    		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"成功", '添加成功', function(){
		    		//重置
		    		reset()
		    	});
	    	}else{
	    		new WindowPanel().showAlert(WindowPanel.TypeAlertError,"错误", returnValue.message);
	    	}
	    },
	    error: function(returnValue){
	    	new WindowPanel().showAlert(WindowPanel.TypeAlertError,"错误", returnValue.message);
	    }
	});
}
//修改政府详情
function updateGovermentDetails(){
	if(govermentName.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入机关名称');
		return
	}
	if(contactName.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入姓名');
		return
	}
	if(positionName.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入职务');
		return
	}
	if(contactPhone.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入联系电话');
		return
	}
	if(contactPhone.getText().length !=11){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入11位联系电话');
		return
	}
	if(administrationLevel.getRadioValue()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请选择行政级别');
		return
	}
	if(userName.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入用户名');
		return
	}
	if(belongArea_AB.getProvinceValue()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请选择所属省');
		return
	}
	if(belongArea_AB.getCityValue()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请选择所属市');
		return
	}
	if(belongArea_AB.getCountyValue()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请选择所属县');
		return
	}
	if(address.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入详细地址');
		return
	}
	$.ajax({
		url:"/jikuang/system/company/updateCompany.html",
		type: "POST",
    	dataType: "json",
    	data:{
    		"companyId": urlcompanyid,
	    	"companyName": govermentName.getText(),
	    	"contactName": contactName.getText(),
	    	"position": positionName.getText(),
	    	"contactTel": contactPhone.getText(),
	    	"accountType": administrationLevel.getRadioValue(),
	    	"username": userName.getText(),
	    	"provCode": belongArea_AB.getProvinceValue(),
	    	"cityCode": belongArea_AB.getCityValue(),
	    	"areaCode": belongArea_AB.getCountyValue(),
	    	"address": address.getText(),
	    	"sysRemark": $.trim(remark.getText())
		},
		success: function(returnValue){
			if(returnValue.success == true){
				new WindowPanel().showAlert(WindowPanel.TypeAlertOk,"提醒",'修改成功！',function(){
					parent.$('.panel:visible iframe')[0].contentWindow.searchData();
					WindowPanel.closeLastWindow(WindowPanel.TypePage)
				});
			}else{
				new WindowPanel().showAlert(WindowPanel.TypeAlertError,"错误",'信息修改失败！');
			}
		},
		error: function(returnValue){
			new WindowPanel().showAlert(WindowPanel.TypeAlertError,"错误",'信息修改失败！');
		}
	})
}
//添加企业用户
function saveNewEnterprise(){
	if(companyName.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入企业名称');
		return
	}
	if(userName.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入用户名');
		return
	}
	if(belongArea_AB.getProvinceValue()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请选择所属地区省');
		return
	}
	if(belongArea_AB.getCityValue()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请选择所属地区市');
		return
	}
	if(belongArea_AB.getCountyValue()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请选择所属地区县');
		return
	}
	if($('#submitLng').html()=='' && $('#submitLat').html()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请选择详细地址');
		return
	}
	if(contactName.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入联系人');
		return
	}
	if(contactMobile.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入联系电话');
		return
	}
	if(contactMobile.getText().length !=11){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入11位联系电话');
		return
	}
	if(contactQQ.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入联系QQ');
		return
	}
	if(contactWechat.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入联系微信');
		return
	}
	if(ckPermitNum.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入采矿许可证号');
		return
	}
	if($('#ckPermitThumb').attr('src')==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请选择采矿许可证图片');
		return
	}
	if(ckPermitStartDate.getDateText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入采矿许可证有效期开始时间');
		return
	}
	if(ckPermitEndDate.getDateText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入采矿许可证有效期结束时间');
		return
	}
	if(pwPermitNum.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入排污许可证号');
		return
	}
	if($('#pwPermitThumb').attr('src')==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请选择排污许可证图片');
		return
	}
	if(pwPermitStartDate.getDateText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入排污许可证有效期开始时间');
		return
	}
	if(pwPermitEndDate.getDateText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入排污许可证有效期结束时间');
		return
	}
	if(aqscPermitNum.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入安全生产许可证号');
		return
	}
	if($('#aqscPermitThumb').attr('src')==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请选择安全生产许可证图片');
		return
	}
	if(aqscPermitStartDate.getDateText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入安全生产许可证有效期开始时间');
		return
	}
	if(aqscPermitEndDate.getDateText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入安全生产许可证有效期结束时间');
		return
	}
	if(minesType.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入矿种');
		return
	}
	if(producePower.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入生产能力');
		return
	}
	if(reserves.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入储量');
		return
	}
	if($('#companyThumb').attr('src')==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请选择企业图片');
		return
	}
	$.ajax({
	    url: "/jikuang/system/company/addCompany.html",
	    type: "POST",
	    dataType: "json",
	    data:{
	    	"accountType": 'E',
	    	"username": userName.getText(),
	    	"companyName": companyName.getText(),
	    	"contactName": contactName.getText(),
	    	"contactTel": contactMobile.getText(),
	    	"qq": contactQQ.getText(),
	    	"wx": contactWechat.getText(),
	    	"provCode": belongArea_AB.getProvinceValue(),
	    	"cityCode": belongArea_AB.getCityValue(),
	    	"areaCode": belongArea_AB.getCountyValue(),
	    	"address": chooseDetailAddress.getContent(),
	    	"longitude": $('#submitLng').html(),
	    	"latitude": $('#submitLat').html(),
	    	"isMineLicense": ckPermitNum.getText(),
	    	"mineLicenseFile": ckFileId,
	    	"mineLicenseThumb": imgsrcCk,
	    	"mineLicenseValidStartTime": ckPermitStartDate.getDateText(),
	    	"mineLicenseValidStopTime": ckPermitEndDate.getDateText(),
	    	"isSewageLicense": pwPermitNum.getText(),
	    	"sewageLicenseFile": pwFileId,
	    	"sewageLicenseThumb": imgsrcPw,
	    	"sewageLicenseValidStartTime": pwPermitStartDate.getDateText(),
	    	"sewageLicenseValidStopTime": pwPermitEndDate.getDateText(),
	    	"isProductionLicense": aqscPermitNum.getText(),
	    	"productionLicenseFile": aqscFileId,
	    	"productionLicenseThumb": imgsrcAqsc,
	    	"productionLicenseValidStartTime": aqscPermitStartDate.getDateText(),
	    	"productionLicenseValidStopTime": aqscPermitEndDate.getDateText(),
	    	"minesType": minesType.getText(),
	    	"productionYear": producePower.getText(),
	    	"reserves": reserves.getText(),
			"enterpriseGrade": companyRate.getCheckValue().toString(),
	    	"companyFile": fileId,
	    	"companyThumb": imgsrc,
	    	"sysRemark": $.trim(remark.getText())
	    },
	    success: function(returnValue){
	    	if(returnValue.success == true){
		    	new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"成功", '添加成功', function(){
		    		//重置
		    		reset()
		    	});
	    	}else{
	    		new WindowPanel().showAlert(WindowPanel.TypeAlertError,"错误", returnValue.message);
	    	}
	    },
	    error: function(returnValue){
	    	new WindowPanel().showAlert(WindowPanel.TypeAlertError,"错误", returnValue.message);
	    }
	});
}
//修改企业用户详情
function updateEnterpriseDetails(){
	if(companyName.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入企业名称');
		return
	}
	if(userName.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入用户名');
		return
	}
	if(belongArea_AB.getProvinceValue()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请选择所属地区省');
		return
	}
	if(belongArea_AB.getCityValue()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请选择所属地区市');
		return
	}
	if(belongArea_AB.getCountyValue()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请选择所属地区县');
		return
	}
	if(chooseDetailAddress.getContent()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请选择详细地址');
		return
	}
	if(contactName.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入联系人');
		return
	}
	if(contactMobile.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入联系电话');
		return
	}
	if(contactMobile.getText().length !=11){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入11位联系电话');
		return
	}
	if(contactQQ.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入联系QQ');
		return
	}
	if(contactWechat.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入联系微信');
		return
	}
	if(ckPermitNum.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入采矿许可证号');
		return
	}
	if($('#ckPermitThumb').attr('src')==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入采矿许可证图片');
		return
	}
	if(ckPermitStartDate.getDateText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入采矿许可证有效期开始时间');
		return
	}
	if(ckPermitEndDate.getDateText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入采矿许可证有效期结束时间');
		return
	}
	if(pwPermitNum.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入排污许可证号');
		return
	}
	if($('#pwPermitThumb').attr('src')==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入排污许可证图片');
		return
	}
	if(pwPermitStartDate.getDateText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入排污许可证有效期开始时间');
		return
	}
	if(pwPermitEndDate.getDateText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入排污许可证有效期结束时间');
		return
	}
	if(aqscPermitNum.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入安全生产许可证号');
		return
	}
	if($('#aqscPermitThumb').attr('src')==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入安全生产许可证图片');
		return
	}
	if(aqscPermitStartDate.getDateText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入安全生产许可证有效期开始时间');
		return
	}
	if(aqscPermitEndDate.getDateText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入安全生产许可证有效期结束时间');
		return
	}
	if(minesType.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入矿种');
		return
	}
	if(producePower.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入生产能力');
		return
	}
	if(reserves.getText()==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入储量');
		return
	}
	if($('#companyThumb').attr('src')==''){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示", '请输入企业图片');
		return
	}
	$.ajax({
		url:"/jikuang/system/company/updateCompany.html",
	    type: "POST",
	    dataType: "json",
	    data:{
	    	"companyId": urlcompanyid,
	    	"accountType": 'E',
	    	"username": userName.getText(),
	    	"companyName": companyName.getText(),
	    	"contactName": contactName.getText(),
	    	"contactTel": contactMobile.getText(),
	    	"qq": contactQQ.getText(),
	    	"wx": contactWechat.getText(),
	    	"provCode": belongArea_AB.getProvinceValue(),
	    	"cityCode": belongArea_AB.getCityValue(),
	    	"areaCode": belongArea_AB.getCountyValue(),
	    	"address": chooseDetailAddress.getContent(),
	    	"longitude": $('#submitLng').html(),
	    	"latitude": $('#submitLat').html(),
	    	"isMineLicense": ckPermitNum.getText(),
	    	"mineLicenseFile": ckFileId,
	    	"mineLicenseThumb": imgsrcCk,
	    	"mineLicenseValidStartTime": ckPermitStartDate.getDateText(),
	    	"mineLicenseValidStopTime": ckPermitEndDate.getDateText(),
	    	"isSewageLicense": pwPermitNum.getText(),
	    	"sewageLicenseFile": pwFileId,
	    	"sewageLicenseThumb": imgsrcPw,
	    	"sewageLicenseValidStartTime": pwPermitStartDate.getDateText(),
	    	"sewageLicenseValidStopTime": pwPermitEndDate.getDateText(),
	    	"isProductionLicense": aqscPermitNum.getText(),
	    	"productionLicenseFile": aqscFileId,
	    	"productionLicenseThumb": imgsrcAqsc,
	    	"productionLicenseValidStartTime": aqscPermitStartDate.getDateText(),
	    	"productionLicenseValidStopTime": aqscPermitEndDate.getDateText(),
	    	"minesType": minesType.getText(),
	    	"productionYear": producePower.getText(),
	    	"reserves": reserves.getText(),
			"enterpriseGrade": companyRate.getCheckValue().toString(),
	    	"companyFile": fileId,
	    	"companyThumb": imgsrc,
	    	"sysRemark": $.trim(remark.getText())
	    },
	    success: function(returnValue){
	    	if(returnValue.success == true){
		    	new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"成功", '修改成功', function(){
		    		parent.$('.panel:visible iframe')[0].contentWindow.searchData();
		    		WindowPanel.closeLastWindow(WindowPanel.TypePage)
		    	});
	    	}else{
	    		new WindowPanel().showAlert(WindowPanel.TypeAlertError,"错误", returnValue.message);
	    	}
	    },
	    error: function(returnValue){
	    	new WindowPanel().showAlert(WindowPanel.TypeAlertError,"错误", returnValue.message);
	    }
	});
}

//重置密码
function resetPassword(){
	new WindowPanel().showConfirm(WindowPanel.TypeConfirmAsk,"确认", '您确定重置密码？（重置后密码为联系方式后6位）', function(r){
		if(r) {
			$.ajax({
			    url: "/jikuang/system/company/resetCompanyPassword.html",
			    type: "POST",
			    dataType: "json",
			    data:{'companyId': urlcompanyid},
			    success: function(returnValue){
			    	if(returnValue.success){
			    		new WindowPanel().showAlert(WindowPanel.TypeAlertOk,"提醒",'密码重置成功！（默认为联系方式后6位）',function(){
				    		WindowPanel.closeLastWindow(WindowPanel.TypePage)
			    		});
			    	}else if(returnValue.success==false){
			    		new WindowPanel().showAlert(WindowPanel.TypeAlertError,"错误",returnValue.message);
			    	}
			    },
			    error: function(returnValue){
			    	new WindowPanel().showAlert(WindowPanel.TypeAlertError,"错误",returnValue.message);
			    }
			});
		}
	});
}
//删除用户
function deleteAccount(){
	new WindowPanel().showConfirm(WindowPanel.TypeConfirmAsk,"确认删除", '您确定删除该用户吗？', function(r){
		if(r) {
			$.ajax({
			    url: "/jikuang/system/company/deleteCompany.html",
			    type: "POST",
			    dataType: "json",
			    data:{'companyId': urlcompanyid},
			    success: function(returnValue){
			    	new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"成功", '该用户已删除', function(){
			    		//刷新
						parent.$('.panel:visible iframe')[0].contentWindow.searchData();
			    		//关闭
			    		WindowPanel.closeLastWindow(WindowPanel.TypePage);
			    	});
			    },
			    error: function(returnValue){
			    	new WindowPanel().showAlert(WindowPanel.TypeAlertError,"错误",returnValue.message);
			    }
			});
		}
	});
}
//添加广告
function addAdvertisement(){
	$.ajax({
		url : "/jikuang/system/manager/addAdvertisement.html",
	    type: "POST",
	    dataType: "json",
	    data:{
	    	"imgThumb": imgsrc,
	    	"imgFile": fileId,
	    	"isEnable": visibleState.getRadioValue(),
	    	"listOrder": listOrder.getText(),
	    	"remark": remark.getText()
	    },
	    success: function(returnValue){
	    	if(returnValue.success == true){
	    		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"成功", returnValue.message, function(){
	    			reset()
		    	});
	    	}else{
	    		new WindowPanel().showAlert(WindowPanel.TypeAlertError,"错误",returnValue.message);
	    	}
	    },
	    error: function(returnValue){
	    	new WindowPanel().showAlert(WindowPanel.TypeAlertError,"错误",returnValue.message);
	    }
	});
}
//编辑广告
function updateAdDetails(){
	$.ajax({
		url : "/jikuang/system/manager/updateAdvertisement.html",
	    type: "POST",
	    dataType: "json",
	    data:{
	    	"carouselId": urlcarouselid,
	    	"imgThumb": imgsrc,
	    	"imgFile": fileId,
	    	"isEnable": visibleState.getRadioValue(),
	    	"listOrder": listOrder.getText(),
	    	"remark": remark.getText()
	    },
	    success: function(returnValue){
	    	if(returnValue.success == true){
	    		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"成功", returnValue.message, function(){
	    			parent.$('.panel:visible iframe')[0].contentWindow.searchData();
		    		WindowPanel.closeLastWindow(WindowPanel.TypePage)
		    	});
	    	}else{
	    		new WindowPanel().showAlert(WindowPanel.TypeAlertError,"错误",returnValue.message);
	    	}
	    },
	    error: function(returnValue){
	    	new WindowPanel().showAlert(WindowPanel.TypeAlertError,"错误",returnValue.message);
	    }
	});
}
//删除广告
function deleteAd(){
	new WindowPanel().showConfirm(WindowPanel.TypeConfirmAsk,"确认删除", '您确定删除该广告吗？', function(r){
		if(r) {
			$.ajax({
				url : "/jikuang/system/manager/updateStsAdvertisement.html",
			    type: "POST",
			    dataType: "json",
			    data:{"carouselId": urlcarouselid},
			    success: function(returnValue){
			    	if(returnValue.success == true){
			    		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"成功", returnValue.message, function(){
			    			parent.$('.panel:visible iframe')[0].contentWindow.searchData();
				    		WindowPanel.closeLastWindow(WindowPanel.TypePage)
				    	});
			    	}else{
			    		new WindowPanel().showAlert(WindowPanel.TypeAlertError,"错误",returnValue.message);
			    	}
			    },
			    error: function(returnValue){
			    	new WindowPanel().showAlert(WindowPanel.TypeAlertError,"错误",returnValue.message);
			    }
			});
		}
	});
}





