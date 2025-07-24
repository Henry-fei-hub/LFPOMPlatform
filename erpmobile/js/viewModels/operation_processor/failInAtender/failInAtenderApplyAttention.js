define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function failInAtenderApplyAttentionViewModel(params) {
                var self = this;
                self.viewModelName = 'failInAtenderApplyAttentionViewModel';
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

                self.datareceived = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.resultData = arrData;
                    self.dataSource(new oj.ArrayTableDataSource(self.resultData, {idAttribute: 'personnelBusinessId'}));
                     self.specialHeaderTitle(dl.getLabelByValue('employees', arrData[0]['employeeId']) + '___' + arrData[0]['projectName']);
//                    进入即阅
                    dl.submitApprovalWork(0, params.rowData, self);
                };
                self.datareceived1 = function (data) {
                    var arrData = data.ResultSet.Result;
                    self.dataSource1(new oj.ArrayTableDataSource(arrData, {idAttribute: 'projectId'}));
                    self.processbillListData = arrData;
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

                //进度按钮
                self.jinduClick = function (data, event) {
                    self.processInstanceId = self.parentViewModel.rowData.processInstanceId;
                    dl.getGlobalModule({name: 'schedule', params: self});
                    dl.pushPageStack({name: 'operation_processor/failInAtender/failInAtenderApplyAttention', params: self.parentViewModel, cacheKey: 'operation_processor/failInAtender/failInAtenderApplyAttention'});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle("流程进度");
                };

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };
                self.handleAttached = function (info) {
                    var condition = {};
                    condition['personnelBusinessId'] = params.rowData.personnelBusinessId;
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

            return failInAtenderApplyAttentionViewModel;
        }
);


