//按钮---------------------------------------------------------------------------------
Button.TypeNormal = "normal"; //白色
Button.TypeImportant = "important"; //蓝色
Button.TypeYellow = "yellow"; //黄色
Button.TypeGreen = "green"; //绿色
Button.TypeRed = "red"; //红色
Button.SizeMini = {width: 24,height: 24,imgWidth: 16,lineheight:24,size: "mini"}; //24X24
Button.SizeSmall = {width: 30,height: 30,imgWidth: 20,lineheight:30,size: "small"}; //34X34
Button.SizeShort = {width: 40,height: 40,imgWidth: 26,lineheight:40,size: "short"}; //40X40
Button.SizeMiddle = {width: 80,height: 40,imgWidth: 26,lineheight:40,size: "middle"}; //40X80
Button.SizeLong = {width: 120,height: 40,imgWidth: 26,lineheight:40,size: "long"}; //40X120
Button.SizeBig = {width: 80,height: 80,imgWidth: 44,lineheight:80,size: "big"}; //80X80
function Button(targetId,disImage,disText,typeFlg,sizeFlg,documentFlg){
	if(documentFlg==null || documentFlg==undefined){
		documentFlg = document;
	}
    //绑定元素
    this.element = $(targetId,documentFlg);
	this.element.append("<div></div>");
	this.element.append("<button></button>");
    this.btn = this.element.children("button");
    this.btn.append("<img></img>");
    this.btn.append("<label></label>");
    this.img = this.btn.children("img");
	this.label = this.btn.children("label");
	//设置属性
	this.type = typeFlg;
	this.size = sizeFlg;
    this.disImage = disImage;
    this.disText = disText;

    this.iniButton();
}
Button.prototype.iniButton = function(){
	var thisObj = this;
	this.changePos = false;
	//设置样式
	this.setCss();
    //设置显示
    if(this.disImage!=null && this.disImage!=undefined && this.disImage!=""){
        this.setImg(this.disImage);
        if(this.disText==""){
            this.label.remove();
        }else{
            this.label.html("  "+this.disText);
        }
    }else{
    	this.img.remove();
    	this.label.html(this.disText);
    }
    //绑定事件
    this.btn.bind("mousedown",mouseDown);
	this.btn.bind("mouseup",mouseUp);
    function mouseLeave(){
		thisObj.btn.unbind("mouseleave",mouseLeave);
		if(thisObj.changePos == true){
			thisObj.changePos = false;
			//内容偏移归位
			if(thisObj.disImage!=null && thisObj.disImage!=""){
				thisObj.img.offset({top:thisObj.img.offset().top-2,left:thisObj.img.offset().left-2});
			}
			thisObj.label.offset({top:thisObj.label.offset().top-2,left:thisObj.label.offset().left-2});
			//背景图
			thisObj.btn.css("background", "url('/jikuang/statics/system/images/ui/button_"+thisObj.type+"_"+thisObj.size.size+"_"+"normal.png') no-repeat 100% 100%");
		}
	}
    function mouseDown(){
		thisObj.btn.bind("mouseleave",mouseLeave);
		thisObj.changePos = true;
    	//内容偏移更新
    	if(thisObj.disImage!=null && thisObj.disImage!=""){
    		thisObj.img.offset({top:thisObj.img.offset().top+2,left:thisObj.img.offset().left+2});
    	}
    	thisObj.label.offset({top:thisObj.label.offset().top+2,left:thisObj.label.offset().left+2});
        //背景图
    	thisObj.btn.css("background", "url('/jikuang/statics/system/images/ui/button_"+thisObj.type+"_"+thisObj.size.size+"_"+"press.png') no-repeat 100% 100%");
    }
    function mouseUp(){
		thisObj.btn.unbind("mouseleave",mouseLeave);
		if(thisObj.changePos == true){
			thisObj.changePos = false;
			//内容偏移归位
			if(thisObj.disImage!=null && thisObj.disImage!=""){
				thisObj.img.offset({top:thisObj.img.offset().top-2,left:thisObj.img.offset().left-2});
			}
			thisObj.label.offset({top:thisObj.label.offset().top-2,left:thisObj.label.offset().left-2});
			//背景图
			thisObj.btn.css("background", "url('/jikuang/statics/system/images/ui/button_"+thisObj.type+"_"+thisObj.size.size+"_"+"normal.png') no-repeat 100% 100%");
		}
    }
}
Button.prototype.setCss = function(){
	var marginLeft;
	var width = this.size.width+4;
	var height = this.size.height+4;
	var imgWidth = this.size.imgWidth;
	var lineheight = this.size.lineheight;
	if(this.disImage!=null && this.disImage!=undefined && this.disImage!=""){
        marginLeft = 5;
    }else{
    	marginLeft = 0;
    }
    //设置样式
    var css;
    switch(this.type){
		case(Button.TypeNormal):
			this.color = "#666666";
	        break;
		case(Button.TypeImportant):
		this.color = "#ffffff";
	        break;
		case(Button.TypeYellow):
		this.color = "#ffffff";
			break;
		case(Button.TypeGreen):
		this.color = "#ffffff";
			break;
		case(Button.TypeRed):
		this.color = "#ffffff";
			break;
	}
    css = {
        "width": imgWidth + "px",
        "vertical-align": "middle",
        "cursor": "pointer",
    }
    this.img.css(css);
    css = {
		"margin-left": marginLeft + "px",
        "font-size": "14px",
        "cursor": "pointer",
        "line-height": lineheight + "px",
    	"border": "none",
        "outline": "none",
        "background": "transparent",
    }
    this.label.css(css);
    css = {
		"width": width + "px",
		"height": height + "px",
    	"padding": "0px",
    	"cursor": "pointer",
    	"text-align": "center",
    	"vertical-align": "middle",
    	"line-height": lineheight + "px",
    	"border": "none",
		"outline": "none",
		"color": this.color,
    	"background": "url('/jikuang/statics/system/images/ui/button_"+this.type+"_"+this.size.size+"_"+"normal.png') no-repeat 100% 100%",
    }
	this.btn.css(css);
	css = {
		"width": this.btn.outerWidth() + "px",
		"height": this.btn.outerHeight() + "px",
	}
	this.element.css(css);
}
Button.prototype.bindEvent = function(eventName,handleFun){ //绑定事件
	this.btn.bind(eventName,handleFun);
}
Button.prototype.unbindEvent = function(eventName,handleFun){ //解除绑定事件
	this.btn.unbind(eventName,handleFun);
}
Button.prototype.setDisable = function(disableFlg){ //设置是否可用
    this.btn.attr("disabled",disableFlg);
    if(disableFlg){
		this.btn.css({"color":"#ffffff"});
        this.btn.css({"background": "url('/jikuang/statics/system/images/ui/button_disable_"+this.size.size+".png') no-repeat 100% 100%"});
    }else{
		this.btn.css({"color":this.color});
        this.btn.css({"background": "url('/jikuang/statics/system/images/ui/button_"+this.type+"_"+this.size.size+"_"+"normal.png') no-repeat 100% 100%"});
    }
}
Button.prototype.setVisible = function(displayFlg){ //设置是否显示
    if(displayFlg){
        this.element.show();
    }else{
        this.element.hide();
    }
}
Button.prototype.setImg = function(disImage){ //设置是否显示
    this.img.attr("src",disImage);
}
Button.prototype.setText = function(text){ //设置显示文字
    this.label.html(text);
}