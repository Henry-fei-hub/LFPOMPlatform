define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist','ojs/ojselectcombobox',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function preProjectViewModel(params) {
                var self = this;
                self.viewModelName = 'preProjectViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.item = ko.observable("");
                self.id = ko.observable("");
                self.preProjectId = ko.observable(); 
                self.searchVal = ko.observable(); 
                 var resultData=[];
                self.sureClick = function(){
                    var newData=[];    
                   for(var i =0; i<resultData.length;i++){     
                       var projectName = resultData[i]['projectName'];
                       var checkName = self.searchVal();
                       if(projectName.indexOf(checkName) >= 0){
                          newData.push(resultData[i]);
                       }
                          self.dataSource(new oj.ArrayTableDataSource(newData, {idAttribute: 'infoCode'}));
                   };
                };
                self.iClicked = function(event,data){
                   self.preProjectId(data.currentTarget.id);
                    dl.pushPageStack({name: "market/preProject", params: self.parentViewModel, cacheKey: "market/preProject"});
                    dl.getGlobalModule({name: 'market/addingRecord', params: self});
               };


                self.datareceived = function (data) {
                    self.dataSource(new oj.ArrayTableDataSource(dl.parseCollection(data), {idAttribute: 'infoCode'}));
                    resultData = data['ResultSet']['Result'];
                };





                self.handleActivated = function (info) {
                    // Implement if needed
                };


                self.handleAttached = function (info) {
                    var params = {
                        currentPage: 1,
                        pageLines: 20,
                        applyEmployeeId: dl.getEmployeeId(),
                        mpeEmployeeId: dl.getEmployeeId(),
                        departmentId:dl.getDepartmentId(),
                        keyValues :[{"key":"CAST(aa.win_rate AS INTEGER) > ?","value":"1 > ?"}]  
                    };

                    dl.callOperation("NQ_projectPreInfomations", 'find', params, self.datareceived);
                };



                self.handleBindingsApplied = function (info) {

                    // Implement if needed
                };


                self.handleDetached = function (info) {
                    // Implement if needed
                };
            }
            return preProjectViewModel;
        }
);


