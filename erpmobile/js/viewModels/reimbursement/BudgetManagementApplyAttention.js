define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function BudgetManagementApplyAttentionViewModel(params) {
                var self = this;
                self.viewModelName = 'BudgetManagementApplyAttentionViewModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                self.isShowFilesButton = ko.observable(false);
                self.isShowFiles = ko.observable(false);
                self.isShowFilesTitle = ko.observable(false);
                self.isShowtemplate2 = ko.observable(false);
                self.isShowOrderButton = ko.observable(false);
                self.isShowOrder = ko.observable(false);
                self.isShowOrderTitle = ko.observable(false);
                self.dataSource = ko.observable();
                self.dataSource1 = ko.observable();
                self.dataSource2 = ko.observable();
                self.dataSource3 = ko.observable();
                self.dataSource4 = ko.observable();
                self.dataSource5 = ko.observable();
                self.dataSource6 = ko.observable();
                self.__sheetAmount = ko.observable();
                self.__totalIntegral = ko.observable();
                self.__signingMoneySum = ko.observable();
                self.__bdTotalAmount = ko.observable();
                self.__percent = ko.observable();
                self.__bdType = ko.observable(params.rowData.bdType);
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.resultData = null;
                self.processbillListData = null;
                self.specialHeaderTitle = ko.observable('');

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
                        ``
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
//                    进入即阅
                    dl.submitApprovalWork(0, params.rowData, self);
                };

                //处理节点执行的方法
                self.checkData = function (values) {
                    return true;
                };
                //业务数据获取  获取页面的数据
                self.getValues = function () {
                    return [];
                };

                //已阅后执行的方法  回调函数
                self.workCallback = function (data) {
                    if (data.ResultSet.status >= 0) {

                    } else {
                        alert(data.ResultSet.errors);
                    }
                };

//                进度按钮
                self.jinduClick = function (data, event) {
                    self.processInstanceId = self.parentViewModel.rowData.processInstanceId;
                    dl.getGlobalModule({name: 'schedule', params: self});
                    dl.pushPageStack({name: 'reimbursement/BudgetManagementApplyAttention', params: self.parentViewModel, cacheKey: 'reimbursement/BudgetManagementApplyAttention'});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle("流程进度");
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
                    debugger;
                    var arrData = dl.parseCollection(data);
                    self.__signingMoneySum(arrData[0].signingMoneySum);
                    console.log(self.__signingMoneySum());
                    console.log(self.__bdTotalAmount());
                    if (!dl.isNullOrUndefined(self.__signingMoneySum()) && !dl.isNullOrUndefined(self.__bdTotalAmount())) {
                        self.__percent(100 * (Number(self.__bdTotalAmount()) / Number(self.__signingMoneySum())));
                    }

                    //                   合同订单
                    var condition6 = {
                        contractId: arrData[0].contractId
                    };
                    dl.callOperation("NQ_Mcontractppspcccfscsiiicpor", 'find', condition6, self.datareceived6);
                };
                self.datareceived5 = function (data) {
                    debugger;
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
                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {

                };
                self.handleAttached = function (info) {
                    var pageFlag = self.parentViewModel.rowData['pageFlag'];
                    var condition = {
                        processInstanceId: params.rowData.processInstanceId
                    };
                    dl.callOperation("EP_GetProcessInstance", 'find', condition, self.datareceived);

                    var condition1 = {
                        budgetManagementId: params.rowData.businessId
                    };
                    dl.callOperation("ST_BudgetManagementDetail", 'find', condition1, self.datareceived1);
                };

                //    订单合同金额 订单总积分
                var condition3 = {
                    projectId: params.rowData.projectId
                };
                dl.callOperation("ST_Project", 'find', condition3, self.datareceived3);


                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return BudgetManagementApplyAttentionViewModel;
        }
);


