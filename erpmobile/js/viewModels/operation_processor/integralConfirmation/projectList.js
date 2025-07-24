define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist','ojs/ojselectcombobox',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource','ojs/ojarraytabledatasource', 'ojs/ojcollectiontabledatasource'],
//define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
//    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function projectListViewModel(params) {
                var self = this;
                self.viewModelName = 'projectListViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.projectId = ko.observable(); 
                 var resultData=[];
//                  self.datareceived = function (data) {
//                      debugger;
//                    var arrData = dl.parseCollection(data);
//                    self.resultData = arrData;
//                    self.dataSource(new oj.ArrayTableDataSource(self.resultData, {idAttribute: 'projectId'}));
//                    //  某人的报销页面的标题以报销人+主题 
////                     self.specialHeaderTitle(dl.getLabelByValue('employees', arrData[0]['employeeId']) + dl.getLabelByValue('departments', arrData[0]['departmentId']));
//                };
                self.iClicked = function(data,event){
                   self.projectId(data.projectId);
                    dl.pushPageStack({name: "operation_processor/integralConfirmation/projectList", params: self.parentViewModel, cacheKey: "operation_processor/integralConfirmation/projectList"});
                    dl.getGlobalModule({name: 'operation_processor/integralConfirmation/sureIntegral', params: self});
               };

              //                放查询条件
                self.searchData = {
                      employeeId: dl.getEmployeeId()
                    };
                projectListModel = oj.Model.extend({
                    parse: dl.parseModel,
                    idAttribute: 'projectId'
                });

                projectListCollection = oj.Collection.extend({
                    model: new projectListModel(),
                    parse: dl.parseCollection,
                    fetchSize: 10,
                    customPagingOptions: dl.parsePaging,
                    queryAction: 'NQ_DesignerProjectDetail',
                    url: dl._SERVERURL
                });
                self.collection = new projectListCollection();
                self.dataSource = new oj.CollectionTableDataSource(self.collection);
                self.collection.generateCondition = function () {
                    return self.searchData;
                };



                self.handleActivated = function (info) {
                    // Implement if needed
                };


                self.handleAttached = function (info) {
//                                        var params = {
//                      employeeId: dl.getEmployeeId()
//                    };
////                    我的知会的数据
//                    dl.callOperation("NQ_DesignerProjectDetail", 'find', params, self.datareceived);
                };



                self.handleBindingsApplied = function (info) {

                    // Implement if needed
                };


                self.handleDetached = function (info) {
                    // Implement if needed
                };
            }
            return projectListViewModel;
        }
);


