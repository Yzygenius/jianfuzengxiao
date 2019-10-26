//日期类型输入框-----------------------------------------------------------------------------------
DateBox.TypeDay = "Day"; //日期
DateBox.TypeTime = "Time"; //时间
DateBox.TypeDayBtnNormal = "1"; //
DateBox.TypeDayBtnEnter = "2"; //
DateBox.TypeDayBtnLeave = "3"; //
DateBox.TypeDayBtnSelect = "4"; //
DateBox.TypeDayBtnToday = "5"; //
DateBox.TypeDayBtnDisable = "0"; //
function DateBox(targetId,typeFlg){
	//绑定元素
    this.element = $(targetId);
    this.element.append("<img></img>");
    this.element.append("<text></text>");
    this.element.append("<button></button>");
    this.element.append("<div></div>");
    this.img = this.element.children("img");
    this.text = this.element.children("text");
    this.btn = this.element.children("button");
    this.datebox = this.element.children("div");
    this.datebox.append("<div id='dateTitle'></div>"); //标题组
    this.title = this.datebox.children("#dateTitle");
    this.title.append("<div id='lastYear'></div>");
    this.title.append("<div id='lastMonth'></div>");
    this.title.append("<text id='dateText'></text>");
    this.title.append("<div id='nextMonth'></div>");
    this.title.append("<div id='nextYear'></div>");
    this.lastYear = new Button(targetId+" #lastYear","/jikuang/statics/api/images/ui/left_double_f.png","",Button.TypeNormal,Button.SizeMini);
    this.lastMonth = new Button(targetId+" #lastMonth","/jikuang/statics/api/images/ui/left_single_f.png","",Button.TypeNormal,Button.SizeMini);
    this.nextMonth = new Button(targetId+" #nextMonth","/jikuang/statics/api/images/ui/right_single_f.png","",Button.TypeNormal,Button.SizeMini);
    this.nextYear = new Button(targetId+" #nextYear","/jikuang/statics/api/images/ui/right_double_f.png","",Button.TypeNormal,Button.SizeMini);
    this.datebox.append("<div id='dayList'></div>"); //日期按钮组
    this.days = this.datebox.children("#dayList");
    this.days.append("<table></table");
    //设置属性
    this.type = typeFlg;
    this.daysBtn=[];

    this.iniCarlendar();
}
DateBox.prototype.iniCarlendar = function(){ //初始化
    var thisObj = this;
    this.datebox.attr("isOpen","false");
    this.img.attr("src",ImageIcon.Rili_F);
    //
    this.setCss();
    //绑定事件
    this.text.bind("click",dateBoxClick);
    this.btn.bind("click",clearClick);
    //标题按钮事件
    this.lastYear.bindEvent("click",titleClick);
    this.lastMonth.bindEvent("click",titleClick);
    this.nextMonth.bindEvent("click",titleClick);
    this.nextYear.bindEvent("click",titleClick);
    function dateBoxClick(){
        if(thisObj.datebox.attr("isOpen")=="true"){
            thisObj.closeDateBox();
        }else{
            thisObj.openDateBox();
        }
    }
    function clearClick(){
        thisObj.setDateText("");
        thisObj.closeDateBox();
    }
    function titleClick(){
        var dateStrings = thisObj.title.children("text").attr("titleDate").split("-");
        tarDate = new Date(dateStrings[0],dateStrings[1]-1,1);
        
        switch($(this).parent().attr("id")){
            case("lastYear"):
                tarDate.setFullYear(tarDate.getFullYear()-1);break;
            case("nextYear"):
                tarDate.setFullYear(tarDate.getFullYear()+1);break;
            case("lastMonth"):
                tarDate.setMonth(tarDate.getMonth()-1);break;
            case("nextMonth"):
                tarDate.setMonth(tarDate.getMonth()+1);break;
        }
        thisObj.setCalendar(tarDate);
    }
    //监听关闭面板 TODO 是否可以放入Open面板時綁定
    $(document).bind("mousedown",function(event){
        if(thisObj.datebox.attr("isOpen")=="true"){
            var elementList = thisObj.element[0].getElementsByTagName('*');
            for(var i=0; i<elementList.length; i++){
                if(elementList[i]==event.target){
                    console.log("點到裡面了");
                    return;
                }
            }
            thisObj.closeDateBox();
        }
    })
}
DateBox.prototype.setFocusCss = function(){
    var css;
    css = {
        //"box-shadow": "0px 0px 3px #22b8de",
    	"border-color": "#fa6d35",
    }
    this.element.css(css);
}
DateBox.prototype.setBlurCss = function(){
    var css;
    css = {
        //"box-shadow": "1px 1px 2px #cccccc",
    	"border-color": "#a9a9a9",
    }
    this.element.css(css);
}
DateBox.prototype.setCss = function(){ //设置样式
    var css;
    css = {
    	"width": "180px",
    	"height": "40px",
    	"vertical-align": "middle",
        "line-height": "40px",
        "border": "1px solid #a9a9a9",
        //"border-radius": "5px",
        //"box-shadow": "1px 1px 2px #cccccc",
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
        "vertical-align": "middle",
        "cursor": "default",
        "readonly": "true",
        "background-color": "transparent",
    }
    this.text.css(css);
    css = {
        "width": "20px",
        "height": "20px",
        "border": "none",
        "outline": "none",
    	"display": "none",
        "vertical-align": "middle",
        "background": "url('/jikuang/statics/api/images/ui/button_text_clear.png') no-repeat 100% 100%",
    }
    this.btn.css(css);
    css = {
		//"position": "relative",
    	"position": "absolute",
    	"z-index": "999",
        "width": "240px",
        "height": "307px",
        "display": "none",
        "background": "url('/jikuang/statics/api/images/ui/datebox_bgf.png') no-repeat 100% 100%",
    }
    this.datebox.css(css);
	css = {
        //"margin-top" : "13px",
        "margin-left" : "5px",
		"width" : "210px",
		"height" : "40px",
        "line-height" : "40px",
        "vertical-align": "middle",
		"padding": "18px 15px 5px",
	}
	this.title.css(css);
    css={
        "color": "#ffffff",
        "font-size": "12px",
        "width": "78px",
        "height": "40px",
        "line-height": "40px",
        "border": "none",
        "outline": "none",
        "display": "inline-block",
        "vertical-align": "middle",
        "text-align": "center",
        "cursor": "default",
        "background-color": "transparent",
        "margin": "0 5px",
    }
    this.title.children("text").css(css);
    css={
        "float": "left",
    }
    this.title.children().css(css);
    css = {
        "margin-top": "45px",
        "width": "226px",
        "padding-left":"14px",
    }
    this.days.css(css);
}
DateBox.prototype.setCalendar = function(dateFlg){ //获取值
    var thisObj = this;
    //生成日期按钮
    this.days.find("tr").remove();
    this.daysBtn=[];
    var css;
    for(var i=0; i<6; i++){
        this.days.children("table").append("<tr></tr>");
        css={
            "height": "30px",
            "line-height": "30px",
        }
        this.days.find("tr").eq(i).css(css);
        for(var j=0; j<7; j++){
            this.days.find("tr").eq(i).append("<td><button id='day"+(i*7+j)+"'></button></td>");
            this.daysBtn.push(this.days.find("button").eq(i*7+j));
            css={
                "width": "30px",
                "height": "30px",
                "line-height": "30px",
                "padding": "0",
                "border": "none",
                "outline": "none",
                "outline": "none",
                "vertical-align": "middle",
                "display": "block",
            }
            this.daysBtn[i*7+j].css(css);
            this.daysBtn[i*7+j].bind("mouseenter",daysEnter);
            this.daysBtn[i*7+j].bind("mouseleave",daysLeave);
            this.daysBtn[i*7+j].bind("click",daysClick);
        }
    }
    function daysEnter(){
        if($(this).attr("today")=="false" && $(this).attr("sel")=="false"){
            thisObj.setBtnStatus($(this),DateBox.TypeDayBtnEnter);
        }
    }
    function daysLeave(){
        if($(this).attr("today")=="false" && $(this).attr("sel")=="false"){
            thisObj.setBtnStatus($(this),DateBox.TypeDayBtnLeave);
        }
    }
    function daysClick(){
        thisObj.closeDateBox();
        thisObj.setDateText($(this).attr("date"));
    }
    //初始化日期按钮属性设置
    for(var i=0; i<this.daysBtn.length; i++){
        this.daysBtn[i].attr("tarmonth","false");
        this.daysBtn[i].attr("today","false");
        this.daysBtn[i].attr("sel","false");
        this.daysBtn[i].attr("date","");
        this.daysBtn[i].attr("disabled",false);
    }
    //初始化所需值
    var tarDate = new Date(dateFlg);
    var weekDay = this.getFirstDayWeekDay(tarDate); //目标月第一天是周几
    var lastDaysCount = this.getDaysCount(new Date(tarDate.getFullYear(),tarDate.getMonth()-1,tarDate.getDate())); //上一个月有多少天
    var setDaysCount=0; //已设置天数
    //设置标题
    var month = tarDate.getMonth()+1;
    if(month<10){
        month = "0" + month;
    }
    this.title.children("text").text(tarDate.getFullYear()+"年"+month+"月");
    this.title.children("text").attr("titleDate",tarDate.getFullYear()+"-"+(tarDate.getMonth()+1));
    //显示上个月信息
    for(var i=0; i<weekDay; i++){
        this.daysBtn[weekDay-i-1].text(lastDaysCount-i);
        //this.daysBtn[weekDay-i-1].attr("date",tarDate.getFullYear()+"-"+tarDate.getMonth()+"-"+(lastDaysCount-i));
        this.daysBtn[weekDay-i-1].attr("disabled",true);
        this.daysBtn[weekDay-i-1].attr("tarmonth","false");
        setDaysCount+=1;
    }
    //显示当月信息
    var nowDaysCount = this.getDaysCount(tarDate);
    for(var i=0; i<nowDaysCount; i++){
        this.daysBtn[i+weekDay].text(i+1);
        var day = i+1;
        if(day<10){
            day = "0" + day;
        }
        this.daysBtn[i+weekDay].attr("date",tarDate.getFullYear()+"-"+month+"-"+day);
        this.daysBtn[i+weekDay].attr("tarmonth","true");
        setDaysCount+=1;
    }
    //显示下个月信息
    var nextDaysCount = this.daysBtn.length - setDaysCount;
    for(var i=0; i<nextDaysCount; i++){
        this.daysBtn[setDaysCount+i].text(i+1);
        //this.daysBtn[setDaysCount+i].attr("date",tarDate.getFullYear()+"-"+(tarDate.getMonth()+2)+"-"+(i+1));
        this.daysBtn[setDaysCount+i].attr("disabled",true);
        this.daysBtn[setDaysCount+i].attr("tarmonth","false");
    }
    //是否为当前月
    if(new Date().getFullYear() == tarDate.getFullYear() && new Date().getMonth() == tarDate.getMonth()){
        this.daysBtn[weekDay+new Date().getDate()-1].attr("today","true");
    }
    //是否被选中
    if(this.getDateText().split("-")[0] == tarDate.getFullYear() && this.getDateText().split("-")[1]-1 == tarDate.getMonth()){
        this.daysBtn[weekDay+parseInt(this.getDateText().split("-")[2])-1].attr("sel","true");
    }
    //设置日期按钮显示
    for(var i=0; i<this.daysBtn.length; i++){
        //是否属于当前月
        if(this.daysBtn[i].attr("tarmonth")=="true"){
            //是否选中
            if(this.daysBtn[i].attr("sel")=="true"){
                this.setBtnStatus(this.daysBtn[i],DateBox.TypeDayBtnSelect);
            }else{
                //是否是今天
                if(this.daysBtn[i].attr("today")=="true"){
                    this.setBtnStatus(this.daysBtn[i],DateBox.TypeDayBtnToday);
                }else{
                    this.setBtnStatus(this.daysBtn[i],DateBox.TypeDayBtnNormal);
                }
            }
        }else{
            this.setBtnStatus(this.daysBtn[i],DateBox.TypeDayBtnDisable);
        }
    }
}
DateBox.prototype.getFirstDayWeekDay = function(dateFlg){ //当月第一天是周几
    var tarDate = new Date(dateFlg);
    tarDate.setDate(1);
    return tarDate.getDay();
}
DateBox.prototype.getDaysCount = function(dateFlg){ //当月有多少天
    var tarDate = new Date(dateFlg);
    var tarMonth = tarDate.getMonth();
    if(tarMonth != 0){
        tarDate.setMonth(tarMonth + 1); //生成实际的月份: 由于curMonth会比实际月份小1, 故需加1
    }
    tarDate.setDate(0); //将日期设置为0, 顺序找到前一天
    return tarDate.getDate();
}
DateBox.prototype.openDateBox = function(){ //展开日历
    //设置日历显示
    if(this.getDateText() == ""){
        this.setCalendar(new Date());
    }else{
        var dateStrings = this.getDateText().split("-");
        this.setCalendar(new Date(dateStrings[0],dateStrings[1]-1,dateStrings[2]));
    }

    this.datebox.attr("isOpen","true");
    //this.datebox.show();
    this.datebox.css('display','block');
    
    var scrollleft = this.datebox.parents('#moreSearchArea').scrollLeft();
    var scrolltop = this.datebox.parents('#moreSearchArea').scrollTop();
    this.datebox.css('margin-left','-'+scrollleft+'px');
    this.datebox.css('margin-top','-'+scrolltop+'px');
    
    this.setFocusCss();
    if(this.getDateText()!=""){
        this.btn.show();
    }
}
DateBox.prototype.closeDateBox = function(){ //关闭日历
    this.datebox.attr("isOpen","false");
    this.datebox.hide();
    this.setBlurCss();
    this.btn.hide();
}
DateBox.prototype.setBtnStatus = function(tarBtn,dayBtnStatusFlg){ //设置按钮样式
    var css;
    switch(dayBtnStatusFlg){
        case(DateBox.TypeDayBtnDisable):
            css={
                "color": "#cccccc",
                "background": "transparent",
            };
            break;
        case(DateBox.TypeDayBtnNormal):
            css={
                "color": "#666666",
                "background": "transparent",
            }
            break;
        case(DateBox.TypeDayBtnEnter):
            css={
                "color": "#333333",
                "background": "url('/jikuang/statics/api/images/ui/datebox_over.png') no-repeat 100% 100%",
            };
            break;
        case(DateBox.TypeDayBtnLeave):
            css={
                "color": "#666666",
                "background": "transparent",
            };
            break;
        case(DateBox.TypeDayBtnSelect):
            css={
                "color": "#ffffff",
                "background": "url('/jikuang/statics/api/images/ui/datebox_sel.png') no-repeat 100% 100%",
            }
            break;
        case(DateBox.TypeDayBtnToday):
            css={
                "color": "#ffffff",
                "background": "url('/jikuang/statics/api/images/ui/datebox_today.png') no-repeat 100% 100%",
            }
            break;
    }
    tarBtn.css(css);
}
DateBox.prototype.setDateText = function(dateStr){ //设置值
    this.text.text(dateStr);
}
DateBox.prototype.getDateText = function(){ //获取值
	return this.text.text();
}