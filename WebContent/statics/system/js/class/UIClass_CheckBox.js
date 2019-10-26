//复选框---------------------------------------------------------------------------------
function CheckBox(targetId,checkBoxData){
	//绑定元素
    this.element = $(targetId);
    this.checkBtnList = [];
    for(var i=0; i<checkBoxData.length; i++){
        var option = this.element.children(".option").eq(i);
        option.append("<div id='checkBtn"+i+"'></div>");
        this.checkBtnList.push(new CheckButton(targetId + " #checkBtn"+i,checkBoxData[i].value,checkBoxData[i].text));
    }
    //设置属性
    this.targetId = targetId;
    this.checkBoxData = checkBoxData;

    this.iniCheckBox();
}
CheckBox.prototype.iniCheckBox = function(){
    //
    this.setCss();
    //
    this.setCheckBox(this.checkBoxData);
}
CheckBox.prototype.setCss = function(){
    var css;
    css={
        "height": "30px",
        "line-height": "24px",
    }
    this.element.children(".option").css(css);
}
CheckBox.prototype.setCheckBox = function(checkBoxData){
    //
    for(var i=0; i<this.checkBtnList.length; i++){
        if(checkBoxData[i].check==true){
            this.checkBtnList[i].setCheck(true);
        }else{
            this.checkBtnList[i].setCheck(false);
        }
    }
}
CheckBox.prototype.setCheckValue = function(checkValueList){
    var checkData=[];
    for(var i=0; i<checkValueList.length; i++){
        checkData.push(checkValueList[i]);
    }
    for(var i=0; i<this.checkBtnList.length; i++){
        if(checkData.indexOf(this.checkBtnList[i].getCheckValue())>=0){
            this.checkBtnList[i].setCheck(true);
        }else{
            this.checkBtnList[i].setCheck(false);
        }
    }
}
CheckBox.prototype.getCheckValue = function(){
    var checkList = [];
    for(var i=0; i<this.checkBtnList.length; i++){
        if(this.checkBtnList[i].getCheck()){
            checkList.push(this.checkBtnList[i].getCheckValue());
        }
    }
    return checkList;
}
CheckBox.prototype.setDisable = function(disableValueList){
    var disableData=[];
    for(var i=0; i<disableValueList.length; i++){
        disableData.push(disableValueList[i]);
    }
    for(var i=0; i<this.checkBtnList.length; i++){
        if(disableData.indexOf(this.checkBtnList[i].getCheckValue())>=0){
            this.checkBtnList[i].setDisable(true);
        }else{
            this.checkBtnList[i].setDisable(false);
        }
    }
}
CheckBox.prototype.bindEvent = function(eventName,eventFun){
    for(var i=0; i<this.checkBtnList.length; i++){
        this.checkBtnList[i].bindEvent(eventName,eventFun);
    }
}
CheckBox.prototype.unbindEvent = function(eventName,eventFun){
    for(var i=0; i<this.checkBtnList.length; i++){
        this.checkBtnList[i].unbindEvent(eventName,eventFun);
    }
}