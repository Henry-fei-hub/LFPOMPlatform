define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/msgbox', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl, sc) {
            function stayawayApplyViewViewModel(params) {
                var self = this;
                self.viewModelName = 'stayawayApplyViewViewModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                var userData = {};
                self.dataSource = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.resultData = ko.observable();
                self.isShow = ko.observable();
                self.processbillListData = null;
                self.specialHeaderTitle = ko.observable('');
                self.isApproval = ko.observable(true);
                self.__drafter = ko.observable();
                self.__employeeId = ko.observable();
                self.__employeeNo = ko.observable();
                self.__departmentId = ko.observable();
                self.__startDate = ko.observable();
                self.__startDateDetail = ko.observable();
                self.__endDate = ko.observable();
                self.__endDateDetail = ko.observable();
                self.__days = ko.observable();
                self.__projectTypeName = ko.observable();
                self.__projectCode = ko.observable();
                self.__projectName = ko.observable();
                self.__nextAuditor = ko.observable();
                self.__unit = ko.observable();
                self.__contactPerson = ko.observable();
                self.__address = ko.observable();
                self.__reason = ko.observable();
                self.__remark = ko.observable();

                self.datareceived = function (data) {
                    var arrData = dl.parseCollection(data);
                    console.log(arrData);
                    self.resultData = arrData;
                    if (self.resultData.length > 0) {
                        for (var i = 0; i < self.resultData.length; i++) {
                            //获取外出类型;1:项目外出;2:前期项目外出;3:非项目外出
                            var projectType = self.resultData[i]['projectType'];
                            if (Number(projectType) === 1) {
                                self.resultData[i]['projectTypeName'] = '项目外出';
                                self.isShow(1);
                            } else if (Number(projectType) === 2) {
                                self.resultData[i]['projectTypeName'] = '前期项目外出';
                                self.isShow(2);
                            } else if (Number(projectType) === 3) {
                                self.resultData[i]['projectTypeName'] = '非项目外出';
                                self.isShow(3);
                            }
                        }
                    }
                    self.dataSource(new oj.ArrayTableDataSource(self.resultData, {idAttribute: 'personnelBusinessId'}));
                    self.__drafter(arrData[0].drafter);
                    self.__employeeId(arrData[0].employeeId);
                    self.__employeeNo(arrData[0].employeeNo);
                    self.__departmentId(arrData[0].departmentId);
                    self.__startDate(arrData[0].startDate);
                    self.__startDateDetail(arrData[0].startDateDetail);
                    self.__endDate(arrData[0].endDate);
                    self.__endDateDetail(arrData[0].endDateDetail);
                    self.__days(arrData[0].days);
                    self.__projectTypeName(arrData[0].projectTypeName);
                    self.__projectCode(arrData[0].projectCode);
                    self.__projectName(arrData[0].projectName);
                    self.__nextAuditor(arrData[0].nextAuditor);
                    self.__unit(arrData[0].unit);
                    self.__contactPerson(arrData[0].contactPerson);
                    self.__address(arrData[0].address);
                    self.__reason(arrData[0].reason);
                    self.__remark(arrData[0].remark);
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
                    for (var name in self) {
                        if (name.indexOf("__") !== -1) {
                            if (self[name]() instanceof Array) {
                                userData[name.substring(2)] = self[name]()[0];
                                userData['personnelBusinessId'] = params.rowData.businessId;
                            } else {
                                userData[name.substring(2)] = self[name]();
                                userData['personnelBusinessId'] = params.rowData.businessId;
                            }
                        }
                    }
                    return userData;
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

                //进度按钮
                self.jinduClick = function (data, event) {
                    self.processInstanceId = self.parentViewModel.rowData.processInstanceId;
                    dl.getGlobalModule({name: 'schedule', params: self});
                    dl.pushPageStack({name: 'personnel/stayaway/stayawayApplyView', params: self.parentViewModel});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle("流程进度");
                };
                //处理节点执行的方法
                self.checkData = function (values) {
                    return true;
                };
                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    self.pageFlag = self.parentViewModel.rowData['pageFlag'];//pageFlag不为空且等于1时表示从我的申请点击进入此页面
                    if (!dl.isNullOrUndefined(self.pageFlag) && (self.pageFlag === 1 || self.pageFlag === 2)) {
                        self.isApproval(false);
                    } else {
                        self.isApproval(true);
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

            return stayawayApplyViewViewModel;
        }
);


