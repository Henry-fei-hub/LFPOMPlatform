define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox', 'ojs/ojbutton', 'ojs/ojcheckboxset', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojdatetimepicker', 'ojs/ojtimezonedata'],
        function (oj, ko, $, dl) {
            function leaveApplyViewModel(params) {
                var self = this;
                self.viewModelName = 'leaveApplyViewModel';
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
                self.processType = 13;//请假类型
                self.errorMessage = ko.observable();
                self.subok = ko.observable('0');
//               是否显示errorMsg 判断信息对错
                self.isType = ko.observable('0');
                //__drafter新增
                self.__drafter = ko.observable(dl.getEmployeeId());
                self.__employeeId = ko.observable(dl.getEmployeeId());
                self.__companyProvince = ko.observable();
                self.__employeeNo = ko.observable(dl.getEmployeeNo());
                self.__departmentId = ko.observable(dl.getDepartmentId());
                self.__nextAuditor = ko.observable();
                self.__type = ko.observable();
                self.__TypeId = ko.observable();
                self.__subType = ko.observableArray();
                self.__subTypeId = ko.observable();
                self.__numberOfBaby = ko.observable();
                self.__unit = ko.observable();
                self.__reason = ko.observable();
                self.__targetProvince = ko.observable();
                self.__days = ko.observable();
                self.__hours = ko.observable();
                self.__startDate = ko.observable();
                self.__endDate = ko.observable();
                self.__remark = ko.observable();
                self.__attachment = ko.observable();
                self.__attachmentId = ko.observable();
                self.__attachmentName = ko.observable();
                self.__certificationTime = ko.observable();
                self.holidayTypes = ko.observableArray();
                self.holidayDetailTypes = ko.observableArray([]);
                self.holidayDetaildays = ko.observableArray();
                self.uploadFileName = ko.observable();
                var subtypes = [], subdays = [];
                var userData = {};
                self.unitArr = ko.observableArray([{key: '祖父', value: '祖父'}, {key: '祖母', value: '祖母'}, {key: '父亲', value: '父亲'}, {key: '母亲', value: '母亲'}, {key: '配偶', value: '配偶'}, {key: '配偶父亲', value: '配偶父亲'}, {key: '配偶母亲', value: '配偶母亲'}, {key: '子/女', value: '子/女'}]);
                self.typeDayValues = [];

//                最多多少小时多少天
                self.__actualDays = ko.observable('0');
                self.__actualHours = ko.observable('0');

                self.errorMsg = ko.observable('');
//          按钮的返回事件
                self.rebackToClick = function (event, ui) {
                    if (self.ulShow() == 1) {
                        self.ulShow(0);
                    } else {
                        dl.getGlobalModule(dl.popPageStack());
                        dl.headerTitle(dl.popHeader());
                    }
                };
//                单选复选框
                self.boxShow = ko.observable('-1');
//                附件部分
                self.ulShow = ko.observable('0');
                self.uploadAttachment = ko.observable('附件上传');
                self.diagramData = ko.observable();
                self.attentionUrl = ko.observable();

                self.uploadFile = function (data, event) {
                    var fileList = event.target.files;
                    if (fileList.length > 0) {
                        for (var i = 0; i < fileList.length; i++) {
                            self.uploadFileToProcess(fileList[i], {employeeId: dl.getEmployeeId()});
                        }
                    }
                };
                self.uploadFileToProcess = function (obj, condition) {
                    self.subok('-1');
                    var fileElement = obj;
                    if (!dl.isNullOrUndefined(fileElement)) {
                        // 寻找表单域中的 <input type="file" ... /> 标签
                        var file = fileElement;
                        var formData = new FormData();
                        var fileName = file.name;
                        formData.append('Filedata', file);
                        for (var name in condition) {
                            formData.append(name, condition[name]);
                        }
                        $.ajax({
                            type: "POST",
//                            url: dl._SERVERURL + "?action=" + action,
                            url: dl._UPLOADURL,
                            enctype: 'multipart/form-data',
                            processData: false,
                            // 告诉jQuery不要去设置Content-Type请求头
                            contentType: false,
                            data: formData,
                            beforeSend: function () {
                                console.log("正在进行，请稍候");
                            },
                            success: function (response) {
                                var response = JSON.parse(response);
                                if (response['ResultSet']['status'] === 0) {
                                    var resultFileUrl = response['ResultSet']['Result'][0];
//                                   self.attentionUrl(resultFileUrl);
//                                   self.__attachment(self.attentionUrl());
//                                   self.uploadFileName(fileName);
                                    self.__attachment(resultFileUrl.fileUrl)
                                    self.__attachmentId(resultFileUrl.fileId)
                                    self.__attachmentName(resultFileUrl.fileName)
                                    self.subok('1');
                                }
                            },
                            error: function (responseStr) {
                                console.log("error");
                            }
                        });
                        //兼容性差  有很多手机不能够创建该对象
//                        var __xhr = new XMLHttpRequest();
//                        __xhr.open(/* method */ "POST",
//                                /* target url */ dl._SERVERURL + "?action=" + action,
//                                /*, async, default to true */);
//                        __xhr.overrideMimeType("application/octet-stream");
//                        __xhr.send(formData);
//                        __xhr.onreadystatechange = function () {
//                            if (__xhr.readyState === 4) {
//                                if (__xhr.status === 200) {
//                                    //获取url
//                                    var url = __xhr.responseText;
//                                    var obj = JSON.parse(url);
//                                    self.attentionUrl(obj.ResultSet['errors']);
////                                    userData['attachment'] = obj.ResultSet['errors'];
//                                    self.__attachment(self.attentionUrl());
//
//
//                                    self.subok('1');
//                                } else {
//                                }
//                            }
//                        };

                    } else {
                        console.log("Please choose a file.");
                    }
                };
                //                上传附件
                self.uploadAttachmentClick = function (data, event) {
                    $("#fileInput").click();
                    self.ulShow('1');
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle("上传附件");
                };

                self.datareceived1 = function (data) {
                    var arrData = dl.parseCollection(data);
                    if (arrData.length > 0) {
                        self.processID = arrData[0]['idd'];
                    }
                };


                //处理节点执行的方法
                self.checkData = function (values) {
                    if (dl.isNullOrEmpty(values)) {
                        self.errorMessage('♥提示:数据异常不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.type)) {
                        self.errorMessage('♥提示:休假类型不可为空');
                        return false;
                    }
                      if (dl.isNullOrEmpty(values.nextAuditor)) {
                        self.errorMessage('♥提示:交接人不可为空');
                        return false;
                    }
                    if (values.TypeId !== 9 && values.TypeId !== 21 ) {
                        if (dl.isNullOrEmpty(values.reason)) {
                            self.errorMessage('♥提示:请假原由不可为空');
                            return false;
                        }
                    }
                    if ((dl.isNullOrEmpty(values.days) && dl.isNullOrEmpty(values.hours))|| (values.days == 0 && values.hours == 0)) {
                        self.errorMessage('♥提示:请假天数和小时数不能都为空或0');
                        return false;
                    }
                    if (values.subType == 2 && values.subTypeId == "多胞胎假") {
                        if (dl.isNullOrEmpty(values.numberOfBaby)) {
                            self.errorMessage('♥提示:婴儿数量必填');
                            return false;
                        }
                    }
                    if (values.TypeId == 26) {
                        if (dl.isNullOrEmpty(values.hours)) {
                            self.errorMessage('♥提示:需调休工时不可为空');
                            return false;
                        } else if (values.hours > values.adjustableWorkTime) {
                            self.errorMessage('♥提示:剩余的可调休时间不够本次调休');
                            return false;
                        }
                        return true;
                    } else {
                        if (dl.isNullOrEmpty(values.startDate)) {
                            self.errorMessage('♥提示:开始时间不可为空');
                            return false;
                        }
                        if (dl.isNullOrEmpty(values.endDate)) {
                            self.errorMessage('♥提示:结束时间不可为空');
                            return false;
                        }
                        if (values.type == 8 || values.type == 1 || values.type == 6 || values.type == 7 || values.type == 12|| values.type == 20) {
                            if (dl.isNullOrEmpty(values.attachment)) {
                                self.errorMessage('♥提示:婚假、产假、产检假、陪护假需上传相关证明文件');
                                return false;
                            }
                        }
                        if (dl.isNullOrEmpty(values.endDate)) {
                            self.errorMessage('♥提示:结束时间不可为空');
                            return false;
                        }
                        if (parseInt(values.numberOfBaby) < 2) {
                            self.errorMessage('♥提示:婴儿数量大于等于2才能申请多胞胎假');
                            return false;
                        }
                        return true;
                    }
                    ;
                };
                //self 当前整个模块
                self.getValues = function () {
                    //业务数据获取
                    for (var name in self) {
                        if (name.indexOf("__") !== -1) {
//                            给产假的多选框进行处理
                            if (userData['type'] === 1 && name === '__subType') {//产假
                                var val = self[name]();
                                var subType = '';
                                var subTypeStr = '';
                                var arr = self.holidayDetailTypes();
                                for (var i = 0; i < val.length; i++) {
                                    var tmpVal = val[i];
                                    for (var j = 0; j < arr.length; j++) {
                                        if (arr[j]['leaveTypeName'] == tmpVal) {
                                            if (i > 0) {
                                                subType += ',';
                                                subTypeStr += ',';
                                            }
                                            subType += arr[i]['leaveTypeId'];
                                            subTypeStr += arr[i]['leaveTypeName'];
                                            break;
                                        }
                                    }
                                }
                                userData['subType'] = subType;
                                userData['subTypeStr'] = subTypeStr;
                            } else {
                                if (self[name]() instanceof Array) {
                                    userData[name.substring(2)] = self[name]()[0];
                                } else {
                                    userData[name.substring(2)] = self[name]();
                                }
                            }
                        }
                    }
                    return userData;
                };

                // 取消按钮   返回
                self.cancleClick = function (data, event) {
                    self.rebackToClick();
                };

//                // 提交按钮   跳进度
                self.submitClick = function (data, event) {
                    var paramData = {
                        systemProcessApplyId: 1,
                        activityType: 4,
                        operatorId: dl.getEmployeeId(),
                        processDefinition: {processId: self.processID}
                    };
                    dl.submitApprovalWork(0, paramData, self, '', '');

                };

                //审批后执行的方法
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

                self.__type.subscribe(function (val) {
                    self.__startDate(0);
                    self.__endDate(0);
                    var htype = val;
                    if (val instanceof Array && val.length > 0)
                        htype = val[0];
                    self.__TypeId(htype);
                    var condition = {};
                    condition['parentId'] = htype;
                    condition['optType'] = 'getLeaveTypes';
                    condition['areaId'] = self.__companyProvince();
                    condition['employeeId'] = self.__employeeId();
                    dl.callOperation("EP_MyPersonnelProcessor", '', condition, function (response) {
                        var arr = dl.parseCollection(response);
                        var oriSunTypes = self.holidayTypes();
                        var maxDays = 0;
                        for (var i = 0; i < oriSunTypes.length; i++) {
                            if (oriSunTypes[i]['leaveTypeId'] === htype) {
                                maxDays = oriSunTypes[i]['days'];
                            }
                        }
                        subtypes = [];
                        subdays = [];
                        for (var i = 0; i < arr.length; i++) {
                            subtypes.push({leaveTypeId: arr[i].leaveTypeId, leaveTypeName: arr[i].leaveTypeName});
                            subdays.push({leaveTypeId: arr[i].leaveTypeId, days: arr[i].days});
                        }
//                        21 调休时显示小时数
                        if (htype === 21) {
                            self.__actualHours(maxDays);
                            self.__actualDays(0);
                        } else {
                            self.__actualHours(0);
                            self.__actualDays(maxDays);
                        }
                        if (htype === 1 || htype === 9 || htype === 12) {
                            self.__actualDays('');
                        }
                        ;
                        self.holidayDetailTypes(subtypes);
                        self.holidayDetaildays(subdays);
                        self.holidayDetaildays(subdays);

                    });

                });


                self.__subType.subscribe(function (val) {
                    self.__subTypeId(val);
                    if (self.__TypeId() === 1) {
                        var num = 0;
                        for (var i = 0; i < val.length; i++) {
                            if (val[i] == '基础产假') {
                                num = num + 98;
                            } else if (val[i] == "生育奖励假") {
                                num = num + 80;
                            } else if (val[i] == "难产假") {
                                num = num + 30;
                            } else if (val[i] == "多胞胎假") {
                                num = num + 15;
                            }
                            self.__actualDays(num);
                        }
                    }
                    if (self.__subTypeId() == '多胞胎假') {
                        if (Number(self.__numberOfBaby) >= 2) {
                            self.__actualDays(15 * (Number(self.__days) - 1));
                        }
                    } else {
                        if (!dl.isNullOrEmpty(subdays) && subdays.length > 0) {
                            for (var i = 0; i < subdays.length; i++) {
                                //获取typeId
                                var typeId = subdays[i]['leaveTypeId'];
                                if (Number(val) === Number(typeId)) {
                                    //获取最大天数
                                    var days = subdays[i]['days'];
                                    self.__actualDays(days);
                                }
                            }
                        } else {
                            self.__actualDays(0);
                        }
                    }
                });

                self.__numberOfBaby.subscribe(function (val) {
                    if (self.__subTypeId() == '多胞胎假') {
                        if (Number(val) >= 2) {
                            self.__actualDays(15 * (Number(val) - 1));
                        }
                    }
                });


//              根据开始结束时间获取请假天数 小时数
                self.__startDate.subscribe(function (val) {
                    var condition = {};
                    condition = self.getValues();
                    condition['optType'] = 'calculateDaysAndHours';
                    condition['employeeId'] = self.__employeeId();
                    condition['startDate'] = self.__startDate();
                    condition['endDate'] = self.__endDate();
                    condition['maxDays'] = self.__actualDays();
                    if (dl.isNullOrUndefined(condition['type'])) {
                        self.isType('1');
                        self.errorMsg('*先输入假期类型,再输入开始、结束时间');
                        return;
                    } else {
                        self.isType('0');
                    }
                    if (!dl.isNullOrEmpty(self.__endDate())) {
                        dl.callOperation("EP_MyPersonnelProcessor", '', condition, function (response) {
                            if (response['ResultSet']['status'] >= 0) {
                                self.isType('0');
                                self.errorMsg('');
                                var arr = dl.parseCollection(response);
                                if (!dl.isNullOrEmpty(arr)) {
                                    self.__days(arr[0]['days']);
                                    self.__hours(arr[0]['hours']);
                                }
                            } else {
                                self.isType('1');
                                self.errorMsg(response['ResultSet']['errors']);
                                self.__days(0);
                                self.__hours(0);
                            }
                        });
                    }
                });

                self.__endDate.subscribe(function (val) {
                    var condition = {};
                    condition = self.getValues();
                    condition['optType'] = 'calculateDaysAndHours';
                    condition['startDate'] = self.__startDate();
                    condition['employeeId'] = self.__employeeId();
                    condition['endDate'] = self.__endDate();
                    condition['maxDays'] = self.__actualDays();
                    if (dl.isNullOrUndefined(condition['type'])) {
                        self.isType('1');
                        self.errorMsg('*先输入假期类型,再输入开始、结束时间');
                        return;
                    } else {
                        self.isType('0');
                    }
                    ;
                    if (!dl.isNullOrEmpty(self.__startDate())) {
                        dl.callOperation("EP_MyPersonnelProcessor", '', condition, function (response) {
                            if (response['ResultSet']['status'] >= 0) {
                                self.isType('0');
                                self.errorMsg('');
                                var arr = dl.parseCollection(response);
                                if (!dl.isNullOrEmpty(arr)) {
                                    self.__days(arr[0]['days']);
                                    self.__hours(arr[0]['hours']);
                                }
                            } else {
                                self.isType('1');
                                self.errorMsg(response['ResultSet']['errors']);
                                self.__days(0);
                                self.__hours(0);
                            }
                        })
                    }
                    ;
                });

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    //                   通过id  获取公司所在地
                    var condition = {
                        employeeId: self.__employeeId(),
                        optType: 'getCompanyAndArea'
                    };
                    dl.callOperation("EP_GetUserInfoById", '', condition, function (response) {
                        if (Number(response['ResultSet']['status']) >= 0) {

                            var data = dl.parseCollection(response);
                            condition['optType'] = 'getLeaveTypes';
                            condition['areaId'] = data[0]['areaId'];
//                            公司所在地
                            self.__companyProvince(data[0]['areaId']);
                            dl.setOptionsFromQuery('EP_MyPersonnelProcessor', condition, function (response) {
                                var idArr = [];
//                                假期类型去重
                                for (var i = 0; i < response.length; i++) {
                                    var leaveTypeId = response[i]['leaveTypeId'];
                                    if (idArr.indexOf(leaveTypeId) == -1) {
                                        idArr.push(leaveTypeId);
                                        self.holidayTypes.push(response[i]);
                                    }
                                }
                                return self.holidayTypes();
                            });

                            var condition1 = {
                                employeeId: dl.getEmployeeId(),
                                processTypeId: self.processType
                            };
                            dl.callOperation("NQ_EmployeeProcess", 'find', condition1, self.datareceived1);
                        }

                    });
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }

            return leaveApplyViewModel;
        }
);


