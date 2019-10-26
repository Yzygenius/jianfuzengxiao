//区域---------------------------------------------------------------------------------
AreaBox.TypeProvince = "TypeProvince";//省
AreaBox.TypeCity = "TypeCity";//市
AreaBox.TypeCounty = "TypeCounty";//县

function AreaBox(targetId,typeFlg){
	//绑定元素
    this.element = $(targetId);
    this.element.append("<div id='province'></div>");
    this.element.append("<div id='city'></div>");
    this.element.append("<div id='county'></div>");
    this.province = this.element.children("#province");
    this.city = this.element.children("#city");
    this.county = this.element.children("#county");
    this.province_CB = new Combox("#province",Combox.TypeArea);
    this.city_CB = new Combox("#city",Combox.TypeArea);
    this.county_CB = new Combox("#county",Combox.TypeArea);
    //设置属性
    this.type = typeFlg;

    this.iniAreaBox();
}
AreaBox.prototype.iniAreaBox = function(){
    //
    this.setCss();
    if(this.type==AreaBox.TypeProvince){
        this.city.remove();
        this.county.remove();
    }
    if(this.type==AreaBox.TypeCity){
        this.county.remove();
    }
    //
    this.getComboxData();
}
AreaBox.prototype.setCss = function(){
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
    this.province.css(css);
    css = {
        "margin-left": "10px",
    	"display": "inline-block",
    }
    this.city.css(css);
    css = {
        "margin-left": "10px",
    	"display": "inline-block",
    }
    this.county.css(css);
}
AreaBox.prototype.getComboxData = function(){
    //下载数据
    var thisObj = this;
    $.ajax({
        url : "/jikuang/common/getAreaList.html",
        type : "post",
        dataType: "json",
        success : function(returnValue){
            //设置下拉框
            thisObj.setArea(returnValue.data);
        },
        error: function(returnValue){
            //new WindowPanel().showAlert(WindowPanel.TypeAlertError,"错误", "区域列表数据获取失败！");
        }
    })
}
AreaBox.prototype.setArea = function(areaData){
    var thisObj = this;
    this.areaData = areaData;
    //初始化省
    this.provinceData=[{optionId:Combox.DefaultValue, optionName:"请选择省/市"}];
    for(var i=0; i<this.areaData.length; i++){
        this.provinceData.push({optionId: this.areaData[i].code, optionName: this.areaData[i].name});
    }
    this.province_CB.setCombox(this.provinceData);
    this.province_CB.bindChange(provinceChange);
    //初始化市
    this.cityData=[{optionId:Combox.DefaultValue, optionName:"请选择市"}];
    this.city_CB.setCombox(this.cityData);
    this.city_CB.bindChange(cityChange);
    //初始化县
    this.countyData=[{optionId:Combox.DefaultValue, optionName:"请选择区/县"}];
    this.county_CB.setCombox(this.countyData);
    this.county_CB.bindChange(countyChange);

    function provinceChange(){
        thisObj.cityData=[{optionId:Combox.DefaultValue, optionName:"请选择市"}];
        thisObj.countyData=[{optionId:Combox.DefaultValue, optionName:"请选择区/县"}];
    
        if(thisObj.province_CB.getSelValue()!=Combox.DefaultValue){
            for(var i=0; i<thisObj.areaData.length; i++){
                if(thisObj.areaData[i].code==thisObj.province_CB.getSelValue()){
                    thisObj.provinceChildData = thisObj.areaData[i].childList;
                    for(var i=0; i<thisObj.provinceChildData.length; i++){
                        thisObj.cityData.push({optionId: thisObj.provinceChildData[i].code, optionName: thisObj.provinceChildData[i].name});
                    }
                    break;
                }
            }
        }
        thisObj.city_CB.setCombox(thisObj.cityData);
        thisObj.city_CB.setSelect(Combox.DefaultValue);
        thisObj.county_CB.setCombox(thisObj.countyData);
        thisObj.county_CB.setSelect(Combox.DefaultValue);
    }

    function cityChange(){
        thisObj.countyData=[{optionId:Combox.DefaultValue, optionName:"请选择区/县"}];
    
        if(thisObj.city_CB.getSelValue()!=Combox.DefaultValue){
            for(var i=0; i<thisObj.provinceChildData.length; i++){
                if(thisObj.provinceChildData[i].code==thisObj.city_CB.getSelValue()){
                    thisObj.cityChildData = thisObj.provinceChildData[i].childList;
                    for(var i=0; i<thisObj.cityChildData.length; i++){
                        thisObj.countyData.push({optionId: thisObj.cityChildData[i].code, optionName: thisObj.cityChildData[i].name});
                    }
                    break;
                }
            }
        }
        
        thisObj.county_CB.setCombox(thisObj.countyData);
        thisObj.county_CB.setSelect(Combox.DefaultValue);
    }

    function countyChange(){
        
    }
}
AreaBox.prototype.setProvinceSelect = function(optionId){ //设置选中
    this.province_CB.setSelect(optionId);
}
AreaBox.prototype.setCitySelect = function(optionId){ //设置选中
    this.city_CB.setSelect(optionId);
}
AreaBox.prototype.setCountySelect = function(optionId){ //设置选中
    this.county_CB.setSelect(optionId);
}
AreaBox.prototype.getProvinceValue = function(){ //获取选中值
	return this.province_CB.getSelValue();
}
AreaBox.prototype.getCityValue = function(){ //获取选中值
	return this.city_CB.getSelValue();
}
AreaBox.prototype.getCountyValue = function(){ //获取选中值
	return this.county_CB.getSelValue();
}
AreaBox.prototype.getProvinceText = function(){ //获取选中值
	return this.province_CB.getSelText();
}
AreaBox.prototype.getCityText = function(){ //获取选中值
	return this.city_CB.getSelText();
}
AreaBox.prototype.getCountyText = function(){ //获取选中值
	return this.county_CB.getSelText();
}