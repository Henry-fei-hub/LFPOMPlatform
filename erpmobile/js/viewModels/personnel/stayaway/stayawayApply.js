define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojbutton', 'ojs/ojcheckboxset', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojdatetimepicker'],
        function (oj, ko, $, dl) {
            function stayawayApplyViewModel(params) {
                var self = this;
                self.viewModelName = 'stayawayApplyViewModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable(); //审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable(); //审批意见
                self.processComment.dataType = 'string';
                self.dataSource = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.resultData = ko.observableArray();
                self.specialHeaderTitle = ko.observable('');
                self.processID = ko.observable();
                self.processType = 16; //外出申请
                self.errorMessage = ko.observable();
                //__drafter新增
                self.__drafter = ko.observable(dl.getEmployeeId());
                self.__employeeId = ko.observable(dl.getEmployeeId());
                self.__employeeNo = ko.observable(dl.getEmployeeNo());
                self.__departmentId = ko.observable(dl.getDepartmentId());
                self.__days = ko.observable();
                self.__startDate = ko.observable();
                self.__endDate = ko.observable();
//                self.__startDateDetail = ko.observable();
//                self.__endDateDetail = ko.observable();
                self.__remark = ko.observable();
                self.__reason = ko.observable();
                self.__projectType = ko.observable();
                self.__projectId = ko.observable();
                self.__nextAuditor = ko.observable();
                self.__unit = ko.observable();
                self.__contactPerson = ko.observableArray();
                self.__adress = ko.observable();
                self.__projectName = ko.observable();
                self.__projectCode = ko.observable();
                self.projectSelect = ko.observableArray();
                self.preProjectSelect = ko.observableArray();
                self.subTypes = ko.observable();
                self.preSubTypes = ko.observable();
                self.projectTypes = ko.observableArray([{'projectId': 1, 'title': '项目外出'}, {'projectId': 2, 'title': '前期项目外出'}, {'projectId': 3, 'title': '非项目外出'}]);
                self.nextAuditors = ko.observable();
                self.userData = {};
                self.isShow = ko.observable();
                self.errorMsg = ko.observable('');
//          按钮的返回事件
                self.rebackToClick = function (event, ui) {
                    dl.getGlobalModule(dl.popPageStack());
                    dl.headerTitle(dl.popHeader());
                };
                self.datareceived1 = function (data) {
                    var arrData = dl.parseCollection(data);
                    if (arrData.length > 0) {
                        self.processID(arrData[0]['idd']);
                    }
                };
                //3. 处理节点执行的方法
                self.checkData = function (values) {
                    if (dl.isNullOrEmpty(values)) {
                        self.errorMessage('♥提示:数据异常不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.reason)) {
                        self.errorMessage('♥提示:请假原由不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.startDate)) {
                        self.errorMessage('♥提示:外出日期不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.endDate)) {
                        self.errorMessage('♥提示:预期返回日期不可为空');
                        return false;
                    }
                    if (!((new Date(values.startDate).getFullYear() == new Date(values.endDate).getFullYear()) && (new Date(values.startDate).getMonth() == new Date(values.endDate).getMonth()) && (new Date(values.startDate).getDate() == new Date(values.endDate).getDate()))) {
                        self.errorMessage('♥提示:外出申请时间范围不能跨天，如需跨天，请提出差申请');
                        return false;
                    }
//                    if (dl.isNullOrEmpty(values.startDateDetail)) {
//                        self.errorMessage('♥提示:外出时段不可为空');
//                        return false;
//                    }
//                    if (dl.isNullOrEmpty(values.endDateDetail)) {
//                        self.errorMessage('♥提示:预期返回时段不可为空');
//                        return false;
//                    }
                    if (dl.isNullOrEmpty(values.projectType)) {
                        self.errorMessage('♥提示:请选择外出类型');
                        return false;
                    }
                    if (!dl.isNullOrEmpty(values.projectType) && Number(values.projectType) === 1) {
                        if (dl.isNullOrEmpty(values.projectId)) {
                            self.errorMessage('♥提示:项目外出请选择相关项目');
                            return false;
                        }
                    }
                    if (!dl.isNullOrEmpty(values.projectType) && Number(values.projectType) === 2) {
                        if (dl.isNullOrEmpty(values.projectId)) {
                            self.errorMessage('♥提示:前期项目外出请选择相关项目');
                            return false;
                        }
                        if (dl.isNullOrEmpty(values.nextAuditor)) {
                            self.errorMessage('♥提示:[Could not find the next activity owner]');
                            return false;
                        }
                    }
                    if (values.days >= 24) {
                        self.errorMessage('♥提示:外出申请的时间不能超过1天');
                        return false;
                    }
                    return true;
                };
                //2. self 当前整个模块
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
                    }
                    ;
                    for (var name in self) {
                        if (name.indexOf('__') !== -1) {
                            if (self[name]() instanceof Array) {
                                self.userData[name.substring(2)] = self[name]()[0];
                            } else {
                                self.userData[name.substring(2)] = self[name]();
                            }
                        }
                    }
                    return self.userData;
                };
//                // 1.提交按钮   跳进度
                self.submitClick = function (data, event) {
                    var paramData = {
                        systemProcessApplyId: 1,
                        activityType: 4,
                        operatorId: dl.getEmployeeId(),
                        processDefinition: {processId: self.processID()}
                    };
                    dl.submitApprovalWork(0, paramData, self, '', '');
                };
                //4. 审批后执行的方法
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

//              根据开始结束时间获取外出小时数
                self.__startDate.subscribe(function (val) {
                    var condition = {};
                    condition = self.getValues();
                    condition['optType'] = 'calculateDaysAndHours';
                    condition['startDate'] = self.__startDate();
                    condition['endDate'] = self.__endDate();
                    if (!dl.isNullOrUndefined(self.__endDate())) {
                        dl.callOperation("EP_MyPersonnelProcessor", '', condition, function (response) {
                            if (response['ResultSet']['status'] >= 0) {
                                var arr = dl.parseCollection(response);
                                if (!dl.isNullOrEmpty(arr)) {
                                    if ((arr[0]['days'] == 1 && arr[0]['hours'] > 0) || arr[0]['days'] > 1) {
                                        self.errorMessage('外出申请的时间不能超过1天');
                                    } else if (arr[0]['days'] == 1) {
                                        self.__days(7.5);
                                        self.errorMessage('');
                                    } else {
                                        self.__days(arr[0]['hours']);
                                        self.errorMessage('');
                                    }
                                }
                            } else {
                                self.errorMessage(response['ResultSet']['errors']);
                            }
                        });
                    }
                });
                self.__endDate.subscribe(function (val) {
                    var condition = {};
                    condition = self.getValues();
                    condition['optType'] = 'calculateDaysAndHours';
                    condition['startDate'] = self.__startDate();
                    condition['endDate'] = self.__endDate();
                    if (!dl.isNullOrUndefined(self.__startDate())) {
                        dl.callOperation("EP_MyPersonnelProcessor", '', condition, function (response) {
                            if (response['ResultSet']['status'] >= 0) {
                                var arr = dl.parseCollection(response);
                                if (!dl.isNullOrEmpty(arr)) {
                                    if ((arr[0]['days'] == 1 && arr[0]['hours'] > 0) || arr[0]['days'] > 1) {
                                        self.errorMessage('外出申请的时间不能超过1天');
                                    } else if (arr[0]['days'] == 1) {
                                        self.errorMessage('');
                                        self.__days(7.5);
                                    } else {
                                        self.errorMessage('');
                                        self.__days(arr[0]['hours']);
                                    }
                                }
                            } else {
                                self.errorMessage(response['ResultSet']['errors']);
                            }
                        });
                    }
                    ;
                });
                self.__projectType.subscribe(function (val) {
                    if (Number(self.__projectType()) === 1) {
                        self.isShow(1);
                    } else if (Number(self.__projectType()) === 2) {
                        self.isShow(2);
                    } else {
                        self.isShow(3);
                    }
                });
                self.getDataTitle = function (data) {
                };
                self.handleActivated = function (info) {
                };
                self.handleAttached = function (info) {
                    var condition1 = {
                        employeeId: dl.getEmployeeId(),
                        processTypeId: self.processType
                    };
                    dl.callOperation("NQ_EmployeeProcess", 'find', condition1, self.datareceived1);
//                    项目外出数据
                    var condition = {
                        employeeId: dl.getEmployeeId()
                    };
                    dl.callOperation('NQ_SelectGridMyProjectValue', '', condition, function (response) {
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
//                    前期项目外出数据
                    dl.callOperation('NQ_SelectGridPreProjectValue', '', {}, function (response) {
                        if (Number(response['ResultSet']['status']) >= 0) {
                            var dataArr1 = dl.parseCollection(response);
                            for (var i = 0; i < dataArr1.length; i++) {
                                var temVal = dataArr1[i];
                                var preTitle = '';
                                preTitle += temVal['projectName'] + "-";
                                preTitle += temVal['projectCode'];
                                temVal['preTitle'] = preTitle;
                            }
                            self.preSubTypes(dataArr1);
                        }
                    });
                    //  项目经理数据
                    var condition2 = {
                        status: 0,
                        plateId: dl.getPlateId()
                    };
                    dl.callOperation('NQ_SelectEmployee', '', condition2, function (response) {
                        if (Number(response['ResultSet']['status']) >= 0) {
                            var data2 = dl.parseCollection(response);
                            self.nextAuditors(data2);
                        }
                    });
                };
                self.handleBindingsApplied = function (info) {
                };
                self.handleDetached = function (info) {
                };
            }

            return stayawayApplyViewModel;
        }
);


