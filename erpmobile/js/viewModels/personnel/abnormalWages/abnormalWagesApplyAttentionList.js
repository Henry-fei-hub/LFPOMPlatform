define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient','dl/msgbox', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl, sc) {
            function abnormalWagesApplyAttentionListViewModel(params) {
                var self = this;
                self.viewModelName = 'abnormalWagesApplyAttentionListViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.menuData = ko.observable();
                self.amountAttr = ko.observable("");
                self.amountoldAttr = ko.observable("");
                self.showBut = ko.observable(true);
                self.pageFlag = self.parentViewModel.rowData['pageFlag'];

                self.iClicked = function (data, event) {
                    self.commonClick(event, self.normalData);
                };
                // 一键标记已读
                self.readToggetherClick = function (data, event) {
                    dl.attentionBatchReadWork(params.processType, self);
                };
//                一键标记已读的回调函数
                self.batchReadCallback = function (data) {
                    self.handleAttached();
                     self.collection.refresh();
                };
                //列表点击的功用方法
                self.commonClick = function (event, selfData) {
                    var processType = params.processType;
                    var pageName;
                    var target = event.currentTarget;
                    var id = target.id; //业务主键
                    //每个报销特有businessId
                    var d = dl.findCurrentDataByAttr(id, 'businessId', selfData);                 
                    d['pageFlag']=2;
                    self.rowData=d;
                    if (dl.isNullOrUndefined(d)) {
                        return;
                    }
                    // 4 atttenton 2 view
                    pageName = dl.getProcessPageName(processType, !dl.isNullOrUndefined(self.pageFlag) && self.pageFlag === 2 ? 2 : 4);
                    if (dl.isNullOrUndefined(pageName)) {
                        return;
                    }
                    self.rowData = d;
                    //把每次点击的module存在数组中 也不是单纯的模块名
                    dl.pushPageStack({name: 'personnel/abnormalWages/abnormalWagesApplyAttentionList', params: self.parentViewModel, cacheKey: 'personnel/abnormalWages/abnormalWagesApplyAttentionList'});
                    dl.getGlobalModule({name: pageName, params: self});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(dl.getLabelByValue('employees', d.employeeId) + d.businessName);
                };


                //人事流程代办s
                self.datareceived = function (data) {
                    self.normalData = dl.parseCollection(data);
                    if (self.normalData.length > 0) {
                        $('.isnormal_approvalment').show();
                        $('#but').show();
                    } 
                    if (Number(self.parentViewModel.handelType) === 1) {
                        self.dataSource(new oj.ArrayTableDataSource(self.normalData, {idAttribute: 'processInstanceActivityId'}));
                    } else {
                        self.dataSource(new oj.ArrayTableDataSource(self.normalData, {idAttribute: 'systemProcessAttentionId'}));
                    }
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
                    var condition = {
                        currentPage: 0,
                        pageLines: 1,
                        employeeId: dl.getEmployeeId(),
                        processType: self.parentViewModel.processType,
                        status: !dl.isNullOrUndefined(self.pageFlag) && self.pageFlag === 2 ? 2 : 1
                    };
                    $('.isnormal_approvalment').hide();
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
            return abnormalWagesApplyAttentionListViewModel;
        }
);


