var pageSize =10;
$(function(){
		searchData();
})
function menuTriangle(){
	$('#menuTitleNav ul li').eq(6).addClass('active');
}
function searchData(page){
	if(page == '' || page == null){
		page=1;
	}
	$.ajax({
		url: "/jikuang/news/getNewsInfoPage.html",
		type: "POST",
		dataType: "json",
		data:{
			'newsType': 'B',
			'page': page,
			'pageSize': pageSize
			},
		success: function(data){
			if(data.success == true){
				pageinfo(data.data.page,data.data.pageCount,"#mainArea");
				
				var rows = data.data.rows;
				$('#dynamicsList').html('');
				for(var i=0;i<rows.length;i++){
					/*var dynamicsNews = '<div class="dynamicsNews">'+
											'<div class="left">'+
												'<img src="/jikuang/'+rows[i].coverThumb+'" >'+
											'</div>'+
											'<div class="right">'+
												'<ul>'+
													'<li class="newsTitle">'+
														'<a href="/jikuang/news/topld.html?newsId='+rows[i].newsId+'&page=6" target="_blank">'+rows[i].title+'</a>'+
													'</li>'+
													'<li class="newContent">'+rows[i].introduction+'<a href="/jikuang/news/topld.html?newsId='+rows[i].newsId+'&page=6" style="color:#fa6d35;margin-left:10px" target="_blank">查看更多</a></li>'+
													'<li class="newsElse">'+
														'<span class="date">'+rows[i].createTime+'</span>'+
														'<span>作者：<span class="auther">环境保护</span></span>'+
														'<span>阅读：<span class="readingNum">57</span></span>'+
													'</li>'+
												'</ul>'+
											'</div>'+
										'</div>';*/
					var dynamicsNews = '<li>'+
						 					'<span class="redPoint"></span>'+
						 					'<span class="newsTitle"><a href="/jikuang/news/topld.html?newsId='+rows[i].newsId+'&page=6" target="_blank">'+rows[i].title+'</a></span>'+
						 					'<span class="dateTime">'+rows[i].createTime+'</span>'+
						 			 '</li>';
					$('#dynamicsList').append(dynamicsNews);
				}
				
				$('.left img').each(function(){
					$(this).height($(this).width()/1.2);
					$('.right').height($(this).width()/1.2);
				})
			}
		}	
	})
}