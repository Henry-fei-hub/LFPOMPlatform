
define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient','dl/msgbox', 'ojs/ojknockout', 'promise','ojs/ojselectcombobox', 'ojs/ojnavigationlist', 'ojs/ojbutton',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojdatetimepicker', 'ojs/ojcheckboxset'],
        function (oj, ko, $, dl,sc) {

            function addMyMeetingViewModel(params) {
                var self = this;
                self.viewModelName = 'addMyMeetingViewModel';
                self.specialHeaderTitle=params.specialHeaderTitle;
                self.parentViewModel = params;
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.menuData = ko.observableArray();
                self.dataSource = ko.observable();
                self.errorMessage= ko.observable();
                self.__operateEmployeeId = ko.observable(dl.getEmployeeId());
                self.__customerName = ko.observable();
                self.__projectName = ko.observable();
                self.__meetType = ko.observable();
                self.__meetTime = ko.observable();
                self.__meetAddress = ko.observable();
                self.__meetTitle = ko.observable();
                self.__meetTarget = ko.observable();
                self.__contactName = ko.observable();
                self.__theirRequire = ko.observable();
                self.__theirEmployees = ko.observable();
                self.__ourEmployees = ko.observable();
                self.__remark = ko.observable();
                self.__operateTime = ko.observable(new Date());
                var employeeNamess='';
                var meet;
                self.checkData = function (values) {
                    if (dl.isNullOrEmpty(values)) {
                        self.errorMessage('♥提示:数据异常不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.__customerName._latestValue)) {
                        self.errorMessage('♥提示:客户名称不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.__projectName._latestValue)) {
                        self.errorMessage('♥提示:项目名称不可为空');
                        return false;
                    }
                    if (dl.isNullOrEmpty(values.__meetType._latestValue)) {
                        self.errorMessage('♥提示:会议类型不可为空');
                        return false;
                    }
                     if (dl.isNullOrEmpty(values.__meetTime._latestValue)) {
                        self.errorMessage('♥提示:会议时间不可为空');
                        return false;
                    }
//                    if (dl.isNullOrEmpty(values.__meetAddress._latestValue)) {
//                        self.errorMessage('♥提示:会议地址不可为空');
//                        return false;
//                    }
//                    if (dl.isNullOrEmpty(values.__meetTitle._latestValue)) {
//                        self.errorMessage('♥提示:会议主题不可为空');
//                        return false;
//                    }
//                    if (dl.isNullOrEmpty(values.__meetTarget._latestValue)) {
//                        self.errorMessage('♥提示:会议目标不可为空');
//                        return false;
//                    }
//                    if (dl.isNullOrEmpty(values.__contactName._latestValue)) {
//                        self.errorMessage('♥提示:联系人不可为空');
//                        return false;
//                    }
//                    if (dl.isNullOrEmpty(values.__theirRequire._latestValue)) {
//                        self.errorMessage('♥提示:甲方要求不可为空');
//                        return false;
//                    }
//                    if (dl.isNullOrEmpty(values.__theirEmployees._latestValue)) {
//                        self.errorMessage('♥提示:甲方出席人员不可为空');
//                        return false;
//                    }
                    if (dl.isNullOrEmpty(values.__ourEmployees._latestValue)) {
                        self.errorMessage('♥提示:我方出席人员不可为空');
                        return false;
                    }
                    return true;
                };
               // 提交按钮   
                self.submitClick = function (data, event) {
                    if(!self.checkData(self)){
                         sc.alert( self.errorMessage._latestValue);
                         return;
                    }
                    var emploeesStr='';
                    var ourEmployeeId = self.__ourEmployees._latestValue;
                   if(!dl.isNullOrEmpty(ourEmployeeId)){
                         for(i=0;i<ourEmployeeId.length;i++){
                             if(i+1==ourEmployeeId.length){
                                emploeesStr= emploeesStr+ourEmployeeId[i];
                             }else{
                                emploeesStr= emploeesStr+ourEmployeeId[i]+","; 
                             }
                              
                         }
                        var condition ={
                             addtionalCondition:" employee_id in ("+emploeesStr+")"
                        };
                       dl.callOperation("ST_Employee", 'find', condition, self.datareceived);
                   }
              

                };    
                
                self.saveDate = function(data) {
                    var date = new Date();
                    var time = date.getTime();
                       var paramData = {
                            operateEmployeeId : dl.getEmployeeId(),
                            customerName : self.__customerName._latestValue, 
                            projectName : self.__projectName._latestValue, 
                            meetType : meet,
                            meetTime: self.__meetTime._latestValue,
                            meetAddress : self.__meetAddress._latestValue,
                            meetTitle  : self.__meetTitle._latestValue,
                            meetTarget:  self.__meetTarget._latestValue, 
                            contactName : self.__contactName._latestValue,
                            theirRequire :self.__theirRequire._latestValue,
                            theirEmployees : self.__theirEmployees._latestValue,
                            ourEmployees : employeeNamess,
                            remark : self.__remark._latestValue,
                            operateTime : time
                  };
                         
                         
                      dl.callOperation("ST_Activity", 'save', paramData, self.saveCallback);
                }
                
                self.datareceived = function (data) {
                    var d = dl.parseCollection(data);
                    if(!dl.isNullOrEmpty(d)){
                    var employeeNames='';
                      for(var i=0;i<d.length;i++){
                            if(i+1==d.length){
                                employeeNames= employeeNames+d[i]['employeeName'];
                             }else{
                                employeeNames= employeeNames+d[i]['employeeName']+',';
                             }
                           
                    }
                    if(!dl.isNullOrEmpty(self.__meetType._latestValue)){
                        meet = self.__meetType._latestValue[0];
                    }
                     
                    employeeNamess = employeeNames;                   
                    }
                    self.saveDate();
                };
                
                 //保存后的方法
               self.saveCallback = function (data) {
                    if (data.ResultSet.status >= 0) {
                        sc.alert('添加成功',self.cancleClick);
                    } else {
                        alert(data.ResultSet.errors);
                    }
                };
                self.cancleClick = function (data, event) {
                    self.rebackToClick();
                };
                
                self.rebackToClick = function (event, ui) {
                    dl.getGlobalModule(dl.popPageStack());
                    dl.headerTitle(dl.popHeader());
                };
                
   
                
                self.getDataTitle = function (data) {
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
            return addMyMeetingViewModel;
        }
);


