define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function CommonTravelReimbursementAttentionViewModel(params) {
                var self = this;
                self.viewModelName = 'CommonTravelReimbursementAttentionViewModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                self.dataSourcect = ko.observable();
                self.dataSourcect1 = ko.observable();
                self.dataSourcect2 = ko.observable();
                self.dataSourcect3 = ko.observable();

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
                    self.dataSourcect(new oj.ArrayTableDataSource(arrData, {idAttribute: 'travelReimbursementId'}));
                    //差旅报销费用清单
                    self.dataSourcect1(new oj.ArrayTableDataSource(arrData[0].detailTravelReimbursementDetail, {idAttribute: 'travelReimbursementDetailId'}));
                    //费用分拆
                    self.dataSourcect2(new oj.ArrayTableDataSource(arrData[0].detailTravelReimbursementLinkDepartment, {idAttribute: 'travelReimbursementLinkDepartmentId'}));
                    //  某人的报销页面的标题以报销人+主题 
                    self.specialHeaderTitle(dl.getLabelByValue('employees', arrData[0]['applicant']) + arrData[0]['title']);
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
                    dl.pushPageStack({name: 'reimbursement/CommonTravelReimbursementAttention', params: self.parentViewModel, cacheKey: 'reimbursement/CommonTravelReimbursementAttention'});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle("流程进度");
                };

                self.datareceivedBillList = function (data) {
                    //账单流水数据
                    var arrData = data.ResultSet.Result;
                    self.dataSourcect3(new oj.ArrayTableDataSource(arrData, {idAttribute: 'processBillListId'}));
                    self.processbillListData = arrData;
                };
                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };
                self.handleAttached = function (info) {
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

            return CommonTravelReimbursementAttentionViewModel;
        }
);


