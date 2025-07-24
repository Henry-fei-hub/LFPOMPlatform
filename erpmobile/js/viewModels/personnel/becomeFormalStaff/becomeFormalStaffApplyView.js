define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient','dl/msgbox', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojbutton', 'ojs/ojcheckboxset', 'ojs/ojdatetimepicker','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl,sc) {
            function becomeFormalStaffApplyViewViewModel(params) {
                var self = this;
                self.viewModelName = 'becomeFormalStaffApplyViewViewModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                var userData = {};
                self.dataSource = ko.observable();
                self.errorMessage = ko.observable('');
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.resultData = ko.observable();
                self.processbillListData = null;
                self.specialHeaderTitle = ko.observable('');
                self.isApproval = ko.observable(true);               
                self.__employeeId = ko.observable();
                self.__companyId = ko.observable();
                self.__startDate = ko.observable();
                self.__departmentId = ko.observable();
                self.__type = ko.observable();
                self.__employeeNo = ko.observable();
                self.__endDate = ko.observable();
                self.__dutyId = ko.observable();
                self.__targetProvince = ko.observable();
                self.__fee = ko.observable();
                self.__originalPay = ko.observable();
                self.__totalPay = ko.observable();
                self.__monthPay = ko.observable();
                self.__foremanPay = ko.observable();
                self.__basicProportionStr =  ko.observable();
                self.__otherSubsidy =  ko.observable();
                self.__monthBasicPay = ko.observable();
                self.__annualPerformance = ko.observable();
                self.__monthPerformancePay = ko.observable();
                self.__costAttribution = ko.observable();
                self.__reason = ko.observable();
                self.__remark =  ko.observable();
                  
                    self.__basicProportionStr.subscribe(function (val) {
                        if(val.indexOf('%')>0){
                            var value= Number(val.slice(0,val.length-1));
                             var bili =Number(value)/100;
                        self.__monthBasicPay(Number(self.__monthPay())*Number(bili));
                        self.__monthPerformancePay(Number(self.__monthPay()) -Number(self.__monthBasicPay()));
                        }else{
                        var bili =Number(val)/100;
                        self.__monthBasicPay(Number(self.__monthPay())*Number(bili));
                        self.__monthPerformancePay(Number(self.__monthPay()) -Number(self.__monthBasicPay()));
                          }
                    });
//                    转正后基本工资变了 月薪要跟着变 这俩一样
                      self.__totalPay.subscribe(function (val) {
                           self.__monthPay(val);
                      });
                      self.__monthPay.subscribe(function (val) {
                           self.__totalPay(val);
                      })
                self.isshow = function(id){
                        if (!dl.isNullOrUndefined(params.rowData.backViewName)&&(params.rowData.backViewName).indexOf("转正员工") >= 0 ){
                                switch(id){
                                    case(13): return true;
                                          break;
                                    case(14): return true;
                                          break;
                                    default: return false;
                                  }
                        } else if(!dl.isNullOrUndefined(params.rowData.backViewName)&&(params.rowData.backViewName).indexOf("部门负责人") >= 0 ){
                                  switch(id){
                                    case(13): return true;
                                          break;
                                    case(14): return true;
                                          break;
                                    default: return false;
                                  }
                              
                        }else if(!dl.isNullOrUndefined(params.rowData.backViewName)&&(params.rowData.backViewName).indexOf("部门主管领导") >= 0 ){
                                  switch(id){
                                    case(1): return true;
                                          break;
                                    case(3): return true;
                                          break;
                                    case(4): return true;
                                          break;
                                     case(13): return true;
                                          break;
                                    case(14): return true;
                                          break;     
                                    default: return false;
                                  }
                        }else if(!dl.isNullOrUndefined(params.rowData.backViewName)&&(params.rowData.backViewName).indexOf("部门分管领导") >= 0 ){
                                  switch(id){
                                    case(1): return true;
                                          break;
                                    case(3): return true;
                                          break;
                                    case(4): return true;
                                           break;
                                     case(13): return true;
                                          break;
                                    case(14): return true;
                                           break;
                                    default: return false;
                                  }
                        }else if(!dl.isNullOrUndefined(params.rowData.backViewName)&&(params.rowData.backViewName).indexOf("人资部") >= 0 ){
                                  switch(id){
                                    case(1): return true;
                                          break;
                                    case(2): return true;
                                          break;
                                    case(3): return true;
                                          break;
                                    case(4): return true;
                                          break;
                                    case(13): return true;
                                          break;
                                    case(14): return true;
                                           break;
                                    default: return false;
                                  }
                        }else if(!dl.isNullOrUndefined(params.rowData.backViewName)&&(params.rowData.backViewName).indexOf("薪酬专员") >= 0 ){
                                  switch(id){
                                    case(1): return true;
                                          break;
                                    case(2): return true;
                                          break;
                                    case(3): return true;
                                          break;
                                    case(4): return true;
                                          break;
                                    case(5): return true;
                                          break;
                                    case(6): return true;
                                          break;
                                    case(7): return true;
                                          break;
                                    case(8): return true;
                                          break;
                                    case(9): return true;
                                          break;
                                    case(10): return true;
                                          break;
                                    case(11): return true;
                                          break;
                                    case(12): return true;
                                          break;
                                    case(13): return true;
                                          break;
                                    case(14): return true;
                                          break;
                                    default: return false;
                                  }
                            };
                         };
                          self.isenable = function(id){
                        if (!dl.isNullOrUndefined(params.rowData.backViewName)&&(params.rowData.backViewName).indexOf("转正员工") >= 0 ){
                                switch(id){
                                    case(-1): return false;
                                          break;
                                    case(0): return false;
                                          break;
                                    default: return true;
                                  }
                        } else if(!dl.isNullOrUndefined(params.rowData.backViewName)&&(params.rowData.backViewName).indexOf("部门负责人") >= 0 ){
                                  switch(id){
                                    case(-1): return false;
                                          break;
                                    case(0): return false;
                                          break;
                                    case(13): return false;
                                          break;
                                    case(14): return false;
                                          break;
                                    default: return true;
                                  }
                              
                        }else if(!dl.isNullOrUndefined(params.rowData.backViewName)&&(params.rowData.backViewName).indexOf("部门主管领导") >= 0 ){
                                  switch(id){
                                    case(-1): return false;
                                          break;
                                    case(0): return false;
                                          break;
                                    case(1): return false;
                                          break;
                                    case(2): return false;
                                          break;
                                    case(3): return false;
                                          break;
                                    case(13): return false;
                                          break;
                                    case(14): return false;
                                          break;     
                                    default: return true;
                                  }
                        }else if(!dl.isNullOrUndefined(params.rowData.backViewName)&&(params.rowData.backViewName).indexOf("部门分管领导") >= 0 ){
                                 return true;
                        }else if(!dl.isNullOrUndefined(params.rowData.backViewName)&&(params.rowData.backViewName).indexOf("人资部") >= 0 ){
                                  switch(id){
                                     case(-1): return false;
                                          break;
                                    case(0): return false;
                                          break;
                                    case(1): return false;
                                          break;
                                    case(2): return false;
                                          break;
                                    case(3): return false;
                                          break;
                                    case(4): return false;
                                          break;
                                    case(13): return false;
                                          break;
                                    case(14): return false;
                                          break; 
                                    default: return true;
                                  }
                        }else if(!dl.isNullOrUndefined(params.rowData.backViewName)&&(params.rowData.backViewName).indexOf("薪酬专员") >= 0 ){
                                  switch(id){
                                    case(3): return false;
                                          break;
                                    case(4): return false;
                                          break;
                                    case(6): return false;
                                          break;
                                    case(13): return false;
                                          break;
                                    case(14): return false;
                                          break;
                                    default: return true;
                                  }
                            };
                         };
                self.datareceived = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.resultData = arrData;
                    self.dataSource(new oj.ArrayTableDataSource(arrData, {idAttribute: 'personnelBusinessId'}));
                    self.specialHeaderTitle(dl.getLabelByValue('employees', arrData[0]['employeeId']) + dl.getLabelByValue('departments', arrData[0]['departmentId']));
                    self.__employeeId(arrData[0].employeeId);
                    self.__departmentId(arrData[0].departmentId);
                    self.__employeeNo(arrData[0].employeeNo);
                    self.__companyId(arrData[0].companyId);
                    self.__startDate(arrData[0].startDate);
                    self.__type(arrData[0].type);
                    self.__endDate(dl.parseValueFromService(arrData[0].endDate));
                    self.__dutyId(arrData[0].dutyId);
                    self.__targetProvince(arrData[0].targetProvince);
                    self.__fee(arrData[0].fee);
                    self.__originalPay(arrData[0].originalPay);
                    self.__totalPay(arrData[0].totalPay);
                    self.__monthPay(arrData[0].totalPay);
                    self.__foremanPay(arrData[0].foremanPay);
                    self.__otherSubsidy(arrData[0].otherSubsidy);
                    self.__costAttribution(arrData[0].costAttribution);
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

                             //self 当前整个模块
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
                //处理节点执行的方法
                self.checkData = function (values) {
                      if (!dl.isNullOrUndefined(params.rowData.backViewName)&&(params.rowData.backViewName).indexOf("转正员工") >= 0 ){
                           if (dl.isNullOrEmpty(values.reason)) {
                                self.errorMessage('♥提示:自我鉴定不可为空');
                                return false;
                            }
                           if (dl.isNullOrEmpty(values.remark)) {
                                self.errorMessage('♥提示:试用期工作总结不可为空');
                                return false;
                            }
                      }else if (!dl.isNullOrUndefined(params.rowData.backViewName)&&(params.rowData.backViewName).indexOf("部门分管领导") >= 0 ){
                           if (dl.isNullOrEmpty(values.totalPay)|| !(Number(values.totalPay)>0)) {
                                self.errorMessage('♥提示:请填写转正工资');
                                return false;
                            }
                      }else if(!dl.isNullOrUndefined(params.rowData.backViewName)&&(params.rowData.backViewName).indexOf("薪酬专员") >= 0 ){
                          if (dl.isNullOrEmpty(values.monthBasicPay)|| !(Number(values.monthBasicPay)>0)) {
                                self.errorMessage('♥提示:请填写并正确填写转正后的工资详细信息');
                                return false;
                            }
                      }
                   
                    return true;
                };
                //进度按钮
                self.jinduClick = function (data, event) {
                    self.processInstanceId = self.parentViewModel.rowData.processInstanceId;
                    dl.getGlobalModule({name: 'schedule', params: self});
                    dl.pushPageStack({name: 'personnel/becomeFormalStaff/becomeFormalStaffApplyView', params: self.parentViewModel});
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
                    }
                    var condition = {
                        personnelBusinessId: params.rowData.businessId,
                        includeDetail: true
                    };
                    dl.callOperation("NQ_DecryptPersonnelBusiness", 'find', condition, self.datareceived);
                    
                 
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return becomeFormalStaffApplyViewViewModel;
        }
);


