define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/msgbox', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl, sc) {
            function entryApplyViewViewModel(params) {
                var self = this;
                self.viewModelName = 'entryAApplyViewViewModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                var userData = {};
                self.dataSource = ko.observable();
                self.dataSource1 = ko.observable();
                self.dataSource2 = ko.observable();
                self.dataSource3 = ko.observable();
                self.dataSource4 = ko.observable();
                self.dataSource5 = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.resultData = ko.observable();
                self.processbillListData = null;
                self.specialHeaderTitle = ko.observable('');
                self.isApproval = ko.observable(true);
//                判断是否可以修改  3即可修改
                self.updateKey = ko.observable(params.rowData.activityType);
                self.isshow = ko.observable();
                self.__employeeId = ko.observable();
                self.__employeeNo = ko.observable();
                self.__employeeName = ko.observable();
                self.__employeeNameEn = ko.observable();
                self.__fileNumber = ko.observable();
                self.__card = ko.observable();
                self.__birth = ko.observable();
                self.__age = ko.observable();
                self.__gender = ko.observable();
                self.__phone = ko.observable();
                self.__companyEmail = ko.observable();
                self.__homePhone = ko.observable();
                self.__country = ko.observable();
                self.__birthplace = ko.observable();
                self.__accountLocation = ko.observable();
                self.__householdRegistration = ko.observable();
                self.__nationality = ko.observable();
                self.__health = ko.observable();
                self.__politicalFace = ko.observable();
                self.__education = ko.observable();
                self.__degree = ko.observable();
                self.__languages = ko.observable();
                self.__positiveDate = ko.observable();
                self.__workYearType = ko.observable();
                self.__plateId = ko.observable();
                self.__jobs = ko.observable();
                self.__isCheck = ko.observable();
                self.__socialComputerNumber = ko.observable();
                self.__fundAccount = ko.observable();
                self.__bankCardNum = ko.observable();
                self.__employeeShift = ko.observable();
                self.__selfIntroduction = ko.observable();
                self.__personalBusinessRemark = ko.observable();
                self.__marriedStatus = ko.observable();
                self.__startWorkDate = ko.observable();
                self.__onboardDate = ko.observable();
                self.__tryTime = ko.observable();
                self.__workAddress = ko.observable();
                self.__onboardStatus = ko.observable();
                self.__contractStartDate = ko.observable();
                self.__contractEndDate = ko.observable();
                self.__ownedCompany = ko.observable();
                self.__departmentId = ko.observable();
                self.__dutyId = ko.observable();
                self.__gradeId = ko.observable();
                self.__mobile = ko.observable();
                self.__tryTimePay = ko.observable();
                self.__positivePay = ko.observable();
                self.__annualPerformance = ko.observable();
                self.__annualBonus = ko.observable();
                self.__roleId = ko.observable();
                self.__costAttribution = ko.observable();

                self.datareceived = function (data) {
                    var arrData = dl.parseCollection(data);
                    if (dl.getEmployeeId() == 109) {
                        //只有陈彩可以改
                        self.isshow(true);
                    } else {
                        self.isshow(false);
                    }
                    self.resultData = arrData;
                    self.dataSource(new oj.ArrayTableDataSource(self.resultData, {idAttribute: 'personnelBusinessId'}));
                    //  某人的报销页面的标题以报销人+主题 
                    self.specialHeaderTitle(dl.getLabelByValue('employees', arrData[0]['employeeId']) + dl.getLabelByValue('departments', arrData[0]['departmentId']));


                    self.__age(arrData[0]['age']);
                    self.__gender(arrData[0]['gender']);
                    self.__phone(arrData[0]['phone']);
                    self.__companyEmail(arrData[0]['companyEmail']);
                    self.__homePhone(arrData[0]['homePhone']);
                    self.__country(arrData[0]['country']);
                    self.__birthplace(arrData[0]['birthplace']);
                    self.__accountLocation(arrData[0]['accountLocation']);
                    self.__householdRegistration(arrData[0]['householdRegistration']);
                    self.__nationality(arrData[0]['nationality']);
                    self.__health(arrData[0]['health']);
                    self.__politicalFace(arrData[0]['politicalFace']);
                    self.__education(arrData[0]['education']);
                    self.__degree(arrData[0]['degree']);
                    self.__languages(arrData[0]['languages']);
                    self.__positiveDate(arrData[0]['positiveDate']);
                    self.__workYearType(arrData[0]['workYearType']);
                    self.__plateId(arrData[0]['plateId']);
                    self.__jobs(arrData[0]['jobs']);
                    self.__isCheck(arrData[0]['isCheck']);
                    self.__socialComputerNumber(arrData[0]['socialComputerNumber']);
                    self.__fundAccount(arrData[0]['fundAccount']);
                    self.__bankCardNum(arrData[0]['bankCardNum']);
                    self.__employeeShift(arrData[0]['employeeShift']);
                    self.__selfIntroduction(arrData[0]['selfIntroduction']);
                    self.__personalBusinessRemark = ko.observable();
                    self.__employeeId(arrData[0]['employeeId']);
                    self.__employeeNo(arrData[0]['employeeNo']);
                    self.__employeeName(arrData[0]['employeeName']);
                    self.__employeeNameEn(arrData[0]['employeeNameEn']);
                    self.__fileNumber(arrData[0]['fileNumber']);
                    self.__card(arrData[0]['card']);
                    self.__birth(arrData[0]['birth']);
                    self.__marriedStatus(arrData[0]['marriedStatus']);
                    self.__startWorkDate(arrData[0]['startWorkDate']);
                    self.__onboardDate(arrData[0]['onboardDate']);
                    self.__tryTime(arrData[0]['tryTime']);
                    self.__workAddress(arrData[0]['workAddress']);
                    self.__onboardStatus(arrData[0]['onboardStatus']);
                    self.__contractStartDate(arrData[0]['contractStartDate']);
                    self.__contractEndDate(arrData[0]['contractEndDate']);
                    self.__ownedCompany(arrData[0]['ownedCompany']);
                    self.__departmentId(arrData[0]['departmentId']);
                    self.__dutyId(arrData[0]['dutyId']);
                    self.__gradeId(arrData[0]['gradeId']);
                    self.__mobile(arrData[0]['mobile']);
                    self.__tryTimePay(arrData[0]['tryTimePay']);
                    self.__positivePay(arrData[0]['positivePay']);
                    self.__annualPerformance(arrData[0]['annualPerformance']);
                    self.__annualBonus(arrData[0]['annualBonus']);
                    self.__roleId(arrData[0]['roleId']);
                    self.__costAttribution(arrData[0]['costAttribution']);
                };

                self.datareceived1 = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.dataSource1(new oj.ArrayTableDataSource(arrData, {idAttribute: 'employeeId'}));
                }
                self.datareceived2 = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.dataSource2(new oj.ArrayTableDataSource(arrData, {idAttribute: 'employeeId'}));
                }
                self.datareceived3 = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.dataSource3(new oj.ArrayTableDataSource(arrData, {idAttribute: 'employeeId'}));
                }
                self.datareceived4 = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.dataSource4(new oj.ArrayTableDataSource(arrData, {idAttribute: 'employeeId'}));
                }
                self.datareceived5 = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.dataSource5(new oj.ArrayTableDataSource(arrData, {idAttribute: 'employeeId'}));
                }

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
                                userData['personnelBusinessId'] = params.rowData.businessId;
                            } else {
                                userData[name.substring(2)] = self[name]();
                                userData['personnelBusinessId'] = params.rowData.businessId;
                            }
                        } else {
                            if (!dl.isNullOrUndefined(self.dataSource1())) {
                                userData['detailEmployeeEducationInformation'] = self.dataSource1().data;
                            }
                            if (!dl.isNullOrUndefined(self.dataSource2())) {
                                userData['detailEmployeeTechnicalTitle'] = self.dataSource2().data;
                            }
                            if (!dl.isNullOrUndefined(self.dataSource3())) {
                                userData['detailEmployeeRewardExperience'] = self.dataSource3().data;
                            }
                            if (!dl.isNullOrUndefined(self.dataSource4())) {
                                userData['detailEmployeeWorkExperience'] = self.dataSource4().data;
                            }
                            if (!dl.isNullOrUndefined(self.dataSource5())) {
                                userData['detailEmployeeFamilyInformation'] = self.dataSource5().data;
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
                    dl.pushPageStack({name: 'personnel/entry/entryApplyView', params: self.parentViewModel});
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
                        employeeId: params.rowData.businessId
                    };
                    dl.callOperation("ST_Employee", 'find', condition, self.datareceived);

//                //                  学历信息表
                    dl.callOperation("ST_EmployeeEducationInformation", 'find', condition, self.datareceived1);
//                    //                   技术职称

                    dl.callOperation("ST_EmployeeTechnicalTitle", 'find', condition, self.datareceived2);
//                    //                   奖惩经历表

                    dl.callOperation("ST_EmployeeRewardExperience", 'find', condition, self.datareceived3);
//                      //                  工作经历表

                    dl.callOperation("ST_EmployeeWorkExperience", 'find', condition, self.datareceived4);
                    //家庭
                    dl.callOperation("ST_EmployeeFamilyInformation", 'find', condition, self.datareceived5);
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return entryApplyViewViewModel;
        }
);


