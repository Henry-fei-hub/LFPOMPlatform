define(['ojs/ojcore', 'knockout', 'jquery', 'dl/commclient','dl/msgbox', 'dl/workflow', 'ojs/ojknockout', 'promise', 'ojs/ojnavigationlist',
    'ojs/ojdatagrid', 'ojs/ojrowexpander', 'ojs/ojflattenedtreedatagriddatasource', 'ojs/ojjsontreedatasource', 'ojs/ojarraytabledatasource'],
        function (oj, ko, $, dl ,sc) {
            function myExamineViewModel(params) {
                var self = this;
                self.viewModelName = 'myExamineViewModel';
                self.parentViewModel = params;
                self.dataSource = ko.observable();
                self.display = ko.observable("all");
                self.navigationLevel = ko.observable("page");
                self.selectedItem = ko.observable("");
                self.item = ko.observable("");
                self.isNode = ko.observable('0');

                self.iClicked = function (data, event) {
//                    日常  ok 
                    var normalTypes = ['2', '3', '8'];
//                     差旅
                    var travelTypes = ['4', '5', '9'];
//                      借款
                    var borrowMoneyTypes = ['6'];
//                       预付款
                    var PrePaymentTypes = ['7'];
//                    员工还款申请
                    var repayMoneyTypes = ['28'];
//                        人事!!! 部分行政！！   45工资异常申请暂时去掉隐藏   40网络权限  '25',  '29',隐藏
                    var reimburseAdministrationTypes = ['13', '14', '15', '16', '17', '18', '21','26', '30', '31', '33', '34', '36', '37', '41', '52' ,'75', '78','81','82' ];
                    //出差延期申请  出差更改行程申请
                    var travelChangeTypes = ['19', '20'];
                    //   入职
                    var entryTypes = ['24'];
                    //成本调节
                    var costAdjustmentTypes = ['39'];
//                    行政 '42', '43',隐藏
                    var operationProcessorType = [ '44'];
                    //供应商入库
                    var SupplierComeInTypes = ['53'];
                    //落标申请
                    var failInAtenderTypes = ['73'];
 //                   报价单审核申请
//                   var qutQuotationTypes = ['75'];
//                    可分配阶段申请
                   var projectStagesProcessTypes = ['76'];
//                     团队组建申请
                    var projectEmployeeProcessTypes = ['79'];
//                      经费结算申请
                    var projectSettlementProcessTypes = ['80'];
//                    配合申请
//                    var cooperateTypes = ['81'];
////                      结算申请
//                    var settlementTypes = ['82'];
//                      我的工时
                    var workTimeTypes = ['84'];
                    var target = event.currentTarget;
                    var id = target.id;
                    var pageName;
//                  传入的id能在这个数组里找到页面 
                    if ($.inArray(id, normalTypes) !== -1) {
                        pageName = "myExamine/normalExamineList";
                    } else if ($.inArray(id, travelTypes) !== -1) {
                        pageName = "myExamine/travelExamineList";
                    } else if ($.inArray(id, entryTypes) !== -1) {
                        pageName = "myExamine/entryExamineList";
                    } else if ($.inArray(id, costAdjustmentTypes) !== -1) {
                        pageName = "myExamine/costAdjustmentExamineList";
                    } else if ($.inArray(id, travelChangeTypes) !== -1) {
                        pageName = "myExamine/travelChangeExamineList";
                    } else if ($.inArray(id, borrowMoneyTypes) !== -1) {
                        pageName = "myExamine/borrowMoneyExamineList";
                    } else if ($.inArray(id, PrePaymentTypes) !== -1) {
                        pageName = "myExamine/PrePaymentExamineList";
                    } else if ($.inArray(id, repayMoneyTypes) !== -1) {
                        pageName = "myExamine/repayMoneyExamineList";
                    } else if ($.inArray(id, reimburseAdministrationTypes) !== -1) {
                        pageName = "myExamine/reimburseAdministrationExamineList";
                    } else if ($.inArray(id, operationProcessorType) !== -1) {
                        pageName = "myExamine/operationProcessorExamineList";
                    } else if ($.inArray(id, SupplierComeInTypes) !== -1) {
                        pageName = "myExamine/SupplierComeInExamineList";
                    } else if ($.inArray(id, failInAtenderTypes) !== -1) {
                        pageName = "myExamine/failInAtenderExamineList"
                    }else if ($.inArray(id, projectStagesProcessTypes) !== -1) {
                        pageName = "myExamine/projectStagesProcessExamineList"
                    }else if ($.inArray(id, projectEmployeeProcessTypes) !== -1) {
                        pageName = "myExamine/projectEmployeeProcessExamineList"
                    }else if ($.inArray(id, projectSettlementProcessTypes) !== -1) {
                        pageName = "myExamine/projectSettlementProcessExamineList"
//                    }else if ($.inArray(id, cooperateTypes) !== -1) {
//                        pageName = dl.getProcessPageName(id, 1);
//                    }else if ($.inArray(id, settlementTypes) !== -1) {
//                        pageName = dl.getProcessPageName(id, 1);
                    } else if ($.inArray(id, workTimeTypes) !== -1) {
                        pageName = "myExamine/workTimeExamineList"
                    }else {
                        sc.alert("此流程手机端不支持审批，请移至电脑审批。");
                    }
                    if (dl.isNullOrUndefined(pageName)) {
                        return;
                    }
                    self.processType = id;
                    //设置页面处理类型:1:待办;2:知会
                    self.handelType = 1;
//                    保存页面路径
                    dl.pushPageStack({name: 'myExamine', params: self.parentViewModel});
                    dl.getGlobalModule({name: pageName, params: self});
//                    通过点击我的代办列表里的某一条，获得数据d
                    var d = dl.findCurrentDataByAttr(id, "processType", self.menuData);
//                    保存header路径 dl.headerTitle()一个ob变量 d.processTypeName 为下一页header名字

//                  表示从我的已审过去的
                    d['pageFlag'] = 1;
                    self.rowData = d;
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
                    console.log(data);
                    self.menuData = data.ResultSet.Result;
                    var newData = [];
                    for (var i = 0; i < self.menuData.length; i++) {
                        if (self.menuData[i].activityType == 7) {
                            //                            已办审批 7
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
                dl.haveDoneArr = [2, 3, 4, 5, 6, 7, 8, 9, 10,11,13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 33, 34, 35, 36, 37, 39, 40, 41, 42, 43, 44, 45,46,51, 52, 53, 56, 58, 59, 60, 61, 62, 63, 64, 71, 72, 73, 75, 76, 77, 78, 79, 80, 81, 82,84];


//                 41外部公司还款 45 工资异常申请暂时隐藏
                self.getDataTitle = function (data) {
                };




                self.handleActivated = function (info) {
                    // Implement if needed
                };


                self.handleAttached = function (info) {
                    var params = {currentPage: 0,
                        pageLines: 1,
                        optType: 'onLoadFLowProcessTypeNum',
//                        parentProcessTypeId: 1,
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

            return myExamineViewModel;
        }
);


