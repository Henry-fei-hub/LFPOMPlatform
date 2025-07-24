define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient',  'dl/msgbox','dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl ,sc) {
            function failToDoViewModel(params) {
                var self = this;
                self.viewModelName = 'failToDoViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.item = ko.observable("");
                self.isNode = ko.observable('0');

                self.iClicked = function (data, event) {
                    //   财务报销页面  
                    var reimbursementTypes = ['2', '3', '4', '5', '6', '7', '8', '9'];
                    //     行政页面数组   物品领用申请、用车申请、名片申请、刻章申请、采购申请、薪资发放申请
                    //     定义人事页面数组   请假、非项目出差,项目出差申请、打卡申请、外出申请、加班申请、项目派驻申请、离职、转岗   员工还款 网络权限 外部公司还款、调薪、工资异常   40网络权限隐藏'25', '29',隐藏
                    var totalTypes = ['13', '14', '15', '16', '17', '18', '19', '20', '21',  '26', '27','28', '30', '31', '33', '34', '36', '37',  '41'];
                    //项目报备 /前期项目关闭 '42','43',隐藏
                    var operation_processorTypes = ['44'];
                    ////入职申请
                    var entryTypes = ['24'];
                        //成本调节
                    var costAdjustmentTypes = ['39'];  
                    //预算单立项
                    var budgetManagementTypes = ['52'];
                                      //供应商入库
                    var SupplierComeInTypes = ['53'];
                                      //落标申请
                    var failInAtenderTypes = ['73'];
//                      我的工时
                    var workTimeTypes = ['84'];
                    var target = event.currentTarget;
                    var id = target.id;
                    var pageName;
//                    从我的申请里进行中进入 点击不同实现跳转
                    // 传入的id能在这个数组里找到页面  
                    if ($.inArray(id, totalTypes) !== -1) {
                        pageName = "administration/myApplyadministrationList";
                    } else if ($.inArray(id, reimbursementTypes) !== -1) {
                        pageName = "reimbursement/myApplyReimbursementList";
                    } else if ($.inArray(id, operation_processorTypes) !== -1) {
                        pageName = "operation_processor/myApplyOperationList";
                    } else if ($.inArray(id, entryTypes) !== -1) {
                        pageName = "personnel/entry/myApplyEntryList";
                    } else if ($.inArray(id, costAdjustmentTypes) !== -1) {
                        pageName = "operation_processor/costAdjustment/myApplycostAdjustmentList";
                    } else if ($.inArray(id, budgetManagementTypes) !== -1) {
                        pageName = "reimbursement/myApplyBudgetManagementList";
                    }else if ($.inArray(id, SupplierComeInTypes) !== -1) {
                        pageName = "operation_processor/SupplierComeIn/myApplySupplierComeInList";
                    }else if ($.inArray(id, failInAtenderTypes) !== -1) {
                        pageName = "operation_processor/failInAtender/myApplyFailInAtenderList";
                    } else if ($.inArray(id, workTimeTypes) !== -1) {
                       pageName = "personnel/workTime/myApplyWorkTimeList";
                    }else {
                        sc.alert("此流程手机端不支持审批，请移至电脑审批。");
                    }


                    if (dl.isNullOrUndefined(pageName)) {
                        return;
                    }

                    self.processType = id;
//                    通过点击我的代办列表里的某一条，获得数据d
                    var d = dl.findCurrentDataByAttr(id, "processType", self.menuData);
                    d['activityType'] = 2;
                    d['status'] = 5;
                    self.rowData = d;
                    //                    保存页面路径
                    dl.pushPageStack({name: 'failToDo', params: self.parentViewModel, cacheKey: 'failToDo'});
                    dl.getGlobalModule({name: pageName, params: self});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(dl.getLabelByValue('system_process_types', d.processType));
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

                self.datareceived = function (data) {
                    self.menuData = data.ResultSet.Result;
                    var newData = [];
                    for (var i = 0; i < self.menuData.length; i++) {
                        if (self.menuData[i].activityType == 2) {
//                           2 驳回
                            var typeId = self.menuData[i].processType;
                            if ($.inArray(typeId, dl.haveDoneArr) !== -1) {
                                newData.push(self.menuData[i]);
                            }
                        }
                    }
                    self.menuData = newData;
                    self.dataSource(new oj.ArrayTableDataSource(self.menuData));
                };


//             已做审批页面的数组  记得做一个页面加上这个id
                dl.haveDoneArr = [2, 3, 4, 5, 6, 7, 8, 9, 10,11,13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 33, 34, 35, 36, 37, 39, 40, 41, 42, 43, 44, 45,46,51, 52, 53, 56, 58, 59, 60, 61, 62, 63, 64, 71, 72, 73, 75, 76, 77, 78, 79, 80, 81, 82 ,84];
//                  41外部公司还款 暂时隐藏 45,
                self.getDataTitle = function (data) {
                };




                self.handleActivated = function (info) {
                    // Implement if needed
                };


                self.handleAttached = function (info) {
                    var params = {
                        currentPage: 0,
                        pageLines: 1,
                        optType: 'onLoadFLowProcessTypeNum',
                        parentProcessTypeId: 12,
                        employeeId: dl.getEmployeeId()
                    };
                    dl.callOperation("EP_OnWrokflowProcess", 'find', params, self.datareceived);
                };



                self.handleBindingsApplied = function (info) {

                    // Implement if needed
                };


                self.handleDetached = function (info) {
                    // Implement if needed
                };
            }

            return failToDoViewModel;
        }
);


