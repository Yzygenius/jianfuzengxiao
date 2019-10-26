//货物---------------------------------------------------------------------------------
GoodsBox.TypeMainGoods = "TypeMainGoods";//货物一级
GoodsBox.TypeGoods = "TypeGoods";//货物二级

function GoodsBox(targetId,typeFlg){
	//绑定元素
    this.element = $(targetId);
    this.element.append("<div id='mainGoods'></div>");
    this.element.append("<div id='subGoods'></div>");
    this.mainGoods = this.element.children("#mainGoods");
    this.subGoods = this.element.children("#subGoods");
    this.mainGoods_CB = new Combox("#mainGoods",Combox.TypeGoods);
    this.subGoods_CB = new Combox("#subGoods",Combox.TypeGoods);
    //设置属性
    this.type = typeFlg;

    this.iniGoodsBox();
}
GoodsBox.prototype.iniGoodsBox = function(){
    //
    this.setCss();
    if(this.type==GoodsBox.TypeMainGoods){
        this.subGoods.remove();
    }
    //
    this.getComboxData();
}
GoodsBox.prototype.setCss = function(){
    //设置样式
    var css;
    css = {
        "height": "40px",
        "vertical-align": "middle",
        "line-height": "40px",
        "background": "#ffffff",
    }
    this.element.css(css);
    css = {
    	"display": "inline-block",
    }
    this.mainGoods.css(css);
    css = {
        "margin-left": "10px",
    	"display": "inline-block",
    }
    this.subGoods.css(css);
}
GoodsBox.prototype.getComboxData = function(){
    //下载数据
    var thisObj = this;
    $.ajax({
    	url : "../goods/getGoodsList.html",
        type : "post",
        dataType: "json",
        success : function(returnValue){
            //设置下拉框
            thisObj.setGoods(returnValue.data);
        },
        error: function(){
            //new WindowPanel().showAlert(WindowPanel.TypeAlertError,"错误", "货物数据获取失败！");
        }
    })
}
GoodsBox.prototype.setGoods = function(goodsData){
    var thisObj = this;
    this.goodsData = goodsData;
    
    //初始化一级货物
    this.mainGoodsData=[{optionId:Combox.DefaultValue, optionName:"请选择一级货物"}];
    for(var i=0; i<this.goodsData.length; i++){
        this.mainGoodsData.push({optionId: this.goodsData[i].goodsId, optionName: this.goodsData[i].goodsName});
    }
    this.mainGoods_CB.setCombox(this.mainGoodsData);
    this.mainGoods_CB.bindChange(mainGoodsChange);
    //初始化二级货物
    this.subGoodsData=[{optionId:Combox.DefaultValue, optionName:"请选择二级货物"}];
    this.subGoods_CB.setCombox(this.subGoodsData);
    this.subGoods_CB.bindChange(subGoodsChange);

    function mainGoodsChange(){
        thisObj.subGoodsData=[{optionId:Combox.DefaultValue, optionName:"请选择二级货物"}];
        if(thisObj.mainGoods_CB.getSelValue()!=Combox.DefaultValue){
            for(var i=0; i<thisObj.goodsData.length; i++){
                if(thisObj.goodsData[i].goodsId==thisObj.mainGoods_CB.getSelValue()){
                    thisObj.mainGoodsChildData = thisObj.goodsData[i].childList;
                    for(var i=0; i<thisObj.mainGoodsChildData.length; i++){
                        thisObj.subGoodsData.push({optionId: thisObj.mainGoodsChildData[i].goodsId, optionName: thisObj.mainGoodsChildData[i].goodsName});
                    }
                    break;
                }
            }
        }
        
        thisObj.subGoods_CB.setCombox(thisObj.subGoodsData);
        thisObj.subGoods_CB.setSelect(Combox.DefaultValue);
    }
    function subGoodsChange(){
        
    }
}
GoodsBox.prototype.setMainGoodsSelect = function(optionId){ //设置选中
    this.mainGoods_CB.setSelect(optionId);
}
GoodsBox.prototype.setSubGoodsSelect = function(optionId){ //设置选中
    this.subGoods_CB.setSelect(optionId);
}
GoodsBox.prototype.getMainGoodsValue = function(){ //获取选中值
	return this.mainGoods_CB.getSelValue();
}
GoodsBox.prototype.getSubGoodsValue = function(){ //获取选中值
	return this.subGoods_CB.getSelValue();
}
GoodsBox.prototype.getMainGoodsText = function(){ //获取选中值
	return this.mainGoods_CB.getSelText();
}
GoodsBox.prototype.getSubGoodsText = function(){ //获取选中值
	return this.subGoods_CB.getSelText();
}
GoodsBox.prototype.closeOptionPanel = function(){ //关闭面板
	this.mainGoods_CB.closeOptionPanel();
	this.subGoods_CB.closeOptionPanel();
}