define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function capitalDistributionsExamineListViewModel(params) {
                var self = this;
                self.viewModelName = 'capitalDistributionsExamineListViewModel';
                self.parentViewModel = params;

                self.dataSource = ko.observable();
                self.dataSource1 = ko.observable();

                self.selectedItem = ko.observable("");
                self.isShow = ko.observable(1);
                self.isShow11 = ko.observable(1);
                self.goPage = function (type, businessId) {
                    var processType = params.processType;
                    var pageName;
                    var id = businessId; //业务主键
//                  每个报销特有businessId
                    var d = dl.findCurrentDataByAttr(id, 'businessId', type === 1 ? self.normalData : self.pooledData);
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
                    dl.pushPageStack({name: "myExamine/capitalDistributionsExamineList", params: self.parentViewModel});
                    dl.getGlobalModule({name: pageName, params: self});
//                    headerTitle
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(dl.headerTitle());
                };
                self.returnTitle = function (data) {
                    if (data['processType'] == 11) {
                        return dl.getLabelByValue('employees', data['applyEmployeeId']) + data['title'];
                    }
                };
                self.iClicked = function (data, event) {

                    var target = event.currentTarget;
                    var id = target.id; //业务主键
                    self.goPage(1, id);
                };
                self.pooledClicked = function (data, event) {
                    var target = event.currentTarget;
                    var id = target.id; //业务主键
                    self.goPage(2, id);
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
                //待办单独审批的数据
                self.datareceived = function (data) {
                    self.normalData = dl.parseCollection(data);

                    if (self.normalData.length > 0) {
                        $('.normal_approvalment').show();
                        $(".pooled_approvalment").css({marginTop: 0});
                    } else {
                        $(".pooled_approvalment").css({marginTop: "40px"});
                    }
                    self.dataSource(new oj.ArrayTableDataSource(dl.parseCollection(data), {idAttribute: 'processInstanceActivityId'}));
                };

                //待办任务池审批的数据
                self.datareceived1 = function (data) {
                    self.pooledData = dl.parseCollection(data);

                    if (self.pooledData.length > 0) {
                        $('.pooled_approvalment').show();
                    }
                    self.dataSource1(new oj.ArrayTableDataSource(dl.parseCollection(data), {idAttribute: 'processPooledTaskId'}));
                };


                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                    // Implement if needed
                };


                self.handleAttached = function (info) {
                    var condition = {
                        currentPage: 0,
                        pageLines: 1,
                        employeeId: dl.getEmployeeId(),
                        processType: self.parentViewModel.processType
                    };
                    $('.pooled_approvalment').hide();
                    $('.normal_approvalment').hide();
                    var processType = Number(self.parentViewModel.processType);
//                     单个
                    dl.callOperation("NQ_CapitalDistributionsAuditOfWorkflow", 'find', condition, self.datareceived);

                    var condition1 = {
                        currentPage: 0,
                        pageLines: 1,
                        employeeId: dl.getEmployeeId(),
                        processType: self.parentViewModel.processType,
                        status: 2
                    };
//                        多个
                    dl.callOperation("NQ_CapitalDistributionsPoolOfWorkflow", 'find', condition1, self.datareceived1);


                };

                self.handleBindingsApplied = function (info) {
                    // Implement if needed
                };

                self.handleDetached = function (info) {
                    // Implement if needed
                };

            }
            return capitalDistributionsExamineListViewModel;
        }
);


