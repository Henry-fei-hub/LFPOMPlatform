define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist', 'ojs/ojjsontreedatasource'],
        function (oj, ko, $, dl) {
            function homeViewModel(params) {
                var self = this;
                self.viewModelName = 'homeViewModel';
//                数据是来自父模块  把父模块的数据传进来
                self.parentViewModel = params.data;
                self.dataSource = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("home");
                self.isHighEmp = false;

                self.itemClicked = function (data, event) {
                    var target = event.currentTarget;
                    var id = target.id;
//                    退出
                    if(data.title.indexOf('退出登录')>=0){
                         dl.mobileLogout();
                    }
//                    由id在 self.menuData(全部的数据)里找对应数据d是
                    var d = dl.findMenuDataByID(id, self.menuData);
                    if (dl.isNullOrUndefined(d))
                        return;
//                    功能页面 d.executePageName 
                    if (!d.executePageName)
                        return;
//                    不让页面有缓存
                    if (d.executePageName === 'personnel/leave/leaveApply'||d.executePageName === 'personnel/stayaway/stayawayApply'|| d.executePageName === 'personnel/overtime/overtimeApply'
                            || d.executePageName === 'operation_processor/preProjects/preProjectsApply'|| d.executePageName === 'personnel/travel/BusinessProjectTripApply'
                            || d.executePageName === 'personnel/travel/BusinessTripApply'|| d.executePageName === 'administration/car/carApply'|| d.executePageName === 'operation_processor/integralConfirmation/projectList'
                             || d.executePageName === 'personnel/workTime/workTimeApply' ) {
                        if(d.executePageName === 'operation_processor/preProjects/preProjectsApply'){
                            self.pageType = 1;
                        }
                        dl.getGlobalModule({name: d.executePageName, params: self});
                    } else if(d.executePageName === 'myAttendance/attendanceTotalList'){
                        if(self.isHighEmp){
                            dl.getGlobalModule({name: d.executePageName, params: self, cacheKey: d.executePageName});
                        }else{
                            return;
                        }
                    }else {
                        
                        dl.getGlobalModule({name: d.executePageName, params: self, cacheKey: d.executePageName});
                    }

                    dl.pushPageStack({name: 'home', params: params, cacheKey: 'home'});
//                    阻止事件向上传播 点一次触发3次
                    event.preventDefault();
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(d.title);
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
                self.approvalCountNum = ko.observable('');
                self.attentionCountNum = ko.observable('');
                self.doing = ko.observable(0);
                self.failToDo = ko.observable(0);
                self.haveDone = ko.observable(0);
                self.myExamine = ko.observable(0);
                self.myHaveRead = ko.observable(0);
                self.datareceived = function (data) {
                    self.menuData = data;
                    for (var i = 0; i < self.menuData.length; i++) {
//                        给退出登录改样式
                        if(data[i].title.indexOf('退出登录')>=0){
                         data[i].attr.width = '100%';
                         data[i].attr.display = 'block';
                         data[i].attr.textalign = 'center';
                        }
                    }
                    self.dataSource(new oj.JsonTreeDataSource(self.menuData));

                };
//                数据来源不同 不同接口
//                countNum属性  代办总量
                self.datareceived1 = function (data) {
                    var dataArr = dl.parseCollection(data);
                    console.log(dataArr);
                    for (var i = 0; i < dataArr.length; i++) {
                        var type = Number(dataArr[i]['type']);
                        var num = dataArr[i]['needDeal'];
                        switch (type) {
                            case 1: //我的待办
                                self.approvalCountNum(num);
                                break;
                            case 2: //我的知会
                                self.attentionCountNum(num);
                                break;
                            case 3: //我的申请--》正在进行中
                                self.doing(num);
                                break;
                            case 4: //我的申请--》已完成
                                self.haveDone(num);
                                break;
                            case 5: //我的申请--》已被驳回
                                self.failToDo(num);
                                break;
                            case 6://我的已办
                                self.myExamine(num);
                                break;
                            case 7://我的已阅
                                self.myHaveRead(num);
                                break;
                        }

                    }
                };

                self.returnCount = function (rowData) {
                    var pageName = rowData['executePageName'];
                    var functionCode = rowData['functionCode'];
                    var num = '';
                    if (!dl.isNullOrUndefined(pageName)) {
                        switch (pageName) {
                            case 'myApproval':
                                if (self.approvalCountNum() !== 0) {
                                    num = self.approvalCountNum();
                                }
                                break;
                            case 'myAttentions':
                                if (self.attentionCountNum() !== 0) {
                                    num = self.attentionCountNum();
                                }
                                break;
                            case 'doing':
                                if (self.doing() !== 0) {
                                    num = self.doing();
                                }
                                break;
//                                驳回和已完成合并
                            case 'haveDone':
                                if (self.haveDone() !== 0) {
                                    num = self.haveDone() + self.failToDo();
                                }
                                break;
//                            case 'failToDo':
//                                if (self.failToDo() !== 0) {
//                                    num = self.failToDo();
//                                }
//                                break;
                            case 'myExamine':
                                if (self.myExamine() !== 0) {
                                    num = self.myExamine();
                                }
                                break;
                            case 'myHaveRead':
                                if (self.myHaveRead() !== 0) {
                                    num = self.myHaveRead();
                                }
                                break;
                        }
                    }
                    if (!dl.isNullOrUndefined(functionCode) && dl.isNullOrEmpty(num)) {
                        switch (functionCode) {
                            case 'MB-30000-000':
                                if (self.doing() + self.haveDone() + self.failToDo() !== 0) {
                                    num = self.doing() + self.haveDone() + self.failToDo();
                                }
                                break;
                        }
                    }
                    return num;
                };
                self.returnClass = function (rowData) {
                    var pageName = rowData['executePageName'];
                    var functionCode = rowData['functionCode'];
                    var className = '';
                    if (!dl.isNullOrUndefined(pageName)) {
                        if ((pageName === 'myApproval' && self.approvalCountNum() !== 0) || (pageName === 'myAttentions' && self.attentionCountNum() !== 0)) {
                            className = 'homeRed';
                        }else if ((pageName === 'myExamine' && self.myExamine() !== 0)  || (pageName === 'myHaveRead' && self.myHaveRead() !== 0)) {
                            return  'homeBlue';
                        } else if (pageName === 'doing' && self.doing() !== 0 || pageName === 'haveDone' && self.haveDone() !== 0 || pageName === 'failToDo' && self.failToDo() !== 0) {
                            return  'homeRed2';
                        }
                    }
                    if (!dl.isNullOrUndefined(functionCode) && dl.isNullOrEmpty(className)) {
                        if (functionCode === 'MB-30000-000') {
                            if (self.doing() + self.haveDone() + self.failToDo() !== 0) {
                                className = 'homeRed';
                            }
                        }
                    }
                    return className;
                };
//                给没有功能页面的加上>
                self.returnOtherClass = function (pageName) {
                    if (!dl.isNullOrUndefined(pageName)) {
                        if (pageName === 'myApproval' || pageName === 'myExamine' || pageName === 'myAttentions' || pageName === 'myHaveRead' || pageName === 'myselfInfo/myselfInfo'
                                || pageName === 'myIntegral/myIntegral' || pageName === 'myAttendance/myAttendance'
                                || pageName === 'doing' || pageName === 'haveDone' || pageName === 'failToDo'
                                || pageName === 'personnel/leave/leaveApply' || pageName === 'personnel/fillcheck/fillcheckApply'|| pageName === 'personnel/overtime/overtimeApply'|| pageName === 'personnel/stayaway/stayawayApply'
                                || pageName === 'operation_processor/preProjects/preProjectsApply'|| pageName === 'myMeeting/myMeeting'|| pageName === 'goodspick/goodspickApply'
                                || pageName === 'market/preProject'|| pageName === 'personnel/travel/BusinessProjectTripApply'|| pageName === 'personnel/travel/BusinessTripApply'
                                || pageName === 'management/alltraining'|| pageName === 'management/mytraining' || pageName === 'administration/car/carApply'|| pageName === 'operation_processor/integralConfirmation/projectList'
                                 || pageName === 'personnel/workTime/workTimeApply'  ) {
                            return  'oj-component-icon oj-clickable-icon-nocontext oj-navigationlist-collapse-icon';
                        }
                    }
                    return '';
                };
                
                self.datareceived2 = function (data) {
                    var d = dl.parseCollection(data);
                    var len = d.length;
                    if(len > 0){//说明是高管
                        self.isHighEmp = true;
                    }
                };

                self.getDataTitle = function (data) {
                };
//                   访问接口拿到全部数据
                dl.callOperation("EP_GetFunctionTree", '', {}, self.datareceived);

                self.handleActivated = function (info) {
                    var condition = {
                        employeeId: dl.getEmployeeId()
                    };
//                访问接口拿到代办总量    condition传入用户信息到后台获取数据
                    dl.callOperation("NQ_MyApprovalSummary", 'find', condition, self.datareceived1);
                    //加载这个人员是否是高管角色
                    var condition = {
                        employeeId: dl.getEmployeeId(),
                        roleId:1
                    };
                    dl.callOperation("ST_EmployeeRole", 'find', condition, self.datareceived2);
                };


                self.handleAttached = function (info) {

                    // Implement if needed
                };



                self.handleBindingsApplied = function (info) {

                    // Implement if needed
                };


                self.handleDetached = function (info) {
                    // Implement if needed
                };
            }

            return homeViewModel;
        }
);
