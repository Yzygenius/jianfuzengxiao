//TipImage
function TipImage(targetId,tipImg,tipContent){
	//绑定元素
    this.element = $(targetId);
    //
    this.tipImg = tipImg;
    this.tipContent = tipContent;

    this.iniTipImage();
}
TipImage.prototype.iniTipImage = function(){
    var thisObj = this;
    this.element.attr("src",this.tipImg);
    this.element.bind("mouseenter",function(){
        tip = new Tip(thisObj.tipContent);
    });
    this.element.bind("mouseleave",function(){
        tip.closeTip();
    });
    //
    this.setCss();
}
TipImage.prototype.setCss = function(){
    //设置样式
    var css;
    css = {
        "margin-left": "5px",
        "width": "18px",
        "vertical-align": "middle",
        "display": "inline-block",
    }
    this.element.css(css);
}
TipImage.prototype.setImg = function(disImage){
    this.img.attr("src",disImage);
}
TipImage.prototype.setContent = function(disContent){ //设置值
    this.tipContent = disContent;
}
TipImage.prototype.getContent = function(){ //获取值
    return this.tipContent;
}
TipImage.prototype.setVisible = function(displayFlg){ //设置是否显示
    if(displayFlg){
        this.element.show();
    }else{
        this.element.hide();
    }
}