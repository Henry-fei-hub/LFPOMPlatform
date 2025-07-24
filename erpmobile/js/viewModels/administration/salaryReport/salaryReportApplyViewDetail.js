define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function salaryReportApplyViewDetailModel(params) {
                var self = this;
                self.viewModelName = 'salaryReportApplyViewDetailModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                self.dataSource = ko.observable();
                self.dataSource1 = ko.observable();
                self.dataSource2 =ko.observable();
                self.dataSource3 =ko.observable();
                self.dataSource4 = ko.observable();
                self.dataSource5 = ko.observable();
                self.haveBonusPlate=ko.observable(false);
                self.haveSalaryCompany=ko.observable(false);
                self.haveYearBonusPlate = ko.observable(false);
                self.isSalary = ko.observable(false);
                self.isBonus = ko.observable(false);
                self.isYearBonus = ko.observable(false);
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.resultData = ko.observable();
                self.processbillListData = null;
                self.specialHeaderTitle = ko.observable('详情');
                   
                self.goSalaryDetail = function(data, event){
                    self.goDetail(1, data, event);
                };
                
                self.goBonusDetail = function(data, event){
                    var personnelBusinessId = params.rowData.personnelBusinessId;
                    data['personnelBusinessId'] = personnelBusinessId;
                    self.goDetail(2, data, event);
                };
                
                self.goYearBonusDetail = function(data, event){
                    self.goDetail(3, data, event);
                };
                
                self.goDetail = function(goType, data, event){
                    data['goType'] = goType;
                    self.rowData = data;
                    self.rowData['plateId'] = params.rowData.plateId;
                    dl.getGlobalModule({name: 'administration/salaryReport/salaryReportApplyViewDetail_more', params: self});
                    dl.pushPageStack({name: 'administration/salaryReport/salaryReportApplyViewDetail', params: self.parentViewModel});
                    dl.pushHeader("详情");
                };
                self.datareceived = function (data) {
                  
                };
                    //根据业务部门查看部门奖金数据列表  全部来自奖金分表
                self.datareceived2 = function (data) {
                    var arrData2 = data.ResultSet.Result;
                    if (arrData2.length > 0) {
                        self.haveBonusPlate(true);
                    }
                    self.dataSource2(new oj.ArrayTableDataSource(arrData2, {idAttribute: 'departmentId'}));
                };
                //根据业务部门查看部门工资数据列表  全部来自奖金分表
                self.datareceived3 = function (data) {
                    
                    var arrData3 = data.ResultSet.Result;
                    if (arrData3.length > 0) {
                        self.haveSalaryCompany(true);
                    }
                    self.dataSource3(new oj.ArrayTableDataSource(arrData3, {idAttribute: 'departmentId'}));
                };
                
                 //根据业务部门查看部门年终奖分表
                self.datareceived5 = function (data) {
                    
                    var arrData = data.ResultSet.Result;
                    if (arrData.length > 0) {
                        self.haveSalaryCompany(true);
                    }
                    self.dataSource5(new oj.ArrayTableDataSource(arrData, {idAttribute: 'departmentId'}));
                };
                
                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
//                     dl.pushPageStack({name: 'administration/salaryReport/salaryReportApplyViewDetail', params: params});
                    self.isSalary(false);
                    self.isBonus(false);
                    self.haveBonusPlate(false);
                    self.haveSalaryCompany(false);
                    self.isYearBonus(false);
                    self.haveYearBonusPlate(false); 
                    var goType = self.parentViewModel.rowData['goType'];//pageFlag不为空且等于1时表示从我的申请点击进入此页面
                    if(goType === 1){
                        self.isSalary(true);
                        self.dataSource(new oj.ArrayTableDataSource([self.parentViewModel.rowData], {idAttribute: 'plateId'}));
                        //根据业务部门查看部门工资数据列表
                        var condition = {

                            plateId: params.rowData.plateId,
                            year: params.rowData.year,
                            month:params.rowData.month
                        };
                        dl.callOperation("NQ_OnSalaryReportByDepartment", 'find', condition, self.datareceived3);
                    }else if(goType === 2){
                        self.isBonus(true);
                        self.dataSource1(new oj.ArrayTableDataSource([self.parentViewModel.rowData], {idAttribute: 'plateId'}));
                         //根据业务部门查看部门奖金数据列表
                        var condition = {

                            plateId: params.rowData.plateId,
                            year: params.rowData.year,
                            month:params.rowData.month,
                            personnelBusinessId: params.rowData.personnelBusinessId
                        };
                        dl.callOperation("NQ_OnSalaryDepartmentBonusByPlate", 'find', condition, self.datareceived2);
                    }else if(goType === 3){
                        self.isYearBonus(true);
                        self.dataSource4(new oj.ArrayTableDataSource([self.parentViewModel.rowData], {idAttribute: 'plateId'}));
                         //根据业务部门查看部门年终奖奖金数据列表
                        var condition = {
                            plateId: params.rowData.plateId,
                            personnelBusinessId: params.rowData.personnelBusinessId
                        };
                        dl.callOperation("NQ_OnSalaryAnnualBonusByDepartment", 'find', condition, self.datareceived5);
                    };
                    
                    
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return salaryReportApplyViewDetailModel;
        }
);


