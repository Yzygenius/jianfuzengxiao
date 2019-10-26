var pageSize =5;
var mapLng,mapLat,companyid,submitnewsid,editorAddContent,editor;
var goodTrendid,goodsid;
var edittransactionid;
var imgsrc,rate,upload,companyFileId;
var imgsrcCk,rateCk,uploadCk,ckFileId,imgsrcPw,ratePw,uploadPw,pwFileId,imgsrcAqsc,rateAqsc,uploadAqsc,aqscFileId;
var imgsrc1,rate1,upload1,imgsrcId1;
$(function(){
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
		})
	})
//基本信息
	companyName_IT = new InputText("#companyName_IT",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#companyName_IT input').attr('placeholder','请输入企业名称')
	
	localProvince_AB = new AreaBox('#localProvince_AB',AreaBox.TypeCounty);

	localAddress_IT = new InputText("#localAddress_IT",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#localAddress_IT input').attr('placeholder','请选择企业地址');
	$('#localAddress_IT').append('<span id="chooseAddressBtn">选择地址</span>')
	
	contactName_IT = new InputText("#contactName_IT",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#contactName_IT input').attr('placeholder','请输入联系人')
	
	contactPhone_IT = new InputText("#contactPhone_IT",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#contactPhone_IT input').attr('placeholder','请输入联系电话')
	
	contactQQ_IT = new InputText("#contactQQ_IT",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#contactQQ_IT input').attr('placeholder','请输入QQ')
	
	contactWeChat_IT = new InputText("#contactWeChat_IT",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#contactWeChat_IT input').attr('placeholder','请输入微信')
	
	ckPermit_IT = new InputText("#ckPermit_IT",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#ckPermit_IT input').attr('placeholder','请输采矿许可证号')
	ckPermitStartDate_IT = new DateBox('#ckPermitStartDate_IT',DateBox.TypeDay);
	ckPermitEndDate_IT = new DateBox('#ckPermitEndDate_IT',DateBox.TypeDay);
	
	pwPermit_IT = new InputText("#pwPermit_IT",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#pwPermit_IT input').attr('placeholder','请输入排污许可证号')
	pwPermitStartDate_IT = new DateBox('#pwPermitStartDate_IT',DateBox.TypeDay);
	pwPermitEndDate_IT = new DateBox('#pwPermitEndDate_IT',DateBox.TypeDay);
	
	aqscPermit_IT = new InputText("#aqscPermit_IT",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#aqscPermit_IT input').attr('placeholder','请输入安全生产许可证号')
	aqscPermitStartDate_IT = new DateBox('#aqscPermitStartDate_IT',DateBox.TypeDay);
	aqscPermitEndDate_IT = new DateBox('#aqscPermitEndDate_IT',DateBox.TypeDay);
	
	//公司图片
	//certThumb_Btn = new Button("#certThumb_Btn",ImageIcon.Fangdajing_W,"",Button.TypeImportant,Button.SizeShort);
	uploadImages_Btn = new Button("#uploadImages_Btn",ImageIcon.Tupian_W,"选择图片",Button.TypeFa,Button.SizeLong);
	//采矿许可证照片
	uploadImagesCk_Btn = new Button("#uploadImagesCk_Btn",ImageIcon.Tupian_W,"选择图片",Button.TypeFa,Button.SizeLong);
	//排污许可证照片
	uploadImagesPw_Btn = new Button("#uploadImagesPw_Btn",ImageIcon.Tupian_W,"选择图片",Button.TypeFa,Button.SizeLong);
	//安全生产许可证照片
	uploadImagesAqsc_Btn = new Button("#uploadImagesAqsc_Btn",ImageIcon.Tupian_W,"选择图片",Button.TypeFa,Button.SizeLong);
	/*certThumb_Btn.bindEvent('click',function(){
		new WindowPanel().showImage("营业执照", "/dazong/"+returnData.certThumb);
	});*/
	
	mainProduct_IT = new InputText("#mainProduct_IT",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#mainProduct_IT input').attr('placeholder','请输入矿种')
	productivity_IT = new InputText("#productivity_IT",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#productivity_IT input').attr('placeholder','请输入年产量')
	keepWeight_IT = new InputText("#keepWeight_IT",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#keepWeight_IT input').attr('placeholder','请输入储量')
	var companyRateData = [{"value":"A","text":"正面清单企业","radio": true},{"value":"B","text":"正面清单申请中"},{"value":"C","text":"知名企业"}];
	companyRate_CB = new CheckBox("#companyRate_CB",companyRateData);
	companyProduce_TA = new TextArea('#companyProduce_TA',TextArea.DisTypeTable);
	$('#companyProduce_TA textarea').attr('id','companyProduce')
	
	editor = KindEditor.create('#companyProduce',{
		//指定上传文件参数名称
        filePostName : "uploadFile",
    	uploadJson : '/jikuang/statics/api/js/kindeditor/jsp/upload_json.jsp',
        fileManagerJson : '/jikuang/statics/api/js/kindeditor/jsp/file_manager_json.jsp',
        allowFileManager : true,
        dir : "image"
	});
	
	
	
	getUserInfo();
	scroll();
	
	//点击上传图片按钮
	uploadImages_Btn.bindEvent('click',function(){
		$('#uploadImages').click();
	})
	uploadImagesCk_Btn.bindEvent('click',function(){
		$('#uploadImagesCk').click();
	})
	uploadImagesPw_Btn.bindEvent('click',function(){
		$('#uploadImagesPw').click();
	})
	uploadImagesAqsc_Btn.bindEvent('click',function(){
		$('#uploadImagesAqsc').click();
	})
	//更换图片预览
	$('#uploadImages').change(function(){
		var objUrl = getObjectURL(this.files[0]) ; //获取图片的路径，该路径不是图片在本地的路径
        if (objUrl) {
            $("#certThumb").attr("src", objUrl) ; //将图片路径存入src中，显示出图片
        }
        upload=true;
        //上传图片
		fileObj=$('#uploadImages')[0].files[0];
		var formFile = new FormData();
        formFile.append("action", "/jikuang/api/common/uploadImage.html");  
        formFile.append("file", fileObj); //加入文件对象
        var data = formFile;
        $.ajax({
            url: "/jikuang/api/common/uploadImage.html",
            data: data,
            type: "POST",
            dataType: "json",
            cache: false,//上传文件无需缓存
            processData: false,//用于对data参数进行序列化处理 这里必须false
            contentType: false, //必须
            success: function (result) {
            	companyFileId=result.data.fileId; 
    			imgsrc=result.data.saveName;  
    			rate=true;
    			//uploadHeadImage(imgsrc);
           },
       })
	})
	$('#uploadImagesCk').change(function(){
		var objUrl = getObjectURL(this.files[0]) ; //获取图片的路径，该路径不是图片在本地的路径
        if (objUrl) {
            $("#ckPermitThumb").attr("src", objUrl) ; //将图片路径存入src中，显示出图片
        }
        uploadCk=true;
        //上传图片
		fileObj=$('#uploadImagesCk')[0].files[0];
		var formFile = new FormData();
        formFile.append("action", "/jikuang/api/common/uploadImage.html");  
        formFile.append("file", fileObj); //加入文件对象
        var data = formFile;
        $.ajax({
            url: "/jikuang/api/common/uploadImage.html",
            data: data,
            type: "POST",
            dataType: "json",
            cache: false,//上传文件无需缓存
            processData: false,//用于对data参数进行序列化处理 这里必须false
            contentType: false, //必须
            success: function (result) {
            	ckFileId=result.data.fileId;
    			imgsrcCk=result.data.saveName;  
    			rateCk=true;
    			//uploadHeadImage(imgsrc);
           },
       })
	})
	$('#uploadImagesPw').change(function(){
		var objUrl = getObjectURL(this.files[0]) ; //获取图片的路径，该路径不是图片在本地的路径
        if (objUrl) {
            $("#pwPermitThumb").attr("src", objUrl) ; //将图片路径存入src中，显示出图片
        }
        uploadPw=true;
        //上传图片
		fileObj=$('#uploadImagesPw')[0].files[0];
		var formFile = new FormData();
        formFile.append("action", "/jikuang/api/common/uploadImage.html");  
        formFile.append("file", fileObj); //加入文件对象
        var data = formFile;
        $.ajax({
            url: "/jikuang/api/common/uploadImage.html",
            data: data,
            type: "POST",
            dataType: "json",
            cache: false,//上传文件无需缓存
            processData: false,//用于对data参数进行序列化处理 这里必须false
            contentType: false, //必须
            success: function (result) {
            	pwFileId=result.data.fileId;
    			imgsrcPw=result.data.saveName;  
    			ratePw=true;
    			//uploadHeadImage(imgsrc);
           },
       })
	})
	$('#uploadImagesAqsc').change(function(){
		var objUrl = getObjectURL(this.files[0]) ; //获取图片的路径，该路径不是图片在本地的路径
        if (objUrl) {
            $("#aqscPermitThumb").attr("src", objUrl) ; //将图片路径存入src中，显示出图片
        }
        uploadAqsc=true;
        //上传图片
		fileObj=$('#uploadImagesAqsc')[0].files[0];
		var formFile = new FormData();
        formFile.append("action", "/jikuang/api/common/uploadImage.html");  
        formFile.append("file", fileObj); //加入文件对象
        var data = formFile;
        $.ajax({
            url: "/jikuang/api/common/uploadImage.html",
            data: data,
            type: "POST",
            dataType: "json",
            cache: false,//上传文件无需缓存
            processData: false,//用于对data参数进行序列化处理 这里必须false
            contentType: false, //必须
            success: function (result) {
            	aqscFileId=result.data.fileId;
    			imgsrcAqsc=result.data.saveName;  
    			rateAqsc=true;
    			//uploadHeadImage(imgsrc);
           },
       })
	})
	
	//点击确定
	$('#submit').click(function(){
		if(companyName_IT.getText() == ''){
			alert('请输入企业名称！')
			return
		}
		if(localProvince_AB.getProvinceValue() == ''){
			alert('请选择所在地省份！')
			return
		}
		if(localProvince_AB.getCityValue() == ''){
			alert('请选择所在地城市！')
			return
		}
		if(localProvince_AB.getCountyValue() == ''){
			alert('请选择所在地县镇！')
			return
		}
		if(localAddress_IT.getText() == ''){
			alert('请选择企业地址！')
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
		if(ckPermit_IT.getText() == ''){
			alert('请输入采矿许可证号！')
			return
		}
		if(ckFileId == '' || ckFileId == undefined){
			alert('请选择采矿许可证图片！')
			return
		}
		if(ckPermitStartDate_IT.getDateText() == ''){
			alert('请选择采矿许可证有效期起始时间！')
			return
		}
		if(ckPermitEndDate_IT.getDateText() == ''){
			alert('请选择采矿许可证有效期终止时间！')
			return
		}
		if(pwPermit_IT.getText() == ''){
			alert('请输入排污许可证号！')
			return
		}
		if(pwFileId == '' || pwFileId == undefined){
			alert('请选择排污许可证图片！')
			return
		}
		if(pwPermitStartDate_IT.getDateText() == ''){
			alert('请选择排污许可证有效期起始时间！')
			return
		}
		if(pwPermitEndDate_IT.getDateText() == ''){
			alert('请选择排污许可证有效期终止时间！')
			return
		}
		if(aqscPermit_IT.getText() == ''){
			alert('请输入安全生产许可证号！')
			return
		}
		if(aqscFileId == '' || aqscFileId == undefined){
			alert('请选择安全生产许可证图片！')
			return
		}
		if(aqscPermitStartDate_IT.getDateText() == ''){
			alert('请选择安全生产许可证有效期起始时间！')
			return
		}
		if(aqscPermitEndDate_IT.getDateText() == ''){
			alert('请选择安全生产许可证有效期终止时间！')
			return
		}
		if(mainProduct_IT.getText() == ''){
			alert('请输入矿种！')
			return
		}
		if(productivity_IT.getText() == ''){
			alert('请输入生产能力！')
			return
		}
		if(keepWeight_IT.getText() == ''){
			alert('请输入储量！')
			return
		}
		if(companyFileId == '' || companyFileId == undefined){
			alert('请选择企业图片！')
			return
		}
		if(editor.html() == ''){
			alert('请输入企业简介！')
			return
		}
		$.ajax({
			url: "/jikuang/api/companyinfo/updateCompanyInfo.html",
			type: "POST",
			dataType: "json",
			data: {
				"companyId": companyid,
				"companyName": companyName_IT.getText(),
				"provCode": localProvince_AB.getProvinceValue(),
				"cityCode": localProvince_AB.getCityValue(),
				"areaCode": localProvince_AB.getCountyValue(),
				"address": localAddress_IT.getText(),
				"longitude": mapLng,
				"latitude": mapLat,
				"contactName": contactName_IT.getText(),
				"contactTel": contactPhone_IT.getText(),
				"qq": contactQQ_IT.getText(),
				"wx": contactWeChat_IT.getText(),
				"isMineLicense": ckPermit_IT.getText(),
				"mineLicenseFile": ckFileId,
				"mineLicenseThumb": imgsrcCk,
				"mineLicenseValidStartTime": ckPermitStartDate_IT.getDateText(),
				"mineLicenseValidEndTime": ckPermitEndDate_IT.getDateText(),
				"isSewageLicense": pwPermit_IT.getText(),
				"sewageLicenseFile": pwFileId,
				"sewageLicenseThumb": imgsrcPw,
				"sewageLicenseValidStartTime": pwPermitStartDate_IT.getDateText(),
				"sewageLicenseValidEndTime": pwPermitEndDate_IT.getDateText(),
				"isProductionLicense": aqscPermit_IT.getText(),
				"productionLicenseFile": aqscFileId,
				"productionLicenseThumb": imgsrcAqsc,
				"productionLicenseValidStartTime": aqscPermitStartDate_IT.getDateText(),
				"productionLicenseValidEndTime": aqscPermitEndDate_IT.getDateText(),
				"minesType": mainProduct_IT.getText(),
				"productionYear": productivity_IT.getText(),
				"reserves": keepWeight_IT.getText(),
				"enterpriseGrade": companyRate_CB.getCheckValue().toString(),
				"companyFile": companyFileId,
				"companyThumb": imgsrc,
				"companySynopsis": editor.html(),
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
	})
	//点击取消
	$('#cancle').click(function(){
		getUserInfo()
	})
	
	
	
	
	
//主营产品
	companyImage_IT = new InputText("#companyImage_IT",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#companyImage_IT input').attr('placeholder','请输入公司图片')
	productName = new InputText("#productName",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#productName input').attr('placeholder','请输入产品名称')
	productKind = new InputText("#productKind",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#productKind input').attr('placeholder','请输入产品类别')
	productThumb_Btn = new Button("#productThumb_Btn",ImageIcon.Fangdajing_W,"",Button.TypeImportant,Button.SizeShort);
	uploadImages1_Btn = new Button("#uploadImages1_Btn",ImageIcon.Tupian_W,"选择图片",Button.TypeFa,Button.SizeLong);
	productParam_TA = new TextArea('#productParam_TA',TextArea.DisTypeLong)
	$('#productParam_TA textarea').attr('id','productParam')
	remark_TA = new TextArea('#remark_TA',TextArea.DisTypeTable)
	
	editorProductParam = KindEditor.create('#productParam',{
		//指定上传文件参数名称
        filePostName : "uploadFile",
    	uploadJson : '/jikuang/statics/api/js/kindeditor/jsp/upload_json.jsp',
        fileManagerJson : '/jikuang/statics/api/js/kindeditor/jsp/file_manager_json.jsp',
        allowFileManager : true,
        dir : "image"
	});
	

	getProductInfo();
	
	//产品图片
	//点击上传图片按钮
	uploadImages1_Btn.bindEvent('click',function(){
		$('#uploadImages1').click();
	})
	//更换图片预览
	$('#uploadImages1').change(function(){
		var objUrl = getObjectURL(this.files[0]) ; //获取图片的路径，该路径不是图片在本地的路径
        if (objUrl) {
            $("#productThumb").attr("src", objUrl) ; //将图片路径存入src中，显示出图片
        }
        upload1=true;
        //上传图片
		fileObj=$('#uploadImages1')[0].files[0];
		var formFile = new FormData();
        formFile.append("action", "/jikuang/api/common/uploadImage.html");  
        formFile.append("file", fileObj); //加入文件对象
        var data = formFile;
        $.ajax({
            url: "/jikuang/api/common/uploadImage.html",
            data: data,
            type: "POST",
            dataType: "json",
            cache: false,//上传文件无需缓存
            processData: false,//用于对data参数进行序列化处理 这里必须false
            contentType: false, //必须
            success: function (result) {
            	imgsrcId1=result.data.fileId; 
    			imgsrc1=result.data.saveName;  
    			rate=true;
    			//uploadHeadImage(imgsrc);
           },
       })
	})
	
	//点击确定
	$('#priceSubmit').click(function(){
		if(productName.getText() == ''){
			alert('请输入产品名称！')
			return
		}
		if(imgsrcId1 == '' || imgsrcId1 == undefined){
			alert('请选择产品图片！')
			return
		}
		if(productKind.getText() == ''){
			alert('请输入产品类别！')
			return
		}
		if(editorProductParam.html() == ''){
			alert('请输入产品参数！')
			return
		}
		/*if(productPrice.getText() == ''){
			alert('请输入产品价格！')
			return
		}*/
		$.ajax({
			url: "/jikuang/api/goodsinfo/updateGoodsInfo.html",
			type: "POST",
			dataType: "json",
			data: {
				'goodsId': goodsid,
				'productName': productName.getText(),
				'productType': productKind.getText(),
				'imgFile': imgsrcId1,
				'imgThumb': imgsrc1,
				'parameter': editorProductParam.html(),
				'introduction': remark_TA.getText(),
				'companyId': companyid
			},
			success: function(data){
				if(data.success == true){
					alert('产品信息修改成功！')
					$('#editProductName').html('')
					editProductName = new Combox("#editProductName",Combox.TypeProductType);
				}
			},
			error: function(data){
				alert('产品信息修改失败')
			}
		})
	})
	
//生产数据
	editProductName = new Combox("#editProductName",Combox.TypeProductType);
	$('#editProductName text').css({'font-size':'18px'})
	editWeight = new InputText("#editWeight",InputText.TypeFloor,InputText.DisTypeTable,30);
	editPrice = new InputText("#editPrice",InputText.TypeFloor,InputText.DisTypeTable,30);
	editDate = new DateBox('#editDate',DateBox.TypeDay);
	produceDataSearchStartDate = new DateBox('#produceDataSearchStartDate',DateBox.TypeDay);
	$('#produceDataSearchStartDate').css({'float':'left','text-align':'left','border-radius':'5px'})
	produceDataSearchEndDate = new DateBox('#produceDataSearchEndDate',DateBox.TypeDay);
	$('#produceDataSearchEndDate').css({'float':'left','text-align':'left','border-radius':'5px'})
	
	//获取生产数据
	getProduceDataInfo()
	//点击搜索按钮
	$('#produceDataSearchBtn').click(function(){
		getProduceDataInfo()
	})
	//点击添加按钮
	$('#addProduceData').click(function(){
		$('#produceDataList').hide()
		$('#editProduceData').show()
	})
	//添加生产数据
	$('#produceDataSubmitBtn').click(function(){
		addProduceData()
	})
	//点击取消按钮
	$('#produceDataCancleBtn').click(function(){
		$('#editProduceData').hide()
		$('#produceDataList').show()
		produceDataClear()
	})
	
//企业动态
	dynamicsKeyWord = new InputText("#dynamicsKeyWord",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#dynamicsKeyWord input').attr('placeholder','请输入关键字')
	addTitle_IT = new InputText("#addTitle_IT",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#addTitle_IT input').attr('placeholder','请输入标题')
	addSynopsis_IT = new InputText("#addSynopsis_IT",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#addSynopsis_IT input').attr('placeholder','请输入简介')
	auditState = new InputText("#auditState",InputText.TypeNormal,InputText.DisTypeTable,30);
	auditState.setDisable(true)
	auditMessage = new InputText("#auditMessage",InputText.TypeNormal,InputText.DisTypeTable,30);
	auditMessage.setDisable(true)
	addContent_TA = new TextArea('#addContent_TA',TextArea.DisTypeLong)
	$('#addContent_TA textarea').attr('id','addContent')
	
	editorAddContent = KindEditor.create('#addContent',{
		//指定上传文件参数名称
        filePostName : "uploadFile",
    	uploadJson : '/jikuang/statics/api/js/kindeditor/jsp/upload_json.jsp',
        fileManagerJson : '/jikuang/statics/api/js/kindeditor/jsp/file_manager_json.jsp',
        allowFileManager : true,
        dir : "image"
	});
	
	$('#dynamicsSearchBtn').click(function(){
		var keyword = dynamicsKeyWord.getText();
		searchData(1,keyword)
	})
	$('#addDynamicsBtn').click(function(){
		clearDynamics()
		$('#dynamicsAuditMessage').hide()
		$('#dynamicsAudit').hide()
		$('#dynamicsList').hide();
		$('#editDynamics').show();
		$('#editDynamicsSubmit').hide()
		$('#deleteDynamicsCancle').hide()
		$('#addDynamicsSubmit').show()
	})
	$('#addDynamicsCancle').click(function(){
		$('#editDynamics').hide();
		$('#dynamicsList').show();
	})
	
	
	
	//点击确定
	$('#addDynamicsSubmit').click(function(){
		if(addTitle_IT.getText() == ''){
			alert('请输入标题！')
			return
		}
		if(addSynopsis_IT.getText() == ''){
			alert('请输入简介！')
			return
		}
		if(editorAddContent.html() == ''){
			alert('请输入内容！')
			return
		}
		$.ajax({
			url: "/jikuang/api/newsinfo/addNewsInfo.html",
			type: "POST",
			dataType: "json",
			data: {
				/*'newsType': 'B',
				'companyId': companyid,*/
				'title': addTitle_IT.getText(),
				'introduction': addSynopsis_IT.getText(),
				'content': editorAddContent.html()
				//'coverThumb': imgsrcAdd
			},
			success: function(data){
				if(data.success == true){
					alert('提交成功！')
					$('#editDynamics').hide();
					$('#dynamicsList').show();
					clearDynamics()
					searchData()
				}else{
					console.log(data)
					alert('提交失败')
				}
			},
			error: function(data){
				alert('提交失败')
			}
		
		
		})
	})
	//点击确定修改
	$('#editDynamicsSubmit').click(function(){
		$.ajax({
			url: "/jikuang/api/newsinfo/updateNewsInfo.html",
			type: "POST",
			dataType: "json",
			data: {
				//'newsType': 'B',
				'newsId': submitnewsid,
				'title': addTitle_IT.getText(),
				'introduction': addSynopsis_IT.getText(),
				'content': editorAddContent.html()
			},
			success: function(data){
				if(data.success == true){
					alert('修改成功！')
					$('#editDynamics').hide();
					$('#dynamicsList').show();
					clearDynamics()
					searchData()
				}
			},
			error: function(data){
				alert('修改失败')
			}
		
		
		})
	})
	//点击删除
	$('#deleteDynamicsCancle').click(function(){
		var r=confirm("确定要删除吗？");
		if (r==true){
			$.ajax({
				url: "/jikuang/api/newsinfo/updateStsNewsInfo.html",
				type: "POST",
				dataType: "json",
				data: {'newsId': submitnewsid},
				success: function(data){
					if(data.success == true){
						alert('删除成功！')
						$('#editDynamics').hide();
						$('#dynamicsList').show();
						clearDynamics()
						searchData()
					}
				},
				error: function(data){
					alert('修改失败')
				}
			})
		}
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
		$('#tradeInfoDetail').hide()
		$('#goodsSupply').hide()
		$('#tradeInfoContent').show()
	})
	//点击我要供货按钮
	$('#supplyGoodsBtn').click(function(){
		$('#tradeInfoDetail').hide()
		$('#goodsSupply').show()
		
	})
	
//我的交易信息
	myTradeInfoType = new InputText("#myTradeInfoType",InputText.TypeNormal,InputText.DisTypeTable,30);
	var tradeStyleData = [{"value":"B","text":"购买"},{"value":"S","text":"出售"}];
	myTradeInfoStyle = new RadioBox("#myTradeInfoStyle",tradeStyleData);
	myTradeInfoYield = new InputText("#myTradeInfoYield",InputText.TypeFloor,InputText.DisTypeTable,30);
	myTradeInfoPrice = new InputText("#myTradeInfoPrice",InputText.TypeFloor,InputText.DisTypeTable,30);
	myTradeInfoStartDate = new DateBox('#myTradeInfoStartDate',DateBox.TypeDay);
	myTradeInfoEndDate = new DateBox('#myTradeInfoEndDate',DateBox.TypeDay);
	myTradeInfoContactName = new InputText("#myTradeInfoContactName",InputText.TypeNormal,InputText.DisTypeTable,30);
	myTradeInfoContactPhone = new InputText("#myTradeInfoContactPhone",InputText.TypeTel,InputText.DisTypeTable,11);
	myTradeInfoRemark = new TextArea('#myTradeInfoRemark_TA',TextArea.DisTypeTable);
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
	
	//获取我的交易信息列表
	getMyTradeMessage()
	//点击搜索按钮
	$('#myTradeInfoSearchBtn').click(function(){
		getMyTradeMessage()
	})
	//点击添加按钮
	$('#addTradeInfo').click(function(){
		$('#myTradeInfo').hide()
		$('#addMyTradeInfo').show()
		$('#myTradeInfoEditBtn').hide()
		$('#deleteMyTradeInfo').hide()
		$('#myTradeInfoSubmitBtn').show()
	})
	//点击确认按钮
	$('#myTradeInfoSubmitBtn').click(function(){
		addMyTradeMessage()
	})
	//点击确认修改按钮
	$('#myTradeInfoEditBtn').click(function(){
		editMyTradeMessage()
		
	})
	//点击删除按钮
	$('#deleteMyTradeInfo').click(function(){
		var r=confirm("确定要删除吗？");
		if (r==true){
			deleteMyTradeInfo()
		}
	})
	//点击取消按钮
	$('#myTradeInfoCancleBtn').click(function(){
		$('#addMyTradeInfo').hide()
		$('#myTradeInfo').show()
		$('#myTradeInfoEditBtn').hide()
		$('#myTradeInfoSubmitBtn').hide()
		$('#deleteMyTradeInfo').hide()
		clearMyTradenfo()
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
//获取用户信息
function getUserInfo(){
	$.ajax({
		url: "/jikuang/api/companyinfo/getCompanyDetails.html",
		type: "POST",
		dataType: "json",
		success: function(data){
			if(data.success == true && data.data != ''){
				var rows = data.data;
				companyid = rows.companyId;
				searchData()
				$('#enterpriseName').html(rows.companyName)
				$('#enterpriseImage img').attr('src','/jikuang/'+rows.companyThumb)
				$('.enterprisePhone').html(rows.username)
				for(var i=0;i<rows.competitiveValue.length;i++){
					$('.enterpriseStar').html('')
					$('.enterpriseStar').append('<img src="/jikuang/statics/api/images/star.png">')
				}
				if(rows.isRecommend == 'A'){
					$('.ynStarCompany').html('否')
				}else{
					$('.ynStarCompany').html('是')
				}
				companyName_IT.setText(rows.companyName)
				setTimeout(function(){
					localProvince_AB.setProvinceSelect(rows.provCode)
					localProvince_AB.setCitySelect(rows.cityCode)
					localProvince_AB.setCountySelect(rows.areaCode)
				},500)
				localAddress_IT.setText(rows.address)
				mapLng=rows.longitude;
				mapLat=rows.latitude;
				contactName_IT.setText(rows.contactName)
				contactPhone_IT.setText(rows.contactTel)
				contactQQ_IT.setText(rows.qq)
				contactWeChat_IT.setText(rows.wx)
				editor.html(rows.companySynopsis)
				ckPermit_IT.setText(rows.isMineLicense)
				ckFileId = rows.mineLicenseFile
				imgsrcCk = rows.mineLicenseThumb
				$('#ckPermitThumb').attr('src','/jikuang/'+rows.mineLicenseThumb)
				ckPermitStartDate_IT.setDateText(rows.mineLicenseValidStartTime)
				ckPermitEndDate_IT.setDateText(rows.mineLicenseValidStopTime)
				pwPermit_IT.setText(rows.isSewageLicense)
				pwFileId = rows.sewageLicenseFile
				imgsrcPw = rows.sewageLicenseThumb
				$('#pwPermitThumb').attr('src','/jikuang/'+rows.sewageLicenseThumb)
				pwPermitStartDate_IT.setDateText(rows.sewageLicenseValidStartTime)
				pwPermitEndDate_IT.setDateText(rows.sewageLicenseValidStopTime)
				aqscPermit_IT.setText(rows.isProductionLicense)
				aqscFileId = rows.productionLicenseFile 
				imgsrcAqsc = rows.productionLicenseThumb 
				$('#aqscPermitThumb').attr('src','/jikuang/'+rows.productionLicenseThumb)
				aqscPermitStartDate_IT.setDateText(rows.productionLicenseValidStartTime)
				aqscPermitEndDate_IT.setDateText(rows.productionLicenseValidStopTime)
				mainProduct_IT.setText(rows.minesType)
				productivity_IT.setText(rows.productionYear)
				keepWeight_IT.setText(rows.reserves)
				companyRate_CB.setCheckValue(rows.enterpriseGrade)
				companyFileId = rows.companyFile 
				imgsrc = rows.companyThumb 
				$('#certThumb').attr('src','/jikuang/'+rows.companyThumb)
			}
			
		},
		error: function(data){
			alert('获取信息失败')
		}
	})
}
//获取主营产品信息
function getProductInfo(){
	$.ajax({
		url: "/jikuang/api/goodsinfo/getGoodsInfoLast.html",
		type: "POST",
		dataType: "json",
		data:{'companyId': companyid},
		success: function(data){
			var rows = data.data;
			goodsid = rows.goodsId
			productName.setText(rows.productName)
			//editProductName.setSelect(rows.productName)
			//$('#productThumb').attr('src','/jikuang/'+rows.imgThumb);
			imgsrcId1 = rows.imgFile
		    imgsrc1 = rows.imgThumb
			$('#productThumb').attr('src','/jikuang/'+rows.imgThumb);
			productKind.setText(rows.productType)
			editorProductParam.html(rows.parameter)
			remark_TA.setText(rows.introduction)
			
		}
	})
}

//获取企业动态
function searchData(page,keyword){
	if(page == '' || page == null){
		page=1;
	}
	$.ajax({
		url: "/jikuang/api/newsinfo/getCompanyNewsPage.html",
		type: "POST",
		dataType: "json",
		data: {'title': keyword},
		/*data:{'newsType': 'B','page': page,'pageSize': pageSize,'title': keyword,'companyId': companyid},*/
		success: function(data){
			if(data.success == true){
				pageinfo(data.data.page,data.data.pageCount,'#dynamicsList');
				var rows = data.data.rows;
				$('#companyCulture table tr').eq(0).siblings().remove();
				for(var i=0;i<rows.length;i++){
					if(rows[i].auditState == 'C'){
						var state = '已审核'
					}else if(rows[i].auditState == 'R'){
						var state = '已驳回'
					}else if(rows[i].auditState == 'B'){
						var state = '待审核'
					}
					var dynamicsNews = '<tr>'+
										'<td style="text-align:center;">'+(i + 1)+'</td>'+
										'<td style="text-align:left;text-indent:20px;"><div style="color: #fa6d35;cursor: pointer;max-width: 600px;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;" onclick=checkNewsDetail('+rows[i].newsId+',6)>'+rows[i].title+'</div></td>'+
										'<td style="text-align:center;">'+rows[i].createTime+'</td>'+
										'<td style="text-align:center;">'+state+'</td>'+
										'<td style="text-align:center;"><div class="dynamicsNewsEdit" onclick=dblDynamics('+rows[i].newsId+') >编辑</div></td>'+
									'</tr>';
					$('#companyCulture table').append(dynamicsNews);
				}
				
			}
		}	
	})
}
function checkNewsDetail(newsid,page){
	window.open('/jikuang/news/topld.html?newsId='+newsid+'&page='+page)
}
//编辑动态
function dblDynamics(newsid){
	clearDynamics()
	$('#dynamicsAudit').show()
	$('#addDynamicsSubmit').hide()
	$('#editDynamicsSubmit').show()
	$('#deleteDynamicsCancle').show()
	$('#dynamicsList').hide();
	$('#editDynamics').show();
	$.ajax({
		url: "/jikuang/api/newsinfo/getNewsInfoDetails.html",
		type: "POST",
		dataType: "json",
		data: {
			'newsId': newsid,
		},
		success: function(data){
			if(data.success == true){
				addTitle_IT.setText(data.data.title)
				addSynopsis_IT.setText(data.data.introduction)
				//$('#certThumbAdd').attr('src','/jikuang/'+data.data.coverThumb)
				editorAddContent.html(data.data.content)
				if(data.data.auditState == 'C'){
					auditState.setText('已审核')
				}else if(data.data.auditState == 'R'){
					auditState.setText('已驳回')
					$('#dynamicsAuditMessage').show()
				}else if(data.data.auditState == 'B'){
					auditState.setText('待审核')
				}
				submitnewsid = newsid
			}
		},
		error: function(data){
			console.log('获取动态详情失败')
		}
	
	
	})
}
function clearDynamics(){
	addTitle_IT.setText('')
	addSynopsis_IT.setText('')
	//$('#certThumbAdd').attr('src','')
	editorAddContent.html('')
	submitnewsid = '';
}
function scroll(){
	$(document).scroll(function() {
		        var scroH = $(document).scrollTop();  //滚动高度
		        var viewH = $(window).height();  //可见高度 
		        var contentH = $(document).height();  //内容高度
		        $('#windowPanel').css('top',scroH +'px')
	})	        
}
//清空生产数据
function produceDataClear(){
	editWeight.setText('');
	editPrice.setText('');
	editDate.setDateText('');
}
//获取生产数据列表
function getProduceDataInfo(page){
	var searchStartTime = produceDataSearchStartDate.getDateText();
	var searchEndTime = produceDataSearchEndDate.getDateText();
	if(page == '' || page == null){
		page=1;
	}
	$.ajax({
		url: "/jikuang/api/goodstrend/getGoodsTrendPage.html",
		type: "POST",
		dataType: "json",
		data: {'firstManufactureTime': searchStartTime,'secondManufactureTime': searchEndTime},
		success: function(data){
			if(data.success == true){
				pageinfoProductionData(data.data.page,data.data.pageCount,'#produceDataList');
				var rows = data.data.rows;
				$('#produceDataTable tr').eq(0).siblings().remove();
				for(var i=0;i<rows.length;i++){
					$('#produceDataTable').append('<tr>'+
													'<td style="text-align:center;">'+(i + 1)+'</td>'+
													'<td style="text-align:center;">'+rows[i].goodsName+'</td>'+
													'<td style="text-align:center;">'+rows[i].weight+'</td>'+
													'<td style="text-align:center;">'+rows[i].price+'</td>'+
													'<td style="text-align:center;">'+rows[i].manufactureTime+'</td>'+
												'</tr>')
				}
				
			}
		},
		error: function(data){
			alert('获取生产数据失败')
		}
	})
}
//添加生产数据
function addProduceData(){
	if(editProductName.getSelValue() == ''){
		alert('请选择产品！')
		return
	}
	if(editWeight.getText() == ''){
		alert('请输入产量！')
		return
	}
	if(editDate.getDateText() == ''){
		alert('请选择日期！')
		return
	}
	$.ajax({
		url: "/jikuang/api/goodstrend/addGoodsTrend.html",
		type: "POST",
		dataType: "json",
		data: {
			'goodsId': editProductName.getSelValue(),
			'goodsName': editProductName.getSelText(),
			'weight': editWeight.getText(),
			'price': editPrice.getText(),
			'manufactureTime': editDate.getDateText()
		},
		success: function(data){
			console.log(data)
			if(data.success == true){
				alert('添加成功！')
				getProduceDataInfo()
				$('#produceDataCancleBtn').click()
			}else{
				alert('添加生产数据失败')
			}
		},
		error: function(data){
			alert('添加生产数据失败')
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
		url: "/jikuang/transactioninfo/getTransactionInfoPage.html",
		type: "POST",
		dataType: "json",
		data: {'validStartTime': searchStarTime,'validStopTime': searchEndTime},
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
												'<td style="text-align:center;">'+(i + 1)+'</td>'+
												'<td style="text-align:center;"><div style="color: #fa6d35;cursor:pointer;" onclick="tradeInfoDetail('+rows[i].transactionId+')">'+rows[i].type+'</div></td>'+
												'<td style="text-align:center;">'+tradeStyle+'</td>'+
												'<td style="text-align:center;">'+rows[i].weight+'</td>'+
												'<td style="text-align:center;">'+rows[i].price+'</td>'+
												'<td style="text-align:center;">'+rows[i].contactName+'</td>'+
												'<td style="text-align:center;">'+rows[i].validStartTime+' - '+rows[i].validStopTime+'</td>'+
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
		url: "/jikuang/transactioninfo/getTransactionInfoDetails.html",
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
//
//获取我的交易信息列表
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
		data: {'validStartTime': searchStarTime,'validStopTime': searchEndTime},
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
															'<td style="text-align:center;">'+(i + 1)+'</td>'+
															'<td style="text-align:center;"><div style="color: #fa6d35;cursor:pointer;" onclick="myTradeInfoDetail('+rows[i].transactionId+')">'+rows[i].type+'</div></td>'+
															'<td style="text-align:center;">'+tradeStyle+'</td>'+
															'<td style="text-align:center;">'+rows[i].weight+'</td>'+
															'<td style="text-align:center;">'+rows[i].price+'</td>'+
															'<td style="text-align:center;">'+rows[i].contactName+'</td>'+
															'<td style="text-align:center;">'+rows[i].contactPhone+'</td>'+
															'<td style="text-align:center;">'+rows[i].validStartTime+' - '+rows[i].validStopTime+'</td>'+
															'<td style="text-align:center;"><div style="text-align:center;color: #fa6d35;cursor:pointer;" onclick="supplierList()">3</div></td>'+
														'</tr>')
			}
			
		},
		error: function(data){
			console.log('获取我的交易信息失败')
		}
	})
}
//供应商列表
function supplierList(){
	$('#myTradeInfo').hide()
	$('#supplierList').show()
	$('.supplierListTable tr').eq(0).siblings().remove()
	$('.supplierListTable').append('<tr><td style="text-align:center;">1</td>'+
										'<td style="text-align:center;"><div style="color: #fa6d35;cursor:pointer;" onclick="supplierDetails(1)">曲阳鑫美钙粉有限公司</div></td>'+
										'<td style="text-align:center;">10000</td>'+
										'<td style="text-align:center;">60</td>'+
										'<td style="text-align:center;">企业</td>'+
										'<td style="text-align:center;">待选</td>'+
										'<td style="text-align:center;">2019-04-15</td>'+
									'</tr>'+
									'<tr><td style="text-align:center;">2</td>'+
										'<td style="text-align:center;"><div style="color: #fa6d35;cursor:pointer;" onclick="supplierDetails(2)">集矿数据有限公司</div></td>'+
										'<td style="text-align:center;">10000</td>'+
										'<td style="text-align:center;">60</td>'+
										'<td style="text-align:center;">平台</td>'+
										'<td style="text-align:center;">已选</td>'+
										'<td style="text-align:center;">2019-04-15</td>'+
									'</tr>'+
									'<tr><td style="text-align:center;">3</td>'+
										'<td style="text-align:center;"><div style="color: #fa6d35;cursor:pointer;" onclick="supplierDetails(3)">易县南山石场有限公司</div></td>'+
										'<td style="text-align:center;">10000</td>'+
										'<td style="text-align:center;">60</td>'+
										'<td style="text-align:center;">企业</td>'+
										'<td style="text-align:center;">放弃</td>'+
										'<td style="text-align:center;">2019-04-15</td>'+
									'</tr>')
}
//供应商详情
function supplierDetails(num){
	$('#supplierList').hide()
	$('#supplierDetails').show()
	if(num == 1){
		supplierCompanyName.setText('曲阳鑫美钙粉有限公司');
		supplierContactName.setText('周幼琳');
		supplierContactPhone.setText('15100023658');
	}else if(num==2){
		supplierCompanyName.setText('集矿数据有限公司');
		supplierContactName.setText('徐凯');
		supplierContactPhone.setText('15800023647');
	}else if(num==3){
		supplierCompanyName.setText('易县南山石场有限公司');
		supplierContactName.setText('林大山');
		supplierContactPhone.setText('15890025658');
	}
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
				myTradeInfoRemark.setText(rows.remark)
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
			"transactionType": myTradeInfoStyle.getRadioValue(),
			"type": myTradeInfoType.getText(),
			"weight": myTradeInfoYield.getText(),
			"price": myTradeInfoPrice.getText(),
			"contactName": myTradeInfoContactName.getText(),
			"contactPhone": myTradeInfoContactPhone.getText(),
			"remark": myTradeInfoRemark.getText(),
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
//添加我的交易信息
function addMyTradeMessage(){
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
		url: "/jikuang/api/transactioninfo/addTransactionInfo.html",
		type: "POST",
		dataType: "json",
		data:{
			"type": myTradeInfoType.getText(),
			"transactionType": myTradeInfoStyle.getRadioValue(),
			"weight": myTradeInfoYield.getText(),
			"price": myTradeInfoPrice.getText(),
			"contactName": myTradeInfoContactName.getText(),
			"contactPhone": myTradeInfoContactPhone.getText(),
			"remark": myTradeInfoRemark.getText(),
			"validStartTime": myTradeInfoStartDate.getDateText(),
			"validStopTime": myTradeInfoEndDate.getDateText()
		},
		success: function(data){
			if(data.success == true){
				alert('添加我的交易信息成功！')
				getMyTradeMessage()
				$('#myTradeInfoCancleBtn').click()
			}else{
				alert(data.message)
			}
		},
		error: function(data){
			alert(data.message)
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
				alert('我的交易信息删除成功！')
				getMyTradeMessage()
				$('#myTradeInfoCancleBtn').click()
			}else{
				alert(data.message)
			}
		},
		error: function(data){
			alert(data.message)
		}
	})
}
//清空我的交易信息添加页面
function clearMyTradenfo(){
	myTradeInfoType.setText('')
	myTradeInfoStyle.setRadioValue(''),
	myTradeInfoYield.setText('')
	myTradeInfoPrice.setText('')
	myTradeInfoContactName.setText('')
	myTradeInfoContactPhone.setText('')
	myTradeInfoStartDate.setDateText('')
	myTradeInfoEndDate.setDateText('')
	myTradeInfoRemark.setText('')
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