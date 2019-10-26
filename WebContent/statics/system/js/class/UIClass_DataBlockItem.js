//通用数据块---------------------------------------------------------------------------------
function DataBlockItem(targetId,blockIndex,blockData,blockSetData){
	//绑定元素
    this.element = $(targetId);
    //
    this.element.append("<div id='headDiv'></div>");
    this.element.append("<div id='contentDiv'></div>");
    this.element.append("<div id='bottomDiv'></div>");
    this.headDiv = this.element.children("#headDiv");
    this.contentDiv = this.element.children("#contentDiv");
    this.bottomDiv = this.element.children("#bottomDiv");
    //
    this.targetId = targetId;
    this.blockIndex = blockIndex;
    this.blockData = blockData;
    this.blockSetData = blockSetData;
    this.head = blockSetData.head;
    this.contents = blockSetData.contents;
    this.bottom = blockSetData.bottom;
    this.doFunction = blockSetData.doFunction;
    this.dbClickFun = blockSetData.dbClickFun;

    this.iniBlockItem();
}
DataBlockItem.prototype.iniBlockItem = function(){
    var thisObj = this;

    this.setCss();
    //标题
    for(var i=0; i<this.head.length; i++){
        this.headDiv.append("<div id='itemHead_"+i+"'></td>");
        if(this.head[i].formatter == null || this.head[i].formatter == undefined){
            this.headDiv.find("#itemHead_"+i).text(this.blockData[this.head[i].field]);
        }else{
            this.headDiv.find("#itemHead_"+i).html(this.head[i].formatter(this.blockData));
        }
    }
    //内容主体
    for(var i=0; i<this.contents.length; i++){
        this.contentDiv.append("<div id='itemContent_"+this.contents[i].field+"'></td>");
        if(this.contents[i].formatter == null || this.contents[i].formatter == undefined){
            this.contentDiv.find("#itemContent_"+this.contents[i].field).text(this.blockData[this.contents[i].field]);
        }else{
            this.contentDiv.find("#itemContent_"+this.contents[i].field).html(this.contents[i].formatter(this.blockData));
        }
    }
    //内容主体
    for(var i=0; i<this.bottom.length; i++){
        this.bottomDiv.append("<div id='itemBottom_"+this.bottom[i].field+"'></td>");
        if(this.bottom[i].formatter == null || this.bottom[i].formatter == undefined){
            this.bottomDiv.find("#itemBottom_"+this.bottom[i].field).text(this.blockData[this.bottom[i].field]);
        }else{
            this.bottomDiv.find("#itemBottom_"+this.bottom[i].field).html(this.bottom[i].formatter(this.blockData));
        }
    }
    //执行内容
    if(this.doFunction != null && this.doFunction != undefined){
        this.doFunction(this.targetId,this.blockData);
    }
    //
    this.element.bind("mouseenter",blockEnter);
    this.element.bind("mouseleave",blockLeave);
    this.element.bind("dblclick",blockDbClick);
    //
    function blockEnter(){
        thisObj.setDisEnter();
    }
    function blockLeave(){
        thisObj.setDisNormal();
    }
    function blockDbClick(){
        thisObj.blockClickFun(thisObj.blockData);
    }
}
DataBlockItem.prototype.setCss = function(){
    var css;
    css = {
        "background": "#transparent",
        "margin": "10px",
    }
    this.headDiv.css(css);
    css = {
        "border": "2px solid #f1f1f1",
        "border-radius": "6px",
        "background": "#transparent",
        "color": "#666666",
        "margin": "10px",
        "line-height": "30px",
        "vertical-align": "middle",
    }
    this.contentDiv.css(css);
    css = {
        "background": "#transparent",
        "margin": "10px",
    }
    this.bottomDiv.css(css);
    css = {
        "margin": "10px",
        "display": "inline-block",
        "width":"304px",
        "border-radius": "10px",
        "cursor": "default",
        "border": "1px solid #f1f1f1",
        "background": "#ffffff",
        "box-shadow": "1px 1px 2px #cccccc",
    }
    this.element.css(css);
}
DataBlockItem.prototype.setDisEnter = function(){
    this.element.css("box-shadow","none");
    this.element.offset({top:this.element.offset().top+2,left:this.element.offset().left+2});
}
DataBlockItem.prototype.setDisNormal = function(){
    this.element.css("box-shadow","1px 1px 2px #cccccc");
    this.element.offset({top:this.element.offset().top-2,left:this.element.offset().left-2});
}