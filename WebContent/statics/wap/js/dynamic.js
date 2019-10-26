//矿业资讯列表
var pageSize =10;
$(function(){
		seachData();
})
function menuTriangle(){
	$('#menuTitleNav ul li').eq(6).addClass('active');
}
function seachData(page){
	if(page == '' || page == null){
		page=1;
	}
	$.ajax({
		url: "/jikuang/news/getNewsInfoList.html",
		type: "POST",
		dataType: "json",
		data:{'newsType': 'C'},
		success: function(data){
			if(data.success == true){
				var rows = data.data;
				$('#dynamicsList').html('');
				for(var i=0;i<rows.length;i++){
					if(rows[i].author==undefined){
						rows[i].author="未知";
					}
					if(rows[i].introduction!=""||rows[i].introduction!=null){
						var introduction = rows[i].introduction;
						var introductions = introduction.substring(0,40);
					}else{
						var introductions="该企业暂未有简介"
					}
					var dynamicsNews = '<div class="dy_cont0">'+
											'<div class="news_cont">'+
												'<div class="news_name"><a href="/jikuang/wap/dynamic_detail.html?newsId='+rows[i].newsId+'&page=7">'+rows[i].title+
													'</a></div><div class="news_text"><span>'
														+introductions+'</span>  ...  </div>'+
												/*	'<a href="/jikuang/wap/dynamic_detail.html?newsId='+rows[i].newsId+'&page=6" target="_blank">查看更多</a></div>'+*/
													'<div class="news_time">'+
														'<div class="time0">发布时间：'+rows[i].createTime+'</div>'+
														'<div class="time1">作者：'+rows[i].author+'</div>'+
														'<div class="time2">阅读数：'+rows[i].readNumber+'</div>'+
													'</div></div></div>';
					$('#dynamicsList').append(dynamicsNews);
				}
				/*$('.news_img img').each(function(){
					$(this).height($(this).width()/1.2);
					$('.news_cont').height($(this).width()/1.2);
				})*/
			}
		}	
	})
}