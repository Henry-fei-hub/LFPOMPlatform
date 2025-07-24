define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'ojs/ojdatetimepicker', 'ojs/ojselectcombobox', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function attendanceStatusViewModel(params) {
                var self = this;
                self.viewModelName = 'attendanceStatusViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.item = ko.observable("");
                self.menuData = ko.observableArray();
                self.iClicked = function (data, event) {
                    var target = event.currentTarget;
                    var id = target.id;
                    var name = target.name;
                    self.processTypeValue = id;
                    self.plateIdValue = self.parentViewModel.plateIdValue;
                    self.startDateValue = self.parentViewModel.startDateValue;
                    self.endDateValue = self.parentViewModel.endDateValue;
                    var pageName = "attendanceStatusDetail";
//                    进入我的代办myApproval页面 把myApproval进栈 并且若为财务报销页面把模块替换成reimbursementList页面
//                    保存页面路径
                    dl.pushPageStack({name: 'myAttendance/attendanceStatus', params: self.parentViewModel, cacheKey: 'myAttendance/attendanceStatus'});
                    dl.getGlobalModule({name: 'myAttendance/'+pageName, params: self, cacheKey: 'myAttendance/'+pageName});
//                    保存header路径 dl.headerTitle()一个ob变量 d.processTypeName 为下一页header名字
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(dl.getLabelByValue('system_dictionary_1',self.parentViewModel.plateIdValue)+name+'详情');
                };
                
                self.datareceived = function (data) {
                    var d = dl.parseCollection(data);
                    self.menuData = d;
                    self.dataSource(new oj.ArrayTableDataSource(self.menuData, {idAttribute: 'processType'}));
                };

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    //加载当前年月份的数据集
                    var condition = {
                        plateId:self.parentViewModel.plateIdValue,
                        startDate: self.parentViewModel.startDateValue,
                        endDate: self.parentViewModel.endDateValue
                    };
                    dl.callOperation("NQ_OnLoadAttendanceStatus", 'find', condition, self.datareceived);
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
                
            }
            
            return attendanceStatusViewModel;
        }
);


