define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function failInAtenderApplyViewViewModel(params) {
                var self = this;
                self.viewModelName = 'failInAtenderApplyViewViewModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observableArray([]);//审批人
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

                self.datareceived = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.resultData = arrData;
                    self.dataSource(new oj.ArrayTableDataSource(arrData, {idAttribute: 'personnelBusinessId'}));
                    self.specialHeaderTitle(dl.getLabelByValue('employees', arrData[0]['employeeId']) + '___' + arrData[0]['projectName']);

                };
                self.datareceived1 = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.processbillListData = arrData;
                    self.dataSource1(new oj.ArrayTableDataSource(arrData, {idAttribute: 'projectId'}));
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

                self.getValues = function () {
                    //业务数据获取
                    var userData = self.resultData;
                    userData[0].detailproject = self.processbillListData;
                    return userData[0];
                };

                //提交审批
                self.submitClick = function (data, event) {
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
                };

                //进度按钮
                self.jinduClick = function (data, event) {
                    self.processInstanceId = self.parentViewModel.rowData.processInstanceId;
                    dl.getGlobalModule({name: 'schedule', params: self});
                    dl.pushPageStack({name: 'operation_processor/failInAtender/failInAtenderApplyView', params: self.parentViewModel});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle("流程进度");
                };
                //处理节点执行的方法
                self.checkData = function (values) {
                    return true;
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
                        personnelBusinessId:  params.rowData.personnelBusinessId
                    };
                    dl.callOperation("NQ_BidPaySheetProject", '', condition, self.datareceived);

                    var condition1 = {
                        contractId: params.rowData.linkId,
                        projectType: '66'
                    };
                    dl.callOperation("ST_Project", '', condition1, self.datareceived1);
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return failInAtenderApplyViewViewModel;
        }
);


