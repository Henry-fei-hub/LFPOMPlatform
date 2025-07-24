define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function BorrowMoneyApplicationAttentionViewModel(params) {
                var self = this;
                self.viewModelName = 'BorrowMoneyApplicationAttentionViewModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                self.dataSource = ko.observable();
                self.dataSource3 = ko.observable();

                self.processString = function (ss) {
                    var s = "";
                    for (var i = 0; i < ss.length; i++) {
                        if (ss[i] === '+')
                            s += ' ';
                        else
                            s += ss[i];
                    }
                    return s;
                };

                self.resultData = null;
                self.processbillListData = null;
                self.specialHeaderTitle = ko.observable('');

                self.datareceived = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.resultData = arrData;
                    self.dataSource(new oj.ArrayTableDataSource(arrData, {idAttribute: 'employeeMoneyManageId'}));
                    //  某人的报销页面的标题以报销人+主题 
                    self.specialHeaderTitle(dl.getLabelByValue('employees', arrData[0]['employeeId']) + arrData[0]['borrowMoney']);
//                    进入即阅
                    dl.submitApprovalWork(0, params.rowData, self);
                };

                //处理节点执行的方法
                self.checkData = function (values) {
                    return true;
                };

                self.getValues = function () {
                    //业务数据获取
                     return [];
                };

                //审批后执行的方法
                self.workCallback = function (data) {
                    if (data.ResultSet.status >= 0) {
                    } else {
                        alert(data.ResultSet.errors);
                    }
                };

//                进度按钮
                self.jinduClick = function (data, event) {
                    self.processInstanceId = self.parentViewModel.rowData.processInstanceId;
                    dl.getGlobalModule({name: 'schedule', params: self});
                    dl.pushPageStack({name: 'reimbursement/BorrowMoneyApplicationAttention', params: self.parentViewModel, cacheKey: 'reimbursement/BorrowMoneyApplicationAttention'});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle("流程进度");
                };

                self.datareceivedBillList = function (data) {
                    //账单流水数据
                    var arrData = data.ResultSet.Result;
                    self.dataSource3(new oj.ArrayTableDataSource(arrData, {idAttribute: 'processBillListId'}));
                    self.processbillListData = arrData;
                };

                self.getDataTitle = function (data) {
                };
                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    var condition = {
                        employeeMoneyManageId: params.rowData.businessId
                    };

                    dl.callOperation("ST_EmployeeMoneyManage", 'find', condition, self.datareceived);

                    var condition1 = {
                        optType: "getBillListByBusinessidProcesstype",
                        processType: params.rowData.processType,
                        businessId: params.rowData.businessId
                    };
                    dl.callOperation("EP_CustomSprocessbilllistppporProcess", 'find', condition1, self.datareceivedBillList);
                };



                self.handleBindingsApplied = function (info) {

                    // Implement if needed
                };


                self.handleDetached = function (info) {
                    // Implement if needed
                };
            }

            return BorrowMoneyApplicationAttentionViewModel;
        }
);


