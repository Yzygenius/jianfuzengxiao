var urlpagetype;
$(function(){
	var urlnewsid=GetQueryString('newsId');
	urlpagetype=GetQueryString('page');
	var newScript = document.createElement('script');
	newScript.type = 'text/javascript';
	newScript.src = '/jikuang/statics/api/js/jquery.share.min.js';
	$.ajax({
		url: "/jikuang/news/getNewsInfoDetails.html",
		type: "POST",
		dataType: "json",
		data:{'newsId': urlnewsid},
		success: function(data){
			if(data.success == true){
				var rows = data.data;
				var reg = new RegExp("&nbsp;","g");
				var reg1 = new RegExp("<br />","g");
				var reg2 = new RegExp("<br>","g");
				rows.content = rows.content.replace(reg,'')
				rows.content = rows.content.replace(reg1,'')
				rows.content = rows.content.replace(reg2,'')
				$('#articleTitle').html('').html(rows.title)
				$('#articleDate').html('').html(rows.createTime)
				$('#newsContent').html('').html(rows.content)
				$('#newsContent img').parent('p').css({'background':'rgb(231,231,231)','padding':'20px 0'})
				$('.share-component').attr('data-title',rows.title)
				if($('#newsContent img').length > 0){
					var src = $('#newsContent img').eq(0).attr('src');
					$('.share-component').attr('data-image',src)
				}
				$('body').append(newScript)
			}
		}
		
	})
	
	
	
	
	
});
function menuTriangle(){
	if(urlpagetype == 7){
		return
	}
	$('#menuTitleNav ul li').eq(urlpagetype).addClass('active');
	document.title = $('#menuTitleNav ul .active').find('a').html();
}
/*//分享到微博
function shareWeibo(title,url,picurl){
	var sharesinastring='http://v.t.sina.com.cn/share/share.php?title='+title+'&url='+url+'&content=utf-8&sourceUrl='+url+'&pic='+picurl;
	window.open(sharesinastring,'newwindow','height=400,width=400,top=100,left=100');
}
//分享到QQ空间
function shareKongjian(title,url,picurl){
	console.log(title)
	var shareqqzonestring='http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?summary='+title+'&url='+url+'&pics='+picurl;
	window.open(shareqqzonestring,'newwindow','height=400,width=400,top=100,left=100');
}
//分享到微信
function shareWeixin(){
    var target_url ="http://qr.liantu.com/api.php?text=http://test.qicheyitiao.com";
    window.open(target_url, 'weixin','height=320, width=320');
}*/




