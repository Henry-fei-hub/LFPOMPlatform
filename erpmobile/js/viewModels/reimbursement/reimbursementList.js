define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojcollectiontabledatasource'],
        function (oj, ko, $, dl) {
            function reimbursementListViewModel(params) {
                var self = this;
                self.viewModelName = 'reimbursementListViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.selectedItem = ko.observable("");
                self.normalData = ko.observable();
                self.isShow = ko.observable(1);
                self.isShow11 = ko.observable(1);
                self.queryAction = ko.observable();
                self.amountName = ko.observable('amount');
                self.goPage = function (type, businessId) {
                    var processType = params.processType;
                    var pageName;
                    var id = businessId; //业务主键
//                  每个报销特有businessId
                    var d = dl.findCurrentDataByAttr(id, 'businessId', self.normalData());
                    if (dl.isNullOrUndefined(d)) {
                        return;
                    }
                    pageName = dl.getProcessPageName(processType, d.activityType);
                    if (dl.isNullOrUndefined(pageName)) {
                        return;
                    }
                    self.rowData = d;
                    //把每次点击的module存在数组中 也不是单纯的模块名
                    dl.pushPageStack({name: "reimbursement/reimbursementList", params: self.parentViewModel});
                    dl.getGlobalModule({name: pageName, params: self});
                    dl.pushHeader(dl.headerTitle());
                   dl.headerTitle(dl.getLabelByValue('employees', d.bdApplyEmployeeId) + dl.getLabelByValue('system_dictionary_191', d.bdType));
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

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    var processType = Number(self.parentViewModel.processType);
                    switch (processType) {
                        case 2:
                        case 3:
                        case 8:
                            self.queryAction("NQ_OnLoadFlowNormalReimbursementsApplyBuisnessData");
                            break;
                        case 4:
                        case 5:
                        case 9:
                            self.queryAction("NQ_OnLoadFlowTravelReimbursementsApplyBuisnessData");
                            break;
                        case 6:
                            self.amountName('borrowMoney');
                            self.queryAction("NQ_OnLoadFlowEmployeeMoneyApplyBuisnessData");
                            break;
                        case 7:
                            self.amountName('payAmount');
                            self.queryAction("NQ_OnLoadFlowPayMoneyApplyBuisnessData");
                            break;
                        case 52:
                            self.isShow(2);
                            self.queryAction("NQ_OnLoadFlowBudgetManagementApplyBuisnessData");
                            break;
                        default:
                            self.amountName('amount');
                            self.isShow(1);
                            self.isShow11(0);
                            break;
                    }
                };
                self.menuData = null;
                //待办单独审批的数据

                //                放查询条件
                self.searchData = {
                    employeeId: dl.getEmployeeId(),
                    'processType': self.parentViewModel.processType,
                    status: 1
                };
                reimbursementListModel = oj.Model.extend({
                    parse: dl.parseModel,
                    idAttribute: 'processInstanceActivityId'
                });

                reimbursementListCollection = oj.Collection.extend({
                    model: new reimbursementListModel(),
                    parse: dl.parseCollection,
                    fetchSize: 10,
                    customPagingOptions: dl.parsePaging,
                    queryAction: self.queryAction,
                    url: dl._SERVERURL
                });
                self.collection = new reimbursementListCollection();
                self.dataSource = new oj.CollectionTableDataSource(self.collection);
                self.collection.generateCondition = function () {
                    return self.searchData;
                };



                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }
            
            return reimbursementListViewModel;
        }
);


