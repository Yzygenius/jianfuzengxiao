var mines = '';
var more = '';
var pageSize = 5; //页面大小
var before; //上次请求页码
$('.managementProductChoose span').click(function(){
	mines = $(this).attr('value');
	if(mines == 0){
		mines = '';
	}
	
	$(this).addClass('active').siblings().removeClass('active')
	searchData();
})
$('#searchBtn').click(function(){
	more = $('#keyWord').val();
	searchData();
})
	
function searchData(page){
	if(page == '' || page == null){
		page = 1;
	}
	$.getJsonA("/jikuang/goods/getGoodsInfoPage.html",{'page': page, 'pageSize': pageSize, 'minesTypeId': mines, 'moreSearch': more},function(data){
		
		if(data.success){
			pageinfo(data.data.page, data.data.pageCount,"#mainArea")
			
			var rows = data.data.rows
			$('#mainContentList').html('');
			var str = '';
			str += '<tr style="background: #faf2e7;height: 50px;"><th>名称</th><th>矿种</th><th>供应商</th><th>报价</th><th>产地</th><th>日期</th></tr>';
			for(var i=0;i<rows.length;i++){
				str += '<tr><td>'+rows[i].productName+'</td>';
				str += '<td>'+rows[i].minesTypeName+'</td>';
				str += '<td><div onclick="toCompany('+rows[i].companyId+')">'+rows[i].companyName+'</div></td>';
				str += '<td>'+rows[i].price+'</td>';
				str += '<td>'+rows[i].provName+rows[i].cityName+rows[i].areaName+'</td>';
				str += '<td>'+rows[i].createTime+'</td></tr>';
			}
			$('#mainContentList').append(str);
		} 
	},true);
}

searchData();

function toCompany(companyid){
	window.location.href="/jikuang/company/tomcd.html?id="+companyid;
}
function menuTriangle(){
	$('#menuTitleNav ul li').eq(3).addClass('active');
}