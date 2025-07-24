define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'promise', 'ojs/ojselectcombobox','ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource','ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function myMeetingYearListViewModel(params) {
                var self = this;
                self.viewModelName = 'myMeetingYearListViewModel';
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
                    var pageName = "myMeetingMonthList";
                    if (dl.isNullOrUndefined(pageName))
                        return;
                    self.year = id;
                    dl.pushPageStack({name: 'myMeeting/myMeetingYearList', params: self.parentViewModel, cacheKey: 'myMeeting/myMeetingYearList'});
                    dl.getGlobalModule({name: 'myMeeting/'+pageName, params: self, cacheKey: 'myMeeting/'+pageName});
                    var d = dl.findCurrentDataByAttr(id, "month", self.menuData);
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(id+" 年详情");
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
                     var yearStr;
                     var yearNum;
                     var num = 0;
                      for(var i=1;i<=d.length;i++){
                             yearStr =  dl.dateConverter.format(dl.parseValueFromService( d[i-1].meetTime));
                             yearNum =yearStr.substring(0,4);
                             var index=self.findElem(dataArry,'year',yearNum);
                            if(index===-1) {
                                  var detail = {};
                                  detail.year = yearNum;
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
                        operateEmployeeId: dl.getEmployeeId(),
                        addtionalCondition:'order by meet_time asc'
                    };
                    dl.callOperation("ST_Activity", 'find', condition, self.datareceived);
                };

                self.handleBindingsApplied = function (info) {
                };

                self.handleDetached = function (info) {
                };
            }
            
            return myMeetingYearListViewModel;
        }
);


