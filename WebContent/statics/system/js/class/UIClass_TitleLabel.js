//显示Label
TitleLabel.DisTypeLong = "DisTypeLong";
TitleLabel.DisTypeMiddle = "DisTypeMiddle";
TitleLabel.DisTypeShort = "DisTypeShort";
TitleLabel.DisTypeMini = "DisTypeMini";

function TitleLabel(targetId,disType,disImage,disTitle,disContent,disBorder,documentFlg){
    if(documentFlg==null || documentFlg==undefined){
		documentFlg = document;
	}
	//绑定元素
    this.element = $(targetId,documentFlg);
    this.element.append("<img></img>");
    this.element.append("<div></div>");
    this.img = this.element.children("img");
    this.body = this.element.children("div");
    this.body.append("<label id='title'></lebel>");
    this.body.append("<label id='content'></lebel>");
    this.title = this.body.children("#title");
    this.content = this.body.children("#content");
    //设置属性
    this.disType = disType;
    this.disImage = disImage;
    this.disTitle = disTitle;
    this.disContent = disContent;
    this.disBorder = disBorder;

    this.iniLabel();
}
TitleLabel.prototype.iniLabel = function(){
    if(this.disImage == "" || this.disImage == null || this.disImage == undefined){
    	this.img.remove();
    }else{
        this.setImg(this.disImage);
    }
    if(this.disTitle == "" || this.disTitle == null || this.disTitle == undefined){
    	this.setTitle("");
    }else{
        this.setTitle(this.disTitle);
    }
    if(this.disContent == "" || this.disContent == null || this.disContent == undefined){
    	this.setContent("");
    }else{
        this.setContent(this.disContent);
    }
    //
    this.setCss();
}
TitleLabel.prototype.setCss = function(){
    var elementWidth;
    var editWidth;
    var border;
    switch(this.disType){
        case(TitleLabel.DisTypeLong):{
            elementWidth = 380;
            break;
        }
        case(TitleLabel.DisTypeMiddle):{
            elementWidth = 280;
            break;
        }
        case(TitleLabel.DisTypeShort):{
            elementWidth = 180;
            break;
        }
        case(TitleLabel.DisTypeMini):{
            elementWidth = 100;
            break;
        }
    }
    if(this.img.attr("src")=="" || this.img.attr("src")==null || this.img.attr("src")==undefined){
    	editWidth = 25;
    }else{
    	editWidth = 50;
    }
    if(this.disBorder || this.disBorder == null || this.disBorder == undefined){
        border = "2px solid #f1f1f1";
    }else{
        border = "none";
    }
    //设置样式
    var css;
    css = {
        "width": elementWidth + "px",
        //"height": "40px",
        "vertical-align": "middle",
        "line-height": "40px",
        "border": border,
        "border-radius": "6px",
        "background": "#transparent",
    }
    this.element.css(css);
    css = {
        "margin-left": "10px",
        "width": "26px",
        "height": "26px",
        "line-height": "40px",
        "display": "inline-block",
        "vertical-align": "middle",
    }
    this.img.css(css);
    css = {
        "width": (elementWidth - editWidth) + "px",
        "margin-left": "10px",
        "line-height": "40px",
        "display": "inline-block",
        "vertical-align": "middle",
    }
    this.body.css(css);
    css = {
        "margin-top": "4px",
        "color": "#333333",
        "font-weight": "bold",
        "height": "16px",
        "line-height": "16px",
        "background-color": "transparent",
        "display": "block",
    }
    this.title.css(css);
    css = {
    	"width": "180px",
    	
        "color": "#666666",
        //"height": "16px",
        "line-height": "16px",
        "background-color": "transparent",
        "display": "block",
    }
    this.content.css(css);
}
TitleLabel.prototype.setImg = function(disImage){
    this.img.attr("src",disImage);
}
TitleLabel.prototype.setTitle = function(disTitle){ //设置值
    this.title.html(disTitle);
}
TitleLabel.prototype.setContent = function(disContent){ //设置值
    this.content.html(disContent);
}
TitleLabel.prototype.getContent = function(){ //获取值
    return this.content.text();
}
TitleLabel.prototype.setVisible = function(displayFlg){ //设置是否显示
    if(displayFlg){
        this.element.show();
    }else{
        this.element.hide();
    }
}