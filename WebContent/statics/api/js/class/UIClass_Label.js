//显示Label
Label.DisTypeLong = "DisTypeLong";
Label.DisTypeMiddle = "DisTypeMiddle";
Label.DisTypeShort = "DisTypeShort";
Label.DisTypeMini = "DisTypeMini";

Label.DisTypeTable = "DisTypeTable";

function Label(targetId,disType,disImage,disContent,disBorder,documentFlg){
    if(documentFlg==null || documentFlg==undefined){
		documentFlg = document;
	}
	//绑定元素
    this.element = $(targetId,documentFlg);
    //this.element.append("<img></img>");
    this.element.append("<label></lebel>");
    //this.img = this.element.children("img");
    this.label = this.element.children("label");
    //设置属性
    this.disType = disType;
    //this.disImage = disImage;
    this.disContent = disContent;
    this.disBorder = disBorder;

    this.iniLabel();
}
Label.prototype.iniLabel = function(){
    /*if(this.disImage == "" || this.disImage == null || this.disImage == undefined){
    	this.img.remove();
    }else{
        this.setImg(this.disImage);
    }*/
    if(this.disContent == "" || this.disContent == null || this.disContent == undefined){
    	this.setContent("");
    }else{
        this.setContent(this.disContent);
    }
    //
    this.setCss();
}
Label.prototype.setCss = function(){
    var elementWidth;
    var editWidth;
    var border;
    switch(this.disType){
        case(Label.DisTypeLong):{
            elementWidth = 380;
            break;
        }
        case(Label.DisTypeMiddle):{
            elementWidth = 280;
            break;
        }
        case(Label.DisTypeShort):{
            elementWidth = 180;
            break;
        }
        case(Label.DisTypeMini):{
            elementWidth = 100;
            break;
        }
    }
    /*if(this.img.attr("src")=="" || this.img.attr("src")==null || this.img.attr("src")==undefined){
    	editWidth = 25;
    }else{
    	editWidth = 50;
    }*/
    if(this.disBorder || this.disBorder == null || this.disBorder == undefined){
        border = "2px solid #f1f1f1";
    }else{
        border = "none";
    }
    //设置样式
    var css;
    if(this.disType == Label.DisTypeTable){
    	css = {
	        "width": "100%",
	        "height": "40px",
	        "vertical-align": "middle",
	        "line-height": "40px",
	        "border": "1px solid #a9a9a9",
	        //"border-radius": "6px",
	        //"box-shadow": "1px 1px 2px #cccccc",
	        "background": "#ffffff",
	    }
        this.element.css(css);
    }else{
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
    }
    css = {
        "margin-left": "10px",
        "width": "26px",
        "height": "26px",
        "display": "inline-block",
        "vertical-align": "middle",
    }
    //this.img.css(css);
    css = {
        "margin-left": "10px",
        "color": "#666666",
        "width": (elementWidth - editWidth) + "px",
        "height": "30px",
        "line-height": "30px",
        "vertical-align": "middle",
        "background-color": "transparent",
    }
    this.label.css(css);
}
/*Label.prototype.setImg = function(disImage){
    this.img.attr("src",disImage);
}*/
Label.prototype.setContent = function(disContent){ //设置值
    this.label.html(disContent);
}
Label.prototype.getContent = function(){ //获取值
    return this.label.text();
}
Label.prototype.setVisible = function(displayFlg){ //设置是否显示
    if(displayFlg){
        this.element.show();
    }else{
        this.element.hide();
    }
}