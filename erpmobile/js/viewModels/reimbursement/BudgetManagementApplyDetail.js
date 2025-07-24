define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/msgbox', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojdatetimepicker', 'ojs/ojtimezonedata', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl, sc) {
            function BudgetManagementApplyDetailViewModel(params) {
                var self = this;
                self.viewModelName = 'BudgetManagementApplyDetailViewModel';
                self.specialHeaderTitle = ko.observable('');
                self.isshow = ko.observable(false);
                self.__bdTotalAmount = ko.observable(params.rowData.bdTotalAmount);
                self.__bdApplyTime = ko.observable(params.rowData.bdApplyTime);
                self.__bdEstimatecloseTime = ko.observable(params.rowData.bdEstimatecloseTime);
                self.__bdApplyEmployeeId = ko.observable(params.rowData.bdApplyEmployeeId);
                self.__departmentId = ko.observable(params.rowData.departmentId);
                self.__costBearing = ko.observable(params.rowData.costBearing);
                self.__bdType = ko.observable(params.rowData.bdType);
                self.__bddType = ko.observable('');
                self.__bddAmount = ko.observable();
                self.__companyId = ko.observable(params.rowData.companyId);
                self.__projectId = ko.observable(params.rowData.projectId);
                self.__signingMoneySum = ko.observable();
                self.__percent = ko.observable();
                self.__bdRemark = ko.observable(params.rowData.bdRemark);
//                采买1 行政2 项目3
                if (self.__bdType() == 1 || self.__bdType() == 3) {
                    self.isshow(true);
                };
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                self.dataSource = ko.observable();
                self.dataSource1 = ko.observable();
                self.isApproval = ko.observable(true);
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.resultDataArr = [];
                self.selectedItem = ko.observable("");
//               跳转关联的物品领用的详情页面
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

                self.resultData = null;
                self.processbillListData = null;
                self.specialHeaderTitle = ko.observable('关联的物品领用详情');
                self.datareceived1 = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.dataSource1(new oj.ArrayTableDataSource(arrData, {idAttribute: 'personnelBusinessLinkEquipmentId'}));
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

                //审批后执行的方法
                self.workCallback = function (data) {
                    if (data.ResultSet.status >= 0) {
                        var returnData = dl.parseCollection(data);
                        self.processInstanceId = returnData[0].processInstanceId;
                        dl.getGlobalModule({name: 'schedule', params: self});
                        dl.pushHeader(dl.headerTitle());
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
                    dl.pushPageStack({name: 'reimbursement/BudgetManagementApplyDetail', params: self.parentViewModel});
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
                    //                    关联项目详情
                    var condition = {
                        processInstanceId: params.rowData.processInstanceId
                    };

                    dl.callOperation("EP_GetProcessInstance", 'find', condition, function (data) {
                        var arrData = dl.parseCollection(data);
                        self.resultDataArr.push(arrData[0].userData);
                        var parentId = arrData[0].userData.personnelBusinessId;
                        var processType = arrData[0].userData.processType;
                        self.dataSource(new oj.ArrayTableDataSource(self.resultDataArr, {idAttribute: 'personnelBusinessId'}));
//                        右边部分数据
                        var condition1 = {
                            'parentId': parentId,
                            'processType': processType
                        };

                        dl.callOperation("ST_PersonnelBusinessLinkEquipment", 'find', condition1, self.datareceived1);
                    });
                };

                self.handleBindingsApplied = function (info) {
                };
                self.handleDetached = function (info) {
                };
            }
            return BudgetManagementApplyDetailViewModel;
        }
);


