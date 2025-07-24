
define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojcollectiontabledatasource'],
        function (oj, ko, $, dl) {
            function workTimeExamineListViewModel(params) {
                var self = this;
                self.viewModelName = 'workTimeExamineListViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.normalData = ko.observable();
                self.isShow = ko.observable(1);
                self.isShow11 = ko.observable(1);
                self.goPage = function (type, businessId) {
                    var processType = params.processType;
                    var pageName;
                    var id = businessId; //业务主键
//                  每个报销特有businessId  
                    var d = dl.findCurrentDataByAttr(id, 'businessId',self.normalData());
                    if (dl.isNullOrUndefined(d)) {
                        return;
                    }
//                    已办只有查看 只view 2
                    pageName = dl.getProcessPageName(processType,2);
                    if (dl.isNullOrUndefined(pageName)) {
                        return;
                    }
                       //                    表示从我的已审过去的
                    d['pageFlag'] = 1;
                    self.rowData = d;
                    //把每次点击的module存在数组中 也不是单纯的模块名
                    dl.pushPageStack({name: "myExamine/workTimeExamineList", params: self.parentViewModel});
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
                self.amountName = ko.observable('amount');
                 
               //                放查询条件
                self.searchData = {
                    employeeId: dl.getEmployeeId(),
                        processType: self.parentViewModel.processType,
                        keyValues: [{key: 'spia.status =?', value: '1 =? and spia.status in (2,3,4,5,6)'},
                                  {key: 'sppt.status =?', value: '1 =? and sppt.status in (2,3,4,5,6)'},
                                  {key: 'spt.parent_process_type_id = 12', value: 'spt.parent_process_type_id = 38'}]
                }; 
                workTimeExamineListModel = oj.Model.extend({
                    parse: dl.parseModel,
                    idAttribute: 'processInstanceActivityId'
                });

                workTimeExamineListCollection = oj.Collection.extend({
                    model: new workTimeExamineListModel(),
                    parse: dl.parseCollection,
                    fetchSize: 10,
                    customPagingOptions: dl.parsePaging,
                    queryAction: 'NQ_OnLoadFlowPersonnelBuisnessData',
                    url: dl._SERVERURL
                });
                self.collection = new workTimeExamineListCollection();
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
                };

                self.handleDetached = function (info) {
                };

            }
            return workTimeExamineListViewModel;
        }
);


