//DeleteLabel
DeleteLabel.DisTypeLong = "DisTypeLong";
DeleteLabel.DisTypeMiddle = "DisTypeMiddle";
DeleteLabel.DisTypeShort = "DisTypeShort";
DeleteLabel.DisTypeMini = "DisTypeMini";

function DeleteLabel(targetId,disType,disImage,disContent,disBorder,documentFlg){
    if(documentFlg==null || documentFlg==undefined){
		documentFlg = document;
	}
	//绑定元素
    this.element = $(targetId,documentFlg);
    this.element.append("<img></img>");
    this.element.append("<label></lebel>");
    this.element.append("<button></button>");
    this.img = this.element.children("img");
    this.label = this.element.children("label");
    this.btn = this.element.children("button");
    //设置属性
    this.disType = disType;
    this.disImage = disImage;
    this.disContent = disContent;
    this.disBorder = disBorder;

    this.iniDeleteLabel();
}
DeleteLabel.prototype.iniDeleteLabel = function(){
    var thisObj = this;
    if(this.disImage == "" || this.disImage == null || this.disImage == undefined){
    	this.img.remove();
    }else{
        this.setImg(this.disImage);
    }
    if(this.disContent == "" || this.disContent == null || this.disContent == undefined){
    	this.setContent("");
    }else{
        this.setContent(this.disContent);
    }
    
    //绑定事件
    this.element.bind("mouseenter",mouseEnter); //
    this.element.bind("mouseleave",mouseLeave); //
    this.btn.bind("click",deleteLabel);
    function mouseEnter(){
        thisObj.btn.show();
    }
    function mouseLeave(){
        thisObj.btn.hide();
    }
    function deleteLabel(){
        thisObj.element.remove();
    }
    //
    this.setCss();
}
DeleteLabel.prototype.setCss = function(){
    var elementWidth;
    var editWidth;
    var border;
    switch(this.disType){
        case(DeleteLabel.DisTypeLong):{
            elementWidth = 380;
            break;
        }
        case(DeleteLabel.DisTypeMiddle):{
            elementWidth = 280;
            break;
        }
        case(DeleteLabel.DisTypeShort):{
            elementWidth = 180;
            break;
        }
        case(DeleteLabel.DisTypeMini):{
            elementWidth = 100;
            break;
        }
    }
    console.log(this.img.attr("src"));
    if(this.img.attr("src")=="" || this.img.attr("src")==null || this.img.attr("src")==undefined){
    	editWidth = 45;
    }else{
    	editWidth = 80;
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
        "height": "40px",
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
        "display": "inline-block",
        "vertical-align": "middle",
    }
    this.img.css(css);
    css = {
        "margin-left": "10px",
        "color": "#666666",
        "width": (elementWidth - editWidth) + "px",
        "height": "30px",
        "line-height": "30px",
        "vertical-align": "middle",
        "background-color": "transparent",
        "display": "inline-block",
    }
    this.label.css(css);
    css = {
        "margin-right": "5px",
        "width": "20px",
        "height": "20px",
        "border": "none",
        "outline": "none",
        "display": "none",
        "vertical-align": "middle",
        "background": "url('/dazong/statics/manager/image/ui/button_text_clear.png') no-repeat 100% 100%",
    }
    this.btn.css(css);
}
DeleteLabel.prototype.setImg = function(disImage){
    this.img.attr("src",disImage);
}
DeleteLabel.prototype.setContent = function(disContent){ //设置值
    this.label.html(disContent);
}
DeleteLabel.prototype.getContent = function(){ //获取值
    return this.label.text();
}
DeleteLabel.prototype.setVisible = function(displayFlg){ //设置是否显示
    if(displayFlg){
        this.element.show();
    }else{
        this.element.hide();
    }
}