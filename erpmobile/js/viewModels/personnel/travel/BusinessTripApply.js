
define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojbutton', 'ojs/ojcheckboxset', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojdatetimepicker'],
        function (oj, ko, $, dl) {

            function BusinessTripApplyViewModel(params) {
                var self = this;
                self.viewModelName = 'BusinessTripApplyViewModel';
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
                self.processType = 14; //非项目出差申请 
                self.errorMessage = ko.observable();
                //__drafter新增
                self.__employeeId = ko.observable(dl.getEmployeeId());
                self.__drafter = ko.observable(dl.getEmployeeId());
                self.__employeeNo = ko.observable(dl.getEmployeeNo());
                self.__departmentId = ko.observable(dl.getDepartmentId());
                self.__companyId = ko.observable();
                self.__days = ko.observable();
                self.__startDate = ko.observable();
                self.__endDate = ko.observable();
                self.__startDateDetail = ko.observable();
                self.__endDateDetail = ko.observable();
                self.__address = ko.observable();
                self.__remark = ko.observable();
                self.__reason = ko.observable();
                self.__transportation = ko.observable();
                self.__plan = ko.observable();
                self.__fee = ko.observable();
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
                    if (dl.isNullOrEmpty(values.companyId)) {
                        self.errorMessage('♥提示:归属公司不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.reason)) {
                        self.errorMessage('♥提示:请假原由不可为空');
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
                    if (values.endDate < values.startDate) {
                        self.errorMessage('♥提示:结束日期不可小于开始日期');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.startDateDetail)) {
                        self.errorMessage('♥提示:开始时段不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.endDateDetail)) {
                        self.errorMessage('♥提示:结束时段不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.address)) {
                        self.errorMessage('♥提示:出差地址不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.transportation)) {
                        self.errorMessage('♥提示:交通工具不可为空');
                        return false;
                    }
                    return true;
                };
                //2. self 当前整个模块
                self.getValues = function () {
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
//               天数
                self.check = function (a, b, c, d) {
                    if (!dl.isNullOrUndefined(a) && !dl.isNullOrUndefined(b) && !dl.isNullOrUndefined(c) && !dl.isNullOrUndefined(d)) {
                        var condition = {};
                        condition = self.getValues();
                        condition['optType'] = 'calculateTripDays';
                        condition['startDate'] = a;
                        condition['endDate'] = b;
//                        数组转成数字
                        condition['startDateDetail'] = c[0];
                        condition['endDateDetail'] = d[0];
                        dl.callOperation("EP_MyPersonnelProcessor", '', condition, function (response) {
                            if (response['ResultSet']['status'] >= 0) {
                                self.errorMsg('');
                                var arr = dl.parseCollection(response);
                                if (!dl.isNullOrEmpty(arr)) {
                                    self.__days(arr[0]['days']);
                                }
                            } else {
                                self.errorMsg(response['ResultSet']['errors']);
                            }
                        })
                    }
                };
//              根据开始结束时间获取外出天数 
                self.__startDate.subscribe(function (val) {
                    self.check(self.__startDate(), self.__endDate(), self.__startDateDetail(), self.__endDateDetail());

                });
                self.__endDate.subscribe(function (val) {
                    self.check(self.__startDate(), self.__endDate(), self.__startDateDetail(), self.__endDateDetail());
                });
                self.__startDateDetail.subscribe(function (val) {
                    self.check(self.__startDate(), self.__endDate(), self.__startDateDetail(), self.__endDateDetail());

                });
                self.__endDateDetail.subscribe(function (val) {
                    self.check(self.__startDate(), self.__endDate(), self.__startDateDetail(), self.__endDateDetail());
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
                };
                self.handleBindingsApplied = function (info) {
                };
                self.handleDetached = function (info) {
                };
            }

            return BusinessTripApplyViewModel;
        }
);


