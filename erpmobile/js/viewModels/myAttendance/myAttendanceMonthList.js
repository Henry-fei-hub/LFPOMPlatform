define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function myAttendanceMonthListViewModel(params) {
                var self = this;
                self.viewModelName = 'myAttendanceMonthListViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.item = ko.observable("");
                self.menuData = ko.observableArray();
                self.iClicked = function (data, event) {
//                    财务报销页面 
                    var monthTypes = [1,2, 3, 4, 5, 6, 7, 8, 9,10,11,12];
                    var target = event.currentTarget;
                    var id = target.id;
                    var pageName;
//                     传入的id能在这个数组里找到显示财务报销页面  含有报销编号的页面就显示reimbursementList模块页面
                    if ($.inArray(id, monthTypes)) {
                        pageName = "myAttendanceDayList";
                    }
                    if (dl.isNullOrUndefined(pageName))
                        return;
                    self.month = id;
//                    进入我的代办myApproval页面 把myApproval进栈 并且若为财务报销页面把模块替换成reimbursementList页面
//                    保存页面路径
                    dl.pushPageStack({name: 'myAttendance/myAttendanceMonthList', params: self.parentViewModel, cacheKey: 'myAttendance/myAttendanceMonthList'});
                    dl.getGlobalModule({name: 'myAttendance/'+pageName, params: self, cacheKey: 'myAttendance/'+pageName});
//                    通过点击我的代办列表里的某一条，获得数据d
                    var d = dl.findCurrentDataByAttr(id, "month", self.menuData);
//                    保存header路径 dl.headerTitle()一个ob变量 d.processTypeName 为下一页header名字
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(id+" 月详情");
                };

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    var data = [];
                    var num = 12;
                    for(var i=1;i<=num;i++){
                        var detail = {};
                        detail.month = i;
                        detail.name = i+" 月";
                        data[i-1] = detail;
                    }
                    self.menuData = data;
                    self.dataSource(new oj.ArrayTableDataSource(self.menuData));
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }
            
            return myAttendanceMonthListViewModel;
        }
);


