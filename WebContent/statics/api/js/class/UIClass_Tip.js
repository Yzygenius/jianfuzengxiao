//显示Tip
function Tip(content){
    //
    $(document.body).append("<div id='tip' class='Tip'></div>");
    this.element = $("#tip");
    this.element.append("<div id='bodyDiv'></div>");
    this.bodyDiv = this.element.children("#bodyDiv");
    this.bodyDiv.append("<div id='bodyContent'></div>");
    this.bodyContent = this.bodyDiv.children("#bodyContent");
    //设置属性
    this.content = content;

    this.iniTip();
}
Tip.prototype.iniTip = function(){
    var thisObj = this;
    //
    this.setCss();

    this.setContent(this.content);

    $(document).on('mousemove',function(event){
        thisObj.setVisible(true);
        thisObj.setPosition({x:event.clientX,y:event.clientY});
    });
}
Tip.prototype.setCss = function(){
    //设置样式
    var css;
    css = {
        "max-width": "180px",
        "border": "2px solid #f1f1f1",
        "border-radius": "6px",
        "background": "#ffffff",
        "box-shadow": "1px 1px 2px #cccccc",
        "z-index": "100",
        "position": "absolute",
        "display": "none",
    }
    this.element.css(css);
    css = {
        "margin": "10px",
        "color": "#666666",
        "line-height": "20px",
    }
    this.bodyDiv.css(css);
}
Tip.prototype.setContent = function(disContent){ //设置值
    if(disContent == "" || disContent == null || disContent == undefined){
    	this.bodyContent.html("");
    }else{
        this.bodyContent.html(disContent);
    }
}
Tip.prototype.setPosition = function(positionFlg){ //设置位置
    if(positionFlg == "" || positionFlg == null || positionFlg == undefined){
        this.element.css({"display": "none"});
    }else{
        var xFlg = positionFlg.x;
        var yFlg = positionFlg.y;
        var bodyWidth = $(document.body).outerWidth();
        var bodyHeight = $(document.body).outerHeight();
        var thisWidth = this.element.outerWidth();
        var thisHeight = this.element.outerHeight();
        var offX = 0;
        var offY = 0;
        if(xFlg + thisWidth + 20 > bodyWidth){ //20是留出的与鼠标间距
            xFlg = xFlg - thisWidth;
            offX = -20;
        }else{
            offX = 20;
        }
        if(yFlg + thisHeight + 20 > bodyHeight){ //20是留出的与鼠标间距
            yFlg = yFlg - thisHeight;
            offY = -20;
        }else{
            offY = 20;
        }
        this.element.css({
            "left": xFlg + offX,
            "top": yFlg + offY,
        });
        this.element.show();
    }
}
Tip.prototype.setVisible = function(visibleFlg){ //设置显示
    if(visibleFlg){
        this.element.show();
    }else{
        this.element.hide();
    }
}
Tip.prototype.closeTip = function(){ //关闭
    this.element.remove();
}
Tip.closeAllTip = function(){ //关闭全部
    var tipInfoList = $(document.body).find(".Tip");
    for(var i=tipInfoList.length-1; i>=0; i--){ //从最后往前删除
        tipInfoList.eq(i).remove();
    }
}