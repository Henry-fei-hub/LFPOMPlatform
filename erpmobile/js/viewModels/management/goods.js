
define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/msgbox', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojbutton', 'ojs/ojcheckboxset', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojdatetimepicker'],
        function (oj, ko, $, dl, sc) {

            function goodsViewModel(params) {
                var self = this;
                self.viewModelName = 'goodsViewModel';
                self.parentViewModel = params;
                self.errorMsg = ko.observable('');
                self.__sub = ko.observable(); 
                self.__date = ko.observable();
                self.__goods = ko.observable();
                self.__count = ko.observable();
//          按钮的返回事件
                self.rebackToClick = function (event, ui) {
                        dl.getGlobalModule(dl.popPageStack());
                        dl.headerTitle(dl.popHeader());
                };

                self.submitClick = function (event, ui) {
                    var paramData = {
                        optType:"getGoods",
                        goodsReceiveId: params['id'],
                        employeeId: dl.getEmployeeId(),
                        employeeNumber: dl.getEmployeeNo(),
                        departmentId: dl.getDepartmentId(),
//                        employeeName: dl.getEmployeeName(),
                    };
                    dl.callOperation("EP_GoodsReceiveProcess", "", paramData, function (response) {
                        if (response.ResultSet.status >= 0) {
                             self.ulShow(0);
                            sc.alert("领取成功");
                        }else{
                            sc.alert(response.ResultSet.errors);
                        }

                    });
                };

                self.ulShow = ko.observable('0');

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                    var condition = {
                        goodsReceiveId: params['id']
                    };
                    dl.callOperation("ST_GoodsReceive", 'find', condition, function (response) {
                        if(response.ResultSet.status >= 0){
                            var data = dl.parseCollection(response)[0];
                            self.__sub(data.subject);
                            self.__date(dl.dateConverter.format(dl.parseValueFromService(data.receiveDate)));
                            self.__goods(data.goodsDetail);
                            self.__count(data.count);
                        }
                    });
//                    var condition2 = {
//                        optType:"getFlag",
//                        goodsReceiveId: params['id'],
//                        employeeId:dl.getEmployeeId()
//                    }
//                    dl.callOperation("EP_GoodsReceiveProcess", 'find', condition2, function (response) {
//                        if(response.ResultSet.status > 0){
//                             self.ulShow(0);
//                        }else{
//                            self.ulShow(1);
//                        }
//                    });
                };

                self.handleAttached = function (info) {

                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return goodsViewModel;
        }
);


