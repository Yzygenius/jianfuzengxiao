var mines = '';
var more = '';
var pageSize = 5; //页面大小
var before; //上次请求页码
$('#searchBtns').click(function(){
	seachData();
	more = $('#keyWord').val();
})

$(function(){seachData();})
	
function seachData(page){
	if(page == '' || page == null){
		page = 1;
	}
	
	$.ajax({
		url:"/jikuang/goods/getGoodsInfoPage.html",
		type:"post",
		dataType:"json",
		data:{'page': page, 'pageSize': pageSize, 'minesTypeId': mines, 'moreSearch': more},
		success:function(data){/*console.log(data);*/
		pageinfo(data.data.page, data.data.pageCount,"#mainArea")
		var rows = data.data.rows;
			$('#in_boxMap').html('');
			var str = '';
			for(var i=0;i<rows.length;i++){
				str += '<a href="/jikuang/wap/company_detail.html?id='+rows[i].companyId+'"><ul><li class="first">'+rows[i].productName+'</li>';
				str +='<li class="second">'+rows[i].companyName+'</li>';
				str +='<li class="third">'+rows[i].price+'</li>';
				str +='<li class="fourth"><img src="/jikuang/statics/wap/images/company/qus.png" alt=""></li>';
				str +='<li class="fifth">'+rows[i].createTime+'</li></ul></a>';
			}
			$('#in_boxMap').append(str);
			
		},
		error:function(data){console.log(data)}
	});
	
}

function mySwiper(){
	var mySwiper = new Swiper('.menuSwiper',{
		autoplay:true,
		loop:true,
		speed:1000,
		pagination:{
			el: '.menuSwiper .swiper-pagination',
			clickable: true,
			clickableClass : 'my-pagination-clickable',
		},
	})
}
