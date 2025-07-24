define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient', 'dl/msgbox', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl, sc) {
            function myHaveReadViewModel(params) {
                var self = this;
                self.viewModelName = 'myHaveReadViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.selectedItem = ko.observable("");
                self.item = ko.observable("");

                self.iClicked = function (data, event) {
//                    财务报销页面 
                    var financeTypes = ['2', '3', '4', '5', '6', '7', '8', '9'];
                    //定义人事页面数组   请假
                    var leaveTypes = ['13'];
                    //非项目出差,项目出差申请
                    var travelTypes = ['14', '18'];
                    //打卡申请
                    var fillcheckTypes = ['15'];
                    //外出申请
                    var stayawayTypes = ['16'];
                    //加班申请
                    var overtimeTypes = ['17'];
                    //出差更改行程申请 出差延期申请
                    var travelChangeTypes = ['19', '20'];
                    //项目派驻申请
                    var projectAccreditTypes = ['21'];
                    //入职
                    var entryTypes = ['24'];
                    //定义人事离职页面数组
//                    var personnelQuitTypes = ['25'];
                    //转岗
                    var transferTypes = ['26'];
                    //确认函申请 27
                    var confirmationTypes = ['27'];
                    //员工还款
                    var repayMoneyTypes = ['28'];
                    //转正
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
                    // 项目报备申请
//                    var preProjectsTypes = ['42'];
//                    //前期项目立项申请
//                    var bePreProjectsTypes = ['43'];
                    //前期项目关闭申请
                    var closePreProjectsTypes = ['44'];
                    //工资异常申请
//                    var abnormalWagesTypes = ['45'];
                    //预算单立项 
                    var budgetManagementTypes = ['52'];
                    //供应商入库
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
                    var target = event.currentTarget;
                    var id = target.id;
                    var pageName;

//                    从知会页面进入的列表页面要和代办的区分 
                    // 传入的id能在这个数组里找到页面  
                    if ($.inArray(id, financeTypes) !== -1) {
                        pageName = "reimbursement/myAttentionsReimbursementList";
                    } else if ($.inArray(id, leaveTypes) !== -1) {
                        pageName = "personnel/leave/leaveApplyAttentionList";
//                    } else if ($.inArray(id, personnelQuitTypes) !== -1) {
//                        pageName = "personnel/quit/quitApplyAttentionList";
                    } else if ($.inArray(id, travelTypes) !== -1) {
                        pageName = "personnel/travel/travelApplyAttentionList";
                    } else if ($.inArray(id, fillcheckTypes) !== -1) {
                        pageName = "personnel/fillcheck/fillcheckApplyAttentionList";
                    } else if ($.inArray(id, stayawayTypes) !== -1) {
                        pageName = "personnel/stayaway/stayawayApplyAttentionList";
                    } else if ($.inArray(id, overtimeTypes) !== -1) {
                        pageName = "personnel/overtime/overtimeApplyAttentionList";
                    } else if ($.inArray(id, projectAccreditTypes) !== -1) {
                        pageName = "personnel/projectAccredit/projectAccreditApplyAttentionList";
                    } else if ($.inArray(id, entryTypes) !== -1) {
                        pageName = "personnel/entry/entryApplyAttentionList";
                    } else if ($.inArray(id, transferTypes) !== -1) {
                        pageName = "personnel/transfer/transferApplyAttentionList";
//                    } else if ($.inArray(id, confirmationTypes) !== -1) {
//                        pageName = "operation_processor/confirmation/confirmationApplyAttentionList";
                    } else if ($.inArray(id, repayMoneyTypes) !== -1) {
                        pageName = "reimbursement/repayMoneyApplyAttentionList";
//                    } else if ($.inArray(id, becomeFormalStaffTypes) !== -1) {
//                        pageName = "personnel/becomeFormalStaff/becomeFormalStaffApplyAttentionList";
                    } else if ($.inArray(id, goodsTypes) !== -1) {
                        pageName = "administration/goods/goodsApplyAttentionList";
                    } else if ($.inArray(id, SalaryAdjustTypes) !== -1) {
                        pageName = "administration/SalaryAdjust/SalaryAdjustApplyAttentionList";
                    } else if ($.inArray(id, carTypes) !== -1) {
                        pageName = "administration/car/carApplyAttentionList";
                    } else if ($.inArray(id, businessCardTypes) !== -1) {
                        pageName = "administration/businessCard/businessCardApplyAttentionList";
//                    } else if ($.inArray(id, stampCarvingTypes) !== -1) {
//                        pageName = "administration/stampCarving/stampCarvingApplyAttentionList";
                    } else if ($.inArray(id, purchaseTypes) !== -1) {
                        pageName = "administration/purchase/purchaseApplyAttentionList";
                    } else if ($.inArray(id, salaryReportTypes) !== -1) {
                        pageName = "administration/salaryReport/salaryReportApplyAttentionList";
                    } else if ($.inArray(id, costAdjustmentTypes) !== -1) {
                        pageName = "operation_processor/costAdjustment/costAdjustmentApplyAttentionList";
                    } else if ($.inArray(id, travelChangeTypes) !== -1) {
                        pageName = "personnel/travelChange/travelChangeApplyAttentionList";
//                    } else if ($.inArray(id, networkAuthorityTypes) !== -1) {
//                        pageName = "personnel/networkAuthority/networkAuthorityApplyAttentionList";
                    } else if ($.inArray(id, outsideCompanyRepaymentsTypes) !== -1) {
                        pageName = "personnel/outsideCompanyRepayments/outsideCompanyRepaymentsApplyAttentionList";
//                    } else if ($.inArray(id, preProjectsTypes) !== -1) {
//                        pageName = "operation_processor/preProjects/preProjectsApplyAttentionList";
//                    } else if ($.inArray(id, bePreProjectsTypes) !== -1) {
//                        pageName = "operation_processor/bePreProjects/bePreProjectsAttentionList";
                    } else if ($.inArray(id, closePreProjectsTypes) !== -1) {
                        pageName = "operation_processor/closePreProjects/closePreProjectsAttentionList";
//                    } else if ($.inArray(id, abnormalWagesTypes) !== -1) {
//                        pageName = "personnel/abnormalWages/abnormalWagesApplyAttentionList";
                    } else if ($.inArray(id, budgetManagementTypes) !== -1) {
                        pageName = "reimbursement/BudgetManagementApplyAttentionList";
                    } else if ($.inArray(id, SupplierComeInTypes) !== -1) {
                        pageName = "operation_processor/SupplierComeIn/SupplierComeInApplyAttentionList";
                    } else if ($.inArray(id, failInAtenderTypes) !== -1) {
                        pageName = "operation_processor/failInAtender/failInAtenderApplyAttentionList";
//                    } else if ($.inArray(id, SealTypes) !== -1) {
//                        pageName = "administration/seal/sealApplyAttentionList";
                    } else if ($.inArray(id, qutQuotationTypes) !== -1) {
                        pageName = "operation_processor/qutQuotation/qutQuotationApplyAttentionList";
                    } else if ($.inArray(id, projectStagesProcessTypes) !== -1) {
                        pageName = "operation_processor/projectStagesProcess/projectStagesProcessApplyAttentionList";
                    } else if ($.inArray(id, outputDrawingTypes) !== -1) {
                        pageName = "myWork/outputDrawing/outputDrawingApplyAttentionList";
                    } else if ($.inArray(id, projectEmployeeProcessTypes) !== -1) {
                        pageName = "operation_processor/projectEmployeeProcess/projectEmployeeProcessApplyAttentionList";
                    } else if ($.inArray(id, projectSettlementProcessTypes) !== -1) {
                        pageName = "operation_processor/projectSettlementProcess/projectSettlementProcessApplyAttentionList";
                    } else if ($.inArray(id, cooperateTypes) !== -1) {
                        pageName = "myWork/cooperate/cooperateApplyAttentionList";
                    } else if ($.inArray(id, settlementTypes) !== -1) {
                        pageName = "myWork/settlement/settlementApplyAttentionList";
                    } else {
                        sc.alert("此流程手机端不支持审批，请移至电脑审批。");
                    }

                    if (dl.isNullOrUndefined(pageName))
                        return;
                    self.processType = id;
                    //设置页面处理类型:1:待办;2:知会
                    self.handelType = 2;
                    //从我的已阅页面进入
                    //                    通过点击我的代办列表里的某一条，获得数据d
                    var d = dl.findCurrentDataByAttr(id, "processType", self.menuData);
                    d['pageFlag'] = 2;
                    self.rowData = d;
                    //保存页面路径
                    dl.pushPageStack({name: 'myHaveRead', params: self.parentViewModel, cacheKey: 'myHaveRead'});
                    dl.getGlobalModule({name: pageName, params: self});
                    dl.pushHeader(dl.headerTitle());
                    dl.headerTitle(dl.getLabelByValue('system_process_types', d.processType));

                };
                //  已做审批页面的数组  记得做一个页面加上这个id
                dl.haveDoneArr = [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 33, 34, 35, 36, 37, 39, 40, 41, 42, 43, 44, 45, 46, 51, 52, 53, 56, 58, 59, 60, 61, 62, 63, 64, 71, 72, 73, 75, 76, 77, 78, 79, 80, 81, 82];
                //                  41外部公司还款 , 45暂时隐藏
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

                self.getValues = function () {
                    //业务数据获取
                    var userData = self.resultData;
                    userData[0].detailProcessBillListApply = self.processbillListData;
                    return userData[0];
                };

                self.datareceived = function (data) {
                    self.menuData = data.ResultSet.Result;
                    var newData = [];
                    for (var i = 0; i < self.menuData.length; i++) {
                        if (self.menuData[i].activityType == 8) {
//                            已阅 8
                            var typeId = self.menuData[i].processType;
                            if ($.inArray(typeId, dl.haveDoneArr) !== -1) {
                                newData.push(self.menuData[i]);
                            }
                        }
                    }
                    self.menuData = newData;
                    self.dataSource(new oj.ArrayTableDataSource(self.menuData));


                };

                self.getDataTitle = function (data) {
                };

                self.handleActivated = function (info) {
                    // Implement if needed
                };

                self.handleAttached = function (info) {
                    var params = {currentPage: 0,
                        pageLines: 1,
                        optType: 'onLoadFLowProcessTypeNum',
                        employeeId: dl.getEmployeeId()
                    };
                    dl.callOperation("EP_OnWrokflowProcess", 'find', params, self.datareceived);
                };



                self.handleBindingsApplied = function (info) {
                };


                self.handleDetached = function (info) {
                };
            }

            return myHaveReadViewModel;
        }
);


