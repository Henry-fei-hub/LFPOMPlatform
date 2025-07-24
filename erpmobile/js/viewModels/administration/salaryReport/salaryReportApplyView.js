define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient','dl/msgbox', 'dl/workflow','ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl, sc) {
            function salaryReportApplyViewViewModel(params) {
                var self = this;
                self.viewModelName = 'salaryReportApplyViewViewModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                self.dataSource = ko.observable();
                self.dataSource1 = ko.observable();
                self.dataSource2 = ko.observable();
                self.dataSource3 = ko.observable();
                self.dataSource4 = ko.observable();
                self.dataSource5 = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.resultData = ko.observable();
                self.processbillListData = null;
                self.specialHeaderTitle = ko.observable('');
                self.haveSalaryPlate = ko.observable(false);
                self.haveSalaryCompany = ko.observable(false);
                self.haveBonusPlate = ko.observable(false);
                self.haveBonusCompany = ko.observable(false);
                self.havaSararyAnnualPlate = ko.observable(false);
                
                self.isApproval = ko.observable(true);
                self.salaryBonusRemark = ko.observable('');
                
                self.datareceived = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.resultData = arrData;
                    self.dataSource(new oj.ArrayTableDataSource(self.resultData, {idAttribute: 'personnelBusinessId'}));
                    //  某人的报销页面的标题以报销人+主题 
                    self.specialHeaderTitle(dl.getLabelByValue('employees', arrData[0]['employeeId']) + arrData[0]['fee']);                  
                    if(dl.isNullOrUndefined(params.rowData.backViewName)){
                        //节点名称为空时 表示为申请人自己查看
                        params.rowData.backViewName = '人资部发起人';
                    }else if (!dl.isNullOrUndefined(params.rowData.backViewName)) {
//                        processName = processName.toString();
                        var year = arrData[0]['companyProvince'];
                        
                        var month = arrData[0]['targetProvince'];
                        var type = Number(arrData[0]['type']);
                        
                        var condition = {
                            'year': year,
                            'month': month
                        };
                        var remarkCondition = {
                            'year': year,
                            'month': month,
                            'opt_type': 'getSalaryReportRemark'
                        };
                        if(type === 1){//薪资
                            if (params.rowData.backViewName.indexOf("人资部") >= 0 || params.rowData.backViewName.indexOf("总经理") >= 0
                                || params.rowData.backViewName.indexOf("财务经理") >= 0 || params.rowData.backViewName.indexOf("报税会计") >= 0) {
                                //工资主表
//                                dl.callOperation("NQ_OnSalaryReportByCompany", 'find', condition, self.datareceived1);
                                dl.callOperation('NQ_OnSalaryReportByPlate', 'find', condition, self.datareceived1);
                                dl.callOperation("EP_CustomMobileProcess", '', remarkCondition, self.loadRemark);
                            } else if (params.rowData.backViewName.indexOf("部门分管") >= 0) {
                                //工资分表
                                var getPalteCondition = {
                                    employeeId: dl.getEmployeeId(),
                                    opt_type: 'getPlateByRole'
                                };
                                dl.callOperation('EP_CustomSemployeeProcess', 'getPlateByRole', getPalteCondition, function (response) {
                                    if (response['ResultSet']['status'] > 0) {
                                        var tmpSql = "ORDER BY a.plate_id";
                                        var keyvalues = [];
                                        var ids = response['ResultSet']['errors'].toString();
                                        var kv = {
                                            key: tmpSql,
                                            value: ' and a.plate_id in (' + ids + ') ORDER BY a.plate_id'
                                        };
                                        keyvalues.push(kv);
                                        condition['keyValues'] = keyvalues;
                                        dl.callOperation('NQ_OnSalaryReportByPlate', 'find', condition, self.datareceived1);
                                        remarkCondition['plateIds'] = ids;
                                        dl.callOperation("EP_CustomMobileProcess", '', remarkCondition, self.loadRemark);
                                    }
                                });
                            }
                        }else if(type === 2){//奖金
                             var personnelBusinessId = arrData[0]['personnelBusinessId'];
                              condition['personnelBusinessId'] = personnelBusinessId;
                            if (params.rowData.backViewName.indexOf("人资部") >= 0 || params.rowData.backViewName.indexOf("总经理") >= 0
                                || params.rowData.backViewName.indexOf("财务经理") >= 0 || params.rowData.backViewName.indexOf("报税会计") >= 0) {
                                //奖金总表
                                dl.callOperation("NQ_OnSalaryPlateBonusByCompany", 'find', condition, self.datareceived4);
                            } else if (params.rowData.backViewName.indexOf("部门分管") >= 0) {
                                //奖金分表
                                var getPalteCondition = {
                                    employeeId: dl.getEmployeeId(),
                                    opt_type: 'getPlateByRole'
                                };
                                dl.callOperation('EP_CustomSemployeeProcess', 'getPlateByRole', getPalteCondition, function (response) {
                                    if (response['ResultSet']['status'] > 0) {
                                        var tmpSql = "GROUP BY pd.plate_id, A.YEAR, A.MONTH ORDER BY pd.plate_id, A.YEAR, A.MONTH";
                                        var keyvalues = [];
                                        var ids = response['ResultSet']['errors'].toString();
                                        var kv = {
                                            key: tmpSql,
                                            value: ' and a.plate_id in (' + ids + ') ' + tmpSql
                                        };
                                        keyvalues.push(kv);
                                        condition['keyValues'] = keyvalues;
                                        dl.callOperation('NQ_OnSalaryPlateBonusByCompany', 'find', condition, self.datareceived4);
                                    }
                                });
                            }
                        }else if(type === 3){//年终奖金发放
                            var personnelBusinessId = arrData[0]['personnelBusinessId'];
                            condition['personnelBusinessId'] = personnelBusinessId;
                            if (params.rowData.backViewName.indexOf("人资部") >= 0 || params.rowData.backViewName.indexOf("总经理") >= 0
                                || params.rowData.backViewName.indexOf("财务经理") >= 0 || params.rowData.backViewName.indexOf("报税会计") >= 0) {
                                //年终奖分表
                                dl.callOperation("NQ_OnSalaryAnnualBonusByPlate", 'find', condition, self.datareceived5);
                            } else if (params.rowData.backViewName.indexOf("部门分管") >= 0) {
                                //年终奖分表
                                var getPalteCondition = {
                                    employeeId: dl.getEmployeeId(),
                                    opt_type: 'getPlateByRole'
                                };
                                dl.callOperation('EP_CustomSemployeeProcess', 'getPlateByRole', getPalteCondition, function (response) {
                                    if (response['ResultSet']['status'] > 0) {
                                        var tmpSql = "GROUP BY plate_id,year,personnel_business_id,flow_status,send_time ORDER BY plate_id,year";
                                        var keyvalues = [];
                                        var ids = response['ResultSet']['errors'].toString();
                                        var kv = {
                                            key: tmpSql,
                                            value: ' and plate_id in (' + ids + ') ' + tmpSql
                                        };
                                        keyvalues.push(kv);
                                        condition['keyValues'] = keyvalues;
                                        dl.callOperation('NQ_OnSalaryAnnualBonusByPlate', 'find', condition, self.datareceived5);
                                    }
                                });
                            }
                        }
                    }
                };
                
                self.getIndex = function(arrko, koObj, prp){
                    for(var i = 0; i < arrko().data.length; i ++){
                        if(arrko().data[i][prp] === koObj[prp]){
                            return i;
                        }
                    }
                    return null;
                };
                
                self.goSalaryDetail = function(data, event){
                    self.goDetail(1, data, event);
                };
                
                self.goBonusDetail = function(data, event){
                    var personnelBusinessId = params.rowData.businessId;
                    data['personnelBusinessId'] = personnelBusinessId;
                    self.goDetail(2, data, event);
                };
                
                self.goYearBonusDetail = function(data, event){
                    var personnelBusinessId = params.rowData.businessId;
                    data['personnelBusinessId'] = personnelBusinessId;
                    self.goDetail(3, data, event);
                };
                
                self.goDetail = function(goType, data, event){
                    data['goType'] = goType;
                    self.rowData = data;
                    dl.getGlobalModule({name: 'administration/salaryReport/salaryReportApplyViewDetail', params: self});
                    dl.pushPageStack({name: 'administration/salaryReport/salaryReportApplyView', params: self.parentViewModel});
                    dl.pushHeader("详情");
                };
                
                self.datareceived1 = function (data) {
                    //工资主表数据
                    var arrData1 = data.ResultSet.Result;
                    if (arrData1.length > 0) {
                        self.haveSalaryCompany(true);
                    }
                    self.dataSource1(new oj.ArrayTableDataSource(arrData1, {idAttribute: 'plateId'}));
                };
                self.datareceived2 = function (data) {
                    //工资分表数据
                    var arrData2 = data.ResultSet.Result;
                    if (arrData2.length > 0) {
                        self.haveSalaryPlate(true);
                    }
                    self.dataSource2(new oj.ArrayTableDataSource(arrData2, {idAttribute: 'plateId'}));
                };
                
                self.datareceived3 = function (data) {
                    //奖金总表数据
                    var arrData1 = data.ResultSet.Result;
                    if (arrData1.length > 0) {
                        self.haveBonusCompany(true);
                    }
                    ;
                    self.dataSource3(new oj.ArrayTableDataSource(arrData1, {idAttribute: 'companyId'}));
                };
                self.datareceived4 = function (data) {
                    //奖金分表数据
                    var arrData2 = data.ResultSet.Result;
                    if (arrData2.length > 0) {
                        self.haveBonusPlate(true);
                    }
                    self.dataSource4(new oj.ArrayTableDataSource(arrData2, {idAttribute: 'plateId'}));
                };
                
                self.datareceived5 = function (data) {
                    //年终奖金分表数据
                    var arrData = data.ResultSet.Result;
                    if (arrData.length > 0) {
                        self.havaSararyAnnualPlate(true);
                    }
                    self.dataSource5(new oj.ArrayTableDataSource(arrData, {idAttribute: 'plateId'}));
                };
                
                self.loadRemark = function(response){
                    self.salaryBonusRemark(response['ResultSet']['errors']);
                };

                //审批后执行的方法
                self.workCallback = function (data) {
                    if (data.ResultSet.status >= 0) {
                        var returnData = dl.parseCollection(data);
                        self.processInstanceId = returnData[0].processInstanceId;
                        dl.getGlobalModule({name: 'schedule', params: self});
                        dl.headerTitle("流程进度");
                    } else {
                        alert(data.ResultSet.errors);
                    }
                };

                self.getValues = function () {
                    //业务数据获取
                    var userData = self.resultData;
                    userData[0].detailProcessBillListApply = self.processbillListData;
                    return userData[0];
                };
                //处理节点执行的方法
                self.checkData = function (values) {
                    return true;
                };
                //提交审批
                self.submitClick = function (data, event) {
                    var inner = event.currentTarget.innerText;
                    sc.confirm("确定" + inner + "吗?", function () {
                    var target = event.currentTarget;
                    var approvalment = target.id;
                    var val = self.additionalApprovalment();
                    var additionalApprovalment;
                    if (!dl.isNullOrUndefined(val)) {
                        if (val instanceof Array) {
                            if (val.length > 0)
                                additionalApprovalment = val[0];
                        } else
                            additionalApprovalment = val;
                    }
                    var processComment = self.processComment();
                    dl.submitApprovalWork(approvalment, params.rowData, self, processComment, additionalApprovalment);
                })
                };

                //进度按钮
                self.jinduClick = function (data, event) {
                    self.processInstanceId = self.parentViewModel.rowData.processInstanceId;
                    dl.getGlobalModule({name: 'schedule', params: self});
                    dl.pushPageStack({name: 'administration/salaryReport/salaryReportApplyView', params: self.parentViewModel, cacheKey: 'administration/salaryReport/salaryReportApplyView'});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle("流程进度");
                };

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    self.haveBonusCompany(false);
                    self.haveBonusPlate(false);
                    self.haveSalaryCompany(false);
                    self.haveSalaryPlate(false);
                    self.havaSararyAnnualPlate(false);
                    self.pageFlag = self.parentViewModel.rowData['pageFlag'];//pageFlag不为空且等于1时表示从我的申请点击进入此页面
                    if (!dl.isNullOrUndefined(self.pageFlag) && (self.pageFlag === 1 || self.pageFlag === 2)) {
                        self.isApproval(false);
                    } else {
                        self.isApproval(true);
                    }
                    var condition = {
                        personnelBusinessId: params.rowData.businessId,
                        includeDetail: true
                    };
                    dl.callOperation("ST_PersonnelBusines", 'find', condition, self.datareceived);

                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return salaryReportApplyViewViewModel;
        }
);


