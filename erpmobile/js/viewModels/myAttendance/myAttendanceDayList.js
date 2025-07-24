define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function myAttendanceDayListViewModel(params) {
                var self = this;
                self.viewModelName = 'myAttendanceDayListViewModel';
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
                    self.employeeDayCheckId = id;
                    var pageName = "myAttendanceDayDetail";
//                    进入我的代办myApproval页面 把myApproval进栈 并且若为财务报销页面把模块替换成reimbursementList页面
//                    保存页面路径
                    dl.pushPageStack({name: 'myAttendance/myAttendanceDayList', params: self.parentViewModel, cacheKey: 'myAttendance/myAttendanceDayList'});
                    dl.getGlobalModule({name: 'myAttendance/'+pageName, params: self, cacheKey: 'myAttendance/'+pageName});
//                    通过点击我的代办列表里的某一条，获得数据d
                    var d = dl.findCurrentDataByAttr(id, "employeeDayCheckId", self.menuData);
//                    保存header路径 dl.headerTitle()一个ob变量 d.processTypeName 为下一页header名字
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(dl.dateViewConverter.format(dl.parseValueFromService(d.recordDate)));
                };

                self.datareceived = function (data) {
                    var d = dl.parseCollection(data);
                    self.menuData = d;
                    self.dataSource(new oj.ArrayTableDataSource(self.menuData, {idAttribute: 'employeeDayCheckId'}));
                };

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    //获取当前日期的年份
                    var date = new Date();
                    var year=date.getFullYear();
                    //加载当前年月份的数据集
                    var condition = {
                        employeeId: dl.getEmployeeId(),
                        year: year,
                        month:params.month,
                        addtionalCondition:'order by record_date asc'
                    };
                    dl.callOperation("ST_EmployeeDayCheck", 'find', condition, self.datareceived);
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }
            
            return myAttendanceDayListViewModel;
        }
);


