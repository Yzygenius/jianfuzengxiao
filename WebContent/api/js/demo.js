

console.log(jQuery.base64.encode('eGlhb21hYnVoZWk='))
function setupWebViewJavascriptBridge(callback) {
	if(window.WebViewJavascriptBridge) {
		callback(WebViewJavascriptBridge)
	} else {
		document.addEventListener(
			'WebViewJavascriptBridgeReady',
			function() {
				callback(WebViewJavascriptBridge)
			},
			false
		);
	}

	if(window.WVJBCallbacks) {
		return window.WVJBCallbacks.push(callback);
	}
	window.WVJBCallbacks = [callback];
	var WVJBIframe = document.createElement('iframe');
	WVJBIframe.style.display = 'none';
	WVJBIframe.src = 'wvjbscheme://__BRIDGE_LOADED__';
	document.documentElement.appendChild(WVJBIframe);
	setTimeout(function() {
		document.documentElement.removeChild(WVJBIframe)
	}, 0)
}

setupWebViewJavascriptBridge(function(bridge) {
	//注册原生调起方法
	//参数1： buttonjs 注册flag 供原生使用，要和原生统一
	//参数2： data  是原生传给js 的数据
	//参数3： responseCallback 是js 的回调，可以通过该方法给原生传数据
	bridge.registerHandler("webReCall", function(data, responseCallback) {

		document.getElementById("content").innerHTML = data;
		responseCallback("button js callback");
	});

})
document.getElementById('enter1').onclick = function(e) {
	var data = {
		'action': 'jsNGetPhoto',
		'needCallBack': '',
		'message': '',
		'parameter': {
			'scale': '0.5,1.0',
		}
	}
	window.WebViewJavascriptBridge.callHandler('nativeListener', data, function(resp) {
		var list=JSON.parse(resp)
		// document.getElementById("content").innerHTML = list.msg;
		var html = "<img src=\"'data:image/jpeg;base64,'+list.data.img\"alt=\"\">"
		document.getElementById('enter1').innerHTML = html;
	});
}
document.getElementById('enter4').onclick = function(e) {
	var data = {
		'action': 'jsNShowLoading',
		'needCallBack': '',
		'message': '',
		'parameter': {
			'state': '',
			'alert': ''
		}
	}
	window.WebViewJavascriptBridge.callHandler('nativeListener', data, function(resp) {
		var list=JSON.parse(resp)
		document.getElementById("content").innerHTML = list.data.msg;
	});
}