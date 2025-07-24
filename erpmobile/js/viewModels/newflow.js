/**
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates.
 * The Universal Permissive License (UPL), Version 1.0
 */
/*
 * Your incidents ViewModel code goes here
 */
define(['ojs/ojcore', 'knockout', 'jquery', 'ojs/ojtabs', 'hammerjs', 'ojs/ojjquery-hammer', 'ojs/ojknockout', 'ojs/ojoffcanvas', 'ojs/ojbutton', 'dl/commclient'],
        function (oj, ko, $) {

            function newflowViewModel(params) {
                var self = this;
                self.leftModel = {name: 'newflowleft', params: {data : self}};
                self.rightModel = {name: 'newflowright', params: {data : self}};
                self.viewModelName = 'newflow';
                self.parentViewModel = params.data;
                if (dl.isNullOrUndefined(self.parentViewModel.details))
                    self.parentViewModel.details = [];
                self.getCurrentDetailPageType = self.parentViewModel.getCurrentDetailPageType();
                if(self.getCurrentDetailPageType === dl._DETAILTYPE_UPDATE && self.parentViewModel.currentData){
                    self.currentData = self.parentViewModel.currentData;
                }
                var thisViewModel = {name: 'newflow', data: self, detailType: self.getCurrentDetailPageType};
                dl.addViewModelToParentDetails(self.parentViewModel.details, thisViewModel);

                self.setDataToControls = function () {
//                    if (self.parentViewModel.currentData) {
//                        self.currentData = self.parentViewModel.currentData;
//                        dl.copyAllDetailDataToControls(self, self.getCurrentDetailPageType);
//                        dl.copyDataToControls(self.parentViewModel.currentData.data.attributes, self);
//                    }
                };

                self.setDataFromControls = function () {
                    if (!self.parentViewModel.currentData) {
                        self.parentViewModel.currentData = {};
                        self.parentViewModel.currentData.data = {};
                        self.parentViewModel.currentData.data.attributes = {};
                    }
                    dl.copyAllDetailDataFromControls(self, self.getCurrentDetailPageType);
                    if(self.currentData.data.attributes){
                        for(var key in self.currentData.data.attributes){
                            self.parentViewModel.currentData.data.attributes[key] = self.currentData.data.attributes[key];
                        }
                    }
//                    dl.copyDataFromControls(self.parentViewModel.currentData.data.attributes, self);
                };
                // Below are a subset of the ViewModel methods invoked by the ojModule binding
                // Please reference the ojModule jsDoc for additionaly available methods.

                /**
                 * Optional ViewModel method invoked when this ViewModel is about to be
                 * used for the View transition.  The application can put data fetch logic
                 * here that can return a Promise which will delay the handleAttached function
                 * call below until the Promise is resolved.
                 * @param {Object} info - An object with the following key-value pairs:
                 * @param {Node} info.element - DOM element or where the binding is attached. This may be a 'virtual' element (comment node).
                 * @param {Function} info.valueAccessor - The binding's value accessor.
                 * @return {Promise|undefined} - If the callback returns a Promise, the next phase (attaching DOM) will be delayed until
                 * the promise is resolved
                 */
                self.handleActivated = function (info) {
                    // Implement if needed
                };

                /**
                 * Optional ViewModel method invoked after the View is inserted into the
                 * document DOM.  The application can put logic that requires the DOM being
                 * attached here.
                 * @param {Object} info - An object with the following key-value pairs:
                 * @param {Node} info.element - DOM element or where the binding is attached. This may be a 'virtual' element (comment node).
                 * @param {Function} info.valueAccessor - The binding's value accessor.
                 * @param {boolean} info.fromCache - A boolean indicating whether the module was retrieved from cache.
                 */
                self.handleAttached = function (info) {
                    // Implement if needed
                };


                /**
                 * Optional ViewModel method invoked after the bindings are applied on this View. 
                 * If the current View is retrieved from cache, the bindings will not be re-applied
                 * and this callback will not be invoked.
                 * @param {Object} info - An object with the following key-value pairs:
                 * @param {Node} info.element - DOM element or where the binding is attached. This may be a 'virtual' element (comment node).
                 * @param {Function} info.valueAccessor - The binding's value accessor.
                 */
                self.handleBindingsApplied = function (info) {
                    // Implement if needed
                };

                /*
                 * Optional ViewModel method invoked after the View is removed from the
                 * document DOM.
                 * @param {Object} info - An object with the following key-value pairs:
                 * @param {Node} info.element - DOM element or where the binding is attached. This may be a 'virtual' element (comment node).
                 * @param {Function} info.valueAccessor - The binding's value accessor.
                 * @param {Array} info.cachedNodes - An Array containing cached nodes for the View if the cache is enabled.
                 */
                self.handleDetached = function (info) {
                    // Implement if needed
                };
            }

            /*
             * Returns a constructor for the ViewModel so that the ViewModel is constrcuted
             * each time the view is displayed.  Return an instance of the ViewModel if
             * only one instance of the ViewModel is needed.
             */
            return newflowViewModel;
        }
);

