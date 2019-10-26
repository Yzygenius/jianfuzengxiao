!function ($) {
	$.extend({
		getJsonA:function (url, data, callback, async) {
			if(typeof(url) == "undefined" || $.trim(url)=="")
				return;
			if(typeof(data) == "undefined")
				data = {};
			if(typeof(async) == "undefined")
				async = true;
  			$.ajax({
				url:url,
				type:"post",
				async:async,
				dataType:"json",
				data:data,
				success: function(msg){
					__callbackBefore();
					if(typeof(callback)!="undefined") {
						callback(msg);
					}
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){
					__callbackBefore();
			     	//myalert('服务器出现异常，请联系管理员或重试');
			     	window.location.href = "${url:site('manager/logout')}";
				}
			});
		}
	})
}
(jQuery);


$(document).ajaxStart(function(){
//	onloading();
});

$(document).ajaxStop(function(){
	$("#DialogDiv").remove();
});

function onloading(msg){
	if(typeof(msg) == "undefined"){
		msg = "加载中，请稍候。。。";
	};
	var div = $('<div id="DialogDiv" style="font-family:\'微软雅黑\';font-size:12px;padding-top:20%;min-height:100%;max-height:100%;background:#fff;position:absolute;z-index:100000;top:0px;left:0px;text-align:center;filter:alpha(opacity=50);-moz-opacity:0.5;-khtml-opacity: 0.5;opacity: 0.5;"><img style="vertical-align:middle;padding-right:5px;" src="../statics/sa/css/themes/default/images/jiazai.gif" /><strong>'+msg+'</strong></div>');
	$(document.body).append(div);

	$(document.body).css("position","relative");
	$("#DialogDiv").css({
		height : $(document).height(),
		width : '100%'
	});
}

function __callbackBefore(){
	$("#DialogDiv").remove();
}

function datagridFormatRecommend(val,row){
	return val=='1' ? '是' : '否';
}

function datagridFormatSts(val,row){
	if(val=='A'){
		return '在用';
	}else{
		return '禁用';
	}
}

function datagridFormatState(val,row){
	return val=="1" ? "<span style='color:blue;'>在用</span>" : "<span style='color:red;'>禁用</span>";
}

function datagridFormatBoolean(val,row){
	return val=='1' ? '是' : '否';
}

function datagridFormatSex(val,row){
	return val=='M' ? '男' : '女';
}

function datagridFormatBlankNull(val,row){
	if ($.isEmptyObject(val)) {
		return "";
	}
	return val;
}