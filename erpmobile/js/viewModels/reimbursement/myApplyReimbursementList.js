
define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojcollectiontabledatasource'],
        function (oj, ko, $, dl) {
            function myApplyReimbursementListViewModel(params){
                var self = this;
                self.viewModelName = 'myApplyReimbursementListViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.searchData = ko.observable();
                self.queryAction = ko.observable();
                self.menuData = ko.observable();
                self.normalData = ko.observable();
                self.amountName = ko.observable('amount');

                var processType = self.parentViewModel.rowData.processType;
                self.iClicked = function (data, event) {
                    self.normalData(data);
                    var target = event.currentTarget;
                    var id = target.id; //业务主键
                    var pageName;
//                  每个报销特有businessId
                    var d = dl.findCurrentDataByAttr(id, 'businessId', self.normalData());
                    if (dl.isNullOrUndefined(d)) {
                        return;
                    }
                    pageName = dl.getProcessPageName(processType, 2);
                    d['pageFlag'] = 1;
                    if (dl.isNullOrUndefined(pageName)) {
                        return;
                    }
                    self.rowData = d;
                    dl.pushPageStack({name: "reimbursement/myApplyReimbursementList", params: self.parentViewModel});
                    dl.getGlobalModule({name: pageName, params: self});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(dl.headerTitle());
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
                self.returnTitle = function (data) {
                    switch (processType) {
                        case 2:
                        case 3:
                            return '('+ dl.getLabelByValue('process_status', data['processStatus'])  + ')'+ dl.getLabelByValue('employees', data['employeeId']) + '(' + data['businessName'] + ')';
                            break;
                        case 8:
                            return '('+ dl.getLabelByValue('process_status', data['processStatus'])  + ')'+  dl.getLabelByValue('employees', data['employeeId']) + '(' + dl.getLabelByValue('departments', data['departmentId']) + ')';
                            break;
                        case 9:
                            return '('+ dl.getLabelByValue('process_status', data['processStatus'])  + ')'+  dl.getLabelByValue('employees', data['applicant']) + '(' + dl.getLabelByValue('departments', data['departmentId']) + ')';
                            break;
                        case 4:
                        case 5:
                            return '('+ dl.getLabelByValue('process_status', data['processStatus'])  + ')'+  dl.getLabelByValue('employees', data['applicant']) + '(' + data['businessName'] + ')';
                            break;
                        case 6:
                            return '('+ dl.getLabelByValue('process_status', data['processStatus'])  + ')'+   dl.getLabelByValue('employees', data['employeeId']) + '(' + dl.currencyConverter.format(data['borrowMoney']).slice(2) + ') ';
                            break;
                        case 7:
                            return '('+ dl.getLabelByValue('process_status', data['processStatus'])  + ')'+  dl.getLabelByValue('employees', data['employeeId']) + '(' + dl.currencyConverter.format(data['payAmount']).slice(2) + ') ';
                            break;
                        case 52:
                            return  '('+ dl.getLabelByValue('process_status', data['processStatus'])  + ')'+ dl.getLabelByValue('employees', data['bdApplyEmployeeId']) + '(' + dl.getLabelByValue('system_dictionary_1', data['departmentId']) + ')';
                            break;
                    };
                };
                    var activityType = self.parentViewModel.rowData.activityType;
                    switch (Number(activityType)) {
                        case 1:
                            self.searchData({
                                currentPage: 0,
                                pageLines: 1,
                                employeeId: dl.getEmployeeId(),
                                processType: processType
                            });
                            break;
                        case 2:
                        case 3:
                            if(processType == 7){
                                      self.searchData({
                                currentPage: 0,
                                pageLines: 1,
                                employeeId: dl.getEmployeeId(),
                                processType: processType,
                                 keyValues: [{key: 'spi.process_status IN ( 0, 1 )', value: 'spi.process_status IN ( 3, 5 )'}]       
                            });
                            }else{
                                    self.searchData({
                                currentPage: 0,
                                pageLines: 1,
                                employeeId: dl.getEmployeeId(),
                                processType: processType,
                                 keyValues: [{key: 'spi.process_status in(0,1)', value: 'spi.process_status IN ( 3, 5 )'}]        
                            });
                            }
                     
                              break;
                    };

                    switch (processType) {
                        case 2:
                        case 3:
                        case 8:
                            self.queryAction('NQ_NormalReimbursementsApplyOfWorkflow'); 
                            break;
                        case 4:
                        case 5:
                        case 9:
                            self.queryAction('NQ_TravelReimbursementsApplyOfWorkflow');
                            break;
                        case 6:
                            self.queryAction('NQ_EmployeeMoneyApplyOfWorkflow');
                            break;
                        case 7:
                            self.queryAction('NQ_PayMoneyApplyOfWorkflow');
                            break;
                    };
                    
                myApplyReimbursementListModel = oj.Model.extend({
                    parse: dl.parseModel,
                    idAttribute: 'processInstanceId'
                });

                myApplyReimbursementListCollection = oj.Collection.extend({
                    model: new myApplyReimbursementListModel(),
                    parse: dl.parseCollection,
                    fetchSize: 10,
                    customPagingOptions: dl.parsePaging,
                    queryAction: self.queryAction,
                    url: dl._SERVERURL
                });
                self.collection = new myApplyReimbursementListCollection();
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
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }
            return myApplyReimbursementListViewModel;
        }
);


