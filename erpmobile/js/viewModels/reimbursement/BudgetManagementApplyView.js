define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/msgbox', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojdatetimepicker', 'ojs/ojtimezonedata', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl, sc) {
            function BudgetManagementApplyViewViewModel(params) {
                var self = this;
                self.viewModelName = 'BudgetManagementApplyViewViewModel';
                self.specialHeaderTitle = ko.observable('');
                self.isShowFilesButton = ko.observable(false);
                self.isShowFiles = ko.observable(false);
                self.isShowFilesTitle = ko.observable(false);
                self.isShowtemplate2 = ko.observable(false);
                self.isShowOrderButton = ko.observable(false);
                self.isShowOrder = ko.observable(false);
                self.isShowOrderTitle = ko.observable(false);
                self.__sheetAmount = ko.observable();
                self.__totalIntegral = ko.observable();
                self.__signingMoneySum = ko.observable();
                self.__bdTotalAmount = ko.observable();
                self.__percent = ko.observable();
                self.__bdType = ko.observable(params.rowData.bdType);
//                采买1 行政2 项目3 外包4
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
                self.dataSource6 = ko.observable();
                self.isApproval = ko.observable(true);
                self.processbillListData = null;
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");

                self.showFiles = function (data, event) {
                    self.isShowFilesButton(false);
                    self.isShowFilesTitle(true);
                    self.isShowFiles(true);
                };
                self.hideFiles = function () {
                    self.isShowFilesButton(true);
                    self.isShowFilesTitle(false);
                    self.isShowFiles(false);
                };
                self.showOrder = function (data, event) {
                    self.isShowOrderButton(false);
                    self.isShowOrderTitle(true);
                    self.isShowOrder(true);
                };
                self.hideOrder = function () {
                    self.isShowOrderButton(true);
                    self.isShowOrderTitle(false);
                    self.isShowOrder(false);
                };
//               跳转关联的物品领用的详情页面
                self.goDetail = function (data, event) {
                    self.rowData = data;
                    dl.getGlobalModule({name: 'reimbursement/BudgetManagementApplyDetail', params: self});
                    dl.pushPageStack({name: 'reimbursement/BudgetManagementApplyView', params: self.parentViewModel});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle('关联的物品领用详情');
                };
                self.toPercent = function (num) {
                    var str = Number(num * 100).toFixed(2);
                    str += '%';
                    return str;
                };
                self.processString = function (ss) {
                    var s = "";
                    for (var i = 0; i < ss.length; i++) {
                        if (ss[i] === '+')
                            s += ' ';
                        else
                            s += ss[i];
                    }
                    return s;
                };


                self.datareceived = function (data) {
                    var arrData = dl.parseCollection(data);
                    var resultData = [];
                    resultData.push(arrData[0].userData);
                    self.resultData = resultData;
                    self.__bdTotalAmount(arrData[0].userData.bdTotalAmount);
                    self.dataSource(new oj.ArrayTableDataSource(resultData, {idAttribute: 'budgetManagementId'}));
                    self.specialHeaderTitle(dl.getLabelByValue('employees', params.rowData.bdApplyEmployeeId) + dl.getLabelByValue('system_dictionary_191', params.rowData.bdType));
                    //    签约合同金额 
                    var condition4 = {
                        projectId: params.rowData.projectId,
                        budgetManagementId: params.rowData.businessId
                    };
                    dl.callOperation("NQ_Mcontractppspcccfscsiiicpor", 'find', condition4, self.datareceived4);
                    if (!dl.isNullOrUndefined(arrData[0].userData.fileId)) {
                        self.isShowFilesButton(true);
                        //                   附件
                        var arrData = dl.parseCollection(data);
                        var condition5 = {
                            fileId: arrData[0].userData.fileId,
                            budgetManagementId: params.rowData.businessId
                        };
                        dl.callOperation("NQ_GetBudgetUplodaNews", 'find', condition5, self.datareceived5);
                    }
                };

                self.datareceived1 = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.processbillListData = arrData;
                    self.dataSource1(new oj.ArrayTableDataSource(arrData, {idAttribute: 'budgetManagementDetailId'}));
                };

                self.datareceived2 = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.dataSource2(new oj.ArrayTableDataSource(arrData, {idAttribute: 'budgetManagementLinkProcessId'}));
                    if (!dl.isNullOrEmpty(arrData)) {
                        self.isShowtemplate2(true);
                    }
                };

                self.datareceived3 = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.__sheetAmount(arrData[0].sheetAmount);
                    self.__totalIntegral(arrData[0].totalIntegral);
                };
                self.datareceived4 = function (data) {
                    var arrData = dl.parseCollection(data);
                    if (arrData.length > 0) {
                        self.__signingMoneySum(arrData[0].signingMoneySum);
                        if (!dl.isNullOrUndefined(self.__signingMoneySum()) && !dl.isNullOrUndefined(self.__bdTotalAmount())) {
                            self.__percent(100 * (Number(self.__bdTotalAmount()) / Number(self.__signingMoneySum())));
                        }
                    }
                    //                   合同订单
                    var condition6 = {
                        contractId: arrData[0].contractId
                    };
                    dl.callOperation("NQ_Mcontractppspcccfscsiiicpor", 'find', condition6, self.datareceived6);
                };
                self.datareceived5 = function (data) {
                    var arrData = dl.parseCollection(data);

                    self.dataSource5(new oj.ArrayTableDataSource(arrData, {idAttribute: 'fileId'}));
                };
                self.datareceived6 = function (data) {
                    var arrData = dl.parseCollection(data);
                    if (!dl.isNullOrEmpty(arrData)) {
                        self.isShowOrderButton(true);
                    }
                    self.dataSource6(new oj.ArrayTableDataSource(arrData, {idAttribute: 'contractId'}));
                };
                //处理节点执行的方法
                self.checkData = function (values) {
                    return true;
                };

                self.getValues = function () {
                    //业务数据获取
                    var userData = self.resultData;
                    userData[0].detailBudgetManagementDetail = self.processbillListData;
                    return userData[0];
                };

                //审批后执行的方法
                self.workCallback = function (data) {
                    if (data.ResultSet.status >= 0) {
                        var returnData = dl.parseCollection(data);
                        self.processInstanceId = returnData[0].processInstanceId;
                        dl.getGlobalModule({name: 'schedule', params: self});
                        // view页面不要push title        dl.pushHeader(dl.headerTitle());
                        dl.headerTitle("流程进度");
                    } else {
                        alert(data.ResultSet.errors);
                    }
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
//                进度按钮
                self.jinduClick = function (data, event) {
                    self.processInstanceId = self.parentViewModel.rowData.processInstanceId;
                    dl.getGlobalModule({name: 'schedule', params: self});
                    dl.pushPageStack({name: 'reimbursement/BudgetManagementApplyView', params: self.parentViewModel});
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
                        processInstanceId: params.rowData.processInstanceId
                    };
                    dl.callOperation("EP_GetProcessInstance", 'find', condition, self.datareceived);


                    var condition1 = {
                        budgetManagementId: params.rowData.businessId
                    };
                    dl.callOperation("ST_BudgetManagementDetail", 'find', condition1, self.datareceived1);

//                    关联项目
                    var condition2 = {
                        budgetManagementId: params.rowData.businessId
                    };
                    dl.callOperation("ST_BudgetManagementLinkProcess", 'find', condition2, self.datareceived2);

                    //    订单合同金额 订单总积分
                    var condition3 = {
                        projectId: params.rowData.projectId
                    };
                    dl.callOperation("ST_Project", 'find', condition3, self.datareceived3);


                };

                self.handleBindingsApplied = function (info) {
                };
                self.handleDetached = function (info) {
                };
            }
            return BudgetManagementApplyViewViewModel;
        }
);


