
define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/msgbox', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojbutton', 'ojs/ojcheckboxset',
     'ojs/ojdatetimepicker', 'ojs/ojinputnumber', 'ojs/ojselectcombobox', 'ojs/ojvalidation'],
        function (oj, ko, $, dl ,sc) {

            function trainingViewModel(params) {
                var self = this;
                self.viewModelName = 'trainingViewModel';
                self.parentViewModel = params;
                self.errorMsg = ko.observable('');
                self.__sub = ko.observable(); 
                self.__date = ko.observable();
                self.__department = ko.observable();
                self.__courseScore = ko.observable();
                self.__compere = ko.observable();
                self.__site = ko.observable();
                self.__employeeId = ko.observable();
                self.holidayTypes = ko.observableArray();
                self.__explain = ko.observable("从高到低分数区间为100-0");
                self.__trainingFrequency = ko.observable();
                self.__trainingPeriod = ko.observable();
                self.__spareTimeTraining = ko.observable();
                self.__departmentId = ko.observable();
                self.__courseScore = ko.observable();
                self.__trainingContent = ko.observable(100);
                self.__courseEvaluation = ko.observable(100);
                self.__guidingFunction = ko.observable(100);
                self.__trainingMethod = ko.observable(100);
                
//          按钮的返回事件
                self.rebackToClick = function (event, ui) {
                        dl.getGlobalModule(dl.popPageStack());
                        dl.headerTitle(dl.popHeader());
                };
                //签到
                self.signInClick = function (event, ui) {
                    var paramDatas = {
                        optType:"signin",
                        trainingManagementId:params['id'],
                        employeeId:dl.getEmployeeId(),
                        employeeNumber:dl.getEmployeeNo(),
                        departmentId:dl.getDepartmentId()
                    };
                    dl.callOperation("EP_TrainingManagementProcess", "", paramDatas, function (response) {
                        if (response.ResultSet.status > 0) {
                            self.ulShow(1);
                            alert("签到成功");
                        }else{
                            alert(response.ResultSet.errors);
                        }

                    });
                };
                //签退
                self.signOutClick = function(event,ui){
                    if(self.__trainingContent()==null||self.__trainingMethod()==null||self.__courseEvaluation()==null||self.__guidingFunction()==null||self.__trainingFrequency()==null||self.__trainingPeriod()==null||self.__spareTimeTraining()==null){
                        alert("请完成课程评价");
                        return;
                    }
                    var paramDatas = {
                       optType:"signout",
                       trainingManagementId:params['id'],
                       employeeId:dl.getEmployeeId(),
                       trainingContent:self.__trainingContent(),
                       trainingMethod:self.__trainingMethod(),
                       courseEvaluation:self.__courseEvaluation(),
                       guidingFunction:self.__guidingFunction(),
                       trainingFrequency:self.__trainingFrequency(),
                       trainingPeriod:self.__trainingPeriod(),
                       spareTimeTraining:self.__spareTimeTraining()
                    }
                    dl.callOperation("EP_TrainingManagementProcess", "", paramDatas, function (response) {
                        if(response.ResultSet.status>0){
                            self.ulShow(0);
                            alert("签退成功");
                        }else{
                            alert(response.ResultSet.errors);
                        }
                    });
                };

                self.ulShow = ko.observable(0);
                

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                    var condition = {
                        trainingManagementId: params['id']
                    };
                    dl.callOperation("ST_TrainingManagement", 'find', condition, function (response) {
                        if(response.ResultSet.status >= 0){
                            var data = dl.parseCollection(response)[0];
                            self.__sub(data.subject);
                            self.__date(dl.dateConverter.format(dl.parseValueFromService(data.startTime)));
                            self.__departmentId(data.departmentId);
                            self.__courseScore(data.courseScore);
                            self.__compere(data.compere);
                            self.__site(data.site);
                        }
                    });
                    
                    var paramDatas = {
                       optType:"signinFlag",
                       trainingManagementId:params['id'],
                       employeeId:dl.getEmployeeId()
                    }
                    dl.callOperation("EP_TrainingManagementProcess", "", paramDatas, function (response) {
                        if(response.ResultSet.status > 0){
                            var paramDatas2 = {
                                optType:"signoutFlag",
                                trainingManagementId:params['id'],
                                employeeId:dl.getEmployeeId()
                            }
                            dl.callOperation("EP_TrainingManagementProcess", "", paramDatas2, function (response) {
                                if(response.ResultSet.status > 0){
                                    self.ulShow(0);
                                }else{
                                     self.ulShow(1);
                                }
                             });
                        }else{
                            self.ulShow(-1);
                        }
                    });
                };

                self.handleAttached = function (info) {
                    
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return trainingViewModel;
        }
);


