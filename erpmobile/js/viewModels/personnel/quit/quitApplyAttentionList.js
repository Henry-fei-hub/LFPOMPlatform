
define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient','dl/msgbox',  'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojcollectiontabledatasource'],
        function (oj, ko, $, dl ,sc) {
            function quitApplyAttentionListViewModel(params) {
                var self = this;
                self.viewModelName = 'quitApplyAttentionListViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.menuData = ko.observable();
                self.normalData = ko.observable();
                self.showBut = ko.observable(true);
                self.pageFlag = self.parentViewModel.rowData['pageFlag'];

                // 一键标记已读
                self.readToggetherClick = function (data, event) {
                    dl.attentionBatchReadWork(params.processType, self);
                };
//                一键标记已读的回调函数
                self.batchReadCallback = function (data) {
                    self.handleAttached();
                     self.collection.refresh();
                };

                self.iClicked = function (data, event) {
                    self.normalData(data);
                    var processType = params.processType;
                    var pageName;
                    var target = event.currentTarget;
                    var id = target.id; //业务主键
                    //每个报销特有businessId
                    var d = dl.findCurrentDataByAttr(id, 'businessId', self.normalData());
                    d['pageFlag'] = 2;
                    self.rowData = d;
                    if (dl.isNullOrUndefined(d)) {
                        return;
                    }
                     pageName = dl.getProcessPageName(processType, !dl.isNullOrUndefined(self.pageFlag) && self.pageFlag == 2 ? 2 : 4);
                    if (dl.isNullOrUndefined(pageName)) {
                        return;
                    }

                    //把每次点击的module存在数组中 也不是单纯的模块名
                    dl.pushPageStack({name: "personnel/quit/quitApplyAttentionList", params: self.parentViewModel});
                    dl.getGlobalModule({name: pageName, params: self});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(dl.headerTitle());
                };
                
                
                 //                放查询条件
                self.searchData = {
                    employeeId: dl.getEmployeeId(),
                    processType: self.parentViewModel.processType,
                    status: !dl.isNullOrUndefined(self.pageFlag) && self.pageFlag == 2 ? 2 : 1
                };
                quitApplyAttentionListModel = oj.Model.extend({
                    parse: dl.parseModel,
                    idAttribute: 'systemProcessAttentionId'
                });

               quitApplyAttentionListCollection = oj.Collection.extend({
                    model: new quitApplyAttentionListModel(),
                    parse: dl.parseCollection,
                    fetchSize: 10,
                    customPagingOptions: dl.parsePaging,
                    queryAction: 'NQ_OnLoadAttentionListOfPersonnel',
                    url: dl._SERVERURL
                });
                self.collection = new quitApplyAttentionListCollection();
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
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };

            }
            return quitApplyAttentionListViewModel;
        }
);


