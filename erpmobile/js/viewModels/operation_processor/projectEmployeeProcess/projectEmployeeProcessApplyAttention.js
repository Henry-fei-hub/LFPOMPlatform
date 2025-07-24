define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/msgbox', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl, sc) {
            function projectEmployeeProcessApplyAttentionViewModel(params) {
                var self = this;
                self.viewModelName = 'projectEmployeeProcessApplyAttentionViewModel';
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
                self.specialHeaderTitle = ko.observable('');
                self.chooseStatus = function (num) {
                    switch (Number(num)) {
                        case 1:
                            return '成功';
                            break;
                        case 2:
                            return '历史版本';
                            break;
                        case 3:
                            return '报价中';
                            break;
                    }
                };
                self.datareceived = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.dataSource(new oj.ArrayTableDataSource(arrData, {idAttribute: 'personnelBusinessId'}));
                    dl.headerTitle(params.rowData.projectName);
//                    进入即阅
                    dl.submitApprovalWork(0, params.rowData, self);
                };
                self.datareceived1 = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.dataSource1(new oj.ArrayTableDataSource(arrData, {idAttribute: 'projectEmployeeId'}));
                };
                //处理节点执行的方法
                self.checkData = function (values) {
                    return true;
                };
                //审批后执行的方法
                self.workCallback = function (data) {
                    if (data.ResultSet.status >= 0) {
                    } else {
                        alert(data.ResultSet.errors);
                    }
                };

                self.getValues = function () {
                    return [];
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
                    dl.pushPageStack({name: 'operation_processor/projectEmployeeProcess/projectEmployeeProcessApplyAttention', params: self.parentViewModel});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle("流程进度");
                };

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    var condition = {
                        personnelBusinessId: params.rowData.businessId,
                    };
                    dl.callOperation("NQ_ProjectEmployeeProcessApplication", 'find', condition, self.datareceived);
                    var condition1 = {
                        businessId: params.rowData.businessId,
                    };
                    dl.callOperation("NQ_OnLoadProjectEmpByProcess", 'find', condition1, self.datareceived1);
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return projectEmployeeProcessApplyAttentionViewModel;
        }
);


