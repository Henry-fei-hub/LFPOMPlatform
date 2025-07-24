/**
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates.
 * The Universal Permissive License (UPL), Version 1.0
 */
/*
 * Your about ViewModel code goes here
 */
define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojpagingtabledatasource', 'ojs/ojrouter', 'ojs/ojdialog', 'ojs/ojbutton', 'ojs/ojknockout', 'ojs/ojmodel',
    'promise', 'ojs/ojdatagrid', 'ojs/ojpagingcontrol', 'ojs/ojcollectiondatagriddatasource', 'ojs/ojpagingdatagriddatasource',
    'ojs/ojconveyorbelt', 'dl/workflow', 'ojs/ojdiagram', 'ojs/ojjsondiagramdatasource', 'ojs/ojchart', 'ojs/ojgauge', 'ojs/ojtoolbar'],
        function (oj, ko, $, dl) {

            function scheduleViewModel(params) {
                var self = this;
                var pieSeries = [{name: "正常", items: [50]},
                                 {name: "迟到", items: [15]},
                                 {name: "早退", items: [5]},
                                 {name: "旷工", items: [2]}];
                this.pieSeriesValue = ko.observableArray(pieSeries);
                var converterFactory = oj.Validation.converterFactory('number');         
                var converter = converterFactory.createConverter({pattern: "#.#%"});
                this.pieSliceLabel = function(dataContext){
                    var percent = dataContext.value/dataContext.totalValue;
                    return dataContext.value+"人("+converter.format(percent)+ ")";
                };
                self.diagramDefaults = {
                    linkDefaults: {
                        startConnectorType: 'none', endConnectorType: 'arrow', width: 5
                    },
                    nodeDefaults: {
                        icon: {
                            width: 64, height: 64,
                            source: '/css/images/start.png'

                        }
                    }
                };

                self.diagramResize = function (data, event) {
                    $('#diagram').ojDiagram('refresh');
                };
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
//                    dl.callOperation('EP_GetProcessInstance', '', {processInstanceId: self.parentViewModel.processInstanceId}, self.getProcessInstanceCallback);
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
            return scheduleViewModel;
        }
);
