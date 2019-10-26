//数据块---------------------------------------------------------------------------------
function DataBlock(targetId,gridSetData){
	//绑定元素
    this.element = $(targetId);
    this.element.append("<div id='title'></div>"); //标题
    this.element.append("<div id='main'></div>"); //主体
    this.element.append("<div id='bottom'></div>"); //底部
    this.title = this.element.children("#title");
    this.main = this.element.children("#main"); 
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
    this.contents = gridSetData.contents;
    this.doFunction = gridSetData.doFunction;
    this.dbClickFun = gridSetData.dbClickFun;
    this.blockList = [];
    this.blockData = [];
    //初始化
    this.iniDataBlock();
}
DataBlock.prototype.iniDataBlock = function(){ //初始化
    var thisObj = this;
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
DataBlock.prototype.setCss = function(){ //设置样式
    var css;
    css = {
        "width": "100%",
        "height": "calc(100% - 110px)", //去掉部分固定区域
        "background": "#ffffff",
    }
    this.element.css(css);
    css = {
        "width": "100%",
        "height": "30px",
        "display": "inline-block",
        "vertical-align": "middle",
        "background": "#f1f1f1",
    }
    this.title.css(css);
    css = {
        "width": "100%",
        "height":"calc(100% - 50px)",
        "line-height": "30px",
        "vertical-align": "middle",
        "background-color": "#ffffff",
        "overflow-y":"scroll",
    }
    this.main.css(css);
    css = {
    	"margin-bottom": "10px",
        "padding-bottom": "10px",
        "width": "100%",
        "overflow": "hidden",
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
DataBlock.prototype.searchData = function(ajaxJson){ //查询数据
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
        	new WindowPanel().showAlert(WindowPanel.TypeAlertError,"错误","获取数据失败！");
        }
    })
}
DataBlock.prototype.setPage = function(blockData){ //设置页面
    var thisObj = this;
    //基础数据
    this.blockData = blockData;
    this.pageNum = blockData.page;
    this.pageCount = blockData.pageCount;
    this.pageSize = blockData.pageSize;
    this.total = blockData.total;
    this.pageData = blockData.rows;
    this.colCount = 5;
    if(this.pageData.length>0){
        //生成表格
        for(var i=0; i<this.pageData.length; i++){
            if(i%5 == 0){
                this.list.append("<li></li>");
            }
            this.list.children("li").last().append("<div id='block_"+((this.pageNum-1)*this.pageSize+i+1)+"'></div>");
            this.blockList.push(new DataBlockItem(this.targetId +" #block_"+((this.pageNum-1)*this.pageSize+i+1),((this.pageNum-1)*this.pageSize+i+1),this.pageData[i],this.gridSetData,this));
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
DataBlock.prototype.changePage = function(pageNum){ //变更页面
    this.ajaxJson.queryParams.page = pageNum;
    this.searchData(this.ajaxJson);
}
DataBlock.prototype.clearPage = function(){ //清除页面
    this.list.children().remove();
    this.totalPageValue.text("0");
    this.totalCountValue.text("0");
    this.currentPageValue.text("0");
    this.blockList = [];
    this.blockData = [];
}
DataBlock.prototype.reFresh = function(){
    this.searchData(this.ajaxJson);
}