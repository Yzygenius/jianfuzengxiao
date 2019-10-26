var usernameLogin,passwordLogin,loginBtn,checkLogin;
$(function(){
	/* 登录 */
	//初始化标签
	usernameLogin = new InputText('#login-username',InputText.TypeUserName,InputText.DisTypeMiddle,ImageIcon.Touxiang_B,18);
	passwordLogin = new InputText('#login-password',InputText.TypePassword,InputText.DisTypeMiddle,ImageIcon.Mima_B,16);
	checkLogin = new InputText('#check-input',InputText.TypeNormal,InputText.DisTypeShort,ImageIcon.Mima_B,4);
	loginBtn = new Button('#login-btn','','登录',Button.TypeImportant,Button.SizeLong);
	//输入框添加默认值
	usernameLogin.text.attr('placeholder','请输入用户名');
	passwordLogin.text.attr('placeholder','请输入密码');
	checkLogin.text.attr('placeholder','验证码');
	//登录
	loginBtn.bindEvent('click', checkToLogin);
	
	/*点击忘记密码*/
	$('.login-other .forgetpwd-tips').click(function(){
		$('.login').hide();
		$('.forgetpwd').show();
	})
	
	/* 点击注册账号 */
	$('.login-other .register-tips').click(function(){
		$('.login').hide();
		$('.register').show();
	})
	
	/*忘记密码 点击返回到登录页*/
	$('.goback').click(function(){
		$('.forgetpwd').hide();
		$('.register').hide();
		$('.login').show();
	})
	
	/* 忘记密码 */
	//初始化组件
	usernameForgetpwd = new InputText('#forgetpwd-username',InputText.TypeTel,InputText.DisTypeMiddle,ImageIcon.Touxiang_B,11);
	forgetpwdCheck = new InputText('#forgetpwd-check',InputText.TypeNormal,InputText.DisTypeShort,ImageIcon.Mima_B,6);
	forgetpwdSmsbtn = new Button('#forgetpwd-smsbtn','','获取验证码',Button.TypeImportant,Button.SizeLong)
	forgetpwdBtn = new Button('#forgetpwd-btn', '', '下一步', Button.TypeImportant, Button.SizeLong);
	forgetpwdGoback = new Button('#forgetpwd-goback', '', '返回', Button.TypeImportant, Button.SizeLong);
	//
	forgetpwdNewspwd = new InputText('#forgetpwd-newspwd',InputText.TypePassword,InputText.DisTypeMiddle,ImageIcon.Mima_B,16);
	forgetpwdAgainNewspwd = new InputText('#forgetpwd-again-newspwd',InputText.TypePassword,InputText.DisTypeMiddle,ImageIcon.Mima_B,16);
	forgetpwdNewsbtn = new Button('#forgetpwd-newsbtn', '', '确认', Button.TypeImportant, Button.SizeLong);
	//输入框添加默认值
	usernameForgetpwd.text.attr('placeholder','请输入用户名');
	forgetpwdCheck.text.attr('placeholder','验证码');
	forgetpwdNewspwd.text.attr('placeholder','请输入新密码');
	forgetpwdAgainNewspwd.text.attr('placeholder','请再次输入新密码');
	//找回密码获取验证码
	forgetpwdSmsbtn.bindEvent('click',function(){
		if(usernameForgetpwd.getText().length < 11){
			new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示","用户名输入错误！<br>请输入11位正确的用户名",function(){usernameForgetpwd.setFocus();});
			return;
		}
		//发送验证码
		$.ajax({  
			url : "/dazong/manager/sendSms.html",  
			type : 'post',
			dataType: "json",
			data:{"type":'B',"mobile":usernameForgetpwd.getText()},
			success : function(data){
				new WindowPanel().showAlert(WindowPanel.TypeAlertOk,"获取验证码",data.message)
				if(data.success==true){
					settime(forgetpwdSmsbtn);
				}
			},
			error : function(returnValue){
				new WindowPanel().showAlert(WindowPanel.TypeAlertError,"获取验证码",data.message)
			}
		});
	})
	//下一步
	var forgetToken;
	forgetpwdBtn.bindEvent("click",function(){
		/*if(usernameForgetpwd.getText().length<11){
			new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示","用户名输入错误！<br>请输入11位正确的用户名",function(){usernameForgetpwd.setFocus();});
			return;
		}*/
		if(usernameForgetpwd.getText() ==""){
			new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示","用户名输入错误！<br>请输入正确的用户名",function(){usernameForgetpwd.setFocus();});
			return;
		}
		if(forgetpwdCheck.getText().length<4){
			new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示","验证码输入错误！<br>请输入4位正确的验证码",function(){forgetpwdCheck.setFocus();});
			return;
		}
		var forgetSmsParam = {"mobile":usernameForgetpwd.getText(),"smsCode":forgetpwdCheck.getText()};
		$.ajax({  
			url : "/dazong/manager/memberInfo/retrieveCheck.html",  
			type : 'post',
			dataType: "json",
			data: forgetSmsParam,
			success : function(data){
				forgetToken = data.data.token;
				$('#forgetpwd').hide();
				$('#forgetpwd-news').show();
			},
			error : function(data){
				new WindowPanel().showAlert(WindowPanel.TypeAlertError,"忘记密码",data.message);
			}
		});
	})
	//提交
	forgetpwdNewsbtn.bindEvent("click", function(){
		if(forgetpwdNewspwd.getPassword != forgetpwdAgainNewspwd.getPassword){
			new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示","两次输入密码不一致",function(){forgetpwdAgainNewspwd.setFocus();});
			return;
		} 
		var param = {
			equipmentType : 'W',
			token : forgetToken,
			password : encrypt(forgetpwdAgainNewspwd.getPassword())
		};
		$.getJsonA("/dazong/manager/memberInfo/retrievePwd.html", param, function (data) {
			if (data.success) {
				new WindowPanel().showAlert(WindowPanel.TypeAlertOk,"忘记密码",data.message);
				window.location.reload();
			} else {
				new WindowPanel().showAlert(WindowPanel.TypeAlertError,"忘记密码",data.message);
			}
		}, true);
	});
	
	
	/* 注册账号 */
	//初始化组件
	var registerUsername, registerCheck, registerSmsbtn, registerPwd, registerAgainpwd, registerBtn;
	registerUsername = new InputText('#register-username',InputText.TypeTel,InputText.DisTypeMiddle,ImageIcon.Touxiang_B,11);
	registerCheck = new InputText('#register-check',InputText.TypeNormal,InputText.DisTypeShort,ImageIcon.Mima_B,6);
	registerSmsbtn = new Button('#register-smsbtn','','获取验证码',Button.TypeImportant,Button.SizeLong);
	registerPwd = new InputText('#register-pwd',InputText.TypePassword,InputText.DisTypeMiddle,ImageIcon.Mima_B,16);
	registerAgainpwd = new InputText('#register-againPwd',InputText.TypePassword,InputText.DisTypeMiddle,ImageIcon.Mima_B,16);
	registerCheckbox = new CheckBox('#register-checkBox', [{'value':'1', 'text': '我已同意'}]);
	registerBtn = new Button('#register-btn', '', '立即注册', Button.TypeImportant, Button.SizeLong);
	registerGoback = new Button('#register-goback', '', '返回', Button.TypeImportant, Button.SizeLong);
	//输入框添加默认值
	registerUsername.text.attr('placeholder','请输入用户名');
	registerCheck.text.attr('placeholder','验证码');
	registerPwd.text.attr('placeholder','请输入密码');
	registerAgainpwd.text.attr('placeholder','请再次输入密码');
	
	//注册账号获取验证码
	registerSmsbtn.bindEvent('click', function(){
		if(registerUsername.getText().length<11){
			new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示","用户名输入错误！<br>请输入11位正确的用户名",function(){registerUsername.setFocus();});
			return;
		}
		//发送验证码
		$.ajax({  
			url : "/jikuang/system/sendSms.html",  
			type : 'post',
			dataType: "json",
			data:{"type":'A',"mobile":registerUsername.getText()},
			success : function(data){
				if(data.code==1205){
					new WindowPanel().showAlert(WindowPanel.TypeAlertError,"获取验证码",data.message)
					window.location.reload();
				}
				if(data.success==false){
					if(data.message=='9004'){
						new WindowPanel().showAlert(WindowPanel.TypeAlertError,"获取验证码",data.message)
					}else{
						new WindowPanel().showAlert(WindowPanel.TypeAlertError,"获取验证码",data.message)
					}
				}
				if(data.success==true){
					new WindowPanel().showAlert(WindowPanel.TypeAlertOk,"获取验证码",data.message,function(){
						settime(registerSmsbtn);
					})
				}
			},
			error : function(data){
				new WindowPanel().showAlert(WindowPanel.TypeAlertError,"获取验证码",data.message)
			}
		});
	})
	//立即注册
	registerBtn.bindEvent("click", function(){
		if(registerUsername.getText().length<11){
			new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示","用户名输入错误！<br>请输入11位正确的用户名",function(){registerUsername.setFocus();});
			return;
		}
		if(registerCheck.getText().length<6){
			new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示","验证码输入错误！<br>请输入6位正确的验证码",function(){registerCheck.setFocus();});
			return;
		}
		if(registerPwd.getPassword().length<6){
			new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示","密码输入错误！<br>请输入至少6位正确的密码",function(){registerPwd.setFocus();});
			return;
		}
		if(registerAgainpwd.getPassword().length<6){
			new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示","密码输入错误！<br>请输入至少6位正确的密码",function(){registerAgainpwd.setFocus();});
			return;
		}
		
		if(registerPwd.getPassword() != registerAgainpwd.getPassword()){
			new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示",'两次密码输入不一致');
			return;
		}
		var checkSel = registerCheckbox.getCheckValue();
		if(checkSel.length != 1 ){
			new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"注册",'请仔细阅读协议，再勾选按钮');
			return;
		}
		var param = $.param({
			equipmentType : 'W',
			accountType : 'H',
			mobile : registerUsername.getText(),
			smsCode : registerCheck.getText(),
			password : encrypt(registerPwd.getPassword())
		});
		$.getJsonA("/jikuang/system/register.html", param, function (data) {
			if (data.success) {
				new WindowPanel().showAlert(WindowPanel.TypeAlertOk,"注册",data.message,function(){
					window.location.reload();
				});
			} else {
				new WindowPanel().showAlert(WindowPanel.TypeAlertError,"注册",data.message);
			}
		}, true);
	})
	
	//获取动态验证码
	$('#captchaImg').on('click', function(){
		$(this).attr('src', '/jikuang/system/captcha/login.html?' + new Date().getMilliseconds());
	});
	
});
function checkToLogin(){
	/*if(usernameLogin.getText().length != 11){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示","用户名输入错误！<br>请输入11位正确的用户名",function(){usernameLogin.setFocus();});
		return;
	}*/
	if(usernameLogin.getText() ==""){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示","用户名不能为空！<br>请输入正确的用户名",function(){usernameLogin.setFocus();});
		return;
	}
	if(passwordLogin.getText().length < 6){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示","密码输入错误！<br>请输入至少6位正确的密码",function(){passwordLogin.setFocus();});
		return;
	}
	if(checkLogin.getText().length < 4){
		new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提示","验证码输入错误！<br>请输入4位正确的验证码",function(){checkLogin.setFocus();});
		return;
	}
	//
	var param = $.param({
		username : usernameLogin.getText(),
		password : encrypt(passwordLogin.getPassword()),
		captcha : checkLogin.getText()
	});
	$.getJsonA("/jikuang/system/login.html", param, function (data) {
		if (data.success) {
			//window.location.href = "/jikuang/system.html";
			window.location.reload()
		} else {
			$('#captchaImg').trigger('click');
			new WindowPanel().showAlert(WindowPanel.TypeAlertError,"登录",data.message);
		}
	}, true);
}
var countdown=60;
function settime(val) { 
	if(countdown == 0){           
		val.setDisable(false)        
		//val.text.text("获取验证码");
		val.setText("获取验证码")
		countdown = 60;        
	}else{  
		val.setDisable(true)
		//val.text.text(countdown+"后重新获取");            
		val.setText(countdown+"后重新获取")
		countdown--;            
		setTimeout(function(){                
			settime(val)            
		},1000)        
	}    
}
function keyPress(event){
	if($('.login').is(':visible')){
		event.keyCode == 13 && $("#login-btn button").trigger("click");
		return;
	}
	if($('.register').is(':visible')){
		event.keyCode == 13 && $("#register-btn button").trigger("click");
		return;
	}
	if($('#forgetpwd').is(':visible')){
		event.keyCode == 13 && $("#forgetpwd-btn button").trigger("click");
		return;
	}
	if($('#forgetpwd-news').is(':visible')){
		event.keyCode == 13 && $("#forgetpwd-newsbtn button").trigger("click");
		return;
	}
}