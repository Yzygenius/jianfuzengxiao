//单选框---------------------------------------------------------------------------------
function RadioBox(targetId,radioBoxData){
	//绑定元素
    this.element = $(targetId);
    this.radioBtnList = [];
    for(var i=0; i<radioBoxData.length; i++){
        var option = this.element.children(".option").eq(i);
        option.append("<div id='radioBtn_"+i+"'></div>");
        this.radioBtnList.push(new RadioButton(targetId + " #radioBtn_"+i,radioBoxData[i].value,radioBoxData[i].text));
    }
    //设置属性
    this.targetId = targetId;
    this.radioBoxData = radioBoxData;

    this.iniRadioBox();
}
RadioBox.prototype.iniRadioBox = function(){
    //
    this.setCss();
    //
    this.setRadioBox(this.radioBoxData);
}
RadioBox.prototype.setCss = function(){
    var css;
    css={
        "width": "110px",
        "height": "30px",
    }
    this.element.children(".option").css(css);
}
RadioBox.prototype.setRadioBox = function(radioBoxData){
    var thisObj = this;
    //
    for(var i=0; i<this.radioBtnList.length; i++){
        if(radioBoxData[i].radio==true){
            this.radioBtnList[i].setRadio(true);
        }else{
            this.radioBtnList[i].setRadio(false);
        }
        this.radioBtnList[i].bindEvent("click",radioClick);
    }

    function radioClick(){
        thisObj.setRadioValue($(this).attr("radioValue"));
    }
}
RadioBox.prototype.setRadioValue = function(radioValue){
    var oldValue = this.getRadioValue();
    for(var i=0; i<this.radioBtnList.length; i++){
        if(radioValue==this.radioBtnList[i].getRadioValue()){
            this.radioBtnList[i].setRadio(true);
        }else{
            this.radioBtnList[i].setRadio(false);
        }
    }
    //选值发生变化
    if(oldValue != radioValue){
    	this.change();
    }
}
RadioBox.prototype.getRadioValue = function(){
    for(var i=0; i<this.radioBtnList.length; i++){
        if(this.radioBtnList[i].getRadio()){
            return this.radioBtnList[i].getRadioValue();
        }
    }
}
RadioBox.prototype.setDisable = function(disableValueList){
    var disableData=[];
    for(var i=0; i<disableValueList.length; i++){
        disableData.push(disableValueList[i]);
    }
    for(var i=0; i<this.radioBtnList.length; i++){
        if(disableData.indexOf(this.radioBtnList[i].getRadioValue())>=0){
            this.radioBtnList[i].setDisable(true);
        }else{
            this.radioBtnList[i].setDisable(false);
        }
    }
}
RadioBox.prototype.bindChange = function(changeFun){
    this.changeFun = changeFun;
}
RadioBox.prototype.change = function(){ //执行变更事件
	if(this.changeFun != null && this.changeFun != undefined){
        this.changeFun();
    }
}