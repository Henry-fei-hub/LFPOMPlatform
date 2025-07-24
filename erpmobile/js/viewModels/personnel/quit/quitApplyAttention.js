define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function quitApplyAttentionViewModel(params) {
                var self = this;
                self.viewModelName = 'quitApplyAttentionViewModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                self.dataSource = ko.observable();
                self.selectedItem = ko.observable("");
                self.resultData = ko.observable();
                self.processbillListData = null;
                self.specialHeaderTitle = ko.observable('');
                self.subTypeArr = ko.observableArray();

                self.isShow = function (id) {
                    if (!dl.isNullOrUndefined(params.rowData.backViewName) && (params.rowData.backViewName).indexOf("运营管理员") >= 0 || !dl.isNullOrUndefined(params.rowData.backViewName) && (params.rowData.backViewName).indexOf("部门助理") >= 0
                            || !dl.isNullOrUndefined(params.rowData.backViewName) && (params.rowData.backViewName).indexOf("招聘专员") >= 0 || !dl.isNullOrUndefined(params.rowData.backViewName) && (params.rowData.backViewName).indexOf("运维工程师") >= 0) {
                        //  processName_3   ok 
                        switch (id) {
                            case(1):
                            case(2):
                            case(3):
                            case(4):
                            case(5):
                            case(6):
                            case(7):
                            case(8):
                                return false;
                                break;
                            default:
                                return true;
                        }

                    } else if (!dl.isNullOrUndefined(params.rowData.backViewName) && (params.rowData.backViewName).indexOf("薪酬专员") >= 0|| !dl.isNullOrUndefined(params.rowData.backViewName) && (params.rowData.backViewName).indexOf("人事专员") >= 0) {
                        //  processName_10                ok
                        return true;
                    } else if (!dl.isNullOrUndefined(params.rowData.backViewName) && (params.rowData.backViewName).indexOf("运营中心分管领导") >= 0 || !dl.isNullOrUndefined(params.rowData.backViewName) && (params.rowData.backViewName).indexOf("运营专员") >= 0
                            ||!dl.isNullOrUndefined(params.rowData.backViewName) && (params.rowData.backViewName).indexOf("资源经理") >= 0||!dl.isNullOrUndefined(params.rowData.backViewName) && (params.rowData.backViewName).indexOf("部门分管领导") >= 0
                            ||!dl.isNullOrUndefined(params.rowData.backViewName) && (params.rowData.backViewName).indexOf("人资总监") >= 0||!dl.isNullOrUndefined(params.rowData.backViewName) && (params.rowData.backViewName).indexOf("部门负责人") >= 0
                            ||!dl.isNullOrUndefined(params.rowData.backViewName) && (params.rowData.backViewName).indexOf("部门行政负责人") >= 0) {
                        //  processName_10                ok
                           switch (id) {
                            case(4):
                                return true;
                                break;
                            default:
                                return false;
                        }
                    } else {
//                        行政文员
                        return false;
                    }
                };

                self.datareceived = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.resultData = arrData;
                    var subType = arrData[0].subType;
                    var subTypeIdArr = subType.split(',');
                    for (var i = 0; i < subTypeIdArr.length; i++) {
                        self.subTypeArr.push(dl.getLabelByValue('system_dictionary_102', subTypeIdArr[i]));
                    }
                    ;
                    self.dataSource(new oj.ArrayTableDataSource(arrData, {idAttribute: 'personnelBusinessId'}));
                    // 标题以报销人+离职原因 
                    self.specialHeaderTitle(dl.getLabelByValue('employees', arrData[0]['employeeId']) + dl.getLabelByValue('system_dictionary_101', arrData[0]['startDateDetail']));

//                    进入即阅
                    dl.submitApprovalWork(0, params.rowData, self);
                };

                //审批后执行的方法
                self.workCallback = function (data) {
                    if (data.ResultSet.status >= 0) {
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

                //进度按钮
                self.jinduClick = function (data, event) {
                    self.processInstanceId = self.parentViewModel.rowData.processInstanceId;
                    dl.getGlobalModule({name: 'schedule', params: self});
                    dl.pushPageStack({name: 'personnel/quit/quitApplyAttention', params: self.parentViewModel, cacheKey: 'personnel/quit/quitApplyAttention'});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle("流程进度");
                };

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
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

            return quitApplyAttentionViewModel;
        }
);


