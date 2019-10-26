//输入框
InputText.TypeNormal = "TypeNormal";
InputText.TypeInt = "TypeInt";
InputText.TypeFloor = "TypeFloor";
InputText.TypeTel = "TypeTel";
InputText.TypeCarBoard = "TypeCarBoard";
InputText.TypeMailAdr = "TypeMailAdr";
InputText.TypeChar = "TypeChar";
InputText.TypePassword = "TypePassword";
InputText.TypeUserName = "TypeUserName";//新增用户名登录输入格式限制
InputText.TypeCode = "TypeCode";//发布订单验证码格式限制

InputText.RegTypeInt = new RegExp("[^0-9]","g"); //正整数的非
InputText.RegTypeFloor = new RegExp("[^0-9.]","g"); //正浮点数的非
InputText.RegTypeTel = new RegExp("[^0-9-]","g"); //电话号码的非 
InputText.RegTypeCarBoard = new RegExp("[^京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领a-zA-Z0-9挂学警港澳]","g"); //车牌号
InputText.RegTypeMailAdr = new RegExp("[^@.-_a-zA-Z0-9]","g"); //邮箱
InputText.RegTypeChar = new RegExp("[^@-_a-zA-Z0-9]","g") //数字和字母
InputText.RegTypeCode = new RegExp("[^0-9A-Za-z]","g");
InputText.RegTypeDisplay=new RegExp("[0-9A-Za-z]","g");

InputText.DisTypeLong = "DisTypeLong";
InputText.DisTypeMiddle = "DisTypeMiddle";
InputText.DisTypeShort = "DisTypeShort";

function InputText(targetId,typeFlg,disTypeFlg,disImage,lengthFlg,bitFlg){
	//绑定元素
    this.element = $(targetId);
    this.element.append("<img></img>");
    this.element.append("<input type='text'></input>");
    //this.element.append("<button></button>");
    this.element.append("<div></div>");
    this.img = this.element.children("img");
    this.text = this.element.children("input");
    //this.btn = this.element.children("button");
    this.btn = this.element.children("div");
    //设置属性
    this.type = typeFlg;
    this.disType = disTypeFlg;
    this.length = lengthFlg;
    this.bit = bitFlg;
    this.disImage = disImage;

    this.iniInputText();
}
InputText.prototype.iniInputText = function(){
    var thisObj = this;
    this.setImg(this.disImage);
    //
    this.setCss();
    //绑定事件
    this.text.bind("keyup",checkInput); //keyup事件处理
    this.text.bind("paste",checkInput); //CTR+V事件处理
    this.text.bind("focus",focusText);
    this.btn.bind("click",clearText);
    //检验输入内容
    function checkInput(){
        var input;
        switch(thisObj.type){
            case(InputText.TypeNormal):{
                input = thisObj.getText();
                thisObj.setText(input);
                break;
            }
            case(InputText.TypeInt):{
                input = thisObj.getText().replace(InputText.RegTypeInt,""); //控制输入必须合法
                thisObj.setText(input);
                break;
            }
            case(InputText.TypeFloor):{
                input = thisObj.getText().replace(InputText.RegTypeFloor,""); //控制输入必须合法
                //控制第一个不能输入小数点"."
                if (input.indexOf(".") == 0) {
                    input="";
                }
                //控制只能输入一个小数点"."
                if (input.indexOf('.') != -1 && input.indexOf(".") != input.lastIndexOf(".")) {
                    input=input.substring(0,input.lastIndexOf("."));
                }
                //控制只能输入限定的小数位数
                if (input.indexOf('.') != -1 && input.substring(input.indexOf(".")).length > thisObj.bit+1) {
                    input=input.substring(0,input.length - 1);
                }
                thisObj.setText(input);
                break;
            }
            case(InputText.TypeTel):{
                input = thisObj.getText().replace(InputText.RegTypeTel,""); //控制输入必须合法
                //控制第一位只能输入数字"1"
                if (input.substr(0,1) != "1"){
                	input="";
                }
                //控制第二位只能输入数字"3,4,5,7,8"
                if (input.substr(1,1) != "" && input.substr(1,1) != "3" && input.substr(1,1) != "4" && input.substr(1,1) != "5" && input.substr(1,1) != "7" && input.substr(1,1) != "8"){
                	input="1";
                }
                thisObj.setText(input);
                break;
            }
            case(InputText.TypeUserName):{
                var reg = /^[A-Za-z0-9_]{0,18}$/;   
                input = thisObj.getText();
                if(!reg.test(input)){  
        		  input=input.substring(0,input.length - 1);
        		  thisObj.setText(input); //控制输入必须合法      
                }   
                break;
            }
            case(InputText.TypeCarBoard):{
                input = thisObj.getText().replace(InputText.RegTypeCarBoard,""); //控制输入必须合法
                thisObj.setText(input);
                break;
            }
            case(InputText.TypeMailAdr):{
                input = thisObj.getText().replace(InputText.RegTypeMailAdr,""); //控制输入必须合法
                thisObj.setText(input);
                break;
            }
            case(InputText.TypeChar):{
                input = thisObj.getText().replace(InputText.RegTypeChar,""); //控制输入必须合法
                thisObj.setText(input);
                break;
            }
            case(InputText.TypePassword):{
                input = thisObj.getText();
                var password = thisObj.getPassword().substring(0,input.length); //取当前输入内容长度 重要！（回退时起作用）
                input = input.replace(InputText.RegTypeCode,""); //先替换掉非法字符
                thisObj.setPassword(password + input);
                break;
            }
            case(InputText.TypeCode):{
            	input = thisObj.getText().replace(InputText.RegTypeCode,""); //控制输入必须合法
                thisObj.setText(input);
                break;
            }
        }
        
        if(thisObj.getText()!=""){
            //thisObj.btn.show();
            thisObj.btn.css('display','inline-block');
        }else{
            //thisObj.btn.hide();
        	thisObj.btn.css('display','none');
        }
    }
    //鼠标事件
    function focusText(){
        thisObj.element.attr("isSel","true");
        thisObj.setFocusCss();
        if(thisObj.getText()!=""){
            //thisObj.btn.show();
        	thisObj.btn.css('display','inline-block');
        }
    }
    //清除内容
    function clearText(){
        thisObj.element.attr("password","");
        thisObj.text.val("");
        thisObj.setFocus();
        thisObj.btn.hide();
    }
    //监听
    $(document).bind("mousedown",function(event){
        if(thisObj.element.attr("isSel")=="true"){
            var elementList = thisObj.element[0].getElementsByTagName('*');
            for(var i=0; i<elementList.length; i++){
                if(elementList[i]==event.target){
                    return;
                }
            }
            thisObj.element.attr("isSel","false");
            thisObj.setBlurCss();
            thisObj.btn.hide();
        }
    })
}
InputText.prototype.setFocusCss = function(){
    var css;
    css = {
        "box-shadow": "0px 0px 3px #22b8de",
    }
    this.element.css(css);
}
InputText.prototype.setBlurCss = function(){
    var css;
    css = {
        "box-shadow": "1px 1px 2px #cccccc",
    }
    this.element.css(css);
}
InputText.prototype.setCss = function(){
    var elementWidth;
    switch(this.disType){
        case(InputText.DisTypeLong):{
            elementWidth = 380;
            break;
        }
        case(InputText.DisTypeMiddle):{
            elementWidth = 300;
            break;
        }
        case(InputText.DisTypeShort):{
            elementWidth = 180;
            break;
        }
    }
    //设置样式
    var css;
    css = {
        "width": elementWidth + "px",
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
        "width": (elementWidth-80)+"px",
        "height": "30px",
        "border": "none",
        "outline": "none",
        "display": "inline-block",
        "vertical-align": "middle",
        "background-color": "transparent",
    }
    this.text.css(css);
    css = {
        "margin-left": "5px",
        "width": "20px",
        "height": "20px",
        "border": "none",
        "outline": "none",
        "display": "none",
        "vertical-align": "middle",
        "background": "url('/jikuang/statics/system/images/ui/button_text_clear.png') no-repeat 100% 100%",
    }
    this.btn.css(css);
}
InputText.prototype.setImg = function(disImage){
    this.disImage = disImage;
    this.img.attr("src",disImage);
}
InputText.prototype.setText = function(textStr){ //设置值
    if(textStr.length > this.length){
        textStr = textStr.substring(0,this.length);
    }
    this.text.val(textStr);
}
InputText.prototype.getText = function(){ //获取值
	return this.text.val();
}
InputText.prototype.setPassword = function(password){ //设置值
    password = password.replace(InputText.RegTypeCode,"");
    if(password.length > this.length){
        password = password.substring(0,this.length);
    }
    this.element.attr("password",password);
    this.text.val(password.replace(InputText.RegTypeDisplay,"●"));
}
InputText.prototype.getPassword = function(){ //获取密码
    if(this.element.attr("password") == null || this.element.attr("password") == undefined){
        return "";
    }
	return this.element.attr("password");
}
InputText.prototype.setDisable = function(disableFlg){ //设置不可用
    this.text.attr("disabled",disableFlg);
    if(disableFlg){
        this.setImg(SysFunctions.getTarImg(this.disImage,"g"));
        this.text.css({"color": "#999999"});
        this.element.css({"background": "#f1f1f1"});
    }else{
        this.setImg(SysFunctions.getTarImg(this.disImage,"b"));
        this.text.css({"color": "#666666"});
        this.element.css({"background": "#ffffff"});
    }
}
InputText.prototype.setVisible = function(displayFlg){ //设置是否显示
    if(displayFlg){
        this.element.show();
    }else{
        this.element.hide();
    }
}
InputText.prototype.setFocus = function(){ //设置焦點
    this.text.focus();
}
InputText.prototype.bindEvent = function(eventName,handleFun){ //绑定事件
	this.element.bind(eventName,handleFun);
}
InputText.prototype.unbindEvent = function(eventName,handleFun){ //解除绑定事件
	this.element.unbind(eventName,handleFun);
}