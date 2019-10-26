//单选按钮---------------------------------------------------------------------------------
function RadioButton(targetId,radioValue,disText){
    //绑定元素
    this.element = $(targetId);
	this.element.append("<button></button>");
	this.element.append("<label></label>");
    this.btn = this.element.children("button");
	this.label = this.element.children("label");
    this.btn.append("<img></img>");
    this.img = this.btn.children("img");
	//设置属性
    this.radioValue = radioValue;
    this.disText = disText;

    this.iniRadioButton();
}
RadioButton.prototype.iniRadioButton = function(){
	var thisObj = this;
	this.changePos = false;
	this.radioClick = false;
	//设置样式
	this.setCss();
    //设置显示
	this.btn.attr("radioValue",this.radioValue);
	this.label.html(this.disText);
    //绑定事件
    this.btn.bind("mousedown",mouseDown);
	this.btn.bind("mouseup",mouseUp);
    function mouseLeave(){
		thisObj.btn.unbind("mouseleave",mouseLeave);
		if(thisObj.changePos == true){
			thisObj.changePos = false;
			//内容偏移归位
			thisObj.img.offset({top:thisObj.img.offset().top-2,left:thisObj.img.offset().left-2});
			thisObj.btn.offset({top:thisObj.btn.offset().top-2,left:thisObj.btn.offset().left-2});
			//背景图
			thisObj.btn.css("background", "url('/jikuang/statics/system/images/ui/button_radio_mini_normal.png') no-repeat 100% 100%");
		}
	}
    function mouseDown(){
		thisObj.btn.bind("mouseleave",mouseLeave);
		thisObj.changePos = true;
    	//内容偏移更新
		thisObj.img.offset({top:thisObj.img.offset().top+2,left:thisObj.img.offset().left+2});
    	thisObj.btn.offset({top:thisObj.btn.offset().top+2,left:thisObj.btn.offset().left+2});
        //背景图
    	thisObj.btn.css("background", "url('/jikuang/statics/system/images/ui/button_radio_mini_press.png') no-repeat 100% 100%");
    }
    function mouseUp(){
		thisObj.btn.unbind("mouseleave",mouseLeave);
		if(thisObj.changePos == true){
			thisObj.changePos = false;
			//内容偏移归位
			thisObj.img.offset({top:thisObj.img.offset().top-2,left:thisObj.img.offset().left-2});
			thisObj.btn.offset({top:thisObj.btn.offset().top-2,left:thisObj.btn.offset().left-2});
			//背景图
			thisObj.btn.css("background", "url('/jikuang/statics/system/images/ui/button_radio_mini_normal.png') no-repeat 100% 100%");
		}
	}
}
RadioButton.prototype.setCss = function(){
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
		"background": "url('/jikuang/statics/system/images/ui/button_radio_mini_normal.png') no-repeat 100% 100%",
    }
	this.btn.css(css);
    css = {
        "margin-left": "10px",
        "border-radius": "5px",
        "height": "28px",
        "font-size": "14px",
        "line-height": "28px",
        "vertical-align": "middle",
        "color": "#666666",
        "cursor": "default",
        "background": "transparent",
        "display":"inline-block",
    }
    this.label.css(css);
	css = {
        "line-height": "30px",
        "vertical-align": "middle",
        "display": "inline-block",
        "cursor": "default",
        "background": "transparent",
        "outline": "none",
        "border": "none",
	}
	this.element.css(css);
}
RadioButton.prototype.setRadio = function(radioFlg){
	this.radioClick = radioFlg;
	if(this.radioClick){
		this.img.attr("src","/jikuang/statics/system/images/ui/radio.png");
	}else{
		this.img.attr("src","/jikuang/statics/system/images/ui/unradio.png");
	}
}
RadioButton.prototype.getRadio = function(){
	return this.radioClick;
}
RadioButton.prototype.getRadioValue = function(){
	return this.radioValue;
}
RadioButton.prototype.setDisable = function(disableFlg){ //设置是否可用
    this.btn.attr("disabled",disableFlg);
    if(disableFlg){
		this.label.css({"color": "#f1f1f1"});
        this.img.attr("src","/jikuang/statics/system/images/ui/unradio.png");
    }else{
		this.label.css({"color": "#666666"});
        this.btn.attr("src","/jikuang/statics/system/images/ui/unradio.png");
    }
}
RadioButton.prototype.setVisible = function(displayFlg){ //设置是否显示
    if(displayFlg){
        this.element.show();
    }else{
        this.element.hide();
    }
}
RadioButton.prototype.bindEvent = function(eventName,handleFun){ //绑定事件
	this.btn.bind(eventName,handleFun);
}
RadioButton.prototype.unbindEvent = function(eventName,handleFun){ //解除绑定事件
	this.btn.unbind(eventName,handleFun);
}