define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function stayawayApplyAttentionViewModel(params) {
                var self = this;
                self.viewModelName = 'stayawayApplyAttentionViewModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                self.dataSource = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.resultData = ko.observable();
                self.processbillListData = null;
                self.specialHeaderTitle = ko.observable('');

                self.datareceived = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.resultData = arrData;
                    if (self.resultData.length > 0) {
                        for (var i = 0; i < self.resultData.length; i++) {
                            //获取外出类型;1:项目外出;2:前期项目外出;3:非项目外出
                            var projectType = self.resultData[i]['projectType'];
                            if (Number(projectType) === 1) {
                                self.resultData[i]['projectTypeName'] = '项目外出';
                            } else if (Number(projectType) === 2) {
                                self.resultData[i]['projectTypeName'] = '前期项目外出';
                            } else if (Number(projectType) === 3) {
                                self.resultData[i]['projectTypeName'] = '非项目外出';
                            }
                        }
                    }
                    self.dataSource(new oj.ArrayTableDataSource(self.resultData, {idAttribute: 'personnelBusinessId'}));
//                    进入即阅
                    dl.submitApprovalWork(0, params.rowData, self);

                };

                //审批后执行的方法
                self.workCallback = function (data) {
                    if (data.ResultSet.status >= 0) {
                    } else {
                        alert(data.ResultSet.errors);
                    }
                };

                self.getValues = function () {
                    //业务数据获取
                    var userData = self.resultData;
                    userData[0].detailProcessBillListApply = self.processbillListData;
                    return userData[0];
                };


                //进度按钮
                self.jinduClick = function (data, event) {
                    self.processInstanceId = self.parentViewModel.rowData.processInstanceId;
                    dl.getGlobalModule({name: 'schedule', params: self});
                    dl.pushPageStack({name: 'personnel/stayaway/stayawayApplyAttention', params: self.parentViewModel, cacheKey: 'personnel/stayaway/stayawayApplyAttention'});
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
                        includeDetail: true
                    };
                    dl.callOperation("ST_PersonnelBusines", 'find', condition, self.datareceived);
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return stayawayApplyAttentionViewModel;
        }
);


