//按钮---------------------------------------------------------------------------------
SelectButton.TypeImportant = "important"; //蓝色
SelectButton.TypeYellow = "yellow"; //黄色
SelectButton.TypeGreen = "green"; //绿色
SelectButton.TypeRed = "red"; //红色
SelectButton.SizeShort = {width:80,height:40}; //80X40
SelectButton.SizeMiddle = {width:170,height:40}; //150X40
SelectButton.SizeLong = {width:200,height:40}; //180X40
function SelectButton(targetId,disImage,disText,typeFlg,sizeFlg,documentFlg){
	if(documentFlg==null || documentFlg==undefined){
		documentFlg = document;
	}
    //绑定元素
    this.element = $(targetId,documentFlg);
    this.element.append("<button></button>");
	this.btn = this.element.children("button");
	this.btn.append("<div></div>");
	this.btnContent = this.btn.children("div");
    this.btnContent.append("<img></img>");
    this.btnContent.append("<text></text>");
    this.img = this.btnContent.children("img");
	this.text = this.btnContent.children("text");
	//设置属性
    this.type = typeFlg;
    this.size = sizeFlg;
    this.disImage = disImage;
    this.disText = disText;

    this.iniSelectButton();
}
SelectButton.prototype.iniSelectButton = function(){
	var thisObj = this;
	this.changePos = false;
	this.btn.attr("sel","false");
	//设置样式
	this.setCss();
    //设置显示
    if(this.disImage!=null && this.disImage!=undefined && this.disImage!=""){
        this.setImg(this.disImage);
        if(this.disText==""){
            this.text.remove();
        }else{
            this.text.text("  "+this.disText);
        }
    }else{
    	this.img.remove();
    	this.text.text(this.disText);
    }
    //绑定事件
    this.btn.bind("mousedown",mouseDown);
	this.btn.bind("mouseup",mouseUp);
    function mouseLeave(){
		thisObj.btn.unbind("mouseleave",mouseLeave);
		if(thisObj.changePos == true){
			thisObj.changePos = false;
			//内容偏移归位
			thisObj.btn.offset({top:thisObj.btn.offset().top-2,left:thisObj.btn.offset().left-2});
			thisObj.btn.css("box-shadow", "1px 1px 2px #cccccc");
		}
	}
    function mouseDown(){
		thisObj.btn.bind("mouseleave",mouseLeave);
		thisObj.changePos = true;
    	//内容偏移更新
		thisObj.btn.offset({top:thisObj.btn.offset().top+2,left:thisObj.btn.offset().left+2});
		thisObj.btn.css("box-shadow", "none");
    }
    function mouseUp(){
		thisObj.btn.unbind("mouseleave",mouseLeave);
		if(thisObj.changePos == true){
			thisObj.changePos = false;
			//内容偏移归位
			thisObj.btn.offset({top:thisObj.btn.offset().top-2,left:thisObj.btn.offset().left-2});
			thisObj.btn.css("box-shadow", "1px 1px 2px #cccccc");
		}
    }
}
SelectButton.prototype.setCss = function(){
	var linheight;
	var marginLeft;
	var width,height;
	if(this.disImage!=null && this.disImage!=undefined && this.disImage!=""){
        marginLeft = 5;
    }else{
    	marginLeft = 0;
    }
	width = this.size.width;
	height = this.size.height;
	//设置样式
    var css;
    css = {
        "width": "26px",
        "vertical-align": "middle",
        "cursor": "pointer",
    }
    this.img.css(css);
    css = {
		"margin-left": marginLeft + "px",
        "font-size": "14px",
        "cursor": "pointer",
        //"line-height": linheight,
    	"border": "none",
        "outline": "none",
        "background": "transparent",
        "vertical-align": "middle",
    }
	this.text.css(css);
	css = {
		"margin": "2px",
		"width": width + "px",
		"height": height + "px",
		"line-height": height + "px",
    	"cursor": "pointer",
    	"text-align": "center",
    	"vertical-align": "middle",
    	"border": "1px solid #5fd7f3",
		"border-radius": "6px",
		"color": "#666666",
		"background": "transparent",
    }
	this.btnContent.css(css);
    css = {
    	"padding": "0",
		"width": width + 8 + "px",
		"height": height + 8 + "px",
    	"cursor": "pointer",
    	"text-align": "center",
    	"vertical-align": "middle",
    	"line-height": linheight + 4 + "px",
    	"border": "1px solid #cccccc",
    	"outline": "none",
		"border-radius": "6px",
		"background": "#22b8de",
		"box-shadow": "1px 1px 2px #cccccc",
    }
	this.btn.css(css);
}
SelectButton.prototype.setSelect = function(selectFlg){
	this.btn.attr("sel",selectFlg);
	
	if(selectFlg){
		var color;
		var background;
		var borderColor;
		var innerBorderColor;
		switch(this.type){
			case(SelectButton.TypeImportant):{
				color = "#ffffff";
				background = "#22b8de";
				borderColor = "#5fd7f3"
				innerBorderColor = "#5fd7f3";
				break;
			}
			case(SelectButton.TypeYellow):{
				color = "#ffffff";
				background = "#22b8de";
				innerBorderColor = "#ffffff";
				break;
			}
			case(SelectButton.TypeGreen):{
				color = "#ffffff";
				background = "#22b8de";
				innerBorderColor = "#ffffff";
				break;
			}
			case(SelectButton.TypeRed):{
				color = "#ffffff";
				background = "#22b8de";
				innerBorderColor = "#ffffff";
				break;
			}
		}
		//颜色更新
		this.btn.css("color", color);
		this.btn.css("background", background);
		this.btn.css("border-color", borderColor);
		this.btnContent.css("color", color);
		this.btnContent.css("background", background);
		this.btnContent.css("border-color", innerBorderColor);
		this.setImg(SysFunctions.getTarImg(this.disImage,"w"));
	}else{
		//颜色复位
		this.btn.css("color", "#666666");
		this.btn.css("background", "#f1f1f1");
		this.btn.css("border-color", "#cccccc");
		this.btnContent.css("color", "#666666");
		this.btnContent.css("background", "#f1f1f1");
		this.btnContent.css("border-color", "#dddddd");
		this.setImg(SysFunctions.getTarImg(this.disImage,"g"));
	}
}
SelectButton.prototype.getSelect = function(){
	return this.btn.attr("sel");
}
SelectButton.prototype.bindEvent = function(eventName,handleFun){ //绑定事件
	this.btn.bind(eventName,handleFun);
}
SelectButton.prototype.unbindEvent = function(eventName,handleFun){ //解除绑定事件
	this.btn.unbind(eventName,handleFun);
}
SelectButton.prototype.setImg = function(disImage){ //设置是否显示
    this.img.attr("src",disImage);
}