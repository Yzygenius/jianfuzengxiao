var mines = '';
var more = '';
var pageSize = 5; //页面大小
var before;//上次请求页码
$(function(){
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

	searchData();
})
	
function searchData(page){
	if(page == '' || page == null){
		page = 1;
	}
	$.getJsonA("/jikuang/goods/getGoodsInfoPage.html",{'page': page, 'pageSize': pageSize, 'minesTypeId': mines, 'moreSearch': more},function(data){
	
		if(data.success){
			pageinfo(data.data.page, data.data.pageCount,"#companyList")
			
			var rows = data.data.rows;
			$('#companyDataList').html('');
			var str = '';
			for(var i=0;i<rows.length;i++){
				str += '<li><div class="listLeft"><div class="companyName" onclick="toCompany('+rows[i].companyId+')">'+rows[i].companyName+'</div>';
				str += '<div><span class="leftTitle">主营产品</span><span class="mainProduct">'+rows[i].productName+'</span></div>';
				str += '<div><span class="leftTitle">所在地</span><span class="localState">'+rows[i].provName+rows[i].cityName+rows[i].areaName+'</span></div>';
				str += '<div><span class="leftTitle">联系人</span><span class="contactName">'+rows[i].contactName+'</span></div>';
				//str += '<div><span class="leftTitle">联系方式</span><span class="contactPhone">'+rows[i].contactTel+'</span></div>';
				str += '<div><span class="leftTitle">储量 (万吨)</span><span class="keepWeight">'+rows[i].reserves+'</span></div></div>';
				str += '<div class="listRight"><img src="/jikuang/'+rows[i].imgThumb+'" alt="">';
				str += '<img src="/jikuang/'+rows[i].imgThumb2+'" alt="">';
				str += '<img src="/jikuang/'+rows[i].imgThumb3+'" alt="">';
				str += '<img src="/jikuang/'+rows[i].imgThumb4+'" alt=""></div></li>';
			}
			$('#companyDataList').append(str);
			$('.listRight img').each(function(){
				$(this).height($(this).width())
			})
		} 
	},true);
}
function toCompany(companyid){
	window.location.href="/jikuang/company/tomcd.html?id="+companyid;
}
function menuTriangle(){
	$('#menuTitleNav ul li').eq(2).addClass('active');
}