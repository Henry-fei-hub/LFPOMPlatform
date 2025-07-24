define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function SupplierComeInApplyAttentionViewModel(params) {
                var self = this;
                self.viewModelName = 'SupplierComeInApplyAttentionViewModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                self.dataSource = ko.observable();
                self.dataSource1 = ko.observable();
                self.dataSource2 = ko.observable();
                self.dataSource3 = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.resultData = ko.observable();
                var billData1 = [];
                var billData2 = [];
                var billData3 = [];
                self.specialHeaderTitle = ko.observable('');
                self.isApproval = ko.observable(true);
                self.fileId = ko.observable('');
                self.fileUrl = ko.observable('');


                self.datareceived = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.resultData = arrData;
                    self.fileId(arrData[0].fileId);
                    self.dataSource(new oj.ArrayTableDataSource(arrData, {idAttribute: 'supplierId'}));
                    self.specialHeaderTitle(arrData[0]['supplierName'] + '(' + arrData[0]['supplierContact'] + ')');
                    dl.callOperation("NQ_FileManages", 'find', {fileId: self.fileId()}, function (data) {
                        var arrData = data.ResultSet.Result;
                        self.fileUrl(arrData[0].fileUrl);

                    });
                    //                    进入即阅
                    dl.submitApprovalWork(0, params.rowData, self);
                };
                self.datareceived1 = function (data) {
                    var arrData = data.ResultSet.Result;
                    billData1=arrData;
                    self.dataSource1(new oj.ArrayTableDataSource(arrData, {idAttribute: 'supplierDetailId'}));
                };
                self.datareceived2 = function (data) {
                    var arrData = data.ResultSet.Result;
                     billData2=arrData;
                    self.dataSource2(new oj.ArrayTableDataSource(arrData, {idAttribute: 'supplierId'}));
                };
                self.datareceived3 = function (data) {
                    var arrData = data.ResultSet.Result;
                     billData3=arrData;
                    self.dataSource3(new oj.ArrayTableDataSource(arrData, {idAttribute: 'receiveUnitManageId'}));
                };
                   self.datareceived4 = function (data) {
                    self.supplierTypeArr().push(data.ResultSet.userData);
                };
                //审批后执行的方法
                self.workCallback = function (data) {
                    if (data.ResultSet.status >= 0) {
                    } else {
                        alert(data.ResultSet.errors);
                    }
                };

                self.getValues = function () {
                     var userData = self.resultData;
                    userData[0].detailSupplierDetail = billData1;
                    userData[0].detailSupplierCooperation = billData2;
                    userData[0].detailSreceiveunitmanagemmror = billData3;
                    return userData[0];

                };

                //进度按钮
                self.jinduClick = function (data, event) {
                    self.processInstanceId = self.parentViewModel.rowData.processInstanceId;
                    dl.getGlobalModule({name: 'schedule', params: self});
                    dl.pushPageStack({name: 'operation_processor/SupplierComeIn/SupplierComeInApplyAttention', params: self.parentViewModel});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle("流程进度");
                };

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };
                self.handleAttached = function (info) {
                    var condition = {
                        supplierId: params.rowData.supplierId
                    };
                    dl.callOperation("NQ_SupplierComeIn", '', condition, self.datareceived);


                    dl.callOperation("ST_SupplierDetail", 'find', condition, self.datareceived1);


                    dl.callOperation("ST_SupplierCooperation", 'find', condition, self.datareceived2);

                    var condition3 = {
                        supplierId: params.rowData.supplierId,
                        addtionalCondition: "ORDER BY receive_unit_manage_id desc"
                    };
                    dl.callOperation("ST_ReceiveUnitManage", 'find', condition3, self.datareceived3);
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return SupplierComeInApplyAttentionViewModel;
        }
);


