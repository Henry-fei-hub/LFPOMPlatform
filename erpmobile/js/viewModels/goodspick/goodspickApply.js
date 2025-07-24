
define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojbutton', 'ojs/ojcheckboxset', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojdatetimepicker'],
        function (oj, ko, $, dl) {

            function goodspickApplyViewModel(params) {
                var self = this;
                self.viewModelName = 'goodspickApplyViewModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                self.dataSource = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.resultData = ko.observableArray();
                self.processbillListData = null;
                self.specialHeaderTitle = ko.observable('');
                self.processID = ko.observable();
                self.processType = 13;//物品领用类型
                self.errorMessage = ko.observable();
//                self.subok = ko.observable('0');
////               是否显示errorMsg 判断信息对错
                self.isType = ko.observable('0');
                //__drafter新增
                self.__drafter = ko.observable(dl.getEmployeeId());
                self.__employeeId = ko.observable(dl.getEmployeeId());
                self.__companyProvince = ko.observable();
                self.__employeeNo = ko.observable(dl.getEmployeeNo());
                self.__departmentId = ko.observable(dl.getDepartmentId());
                
                self.__subject = ko.observable();
                self.__receiveDate = ko.observable();
                self.__goodsDetail = ko.observableArray();
                self.__count = ko.observable();
              
                var userData = {};
//          按钮的返回事件
                self.rebackToClick = function (event, ui) {
                    if (self.ulShow() == 1) {
                        self.ulShow(0);
                    } else {          
                        dl.getGlobalModule(dl.popPageStack());
                        dl.headerTitle(dl.popHeader());
                    }
                };


                self.datareceived1 = function (data) {
                    var arrData = dl.parseCollection(data);
                    if (arrData.length > 0) {
                        self.processID = arrData[0]['idd'];
                    }
                };


                //处理节点执行的方法
                self.checkData = function (values) {
                    if (dl.isNullOrEmpty(values)) {
                        self.errorMessage('♥提示:数据异常不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.subject)) {
                        self.errorMessage('♥提示:主题不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.receiveDate)) {
                        self.errorMessage('♥提示:日期不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.goodsDetail)) {
                        self.errorMessage('♥提示:物品不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.count)) {
                        self.errorMessage('♥提示:数量不可为空');
                        return false;
                    }
                    return true;
                };
                             //self 当前整个模块
                self.getValues = function () {
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

                // 取消按钮   返回
                self.cancleClick = function (data, event) {
                    self.rebackToClick();
                };

//                // 提交按钮   跳进度
                self.submitClick = function (data, event) {
                    var paramData = {
                        systemProcessApplyId: 1,
                        activityType: 4,
                        operatorId: dl.getEmployeeId(),
                        processDefinition: {processId: self.processID}
                    };
                    dl.submitApprovalWork(0, paramData, self, '', '');

                };

                //审批后执行的方法
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

            return goodspickApplyViewModel;
        }
);


