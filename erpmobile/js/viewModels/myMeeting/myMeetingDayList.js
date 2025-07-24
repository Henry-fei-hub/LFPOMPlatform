define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function myMeetingDayListViewModel(params) {
                var self = this;
                self.viewModelName = 'myMeetingDayListViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.item = ko.observable("");
                self.menuData = ko.observableArray();
                self.iClicked = function (data, event) {
                    var target = event.currentTarget;
                    var id = target.id;
                    self.activitieId = id;
                    var pageName = "myMeetingDayDetail";
//                    进入我的代办myApproval页面 把myApproval进栈 并且若为财务报销页面把模块替换成reimbursementList页面
//                    保存页面路径
                    dl.pushPageStack({name: 'myMeeting/myMeetingDayList', params: self.parentViewModel, cacheKey: 'myMeeting/myMeetingDayList'});
                    dl.getGlobalModule({name: 'myMeeting/'+pageName, params: self, cacheKey: 'myMeeting/'+pageName});
//                    通过点击我的代办列表里的某一条，获得数据d
                    var d = dl.findCurrentDataByAttr(id, "activitieId", self.menuData);
//                    保存header路径 dl.headerTitle()一个ob变量 d.processTypeName 为下一页header名字
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(dl.dateViewConverter.format(dl.parseValueFromService(d.meetTime)));
                };

                self.datareceived = function (data) {
                    var d = dl.parseCollection(data);
                    if(!dl.isNullOrEmpty(d)){
                        for(var i=0;i<d.length;i++){
                            if(dl.isNullOrUndefined(d[i]['meetTitle'])){
                                d[i]['meetTitle']=' ';
                            }
                        }
                    } 
                    self.menuData = d;
                    self.dataSource(new oj.ArrayTableDataSource(self.menuData, {idAttribute: 'activitieId'}));
                };

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    //获取当前日期的年份
                    var date = new Date();
                    var year=date.getFullYear();
                    var moDetailsData="moDetailsData";
                    //加载当前年月份的数据集
                    var condition = {
                        operateEmployeeId: dl.getEmployeeId(),
                        year: params.year,
                        month:params.month,
                        optType:moDetailsData,
                       addtionalCondition:'order by meet_time asc'
                    };
                    dl.callOperation("EP_GetActivityDetailsProcess", 'find', condition, self.datareceived);
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }
            
            return myMeetingDayListViewModel;
        }
);


