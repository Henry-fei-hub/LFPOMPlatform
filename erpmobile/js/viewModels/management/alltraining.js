define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojlistview', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function alltrainingViewModel(params) {
                var self = this;
                self.viewModelName = 'alltrainingViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.headerTitle = ko.observable("所有培训");
                self.iClicked = function (data, event) {
                    var trainingManagementId = data.trainingManagementId;
                    var params = {
                        id:trainingManagementId
                    }
                    dl.pushPageStack({name: 'management/alltraining', params: params, cacheKey: 'management/alltraining'});
                    dl.getGlobalModule({name: 'management/training', params: params, cacheKey: ''});
                    dl.pushHeader('所有培训');
                    dl.headerTitle("培训管理");
                };

                self.datareceived = function (data) {       
                    self.dataSource(new oj.ArrayTableDataSource(dl.parseCollection(data), {idAttribute: 'trainingManagementId'}));
                };

                self.handleActivated = function (info) {
                    // Implement if needed
                };


                self.handleAttached = function (info) {
                    var params = {
                        optType:"showAllNotStarted",
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
            return alltrainingViewModel;
        }
);


