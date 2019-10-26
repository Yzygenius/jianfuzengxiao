//复选按钮---------------------------------------------------------------------------------
function CheckButton(targetId,checkValue,disText){
    //绑定元素
    this.element = $(targetId);
	this.element.append("<button></button>");
	this.element.append("<label></label>");
    this.btn = this.element.children("button");
	this.label = this.element.children("label");
    this.btn.append("<img></img>");
    this.img = this.btn.children("img");
	//设置属性
    this.checkValue = checkValue;
    this.disText = disText;

    this.iniCheckButton();
}
CheckButton.prototype.iniCheckButton = function(){
	var thisObj = this;
	this.changePos = false;
	this.checkClick = false;
	//设置样式
	this.setCss();
    //设置显示
	this.label.html(this.disText);
    //绑定事件
    this.btn.bind("mousedown",mouseDown);
	this.btn.bind("mouseup",mouseUp);
	this.btn.bind("click",checkClick);
    function mouseLeave(){
		thisObj.btn.unbind("mouseleave",mouseLeave);
		if(thisObj.changePos == true){
			thisObj.changePos = false;
			//内容偏移归位
			thisObj.img.offset({top:thisObj.img.offset().top-2,left:thisObj.img.offset().left-2});
			thisObj.btn.offset({top:thisObj.btn.offset().top-2,left:thisObj.btn.offset().left-2});
			//背景图
			thisObj.btn.css("background", "url('/jikuang/statics/api/images/ui/button_check_mini_normal.png') no-repeat 100% 100%");
		}
	}
    function mouseDown(){
		thisObj.btn.bind("mouseleave",mouseLeave);
		thisObj.changePos = true;
    	//内容偏移更新
		thisObj.img.offset({top:thisObj.img.offset().top+2,left:thisObj.img.offset().left+2});
    	thisObj.btn.offset({top:thisObj.btn.offset().top+2,left:thisObj.btn.offset().left+2});
        //背景图
    	thisObj.btn.css("background", "url('/jikuang/statics/api/images/ui/button_check_mini_press.png') no-repeat 100% 100%");
    }
    function mouseUp(){
		thisObj.btn.unbind("mouseleave",mouseLeave);
		if(thisObj.changePos == true){
			thisObj.changePos = false;
			//内容偏移归位
			thisObj.img.offset({top:thisObj.img.offset().top-2,left:thisObj.img.offset().left-2});
			thisObj.btn.offset({top:thisObj.btn.offset().top-2,left:thisObj.btn.offset().left-2});
			//背景图
			thisObj.btn.css("background", "url('/jikuang/statics/api/images/ui/button_check_mini_normal.png') no-repeat 100% 100%");
		}
	}
	function checkClick(){
		thisObj.setCheck(!thisObj.checkClick);
	}
}
CheckButton.prototype.setCss = function(){
    //设置样式
    var css;
    css = {
        "width": "28px",
        "vertical-align": "middle",
        "cursor": "pointer",
    }
    this.img.css(css);
    css = {
		"width": "28px",
		"height": "28px",
    	"padding": "0px",
    	"cursor": "pointer",
    	"text-align": "center",
    	"vertical-align": "middle",
    	"line-height": "24px",
    	"border": "none",
		"outline": "none",
		"display": "inline-block",
		"background": "url('/jikuang/statics/api/images/ui/button_check_mini_normal.png') no-repeat 100% 100%",
    }
	this.btn.css(css);
    css = {
    	"vertical-align": "middle",
		"cursor": "default",
		"margin-left": "10px",
        "border-radius": "5px",
        "height": "20px",
        "font-size": "14px",
        "line-height": "24px",
        "color": "#666666",
        "background": "transparent",
    }
    this.label.css(css);
	css = {
        "line-height": "24px",
        "vertical-align": "middle",
        "display": "inline-block",
        "cursor": "default",
        "background": "transparent",
        "outline": "none",
        "border": "none",
	}
	this.element.css(css);
}
CheckButton.prototype.setCheck = function(checkFlg){
	this.checkClick = checkFlg;
	if(this.checkClick){
		this.img.attr("src","/jikuang/statics/api/images/ui/check.png");
		this.img.attr('checked',true)
	}else{
		this.img.attr("src","/jikuang/statics/api/images/ui/uncheck.png");
		this.img.attr('checked',false)
	}
}
CheckButton.prototype.getCheck = function(){
	return this.checkClick;
}
CheckButton.prototype.getCheckValue = function(){
	return this.checkValue;
}
CheckButton.prototype.bindEvent = function(eventName,handleFun){ //绑定事件
	this.btn.bind(eventName,handleFun);
}
CheckButton.prototype.unbindEvent = function(eventName,handleFun){ //解除绑定事件
	this.btn.unbind(eventName,handleFun);
}
CheckButton.prototype.setDisable = function(disableFlg){ //设置是否可用
    this.btn.attr("disabled",disableFlg);
    if(disableFlg){
		this.label.css({"color": "#f1f1f1"});
        this.img.attr("src","/jikuang/statics/api/images/ui/uncheck.png");
    }else{
		this.label.css({"color": "#666666"});
        this.btn.attr("src","/jikuang/statics/api/images/ui/uncheck.png");
    }
}
CheckButton.prototype.setVisible = function(displayFlg){ //设置是否显示
    if(displayFlg){
        this.element.show();
    }else{
        this.element.hide();
    }
}