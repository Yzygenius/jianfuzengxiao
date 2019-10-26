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
		data:{
			'page': page, 
			'pageSize': pageSize,
			'newsType': 'A',
			'title': $('#keyWord').val()
		},
		success: function(data){
			pageinfo(data.data.page, data.data.pageCount,"#mainArea")
			if(data.success == true){
				var rows = data.data.rows;
				$('#policyList').html('');
				for(var i=0;i<rows.length;i++){
					var li = '<li>'+
				 					'<span class="redPoint"></span>'+
				 					'<span class="policyTitle"><a href="/jikuang/news/topld.html?newsId='+rows[i].newsId+'&page=5" target="_blank">'+rows[i].title+'</a></span>'+
				 					'<span class="dateTime">'+rows[i].createTime+'</span>'+
				 			 '</li>';
					$('#policyList').append(li);
				}
			}else{
				alert(data.message)
			}
		},
		error: function(data){
			alert(data.message)
		}
		
	})
}
