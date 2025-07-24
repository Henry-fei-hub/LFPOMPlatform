define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
   'ojs/ojdatagrid', 'ojs/ojarraydatagriddatasource', 'ojs/ojcollectiondatagriddatasource',  'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource',
   'ojs/ojjsontreedatasource', 'ojs/ojvalidation-datetime','ojs/ojvalidation-number', 'ojs/ojpagingcontrol', 'ojs/ojpagingdatagriddatasource',
   'viewModels/administration/salaryReport/developerlistmodel', 'viewModels/administration/salaryReport/salaryAnnualbonusmodel', 'ojs/ojconveyorbelt','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function salaryReportApplyViewDetail_moreModel(params) {
                var self = this;
                self.viewModelName = 'salaryReportApplyViewDetail_moreModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                self.dataSource2 =ko.observable();
                self.salaryCollection = ko.observableArray();
                self.haveBonusPlate=ko.observable(false);
                self.haveSalaryCompany=ko.observable(false);
                self.isSalary = ko.observable(false);
                self.isBonus = ko.observable(false);
                self.isYearBonus = ko.observable(false);
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.resultData = ko.observable();
                self.processbillListData = null;
                self.specialHeaderTitle = ko.observable('详情');
                self.handleEditEnd = oj.DataCollectionEditUtils.basicHandleEditEnd;
                self.editMode = 'none';
                self.handleEdit = function(event, ui) {
                };
    
                self.collection = new DeveloperListCollection();
                
                self.yearBonusCollection = new SalaryAnnualBonusListCollection();
                
                self.datasource = new oj.CollectionDataGridDataSource(self.collection, {rowHeader: 'employeeName', columns: ['attendanceDeduct','fillSendDeduct','jobSubsidy','shouldSalary',
                        'shouldBonus','shouldTotal','shouldTax','totalInsurance','totalFund','leaveNoDeductTax','factSalary','factBonus']});
                  if (self.datasource["columns"].length>0) {
                        self.haveSalaryCompany(true);
                    }
                
                self.yearBonusDatasource = new oj.CollectionDataGridDataSource(self.yearBonusCollection, {rowHeader: 'employeeName', columns: ['shouldTotal','shouldTax', 'insteadDeduct', 'factBonus','alreadyBonus',
                        'shouldBonus', 'yearPerformanceBonus', 'programBonus', 'salaryDiffDeduct', 'transferAccountMoney', 'depositDeduct', 'reimbursementDeduct', 
                        'oneToThreeRest', 'housingSubsidy', 'deductPerformanceBonus', 'remark'
                    ]});
                
                self.dataGridId = '#developerlist-datagrid';
                    //根据业务部门查看部门奖金数据列表  全部来自奖金分表
                self.datareceived2 = function (data) {
                    var arrData2 = data.ResultSet.Result;
                    if (arrData2.length > 0) {
                        self.haveBonusPlate(true);
                    }
                    self.dataSource2(new oj.ArrayTableDataSource(arrData2, {idAttribute: 'employeeId'}));
                };
                
               self.getCellTemplate = function(cellContext){
			var mode = cellContext['mode'];
			if (mode === 'edit') return 'developerlistEditTemplate';
			else if (mode === 'navigation') return 'developerlistDisplayTemplate';
		};
                self.getCellClassName = function(cellContext){
			var key = cellContext['keys']['column'];
			return 'oj-helper-justify-content-flex-start';
		};
                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    self.isSalary(false);
                    self.isBonus(false);
                    self.haveBonusPlate(false);
                    self.isYearBonus(false);
                    var goType = self.parentViewModel.rowData['goType'];//pageFlag不为空且等于1时表示从我的申请点击进入此页面
                    if(goType === 1){
                        self.isSalary(true);
                    }else if(goType === 2){
                        self.isBonus(true);
                         //根据部门查询员工奖金列表
                        var condition2 = {
                            plateId: params.rowData.plateId,
                            departmentId: params.rowData.departmentId,
                            year: params.rowData.year,
                            month: params.rowData.month,
                            personnelBusinessId: params.rowData.personnelBusinessId
                        };
                        dl.callOperation("NQ_OnSalaryEmpBonusByDepartment", 'find', condition2, self.datareceived2);
                    }else if(goType === 3){
                        self.isYearBonus(true);
                    };
                };
                
                self.collection.generateCondition = function(){
                        return {
                            plateId: params.rowData.plateId,
                            departmentId: params.rowData.departmentId,
                            year: params.rowData.year,
                            month:params.rowData.month};
                };
                
                self.yearBonusCollection.generateCondition = function(){
                    var condition = {
                            plateId: params.rowData.plateId,
                            year: params.rowData.year,
                            month: params.rowData.month,
                            personnelBusinessId: params.rowData.personnelBusinessId
                    }
                    var keyvalues = [];
                    var tmpSql = "order by sab.employee_id";
                    var kv = {
                        key: tmpSql,
                        value: ' and sab.department_id =' + params.rowData.departmentId + ' ' + tmpSql
                    };
                    keyvalues.push(kv);
                    condition['keyValues'] = keyvalues;
                    return condition;
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return salaryReportApplyViewDetail_moreModel;
        }
);


