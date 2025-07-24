
define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojcollectiontabledatasource'],
        function (oj, ko, $, dl) {
            function travelExamineListViewModel(params) {
                var self = this;
                self.viewModelName = 'travelExamineListViewModel';
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
                    dl.pushPageStack({name: "myExamine/travelExamineList", params: self.parentViewModel});
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
                        keyValues: [{key: 'spia.status =?', value: 'spia.status =? and spia.status in (2,3,4,5,6)'},
                                  {key: 'sppt.status =?', value: 'sppt.status =? and sppt.status in (2,3,4,5,6)'}]
                }; 
                travelExamineListModel = oj.Model.extend({
                    parse: dl.parseModel,
                    idAttribute: 'processInstanceActivityId'
                });

                travelExamineListCollection = oj.Collection.extend({
                    model: new travelExamineListModel(),
                    parse: dl.parseCollection,
                    fetchSize: 10,
                    customPagingOptions: dl.parsePaging,
                    queryAction: 'NQ_OnLoadFlowTravelReimbursementsApplyBuisnessData',
                    url: dl._SERVERURL
                });
                self.collection = new travelExamineListCollection();
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
                    if (Number(self.parentViewModel.processType) === 11) {
                        self.isShow(0);
                        self.isShow11(1);
                    } else {
                        self.isShow(1);
                        self.isShow11(0);
                    };
                      self.returnTitle = function (data) {
                    if (data['processType'] == 4||data['processType'] == 5) {
                        return  dl.getLabelByValue('employees', data['applicant']) + '('+data['businessName']+')';
                    }else if (data['processType'] == 9) {
                        return  dl.getLabelByValue('employees', data['employeeId']) + data['title'];
                    }
                };
//
//                    var condition1 = {
//                        currentPage: 0,
//                        pageLines: 1,
//                        employeeId: dl.getEmployeeId(),
//                        processType: self.parentViewModel.processType,
//                        keyValues: [{key: 'spia.status =?', value: 'spia.status =? and spia.status in (2,3,4,5,6)'},
//                                  {key: 'sppt.status =?', value: 'sppt.status =? and sppt.status in (2,3,4,5,6)'}]
//                    };
////                        多个
//                    dl.callOperation("NQ_OnLoadFlowTravelReimbursementsApplyBuisnessData", 'find', condition1, self.datareceived);
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };

            }
            return travelExamineListViewModel;
        }
);


