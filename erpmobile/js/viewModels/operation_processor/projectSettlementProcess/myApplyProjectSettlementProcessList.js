define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojcollectiontabledatasource'],
        function (oj, ko, $, dl) {
            function myApplyprojectSettlementProcessListViewModel(params) {
                var self = this;
                self.viewModelName = 'myApplyprojectSettlementProcessListViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.dataSource2 = ko.observable();
                self.searchData = ko.observable();
                self.queryAction = ko.observable();
                self.menuData = ko.observable();
                self.normalData = ko.observable();
                self.iClicked = function (data, event) {
                    self.normalData(data);
                    var processType = params.processType;
                    var pageName;
                    var target = event.currentTarget;
                    var id = target.id; //业务主键
                    //每个报销特有businessId
                    var d = dl.findCurrentDataByAttr(id, 'businessId', self.normalData());
                    if (dl.isNullOrUndefined(d)) {
                        return;
                    }
                    //根据选中的项的activityType 2审批页面View 3处理页面Update
                    pageName = dl.getProcessPageName(processType, 2);
                    //表示从我的申请过去的
                    d['pageFlag'] = 1;
                    self.rowData = d;
                    //把每次点击的module存在数组中 也不是单纯的模块名
                    dl.pushPageStack({name: 'operation_processor/projectSettlementProcess/myApplyProjectSettlementProcessList', params: self.parentViewModel});
                    dl.getGlobalModule({name: pageName, params: self});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(d.projectName);
                };

                myApplyprojectSettlementProcessListModel = oj.Model.extend({
                    parse: dl.parseModel,
                    idAttribute: 'processInstanceId'
                });

                myApplyprojectSettlementProcessListCollection = oj.Collection.extend({
                    model: new myApplyprojectSettlementProcessListModel(),
                    parse: dl.parseCollection,
                    fetchSize: 10,
                    customPagingOptions: dl.parsePaging,
                    queryAction: self.queryAction,
                    url: dl._SERVERURL
                });
                self.collection = new myApplyprojectSettlementProcessListCollection();
                self.dataSource = new oj.CollectionTableDataSource(self.collection);
                self.collection.generateCondition = function () {
                    return self.searchData();
                };

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    var activityType = self.parentViewModel.rowData.activityType;
                    var processType = self.parentViewModel.rowData.processType;
                    // 0,1 查找正在进行中   3：查 完成  5：  查 驳回.
                    switch (Number(activityType)) {
                        case 1:
                            self.searchData({
                                currentPage: 0,
                                pageLines: 1,
                                employeeId: dl.getEmployeeId(),
                                processType: processType,
                                status:1
                            });
                            self.queryAction('NQ_OnLoadApplyListOfProjectSettlement');
                            break;
                        case 2:
                        case 3:
                            self.searchData({
                                currentPage: 0,
                                pageLines: 1,
                                employeeId: dl.getEmployeeId(),
                                processType: processType,
                                keyValues: [{key: 'spi.process_status IN ( 0, 1 )', value: 'spi.process_status IN ( 3, 5 )'}]
                            });
                            self.queryAction('NQ_OnLoadApplyListOfProjectSettlement');
                            break;
                    }
                    ;

                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };

            }
            return myApplyprojectSettlementProcessListViewModel;
        }
);


