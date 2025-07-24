define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/msgbox', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl, sc) {
            function leaveApplyViewViewModel(params) {
                var self = this;
                self.viewModelName = 'leaveApplyViewViewModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                self.dataSource = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.resultData = ko.observable();
                self.processbillListData = null;
                self.specialHeaderTitle = ko.observable('');
                self.isApproval = ko.observable(true);
                self.isshow = ko.observable(false);
                self.isshowTargetProvince = ko.observable(false);
                self.isshowBaby = ko.observable(false);
                self.isshowUnit = ko.observable(false);
                self.isshowCertificationTime = ko.observable(false);
                self.onboardDate = ko.observable();

                self.datareceived = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.resultData = arrData;
                    if (!dl.isNullOrEmpty(arrData[0]['subTypeStr'])) {
                        self.isshow(true);
                    }
                    if (!dl.isNullOrEmpty(arrData[0]['targetProvince'])) {
                        self.isshowTargetProvince(true);
                    }
                    if (!dl.isNullOrEmpty(arrData[0]['numberOfBaby'])) {
                        self.isshowBaby(true);
                    }
                    if (!dl.isNullOrEmpty(arrData[0]['unit'])) {
                        self.isshowUnit(true);
                    }
                    if (!dl.isNullOrEmpty(arrData[0]['certificationTime'])) {
                        self.isshowCertificationTime(true);
                    }
                    self.dataSource(new oj.ArrayTableDataSource(arrData, {idAttribute: 'personnelBusinessId'}));
                    //  某人的报销页面的标题以报销人+主题 
                    self.specialHeaderTitle(dl.getLabelByValue('employees', arrData[0]['employeeId']) + dl.getLabelByValue('leave_types', arrData[0]['type']));
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

                self.getValues = function () {
                    //业务数据获取
                    var userData = self.resultData;
                    userData[0].detailProcessBillListApply = self.processbillListData;
                    return userData[0];
                };

                //提交审批
                self.submitClick = function (data, event) {
                    var inner = event.currentTarget.innerText;
                    sc.confirm("确定" + inner + "吗?", function () {
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

                    })
                };
                //处理节点执行的方法
                self.checkData = function (values) {
                    return true;
                };
                //进度按钮
                self.jinduClick = function (data, event) {
                    self.processInstanceId = self.parentViewModel.rowData.processInstanceId;
                    dl.getGlobalModule({name: 'schedule', params: self});
                    dl.pushPageStack({name: 'personnel/leave/leaveApplyView', params: self.parentViewModel});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle("流程进度");
                };

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    var pageFlag = self.parentViewModel.rowData['pageFlag'];//pageFlag不为空且等于1时表示从我的申请点击进入此页面
                    if (!dl.isNullOrUndefined(pageFlag) && (pageFlag === 1 || pageFlag === 2)) {
                        self.isApproval(false);
                    } else {
                        self.isApproval(true);
//                        pageFlag为空才显示  代审批 1已办
                    }
                          var condition = {
                        personnelBusinessId: params.rowData.businessId,
                        includeDetail: true
                    };
                    dl.callOperation("ST_PersonnelBusines", 'find', condition, self.datareceived);
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return leaveApplyViewViewModel;
        }
);


