/* global decodeURIComponent */
define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojpagingtabledatasource', 'ojs/ojrouter', 'ojs/ojdialog', 'ojs/ojbutton', 'ojs/ojknockout', 'ojs/ojmodel',
    'promise', 'ojs/ojdatagrid', 'ojs/ojpagingcontrol', 'ojs/ojcollectiondatagriddatasource', 'ojs/ojpagingdatagriddatasource',
    'ojs/ojconveyorbelt', 'dl/workflow', 'ojs/ojdiagram', 'ojs/ojjsondiagramdatasource'],
        function (oj, ko, $, dl) {

            function testflowViewModel() {
                var self = this;


                self.handleAttached = function (info) {
                    // Implement if needed
                };


                self.handleBindingsApplied = function (info) {
                    // Implement if needed
                };


                self.handleDetached = function (info) {
                    // Implement if needed
                };
            }


            return new testflowViewModel();
        }
);
