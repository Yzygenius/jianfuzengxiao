//列表行设置---------------------------------------------------------------------------------
//运输中订单
DataGridItemSet.TypeIntransDemind = {
    head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:0 auto;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:true,formatter:function(row){
            var endDay = row.loadEndtime.split("-");
            var endDate = new Date(endDay[0],endDay[1]-1,endDay[2]);
            var nowDate = new Date();
            var dayDif = (endDate.getTime()-nowDate.getTime())/(1000*60*60*24);
        	if(dayDif<0){
        		return "<div style='text-align: center;'><img src='"+ImageIcon.StatusDelay+"' style='vertical-align:middle;'></img></div>";
        	}else if(dayDif<1){
        		return "<div style='text-align: center;'><img src='"+ImageIcon.StatusWarning+"' style='vertical-align:middle;'></img></div>";
        	}else{
        		return "<div style='text-align: center;'><img src='"+ImageIcon.StatusNormal+"' style='vertical-align:middle;'></img></div>";
        	}
        }},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },
    columns:[
        {title: '订单编号', field: 'demindNum', width:"200px",formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Dingdan_B+
            		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.demindNum+"</span></div>";
        }},
        {title: '收发货信息', field: 'shipCust', width:"300px",formatter:function(row){
            return "<ul style='margin-left:10px;'><li style='text-align: left;line-height:25px;height:25px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_ship.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.shipFactory+"</span></li>"+
                    "<li style='text-align: left;line-height:25px;height:25px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_cust.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.custFactory+"</span></li><ul>";
        }},
        {title: '货物类型', field: 'goodsName', width:"150px",formatter:function(row){
            return "<div style='text-align: left;height:62px;'><img src='"+ImageIcon.Xitong_G+"' style='vertical-align:middle;margin-left:10px;width:18px;'></img>" +
            		"<div style='display:inline-block;vertical-align:middle;margin-left:10px;'><span style='display:block;line-height:20px;'>"+row.parentGoodsName+"</span>" +
            		"<span style='display:block;line-height:20px;'>"+row.goodsName+"</span></div></div>";
        }},
        {title: '货物重量(吨)', field: 'weight', width:"150px",formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Zhongliang_G+
    		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.weight+"</span></div>";
        }},
        {title: '已运重量(吨)', field: 'alreadyWeight', width:"150px",formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Zhongliang_G+
    		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.alreadyWeight+"</span></div>";
        }},
        {title: '运费单价(元)', field: 'freight', width:"150px",formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Yunfei_G+
            		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.freight+"</span></div>";
        }},
        {title: '运输时间', field: 'loadTime', width:"150px",formatter:function(row){
            return "<ul style='margin-left:10px;'><li style='text-align: left;line-height:25px;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_start.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.loadStarttime+"</li>"+
                    "<li style='text-align: left;line-height:25px;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_end.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.loadEndtime+"</li><ul>";
        }},
        {title: '经理人', field: 'carrierNum', width:"100px",formatter:function(row){
            var returnHtml = "<img src='"+ImageIcon.Gerenxinxi_B+"' style='vertical-align:middle;margin-right:10px;width:25px;'></img>";
            if(row.carrierNum>0){
                returnHtml += "<a style='text-decoration:none;color:#ffffff;text-align: center;font-weight:bold;font-size:10px;width:25px;height:25px;line-height:25px;display:inline-block;background:#22b8de;border-radius:100%;'"                
                returnHtml += "href='javascript:void(0);' onclick='new WindowSwitch(WindowSwitch.TypeCarrierList,"+row.demindId+");'>"+ row.carrierNum +"</a>";
            }else{
                returnHtml += "<a style='text-decoration:none;color:#ffffff;text-align: center;font-weight:bold;font-size:10px;width:25px;height:25px;line-height:25px;display:inline-block;background:#aaaaaa;border-radius:100%;cursor:default;'>"+ row.carrierNum +"</a>";
            }
            return returnHtml;
        }},
        {title: '车次', field: 'vehicleNumber', width:"100px",formatter:function(row){
            var returnHtml = "<img src='"+ImageIcon.Huoche_B+"' style='vertical-align:middle;margin-right:10px;width:25px;'></img>";
            if(row.vehicleNumber>0){
                returnHtml += "<a style='text-decoration:none;color:#ffffff;text-align: center;font-weight:bold;font-size:10px;width:25px;height:25px;line-height:25px;display:inline-block;background:#22b8de;border-radius:100%;'"
                returnHtml += "href='javascript:void(0);' onclick='new WindowSwitch(WindowSwitch.TypeVehicleList,["+row.demindId+"]);'>"+ row.vehicleNumber +"</a>";
            }else{
                returnHtml += "<a style='text-decoration:none;color:#ffffff;text-align: center;font-weight:bold;font-size:10px;width:25px;height:25px;line-height:25px;display:inline-block;background:#aaaaaa;border-radius:100%;cursor:default;' href='javascript:;'>"+ row.vehicleNumber +"</a>";
            }
            return returnHtml;
        }},
        {title: '创建时间', field: 'createTime', width:"200px",formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Rili_G+
    		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.createTime+"</span></div>";
        }},
    ],
    itemClickFun:function(row){
    	new WindowSwitch(WindowSwitch.TypeDemindDetail,row.demindId);
    },
}
//已运完订单列表
DataGridItemSet.TypeFinishDemind = {
    head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px auto;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },
    columns:[
        {title: '订单编号', field: 'demindNum', width:"200px",formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Dingdan_B+
            		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.demindNum+"</span></div>";
        }},
        {title: '收发货信息', field: 'shipCust', width:"300px",formatter:function(row){
            return "<ul style='margin-left:10px;'><li style='text-align: left;line-height:25px;height:25px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_ship.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.shipFactory+"</span></li>"+
                    "<li style='text-align: left;line-height:25px;height:25px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_cust.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.custFactory+"</span></li><ul>";
        }},
        {title: '货物类型', field: 'goodsName', width:"150px",formatter:function(row){
        	return "<div style='text-align: left;height:62px;'><img src='"+ImageIcon.Xitong_G+"' style='vertical-align:middle;margin-left:10px;width:18px;'></img>" +
    		"<div style='display:inline-block;vertical-align:middle;margin-left:10px;'><span style='display:block;line-height:20px;'>"+row.parentGoodsName+"</span>" +
    		"<span style='display:block;line-height:20px;'>"+row.goodsName+"</span></div></div>";
        }},
        {title: '实运重量(吨)', field: 'alreadyWeight', width:"150px",formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Zhongliang_G+
    		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.alreadyWeight+"</span></div>";
        }},
        {title: '应付运费(元)', field: 'shouldFreight', width:"150px",formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Yunfei_G+
            		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.shouldFreight+"</span></div>";
        }},
        {title: '已付运费(元)', field: 'alreadyPaidFreight', width:"150px",formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Yunfei_G+
    		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.alreadyPaidFreight+"</span></div>";
        }},
        {title: '运输时间', field: 'loadTime', width:"150px",formatter:function(row){
            return "<ul style='margin-left:10px;'><li style='text-align: left;line-height:25px;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_start.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.loadStarttime+"</li>"+
                    "<li style='text-align: left;line-height:25px;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_end.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.loadEndtime+"</li><ul>";
        }},
        {title: '经理人', field: 'carrierNum', width:"100px",formatter:function(row){
            var returnHtml = "<img src='"+ImageIcon.Gerenxinxi_B+"' style='vertical-align:middle;margin-right:10px;width:25px;'></img>";
            if(row.carrierNum>0){
                returnHtml += "<a style='text-decoration:none;color:#ffffff;text-align: center;font-weight:bold;font-size:10px;width:25px;height:25px;line-height:25px;display:inline-block;background:#22b8de;border-radius:100%;'"                
                returnHtml += "href='javascript:void(0);' onclick='new WindowSwitch(WindowSwitch.TypeCarrierList,"+row.demindId+");'>"+ row.carrierNum +"</a>";
            }else{
                returnHtml += "<a style='text-decoration:none;color:#ffffff;text-align: center;font-weight:bold;font-size:10px;width:25px;height:25px;line-height:25px;display:inline-block;background:#aaaaaa;border-radius:100%;cursor:default;'>"+ row.carrierNum +"</a>";
            }
            return returnHtml;
        }},
        {title: '车次', field: 'vehicleNumber', width:"100px",formatter:function(row){
            var returnHtml = "<img src='"+ImageIcon.Huoche_B+"' style='vertical-align:middle;margin-right:10px;width:25px;'></img>";
            if(row.vehicleNumber>0){
                returnHtml += "<a style='text-decoration:none;color:#ffffff;text-align: center;font-weight:bold;font-size:10px;width:25px;height:25px;line-height:25px;display:inline-block;background:#22b8de;border-radius:100%;'"
                returnHtml += "href='javascript:void(0);' onclick='new WindowSwitch(WindowSwitch.TypeVehicleList,["+row.demindId+"]);'>"+ row.vehicleNumber +"</a>";
            }else{
                returnHtml += "<a style='text-decoration:none;color:#ffffff;text-align: center;font-weight:bold;font-size:10px;width:25px;height:25px;line-height:25px;display:inline-block;background:#aaaaaa;border-radius:100%;cursor:default;' href='javascript:;'>"+ row.vehicleNumber +"</a>";
            }
            return returnHtml;
        }},
        {title: '运完时间', field: 'finishTime', width:"200px",formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Rili_G+
    		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.finishTime+"</span></div>";
        }},
    ],
    itemClickFun:function(row){
    	new WindowSwitch(WindowSwitch.TypeDemindDetail,row.demindId);
    },
}
//已结清订单列表
DataGridItemSet.TypeMoneyFinishDemind = {
    head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px auto;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },
    columns:[
        {title: '订单编号', field: 'demindNum', width:"200px",formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Dingdan_B+
            		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.demindNum+"</span></div>";
        }},
        {title: '收发货信息', field: 'shipCust', width:"300px",formatter:function(row){
            return "<ul style='margin-left:10px;'><li style='text-align: left;line-height:25px;height:25px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_ship.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.shipFactory+"</span></li>"+
                    "<li style='text-align: left;line-height:25px;height:25px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_cust.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.custFactory+"</span></li><ul>";
        }},
        {title: '货物类型', field: 'goodsName', width:"150px",formatter:function(row){
        	return "<div style='text-align: left;height:62px;'><img src='"+ImageIcon.Xitong_G+"' style='vertical-align:middle;margin-left:10px;width:18px;'></img>" +
    		"<div style='display:inline-block;vertical-align:middle;margin-left:10px;'><span style='display:block;line-height:20px;'>"+row.parentGoodsName+"</span>" +
    		"<span style='display:block;line-height:20px;'>"+row.goodsName+"</span></div></div>";
        }},
        {title: '实运重量(吨)', field: 'alreadyWeight', width:"150px",formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Zhongliang_G+
    		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.alreadyWeight+"</span></div>";
        }},
        {title: '实付运费(元)', field: 'alreadyPaidFreight', width:"150px",formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Yunfei_G+
    		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.alreadyPaidFreight+"</span></div>";
        }},
        {title: '运输时间', field: 'loadTime', width:"150px",formatter:function(row){
            return "<ul style='margin-left:10px;'><li style='text-align: left;line-height:25px;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_start.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.loadStarttime+"</li>"+
                    "<li style='text-align: left;line-height:25px;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_end.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.loadEndtime+"</li><ul>";
        }},
        {title: '经理人', field: 'carrierNum', width:"100px",formatter:function(row){
            var returnHtml = "<img src='"+ImageIcon.Gerenxinxi_B+"' style='vertical-align:middle;margin-right:10px;width:25px;'></img>";
            if(row.carrierNum>0){
                returnHtml += "<a style='text-decoration:none;color:#ffffff;text-align: center;font-weight:bold;font-size:10px;width:25px;height:25px;line-height:25px;display:inline-block;background:#22b8de;border-radius:100%;'"                
                returnHtml += "href='javascript:void(0);' onclick='new WindowSwitch(WindowSwitch.TypeCarrierList,"+row.demindId+");'>"+ row.carrierNum +"</a>";
            }else{
                returnHtml += "<a style='text-decoration:none;color:#ffffff;text-align: center;font-weight:bold;font-size:10px;width:25px;height:25px;line-height:25px;display:inline-block;background:#aaaaaa;border-radius:100%;cursor:default;'>"+ row.carrierNum +"</a>";
            }
            return returnHtml;
        }},
        {title: '车次', field: 'vehicleNumber', width:"100px",formatter:function(row){
            var returnHtml = "<img src='"+ImageIcon.Huoche_B+"' style='vertical-align:middle;margin-right:10px;width:25px;'></img>";
            if(row.vehicleNumber>0){
                returnHtml += "<a style='text-decoration:none;color:#ffffff;text-align: center;font-weight:bold;font-size:10px;width:25px;height:25px;line-height:25px;display:inline-block;background:#22b8de;border-radius:100%;'"
                returnHtml += "href='javascript:void(0);' onclick='new WindowSwitch(WindowSwitch.TypeVehicleList,["+row.demindId+"]);'>"+ row.vehicleNumber +"</a>";
            }else{
                returnHtml += "<a style='text-decoration:none;color:#ffffff;text-align: center;font-weight:bold;font-size:10px;width:25px;height:25px;line-height:25px;display:inline-block;background:#aaaaaa;border-radius:100%;cursor:default;' href='javascript:;'>"+ row.vehicleNumber +"</a>";
            }
            return returnHtml;
        }},
        {title: '结清时间', field: 'moneyFinishTime', width:"200px",formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Rili_G+
    		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.moneyFinishTime+"</span></div>";
        }},
    ],
    itemClickFun:function(row){
    	new WindowSwitch(WindowSwitch.TypeDemindDetail,row.demindId);
    },
}
//取消订单列表
DataGridItemSet.TypeDemind = {
    head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px auto;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },
    columns:[
        {title: '订单编号', field: 'demindNum', width:"200px",formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Dingdan_B+
            		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.demindNum+"</span></div>";
        }},
        {title: '收发货信息', field: 'shipCust', width:"300px",formatter:function(row){
            return "<ul style='margin-left:10px;'><li style='text-align: left;line-height:25px;height:25px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_ship.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.shipFactory+"</span></li>"+
                    "<li style='text-align: left;line-height:25px;height:25px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_cust.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.custFactory+"</span></li><ul>";
        }},
        {title: '货物类型', field: 'goodsName', width:"150px",formatter:function(row){
        	return "<div style='text-align: left;height:62px;'><img src='"+ImageIcon.Xitong_G+"' style='vertical-align:middle;margin-left:10px;width:18px;'></img>" +
    		"<div style='display:inline-block;vertical-align:middle;margin-left:10px;'><span style='display:block;line-height:20px;'>"+row.parentGoodsName+"</span>" +
    		"<span style='display:block;line-height:20px;'>"+row.goodsName+"</span></div></div>";
        }},
        {title: '货物重量(吨)', field: 'weight', width:"150px",formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Zhongliang_G+
    		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.weight+"</span></div>";
        }},
        {title: '运费单价(元)', field: 'freight', width:"150px",formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Yunfei_G+
            		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.freight+"</span></div>";
        }},
        {title: '运输时间', field: 'loadTime', width:"150px",formatter:function(row){
            return "<ul style='margin-left:10px;'><li style='text-align: left;line-height:25px;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_start.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.loadStarttime+"</li>"+
                    "<li style='text-align: left;line-height:25px;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_end.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.loadEndtime+"</li><ul>";
        }},
        {title: '取消时间', field: 'cancleTime', width:"200px",formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Rili_G+
    		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.cancleTime+"</span></div>";
        }},
    ],
    itemClickFun:function(row){
    	new WindowSwitch(WindowSwitch.TypeDemindDetail,row.demindId);
    },
}
DataGridItemSet.TypeVehicle = {
    
}
/*发货方管理*/
DataGridItemSet.TypeShipIndex = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: '',width:"60px",visible:false}
    },
    columns:[
        {title: '发货方名称', field: 'shipFactory', width:"350px", visible:true,formatter:function(row){
            return "<div style='text-align: left;padding-left: 10px;height:62px;overflow:hidden;'><img src='"+ImageIcon.Gongchang_B+
            		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.shipFactory+"</span></div>";
        }},
        {title: '发货地址', field: 'address', width:"500px", visible:true,formatter:function(row){
            return "<div style='text-align: left;height:62px;overflow:hidden;'><img src='"+ImageIcon.Dingwei_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.address+"</span></div>";
        }},
        {title: '联系人', field: 'shipName', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Touxiang_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.shipName+"</span></div>";
        }},
        {title: '联系电话', field: 'telephone', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Tel_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.telephone+"</span></div>";
        }},
    ],
    itemClickFun:function(row){
    	//new WindowSwitch(WindowSwitch.TypeEditShip,row.shipId);
    },
}
/*发货方订单记录*/
DataGridItemSet.TypeShipHistory = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },
    columns:[
        {title: '发货方名称', field: 'shipFactory', width:"450px", visible:true,formatter:function(row){
            return "<div style='text-align: left; padding-left:10px;height:62px;overflow:hidden;'><img src='"+ImageIcon.Gongchang_B+
            		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.shipFactory+"</span></div>";
        }},
        {title: '合作状态', field: 'cooperationState', width:"200px", visible:true,formatter:function(row){
            var stateName;
            if(row.cooperationState==State.InCooperation){
                stateName="合作进行中"
            }else{
                stateName="当前无合作"
            }
            return "<div style='text-align: center;'><img src='"+ImageIcon.Zhuangtai_B+
            		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+stateName+"</span></div>";
        }},
        {title: '合作订单数量', field: 'demindCooperationCount', width:"150px", visible:true,formatter:function(row){
        	var returnHtml = "<img src='"+ImageIcon.Dingdan_B+"' style='vertical-align:middle;margin-right:10px;width:25px;'></img>";
                returnHtml += "<a style='text-decoration:none;color:#ffffff;text-align: center;font-weight:bold;font-size:10px;width:25px;height:25px;line-height:25px;display:inline-block;background:#22b8de;border-radius:100%;'"                
                returnHtml += "href='javascript:void(0);' onclick='new WindowSwitch(WindowSwitch.TypeShipCooperateDemind,"+JSON.stringify(row).replace(/"/g, '&quot;')+");'>"+ row.demindCooperationCount +"</a>";
            return returnHtml;
        }}, 
        {title: '合作经理人数量', field: 'carrierCooperationCount', width:"150px", visible:true,formatter:function(row){
        	var returnHtml = "<img src='"+ImageIcon.Gerenxinxi_B+"' style='vertical-align:middle;margin-right:10px;width:25px;'></img>";
            	returnHtml += "<a style='text-decoration:none;color:#ffffff;text-align: center;font-weight:bold;font-size:10px;width:25px;height:25px;line-height:25px;display:inline-block;background:#22b8de;border-radius:100%;'"                
            	returnHtml += "href='javascript:void(0);' onclick='new WindowSwitch(WindowSwitch.TypeShipCooperateCarrierList,"+row.shipId+");'>"+ row.carrierCooperationCount +"</a>";
            return returnHtml;
        }},  
        {title: '合作车次数量', field: 'vehicleCooperationCount', width:"150px", visible:true,formatter:function(row){
        	var returnHtml = "<img src='"+ImageIcon.Huoche_B+"' style='vertical-align:middle;margin-right:10px;width:25px;'></img>";
            	returnHtml += "<a style='text-decoration:none;color:#ffffff;text-align: center;font-weight:bold;font-size:10px;width:25px;height:25px;line-height:25px;display:inline-block;background:#22b8de;border-radius:100%;'"                
            	returnHtml += "href='javascript:void(0);' onclick='new WindowSwitch(WindowSwitch.TypeShipCooperateVehicleList,"+row.shipId+");'>"+ row.vehicleCooperationCount +"</a>";
            return returnHtml;
        }}, 
        {title: '合作订单金额(元)', field: 'amount', width:"250px", visible:true,tip:"只统计审核通过票据总额",formatter:function(row){
            return "<div style='text-align: left; padding-left:10px;height:62px;overflow:hidden;'><img src='"+ImageIcon.Yunfei_G+
    		"' style='vertical-align:middle;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.amount+"</span></div>";
        }},
        {title: '最近订单时间', field: 'releaseTime', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: center;height:62px;overflow:hidden;'><img src='"+ImageIcon.Rili_G+
    		"' style='vertical-align:middle;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.releaseTime+"</span></div>";
        }},
    ],
    doFunction:function(targetId,row){
        var checkCooperationDemind_Btn = new Button(targetId + " #checkCooperationDemind_Btn",ImageIcon.Fangdajing_W,"",Button.TypeImportant,Button.SizeSmall);
        checkCooperationDemind_Btn.bindEvent("click",function(){
            //chooseShip(row);
        });
        //$('.checkBtn').css({'float':'right','margin-right':'10px'})
        $('.checkBtn').css({'display':'inline-block','margin-left':'10px'})
        $('.checkBtn button').css('display','block')
    },
    itemClickFun:function(row){
    	//new WindowSwitch(WindowSwitch.TypeShipCooperateDemind,row);
    },
}
/*收货方管理*/
DataGridItemSet.TypeCustIndex = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },
    columns:[
        {title: '收货方名称', field: 'custFactory', width:"350px", visible:true,formatter:function(row){
            return "<div style='text-align: left;padding-left: 10px;height:62px;overflow:hidden;'><img src='"+ImageIcon.Gongchang_B+
            		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.custFactory+"</span></div>";
        }},
        {title: '收货地址', field: 'address', width:"500px", visible:true,formatter:function(row){
            return "<div style='text-align: left;height:62px;overflow:hidden;'><img src='"+ImageIcon.Dingwei_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.address+"</span></div>";
        }},
        {title: '联系人', field: 'custName', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Touxiang_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.custName+"</span></div>";
        }},
        {title: '联系电话', field: 'telephone', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Tel_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.telephone+"</span></div>";
        }},
    ],
    itemClickFun:function(row){
    	//new WindowSwitch(WindowSwitch.TypeEditCust,row.custId);
    },
}
/*收货方订单记录*/
DataGridItemSet.TypeCustHistory = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },
    columns:[
        {title: '收货方名称', field: 'custFactory', width:"450px", visible:true,formatter:function(row){
            return "<div style='text-align: left;padding-left: 10px;height:62px;overflow:hidden;'><img src='"+ImageIcon.Gongchang_B+
            		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.custFactory+"</span></div>";
        }},
        {title: '合作状态', field: 'cooperationState', width:"200px", visible:true,formatter:function(row){
            var stateName;
            if(row.cooperationState==State.InCooperation){
                stateName="合作进行中"
            }else{
                stateName="当前无合作"
            }
            return "<div style='text-align: center;'><img src='"+ImageIcon.Zhuangtai_B+
            		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+stateName+"</span></div>";
        }},
        {title: '合作订单数量', field: 'demindCooperationCount', width:"150px", visible:true,formatter:function(row){
        	var returnHtml = "<img src='"+ImageIcon.Dingdan_B+"' style='vertical-align:middle;margin-right:10px;width:25px;'></img>";
            	returnHtml += "<a style='text-decoration:none;color:#ffffff;text-align: center;font-weight:bold;font-size:10px;width:25px;height:25px;line-height:25px;display:inline-block;background:#22b8de;border-radius:100%;'"                
            	returnHtml += "href='javascript:void(0);' onclick='new WindowSwitch(WindowSwitch.TypeCustCooperateDemind,"+JSON.stringify(row).replace(/"/g, '&quot;')+");'>"+ row.demindCooperationCount +"</a>";
            return returnHtml;
        }},
        {title: '合作经理人数量', field: 'carrierCooperationCount', width:"150px", visible:true,formatter:function(row){
        	var returnHtml = "<img src='"+ImageIcon.Gerenxinxi_B+"' style='vertical-align:middle;margin-right:10px;width:25px;'></img>";
            	returnHtml += "<a style='text-decoration:none;color:#ffffff;text-align: center;font-weight:bold;font-size:10px;width:25px;height:25px;line-height:25px;display:inline-block;background:#22b8de;border-radius:100%;'"                
            	returnHtml += "href='javascript:void(0);' onclick='new WindowSwitch(WindowSwitch.TypeCustCooperateCarrierList,"+row.custId+");'>"+ row.carrierCooperationCount +"</a>";
            return returnHtml;
        }},
        {title: '合作车次数量', field: 'vehicleCooperationCount', width:"150px", visible:true,formatter:function(row){
        	var returnHtml = "<img src='"+ImageIcon.Huoche_B+"' style='vertical-align:middle;margin-right:10px;width:25px;'></img>";
            	returnHtml += "<a style='text-decoration:none;color:#ffffff;text-align: center;font-weight:bold;font-size:10px;width:25px;height:25px;line-height:25px;display:inline-block;background:#22b8de;border-radius:100%;'"                
            	returnHtml += "href='javascript:void(0);' onclick='new WindowSwitch(WindowSwitch.TypeCustCooperateVehicleList,"+row.custId+");'>"+ row.vehicleCooperationCount +"</a>";
            return returnHtml;
        }},
        {title: '合作订单金额(元)', field: 'amount', width:"250px", visible:true,tip:"只统计审核通过票据总额",formatter:function(row){
        	return "<div style='text-align:left; padding-left:10px;height:62px;overflow:hidden;'><img src='"+ImageIcon.Yunfei_G+
    		"' style='vertical-align:middle;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.amount+"</span></div>";
        }},
        {title: '最近订单时间', field: 'releaseTime', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: center;height:62px;overflow:hidden;'><img src='"+ImageIcon.Rili_G+
    		"' style='vertical-align:middle;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.releaseTime+"</span></div>";
        }},
    ],
    doFunction:function(targetId,row){
        var checkCooperationDemind_Btn = new Button(targetId + " #checkCooperationDemind_Btn",ImageIcon.Fangdajing_W,"",Button.TypeImportant,Button.SizeSmall);
    },
    itemClickFun:function(row){
    	//new WindowSwitch(WindowSwitch.TypeCustCooperateDemind,row);
    },
}
/*消息列表*/
DataGridItemSet.TypePushMessage = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:true,formatter:function(row){
    		if(row.pushState=='A'){
    			return "<div style='text-align: center;line-height:24px;width:40px;background:#f3a1b1;border-radius:6px;display:inline-block;'><span style='color:#ffffff'>未读</span></div>";
    		}else{
    			return "<div style='text-align: center;line-height:24px;width:40px;background:#f1f1f1;border-radius:6px;display:inline-block;'><span style='color:#666666'>已读</span></div>";
    		}
        }},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },
    columns:[
        {title: '消息类型', field: 'pushTypeDesc', width:"150px", visible:true,formatter:function(row){
        	if(row.pushType=='W'){
        		var pushTypeImage = ImageIcon.Lingdang_B;
			}else if(row.pushType=='N'){
				var pushTypeImage = ImageIcon.Fabudingdan_B;
			}else if(row.pushType=='S'){
				var pushTypeImage = ImageIcon.Guanli_B;
			}else if(row.pushType=='M'){
				var pushTypeImage = ImageIcon.Biaoqian_B;
			}
            return "<div style='text-align: center;'><img src='"+pushTypeImage+
            "' style='vertical-align:middle;width:26px'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.pushTypeDesc+"</span></div>";
        }},
        {title: '消息标题', field: 'title', width:"200px", visible:true},
        {title: '消息内容', field: 'content', width:"850px", visible:true,formatter:function(row){
            return "<div style='text-align: left;max-height:60px;line-height:20px;overflow:hidden;'>"+row.content+"</div>";
        }},
        {title: '发送时间', field: 'createTime', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: left;padding-left: 10px;'><img src='"+ImageIcon.Rili_G+
    		"' style='vertical-align:middle;margin-right:10px;width:18px;'></img><span style='vertical-align:middle;'>"+row.createTime+"</span></div>";
        }},
    ],
    itemClickFun:function(row){
    	new WindowSwitch(WindowSwitch.TypePushDetail,row.memberPushId);
    	if(row.pushState=='A'){
    		$(this)[0].headTable.find('#icon span').html('已读')
    		$(this)[0].headTable.find('#icon span').css('color','#666666')
    		$(this)[0].headTable.find('#icon div').css('background','#f1f1f1')
    	}
    },
}
/*付款明细*/
DataGridItemSet.TypePayBill = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },
    columns:[
        {title: '账单流水号', field: 'serialNumber', width:"250px", visible:true},
        {title: '支付类型', field: 'batchpayState', width:"150px", visible:true,formatter:function(row){
        	if(row.batchpayState == 'Y'){return '批量支付'}else if(row.batchpayState == 'N'){return '单笔支付'}
        }},
        {title: '支付方式', field: 'payMode', width:"150px", visible:true,formatter:function(row){
        	if(row.payMode == 'A'){return '银联'}else if(row.payMode == 'B'){return '余额'}else if(row.payMode == 'C'){return '支付宝'}else if(row.payMode == 'D'){return '微信'}
        }},
        {title: '支付金额', field: 'amount', width:"150px", visible:true},
        {title: '支付时间', field: 'createTime', width:"250px", visible:true},
        {title: '第三方流水号', field: 'thirdpayCode', width:"250px", visible:true},
        {title: '备注', field: 'remark', width:"300px", visible:true,formatter:function(row){
            return "<div style='text-align: left;max-height:60px;line-height:20px;overflow:hidden;'>"+row.remark+"</div>";
        }},
    ],
    itemClickFun:function(row){
    	new WindowSwitch(WindowSwitch.TypeBillDetail,row.billId);
    },
}
/*银行卡列表*/
DataGridItemSet.TypeBankCard = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },
    columns:[
        {title: '银行卡号', field: 'bankNo', width:"250px", visible:true},
        {title: '发卡行', field: 'bankTypeName', width:"150px", visible:true},
        {title: '持卡人', field: 'custName', width:"150px", visible:true},
        {title: '备注', field: 'remark', width:"300px", visible:true,formatter:function(row){
            return "<div style='text-align: left;max-height:60px;line-height:20px;overflow:hidden;'>"+row.remark+"</div>";
        }},
    ],
    itemClickFun:function(row){
    	//parent.$('.panel iframe')[0].contentWindow.editBankCard(row);
    	//editBankCard(row.cardId)
    	new WindowSwitch(WindowSwitch.TypeEditBankCard,row.cardId);
    },
}
/*发布订单下选择发货方列表*/
DataGridItemSet.TypeChooseShipList = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px auto;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },	
    columns:[
        {title: '发货方名称', field: 'shipFactory', width:"300px", visible:true,formatter:function(row){
            return "<div style='text-align: left;padding-left: 10px;'><img src='"+ImageIcon.Gongchang_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.shipFactory+"</span></div>";
        }},
        {title: '装货地址', field: 'address', width:"300px", visible:true,formatter:function(row){
            return "<div style='text-align: left;padding-left: 10px;height:62px;overflow:hidden;'><img src='"+ImageIcon.Dingwei_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img>" +
    		"<div style='vertical-align:middle;display:inline-block;'><span style='display:block;line-height:20px;'>"+row.provName+"-"+row.cityName+"</span><span style='display:block;line-height:20px;'>"+row.address+"</span></div></div>";
        }},
        {title: '联系人', field: 'shipName', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;padding-left: 10px;'><img src='"+ImageIcon.Touxiang_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.shipName+"</span></div>";
        }},
        {title: '联系电话', field: 'telephone', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: left;padding-left: 10px;'><img src='"+ImageIcon.Tel_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.telephone+"</span></div>";
        }},
        {title: '备注', field: 'remark', width:"300px", visible:true,formatter:function(row){
            return "<div style='text-align: left;max-height:60px;line-height:20px;overflow:hidden;padding-left: 10px;'>"+row.remark+"</div>";
        }},
        {title: '选择', field: 'chooseShip', width:"80px", visible:true,formatter:function(row){
        	return "<div class='chooseDiv'><div id='choose_Btn'></div></div>"
        }},
    ],
    doFunction:function(targetId,row){
        var choose_Btn = new Button(targetId + " #choose_Btn",ImageIcon.Duigou_W,"",Button.TypeImportant,Button.SizeShort);
        choose_Btn.bindEvent("click",function(){
            chooseShip(row);
        });
        $('.chooseDiv #choose_Btn').css('display','inline-block')
        $('.chooseDiv button').css('display','block')
    },
    itemClickFun:function(row){
    	//new WindowSwitch(WindowSwitch.TypeBillDetail,row.billId);
    },
}
/*发布订单下选择收货方列表*/
DataGridItemSet.TypeChooseCustList = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px auto;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },	
    columns:[
        {title: '收货方名称', field: 'custFactory', width:"300px", visible:true,formatter:function(row){
            return "<div style='text-align: left;padding-left: 10px;'><img src='"+ImageIcon.Gongchang_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.custFactory+"</span></div>";
        }},
        {title: '卸货地址', field: 'address', width:"300px", visible:true,formatter:function(row){
            return "<div style='text-align: left;padding-left: 10px;height:62px;overflow:hidden;'><img src='"+ImageIcon.Dingwei_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img>" +
    		"<div style='vertical-align:middle;display:inline-block;'><span style='display:block;line-height:20px;'>"+row.provName+"-"+row.cityName+"</span><span style='display:block;line-height:20px;'>"+row.address+"</span></div></div>";
        }},
        {title: '联系人', field: 'custName', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;padding-left: 10px;'><img src='"+ImageIcon.Touxiang_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.custName+"</span></div>";
        }},
        {title: '联系电话', field: 'telephone', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: left;padding-left: 10px;'><img src='"+ImageIcon.Tel_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.telephone+"</span></div>";
        }},
        {title: '备注', field: 'remark', width:"300px", visible:true,formatter:function(row){
            return "<div style='text-align: left;max-height:60px;line-height:20px;overflow:hidden;padding-left: 10px;'>"+row.remark+"</div>";
        }},
        {title: '选择', field: 'chooseCust', width:"80px", visible:true,formatter:function(row){
        	return "<div class='chooseDiv'><div id='choose_Btn'></div></div>"
        }},
    ],
    doFunction:function(targetId,row){
        var choose_Btn = new Button(targetId + " #choose_Btn",ImageIcon.Duigou_W,"",Button.TypeImportant,Button.SizeShort);
        choose_Btn.bindEvent("click",function(){
            chooseCust(row);
        });
        $('.chooseDiv #choose_Btn').css('display','inline-block')
        $('.chooseDiv button').css('display','block')
    },
    itemClickFun:function(row){
    	//new WindowSwitch(WindowSwitch.TypeBillDetail,row.billId);
    },
}
//发布订单选择指定经理人列表
DataGridItemSet.TypeCarrierMembersList = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'memberId',text: 'contactName',width:"60px",visible:true}
    },
    columns:[
        {title: '帐号', field: 'username', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Gerenxinxi_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.username+"</span></div>";
        }},
        {title: '注册号码', field: 'mobile', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Tel_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.mobile+"</span></div>";
        }},
        {title: '认证方式', field: 'certTypeDesc', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Renzheng_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.certTypeDesc+"</span></div>";
        }},
        {title: '经理人名称', field: 'certName', width:"250px", visible:true,formatter:function(row){
        	if(row.certType == 'E'){
	            return "<div style='text-align: left;'><img src='"+ImageIcon.Gongchang_B+
	    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.certName+"</span></div>";
        	}
        }},
        {title: '联系人', field: 'contactName', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Touxiang_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.contactName+"</span></div>";
        }},
        {title: '联系电话', field: 'telephone', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Tel_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.telephone+"</span></div>";
        }},
        {title: '所属车辆', field: 'vehicleNumber', width:"150px", visible:true,formatter:function(row){
        	 var returnHtml = "<img src='"+ImageIcon.Huoche_B+"' style='vertical-align:middle;margin-right:10px;width:25px;'></img>";
             if(row.vehicleNumber>0){
                 returnHtml += "<a style='text-decoration:none;color:#ffffff;text-align: center;font-weight:bold;font-size:10px;width:25px;height:25px;line-height:25px;display:inline-block;background:#22b8de;border-radius:100%;'"
                 returnHtml += "href='javascript:void(0);' onclick='new WindowSwitch(WindowSwitch.TypeCarrierManagersVehicleList,"+row.memberId+")'>"+ row.vehicleNumber +"</a>";
             }else{
                 returnHtml += "<a style='text-decoration:none;color:#ffffff;text-align: center;font-weight:bold;font-size:10px;width:25px;height:25px;line-height:25px;display:inline-block;background:#aaaaaa;border-radius:100%;cursor:default;' href='javascript:;'>"+ row.vehicleNumber +"</a>";
             }
             return returnHtml;
        }},
    ],
    itemClickFun:function(row){
    	//new WindowSwitch(WindowSwitch.TypeCarrierManagersDetail,row.demindCarrierId);
    },	
}
/*可修改订单列表*/
DataGridItemSet.TypeDemindCanModified = {
    head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px auto;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },
    columns:[
        {title: '订单编号', field: 'demindNum', width:"200px",formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Dingdan_B+
            		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.demindNum+"</span></div>";
        }},
        {title: '收发货信息', field: 'shipCust', width:"300px",formatter:function(row){    
            return "<ul style='margin-left:10px;'><li style='text-align: left;line-height:25px;height:25px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_ship.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.shipFactory+"</span></li>"+
                    "<li style='text-align: left;line-height:25px;height:25px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_cust.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.custFactory+"</span></li><ul>";
        }},
        {title: '货物类型', field: 'goodsName', width:"150px",formatter:function(row){
        	return "<div style='text-align: left;height:62px;'><img src='"+ImageIcon.Xitong_G+"' style='vertical-align:middle;margin-left:10px;width:18px;'></img>" +
    		"<div style='display:inline-block;vertical-align:middle;margin-left:10px;'><span style='display:block;line-height:20px;'>"+row.parentGoodsName+"</span>" +
    		"<span style='display:block;line-height:20px;'>"+row.goodsName+"</span></div></div>";
        }},
        {title: '货物重量(吨)', field: 'weight', width:"150px",formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Zhongliang_G+
    		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.weight+"</span></div>";
        }},
        {title: '运费(元/吨)', field: 'freight', width:"200px",formatter:function(row){
            return "<div style='text-align: left;padding-left:10px;'><img src='"+ImageIcon.Yunfei_G+
            		"' style='vertical-align:middle;margin-right:10px;width:18px;'></img><span style='vertical-align:middle;'>"+row.freight+"</span></div>";
        }},
        {title: '运输时间', field: 'loadTime', width:"150px",formatter:function(row){
            return "<ul style='margin-left:10px;'><li style='text-align: left;line-height:25px;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_start.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.loadStarttime+"</li>"+
                    "<li style='text-align: left;line-height:25px;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_end.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.loadEndtime+"</li><ul>";
        }},
        {title: '选择', field: 'choose', width:"80px",formatter:function(row){
            return "<div class='chooseDiv'><div id='choose_Btn'></div></div>";
        }},
    ],
    doFunction:function(targetId,row){
        var choose_Btn = new Button(targetId + " #choose_Btn",ImageIcon.Duigou_W,"",Button.TypeImportant,Button.SizeShort);
        choose_Btn.bindEvent("click",function(){
            choosedemind(row);
        });
        $('.chooseDiv #choose_Btn').css('display','inline-block')
        $('.chooseDiv button').css('display','block')
    },
    itemClickFun:function(row){
    	new WindowSwitch(WindowSwitch.TypeDemindDetail,row.demindId);
    },
}
/*合作订单列表*/
DataGridItemSet.TypeCooperateDemind = {
    head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
            "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
            val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },
    columns:[
        {title: '订单编号', field: 'demindNum', width:"200",formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Dingdan_B+
            		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.demindNum+"</span></div>";
        }},
        {title: '订单状态', field: 'stateDesc', width:"150",formatter:function(row){
        	if(row.sts=='P'){
        		var stateName='已取消'
        	}else{
        		var stateName=row.stateDesc
        	}
            return "<div style='text-align: center;'><img src='"+ImageIcon.Zhuangtai_B+
            		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+stateName+"</span></div>";
        }},
        {title: '收发货信息', field: 'shipCust', width:"300px",formatter:function(row){    
            return "<ul><li style='text-align: left;line-height:25px;height:25px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_ship.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.shipFactory+"</span></li>"+
                    "<li style='text-align: left;height:25px;line-height:25px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_cust.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.custFactory+"</span></li><ul>";
        }},
        {title: '货物类型', field: 'goodsName', width:"150px",formatter:function(row){
        	return "<div style='text-align: left;height:62px;'><img src='"+ImageIcon.Xitong_G+"' style='vertical-align:middle;margin-left:10px;width:18px;'></img>" +
    		"<div style='display:inline-block;vertical-align:middle;margin-left:10px;'><span style='display:block;line-height:20px;'>"+row.parentGoodsName+"</span>" +
    		"<span style='display:block;line-height:20px;'>"+row.goodsName+"</span></div></div>";
        }},
        {title: '货物重量', field: 'weight', width:"150px",formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Zhongliang_G+
            		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.weight+"</span></div>";
        }},
        {title: '运费(元)', field: 'shouldFreight', width:"150px",formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Yunfei_G+
            		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.shouldFreight+"</span></div>";
        }},
        {title: '运输时间', field: 'loadTime', width:"150px",formatter:function(row){
            return "<ul><li style='text-align: left;line-height:25px;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_start.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.loadStarttime+"</li>"+
                    "<li style='text-align: left;line-height:25px;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_end.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.loadEndtime+"</li><ul>";
        }},
    ],
    itemClickFun:function(row){
    	new WindowSwitch(WindowSwitch.TypeDemindDetail,row.demindId);
    },
}
//经理人列表  
DataGridItemSet.TypeCarrierList = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },
    columns:[
        {title: '经理人编号', field: 'demindCarrierNum', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Gerenxinxi_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.demindCarrierNum+"</span></div>";
        }},
        {title: '经理人名称', field: 'contactName', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Touxiang_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.contactName+"</span></div>";
        }},
        {title: '联系电话', field: 'telephone', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Tel_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.telephone+"</span></div>";
        }},
        {title: '接单时间', field: 'createTime', width:"250px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Rili_G+
    		"' style='vertical-align:middle;margin-right:10px;width:18px;'></img><span style='vertical-align:middle;'>"+row.createTime+"</span></div>";
        }},
        {title: '承运重量(吨)', field: 'carryWeight', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;padding-left:10px;'><img src='"+ImageIcon.Zhongliang_G+
    		"' style='vertical-align:middle;margin-right:10px;width:18px;'></img><span style='vertical-align:middle;'>"+row.carryWeight+"</span></div>";
        }},
        {title: '实运重量(吨)', field: 'alreadyWeight', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;padding-left:10px;'><img src='"+ImageIcon.Zhongliang_G+
    		"' style='vertical-align:middle;margin-right:10px;width:18px;'></img><span style='vertical-align:middle;'>"+row.alreadyWeight+"</span></div>";
        }},
        {title: '派遣车次', field: 'vehicleNumber', width:"150px", visible:true,formatter:function(row){
        	 var returnHtml = "<img src='"+ImageIcon.Huoche_B+"' style='vertical-align:middle;margin-right:10px;width:25px;'></img>";
             if(row.vehicleNumber>0){
                 returnHtml += "<a style='text-decoration:none;color:#ffffff;text-align: center;font-weight:bold;font-size:10px;width:25px;height:25px;line-height:25px;display:inline-block;background:#22b8de;border-radius:100%;'"
                 returnHtml += "href='javascript:void(0);' onclick='new WindowSwitch(WindowSwitch.TypeCarrierVehicleList,["+JSON.stringify(row).replace(/"/g, '&quot;')+"]);'>"+ row.vehicleNumber +"</a>";
             }else{
                 returnHtml += "<a style='text-decoration:none;color:#ffffff;text-align: center;font-weight:bold;font-size:10px;width:25px;height:25px;line-height:25px;display:inline-block;background:#aaaaaa;border-radius:100%;cursor:default;' href='javascript:;'>"+ row.vehicleNumber +"</a>";
             }
             return returnHtml;
        }},
    ],
    itemClickFun:function(row){
    	new WindowSwitch(WindowSwitch.TypeCarrierDetail,row.demindCarrierId);
    },
}
//合作企业经理人列表  
DataGridItemSet.TypeCarrierManagersList = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },
    columns:[
        {title: '帐号', field: 'username', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Gerenxinxi_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.username+"</span></div>";
        }},
        {title: '注册号码', field: 'mobile', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Tel_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.mobile+"</span></div>";
        }},
        {title: '认证方式', field: 'certTypeDesc', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Renzheng_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.certTypeDesc+"</span></div>";
        }},
        {title: '经理人名称', field: 'certName', width:"250px", visible:true,formatter:function(row){
        	if(row.certType == 'E'){
	            return "<div style='text-align: left;'><img src='"+ImageIcon.Gongchang_B+
	    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.certName+"</span></div>";
        	}
        }},
        {title: '联系人', field: 'contactName', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Touxiang_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.contactName+"</span></div>";
        }},
        {title: '联系电话', field: 'telephone', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Tel_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.telephone+"</span></div>";
        }},
        {title: '所属车辆', field: 'vehicleNumber', width:"150px", visible:true,formatter:function(row){
        	 var returnHtml = "<img src='"+ImageIcon.Huoche_B+"' style='vertical-align:middle;margin-right:10px;width:25px;'></img>";
             if(row.vehicleNumber>0){
                 returnHtml += "<a style='text-decoration:none;color:#ffffff;text-align: center;font-weight:bold;font-size:10px;width:25px;height:25px;line-height:25px;display:inline-block;background:#22b8de;border-radius:100%;'"
                 returnHtml += "href='javascript:void(0);' onclick='new WindowSwitch(WindowSwitch.TypeCarrierManagersVehicleList,"+row.memberId+")'>"+ row.vehicleNumber +"</a>";
             }else{
                 returnHtml += "<a style='text-decoration:none;color:#ffffff;text-align: center;font-weight:bold;font-size:10px;width:25px;height:25px;line-height:25px;display:inline-block;background:#aaaaaa;border-radius:100%;cursor:default;' href='javascript:;'>"+ row.vehicleNumber +"</a>";
             }
             return returnHtml;
        }},
    ],
    itemClickFun:function(row){
    	//new WindowSwitch(WindowSwitch.TypeCarrierManagersDetail,row.demindCarrierId);
    },
}
//合作企业经理人车辆列表
DataGridItemSet.TypeCarrierManagersVehicleList = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },
    columns:[
        {title: '帐号', field: 'username', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Huoche_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.username+"</span></div>";
        }},
        {title: '注册号码', field: 'mobile', width:"180px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Tel_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.mobile+"</span></div>";
        }},
        {title: '车牌号', field: 'plateNumber', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Chepai_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.plateNumber+"</span></div>";
        }},
        {title: '联系人', field: 'contactName', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;padding-left:10px;'><img src='"+ImageIcon.Touxiang_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.contactName+"</span></div>";
        }},
        {title: '联系电话', field: 'telephone', width:"180px", visible:true,formatter:function(row){
            return "<div style='text-align: center;padding-left:10px;'><img src='"+ImageIcon.Tel_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.telephone+"</span></div>";
        }},
        {title: '车辆照片', field: 'vehiclephotoThumb', width:"100px", visible:true,formatter:function(row){
        	return "<div class='checkVehicleImage'><div id='checkVehicleImage_Btn'></div></div>"
        }},
    ],
    doFunction:function(targetId,row){
        var checkVehicleImage_Btn = new Button(targetId + " #checkVehicleImage_Btn",ImageIcon.Fangdajing_W,"",Button.TypeImportant,Button.SizeShort);
        checkVehicleImage_Btn.bindEvent("click",function(){
        	checkImage(row.vehiclephotoThumb)
        });
        $('.checkVehicleImage #checkVehicleImage_Btn').css('display','inline-block')
        $('.checkVehicleImage button').css('display','block')
    },
    itemClickFun:function(row){
    	//new WindowSwitch(WindowSwitch.TypeVehicleDetail,row.demindVehicleId);
    },
}
//合作订单经理人列表  
DataGridItemSet.TypeCooperateCarrierList = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },
    columns:[
        {title: '经理人编号', field: 'demindCarrierNum', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Gerenxinxi_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.demindCarrierNum+"</span></div>";
        }},
        {title: '经理人名称', field: 'contactName', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;padding-left:10px;'><img src='"+ImageIcon.Touxiang_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.contactName+"</span></div>";
        }},
        {title: '联系电话', field: 'telephone', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Tel_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.telephone+"</span></div>";
        }},
    ],
    itemClickFun:function(row){
    	//new WindowSwitch(WindowSwitch.TypeCarrierDetail,row.demindCarrierId);
    },
}
//车次列表  
DataGridItemSet.TypeVehicleList = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },
    columns:[
        {title: '车次编号', field: 'demindVehicleNum', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Huoche_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.demindVehicleNum+"</span></div>";
        }},
        {title: '车牌号', field: 'plateNumber', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Chepai_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.plateNumber+"</span></div>";
        }},
        {title: '车次状态', field: 'stateDesc', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Zhuangtai_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.stateDesc+"</span></div>";
        }},
        {title: '原发重量(吨)', field: 'primaryWeight', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;padding-left:10px;'><img src='"+ImageIcon.Zhongliang_G+
    		"' style='vertical-align:middle;margin-right:10px;width:18px;'></img><span style='vertical-align:middle;'>"+row.primaryWeight+"</span></div>";
        }},
        {title: '卸货重量(吨)', field: 'weight', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;padding-left:10px;'><img src='"+ImageIcon.Zhongliang_G+
    		"' style='vertical-align:middle;margin-right:10px;width:18px;'></img><span style='vertical-align:middle;'>"+row.weight+"</span></div>";
        }},
        {title: '运费(元)', field: 'sumFreight', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;padding-left:10px;'><img src='"+ImageIcon.Yunfei_G+
    		"' style='vertical-align:middle;margin-right:10px;width:18px;'></img><span style='vertical-align:middle;'>"+row.sumFreight+"</span></div>";
        }},
        {title: '所属经理人', field: 'contactName', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Gerenxinxi_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.contactName+"</span></div>";
        }},
        {title: '运输票据', field: 'receipt', width:"80px", visible:true,formatter:function(row){
        	return "<div class='chooseDiv'><div id='choose_Btn' style='display:inline-block;'></div></div>"
        }},
    ],
    doFunction:function(targetId,row){
        var choose_Btn = new Button(targetId + " #choose_Btn",ImageIcon.Fangdajing_W,"",Button.TypeImportant,Button.SizeShort);
        choose_Btn.bindEvent("click",function(){
        	if(row.auditState=='A'){
        		var data = {'receiptId': row.receiptId, 'auditState': row.auditState};
            	new WindowSwitch(WindowSwitch.TypeReceiptAuditDetail, data);
        	}else if(row.auditState=='P'){
        		new WindowSwitch(WindowSwitch.TypeReceiptPayDetail,row.receiptId);
        	}else if(row.auditState=='B'){
        		new WindowSwitch(WindowSwitch.TypeReceiptDetail,row.receiptId);
        	}else{
        		new WindowSwitch(WindowSwitch.TypeReceiptDetail,row.receiptId)
        	}
        	//new WindowSwitch(WindowSwitch.TypeReceiptDetail,[row.receiptId])
        });
        if(row.state=='O' || row.state=='W' || row.state=='R' || row.state=='T' || row.weight==0){
        	choose_Btn.setDisable(true)
        }
    },
    itemClickFun:function(row){
    	new WindowSwitch(WindowSwitch.TypeVehicleDetail,row.demindVehicleId);
    },
}
//合作订单车辆列表
DataGridItemSet.TypeCooperateVehicleList = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },
    columns:[
        {title: '车牌号', field: 'plateNumber', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Chepai_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.plateNumber+"</span></div>";
        }},
        {title: '车辆类型', field: 'vehicleSize', width:"150px", visible:true,formatter:function(row){
        	var vehicleSizeName;
        	if(row.vehicleSize=='1'){
        		vehicleSizeName='微型货车'
        	}else if(row.vehicleSize=='2'){
        		vehicleSizeName='轻型货车'
        	}else if(row.vehicleSize=='3'){
        		vehicleSizeName='中型货车'
        	}else if(row.vehicleSize=='4'){
        		vehicleSizeName='重型货车'
        	}
            return "<div style='text-align: left;padding-left:10px;'><img src='"+ImageIcon.Yunshu_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+vehicleSizeName+"</span></div>";
        }},
        {title: '联系人', field: 'contactName', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;padding-left:10px;'><img src='"+ImageIcon.Touxiang_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.contactName+"</span></div>";
        }},
        {title: '联系电话', field: 'telephone', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;padding-left:10px;'><img src='"+ImageIcon.Tel_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.telephone+"</span></div>";
        }},
        {title: '车辆类型', field: 'vehicleType', width:"80px", visible:true,formatter:function(row){
        	return "<div class='checkVehicleType'><div id='checkVehicleType_Btn'></div></div>"
        }},
    ],
    doFunction:function(targetId,row){
        var checkVehicleType_Btn = new Button(targetId + " #checkVehicleType_Btn",ImageIcon.Fangdajing_W,"",Button.TypeImportant,Button.SizeShort);
        checkVehicleType_Btn.bindEvent("click",function(){
        	new WindowSwitch(WindowSwitch.TypeVehicleModel,row.memberId);
        });
        $('.checkVehicleType #checkVehicleType_Btn').css('display','inline-block')
        $('.checkVehicleType button').css('display','block')
    },
    itemClickFun:function(row){
    	//new WindowSwitch(WindowSwitch.TypeVehicleDetail,row.demindVehicleId);
    },
}
/*订单统计选择发货方*/
DataGridItemSet.TypeStatisticsShipPage = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'shipId',width:"60px",visible:true}
    },
    columns:[
        {title: '发货方名称', field: 'shipFactory', width:"350px", visible:true,formatter:function(row){
            return "<div style='text-align: left;padding-left: 10px;'><img src='"+ImageIcon.Gongchang_B+
            		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.shipFactory+"</span></div>";
        }},
        {title: '发货地址', field: 'address', width:"500px", visible:true,formatter:function(row){
            return "<div style='text-align: left;height:62px;overflow:hidden;'><img src='"+ImageIcon.Dingwei_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.originProvinceName + row.originCityName + row.originAddr+"</span></div>";
        }},
        {title: '联系人', field: 'shipName', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Touxiang_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.shipName+"</span></div>";
        }},
        {title: '联系电话', field: 'telephone', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Tel_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.shipTelephone+"</span></div>";
        }},
    ],
    itemClickFun:function(row){
    	//new WindowSwitch(WindowSwitch.TypeEditShip,row.shipId);
    },
}
/*订单统计选择收货方*/
DataGridItemSet.TypeStatisticsCustPage = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'custId',width:"60px",visible:true}
    },
    columns:[
        {title: '收货方名称', field: 'custFactory', width:"350px", visible:true,formatter:function(row){
            return "<div style='text-align: left;padding-left: 10px;'><img src='"+ImageIcon.Gongchang_B+
            		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.custFactory+"</span></div>";
        }},
        {title: '收货地址', field: 'address', width:"500px", visible:true,formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Dingwei_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.custProvName + row.custCityName + row.destAddr+"</span></div>";
        }},
        {title: '联系人', field: 'custName', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Touxiang_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.custName+"</span></div>";
        }},
        {title: '联系电话', field: 'telephone', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Tel_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.custTel+"</span></div>";
        }},
    ],
    itemClickFun:function(row){
    	//new WindowSwitch(WindowSwitch.TypeEditCust,row.custId);
    },
}
/*票据列表*/
DataGridItemSet.TypeReceiptDemindList = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },
    columns:[
        {title: '票据编号', field: 'demindReceiptNum', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Piao_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.demindReceiptNum+"</span></div>";
        }},
        {title: '车牌号', field: 'plateNumber', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Chepai_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.plateNumber+"</span></div>";
        }},
        {title: '票据状态', field: 'auditStateDesc', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Zhuangtai_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.auditStateDesc+"</span></div>";
        }},
        {title: '运费金额(元)', field: 'sumFreight', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Yunfei_G+
    		"' style='vertical-align:middle;margin-right:10px;width:18px;'></img><span style='vertical-align:middle;'>"+row.sumFreight+"</span></div>";
        }},
        {title: '原发信息', field: 'shipInfo', width:"250px",formatter:function(row){
            return "<ul style='margin-left:10px;'><li style='text-align: left;line-height:25px;height:25px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;width:18px;' src='"+ImageIcon.Rili_G+"'></img><span style='vertical-align:middle;line-height:18px;'>"+row.primaryTime+"</span></li>"+
                    "<li style='text-align: left;line-height:25px;height:25px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;width:18px;' src='"+ImageIcon.Zhongliang_G+"'></img><span style='vertical-align:middle;line-height:18px;'>"+row.primaryWeight+"</span></li><ul>";
        }},
        {title: '卸货信息', field: 'custInfo', width:"250px",formatter:function(row){
            return "<ul style='margin-left:10px;'><li style='text-align: left;line-height:25px;height:25px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;width:18px;' src='"+ImageIcon.Rili_G+"'></img><span style='vertical-align:middle;line-height:18px;'>"+row.arrivalTime+"</span></li>"+
                    "<li style='text-align: left;line-height:25px;height:25px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;width:18px;' src='"+ImageIcon.Zhongliang_G+"'></img><span style='vertical-align:middle;line-height:18px;'>"+row.weight+"</span></li><ul>";
        }},
    ],
    itemClickFun:function(row){
    	if(row.auditState=='A'){
    		var data = {'receiptId': row.receiptId, 'auditState': row.auditState};
        	new WindowSwitch(WindowSwitch.TypeReceiptAuditDetail, data);
    	}else if(row.auditState=='P'){
    		new WindowSwitch(WindowSwitch.TypeReceiptPayDetail,row.receiptId);
    	}else if(row.auditState=='B'){
    		new WindowSwitch(WindowSwitch.TypeReceiptDetail,row.receiptId);
    	}
    	//new WindowSwitch(WindowSwitch.TypeReceiptDetail,row.receiptId);
    },
}

/*票据审核*/
DataGridItemSet.TypeReceiptAudit = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },
    columns:[
        {title: '票据编号', field: 'demindReceiptNum', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Piao_B+
            		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.demindReceiptNum+"</span></div>";
        }},
        {title: '订单编号', field: 'demindNum', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Dingdan_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.demindNum+"</span></div>";
        }},
        {title: '车牌号', field: 'plateNumber', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Chepai_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.plateNumber+"</span></div>";
        }},
        {title: '收发货信息', field: 'shipCust', width:"300px",formatter:function(row){
            return "<ul style='margin-left:10px;'><li style='text-align: left;line-height:25px;height:25px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_ship.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.shipFactory+"</span></li>"+
                    "<li style='text-align: left;line-height:25px;height:25px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_cust.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.custFactory+"</span></li><ul>";
        }},
        {title: '货物类型', field: 'goodsName', width:"150px", visible:true,formatter:function(row){
        	return "<div style='text-align: left;height:62px;'><img src='"+ImageIcon.Xitong_G+"' style='vertical-align:middle;margin-left:10px;width:18px;'></img>" +
    		"<div style='display:inline-block;vertical-align:middle;margin-left:10px;'><span style='display:block;line-height:20px;'>"+row.parentGoodsName+"</span>" +
    		"<span style='display:block;line-height:20px;'>"+row.goodsName+"</span></div></div>";
        }},
        {title: '原发重量(吨)', field: 'primaryWeight', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;height:62px;'><img src='"+ImageIcon.Zhongliang_G+
    		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.primaryWeight+"</span></div>";
        }},
        {title: '卸货重量(吨)', field: 'weight', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;height:62px;'><img src='"+ImageIcon.Zhongliang_G+
    		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.weight+"</span></div>";
        }},
        {title: '提交时间', field: 'applyTime', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: left;height:62px;'><img src='"+ImageIcon.Rili_G+
    		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.applyTime+"</span></div>";
        }},
    ],
    itemClickFun:function(row){
    	var data = {'receiptId': row.receiptId, 'auditState': row.auditState};
    	new WindowSwitch(WindowSwitch.TypeReceiptAuditDetail, data);
    },
}
/*票据支付*/
DataGridItemSet.TypeReceiptPay = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'receiptId',width:"60px",visible:true}
    },
    columns:[
        {title: '票据编号', field: 'demindReceiptNum', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Piao_B+
            		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.demindReceiptNum+"</span></div>";
        }},
        {title: '订单编号', field: 'demindNum', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Dingdan_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.demindNum+"</span></div>";
        }},
        {title: '车牌号', field: 'plateNumber', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;height:62px;'><img src='"+ImageIcon.Chepai_B+
    		"' style='vertical-align:middle;margin-left:10px;width:25px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.plateNumber+"</span></div>";
        }},
        {title: '收发货信息', field: 'shipCust', width:"300px",formatter:function(row){
            return "<ul style='margin-left:10px;'><li style='text-align: left;line-height:25px;height:25px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_ship.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.shipFactory+"</span></li>"+
                    "<li style='text-align: left;line-height:25px;height:25px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_cust.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.custFactory+"</span></li><ul>";
        }},
        {title: '货物类型', field: 'goodsName', width:"150px", visible:true,formatter:function(row){
        	return "<div style='text-align: left;height:62px;'><img src='"+ImageIcon.Xitong_G+"' style='vertical-align:middle;margin-left:10px;width:18px;'></img>" +
    		"<div style='display:inline-block;vertical-align:middle;margin-left:10px;'><span style='display:block;line-height:20px;'>"+row.parentGoodsName+"</span>" +
    		"<span style='display:block;line-height:20px;'>"+row.goodsName+"</span></div></div>";
        }},
        {title: '卸货重量(吨)', field: 'weight', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;height:62px;'><img src='"+ImageIcon.Zhongliang_G+
    		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.weight+"</span></div>";
        }},
        {title: '运费金额(元)', field: 'sumFreight', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;height:62px;'><img src='"+ImageIcon.Yunfei_G+
    		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.sumFreight+"</span></div>";
        }},
        {title: '审核时间', field: 'auditTime', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: left;height:62px;'><img src='"+ImageIcon.Rili_G+
    		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.auditTime+"</span></div>";
        }},
    ],
    itemClickFun:function(row){
    	new WindowSwitch(WindowSwitch.TypeReceiptPayDetail,row.receiptId);
    },
}
/*历史票据*/
DataGridItemSet.TypeReceiptHistory = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },
    columns:[
        {title: '票据编号', field: 'demindReceiptNum', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Piao_B+
            		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.demindReceiptNum+"</span></div>";
        }},
        {title: '订单编号', field: 'demindNum', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Dingdan_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.demindNum+"</span></div>";
        }},
        {title: '车牌号', field: 'plateNumber', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Chepai_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.plateNumber+"</span></div>";
        }},
        {title: '收发货信息', field: 'shipCust', width:"300px",formatter:function(row){
            return "<ul style='margin-left:10px;'><li style='text-align: left;line-height:25px;height:25px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_ship.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.shipFactory+"</span></li>"+
                    "<li style='text-align: left;line-height:25px;height:25px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_cust.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.custFactory+"</span></li><ul>";
        }},
        {title: '货物类型', field: 'goodsName', width:"150px", visible:true,formatter:function(row){
        	return "<div style='text-align: left;height:62px;'><img src='"+ImageIcon.Xitong_G+"' style='vertical-align:middle;margin-left:10px;width:18px;'></img>" +
    		"<div style='display:inline-block;vertical-align:middle;margin-left:10px;'><span style='display:block;line-height:20px;'>"+row.parentGoodsName+"</span>" +
    		"<span style='display:block;line-height:20px;'>"+row.goodsName+"</span></div></div>";
        }},
        {title: '运费金额(元)', field: 'sumFreight', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Yunfei_G+
            		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.sumFreight+"</span></div>";
        }},
        {title: '原发重量(吨)', field: 'primaryWeight', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Zhongliang_G+
            		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.primaryWeight+"</span></div>";
        }},
        {title: '卸货重量(吨)', field: 'weight', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Zhongliang_G+
            		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.weight+"</span></div>";
        }},
        {title: '支付时间', field: 'payTime', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: left;'><img src='"+ImageIcon.Rili_G+
            		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.payTime+"</span></div>";
        }},
    ],
    itemClickFun:function(row){
    	new WindowSwitch(WindowSwitch.TypeReceiptDetail,row.receiptId);
    },
}
/*驳回票据*/
DataGridItemSet.TypeReceiptReject = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },
    columns:[
        {title: '票据编号', field: 'demindReceiptNum', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Piao_B+
            		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.demindReceiptNum+"</span></div>";
        }},
        {title: '订单编号', field: 'demindNum', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Dingdan_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.demindNum+"</span></div>";
        }},
        {title: '车牌号', field: 'plateNumber', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Chepai_B+
    		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.plateNumber+"</span></div>";
        }},
        {title: '收发货信息', field: 'shipCust', width:"300px",formatter:function(row){
            return "<ul style='margin-left:10px;'><li style='text-align: left;line-height:25px;height:25px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_ship.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.shipFactory+"</span></li>"+
                    "<li style='text-align: left;line-height:25px;height:25px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_cust.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.custFactory+"</span></li><ul>";
        }},
        {title: '货物类型', field: 'goodsName', width:"150px", visible:true,formatter:function(row){
        	return "<div style='text-align: left;height:62px;'><img src='"+ImageIcon.Xitong_G+"' style='vertical-align:middle;margin-left:10px;width:18px;'></img>" +
    		"<div style='display:inline-block;vertical-align:middle;margin-left:10px;'><span style='display:block;line-height:20px;'>"+row.parentGoodsName+"</span>" +
    		"<span style='display:block;line-height:20px;'>"+row.goodsName+"</span></div></div>";
        }},
        {title: '原发重量(吨)', field: 'primaryWeight', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;height:62px;'><img src='"+ImageIcon.Zhongliang_G+
    		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.primaryWeight+"</span></div>";
        }},
        {title: '卸货重量(吨)', field: 'weight', width:"150px", visible:true,formatter:function(row){
            return "<div style='text-align: left;height:62px;'><img src='"+ImageIcon.Zhongliang_G+
    		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.weight+"</span></div>";
        }},
        {title: '审核时间', field: 'auditTime', width:"200px", visible:true,formatter:function(row){
            return "<div style='text-align: left;height:62px;'><img src='"+ImageIcon.Rili_G+
    		"' style='vertical-align:middle;margin-left:10px;width:18px;'></img><span style='vertical-align:middle;margin-left:10px;'>"+row.auditTime+"</span></div>";
        }},
    ],
    itemClickFun:function(row){
    	var data = {'receiptId': row.receiptId, 'auditState': row.auditState};
    	new WindowSwitch(WindowSwitch.TypeReceiptAuditDetail, data);
    },
}
/*支付详情*/
DataGridItemSet.TypeReceiptBill = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'demindNum',width:"60px",visible:false}
    },
    columns:[
        {title: '票据编号', field: 'demindReceiptNum', width:"250px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><img src='"+ImageIcon.Piao_B+
            		"' style='vertical-align:middle;margin-right:10px;width:25px;'></img><span style='vertical-align:middle;'>"+row.demindReceiptNum+"</span></div>";
        }},
        {title: '订单编号', field: 'demindNum', width:"250px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><span style='vertical-align:middle;'>"+row.demindNum+"</span>" +
            "<div class='chooseDiv'><div id='choose_Btn'></div></div></div>"
    		//"<a style='text-decoration:none;color:#ffffff;width:40px;height:40px;line-height:40px;display:inline-block;margin:-7px auto;margin-left:5px;background:#22b8de;border-radius:5px;' href='javascript:new WindowSwitch(WindowSwitch.TypeDemindDetail,["+row.demindId+"])'><img style='width:25px;vertical-align:middle;' src='/dazong/statics/manager/image/icon/fangdajing_w.png'></a></div>";
        }},
        {title: '车牌号', field: 'plateNumber', width:"200px", visible:true},
        {title: '收发货信息', field: 'shipCust', width:"350px", visible:true,formatter:function(row){
            return "<ul><li style='text-align: left;height:25px;line-height:25px;padding-left: 20px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_ship.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.shipFactory+"</span></li>"+
                    "<li style='text-align: left;height:25px;line-height:25px;padding-left: 20px;overflow:hidden;'><img style='vertical-align:middle;margin-right:5px;' src='/dazong/statics/manager/image/ui/icon_cust.png'></img><span style='vertical-align:middle;line-height:18px;'>"+row.custFactory+"</span></li><ul>";
        }},
        {title: '货物类型', field: 'goodsName', width:"250px", visible:true,formatter:function(row){
        	return "<div style='text-align: left;height:62px;'><img src='"+ImageIcon.Xitong_G+"' style='vertical-align:middle;margin-left:10px;width:18px;'></img>" +
    		"<div style='display:inline-block;vertical-align:middle;margin-left:10px;'><span style='display:block;line-height:20px;'>"+row.parentGoodsName+"</span>" +
    		"<span style='display:block;line-height:20px;'>"+row.goodsName+"</span></div></div>";
        }},
        {title: '运费金额(元)', field: 'sumFreight', width:"150px", visible:true},
        {title: '结算重量(吨)', field: 'weight', width:"150px", visible:true},
        {title: '审核时间', field: 'auditTime', width:"250px", visible:true},
    ],
    doFunction:function(targetId,row){
        var choose_Btn = new Button(targetId + " #choose_Btn",ImageIcon.Duigou_W,"",Button.TypeImportant,Button.SizeShort);
        choose_Btn.bindEvent("click",function(){
        	new WindowSwitch(WindowSwitch.TypeDemindDetail,[row.demindId]);
        });
        $('.chooseDiv').css('display','inline-block')
        $('.chooseDiv button').css('display','block')
    },
    itemClickFun:function(row){
    	new WindowSwitch(WindowSwitch.TypeReceiptDetail,row.receiptId);
    },	
}
/*角色管理*/
DataGridItemSet.TypeRoleInfo = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'roleId',width:"60px",visible:true}
    },
    columns:[
        {title: '角色名称', field: 'roleName', width:"600px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><span style='vertical-align:middle;'>"+row.roleName+"</span></div>";
        }},
        {title: '角色描述', field: 'roleDesc', width:"600px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><span style='vertical-align:middle;'>"+row.roleDesc+"</span></div>";
        }},
    ],
    itemClickFun:function(row){
    	new WindowSwitch(WindowSwitch.TypeRoleDetails, row.roleId);
    },
}
/*员工管理*/
DataGridItemSet.TypeMemberSub = {
	head:{
        id:{title: '序号',width:"60px",visible:true,formatter:function(val){
            return "<div style='font-weight:bold;font-size:18px;text-align: center;width:40px;line-height:40px;"+
                    "border-radius:10px;color:#ffffff;background:#22b8de;margin:10px;box-shadow: 1px 1px 2px #cccccc'>"+
                    val+"</div>";
        }},
        icon:{title: '状态',width:"60px",visible:false},
        checkBox:{title: '',field: 'memberSubId',width:"60px",visible:true}
    },
    columns:[
        {title: '员工姓名', field: 'staffName', width:"250px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><span style='vertical-align:middle;'>"+row.staffName+"</span></div>";
        }},
        {title: '登录账号', field: 'mobile', width:"250px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><span style='vertical-align:middle;'>"+row.mobile+"</span></div>";
        }},
        {title: '角色', field: 'roleName', width:"250px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><span style='vertical-align:middle;'>"+row.roleName+"</span></div>";
        }},
        {title: '联系电话', field: 'telephone', width:"250px", visible:true,formatter:function(row){
            return "<div style='text-align: center;'><span style='vertical-align:middle;'>"+row.telephone+"</span></div>";
        }},
        {title: '账号状态', field: 'accountState', width:"250px", visible:true,formatter:function(row){
        	var state = row.accountState == 'A' ? '正常' : '锁定'; 
            return "<div style='text-align: center;'><span style='vertical-align:middle;'>"+state+"</span></div>";
        }},
    ],
    itemClickFun:function(row){
    	/*var data = {'receiptId': row.receiptId, 'auditState': row.auditState};*/
    	new WindowSwitch(WindowSwitch.TypeMemberSubDetails, row.memberSubId);
    },
}
function DataGridItemSet(){
    
}