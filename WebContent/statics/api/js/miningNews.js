var pageSize=5;
var newsType = 'C';
$(function(){
	searchData()
	
	//矿业新闻penal
	$.ajax({
		url: "/jikuang/news/getNewsInfoList.html",
		type: "POST",
		dataType: "json",
		data:{'newsType': 'C'},
		success: function(data){
			if(data.success == true){
				var rows = data.data;
				$('.newsPenal .newsList ul').html('');
				for(var i=0;i<rows.length;i++){
					var miningNews = '<li>'+
										'<a href="/jikuang/news/topld.html?newsId='+rows[i].newsId+'&page=7" target="_blank">'+
											'<span class="redPoint"></span>'+
											'<span class="newsTitle" title='+rows[i].title+'>'+rows[i].title+'</span>'+
										'</a>'+
									'</li>';
					$('.newsPenal .newsList ul').append(miningNews);
				}
			}
		}
	})
	//市场动态penal
	$.ajax({
		url: "/jikuang/news/getNewsInfoList.html",
		type: "POST",
		dataType: "json",
		data:{'newsType': 'D'},
		success: function(data){
			if(data.success == true){
				var rows = data.data;
				$('#dynamicsPenal .newsList ul').html('');
				for(var i=0;i<rows.length;i++){
					var miningNews = '<li>'+
										'<a href="/jikuang/news/topld.html?newsId='+rows[i].newsId+'&page=7" target="_blank">'+
											'<span class="redPoint"></span>'+
											'<span class="newsTitle" title='+rows[i].title+'>'+rows[i].title+'</span>'+
										'</a>'+
									'</li>';
					$('#dynamicsPenal .newsList ul').append(miningNews);
				}
			}
		}
	})
	
	
	
	$(window).load(function(){
		if($('.newContent').text().length > 60){
			var text = $('.newContent').text().substr(0,60);
			var more = '<a href="" style="color:#fa6d35;margin-left:10px">查看更多<a>'
			$('.newContent').html(text +'...'+ more)
		}else{
			var text = $('.newContent').text();
			var more = '<a href="" style="color:#fa6d35;margin-left:10px">查看更多<a>'
			$('.newContent').html(text + more)
		}
		
		$('.newsLeftTitle li').click(function(){
			$(this).addClass('active').siblings().removeClass('active');
			$('.newsLeftTitle li').each(function(){
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
			if($(this).index() == '0'){
				newsType = 'C';
				searchData()
			}
			if($(this).index() == '1'){
				newsType = 'D';
				searchData()
			}
		})
	})
});
function searchData(page){
	if(page == '' || page == null){
		page=1;
	}
	$.ajax({
		url: "/jikuang/news/getNewsInfoPage.html",
		type: "POST",
		dataType: "json",
		data:{
			'newsType': newsType,
			'page': page,
			'pageSize': pageSize
		},
		success: function(data){
			if(data.success == true){
				pageinfo(data.data.page,data.data.pageCount);
				var rows = data.data.rows;
				$('#pageNumList').siblings().remove();
				for(var i=0;i<rows.length;i++){
					var miningNews = '<li class="miningNews">'+
										'<div class="left">'+
											'<img src='+rows[i].coverThumb+'>'+
										'</div>'+
										'<div class="right">'+
											'<ul>'+
												'<li class="newsTitle"><a href="/jikuang/news/topld.html?newsId='+rows[i].newsId+'&page=7" target="_blank">'+rows[i].title+'</a></li>'+
												'<li class="newContent">'+rows[i].introduction+'<a href="/jikuang/news/topld.html?newsId='+rows[i].newsId+'&page=7" style="color:#fa6d35;margin-left:10px" target="_blank">查看更多</a></li>'+
												'<li class="newsElse">'+
													'<span class="date">'+rows[i].createTime.slice(0,10)+'</span>'+
													'<span>作者：<span class="auther">环境保护</span></span>'+
													'<span>阅读：<span class="readingNum">57</span></span>'+
												'</li>'+
											'</ul>'+
										'</div>'+
									'</li>';
					$('#pageNumList').before(miningNews);
				}
				
				$('.left img').each(function(){
					$(this).height($(this).width()/1.2);
					$('.right').height($(this).width()/1.2);
				})
			}
		}
		
	})
}
function menuTriangle(){
	//$('#menuTitleNav ul li').eq(7).addClass('active');
}
