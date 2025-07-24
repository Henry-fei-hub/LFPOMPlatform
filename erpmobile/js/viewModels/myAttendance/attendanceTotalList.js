define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'ojs/ojdatetimepicker', 'ojs/ojselectcombobox', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function attendanceTotalListViewModel(params) {
                var self = this;
                self.viewModelName = 'attendanceTotalListViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.item = ko.observable("");
                self.menuData = ko.observableArray();
                //获取当前日期的年份
                var date = new Date();
                self.startDate = ko.observable(oj.IntlConverterUtils.dateToLocalIso(date));
                self.endDate = ko.observable(oj.IntlConverterUtils.dateToLocalIso(date));
                self.plateId = ko.observableArray();
                self.iClicked = function (data, event) {
                    var target = event.currentTarget;
                    var id = target.id;
                    if(Number(id) === 0) return;
                    self.startDateValue = self.startDate();
                    self.endDateValue = self.endDate();
                    self.plateIdValue = id;
                    var pageName = "attendanceStatus";
//                    进入我的代办myApproval页面 把myApproval进栈 并且若为财务报销页面把模块替换成reimbursementList页面
//                    保存页面路径
                    dl.pushPageStack({name: 'myAttendance/attendanceTotalList', params: self.parentViewModel, cacheKey: 'myAttendance/attendanceTotalList'});
                    dl.getGlobalModule({name: 'myAttendance/'+pageName, params: self, cacheKey: 'myAttendance/'+pageName});
//                    保存header路径 dl.headerTitle()一个ob变量 d.processTypeName 为下一页header名字
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(dl.getLabelByValue('system_dictionary_1',id)+'考勤状态');
                };
                
                self.onClick = function (data, event) {
                    var target = event.currentTarget;
                    var id = target.id;
                    var date = new Date();
                    if(Number(id) === 2){
                        date.setDate(date.getDate()+1); 
                    }else if(Number(id) === 3){
                        date.setDate(date.getDate()+2); 
                    }
                    self.loadTimes = 0;
                    self.startDate(oj.IntlConverterUtils.dateToLocalIso(date));
                    self.endDate(oj.IntlConverterUtils.dateToLocalIso(date));
                    self.reload();
                };
                
                self.plateId.subscribe(function (val) {
                    if(self.loadTimes === 0) return;
                    self.reload();
                });
                
                self.startDate.subscribe(function (val) {
                    if(self.loadTimes === 0) return;
                    self.endDate(self.startDate());
                    self.reload();
                });
                
                self.datareceived = function (data) {
                    var d = dl.parseCollection(data);
                    var len = d.length;
                    if(len > 0){
                        var companyTotalNum = 0;
                        var companyLeaveNum = 0;
                        var companyAbsenceNum = 0;
                        for(var i=0;i<len;i++){
                            var totalNum = d[i]['totalNum'];
                            companyTotalNum += totalNum;
                            var leaveNum = d[i]['leaveNum'];
                            if(dl.isNullOrUndefined(leaveNum)){
                                leaveNum = 0;
                            }
                            companyLeaveNum += leaveNum;
                            var absenceNum = d[i]['absenceNum'];
                            if(dl.isNullOrUndefined(absenceNum)){
                                absenceNum = 0;
                            }
                            companyAbsenceNum += absenceNum;
                            var percent = (totalNum-leaveNum-absenceNum)/totalNum*100;
                            percent = percent.toFixed();
                            d[i]['percent'] = percent+'%';
                            d[i]['name'] = dl.getLabelByValue('system_dictionary_1', d[i]['plateId']);
                        }
                    }
                    var companyPercent = (companyTotalNum-companyLeaveNum-companyAbsenceNum)/companyTotalNum*100;
                    companyPercent = companyPercent.toFixed();
                    var arr=new Object();
                    arr.plateId = 0;
                    arr.totalNum = companyTotalNum;
                    arr.leaveNum = companyLeaveNum;
                    arr.absenceNum = companyAbsenceNum;
                    arr.percent = companyPercent+'%';
                    arr.name = '汇总';
                    d[len] = arr;
                    self.menuData = d;
                    self.dataSource(new oj.ArrayTableDataSource(self.menuData, {idAttribute: 'plateId'}));
                    self.loadTimes++;
                };

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    self.reload();
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
                
                self.loadTimes = 0;
                
                self.reload = function(){
                    //加载当前年月份的数据集
                    var condition = {
                        plateId:dl.isNullOrEmpty(self.plateId()) ? null : self.plateId()[0],
                        startDate: self.startDate(),
                        endDate: self.endDate()
                    };
                    dl.callOperation("NQ_OnLoadAttendanceTotal", 'find', condition, self.datareceived);
                };
            }
            
            return attendanceTotalListViewModel;
        }
);


