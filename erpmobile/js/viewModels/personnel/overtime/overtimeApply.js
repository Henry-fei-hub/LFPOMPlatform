define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojdatetimepicker', 'ojs/ojjsontreedatasource','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function overtimeApplyViewModel(params) {
                var self = this;
                self.viewModelName = 'overtimeApplyViewModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                self.dataSource = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.showbox = ko.observable(false);
                var optionsArr = [];
                self.selectedItem = ko.observable("");
                self.resultData = ko.observableArray();
                self.overtimeTypes = ko.observableArray([{'overtimeTypeName':'项目加班','overtimeType':1},{'overtimeTypeName':'前期项目加班','overtimeType':2},{'overtimeTypeName':'非项目加班','overtimeType':3}]);
                self.subTypes = ko.observableArray();
                self.preSubTypes = ko.observableArray();
                self.nextAuditors = ko.observableArray();
                self.processbillListData = null;
                self.specialHeaderTitle = ko.observable('');
                self.processID = ko.observable();
                self.processType = 17;//加班申请
                self.errorMessage = ko.observable();
                self.errorMessage.dataType = 'string';
                 var userData = {};
                  //__drafter新增
                self.__drafter = ko.observable(dl.getEmployeeId());
                self.__employeeId = ko.observable(dl.getEmployeeId());
                self.__employeeNo = ko.observable(dl.getEmployeeNo());
                self.__departmentId = ko.observable(dl.getDepartmentId());
                self.__nextAuditor = ko.observable();
                self.__startDate = ko.observable();
                self.__endDate = ko.observable();
                self.__hours = ko.observable();
                self.__projectType = ko.observable();
                self.projectSelect = ko.observableArray();
                self.preProjectSelect = ko.observableArray();
                self.__projectName = ko.observable();
                self.__projectCode = ko.observable();
                self.__projectId = ko.observable();
                self.__nextAuditor = ko.observable();
                self.__reason = ko.observable();
                self.__remark = ko.observable();
                self.dataSource = new oj.ArrayTableDataSource(self.resultData, {idAttribute: 'employeeId'});

                self.datareceived = function (data) {
                    var arrData = dl.parseCollection(data);
                    if (arrData.length > 0) {
                        arrData[0]['nextAuditor'] = "";
                        arrData[0]['startDate'] = "";
                        arrData[0]['type'] = 1;
                        arrData[0]['reason'] = "";
                        arrData[0]['remark'] = "";
                    }
                    self.resultData(arrData);
                };

                self.datareceived1 = function (data) {
                    var arrData = dl.parseCollection(data);
                    if (arrData.length > 0) {
                        self.processID = arrData[0]['idd'];
                    }
                };

                //处理节点执行的方法   STEP3
                self.checkData = function (values) {
                    //如果为空则返回false
                    if (dl.isNullOrEmpty(values)) {
                        self.errorMessage('♥提示:数据异常');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.startDate)) {
                        self.errorMessage('♥提示:开始日期不可为空');
                        return false;
                    }
                     if (dl.isNullOrEmpty(values.endDate)) {
                        self.errorMessage('♥提示:结束日期不可为空');
                        return false;
                    }  
                    if (dl.isNullOrEmpty(values.hours)) {
                        self.errorMessage('♥提示:小时数不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.projectType)) {
                        self.errorMessage('♥提示：加班类型不可为空');
                        return false;
                    }
                    if (!dl.isNullOrEmpty(values.__projectType) && Number(values.projectType) === 1) {
                        if (dl.isNullOrEmpty(values.projectId)) {
                            self.errorMessage('♥提示:项目加班请选择相关项目');
                            return false;
                        }
                    }
                    if (!dl.isNullOrEmpty(values.projectType) && Number(values.projectType) === 2) {
                        if (dl.isNullOrEmpty(values.projectId)) {
                            self.errorMessage('♥提示:前期项目加班请选择相关前期项目');
                            return false;
                        }
                        if (dl.isNullOrEmpty(values.nextAuditor)) {
                            self.errorMessage('♥提示:[Could not find the next activity owner]');
                            return false;
                        }
                    }
                    return true;
                };
//                STEP2
            self.getValues = function () {
                  if (!dl.isNullOrUndefined(self.__projectType()) && Number(self.__projectType()[0]) === 1) {
                        var a = self.projectSelect()[0];
                        for (var i = 0; i < self.subTypes().length; i++) {
                            if (Number(a) === Number(self.subTypes()[i].projectId)) {
                                self.__projectName(self.subTypes()[i].projectName);
                                self.__projectCode(self.subTypes()[i].projectCode);
                                self.__projectId(self.subTypes()[i].projectId);
                                break;
                            }
                        }
                    } else if (!dl.isNullOrUndefined(self.__projectType()) && Number(self.__projectType()[0]) === 2) {
                            var a = self.preProjectSelect()[0];
                        for (var i = 0; i < self.preSubTypes().length; i++) {
                            if (Number(a) === Number(self.preSubTypes()[i].preProjectReimbursementNumberId)) {
                                self.__projectName(self.preSubTypes()[i].projectName);
                                self.__projectCode(self.preSubTypes()[i].customNumber);
                                self.__projectId(self.preSubTypes()[i].preProjectReimbursementNumberId);
                                break;
                            }
                        }
                    };
                    //业务数据获取
                    for (var name in self) {
                        if (name.indexOf("__") !== -1) {
                                if (self[name]() instanceof Array) {
                                    userData[name.substring(2)] = self[name]()[0];
                                } else {
                                    userData[name.substring(2)] = self[name]();
                                }
                        }
                    }
                    return userData;
                };


                //审批后执行的方法 STEP4
                self.workCallback = function (data) {
                    if (data.ResultSet.status >= 0) {
                        self.errorMessage('');
                        var returnData = dl.parseCollection(data);
                        self.processInstanceId = returnData[0].processInstanceId;
                        dl.getGlobalModule({name: 'schedule', params: self});
                        dl.headerTitle("流程进度");
                    } else {
                        self.errorMessage('♥提示:' + decodeURIComponent(data.ResultSet.errors));
                    }
                };

                //提交审批  STEP1
                self.submitClick = function (data, event) {
//                    当前节点数据详情数据
                    var paramData = {
                        systemProcessApplyId: 1,
                        activityType: 4,
                        operatorId: dl.getEmployeeId(),
                        processDefinition: {processId: self.processID}
                    };
                    dl.submitApprovalWork(0, paramData, self, '', '');
                };

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    self.errorMessage('');
                    var condition = {
                        employeeId: dl.getEmployeeId()
                    };
                    dl.callOperation("ST_Employee", 'find', condition, self.datareceived);
                    
                    var condition1 = {
                        employeeId: dl.getEmployeeId(),
                        processTypeId: self.processType
                    };
                    dl.callOperation("NQ_EmployeeProcess", 'find', condition1, self.datareceived1);
                
                    var condition2 = {
                        employeeId: dl.getEmployeeId()
                    };
                    dl.callOperation('NQ_SelectGridMyProjectValue', '', condition2, function (response) {
                        if (Number(response['ResultSet']['status']) >= 0) {
                            var dataArr = dl.parseCollection(response);
                            for (var i = 0; i < dataArr.length; i++) {
                                var temVal = dataArr[i];
                                var title = '';
                                title += temVal['projectName'] + "-";
                                title += temVal['projectCode'];
                                dataArr[i]['title'] = title;
                            }
                            self.subTypes(dataArr);
                        }
                    });
//                    前期项目数据
                    dl.callOperation('NQ_SelectGridPreProjectValue', '', {}, function (response) {
                        if (Number(response['ResultSet']['status']) >= 0) {
                            var dataArr1 = dl.parseCollection(response);
                            for (var i = 0; i < dataArr1.length; i++) {
                                var temVal = dataArr1[i];
                                var preTitle = '';
                                preTitle += temVal['projectName'] + "-";
                                preTitle += temVal['preProjectReimbursementNumberId']; 
                                temVal['preTitle'] = preTitle;
                            }
                            self.preSubTypes(dataArr1);
                        }
                    });
                    //  项目经理数据
                    var condition3 = {
                        status: 0,
                        plateId: dl.getPlateId()
                    };
                    dl.callOperation('NQ_SelectEmployee', '', condition3, function (response) {
                        if (Number(response['ResultSet']['status']) >= 0) {
                            var data3 = dl.parseCollection(response);
                            self.nextAuditors(data3);
                        }
                    });
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return overtimeApplyViewModel;
        }
);


