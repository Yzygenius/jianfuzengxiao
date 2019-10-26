//通用数据行---------------------------------------------------------------------------------
function DataGridItem(targetId,itemIndex,itemData,gridSetData,thisDataGrid){
	//绑定元素
    this.element = $(targetId);
    //
    this.element.append("<table id='headTable'></table>");
    this.headTable = this.element.children("#headTable");
    this.headTable.append("<tr></tr>");
    this.headTr = this.headTable.find("tr");
    //
    this.element.append("<table id='contentTable'></table>");
    this.contentTable = this.element.children("#contentTable");
    this.contentTable.append("<tr></tr>");
    this.contentTr = this.contentTable.find("tr");
    //
    this.targetId = targetId;
    this.itemIndex = itemIndex;
    this.itemData = itemData;
    this.gridSetData = gridSetData;
    this.head = gridSetData.head;
    this.columns = gridSetData.columns;
    this.itemClickFun = gridSetData.itemClickFun;
    this.doFunction = gridSetData.doFunction;
    this.thisDataGrid = thisDataGrid;

    this.iniItem();
}
DataGridItem.prototype.iniItem = function(){
    var thisObj = this;
    //头部显示
    if(this.head.id.visible){
        this.headTr.append("<td id='id'></td>");
        this.id = this.headTr.children("#id");
        if(this.head.id.formatter == null || this.head.id.formatter == undefined){
            this.id.text(this.itemIndex);
        }else{
            this.id.html(this.head.id.formatter(this.itemIndex));
        }
        this.id.css({"width":this.head.id.width});
    }
    if(this.head.icon.visible){
        this.headTr.append("<td id='icon'></td>");
        this.icon = this.headTr.children("#icon");
        this.icon.html(this.head.icon.formatter(this.itemData));
        this.icon.css({"width":this.head.icon.width});
    }
    if(this.head.checkBox.visible){
        this.headTr.append("<td id='checkBox'></td>");
        this.checkBox = this.headTr.children("#checkBox");
        this.checkBox.append("<div id='checkBoxBtn'><div class='option'></div></div>");
        this.checkBoxBtn = new CheckBox(this.targetId+" #checkBoxBtn",[{"value":this.itemData[this.head.checkBox.field],"text":""}]);
        this.checkBox.css({"width":this.head.checkBox.width});
        this.checkBox.css({"text-align": "center"});

        this.checkBoxBtn.bindEvent("click",checkClick);
    }
    //内容主体
    for(var i=0; i<this.columns.length; i++){
        this.contentTr.append("<td id='item_"+this.columns[i].field+"'></td>");
        this.contentTr.find("#item_"+this.columns[i].field).css({"width":this.columns[i].width});
        if(this.columns[i].formatter == null || this.columns[i].formatter == undefined){
            this.contentTr.find("#item_"+this.columns[i].field).text(this.itemData[this.columns[i].field]);
        }else{
            this.contentTr.find("#item_"+this.columns[i].field).html(this.columns[i].formatter(this.itemData));
        }
    }
    //执行内容
    if(thisObj.doFunction != null && thisObj.doFunction != undefined){
        thisObj.doFunction(thisObj.targetId,thisObj.itemData);
    }
    //
    this.contentTable.bind("mouseenter",itemEnter);
    this.contentTable.bind("mouseleave",itemLeave);
    // this.contentTable.bind("click",itemClick);
    this.contentTable.bind("dblclick",itemDbClick);
    //
    function itemEnter(){
        thisObj.setDisEnter();
    }
    function itemLeave(){
        thisObj.setDisNormal();
    }
    function itemClick(){
        thisObj.setDisSelect();
    }
    function itemDbClick(){
        thisObj.itemClickFun(thisObj.itemData);
    }
    function checkClick(){
        thisObj.thisDataGrid.itemCheck(thisObj.itemCheckBoxValue());
    }

    this.setCss();
}
DataGridItem.prototype.setCss = function(){
    var css;
    css={
        "display": "inline-block",
        "border-radius": "10px",
        "margin-top": "10px",
        "margin-left": "10px",
        "height": "60px",
        "line-height": "60px",
        "vertical-align": "middle",
        "color": "#333333",
        "cursor": "default",
        "border": "1px solid #eeeeee",
        "background": "#ffffff",
        "box-shadow": "1px 1px 2px #cccccc",
    }
    this.headTable.css(css);
    css={
        "width":"calc(100% - "+(this.headTable.outerWidth(true)+22)+"px)",
        "display": "inline-block",
        "border-radius": "10px",
        "margin-top": "10px",
        "margin-left": "10px",
        "margin-right": "10px",
        "height": "60px",
        "line-height": "60px",
        "vertical-align": "middle",
        "color": "#666666",
        "cursor": "default",
        "border": "1px solid #eeeeee",
        "background": "#ffffff",
        "box-shadow": "1px 1px 2px #cccccc",
    }
    this.contentTable.css(css);
    css={
    	"text-align":"center",
    }
    this.contentTable.find("td").css(css);
}
DataGridItem.prototype.setItemCheck = function(checkflg){
    if(checkflg){
        this.checkBoxBtn.setCheckValue([this.itemData[this.head.checkBox.field]]);
    }else{
        this.checkBoxBtn.setCheckValue([]);
    }
}
DataGridItem.prototype.getItemCheck = function(){
    return this.checkBoxBtn.getCheckValue();
}
DataGridItem.prototype.itemCheckBoxValue = function(){
    return this.itemData[this.head.checkBox.field];
}
DataGridItem.prototype.setDisEnter = function(){
    this.contentTable.css("background","#f1f1f1");
    this.contentTable.css("border-color","#f1f1f1");
}
DataGridItem.prototype.setDisNormal = function(){
    this.contentTable.css("background","#ffffff");
    this.contentTable.css("border-color","#f1f1f1");
}
DataGridItem.prototype.setDisSelect = function(){
    this.contentTable.css("background","#d3f1f8");
    this.contentTable.css("border-color","#d3f1f8");
}