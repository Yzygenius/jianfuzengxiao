//显示TipInfo
function TipInfo(titleImg,titleText,content,bottomImg,bottomText){
    //
    $(document.body).append("<div id='tipInfo' class='TipInfo'></div>");
    this.element = $("#tipInfo");
    this.element.append("<div id='headDiv'></div>");
    this.element.append("<div id='bodyDiv'></div>");
    this.element.append("<div id='bottomDiv'></div>");
    this.headDiv = this.element.children("#headDiv");
    this.bodyDiv = this.element.children("#bodyDiv");
    this.bottomDiv = this.element.children("#bottomDiv");
    this.headDiv.append("<div id = 'title_LB'></div>");
    this.titleLB = this.headDiv.children("#title_LB");
    this.title_LB = new Label("#title_LB", Label.DisTypeMiddle, titleImg, titleText,false);
    this.bodyDiv.append("<div id='bodyContent'></div>");
    this.bodyContent = this.bodyDiv.children("#bodyContent");
    this.bottomDiv.append("<div id = 'bottom_LB'></div>");
    this.bottomLB = this.bottomDiv.children("#bottom_LB");
    this.bottom_LB = new Label("#bottom_LB", Label.DisTypeMiddle, bottomImg, bottomText,false);
    //设置属性
    this.titleImg = titleImg;
    this.titleText = titleText;
    this.content = content;
    this.bottomImg = bottomImg;
    this.bottomText = bottomText;

    this.iniTipInfo();
}
TipInfo.prototype.iniTipInfo = function(){
    var thisObj = this;
    //
    this.setCss();

    this.setContent(this.content);

    $(document).on('mousemove',function(event){
        thisObj.setVisible(true);
        thisObj.setPosition({x:event.clientX,y:event.clientY});
    });
}
TipInfo.prototype.setCss = function(){
    //设置样式
    var css;
    css = {
        "width": "300px",
        "border": "2px solid #f1f1f1",
        "border-radius": "6px",
        "background": "#ffffff",
        "box-shadow": "1px 1px 2px #cccccc",
        "z-index": "200",
        "position": "absolute",
        "display": "none",
    }
    this.element.css(css);
    css = {
        "magin-left": "10px",
        "width": "100%",
        "height": "40px",
        "line-height": "40px",
        "background": "#f1f1f1",
        "border-radius": "6px 6px 0 0",
    }
    this.headDiv.css(css);
    css = {
        "font-weight": "bold",
        "font-size": "16px",
        "color": "#333333",
    }
    this.titleLB.css(css);
    css = {
        "margin": "10px",
        "width": "100%",
        "color": "#666666",
        "line-height": "20px",
    }
    this.bodyDiv.css(css);
    css = {
        "width": "100%",
        "height": "40px",
        "line-height": "40px",
        "border-radius": "0 0 6px 6px",
        "background": "#f1f1f1",
    }
    this.bottomDiv.css(css);
    css = {
        "font-weight": "bold",
        "text-align": "right",
    }
    this.bottomLB.css(css);
}
TipInfo.prototype.setContent = function(disContent){ //设置值
    if(disContent == "" || disContent == null || disContent == undefined){
    	this.bodyContent.html("");
    }else{
        this.bodyContent.html(disContent);
    }
}
TipInfo.prototype.setPosition = function(positionFlg){ //设置位置
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
TipInfo.prototype.setVisible = function(visibleFlg){ //设置显示
    if(visibleFlg){
        this.element.show();
    }else{
        this.element.hide();
    }
}
TipInfo.prototype.closeTipInfo = function(){ //关闭
    this.element.remove();
}
TipInfo.closeAllTipInfo = function(){ //关闭全部
    var tipInfoList = $(document.body).find(".TipInfo");
    for(var i=tipInfoList.length-1; i>=0; i--){ //从最后往前删除
        tipInfoList.eq(i).remove();
    }
}