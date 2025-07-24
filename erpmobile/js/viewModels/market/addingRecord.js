
define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojbutton', 'ojs/ojcheckboxset', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojdatetimepicker'],
        function (oj, ko, $, dl) {

            function addingRecordViewModel(params) {
                var self = this;
                self.viewModelName = 'addingRecordViewModel';
                self.parentViewModel = params;
                self.additionalApprovalment = ko.observable();//审批人
                self.additionalApprovalment.dataType = 'integer';
                self.processComment = ko.observable();//审批意见
                self.processComment.dataType = 'string';
                self.dataSource = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.resultData = ko.observableArray();
                self.processbillListData = null;
                self.specialHeaderTitle = ko.observable('');
                self.processID = ko.observable();
                self.errorMessage = ko.observable();
                self.subok = ko.observable(0);
                self.__relevantEmployeesDisplayValue = ko.observable(''); 
                self.__relevantEmployees = ko.observable('');
                self.__trackDate = ko.observable('');
                self.__informationType = ko.observable('2');
                self.__remark = ko.observableArray('');
                self.__attachmentName = ko.observable('');
                self.__registerEmployee = ko.observable(dl.getEmployeeId());
                self.__registerDate = ko.observable('');
                self.__winRate = ko.observable('');
                self.__contractAmount = ko.observable(''); 
                self.__designPrice = ko.observable('');
                self.uploadFileName = ko.observable('');

                self.errorMsg = ko.observable('');
                self.__relevantEmployees.subscribe(function(val){
                   var arr=[];
                   if(val instanceof Array){
                       for(var i= 0; i <val.length;i++){
                           var value = dl.getLabelByValue('employees', val[i]);
                           arr.push(value);
                       }
                        self.__relevantEmployees(val.join(','));
                       self.__relevantEmployeesDisplayValue(arr.join(','));
                   }else{
                        self.__relevantEmployeesDisplayValue( dl.getLabelByValue('employees', self.__relevantEmployees()));   
                   }  
                });
                      
//          按钮的返回事件
                self.rebackToClick = function (event, ui) {
                        dl.getGlobalModule(dl.popPageStack());
                        dl.headerTitle(dl.popHeader());
                };
//                单选复选框
                self.boxShow = ko.observable('-1');
                self.uploadAttachment = ko.observable('附件上传');
                self.diagramData = ko.observable();
                self.attentionUrl = ko.observable();

                self.uploadFile = function (data, event) {
                    var fileList = event.target.files;
                    if (fileList.length > 0) {
                        for (var i = 0; i < fileList.length; i++) {
                            self.uploadFileToProcess(fileList[i], 'UP_UploadPersonnelBusinessAttachments', '', {employeeId: dl.getEmployeeId()});
                        }
                    }
                };
                self.uploadFileToProcess = function (obj, action, subaction, condition) {
                    self.subok('-1');
                    var fileElement = obj;
                    if (!dl.isNullOrUndefined(fileElement)) {
                        // 寻找表单域中的 <input type="file" ... /> 标签
                        var file = fileElement;
                        var formData = new FormData();
                        var fileName = file.name;
                        formData.append('file', file);
                        for (var name in condition) {
                            formData.append(name, condition[name]);
                        }
                        $.ajax({
                            type: "POST",
                            url: dl._SERVERURL + "?action=" + action,
                            enctype: 'multipart/form-data',
                            processData : false, 
                            // 告诉jQuery不要去设置Content-Type请求头
                            contentType : false,
                            data: formData,
                            beforeSend:function(){
                                console.log("正在进行，请稍候");
                            },
                            success: function (response) {
                               var response = JSON.parse(response);
                               if(response['ResultSet']['status'] === 0){
                                   var resultFileUrl = response['ResultSet']['errors'];
                                   self.attentionUrl(resultFileUrl);
                                   self.__attachmentName(self.attentionUrl());
                                   self.uploadFileName(fileName);
                                   self.subok('1');
                               }
                            },
                            error : function(responseStr) { 
                               console.log("error");
                            } 
                          });         
                    } else {
                        console.log("Please choose a file.");
                    }
                };
                //                上传附件
                self.uploadAttachmentClick = function (data, event) {
                    $("#fileInput").click();
                };


                // 取消按钮   返回
                self.cancleClick = function (data, event) {
                    self.rebackToClick();
                };

//                // 提交按钮   跳进度
                self.submitClick = function (data, event) {                   
                        var date = new Date(); 
                       var paramDatas = {
                       preProjectId: params.preProjectId(), 
                       relevantEmployeesDisplayValue: self.__relevantEmployeesDisplayValue(),
                       relevantEmployees: self.__relevantEmployees(),
                       trackDate: date,
                       informationType:self.__informationType(),
                       remark:self.__remark(),
                       attachmentName:self.__attachmentName(),
                       registerEmployee:self.__registerEmployee(),
                       registerDate:date,
                       winRate:self.__winRate(),
                       contractAmount:self.__contractAmount(),
                       designPrice:self.__designPrice()
                    }
                    
                      if (dl.isNullOrEmpty(paramDatas.remark)) {
                        self.errorMessage('♥提示:情况描述不可为空');
                    }
                    if (dl.isNullOrEmpty(paramDatas.winRate)) {
                        self.errorMessage('♥提示:赢率不可为空');
                    }
                    if (dl.isNullOrEmpty(paramDatas.designPrice)) {
                        self.errorMessage('♥提示:设计报价不可为空');
                    }else{
                     dl.callOperation("EP_AddPreProjectRecordProcess", '',paramDatas, self.workCallback);
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
                };

                self.handleDetached = function (info) {
                };
            }

            return addingRecordViewModel;
        }
);


