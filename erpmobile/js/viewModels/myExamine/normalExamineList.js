
define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'ojs/ojmodel', 'promise', 'ojs/ojnavigationlist', 'ojs/ojlistview',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojcollectiontabledatasource', 'ojs/ojjsontreedatasource'],
        function (oj, ko, $, dl) {
            function normalExamineListViewModel(params) {
                var self = this;
                self.viewModelName = 'normalExamineListViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.normalData = ko.observable();
                var processType = Number(self.parentViewModel.processType);
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
                    //表示从我的已审过去的
                    d['pageFlag'] = 1;
                    self.rowData = d;
                    //把每次点击的module存在数组中 也不是单纯的模块名
                    dl.pushPageStack({name: "myExamine/normalExamineList", params: self.parentViewModel});
                    dl.getGlobalModule({name: pageName, params: self});
//                    headerTitle
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(dl.headerTitle());
                };
            
                self.returnTitle = function (data) {
                    switch (processType) {
                        case 2:
                            return dl.getLabelByValue('employees', data['employeeId']) + '(' + data['businessName'] + ')';
                            break;
                        case 3:
                            return  dl.getLabelByValue('employees', data['employeeId']) + '(' + data['businessName'] + ')';
                            break;
                        case 8:
                            return  dl.getLabelByValue('employees', data['employeeId']) + '(' + data['title'] + ')';
                            break;
                    }
                };
                self.iClicked = function (data, event) {
                    self.normalData(data);
                    var target = event.currentTarget;
                    var id = target.id; //业务主键
                    self.goPage(1, id);
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

                self.menuData = null;
//                放查询条件
                self.searchData = {
                    employeeId: dl.getEmployeeId(),
                    'processType':self.parentViewModel.processType,
                    keyValues: [{key: 'spia.status =?', value: 'spia.status =? and spia.status in (2,3,6)'},
                             {key: 'sppt.status =?', value: 'sppt.status =? and sppt.status in (2,3,4,5,6)'}]
                }; 
                normalExamineListModel = oj.Model.extend({
                    parse: dl.parseModel,
                    idAttribute: 'processInstanceActivityId'
                });

                normalExamineListCollection = oj.Collection.extend({
                    model: new normalExamineListModel(),
                    parse: dl.parseCollection,
                    fetchSize: 10,
                    customPagingOptions: dl.parsePaging,
                    queryAction: 'NQ_OnLoadFlowNormalReimbursementsApplyBuisnessData',
                    url: dl._SERVERURL
                });
                self.collection = new normalExamineListCollection();
                self.dataSource = new oj.CollectionTableDataSource(self.collection);
                self.collection.generateCondition = function () {
                    return self.searchData;
                };

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                    // Implement if needed
                };


                self.handleAttached = function (info) {
                };

                self.handleBindingsApplied = function (info) {
                    // Implement if needed
                };

                self.handleDetached = function (info) {
                    // Implement if needed
                };

            }
            return normalExamineListViewModel;
        }
);


