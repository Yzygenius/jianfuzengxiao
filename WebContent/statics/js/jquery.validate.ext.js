jQuery.validator.addMethod("isMobile", function(value, element) {
    var length = value.length;
    var mobile = /^1[34578][0-9]{9}$/;
    return this.optional(element) || (length == 11 && mobile.test(value));
}, "请填写有效的手机号码");

jQuery.validator.addMethod("isQQ", function(value, element) {
	var length = value.length;
	var qq = /^[1-9][0-9]{4,9}$/;
	return this.optional(element) || qq.test(value);
}, "请填写有效的QQ号码");

jQuery.validator.addMethod("isFix", function(value, element) {
	var length = value.length;
	var fix = /^[1-9]\d{6,7}$/;
	return this.optional(element) || fix.test(value);
}, "请填写有效的固话号码");

jQuery.validator.addMethod("isPlate", function(value, element) {
	var length = value.length;
	var reg = /^(京|津|沪|渝|冀|豫|云|辽|黑|湘|皖|鲁|尔|苏|浙|赣|鄂|桂|甘|晋|蒙|陕|吉|闽|贵|粤|青|藏|川|宁|琼)\w{6}$/i;
	return this.optional(element) || reg.test(value);
}, "请填写有效的固话号码");

jQuery.validator.addMethod("int", function(value, element) {
    var length = value.length;
    var regex = /^[1-9]\d*$/;
    return this.optional(element) || (length > 0 && regex.test(value));
}, "请填写有效的整数");

jQuery.validator.addMethod("intZero", function(value, element) {
	var length = value.length;
	var regex = /^\d+$/;
	return this.optional(element) || (length > 0 && regex.test(value));
}, "请填写有效的整数");
