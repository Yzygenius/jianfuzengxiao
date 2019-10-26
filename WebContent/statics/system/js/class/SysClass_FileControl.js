//文件
function FileControl(){
	
}
FileControl.downLoad = function(srcUrl,fileName,canvas){
	if(SysFunctions.getExplorer()=='Chrome'){
		var alink = document.createElement("a");
	    alink.href = srcUrl;
	    alink.download = fileName;
	    alink.click();
	}
	if(SysFunctions.getExplorer()=='Firefox'){
		var alink = document.createElement("a");
	    alink.href = srcUrl;
	    alink.download = fileName+'.png';
	    document.body.appendChild(alink);
	    alink.style.display='none';
	    alink.click();
	    document.body.removeChild(alink);
	}
    if(SysFunctions.getExplorer()=='ie'){
    	if(canvas){
    		var blob = canvas.msToBlob();
    		window.navigator.msSaveBlob(blob,fileName+'.jpeg')
    		return
    	}
    	var oPop = window.open(srcUrl,"","width=1, height=1, top=5000, left=5000");
        for(; oPop.document.readyState != "complete"; )
        {
            if (oPop.document.readyState == "complete")break;
        }
        oPop.document.execCommand("SaveAs");
        oPop.close();
    }
}

FileControl.downLoadExcel = function(targetId, sheetName){
	
	if(SysFunctions.getExplorer()=='ie') { 
		var curTbl = document.getElementById(targetId);
        var oXL = new ActiveXObject("Excel.Application");

        //创建AX对象excel 
        var oWB = oXL.Workbooks.Add();
        //获取workbook对象 
        var xlsheet = oWB.Worksheets(1);
        //激活当前sheet 
        var sel = document.body.createTextRange();
        sel.moveToElementText(curTbl);
        //把表格中的内容移到TextRange中 
        sel.select;
        //全选TextRange中内容 
        sel.execCommand("Copy");
        //复制TextRange中内容  
        xlsheet.Paste();
        //粘贴到活动的EXCEL中       
        oXL.Visible = true;
        //设置excel可见属性

        try {
            var fname = oXL.Application.GetSaveAsFilename("Excel.xls", "Excel Spreadsheets (*.xls), *.xls");
        } catch (e) {
            print("Nested catch caught " + e);
        } finally {
            oWB.SaveAs(fname);

            oWB.Close(savechanges = false);
            //xls.visible = false;
            oXL.Quit();
            oXL = null;
            //结束excel进程，退出完成
            //window.setInterval("Cleanup();",1);
            idTmr = window.setInterval("Cleanup();", 1);

        }

    } else {  
    	var uri = 'data:application/vnd.ms-excel;base64,';
        var template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--><head><meta charset="UTF-8"></head><body><table>{table}</table></body></html>';
        if (!targetId.nodeType) targetId = document.getElementById(targetId);
        var ctx = {worksheet: sheetName || 'Worksheet', table: targetId.innerHTML};
        var alink = document.createElement("a");
    	alink.href = uri + base64(format(template, ctx));
        if(SysFunctions.getExplorer()=='Firefox'){
		    alink.download = sheetName+'.xls';
		    document.body.appendChild(alink);
		    alink.style.display='none';
		    alink.click();
		    document.body.removeChild(alink);
	    }else{
	    	alink.download = sheetName;
		    alink.click();
	    }
    }
	//base64转码
    function base64(s) {
        return window.btoa(unescape(encodeURIComponent(s)));
    };
    //替换table数据和worksheet名字
    function format(s, c) {
        return s.replace(/{(\w+)}/g,
        function (m, p) {
            return c[p];
        });
    }
}
//
FileControl.downLoadDataExcel = function(data, typeFlg, fileName){
    $(document.body).append("<table id='excel' style='display:none;'></table>");
    var table = $("#excel");
    var title = typeFlg.title;
    var columns = typeFlg.columns;
    var bottom = typeFlg.bottom;
    //创建Title
    table.append("<tr id='tr_title'></tr>");
    var tr = table.find("#tr_title");
    console.log(tr);
    for(var i=0; i<title.length; i++){
        tr.append(title[i].formatter());
    }
    //创建Body
    for(var i=0; i<data.length; i++){
        table.append("<tr id='tr_"+i+"'></tr>");
        var tr = table.find("#tr_"+i);
        tr.append(columns[0].formatter(i+1));
        for(var j=1; j<columns.length; j++){
            tr.append(columns[j].formatter(data[i],i+1));
        }
    }
    //创建Bottom
    table.append("<tr id='tr_bottom'></tr>");
    var tr = table.find("#tr_bottom");
    for(var i=0; i<bottom.length; i++){
    	tr.append(bottom[i].formatter(data));
    }
    FileControl.downLoadExcel("excel", fileName);
    table.remove();
}