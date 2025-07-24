
define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/msgbox', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojcollectiontabledatasource'],
        function (oj, ko, $, dl, sc) {
            function myAttentionsReimbursementListViewModel(params) {
                var self = this;
                self.viewModelName = 'myAttentionsReimbursementListViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.normalData = ko.observable();
                self.menuData = ko.observable();
                self.isShow = ko.observable(1);
                self.isShow11 = ko.observable(1);
                self.showBut = ko.observable(true);
                self.queryAction = ko.observable();
                self.pageFlag = self.parentViewModel.rowData['pageFlag'];
                self.goPage = function (type, businessId) {
                    var processType = params.processType;
                    var pageName;
                    var id = businessId; //业务主键
//                      每个报销特有businessId
                    var d = dl.findCurrentDataByAttr(id, 'businessId', self.normalData());
                    d['pageFlag'] = 2;
                    self.rowData = d;
                    if (dl.isNullOrUndefined(d)) {
                        return;
                    }
//                     4 atttenton 2 view
                    pageName = dl.getProcessPageName(processType, !dl.isNullOrUndefined(self.pageFlag) && self.pageFlag === 2 ? 2 : 4);
                    if (dl.isNullOrUndefined(pageName)) {
                        return;
                    }
                    //把每次点击的module存在数组中 也不是单纯的模块名
//                有cacheKey不会重新加载页面 会有问题 去掉cacheKey
                    dl.pushPageStack({name: "reimbursement/myAttentionsReimbursementList", params: self.parentViewModel});
                    dl.getGlobalModule({name: pageName, params: self});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(dl.headerTitle());
                };
                // 一键标记已读
                self.readToggetherClick = function (data, event) {
                    sc.confirm('确定一键阅读?', function () {
                        dl.attentionBatchReadWork(params.processType, self);
                    });
                };
//                一键标记已读的回调函数
                self.batchReadCallback = function (data) {
                    self.handleAttached();
                    self.collection.refresh();
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
                    status: dl.isNullOrUndefined(self.pageFlag) ? 1 : 2
                };
                myAttentionsReimbursementListModel = oj.Model.extend({
                    parse: dl.parseModel,
                    idAttribute: 'businessId'
                });
                myAttentionsReimbursementListCollection = oj.Collection.extend({
                    model: new myAttentionsReimbursementListModel(),
                    parse: dl.parseCollection,
                    fetchSize: 10,
                    customPagingOptions: dl.parsePaging,
                    queryAction: self.queryAction,
                    url: dl._SERVERURL
                });
                self.collection = new myAttentionsReimbursementListCollection();
                self.dataSource = new oj.CollectionTableDataSource(self.collection);
                self.collection.generateCondition = function () {
                    return self.searchData;
                };
                self.getDataTitle = function (data) {
                };
                self.handleActivated = function (info) {
                };
                self.handleAttached = function (info) {
                    self.showBut(true);
                    if (!dl.isNullOrUndefined(self.pageFlag) && self.pageFlag === 2) {
                        self.showBut(false);
                    }
                    if (Number(self.parentViewModel.processType) === 11) {
                        self.isShow(0);
                        self.isShow11(1);
                    } else {
                        self.isShow(1);
                        self.isShow11(0);
                    }
                    var processType = Number(self.parentViewModel.processType);
                    switch (processType) {
                        case 2:
                        case 3:
                        case 8:
                            self.queryAction("NQ_NormalReimbursementsAttentionOfWorkflow");
                            self.amountName('amount');
                            break;
                        case 4:
                        case 5:
                        case 9:
                            self.queryAction("NQ_TravelReimbursementsAttentionOfWorkflow");
                            self.amountName('amount');
                            break;
                        case 6:
                            self.queryAction("NQ_EmployeeMoneyAttentionOfWorkflow");
                            self.amountName('borrowMoney');
                            break;
                        case 7:
                            self.queryAction("NQ_PayMoneyAttentionOfWorkflow");
                            self.amountName('payAmount');
                            break;
                    }
                    ;
                };

                self.handleBindingsApplied = function (info) {
                };
                self.handleDetached = function (info) {
                };
            }
            return myAttentionsReimbursementListViewModel;
        }
);


