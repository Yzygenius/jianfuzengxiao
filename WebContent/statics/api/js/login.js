$(function(){
	account = new InputText("#account",InputText.TypeChar,InputText.DisTypeTable,30);
	password = new InputText("#password",InputText.TypePassword,InputText.DisTypeTable,16);
	
	$('#account input').attr({'placeholder':'请输入用户名'})
	$('#password input').attr('placeholder','请输入密码')
	
	$('#loginBtn').click(function(){
		if(account.getText() == ''){
			alert('请输入用户名！')
			return
		}
		if(password.getPassword() == ''){
			alert('请输入密码！')
			return
		}
		$('#verify').html('')
		verify(account.getText())
		$('#verify').show()
	})
	
	
	//注册
	regAccount = new InputText("#regAccount",InputText.TypeTel,InputText.DisTypeTable,11);
	captcha = new InputText("#captcha",InputText.TypeInt,InputText.DisTypeTable,6);
	$('#captcha').css({'width':'220px','display':'inline-block','margin-right':'20px'})
	$('#captcha input').attr('placeholder','请输入验证码')
	getCaptcha = new Button('#getCaptcha','','获取验证码',Button.TypeFa,Button.SizeLong);
	$('#getCaptcha').css('display','inline-block')
	regPassword = new InputText("#regPassword",InputText.TypePassword,InputText.DisTypeTable,16);
	regPasswordAgain = new InputText("#regPasswordAgain",InputText.TypePassword,InputText.DisTypeTable,16);
	$('#regAccount input').attr({'placeholder':'请输入手机号','maxLength':'11'})
	$('#regPassword input').attr('placeholder','请输入密码')
	$('#regPasswordAgain input').attr('placeholder','请再次输入密码')
	
	$('#registerBtn').click(function(){
		$('#login').hide()
		$('#register').show()
	})
	
	//获取验证码
	/*getCaptcha.bindEvent('click',function(){
		if(regAccount.getText() == '' || regAccount.getText().length != 11){
			alert('请输入11位手机号码')
			return
		}
		console.log(regAccount.getText())
		$.ajax({
			url: "/jikuang/api/common/sendSms.html",
			type: "POST",
			dataType: "json",
			data:{
				'mobile': regAccount.getText(),
				'type': 'D'
			},
			success: function(data){
				console.log(data)
			},
			error: function(data){
				alert(data.message)
			}
		})
	})*/
	
	//立即注册
	$('#registerSubmitBtn').click(function(){
		if(regAccount.getText() == '' || regAccount.getText().length != 11){
			alert('请输入11位手机号码')
			return
		}
		if(regPassword.getPassword() == '' || regPassword.getPassword().length > 16){
			alert('请输入6-16位密码')
			return
		}
		if(regPasswordAgain.getPassword() == ''){
			alert('请再次输入密码')
			return
		}
		if(regPasswordAgain.getPassword() != regPassword.getPassword()){
			alert('两次密码输入不一致')
			return
		}
		$.ajax({
			url: "/jikuang/register/validate.html",
			type: "POST",
			dataType: "json",
			data:{
				'username': regAccount.getText(),
				'password': encrypt(regPassword.getPassword()),
				'accountType': 'G'
			},
			success: function(data){console.log(data)
				if(data.success == true){
					alert('注册成功')
					window.location.reload()
					account.setText(regAccount.getText())
					password.setPassword(regPassword.getPassword())
				}else{
					alert(data.message)
				}
			},
			error: function(data){
				alert(data.message)
			}
		})
	})
	//返回登录
	$('#returnLoginBtn').click(function(){
		$('#login').show()
		$('#register').hide()
	})
	
	
	
	
	
	
	
	
})
function verify(username){
	$('#loginBtn').hide()
	$('#registerBtn').hide()
	$('#verify').pointsVerify({
    	defaultNum : 4,	//默认的文字数量
    	checkNum : 2,	//校对的文字数量
    	vSpace : 5,	//间隔
    	imgName : ['/jikuang/statics/api/images/verify1.jpg', '/jikuang/statics/api/images/verify2.jpg'],
    	imgSize : {
        	width: '600px',
        	height: '200px',
        },
        barSize : {
        	width : '600px',
        	height : '40px',
        },
        ready : function() {
    	},
        success : function() {
        	$.ajax({
        		url: "/jikuang/login/validate.html",
        		type: "POST",
        		dataType: "json",
        		data:{
        			'username': account.getText(),
        			'password': encrypt(password.getPassword())
        		},
        		success: function(data){
        			if(data.success == true){
        				toManageCenter()
        			}else{
        				alert(data.message)
            			$('#verify').hide()
            			$('#loginBtn').show()
            			$('#registerBtn').show()
        			}
        		},
        		error: function(data){
        			alert(data.message)
        			$('#verify').hide()
        			$('#loginBtn').show()
        			$('#registerBtn').show()
        		}
        	})
        },
        error : function() {
        	alert('验证失败！');
        }
        
    });
}
function toManageCenter(){
	$.ajax({
		url: "/jikuang/api/companyinfo/getCompanyDetails.html",
		type: "POST",
		dataType: "json",
		success: function(data){
			if(data.success == true){
				if(data.data.accountType == 'E'){
					window.location.href = '/jikuang/api/companyinfo/enterpriseinfo.html';
				}else if(data.data.accountType == 'C' || data.data.accountType == 'D'){
					window.location.href = '/jikuang/api/companyinfo/govermentManagementCenter.html';
				}else if(data.data.accountType == 'G'){
					window.location.href = '/jikuang/api/companyinfo/generalManagementCenter.html';
				}
			}else if(data.success == false){
				toManageCenter()
			}
		},
		error: function(){
			toManageCenter()
		}
	})
}
