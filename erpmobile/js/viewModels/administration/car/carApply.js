
define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojdatetimepicker', 'ojs/ojjsontreedatasource','ojs/ojformlayout', 'ojs/ojarraydatagriddatasource'],
        function (oj, ko, $, dl) {

            function carApplyViewModel(params) {
                var self = this;
                self.viewModelName = 'carApplyViewModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.showbox = ko.observable(false);
                var optionsArr = [];
                var preDataArr = [];
                var contractDataArr = [];
                self.selectedItem = ko.observable("");
                self.resultData = ko.observableArray();
                self.processbillListData = null;
                self.specialHeaderTitle = ko.observable('');
                self.processID = ko.observable();
                self.processID = 'integer';
                self.processType = 33;//用车类型
                self.errorMessage = ko.observable();
                self.errorMessage.dataType = 'string';
                var userData = {};
                self.ulShow = ko.observable('0');
                //__drafter新增
                self.__drafter = ko.observable(dl.getEmployeeId());
                self.__employeeId = ko.observable(dl.getEmployeeId());
                self.__companyId = ko.observable(dl.getCompanyId());
                self.__employeeNo = ko.observable(dl.getEmployeeNo());
                self.__departmentId = ko.observable(dl.getDepartmentId());
                self.__isRemoteCity=ko.observable(false);
                self.__nextAuditor = ko.observable();
                self.__card = ko.observable();
                self.__unit = ko.observable();
                self.__reason = ko.observable();
                self.__endDate = ko.observable();
                self.__startDate = ko.observable();
                self.__startDateDetail = ko.observable();
                self.__type = ko.observable();
                self.__address = ko.observable();
                self.__projectName = ko.observable("公司（科兴科学园）");
                self.__endDateDetail = ko.observable();
                self.__projectCode = ko.observable();
                self.__livingExpenses = ko.observable();
                self.__reason = ko.observable();
                self.__plan = ko.observable();
                self.__remark = ko.observable();
                 self.dataProvider = ko.observable();
                self.__costAllocation = ko.observable();
                self.__percent = ko.observable();
                self.__cost = ko.observable();
                self.__name = ko.observable();
                self.__code = ko.observable();
                self.__id = ko.observable();
                self.isshow = ko.observable(false);
                self.isshowDetail1 = ko.observable(false);
                self.isshowDetail2 = ko.observable(false);
                self.isshowDetail3 = ko.observable(false);
                self.isdisable = ko.observable(true);
                self.preProjects = ko.observableArray([]);
                self.contractProjects = ko.observableArray([]);
                self.__detailCarCostAllocation = ko.observableArray([]);
                self.__startDateDetail.subscribe(function (val) {
                    switch (Number(val)) {
                        case(1):
                            self.isshowDetail1(true);
                            self.isshowDetail2(false);
                            self.isshowDetail3(false);
                            self.isshow(false);
                            break;
                        case(2):
                            self.isshowDetail1(false);
                            self.isshowDetail2(true);
                            self.isshowDetail3(false);
                            self.isshow(true);
                            break;
                        case(3):
                            self.isshowDetail1(false);
                            self.isshowDetail2(false);
                            self.isshowDetail3(true);
                            self.isshow(false);
                            break;
                    }
                });
                self.__id.subscribe(function (val) {
                    if (!dl.isNullOrEmpty(val) && val instanceof Array) {
                        newVal = val[0];
                    } else {
                        newVal = val;
                    }
                    ;
                    if (self.__startDateDetail()[0] == 1) {
                        for (var i = 0; i < contractDataArr.length; i++) {
                            if (contractDataArr[i]['projectId'] == newVal) {
                                self.__code(contractDataArr[i]['contractCode']);
                                self.__name(contractDataArr[i]['projectName']);
                            }
                        }
                    } else if (self.__startDateDetail()[0] == 2) {
                        for (var i = 0; i < preDataArr.length; i++) {
                            if (preDataArr[i]['preProjectReimbursementNumberId'] == newVal) {
                                self.__code(preDataArr[i]['customNumber']);
                                self.__name(preDataArr[i]['projectName']);
                            }
                        }
                    } else {
                        self.__code('');
                        self.__name('');
                    }
                    ;
                });
                //          按钮的返回事件
                self.rebackToClick = function (event, ui) {
                    if (self.ulShow() == 1) {
                        self.ulShow(0);
                    } else {          
                        dl.getGlobalModule(dl.popPageStack());
                        dl.headerTitle(dl.popHeader());
                    }
                };
                self.addOne = function () {
                 self.ulShow(1);
                };
                self.deleteFun = function () {
                    self.__detailCarCostAllocation.pop();
                    self.__id('');
                    self.__code('');
                    self.__name('');
                    self.__cost('');
                    self.__percent('');
                    self.__costAllocation('');
                    console.log(self.__detailCarCostAllocation());
                };
                self.save = function () {
                    var newObj = {id: self.__id(), code: self.__code(), name: self.__name(), cost: self.__cost(), percent: self.__percent(), costAllocation: self.__costAllocation(),type:self.__type()[0]};
                    self.__detailCarCostAllocation.push(newObj);
                    self.__id('');
                    self.__code('');
                    self.__name('');
                    self.__percent('');
                    self.__costAllocation('');
                    console.log(self.__detailCarCostAllocation());
                };
                self.datareceived0 = function (data) {
                    var arrData = dl.parseCollection(data);
                    if (arrData.length > 0) {
                        self.processID = arrData[0]['idd'];
                    }
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
                    if (dl.isNullOrEmpty(values.card)) {
                        self.errorMessage('♥提示:电话号码不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.unit)) {
                        self.errorMessage('♥提示:同行人数不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.startDate)) {
                        self.errorMessage('♥提示:用车开始时间不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.endDate)) {
                        self.errorMessage('♥提示:预计结束时间不可为空');
                        return false;
                    }if (new Date(values.endDate).getTime()< new Date(values.startDate).getTime()) {
                        self.errorMessage('♥提示:用车结束时间必须晚于用车开始时间');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.startDateDetail)) {
                        self.errorMessage('♥提示:用车类型不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.type)) {
                        self.errorMessage('♥提示:用车范围不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.address)) {
                        self.errorMessage('♥提示:申请用车车型不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.projectName)) {
                        self.errorMessage('♥提示:出发地不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.endDateDetail)) {
                        self.errorMessage('♥提示:目的地所在区域不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.projectCode)) {
                        self.errorMessage('♥提示:目的地详细地址不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.reason)) {
                        self.errorMessage('♥提示:用车目的不可为空');
                        return false;
                    }
                    if (values.startDateDetail==2) {
                        if(dl.isNullOrEmpty(values.nextAuditor)){
                            self.errorMessage('♥提示:请选择前期项目的项目经理');
                            return false;
                       }
                    }
                    
                    return true;
                };
//                STEP2
                self.getValues = function () {
                    //业务数据获取
                    for (var name in self) {
                        if (name.indexOf("__") !== -1) {

                            if (self[name]() instanceof Array) {
                                if (name.indexOf("detailCarCostAllocation") !== -1) {
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
                    var condition0 = {
                        employeeId: dl.getEmployeeId(),
                        processTypeId: self.processType
                    };
                    dl.callOperation("NQ_EmployeeProcess", 'find', condition0, self.datareceived0);
                    self.errorMessage('');
                    //  前期项目下拉值
                    var condition = {};
                    dl.callOperation("NQ_SelectGridPreProjectValue", 'find', condition, function (response) {
                        if (Number(response['ResultSet']['status']) >= 0) {
                            preDataArr = dl.parseCollection(response);
                            var selectDataArr = [];
                            for (var i = 0; i < preDataArr.length; i++) {
                                var obj = {value: '', label: ''};
                                obj.label = preDataArr[i]['projectName'];
                                obj.value = preDataArr[i]['preProjectReimbursementNumberId'];
                                selectDataArr.push(obj);
                            }
                            self.preProjects(selectDataArr);
                        }
                    });
//                                     订单下拉值
                    var condition2 = {
                        employeeId: dl.getEmployeeId()
                    };
                    dl.callOperation("NQ_SelectGridMyProjectValue", 'find', condition2, function (response) {
                        if (Number(response['ResultSet']['status']) >= 0) {
                            contractDataArr = dl.parseCollection(response);
                            var selectDataArr = [];
                            for (var i = 0; i < contractDataArr.length; i++) {
                                var obj = {value: '', label: ''};
                                obj.label = contractDataArr[i]['projectName'];
                                obj.value = contractDataArr[i]['projectId'];
                                selectDataArr.push(obj);
                            }
                            self.contractProjects(selectDataArr);
                        }
                    });
//                //        预计用车费用
                self.__endDateDetail.subscribe(function(val){
                      var htype = val;
                    if (val instanceof Array && val.length > 0)
                        htype = val[0];
                    self.__endDateDetail(htype);
                    var condition3 = {
                        'optType': 'onGetUseCarPrice',
                         'useCarPriceId': self.__endDateDetail(),
                         'carType': self.__address()[0]     
                    };
                    dl.callOperation("EP_OnProjectWithStageCommon",'', condition3, function (response) {
                        if (Number(response['ResultSet']['status']) >= 0) {
                            var data = dl.parseCollection(response);
                            if(!dl.isNullOrEmpty(data)){
                            var price = data[0].price;
                           self.__livingExpenses(price);
                          self.__cost(price);
                            }
                        }
                    });     
                });
               self.__address.subscribe(function(val){
                      var htype = val;
                    if (val instanceof Array && val.length > 0)
                        htype = val[0];
                    self.__address(htype);
                    var condition3 = {
                        'optType': 'onGetUseCarPrice',
                         'useCarPriceId': self.__endDateDetail(),
                         'carType': self.__address()[0]     
                    };
                    dl.callOperation("EP_OnProjectWithStageCommon",'', condition3, function (response) {
                        if (Number(response['ResultSet']['status']) >= 0) {
                            var data = dl.parseCollection(response);
                            if(!dl.isNullOrEmpty(data)){
                            var price = data[0].price;
                           self.__livingExpenses(price);
                          self.__cost(price);
                            }
                        }
                    });     
                });
               self.__percent.subscribe(function(val){
                   console.log(self.__cost()*(val/100));
                   self.__costAllocation(self.__cost()*(val/100));
               });
                    
               self.__livingExpenses.subscribe(function(val){
                   self.__cost(val);
               });
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return carApplyViewModel;
        }
);


