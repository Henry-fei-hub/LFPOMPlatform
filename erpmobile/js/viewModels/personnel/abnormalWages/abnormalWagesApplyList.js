define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function abnormalWagesApplyListViewModel(params) {
                var self = this;
                self.viewModelName = 'abnormalWagesApplyListViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.dataSource1 = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.menuData = ko.observable();
                self.pooledData = ko.observable();
                self.amountAttr = ko.observable("");
                self.amountoldAttr = ko.observable("");

                self.iClicked = function (data, event) {
                    self.commonClick(event, self.normalData);
                };

                self.pooledClicked = function (data, event) {
                    self.commonClick(event, self.pooledData);
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
                    pageName = dl.getProcessPageName(processType, 3);
                    //获取当前页面的目录
                    var currentPageName = dl.getProcessPageName(processType, 1);
                    if (dl.isNullOrUndefined(pageName) || dl.isNullOrUndefined(currentPageName)) {
                        return;
                    }
                    self.rowData = d;
                    //把每次点击的module存在数组中 也不是单纯的模块名
                    dl.pushPageStack({name: currentPageName, params: self.parentViewModel});
                    dl.getGlobalModule({name: pageName, params: self});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(dl.getLabelByValue('employees', d.employeeId) + d.businessName);
                };


                //人事流程代办
                self.datareceived = function (data) {
                    self.normalData = dl.parseCollection(data);
                    if (self.normalData.length > 0) {
                        $('.normal_approvalment').show();
                    } else {
                        $('.pooled_approvalment').css({'margin-top': 40});
                    }
                    if (Number(self.parentViewModel.handelType) === 1) {
                        self.dataSource(new oj.ArrayTableDataSource(self.normalData, {idAttribute: 'processInstanceActivityId'}));
                    } else {
                        self.dataSource(new oj.ArrayTableDataSource(self.normalData, {idAttribute: 'systemProcessAttentionId'}));
                    }
                };

                //待办任务池审批的数据
                self.datareceived1 = function (data) {
                    self.pooledData = dl.parseCollection(data);
                    if (self.pooledData.length > 0) {
                        $('.pooled_approvalment').show();
                    }
                    self.dataSource1(new oj.ArrayTableDataSource(self.pooledData, {idAttribute: 'processPooledTaskId'}));
                };

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    var condition = {
                        currentPage: 0,
                        pageLines: 1,
                        employeeId: dl.getEmployeeId(),
                        processType: self.parentViewModel.processType,
                        status: 1
                    };
                    $('.pooled_approvalment').hide();
                    $('.normal_approvalment').hide();
                    var processType = Number(self.parentViewModel.processType);
                    //工资异常申请
                    if (processType === 45) {
                        //人事流程数据加载
                        if (Number(self.parentViewModel.handelType) === 1) {//待办
                            dl.callOperation("NQ_OnLoadAuditListOfPersonnel", 'find', condition, self.datareceived);
                            dl.callOperation("NQ_OnLoadTaskListOfPersonnel", 'find', condition, self.datareceived1);
                        } else {//知会
                            dl.callOperation("NQ_OnLoadAttentionListOfPersonnel", 'find', condition, self.datareceived);
                        }
                    }

                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };

            }
            return abnormalWagesApplyListViewModel;
        }
);


