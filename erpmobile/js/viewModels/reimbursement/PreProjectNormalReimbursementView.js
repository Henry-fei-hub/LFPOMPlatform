define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/msgbox', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl, sc) {
            function PreProjectNormalReimbursementViewViewModel(params) {
                var self = this;
                self.viewModelName = 'PreProjectNormalReimbursementViewViewModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                self.isApproval = ko.observable(true);
                self.dataSource = ko.observable();
                self.dataSource1 = ko.observable();
                self.dataSource2 = ko.observable();
                self.dataSource3 = ko.observable();
                self.projectArr = ko.observableArray();

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
                self.specialHeaderTitle = ko.observable('');

                self.datareceived = function (data) {
                     var arr = [];
                    var arrData = dl.parseCollection(data);
                    arr.push(arrData[0].userData);
                    self.resultData = arr;
                    self.dataSource(new oj.ArrayTableDataSource(arr, {idAttribute: 'projectNormalReimbursementId'}));
                    //差旅报销费用清单
                    self.dataSource1(new oj.ArrayTableDataSource(arrData[0].userData.detailProjectNormalReimbursementDetail, {idAttribute: 'projectNormalReimbursementDetailId'}));
                    //费用分拆
                    self.dataSource2(new oj.ArrayTableDataSource(arrData[0].userData.detailNormalReimbursementLinkMainProject, {idAttribute: 'normalReimbursementLinkMainProjectId'}));
                    //  某人的报销页面的标题以报销人+主题 
                    self.specialHeaderTitle(dl.getLabelByValue('employees', arrData[0].userData['employeeId']) + arrData[0].userData['reimbursementName']);
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
                    dl.pushPageStack({name: 'reimbursement/PreProjectNormalReimbursementView', params: self.parentViewModel});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle("流程进度");
                };

                self.datareceivedBillList = function (data) {
                    //账单流水数据
                    var arrData = data.ResultSet.Result;
                    self.dataSource3(new oj.ArrayTableDataSource(arrData), {idAttribute: 'processBillListId'});
                    self.processbillListData = arrData;
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
                    dl.callOperation("EP_CustomPreCodeProjectName", 'find', {}, function (data) {
                        var arr1 = dl.parseCollection(data);
                        var projectArr = [];
                        for (var i = 0; i < arr1.length; i++) {
                            var obj = {};
                            obj.value = arr1[i].preProjectReimbursementNumberId;
                            obj.key = arr1[i].projectName.split('--')[1];
                            self.projectArr().push(obj);
                        }
                    })
                    var condition = {
                        processInstanceId: params.rowData.processInstanceId,
                        includeDetail: true
                    };
                    dl.callOperation("EP_GetProcessInstance", 'find', condition, self.datareceived);

                    var condition1 = {
                        opt_type: "getBillListByBusinessidProcesstype",
                        processType: params.rowData.processType,
                        businessId: params.rowData.businessId
                    };
                    dl.callOperation("EP_CustomSprocessbilllistppporProcess", 'find', condition1, self.datareceivedBillList);
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return PreProjectNormalReimbursementViewViewModel;
        }
);


