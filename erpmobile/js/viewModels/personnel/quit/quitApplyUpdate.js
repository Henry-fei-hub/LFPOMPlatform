define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function quitApplyViewViewModel(params) {
                var self = this;
                self.viewModelName = 'quitApplyViewViewModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                self.errorMessage = ko.observable();
                self.tixinMessage = ko.observable();
                self.dataSource = ko.observable();
                self.selectedItem = ko.observable("");
                self.resultData = ko.observable();
                self.processbillListData = null;
                self.specialHeaderTitle = ko.observable('');
                self.isApproval = ko.observable(true);
                self.__employeeId = ko.observable();
                self.__companyId = ko.observable();
                self.__departmentId = ko.observable();
                self.__type = ko.observable();
                self.__employeeNo = ko.observable();
                self.__targetProvince = ko.observable();
                self.__drafter = ko.observable();
                self.__originalPay = ko.observable();
                self.__totalPay = ko.observable();               
                self.__monthPay = ko.observable();                
                self.__foremanPay = ko.observable();
                self.__startDate =  ko.observable();
                self.__endDate =  ko.observable();
                self.__card = ko.observable();
                self.__dutyId = ko.observable();
                self.__startDateDetail = ko.observable();
                self.__createTime = ko.observable();
                self.__livingExpenses = ko.observable();
                self.__housingFinance = ko.observable();
                self.__fee = ko.observable();
                var userData={};
                var processName = (self.parentViewModel.rowData.backViewName).toString();
                     self.isshow = function(id){
                        if (!dl.isNullOrUndefined(processName)&&processName.indexOf("部门经理") >= 0 ){
                                switch(id){
                                    case(1): return true;
                                          break;
                                    default: return false;
                                  }
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("运营中心分管领导") >= 0 ){  
                                //  processName_1
                                  switch(id){
                                    case(2): return true;
                                          break;
                                    case(3): return true;
                                          break;
                                    case(4): return true;
                                          break;
                                    default: return false;
                                  }
                              
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("运营专员") >= 0 ){  
                                  switch(id){
                                    case(2): return true;
                                          break;
                                    case(3): return true;
                                          break;
                                    case(4): return true;
                                          break;
                                    default: return false;
                                  }
                              
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("招聘专员") >= 0 ){
                             //  processName_2
                                  switch(id){
                                    case(13): return true;
                                          break;
                                    case(3): return true;
                                          break;
                                    case(4): return true;
                                          break;
                                    case(14): return true;
                                          break;
                                    default: return false;
                                  }
                              
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("运营管理员") >= 0 ){
                            //  processName_3
                                  switch(id){
                                    case(13): return true;
                                          break;
                                    case(14): return true;
                                          break;
                                    default: return false;
                                  }
                              
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("部门分管领导") >= 0 ){
                            //  processName_4
                                  switch(id){
                                    case(2): return true;
                                          break;
                                    case(3): return true;
                                          break;
                                    case(4): return true;
                                          break;
                                    default: return false;
                                  }
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("人资总监") >= 0 ){
                             //  processName_5
                                  switch(id){
                                    case(2): return true;
                                          break;
                                    default: return false;
                                  }
                              
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("部门负责人") >= 0 ){
                            //  processName_6
                                  switch(id){
                                    case(2): return true;
                                          break;
                                    case(3): return true;
                                          break;
                                    case(4): return true;
                                          break;
                                    default: return false;
                                  }
                              
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("人事专员") >= 0 ){
                            //  processName_7
                                  switch(id){
                                    case(13): return true;
                                          break;
                                    default: return false;
                                  }
                              
                        } else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("运营专员") >= 0 ){
                            //  processName_8
                                  switch(id){
                                    case(8): return true;
                                          break;
                                    default: return false;
                                  }
                              
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("资源经理") >= 0 ){
                            //  processName_9
                                  switch(id){
                                    case(2): return true;
                                          break;
                                    case(3): return true;
                                          break;
                                    case(4): return true;
                                          break;   
                                    default: return false;
                                  }
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("部门行政负责人") >= 0 ){
                             //  processName_11
                                  switch(id){
                                    case(1): return true;
                                          break;
                                    default: return false;
                                  }
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("薪酬专员") >= 0 ){
                             //  processName_10
                                  switch(id){
                                    case(1): return true;
                                          break;
                                    default: return false;
                                  }
                            };
                         };
                      self.tixinMessage = function(){
                       if(!dl.isNullOrUndefined(processName)&&processName.indexOf("运营专员") >= 0 ){
//                            1
                                 return '♥ 温馨提示：请填写离职员工的最终账户积分、冻结积分和离职奖金';
                              
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("人事专员") >= 0 ){
//                            2  unit  请填写社保/公积金停缴月份  severance   请填写离职补偿金  isRemoteCity   请收回员工的工卡，并勾选上“工牌是否已回收”一项
                                return '';
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("部门助理") >= 0 ){
//                            3  transportation   请填写离职考勤信息
                                return '';
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("FC经理") >= 0 ){
//                            5  borrowMoneyStatus  该员工还有借款，不能通过审批  contactPerson  请填写上该员工的借款情况  
                                 return '';
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("行政经理") >= 0 ){
//                            6  companyProvince 请填写收回的拖柜钥匙数量  numberOfBaby   请填写收回的储物柜钥匙数量
                                 return '';
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("运维工程师") >= 0 ){
//                            7  equivalentNumber 请填写收回的办公电脑等设备信息
                                return '';
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("部门经理") >= 0 ){
//                            8  targetProvince   请填写该员工的当月绩效
                                return '♥ 温馨提示：请填写该员工的当月绩效并附上审核意见';
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("资源经理") >= 0 ){
//                            9   needToChangeProjectManage   该离职员工是积分管理员，请及时将其管理的订单更换积分管理员，再通过审批！  integralStatus   该员工的实时积分余额小于0，不能通过审批 livingExpenses  请填写上该员工的最终账户积分
//                          fee  请填写上该员工的离职奖金  housingFinance  请填写上该员工的冻结积分   frozenIntegral.compareTo(BigDecimal.ZERO) < 0  该员工的冻结积分为负数，不能通过审批  
                                return '';
//                                该员工的实时积分余额小于0，不能通过审批
                        };
                         };
                        self.errorShow = function(id){
                            if(!dl.isNullOrUndefined(processName)&&processName.indexOf("运营专员") >= 0 ){
//                            1
                                 return '♥ 温馨提示：请填写离职员工的最终账户积分、冻结积分和离职奖金';
                              
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("人事专员") >= 0 ){
//                            2
                                return '';
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("部门助理") >= 0 ){
//                            3
                                return '';
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("FC经理") >= 0 ){
//                            5
                                 return '';
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("行政经理") >= 0 ){
//                            6
                                 return '';
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("运维工程师") >= 0 ){
//                            7
                                return '';
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("部门经理") >= 0 ){
//                            8
                                return '♥ 温馨提示：请填写该员工的当月绩效并附上审核意见';
                        }else if(!dl.isNullOrUndefined(processName)&&processName.indexOf("资源经理") >= 0 ){
//                            9
                                return '该离职员工是积分管理员，请及时将其管理的订单更换积分管理员，再通过审批！';
//                                该员工的实时积分余额小于0，不能通过审批
                        };
                        };
                self.datareceived = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.resultData = arrData;
                    self.dataSource(new oj.ArrayTableDataSource(arrData, {idAttribute: 'personnelBusinessId'}));
                    // 标题以报销人+离职原因 
                    self.specialHeaderTitle(dl.getLabelByValue('employees', arrData[0]['employeeId']) + dl.getLabelByValue('system_dictionary_101', arrData[0]['startDateDetail']));
                    self.__drafter(arrData[0].drafter);
                    self.__companyId(arrData[0].companyId);
                    self.__type(arrData[0].type);
                    self.__departmentId(arrData[0].departmentId);
                    self.__employeeNo(arrData[0].employeeNo);
                    self.__employeeId(arrData[0].employeeId);
                    self.__startDate(arrData[0].startDate);
                    self.__endDate(dl.parseValueFromService(arrData[0].endDate));
                    self.__card(arrData[0].card);
                    self.__dutyId(arrData[0].dutyId);
                    self.__startDateDetail(arrData[0].startDateDetail);
                    self.__createTime(arrData[0].createTime);
                    self.__livingExpenses(arrData[0].livingExpenses);
                    self.__housingFinance(arrData[0].housingFinance);
                    self.__fee(arrData[0].fee);
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
                //处理节点执行的方法
                self.checkData = function (values) {
                      if (!dl.isNullOrUndefined(processName)&&processName.indexOf("部门经理") >= 0 ){
                           if (dl.isNullOrEmpty(values.targetProvince)) {
                                self.errorMessage('♥提示:请填写该员工的当月绩效');
                                return false;
                            }else if (dl.isNullOrEmpty(values.processComment)){
                                 self.errorMessage('♥提示:请填写审核意见');
                                return false;
                            }
                      }else{
                         
                      }
                    return true;
                };
                //进度按钮
                self.jinduClick = function (data, event) {
                    self.processInstanceId = self.parentViewModel.rowData.processInstanceId;
                    dl.getGlobalModule({name: 'schedule', params: self});
                    dl.pushPageStack({name: 'personnel/quit/quitApplyView', params: self.parentViewModel, cacheKey: 'personnel/quit/quitApplyView'});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle("流程进度");
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

            return quitApplyViewViewModel;
        }
);



