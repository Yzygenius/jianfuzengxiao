//输入区域
TextArea.DisTypeLong = "DisTypeLong";
TextArea.DisTypeMiddle = "DisTypeMiddle";
TextArea.DisTypeShort = "DisTypeShort";

function TextArea(targetId,disType){
	//绑定元素
    this.element = $(targetId);
    this.element.append("<textarea></textarea>");
    this.textarea = this.element.children("textarea");
    //设置属性
    this.targetId = targetId;
    this.disType = disType;

    this.iniTextArea();
}
TextArea.prototype.iniTextArea = function(){
    var thisObj = this;
    //
    this.setCss();

    this.textarea.bind("focus",focusText);
    this.textarea.bind("blur",blurText);

    //鼠标事件
    function focusText(){
        thisObj.setFocusCss();
    }
    function blurText(){
        thisObj.setBlurCss();
    }
}
TextArea.prototype.setCss = function(){
    var elementWidth;
    switch(this.disType){
        case(TextArea.DisTypeLong):{
            elementWidth = 380;
            break;
        }
        case(TextArea.DisTypeMiddle):{
            elementWidth = 280;
            break;
        }
        case(TextArea.DisTypeShort):{
            elementWidth = 180;
            break;
        }
    }
    //设置样式
    var css;
    css = {
        "width": elementWidth + "px",
        "height": "80px",
        "vertical-align": "middle",
        "line-height": "80px",
        "border": "2px solid #f1f1f1",
        "border-radius": "6px",
        "background": "#ffffff",
    }
    this.element.css(css);
    css = {
        "margin": "5px 10px",
        "color": "#666666",
        "width": (elementWidth-20)+"px",
        "height": "70px",
        "line-height": "20px",
        "border": "none",
        "outline": "none",
        "resize": "none",
        "display": "inline-block",
        "vertical-align": "middle",
        "background-color": "transparent",
    }
    this.textarea.css(css);
}
TextArea.prototype.setFocusCss = function(){
    var css;
    css = {
        "box-shadow": "0px 0px 5px #22b8de",
    }
    this.element.css(css);
}
TextArea.prototype.setBlurCss = function(){
    var css;
    css = {
        "box-shadow": "none",
    }
    this.element.css(css);
}
TextArea.prototype.setText = function(textStr){ //设置值
    this.textarea.val(textStr);
}
TextArea.prototype.getText = function(){ //获取值
    return this.textarea.val().trim();
}
TextArea.prototype.setDisable = function(disabelFlg){
    this.textarea.attr("disabled",disabelFlg)
}
TextArea.prototype.setVisible = function(displayFlg){ //设置是否显示
    if(displayFlg){
        this.element.show();
    }else{
        this.element.hide();
    }
}
TextArea.prototype.setFocus = function(){ //设置焦點
    this.textarea.focus();
}