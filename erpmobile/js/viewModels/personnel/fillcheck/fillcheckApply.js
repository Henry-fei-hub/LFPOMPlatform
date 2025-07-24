define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojdatetimepicker', 'ojs/ojjsontreedatasource','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function fillcheckApplyViewModel(params) {
                var self = this;
                self.viewModelName = 'fillcheckApplyViewModel';
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
                self.processbillListData = null;
                self.specialHeaderTitle = ko.observable('');
                self.processID = ko.observable();
                self.processID = 'integer';
                self.processType = 15;//打卡类型
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
                self.__type = ko.observableArray();
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
                    //如果证明人和当前发起人是同一个人,则返回false
                    if (dl.isNullOrEmpty(values.nextAuditor)) {
                        self.errorMessage('♥提示:证明人不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.startDate)) {
                        self.errorMessage('♥提示:漏打卡日期不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.type)) {
                        self.errorMessage('♥提示:签到签退不可为空');
                        return false;
                    }
                    if (Number(dl.getEmployeeId()) === Number(values.nextAuditor)) {
                        self.errorMessage('♥提示:证明人不能选择自己');
                        return false;
                    }
                    return true;
                };
//                STEP2
            self.getValues = function () {
                    //业务数据获取
                    for (var name in self) {
                        if (name.indexOf("__") !== -1) {
//                            给产假的多选框进行处理
                            if (userData['type'] === 1 && name === '__subType') {//产假
                                var val = self[name]();
                                var subType = '';
                                var subTypeStr = '';
                                var arr = self.holidayDetailTypes();
                                for (var i = 0; i < val.length; i++) {
                                    var tmpVal = val[i];
                                    for (var j = 0; j < arr.length; j++) {
                                        if (arr[j]['leaveTypeName'] == tmpVal) {
                                            if (i > 0) {
                                                subType += ',';
                                                subTypeStr += ',';
                                            }
                                            subType += arr[i]['leaveTypeId'];
                                            subTypeStr += arr[i]['leaveTypeName'];
                                            break;
                                        }
                                    }
                                }
                                userData['subType'] = subType;
                                userData['subTypeStr'] = subTypeStr;
                            } else {
                                if (self[name]() instanceof Array) {
                                    userData[name.substring(2)] = self[name]()[0];
                                } else {
                                    userData[name.substring(2)] = self[name]();
                                }
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
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return fillcheckApplyViewModel;
        }
);


