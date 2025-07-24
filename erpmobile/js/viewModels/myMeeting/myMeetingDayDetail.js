define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'promise','ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function myMeetingDayDetailViewModel(params) {
                var self = this;
                self.viewModelName = 'myMeetingDayDetailViewModel';
                self.specialHeaderTitle=params.specialHeaderTitle;
                self.parentViewModel = params;
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.menuData = ko.observableArray();
                self.employeeMyAttendance = ko.observableArray();
                self.dataSource = ko.observable();
                
                self.datareceived = function (data) {
                    var d = dl.parseCollection(data);
                    self.menuData = d;
                    self.dataSource(new oj.ArrayTableDataSource(self.menuData, {idAttribute: 'activitieId'}));
                };
                
                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    //加载我的今日考勤数据
                    var condition = {
                        activitieId: params.activitieId
                    };
                    dl.callOperation("ST_Activity", 'find', condition, self.datareceived);
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }
            return myMeetingDayDetailViewModel;
        }
);


