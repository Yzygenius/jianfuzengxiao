function openTab(title, url, refresh) {
	mainPlatform.openTab(title, url, refresh);
}

function closeSelectedTab() {
	var tab = $('.easyui-tabs1').tabs('getSelected');
	var index = $('.easyui-tabs1').tabs('getTabIndex',tab);
	$('.easyui-tabs1').tabs('close', index);
}

function invokeTabMethod(tabName, fn, args) {
	if($('.easyui-tabs1').tabs('exists', tabName)){
		$target = $('.easyui-tabs1').tabs('getTab', tabName).find('iframe')[0].contentWindow;
		$target.eval(fn).apply(this, args);
	}
}

function invokeSelectedTabMethod(fn, args) {
	$target = $('.easyui-tabs1').tabs('getSelected').find('iframe')[0].contentWindow;
	$target.eval(fn).apply(this, args);
}

function openDialog(options) {
	if ($("#model1").html().trim() == "") {
		if(!options.onClose) {
			options.onClose = closeDialog;
		}
		$("#model1").dialog(options);
		return;
	}
	if ($("#model2").html().trim() == "") {
		if(!options.onClose) {
			options.onClose = closeDialog;
		}
		$("#model2").dialog(options);
	}
}

function closeDialog() {
	if ($("#model2").html().trim() != "") {
		$("#model2").dialog("destroy");
		$("#model_level2").append('<div id="model2"></div>');
		return;
	}
	if ($("#model1").html().trim() != "") {
		$("#model1").dialog("destroy");
		$("#model_level1").append('<div id="model1"></div>');
	}
}