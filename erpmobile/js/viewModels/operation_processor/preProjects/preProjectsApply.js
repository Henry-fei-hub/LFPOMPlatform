define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojradioset', 'ojs/ojlabel', 'ojs/ojnavigationlist',
        'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojdatetimepicker', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
        function preProjectsApplyViewModel(params) {
        var self = this;
                self.viewModelName = 'preProjectsApplyViewModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable(); //审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable(); //审批意见
                self.processComment.dataType = 'string';
                self.dataSource = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.showbox = ko.observable(false);
                self.cityArr = ko.observableArray([]);
                self.selectedItem = ko.observable("");
                self.alldata = ko.observable();
                self.similarData = ko.observable();
                self.__applyEmployeeId = ko.observable(dl.getEmployeeId());
                self.__drafter = ko.observable(dl.getEmployeeId());
                self.__customerName = ko.observable();
                self.__projectName = ko.observable();
                self.__province = ko.observable();
                self.__city = ko.observable();
                self.__detailAddress = ko.observable();
                self.__businessTypes = ko.observable();
                self.__totalBuildingAreas = ko.observable();
                self.__projectOrigination = ko.observable();
                self.__contactName = ko.observable();
                self.__contactPhone = ko.observable();
                self.__region = ko.observable();
                self.__grade = ko.observable();
                self.__estimateTheDesignAreas = ko.observable();
                self.__comparisonForm = ko.observable();
                self.__remark = ko.observable();
//                运营组是否分配项目
                self.__isOperationDepartment = ko.observable("true");
                self.showRegion = ko.observable();
                self.resultData = ko.observableArray();
                self.processbillListData = null;
                self.specialHeaderTitle = ko.observable('');
                self.processID = ko.observable();
                self.processType = 42; //项目报备
                self.businessTypes = ko.observableArray();
                self.errorMessage = ko.observable();
                self.errorMessage.dataType = 'string';
                self.dataSource = new oj.ArrayTableDataSource(self.resultData, {idAttribute: 'employeeId'});
                //                运营组是否分配项目
                self.colorOptions = ko.observableArray([
                {id:"blueopt", value: "true", color: "是"},
                {id:"greenopt", value: "false", color: "否"}
                ]);
                self.datareceived1 = function (data) {
                var arrData = dl.parseCollection(data);
                        if (arrData.length > 0) {
                self.processID = arrData[0]['idd'];
                }
                };
                //处理节点执行的方法   STEP3
                self.checkData = function (paramData) {
                var values = paramData.userData;
                        //如果为空则返回false
                        if (dl.isNullOrEmpty(values)) {
                self.errorMessage('♥提示:数据异常');
                        return false;
                }
                if (dl.isNullOrEmpty(values.customerName)) {
                self.errorMessage('♥提示:开发商名称不可为空');
                        return false;
                }
                if (dl.isNullOrEmpty(values.projectName)) {
                self.errorMessage('♥提示:项目名称不可为空');
                        return false;
                }
                if (dl.isNullOrEmpty(values.province) || dl.isNullOrEmpty(values.city) || dl.isNullOrEmpty(values.detailAddress)) {
                self.errorMessage('♥提示:项目地址/区域不可为空');
                        return false;
                }
                if (dl.isNullOrEmpty(values.totalBuildingAreas)) {
                self.errorMessage('♥提示:项目面积不可为空');
                        return false;
                }
                if (isNaN(values.totalBuildingAreas)) {
                self.errorMessage('♥提示:项目面积只能输入数字');
                        return false;
                }
                if (dl.isNullOrEmpty(values.projectOrigination)) {
                self.errorMessage('♥提示:项目信息来源不可为空');
                        return false;
                }
                if (dl.isNullOrEmpty(values.contactName)) {
                self.errorMessage('♥提示:联系人不可为空');
                        return false;
                }
                if (dl.isNullOrEmpty(values.contactPhone)) {
                self.errorMessage('♥提示:联系电话不可为空');
                        return false;
                }
                //判断是否有相似项目，有则跳转到相似项目页面，无则直接提交申请
                var condition = values;
                        condition['optType'] = 'checkSimilarPercent';
                        dl.callOperation("EP_PreProjectProcess", '', condition, function (response) {
                        if (response['ResultSet']['status'] >= 0){
                        var record = dl.parseCollection(response);
                                if (!dl.isNullOrEmpty(record)){
//                                self.similarData(record);
//                                self.parentViewModel.pageType = 2;
//                                self.parentViewModel.oriData = self.alldata;
//                                dl.pushPageStack({name: 'operation_processor/preProjects/preProjectsApply', params: self.parentViewModel,cacheKey:  'operation_processor/preProjects/preProjectsApply'});
//                                dl.pushHeader(dl.headerTitle());
//                                dl.getGlobalModule({name: 'operation_processor/preProjects/preProjectsApplySimilar', params: self});
//                                dl.headerTitle("类似项目比较");
                        alert('♥提示:报备失败，请联系运营中心');
                        } else{
                        var actionTmp = "EP_NewCreateWorkFlow";
                                dl.callOperation(actionTmp, '', paramData, self.workCallback);
                        }
                        }
                        });
//                    return true;
                };
//                STEP2
                self.getValues = function () {
                //业务数据获取 作为par当前节点数据详情数据的一部分提交
                var resultData = {};
                        for (var name in self) {
                if (name.indexOf("__") !== - 1) {
                if (self[name]() instanceof Array) {
                resultData[name.substring(2)] = self[name]()[0];
                } else {
                resultData[name.substring(2)] = self[name]();
                }
                }
                }
                self.alldata(resultData);
                        return resultData;
                };
                //审批后执行的方法 STEP4
                self.workCallback = function (data) {
                if (data.ResultSet.status >= 0) {
                self.errorMessage('');
                        var returnData = dl.parseCollection(data);
                        self.processInstanceId = returnData[0].processInstanceId;
                        dl.getGlobalModule({name: 'schedule', params: self});
                        dl.headerTitle("流程进度");
                } else {
                self.errorMessage('♥提示:' + decodeURIComponent(data.ResultSet.errors));
                }
                };
                //提交审批  STEP1
                self.submitClick = function (data, event) {
//                    当前节点数据详情数据
                var paramData = {
                operatorId: dl.getEmployeeId(),
                        processDefinition: {processId: self.processID}
                };
                        paramData.userData = self.getValues();
                        self.checkData(paramData);
//                        dl.submitApprovalWork(0, paramData, self, '', '');
                };
                //通过省份获取对应城市
                self.__province.subscribe(function(val){
                var pro = val;
                        if (val instanceof Array && val.length > 0)
                        pro = val[0];
                        var param = {};
                        param['province'] = pro;
                        param['parentId'] = 0;
                        param['optType'] = 'getCityNames';
                        dl.callOperation("EP_PreProjectProcess", '', param, function (response) {
                        var data = dl.parseCollection(response);
                                var userData = response.ResultSet.userData;
                                arr = [];
                                for (var i = 0; i < data.length; i++){
                        if (data){
                        arr.push({value:data[i].allName, label:data[i].allName});
                        } else{
                        arr.push(data);
                        }
                        }
                        self.cityArr(arr);
                                self.showRegion(dl.getLabelByValue('system_dictionary_170', userData.region));
                                self.__region(userData.region);
                        });
                });
                self.getDataTitle = function (data) {
                };
                self.handleActivated = function (info) {
                };
                self.handleAttached = function (info) {
                if (self.parentViewModel.oriData && self.parentViewModel.pageType && self.parentViewModel.pageType === 2){
                var oriData = self.parentViewModel.oriData();
                        for (var i in oriData){
                if (self["__" + i]){
                if (i === "city" || i === "province" || i === "projectType" || i === "projectOrigination"){
                self["__" + i]([oriData[i]]);
                } else{
                self["__" + i](oriData[i]);
                }
                }
                }
                }
                self.errorMessage('');
                          dl.setOptionsFromQuery('NQ_BusinessCategory', {},  function (response) {
                  self.businessTypes(response)
                            });
                        var condition1 = {
                        employeeId: dl.getEmployeeId(),
                                processTypeId: self.processType
                        };
                                dl.callOperation("NQ_EmployeeProcess", 'find', condition1, self.datareceived1);
                        };
                                self.handleBindingsApplied = function (info) {
                                };
                                self.handleDetached = function (info) {
                                };
                        }

                        return preProjectsApplyViewModel;
                        }
                        );


