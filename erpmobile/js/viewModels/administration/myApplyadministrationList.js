define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojcollectiontabledatasource'],
        function (oj, ko, $, dl) {
            function myApplyadministrationListViewModel(params) {
                var self = this;
                self.viewModelName = 'myApplyadministrationListViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.searchData = ko.observable();
                self.queryAction = ko.observable();
                self.menuData = ko.observable();
                self.normalData = ko.observable();
                var processType = self.parentViewModel.rowData.processType;

                self.iClicked = function (data, event) {
                    self.normalData(data);
                    var target = event.currentTarget;
                    var id = target.id; //业务主键
                    //每个报销特有businessId
                    var d = dl.findCurrentDataByAttr(id, 'businessId', self.normalData());
                    if (dl.isNullOrUndefined(d)) {
                        return;
                    }
                    //根据选中的项的activityType 2审批页面View 3处理页面Update
                    pageName = dl.getProcessPageName(processType, 2);
//                    表示从我的申请过去的
                    d['pageFlag'] = 1;
                    self.rowData = d;
                    //把每次点击的module存在数组中 也不是单纯的模块名
                    dl.pushPageStack({name: 'administration/myApplyadministrationList', params: self.parentViewModel});
                    dl.getGlobalModule({name: pageName, params: self});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(dl.getLabelByValue('employees', d.employeeId) + d.businessName);
                };
                self.returnTitle = function (data) {
                    switch (processType) {
                        case 13:
                            return  '('+ dl.getLabelByValue('process_status', data['processStatus'])  + ')'+ dl.getLabelByValue('employees', data['employeeId']) + dl.getLabelByValue('leave_types', data['type']);
                            break;
                        case 16:
                        case 19:
                        case 20:
//                        case 27:
                            return  '('+ dl.getLabelByValue('process_status', data['processStatus'])  + ')'+ dl.getLabelByValue('employees', data['employeeId']);
                            break;
                        case 14:
                        case 15:
                        case 17:
                        case 18:
                        case 21:
                        case 26:
                        case 29:
                        case 45:
                            return   '('+ dl.getLabelByValue('process_status', data['processStatus'])  + ')'+ dl.getLabelByValue('employees', data['employeeId']) + '(' + dl.getLabelByValue('departments', data['departmentId']) + ') ';
                            break;
                        case 25:
                            return   '('+ dl.getLabelByValue('process_status', data['processStatus'])  + ')'+ dl.getLabelByValue('employees', data['employeeId']) + dl.getLabelByValue('departments', data['departmentId']) + '(' + data['reason'] + ') ';
                            break;
                        case 28:
                        case 36:
                        case 37:
                        case 41:
                            return   '('+ dl.getLabelByValue('process_status', data['processStatus'])  + ')'+ dl.getLabelByValue('employees', data['employeeId']) + '(' + dl.currencyConverter.format(data['fee']).slice(2) + ') ';
                            break;
                        case 30:
                            return   '('+ dl.getLabelByValue('process_status', data['processStatus'])  + ')'+ dl.getLabelByValue('employees', data['employeeId']) + '(' + dl.getLabelByValue('departments', data['departmentId']) + ')(' + dl.datetimeConverter.format(dl.parseValueFromService(data['endDate'])) + ') ';
                            break;
                        case 31:
                            return   '('+ dl.getLabelByValue('process_status', data['processStatus'])  + ')'+ dl.getLabelByValue('employees', data['employeeId']) + dl.getLabelByValue('system_dictionary_109', data['type']);
                            break;
                        case 33:
                            return  '('+ dl.getLabelByValue('process_status', data['processStatus'])  + ')'+ dl.getLabelByValue('employees', data['employeeId']) + dl.getLabelByValue('system_dictionary_122', data['address']);
                            break;
                        case 34:
                            return   '('+ dl.getLabelByValue('process_status', data['processStatus'])  + ')'+ dl.getLabelByValue('employees', data['employeeId']);
                            break;
                        case 35:
                            return   '('+ dl.getLabelByValue('process_status', data['processStatus'])  + ')'+ dl.getLabelByValue('employees', data['employeeId']) + dl.getLabelByValue('system_dictionary_107', data['type']);
                            break;
                        case 40:
                            return   '('+ dl.getLabelByValue('process_status', data['processStatus'])  + ')'+ dl.getLabelByValue('employees', data['employeeId']) + data['subTypeStr'];
                            break;
                    }
                    ;
                };
                myApplyadministrationListModel = oj.Model.extend({
                    parse: dl.parseModel,
                    idAttribute: 'processInstanceId'
                });

                myApplyadministrationListCollection = oj.Collection.extend({
                    model: new myApplyadministrationListModel(),
                    parse: dl.parseCollection,
                    fetchSize: 10,
                    customPagingOptions: dl.parsePaging,
                    queryAction: self.queryAction,
                    url: dl._SERVERURL
                });
                self.collection = new myApplyadministrationListCollection();
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
                    // 0,1 查找正在进行中   3：查 完成  5：  查 驳回.
                    switch (Number(activityType)) {
                        case 1:
                            self.searchData({
                                currentPage: 0,
                                pageLines: 1,
                                employeeId: dl.getEmployeeId(),
                                processType: processType
                            });
                            self.queryAction("NQ_OnLoadApplyListOfPersonnel");
                            break;
                        case 2:
                        case 3:
                            self.searchData({
                                currentPage: 0,
                                pageLines: 1,
                                employeeId: dl.getEmployeeId(),
                                processType: processType,
                                  keyValues: [{key: 'spia.status =?', value: 'spia.status =? and spia.status in (3,5)'}]
                                
                            });
                            self.queryAction("NQ_OnLoadRefuseListOfPersonnel");
                            break;
                    };
              
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };

            }
            return myApplyadministrationListViewModel;
        }
);


