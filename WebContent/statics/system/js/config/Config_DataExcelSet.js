//数据块设置---------------------------------------------------------------------------------
//订单列表
DataExcelSet.TypeDemind = {
    title:[
    	{title:"序号",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>序号</th>";
        }},
        {title:"订单编号",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>订单编号</th>";
        }},
        {title:"发货方",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>发货方</th>";
        }},
        {title:"发货方地址",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>发货方地址</th>";
        }},
        {title:"收货方",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>收货方</th>";
        }},
        {title:"收货方地址",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>收货方地址</th>";
        }},
        {title:"货物类型",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #ffd966;color: #666666;font-weight: bold;'>货物类型</th>";
        }},
        {title:"货物重量(吨)",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #ffd966;color: #666666;font-weight: bold;'>货物重量(吨)</th>";
        }},
        {title:"已运重量(吨)",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #ffd966;color: #666666;font-weight: bold;'>已运重量(吨)</th>";
        }},
        {title:"运费单价(元)",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #ffd966;color: #666666;font-weight: bold;'>运费单价(元)</th>";
        }},
        {title:"运输时间(起)",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #ffd966;color: #666666;font-weight: bold;'>运输时间(起)</th>";
        }},
        {title:"运输时间(止)",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #ffd966;color: #666666;font-weight: bold;'>运输时间(止)</th>";
        }},
        {title:"经理人数量",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #bdd7ee;color: #666666;font-weight: bold;'>经理人数量</th>";
        }},
        {title:"车次",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #bdd7ee;color: #666666;font-weight: bold;'>车次</th>";
        }},
        {title:"创建时间",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>创建时间</th>";
        }},
        {title:"运完时间",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>运完时间</th>";
        }},
        {title:"结清时间",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>结清时间</th>";
        }}
    ],
    columns:[
    	{field: '',formatter:function(num){
    		if(num%2==0){
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#f1f1f1;'>"+num+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#ffffff;'>"+num+"</td>";
    		}
        }},
        {field: 'demindNum',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#f1f1f1;'>"+row.demindNum+"</td>";
        	}else{
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#ffffff;'>"+row.demindNum+"</td>";
        	}
        }},
        {field: 'shipFactory',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: left;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.shipFactory+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: left;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.shipFactory+"</td>";
    		}
        }},
        {field: 'originAddr',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: left;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.originProvinceName+"-"+row.originCityName+"-"+row.originAddr+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: left;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.originProvinceName+"-"+row.originCityName+"-"+row.originAddr+"</td>";
    		}
        }},
        {field: 'custFactory',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: left;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.custFactory+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: left;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.custFactory+"</td>";
    		}
        }},
        {field: 'destAddr',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: left;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.custProvName+"-"+row.custCityName+"-"+row.destAddr+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: left;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.custProvName+"-"+row.custCityName+"-"+row.destAddr+"</td>";
    		}
        }},
        {field: 'goodsName',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.parentGoodsName+"-"+row.goodsName+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.parentGoodsName+"-"+row.goodsName+"</td>";
    		}
        }},
        {field: 'weight',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#f1f1f1;'>"+row.weight+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#ffffff;'>"+row.weight+"</td>";
    		}
        }},
        {field: 'alreayWeight',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#f1f1f1;'>"+row.alreadyWeight+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#ffffff;'>"+row.alreadyWeight+"</td>";
    		}
        }},
        {field: 'freight',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#f1f1f1;'>"+row.freight+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#ffffff;'>"+row.freight+"</td>";
    		}
        }},
        {field: 'loadStartTime',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.loadStarttime+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.loadStarttime+"</td>";
    		}
        }},
        {field: 'loadEndTime',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.loadEndtime+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.loadEndtime+"</td>";
    		}
        }},
        {field: 'carrierNum',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.carrierNum+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.carrierNum+"</td>";
    		}
        }},
        {field: 'vehicleNumber',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.vehicleNumber+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.vehicleNumber+"</td>";
    		}
        }},
        {field: 'createTime',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.createTime+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.createTime+"</td>";
    		}
        }},
        {field: 'finishTime',formatter:function(row,num){
        	var finishTime = row.finishTime;
        	if(finishTime == '' || finishTime == undefined){
        		finishTime = '-';
        	}
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+finishTime+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+finishTime+"</td>";
    		}
        }},
        {field: 'moneyFinishTime',formatter:function(row,num){
        	var moneyFinishTime = row.moneyFinishTime;
        	if(moneyFinishTime == '' || moneyFinishTime == undefined){
        		moneyFinishTime = '-';
        	}
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+moneyFinishTime+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+moneyFinishTime+"</td>";
    		}
        }}
    ],
    bottom:[
    	{title:"总计",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDD5B4;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'>总计</td>";
        }},
        {title:"订单编号",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"发货方",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"发货方地址",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"收货方",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"收货方地址",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"货物类型",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"货物重量(吨)",formatter:function(data){
        	var result = 0;
        	for(var i=0;i<data.length;i++){
        		result += Number(data[i].weight);
        	}
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'>"+result+"</td>";
        }},
        {title:"已运重量(吨)",formatter:function(data){
        	var result = 0;
        	for(var i=0;i<data.length;i++){
        		result += Number(data[i].alreadyWeight);
        	}
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'>"+result+"</td>";
        }},
        {title:"运费单价(元)",formatter:function(data){
        	var result = 0;
        	for(var i=0;i<data.length;i++){
        		result += Number(data[i].freight);
        	}
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'>"+result+"</td>";
        }},
        {title:"运输时间(起)",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"运输时间(止)",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"经理人数量",formatter:function(data){
        	var result = 0;
        	for(var i=0;i<data.length;i++){
        		result += Number(data[i].carrierNum);
        	}
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'>"+result+"</td>";
        }},
        {title:"车次",formatter:function(data){
        	var result = 0;
        	for(var i=0;i<data.length;i++){
        		result += Number(data[i].vehicleNumber);
        	}
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'>"+result+"</td>";
        }},
        {title:"创建时间",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"运完时间",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"结清时间",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }}
    ],
}
/*票据列表*/
DataExcelSet.TypeReceipt = {
    title:[
    	{title:"序号",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>序号</th>";
        }},
        {title:"票据编号",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>票据编号</th>";
        }},
        {title:"订单编号",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>订单编号</th>";
        }},
        {title:"车牌号",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>车牌号</th>";
        }},
        {title:"发货方",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>发货方</th>";
        }},
        {title:"发货方地址",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>发货方地址</th>";
        }},
        {title:"收货方",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>收货方</th>";
        }},
        {title:"收货方地址",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>收货方地址</th>";
        }},
        {title:"货物类型",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #ffd966;color: #666666;font-weight: bold;'>货物类型</th>";
        }},
        {title:"原发重量(吨)",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #ffd966;color: #666666;font-weight: bold;'>原发重量(吨)</th>";
        }},
        {title:"卸货重量(吨)",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #ffd966;color: #666666;font-weight: bold;'>卸货重量(吨)</th>";
        }},
        {title:"运费金额(元)",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #ffd966;color: #666666;font-weight: bold;'>运费金额(元)</th>";
        }},
        {title:"运输时间(起)",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #ffd966;color: #666666;font-weight: bold;'>运输时间(起)</th>";
        }},
        {title:"运输时间(止)",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #ffd966;color: #666666;font-weight: bold;'>运输时间(止)</th>";
        }},
        {title:"提交时间",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>提交时间</th>";
        }},
        {title:"审核时间",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>审核时间</th>";
        }},
        {title:"支付时间",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>支付时间</th>";
        }}
    ],
    columns:[
    	{field: '',formatter:function(num){
    		if(num%2==0){
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#f1f1f1;'>"+num+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#ffffff;'>"+num+"</td>";
    		}
        }},
        {field: 'demindReceiptNum',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#f1f1f1;'>"+row.demindReceiptNum+"</td>";
        	}else{
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#ffffff;'>"+row.demindReceiptNum+"</td>";
        	}
        }},
        {field: 'demindNum',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#f1f1f1;'>"+row.demindNum+"</td>";
        	}else{
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#ffffff;'>"+row.demindNum+"</td>";
        	}
        }},
        {field: 'plateNumber',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#f1f1f1;'>"+row.plateNumber+"</td>";
        	}else{
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#ffffff;'>"+row.plateNumber+"</td>";
        	}
        }},
        {field: 'shipFactory',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: left;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.shipFactory+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: left;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.shipFactory+"</td>";
    		}
        }},
        {field: 'originAddr',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: left;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.originProvinceName+"-"+row.originCityName+"-"+row.originAddr+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: left;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.originProvinceName+"-"+row.originCityName+"-"+row.originAddr+"</td>";
    		}
        }},
        {field: 'custFactory',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: left;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.custFactory+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: left;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.custFactory+"</td>";
    		}
        }},
        {field: 'destAddr',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: left;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.custProvName+"-"+row.custCityName+"-"+row.destAddr+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: left;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.custProvName+"-"+row.custCityName+"-"+row.destAddr+"</td>";
    		}
        }},
        {field: 'goodsName',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.parentGoodsName+"-"+row.goodsName+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.parentGoodsName+"-"+row.goodsName+"</td>";
    		}
        }},
        {field: 'primaryWeight',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#f1f1f1;'>"+row.primaryWeight+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#ffffff;'>"+row.primaryWeight+"</td>";
    		}
        }},
        {field: 'weight',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#f1f1f1;'>"+row.weight+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#ffffff;'>"+row.weight+"</td>";
    		}
        }},
        {field: 'sumFreight',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#f1f1f1;'>"+row.sumFreight+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#ffffff;'>"+row.sumFreight+"</td>";
    		}
        }},
        {field: 'primaryTime',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.primaryTime+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.primaryTime+"</td>";
    		}
        }},
        {field: 'arrivalTime',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.arrivalTime+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.arrivalTime+"</td>";
    		}
        }},
        {field: 'applyTime',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.applyTime+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.applyTime+"</td>";
    		}
        }},
        {field: 'auditTime',formatter:function(row,num){
        	var auditTime = row.auditTime;
        	if(auditTime == '' || auditTime == undefined){
        		auditTime = '-';
        	}
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+auditTime+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+auditTime+"</td>";
    		}
        }},
        {field: 'payTime',formatter:function(row,num){
        	var payTime = row.payTime;
        	if(payTime == '' || payTime == undefined){
        		payTime = '-';
        	}
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+payTime+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+payTime+"</td>";
    		}
        }}
    ],
    bottom:[
    	{title:"总计",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDD5B4;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'>总计</td>";
        }},
        {title:"票据编号",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"订单编号",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"车牌号",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"发货方",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"发货方地址",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"收货方",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"收货方地址",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"货物类型",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"原发重量(吨)",formatter:function(data){
        	var result = 0;
        	for(var i=0;i<data.length;i++){
        		result += Number(data[i].primaryWeight);
        	}
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'>"+result+"</td>";
        }},
        {title:"卸货重量(吨)",formatter:function(data){
        	var result = 0;
        	for(var i=0;i<data.length;i++){
        		result += Number(data[i].weight);
        	}
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'>"+result+"</td>";
        }},
        {title:"运费金额(元)",formatter:function(data){
        	var result = 0;
        	for(var i=0;i<data.length;i++){
        		result += Number(data[i].sumFreight);
        	}
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'>"+result+"</td>";
        }},
        {title:"运输时间(起)",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"运输时间(止)",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"提交时间",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"审核时间",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"支付时间",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }}
    ],
}
/*车次列表*/
DataExcelSet.TypeVehicle = {
    title:[
    	{title:"序号",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>序号</th>";
        }},
        {title:"车次编号",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>车次编号</th>";
        }},
        {title:"车牌号",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>车牌号</th>";
        }},
        {title:"联系人姓名",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>联系人姓名</th>";
        }},
        {title:"联系电话",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>联系电话</th>";
        }},
        {title:"所属经理人",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>所属经理人</th>";
        }},
        {title:"车次状态",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>车次状态</th>";
        }},
        {title:"货物类型",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #ffd966;color: #666666;font-weight: bold;'>货物类型</th>";
        }},
        {title:"原发重量(吨)",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #ffd966;color: #666666;font-weight: bold;'>原发重量(吨)</th>";
        }},
        {title:"卸货重量(吨)",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #ffd966;color: #666666;font-weight: bold;'>卸货重量(吨)</th>";
        }},
        {title:"运费金额(元)",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #ffd966;color: #666666;font-weight: bold;'>运费金额(元)</th>";
        }},
        {title:"运输时间(起)",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #ffd966;color: #666666;font-weight: bold;'>运输时间(起)</th>";
        }},
        {title:"运输时间(止)",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #ffd966;color: #666666;font-weight: bold;'>运输时间(止)</th>";
        }},
        {title:"接单时间",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>接单时间</th>";
        }}
    ],
    columns:[
    	{field: '',formatter:function(num){
    		if(num%2==0){
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#f1f1f1;'>"+num+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#ffffff;'>"+num+"</td>";
    		}
        }},
        {field: 'demindVehicleNum',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#f1f1f1;'>"+row.demindVehicleNum+"</td>";
        	}else{
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#ffffff;'>"+row.demindVehicleNum+"</td>";
        	}
        }},
        {field: 'plateNumber',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#f1f1f1;'>"+row.plateNumber+"</td>";
        	}else{
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#ffffff;'>"+row.plateNumber+"</td>";
        	}
        }},
        {field: 'vehicleContactName',formatter:function(row,num){
        	console.log(row)
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.vehicleContactName+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.vehicleContactName+"</td>";
    		}
        }},
        {field: 'telephone',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.telephone+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.telephone+"</td>";
    		}
        }},
        {field: 'contactName',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.contactName+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.contactName+"</td>";
    		}
        }},
        {field: 'stateDesc',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.stateDesc+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.stateDesc+"</td>";
    		}
        }},
        {field: 'goodsName',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.parentGoodsName+"-"+row.goodsName+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.parentGoodsName+"-"+row.goodsName+"</td>";
    		}
        }},
        {field: 'primaryWeight',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#f1f1f1;'>"+row.primaryWeight+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#ffffff;'>"+row.primaryWeight+"</td>";
    		}
        }},
        {field: 'weight',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#f1f1f1;'>"+row.weight+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#ffffff;'>"+row.weight+"</td>";
    		}
        }},
        {field: 'sumFreight',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#f1f1f1;'>"+row.sumFreight+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#ffffff;'>"+row.sumFreight+"</td>";
    		}
        }},
        {field: 'startMoveTime',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.startMoveTime+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.startMoveTime+"</td>";
    		}
        }},
        {field: 'stopMoveTime',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.stopMoveTime+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.stopMoveTime+"</td>";
    		}
        }},
        {field: 'createTime',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.createTime+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.createTime+"</td>";
    		}
        }}
    ],
    bottom:[
    	{title:"总计",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDD5B4;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'>总计</td>";
        }},
        {title:"车次编号",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"车牌号",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"联系人姓名",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"联系电话",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"所属经理人",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"车次状态",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"货物类型",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"原发重量(吨)",formatter:function(data){
        	var result = 0;
        	for(var i=0;i<data.length;i++){
        		result += Number(data[i].primaryWeight);
        	}
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'>"+result+"</td>";
        }},
        {title:"卸货重量(吨)",formatter:function(data){
        	var result = 0;
        	for(var i=0;i<data.length;i++){
        		result += Number(data[i].weight);
        	}
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'>"+result+"</td>";
        }},
        {title:"运费金额(元)",formatter:function(data){
        	var result = 0;
        	for(var i=0;i<data.length;i++){
        		result += Number(data[i].sumFreight);
        	}
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'>"+result+"</td>";
        }},
        {title:"运输时间(起)",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"运输时间(止)",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"接单时间",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }}
    ],
}
/*车辆列表*/
DataExcelSet.TypeCarrierVehicle = {
    title:[
    	{title:"序号",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>序号</th>";
        }},
        {title:"帐号",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>帐号</th>";
        }},
        {title:"注册号码",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>注册号码</th>";
        }},
        {title:"车牌号",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>车牌号</th>";
        }},
        {title:"联系人姓名",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>联系人姓名</th>";
        }},
        {title:"联系电话",formatter:function(row){
            return "<th style='height: 30px;text-align: center;background: #666666;color: #ffffff;font-weight: bold;'>联系电话</th>";
        }}
    ],
    columns:[
    	{field: '',formatter:function(num){
    		if(num%2==0){
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#f1f1f1;'>"+num+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#ffffff;'>"+num+"</td>";
    		}
        }},
        {field: 'userName',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#f1f1f1;'>"+row.userName+"</td>";
        	}else{
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#ffffff;'>"+row.userName+"</td>";
        	}
        }},
        {field: 'mobile',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.mobile+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.mobile+"</td>";
    		}
        }},
        {field: 'plateNumber',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#f1f1f1;'>"+row.plateNumber+"</td>";
        	}else{
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;mso-number-format: \"@\";background:#ffffff;'>"+row.plateNumber+"</td>";
        	}
        }},
        {field: 'contactName',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.contactName+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.contactName+"</td>";
    		}
        }},
        {field: 'telephone',formatter:function(row,num){
        	if(num%2==0){
        		return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#f1f1f1;'>"+row.telephone+"</td>";
    		}else{
    			return "<td style='height: 30px;text-align: center;border-bottom: 0.5px dashed #cccccc;background:#ffffff;'>"+row.telephone+"</td>";
    		}
        }}
    ],/*
    bottom:[
    	{title:"总计",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDD5B4;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'>总计</td>";
        }},
        {title:"帐号",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"注册号码",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"车牌号",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"联系人姓名",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }},
        {title:"联系电话",formatter:function(data){
            return "<td style='height: 30px;text-align: center;background: #FDE9D9;color: #333333;font-weight: bold; border-bottom: 0.5px solid #cccccc;'></td>";
        }}
    ],*/
}
function DataExcelSet(){
    
}