
define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/msgbox', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl, sc) {
            function sureIntegralViewModel(params) {
                var self = this;
                self.viewModelName = 'sureIntegralViewModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                self.dataSource = ko.observable();
                self.dataSource1 = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.resultData = ko.observableArray();
                self.processbillListData = null;
                self.specialHeaderTitle = ko.observable('');
                self.processID = ko.observable();
                self.arr1 = ko.observable();
                self.newArr = ko.observableArray();


                agreeClick = function (data, event) {
                    var currentData = data;
                    var target = event.currentTarget;
                    sc.confirm("确定同意吗?", function (data, event) {
                        var condition = {
                            employeeId: dl.getEmployeeId(),
                            projectId: params.projectId(),
                            stageId: currentData.stageId,
                            status: 2,
                            optType: 'onSaveOrUpdateStageStatus'
                        };
                        dl.callOperation("EP_OnProjectCommonProcess", 'find', condition, function (data) {
                            alert('保存成功');
                            var data = data.ResultSet.Result;
                            $(target).parent().hide();
                            $(target).parent().siblings('.agreeText').show();
                        });
                    });
                };
                disagreeClick = function (data, event) {
                    var currentData = data;
                    var target = event.currentTarget;
                    sc.confirm("确定不同意吗?", function (data, event) {
                        var condition = {
                            employeeId: dl.getEmployeeId(),
                            projectId: params.projectId(),
                            stageId: currentData.stageId,
                            status: 3,
                            optType: 'onSaveOrUpdateStageStatus'
                        };
                        dl.callOperation("EP_OnProjectCommonProcess", 'find', condition, function (data) {
                            alert('保存成功');
                            $(target).parent().hide();
                            $(target).parent().siblings('.disagreeText').show();
                        });
                    });
                }
//          按钮的返回事件
                self.rebackToClick = function (event, ui) {
                    dl.getGlobalModule(dl.popPageStack());
                    dl.headerTitle(dl.popHeader());
                };

                self.datareceived = function (data) {
                    var data = data.ResultSet.Result;
                    self.arr1(data);
                };
                self.datareceived1 = function (data) {
                    var data = data.ResultSet.Result;
                    self.newArr(data);
                };



//                // 提交按钮   跳进度
                self.submitClick = function (data, event) {
                    var date = new Date();
                    var paramDatas = {
                        preProjectId: params.preProjectId(),
                        relevantEmployeesDisplayValue: self.__relevantEmployeesDisplayValue(),
                        relevantEmployees: self.__relevantEmployees(),
                        trackDate: date,
                        informationType: self.__informationType(),
                        remark: self.__remark(),
                        attachmentName: self.__attachmentName(),
                        registerEmployee: self.__registerEmployee(),
                        registerDate: date,
                        winRate: self.__winRate(),
                        contractAmount: self.__contractAmount(),
                        designPrice: self.__designPrice()
                    }

                    if (dl.isNullOrEmpty(paramDatas.remark)) {
                        self.errorMessage('♥提示:情况描述不可为空');
                    }
                    if (dl.isNullOrEmpty(paramDatas.winRate)) {
                        self.errorMessage('♥提示:赢率不可为空');
                    }
                    if (dl.isNullOrEmpty(paramDatas.designPrice)) {
                        self.errorMessage('♥提示:设计报价不可为空');
                    } else {
                        dl.callOperation("EP_AddPreProjectRecordProcess", '', paramDatas, self.workCallback);
                    }

                };

                //审批后执行的方法
                self.workCallback = function (data) {
                    $('#navlistcontainer').hide();
                    alert('♥提示:保存成功！');
                    self.rebackToClick();
                };


                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {

                };

                self.handleBindingsApplied = function (info) {
                    var condition2 = {
                        checkEmployeeId: dl.getEmployeeId(),
                        projectId: params.projectId()
                    };
                    var condition = {
                        employeeId: dl.getEmployeeId(),
                        projectId: params.projectId()
                    };
                    dl.callOperation("NQ_OnLoadProjectStageSettlement2", 'find', condition2, self.datareceived);
                    dl.callOperation("NQ_OnLoadProjectEmpAndStageWithB  ", 'find', condition, self.datareceived1);
                };

                self.handleDetached = function (info) {
                };
            }

            return sureIntegralViewModel;
        }
);


