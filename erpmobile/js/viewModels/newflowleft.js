


define(['ojs/ojcore', 'knockout', 'jquery', 'ojs/ojselectcombobox', 'ojs/ojinputtext', 'ojs/ojcheckboxset', 'ojs/ojdatetimepicker', 'ojs/ojinputnumber', 'dl/commclient'],
        function (oj, ko, $) {
            function newFlowLeftViewModel(params) {
                var self = this;
                self.viewModelName = 'newflowleft';
                self.parentViewModel = params.data;
                if (dl.isNullOrUndefined(self.parentViewModel.details))
                    self.parentViewModel.details = [];
                var thisViewModel = {name: 'newflowleft', data: self, detailType: self.parentViewModel.getCurrentDetailPageType};
                dl.addViewModelToParentDetails(self.parentViewModel.details, thisViewModel);
                self.__processTypeId = ko.observable();
                self.__processName = ko.observable();
                self.__description = ko.observable();
                
                self.setDataToControls = function () {
                    if (self.parentViewModel.currentData) {
                        dl.copyDataToControls(self.parentViewModel.currentData.data.attributes, self);
                    }
                };

                self.setDataFromControls = function () {
                    if (!self.parentViewModel.currentData) {
                        self.parentViewModel.currentData = {};
                        self.parentViewModel.currentData.data = {};
                        self.parentViewModel.currentData.data.attributes = {};
                    }
                    dl.copyDataFromControls(self.parentViewModel.currentData.data.attributes, self);
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    if(self.parentViewModel.getCurrentDetailPageType === dl._DETAILTYPE_UPDATE && !dl.isNullOrUndefined(self.parentViewModel.currentData)){
                        dl.copyDataToControls(self.parentViewModel.currentData.data.attributes, self);
                    }
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };

            }
            return newFlowLeftViewModel;
        }
);