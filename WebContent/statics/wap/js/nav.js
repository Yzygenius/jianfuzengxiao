
$(window).load(function(){
	$.ajax({
		url: "/jikuang/api/companyinfo/getCompanyDetails.html",
		type: "POST",
		dataType: "json",
		success: function(data){console.log(data.data)
			if(data.success == true){
				var rows = data.data;
				if(rows.accountType == 'E'){
					var href = '/jikuang/api/companyinfo/enterpriseinfo.html';
				}else if(rows.accountType == 'C' || rows.accountType == 'D'){
					var href = '/jikuang/api/companyinfo/govermentManagementCenter.html';
				}else if(rows.accountType == 'G'){
					var href = '/jikuang/api/companyinfo/generalManagementCenter.html';
				}
				var loginArea = '<div id="loginArea">'+
									/*'<span id="loginBtn" style="display: none;"><span><a href="/jikuang/login.html">登录</a></span>|<span><a href="">注册</a></span></span>'+*/
									'<span id="loginInfo" style="color: #666666;"><span>Hi,</span><span id="userName">'+rows.companyName+'</span><img style="margin-left: 5px;" src="/jikuang/statics/api/images/littleTriangle.png"></span>'+
									'<ul id="topMenu">'+
										'<li onclick="myCompany()">'+
											'<img src="/jikuang/statics/api/images/navCompany.png">'+
											'<span>我的企业</span>'+
										'</li>'+
										'<li onclick="logout()">'+
											'<img src="/jikuang/statics/api/images/navExit.png">'+
											'<span>退出登录</span>'+
										'</li>'+
									'</ul>'+
								'</div>';
				var menuTitle = '<div id="menuTitle">'+
									'<div id="menuTitleLogo">'+
										'<img src="/jikuang/statics/api/images/logo.png" >'+
										'<span>'+
											'<p>集矿数据</p>'+
											'<p>JIKUANG DATA</p>'+
										'</span>'+
									'</div>'+
									'<div id="menuTitleNav">'+
										'<ul>'+
											'<li><a href="/jikuang/index.html">首页</a></li>'+
											'<li><a href="/jikuang/company.html">矿产企业</a></li>'+
											'<li><a href="/jikuang/company/tospf.html">石料加工厂</a></li>'+
											'<li><a href="/jikuang/goods.html">矿产价格</a></li>'+
											'<li><a href="/jikuang/goods/topt.html">产品交易</a></li>'+
											'<li><a href="/jikuang/news/topl.html">政策法规</a></li>'+
											'<li><a href="/jikuang/news/tocd.html">企业动态</a></li>'+
											'<li><a href="http://www.jizongkeji.com" target="_blank">大宗集运</a></li>'+
											'<li><a href="'+href+'">管理中心</a></li>'+
											//'<li><a href="/jikuang/api/companyinfo/generalManagementCenter.html">个人管理中心</a></li>'+
											//'<li><a href="/jikuang/api/companyinfo/govermentManagementCenter.html">政府管理中心</a></li>'+
											
										'</ul>'+
									'</div>'+
								'</div>';
			}else{
				var loginArea = '<div id="loginArea">'+
									/*'<span id="loginBtn"><span><a href="/jikuang/login.html">登录</a></span>|<span><a href="">注册</a></span></span>'+*/
									'<span id="loginInfo" style="color: #666666;display:none;"><span>Hi,</span><span id="userName"></span><img style="margin-left: 5px;" src="/jikuang/statics/api/images/littleTriangle.png"></span>'
								'</div>';
				var menuTitle = '<div id="menuTitle">'+
									'<div id="menuTitleLogo">'+
										'<img src="/jikuang/statics/api/images/logo.png" >'+
										'<span>'+
											'<p>集矿数据</p>'+
											'<p>JIKUANG DATA</p>'+
										'</span>'+
									'</div>'+
									'<div id="menuTitleNav">'+
										'<ul>'+
											'<li><a href="/jikuang/index.html">首页</a></li>'+
											'<li><a href="/jikuang/company.html">矿产企业</a></li>'+
											'<li><a href="/jikuang/company/tospf.html">石料加工厂</a></li>'+
											'<li><a href="/jikuang/goods.html">矿产价格</a></li>'+
											'<li><a href="/jikuang/goods/topt.html">产品交易</a></li>'+
											'<li><a href="/jikuang/news/topl.html">政策法规</a></li>'+
											'<li><a href="/jikuang/news/tocd.html">企业动态</a></li>'+
											'<li><a href="http://www.jizongkeji.com" target="_blank">大宗集运</a></li>'+
										'</ul>'+
									'</div>'+
								'</div>';
			}
			$('body').prepend(loginArea);
			$('#menuArea').prepend(menuTitle);
			/*$('body').append(bottom);*/
			topMenu()
			menuTriangle()
		},
		error: function(data){
			var loginArea = '<div id="loginArea">'+
								/*'<span id="loginBtn"><span><a href="/jikuang/login.html">登录</a></span>|<span><a href="">注册</a></span></span>'+*/
								'<span id="loginInfo" style="color: #666666;display:none;"><span>Hi,</span><span id="userName"></span><img style="margin-left: 5px;" src="/jikuang/statics/api/images/littleTriangle.png"></span>'
							'</div>';
			var menuTitle = '<div id="menuTitle">'+
								'<div id="menuTitleLogo">'+
									'<img src="/jikuang/statics/api/images/logo.png" >'+
									'<span>'+
										'<p>集矿数据</p>'+
										'<p>JIKUANG DATA</p>'+
									'</span>'+
								'</div>'+
								'<div id="menuTitleNav">'+
									'<ul>'+
										'<li><a href="/jikuang/index.html">首页</a></li>'+
										'<li><a href="/jikuang/company.html">矿产企业</a></li>'+
										'<li><a href="/jikuang/company/tospf.html">石料加工厂</a></li>'+
										'<li><a href="/jikuang/goods.html">矿产价格</a></li>'+
										'<li><a href="/jikuang/goods/topt.html">产品交易</a></li>'+
										'<li><a href="/jikuang/news/topl.html">政策法规</a></li>'+
										'<li><a href="/jikuang/news/tocd.html">企业动态</a></li>'+
										'<li><a href="http://www.jizongkeji.com" target="_blank">大宗集运</a></li>'+
									'</ul>'+
								'</div>'+
							'</div>';
			$('body').prepend(loginArea);
			$('#menuArea').prepend(menuTitle);
			/*$('body').append(bottom);*/
		/*	topMenu()*/
			/*menuTriangle()*/
		}
	})
})
function topMenu(){
	var left = ($('#titless').width() - 95) + 'px';
	$('#topMenu').css('left','企业动态')
	$('#loginInfo img').click(function(){
		if($('#topMenu').is(':hidden')){
			$('#topMenu').show()
			$(this).attr('src','/jikuang/statics/api/images/littleTriangleUp.png')
		}else{
			$('#topMenu').hide()
			$(this).attr('src','/jikuang/statics/api/images/littleTriangle.png')
		}
	})
	$('#topMenu li').mouseover(function(){
		var src = $(this).find('img').attr('src');
		src = src.replace('.png','_active.png')
		$(this).find('img').attr('src',src)
	})
	$('#topMenu li').mouseout(function(){
		var src = $(this).find('img').attr('src');
		src = src.replace('_active.png','.png')
		$(this).find('img').attr('src',src)
	})
}
function logout(){
	window.location.href="/jikuang/api/main/logout.html";
}
function myCompany(){
	var src = $('#menuTitleNav li').last().find('a').attr('href')
	window.location.href=src;
}
//获取地址后的参数
function GetQueryString(name) {
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}
