define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojdatetimepicker', 'ojs/ojjsontreedatasource','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function preProjectsApplySimilarViewModel(params) {
                var self = this;
                self.viewModelName = 'preProjectsApplySimilarViewModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                self.dataSource = ko.observable(new oj.ArrayTableDataSource(params.similarData()));
                self.dataSource1 = ko.observable(new oj.ArrayTableDataSource([params.alldata()]));
               self.submitClick = function (data, event) {
                    var paramData = {
                        operatorId: dl.getEmployeeId(),
                        processDefinition: {processId: params.processID}
                    };
                    dl.submitNewCreatWork(paramData, self);
                };
                                  
               
                self.getValues = function () {
                    var resultData = params.alldata();
                    return resultData;
                };
                
                self.checkData = function (values) {
                     return true;
                };
                
                //审批后执行的方法 STEP4
                self.workCallback = function (data) {
                    if (data.ResultSet.status >= 0) {
                        params.errorMessage('');
                        var returnData = dl.parseCollection(data);
                        self.processInstanceId = returnData[0].processInstanceId;
                        dl.popPageStack();
                        dl.popHeader();
                        dl.getGlobalModule({name: 'schedule', params: self});
                        dl.headerTitle("流程进度");
                    } else {
                        params.errorMessage('♥提示:' + decodeURIComponent(data.ResultSet.errors));
                    }
                };
               
                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                   
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return preProjectsApplySimilarViewModel;
        }
);


