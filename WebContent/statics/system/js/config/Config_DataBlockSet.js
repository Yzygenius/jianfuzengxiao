//数据块设置---------------------------------------------------------------------------------
//发货方
DataBlockSet.TypeShipIndex = {
    head:[
        {title:"",formatter:function(){
            return "<div style='width:calc(100% - 20px);height:4px;line-height:3px;border:0;background:#22b8de;border-radius:50px;outline:none;margin-left:10px;margin-bottom:10px;'></div>";
        }},
        {title: '厂家照片', field: 'shipImg',formatter:function(row){
            return "<div id=''></div>";
        }},
        {title: '厂家名称', field: 'shipFactory',formatter:function(row){
            return "<div style='margin:10px auto;border:0;border-radius:6px;background:#f1f1f1;'><div id='shipFactory_LB'></div></div>";
        }},
    ],
    contents:[
        {title: '装货地址', field: 'address',formatter:function(row){
            return "<div id='address_TL'></div>";
        }},
        {title: '联系人', field: 'shipName', formatter:function(row){
            return "<div id='shipName_LB'></div>";
        }},
        {title: '联系电话', field: 'telephone', formatter:function(row){
            return "<div id='telephone_LB'></div>";
        }},
    ],
    bottom:[
        {title: '备注', field: 'remark', formatter:function(row){
            return "<div id='remark_TA'></div>";
        }},
        {title: '选择', field: 'chooseShip', formatter:function(row){
        	return "<div class='chooseDiv'><div id='choose_Btn'></div></div>";
        }},
    ],
    doFunction:function(targetId,row){
        //
        shipFactory_LB = new Label(targetId + " #shipFactory_LB", Label.DisTypeMiddle, ImageIcon.Gongchang_G, "");
        address_TL = new TitleLabel(targetId + " #address_TL", TitleLabel.DisTypeMiddle, ImageIcon.Dingwei_B, "","",false);
		shipName_LB = new Label(targetId + " #shipName_LB", Label.DisTypeMiddle, ImageIcon.Touxiang_B, "",false);
        telephone_LB = new Label(targetId + " #telephone_LB", Label.DisTypeMiddle, ImageIcon.Tel_B, "",false);
        remark_TA = new TextArea(targetId + " #remark_TA",TextArea.DisTypeMiddle);
        //
        shipFactory_LB.setContent(row.shipFactory);
        address_TL.setTitle(row.provName+"-"+row.cityName);
        address_TL.setContent(row.address);
        shipName_LB.setContent(row.shipName);
        telephone_LB.setContent(row.telephone);
        remark_TA.setText(row.remark);
        remark_TA.setDisable(true);
    },
    dbClickFun:function(row){
    },
}
//收货方
DataBlockSet.TypeCustIndex = {
    head:[
        {title:"",formatter:function(){
            return "<div style='width:calc(100% - 20px);height:4px;line-height:3px;border:0;background:#22b8de;border-radius:50px;outline:none;margin-left:10px;margin-bottom:10px;'></div>";
        }},
        {title: '厂家照片', field: 'custImg',formatter:function(row){
            return "<div id=''></div>";
        }},
        {title: '厂家名称', field: 'custFactory',formatter:function(row){
            return "<div style='margin:10px auto;border:0;border-radius:6px;background:#f1f1f1;'><div id='custFactory_LB'></div></div>";
        }},
    ],
    contents:[
        {title: '装货地址', field: 'address',formatter:function(row){
            return "<div id='address_TL'></div>";
        }},
        {title: '联系人', field: 'custName', formatter:function(row){
            return "<div id='custName_LB'></div>";
        }},
        {title: '联系电话', field: 'telephone', formatter:function(row){
            return "<div id='telephone_LB'></div>";
        }},
    ],
    bottom:[
        {title: '备注', field: 'remark', formatter:function(row){
            return "<div id='remark_TA'></div>";
        }},
        {title: '选择', field: 'chooseShip', formatter:function(row){
        	return "<div class='chooseDiv'><div id='choose_Btn'></div></div>";
        }},
    ],
    doFunction:function(targetId,row){
        //
        custFactory_LB = new Label(targetId + " #custFactory_LB", Label.DisTypeMiddle, ImageIcon.Gongchang_G, "");
        address_TL = new TitleLabel(targetId + " #address_TL", TitleLabel.DisTypeMiddle, ImageIcon.Dingwei_B, "","",false);
		custName_LB = new Label(targetId + " #custName_LB", Label.DisTypeMiddle, ImageIcon.Touxiang_B, "",false);
        telephone_LB = new Label(targetId + " #telephone_LB", Label.DisTypeMiddle, ImageIcon.Tel_B, "",false);
        remark_TA = new TextArea(targetId + " #remark_TA",TextArea.DisTypeMiddle);
        //
        custFactory_LB.setContent(row.custFactory);
        address_TL.setTitle(row.provName+"-"+row.cityName);
        address_TL.setContent(row.address);
        custName_LB.setContent(row.custName);
        telephone_LB.setContent(row.telephone);
        remark_TA.setText(row.remark);
        remark_TA.setDisable(true);
    },
    dbClickFun:function(row){
    },
}
function DataBlockSet(){
    
}