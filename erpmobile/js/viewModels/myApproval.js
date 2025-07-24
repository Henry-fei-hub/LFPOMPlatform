define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/msgbox', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist', 'ojs/ojarraytabledatasource', 'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource'],
        function (oj, ko, $, dl, sc) {
            function myApprovalViewModel(params) {
                var self = this;
                self.viewModelName = 'myApprovalViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.item = ko.observable("");
                self.isNode = ko.observable('0');

                self.iClicked = function (data, event) {
//                    财务报销页面 
                    var financeTypes = ['2', '3', '4', '5', '6', '7', '8', '9', '52'];
                    //请假申请
                    var leaveTypes = ['13'];
                    //非项目出差,项目出差申请
                    var travelTypes = ['14', '18'];
                    //打卡申请
                    var fillcheckTypes = ['15'];
                    //外出申请
                    var stayawayTypes = ['16'];
                    //加班申请
                    var overtimeTypes = ['17'];
                    //出差更改行程申请  出差延期申请
                    var travelChangeTypes = ['19', '20'];
                    //项目派驻申请
                    var projectAccreditTypes = ['21'];
                    //入职申请
                    var entryTypes = ['24'];
                    //离职申请
//                    var quitTypes = ['25'];
                    //转岗申请
                    var transferTypes = ['26'];
                    //确认函申请 27
                    var confirmationTypes = ['27'];
                    //员工还款申请
                    var repayMoneyTypes = ['28'];
                    //转正申请  暂时隐藏
//                    var becomeFormalStaffTypes = ['29'];
                    //调薪申请
                    var SalaryAdjustTypes = ['30'];
                    //物品领用申请
                    var goodsTypes = ['31'];
                    //用车申请申请
                    var carTypes = ['33'];
                    //名片申请申请
                    var businessCardTypes = ['34'];
//                    //刻章申请
//                    var stampCarvingTypes = ['35'];
                    //采购申请
                    var purchaseTypes = ['36'];
                    //薪资发放申请
                    var salaryReportTypes = ['37'];
                    //成本调节
                    var costAdjustmentTypes = ['39'];
                    //网络权限申请
//                    var networkAuthorityTypes = ['40'];
                    //外部公司还款申请
                    var outsideCompanyRepaymentsTypes = ['41'];
                    //项目报备申请 隐藏
//                    var preProjectsTypes = ['42'];
//                    //前期项目立项申请   隐藏
//                    var bePreProjectsTypes = ['43'];
                    //前期项目关闭申请
                    var closePreProjectsTypes = ['44'];
                    //供应商入库
//                         薪酬模块没用 
                    var SupplierComeInTypes = ['53'];
                    //盖章申请
//                    var SealTypes = ['71'];
                    //落标申请
                    var failInAtenderTypes = ['73'];
                    //  报价单审核申请
                    var qutQuotationTypes = ['75'];
//                    可分配阶段申请
                    var projectStagesProcessTypes = ['76'];
//                   我的出图
                    var outputDrawingTypes = ['78'];
//                     团队组建申请
                    var projectEmployeeProcessTypes = ['79'];
//                      经费结算申请
                    var projectSettlementProcessTypes = ['80'];
//                    配合申请
                    var cooperateTypes = ['81'];
//                      结算申请
                    var settlementTypes = ['82'];
//                      我的工时
                    var workTimeTypes = ['84'];
                    var target = event.currentTarget;
                    var id = target.id;
                    var pageName;
//                  传入的id能在这个数组里找到页面 
                    if ($.inArray(id, financeTypes) !== -1) {
                        pageName = "reimbursement/reimbursementList";
                    } else if ($.inArray(id, leaveTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, travelTypes) !== -1) {
//                        1为activityType=1待办
                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, fillcheckTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, stayawayTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, overtimeTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, travelChangeTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, projectAccreditTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, entryTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, transferTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
//                    } else if ($.inArray(id, quitTypes) !== -1) {
//                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, confirmationTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, repayMoneyTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
//                    } else if ($.inArray(id, becomeFormalStaffTypes) !== -1) {
//                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, costAdjustmentTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, SalaryAdjustTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, goodsTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, carTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, businessCardTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
//                    } else if ($.inArray(id, stampCarvingTypes) !== -1) {
//                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, purchaseTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, salaryReportTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
//                    } else if ($.inArray(id, networkAuthorityTypes) !== -1) {
//                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, outsideCompanyRepaymentsTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
//                    } else if ($.inArray(id, preProjectsTypes) !== -1) {
//                        pageName = dl.getProcessPageName(id, 1);
//                    } else if ($.inArray(id, bePreProjectsTypes) !== -1) {
//                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, closePreProjectsTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, SupplierComeInTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
//                    } else if ($.inArray(id, SealTypes) !== -1) {
//                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, failInAtenderTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, qutQuotationTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, projectStagesProcessTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, outputDrawingTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, projectEmployeeProcessTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, projectSettlementProcessTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, cooperateTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, settlementTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, workTimeTypes) !== -1) {
                        pageName = dl.getProcessPageName(id, 1);
                    }  else {
                        sc.alert("此流程手机端不支持审批，请移至电脑审批。");
                    }
                    
                    if (dl.isNullOrUndefined(pageName)) {
                        return;
                    }

                    self.processType = id;
                    //设置页面处理类型:1:待办;2:知会
                    self.handelType = 1;
//                    进入我的代办myApproval页面 把myApproval进栈
//                    保存页面路径   dl.getGlobalModule有cacheKey 会导致调至的列表页面走缓存 数据不会变 
                    dl.pushPageStack({name: 'myApproval', params: self.parentViewModel});
                    dl.getGlobalModule({name: pageName, params: self});
//                    通过点击我的代办列表里的某一条，获得数据d
                    var d = dl.findCurrentDataByAttr(id, "processType", self.menuData);
                    self.rowData = d;
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(dl.getLabelByValue('system_process_types', d.processType));
                }


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
                        if (self.menuData[i].activityType == 4) {
//                            待审 4
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
                dl.haveDoneArr = [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 33, 34, 35, 36, 37, 39, 40, 41, 42, 43, 44, 45, 46, 51, 52, 53, 56, 58, 59, 60, 61, 62, 63, 64, 71, 72, 73, 75, 76, 77, 78, 79, 80, 81, 82,84];
//                  41外部公司还款, 45 暂时隐藏
                self.getDataTitle = function (data) {
                };




                self.handleActivated = function (info) {
                    // Implement if needed
                };


                self.handleAttached = function (info) {
//                    12renshi  32xz
                    var params = {currentPage: 0,
                        pageLines: 1,
                        optType: 'onLoadFLowProcessTypeNum',
//                        parentProcessTypeId: 12 || 1 || 32||38,
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
            return myApprovalViewModel;
        }
);


