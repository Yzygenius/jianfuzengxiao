

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
		console.log(resp)
		var list=JSON.parse(resp)
		// document.getElementById("content").innerHTML = list.msg;

        document.getElementById('preview10').setAttribute('src','');
		document.getElementById('preview10').setAttribute('src','data:image/jpeg;base64,'+list.data.img)
	});
}
document.getElementById('enter2').onclick = function(e) {
	var data = {
		'action': 'jsNGetIDCard',
		'needCallBack': '1',
		'message': '',
		'parameter': {}
	}
	window.WebViewJavascriptBridge.callHandler('nativeListener', data, function(resp) {
        var list=JSON.parse(resp);
        var result= $.inArray("姓名", list.data.GetFieldName);
        // for(var i in list.data.GetFieldName){
        	if(result !== -1){
		        document.getElementById('preview11').setAttribute('src','');
		    	document.getElementById('preview11').setAttribute('src','data:image/jpeg;base64,'+list.data.img);
				document.getElementById('trigger1').value = '身份证';
				for(var i in list.data.GetFieldName){
		    	// $('#content').append(list.data.GetFieldName[i]);
					if(list.data.GetFieldName[i] === '姓名'){
						document.getElementById('namev').value = list.data.GetRecogResult[i];
					}else if(list.data.GetFieldName[i] === '民族'){
						document.getElementById('trigger3').value = list.data.GetRecogResult[i]+'族';
					}else if(list.data.GetFieldName[i] === '性别'){
						document.getElementById('trigger2').value = list.data.GetRecogResult[i];
					}else if(list.data.GetFieldName[i].indexOf('出生') != -1){
						document.getElementById('select_2').value = list.data.GetRecogResult[i];
					}else if(list.data.GetFieldName[i] === '住址'){
						document.getElementById('address').value = list.data.GetRecogResult[i];
					}else if(list.data.GetFieldName[i] === '公民身份号码'){
						document.getElementById('measnnum').value = list.data.GetRecogResult[i];
					}
				}
				
				// document.getElementById('namev').value = list.data.GetRecogResult[0];
				// document.getElementById('select_2').value = list.data.GetRecogResult[3];
				// document.getElementById('trigger3').value = list.data.GetRecogResult[2]+'族';
				// document.getElementById('measnnum').value = list.data.GetRecogResult[5];
				// document.getElementById('address').value = list.data.GetRecogResult[4];
				var enter = document.getElementById('prev1');
				enter.remove();
				Positive('身份证',document.getElementById('trigger2').value,document.getElementById('select_2').value,document.getElementById('trigger3').value);
        	}else if(result == -1){
        		if(document.getElementById('prev1')){
        			var enter = document.getElementById('prev1');
        			enter.innerText = '请识别身份证指定的一面'
        			enter.setAttribute('style','display:block!important;font-size:18px;font-weight:blod;');
        		}else{
        			var enter0 = document.getElementById('enter2');
        			var p=document.createElement('p');
        			p.setAttribute('class','faceword1');
        			p.setAttribute('id','prev1');
        			enter0.appendChild(p);
        		}
        	}
        // }
    });
}
document.getElementById('enter3').onclick = function(e) {
	var data = {
		'action': 'jsNGetIDCard',
		'needCallBack': '1',
		'message': '',
		'parameter': {}
	}
	window.WebViewJavascriptBridge.callHandler('nativeListener', data, function(resp) {
        var list=JSON.parse(resp);
        var result= $.inArray("签发机关", list.data.GetFieldName);
        // for(var i in list.data.GetFieldName){
        	if(result !== -1){
		        document.getElementById('preview12').setAttribute('src','');
		    	document.getElementById('preview12').setAttribute('src','data:image/jpeg;base64,'+list.data.img);
		    	// document.getElementById("content").innerHTML =list.data.GetRecogResult;
		    	for(var i in list.data.GetFieldName){
					if(list.data.GetFieldName[i] === '签发机关'){
						document.getElementById('measn12').value = list.data.GetRecogResult[i];
					}else if(list.data.GetFieldName[i] === '有效期至'){
						document.getElementById('select_3').value = list.data.GetRecogResult[i];
					}else if(list.data.GetFieldName[i] === '签发日期'){
						document.getElementById('date1').value = list.data.GetRecogResult[i];
					}
				}
				Back(document.getElementById('date1').value,document.getElementById('select_3').value);
				// document.getElementById('date1').value = list.data.GetRecogResult[2];
				// document.getElementById('select_3').value = list.data.GetRecogResult[3];
				// document.getElementById('measn12').value = list.data.GetRecogResult[0];
				var enter = document.getElementById('prev2');
				enter.remove();
			}else if(result == -1){
				if(document.getElementById('prev2')){
        			var enter = document.getElementById('prev2');
        			enter.innerText = '请识别身份证指定的一面'
        			enter.setAttribute('style','display:block!important;font-size:18px;font-weight:blod;');
        		}else{
        			var enter0 = document.getElementById('enter3');
        			var p=document.createElement('p');
        			p.setAttribute('class','faceword1');
        			p.setAttribute('id','prev2');
        			enter0.appendChild(p);
        		}
			}
		// }
    });
}