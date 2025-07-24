define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient','dl/msgbox', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl, sc) {
            function failInAtenderApplyAttentionListViewModel(params) {
                var self = this;
                self.viewModelName = 'failInAtenderApplyAttentionListViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.menuData = ko.observable();
                self.amountAttr = ko.observable("");
                self.amountoldAttr = ko.observable("");
                self.showBut = ko.observable(true);
                var pageFlag = self.parentViewModel.rowData['pageFlag'];

                self.iClicked = function (data, event) {
                    self.commonClick(event, self.isnormalData);
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
                     self.rowData = d;
                    if (dl.isNullOrUndefined(d)) {
                        return;
                    }
                    pageName = dl.getProcessPageName(processType, dl.isNullOrUndefined(pageFlag) && pageFlag == 2 ? 2 : 4);
                    if (dl.isNullOrUndefined(pageName)) {
                        return;
                    }
                    //把每次点击的module存在数组中 也不是单纯的模块名
                    dl.pushPageStack({name: 'operation_processor/failInAtender/failInAtenderApplyAttentionList', params: self.parentViewModel, cacheKey:  'operation_processor/failInAtender/failInAtenderApplyAttentionList'});
                    dl.getGlobalModule({name: pageName, params: self});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(dl.getLabelByValue('employees', d.employeeId) + d.businessName);
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

                //运营流程代办
                self.datareceived = function (data) {
                    self.isnormalData = dl.parseCollection(data);
                    if (self.isnormalData.length > 0) {
                        $('.isnormal_approvalment').show();
                        $('#but').show();
                    } else {
                        $('.pooled_approvalment').css({'margin-top': 40});
                        $('#but').hide();
                    }
                    if (Number(self.parentViewModel.handelType) === 1) {
                        self.dataSource(new oj.ArrayTableDataSource(self.isnormalData, {idAttribute: 'processInstanceActivityId'}));
                    } else {
                        self.dataSource(new oj.ArrayTableDataSource(self.isnormalData, {idAttribute: 'systemProcessAttentionId'}));
                    }
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    self.showBut(true);
                    if (!dl.isNullOrUndefined(pageFlag) && pageFlag == 2) {
                        self.showBut(false);
                    }
                    var condition = {
                        currentPage: 0,
                        pageLines: 1,
                        employeeId: dl.getEmployeeId(),
                        status: !dl.isNullOrUndefined(pageFlag) && pageFlag == 2 ? 2 : 1
                    };
                    $('.isnormal_approvalment').hide();
                    var processType = Number(self.parentViewModel.processType);
                    //项目立项
                    if (processType === 73) {
                        if (Number(self.parentViewModel.handelType) === 2) {//知会
                            dl.callOperation("NQ_OnLoadAttentionListOfBidPaySheetProject", 'find', condition, self.datareceived);
                        }
                    }

                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };

            }
            return failInAtenderApplyAttentionListViewModel;
        }
);


