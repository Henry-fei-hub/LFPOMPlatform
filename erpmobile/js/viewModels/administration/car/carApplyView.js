define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/msgbox', 'ojs/ojarraydataprovider', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojdatetimepicker', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojtimezonedata', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl, sc) {
            function carApplyViewViewModel(params) {
                var self = this;
                self.viewModelName = 'carApplyViewViewModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                self.approvalment = ko.observable();
                self.errorMessage = ko.observable();
                var userData = {};
                self.listArr = ko.observableArray([]);
                self.dataSource = ko.observable();
//                self.listArr 变化 动态监听
                self.dataSource1 = new oj.ArrayDataProvider(self.listArr, {keys: self.listArr().map(function (value) {
                        return value.personnelBusinessId;
                    })});
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.resultData = ko.observable();
                self.processbillListData = null;
                self.specialHeaderTitle = ko.observable('');

                self.isShow = ko.observable();
                self.isshowitem = ko.observable(false);
                self.isshowUpdate = ko.observable(false);
                self.isApproval = ko.observable(true);
                self.__drafter = ko.observable(dl.getEmployeeId());
                self.__employeeId = ko.observable();
                self.__companyId = ko.observable();
                self.__employeeNo = ko.observable();
                self.__departmentId = ko.observable();
                self.__card = ko.observable();
                self.__plan = ko.observable();
                self.__unit = ko.observable();
                self.__startDate = ko.observable();
                self.__endDate = ko.observable();
                self.__startDateDetail = ko.observable();
                self.__livingExpenses = ko.observable();
                self.__type = ko.observable();
                self.__address = ko.observable();
                self.__projectName = ko.observable();
                self.__endDateDetail = ko.observable();
                self.__projectCode = ko.observable();
                self.__fee = ko.observable();
                self.__reason = ko.observable();
                self.__subType = ko.observable();
                self.__subTypeStr = ko.observable();
                self.__targetProvince = ko.observable('');
                self.__contactPerson = ko.observable('');
                self.__remark = ko.observable();
                self.__id = ko.observable();
                self.__code = ko.observable();
                self.__name = ko.observable();
                self.__cost = ko.observable();
                self.__percent = ko.observable();
                self.__costAllocation = ko.observable();
                self.__transportation = ko.observable();
                self.contactPersonArr = ko.observableArray([]);
                self.__subType.subscribe(function (val) {
                    if (val == 0) {
                        // 内部派车
                        self.isshowitem(true);
                    } else {
                        self.isshowitem(false);
                    }
                });

                self.__endDateDetail.subscribe(function (val) {
                    var htype = val;
                    if (val instanceof Array && val.length > 0)
                        htype = val[0];
                    self.__endDateDetail(htype);
                    if(dl.isNullOrEmpty(self.__livingExpenses())){
                    var condition3 = {
                        'optType': 'onGetUseCarPrice',
                        'useCarPriceId': self.__endDateDetail(),
                        'carType': self.__address()
                    };
                    dl.callOperation("EP_OnProjectWithStageCommon", '', condition3, function (response) {
                        if (Number(response['ResultSet']['status']) >= 0) {
                            var data = dl.parseCollection(response);
                            if (!dl.isNullOrEmpty(data)) {
                                var price = data[0].price;
                                self.__livingExpenses(price);
                                self.__fee(price);
                                self.__cost(price);
                            }
                        }
                    });
                   
                    }
                });
                self.__address.subscribe(function (val) {
                    var htype = val;
                    if (val instanceof Array && val.length > 0)
                        htype = val[0];
                    self.__address(htype);
                    var condition3 = {
                        'optType': 'onGetUseCarPrice',
                        'useCarPriceId': self.__endDateDetail(),
                        'carType': self.__address()
                    };
                    dl.callOperation("EP_OnProjectWithStageCommon", '', condition3, function (response) {
                        if (Number(response['ResultSet']['status']) >= 0) {
                            var data = dl.parseCollection(response);
                            if (!dl.isNullOrEmpty(data)) {
                                var price = data[0].price;
                                self.__livingExpenses(price);
                                self.__fee(price);
                                self.__cost(Number(price));
                            }
                        }
                    });
                });
                self.__livingExpenses.subscribe(function (val) {
                    self.__fee(val);
                     self.__cost(Number(val));
                });
                self.__fee.subscribe(function (val) {
                    self.__livingExpenses(val);
                      self.__cost(Number(val));
                });
                self.__cost.subscribe(function (val) {
                    self.__livingExpenses(val);
                    self.__fee(val);
                    var newArra = self.listArr();
                    for (var i = 0; i < newArra.length; i++) {
                        newArra[i].cost = val;
                        newArra[i].costAllocation = (newArra[i].percent / 100) * val;
                    }
                    self.listArr(newArra);

                });
                self.datareceived2 = function (data) {
                    var arr = dl.parseCollection(data);
                    for (var i = 0; i < arr.length; i++) {
                        var littlearr = {};
                        littlearr.label = arr[i]['employeeName'];
                        littlearr.value = arr[i]['employeeId'];
                        self.contactPersonArr.push(littlearr);
                    }
                };
                self.datareceived = function (data) {
                    var arrData = dl.parseCollection(data);
                    self.resultData = arrData;
                    self.dataSource(new oj.ArrayTableDataSource(self.resultData, {idAttribute: 'personnelBusinessId'}));
                    //  某人的报销页面的标题以报销人+主题 
                    self.specialHeaderTitle(dl.getLabelByValue('employees', arrData[0]['employeeId']) + dl.getLabelByValue('system_dictionary_119', arrData[0]['startDateDetail']));
                    self.__employeeId(arrData[0]['employeeId']);
                    self.__companyId(arrData[0]['companyId']);
                    self.__employeeNo(arrData[0]['employeeNo']);
                    self.__departmentId(arrData[0]['departmentId']);
                    self.__card(arrData[0]['card']);
                    self.__plan(arrData[0]['plan']);
                    self.__unit(arrData[0]['unit']);
                    self.__startDate(arrData[0]['startDate']);
                    self.__endDate(arrData[0]['endDate']);
                    self.__startDateDetail(arrData[0]['startDateDetail']);
                    self.__livingExpenses(arrData[0]['livingExpenses']);
                    self.__type(arrData[0]['type']);
                    self.__address(arrData[0]['address']);
                    self.__projectName(arrData[0]['projectName']);
                    self.__endDateDetail(arrData[0]['endDateDetail']);
                    self.__projectCode(arrData[0]['projectCode']);
                    self.__fee(arrData[0]['fee']);
                    self.__reason(arrData[0]['reason']);
                    self.__subType(arrData[0]['subType']);
                    self.__subTypeStr(arrData[0]['subTypeStr']);
                    self.__targetProvince(arrData[0]['targetProvince']);
                    self.__contactPerson(Number(arrData[0]['contactPerson']));
                    self.__remark(arrData[0]['remark']);
                    self.__transportation(arrData[0]['transportation']);
                };
                self.datareceived1 = function (data) {
                    //用车子表数据
                    var arrData = data.ResultSet.Result;
                    self.listArr(arrData);
                    self.resultData1 = arrData;
                    if (arrData.length > 0 && !dl.isNullOrUndefined(arrData[0]['type'])) {
                        var typeId = arrData[0]['type'];
                        self.processbillListData = arrData;
                        switch (Number(typeId)) {
                            case 1://项目用车
                                self.isShow(1);
                                break;
                            case 2: //前期项目用车
                                self.isShow(2);
                                break;
                            case 3: //部门用车
                                self.isShow(3);
                                break;
                        }
                    }
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

                //处理节点执行的方法
                self.checkData = function (values) {
                    if (self.approvalment() == 0) {
                        if (!dl.isNullOrUndefined(params.rowData.backViewName) && (params.rowData.backViewName).indexOf("司机班职能经理") >= 0) {
                            if (dl.isNullOrEmpty(values.subType)) {
                                self.errorMessage('♥提示:请选择内部派车/外部专车');
                                return false;
                            } else if (values.subType ==2 && dl.isNullOrEmpty(values.targetProvince)) {
                                self.errorMessage('♥提示:请选择车辆信息');
                                return false;
                            } else if (values.subType ==2 && dl.isNullOrEmpty(values.contactPerson)) {
                                self.errorMessage('♥提示:请选择司机');
                                return false;
                            } else {
                                return true;
                            }
                        }else{
                              return true;
                        }
                    } else {
                        return true;
                    }
                };

                self.getValues = function () {
                    //业务数据获取
                    userData = self.resultData[0];
                    userData['personnelBusinessId'] = params.rowData.businessId;
                    var arr = [];
                    arr.push(userData);
                    //  费用分摊加进来
                    arr[0].detailCarCostAllocation = self.resultData1;
                    for (var name in self) {
                        if (name.indexOf("__") !== -1) {
                            if (self[name]() instanceof Array) {
                                userData[name.substring(2)] = self[name]()[0];
                                userData['personnelBusinessId'] = params.rowData.businessId;
                                userData['processType'] = params.rowData.processType;
                            } else {
                                userData[name.substring(2)] = self[name]();
                                userData['processType'] = params.rowData.processType;
                            }
                        }
                    }
                    return arr[0];
                };
                //提交审批
                self.submitClick = function (data, event) {
                    var inner = event.currentTarget.innerText;
                    sc.confirm("确定" + inner + "吗?", function () {
                        var target = event.currentTarget;
                        var approvalment = target.id;
                        self.approvalment(target.id);
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
                    dl.pushPageStack({name: 'administration/car/carApplyView', params: self.parentViewModel, cacheKey: 'administration/car/carApplyView'});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle("流程进度");
                };

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    if (!dl.isNullOrUndefined(params.rowData.backViewName)) {
                        if (params.rowData.backViewName.indexOf('司机班职能经理') >= 0) {
                            self.isshowUpdate(true);
                        }
                    }

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
                    var condition1 = {
                        personnelBusinessId: params.rowData.businessId
                    };
                    dl.callOperation("ST_CarCostAllocation", 'find', condition1, self.datareceived1);
                    var condition2 = {
                        status: 0,
                        dutyId: 31
                    };
                    dl.callOperation("NQ_SelectEmployee", 'find', condition2, self.datareceived2);

                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return carApplyViewViewModel;
        }
);


