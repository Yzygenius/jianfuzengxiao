$(function(){
	$('.menuPenal li').click(function(){
		$(this).addClass('active').siblings().removeClass('active')
		$('.contentList li').eq($(this).index()).show().siblings().hide()
		$('.menuPenal li').each(function(){
			var imgSrc = $(this).find('img').eq(0).attr('src');
			var src = imgSrc.replace('.png','');
			if($(this).hasClass('active')){
				if(src.indexOf('Choosed') == -1){
					src = src + 'Choosed.png';
					$(this).find('img').eq(0).attr('src',src)
				}
			}else{
				if(src.indexOf('Choosed') != -1){
					src = src.replace('Choosed','.png');
					$(this).find('img').eq(0).attr('src',src)
				}
			}
		})
	})
//关于我们
	$.ajax({
		url: "/jikuang/about/getManager.html",
		type: "POST",
		dataType: "json",
		data: {"type": 'A'},
		success: function(data){
			if(data.success == true){
				$('#about').html('')
				$('#about').html(data.data.content)
			}
		},
		error: function(data){
			alert(data.message)
		}
	})
	
//留言建议
	contactName = new InputText("#contactName",InputText.TypeNormal,InputText.DisTypeLong,30);
	contactPhone = new InputText("#contactPhone",InputText.TypeTel,InputText.DisTypeLong,11);
	contactEmail = new InputText("#contactEmail",InputText.TypeMailAdr,InputText.DisTypeLong,30);
	$('#contactEmail input').attr('placeholder','非必填项')
	
	$('#submit').click(function(){
		if(contactName.getText() == ''){
			alert('请输入姓名！')
			return
		}
		if(contactPhone.getText() == ''){
			alert('请输入联系电话！')
			return
		}
		if($('.suggestContent textarea').val() == ''){
			alert('请填写留言内容')
			return
		}
		$.ajax({
			url: "/jikuang/about/addMessage.html",
			type: "POST",
			dataType: "json",
			data: {
				"contactName": contactName.getText(),
				"contactTel": contactPhone.getText(),
				"email": contactEmail.getText(),
				"content": $('.suggestContent textarea').val()
			},
			success: function(data){
				if(data.success == true){
					contactName.setText('')
					contactPhone.setText('')
					contactEmail.setText('')
					$('.suggestContent textarea').val('')
				}
				alert(data.message)
			},
			error: function(data){
				
			}
		})
	})

//加入我们
	//行政
	$.ajax({
		url: "/jikuang/about/getManager.html",
		type: "POST",
		dataType: "json",
		data: {"type": 'B'},
		success: function(data){
			if(data.success == true){
				$('#joinContent #menuContent .text').eq(0).html('')
				$('#menuContent .text').eq(0).html(data.data.content)
			}
		},
		error: function(data){
			alert(data.message)
		}
	})
	//技术
	$.ajax({
		url: "/jikuang/about/getManager.html",
		type: "POST",
		dataType: "json",
		data: {"type": 'C'},
		success: function(data){
			if(data.success == true){console.log($('#joinContent #menuContent .text').eq(1))
				$('#joinContent #menuContent .text').eq(1).html('')
				$('#menuContent .text').eq(1).html(data.data.content)
			}
		},
		error: function(data){
			alert(data.message)
		}
	})
	//其他
	$.ajax({
		url: "/jikuang/about/getManager.html",
		type: "POST",
		dataType: "json",
		data: {"type": 'D'},
		success: function(data){
			if(data.success == true){
				$('#joinContent #menuContent .text').eq(2).html('')
				$('#menuContent .text').eq(2).html(data.data.content)
			}
		},
		error: function(data){
			alert(data.message)
		}
	})
	
//联系我们
	$.ajax({
		url: "/jikuang/about/getManager.html",
		type: "POST",
		dataType: "json",
		data: {"type": 'E'},
		success: function(data){
			if(data.success == true){
				$('#contactContent').html('')
				$('#contactContent').html(data.data.content)
			}
		},
		error: function(data){
			alert(data.message)
		}
	})
	
	
	
	$('#menu div').click(function(){
		$(this).addClass('active').siblings('div').removeClass('active');
		$('#menuContent .text').eq($(this).attr('name')).addClass('textActive').siblings().removeClass('textActive')
	})
	
	$('.menuPenal li').eq(GetQueryString('part')).click()
})
function menuTriangle(){
	
}