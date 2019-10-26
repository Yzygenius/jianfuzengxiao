/**
 * 打开window窗口时，使其自动居中
 */
var easyuiPanelOnOpen = function(left, top) {
    var iframeWidth  = $(this).parent().parent().width();
    var windowWidth  = $(this).parent().width();
    var iframeHeight = $(this).parent().parent().height();
    var windowHeight = $(this).parent().height();

    var setWidth = (iframeWidth - windowWidth) / 2;
    var setHeight = (iframeHeight - windowHeight) / 2;
    $(this).parent().css({/* 修正面板位置 */
        left: setWidth,
        top: setHeight
    });
    if (iframeHeight < windowHeight) {
        $(this).parent().css({/* 修正面板位置 */
            left: setWidth,
            top: 0
        });
    }
    $(".window-shadow").hide();
};
$.fn.window.defaults.onOpen = easyuiPanelOnOpen;

jQuery.fn.serializeJson = function() {
	var result = {};
	var objs = this[0].elements;
	for ( var i = 0; i < objs.length; i++) {
		if (typeof (objs[i].name) != "undefined" && objs[i].name != '') {
			if (objs[i].tagName == "SELECT" && objs[i].value == '-1') {
			} else {
				result[objs[i].name] = objs[i].value;
			}
		}
	}

	var oldJsonStr = JSON.stringify(result);
	// 替换json串中的（"null"）在IE8的一些版本中，使用JSON.stringify(result)时，会将空串转为字符串"null"
	var newJsonStr = oldJsonStr.replace(new RegExp("\"null\"", "gm"), "\"\"");

	return newJsonStr;
}

jQuery.fn.serializeEasyuiJson = function() {
	var result = {};
	
	var handleElem = [];
	var getRadio = function(name) {
		var val = $("input[name='"+name+"']:checked").val();
		return val === undefined ? '' : val;
	};
	var checkHandleState = function(name) {
		return $.inArray(name, handleElem) >= 0;
	};
	var getComboboxVal = function(name) {
		var target = $("input[name="+name+"]");
		if (target.length <= 0) {
			return null;
		}
		var val = '';
		target.each(function(i, obj){
			val += ',' + obj.value;
		});
		return val == '' ? '' : val.substring(1);
	}
	
	var objs = $(this).find('input,textarea');
    for (var i=0; i<objs.length; i++) {
	    var obj = objs[i];
	    var objId = $.trim(obj.id),
	    	objName = $.trim(obj.name);
	    if ($(obj).hasClass('easyui-combobox')) {
	    	var elemName = $(obj).attr('textboxname');
	    	if (!checkHandleState(elemName)) {
	    		result[elemName] = getComboboxVal(elemName);
	    		handleElem.push(elemName);
	    	}
	    	continue;
	    }
		if (objName == "" || checkHandleState(objName)) 
			continue;
		
	    // TEXTAREA 直接取值
		if (obj.nodeName == 'TEXTAREA') {
	    	result[objName] = obj.value;
	    	continue;
	    }
		// RADIO 取埴
		if (obj.type == 'radio') {
			result[objName] = getRadio(objName);
			handleElem.push(objName);
			continue;
		}
		// INPUT标签，根据Easyui控件类型取值
	    switch(obj.className) {
	    case 'switchbutton-value':
	    	result[objName] = obj.checked ? '1' : '0';
		    break;
		default:
	    	result[objName] = obj.value;
	    }
	}
	return result;
}

jQuery.fn.batchSetEasyuiById = function(json) {
    var $form = $(this);
    $.each(json, function(id, val) {
        var $elem = $form.find('[id=' + id + ']')[0];
        if (!$elem)
            return;
        var clzName = $elem.className;
        var $target = $('#' + id);
        if (typeof(clzName) == 'undefined' || clzName == '') {
        	$target.val(val);
	    } else if (clzName.indexOf('combobox-f') != -1) {  // combobox
	    	$target.combobox('select', val);
		} else if (clzName.indexOf('switchbutton-f') != -1) {  // switchbutton
			$target.switchbutton(val=='1' || val=='A' ? 'check' : 'uncheck');
		} else if (clzName.indexOf('textbox-f') != -1) {  // textbox
			$target.textbox('setValue', val);
		} else {
			$target.val(val);
		}
	});
}

jQuery.fn.checkSelected = function(option) {
	$rule = $.extend({multiple: true}, option);
	var $target = $(this);
	var selrow = $target.datagrid('getSelections');
	if (selrow.length <= 0) {
		myalert($rule.multiple ? '请至少选择一行数据！' : '请选择一行数据！');
		return false;
	}
	if (!$rule.multiple &&  selrow.length > 1) {
		myalert('只能选择一行数据！');
		return false;
	}
	return true;
}

function myalert(text){
	window.parent.$.messager.alert({title: '温馨提示', ok: '确定', msg:text});
}

function myshow(text){
	window.parent.$.messager.show({title: '温馨提示', msg: text, timeout: 2000, showType: 'slide'});	
}

function myconfirm(text,callback){
	window.parent.$.messager.confirm({title: '请确认', ok: '确定', cancel: '取消', msg:text, fn:callback});
}

jQuery.fn.textboxEnter = function(callback) {
	$(this).textbox({
		inputEvents: $.extend({}, $.fn.textbox.defaults.inputEvents, {
			keyup: function(event){
				if(event.keyCode == 13) {
					callback();
				}
			}
		})
	});
}

/**
 * 重置combobox下拉框
 * 
 * @param value 重置后选中的值，如果不传该值，则默认选中第一个
 */
$.extend($.fn.combobox.methods, {
    reset: function (jq, value) {
    	var data = $(jq).combobox('getData');
    	if ($.isEmptyObject(data)) {
    		return;
    	}
    	
    	if (value == undefined) {
    		// 默认选中第一个选项
    		var valueField = $(jq).combobox('options').valueField;
    		value = data[0][valueField];
    	}
    	$(jq).combobox('select', value);
    }
});

$.extend($.fn.datagrid.methods, {
	getSelectedField: function (jq, field) {
		var result = '';
		var dataArr = $(jq).datagrid('getSelections');
		if ($.isEmptyObject(dataArr) || $.trim(field) == '') {
			return result;
		}

		$.each(dataArr, function(i, row){
			if ($.inArray(field, row)) {
				result += ',' + row[field];
			}
		});
		return result == '' ? result : result.substring(1);
	}
});
