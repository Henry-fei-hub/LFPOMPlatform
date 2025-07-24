define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function CommonNormalReimbursementAttentionViewModel(params) {
                var self = this;
                self.viewModelName = 'CommonNormalReimbursementAttentionViewModel';
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
                   var arr = [];
                    var arrData = dl.parseCollection(data);
                    arr.push(arrData[0].userData);
                    self.resultData = arr;
                    self.dataSource(new oj.ArrayTableDataSource(arr, {idAttribute: 'projectNormalReimbursementId'}));
                    //费用明细清单
                    self.dataSource1(new oj.ArrayTableDataSource(arrData[0].userData.detailProjectNormalReimbursementDetail, {idAttribute: 'projectNormalReimbursementDetailId'}));
                    //部门分摊费用
                    self.dataSource2(new oj.ArrayTableDataSource(arrData[0].userData.detailNormalReimbursementLinkDepartment, {idAttribute: 'normalReimbursementLinkDepartmentId'}));
                    //  某人的报销页面的标题以报销人+主题 
                    self.specialHeaderTitle(dl.getLabelByValue('employees', arrData[0].userData['applyEmployeeId']) + arrData[0].userData['reimbursementName']);
//                    进入即阅
                    dl.submitApprovalWork(0, params.rowData, self);     
                };

                //处理节点执行的方法
                self.checkData = function (values) {
                    return true;
                };
                //业务数据获取  获取页面的数据
                self.getValues = function () {
                    return [];
                };

                //已阅后执行的方法  回调函数
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
                    dl.pushPageStack({name: 'reimbursement/CommonNormalReimbursementAttention', params: self.parentViewModel, cacheKey: 'reimbursement/CommonNormalReimbursementAttention'});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle("流程进度");
                };

                self.datareceivedBillList = function (data) {
                    //账单流水数据
                    var arrData = data.ResultSet.Result;
                    self.dataSource3(new oj.ArrayTableDataSource(arrData), {idAttribute: 'processBillListId'});
                    self.processbillListData = arrData;
                };


                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {

                };
                self.handleAttached = function (info) {
//                    var condition = {
//                        projectNormalReimbursementId: params.rowData.businessId,
//                        includeDetail: true
//                    };
//                    dl.callOperation("NQ_NormalReimbursementWithDepartment", 'find', condition, self.datareceived);
                      var condition = {
                        processInstanceId: params.rowData.processInstanceId,
                        includeDetail: true
                    };
                    dl.callOperation("EP_GetProcessInstance", 'find', condition, self.datareceived);
                    var condition1 = {
                        opt_type: "getBillListByBusinessidProcesstype",
                        processType: params.rowData.processType,
                        businessId: params.rowData.businessId
                    };
                    dl.callOperation("EP_CustomSprocessbilllistppporProcess", 'find', condition1, self.datareceivedBillList);
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return CommonNormalReimbursementAttentionViewModel;
        }
);


