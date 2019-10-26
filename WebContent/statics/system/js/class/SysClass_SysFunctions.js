//系统函数
function SysFunctions(){
	
}
SysFunctions.getExplorer = function(){
	var explorer = window.navigator.userAgent ;
	//ie10以下
	if (explorer.indexOf("MSIE") >= 0) {
		return 'ie';
	}
	//ie11以上
	if (!!window.ActiveXObject || "ActiveXObject" in window) {
		return 'ie';
	}
	//firefox
	else if (explorer.indexOf("Firefox") >= 0) {
		return 'Firefox';
	}
	//Chrome
	else if(explorer.indexOf("Chrome") >= 0){
		return 'Chrome';
	}
	//Opera
	else if(explorer.indexOf("Opera") >= 0){
		return 'Opera';
	}
	//Safari
	else if(explorer.indexOf("Safari") >= 0){
		return 'Safari';
	}
}
//数组转字符串
SysFunctions.aryToString = function(tarAry, linkChar){
	var returnStr = "";
	for (var i = 0; i < tarAry.length-1; i++) {
		returnStr +=tarAry[i] + linkChar;
    }
	return returnStr += tarAry[tarAry.length-1];
}
//日差数量
SysFunctions.getDayDif = function(startDate,endDate){
	return (endDate.getTime()-startDate.getTime())/(1000*60*60*24);
}
//月差数量
SysFunctions.getMonthDif = function(startDate,endDate){
	startYear = startDate.getFullYear();
	startMonth = startDate.getMonth();
	endYear = endDate.getFullYear();
	endMonth = endDate.getMonth();
	return (endYear-startYear)*12+(endMonth-startMonth);
}
//获取下一天
SysFunctions.getNextDate = function(tarDate){
	var nextDate=new Date(tarDate);
	nextDate.setDate(nextDate.getDate()+1);
	
	return nextDate;
}
//按日差获得时间
SysFunctions.getDateByDif = function(startDate,dayDif){
    return new Date(startDate.getTime() + 1000 * 60 * 60 * 24 * dayDif);
}
//获取日期字符串
SysFunctions.getDateString = function(tarDate,linkChar,timeFlg){
	var year = tarDate.getFullYear();
	var month = tarDate.getMonth()+1;
    if(month<10){
        month = "0" + month;
    }
	var day = tarDate.getDate();
	if(day<10){
		day = "0" + day;
	}
	var hour = tarDate.getHours();
	if(hour<10){
		hour = "0" + hour;
	}
	var minute = tarDate.getMinutes();
	if(minute<10){
		minute = "0" + minute;
	}
	var second = tarDate.getSeconds();
	if(second<10){
		second = "0" + second;
	}
	
	if(linkChar==null || linkChar==undefined){
		linkChar = "-";
	}
	if(timeFlg){
		return year + linkChar + month + linkChar + day + linkChar + hour + linkChar + minute + linkChar + second;
	}else{
	    return year + linkChar + month + linkChar + day;
	}
}
//获取字符串日期
SysFunctions.getStringDate = function(dateStr,linkChar,timeFlg){
	var strAry = dateStr.split(linkChar);
	if(timeFlg){
		return new Date(strAry[0],strAry[1]-1,strAry[2],strAry[3],strAry[4],strAry[5]);
	}else{
		return new Date(strAry[0],strAry[1]-1,strAry[2]);
	}
}
//获取不同尾标图片
SysFunctions.getTarImg = function(imgUrl,typeFlg){
	var aaa = imgUrl.split("/");
	var bbb = aaa.pop().split("_");
	var ccc = SysFunctions.aryToString(aaa,"/");
	return ccc + "/" + bbb[0] + "_" + typeFlg + ".png";
}
//获取亏吨罚款
SysFunctions.getPenalty = function(primaryWeight,realWeight,rate,penalty){
	return SysFunctions.numMul(SysFunctions.getKuisun(primaryWeight,realWeight,rate),penalty);
}
//获取亏吨
SysFunctions.getKuisun = function(primaryWeight,realWeight,rate){
	var dunCha = SysFunctions.numSub(primaryWeight,realWeight);
	var kuiDunFlg = SysFunctions.numDiv(dunCha,primaryWeight) > rate/100;
	if(kuiDunFlg){
		return SysFunctions.numSub(dunCha,SysFunctions.numMul(primaryWeight,rate/100));
	}
	return 0;
}
//浮点数计算公式
SysFunctions.numAdd = function(a, b){
    var c, d, e;
    try {
        c = a.toString().split(".")[1].length;
    } catch (f) {
        c = 0;
    }
    try {
        d = b.toString().split(".")[1].length;
    } catch (f) {
        d = 0;
    }
    return e = Math.pow(10, Math.max(c, d)), (SysFunctions.numMul(a, e) + SysFunctions.numMul(b, e)) / e;
}
SysFunctions.numSub = function(a, b){
    var c, d, e;
    try {
        c = a.toString().split(".")[1].length;
    } catch (f) {
        c = 0;
    }
    try {
        d = b.toString().split(".")[1].length;
    } catch (f) {
        d = 0;
    }
    return e = Math.pow(10, Math.max(c, d)), (SysFunctions.numMul(a, e) - SysFunctions.numMul(b, e)) / e;
}
SysFunctions.numMul = function(a, b){
    var c = 0,
        d = a.toString(),
        e = b.toString();
    try {
        c += d.split(".")[1].length;
    } catch (f) {}
    try {
        c += e.split(".")[1].length;
    } catch (f) {}
    return Number(d.replace(".", "")) * Number(e.replace(".", "")) / Math.pow(10, c);
}
SysFunctions.numDiv = function(a, b){
    var c, d, e = 0,
        f = 0;
    try {
        e = a.toString().split(".")[1].length;
    } catch (g) {}
    try {
        f = b.toString().split(".")[1].length;
    } catch (g) {}
    return c = Number(a.toString().replace(".", "")), d = Number(b.toString().replace(".", "")), SysFunctions.numMul(c / d, Math.pow(10, f - e));
}
SysFunctions.getTopSize = function(){
	return {
		width: $(window.top).width(),
		height: $(window.top).height(),
	}
}


function getObjectURL(file) {
    var url = null ;
    if (window.createObjectURL!=undefined) { // basic
        url = window.createObjectURL(file) ;
    } else if (window.URL!=undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file) ;
    } else if (window.webkitURL!=undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file) ;
    }
    return url ;
}