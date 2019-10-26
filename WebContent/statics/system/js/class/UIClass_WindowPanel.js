//弹窗---------------------------------------------------------------------------------
WindowPanel.ZIndexNum = 999;

WindowPanel.TypeAlert = "TypeAlert";
WindowPanel.TypeConfirm = "TypeConfirm";
WindowPanel.TypeDialog = "TypeDialog";
WindowPanel.TypePage = "TypePage";
WindowPanel.TypeImage = "TypeImage";

WindowPanel.TypeLoading = "TypeLoading";

WindowPanel.TypeAlertOk = "TypeAlertOk";
WindowPanel.TypeAlertWarning = "TypeAlertWarning";
WindowPanel.TypeAlertError = "TypeAlertError";
WindowPanel.TypeConfirmAsk = "TypeConfirmAsk";
function WindowPanel(tarDocument){
    this.tarDocument = tarDocument;
    if(this.tarDocument=="" || this.tarDocument==null || this.tarDocument==undefined){
        this.tarDocument = top.document;
    }
    //
    this.randomId = Math.floor(Math.random()*100000 + 1);
    $(this.tarDocument.body).find('.windowPanel #maskDiv').hide();
    $(this.tarDocument.body).append("<div id='windowPanel"+this.randomId+"' class='windowPanel'></div>");
    this.element = $("#windowPanel"+this.randomId,this.tarDocument);
    this.element.append("<div id='maskDiv'></div>");
    this.element.append("<div id='panelDiv'></div>");
    this.maskDiv = this.element.children("#maskDiv");
    this.panelDiv = this.element.children("#panelDiv");
    this.panelDiv.append("<div id='panelHead'></div>");
    this.panelDiv.append("<div id='panelBody'></div>");
    this.panelDiv.append("<div id='panelBottom'></div>");
    this.panelHead = this.panelDiv.children("#panelHead");
    this.panelBody = this.panelDiv.children("#panelBody");
    this.panelBottom = this.panelDiv.children("#panelBottom");
    this.panelHead.append("<div id='title'></div>");
    this.panelHead.append("<div id='close_Btn'></div>");
    this.panelBody.append("<div id='content'></div>");
    this.title = this.panelHead.children("#title");
    this.close = this.panelHead.children("#close_Btn");
    this.close_Btn = new Button("#windowPanel"+this.randomId+" #close_Btn",ImageIcon.Cha_W,"",Button.TypeRed,Button.SizeSmall,this.tarDocument);
    this.content = this.panelBody.children("#content");
    //
    this.iniWindowPanel();
}
WindowPanel.prototype.iniWindowPanel = function(){
    var thisObj = this;
    this.setCss();

    switch(this.type){
        case(WindowPanel.TypeAlert):{
            
            break;
        }
        case(WindowPanel.TypeConfirm):{
            
            break;
        }
        case(WindowPanel.TypeDialog):{
            break;
        }
    }

    this.close_Btn.bindEvent("click",function(){
        thisObj.closeWindow();
    });
}
WindowPanel.prototype.setCss = function(){
    var css;
    css = {
        "top": "0px",
        "width": "100%",
        "height": "100%",
        "position": "absolute",
        "z-index": WindowPanel.ZIndexNum,
    }
    this.element.css(css);
    css = {
        "top": "0px",
        "width": "100%",
        "height": "100%",
        "background": "#000000",
        "opacity": "0.6",
        "position": "absolute",
    }
    this.maskDiv.css(css);
    css = {
        "background": "#d3f1f8",
        "border": "1px solid #f1f1f1",
        "box-shadow": "1px 1px 2px #cccccc",
        "position": "absolute",
        "border-radius": "6px",
        "display": "none",
    }
    this.panelDiv.css(css);
    css = {
        "background": "#ffffff",
        "width": "100%",
        "height": "50px",
        "line-height": "50px",
        "top": "0px",
        "border-bottom": "1px solid #f1f1f1",
        "border-radius": "6px 6px 0 0",
        "box-shadow": "1px 1px 2px #cccccc",
    }
    this.panelHead.css(css);
    css = {
        "margin-left": "10px",
        "background": "#f1f1f1",
        "padding": "0 15px",
        "height": "30px",
        "border-radius": "6px",
        "line-height": "30px",
        "display": "inline-block",
        "color": "#666666",
        "font-size": "16px",
        "font-weight": "bold",
    }
    this.title.css(css);
    css = {
        "margin-right": "10px",
        "float": "right",
        "line-height": "50px",
    }
    this.close.css(css);
    css = {
        "background": "#ffffff",
        "border": "1px solid #f1f1f1",
        "border-radius": "6px",
        "box-shadow": "1px 1px 2px #cccccc",
    }
    this.content.css(css);
    css = {
        "background": "#ffffff",
        "width": "100%",
        "height": "50px",
        "line-height": "50px",
        "bottom": "0px",
        "border": "none",
        "border-radius": "0 0 6px 6px",
        "position": "absolute",
    }
    this.panelBottom.css(css);
}
WindowPanel.prototype.showAlert = function(typeFlg,title,content,confirmFun){
    var thisObj = this;
    this.element.attr("type",WindowPanel.TypeAlert);
    this.content.append("<img></img>");
    this.content.append("<span></span>");
    this.contentImg = this.content.children("img");
    this.contentSpan = this.content.children("span");
    this.panelBottom.append("<div id='confirm_Btn'></div>");
    this.confirm = this.panelBottom.children("#confirm_Btn");
    this.confirm_Btn = new Button("#windowPanel"+this.randomId+" #confirm_Btn","","确认",Button.TypeImportant,Button.SizeMiddle,this.tarDocument);

    //确认
    this.confirm_Btn.bindEvent("click",function(){
        thisObj.closeWindow();
    });
    this.confirm_Btn.bindEvent("click",confirmFun);

    this.title.text(title);
    this.contentSpan.html(content);
    this.setSize(350,200);
    this.setPositionCenter();
    switch(typeFlg){
        case(WindowPanel.TypeAlertOk):{
            this.contentImg.attr("src",ImageIcon.PopOk);
            break;
        }
        case(WindowPanel.TypeAlertWarning):{
            this.contentImg.attr("src",ImageIcon.PopWarning);
            break;
        }
        case(WindowPanel.TypeAlertError):{
            this.contentImg.attr("src",ImageIcon.PopError);
            break;
        }
        case(WindowPanel.TypeConfirmAsk):{
            this.contentImg.attr("src",ImageIcon.PopAsk);
            break;
        }
    }
    
    var css;
    css = {
        "display": "block",
    }
    this.panelDiv.css(css);
    css = {
        "width": (this.panelDiv.outerWidth() - 16) + "px",
        "height": (this.panelDiv.outerHeight() - this.panelHead.outerHeight() - this.panelBottom.outerHeight() - 16) + "px",
        "margin": "6px",
        "vertical-align": "middle",
    }
    this.content.css(css);
    css = {
        "width": "50px",
        "height": "50px",
        "margin": "10px",
        "display": "inline-block",
        "vertical-align": "middle",
    }
    this.contentImg.css(css);
    css = {
        "width": (this.content.outerWidth() - this.contentImg.outerWidth(true) - 30) + "px",
        "height": (this.content.outerHeight() - 20) + "px",
        "color": "#666666",
        "margin": "10px",
        "font-weight": "bold",
        "font-size": "14px",
        "background": "transparent",
        "display": "inline-block",
        "vertical-align": "middle",
    }
    this.contentSpan.css(css);
    css = {
        "float": "left",
        "margin-left": (this.panelBottom.outerWidth() - this.confirm.outerWidth())/2  + "px",
    }
    this.confirm.css(css);
}

WindowPanel.prototype.showLoading = function(content){
    var thisObj = this;
    this.panelDiv.remove();
    this.element.append("<img></img>");
    this.contentImg = this.element.children("img");
    this.contentImg.attr("src",ImageIcon.Loading);

    this.setSize(350,200);
    this.setPositionCenter();
    
    var css;
    css = {
        "display": "block",
        "width":"150px",
        "position": "absolute",
        "top": "calc(50% - 56px)",
        "left": "calc(50% - 75px)",
    }
    this.contentImg.css(css);
}

WindowPanel.prototype.showConfirm = function(typeFlg,title,content,confirmFun,cancelFun){
    var thisObj = this;
    this.element.attr("type",WindowPanel.TypeConfirm);
    this.content.append("<img></img>");
    this.content.append("<span></span>");
    this.contentImg = this.content.children("img");
    this.contentSpan = this.content.children("span");
    this.panelBottom.append("<div id='confirm_Btn'></div>");
    this.panelBottom.append("<div id='cancel_Btn'></div>");
    this.confirm = this.panelBottom.children("#confirm_Btn");
    this.cancel = this.panelBottom.children("#cancel_Btn");
    this.confirm_Btn = new Button("#windowPanel"+this.randomId+" #confirm_Btn","","确认",Button.TypeImportant,Button.SizeMiddle,this.tarDocument);
    this.cancel_Btn = new Button("#windowPanel"+this.randomId+" #cancel_Btn","","取消",Button.TypeRed,Button.SizeMiddle,this.tarDocument);
    //确认
    this.confirm_Btn.bindEvent("click",function(){
        thisObj.closeWindow();
    });
    this.confirm_Btn.bindEvent("click",confirmFun);
    //取消
    this.cancel_Btn.bindEvent("click",function(){
        thisObj.closeWindow();
    });
    this.cancel_Btn.bindEvent("click",cancelFun);
    
    this.title.text(title);
    this.contentSpan.html(content);
    this.setSize(350,200);
    this.setPositionCenter();

    switch(typeFlg){
        case(WindowPanel.TypeAlertOk):{
            this.contentImg.attr("src",ImageIcon.PopOk);
            break;
        }
        case(WindowPanel.TypeAlertWarning):{
            this.contentImg.attr("src",ImageIcon.PopWarning);
            break;
        }
        case(WindowPanel.TypeAlertError):{
            this.contentImg.attr("src",ImageIcon.PopError);
            break;
        }
        case(WindowPanel.TypeConfirmAsk):{
            this.contentImg.attr("src",ImageIcon.PopAsk);
            break;
        }
    }

    var css;
    css = {
        "display": "block",
    }
    this.panelDiv.css(css);
    css = {
        "width": (this.panelDiv.outerWidth() - 16) + "px",
        "height": (this.panelDiv.outerHeight() - this.panelHead.outerHeight() - this.panelBottom.outerHeight() - 16) + "px",
        "margin": "6px",
        "vertical-align": "middle",
    }
    this.content.css(css);
    css = {
        "width": "50px",
        "height": "50px",
        "margin": "10px",
        "display": "inline-block",
        "vertical-align": "middle",
    }
    this.contentImg.css(css);
    css = {
        "width": (this.content.outerWidth() - this.contentImg.outerWidth(true) - 30) + "px",
        "height": (this.content.outerHeight() - 20) + "px",
        "color": "#666666",
        "margin": "10px",
        "font-weight": "bold",
        "font-size": "14px",
        "background": "transparent",
        "display": "inline-block",
        "vertical-align": "middle",
    }
    this.contentSpan.css(css);
    css = {
        "float": "left",
        "margin-left": (this.panelBottom.outerWidth() / 2 - this.confirm.outerWidth() - 5) + "px",
    }
    this.confirm.css(css);
    css = {
        "float": "right",
        "margin-right": (this.panelBottom.outerWidth() / 2 - this.cancel.outerWidth() - 5) + "px",
    }
    this.cancel.css(css);
}
WindowPanel.prototype.showDialog = function(title, content, widthFlg, heightFlg){
    this.element.attr("type",WindowPanel.TypeDialog);
    this.panelBottom.remove();
    this.content.append("<div>"+content+"</div>");
    
    this.title.text(title);
    this.setSize(widthFlg,heightFlg);
    this.setPositionCenter();

    var css;
    css = {
        "display": "block",
    }
    this.panelDiv.css(css);
    css = {
        "height": (this.panelDiv.outerHeight() - this.panelHead.outerHeight() - 20) + "px",
        "margin": "0 10px",
        "margin-top": "6px",
        "vertical-align": "middle",
    }
    this.content.css(css);
}
WindowPanel.prototype.showPage = function(title, content, widthFlg, heightFlg,screenFlg){
    this.element.attr("type",WindowPanel.TypePage);
    this.panelBottom.remove();
    this.content.append('<iframe src="' + content + '" width="100%" height="100%" frameborder="0" scrolling="no"></iframe>');

    this.title.text(title);
    this.setSize(widthFlg,heightFlg);
    this.setPositionCenter();

    var css;
    if(screenFlg){
    	css = {
    	        "display": "block",
    	        "transform": "scale(0.85)",
    	    }
    }else{
    	css = {
    	        "display": "block",
    	    }
    }
    this.panelDiv.css(css);
    css = {
        // "width": (this.panelDiv.outerWidth() - 20) + "px",
        "height": (this.panelDiv.outerHeight() - this.panelHead.outerHeight() - 20) + "px",
        "margin": "0 10px",
        "margin-top": "6px",
        "vertical-align": "middle",
    }
    this.content.css(css);
}
WindowPanel.prototype.showImage = function(title, imgSrc, imgName){
    var thisObj = this;
    this.element.attr("type",WindowPanel.TypeImage);
    this.content.remove();
    this.panelBody.append('<img></img>');
    this.img = this.panelBody.children("img");
    this.panelBottom.append("<div id='download_Btn'></div>");
    this.download = this.panelBottom.children("#download_Btn");
    this.download_Btn = new Button("#windowPanel"+this.randomId+" #download_Btn",ImageIcon.Xiazai_W,"下载",Button.TypeImportant,Button.SizeLong,this.tarDocument);

    this.title.text(title);
    this.imgSrc = imgSrc;
    this.imgName = imgName;
    this.img.attr("src",imgSrc);
    var maxWidth = SysFunctions.getTopSize().width - 100;
    var maxHeight = SysFunctions.getTopSize().height - 200;

    if(this.img.complete){ //已经缓存的情况
        setImage();
    }else{
        this.img.load(function(){ // 完全加载完毕的事件(没找到情况下默认图片载入后也会执行)
            setImage();
        })
        this.img.error(function(){ //没找到
            thisObj.imgSrc = ImageIcon.ImgUnfind;
            thisObj.imgName = "Image404";
            thisObj.img.attr("src",thisObj.imgSrc);
        })
    }
    function setImage(){
        var tarImg = new Image();
        var imgWidth;
        var imgHeight;
        var imgScale;

        tarImg.src = thisObj.imgSrc;
        if(tarImg.width > maxWidth && tarImg.height > maxHeight){
            if(maxWidth / tarImg.width > maxHeight / tarImg.height){
                imgScale = maxHeight / tarImg.height;
            }else{
                imgScale = maxWidth / tarImg.width;
            }
            imgWidth = imgScale * tarImg.width;
            imgHeight = imgScale * tarImg.height;
        }else{
            if(tarImg.width > maxWidth){
                imgWidth = maxWidth;
                imgHeight = imgWidth / tarImg.width * tarImg.height;
            }else{
                imgWidth = tarImg.width;
            }
            if(tarImg.height > maxHeight){
                imgHeight = maxHeight;
                imgWidth = imgHeight / tarImg.height * tarImg.width;
            }else{
                imgHeight = tarImg.height;
            }
        }
        
        thisObj.setSize(imgWidth+20,imgHeight+thisObj.panelHead.outerHeight()+thisObj.panelBottom.outerHeight()+20);
        thisObj.setPositionCenter();

        var css;
        css = {
            "display": "block",
        }
        thisObj.panelDiv.css(css);
    }
    this.download_Btn.bindEvent("click",function(){
        FileControl.downLoad(thisObj.imgSrc,thisObj.imgName);
    })
    var css;
    css = {
        "margin": "10px",
        "max-width": maxWidth + "px",
        "max-height": maxHeight + "px",
    }
    thisObj.img.css(css);
    css = {
        "float": "right",
        "margin-right": "10px",
    }
    this.download.css(css);
}
WindowPanel.prototype.setSize = function(widthFlg,heightFlg){
    var css = {
        "width": widthFlg+"px",
        "height": heightFlg+"px",
    }
    this.panelDiv.css(css);
}
WindowPanel.prototype.setPosition = function(xFlg,yFlg){
    var css = {
        "left": xFlg+"px",
        "top": yFlg+"px",
    }
    this.panelDiv.css(css);
}
WindowPanel.prototype.setPositionCenter = function(){
    var css = {
        "left": (this.element.outerWidth(true) -this.panelDiv.outerWidth(true)) / 2+"px",
        "top": (this.element.outerHeight(true) -this.panelDiv.outerHeight(true)) / 2+"px",
    }
    this.panelDiv.css(css);
}
WindowPanel.prototype.closeWindow = function(){
    this.element.remove();
    $(this.tarDocument.body).find('.windowPanel').last().find('#maskDiv').show();
}
//关闭最后一个内容框弹窗
WindowPanel.closeLastWindow = function(typeFlg,tarDocument){
    if(tarDocument=="" || tarDocument==null || tarDocument==undefined){
        tarDocument = top.document;
    }
    var windowList = $(tarDocument.body).find(".windowPanel");
    var lastWindow;

    if(typeFlg==null || typeFlg==undefined){
        lastWindow = windowList.eq(windowList.length-1);
        lastWindow.remove();
    }else{
        for(var i=windowList.length-1; i>=0; i--){
            lastWindow = windowList.eq(i);
            if(lastWindow.attr("type") == typeFlg){
                lastWindow.remove();
            	windowList.eq(i - 1).find('#maskDiv').show();
                //$(tarDocument.body).find('.windowPanel').last().find('#maskDiv').show();
                return
            }
        }
    }
    $(tarDocument.body).find('.windowPanel').last().find('#maskDiv').show();
}
//关闭全部弹窗
WindowPanel.closeAllWindow = function(tarDocument){
    if(tarDocument=="" || tarDocument==null || tarDocument==undefined){
        tarDocument = top.document;
    }
    var windowList = $(tarDocument.body).find(".windowPanel");
    for(var i=windowList.length-1; i>=0; i--){ //从最后往前删除
        windowList.eq(i).remove();
    }
}