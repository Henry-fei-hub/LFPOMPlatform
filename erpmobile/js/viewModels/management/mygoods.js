define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojlistview', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function mygoodsViewModel(params) {
                var self = this;
                self.viewModelName = 'mygoodsViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();

                self.iClicked = function (data, event) {
                    var goodsReceivesId = data.goodsReceiveId;
                    var params = {
                        id:goodsReceivesId
                    }
                    dl.pushPageStack({name: 'management/mygoods', params: params});
                    dl.getGlobalModule({name: 'management/goods', params: params});
                    dl.pushHeader('我的领用');
                    dl.headerTitle("物品领用");
                };

                self.datareceived = function (data) {
                    self.dataSource(new oj.ArrayTableDataSource(dl.parseCollection(data)));
                };

                self.handleActivated = function (info) {
                    // Implement if needed
                };


                self.handleAttached = function (info) {
                    var params = {
                        optType:"showMyAll",
                        employeeId:dl.getEmployeeId(),
                        currentPage: 0,
                        pageLines: 1
                    };
                    dl.callOperation("EP_GoodsReceiveProcess", '', params, self.datareceived);
                };


                self.handleBindingsApplied = function (info) {

                    // Implement if needed
                };


                self.handleDetached = function (info) {
                    // Implement if needed
                };
            }
            return mygoodsViewModel;
        }
);


