var pageGeShu = 5;//页面显示页码数
var pageCountData = 0;
var parentElement;
//var page = 1;
/* 当前页数， 总页数 */
function pageinfoMyTradeInfo(page, pageCount,element){
	parentElement = element;
	if(pageCount == 0){
		pageCount = 1;
	}
	pageCountData = pageCount;
	$(parentElement).find('.nowPageNum').text(page);
	$(parentElement).find('.totalPageNum').text(pageCount);
    //var pageCount = 0;
	if(pageGeShu == '' || pageGeShu == null || pageGeShu < 1){
		pageGeShu = 5
	}
    if (pageCount <= pageGeShu) {
        //pageCount = pageCount;
        
        if(page == 1){
            var str = '';
            for(var i = 0; i < pageCount; i++){
            	$(parentElement).find('.pageNumbers').html('');
                var p = (i + 1);
                if(i == 0){
                    str += '<span class="active" onclick="getMyTradeMessage('+p+')">'+p+'</span>';
                }else{
                    str += '<span onclick="getMyTradeMessage('+p+')">'+p+'</span>';
                }
            }
            $(parentElement).find('.pageNumbers').append(str);
            return page;
        }else{
        	$(parentElement).find('.pageNumbers span').each(function(i, e){
                if((i+1) == page){
                    $(this).addClass('active').siblings().removeClass('active');
                }
            });
        }
    } else if(pageCount > pageGeShu){
        if(page == 1){
            var str = '';
            for(var i = 0; i < pageGeShu; i++){
            	$(parentElement).find('.pageNumbers').html('');
                var p = (i + 1);
                if(i == 0){
                    str += '<span class="active" onclick="getMyTradeMessage('+p+')">'+p+'</span>';
                }else{
                    str += '<span onclick="getMyTradeMessage('+p+')">'+p+'</span>';
                }
            }
            $(parentElement).find('.pageNumbers').append(str);
        }else if(pageCount - page < pageGeShu){

            var str = '';
            for(var i = (pageGeShu-1); i >= 0; i--){
            	$(parentElement).find('.pageNumbers').html('');
                var p = pageCount - i;
                if(page == p){
                    str += '<span class="active" onclick="getMyTradeMessage('+p+')">'+p+'</span>';
                }else{
                    str += '<span onclick="getMyTradeMessage('+p+')">'+p+'</span>';
                }
            }
            $(parentElement).find('.pageNumbers').append(str);
        }else{
            var str = '';
            for(var i = 0; i < pageGeShu; i++){
            	$(parentElement).find('.pageNumbers').html('');
                var p = (i + page);
                if(page == p){
                    str += '<span class="active" onclick="getMyTradeMessage('+p+')">'+p+'</span>';
                }else{
                    str += '<span onclick="getMyTradeMessage('+p+')">'+p+'</span>';
                }
            }
            $(parentElement).find('.pageNumbers').append(str);
        }
        
    }

	$(parentElement).find('.pageLeftDouble').click(function(){
	    var li = $(parentElement).find('.pageNumbers').find('.active').text();
	    if(li > 1){
	    	getMyTradeMessage(1)
	    }else{
	        //alert('禁用')
	    }
	})
	$(parentElement).find('.pageLeft').click(function(){
	    var li = $(parentElement).find('.pageNumbers').find('.active').text();
	    if(li > 1){
	    	getMyTradeMessage((li-1))
	    }else{
	        //alert('禁用')
	    }
	})
	$(parentElement).find('.pageRight').click(function(){
	    var li = $(parentElement).find('.pageNumbers').find('.active').text();
	    if(pageCountData > li){
	    	getMyTradeMessage(li-(-1))
	    }else{
	        //alert('禁用')
	    }
	})
	$(parentElement).find('.pageRightDouble').click(function(){
	    var li = $(parentElement).find('.pageNumbers').find('.active').text();
	    if(pageCountData > li){
	    	getMyTradeMessage(pageCountData)
	    }else{
	        //alert('禁用')
	    }
	});

}