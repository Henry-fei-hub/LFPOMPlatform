define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojcollectiontabledatasource'],
        function (oj, ko, $, dl) {
            function failInAtenderApplyListViewModel(params) {
                var self = this;
                self.viewModelName = 'failInAtenderApplyListViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.dataSource1 = ko.observable();
                self.normalData = ko.observable();
                self.iClicked = function (data, event) {
                    self.normalData(data);
                    self.commonClick(event, self.normalData());
                };
                self.datareceived = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.resultData = arrData;
                    self.dataSource1(new oj.ArrayTableDataSource(arrData, {idAttribute: 'processInstanceActivityId'}));

                };
                //列表点击的功用方法
                self.commonClick = function (event, selfData) {
                    var processType = params.processType;
                    var pageName;
                    var target = event.currentTarget;
                    var id = target.id; //业务主键
                    //每个报销特有businessId
                    var d = dl.findCurrentDataByAttr(id, 'businessId', selfData);
                    if (dl.isNullOrUndefined(d)) {
                        return;
                    }
                    //根据选中的项的activityType 2审批页面View 3处理页面Update
                    pageName = dl.getProcessPageName(processType, Number(self.parentViewModel.handelType) === 1 ? d.activityType : 4);
                    //获取当前页面的目录
                    var currentPageName = dl.getProcessPageName(processType, 1);
                    if (dl.isNullOrUndefined(pageName) || dl.isNullOrUndefined(currentPageName)) {
                        return;
                    }
                    self.rowData = d;
                    //把每次点击的module存在数组中 也不是单纯的模块名
                    dl.pushPageStack({name: currentPageName, params: self.parentViewModel, cacheKey: currentPageName});
                    dl.getGlobalModule({name: pageName, params: self});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(dl.getLabelByValue('employees', d.employeeId) + d.businessName);
                };


                //                放查询条件
                self.searchData = {
                    employeeId: dl.getEmployeeId(),
//                    'processType':self.parentViewModel.processType,
//                    keyValues: [{key: 'spia.status =?', value: '1 =? and spia.status in (2,3,4,5,6)'}],
                    status: 1
                };
                bePreProjectsListModel = oj.Model.extend({
                    parse: dl.parseModel,
                    idAttribute: 'processInstanceActivityId'
                });

                bePreProjectsListCollection = oj.Collection.extend({
                    model: new bePreProjectsListModel(),
                    parse: dl.parseCollection,
                    fetchSize: 10,
                    customPagingOptions: dl.parsePaging,
                    queryAction: 'NQ_OnLoadAuditListOfBidPaySheetProject',
                    url: dl._SERVERURL
                });
                self.collection = new bePreProjectsListCollection();
                self.dataSource = new oj.CollectionTableDataSource(self.collection);
                self.collection.generateCondition = function () {
                    return self.searchData;
                };

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    var condition = {
                        employeeId: dl.getEmployeeId(),
                        status: 1
                    };

                    dl.callOperation("NQ_OnLoadAuditListOfBidPaySheetProject", 'find', condition, self.datareceived);

                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };

            }
            return failInAtenderApplyListViewModel;
        }
);


