$(function(){
	searchData();
	$('#searchBtn').click(function(){
		searchData()
	})
});

var pageSize = 10; //页面大小
function menuTriangle(){
	$('#menuTitleNav ul li').eq(5).addClass('active');
}
function searchData(page){
	if(page == '' || page == null){
		page = 1;
	}
	
	
	$.ajax({
		url: "/jikuang/news/getNewsInfoPage.html",
		type: "POST",
		dataType: "json",
		data:{'page': page,'pageSize': pageSize,'newsType': 'A','title': $('#keyWord').val()},
		success: function(data){
			pageinfo(data.data.page, data.data.pageCount,"#mainArea")
			if(data.success == true){
				var rows = data.data.rows;
				$('#policyList').html('');
				var str='';
				for(var i=0;i<rows.length;i++){
					str = '<li><span>·</span><p class="text"><a href="/jikuang/wap/dynamic_detail.html?newsId='+rows[i].newsId+'&page=5">'+rows[i].title+'</a></p><p class="date">'+rows[i].createTime+'</p></li>';
					$('#policyList').append(str);
				}
			}
		},
		error: function(data){
			alert(data.message)
		}
	})
	
}




/*
$(function(){
	getNewsData();
	$('#searchBtn').click(function(){
		if($('#keyWord').val() != ''){
			getNewsData($('#keyWord').val())
		}
	})
});
function getNewsData(keyword){
	$.ajax({
		url: "/jikuang/news/getNewsInfoList.html",
		type: "POST",
		dataType: "json",
		data:{'newsType': 'A','title': keyword},
		success: function(data){
			if(data.success == true){
				var rows = data.data;
				var str='';
				$('#policyList').html('');
				for(var i=0;i<rows.length;i++){
					str = '<li><span>·</span><p class="text"><a href="/jikuang/wap/dynamic_detail.html?newsId='+rows[i].newsId+'&page=5">'+rows[i].title+'</a></p><p class="date">'+rows[i].createTime+'</p></li>';
					$('#policyList').append(str);
				}
			}
		}
		
	})
}
*/