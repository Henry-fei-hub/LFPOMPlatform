define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'promise','ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function myAttendanceViewModel(params) {
                var self = this;
                self.viewModelName = 'myAttendanceViewModel';
                self.specialHeaderTitle='我的门禁';
                self.parentViewModel = params;
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.menuData = ko.observableArray();
                self.employeeMyAttendance = ko.observableArray();
                self.dataSource = new oj.ArrayTableDataSource(self.employeeMyAttendance, {idAttribute: 'employeeId'});
                
                self.datareceived = function (data) {
                    var d = dl.parseCollection(data);
                    if(!dl.isNullOrEmpty(d)){
                        self.menuData = d[0];
                        //加载我的今日考勤数据
                        var condition = {
                            employeeId: dl.getEmployeeId(),
                            recordDate: new Date(),
                            optType:"onLoadEmployeeDayCheck"
                        };
                        dl.callOperation("EP_OnShiftManageProcess","", condition, self.datareceived1);
                    }
                };
                
                self.datareceived1 = function (data) {
                    var d = dl.parseCollection(data);
                    if(!dl.isNullOrEmpty(d)){
                        self.menuData.checkin = d[0]['checkin'];
                        self.menuData.checkout = d[0]['checkout'];
                        self.menuData.attendanceStatus = d[0]['status'];
                    }
                    self.employeeMyAttendance(self.menuData);
                };
                
                //每月详情点击事件
                self.monthClick= function (data, event) {
//                  进入我的考勤myAttendance页面 把myAttendance进栈 并且若为财务报销页面把模块替换成myAttendanceMonthList页面
//                  保存页面路径
                    dl.pushPageStack({name: 'myAttendance/myAttendance', params: self.parentViewModel, cacheKey: 'myAttendance/myAttendance'});
                    dl.getGlobalModule({name: 'myAttendance/myAttendanceMonthList', params: self, cacheKey: 'myAttendance/myAttendanceMonthList'});
//                  保存header路径 dl.headerTitle()一个ob变量 d.processTypeName 为下一页header名字
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle("每月详情");
                };
                
                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    var condition = {
                        employeeId: dl.getEmployeeId()
                    };
                    dl.callOperation("ST_Employee", 'find', condition, self.datareceived);
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }
            return myAttendanceViewModel;
        }
);


