//数据表---------------------------------------------------------------------------------
function DataGrid(targetId,gridSetData){
	//绑定元素
    this.element = $(targetId);
    this.element.append("<div id='displayContent'></div>");//显示区
    this.element.append("<div id='bottom'></div>"); //底部
    this.displayContent = this.element.children("#displayContent");
    this.displayContent.append("<div id='title'></div>"); //标题
    this.displayContent.append("<div id='main'></div>"); //主体
    this.title = this.displayContent.children("#title");
    this.title.append("<table id='headTitleTable'></table>");
    this.title.append("<table id='contentTitleTable'></table>");
    this.headTitleTable = this.title.children("#headTitleTable");
    this.contentTitleTable = this.title.children("#contentTitleTable");
    this.main = this.displayContent.children("#main");
    this.main.append("<ul id='list'></ul>");
    this.list = this.main.children("#list");
    this.bottom = this.element.children("#bottom"); 
    this.bottom.append("<div id='labels'></div>");
    this.bottom.append("<div id='btns'></div>");
    this.btmLabels = this.bottom.children("#labels");
    this.btmBtns = this.bottom.children("#btns");
    this.btmLabels.append("<label id='totalPageValue'></label>");
    this.btmLabels.append("<label id='totalCountValue'></label>");
    this.btmLabels.append("<label id='currentPageValue'></label>");
    this.totalPageValue = this.btmLabels.children("#totalPageValue"); //总页数
    this.totalCountValue = this.btmLabels.children("#totalCountValue"); //总数据量
    this.currentPageValue = this.btmLabels.children("#currentPageValue"); //当前页数
    this.btmBtns.append("<div id='fpBtn'></div>");
    this.btmBtns.append("<div id='lpBtn'></div>");
    this.btmBtns.append("<div id='npBtn'></div>");
    this.btmBtns.append("<div id='epBtn'></div>");
    this.fpBtn = new Button(targetId +" #fpBtn","/dazong/statics/manager/image/ui/left_double.png","",Button.TypeNormal,Button.SizeShort);
    this.lpBtn = new Button(targetId +" #lpBtn","/dazong/statics/manager/image/ui/left_single.png","",Button.TypeNormal,Button.SizeShort);
    this.npBtn = new Button(targetId +" #npBtn","/dazong/statics/manager/image/ui/right_single.png","",Button.TypeNormal,Button.SizeShort);
    this.epBtn = new Button(targetId +" #epBtn","/dazong/statics/manager/image/ui/right_double.png","",Button.TypeNormal,Button.SizeShort);
    //设置属性
    this.targetId = targetId;
    this.gridSetData = gridSetData;
    this.head = gridSetData.head;
    this.columns = gridSetData.columns;
    this.doFunction = gridSetData.doFunction;
    this.itemClickFun = gridSetData.itemClickFun;
    this.gridList = [];
    this.gridData = [];
    this.checkList = [];
    //初始化
    this.iniDataGrid();
}
DataGrid.prototype.iniDataGrid = function(){ //初始化
    var thisObj = this;
    //
    this.setTitle();
    //显示初始化
    //文本
    this.totalPageValue.text("0");
    this.totalCountValue.text("0");
    this.currentPageValue.text("0");
    //按钮
    this.fpBtn.setDisable(true);
    this.lpBtn.setDisable(true);
    this.npBtn.setDisable(true);
    this.epBtn.setDisable(true);
    this.fpBtn.bindEvent("click",fpClick);
    this.lpBtn.bindEvent("click",lpClick);
    this.npBtn.bindEvent("click",npClick);
    this.epBtn.bindEvent("click",epClick);

    function fpClick(){
        thisObj.changePage(1);
    }
    function lpClick(){
        thisObj.changePage(thisObj.pageNum-1);
    }
    function npClick(){
        thisObj.changePage(thisObj.pageNum+1);
    }
    function epClick(){
        thisObj.changePage(thisObj.pageCount);
    }
    //初始化样式
    this.setCss();
}
DataGrid.prototype.setCss = function(){ //设置样式
    var css;
    
    css = {
        "width": "100%",
        "height": "calc(100% - 115px)", //去掉部分固定区域
        "background": "#ffffff",
        "overflow": "auto",
    }
    this.element.css(css);
    if(this.element.width() >= this.defaultWidth){
        css = {
            "width": "100%",
            "height": "100%", 
        }
    }else{
        css = {
            "width": this.defaultWidth + "px",
            "height": "100%",
        }
    }
    this.displayContent.css(css);
    css = {
        "width": "100%",
        "display": "inline-block",
        "vertical-align": "middle",
        "background": "#f1f1f1",
    }
    this.title.css(css);
    css = {
        "margin-left": "10px",
        "display": "inline-block",
        "border-left":"1px solid transparent",
        "border-right":"1px solid transparent",
        "vertical-align":"top",
    }
    this.headTitleTable.css(css);
    css = {
        "width":"calc(100% - "+(this.headTitleTable.outerWidth(true)+32)+"px)",
        "margin-left": "10px",
        "margin-right": "10px",
        "display": "inline-block",
        "padding":"0 1px",
        "vertical-align":"top",
    }
    this.contentTitleTable.css(css);
    css = {
        "line-height":"30px",
        "text-align":"center",
        "color": "#666666",
        "margin":"10px 0px",
        "font-weight": "bold",
        "border-radius": "6px",
        "background": "#ffffff",
    }
    this.headTitleTr.find("td").children("div").css(css);
    css = {
        "line-height":"30px",
        "text-align":"center",
        "border-left":"1px dashed #999999",
        "color": "#666666",
        "margin":"10px 0px",
        "font-weight": "bold",
    }
    this.contentTitleTr.find("td").children("div").css(css);
    css = {
        "width": "100%",
        "height":"calc(100% - 50px)",
        "line-height": "30px",
        "vertical-align": "middle",
        "background-color": "#ffffff",
        "overflow":"auto",
    }
    this.main.css(css);
    css = {
        "margin-bottom": "10px",
        "width": "100%",
    }
    this.list.css(css);
    css = {
        "width": "100%",
        "height": "50px",
        "vertical-align": "middle",
        "background-color": "#d3f1f8",
        "position": "fixed",
        "bottom": "0",
    }
    this.bottom.css(css);
    css = {
        "float": "left",
        "margin-left": "10px",
        "margin-top": "10px",
        "width": "378px",
        "height": "34px",
        "background": "url('/dazong/statics/manager/image/ui/datagrid_pageinfo.png') no-repeat 100% 100%",
    }
    this.btmLabels.css(css);
    css = {
        "display": "inline-block",
        "margin-left": "76px",
        "text-align": "center",
        "width": "40px",
        "height": "34px",
        "line-height": "34px",
        "vertical-align": "middle",
        "display": "inline-block",
        "color": "#666666",
        "font-weight": "bold",
    }
    this.totalPageValue.css(css);
    css = {
        "display": "inline-block",
        "margin-left": "84px",
        "text-align": "center",
        "width": "40px",
        "height": "34px",
        "line-height": "34px",
        "vertical-align": "middle",
        "display": "inline-block",
        "color": "#666666",
        "font-weight": "bold",
    }
    this.totalCountValue.css(css);
    css = {
        "display": "inline-block",
        "margin-left": "84px",
        "text-align": "center",
        "width": "40px",
        "height": "34px",
        "line-height": "34px",
        "vertical-align": "middle",
        "display": "inline-block",
        "color": "#666666",
        "font-weight": "bold",
    }
    this.currentPageValue.css(css);
    css = {
        "float": "right",
        "margin-right": "30px",
        "height": "44px",
        "line-height": "44px",
        "vertical-align": "middle",
    }
    this.btmBtns.css(css);
    css = {
        "display": "inline-block",
        "margin-right": "10px",
        "width": "44px",
        "height": "44px",
        "line-height": "44px",
        "vertical-align": "middle",
    }
    this.btmBtns.children().css(css);
}
DataGrid.prototype.searchData = function(ajaxJson){ //查询数据
    var thisObj = this;
    //清除页面
    this.clearPage();
    //请求数据
    this.ajaxJson = ajaxJson;
    this.ajaxUrl = ajaxJson.url;
    this.ajaxType = ajaxJson.type;
    this.ajaxDataType = ajaxJson.dataType;
    this.ajaxQueryParams = ajaxJson.queryParams;
    $.ajax({
        url: thisObj.ajaxUrl,
        type: thisObj.ajaxType,
        dataType: thisObj.ajaxDataType,
        data: thisObj.ajaxQueryParams,
        success : function(data){
            thisObj.setPage(data);
        },
        error: function(){
        	//new WindowPanel().showAlert(WindowPanel.TypeAlertError,"错误","获取数据失败！");
        }
    })
}
DataGrid.prototype.setTitle = function(){ //标题设置
    var thisObj = this;
    this.defaultWidth = 20;
    //head
    this.headTitleTable.append("<tr id='headTitleTr'></tr>");
    this.headTitleTr = this.headTitleTable.find("#headTitleTr");
    if(this.head.id.visible){
        this.headTitleTr.append("<td id='head_id'><div></div></td>");
        this.headTitleTr.find("#head_id div").text(this.head.id.title);
        this.headTitleTr.find("#head_id").css({"width":this.head.id.width});
        this.defaultWidth += Number(this.head.id.width.replace("px",""));
    }
    if(this.head.icon.visible){
        this.headTitleTr.append("<td id='head_icon'><div></div></td>");
        this.headTitleTr.find("#head_icon div").text(this.head.icon.title);
        this.headTitleTr.find("#head_icon").css({"width":this.head.icon.width});
        this.defaultWidth += Number(this.head.icon.width.replace("px",""));
    }
    if(this.head.checkBox.visible){
        this.headTitleTr.append("<td id='head_checkBox'><div id='checkAll'><div class='option'></div></div></td>");
        this.headTitleTr.find("#head_checkBox").css({"width":this.head.checkBox.width});
        this.defaultWidth += Number(this.head.checkBox.width.replace("px",""));
        this.checkAll = new CheckBox(this.targetId+" #checkAll",[{"value":"all","text":""}]);
        this.checkAll.bindEvent("click",function(){
            thisObj.allItemCheck();
        });
    }
    //content
    this.contentTitleTable.append("<tr id='contentTitleTr'></tr>");
    this.contentTitleTr = this.contentTitleTable.find("#contentTitleTr");
    for(var i=0; i<this.columns.length; i++){
        this.contentTitleTr.append("<td id='title_"+this.columns[i].field+"'><div></div></td>");
        this.contentTitleTr.find("#title_"+this.columns[i].field +" div").text(this.columns[i].title);
        this.contentTitleTr.find("#title_"+this.columns[i].field).css({"width":this.columns[i].width});
        this.defaultWidth += Number(this.columns[i].width.replace("px",""));

        if(this.columns[i].tip!="" && this.columns[i].tip!=null && this.columns[i].tip!=undefined){
            var tip;
            var tipContent = thisObj.columns[i].tip;
            this.contentTitleTr.find("#title_"+this.columns[i].field +" div").append("<img id='tip_"+i+"' src='"+ImageIcon.Tip_G+"' style='margin-left:5px;width:18px;'></img>");
            this.contentTitleTr.find("#tip_"+i).bind("mouseenter",function(){
                tip = new Tip(tipContent);
            });
            this.contentTitleTr.find("#tip_"+i).bind("mouseleave",function(){
                tip.closeTip();
            });
        }
    }
}
DataGrid.prototype.setPage = function(gridData){ //设置页面
    var thisObj = this;
    //基础数据
    this.gridData = gridData;
    this.pageNum = gridData.page;
    this.pageCount = gridData.pageCount;
    this.pageSize = gridData.pageSize;
    this.total = gridData.total;
    this.pageData = gridData.rows;
    if(this.pageData.length>0){
        //生成表格
        for(var i=0; i<this.pageData.length; i++){
            this.list.append("<li id='list_"+((this.pageNum-1)*this.pageSize+i+1)+"'></li>");
            this.gridList.push(new DataGridItem(this.targetId +" #list_"+((this.pageNum-1)*this.pageSize+i+1),((this.pageNum-1)*this.pageSize+i+1),this.pageData[i],this.gridSetData,this));
        }
        //设置底部
        this.totalPageValue.text(this.pageCount);
        this.totalCountValue.text(this.total);
        this.currentPageValue.text(this.pageNum);
        //底部按钮
        this.fpBtn.setDisable(this.pageNum==1);
        this.lpBtn.setDisable(this.pageNum==1);
        this.npBtn.setDisable(this.pageNum==this.pageCount);
        this.epBtn.setDisable(this.pageNum==this.pageCount);
    }else{
        new WindowPanel().showAlert(WindowPanel.TypeAlertWarning,"提醒","没有查询到的数据！<br><br>请尝试重新设置搜索项");
    }
}
DataGrid.prototype.changePage = function(pageNum){ //变更页面
    this.ajaxJson.queryParams.page = pageNum;
    this.searchData(this.ajaxJson);
}
DataGrid.prototype.clearPage = function(){ //清除页面
    this.list.children().remove();
    this.totalPageValue.text("0");
    this.totalCountValue.text("0");
    this.currentPageValue.text("0");
    this.gridList = [];
    this.gridData = [];
    this.checkList = [];
}
DataGrid.prototype.itemCheck = function(checkValue){ //
    //if(this.checkList.includes(checkValue)){  IE14以下不支持includes属性
	if(this.checkList.indexOf(checkValue) != '-1'){
        this.checkList.splice(this.checkList.indexOf(checkValue),1);
        this.checkAll.setCheckValue([]);
    }else{
        this.checkList.push(checkValue);
        if(this.checkList.length == this.gridList.length){
            this.checkAll.setCheckValue(["all"]);
        }
    }
}
DataGrid.prototype.allItemCheck = function(){
    if(this.checkAll.getCheckValue().length==0){
        for(var i=0; i<this.gridList.length; i++){
            this.gridList[i].setItemCheck(false);
        }
        this.checkList = [];
    }else{
        this.checkList = [];
        for(var i=0; i<this.gridList.length; i++){
            this.gridList[i].setItemCheck(true);
            this.checkList.push(this.gridList[i].itemCheckBoxValue());
        }
    }
}
DataGrid.prototype.getCheckList = function(){
    return this.checkList;
}
DataGrid.prototype.reFresh = function(){
    this.searchData(this.ajaxJson);
}