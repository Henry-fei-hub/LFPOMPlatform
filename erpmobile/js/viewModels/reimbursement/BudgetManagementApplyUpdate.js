define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojdatetimepicker', 'ojs/ojtimezonedata', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function BudgetManagementApplyUpdateViewModel(params) {
                var self = this;
                self.viewModelName = 'BudgetManagementApplyUpdateViewModel';
                self.evtData = ko.observable();
                self.specialHeaderTitle = ko.observable('');
                self.isshow = ko.observable(false);
                self.__bdType = ko.observable();
                self.__bdTotalAmount = ko.observable(params.rowData.bdTotalAmount);
                self.__bdApplyTime = ko.observable(params.rowData.bdApplyTime);
                self.__bdEstimatecloseTime = ko.observable(params.rowData.bdEstimatecloseTime);
                self.__bdApplyEmployeeId = ko.observable(params.rowData.bdApplyEmployeeId);
                self.__departmentId = ko.observable(params.rowData.departmentId);
                self.__costBearing = ko.observable(params.rowData.costBearing);
                self.__companyId = ko.observable(params.rowData.companyId);
                self.__projectId = ko.observable(params.rowData.projectId);
                self.__bddType = ko.observable('');
                self.__signingMoneySum = ko.observable();
                self.__percent = ko.observable();
                self.__bdRemark = ko.observable(params.rowData.bdRemark);
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                self.dataSource1 = ko.observable();
                self.isApproval = ko.observable(true);
                var userData = {};
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.departmentData =ko.observableArray(dl.getOptionsByName('system_dictionary_1', true));  
                self.companyData=ko.observableArray(dl.getOptionsByName('system_dictionary_26', true));  
                self.bdTypeData =ko.observableArray(dl.getOptionsByName('system_dictionary_191', true));  
                self.costBearingArr= ko.observableArray([{'key':'部门承担','value':'部门承担'},{'key':'公司承担','value':'公司承担'},{'key':'项目承担','value':'项目承担'}]);
                self.bddTypeArr = ko.observableArray([]);
                self.projectArr = ko.observableArray([]);
                self.selectedItem = ko.observable("");
                self.bdTypeValue = ko.observable();
                 // 采买1 行政2 项目3
//                 改变数值就会执行
               self.valueChangedHandler = function (event) {
                self.evtData(event['detail']);
                self.bdTypeValue(self.evtData().value);
                 switch (Number(self.bdTypeValue())) {
                        case 1:
                            self.__bddType('质保金');
                            self.isshow(true);
                            break;
                        case 3:
                            self.isshow(true);
                            break;
                        default:
                            self.isshow(false);
                            break;
                    };
              };
//                   页面初始加载会执行
                self.__bdType.subscribe(function (val) {
                    switch (Number(val)) {
                        case 1:
                            self.__bddType('质保金');
                            self.isshow(true);
                            break;
                        case 3:
                            self.isshow(true);
                            break;
                        default:
                            self.isshow(false);
                            break;
                    }
                });
                
             
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
                    self.__signingMoneySum(arrData[0].signingMoneySum);
                    var a = self.__bdTotalAmount();
                    var b = self.__signingMoneySum();
                    var num = Number(a) / Number(b);
                    self.__percent(((num * 100).toFixed(2)).concat('%'));    

                    self.specialHeaderTitle(dl.getLabelByValue('employees', params.rowData.bdApplyEmployeeId) + dl.getLabelByValue('system_dictionary_191', params.rowData.bdType));
                };

                self.datareceived1 = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.resultData = arrData;
                    self.dataSource1(new oj.ArrayTableDataSource(arrData, {idAttribute: 'budgetManagementId'}));
                    self.__bddType(arrData[0]['bddType']);
                };
             
                //处理节点执行的方法
                self.checkData = function (values) {
                    return true;
                };

                self.getValues = function () {
                    //业务数据获取
                    for (var name in self) {
                        if (name.indexOf("__") !== -1) {
                            if (self[name]() instanceof Array) {
                                userData[name.substring(2)] = self[name]()[0];
                                userData['budgetManagementId'] = params.rowData.budgetManagementId;

                            } else {
                                userData[name.substring(2)] = self[name]();
                                userData['budgetManagementId'] = params.rowData.budgetManagementId;
                            }
                        }
                    }
                    return userData;
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
//                进度按钮
                self.jinduClick = function (data, event) {
                    self.processInstanceId = self.parentViewModel.rowData.processInstanceId;
                    dl.getGlobalModule({name: 'schedule', params: self});
                    dl.pushPageStack({name: 'reimbursement/BudgetManagementApplyUpdate', params: self.parentViewModel, cacheKey: 'reimbursement/BudgetManagementApplyUpdate'});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle("流程进度");
                };
                self.checkData = function (values) {
                    return true;
                }

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    self.__bdType(params.rowData.bdType);
                //                百分比变时
                  self.__percent.subscribe(function (val) {
                      if(val.indexOf('%')>0){
                           var percentNum = (val.substring(0,val.lastIndexOf('%')))/100;
                           self.__bdTotalAmount( self.__signingMoneySum()*percentNum);
                      }else{
                             self.__bdTotalAmount( self.__signingMoneySum()*(val/100));
                      }
                  });
                    self.pageFlag = self.parentViewModel.rowData['pageFlag'];//pageFlag不为空且等于1时表示从我的申请点击进入此页面
                    if (!dl.isNullOrUndefined(self.pageFlag) && (self.pageFlag === 1 || self.pageFlag === 2)) {
                        self.isApproval(false);
                    } else {
                        self.isApproval(true);
                    }
                    var condition = {
                        projectId: params.rowData.projectId
                    };

                    dl.callOperation("NQ_Mcontractppspcccfscsiiicpor", 'find', condition, self.datareceived);

                    var condition1 = {
                        budgetManagementId: params.rowData.budgetManagementId
                    };

                    dl.callOperation("ST_BudgetManagementDetail", 'find', condition1, self.datareceived1);
                      var conditionDetail = {
                        typeId:1
                    };

                    dl.callOperation('ST_BudgetDetailType', '', conditionDetail, function (response) {
                        if (Number(response['ResultSet']['status']) >= 0) {
                            var dataArr = dl.parseCollection(response);
                            for (var i = 0; i < dataArr.length; i++) {
                               var item={key: dataArr[i]['budgetDetailTypeKey'] ,value: dataArr[i]['budgetDetailTypeValue']};
                                self.bddTypeArr.push(item);
                            }
                        }
                    });
                     
                };

                self.handleBindingsApplied = function (info) {
                };
                self.handleDetached = function (info) {
                };
            }
            return BudgetManagementApplyUpdateViewModel;
        }
);


