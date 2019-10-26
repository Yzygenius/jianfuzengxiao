//弹窗---------------------------------------------------------------------------------
PopInfo.ZIndexNum = 999;

PopInfo.TypeAlert = "TypeAlert";

PopInfo.TypeAlertOk = "TypeAlertOk";
PopInfo.TypeAlertWarning = "TypeAlertWarning";
PopInfo.TypeAlertError = "TypeAlertError";
function PopInfo(type,content,tarDocument){
    this.tarDocument = tarDocument;
    if(this.tarDocument=="" || this.tarDocument==null || this.tarDocument==undefined){
        this.tarDocument = top.document;
    }
    //
    this.randomId = Math.floor(Math.random()*100000 + 1);
    $(this.tarDocument.body).append("<div id='pop"+this.randomId+"' class='pop'></div>");
    this.element = $("#pop"+this.randomId,this.tarDocument);
    this.element.append("<div id='panelDiv'></div>");
    this.panelDiv = this.element.children("#panelDiv");
    this.panelDiv.append("<img></img>");
    this.panelDiv.append("<label></label>");
    this.img = this.panelDiv.children("img");
    this.label = this.panelDiv.children("label");

    this.type = type;
    this.content = content;
    //
    this.iniPopInfo();
}
PopInfo.prototype.iniPopInfo = function(){
    this.setCss();

    switch(this.type){
        case(PopInfo.TypeAlertOk):{
            this.img.attr("src",ImageIcon.PopOk);
            break;
        }
        case(PopInfo.TypeAlertWarning):{
            this.img.attr("src",ImageIcon.PopWarning);
            break;
        }
        case(PopInfo.TypeAlertError):{
            this.img.attr("src",ImageIcon.PopError);
            break;
        }
    }
    this.label.html(this.content);

    this.setTimer();
}
PopInfo.prototype.setCss = function(){
    var css;
    css = {
        "width": "250px",
        "height": "80px",
        "position": "absolute",
        "z-index": PopInfo.ZIndexNum,
        "background": "#ffffff",
        "border": "2px solid #f1f1f1",
        "box-shadow": "1px 1px 2px #cccccc",
        "border-radius": "6px",
        "right": 20+"px",
        "bottom": 20+"px",
    }
    this.element.css(css);
    css = {
        "padding": "0",
        "width": "240px",
        "height": "70px",
        "margin": "auto auto",
        "border": "2px solid #f1f1f1",
        "border-radius": "6px",
    }
    this.panelDiv.css(css);
    css = {
        "display": "line-height",
        "line-height": "70px",
    }
    this.img.css(css);
    css = {
        "margin-top": "10px",
        "display": "line-height",
        "line-height": "20px",
        "color": "#666666",
    }
    this.label.css(css);
}
PopInfo.prototype.setTimer = function(){
    var thisObj = this;
    var timer = window.setInterval(function(){
        thisObj.closePopInfo();
		window.clearInterval(timer);
	},2000);
}
PopInfo.prototype.closePopInfo = function(){
    this.element.remove();
}