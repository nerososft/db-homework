var Excel = new Object({
    Func: {
        printToExcel: function(html) {
            try {
                var ExApp = new ActiveXObject("Excel.Application")
                var ExWBk = ExApp.workbooks.add()
                var ExWSh = ExWBk.worksheets(1)
                ExApp.DisplayAlerts = false
                ExApp.visible = true
            } catch (e) {
                layer.open({
                    type: 1,
                    offset: 't' //具体配置参考：offset参数项
                        ,
                    content: '<div style="padding: 20px 80px;">您所设定的安全级别太高，或者您的电脑没有安装Microsoft Excel软件！</div>',
                    btn: '确认',
                    btnAlign: 'c' //按钮居中
                        ,
                    shade: 0 //不显示遮罩
                        ,
                    yes: function() {
                        layer.closeAll();
                        return false
                    }
                });
                window.clipboardData.setData("Text", html);
                ExWBk.worksheets(1).Paste;
                ExWBk.worksheets(1).Columns.AutoFit;
                ExWBk.worksheets(1).Rows.AutoFit;
            }
        },
        exportToExcel: function(table) {
            layer.open({
                type: 1,
                offset: 't' //具体配置参考：offset参数项
                    ,
                content: '<div style="padding: 20px 80px;">确认要导出吗?</div>',
                btn: '确认',
                btnAlign: 'c' //按钮居中
                    ,
                shade: 0 //不显示遮罩
                    ,
                yes: function() {
                    var oXL = new ActiveXObject("Excel.Application");
                    var oWB = oXL.Workbooks.Add();
                    var oSheet = oWB.ActiveSheet;
                    var hang = table.rows.length;
                    var lie = table.rows(0).cells.length;
                    for (i = 0; i < hang; i++) {
                        for (j = 0; j < lie; j++) {
                            oSheet.Cells(i + 1, j + 1).Value = table.rows(i).cells(j).innerText;
                        }
                    }
                    oXL.Visible = true;
                    oXL.UserControl = true;
                }
            });
        },
        export: function(div) {
            layer.open({
                type: 1,
                offset: 't' //具体配置参考：offset参数项
                    ,
                content: '<div style="padding: 20px 80px;">是否导出表格数据为 Excel?</div>',
                btn: '确认',
                btnAlign: 'c' //按钮居中
                    ,
                shade: 0 //不显示遮罩
                    ,
                yes: function() {
                    Excel.Func.printToExcel(document.getElementById(div).innerHTML);
                }
            });
        }
    }
});