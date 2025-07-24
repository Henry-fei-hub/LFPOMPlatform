define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojlistview', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function mytrainingViewModel(params) {
                var self = this;
                self.viewModelName = 'mytrainingViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();

                self.iClicked = function (data, event) {
                    var trainingManagementId = data.trainingManagementId;
                    var params = {
                        id:trainingManagementId
                    }
                    dl.pushPageStack({name: 'management/mytraining', params: params, cacheKey: 'management/mytraining'});
                    dl.getGlobalModule({name: 'management/training', params: params, cacheKey: ''});
                    dl.pushHeader('我的培训');
                    dl.headerTitle("培训管理");
                };

                self.datareceived = function (data) {
                    self.dataSource(new oj.ArrayTableDataSource(dl.parseCollection(data)));
                };

                self.handleActivated = function (info) {
                    // Implement if needed
                };


                self.handleAttached = function (info) {
                    var params = {
                        optType:"showMyTraining",
                        employeeId:dl.getEmployeeId(),
                        currentPage: 0,
                        pageLines: 1
                    };
                    dl.callOperation("EP_TrainingManagementProcess", '', params, self.datareceived);
                };


                self.handleBindingsApplied = function (info) {

                    // Implement if needed
                };


                self.handleDetached = function (info) {
                    // Implement if needed
                };
            }
            return mytrainingViewModel;
        }
);


