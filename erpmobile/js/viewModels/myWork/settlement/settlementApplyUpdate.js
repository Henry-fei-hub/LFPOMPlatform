define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojdatetimepicker', 'ojs/ojjsontreedatasource','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function fillcheckUpdateViewModel(params) {
                var self = this;
                self.viewModelName = 'fillcheckUpdateViewModel';
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
                self.dataSource = new oj.ArrayTableDataSource(self.resultData, {idAttribute: 'personnelBusinessId'});
                self.datareceived = function (data) {
                    var arrData = dl.parseCollection(data);
                    for (var i = 0; i < arrData.length; i++) {
                        if (!dl.isNullOrUndefined(arrData[i]['startDate'])) {
                            arrData[i]['startDate'] = dl.parseValueFromService(arrData[i]['startDate']);
                        }
                    }
                    self.resultData(arrData);
                };

                //处理节点执行的方法
                self.checkData = function (values) {
                    return true;
                };

                self.getValues = function () {
                    //业务数据获取
                    var resultData = [];
                    for (var i = 0; i < self.resultData().length; i++) {
                        resultData.push(dl.processInlineData(self.resultData()[i]));
                    }
                    return resultData[0];
                };

                //进度按钮
                self.jinduClick = function (data, event) {
                    self.processInstanceId = self.parentViewModel.rowData.processInstanceId;
                    dl.getGlobalModule({name: 'schedule', params: self});
                    var currentPageName = dl.getProcessPageName(params.rowData.processType, params.rowData.activityType);
                    dl.pushPageStack({name: currentPageName, params: self.parentViewModel, cacheKey: currentPageName});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle("流程进度");
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

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    var condition = {
                        personnelBusinessId: params.rowData.businessId,
                        includeDetail: true
                    };
                    dl.callOperation("ST_PersonnelBusines", 'find', condition, self.datareceived);
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return fillcheckUpdateViewModel;
        }
);


