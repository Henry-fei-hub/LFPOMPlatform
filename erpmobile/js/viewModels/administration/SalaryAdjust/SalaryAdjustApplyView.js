define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/msgbox', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl, sc) {
            function SalaryAdjustApplyViewViewModel(params) {
                var self = this;
                self.viewModelName = 'SalaryAdjustApplyViewViewModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                self.dataSource = ko.observable();
                self.dataSource1 = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.resultData = ko.observable();
                self.processbillListData = null;
                self.specialHeaderTitle = ko.observable('');
                self.isApproval = ko.observable(true);
//                判断是否可以修改  3即可修改
                self.updateKey = ko.observable(params.rowData.activityType);
                self.__dutyId = ko.observable();
                self.__type = ko.observable();
                self.__employeeId = ko.observable();
                self.__employeeNo = ko.observable();
                self.__departmentId = ko.observable();
                self.__remark = ko.observable();
//               调薪日期
                self.__endDate = ko.observable();
//                现薪资
                self.__originalPay = ko.observable();
//               本次调薪金额 
                self.__severance = ko.observable();
//                调整后薪资总额
                self.__monthPay = ko.observable();
//                调薪比例
                self.__subType = ko.observable();
                self.__severance.subscribe(function (val) {
                    //  动态监听函数不能用template模块
                    //                调整后薪资总额
                    self.__monthPay(Number(self.__originalPay()) + Number(val));
                    //                  调薪比例
                    self.__subType((val / self.__originalPay()) * 100);
                });
                self.datareceived = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.resultData = arrData;
                    self.dataSource(new oj.ArrayTableDataSource(self.resultData, {idAttribute: 'personnelBusinessId'}));
                    //  某人的报销页面的标题以报销人+主题 
                    self.specialHeaderTitle(dl.getLabelByValue('employees', arrData[0]['employeeId']) + dl.getLabelByValue('departments', arrData[0]['departmentId']));
                    self.__employeeId(arrData[0]['employeeId']);
                    self.__employeeNo(arrData[0]['employeeNo']);
                    self.__departmentId(arrData[0]['departmentId']);
                    self.__dutyId(arrData[0]['dutyId']);
                    self.__type(arrData[0]['type']);
                    self.__remark(arrData[0]['remark']);
                    // 调薪日期
                    self.__endDate(arrData[0]['endDate']);
                    self.__originalPay(arrData[0]['originalPay']);
                    //               本次调薪金额 
                    self.__severance(arrData[0]['severance']);
                    //                  调薪比例
                    self.__subType(arrData[0]['subType']);
                };

//                self.__severance.subscribe(function (val) {
//                    //  动态监听函数不能用template模块
//                    //                调整后薪资总额
//                    self.__monthPay(Number(self.__originalPay()) + Number(val));
//                    //                  调薪比例
//                    self.__subType((val / self.__originalPay()).toFixed(2));
//                    self.resultData[0]['severance'] = self.__severance();
//                    self.resultData[0]['monthPay'] = self.__monthPay();
//                    self.resultData[0]['subType'] = self.__subType();
//                });

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
                //处理节点执行的方法
                self.checkData = function (values) {
                    return true;
                };
                self.getValues = function () {
                    //业务数据获取
                    var userData = self.resultData;
                    userData[0].detailProcessBillListApply = self.processbillListData;
                    return userData[0];
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
                    dl.pushPageStack({name: 'administration/SalaryAdjust/SalaryAdjustApplyView', params: self.parentViewModel});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle("流程进度");
                };

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    self.pageFlag = self.parentViewModel.rowData['pageFlag'];//pageFlag不为空且等于1时表示从我的申请点击进入此页面
                    if (!dl.isNullOrUndefined(self.pageFlag) && (self.pageFlag === 1 || self.pageFlag === 2)) {
                        self.isApproval(false);
                    } else {
                        self.isApproval(true);
                    }
                    var condition = {
                        personnelBusinessId: params.rowData.businessId
                    };
                    dl.callOperation("NQ_DecryptPersonnelBusiness", 'find', condition, self.datareceived);


                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return SalaryAdjustApplyViewViewModel;
        }
);


