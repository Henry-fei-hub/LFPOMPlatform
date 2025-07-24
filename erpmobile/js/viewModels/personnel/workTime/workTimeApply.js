define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojdatetimepicker', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function workTimeApplyViewModel(params) {
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
                self.selectedItem = ko.observable("");
                self.resultData = ko.observableArray();
                self.__workHoursDetails = ko.observableArray([]);
                self.specialHeaderTitle = ko.observable('');
                self.processID = ko.observable();
                self.processID = 'integer';
                self.processType = 84;
                self.errorMessage = ko.observable();
                self.errorMessage.dataType = 'string';
                var updateIndex;
                var userData = {};
                self.__employeeId = ko.observable(dl.getEmployeeId());
                self.__employeeNo = ko.observable(dl.getEmployeeNo());
                self.__departmentId = ko.observable(dl.getDepartmentId());
                self.__companyId = ko.observable(dl.getCompanyId());
                self.__startDate = ko.observable(new Date().getTime());
                console.log(self.__startDate());
                self.__remark = ko.observable();
                self.workHour = ko.observable();
                self.projectId = ko.observable();
                self.projectName = ko.observable();
                self.projectCode = ko.observable();
                self.addPicShow = ko.observable(false);
                self.updatePicShow = ko.observable(false);

                self.datareceived1 = function (data) {
                    var arrData = dl.parseCollection(data);
                    if (arrData.length > 0) {
                        self.processID = arrData[0]['idd'];
                    }
                };
                self.addDetail = function () {
                    self.addPicShow(true);
                };
                self.projectId.subscribe(function (val) {
                    if (!dl.isNullOrEmpty(val) && val instanceof Array) {
                        newVal = val[0];
                    } else {
                        newVal = val;
                    }
                    self.projectCode(dl.getLabelByValue('main_projects_code', newVal));
                });
                self.saveClick = function () {
                    if (dl.isNullOrEmpty(self.projectCode())|| dl.isNullOrEmpty(self.projectId())|| dl.isNullOrEmpty(self.workHour())  ) {
                        self.errorMessage('♥提示:请填写所有项目信息');
                        return false;
                    } else {
                        var obj = {projectCode: self.projectCode(),  projectId: self.projectId()[0], workHour: self.workHour()};
                        self.__workHoursDetails.push(obj);
                        console.log(self.__workHoursDetails());
                        self.addPicShow(false);
                        self.projectCode('');
                        self.projectId('请输入');
                        self.projectName(' ');
                        self.workHour('');
                          self.errorMessage('');
                    }
                };
                self.saveUpdateClick = function () {
                    var obj = {projectCode: self.projectCode(), projectId: self.projectId(), workHour: self.workHour()};
                    self.__workHoursDetails.splice(updateIndex, 1, obj);
                    self.updatePicShow(false);
                    self.projectCode('');
                    self.projectName('');
                    self.projectId('');
                    self.workHour('');
                };


                self.updateClick = function (data, event) {
                    self.updatePicShow(true);
                    updateIndex = event.currentTarget.id;
                    self.projectCode(self.__workHoursDetails()[updateIndex].projectCode);
                    self.projectName( dl.getLabelByValue('main_projects_name', self.__workHoursDetails()[updateIndex].projectId)); 
                    self.projectId(self.__workHoursDetails()[updateIndex].projectId);
                    self.workHour(self.__workHoursDetails()[updateIndex].workHour);
                };

                self.deleteClick = function (data, event) {
                    self.__workHoursDetails.splice(event.currentTarget.id, 1);
                };

                //处理节点执行的方法   STEP3
                self.checkData = function (values) {
                    //如果为空则返回false
                    if (dl.isNullOrEmpty(values)) {
                        self.errorMessage('♥提示:数据异常');
                        return false;
                    }
                    if (new Date(values.startDate).getTime() - new Date().getTime() >0) {
                        self.errorMessage('♥提示:当前日期不能选择今天之后的时间');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.workHoursDetails)) {
                        self.errorMessage('♥提示:请填写项目信息');
                        return false;
                    }
                    return true;
                };
//                STEP2
                self.getValues = function () {
                    //业务数据获取
                    for (var name in self) {
                        if (name.indexOf("__") !== -1) {

                            if (self[name]() instanceof Array) {
                                if (name.indexOf("workHoursDetails") !== -1) {
                                    userData[name.substring(2)] = self[name]();
                                } else {
                                    userData[name.substring(2)] = self[name]()[0];
                                }

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

            return workTimeApplyViewModel;
        }
);


