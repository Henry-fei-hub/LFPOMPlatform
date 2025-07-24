define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient','dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl) {
            function myApprovalViewModel(params) {
                var self = this;
                self.viewModelName = 'myApprovalViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.item = ko.observable("");
                
                        
                self.iClicked = function (data, event) { 
//                    财务报销页面 
                    var financeTypes = ['2','3','4','5','6','7','8','9'];
                    //请假申请
                    var leaveTypes = ['13'];
                    //非项目出差,项目出差申请
                    var travelTypes = ['14','18'];
                    //打卡申请
                    var fillcheckTypes = ['15'];
                    //外出申请
                    var stayawayTypes = ['16'];
                    var target = event.currentTarget;
                    var id = target.id;
                    var pageName;
//                     传入的id能在这个数组里找到显示财务报销页面  含有报销编号的页面就显示reimbursementList模块页面
                    if ($.inArray(id, financeTypes) !== -1) {
                        pageName = "reimbursement/reimbursementList";
                    }else if($.inArray(id, leaveTypes) !== -1){
                        pageName = "personnel/leave/leaveApplyList";
                    }else if($.inArray(id, travelTypes) !== -1){
                        pageName = dl.getProcessPageName(id,0);
                    }else if($.inArray(id, fillcheckTypes) !== -1){
                        pageName = dl.getProcessPageName(id,0);
                    }else if($.inArray(id, stayawayTypes) !== -1){
                        pageName = dl.getProcessPageName(id,0);
                    }
                    if (dl.isNullOrUndefined(pageName))
                        return;
                    self.processType = id;
//                    进入我的代办myApproval页面 把myApproval进栈 并且若为财务报销页面把模块替换成reimbursementList页面
//                    保存页面路径
                    dl.pushPageStack({name: 'myApproval', params: self.parentViewModel, cacheKey: 'myApproval'});
                    dl.getGlobalModule({name: pageName, params: self, cacheKey: pageName});
//                    通过点击我的代办列表里的某一条，获得数据d
                    var d = dl.findCurrentDataByAttr(id, "processType", self.menuData);
//                    保存header路径 dl.headerTitle()一个ob变量 d.processTypeName 为下一页header名字
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(d.processTypeName);

                };


                self.processString = function (ss) {
                    var s = "";
                    for (var i = 0; i < ss.length; i++) {
                        if (ss[i] === '+')
                            s += ' ';
                        else
                            s += ss[i];
                    }
                    return s;
                };


                ;
                self.datareceived = function (data) {
                    self.menuData = data.ResultSet.Result;
                    self.dataSource(new oj.ArrayTableDataSource(self.menuData));

            
                };


                self.getDataTitle = function (data) {
                };




                self.handleActivated = function (info) {
                    // Implement if needed
                };


                self.handleAttached = function (info) {
                    var params = {
                        currentPage: 0,
                        pageLines: 1,
                        employeeId: dl.getEmployeeId()
                    };

                    dl.callOperation("NQ_MyApprovalProcessDetail", 'find', params, self.datareceived);
                };



                self.handleBindingsApplied = function (info) {

                    // Implement if needed
                };


                self.handleDetached = function (info) {
                    // Implement if needed
                };
            }

            return myApprovalViewModel;
        }
);


