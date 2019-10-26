var pageSize =10;
var mapLng,mapLat,companyid,submitnewsid,editorAddContent,editor;
var goodTrendid,goodsid;
var edittransactionid;
var policysubmitnewsid,submitnewsid;
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
//政策法规
	policyLawsKeyWord = new InputText("#policyLawsKeyWord",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#policyLawsKeyWord input').attr('placeholder','请输入标题关键字')
	addPolicyLawsTitle_IT = new InputText("#addPolicyLawsTitle_IT",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#addPolicyLawsTitle_IT input').attr('placeholder','请输入标题')
	addPolicyLawsSynopsis_IT = new TextArea("#addPolicyLawsSynopsis_IT",TextArea.DisTypeTable);
	$('#addPolicyLawsSynopsis_IT textarea').css('font-size','18px')
	addPolicyLawsContent_TA = new TextArea('#addPolicyLawsContent_TA',TextArea.DisTypeLong)
	$('#addPolicyLawsContent_TA textarea').attr('id','addPolicyContent')
	
	editorAddPolicyContent = KindEditor.create('#addPolicyContent',{
		//指定上传文件参数名称
        filePostName : "uploadFile",
    	uploadJson : '/jikuang/statics/api/js/kindeditor/jsp/upload_json.jsp',
        fileManagerJson : '/jikuang/statics/api/js/kindeditor/jsp/file_manager_json.jsp',
        allowFileManager : true,
        dir : "image"
	});
	//点击搜索按钮
	$('#policyLawsSearchBtn').click(function(){
		var keyword = policyLawsKeyWord.getText();
		searchDataPolicyLaws()
	})
	//点击添加按钮
	$('#addPolicyLawsBtn').click(function(){
		clearPolicyLaws()
		$('#policyLawsList').hide();
		$('#editPolicyLaws').show();
		$('#editPolicyLawsSubmit').hide()
		$('#deletePolicyLawsCancle').hide()
		$('#addPolicyLawsSubmit').show()
	})
	//点击取消按钮
	$('#addPolicyLawsCancle').click(function(){
		$('#editPolicyLaws').hide();
		$('#policyLawsList').show();
	})
	
	//点击确定
	$('#addPolicyLawsSubmit').click(function(){
		if(addPolicyLawsTitle_IT.getText() == ''){
			alert('请输入标题！')
			return
		}
		if(addPolicyLawsSynopsis_IT.getText() == ''){
			alert('请输入简介！')
			return
		}
		if(editorAddPolicyContent.html() == ''){
			alert('请输入内容！')
			return
		}
		$.ajax({
			url: "/jikuang/api/newsinfo/addNewsInfo.html",
			type: "POST",
			dataType: "json",
			data: {
				'title': addPolicyLawsTitle_IT.getText(),
				'introduction': addPolicyLawsSynopsis_IT.getText(),
				'content': editorAddPolicyContent.html()
			},
			success: function(data){
				if(data.success == true){
					alert('提交成功！')
					$('#editPolicyLaws').hide();
					$('#policyLawsList').show();
					clearPolicyLaws()
					searchDataPolicyLaws()
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
	$('#editPolicyLawsSubmit').click(function(){
		$.ajax({
			url: "/jikuang/api/newsinfo/updateNewsInfo.html",
			type: "POST",
			dataType: "json",
			data: {
				//'newsType': 'B',
				'newsId': policysubmitnewsid,
				'title': addPolicyLawsTitle_IT.getText(),
				//'introduction': addSynopsis_IT.getText(),
				'content': editorAddPolicyContent.html()
			},
			success: function(data){
				if(data.success == true){
					alert('修改成功！')
					$('#editPolicyLaws').hide();
					$('#policyLawsList').show();
					clearPolicyLaws()
					searchDataPolicyLaws()
				}
			},
			error: function(data){
				alert('修改失败')
			}
		
		
		})
	})
	//点击删除
	$('#deletePolicyLawsCancle').click(function(){
		var r=confirm("确定要删除吗？")
		if (r==true){
			$.ajax({
				url: "/jikuang/api/newsinfo/updateStsNewsInfo.html",
				type: "POST",
				dataType: "json",
				data: {'newsId': policysubmitnewsid},
				success: function(data){
					if(data.success == true){
						alert('删除成功！')
						$('#editPolicyLaws').hide();
						$('#policyLawsList').show();
						clearPolicyLaws()
						searchDataPolicyLaws()
					}
				},
				error: function(data){
					alert('删除失败')
				}
			})
		}
	})
	searchDataPolicyLaws()
	
//企业动态
	dynamicsKeyWord = new InputText("#dynamicsKeyWord",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#dynamicsKeyWord input').attr('placeholder','请输入标题关键字')
	addTitle_IT = new InputText("#addTitle_IT",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#addTitle_IT input').attr('placeholder','请输入标题')
	/*addSynopsis_IT = new InputText("#addSynopsis_IT",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#addSynopsis_IT input').attr('placeholder','请输入简介')*/
	uploadImagesAdd_Btn = new Button("#uploadImagesAdd_Btn",ImageIcon.Tupian_W,"选择图片",Button.TypeFa,Button.SizeLong);
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
		searchData()
	})
	
	
	
	
	
	
//企业信息
	companyInfoKeyWord = new InputText("#companyInfoKeyWord",InputText.TypeNormal,InputText.DisTypeTable,30);
	$('#companyInfoKeyWord input').attr('placeholder','请输入关键字')
	
	//点击搜索按钮
	$('#companyInfoSearchBtn').click(function(){
		var keyword = companyInfoKeyWord.getText();
		searchDataCompanyInfo()
	})
	
	searchDataCompanyInfo()
	getUserInfo()
	
	
	
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
				//searchDataPolicyLaws()
				$('#enterpriseName').html(rows.companyName)
				$('#enterpriseImage img').attr('src','/jikuang/'+rows.companyThumb)
				$('.enterprisePhone').html(rows.contactTel)
				$('.userName').html(rows.contactName)
				$('.position').html(rows.position)
			}
			
		},
		error: function(data){
			alert('获取信息失败')
		}
	})
}

//获取政策法规列表
function searchDataPolicyLaws(page){
	if(page == '' || page == null){
		page=1;
	}
	$.ajax({
		url: "/jikuang/api/newsinfo/getCompanyNewsPage.html",
		type: "POST",
		dataType: "json",
		data: {
			'page': page,
			'pageSize': pageSize,
			'title': policyLawsKeyWord.getText()
		},
		/*data:{'newsType': 'B','page': page,'pageSize': pageSize,'title': keyword,'companyId': companyid},*/
		success: function(data){
			if(data.success == true){
				pageinfoPolicyLaws(data.data.page,data.data.pageCount,'#policyLawsList');
				var rows = data.data.rows;
				$('#policyLawsContent table tr').eq(0).siblings().remove();
				for(var i=0;i<rows.length;i++){
					var policyLawsNews = '<tr>'+
										'<td style="text-align: center;">'+(i + 1)+'</td>'+
										'<td style="text-align: center;"><div style="color: #fa6d35;cursor: pointer;max-width: 500px;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;" onclick=checkNewsDetail('+rows[i].newsId+',5)>'+rows[i].title+'</div></td>'+
										'<td style="text-align: center;">'+rows[i].createTime+'</td>'+
										'<td style="text-align: center;"><div class="dynamicsNewsEdit" onclick=dblPolicyLaws('+rows[i].newsId+') >编辑</div></td>'+
									'</tr>';
					$('#policyLawsContent table').append(policyLawsNews);
				}
				
			}
		}	
	})
}



//政府帐号获取企业动态
function searchData(page){
	if(page == '' || page == null){
		page=1;
	}
	$.ajax({
		url: "/jikuang/api/newsinfo/getGovernmentNewsPage.html",
		type: "POST",
		dataType: "json",
		data: {
			'page': page, 
			'pageSize': pageSize,
			'title': dynamicsKeyWord.getText()
		},
		/*data:{'newsType': 'B','page': page,'pageSize': pageSize,'title': keyword,'companyId': companyid},*/
		success: function(data){
			if(data.success == true){
				pageinfo(data.data.page,data.data.pageCount,'#dynamicsList');
				var rows = data.data.rows;
				$('#companyCulture table tr').eq(0).siblings().remove();
				for(var i=0;i<rows.length;i++){
					var dynamicsNews = '<tr>'+
										'<td style="text-align: center;">'+(i + 1)+'</td>'+
										'<td style="text-align: left;text-indent: 20px;"><div style="color: #fa6d35;cursor: pointer;max-width: 600px;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;" onclick=checkNewsDetail('+rows[i].newsId+',6)>'+rows[i].title+'</div></td>'+
										'<td style="text-align: center;">'+rows[i].createTime+'</td>'+
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
//编辑政策法规
function dblPolicyLaws(newsid){
	clearPolicyLaws()
	$('#addPolicyLawsSubmit').hide()
	$('#editPolicyLawsSubmit').show()
	$('#deletePolicyLawsCancle').show()
	$('#policyLawsList').hide();
	$('#editPolicyLaws').show();
	$.ajax({
		url: "/jikuang/api/newsinfo/getNewsInfoDetails.html",
		type: "POST",
		dataType: "json",
		data: {
			'newsId': newsid,
		},
		success: function(data){
			if(data.success == true){
				addPolicyLawsTitle_IT.setText(data.data.title)
				addPolicyLawsSynopsis_IT.setText(data.data.introduction)
				//$('#certThumbAdd').attr('src','/jikuang/'+data.data.coverThumb)
				editorAddPolicyContent.html(data.data.content)
				policysubmitnewsid = newsid
			}
		},
		error: function(data){
			alert('获取详情失败')
		}
	
	
	})
}
//编辑企业动态
function dblDynamics(newsid){
	clearDynamics()
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
				//addSynopsis_IT.setText(data.data.introduction)
				//$('#certThumbAdd').attr('src','/jikuang/'+data.data.coverThumb)
				editorAddContent.html(data.data.content)
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
	//addSynopsis_IT.setText('')
	//$('#certThumbAdd').attr('src','')
	editorAddContent.html('')
	submitnewsid = '';
}
function clearPolicyLaws(){
	addPolicyLawsTitle_IT.setText('')
	addPolicyLawsSynopsis_IT.setText('')
	//$('#certThumbAdd').attr('src','')
	editorAddPolicyContent.html('')
	policysubmitnewsid = '';
}

//获取企业信息列表
function searchDataCompanyInfo(page){
	if(page == '' || page == null){
		page=1;
	}
	$.ajax({
		url: "/jikuang/api/companyinfo/getGovernmentCompanyPage.html",
		type: "POST",
		dataType: "json",
		data: {
			'page': page, 
			'pageSize': pageSize,
			'companyName': companyInfoKeyWord.getText()
		},
		/*data:{'newsType': 'B','page': page,'pageSize': pageSize,'title': keyword,'companyId': companyid},*/
		success: function(data){
			if(data.success == true){
				pageinfoCompanyInfo(data.data.page,data.data.pageCount,'#companyInfoList');
				var rows = data.data.rows;
				$('#companyInfoContent table tr').eq(0).siblings().remove();
				for(var i=0;i<rows.length;i++){
					if(rows[i].address == undefined){
						rows[i].address = ''
					}
					var companyInfoNews = '<tr>'+
										'<td style="text-align: center;">'+(i + 1)+'</td>'+
										'<td style="text-align: center;"><div style="color: #fa6d35;cursor: pointer;max-width: 500px;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;" onclick=checkCompanyDetail('+rows[i].companyId+',5)>'+rows[i].companyName+'</div></td>'+
										'<td style="text-align: center;">'+rows[i].provName + rows[i].cityName + rows[i].areaName + rows[i].address+'</td>'+
										'<td style="text-align: center;">'+rows[i].minesType+'</td>'+
										'<td style="text-align: center;">'+rows[i].reserves+'</td>'+
										'<td style="text-align: center;">'+rows[i].productionYear+'</td>'+
									'</tr>';
					$('#companyInfoContent table').append(companyInfoNews);
				}
				
			}
		}	
	})
}
//查看企业详情
function checkCompanyDetail(companyid){
	window.open('/jikuang/company/tomcd.html?id='+companyid)
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