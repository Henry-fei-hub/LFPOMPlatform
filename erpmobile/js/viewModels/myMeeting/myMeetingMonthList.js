define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function myMeetingMonthListViewModel(params) {
                var self = this;
                self.viewModelName = 'myMeetingMonthListViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.item = ko.observable("");
                self.menuData = ko.observableArray();
                self.iClicked = function (data, event) {
//                    财务报销页面 
                    var monthTypes = [1,2, 3, 4, 5, 6, 7, 8, 9,10,11,12];
                    var target = event.currentTarget;
                    var id = target.id;
                    var pageName;
//                     传入的id能在这个数组里找到显示财务报销页面  含有报销编号的页面就显示reimbursementList模块页面
                    if ($.inArray(id, monthTypes)) {
                        pageName = "myMeetingDayList";
                    }
                    if (dl.isNullOrUndefined(pageName))
                        return;
                    self.month = id;
                    self.year = params.year;
                    dl.pushPageStack({name: 'myMeeting/myMeetingMonthList', params: self.parentViewModel, cacheKey: 'myMeeting/myMeetingMonthList'});
                    dl.getGlobalModule({name: 'myMeeting/'+pageName, params: self, cacheKey: 'myMeeting/'+pageName});
                    var d = dl.findCurrentDataByAttr(id, "month", self.menuData);
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(id+" 月详情");
                };
                self.findElem = function (arrayToSearch,attr,val){
                    for (var i=0;i<arrayToSearch.length;i++){
                      if(arrayToSearch[i][attr]==val){
                            return i;
                          }
                        }
                      return -1;
                   };
                
                self.datareceived = function (data) {
                    
                    var d = dl.parseCollection(data);
                    if(!dl.isNullOrEmpty(d)){
                     var dataArry = [];
                     var monthStr;
                     var monthNum;
                     var num = 0;
                      for(var i=1;i<=d.length;i++){
                             monthStr =  dl.dateConverter.format(dl.parseValueFromService( d[i-1].meetTime));
                             monthNum =monthStr.substring(5,7);
                             var index=self.findElem(dataArry,'month',monthNum);
                            if(index===-1) {
                                  var detail = {};
                                  detail.month = monthNum;
                                  detail.name = monthNum+'月';
                                  dataArry[num] = detail;
                                  num++;
                            }
                          
                    }

                    self.menuData = dataArry;
                    self.dataSource(new oj.ArrayTableDataSource(self.menuData));
                    
                    }
                };
                
                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                };

                self.handleAttached = function (info) {
                    
                      var condition = {
                          year : params.year,
                          optType:'moYearDetailsData',
                        operateEmployeeId: dl.getEmployeeId(),
    
                    };
                    dl.callOperation("EP_GetActivityDetailsProcess", 'find', condition, self.datareceived);
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }
            
            return myMeetingMonthListViewModel;
        }
);


