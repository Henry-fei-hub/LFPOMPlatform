define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function carApplyAttentionViewModel(params) {
                var self = this;
                self.viewModelName = 'carApplyAttentionViewModel';
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
                self.isShow = ko.observable();
                self.datareceived = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.resultData = arrData;
                    self.dataSource(new oj.ArrayTableDataSource(self.resultData, {idAttribute: 'personnelBusinessId'}));
                    //  某人的报销页面的标题以报销人+主题 
                    self.specialHeaderTitle(dl.getLabelByValue('employees', arrData[0]['employeeId']) + dl.getLabelByValue('system_dictionary_119', arrData[0]['startDateDetail'])); 
                };
                self.datareceived1 = function (data) {
                    //用车子表数据
                    var arrData = data.ResultSet.Result;
                    if (arrData.length > 0 && !dl.isNullOrUndefined(arrData[0]['type'])) {
                        self.dataSource1(new oj.ArrayTableDataSource(arrData, {idAttribute: 'personnelBusinessId'}));
                        self.processbillListData = arrData;
                        var typeId = arrData[0]['type'];
                        if (!dl.isNullOrUndefined(typeId)) {
                            switch (Number(typeId)) {
                                case 1://项目用车
                                    self.isShow(1);
                                    break;
                                case 2: //前期项目用车
                                    self.isShow(2);
                                    break;
                                case 3: //部门用车
                                    self.isShow(3);
                                    break;
                            }
                        }
                    }
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
                   return [];
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
                    //          法1：直接写死页面 
//                  dl.pushPageStack({name: 'administration/car/carApplyAttention', params: self.parentViewModel, cacheKey: 'administration/car/carApplyAttention'});
//               法2：通过公共方法   params.rowData.activityType获取不到 可直接赋值 如知会4
//                    var currentPageName = dl.getProcessPageName(params.rowData.processType, params.rowData.activityType);
//                    dl.pushPageStack({name: currentPageName, params: self.parentViewModel, cacheKey: currentPageName});
//                    var currentPageName = dl.getProcessPageName(params.rowData.processType, 4);
//                    dl.pushPageStack({name: currentPageName, params: self.parentViewModel, cacheKey: currentPageName});
                    dl.pushPageStack({name: 'administration/car/carApplyAttention', params: self.parentViewModel, cacheKey: 'administration/car/carApplyAttention'});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle("流程进度");
                };

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                 
                };
                self.handleAttached = function (info) {
                    self.pageFlag = self.parentViewModel.rowData['pageFlag'];
                    if(!dl.isNullOrUndefined(self.pageFlag)){ 
//                    进入即阅
                    dl.submitApprovalWork(0, params.rowData, self);           
                    }
                    var condition = {
                        personnelBusinessId: params.rowData.businessId,
                        includeDetail: true
                    };
                    dl.callOperation("ST_PersonnelBusines", 'find', condition, self.datareceived);

                    var condition = {
                        personnelBusinessId: params.rowData.businessId
                    };
                    dl.callOperation("ST_CarCostAllocation", 'find', condition, self.datareceived1);
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return carApplyAttentionViewModel;
        }
);


