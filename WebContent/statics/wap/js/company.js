var mines = '';
var more = '';
var pageSize = 5;//页面大小
var before;//上次请求页码
$(function(){
	
	$('#searchBtn').click(function(){
		more = $('#keyWord').val();
		seachData();
	})	
	
	//明星企业
	$.ajax({
		url:"/jikuang/company/getCompanyInfoList.html",
		type:"post",
		dataType:"json",
		data:{'accountType': 'E','isRecommend': 'B'},
		success:function(data){/*console.log(data);*/
			var rows = data.data;
			$('.swiper-wrapper').html('');
			var str = '';
			for(var i=0;i<rows.length;i++){
				str += '<div class="name_box swiper-slide">'+
								'<a href="/jikuang/company/tomcd.html?id='+rows[i].companyId+'">'+
								'<img src="/jikuang/'+ rows[i].companyThumb+'" alt="'+rows[i].companyName+'">'+
								'<h5>'+rows[i].companyName +'</h5>'+
								'</a><p class="text0">'+rows[i].minesType+
								'</p>'+
						'</div>'
			}
			$('.swiper-wrapper').append(str);
			mySwiper()
		},
		error: function(data){console.log(data)}
	});
			
	//产品列表
	$.ajax({
		url:"/jikuang/goods/getGoodsInfoList.html",
		type:"post",
		dataType:"json",
		success:function(data){
			var rows = data.data;
			$('.BoxList').html('');
			var str = '';
			console.log(rows.length);
			for(var i=0;i<5;i++){
				str += '<div class="listBox">'
							+'<div class="list_img">'
								+'<a href="/jikuang/wap/company_detail.html?id='+rows[i].companyId+'">'
									+'<img src="/jikuang/statics/api/images/pro'+(i+6)+'.jpg">'
								+'</a>'
							+'</div>'
							+'<div class="list_infor">'
								+'<h5><a href="/jikuang/wap/company_detail.html?id='+rows[i].companyId+'">'+rows[i].companyName+'</a></h5>'
								+'<p class="pText"><span>主营产品</span><span class="texts0">'+rows[i].productName+'</span></p>'
								+'<p class="pText"><span>所在地</span><span class="texts1">'+rows[i].provName+rows[i].cityName+rows[i].areaName+'</span></p>'
								+'<p class="pText"><span>联系人</span><span class="texts2">'+rows[i].contactName+'</span></p>'
								+'<p class="pText ac_p"><span>储量(万吨)</span><span class="texts3">'+rows[i].price+'</span></p>'
								+'</div>'
							+'</div>'
				
			}
			$('.BoxList').append(str);
		},
		error:function(data){console.log(data)}
	});
	seachData();
})




/*function mySwiper(){
	var mySwiper = new Swiper('.swiper-container',{
		slidesPerView : 3,
		spaceBetween : 9,
		slidesPerGroup: 3,
		navigation: {
			nextEl: '.swiper-button-next',
			prevEl: '.swiper-button-prev',
		}
	})
	$('.swiper-slide img').height($('.swiper-slide img').width())
	$('#companyLeft').height($('#companyRight').height())
}*/
function mySwiper(){
	var mySwiper = new Swiper('.swiper-container',{
		slidesPerView : 3,
		spaceBetween : 9,
		slidesPerGroup: 3,
		/*loop: true,
		loopAdditionalSlides:true,
	    autoplay: {
	        delay: 5000,
	        disableOnInteraction: false,
	    },*/
		navigation: {
			nextEl: '.swiper-button-next',
			prevEl: '.swiper-button-prev',
		}
	})
	$('.swiper-slide img').height($('.swiper-slide img').width())
	$('#companyLeft').height($('#companyRight').height())
}





	//搜索
function seachData(page){
	if(page == '' || page == null){
		page = 1;
	}
	$.ajax({
		url:"/jikuang/goods/getGoodsInfoPage.html",
		type:"post",
		dataType:"json",
		data:{'page': page, 'pageSize': pageSize, 'minesTypeId': mines, 'moreSearch': more},
		success:function(data){
			var rows = data.data.rows;
			$('.BoxList').html('');
			var str="";
			for(var i=0;i<rows.length;i++){
				str += '<div class="listBox">'
				+'<div class="list_img">'
					+'<a href="/jikuang/wap/company_detail.html?id='+rows[i].companyId+'">'
						+'<img src="/jikuang/statics/api/images/pro'+(i+6)+'.jpg">'
					+'</a>'
				+'</div>'
				+'<div class="list_infor">'
					+'<h5><a href="/jikuang/wap/company_detail.html?id='+rows[i].companyId+'">'+rows[i].companyName+'</a></h5>'
					+'<p class="pText"><span>主营产品</span><span class="texts0">'+rows[i].productName+'</span></p>'
					+'<p class="pText"><span>所在地</span><span class="texts1">'+rows[i].provName+rows[i].cityName+rows[i].areaName+'</span></p>'
					+'<p class="pText"><span>联系人</span><span class="texts2">'+rows[i].contactName+'</span></p>'
					+'<p class="pText ac_p"><span>储量(万吨)</span><span class="texts3">'+rows[i].price+'</span></p>'
					+'</div>'
				+'</div>'
			}
			$('.BoxList').append(str);
		},
		error: function(data){console.log(data)}
	});
}

