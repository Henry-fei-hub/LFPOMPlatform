define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'ojs/ojdatetimepicker', 'ojs/ojselectcombobox', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function attendanceStatusDetailViewModel(params) {
                var self = this;
                self.viewModelName = 'attendanceStatusDetailViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.item = ko.observable("");
                self.menuData = ko.observableArray();
                self.datareceived = function (data) {
                    var d = dl.parseCollection(data);
                    self.menuData = d;
                    self.dataSource(new oj.ArrayTableDataSource(self.menuData, {idAttribute: 'employeeId'}));
                };

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    //加载当前年月份的数据集
                    var condition = {
                        plateId:self.parentViewModel.plateIdValue,
                        processType:self.parentViewModel.processTypeValue,
                        startDate: self.parentViewModel.startDateValue,
                        endDate: self.parentViewModel.endDateValue
                    };
                    dl.callOperation("NQ_OnLoadAttendanceStatusDetial", 'find', condition, self.datareceived);
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
                
            }
            
            return attendanceStatusDetailViewModel;
        }
);


