var mines = '';
var more = '';
var pageSize = 5;//页面大小
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
	//矿业排名
	$.getJsonA("/jikuang/company/getCompanyInfoList.html",{'accountType': 'E'},function(data){
			if(data.success){
				var rows = data.data;
				$('.companyList ul').html('');
				var color=['red','#fa6d35','#eaea22'];
				for(var i=0;i<rows.length;i++){
					if(i>9){
						break
					}
					if(i<3){
						$('.companyList ul').append('<li>'+
								'<a href="/jikuang/company/tomcd.html?id='+rows[i].companyId+'">'+
									'<span class="threePoint" style="background:'+color[i]+'">'+(i + 1)+'</span>'+
									'<span class="companyTitle" title="'+rows[i].companyName+'">'+
										rows[i].companyName +
									'</span>'+
								'</a></li>')
					}else{
						$('.companyList ul').append('<li>'+
												'<a href="/jikuang/company/tomcd.html?id='+rows[i].companyId+'">'+
													'<span class="redPoint"></span>'+
													'<span class="companyTitle" title="'+rows[i].companyName+'">'+
														rows[i].companyName +
													'</span>'+
												'</a></li>')
					}
				}
				
				
			}
		},true);
	
	//明星企业
	$.getJsonA("/jikuang/company/getCompanyInfoList.html",{'accountType': 'E','isRecommend': 'B'},function(data){
		if(data.success){
			var rows = data.data;
			$('.swiper-wrapper').html('');
			var str = '';
			for(var i=0;i<rows.length;i++){
				str += '<div class="swiper-slide">'+
							'<a href="/jikuang/company/tomcd.html?id='+rows[i].companyId+'">'+
								'<img src="/jikuang/'+rows[i].companyThumb+'" alt="'+rows[i].companyName+'">'+
								'<p>'+rows[i].companyName+'</p>'+
								'<p style="color: #fa6d35;">矿种：'+rows[i].minesType+'</p>'+
							'</a>'+
						'</div>'
			}
			$('.swiper-wrapper').append(str);
			mySwiper()
		}
	},true);
	
	//产品列表
	$.getJsonA("/jikuang/goods/getGoodsInfoList.html",{},function(data){
		if(data.success){
			var rows = data.data;
			$('#productList').html('');
			var str = '';
			for(var i=0;i<rows.length;i++){
				if(i>2){
					break
				}
				str += '<li>'+
							'<a href="###">'+
								'<img src="/jikuang/'+rows[i].imgThumb+'">'+
								'<p>'+rows[i].productName+'</p>'+
								'<p>￥'+rows[i].price+'</p>'+
							'</a>'+
						'</li>'
			}
			$('#productList').append(str);
			
			
		}
	},true);
	

	searchData();
})




function mySwiper(){
	var mySwiper = new Swiper('.swiper-container',{
		slidesPerView : 5,
		spaceBetween : 20,
		slidesPerGroup: 5,
		navigation: {
			nextEl: '.swiper-button-next',
			prevEl: '.swiper-button-prev',
		}
	})
	$('.swiper-slide img').height($('.swiper-slide img').width())
	$('#companyLeft').height($('#companyRight').height())
}
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
				str += '<li><div class="listLeft"><a href="/jikuang/company/tomcd.html?id='+rows[i].companyId+'"><div class="companyName">'+rows[i].companyName+'</div></a>';
				str += '<div><span class="leftTitle">主营产品</span><span class="mainProduct">'+rows[i].minesTypeName+'</span></div>';
				str += '<div><span class="leftTitle">所在地</span><span class="localState">'+rows[i].provName+rows[i].cityName+rows[i].areaName+'</span></div>';
				str += '<div><span class="leftTitle">储量 (万吨)</span><span class="keepWeight">'+rows[i].reserves+'</span></div>';
				str += '<div><span class="leftTitle">综合评级</span><span class="compositeRating" starNum='+rows[i].competitiveValue+'></span></div></div>';
				str += '<div class="listRight">';
				//str += '<div class="goodsImagePrice"><img src="'+rows[i].imgThumb+'" alt="">';
				str += '<div class="goodsImagePrice"><img src="/jikuang/'+rows[i].imgThumb+'" alt="">';
				str += '<p>￥ '+rows[i].price+'</p></div>';
				str += '<div class="goodsChart"><img src="/jikuang/statics/api/images/goodsPrice.png" alt=""></div></div></li>';
			}
			$('#companyDataList').append(str);
			$('.listRight .goodsImagePrice img').each(function(){
				$(this).height($(this).width())
			})
			$('.listRight .goodsChart img').each(function(){
				$(this).height($('.listRight .goodsImagePrice img').height() + 40)
			})
			$('.listLeft .compositeRating').each(function(){
				for(var i=0;i<$(this).attr('starNum');i++){
					$(this).append('<img src="/jikuang/statics/api/images/star.png" alt="">')
				}
			})
		} 
	},true);
}

function menuTriangle(){
	$('#menuTitleNav ul li').eq(1).addClass('active');
}
