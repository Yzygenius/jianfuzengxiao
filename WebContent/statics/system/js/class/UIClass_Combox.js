//下拉菜单---------------------------------------------------------------------------------
Combox.TypeGoods = "Goods"; //货物类型
Combox.TypePayMan = "PayMan"; //货物类型
Combox.TypeDemindState = "DemindState"; //订单状态
Combox.TypeVehicleState = "VehicleState"; //运输状态
Combox.TypeReceiptState = "ReceiptState"; //小票状态
Combox.TypePushMessage = "PushMessage"; //消息类型
Combox.TypeMessagePushState = "MessagePushState";//消息已读/未读
Combox.TypePayType = "PayType";//支付类型   
Combox.TypePayMode = "PayMode";//支付方式
Combox.TypeArea = "Area";//区域
Combox.TypeVehicleState = "VehicleState";//车次状态
Combox.TypeBankType = "BankType";//银行卡类型
Combox.TypeRoleType = "RoleType";//权限类型
Combox.TypeAccountState = "AccountState";//账号状态

Combox.TypeBankList = "BankList";//绑定银行卡列表
Combox.DefaultValue = "";
Combox.TypeCertTypeDesc = "TypeCertTypeDesc";//经理人认证方式

function Combox(targetId,typeFlg){
	//绑定元素
    this.element = $(targetId);
    this.element.append("<img></img>");
    this.element.append("<text></text>");
    this.element.append("<button></button>");
    this.element.append("<div></div>");
    this.img = this.element.children("img");
    this.combox = this.element.children("text");
    this.btn = this.element.children("button");
    this.optionPanel = this.element.children("div");
    this.optionPanel.append("<ul></ul>");
    this.options = this.optionPanel.children("ul");
    //设置属性
    this.type = typeFlg;
    this.optionList = [];
    this.comboxData = [];

    this.iniComboxData();
}
Combox.prototype.iniComboxData = function(){
    var thisObj = this;
    //
    this.optionPanel.attr("isOpen","false");
    this.combox.attr("comboxValue",Combox.DefaultValue);
    //
    this.setCss();
    switch(this.type){
        case(Combox.TypeGoods):{
            this.img.attr("src",ImageIcon.Xitong_B);
            break;
        }
        case(Combox.TypePayMan):{
            this.img.attr("src",ImageIcon.Touxiang_B);
            break;
        }
        case(Combox.TypeDemindState):{
            this.img.attr("src",ImageIcon.Zhuangtai_B);
            break;
        }
        case(Combox.TypeVehicleState):{
            this.img.attr("src",ImageIcon.Zhuangtai_B);
            break;
        }
        case(Combox.TypeReceiptState):{
            this.img.attr("src",ImageIcon.Zhuangtai_B);
            break;
        }
        case(Combox.TypePushMessage):{
            this.img.attr("src",ImageIcon.Laba_B);
            break;
        }
        case(Combox.TypeMessagePushState):{
            this.img.attr("src",ImageIcon.Zhuangtai_B);
            break;
        }
        case(Combox.TypePayType):{
            this.img.attr("src",ImageIcon.Qianbao_B);
            break;
        }
        case(Combox.TypePayMode):{
            this.img.attr("src",ImageIcon.Qianbao_B);
            break;
        }
        case(Combox.TypeArea):{
            this.img.attr("src",ImageIcon.Ditu_B);
            break;
        }
        case(Combox.TypeBankType):{
            this.img.attr("src",ImageIcon.Jia_B);
            break;
        }
        case(Combox.TypeRoleType):{
            this.img.attr("src",ImageIcon.Gerenzhongxin_B);
            break;
        }
        case(Combox.TypeAccountState):{
            this.img.attr("src",ImageIcon.Zhuangtai_B);
            break;
        }
        case(Combox.TypeBankList):{
            this.img.attr("src",ImageIcon.Jia_B);
            break;
        }
        case(Combox.TypeCertTypeDesc):{
            this.img.attr("src",ImageIcon.Renzheng_B);
            break;
        }
    }
    //绑定事件
    this.combox.bind("click",clickCombox);
    this.btn.bind("click",clickBtn);
    //鼠标事件
    function clickCombox(){
        if(thisObj.optionPanel.attr("isOpen")=="true"){
            thisObj.closeOptionPanel();
        }else{
            thisObj.openOptionPanel();
        }
    }
    function clickBtn(){
        if(thisObj.optionPanel.attr("isOpen")=="true"){
            thisObj.closeOptionPanel();
            
        }else{
            thisObj.openOptionPanel();
        }
    }
    //监听关闭面板
    $(document).bind("mousedown",function(event){
        if(thisObj.optionPanel.attr("isOpen")=="true"){
            var elementList = thisObj.element[0].getElementsByTagName('*');
            for(var i=0; i<elementList.length; i++){
                if(elementList[i]==event.target){
                    return;
                }
            }
            thisObj.closeOptionPanel();
        }
    })
    //
    this.getComboxData(this.type);
}
Combox.prototype.setCss = function(){
    //设置样式
    var css;
    css = {
    	"width": "180px",
        "height": "40px",
        "vertical-align": "middle",
        "line-height": "40px",
        "border": "1px solid #f1f1f1",
        "border-radius": "6px",
        "box-shadow": "1px 1px 2px #cccccc",
        "background": "#ffffff",
    }
    this.element.css(css);
    css = {
    	"margin-left": "10px",
    	"width": "26px",
    	"height": "26px",
    	"display": "inline-block",
    	"vertical-align": "middle",
    }
    this.img.css(css);
    css = {
        "margin-left": "10px",
        "color": "#666666",
        "width": "100px",
        "height": "30px",
        "line-height": "30px",
        "font-size": "14px",
        "border": "none",
        "outline": "none",
        "display": "inline-block",
        "readonly": "true",
        "cursor": "default",
        "vertical-align": "middle",
        "background-color": "transparent",
        "readonly": "true",
    }
    this.combox.css(css);
    css = {
        "width": "30px",
        "height": "30px",
        "border": "none",
        "outline": "none",
        "vertical-align": "middle",
        "background": "url('"+ImageIcon.ComboxNormal+"') no-repeat 100% 100%",
    }
    this.btn.css(css);
    css = {
		//"position": "relative",
    	"position": "absolute",
		"overflow": "hidden",
    	"z-index": "999",
        "width": "184px",
        "height": "201px",
        "display": "none",
        "background": "url('/jikuang/statics/system/images/ui/combox_bg.png') no-repeat 100% 100%",
    }
    this.optionPanel.css(css);
    css = {
        "margin-top": "16px",
        "width": "180px",
        "height": "175px",
		"overflow": "hidden",
		"overflow-y": "auto",
    }
    this.options.css(css);
}
Combox.prototype.setFocusCss = function(){
    var css;
    css = {
        "box-shadow": "0px 0px 3px #22b8de",
    }
    this.element.css(css);
}
Combox.prototype.setBlurCss = function(){
    var css;
    css = {
        "box-shadow": "1px 1px 2px #cccccc",
    }
    this.element.css(css);
}
Combox.prototype.getComboxData = function(typeFlg){
    //下载数据
    var thisObj = this;
    if(typeFlg==Combox.TypeDemindState){
        this.comboxData.push({optionId:Combox.DefaultValue,optionName:"请选择"});
        this.comboxData.push({optionId:State.DemindStateNoTaking,optionName:"未接单"});
        this.comboxData.push({optionId:State.DemindStateInTaking,optionName:"接单中"});
        this.comboxData.push({optionId:State.DemindStateEndReview,optionName:"已审核"});
        this.comboxData.push({optionId:State.DemindStateEndPay,optionName:"已结款"});
    }else if(typeFlg==Combox.TypeVehicleState){
        this.comboxData.push({optionId:Combox.DefaultValue,optionName:"请选择"});
        this.comboxData.push({optionId:State.VehicleStateInTrans,optionName:"运输中"});
        this.comboxData.push({optionId:State.VehicleStateEndTrans,optionName:"待审核"});
        this.comboxData.push({optionId:State.VehicleStateEndReview,optionName:"已审核"});
        this.comboxData.push({optionId:State.VehicleStateEndPay,optionName:"已结款"});
    }else if(typeFlg==Combox.TypeReceiptState){
    	this.comboxData.push({optionId:Combox.DefaultValue,optionName:"请选择"});
        this.comboxData.push({optionId:"A",optionName:"待审核"});
        this.comboxData.push({optionId:"P",optionName:"待支付"});
        this.comboxData.push({optionId:"B",optionName:"已支付"});
        this.comboxData.push({optionId:"R",optionName:"驳回"});
    }else if(typeFlg==Combox.TypePayMan){
        this.comboxData.push({optionId:Combox.DefaultValue,optionName:"请选择"});
        this.comboxData.push({optionId:"A",optionName:"发货方"});
        this.comboxData.push({optionId:"B",optionName:"收货方"});
        this.comboxData.push({optionId:"C",optionName:"垫资方"});
    }else if(typeFlg==Combox.TypePushMessage){
        this.comboxData.push({optionId:Combox.DefaultValue,optionName:"请选择"});
        this.comboxData.push({optionId:"W",optionName:"警告通知"});
        this.comboxData.push({optionId:"N",optionName:"业务通知"});
        this.comboxData.push({optionId:"S",optionName:"平台通知"});
        this.comboxData.push({optionId:"M",optionName:"款项通知"});
    }else if(typeFlg==Combox.TypeMessagePushState){
        this.comboxData.push({optionId:Combox.DefaultValue,optionName:"请选择"});
        this.comboxData.push({optionId:"A",optionName:"未读"});
        this.comboxData.push({optionId:"B",optionName:"已读"});
    }else if(typeFlg==Combox.TypePayType){
        this.comboxData.push({optionId:Combox.DefaultValue,optionName:"请选择"});
        this.comboxData.push({optionId:"Y",optionName:"批量支付"});
        this.comboxData.push({optionId:"N",optionName:"单笔支付"});
    }else if(typeFlg==Combox.TypePayMode){
        this.comboxData.push({optionId:Combox.DefaultValue,optionName:"请选择"});
        this.comboxData.push({optionId:"A",optionName:"银联"});
        this.comboxData.push({optionId:"B",optionName:"余额"});
        this.comboxData.push({optionId:"C",optionName:"支付宝"});
        this.comboxData.push({optionId:"D",optionName:"微信"});
    }else if(typeFlg==Combox.TypeVehicleState){
        this.comboxData.push({optionId:Combox.DefaultValue,optionName:"请选择"});
        this.comboxData.push({optionId:"W",optionName:"未接单"});
		this.comboxData.push({optionId:"O",optionName:"预约中"});
		this.comboxData.push({optionId:"T",optionName:"运输中"});
		this.comboxData.push({optionId:"I",optionName:"待审核"});
		this.comboxData.push({optionId:"E",optionName:"已审核"});
		this.comboxData.push({optionId:"P",optionName:"已结款"});
		this.comboxData.push({optionId:"R",optionName:"已拒绝"});
    }else if(typeFlg==Combox.TypeAccountState){
        this.comboxData.push({optionId:Combox.DefaultValue,optionName:"请选择"});
        this.comboxData.push({optionId:"A",optionName:"正常"});
		this.comboxData.push({optionId:"L",optionName:"锁定"});
		this.comboxData.push({optionId:"I",optionName:"失效"});
    }else if(typeFlg==Combox.TypeBankType){
    	$.ajax({
		    url : "../wallet/getBankInfoList.html",
		    type : 'post',
		    dataType: "json",
		    success : function(data) {
                thisObj.comboxData.push({optionId:Combox.DefaultValue, optionName:"请选择"});
                for(var i=0; i<data.data.length; i++){
                    thisObj.comboxData.push({optionId: data.data[i].bankId, optionName: data.data[i].bankName});
                }
                //设置下拉框
                thisObj.setCombox(thisObj.comboxData);
		    }
		})
		return;
    }else if(typeFlg==Combox.TypeRoleType){
    	$.ajax({
		    url : "/dazong/manager/roleinfo/getRoleInfoList.html",
		    type : 'post',
		    dataType: "json",
		    success : function(data) {
                thisObj.comboxData.push({optionId:Combox.DefaultValue, optionName:"请选择"});
                for(var i=0; i<data.length; i++){
                    thisObj.comboxData.push({optionId: data[i].roleId, optionName: data[i].roleName});
                }
                //设置下拉框
                thisObj.setCombox(thisObj.comboxData);
		    }
		})
		return;
    }else if(typeFlg==Combox.TypeArea){
        this.comboxData.push({optionId:Combox.DefaultValue,optionName:"请选择"});
    }else if(typeFlg==Combox.TypeGoods){
        this.comboxData.push({optionId:Combox.DefaultValue,optionName:"请选择"});
    }else if(typeFlg==Combox.TypeBankList){
    	$.ajax({  
		    url : "../wallet/getBankCardList.html",  
		    type : 'post',
		    dataType: "json",
		    success : function(data) {
		    	thisObj.comboxData.push({optionId:Combox.DefaultValue, optionName:"请选择"});
                for(var i=0; i<data.data.length; i++){
                    thisObj.comboxData.push({optionId: data.data[i].cardId, optionName: data.data[i].bankTypeName});
                }
                //设置下拉框
                thisObj.setCombox(thisObj.comboxData);
		    }  
		});
    }else if(typeFlg==Combox.TypeCertTypeDesc){
        this.comboxData.push({optionId:Combox.DefaultValue,optionName:"请选择"});
        this.comboxData.push({optionId:"P",optionName:"个人认证"});
        this.comboxData.push({optionId:"E",optionName:"企业认证"});
    }
    
    //设置下拉框
    this.setCombox(this.comboxData);
}
Combox.prototype.setCombox = function(comboxData){
    var thisObj = this;
    this.comboxData = comboxData;
    this.optionList = [];
    this.options.html("");
    for(var i=0; i<comboxData.length; i++){
        this.options.append("<li optionValue='"+comboxData[i].optionId+"'>"+comboxData[i].optionName+"</li>");
        css={
            "margin-left": "10px",
            "width": "160px",
            "height": "25px",
            "line-height": "25px",
            "font-size": "14px",
            "vertical-align": "middle",
            "color": "#666666",
            "cursor": "default",
        }
        this.optionList.push(this.options.children("li").eq(i));
        this.optionList[i].css(css);
        this.optionList[i].bind("mouseenter",optionEnter);
        this.optionList[i].bind("mouseleave",optionLeave);
        this.optionList[i].bind("click",optionClick);
        this.optionList[i].attr("sel","false");
    }
    this.setSelect(Combox.DefaultValue);

    //
    function optionEnter(){
        if($(this).attr("sel")=="false"){
            $(this).css("background","#f1f1f1");
        }
    }
    function optionLeave(){
        if($(this).attr("sel")=="false"){
            $(this).css("background","transparent");
        }
    }
    function optionClick(){
        thisObj.setSelect($(this).attr("optionValue"));
        thisObj.closeOptionPanel();
    }
}
Combox.prototype.clearCombox = function(){
    this.setSelect(this.comboxData[0].optionId);
    for(var i=1; i<this.optionList.length; i++){
        this.optionList[i].remove();
    }
    this.optionList = [];
}
Combox.prototype.openOptionPanel = function(){ //打开下拉窗
	this.optionPanel.attr("isOpen","true");
	
	var scrollleft = this.optionPanel.parents('#moreSearchArea').scrollLeft();
    var scrolltop = this.optionPanel.parents('#moreSearchArea').scrollTop();
    this.optionPanel.css('margin-left','-'+scrollleft+'px');
    this.optionPanel.css('margin-top','-'+scrolltop+'px');
    
    //this.optionPanel.show();
    this.optionPanel.css('display','block')
    this.setFocusCss();
    this.btn.css("background","url('"+ImageIcon.ComboxFocus+"') no-repeat 100% 100%");
}
Combox.prototype.closeOptionPanel = function(){ //关闭下拉窗
	this.optionPanel.attr("isOpen","false");
    this.optionPanel.hide();
    this.setBlurCss();
    this.btn.css("background","url('"+ImageIcon.ComboxNormal+"') no-repeat 100% 100%");
}
Combox.prototype.setSelect = function(optionId){ //设置选中
    var oldValue = this.getSelValue();
    for(var i=0; i<this.optionList.length; i++){
        if(this.optionList[i].attr("optionValue")==optionId){
            this.optionList[i].attr("sel","true");
            this.optionList[i].css("color","#ffffff");
            this.optionList[i].css("background","#22B8DE");
            this.combox.attr("comboxValue",optionId);
            this.combox.text(this.optionList[i].text());
        }else{
            this.optionList[i].attr("sel","false");
            this.optionList[i].css("color","#666666");
            this.optionList[i].css("background","transparent");
        }
    }
    //选值发生变化
    if(oldValue != optionId){
    	this.change();
    }
}
Combox.prototype.getSelValue = function(){ //获取选中值
	return this.combox.attr("comboxValue");
}
Combox.prototype.getSelText = function(){ //获取选中文本
	return this.combox.text();
}
Combox.prototype.bindChange = function(handleFun){ //绑定变更事件
	this.changeFun = handleFun;
}
Combox.prototype.change = function(){ //执行变更事件
	if(this.changeFun != null && this.changeFun != undefined){
        this.changeFun();
    }
}
Combox.prototype.bindEvent = function(eventName,handleFun){ //绑定事件
	this.combox.bind(eventName,handleFun);
}
Combox.prototype.unbindEvent = function(eventName,handleFun){ //解除绑定事件
	this.combox.unbind(eventName,handleFun);
}