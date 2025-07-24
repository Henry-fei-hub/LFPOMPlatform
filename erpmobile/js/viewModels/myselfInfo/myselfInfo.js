define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'promise','ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function myselfInfoViewModel(params) {
                var self = this;
                self.viewModelName = 'myselfInfoViewModel';
                self.specialHeaderTitle='我的资料';
                self.parentViewModel = params;
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.menuData = ko.observableArray();
                self.employeeMyselfInfo = ko.observableArray();
                self.dataSource = new oj.ArrayTableDataSource(self.employeeMyselfInfo, {idAttribute: 'employeeId'});
                self.employeeMyProjectInfo = ko.observableArray();
                self.dataSource1 = new oj.ArrayTableDataSource(self.employeeMyProjectInfo);
                self.photo =  ko.observable("");
                self.datareceived = function (data) {
                    var d = dl.parseCollection(data);
                     self.photo(d[0].photo);
                    self.menuData = d;
                    self.employeeMyselfInfo(self.menuData);
                };
                
                self.datareceived1 = function (data) {
                    var d = dl.parseCollection(data);
                    self.employeeMyProjectInfo(d);
                };

                
                //保存点击事件
               self.saveClick= function (data, event) {
                    dl.callOperation("ST_Employee", 'update', self.menuData[0], self.saveCallback);
               };
               //保存后的方法
               self.saveCallback = function (data) {
                    if (data.ResultSet.status >= 0) {
                        console.log('操作成功');
                    } else {
                        alert(data.ResultSet.errors);
                    }
                };
                
                //上传头像
                self.uploadImgClick= function (data, event) {
//                    dl.callOperation("ST_Employee", 'update', self.menuData[0], self.saveCallback);

                };
                
                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    //加载我的资料信息
                    var condition = {
                        employeeId: dl.getEmployeeId()
                    };
                    dl.callOperation("ST_Employee", 'find', condition, self.datareceived);
                };

                self.handleBindingsApplied = function (info) {
                    //加载我的项目
                    var condition = {
                        employeeId: dl.getEmployeeId()
                    };
                    dl.callOperation("EP_DesignerGetMsg", 'find', condition, self.datareceived1);
                };

                self.handleDetached = function (info) {
                };
            }
            return myselfInfoViewModel;
        }
);


