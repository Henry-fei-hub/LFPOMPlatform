define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojcollectiontabledatasource'],
        function (oj, ko, $, dl) {
            function reimburseAdministrationExamineListViewModel(params) {
                var self = this;
                self.viewModelName = 'reimburseAdministrationExamineListViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                var processType = params.processType;
                self.searchData = ko.observable();
                self.normalData = ko.observable();
                self.queryAction = ko.observable();
                self.goPage = function (type, businessId) {
                    var pageName;
                    var id = businessId; //业务主键
//                  每个报销特有businessId
                    var d = dl.findCurrentDataByAttr(id, 'businessId', self.normalData());
                    if (dl.isNullOrUndefined(d)) {
                        return;
                    }
                    pageName = dl.getProcessPageName(processType, 2);
                    if (dl.isNullOrUndefined(pageName)) {
                        return;
                    }
                    //                    表示从我的已审过去的
                    d['pageFlag'] = 1;
                    self.rowData = d;

                    //把每次点击的module存在数组中 也不是单纯的模块名
                    dl.pushPageStack({name: "myExamine/reimburseAdministrationExamineList", params: self.parentViewModel});
                    dl.getGlobalModule({name: pageName, params: self});
//                    headerTitle
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(dl.headerTitle());
                };

                self.iClicked = function (data, event) {
                    self.normalData(data);
                    var target = event.currentTarget;
                    var id = target.id; //业务主键
                    self.goPage(1, id);
                };
                self.returnTitle = function (data) {
                    switch (Number(processType)) {
                        case 13:
                            return dl.getLabelByValue('employees', data['employeeId']) + dl.getLabelByValue('leave_types', data['type']);
                            break;
                        case 16:
                            return dl.getLabelByValue('employees', data['employeeId']) + '(' + data['reason'] + ') ';
                            break;
                        case 29:
                        case 15:
                        case 17:
                        case 21:
                        case 26:
                        case 34:
                        case 45:
                        case 78:
                        case 81:
                        case 82:
                            return  dl.getLabelByValue('employees', data['employeeId']) + '(' + dl.getLabelByValue('departments', data['departmentId']) + ') ';
                            break;
                        case 25:
                            return  dl.getLabelByValue('employees', data['employeeId']) + dl.getLabelByValue('departments', data['departmentId']) + '(' + data['reason'] + ') ';
                            break;
                        case 36:
                        case 37:
                        case 41:
                            return  dl.getLabelByValue('employees', data['employeeId']) + '(' + dl.currencyConverter.format(data['fee']).slice(2) + ') ';
                            break;
                        case 14:
                        case 18:
                            return  dl.getLabelByValue('employees', data['employeeId']) + '(' + data['address'] + ') ';
                            break;
                        case 30:
                            return  dl.getLabelByValue('employees', data['employeeId']) + '(' + dl.getLabelByValue('departments', data['departmentId']) + ')(' + dl.dateConverter.format(dl.parseValueFromService(data['endDate'])) + ') ';
                            break;
                        case 31:
                            return  dl.getLabelByValue('employees', data['employeeId']) + dl.getLabelByValue('system_dictionary_109', data['type']);
                            break;
                        case 33:
                            return dl.getLabelByValue('employees', data['employeeId']) + data['projectCode'];
                            break;
                        case 35:
                            return  dl.getLabelByValue('employees', data['employeeId']) + '(' + data['subType'] + ')';
                            break;
                        case 40:
                            return  dl.getLabelByValue('employees', data['employeeId']) + data['subTypeStr'];
                            break;
                        case 52:
                            return  dl.getLabelByValue('employees', data['bdApplyEmployeeId']) + dl.getLabelByValue('system_dictionary_191', data['bdType']);
                            break;
                        case 75:
                            return  dl.getLabelByValue('employees', data['employeeId']);
                            break;
                    }
                    ;
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

                reimburseAdministrationListModel = oj.Model.extend({
                    parse: dl.parseModel,
                    idAttribute: 'processInstanceActivityId'
                });

                reimburseAdministrationListCollection = oj.Collection.extend({
                    model: new reimburseAdministrationListModel(),
                    parse: dl.parseCollection,
                    fetchSize: 10,
                    customPagingOptions: dl.parsePaging,
                    queryAction: self.queryAction,
                    url: dl._SERVERURL
                });
                self.collection = new reimburseAdministrationListCollection();
                self.dataSource = new oj.CollectionTableDataSource(self.collection);
                self.collection.generateCondition = function () {
                    return self.searchData();
                };

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                    // Implement if needed
                };

                self.handleAttached = function (info) {
                    var processType = self.parentViewModel.processType;
                    switch (Number(processType)) {
                        case 52:
                            self.searchData({
                                employeeId: dl.getEmployeeId(),
                                'processType': processType,
                                keyValues: [{key: 'spia.status =?', value: 'spia.status =? and spia.status in (2,3,4,5,6)'},
                                    {key: 'sppt.status =?', value: 'sppt.status =? and sppt.status in (2,3,4,5,6)'}]
                            });
                            self.queryAction("NQ_OnLoadFlowBudgetManagementApplyBuisnessData");
                            break;
                        case 30:
                            self.searchData({
                                employeeId: dl.getEmployeeId(),
                                'processType': processType,
                                keyValues: [{key: 'spia.status = 1', value: 'spia.status in (2,3,4,5,6)'},
                                    {key: 'sppt.status = 1', value: 'sppt.status in (2,3,4,5,6)'},
                                    {key: '( EXTRACT ( YEAR FROM A.end_date )) =?', value: '1=?'},
                                    {key: '( EXTRACT ( MONTH FROM A.end_date )) =?', value: '1=?'}]
                            });
                            self.queryAction("NQ_OnLoadFlowEmployeeSalaryAdjustmentBuisnessData");
                            break;
                        case 31:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 40:
                            self.searchData({
                                employeeId: dl.getEmployeeId(),
                                'processType': processType,
                                keyValues: [{key: 'spia.status =?', value: 'spia.status =? and spia.status in (2,3,4,5,6)'},
                                    {key: 'sppt.status =?', value: 'sppt.status =? and sppt.status in (2,3,4,5,6)'},
                                    {key: 'spt.parent_process_type_id = 12', value: 'spt.parent_process_type_id = 32'}]
                            });
                            self.queryAction("NQ_OnLoadFlowPersonnelBuisnessData");
                            break;
                        case 41:
                            self.searchData({
                                employeeId: dl.getEmployeeId(),
                                'processType': processType,
                                keyValues: [{key: 'spia.status =?', value: '1 =? and spia.status in (2,3,4,5,6)'},
                                    {key: 'sppt.status =?', value: '1 =? and sppt.status in (2,3,4,5,6)'},
                                    {key: 'spt.parent_process_type_id = 12', value: ' spt.parent_process_type_id = 1'}]
                            });
                            self.queryAction("NQ_OnLoadFlowPersonnelBuisnessData");
                            break;
                        case 75:
                            self.searchData({
                                employeeId: dl.getEmployeeId(),
                                'processType': processType,
                                keyValues: [
                                    {'key': 'spia.status = ?', 'value': 'spia.status =? and spia.status in (2,3,4,5,6)'},
                                    {'key': 'sppt.status = ?', 'value': 'sppt.status =? and sppt.status in (2,3,4,5,6)'}]
                            });
                            self.queryAction("NQ_OnLoadAuditListOfOutQuotations");
                            break;

                        case 78:
                        case 81:
                        case 82:
                            self.searchData({
                                employeeId: dl.getEmployeeId(),
                                'processType': processType,
                                keyValues: [
                                    {'key': 'spia.status =?', 'value': '1 =? and spia.status in (2,3,4,5,6)'},
                                    {'key': 'sppt.status =?', 'value': '1 =? and sppt.status in (2,3,4,5,6)'},
                                    {'key': 'spt.parent_process_type_id = 12', 'value': 'spt.parent_process_type_id = 77'}]
                            });
                            self.queryAction("NQ_OnLoadFlowPersonnelBuisnessData");
                            break;
                        default:
                            self.searchData({
                                employeeId: dl.getEmployeeId(),
                                'processType': processType,
                                keyValues: [{key: 'spia.status =?', value: 'spia.status =? and spia.status in (2,3,4,5,6)'},
                                    {key: 'sppt.status =?', value: 'sppt.status =? and sppt.status in (2,3,4,5,6)'}]
                            });
                            self.queryAction("NQ_OnLoadFlowPersonnelBuisnessData");
                            break;
                    }
                    ;
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                    // Implement if needed
                };

            }
            return reimburseAdministrationExamineListViewModel;
        }
);


