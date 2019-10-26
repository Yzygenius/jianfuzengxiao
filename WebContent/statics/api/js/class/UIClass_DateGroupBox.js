//货物---------------------------------------------------------------------------------
DateGroupBox.TypeStartDate = "TypeStartDate";//起始时间
DateGroupBox.TypeEndDate = "TypeEndDate";//终止时间

function DateGroupBox(targetId,typeFlg){
	//绑定元素
    this.element = $(targetId);
    this.element.append("<div id='startDate'></div> ~ ");
    this.element.append("<div id='endDate'></div>");
    this.startDate = this.element.children("#startDate");
    this.endDate = this.element.children("#endDate");
    this.startDate_DB = new DateBox("#startDate",DateBox.TypeDay);
    this.endDate_DB = new DateBox("#endDate",DateBox.TypeDay);
    //设置属性
    this.type = typeFlg;

    this.iniDateGroupBox();
}
DateGroupBox.prototype.iniDateGroupBox = function(){
    //
    this.setCss();
}
DateGroupBox.prototype.setCss = function(){
    //设置样式
    var css;
    css = {
        "height": "40px",
        "vertical-align": "middle",
        "line-height": "40px",
        "background": "#ffffff",
    }
    this.element.css(css);
    css = {
    	"display": "inline-block",
    }
    this.startDate.css(css);
    css = {
    	"display": "inline-block",
    }
    this.endDate.css(css);
}
DateGroupBox.prototype.setStartDateText = function(dateStr){ //设置选中值
	return this.startDate_DB.setDateText(dateStr);
}
DateGroupBox.prototype.setEndDateText = function(dateStr){ //设置选中值
	return this.endDate_DB.setDateText(dateStr);
}
DateGroupBox.prototype.getStartDateText = function(){ //获取选中值
	return this.startDate_DB.getDateText();
}
DateGroupBox.prototype.getEndDateText = function(){ //获取选中值
	return this.endDate_DB.getDateText();
}