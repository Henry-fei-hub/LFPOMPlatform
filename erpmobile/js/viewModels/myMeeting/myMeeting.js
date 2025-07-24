define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'promise','ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function myMeetingViewModel(params) {
                var self = this;
                self.viewModelName = 'myMeetingViewModel';
                self.specialHeaderTitle='差旅会议';
                self.parentViewModel = params;
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.menuData = ko.observableArray();
                self.employeeMyMeeting = ko.observableArray();
                self.dataSource = new oj.ArrayTableDataSource(self.employeeMyMeeting, {idAttribute: 'activitieId'});
                         
                self.datareceived = function (data) {
                    
                    var d = dl.parseCollection(data);
                    if(!dl.isNullOrEmpty(d)){
                    self.employeeMyMeeting(d[0]);
                    
                    }
                };
                
                //每月详情点击事件
                self.monthClick= function (data, event) {
//                  进入我的考勤myAttendance页面 把myAttendance进栈 并且若为财务报销页面把模块替换成myAttendanceMonthList页面
//                  保存页面路径
                    dl.pushPageStack({name: 'myMeeting/myMeeting', params: self.parentViewModel, cacheKey: 'myMeeting/myMeeting'});
                    dl.getGlobalModule({name: 'myMeeting/myMeetingYearList', params: self, cacheKey: 'myMeeting/myMeetingYearList'});
//                  保存header路径 dl.headerTitle()一个ob变量 d.processTypeName 为下一页header名字
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle("每年详情");
                };
                
                             //每月详情点击事件
                self.addClick= function (data, event) {
//                  进入我的考勤myAttendance页面 把myAttendance进栈 并且若为财务报销页面把模块替换成myAttendanceMonthList页面
//                  保存页面路径
                    dl.pushPageStack({name: 'myMeeting/myMeeting', params: self.parentViewModel, cacheKey: 'myMeeting/myMeeting'});
                    dl.getGlobalModule({name: 'myMeeting/addMyMeeting', params: self, cacheKey: 'myMeeting/addMyMeeting'});
//                  保存header路径 dl.headerTitle()一个ob变量 d.processTypeName 为下一页header名字
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle("新增差旅&会议");
                };
                
                
                
                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    var condition = {
                        operateEmployeeId: dl.getEmployeeId()
                    };
                    dl.callOperation("ST_Activity", 'find', condition, self.datareceived);
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }
            return myMeetingViewModel;
        }
);


