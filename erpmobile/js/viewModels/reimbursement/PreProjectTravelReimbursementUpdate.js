define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function PreProjectTravelReimbursementUpdateViewModel(params) {
                var self = this;
                self.viewModelName = 'PreProjectTravelReimbursementUpdateViewModel';
                self.parentViewModel = params;
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
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
                //主数据清单
                self.resultData = ko.observableArray();
                //费用明细
                self.detailTravelReimbursementDetail = ko.observableArray();
                //部门分摊费用
                self.detailTravelReimbursementLinkMainProject = ko.observableArray();
                //账单流水
                self.processbillListData = ko.observableArray();

                self.specialHeaderTitle = ko.observable('');
                self.dataSource(new oj.ArrayTableDataSource(self.resultData, {idAttribute: 'travelReimbursementId'}));
                //费用明细清单
                self.dataSource1(new oj.ArrayTableDataSource(self.detailTravelReimbursementDetail, {idAttribute: 'travelReimbursementDetailId'}));
                //部门分摊费用
                self.dataSource2(new oj.ArrayTableDataSource(self.detailTravelReimbursementLinkMainProject, {idAttribute: 'travelReimbursementLinkMainProjectId'}));

                self.dataSource3(new oj.ArrayTableDataSource(self.processbillListData, {idAttribute: 'processBillListId'}));

                self.datareceived = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.resultData(arrData);
                    self.detailTravelReimbursementDetail(arrData[0].detailTravelReimbursementDetail);
                    self.detailTravelReimbursementLinkMainProject(arrData[0].detailTravelReimbursementLinkMainProject);

                    for (var i = 0; i < self.detailTravelReimbursementLinkMainProject.length; i++) {
                        detailTravelReimbursementLinkMainProject[i].projectId = [detailTravelReimbursementLinkMainProject[i].projectId.toString()];
                    }
                    //  某人的报销页面的标题以报销人+主题 
                    self.specialHeaderTitle(dl.getLabelByValue('employees', arrData[0]['applicant']) + arrData[0]['title']);
                };

                //处理节点执行的方法
                self.checkData = function (values) {
                    return true;
                };

                self.getValues = function () {
                    //业务数据获取  同意时获取数据返回后台
                    var resultData = [];
                    for (var i = 0; i < self.resultData().length; i++) {
                        resultData.push(dl.processInlineData(self.resultData()[i]));
                    }

                    var detailTravelReimbursementDetail = [];
                    for (var i = 0; i < self.detailTravelReimbursementDetail().length; i++) {
                        detailTravelReimbursementDetail.push(dl.processInlineData(self.detailTravelReimbursementDetail()[i]));
                    }

                    var detailTravelReimbursementLinkMainProject = [];
                    for (var i = 0; i < self.detailTravelReimbursementLinkMainProject().length; i++) {
                        detailTravelReimbursementLinkMainProject.push(dl.processInlineData(self.detailTravelReimbursementLinkMainProject()[i]));
                    }

                    var processbillListData = [];
                    for (var i = 0; i < self.processbillListData().length; i++) {
                        processbillListData.push(dl.processInlineData(self.processbillListData()[i]));
                    }
                    resultData[0].detailTravelReimbursementDetail = detailTravelReimbursementDetail;
                    resultData[0].detailTravelReimbursementLinkMainProject = detailTravelReimbursementLinkMainProject;
                    resultData[0].detailProcessBillListApply = processbillListData;
                    return resultData[0];
                };

                //                进度按钮
                self.jinduClick = function (data, event) {
                    self.processInstanceId = self.parentViewModel.rowData.processInstanceId;
                    dl.getGlobalModule({name: 'schedule', params: self});
                    dl.pushPageStack({name: 'reimbursement/PreProjectTravelReimbursementUpdate', params: self.parentViewModel, cacheKey: 'reimbursement/PreProjectTravelReimbursementUpdate'});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle("流程进度");
                };

                //审批后执行的方法
                self.workCallback = function (data) {

                    if (data.ResultSet.status >= 0) {
                        var returnData = dl.parseCollection(data);
                        self.processInstanceId = returnData[0].processInstanceId;
                        dl.getGlobalModule({name: 'schedule', params: self});
                        dl.headerTitle("流程进度");
                    } else {
                        alert(data.ResultSet.errors);
                    }
                };

                // 同意   提交审批
                self.submitClick = function (data, event) {
                    var target = event.currentTarget;
                    var approvalment = target.id;
                    var val = self.additionalApprovalment();
                    var additionalApprovalment;
                    if (!dl.isNullOrUndefined(val)) {
                        if (val instanceof Array) {
                            if (val.length > 0)
                                additionalApprovalment = val[0];
                        } else
                            additionalApprovalment = val;
                    }
                    var processComment = self.processComment();
                    dl.submitApprovalWork(approvalment, params.rowData, self, processComment, additionalApprovalment);
                };

                self.datareceivedBillList = function (data) {
                    //账单流水数据
                    self.processbillListData(dl.parseCollection(data));
                };


                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                    // Implement if needed
                };


                var condition = {
                    travelReimbursementId: params.rowData.businessId,
                    includeDetail: true
                };

                dl.callOperation("NQ_PreProjectTravelReimbursement", 'find', condition, self.datareceived);

                var condition1 = {
                    opt_type: "getBillListByBusinessidProcesstype",
                    processType: params.rowData.processType,
                    businessId: params.rowData.businessId
                };
                dl.callOperation("EP_CustomSprocessbilllistppporProcess", 'find', condition1, self.datareceivedBillList);

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return PreProjectTravelReimbursementUpdateViewModel;
        }
);


