package com.pomplatform.client.data;

import static com.delicacy.client.data.DelicacyMenuData.generalMap;
import static com.delicacy.client.data.DelicacyMenuData.menuMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.delicacy.client.BasicPermissionStatic;
import com.delicacy.client.data.ExplorerTreeNode;
import com.delicacy.client.ui.MenuAppender;
import com.google.gwt.i18n.client.LocaleInfo;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.aboutinputtaxrecordinfo.panel.AboutInputTaxRecordInfoPanel;
import com.pomplatform.client.abouttrainingmanagement.panel.AboutTrainingManagementPanel;
import com.pomplatform.client.account.panel.EmployeeAccountPanel;
import com.pomplatform.client.account.panel.PlateAccountPanel;
import com.pomplatform.client.account.panel.ProjectAccountPanel;
import com.pomplatform.client.account.panel.QualityFundAccountPanel;
import com.pomplatform.client.account.panel.SheetAccountPanel;
import com.pomplatform.client.accountweightrecord.panel.AccountWeightRecordPanel;
import com.pomplatform.client.activitympcor.panel.ActivityMeetManagePanel;
import com.pomplatform.client.analysisemployee.panel.EmployeeProjectAnalysisPanel;
import com.pomplatform.client.annoucement.panel.AnnoucementManagePanel;
import com.pomplatform.client.annoucement.panel.MyPermissionsFunctionInitPanel;
import com.pomplatform.client.areas.panel.SareaaaorPanel;
import com.pomplatform.client.attachment.panel.McontractcacccccaaaraabbifiiorPanel;
import com.pomplatform.client.attachment.panel.OnAttachmentSurePanel;
import com.pomplatform.client.attachment.panel.OnLoadAttachmentDataOfAttachmentPanel;
import com.pomplatform.client.attachmentmanagemeeting.panel.AttachmentManageMettingPanel;
import com.pomplatform.client.bank.panel.BankManagerPanel;
import com.pomplatform.client.bonuspayment.panel.BonusPaymentRecordPanel;
import com.pomplatform.client.bonuspayment.panel.bonusSummaryPanel;
import com.pomplatform.client.borrowmoneymanage.panel.BorrowMoneyManagePanel;
import com.pomplatform.client.budgetmanagement.panel.OnBudgetManagementPanel;
import com.pomplatform.client.calculateannualleave.panel.CalculateAnnualLeavePanel;
import com.pomplatform.client.capitaldistribution.panel.AllCapitalDistributionInfoPanel;
import com.pomplatform.client.capitaldistribution.panel.CapitalDistributionAnalyzePanel;
import com.pomplatform.client.capitaldistribution.panel.CapitalDistributionOfDepartmentPanel;
import com.pomplatform.client.capitaldistribution.panel.CapitalDistributionOfProjectPanel;
import com.pomplatform.client.capitaldistribution.panel.CapitalLogDetailPanel;
import com.pomplatform.client.cardmanage.panel.EmployeeCardManagePanel;
import com.pomplatform.client.cardmanagecdcor.panel.ScardmanagecdcorPanel;
import com.pomplatform.client.check.panel.AttendanceManagementStatisticsPanel;
import com.pomplatform.client.clocks.panel.ClockListPanel;
import com.pomplatform.client.clocks.panel.EmployeeFacesPanel;
import com.pomplatform.client.clocks.panel.EmployeeFingersPanel;
import com.pomplatform.client.cmbcinfo.panel.BankCapitalPaymentCheckPanel;
import com.pomplatform.client.cmbcinfo.panel.BankCapitalReceiveCheckPanel;
import com.pomplatform.client.cmbcinfo.panel.McmbcaccoutinfoccacbscorPanel;
import com.pomplatform.client.cmbcinfo.panel.McmbctransinfoctatorPanel;
import com.pomplatform.client.collection.panel.MItemCollectionPanel;
import com.pomplatform.client.company.panel.CompanyReportIntegralPanel;
import com.pomplatform.client.company.panel.JobManagementPanel;
import com.pomplatform.client.companyarea.panel.CompanyareaPanel;
import com.pomplatform.client.contract.panel.ContractAmountAnalyzePanel;
import com.pomplatform.client.contract.panel.ContractCommissionDetailPanel;
import com.pomplatform.client.contract.panel.ContractDistributionNewPanel;
import com.pomplatform.client.contract.panel.ContractLogListPanel;
import com.pomplatform.client.contract.panel.ContractManagePanel;
import com.pomplatform.client.contract.panel.ContractStatusHistoryPanel;
import com.pomplatform.client.contract.panel.NewContractDistributionPanel;
import com.pomplatform.client.contract.panel.OnLoadContractAttachmentDataPanel;
import com.pomplatform.client.contract.panel.ShowContractDistributionPanel;
import com.pomplatform.client.contract.panel.ShowOldProjectRevenuePanel;
import com.pomplatform.client.contractchange.panel.ContractChangeListPanel;
import com.pomplatform.client.contracticcisiior.panel.McontracticcisiiorPanel;
import com.pomplatform.client.contractincome.panel.ContractIncomeLedgerListPanel;
import com.pomplatform.client.contractmessage.panel.OnLoadContractMessageRecordPanel;
import com.pomplatform.client.contractppspcccfscsiiicpor.panel.McontractppspcccfscsiiicporPanel;
import com.pomplatform.client.contractsrecords.panel.ContractsRecordsPanel;
import com.pomplatform.client.costallocation.panel.CarCostAllocationEachMonthPanel;
import com.pomplatform.client.customer.panel.CustomerResourcesPanel;
import com.pomplatform.client.customer.panel.HolidayBlessPanel;
import com.pomplatform.client.customer.panel.OnLoadCompetitionUnitsDataPanel;
import com.pomplatform.client.customer.panel.OnLoadCustomerDataPanel;
import com.pomplatform.client.department.panel.DepartmentPanel;
import com.pomplatform.client.department.panel.DepartmentRoleEmployeePanel;
import com.pomplatform.client.department.panel.DepartmentRolePanel;
import com.pomplatform.client.department.panel.RoleEmployeePanel;
import com.pomplatform.client.department.panel.RoleFunsPanel;
import com.pomplatform.client.designer.panel.DesignMessagePanel;
import com.pomplatform.client.designer.panel.DesignerProjectPanel;
import com.pomplatform.client.employee.panel.DictionaryManagementPanel;
import com.pomplatform.client.employee.panel.OnboardEmployeeEachYearPanel;
import com.pomplatform.client.employee.panel.ResignEmployeeEachYearPanel;
import com.pomplatform.client.employee.panel.UpdateFrozenIntegralPanel;
import com.pomplatform.client.employeeaward.panel.OnEmployeeIntegralBusinessAllPanel;
import com.pomplatform.client.employeechangeplaterecord.panel.MemployeechangeplaterecordeeepyseorPanel;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.panel.EmployeeCapitalsPanel;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.panel.EmployeeIntegralCapitalsPanel;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.panel.MpersonnelbusinessdddemmporPanel;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.panel.ReceiveUnitCapitalsPanel;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.panel.ReceiveUnitEmployeeCapitalsPanel;
import com.pomplatform.client.employeenew.panel.MemployeePanel;
import com.pomplatform.client.employeenew.panel.SplateManagerPanel;
import com.pomplatform.client.employeesalary.panel.MemployeeSalaryPanel;
import com.pomplatform.client.equipment.panel.EquipmentDetailPanel;
import com.pomplatform.client.equipment.panel.MequipmenttypeedeeeorPanel;
import com.pomplatform.client.exchangerate.panel.ExchangeRateListPanel;
import com.pomplatform.client.financereceivebills.panel.MfinancereceivebillsporPanel;
import com.pomplatform.client.financialstatements.panel.FinancicalCapitalAnalysisPanel;
import com.pomplatform.client.financialtransactionaccount.panel.HandingTransDetailSummaryPanel;
import com.pomplatform.client.financialtransactionaccount.panel.TransDetailSummaryPanel;
import com.pomplatform.client.goodsreceive.panel.GoodsreceivePanel;
import com.pomplatform.client.hr.panel.EmployeeContractAttachmentPanel;
import com.pomplatform.client.hr.panel.PlateRecordPanel;
import com.pomplatform.client.inputtaxinvoiceabpor.panel.MinputtaxinvoicelinkfinancesippciiymssorPanel;
import com.pomplatform.client.inputtaxinvoiceabpor.panel.SinputtaxinvoiceabporPanel;
import com.pomplatform.client.invoiceexpresitssccmisiior.panel.MinvoiceexpresitssccmisiiorPanel;
import com.pomplatform.client.ja.ht.panel.ContractPricePanel;
import com.pomplatform.client.ja.ht.panel.MainProjectPanel;
import com.pomplatform.client.ja.ht.panel.OrderMainProjectPanel;
import com.pomplatform.client.k3code.panel.BankAccountK3CodePanel;
import com.pomplatform.client.k3code.panel.CompanyK3CodePanel;
import com.pomplatform.client.k3code.panel.CustomerK3CodePanel;
import com.pomplatform.client.k3code.panel.EmployeeK3CodePanel;
import com.pomplatform.client.k3code.panel.PlateAreaK3CodePanel;
import com.pomplatform.client.k3code.panel.ReceiveUnitK3CodePanel;
import com.pomplatform.client.k3code.panel.SpecificK3CodePanel;
import com.pomplatform.client.k3code.panel.SubjectTypeK3CodePanel;
import com.pomplatform.client.k3voucher.panel.DelicacyAllVoucherPanel;
import com.pomplatform.client.leavetype.panel.LeaveTypeTotalPanel;
import com.pomplatform.client.mainprojectinfo.panel.OnLoadBidPaySheetProjectSummaryPanel;
import com.pomplatform.client.manageproject.panel.ManageProjectPanel;
import com.pomplatform.client.mcapitalcmmssmssbor.panel.McapitalcmmssmssborPanel;
import com.pomplatform.client.mcecscreeor.panel.McecscreeorPanel;
import com.pomplatform.client.mcontracticcacccor.panel.McontracticcacccorPanel;
import com.pomplatform.client.meeting.panel.MeetingRoomManagementPanel;
import com.pomplatform.client.meeting.panel.MeetingRoomReservaTionRecordPaymentBasePanel;
import com.pomplatform.client.memployeechangeplatedetail.panel.MEmployeeChangePlateDetailPanel;
import com.pomplatform.client.mfinancialaccounting.panel.MfinancialAccountingPanel;
import com.pomplatform.client.minvocieapplydedaocor.panel.McontracticcccsprfiiibaadicrbbiorPanel;
import com.pomplatform.client.minvocieapplydedaocor.panel.MinvocieapplydedaocorPanel;
import com.pomplatform.client.newcontractppcor.panel.ScontractppcorPanel;
import com.pomplatform.client.onemployeedayplaterecords.panel.OnEmployeeDayPlateRecordsPanel;
import com.pomplatform.client.onlaborpaymentdata.panel.OnLaborPaymentDataPanel;
import com.pomplatform.client.onrevenue.panel.BusinessStateRecordPanel;
import com.pomplatform.client.onrevenue.panel.FinishPercentSurePanel;
import com.pomplatform.client.onrevenue.panel.OnBusinessStateRevenuePanel;
import com.pomplatform.client.onsupplierinfo.panel.OnSupplierInfoPanel;
import com.pomplatform.client.operating.panel.OperatingReportIntegralPanel;
import com.pomplatform.client.operation.panel.ProjectManagerPanel;
import com.pomplatform.client.payment.panel.EmployeeSalaryTypePanel;
import com.pomplatform.client.payment.panel.FiveInsuranceOneGoldsPanel;
import com.pomplatform.client.payment.panel.FiveInsuranceOneGoldsPaymentBasePanel;
import com.pomplatform.client.payment.panel.OnFillSendDeductDataPanel;
import com.pomplatform.client.payment.panel.OnInsteadDeductDataPanel;
import com.pomplatform.client.payment.panel.OnInsteadDeductIllDataPanel;
import com.pomplatform.client.payment.panel.OnJobSubsidysDataPanel;
import com.pomplatform.client.payment.panel.OnLeaveSubsidysDataPanel;
import com.pomplatform.client.payment.panel.OnLoadEmployeePaymentPanel;
import com.pomplatform.client.payment.panel.OnLoadSalaryPaymentByCompanyPanel;
import com.pomplatform.client.payment.panel.OnOtherDeductionDataPanel;
import com.pomplatform.client.payment.panel.OnReplacementTaxDataPanel;
import com.pomplatform.client.payment.panel.OnSalaryAnnualBonusByCompanyPanel;
import com.pomplatform.client.payment.panel.OnSalaryAnnualBonusByPlatePanel;
import com.pomplatform.client.payment.panel.OnSalaryBonusSendDataPanel;
import com.pomplatform.client.payment.panel.OnSalaryBonusTotalDataPanel;
import com.pomplatform.client.payment.panel.OnSalaryPlateBonusByPlatePanel;
import com.pomplatform.client.payment.panel.OnSalaryReportByCompanyPanel;
import com.pomplatform.client.payment.panel.OnSalaryReportByPlatePanel;
import com.pomplatform.client.payment.panel.OnSalarySendDataPanel;
import com.pomplatform.client.payment.panel.OnSalaryTaxDataPanel;
import com.pomplatform.client.payment.panel.OnSalaryTotalDataPanel;
import com.pomplatform.client.payment.panel.OnloadEmployeePaymentMonthDetailPanel;
import com.pomplatform.client.plateproductionvaluecoefficients.panel.SproductionvaluecoefficienttypeporPanel;
import com.pomplatform.client.platereportrecorddetail.panel.projectAdvanceDetailPanel;
import com.pomplatform.client.poolmanage.panel.OnloadPoolDataPanel;
import com.pomplatform.client.preprojectreimbursementnumber.panel.PreProjectReimbursementNumbersPanel;
import com.pomplatform.client.preprojects.panel.projectPreInfomationsPanel;
import com.pomplatform.client.productcategory.panel.ProductCategoryPanel;
import com.pomplatform.client.project.panel.MprojecttrcccsyyyseyymmymmorPanel;
import com.pomplatform.client.project.panel.OnDevelopProjectPanel;
import com.pomplatform.client.project.panel.OnLoadInAchieveDetailPanel;
import com.pomplatform.client.project.panel.OnLoadOutAchieveSurePanel;
import com.pomplatform.client.project.panel.OnManageProjectPanel;
import com.pomplatform.client.project.panel.OnProjectBusinessLinePanel;
import com.pomplatform.client.project.panel.OnProjectPerformanceNodeEmployeePanel;
import com.pomplatform.client.project.panel.OnProjectPerformanceRecordPanel;
import com.pomplatform.client.project.panel.OnRevenueSureWarnPanel;
import com.pomplatform.client.project.panel.PersonArrangementPanel;
import com.pomplatform.client.project.panel.SprojectManagerPanel;
import com.pomplatform.client.project.panel.SprojectpbporPanel;
import com.pomplatform.client.projectTemplate.panel.SprojecttemplateorPanel;
import com.pomplatform.client.projectattachmentmanage.panel.ProjectAttachmentManagePanel;
import com.pomplatform.client.projectcost.panel.ProjectCostRecordPanel;
import com.pomplatform.client.projectemployee.panel.ProjectEmployeeAuditPanel;
import com.pomplatform.client.projectemployee.panel.ProjectEmployeeReportPanel;
import com.pomplatform.client.projectperformance.panel.ContractProjectPerformancePanel;
import com.pomplatform.client.projectreportrecorddetail.panel.ProjectBuyCostsPanel;
import com.pomplatform.client.projectreportrecorddetail.panel.ProjectReportRecordDetailPanel;
import com.pomplatform.client.projectstages.panel.ConfirmablePhasesListPanel;
import com.pomplatform.client.projectsuredaterecord.panel.ProjectSureDateRecordPanel;
import com.pomplatform.client.projecttransitions.panel.OnLoadProjectTransitionRecordPanel;
import com.pomplatform.client.purchase.panel.MpurchaseplanmsommpmosrorPanel;
import com.pomplatform.client.purchase.panel.OnStorageDataPanel;
import com.pomplatform.client.purchase.panel.PaymentTemplateWithPPanel;
import com.pomplatform.client.purchase.panel.PurchaseContractWithPpPanel;
import com.pomplatform.client.purchase.panel.SproductmmporPanel;
import com.pomplatform.client.purchase.panel.SpurchasepaymentorPanel;
import com.pomplatform.client.receivables.panel.IncomeMoneyForWeekPanel;
import com.pomplatform.client.receivables.panel.InvoiceAndPaymentPanel;
import com.pomplatform.client.receivables.panel.InvoiceReportPanel;
import com.pomplatform.client.receivables.panel.McapitalecoosmeorPanel;
import com.pomplatform.client.receivables.panel.MinvoicecseccorPanel;
import com.pomplatform.client.reimbursement.panel.ResetAllReimbursementCostPanel;
import com.pomplatform.client.reimbursement.panel.SearchReimbursementInfoPanel;
import com.pomplatform.client.reimbursement.panel.SreimbursementpackagesummarymmmorPanel;
import com.pomplatform.client.reimbursementinfo.panel.ReimbursementInfoPanel;
import com.pomplatform.client.report.panel.*;
import com.pomplatform.client.revenue.panel.PlateRateOfRevenuePanel;
import com.pomplatform.client.revenue.panel.RevenueStatisticalOfRevenuePanel;
import com.pomplatform.client.revenue.panel.SheetAmountStatisticalOfRevenuePanel;
import com.pomplatform.client.revenue.panel.contractSaveAnalyzePanel;
import com.pomplatform.client.revenuecapitalsinfo.panel.RevenueCapitalsInfoPanel;
import com.pomplatform.client.rmimburseementinvoice.panel.MreimbursementinvoiceinformationrsrmmprorPanel;
import com.pomplatform.client.salary.panel.SalaryAnnualbonusPanel;
import com.pomplatform.client.salary.panel.SalaryAnnualbonusSendPanel;
import com.pomplatform.client.salary.panel.SalaryAnnualbonusTaxPanel;
import com.pomplatform.client.salary.panel.SalaryOfFactBonusPanel;
import com.pomplatform.client.salary.panel.SalaryOfOtherBonusPanel;
import com.pomplatform.client.salary.panel.SalaryOfShouldBonusPanel;
import com.pomplatform.client.salary.panel.SalaryOfWorkYearsPanel;
import com.pomplatform.client.salaryemployeeevaluationrmmor.panel.SsalaryemployeeevaluationrmmorPanel;
import com.pomplatform.client.salaryemployeeevaluationrmmor.panel.SsalaryemployeeperformancemmeorPanel;
import com.pomplatform.client.scontract.panel.ScontractPanel;
import com.pomplatform.client.scontractcccor.panel.ContractSendedPanel;
import com.pomplatform.client.scontractcccor.panel.SAuditcontractcccorPanel;
import com.pomplatform.client.scontractcccor.panel.ScontractcccorPanel;
import com.pomplatform.client.scontractreceivabletemplaterrcor.panel.ScontractreceivabletemplaterrcorPanel;
import com.pomplatform.client.sealkeepers.panel.RankMaintenancePanel;
import com.pomplatform.client.sealkeepers.panel.sealKeepersWorkflowPanel;
import com.pomplatform.client.shift.form.MyAttendance;
import com.pomplatform.client.shift.panel.EmployeeMonthCheckPanel;
import com.pomplatform.client.shift.panel.HolidayManagePanel;
import com.pomplatform.client.shift.panel.ManageShiftTimePanel;
import com.pomplatform.client.shift.panel.OnLoadEmployeeCheckDetailPanel;
import com.pomplatform.client.shift.panel.OnLoadEmployeeShiftOfShiftPanel;
import com.pomplatform.client.shift.panel.SshiftmanagesorPanel;
import com.pomplatform.client.sinvoiceitior.panel.SinvoiceitiorPanel;
import com.pomplatform.client.sinvoiceitiorcount.panel.SinvoiceitiorcountPanel;
import com.pomplatform.client.specialdeduction.panel.MspecialdeductionrecordssyeseeshsppcorPanel;
import com.pomplatform.client.specialdeduction.panel.SspecialdeductionmonthdetailedporPanel;
import com.pomplatform.client.sreceiveunitmanagemmror.panel.SreceiveunitmanagemmrorPanel;
import com.pomplatform.client.sreimbursementpackagemmror.panel.SreimbursementpackagemmrorPanel;
import com.pomplatform.client.stagemodel.panel.ContractStageAuditDesignerPanel;
import com.pomplatform.client.stagemodel.panel.ContractStageAuditManagerPanel;
import com.pomplatform.client.stagemodel.panel.ContractStageProcessStatusListPanel;
import com.pomplatform.client.stagemodel.panel.StageContractInfoListPanel;
import com.pomplatform.client.stagemodel.panel.StageModelTreePanel;
import com.pomplatform.client.subjecttype.panel.SubjectTypeTotalPanel;
import com.pomplatform.client.threadtask.panel.SthreadtaskmanagemmmorPanel;
import com.pomplatform.client.trainingmanagement.panel.EmployeeItegralPanel;
import com.pomplatform.client.trainingmanagement.panel.TrainingManagementPanel;
import com.pomplatform.client.workflow.panel.*;
import com.pomplatform.client.workinghour.panel.WorkingHourManagePanel;


/**
 *
 * @author lxf
 */
public class POMPlatformMenu implements MenuAppender {

    @Override
    public void append(Map<String, ExplorerTreeNode> map) {
        String localName = LocaleInfo.getCurrentLocale().getLocaleName();
        //编码总共12位,第一位表示类型:S:系统;A:应用;第二位表示应用类型:M:菜单;B:按钮;D:数据;-00000：表示菜单级别数：第一个0表示一级菜单第二个表示二级，依次类推;-000:表示按钮或者数据权限
        	//供应链管理
        	menuMap.put(ERPPermissionStatic.PURCHASE_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "供应链管理" : "Purchase Manage", "purchase_managment", "root", "silk/layout_content.png", null, true, "", null));
        		menuMap.put(ERPPermissionStatic.PRODUCT_CATEGORY_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "产品品类管理" : "Product category managment", "product_category_manage", "purchase_managment", "menuicons/icon-icon_yuangongpaiban.png",
        			new ProductCategoryPanel.Factory(), true,"", ProductCategoryPanel.class));
        		menuMap.put(ERPPermissionStatic.PRODUCT_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "产品管理" : "Product managment", "product_manage", "purchase_managment", "menuicons/icon-shebeiliebiao1.png",
        			new SproductmmporPanel.Factory(), true,"", SproductmmporPanel.class));
        		menuMap.put(ERPPermissionStatic.PURCHASE_PAYMENT_TEMPLATE, new ExplorerTreeNode(localName.equals("zh_CN") ? "采购付款模板" : "Purchase payment template", "purchase_payment_template", "purchase_managment", "menuicons/icon-butie2.png",
            			new PaymentTemplateWithPPanel.Factory(), true,"", PaymentTemplateWithPPanel.class));
        		menuMap.put(ERPPermissionStatic.PURCHASE_PLAN, new ExplorerTreeNode(localName.equals("zh_CN") ? "采购计划" : "Purchase plan", "purchase_plan", "purchase_managment", "menuicons/icon-butie2.png",
            			new MpurchaseplanmsommpmosrorPanel.Factory(), true,"", MpurchaseplanmsommpmosrorPanel.class));
        		menuMap.put(ERPPermissionStatic.PURCHASE_PAYMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "采购付款计划" : "Purchase payment", "purchase_payment", "purchase_managment", "menuicons/icon-butie2.png",
            			new SpurchasepaymentorPanel.Factory(), true,"", SpurchasepaymentorPanel.class));
        		menuMap.put(ERPPermissionStatic.PURCHASE_CONTRACT, new ExplorerTreeNode(localName.equals("zh_CN") ? "采购合同管理" : "Purchase contract", "purchase_contract", "purchase_managment", "menuicons/icon-butie2.png",
            			new PurchaseContractWithPpPanel.Factory(), true,"", PurchaseContractWithPpPanel.class));
        		menuMap.put(ERPPermissionStatic.STORAGE_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "仓库管理" : "Storage Managment", "storage_managment", "purchase_managment", "menuicons/icon-shiduan-copy.png",null, true,"", null));
        			menuMap.put(ERPPermissionStatic.STORAGE_SET, new ExplorerTreeNode(localName.equals("zh_CN") ? "仓库设置" : "Storage Set", "storage_set", "storage_managment", "menuicons/icon-shiduan-copy.png",
        					new OnStorageDataPanel.Factory(), true,"", OnStorageDataPanel.class));
            menuMap.put(ERPPermissionStatic.HR_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "人资管理" : "Human Resource Manage", "hr_managment", "root", "silk/layout_content.png", null, true, "", null));
                menuMap.put(ERPPermissionStatic.ORGANIZATION_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "组织架构" : "Organizational Structure", "organizational_structure", "hr_managment", "menuicons/icon-zuzhijiagou1.png",
                    null, true,"",null));
                        menuMap.put(ERPPermissionStatic.ORGANIZATION_DEPT_NUM_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "部门下职员" : "dept_emp", "dept_emp", "organizational_structure", "menuicons/icon-icon-test1.png",
                            new DepartmentPanel.Factory(), true,"", DepartmentPanel.class));
                        menuMap.put(ERPPermissionStatic.ORGANIZATION_DEPT_ROLE_NUM_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "部门下角色" : "dept_role", "dept_role", "organizational_structure", "menuicons/icon-jiaose2.png",
                            new DepartmentRolePanel.Factory(), true,"", DepartmentRolePanel.class));
                        menuMap.put(ERPPermissionStatic.ORGANIZATION_ROLE_EMP_NUM_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "角色下职员" : "role_emp", "role_emp", "organizational_structure", "menuicons/icon-zhiyuan.png",
                            new RoleEmployeePanel.Factory(), true,"", RoleEmployeePanel.class));
                        menuMap.put(ERPPermissionStatic.ORGANIZATION_ROLE_TOOL_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "角色下功能" : "role_tool", "role_tool", "organizational_structure", "menuicons/icon-gongneng2.png",
                            new RoleFunsPanel.Factory(), true,"", RoleFunsPanel.class));
                        menuMap.put(ERPPermissionStatic.ORGANIZATION_DEPARTMENT_ROLE_EMP_NUM_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "部门角色下职员" : "department_role_emp", "department_role_emp", "menuicons/icon-zhiyuanguanli.png", "silk/layout_content.png",
                                new DepartmentRoleEmployeePanel.Factory(), true,"", DepartmentRoleEmployeePanel.class));
                //考勤管理
                menuMap.put(ERPPermissionStatic.ATTENDANCE_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "考勤管理" : "Attendance Manage", "attendance_manage", "hr_managment", "menuicons/icon-kaoqinguanli.png",
                    null, true,"",null));
                	//节日维护
                	menuMap.put(ERPPermissionStatic.HOLIDAY_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "假日维护" : "Holiday Manage", "holiday_manage", "attendance_manage", "menuicons/icon-shiduan-copy.png",
                			new HolidayManagePanel.Factory(), true, "", HolidayManagePanel.class));
                	//时段维护
                	menuMap.put(ERPPermissionStatic.SHIFT_TIME_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "时段维护" : "Shift time manage", "shift_time_manage", "attendance_manage", "menuicons/icon-shiduan-copy.png",
                			new ManageShiftTimePanel.Factory(), true,"", ManageShiftTimePanel.class));
                	//班次管理
                	menuMap.put(ERPPermissionStatic.SHIFT_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "班次管理" : "Shift manage", "shift_manage", "attendance_manage", "menuicons/icon-banciguanli1.png",
                			new SshiftmanagesorPanel.Factory(), true, "", SshiftmanagesorPanel.class));
                	//员工排班
                	menuMap.put(ERPPermissionStatic.EMPLOYEE_SHIFT_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "员工排班" : "Employee shift manage", "employee_shift_manage", "attendance_manage", "menuicons/icon-icon_yuangongpaiban.png",
                			new OnLoadEmployeeShiftOfShiftPanel.Factory(), true,"",OnLoadEmployeeShiftOfShiftPanel.class));

					//年假
					menuMap.put(ERPPermissionStatic.ANNUAL_LEAVE, new ExplorerTreeNode(localName.equals("zh_CN") ? "年假和带薪病假" : "Annual leave", "annual_leave", "attendance_manage", "menuicons/icon-shiduan-copy.png",
							new CalculateAnnualLeavePanel.Factory(), true,"", CalculateAnnualLeavePanel.class));
                	//考勤数据
//                	menuMap.put(ERPPermissionStatic.CHECK_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "考勤数据" : "check_data", "check_managment", "attendance_manage", "silk/layout_content.png",
//                			new MemployeecheckinouteeseorPanel.Factory(), true, "", MemployeecheckinouteeseorPanel.class));
                	//考勤汇总
//                	menuMap.put(ERPPermissionStatic.CHECK_TOTAL_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "考勤汇总" : "check_total", "check_total", "attendance_manage", "silk/layout_content.png",
//                			new SemployeemonthlycheckymorPanel.Factory(), true, "", SemployeemonthlycheckymorPanel.class));
                	//考勤汇总测试
                	menuMap.put(ERPPermissionStatic.CHECK_TOTAL_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "考勤汇总" : "check_total_test", "check_total_test", "attendance_manage", "menuicons/icon-kaoqinhuizongtongjibiao.png",
                			new EmployeeMonthCheckPanel.Factory(), true, "", EmployeeMonthCheckPanel.class));
                	//实时考勤
                	/*menuMap.put(ERPPermissionStatic.EMPLOYEE_CHECKINOUT, new ExplorerTreeNode(localName.equals("zh_CN") ? "实时考勤" : "employee Checkinout", "employee_checkinout", "attendance_manage", "menuicons/icon-kaoqin1.png",
                			new EmployeeCheckinoutPanel.Factory(), true, "", EmployeeCheckinoutPanel.class));*/
                	//请假类型
                	menuMap.put(ERPPermissionStatic.LEAVE_TYPE, new ExplorerTreeNode(localName.equals("zh_CN") ? "请假类型" : "leave type", "leave_type", "attendance_manage", "menuicons/icon-qingjia2.png",
                			new LeaveTypeTotalPanel.Factory(), true, "", LeaveTypeTotalPanel.class));
                	//打卡明细
                	menuMap.put(ERPPermissionStatic.CHECK_DETAIL, new ExplorerTreeNode(localName.equals("zh_CN") ? "打卡明细" : "check detail", "check_detail", "attendance_manage", "menuicons/icon-daqia1.png",
                			new OnLoadEmployeeCheckDetailPanel.Factory(), true, "", OnLoadEmployeeCheckDetailPanel.class));
                	//预计考勤统计
                	menuMap.put(ERPPermissionStatic.ATTENDANCE_MANAGEMENT_STATISTICS, new ExplorerTreeNode(localName.equals("zh_CN") ? "预计考勤统计" : "attendance management statistics", "attendance_management_statistics", "attendance_manage", "menuicons/icon-kaoqintongji.png",
                			new AttendanceManagementStatisticsPanel.Factory(), true, "", AttendanceManagementStatisticsPanel.class));
            	//设备管理
            	menuMap.put(ERPPermissionStatic.CLOCK_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "设备管理" : "Clock Manage", "clock_manage", "hr_managment", "menuicons/icon-shebeiguanli.png",
            			null, true,"",null));
	            	//设备列表
	            	menuMap.put(ERPPermissionStatic.CLOCK_LIST, new ExplorerTreeNode(localName.equals("zh_CN") ? "设备列表" : "Clock List", "clock_list", "clock_manage", "menuicons/icon-shebeiliebiao1.png",
	            			new ClockListPanel.Factory(), true, "", ClockListPanel.class));
	            	//员工指纹
	            	menuMap.put(ERPPermissionStatic.EMPLOYEE_FINGERS, new ExplorerTreeNode(localName.equals("zh_CN") ? "员工指纹" : "Employee Fingers", "employee_fingers", "clock_manage", "menuicons/employee.png",
	            			new EmployeeFingersPanel.Factory(), true, "", EmployeeFingersPanel.class));
	            	//员工人脸
	            	menuMap.put(ERPPermissionStatic.EMPLOYEE_FACES, new ExplorerTreeNode(localName.equals("zh_CN") ? "员工人脸" : "Employee Faces", "employee_faces", "clock_manage", "menuicons/icon-renlian.png",
	            			new EmployeeFacesPanel.Factory(), true, "", EmployeeFacesPanel.class));
	            //物品管理
				menuMap.put(ERPPermissionStatic.EQUIPMENT_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "物品管理" : "Equipment Manage", "equipment_manage", "hr_managment", "menuicons/icon-shebeiguanli.png",
						null, true,"",null));
					menuMap.put(ERPPermissionStatic.EQUIPMENT_INVENTORY_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "物品库存管理" : "Equipment Invntory Manage", "equipment_invntory_manage", "equipment_manage", "menuicons/icon-shebeiguanli.png",
						new MequipmenttypeedeeeorPanel.Factory(), true, "", MequipmenttypeedeeeorPanel.class));
					menuMap.put(ERPPermissionStatic.EQUIPMENT_DETAIL, new ExplorerTreeNode(localName.equals("zh_CN") ? "采购领用明细表" : "Equipment Detail", "equipment_detail", "equipment_manage", "menuicons/icon-shebeiguanli.png",
						new EquipmentDetailPanel.Factory(), true, "", EquipmentDetailPanel.class));
            	//薪酬管理
            	menuMap.put(ERPPermissionStatic.PAYMENT_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "薪酬管理" : "Payment Manage", "payment_manage", "hr_managment", "menuicons/icon-xinchouguanli.png",
            			null, true,"",null));
	            	//日薪管理
	            	menuMap.put(ERPPermissionStatic.DAY_PAYMENT_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "日薪管理" : "Day Payment", "day_payment", "payment_manage", "menuicons/icon-ziyuan.png",
	            			new OnLoadEmployeePaymentPanel.Factory(), true, "", OnLoadEmployeePaymentPanel.class));
	            	//月薪管理
	            	menuMap.put(ERPPermissionStatic.MONTH_PAYMENT_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "月薪管理" : "Month Payment", "month_payment", "payment_manage", "menuicons/icon-qiwangyuexin.png",
	            			new OnloadEmployeePaymentMonthDetailPanel.Factory(), true, "", OnloadEmployeePaymentMonthDetailPanel.class));
	            	//五险一金
	            	menuMap.put(ERPPermissionStatic.SOCIAL_AND_FUND, new ExplorerTreeNode(localName.equals("zh_CN") ? "五险一金" : "Social and fund", "social_and_fund", "payment_manage", "menuicons/icon-wuxianyijin1.png",
	            			new FiveInsuranceOneGoldsPanel.Factory(), true, "", FiveInsuranceOneGoldsPanel.class));

					//五险一金缴费基数
					menuMap.put(ERPPermissionStatic.SOCIAL_AND_FUND_INFO, new ExplorerTreeNode(localName.equals("zh_CN") ? "五险一金缴费基数" : "Social and fund payment base", "social_and_fund_payment_base", "payment_manage", "menuicons/icon-wuxianyijin1.png",
							new FiveInsuranceOneGoldsPaymentBasePanel.Factory(), true, "", FiveInsuranceOneGoldsPaymentBasePanel.class));
	            	//工龄工资
	            	menuMap.put(ERPPermissionStatic.SALARY_OF_WORK_YEARS, new ExplorerTreeNode(localName.equals("zh_CN") ? "工龄工资" : "Salary Of Work Years", "salary_of_work_years", "payment_manage", "menuicons/icon-butie2.png",
	            			new SalaryOfWorkYearsPanel.Factory(), true, "", SalaryOfWorkYearsPanel.class));
	            	//奖金管理
	            	menuMap.put(ERPPermissionStatic.SALARY_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "奖金管理" : "Salary Manage", "salary_manage", "payment_manage", "menuicons/icon-jiangjinguanli.png",null, true, "", null));
		            	//应发奖金
		            	menuMap.put(ERPPermissionStatic.SALARY_OF_SHOULD_BONUS, new ExplorerTreeNode(localName.equals("zh_CN") ? "应发奖金" : "Salary Of Should Bonus", "salary_of_should_bonus", "salary_manage", "menuicons/icon-yingfahanghushu-.png",
		            			new SalaryOfShouldBonusPanel.Factory(), true, "", SalaryOfShouldBonusPanel.class));
		            	//已发奖金
		            	menuMap.put(ERPPermissionStatic.SALARY_OF_FACT_BONUS, new ExplorerTreeNode(localName.equals("zh_CN") ? "已发奖金" : "Salary Of Fact Years", "salary_of_fact_bonus", "salary_manage", "menuicons/icon-yifa.png",
		            			new SalaryOfFactBonusPanel.Factory(), true, "", SalaryOfFactBonusPanel.class));
		            	//其他奖金
		            	menuMap.put(ERPPermissionStatic.SALARY_OF_OTHER_BONUS, new ExplorerTreeNode(localName.equals("zh_CN") ? "其他奖金" : "Salary Of Other Years", "salary_of_other_bonus", "salary_manage", "menuicons/icon-qita.png",
		            			new SalaryOfOtherBonusPanel.Factory(), true, "", SalaryOfOtherBonusPanel.class));
	            	//异动补发
	            	menuMap.put(ERPPermissionStatic.SALARY_SUBSIDY_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "异动补发" : "Salary Subsidy Manage", "salary_subsidy_manage", "payment_manage", "menuicons/icon-yidong.png",null, true, "", null));
		            	//补发补扣
		            	menuMap.put(ERPPermissionStatic.SALARY_FILL_SEND_DEDUCT, new ExplorerTreeNode(localName.equals("zh_CN") ? "补发补扣" : "Salary Fill Send Deduct", "salary_fill_send_deduct", "salary_subsidy_manage", "menuicons/icon-bufa.png",
		            			new OnFillSendDeductDataPanel.Factory(), true, "", OnFillSendDeductDataPanel.class));
		            	//岗位补贴
		            	menuMap.put(ERPPermissionStatic.SALARY_JOB_SUBSIDY, new ExplorerTreeNode(localName.equals("zh_CN") ? "岗位补贴" : "Salary Job Subsidy", "salary_job_subsidy", "salary_subsidy_manage", "menuicons/icon-butie.png",
		            			new OnJobSubsidysDataPanel.Factory(), true, "", OnJobSubsidysDataPanel.class));
		            	//代扣款项
		            	menuMap.put(ERPPermissionStatic.INSTEAD_DEDUCT, new ExplorerTreeNode(localName.equals("zh_CN") ? "代扣款项" : "Instead Deduct", "instead_deduct", "salary_subsidy_manage", "menuicons/icon-daikoukuan.png",
		            			new OnInsteadDeductDataPanel.Factory(), true, "", OnInsteadDeductDataPanel.class));
		            	//代扣重疾
		            	menuMap.put(ERPPermissionStatic.INSTEAD_DEDUCT_ILL, new ExplorerTreeNode(localName.equals("zh_CN") ? "代扣重疾" : "Instead Deduct Ill", "instead_deduct_ill", "salary_subsidy_manage", "menuicons/icon-daikou.png",
		            			new OnInsteadDeductIllDataPanel.Factory(), true, "", OnInsteadDeductIllDataPanel.class));
		            	//补发个税
		            	menuMap.put(ERPPermissionStatic.REPLACEMENT_TAX, new ExplorerTreeNode(localName.equals("zh_CN") ? "补发个税" : "Replacement Tax", "replacement_tax", "salary_subsidy_manage", "menuicons/icon-daikou.png",
		            			new OnReplacementTaxDataPanel.Factory(), true, "", OnReplacementTaxDataPanel.class));
		            	//其他扣除
		            	menuMap.put(ERPPermissionStatic.OTHER_DEDUCTION, new ExplorerTreeNode(localName.equals("zh_CN") ? "其他扣除" : "Other Deduction", "other_deduction", "salary_subsidy_manage", "menuicons/icon-daikou.png",
		            			new OnOtherDeductionDataPanel.Factory(), true, "", OnOtherDeductionDataPanel.class));
	            	//离职补偿
	            	menuMap.put(ERPPermissionStatic.SALARY_LEAVE_SUBSIDY, new ExplorerTreeNode(localName.equals("zh_CN") ? "离职补偿" : "Salary Leave Subsidy", "salary_leave_subsidy", "payment_manage", "menuicons/icon-buchang.png",
	            			new OnLeaveSubsidysDataPanel.Factory(), true, "", OnLeaveSubsidysDataPanel.class));
	            	//绩效工资
	            	menuMap.put(ERPPermissionStatic.PERFORMANCE_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "绩效工资" : "Performance Manage", "performance_manage", "payment_manage", "menuicons/icon-jixiaogongzi.png",null, true, "", null));
		            	//绩效等级
		            	menuMap.put(ERPPermissionStatic.SALARY_EMPLOYEE_EVALUATION, new ExplorerTreeNode(localName.equals("zh_CN") ? "绩效等级" : "Salary Employee Evaluation", "salary_employee_evaluation", "performance_manage", "menuicons/icon--jixiaodengji.png",
		            			new SsalaryemployeeevaluationrmmorPanel.Factory(), true, "", SsalaryemployeeevaluationrmmorPanel.class));
		            	//员工绩效
		            	menuMap.put(ERPPermissionStatic.SALARY_EMPLOYEE_PERFORMANCE, new ExplorerTreeNode(localName.equals("zh_CN") ? "员工绩效" : "Salary Employee Performance", "salary_employee_performance", "performance_manage", "menuicons/icon-yuangongjixiao.png",
		            			new SsalaryemployeeperformancemmeorPanel.Factory(), true, "", SsalaryemployeeperformancemmeorPanel.class));
	            	//年终奖金
	            	menuMap.put(ERPPermissionStatic.SALARY_ANNUAL_BONUS, new ExplorerTreeNode(localName.equals("zh_CN") ? "年终奖金" : "Salary Annualbonus ", "salary_annualbonus", "payment_manage", "menuicons/icon-jiangjin2.png",
	            			new SalaryAnnualbonusPanel.Factory(), true, "", SalaryAnnualbonusPanel.class));
	            	//工资表
	            	menuMap.put(ERPPermissionStatic.SALARY_TOTAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "工资表" : "Salary Total", "salary_total", "payment_manage", "menuicons/icon-gongzibiao--.png",
	            			new OnSalaryTotalDataPanel.Factory(), true, "", OnSalaryTotalDataPanel.class));
	            	//劳务报酬
	            	menuMap.put(ERPPermissionStatic.LABOR_PAYMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "劳务报酬" : "labor payment", "labor_payment", "payment_manage", "menuicons/icon-gongzibiao--.png",
	            			new OnLaborPaymentDataPanel.Factory(), true, "", OnLaborPaymentDataPanel.class));
	            	//财务报表
	            	menuMap.put(ERPPermissionStatic.CAPITAL_REPORT, new ExplorerTreeNode(localName.equals("zh_CN") ? "财务报表" : "Capital Report", "capital_report", "payment_manage", "menuicons/icon-caiwubaobiao1.png",null, true, "", null));
		            	//工资总表
		            	menuMap.put(ERPPermissionStatic.SALARY_TOTAL_OF_CAPITAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "工资总表" : "Salary Total Of Capital", "salary_total_of_capital", "capital_report", "menuicons/icon-gongzibiao.png",
		            			new OnSalaryReportByCompanyPanel.Factory(), true, "", OnSalaryReportByCompanyPanel.class));
		            	//工资分表
		            	menuMap.put(ERPPermissionStatic.SALARY_DETAIL_OF_CAPITAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "工资分表" : "Salary Detail Of Capital", "salary_detail_of_capital", "capital_report", "menuicons/icon-gongzibiaomingxi.png",
		            			new OnSalaryReportByPlatePanel.Factory(), true, "", OnSalaryReportByPlatePanel.class));
		            	//工资发放表
		            	menuMap.put(ERPPermissionStatic.SALARY_SEND_OF_CAPITAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "工资发放表" : "Salary Send Of Capital", "salary_send_of_capital", "capital_report", "menuicons/icon-shengchenggongzibiao.png",
		            			new OnSalarySendDataPanel.Factory(), true, "", OnSalarySendDataPanel.class));
		            	//募投项目表
		            	menuMap.put(ERPPermissionStatic.EMPLOYEE_SALARY_TYPEP, new ExplorerTreeNode(localName.equals("zh_CN") ? "募投项目表" : "Employee Salary Type", "employee_salary_type", "capital_report", "menuicons/icon-biaotigongzibiao_lanse.png",
		            			new EmployeeSalaryTypePanel.Factory(), true, "", EmployeeSalaryTypePanel.class));
						//工资报税表
						menuMap.put(ERPPermissionStatic.SALARY_TAX_OF_CAPITAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "工资报税表" : "Salary Tax Of Capital", "salary_tax_of_capital", "capital_report", "menuicons/icon-biaotigongzibiao_lanse.png",
								new OnSalaryTaxDataPanel.Factory(), true, "", OnSalaryTaxDataPanel.class));
		            	//奖金总表
		            	menuMap.put(ERPPermissionStatic.SALARY_BONUS_TOTAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "奖金总表" : "Salary Bonus Total", "salary_bonus_total", "capital_report", "menuicons/icon-zongbiaoshu.png",
		            			new OnSalaryBonusTotalDataPanel.Factory(), true, "", OnSalaryBonusTotalDataPanel.class));
		            	//奖金分表
		            	menuMap.put(ERPPermissionStatic.SALARY_BONUS_DETAIL, new ExplorerTreeNode(localName.equals("zh_CN") ? "奖金分表" : "Salary Bonus Detail", "salary_bonus_detail", "capital_report", "menuicons/icon-fenbiao-.png",
		            			new OnSalaryPlateBonusByPlatePanel.Factory(), true, "", OnSalaryPlateBonusByPlatePanel.class));
		            	//奖金发放表
		            	menuMap.put(ERPPermissionStatic.SALARY_BONUS_SEND, new ExplorerTreeNode(localName.equals("zh_CN") ? "奖金发放表" : "Salary Bonus Send", "salary_bonus_send", "capital_report", "menuicons/icon-yinhangfafangbiao.png",
		            			new OnSalaryBonusSendDataPanel.Factory(), true, "", OnSalaryBonusSendDataPanel.class));
		            	//工资薪酬表
		            	menuMap.put(ERPPermissionStatic.SALARY_PAYMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "工资薪酬表" : "Salary Payement", "salary_payment", "capital_report", "menuicons/icon-heduigongzibiao.png",
		            			new OnLoadSalaryPaymentByCompanyPanel.Factory(), true, "", OnLoadSalaryPaymentByCompanyPanel.class));
		            	//年终奖金总表
		            	menuMap.put(ERPPermissionStatic.SALARY_ANNUALBONUS_TOTAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "年终奖金总表" : "Salary Annualbonus Total", "salary_annualbonus_total", "capital_report", "menuicons/icon-yewutongjizongbiao.png",
		            			new OnSalaryAnnualBonusByCompanyPanel.Factory(), true, "", OnSalaryAnnualBonusByCompanyPanel.class));
		            	//年终奖金分表
		            	menuMap.put(ERPPermissionStatic.SALARY_ANNUALBONUS_DETAIL, new ExplorerTreeNode(localName.equals("zh_CN") ? "年终奖金分表" : "Salary Annualbonus Detail", "salary_annualbonus_detail", "capital_report", "menuicons/icon-biao.png",
		            			new OnSalaryAnnualBonusByPlatePanel.Factory(), true, "", OnSalaryAnnualBonusByPlatePanel.class));
		            	//年终奖金发放表
		            	menuMap.put(ERPPermissionStatic.SALARY_ANNUALBONUS_SEND, new ExplorerTreeNode(localName.equals("zh_CN") ? "年终奖金发放表" : "Salary Annualbonus Send", "salary_annualbonus_send", "capital_report", "menuicons/icon-shengchanfafangbiao.png",
		            			new SalaryAnnualbonusSendPanel.Factory(), true, "", SalaryAnnualbonusSendPanel.class));
		            	//年终奖金报税表
		            	menuMap.put(ERPPermissionStatic.SALARY_ANNUALBONUS_TAX, new ExplorerTreeNode(localName.equals("zh_CN") ? "年终奖金报税表" : "Salary Annualbonus Tax", "salary_annualbonus_tax", "capital_report", "menuicons/icon-biaodan.png",
		            			new SalaryAnnualbonusTaxPanel.Factory(), true, "", SalaryAnnualbonusTaxPanel.class));
		           //专项扣除
		          menuMap.put(ERPPermissionStatic.SPECIAL_DEDUCTION, new ExplorerTreeNode(localName.equals("zh_CN") ? "专项扣除" : "Special Deduction", "special_deduction", "payment_manage", "menuicons/icon-caiwubaobiao1.png",null, true, "", null));
		            	//个税专项扣除管理
		   			 /* menuMap.put(ERPPermissionStatic.SPECIAL_DEDUCTION_MAMAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "个税专项扣除管理" : "special deduction managerment", "special_deduction_managerment", "hr_managment", "menuicons/icon-zhiyuanguanli-.png",
		   						new SspecialdeductionrecordsssorPanel.Factory(), true,"",SspecialdeductionrecordsssorPanel.class));*/
		   			   menuMap.put(ERPPermissionStatic.SPECIAL_DEDUCTION_MAMAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "专项扣除管理" : "Special Deduction Managerment", "special_deduction_managerment", "special_deduction", "menuicons/icon-zhiyuanguanli-.png",
		   						new MspecialdeductionrecordssyeseeshsppcorPanel.Factory(), true,"",MspecialdeductionrecordssyeseeshsppcorPanel.class));
//		   			   menuMap.put(ERPPermissionStatic.SPECIAL_DEDUCTION_MAMAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "专项扣除管理" : "Special Deduction Managerment", "special_deduction_managerment", "special_deduction", "menuicons/icon-zhiyuanguanli-.png",
//		   						new MspecialdeductionrecordsorPanel.Factory(), true,"",MspecialdeductionrecordsorPanel.class));
		   			 /*//个税专项扣除纳税人管理
		   			   menuMap.put(ERPPermissionStatic.SPECIAL_DEDUCTION_EMPLOYEE_MAMAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "专项扣除纳税人管理" : "Special Deduction Employee Managerment", "special_deduction_employee_managerment", "special_deduction", "menuicons/icon-zhiyuanguanli-.png",
		   					   new SspecialdeductionseporPanel.Factory(), true,"",SspecialdeductionseporPanel.class));*/
		   			   //月专项扣除表
		   			   menuMap.put(ERPPermissionStatic.SPECIAL_DEDUCTION_MONTH_MAMAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "月专项扣除表" : "Special Deduction Month Managerment", "special_deduction_month_managerment", "special_deduction", "menuicons/icon-zhiyuanguanli-.png",
		   					   new SspecialdeductionmonthdetailedporPanel.Factory(), true,"",SspecialdeductionmonthdetailedporPanel.class));

            	menuMap.put(ERPPermissionStatic.SALARY_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "人工成本" : "Employee Salary", "salary_managment", "hr_managment", "menuicons/icon-chengbenshouyi-rengongchengben1.png",
                    new MemployeeSalaryPanel.Factory(), true,"", MemployeeSalaryPanel.class));
                menuMap.put(ERPPermissionStatic.CHANGE_PLATE_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "转岗汇总" : "change_plate", "change_plate", "hr_managment", "menuicons/icon-Artboard.png",
                    new MEmployeeChangePlateDetailPanel.Factory(), true, "", MEmployeeChangePlateDetailPanel.class));
                menuMap.put(ERPPermissionStatic.MY_TEAM_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "我的团队" : "My Team", "my_team", "hr_managment", "menuicons/icon-wodetuandui.png",
                		new SplateManagerPanel.Factory(), true, "", SplateManagerPanel.class));
                menuMap.put(ERPPermissionStatic.EMPLOYEE_PLATE_RECORD_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "职员每月所属业务部门记录" : "employee_plate_record", "employee_plate_record", "hr_managment", "menuicons/icon-meiyue.png",
                    new MemployeechangeplaterecordeeepyseorPanel.Factory(), true, "", MemployeechangeplaterecordeeepyseorPanel.class));
                //职员每日所属业务部门记录
                menuMap.put(ERPPermissionStatic.EMPLOYEE_DAY_PLATE_RECORD_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "职员每日所属业务部门记录" : "employee_day_plate_record", "employee_day_plate_record", "hr_managment", "menuicons/icon-meiri.png",
                        new OnEmployeeDayPlateRecordsPanel.Factory(), true, "", OnEmployeeDayPlateRecordsPanel.class));
                menuMap.put(ERPPermissionStatic.CARD_MANAGE_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "卡号管理" : "Card Manage", "card_manage", "hr_managment", "menuicons/icon-qiahaoguanli.png",
                		new EmployeeCardManagePanel.Factory(), true, "", EmployeeCardManagePanel.class));
            	 //员工合同管理
                menuMap.put(ERPPermissionStatic.EMPLOYEE_CONTRACT_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "劳动合同" : "Employee Contract Manage", "employee_contract_manage", "hr_managment", "menuicons/icon-laodonghetong1.png",
                		new EmployeeContractAttachmentPanel.Factory(), true,"",EmployeeContractAttachmentPanel.class));
                menuMap.put(ERPPermissionStatic.RESIGN_EMPLOYEE, new ExplorerTreeNode(localName.equals("zh_CN") ? "离职员工" : "Resign Employee", "resign_employee", "hr_managment", "menuicons/icon-yglz.png",
                		new ResignEmployeeEachYearPanel.Factory(), true,"",ResignEmployeeEachYearPanel.class));
                menuMap.put(ERPPermissionStatic.UPDATE_FROZEN_INTEGRAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "离职员工冻结积分修改" : "Update Frozen Integral", "update_frozen_integral", "hr_managment", "menuicons/icon-yglz.png",
                		new UpdateFrozenIntegralPanel.Factory(), true,"",UpdateFrozenIntegralPanel.class));
                //统计入职员工人数
                menuMap.put(ERPPermissionStatic.ONBOARD_EMPLOYEE, new ExplorerTreeNode(localName.equals("zh_CN") ? "入职员工" : "Onboard Employee Each Year", "onboard_employee_each_year", "hr_managment", "menuicons/icon-ruzhi.png",
                		new OnboardEmployeeEachYearPanel.Factory(), true,"",OnboardEmployeeEachYearPanel.class));
                menuMap.put(ERPPermissionStatic.CAR_ALLOCATION, new ExplorerTreeNode(localName.equals("zh_CN") ? "用车成本汇总" : "Car allocation", "car_allocation", "hr_managment", "menuicons/icon-yongche.png",
                		new CarCostAllocationEachMonthPanel.Factory(), true,"",CarCostAllocationEachMonthPanel.class));
                //业务板块维护
                menuMap.put(ERPPermissionStatic.PLATE_LINK_DEPARTMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "业务板块维护" : "Plate Manage", "plate_manage", "hr_managment", "menuicons/icon-code-yewubankuai.png",
                		new PlateRecordPanel.Factory(), true,"",PlateRecordPanel.class));
                //任务列表查询
                menuMap.put(ERPPermissionStatic.THREAD_TASK_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "任务列表查询" : "Thread task Manage", "thread_task_manage", "hr_managment", "menuicons/icon-taskList.png",
                		new SthreadtaskmanagemmmorPanel.Factory(), true, "", SthreadtaskmanagemmmorPanel.class));
              //培训管理
                menuMap.put(ERPPermissionStatic.TRAINING_MANAGERMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "培训管理" : "Training managerment", "training_managerment", "hr_managment", "menuicons/icon-peixunguanli.png",
                    null, true,"",null));
                	//培训管理
                	menuMap.put(ERPPermissionStatic.TRAINING_MANAGEMENTS, new ExplorerTreeNode(localName.equals("zh_CN") ? "培训管理" : "Training managerments", "training_managerments", "training_managerment", "menuicons/icon-peixunguanli.png",
                			new TrainingManagementPanel.Factory(), true, "", TrainingManagementPanel.class));
                	//员工积分
                	menuMap.put(ERPPermissionStatic.EMPLOYEE_INTEGRAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "员工培训分数" : "Employee integral", "employee_integral", "training_managerment", "menuicons/icon-yuangongpeixun.png",
                			new EmployeeItegralPanel.Factory(), true, "", EmployeeItegralPanel.class));
                	//物品领取
                	menuMap.put(ERPPermissionStatic.GOODS_RECEIVE, new ExplorerTreeNode(localName.equals("zh_CN") ? "物品领取" : "goods receive", "goods_receive", "training_managerment", "menuicons/icon-icon-.png",
                			new GoodsreceivePanel.Factory(), true, "", GoodsreceivePanel.class));
                	//培训管理汇总
                	menuMap.put(ERPPermissionStatic.ABOUT_TRAINING_MANAGEMENTS, new ExplorerTreeNode(localName.equals("zh_CN") ? "培训管理汇总" : " About Training managerment", "About Training managerment", "training_managerment", "menuicons/icon-shebeiliebiao1.png",
                			new AboutTrainingManagementPanel.Factory(), true, "", AboutTrainingManagementPanel.class));
              //公司管理
              menuMap.put(ERPPermissionStatic.COMPANY_MAMAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "公司管理" : "Company managerment", "company_managerment", "hr_managment", "menuicons/icon-kehuguanli.png",
            		  new CompanyareaPanel.Factory(), true,"",CompanyareaPanel.class));
              //岗位管理
			  menuMap.put(ERPPermissionStatic.JOB_MAMAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "岗位管理" : "Job managerment", "job_managerment", "hr_managment", "menuicons/icon-zhiyuanguanli-.png",
					new JobManagementPanel.Factory(), true,"",JobManagementPanel.class));

		      //会议室管理
		      menuMap.put(ERPPermissionStatic.MEETING_ROOM_MAMAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "会议室管理" : "Meeting room managerment", "meetin_room_managerment", "hr_managment", "menuicons/icon-zhiyuanguanli-.png",
							new MeetingRoomManagementPanel.Factory(), true,"",MeetingRoomManagementPanel.class));
		      //印章保管维护
		menuMap.put(ERPPermissionStatic.SEAL_PRESERVATION_MAINTENANCE, new ExplorerTreeNode(localName.equals("zh_CN") ? "印章管理" : "seal preservation maintenance", "seal_preservation_maintenance", "hr_managment", "menuicons/icon-zhiyuanguanli-.png",
				new sealKeepersWorkflowPanel.Factory(), true,"",sealKeepersWorkflowPanel.class));
		//职级系数维护
		menuMap.put(ERPPermissionStatic.RANK_MAINTENANCE, new ExplorerTreeNode(localName.equals("zh_CN") ? "职级系数管理" : "rank maintenance", "rank_maintenance", "hr_managment", "menuicons/icon-zhiyuanguanli-.png",
				new RankMaintenancePanel.Factory(), true,"",RankMaintenancePanel.class));

		menuMap.put(ERPPermissionStatic.MARKET_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "营销管理" : "Market Manage", "market_managment", "root", "menuicons/icon-yingxiaoguanli01.png", null, true, "", null));
		menuMap.put(ERPPermissionStatic.PRE_PROJECTS, new ExplorerTreeNode(localName.equals("zh_CN") ? "前期项目" : "Pre Project Informations", "pre_project_informations", "market_managment", "menuicons/icon-qianqixiangmu.png",
        		new projectPreInfomationsPanel.Factory(), true, "", projectPreInfomationsPanel.class));
		menuMap.put(ERPPermissionStatic.PROJECT_INFO_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "立项管理" : "Project Info", "main_project", "market_managment", "menuicons/icon-lixiangguanli.png",
                    new MainProjectPanel.Factory(), true, "", MainProjectPanel.class));
                menuMap.put(ERPPermissionStatic.OUT_QUOTATIONS_INFO_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "报价管理" : "Project Info", "order_main_project", "market_managment", "menuicons/icon-quote.png",
                        null, true, "", null));
                	menuMap.put(ERPPermissionStatic.BJD_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "报价单" : "Project Info", "bjd_main_project", "order_main_project", "menuicons/icon-baojiadan.png",
                			new OrderMainProjectPanel.Factory(), true, "", OrderMainProjectPanel.class));
                	menuMap.put(ERPPermissionStatic.HTBJB_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "合同报价表" : "Project Info", "htbjb_main_project", "order_main_project", "menuicons/icon-baojiadan.png",
                			new ContractPricePanel.Factory(), true, "", ContractPricePanel.class));
//                	menuMap.put(ERPPermissionStatic.CFJ_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "拆分价" : "Project Info", "cfj_main_project", "order_main_project", "menuicons/icon-chaifen.png",
//                			new SplitMainProjectPanel.Factory(), true, "", SplitMainProjectPanel.class));
//                	menuMap.put(ERPPermissionStatic.STANDARD_QUOTE, new ExplorerTreeNode(localName.equals("zh_CN") ? "标准报价" : "Standard Quote", "standard_quote", "order_main_project", "menuicons/icon-biaozhunbaojiadan.png",
//                			new StandardQuotePanel.Factory(), true, "", StandardQuotePanel.class));
//                	menuMap.put(ERPPermissionStatic.QUOTE_TEMPLATE, new ExplorerTreeNode(localName.equals("zh_CN") ? "报价模板" : "Quote template", "quote_template", "order_main_project", "menuicons/icon-biaozhunbaojiadan.png",
//                			new AboutProjectQuoteTemplatesParentPanel.Factory(), true, "", AboutProjectQuoteTemplatesParentPanel.class));
                menuMap.put(ERPPermissionStatic.FINALLTY_INFO_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "合同管理" : "Contract Info", "formal_contract", "market_managment", "menuicons/icon-contract.png",
                        null, true, "",null));// SformalcontractcccorPanel.class
//                	menuMap.put(ERPPermissionStatic.FINALLTY_SECOND_INFO_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "创建合同" : "Create Contract Info", "create_contract", "formal_contract", "silk/layout_content.png",
//            			new CreateContractMainProjectPanel.Factory(), true, "", CreateContractMainProjectPanel.class));
                	menuMap.put(ERPPermissionStatic.SK_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "收款阶段" : "Create Collection stage", "collection_stage", "formal_contract", "menuicons/icon-xiugaishoukuanjieduan_huaban.png",
                			new ScontractPanel.Factory(), true, "", ScontractPanel.class));
                	menuMap.put(ERPPermissionStatic.CONTRACT_MANAGEMENT_INFO, new ExplorerTreeNode(localName.equals("zh_CN") ? "合同文件" : "Contract info", "my_contract_info", "formal_contract", "menuicons/icon-hetongwenjian.png",
                			new ScontractppcorPanel.Factory(), true, "", ScontractppcorPanel.class));
                	menuMap.put(ERPPermissionStatic.CONTRACTS_RECORDS, new ExplorerTreeNode(localName.equals("zh_CN") ? "合同跟踪记录汇总" : "Contracts Records", "contracts_records", "formal_contract", "menuicons/icon-bangzhu-hetonggenzong.png",
                			new  ContractsRecordsPanel.Factory(), true, "", ContractsRecordsPanel.class));
                	menuMap.put(ERPPermissionStatic.CREATE_CONTRACT_CODE, new ExplorerTreeNode(localName.equals("zh_CN") ? "创建合同编号" : "Contract code", "contract_code", "formal_contract", "menuicons/icon-paimingbianhao.png",
                			new McecscreeorPanel.Factory(), true, "", McecscreeorPanel.class));
                	menuMap.put(ERPPermissionStatic.CONTRACT_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "合同维护" : "Contract maintenance", "contract_maintenance", "formal_contract", "menuicons/icon-yonghubiaoduanhetongweihu.png",
                			new ContractManagePanel.Factory(), true, "", ContractManagePanel.class));
                	menuMap.put(ERPPermissionStatic.CONTRACT_ATTACHMENT_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "合同文件库" : "Contract attachments", "contract_attachment", "formal_contract", "menuicons/icon-hetongwenjian1.png",
                			new OnLoadContractAttachmentDataPanel.Factory(), true, "", OnLoadContractAttachmentDataPanel.class));
                	menuMap.put(ERPPermissionStatic.RECEIVABLE_TEMPLATE, new ExplorerTreeNode(localName.equals("zh_CN") ? "收款阶段模板" : "Receivable Template", "receivable_template", "formal_contract", "menuicons/icon-moban.png",
                    new ScontractreceivabletemplaterrcorPanel.Factory(), true, "", ScontractreceivabletemplaterrcorPanel.class));
                menuMap.put(ERPPermissionStatic.CUSTOMER_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "客户管理" : "Customer Manage", "customer_managment", "market_managment", "menuicons/icon-kehuguanli.png",
                		new OnLoadCustomerDataPanel.Factory(), true, "", OnLoadCustomerDataPanel.class));
                menuMap.put(ERPPermissionStatic.CUSTOMER_RESOURCES, new ExplorerTreeNode(localName.equals("zh_CN") ? "客户资源" : "Customer Resources", "customer_resources", "market_managment", "menuicons/icon-kehuziyuan1.png",
                		new CustomerResourcesPanel.Factory(), true, "", CustomerResourcesPanel.class));
                menuMap.put(ERPPermissionStatic.HOLIDAY_BLESS, new ExplorerTreeNode(localName.equals("zh_CN") ? "节日祝福" : "Holiday Bless", "holiday_bless", "market_managment", "menuicons/icon-jierizhufu.png",
                		new HolidayBlessPanel.Factory(), true, "", HolidayBlessPanel.class));
                menuMap.put(ERPPermissionStatic.AREA_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "区域管理" : "Area Manage", "area_manage", "market_managment", "menuicons/icon-quyuguanli.png",
                		new SareaaaorPanel.Factory(), true, "", SareaaaorPanel.class));
                menuMap.put(ERPPermissionStatic.COMMISSION_ALLOCATION, new ExplorerTreeNode(localName.equals("zh_CN") ? "提成分配" : "Commission allocation", "commission_allocation", "market_managment", "menuicons/icon-web-icon-.png",
                       null, true,"",null));
//                	menuMap.put(ERPPermissionStatic.COMMISSION_ALLOCATIONS, new ExplorerTreeNode(localName.equals("zh_CN") ? "提成分配" : "Allocation team1", "allocation_team1", "commission_allocation", "silk/layout_content.png",
//               			new ContractDistributionPanel.Factory(), true, "", ContractDistributionPanel.class));
                	menuMap.put(ERPPermissionStatic.ALLOCATION_TEAM, new ExplorerTreeNode(localName.equals("zh_CN") ? "分配团队" : "Allocation team", "allocation_team", "commission_allocation", "menuicons/icon-fenpeituandui.png",
               			new NewContractDistributionPanel.Factory(), true, "", NewContractDistributionPanel.class));
                	menuMap.put(ERPPermissionStatic.SHOW_CONTRACT_DISTRIBUTION, new ExplorerTreeNode(localName.equals("zh_CN") ? "提成计算" : "show contract distribution", "show_contract_distribution", "commission_allocation", "menuicons/icon-tichengguize.png",
                   			new ShowContractDistributionPanel.Factory(), true, "", ShowContractDistributionPanel.class));
					menuMap.put(ERPPermissionStatic.SHOW_CONTRACT_DISTRIBUTION_NEW, new ExplorerTreeNode(localName.equals("zh_CN") ? "提成计算(新)" : "show contract distribution new", "show_contract_distribution_new", "commission_allocation", "menuicons/icon-tichengguize.png",
							new ContractDistributionNewPanel.Factory(), true, "", ContractDistributionNewPanel.class));
                	menuMap.put(ERPPermissionStatic.OLD_PROJECT_REVENU, new ExplorerTreeNode(localName.equals("zh_CN") ? "订单提成" : "show old project revenue", "show_old_project_revenue", "commission_allocation", "menuicons/icon-ticheng.png",
                   			new ShowOldProjectRevenuePanel.Factory(), true, "", ShowOldProjectRevenuePanel.class));
					menuMap.put(ERPPermissionStatic.CONTRACT_COMMISSION_DETAIL, new ExplorerTreeNode(localName.equals("zh_CN") ? "提成报表" : "contract commission detail", "contract_commission_detail", "commission_allocation", "menuicons/icon-ticheng.png",
							new ContractCommissionDetailPanel.Factory(), true, "", ContractCommissionDetailPanel.class));
				menuMap.put(ERPPermissionStatic.ACTIVITY_MEET_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "差旅&会议" : "Activity Meet Manage", "activity_meet_manage", "market_managment", "menuicons/icon-chalv.png",
                		new ActivityMeetManagePanel.Factory(), true, "", ActivityMeetManagePanel.class));
                menuMap.put(ERPPermissionStatic.COMPETITION_UNITS, new ExplorerTreeNode(localName.equals("zh_CN") ? "竞争对手" : "Competition Unit", "competition_unit", "market_managment", "menuicons/icon-jingzhengduishou.png",
                		new OnLoadCompetitionUnitsDataPanel.Factory(), true, "", OnLoadCompetitionUnitsDataPanel.class));

				menuMap.put(ERPPermissionStatic.POOL_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "池子管理" : "Pool Manage", "pool_manage", "market_managment", "menuicons/icon-qianqixiangmu.png",
                		new OnloadPoolDataPanel.Factory(), true, "", OnloadPoolDataPanel.class));
				menuMap.put(ERPPermissionStatic.PRODUCTION_VALUE_COEFFICIENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "产值系数管理" : "Production Value Coefficient", "production_value_coefficient", "market_managment", "menuicons/icon-qianqixiangmu.png",
						new SproductionvaluecoefficienttypeporPanel.Factory(), true, "", SproductionvaluecoefficienttypeporPanel.class));
				//运营管理
				menuMap.put(ERPPermissionStatic.OPERATE_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "运营管理" : "Operate Manage", "operate_managment", "root", "menuicons/icon-yunyingguanli.png", null, true, "", null));
            	menuMap.put(ERPPermissionStatic.PRE_REIMBURSEMENT_PROJECT, new ExplorerTreeNode(localName.equals("zh_CN") ? "前期报销项目" : "Reimbursement Project Info", "meimbursement_project", "operate_managment", "menuicons/icon-baoxiao.png",
                    new PreProjectReimbursementNumbersPanel.Factory(), true, "", PreProjectReimbursementNumbersPanel.class));

            	menuMap.put(ERPPermissionStatic.SHEET_INFO_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "订单管理" : "Sheet Manage", "sheet_manage", "operate_managment", "menuicons/icon-dingdanguanli.png", null, true, "", null));
            		menuMap.put(ERPPermissionStatic.SHEET_SEND_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "订单下达" : "Sheet Send", "sheet_send", "sheet_manage", "menuicons/icon-xiada.png", null, true, "", null));
            			menuMap.put(ERPPermissionStatic.CONTRACT_INFO_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "订单信息" : "Sheet Info", "sheet_info", "sheet_send", "menuicons/icon-dingdanxinxi.png",
                            new ScontractcccorPanel.Factory(), true, "", ScontractcccorPanel.class));
//            			menuMap.put(ERPPermissionStatic.YUNY_PRICE_INFO_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "订单审核列表" : "Main Contract Three", "main_contract_three", "sheet_send", "menuicons/icon-shenhe.png",
//    	                        new SAuditcontractcccorPanel.Factory(), true, "", SAuditcontractcccorPanel.class));
            			menuMap.put(ERPPermissionStatic.SENDED_SHEET_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "已下达订单" : "Sended sheet", "sended_sheet", "sheet_send", "menuicons/icon-dingdan.png",
            					new ContractSendedPanel.Factory(), true, "", ContractSendedPanel.class));

            	menuMap.put(ERPPermissionStatic.MY_STAGE_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "阶段分配" : "My Stage", "my_stage", "sheet_manage", "menuicons/icon-icon2-copy.png",null, true, "", null));
            			menuMap.put(ERPPermissionStatic.CONFIRMABLE_PHASES, new ExplorerTreeNode(localName.equals("zh_CN") ? "可分配阶段确认" : "Confirmable Phases", "confirmable_phases", "my_stage", "menuicons/icon-dingdan.png",
            					new ConfirmablePhasesListPanel.Factory(), true, "", ConfirmablePhasesListPanel.class));
            			menuMap.put(ERPPermissionStatic.CONTRACT_MESSAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "收款与出图阶段报警记录" : "Contract Message", "contract message", "my_stage", "menuicons/icon-dingdan.png",
            					new OnLoadContractMessageRecordPanel.Factory(), true, "", OnLoadContractMessageRecordPanel.class));

        			menuMap.put(ERPPermissionStatic.MY_PROJECT_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "我的订单" : "My Sheet", "my_sheet", "sheet_manage", "menuicons/icon-icon2-copy.png",null, true, "", null));
                        //事业部负责人项目
//                        menuMap.put(ERPPermissionStatic.PLATE_MANAGE_PROJECT_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "事业部管理项目" : "My Manage Project", "plate_manage_project", "my_sheet", "menuicons/icon-guanlixiangmu.png",
//                            new MDepartmentDirectorPanel.Factory(), true, "", MDepartmentDirectorPanel.class));
                        //运营管理员项目  改部门经理项目
                        menuMap.put(ERPPermissionStatic.OPERATE_MANAGE_PROJECT_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "部门经理项目" : "My Manage Project", "operate_manage_project", "my_sheet", "menuicons/icon-project.png",
                            new ProjectManagerPanel.Factory(), true, "", ProjectManagerPanel.class));
                        menuMap.put(ERPPermissionStatic.INITIATE_DESIGN_MANAGE_PROJECT_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "方案主创管理项目" : "My Manage Project", "initiate_design_manage_project", "my_sheet", "menuicons/icon-guanlixiangmu.png",
                                new OnLoadProjectTransitionRecordPanel.Factory(), true, "", OnLoadProjectTransitionRecordPanel.class));
                        //积分管理员项目 改专业负责人项目
                        menuMap.put(ERPPermissionStatic.INTEGRAL_MANAGE_PROJECT_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "专业负责人项目" : "My Manage Project", "integral_manage_project", "my_sheet", "menuicons/icon-jifenguanli.png",
                            new SprojectManagerPanel.Factory(), true, "", SprojectManagerPanel.class));
                        //订单汇总
                        menuMap.put(ERPPermissionStatic.PROJECT_GATHER_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "订单汇总" : "Sheet Report", "sheet_report", "my_sheet", "menuicons/icon-dingdanhuizong.png",
                                new ProjectReportRecordDetailPanel.Factory(), true, "", ProjectReportRecordDetailPanel.class));
                        //我参与的项目
                        menuMap.put(ERPPermissionStatic.MY_TAKEPARTIN_PROJECT_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "我参与的项目" : "My Take Part In Project", "my_takePartIn_project", "my_sheet", "menuicons/icon-wocanyudexiangmu.png",
                            new DesignerProjectPanel.Factory(), true, "", DesignerProjectPanel.class));
                        //我的邀请
//                        menuMap.put(ERPPermissionStatic.MY_INVITE_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "我的邀请" : "My Invite", "my_invite", "my_sheet", "silk/layout_content.png",
//                            new MprojectemployeeporPanel.Factory(), true, "", MprojectemployeeporPanel.class));
                        //项目成本
                        menuMap.put(ERPPermissionStatic.PROJECT_COST_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "项目成本" : "Project Cost", "project_cost", "my_sheet", "menuicons/icon-xiangmuchengbencaigou.png",
                                new ProjectCostRecordPanel.Factory(), true, "", ProjectCostRecordPanel.class));
                        //采买订单汇总
                        menuMap.put(ERPPermissionStatic.PROJECT_BUY_COSTS, new ExplorerTreeNode(localName.equals("zh_CN") ? "采买订单汇总" : "Project Buy Cost", "project_buy_cost", "my_sheet", "menuicons/icon-shuoyoudingdanhuizong.png",
                                new ProjectBuyCostsPanel.Factory(), true, "", ProjectBuyCostsPanel.class));
						//项目积分补贴汇总
						menuMap.put(ERPPermissionStatic.PROJECT_ADVANCE_DETAIL, new ExplorerTreeNode(localName.equals("zh_CN") ? "项目积分补贴汇总" : "Project Advance Detail", "project_advance_detail", "my_sheet", "menuicons/icon-shuoyoudingdanhuizong.png",
								new projectAdvanceDetailPanel.Factory(), true, "", projectAdvanceDetailPanel.class));
            	//研发管理
                menuMap.put(ERPPermissionStatic.DEVELOP_PROJECT_MANAGEMENT_MENU, new ExplorerTreeNode(localName.equals("zh_CN") ? "研发管理" : "Develop Manage", "develop_manage", "operate_managment", "menuicons/icon-yanfaguanli.png",
                		new OnDevelopProjectPanel.Factory(), true, "", OnDevelopProjectPanel.class));
                //资源管理
                menuMap.put(ERPPermissionStatic.MANAGE_PROJECT_MANAGEMENT_MENU, new ExplorerTreeNode(localName.equals("zh_CN") ? "资源管理" : "Resource Manage", "resource_manage", "operate_managment", "menuicons/icon-ziyuanguanli.png",
                		new OnManageProjectPanel.Factory(), true, "", OnManageProjectPanel.class));
        		 menuMap.put(ERPPermissionStatic.ACCOUNT_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "账户管理" : "Account Manage", "account_manage", "operate_managment", "menuicons/icon-zhanghuguanli.png", null, true, "", null));
            		menuMap.put(ERPPermissionStatic.COMPANY_ACCOUNT_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "公司账户" : "Company Account", "company_account", "account_manage", "menuicons/icon-gongsizhanghu.png",
                        new CompanyReportIntegralPanel.Factory(), true, "", CompanyReportIntegralPanel.class));
            		menuMap.put(ERPPermissionStatic.PLATE_ACCOUNT_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "部门账户" : "Plate Account", "plate_account", "account_manage", "menuicons/icon-zhanghu.png",
            				new PlateAccountPanel.Factory(), true, "", PlateAccountPanel.class));
            		menuMap.put(ERPPermissionStatic.PERSONAL_ACCOUNT_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "个人账户" : "Personal Account", "personal_account", "account_manage", "menuicons/icon-gerenzhanghu.png",
                            new EmployeeAccountPanel.Factory(), true, "", EmployeeAccountPanel.class));
            		menuMap.put(ERPPermissionStatic.QUALITY_FUND_ACCOUNT, new ExplorerTreeNode(localName.equals("zh_CN") ? "品质基金" : "Quality fund", "quality_fund", "account_manage", "menuicons/icon-jijin.png",
            				new QualityFundAccountPanel.Factory(), true, "", QualityFundAccountPanel.class));
            		menuMap.put(ERPPermissionStatic.PROJECT_ACCOUNT, new ExplorerTreeNode(localName.equals("zh_CN") ? "项目账户" : "Project Account", "project_account", "account_manage", "menuicons/icon-xiangmuzhanghuguanli.png",
            				new ProjectAccountPanel.Factory(), true, "", ProjectAccountPanel.class));
            		menuMap.put(ERPPermissionStatic.SHEET_ACCOUNT, new ExplorerTreeNode(localName.equals("zh_CN") ? "订单账户" : "Sheet Account", "sheet_account", "account_manage", "menuicons/icon-zhanghu1.png",
            				new SheetAccountPanel.Factory(), true, "", SheetAccountPanel.class));
            		menuMap.put(ERPPermissionStatic.AWARD_SEND_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "奖金管理" : "Award Manage", "award_manage", "account_manage", "menuicons/icon-jiangjinguanli.png",
            				new OperatingReportIntegralPanel.Factory(), true, "", OperatingReportIntegralPanel.class));
		            		//奖金补贴
		                    menuMap.put(ERPPermissionStatic.MANAGE_PROJECT_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "奖金补贴" : "Manage Project", "manage_project", "award_manage", "menuicons/icon-butie1.png",
		                            new ManageProjectPanel.Factory(), true, "", ManageProjectPanel.class));
							menuMap.put(ERPPermissionStatic.BONUS_PAYMENT_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "奖金发放" : "Bonus Payment Management", "bonus_payment_management", "award_manage", "menuicons/icon-xiangmufuzerenjiangjinfafangshenqing.png",
								new BonusPaymentRecordPanel.Factory(), true, "", BonusPaymentRecordPanel.class));
							menuMap.put(ERPPermissionStatic.AWARD_SEND_REPORT_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "奖金汇总" : "Award Report", "award_report", "award_manage", "menuicons/icon-xiangmujiangjinhuizong.png",
		            				new OperatingReportIntegralPanel.Factory(), true, "", OperatingReportIntegralPanel.class));
				//进度管理
				menuMap.put(ERPPermissionStatic.REVENUE_INFO_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "进度管理" : "Revenue Manage", "revenue_manage", "operate_managment", "menuicons/icon-line-schedule.png", null, true, "", null));
					menuMap.put(ERPPermissionStatic.REVENUE_PROJECT_PROGRESS_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "项目进度表" : "Project Progress", "project_progress", "revenue_manage", "menuicons/icon-xiangmuzongtijindubiao.png",
        				new ProjectSureDateRecordPanel.Factory(), true, "", ProjectSureDateRecordPanel.class));
					menuMap.put(ERPPermissionStatic.REVENUE_ACCOUNT_WEIGHT_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "会计权重表" : "Account Weight", "account_weight", "revenue_manage", "menuicons/icon-biaoge.png",
	        				new AccountWeightRecordPanel.Factory(), true, "", AccountWeightRecordPanel.class));
					menuMap.put(ERPPermissionStatic.REVENUE_BUSINESS_STATE_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "会计业态表" : "Business State", "business_state", "revenue_manage", "menuicons/icon-biaoge1.png",
							new BusinessStateRecordPanel.Factory(), true, "", BusinessStateRecordPanel.class));
					menuMap.put(ERPPermissionStatic.REVENUE_FINISH_SURE_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "完工确认表" : "Finish Sure", "finish_sure", "revenue_manage", "menuicons/icon-biaoge2.png",
							new FinishPercentSurePanel.Factory(), true, "", FinishPercentSurePanel.class));
					menuMap.put(ERPPermissionStatic.REVENUE_ACCOUNT_REVENUE_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "会计营收表" : "Account Revenue", "account_revenue", "revenue_manage", "menuicons/icon-icon-test.png",
							new OnBusinessStateRevenuePanel.Factory(), true, "", OnBusinessStateRevenuePanel.class));
					menuMap.put(ERPPermissionStatic.REVENUE_ATTACHMENT_MANAGE_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "确认函管理" : "Attachment Manage", "attachment_manage_management", "revenue_manage", "menuicons/icon-queren.png",
	            			new ProjectAttachmentManagePanel.Factory(), true, "", ProjectAttachmentManagePanel.class));
				//运营营收
				menuMap.put(ERPPermissionStatic.OPERATE_REVENUE_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "运营营收" : "Operate Revenue", "operate_revenue", "operate_managment", "menuicons/icon-yingshou.png", null, true, "", null));
					//部门税率
					menuMap.put(ERPPermissionStatic.PLATE_RATE_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "部门税率" : "Plate Rate", "plate_rate", "operate_revenue", "menuicons/icon-shuilv.png",
							new PlateRateOfRevenuePanel.Factory(), true, "", PlateRateOfRevenuePanel.class));
					//订单金额
					menuMap.put(ERPPermissionStatic.SHEET_AMOUNT_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "订单金额" : "Sheet Amount", "sheet_amount", "operate_revenue", "menuicons/icon-dingdanjine.png",
							new SheetAmountStatisticalOfRevenuePanel.Factory(), true, "", SheetAmountStatisticalOfRevenuePanel.class));
					//营收统计
					menuMap.put(ERPPermissionStatic.REVENUE_STATISTICAL_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "营收统计" : "Revenue Statistical", "revenue_statistical", "operate_revenue", "menuicons/icon-yingshoutongji-.png",
							new RevenueStatisticalOfRevenuePanel.Factory(), true, "", RevenueStatisticalOfRevenuePanel.class));
					//外部收入确认表
					menuMap.put(ERPPermissionStatic.OUT_ACHIEVE_SURE, new ExplorerTreeNode(localName.equals("zh_CN") ? "外部收入确认表" : "out achieve sure", "out_achieve_sure", "operate_revenue", "menuicons/icon-surelist.png",
							new OnLoadOutAchieveSurePanel.Factory(), true, "", OnLoadOutAchieveSurePanel.class));
					//内部收入明细表
					menuMap.put(ERPPermissionStatic.IN_ACHIEVE_DETAIL, new ExplorerTreeNode(localName.equals("zh_CN") ? "内部收入明细表" : "in achieve detail", "in_achieve_detail", "operate_revenue", "menuicons/icon-shourumingxi.png",
							new OnLoadInAchieveDetailPanel.Factory(), true, "", OnLoadInAchieveDetailPanel.class));
					//营收回款
					menuMap.put(ERPPermissionStatic.IN_ACHIEVE_DETAIL, new ExplorerTreeNode(localName.equals("zh_CN") ? "营收和回款" : "revenue capitals", "revenue_capitals", "operate_revenue", "menuicons/icon-shourumingxi.png",
							new RevenueCapitalsInfoPanel.Factory(), true, "", RevenueCapitalsInfoPanel.class));
				//合同与订单
				menuMap.put(ERPPermissionStatic.MANAGE_CONTRACT_LINK_PROJECT, new ExplorerTreeNode(localName.equals("zh_CN") ? "合同与订单" : "Contract Link Project", "contract_link_project", "operate_managment", "menuicons/icon-hetongdingdan1.png",
						new McontractppspcccfscsiiicporPanel.Factory(), true, "", McontractppspcccfscsiiicporPanel.class));
				//历史合同状态
				menuMap.put(ERPPermissionStatic.CONTRACT_HISTORY_STATUS, new ExplorerTreeNode(localName.equals("zh_CN") ? "历史合同状态" : "Contract History Status", "contract_history_status", "operate_managment", "menuicons/icon-contract-status.png",
						new ContractStatusHistoryPanel.Factory(), true, "", ContractStatusHistoryPanel.class));

				//人员配置表
				menuMap.put(ERPPermissionStatic.TALENTS_MINIMUM_ARRANGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "人员配置表" : "Talents minimum arrangement", "talents_minimum_arrangement", "operate_managment", "menuicons/icon-renyuanshezhi.png",
	                    new PersonArrangementPanel.Factory(), true, "", PersonArrangementPanel.class));
				//运营变更信息
				menuMap.put(ERPPermissionStatic.CONTRACT_CHANGE_LIST, new ExplorerTreeNode(localName.equals("zh_CN") ? "运营变更信息" : "contract change list", "contract_change_list", "operate_managment", "menuicons/icon-biangeng.png",
	                    new ContractChangeListPanel.Factory(), true, "", ContractChangeListPanel.class));
				//确认函管理
				menuMap.put(ERPPermissionStatic.ATTACHMENT_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "确认函管理" : "Attachment Manage", "attachment_manage", "operate_managment", "menuicons/icon-confirm.png",null, true, "", null));
					menuMap.put(ERPPermissionStatic.ATTACHMENT_LIST, new ExplorerTreeNode(localName.equals("zh_CN") ? "确认函列表" : "Attachment List", "attachment_list", "attachment_manage", "menuicons/icon-queren.png",
							new OnLoadAttachmentDataOfAttachmentPanel.Factory(), true, "", OnLoadAttachmentDataOfAttachmentPanel.class));

					menuMap.put(ERPPermissionStatic.ATTACHMENT_CONTRACT_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "合同确认函管理" : "Attachment Contract Manage", "attachment_contract_manage", "attachment_manage", "menuicons/icon-hetongqueren.png",
							new McontractcacccccaaaraabbifiiorPanel.Factory(), true, "", McontractcacccccaaaraabbifiiorPanel.class));

//					menuMap.put(ERPPermissionStatic.ATTACHMENT_CONTRACT_CAPITAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "合同确认函资金" : "Attachment Contract Capital", "attachment_contract_capital", "attachment_manage", "silk/layout_content.png",
//							new McontractAttachmentCapitalCountPanel.Factory(), true, "", McontractAttachmentCapitalCountPanel.class));

					menuMap.put(ERPPermissionStatic.ATTACHMENT_WORKPROCESS, new ExplorerTreeNode(localName.equals("zh_CN") ? "流程中的确认函" : "Attachment Process", "attachment_process", "attachment_manage", "menuicons/icon-liucheng.png",
							new MpersonnelbusinessdddemmporPanel.Factory(), true, "", MpersonnelbusinessdddemmporPanel.class));

					/*menuMap.put(ERPPermissionStatic.ATTACHMENT_CONFERENCE, new ExplorerTreeNode(localName.equals("zh_CN") ? "确认函(会议) " : "Attachment Conference", "attachment_conference", "attachment_manage", "silk/layout_content.png",
							new AttachmentMettingPanel.Factory(), true, "", AttachmentMettingPanel.class));*/
					menuMap.put(ERPPermissionStatic.ATTACHMENT_CONFERENCE, new ExplorerTreeNode(localName.equals("zh_CN") ? "确认函(会议) " : "Attachment Meeting", "attachment_meeting", "attachment_manage", "menuicons/icon-huiyi.png",
							new AttachmentManageMettingPanel.Factory(), true, "", AttachmentManageMettingPanel.class));
					//确认函确认
					menuMap.put(ERPPermissionStatic.ATTACHMENT_SURE, new ExplorerTreeNode(localName.equals("zh_CN") ? "确认函确认" : "Attachment Sure", "attachment_sure", "attachment_manage", "menuicons/icon-queren1.png",
							new OnAttachmentSurePanel.Factory(), true, "", OnAttachmentSurePanel.class));
				//绩效管理
				menuMap.put(ERPPermissionStatic.PERFORMANCE_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "绩效管理" : "performance management", "performance_management", "operate_managment", "menuicons/icon-jixiaoguanli.png",
						new ContractProjectPerformancePanel.Factory(), true, "", ContractProjectPerformancePanel.class));
				//成本二次调节
				menuMap.put(ERPPermissionStatic.RESET_REIMBURSEMENT_COST, new ExplorerTreeNode(localName.equals("zh_CN") ? "成本二次调节" : "reset reimbursement cost", "reset_reimbursement_cost", "operate_managment", "menuicons/icon-tiaojie.png",
						new ResetAllReimbursementCostPanel.Factory(), true, "", ResetAllReimbursementCostPanel.class));
				//调节后的成本查询
				menuMap.put(ERPPermissionStatic.REIMBURSEMENT_COST_AFTER_RESET, new ExplorerTreeNode(localName.equals("zh_CN") ? "调节后的成本查询" : "reimbursement cost after reset", "reimbursement_cost_after_reset", "operate_managment", "menuicons/icon-chaxun.png",
						new ReportCostDetailPanel.Factory(), true, "", ReportCostDetailPanel.class));
				//团队管理
				menuMap.put(ERPPermissionStatic.TEAM_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "团队管理" : "Team Management", "team_management", "operate_managment", "menuicons/icon-ziyuanzhuangtai.png",
						new EmployeeProjectAnalysisPanel.Factory(), true, "", EmployeeProjectAnalysisPanel.class));
					//资源状态
					menuMap.put(ERPPermissionStatic.EMPLOYEE_PROJECT_ANALYSIS, new ExplorerTreeNode(localName.equals("zh_CN") ? "资源状态" : "Employee Project Analysis", "employee_project_analysis", "team_management", "menuicons/icon-ziyuanzhuangtai.png",
							new EmployeeProjectAnalysisPanel.Factory(), true, "", EmployeeProjectAnalysisPanel.class));
					//跨部门协作审批
					menuMap.put(ERPPermissionStatic.PROJECT_EMPLOYEE_AUDIT, new ExplorerTreeNode(localName.equals("zh_CN") ? "跨部门协作审批" : "Project Employee Audit", "project_employee_audit", "team_management", "menuicons/icon-ziyuanzhuangtai.png",
							new ProjectEmployeeAuditPanel.Factory(), true, "", ProjectEmployeeAuditPanel.class));
					//跨部门协作汇总
					menuMap.put(ERPPermissionStatic.PROJECT_EMPLOYEE_REPORT, new ExplorerTreeNode(localName.equals("zh_CN") ? "跨部门协作汇总" : "Project Employee Report", "project_employee_report", "team_management", "menuicons/icon-ziyuanzhuangtai.png",
							new ProjectEmployeeReportPanel.Factory(), true, "", ProjectEmployeeReportPanel.class));
				//合同状态变动日志
				menuMap.put(ERPPermissionStatic.CONTRACT_STATUS_LOG, new ExplorerTreeNode(localName.equals("zh_CN") ? "合同状态变动日志" : "Contract Status Log", "contract_status_log", "operate_managment", "menuicons/icon-icon-contract.png",
						new ContractLogListPanel.Factory(), true, "", ContractLogListPanel.class));
				//条线管理
				menuMap.put(ERPPermissionStatic.PROJECT_MANAGE_LINE, new ExplorerTreeNode(localName.equals("zh_CN") ? "条线管理" : "Project Business Line", "project_business_line", "operate_managment", "menuicons/icon-xiantiaoxia.png",
						new OnProjectBusinessLinePanel.Factory(), true, "", OnProjectBusinessLinePanel.class));
				//营收确认管控
				menuMap.put(ERPPermissionStatic.REVENUE_SURE_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "营收确认管控" : "Revenue Sure Manage", "revenue_sure_manage", "operate_managment", "menuicons/icon-yingshou1.png",null, true, "",null));
					//营收确认预警
					menuMap.put(ERPPermissionStatic.REVENUE_SURE_WARN, new ExplorerTreeNode(localName.equals("zh_CN") ? "营收确认预警" : "Revenue Sure Warn", "revenue_sure_warn", "revenue_sure_manage", "menuicons/icon-yujing.png",
							new OnRevenueSureWarnPanel.Factory(), true, "", OnRevenueSureWarnPanel.class));
					//项目绩效记录
					menuMap.put(ERPPermissionStatic.PROJECT_PERFORMANCE_RECORD, new ExplorerTreeNode(localName.equals("zh_CN") ? "项目绩效记录" : "Project Performance Record", "project_performance_record", "revenue_sure_manage", "menuicons/icon-jixiaojilu.png",
							new OnProjectPerformanceRecordPanel.Factory(), true, "", OnProjectPerformanceRecordPanel.class));
					//绩效节点维护
					menuMap.put(ERPPermissionStatic.PROJECT_PERFORMANCE_NODE, new ExplorerTreeNode(localName.equals("zh_CN") ? "绩效节点维护" : "Project Performance Node", "project_performance_node", "revenue_sure_manage", "menuicons/icon-weihu.png",
							new OnProjectPerformanceNodeEmployeePanel.Factory(), true, "", OnProjectPerformanceNodeEmployeePanel.class));
				//项目阶段模板管理project_stage_templates
				menuMap.put(ERPPermissionStatic.PROJECT_STAGE_TMEPLATE_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "项目阶段模板管理" : "Project Stage Template Management", "project_stage_template_management", "operate_managment", "menuicons/icon-xiangmuhetong.png"
						,new SprojecttemplateorPanel.Factory(), true, "",SprojecttemplateorPanel.class));
				//定价管理
				menuMap.put(ERPPermissionStatic.PRICING_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "定价管理" : "Pricing Management", "pricing_management", "operate_managment", "menuicons/icon-xiangmuhetong.png"
						,null, true, "",null));
				//订单定价维护列表
				menuMap.put(ERPPermissionStatic.PRICING_MAINTAIN_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "订单定价维护" : "Pricing Maintain Management", "pricing_maintain_management", "pricing_management", "menuicons/icon-xiangmuhetong.png"
						,new SprojectpbporPanel.Factory(), true, "",SprojectpbporPanel.class));
				//供应商管理
				menuMap.put(ERPPermissionStatic.SUPPLIER, new ExplorerTreeNode(localName.equals("zh_CN") ? "供应商管理" : "supplier", "supplier", "operate_managment", "menuicons/j.png",
    			new OnSupplierInfoPanel.Factory(), true, "", OnSupplierInfoPanel.class));

	            menuMap.put(ERPPermissionStatic.K3_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "财务管理" : "K3 Manage", "K3_managment", "root", "menuicons/icon-caiwuguanli_erji.png", null, true, "", null));
	           /* //账户管理测试
        		menuMap.put(ERPPermissionStatic.ACCOUNTS_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "账户管理测试" : "Accounts Manage", "Accounts_Manage", "K3_managment", "silk/layout_content.png", null, true, "", null));
        		menuMap.put(ERPPermissionStatic.ACCOUNTS_QUERRY, new ExplorerTreeNode(localName.equals("zh_CN") ? "账户查询" : "Accounts_querry Info", "Accounts_querry", "Accounts_Manage", "silk/layout_content.png",
        				new NewAccountsInfoPanel.Factory(), true, "", NewAccountsInfoPanel.class));
        		menuMap.put(ERPPermissionStatic.ACCOUNTS_ALL_TRANSACTION, new ExplorerTreeNode(localName.equals("zh_CN") ? "账户流水" : "Accounts_All_ transactionInfo", "Accounts_All_ transaction", "Accounts_Manage", "silk/layout_content.png",
        				new NewAccountsTransactionInfoPanel.Factory(), true, "", NewAccountsTransactionInfoPanel.class));    */


				  menuMap.put(ERPPermissionStatic.INVOICES_MANAGMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "发票管理" : "Invoices Manage", "invoices_managment", "K3_managment", "menuicons/icon-fapiaoguanli.png", null, true, "", null));
		                menuMap.put(ERPPermissionStatic.ADD_INVOICES_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "购买发票" : "Add Invoices", "add_invoices", "invoices_managment", "menuicons/icon-fapiao.png",
		                		new SinvoiceitiorPanel.Factory(), true, "", SinvoiceitiorPanel.class));
		                menuMap.put(ERPPermissionStatic.UPDATE_INVOICES_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "填开发票" : "Update Invoices", "update_invoices", "invoices_managment", "menuicons/icon-fapiao1.png",
		                        new McontracticcisiiorPanel.Factory(), true, "", McontracticcisiiorPanel.class));
		                menuMap.put(ERPPermissionStatic.SEND_INVOICES_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "发出快递" : "Send Invoices", "send_invoices", "invoices_managment", "menuicons/icon-kuaidi.png",
		                        new MinvoiceexpresitssccmisiiorPanel.Factory(), true, "", MinvoiceexpresitssccmisiiorPanel.class));
		                menuMap.put(ERPPermissionStatic.COUNT_INVOICES_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "发票汇总" : "Count Invoices", "count_invoices", "invoices_managment", "menuicons/icon-huizong.png",
		                		new SinvoiceitiorcountPanel.Factory(), true, "", SinvoiceitiorcountPanel.class));
		                menuMap.put(ERPPermissionStatic.APPLY_INVOICES_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "发票申请" : "Apply Invoices", "apply_invoices", "invoices_managment", "menuicons/icon-fapiaoshenqing.png",
		                		new MinvocieapplydedaocorPanel.Factory(), true, "", MinvocieapplydedaocorPanel.class));
		                menuMap.put(ERPPermissionStatic.TAX_INVOICES_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "进项税发票" : "Tax Invoices", "tax_invoices", "invoices_managment", "menuicons/icon-fapiao2.png",
		                		new SinputtaxinvoiceabporPanel.Factory(), true, "", SinputtaxinvoiceabporPanel.class));
		                menuMap.put(ERPPermissionStatic.TAX_INVOICES_MANAGEMENT_CHECK, new ExplorerTreeNode(localName.equals("zh_CN") ? "进项税发票核对" : "Tax Invoices Check", "tax_invoices_check", "invoices_managment", "menuicons/icon-fapiao3.png",
		                		new MinputtaxinvoicelinkfinancesippciiymssorPanel.Factory(), true, "", MinputtaxinvoicelinkfinancesippciiymssorPanel.class));
		                menuMap.put(ERPPermissionStatic.TAX_INVOICES_MANAGEMENT_RECORD, new ExplorerTreeNode(localName.equals("zh_CN") ? "进项税发票记录" : "Tax Invoices Check", "tax_invoices_check", "invoices_managment", "menuicons/icon-shoukuandanweiguanli.png",
		                		new AboutInputTaxRecordInfoPanel.Factory(), true, "", AboutInputTaxRecordInfoPanel.class));
		                menuMap.put(ERPPermissionStatic.REIMBURMENT_INVOICES_MANAGEMENT_RECORD, new ExplorerTreeNode(localName.equals("zh_CN") ? "进销核对表" : "reimburment Invoices Check", "reimburment_invoices_check", "invoices_managment", "menuicons/icon-shoukuandanweiguanli.png",
		                		new MreimbursementinvoiceinformationrsrmmprorPanel.Factory(), true, "", MreimbursementinvoiceinformationrsrmmprorPanel.class));

                menuMap.put(ERPPermissionStatic.COLLECTION_PROJECT, new ExplorerTreeNode(localName.equals("zh_CN") ? "收款管理" : "Collection management", "collection_management", "K3_managment", "menuicons/icon-shoukuanguanli.png",
                    null,true, "", null));
					menuMap.put(ERPPermissionStatic.ZD_LS, new ExplorerTreeNode(localName.equals("zh_CN") ? "账单流水" : "Collection A", "collectionA_management", "collection_management", "menuicons/icon-zhangdanliushui-.png",
							new McapitalecoosmeorPanel.Factory(), true, "", McapitalecoosmeorPanel.class));
					menuMap.put(ERPPermissionStatic.PROJECT_HK, new ExplorerTreeNode(localName.equals("zh_CN") ? "项目回款" : "Collection Project", "collectionProject_management", "collection_management", "menuicons/icon-xiangmuhuikuan.png",
							new MItemCollectionPanel.Factory(), true, "", MItemCollectionPanel.class));
					menuMap.put(ERPPermissionStatic.PROJECT_HK_AND_FP, new ExplorerTreeNode(localName.equals("zh_CN") ? "回款对应发票" : "Invoice Payment", "invoice_payment", "collection_management", "menuicons/icon-xiangmuhuikuan.png",
							new InvoiceAndPaymentPanel.Factory(), true, "", InvoiceAndPaymentPanel.class));
					menuMap.put(ERPPermissionStatic.PROJECT_HK_REPORT, new ExplorerTreeNode(localName.equals("zh_CN") ? "回款报表" : "Invoice Report", "invoice_report", "collection_management", "menuicons/icon-1dingdanshoukuanmingxi.png",
							new InvoiceReportPanel.Factory(), true, "", InvoiceReportPanel.class));
					menuMap.put(ERPPermissionStatic.BILLING_COLLECTION_ANALYSIS, new ExplorerTreeNode(localName.equals("zh_CN") ? "开票回款分析" : "Billing collection analysis", "billing_collection_analysis", "collection_management", "menuicons/icon-1dingdanshoukuanmingxi.png",
							new MinvoicecseccorPanel.Factory(), true, "", MinvoicecseccorPanel.class));

				  menuMap.put(ERPPermissionStatic.CONTRACT_MONEY_DETAIL_MANAGMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "合同收款明细" : "Contract Money Detail Manage", "contract_money_detail_manage", "K3_managment", "menuicons/icon-1dingdanshoukuanmingxi.png",
						  new McontracticcacccorPanel.Factory(), true, "", McontracticcacccorPanel.class));
            	menuMap.put(ERPPermissionStatic.SUBJECT_TYPE, new ExplorerTreeNode(localName.equals("zh_CN") ? "报销科目" : "Subject Type", "subject_type", "K3_managment", "menuicons/icon-baoxiao1.png",
	                    new SubjectTypeTotalPanel.Factory(), true, "", SubjectTypeTotalPanel.class));
            	menuMap.put(ERPPermissionStatic.BORROW_LIMIT, new ExplorerTreeNode(localName.equals("zh_CN") ? "借款额度" : "Borrow Limit", "borrow_limit", "K3_managment", "menuicons/icon-jiekuaneduchaxun.png",
            			new BorrowMoneyManagePanel.Factory(), true, "", BorrowMoneyManagePanel.class));
            	menuMap.put(ERPPermissionStatic.RECEIVE_UNIT, new ExplorerTreeNode(localName.equals("zh_CN") ? "收款单位" : "Receive Unit", "receive_unit", "K3_managment", "menuicons/icon-shoukuandanweiguanli.png",
            			new SreceiveunitmanagemmrorPanel.Factory(), true, "", SreceiveunitmanagemmrorPanel.class));
				menuMap.put(ERPPermissionStatic.BANK_UNIT, new ExplorerTreeNode(localName.equals("zh_CN") ? "银行维护" : "Bank Unit", "bank_unit", "K3_managment", "menuicons/icon-shoukuandanweiguanli.png",
						new BankManagerPanel.Factory(), true, "", BankManagerPanel.class));
            	menuMap.put(ERPPermissionStatic.REIMBURSEMENT_PACKAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "报销打包汇总" : "Reimbursement Package", "reimbursement_package", "K3_managment", "menuicons/icon-iocnhuizongbiao.png",
        				new SreimbursementpackagemmrorPanel.Factory(), true, "", SreimbursementpackagemmrorPanel.class));
            	menuMap.put(ERPPermissionStatic.FINANCIAL_ACCOUNTING, new ExplorerTreeNode(localName.equals("zh_CN") ? "报销入账指定" : "Financial Accounting", "financial_accounting", "K3_managment", "menuicons/icon-out.png",
        				new MfinancialAccountingPanel.Factory(), true, "", MfinancialAccountingPanel.class));
            	menuMap.put(ERPPermissionStatic.BANK_CAPITALS, new ExplorerTreeNode(localName.equals("zh_CN") ? "银行资金对账" : "Bank Capitals", "bank_capitals", "K3_managment", "menuicons/icon-zhanghuzijinduizhang.png",
        				new McapitalcmmssmssborPanel.Factory(), true, "", McapitalcmmssmssborPanel.class));

            	menuMap.put(ERPPermissionStatic.EMPLOYEE_CAPITALS, new ExplorerTreeNode(localName.equals("zh_CN") ? "员工资金对账" : "Employee Accounting", "employee_accounting", "K3_managment", "menuicons/icon-duizhang.png",
        				new EmployeeCapitalsPanel.Factory(), true, "", EmployeeCapitalsPanel.class));

//            	menuMap.put(ERPPermissionStatic.ORDER_HK, new ExplorerTreeNode(localName.equals("zh_CN") ? "订单回款汇总" : "Order money", "order_money", "K3_managment", "menuicons/icon-huikuan.png",
//        				new MprojectcspppcpdcorPanel.Factory(), true, "", MprojectcspppcpdcorPanel.class));

            	menuMap.put(ERPPermissionStatic.EMPLOYEE_JF_HK, new ExplorerTreeNode(localName.equals("zh_CN") ? "员工积分回款对照" : "Employee_jf_hk", "Employee_jf_hk", "K3_managment", "menuicons/icon-jifen.png",
        				new EmployeeIntegralCapitalsPanel.Factory(), true, "", EmployeeIntegralCapitalsPanel.class));

            	menuMap.put(ERPPermissionStatic.CONTRACT_REMARK_AND_CONTACTS, new ExplorerTreeNode(localName.equals("zh_CN") ? "合同与联系人关联与备注修改" : "Contract remark and contacts", "Contract_remark_and_contacts", "K3_managment", "menuicons/icon-ziyuan1.png",
        				new McontracticcccsprfiiibaadicrbbiorPanel.Factory(), true, "", McontracticcccsprfiiibaadicrbbiorPanel.class));

            	menuMap.put(ERPPermissionStatic.K3_VOUCHER, new ExplorerTreeNode(localName.equals("zh_CN") ? "K3凭证" : "K3 Voucher", "k3_voucher", "K3_managment", "menuicons/icon-pingzheng.png",
        				null, true, "", null));
//        			menuMap.put(ERPPermissionStatic.K3_VOUCHER_COST, new ExplorerTreeNode(localName.equals("zh_CN") ? "成本K3凭证" : "Cost K3 Voucher", "k3_voucher_cost", "k3_voucher", "menuicons/icon-pingzheng1.png",
//        					new K3VoucherSummaryPanel.Factory(), true, "", K3VoucherSummaryPanel.class));
//        			menuMap.put(ERPPermissionStatic.K3_VOUCHER_INCOME, new ExplorerTreeNode(localName.equals("zh_CN") ? "收入/收款K3凭证" : "Income K3 Voucher", "k3_voucher_income", "k3_voucher", "menuicons/icon-pingzheng1.png",
//        					new IncomeVoucherPanel.Factory(), true, "", IncomeVoucherPanel.class));
//        			menuMap.put(ERPPermissionStatic.K3_VOUCHER_REVENUE, new ExplorerTreeNode(localName.equals("zh_CN") ? "营收K3凭证" : "Income K3 Revenue", "k3_voucher_revenue", "k3_voucher", "menuicons/icon-pingzheng3.png",
//        					new RevenueVoucherPanel.Factory(), true, "", RevenueVoucherPanel.class));
//        			menuMap.put(ERPPermissionStatic.K3_VOUCHER_ATTACHMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "确认函K3凭证" : "Income K3 Attachment", "k3_voucher_attachment", "k3_voucher", "menuicons/icon-Group.png",
//        					new AttachmentVoucherPanel.Factory(), true, "", AttachmentVoucherPanel.class));
//        			menuMap.put(ERPPermissionStatic.K3_VOUCHER_INSURANCE_AND_HOUSING_FUND, new ExplorerTreeNode(localName.equals("zh_CN") ? "五险一金K3凭证" : "Insurance and Housing Fund K3 Voucher", "k3_voucher_insurance_and_housing_fund Voucher", "k3_voucher", "menuicons/icon-tubiao-.png",
//        					new InsuranceAndHousingFundK3VoucherPanel.Factory(), true, "", InsuranceAndHousingFundK3VoucherPanel.class));
//        			menuMap.put(ERPPermissionStatic.K3_VOUCHER_SALARY, new ExplorerTreeNode(localName.equals("zh_CN") ? "工资K3凭证" : "Salary K3 Voucher", "k3_voucher_salary", "k3_voucher", "menuicons/icon-pzzx.png",
//        					new SalaryK3VoucherPanel.Factory(), true, "", SalaryK3VoucherPanel.class));
        			menuMap.put(ERPPermissionStatic.K3_VOUCHER_ALL, new ExplorerTreeNode(localName.equals("zh_CN") ? "所有凭证" : "All K3 Voucher", "all_k3_voucher", "k3_voucher", "menuicons/icon-pzzx.png",
        					new DelicacyAllVoucherPanel.Factory(), true, "", DelicacyAllVoucherPanel.class));
            	menuMap.put(ERPPermissionStatic.K3_CODE, new ExplorerTreeNode(localName.equals("zh_CN") ? "K3代码维护" : "K3  Code", "k3_code", "K3_managment", "menuicons/icon-jichudaimaweihu.png",
        				null, true, "", null));

            	menuMap.put(ERPPermissionStatic.COMPANY_K3_CODE, new ExplorerTreeNode(localName.equals("zh_CN") ? "公司K3代码维护" : "Company K3 Code", "Company_k3_code", "k3_code", "menuicons/icon-weihu1.png",
        				new CompanyK3CodePanel.Factory(), true, "", CompanyK3CodePanel.class));
            	menuMap.put(ERPPermissionStatic.EMPLOYEE_K3_CODE, new ExplorerTreeNode(localName.equals("zh_CN") ? "员工K3代码维护" : "Employee K3 Code", "Employee_k3_code", "k3_code", "menuicons/icon-weihu1.png",
        				new EmployeeK3CodePanel.Factory(), true, "", EmployeeK3CodePanel.class));
            	menuMap.put(ERPPermissionStatic.BANK_ACCOUNT_K3_CODE, new ExplorerTreeNode(localName.equals("zh_CN") ? "银行账号K3代码维护" : "Bank Account K3 Code", "Bank_account_k3_code", "k3_code", "menuicons/icon-weihu2.png",
        				new BankAccountK3CodePanel.Factory(), true, "", BankAccountK3CodePanel.class));
            	menuMap.put(ERPPermissionStatic.SUBJECT_TYPE_K3_CODE, new ExplorerTreeNode(localName.equals("zh_CN") ? "科目K3代码维护" : "Subject Type K3 Code", "Subject_type_K3_code", "k3_code", "menuicons/icon-weihu3.png",
        				new SubjectTypeK3CodePanel.Factory(), true, "", SubjectTypeK3CodePanel.class));
            	menuMap.put(ERPPermissionStatic.RECEIVE_UNIT_K3_CODE, new ExplorerTreeNode(localName.equals("zh_CN") ? "收款单位K3代码维护" : "Receive Unit K3 Code", "Receive_unit_K3_code", "k3_code", "menuicons/icon-weihu4.png",
        				new ReceiveUnitK3CodePanel.Factory(), true, "", ReceiveUnitK3CodePanel.class));
            	menuMap.put(ERPPermissionStatic.CUSTOMER_K3_CODE, new ExplorerTreeNode(localName.equals("zh_CN") ? "客户K3代码维护" : "Customer K3 Code", "Customer_K3_code", "k3_code", "menuicons/icon-weihu5.png",
        				new CustomerK3CodePanel.Factory(), true, "", CustomerK3CodePanel.class));
            	menuMap.put(ERPPermissionStatic.PLATE_AREA_K3_CODE, new ExplorerTreeNode(localName.equals("zh_CN") ? "板块区域K3代码维护" : "Plate Area K3 Code", "Plate_Area_K3_code", "k3_code", "menuicons/icon-weihu_.png",
        				new PlateAreaK3CodePanel.Factory(), true, "", PlateAreaK3CodePanel.class));
//            	menuMap.put(ERPPermissionStatic.SPECIFIC_K3_CODE, new ExplorerTreeNode(localName.equals("zh_CN") ? "特定代码维护" : "Specific Area K3 Code", "Specific_Area_K3_code", "k3_code", "menuicons/icon-weihu_.png",
//            			new SpecificK3CodePanel.Factory(), true, "", SpecificK3CodePanel.class));


            	menuMap.put(ERPPermissionStatic.SPECIFIC_K3_CODE, new ExplorerTreeNode(localName.equals("zh_CN") ? "特定代码维护" : "Specific Area K3 Code", "Specific_Area_K3_code", "k3_code", "menuicons/icon-weihu_.png",
            			new SpecificK3CodePanel.Factory(), true, "", SpecificK3CodePanel.class));
            	menuMap.put(ERPPermissionStatic.CAPITAL_ANALYSIS, new ExplorerTreeNode(localName.equals("zh_CN") ? "财务资金报表" : "Capital Analysis", "Capital_analysis", "K3_managment", "menuicons/icon-zijinbaobiao.png",
        				new FinancicalCapitalAnalysisPanel.Factory(), true, "", FinancicalCapitalAnalysisPanel.class));
//            	menuMap.put(ERPPermissionStatic.RECEIVABLE_TEMPLATE, new ExplorerTreeNode(localName.equals("zh_CN") ? "收款阶段模板" : "Receivable Template", "receivable_template", "K3_managment", "menuicons/icon-moban.png",
//	                    new ScontractreceivabletemplaterrcorPanel.Factory(), true, "", ScontractreceivabletemplaterrcorPanel.class));
            	menuMap.put(ERPPermissionStatic.CAPITAL_SUMMARY, new ExplorerTreeNode(localName.equals("zh_CN") ? "汇总资金查询" : "Capital summary", "capital_summary", "K3_managment", "menuicons/icon-zijinchaxun.png",
	                    new SreimbursementpackagesummarymmmorPanel.Factory(), true, "", SreimbursementpackagesummarymmmorPanel.class));

            	menuMap.put(ERPPermissionStatic.RECEIVE_UNIT_CAPITALS, new ExplorerTreeNode(localName.equals("zh_CN") ? "收款单位对账" : "Receive Unit Accounting", "receive_unit_accounting", "K3_managment", "menuicons/icon-duizhangdan.png",
        				new ReceiveUnitCapitalsPanel.Factory(), true, "", ReceiveUnitCapitalsPanel.class));
            	menuMap.put(ERPPermissionStatic.RECEIVE_UNIT_EMPLOYEE_CAPITALS, new ExplorerTreeNode(localName.equals("zh_CN") ? "收款单位对账(员工)" : "Receive Unit Employee Accounting", "receive_unit_employee_accounting", "K3_managment", "menuicons/icon-webicon16.png",
        				new ReceiveUnitEmployeeCapitalsPanel.Factory(), true, "", ReceiveUnitEmployeeCapitalsPanel.class));
            	menuMap.put(ERPPermissionStatic.SEARCH_REIMBURSEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "报销查询" : "Search Reimbursement Info", "search_reimbursement", "K3_managment", "menuicons/icon-baoxiaochaxun.png",
        				new SearchReimbursementInfoPanel.Factory(), true, "", SearchReimbursementInfoPanel.class));
            	menuMap.put(ERPPermissionStatic.CAPITAL_DISTRIBUTION, new ExplorerTreeNode(localName.equals("zh_CN") ? "回款分配" : "Capital Distribution", "capital_distribution", "K3_managment", "menuicons/icon-if__.png",
        				null, true, "", null));
            		menuMap.put(ERPPermissionStatic.ALL_CAPITAL_DISTRIBUTION_INFO_LIST, new ExplorerTreeNode(localName.equals("zh_CN") ? "回款分配信息列表" : "All Capital Distribution Info List", "all_capital_distribution_info_list", "capital_distribution", "menuicons/icon-xinxiliebiao.png",
            				new AllCapitalDistributionInfoPanel.Factory(), true, "", AllCapitalDistributionInfoPanel.class));
            		menuMap.put(ERPPermissionStatic.CAPITAL_DISTRIBUTION_ANALYZE, new ExplorerTreeNode(localName.equals("zh_CN") ? "回款分配差额明细" : "Capital Distribution Analyze", "capital_distribution_analyze", "capital_distribution", "menuicons/icon-mingxi.png",
            				new CapitalDistributionAnalyzePanel.Factory(), true, "", CapitalDistributionAnalyzePanel.class));
	            	menuMap.put(ERPPermissionStatic.CAPITAL_DISTRIBUTION_OF_DEPARTMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "部门回款分配" : "Capital Distribution of Department", "capital_distribution_of_department", "capital_distribution", "menuicons/icon-huikuanmingxiicon.png",
	        				new CapitalDistributionOfDepartmentPanel.Factory(), true, "", CapitalDistributionOfDepartmentPanel.class));
	            	menuMap.put(ERPPermissionStatic.CAPITAL_DISTRIBUTION_OF_PROJECT, new ExplorerTreeNode(localName.equals("zh_CN") ? "订单回款分配" : "Capital Distribution of Project", "capital_distribution_of_project", "capital_distribution", "menuicons/icon-huikuan-1.png",
	        				new CapitalDistributionOfProjectPanel.Factory(), true, "", CapitalDistributionOfProjectPanel.class));
	            	menuMap.put(ERPPermissionStatic.CAPITAL_DISTRIBUTION_LOG, new ExplorerTreeNode(localName.equals("zh_CN") ? "回款分配日志" : "Capital Distribution Log", "capital_distribution_log", "capital_distribution", "menuicons/icon-huikuanrili.png",
	            			new CapitalLogDetailPanel.Factory(), true, "", CapitalLogDetailPanel.class));
            	menuMap.put(ERPPermissionStatic.EXCHANGE_RATE, new ExplorerTreeNode(localName.equals("zh_CN") ? "汇率维护" : "Exchange Rate", "exchange_rate", "K3_managment", "menuicons/icon-yunpingtai_huishuaiweihu.png",
	                    new ExchangeRateListPanel.Factory(), true, "", ExchangeRateListPanel.class));
            	menuMap.put(ERPPermissionStatic.FINANCE_RECEIVE_BILL, new ExplorerTreeNode(localName.equals("zh_CN") ? "报销单收单" : "Finance Receive Bill", "finance_receive_bill", "K3_managment", "menuicons/icon-baoxiaodan.png",
	                    new MfinancereceivebillsporPanel.Factory(), true, "", MfinancereceivebillsporPanel.class));
            	menuMap.put(ERPPermissionStatic.COMPANY_CARD_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "公司银行卡维护" : "Compnay card manage", "compnay_card_manage", "K3_managment", "menuicons/icon-yinhangqia.png",
	                    new ScardmanagecdcorPanel.Factory(), true, "", ScardmanagecdcorPanel.class));
            	menuMap.put(ERPPermissionStatic.STAGE_MODEL, new ExplorerTreeNode(localName.equals("zh_CN") ? "合同小节点" : "Stage model", "stage_model", "K3_managment", "menuicons/icon-contract1.png",
            			null, true, "", null));
            	menuMap.put(ERPPermissionStatic.STAGE_MODEL_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "合同小节点模板" : "Stage model manage", "stage_model_manage", "stage_model", "menuicons/icon-hetongmoban1.png",
            			new StageModelTreePanel.Factory(), true, "", StageModelTreePanel.class));
            	menuMap.put(ERPPermissionStatic.CONTRACT_STAGE_MODEL_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "合同小节点详情" : "Contract stage model manage", "contract_stage_model_manage", "stage_model", "menuicons/icon-zhupiaopiaoicon-.png",
            			new StageContractInfoListPanel.Factory(), true, "", StageContractInfoListPanel.class));
            	menuMap.put(ERPPermissionStatic.CONTRACT_STAGE_PROCESS_LIST, new ExplorerTreeNode(localName.equals("zh_CN") ? "合同小节点流程状态" : "Contract stage process list", "contract_stage_process_list", "stage_model", "menuicons/icon-zhupiaopiaoicon-.png",
            			new ContractStageProcessStatusListPanel.Factory(), true, "", ContractStageProcessStatusListPanel.class));
            	menuMap.put(ERPPermissionStatic.CONTRACT_STAGE_AUDIT_MANAGER, new ExplorerTreeNode(localName.equals("zh_CN") ? "项目经理审批" : "Contract stage audit manager", "contract_stage_audit_manager", "stage_model", "menuicons/icon-xiangmushenpi.png",
            			new ContractStageAuditManagerPanel.Factory(), true, "", ContractStageAuditManagerPanel.class));
            	menuMap.put(ERPPermissionStatic.CONTRACT_STAGE_AUDIT_DESIGNER, new ExplorerTreeNode(localName.equals("zh_CN") ? "设计总监/驻场审批" : "Contract stage audit designer", "contract_stage_audit_designer", "stage_model", "menuicons/icon-shenpi.png",
            			new ContractStageAuditDesignerPanel.Factory(), true, "", ContractStageAuditDesignerPanel.class));

            	menuMap.put(ERPPermissionStatic.CMBC_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "银企直连" : "Cmbc Manage", "cmbc_manage", "K3_managment", "menuicons/icon-yinqizhilian.png",
            			null, true, "", null));
	            	menuMap.put(ERPPermissionStatic.CM_ACCOUNT_INFO, new ExplorerTreeNode(localName.equals("zh_CN") ? "账户详情" : "Cmbc Account Info", "cmbc_account_info", "cmbc_manage", "menuicons/icon-zhanghuxiangqing.png",
	            			new McmbcaccoutinfoccacbscorPanel.Factory(), true, "", McmbcaccoutinfoccacbscorPanel.class));
	            	menuMap.put(ERPPermissionStatic.CM_TRANS_INFO, new ExplorerTreeNode(localName.equals("zh_CN") ? "交易流水" : "Cmbc trans info", "cmbc_trans_info", "cmbc_manage", "menuicons/icon-jiaoyiliushui.png",
	            			new McmbctransinfoctatorPanel.Factory(), true, "", McmbctransinfoctatorPanel.class));
	            	menuMap.put(ERPPermissionStatic.CM_CAPITAL_RECEIVE_CHECK, new ExplorerTreeNode(localName.equals("zh_CN") ? "收入核对" : "Cm Capital Receive Check", "cm_capital_receive_check", "cmbc_manage", "menuicons/icon-shouruhedui.png",
	            			new BankCapitalReceiveCheckPanel.Factory(), true, "", BankCapitalReceiveCheckPanel.class));
	            	menuMap.put(ERPPermissionStatic.CM_CAPITAL_PAY_CHECK, new ExplorerTreeNode(localName.equals("zh_CN") ? "支出核对" : "Cm Capital payment Check", "cm_capital_payment_check", "cmbc_manage", "menuicons/icon-zhinenghuaxuanpinicon3.png",
	            			new BankCapitalPaymentCheckPanel.Factory(), true, "", BankCapitalPaymentCheckPanel.class));

	            menuMap.put(ERPPermissionStatic.BUDGET_MANAGMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "预算管理" : "Budget Management", "budget_management", "K3_managment", "menuicons/l.png",
	            			null, true, "", null));
	            menuMap.put(ERPPermissionStatic.BUDGET_APPLY, new ExplorerTreeNode(localName.equals("zh_CN") ? "预算单管理" : "Budget Apply", "budget_apply", "budget_management", "menuicons/m.png",
            			new OnBudgetManagementPanel.Factory(), true, "", OnBudgetManagementPanel.class));
	            /*menuMap.put(ERPPermissionStatic.SUPPLIER, new ExplorerTreeNode(localName.equals("zh_CN") ? "供应商管理" : "supplier", "supplier", "budget_management", "menuicons/j.png",
            			new OnSupplierInfoPanel.Factory(), true, "", OnSupplierInfoPanel.class));*/
	            menuMap.put(ERPPermissionStatic.CONTRACT_INCOME_LEDGER, new ExplorerTreeNode(localName.equals("zh_CN") ? "合同收入台账" : "Contract Income Ledger", "contract_income_ledger", "K3_managment", "menuicons/l.png",
            			new ContractIncomeLedgerListPanel.Factory(), true, "", ContractIncomeLedgerListPanel.class));
	            menuMap.put(ERPPermissionStatic.FINANCE_TRANS, new ExplorerTreeNode(localName.equals("zh_CN") ? "往来模块" : "Finance Trans", "finance_trans", "K3_managment", "menuicons/l.png",
	            		null, true, "", null));
		            menuMap.put(ERPPermissionStatic.TRANS_DETAIL_SUMMARY, new ExplorerTreeNode(localName.equals("zh_CN") ? "往来汇总" : "Trans Detail Summary", "trans_detail_summary", "finance_trans", "menuicons/l.png",
		            		new TransDetailSummaryPanel.Factory(), true, "", TransDetailSummaryPanel.class));
		            menuMap.put(ERPPermissionStatic.HANDING_TRANS_DETAIL_SUMMARY, new ExplorerTreeNode(localName.equals("zh_CN") ? "经办往来汇总" : "Handing Trans Detail Summary", "handing_trans_detail_summary", "finance_trans", "menuicons/l.png",
		            		new HandingTransDetailSummaryPanel.Factory(), true, "", HandingTransDetailSummaryPanel.class));
            	generalMap.put(ERPPermissionStatic.REIMBURSEMENT_INFO, new ExplorerTreeNode(localName.equals("zh_CN") ? "报销收款信息补全" : "Reimbursement Info", "reimbursement_info", "root", "menuicons/icon-baoxiao2.png",
            			new ReimbursementInfoPanel.Factory(), true, "", ReimbursementInfoPanel.class));
            	generalMap.put(ERPPermissionStatic.MYSELF_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "My CUBE" : "My CUBE", "myself_management", "root", "menuicons/layout_content.png", null, true, "", null));
            		generalMap.put(ERPPermissionStatic.MY_INFO_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "我的资料" : "My Info", "myMessage_management", "myself_management", "menuicons/icon-wodeziliao.png",
	                    new DesignMessagePanel.Factory(), true, "", DesignMessagePanel.class));
//            		generalMap.put(ERPPermissionStatic.MY_INTEGRAL_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "我的积分" : "My Integral", "myIntegral_management", "myself_management", "silk/layout_content.png",
//	                    new MyAwardPanel.Factory(), true, "", MyAwardPanel.class));
            		generalMap.put(ERPPermissionStatic.MY_INTEGRAL_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "我的积分" : "My Integral", "myIntegral_management", "myself_management", "menuicons/icon-wodejifen.png",
    	                    new OnEmployeeIntegralBusinessAllPanel.Factory(), true, "", OnEmployeeIntegralBusinessAllPanel.class));
//            		new OnEmployeeIntegralBusinessPanel.Factory(), true, "", OnEmployeeIntegralBusinessPanel.class));
//            		generalMap.put(ERPPermissionStatic.MY_APPLY, new ExplorerTreeNode(localName.equals("zh_CN") ? "我的申请" : "My Apply", "my_apply", "myself_management", "silk/layout_content.png",null, true, "", null));
//	            		generalMap.put(ERPPermissionStatic.REIMBURSEMENT_APPLY, new ExplorerTreeNode(localName.equals("zh_CN") ? "报销申请" : "Reimbursement Apply", "reimbursement_apply", "my_apply", "silk/layout_content.png",
//	            				new SsystemprocessinstanceorClientPanel.Factory(), true, "", SsystemprocessinstanceorClientPanel.class));
//            		generalMap.put(ERPPermissionStatic.MY_TO_DO_LIST, new ExplorerTreeNode(localName.equals("zh_CN") ? "我的待办" : "My To Do List", "my_to_do_list", "myself_management", "silk/layout_content.png",null, true, "", null));
//	            		generalMap.put(ERPPermissionStatic.MY_TO_DO_LIST_APPROVAL_ITEMS, new ExplorerTreeNode(localName.equals("zh_CN") ? "待办→审批" : "My To Do List Approval Stuff", "my_to_do_list_approval_stuff", "my_to_do_list", "silk/layout_content.png",
//		                    new SsystemprocessinstanceactivitypeorClientPanel.Factory(), true, "", SsystemprocessinstanceactivitypeorClientPanel.class));
//	            		generalMap.put(ERPPermissionStatic.MY_TO_DO_LIST_INFORMED_ITEMS, new ExplorerTreeNode(localName.equals("zh_CN") ? "待办→知会" : "My To Do List Attention Stuff", "my_to_do_list_attention_stuff", "my_to_do_list", "silk/layout_content.png",
//			                    new SsystemprocessattentionpeorClientPanel.Factory(), true, "", SsystemprocessattentionpeorClientPanel.class));
//	            		generalMap.put(ERPPermissionStatic.MY_TO_DO_LIST_TASK_POOL, new ExplorerTreeNode(localName.equals("zh_CN") ? "待办→任务池" : "My To Do List Task Pool", "my_to_do_list_task_pool", "my_to_do_list", "silk/layout_content.png",
//			                    new SsystemprocesspooledtaskpeorPanel.Factory(), true, "", SsystemprocesspooledtaskpeorPanel.class));
//            		generalMap.put(ERPPermissionStatic.MY_DONE_LIST, new ExplorerTreeNode(localName.equals("zh_CN") ? "我的已办" : "My Done List", "my_done_list", "myself_management", "silk/layout_content.png",null, true, "", null));
//	            		generalMap.put(ERPPermissionStatic.MY_DONE_LIST_APPROVAL_ITEMS, new ExplorerTreeNode(localName.equals("zh_CN") ? "已办→审批" : "My Done List Approval Stuff", "my_done_list_approval_stuff", "my_done_list", "silk/layout_content.png",
//	            				new SsystemprocessinstanceactivitypeorHandelPanel.Factory(), true, "", SsystemprocessinstanceactivitypeorHandelPanel.class));
//	            		generalMap.put(ERPPermissionStatic.MY_DONE_LIST_INFORMED_ITEMS, new ExplorerTreeNode(localName.equals("zh_CN") ? "已办→知会" : "My Done List Attention Stuff", "my_done_list_attention_stuff", "my_done_list", "silk/layout_content.png",
//	            				new SsystemprocessattentionpeorHandelPanel.Factory(), true, "", SsystemprocessattentionpeorHandelPanel.class));
//	            		generalMap.put(ERPPermissionStatic.MY_DONE_LIST_TASK_POOL, new ExplorerTreeNode(localName.equals("zh_CN") ? "已办→任务池" : "My Done List Task Pool", "my_done_list_task_pool", "my_done_list", "silk/layout_content.png",
//	            				new SsystemprocesspooledtaskpeorHandelPanel.Factory(), true, "", SsystemprocesspooledtaskpeorHandelPanel.class));
            		generalMap.put(ERPPermissionStatic.MY_FINANCIAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "我的财务" : "My financial", "my_financial", "myself_management", "menuicons/icon-wodecaiwubu.png"
            				,new MyWorkflowPanel.Factory(), true, "", MyWorkflowPanel.class));
            		generalMap.put(ERPPermissionStatic.MY_PERSONNEL, new ExplorerTreeNode(localName.equals("zh_CN") ? "我的人事" : "My personnel", "my_personnel", "myself_management", "menuicons/icon-renshi.png"
            				,new MyPersonnelFlowPanel.Factory(), true, "", MyPersonnelFlowPanel.class));
            		generalMap.put(ERPPermissionStatic.MY_ADMINISTRATION, new ExplorerTreeNode(localName.equals("zh_CN") ? "我的行政" : "My administrationPanel", "my_administrationPanel", "myself_management", "menuicons/icon-hangzheng.png"
            				,new MyAdministrationPanel.Factory(), true, "", MyAdministrationPanel.class));
            		generalMap.put(ERPPermissionStatic.MY_ATTENDANCE, new ExplorerTreeNode(localName.equals("zh_CN") ? "我的门禁" : "My Attendance", "my_attendance", "myself_management", "menuicons/icon-calendar.png",
            				new MyAttendance.Factory(), true, "", MyAttendance.class));
            		generalMap.put(ERPPermissionStatic.OPERATION_PROCESSOR, new ExplorerTreeNode(localName.equals("zh_CN") ? "运营流程" : "Operation Processor", "operation_processor", "myself_management", "menuicons/icon-EPCzuodaohangtubiao-.png",
            				new MyCostAllocationPanel.Factory(), true, "", MyCostAllocationPanel.class));
					generalMap.put(ERPPermissionStatic.MY_ANNOUCEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "我的公告" : "My Annoucement", "my_annoucement", "myself_management", "menuicons/icon-wodegonggao.png",
            				new AnnoucementManagePanel.Factory(), true, "", AnnoucementManagePanel.class));
					generalMap.put(ERPPermissionStatic.MY_ANNOUCEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "我的权限" : "My Permissions", "my_permissions", "myself_management", "menuicons/icon-wodegonggao.png",
            				new MyPermissionsFunctionInitPanel.Factory(), true, "", MyPermissionsFunctionInitPanel.class));
					generalMap.put(ERPPermissionStatic.MY_WORK, new ExplorerTreeNode(localName.equals("zh_CN") ? "我的工作" : "My Work", "my_work", "myself_management", "menuicons/icon-renshi.png"
							,new MyWorkPanel.Factory(), true, "", MyWorkPanel.class));
					generalMap.put(ERPPermissionStatic.MY_WORK_HOUR, new ExplorerTreeNode(localName.equals("zh_CN") ? "我的工时" : "My Work Hour", "my_work_hour", "myself_management", "menuicons/icon-renshi.png"
							,new WorkingHourManagePanel.Factory(), true, "", WorkingHourManagePanel.class));
					//会议室预约
					generalMap.put(ERPPermissionStatic.MY_MEETING_ROOM_RESERVATION_RECORD, new ExplorerTreeNode(localName.equals("zh_CN") ? "会议室预约" : "Meeting room reservation record", "meeting_room_reservation_record", "myself_management", "menuicons/icon-zhiyuanguanli-.png",
							new MeetingRoomReservaTionRecordPaymentBasePanel.Factory(), true,"",MeetingRoomReservaTionRecordPaymentBasePanel.class));
            		/*generalMap.put(ERPPermissionStatic.MY_ATTENDANCE, new ExplorerTreeNode(localName.equals("zh_CN") ? "系统初始化" : "System init", "system_init", "myself_management", "silk/layout_content.png",
            				new SysteminitloglstorPanel.Factory(), true, "", SysteminitloglstorPanel.class));*/
            	//报表管理
	            menuMap.put(ERPPermissionStatic.REPORT_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "报表管理" : "Report Manage", "report_management", "root", "menuicons/icon-baobiaoguanli.png", null, true, "", null));
					//人资行政报表
	            	menuMap.put(ERPPermissionStatic.THE_PERSONNEL_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "人资行政报表" : "Human resources administration", "human_resources_administration", "report_management", "menuicons/icon-zhiyuanguanli-.png", null, true,"",null));
						//人员结构总览
						menuMap.put(ERPPermissionStatic.EMPLOYEES_STRUCTURE_OVERVIEW_TOTAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "人员结构总览": "Employee Structure Overview","employee_structure_overview","human_resources_administration","menuicons/icon-yingshoufenxi.png",
								new EmployeeStructureOverview.Factory(),true,"", EmployeeStructureOverview.class));
						//员工人数总表
						menuMap.put(ERPPermissionStatic.REPORT_ON_EMPLOYEE_NUM_TOTAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "员工人数总表" : "Report On Employee Num Total", "report_on_employee_num_total", "human_resources_administration", "menuicons/icon-yuangongrenshu-.png",
								new ReportOnEmployeeNumTotalPanel.Factory(), true, "", ReportOnEmployeeNumTotalPanel.class));
						//年龄结构分析总表
						menuMap.put(ERPPermissionStatic.REPORT_ON_EMPLOYEE_AGE_TOTAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "年龄结构分析总表" : "Report On Employee Age Total", "report_on_employee_age_total", "human_resources_administration", "menuicons/icon-yuangongrenshu-.png",
								new ReportOnEmployeeAgeTotalPanel.Factory(), true, "", ReportOnEmployeeAgeTotalPanel.class));
						//设计师职级结构分析
						menuMap.put(ERPPermissionStatic.REPORT_ON_EMPLOYEE_GRADE_TOTAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "职级结构分析总表" : "Report On Employee Grade Total", "report_on_employee_grade_total", "human_resources_administration", "menuicons/icon-yuangongrenshu-.png",
								new ReportOnEmployeeGradeTotalPanel.Factory(), true, "", ReportOnEmployeeGradeTotalPanel.class));
						//学历结构分析
						menuMap.put(ERPPermissionStatic.REPORT_ON_EMPLOYEE_EDUCATION_TOTAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "学历结构分析总表" : "Report On Employee Education Total", "report_on_employee_education_total", "human_resources_administration", "menuicons/icon-yuangongrenshu-.png",
								new ReportOnEmployeeEducationTotalPanel.Factory(), true, "", ReportOnEmployeeEducationTotalPanel.class));
						//工龄结构分析
						menuMap.put(ERPPermissionStatic.REPORT_ON_EMPLOYEE_SENIORITY_TOTAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "工龄结构分析总表" : "Report On Employee Seniority Total", "report_on_employee_seniority_total", "human_resources_administration", "menuicons/icon-yuangongrenshu-.png",
								new ReportOnEmployeeSeniorityTotalPanel.Factory(), true, "", ReportOnEmployeeSeniorityTotalPanel.class));
						//人员流动结构分析
						menuMap.put(ERPPermissionStatic.REPORT_ON_EMPLOYEE_TURNOVER_TOTAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "人员流动结构分析总表" : "Report On Employee Turnover Total", "report_on_employee_turnover_total", "human_resources_administration", "menuicons/icon-yuangongrenshu-.png",
								new ReportOnEmployeeTurnoverTotalPanel.Factory(), true, "", ReportOnEmployeeTurnoverTotalPanel.class));
						//效益指数分析
						menuMap.put(ERPPermissionStatic.REPORT_ON_EMPLOYEE_BENEFIT_TOTAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "效益指数分析表" : "Report On Employee Benefit Total", "report_on_employee_benefit_total", "human_resources_administration", "menuicons/icon-yuangongrenshu-.png",
								new ReportOnEmployeeBenefitTotalPanel.Factory(), true, "", ReportOnEmployeeBenefitTotalPanel.class));
						//性别分析总表
						menuMap.put(ERPPermissionStatic.REPORT_OF_GENDER_ANALYSIS, new ExplorerTreeNode(localName.equals("zh_CN") ? "性别分析总表" : "Report Of Gender Analysis", "report_of_gender_analysis", "human_resources_administration", "menuicons/icon-yuangongrenshu-.png",
								new ReportOfGenderAnalysisPanel.Factory(), true, "", ReportOfGenderAnalysisPanel.class));
						//司龄分析总表
						menuMap.put(ERPPermissionStatic.REPORT_EMPLOYEE_WORK_YEARS, new ExplorerTreeNode(localName.equals("zh_CN") ? "司龄分析总表" : "Report Of Emp Work Years", "report_of_emp_work_years", "human_resources_administration", "menuicons/icon-xingbiefenxi.png",
								new ReportEmployeeWorkYearsPanel.Factory(), true, "", ReportEmployeeWorkYearsPanel.class));
						//工资变动单
//						menuMap.put(ERPPermissionStatic.REPORT_OF_SALARY_CHANGE_NOTICE, new ExplorerTreeNode(localName.equals("zh_CN") ? "工资变动单" : "Report Of salary change", "report_of_emp_salary_change", "human_resources_administration", "menuicons/icon-gongzibiandongguanli.png",
//								new ReportOfSalaryChangeNoticePanel.Factory(), true, "", ReportOfSalaryChangeNoticePanel.class));
						//人工成本对比分析表
//						menuMap.put(ERPPermissionStatic.REPORT_OF_EMPLOYEE_COST_ANALYSIS, new ExplorerTreeNode(localName.equals("zh_CN") ? "人工成本对比分析表" : "Report Of Employee Cost Analysis", "report_of_employee_cost_analysis", "human_resources_administration", "menuicons/icon-rengongchengben1.png",
//								new ReportOfEmployeeCostAnalysisPanel.Factory(), true, "", ReportOfEmployeeCostAnalysisPanel.class));


					//营销报表
					menuMap.put(ERPPermissionStatic.MARKETING_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "营销报表" : "marketing", "marketing", "report_management", "menuicons/icon-yingxiaoguanli01.png", null, true,"",null));
						//新签合同额总表
						menuMap.put(ERPPermissionStatic.REPORT_NEW_CONTRACT_TOTAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "新签合同额总表" : "Report New Contract Total", "report_new_contract_total", "marketing", "menuicons/icon-icon-contract.png",
								new ReportNewContractTotalPanel.Factory(), true, "", ReportNewContractTotalPanel.class));
						//签约合同报表
						menuMap.put(ERPPermissionStatic.CONTRACT_AMOUNT_ANALYZE, new ExplorerTreeNode(localName.equals("zh_CN") ? "签约合同报表" : "Contract Amount Analyze", "contract_amount_analyze", "marketing", "menuicons/icon-yingshoufenxi.png",
								new ContractAmountAnalyzePanel.Factory(), true, "", ContractAmountAnalyzePanel.class));
						//合同存量报表
//						menuMap.put(ERPPermissionStatic.CONTRACT_SAVE_ANALYZE, new ExplorerTreeNode(localName.equals("zh_CN") ? "合同存量报表" : "Contract Save Analyze", "contract_save_analyze", "marketing", "menuicons/icon-yingshoufenxi.png",
//								new contractSaveAnalyzePanel.Factory(), true, "", contractSaveAnalyzePanel.class));
						//签约合同报表
						menuMap.put(ERPPermissionStatic.CONTRACT_AMOUNT_ANALYZE, new ExplorerTreeNode(localName.equals("zh_CN") ? "签约合同报表" : "Contract Amount Analyze", "contract_amount_analyze", "marketing", "menuicons/icon-yingshoufenxi.png",
								new ContractAmountAnalyzePanel.Factory(), true, "", ContractAmountAnalyzePanel.class));
						//定价分析表
//						menuMap.put(ERPPermissionStatic.REGULAR_PRICE_ANALYZE, new ExplorerTreeNode(localName.equals("zh_CN") ? "定价分析表" : "Regular Price Analyze", "regular_price_analyze", "marketing", "menuicons/icon-yingshoufenxi.png",
//								new MprojectppppppbppiporPanel.Factory(), true, "", MprojectppppppbppiporPanel.class));
						//落标汇总表OnLoadBidPaySheetProjectSummary
						menuMap.put(ERPPermissionStatic.ON_LOAD_BID_PAY_SHEET_PROJECT_SUMMARY, new ExplorerTreeNode(localName.equals("zh_CN") ? "落标汇总表" : "Per capita salary analysis", "per_capita_salary_analysis", "marketing", "menuicons/icon-yingshoufenxi.png",
								new OnLoadBidPaySheetProjectSummaryPanel.Factory(), true, "", OnLoadBidPaySheetProjectSummaryPanel.class));


					//运营报表
					menuMap.put(ERPPermissionStatic.OPERATING_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "运营报表" : "operating", "operating", "report_management", "menuicons/icon-yunyingguanli.png", null, true,"",null));
						//营收统计总表
						menuMap.put(ERPPermissionStatic.REPORT_OF_SUM_REVENUE_YEAR_RECORD, new ExplorerTreeNode(localName.equals("zh_CN") ? "营收统计总表" : "Report Of Sum Revenue Year Records", "report_of_sum_revenue_year_records", "operating", "menuicons/icon-navicon-tjb.png",
								new ReportOfSumRevenueYearRecordsPanel.Factory(), true, "", ReportOfSumRevenueYearRecordsPanel.class));
						//部门收支表
						menuMap.put(ERPPermissionStatic.DEPARTMENT_INCOME_REPORT, new ExplorerTreeNode(localName.equals("zh_CN") ? "部门收支表" : "Department income report", "department_income_report", "operating", "menuicons/icon-navicon-tjb.png",
								new DepartmentIncomeReportPanel.Factory(), true, "", DepartmentIncomeReportPanel.class));
						//确认积分总表
						menuMap.put(ERPPermissionStatic.REPORT_SURE_INTEGRAL_TOTAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "确认积分总表" : "Report Sure Integral Total", "report_sure_integral_total", "operating", "menuicons/icon-jifenbiao.png",
								new ReportSureIntegralTotalPanel.Factory(), true, "", ReportSureIntegralTotalPanel.class));
						//报表总表
//						menuMap.put(ERPPermissionStatic.REPORT_TOTAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "报表总表" : "Report Totals", "report_totals", "operating", "menuicons/icon-chengbenmoban.png",
//								new ReportTotalsPanel.Factory(), true, "", ReportTotalsPanel.class));
						//条线营收报表
//						menuMap.put(ERPPermissionStatic.BUSINESS_LINE_REVENUE, new ExplorerTreeNode(localName.equals("zh_CN") ? "条线营收报表" : "Business Line Revenue", "business_line_revenue", "operating", "menuicons/icon-trading_list.png",
//								new OnBusinessLineRevenueDataPanel.Factory(), true, "", OnBusinessLineRevenueDataPanel.class));
						//条线营收明细表
//						menuMap.put(ERPPermissionStatic.BUSINESS_LINE_REVENUE_DETAIL, new ExplorerTreeNode(localName.equals("zh_CN") ? "条线营收明细表" : "Business Line Revenue Detail", "business_line_revenue_detail", "operating", "menuicons/icon-yingshoufenxi.png",
//								new OnBusinessLineRevenueDetailDataPanel.Factory(), true, "", OnBusinessLineRevenueDetailDataPanel.class));
						//条线运营报表
//						menuMap.put(ERPPermissionStatic.BUSINESS_LINE_ANALYZE, new ExplorerTreeNode(localName.equals("zh_CN") ? "条线运营报表" : "Business Line Analyze", "business_line_analyze", "operating", "menuicons/icon-yingshoufenxi.png",
//								new MprojecttrcccsyyyseyymmymmorPanel.Factory(), true, "", MprojecttrcccsyyyseyymmymmorPanel.class));
						//员工参与订单表
						menuMap.put(ERPPermissionStatic.EMPLOYEES_ORDERS_TOTAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "员工参与订单表": "Employees Orders total","employees_orders_total","operating","menuicons/icon-yingshoufenxi.png",
								new EmployeesOrdersPanel.Factory(),true,"", EmployeesOrdersPanel.class));

						//工时报表
						menuMap.put(ERPPermissionStatic.WORKING_HOURS_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "工时报表" : "Working hours", "working_hours", "operating", "menuicons/icon-zuzhijiagou1.png", null, true,"",null));
							//员工日工时统计表
							menuMap.put(ERPPermissionStatic.REPORT_EMPLOYEE_DAILY_HOURS_TOTAL,new ExplorerTreeNode(localName.equals("zh_CN") ? "员工日工时统计表": "Employee daily Hour total","employee_daily_hours_total","working_hours","menuicons/icon-yingshoufenxi.png",
									new ReportEmployeeDailyHoursTotalPanel.Factory(), true, "", ReportEmployeeDailyHoursTotalPanel.class));
							//项目工时统计表
							menuMap.put(ERPPermissionStatic.REPORT_PROJECT_WORK_TIME_TOTAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "项目工时统计表": "Project work Time total","project_work_time_total","working_hours","menuicons/icon-yingshoufenxi.png",
									new ReportProjectWorkTimePanel.Factory(),true,"",ReportProjectWorkTimePanel.class));


						//出图报表
						menuMap.put(ERPPermissionStatic.THE_FIGURE_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "出图报表" : "The figure", "the_figure", "operating", "menuicons/icon-zuzhijiagou1.png", null, true,"",null));
							//出图统计表
							menuMap.put(ERPPermissionStatic.REPORT_MAP_TOTAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "出图统计表": "Project work map total","project_work_map_total","the_figure","menuicons/icon-yingshoufenxi.png",
									new ReportMapTotalsPanel.Factory(),true,"", ReportMapTotalsPanel.class));
							//配合统计表
							menuMap.put(ERPPermissionStatic.COOPERATE_STATISTICS_TOTAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "配合统计表": "Cooperate work Statistics total","cooperate_work_statistics_total","the_figure","menuicons/icon-yingshoufenxi.png",
									new CooperateStatisticsTotalPanel.Factory(),true,"", CooperateStatisticsTotalPanel.class));


					//财务报表
					menuMap.put(ERPPermissionStatic.FINANCIAL_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "财务报表" : "financial", "financial", "report_management", "menuicons/icon-caiwuguanli_erji.png", null, true,"",null));
						//现金流总表
						menuMap.put(ERPPermissionStatic.REPORT_CAPITAL_TOTAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "现金流总表" : "Report Capital Total", "report_capital_total", "financial", "menuicons/icon-xianjinliu.png",
								new ReportCapitalTotalPanel.Factory(), true, "", ReportCapitalTotalPanel.class));
						//薪酬总表
//						menuMap.put(ERPPermissionStatic.REPORT_OF_SALARY_TOTAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "薪酬总表" : "Report Of Salary Total", "report_of_salary_total", "financial", "menuicons/icon-xinchoudiaocha.png",
//								new ReportOfSalaryTotalPanel.Factory(), true, "", ReportOfSalaryTotalPanel.class));
						//成本总表
						menuMap.put(ERPPermissionStatic.REPORT_COST_TOTAL, new ExplorerTreeNode(localName.equals("zh_CN") ? "成本总表" : "Report Cost Total", "report_cost_total", "financial", "menuicons/icon-chengbenmoban.png",
								new ReportCostTotalPanel.Factory(), true, "", ReportCostTotalPanel.class));
						//现金流财务报表
						menuMap.put(ERPPermissionStatic.INCOME_MONEY_FOR_WEEK, new ExplorerTreeNode(localName.equals("zh_CN") ? "现金流收入报表" : "Income Money For Week", "income_money_for_week", "financial", "menuicons/icon-xianjinliuliangbiao-normal.png",
								new IncomeMoneyForWeekPanel.Factory(), true, "", IncomeMoneyForWeekPanel.class));
						//奖金汇总表
//						menuMap.put(ERPPermissionStatic.BONUS_SUMMARY, new ExplorerTreeNode(localName.equals("zh_CN") ? "奖金汇总表" : "Bonus summary", "bonus_summary", "financial", "menuicons/icon-yingshoufenxi.png",
//								new bonusSummaryPanel.Factory(), true, "", bonusSummaryPanel.class));
						//工资奖金分析表 SalaryBonusAnalysis
//						menuMap.put(ERPPermissionStatic.SALARY_BONUS_ANALYSIS, new ExplorerTreeNode(localName.equals("zh_CN") ? "工资奖金分析表" : "Salary bonus analysis", "salary_bonus_analysis", "financial", "menuicons/icon-yingshoufenxi.png",
//								new SalaryBonusAnalysisPanel.Factory(), true, "", SalaryBonusAnalysisPanel.class));
						//人均薪酬分析表 PerCapitaSalaryAnalysis
//						menuMap.put(ERPPermissionStatic.PER_CAPITA_SALARY_ANALYSIS, new ExplorerTreeNode(localName.equals("zh_CN") ? "人均薪酬分析表" : "Per capita salary analysis", "per_capita_salary_analysis", "financial", "menuicons/icon-yingshoufenxi.png",
//								new PerCapitaSalaryAnalysisPanel.Factory(), true, "", PerCapitaSalaryAnalysisPanel.class));
						//回款分析表
						menuMap.put(ERPPermissionStatic.COLLECTION_REVENUE_ANALYSIS, new ExplorerTreeNode(localName.equals("zh_CN") ? "回款分析表" : "Collection revenue analysis", "collection_revenue_analysis", "financial", "menuicons/icon-yingshoufenxi.png",
								new CollectionrevenueanalysisPanel.Factory(), true, "", CollectionrevenueanalysisPanel.class));









//	            menuMap.put(ERPPermissionStatic.JAID_MENU, new ExplorerTreeNode(localName.equals("zh_CN") ? "J&A官网" : "Jaid Manage", "jaid_management", "root", "silk/layout_content.png", null, true, "", null));
//	            	menuMap.put(ERPPermissionStatic.JAID_GG, new ExplorerTreeNode(localName.equals("zh_CN") ? "公司公告" : "Jaid Notice", "jaid_Notice", "jaid_management", "menuicons/n.png",
//	                    new SwebsitenewntforPanel.Factory(), true, "", SwebsitenewntforPanel.class));
//	            	menuMap.put(ERPPermissionStatic.JAID_PROJECT_EXPERIENCE, new ExplorerTreeNode(localName.equals("zh_CN") ? "项目经验" : "Project Experience", "project_Experience", "jaid_management", "menuicons/icon-tubiao_xiangmujingyan.png",
//	            			new ProjectExperiencePanel.Factory(), true, "", ProjectExperiencePanel.class));
//	            	menuMap.put(ERPPermissionStatic.JAID_NEWS_MEDIA, new ExplorerTreeNode(localName.equals("zh_CN") ? "新闻媒体" : "News Media", "news_Media", "jaid_management", "menuicons/icon-xinwenmeiti.png",
//	            			new NewsMediaPanel.Factory(), true, "", NewsMediaPanel.class));
	//		menuMap.put(ERPPermissionStatic.PERSONAL_REGISTER_ADDRESS_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "员工注册地址管理" : "Personal Register Address Manage", "personal_register_address_manage", "cwd_menu", "silk/layout_content.png",
	//				new PersonalRegisterAddressManagePanel.Factory(), true, "", PersonalRegisterAddressManagePanel.class));
		menuMap.put(BasicPermissionStatic.WORKFLOW_UPDATE_ACTIVITY_EMPLOYEE, new ExplorerTreeNode(localName.equals("zh_CN") ? "流程节点人员修改" : "Workflow Update Activity Employee", "workflow_update_activity_employee", "wf_managment", "menuicons/ee.png",
				new UpdateActivityEmployeePanel.Factory(), true, "", UpdateActivityEmployeePanel.class));
		menuMap.put(BasicPermissionStatic.EMPLOYEE_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "职员管理" : "Employee", "employee_managment", "basic_data_managment", "menuicons/icon-zhiyuanguanli-.png",
				new MemployeePanel.Factory(), true, "", MemployeePanel.class));
		/*menuMap.put(BasicPermissionStatic.DATA_INITIALIZATION, new ExplorerTreeNode(localName.equals("zh_CN") ? "数据初始化" : "Data Initialization", "data_initialization", "basic_data_managment", "menuicons/icon-xinwenmeiti.png",
				new TableMaintainPanel.Factory(), true, "", TableMaintainPanel.class));*/
		menuMap.put(BasicPermissionStatic.DICTIONART_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "下拉管理" : "Dictionary Management", "dictionary_management", "basic_data_managment", "menuicons/icon-gongsixiangmu.png",
				new DictionaryManagementPanel.Factory(), true, "", DictionaryManagementPanel.class));
//		menuMap.put(ERPPermissionStatic.CWD_MENU, new ExplorerTreeNode(localName.equals("zh_CN") ? "协同设计管理" : "CWD Menu", "cwd_menu", "root", "silk/layout_content.png", null, true, "", null));
//		 	menuMap.put(ERPPermissionStatic.CWD_OSS_CONFIG_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "OSS配置管理页面" : "OSS Config Manage", "oss_config_manage", "cwd_menu", "menuicons/OSS.png",
//				 new OssConfigManagePanel.Factory(), true, "", OssConfigManagePanel.class));
//		 	//项目策划管理
//			menuMap.put(ERPPermissionStatic.PROJECT_PLAN_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "项目策划管理" : "Project Plan Manage", "project_plan_manage", "cwd_menu", "menuicons/aa.png",null, true, "",null));
//				//任务模板管理
//				menuMap.put(ERPPermissionStatic.TASK_TEMPLATE_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "任务模板管理" : "Task Template Manage", "task_template_manage", "project_plan_manage", "menuicons/cc.png",
//						new ScwdtasktemplatetccorPanel.Factory(), true, "", ScwdtasktemplatetccorPanel.class));	
//			menuMap.put(ERPPermissionStatic.COMPANY_WORKPLACE_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "公司工作场所管理" : "Company Workplace Manage", "company_workplace_manage", "cwd_menu", "menuicons/bb.png",
//					new CompanyWorkplaceAndServerManagePanel.Factory(), true, "", CompanyWorkplaceAndServerManagePanel.class));
//					new CompanyWorkplaceAndServerManagePanel.Factory(), true, "", CompanyWorkplaceAndServerManagePanel.class));
//			menuMap.put(ERPPermissionStatic.CWD_FILE_FILTER_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "文件过滤管理" : "file Filter Manage", "file_filter_manage", "cwd_menu", "menuicons/icon-gongsixiangmu.png",
//	 				new CwdFileFilterPanel.Factory(), true, "", CwdFileFilterPanel.class));
//			menuMap.put(ERPPermissionStatic.CWD_FILING_TEMPLATE_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "文件归档模板" : "cwd filing template Manage", "cwd_filing_template_manage", "cwd_menu", "menuicons/icon-fafangjifen.png",
//					new ScwdfilingmaintemplatetrcorPanel.Factory(), true, "", ScwdfilingmaintemplatetrcorPanel.class));
//			menuMap.put(ERPPermissionStatic.CWD_LOCAL_SYSTEM_UPDATE_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "本地文件系统更新发布" : "local system update Manage", "local_system_update_manage", "cwd_menu", "menuicons/icon-gongsixiangmu.png",
//					new SoftwareUpdateVersionWithSPanel.Factory(), true, "", SoftwareUpdateVersionWithSPanel.class));
//			menuMap.put(ERPPermissionStatic.CWD_VIEW_PROJECT_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "CDC项目监管" : "cdc project Manage", "cdc_project_Manage", "cwd_menu", "menuicons/icon-gongsixiangmu.png",
//					new SmainprojectppporPanel.Factory(), true, "", SmainprojectppporPanel.class));
//			menuMap.put(ERPPermissionStatic.CWD_VIEW_SOFT_INSTALL_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "CDC插件安装记录" : "cdc software Install", "cdc_software_Install", "cwd_menu", "menuicons/icon-gongsixiangmu.png",
//					new MemployeeSoftInstallPanel.Factory(), true, "", MemployeeSoftInstallPanel.class));
//			menuMap.put(ERPPermissionStatic.CWD_VIEW_SOFT_UPDATE_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "CDC插件操作记录" : "cdc software Operate", "cdc_software_Operate", "cwd_menu", "menuicons/icon-gongsixiangmu.png",
//					new MsoftwareoperationlogeoseedorPanel.Factory(), true, "", MsoftwareoperationlogeoseedorPanel.class));
//			menuMap.put(ERPPermissionStatic.CDC_PROJECT_PERMISSION, new ExplorerTreeNode(localName.equals("zh_CN") ? "项目权限管理" : "CDC Project Permission", "cdc_project_permission", "cwd_menu", "menuicons/icon-gongsixiangmu.png",
//					new CwdProjectPermissionPanel.Factory(), true, "", CwdProjectPermissionPanel.class));

			//		menuMap.put(ERPPermissionStatic.PERSONAL_REGISTER_ADDRESS_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "员工注册地址管理" : "Personal Register Address Manage", "personal_register_address_manage", "cwd_menu", "silk/layout_content.png",
//            	 menuMap.put(ERPPermissionStatic.CWD_MENU, new ExplorerTreeNode(localName.equals("zh_CN") ? "协同设计管理" : "CWD Menu", "cwd_menu", "root", "silk/layout_content.png", null, true, "", null));
//	        	 	
	        	 //	        	 	menuMap.put(ERPPermissionStatic.CWD_OSS_CONFIG_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "OSS配置管理页面" : "OSS Config Manage", "oss_config_manage", "cwd_menu", "silk/layout_content.png",
//	        			 new OssConfigManagePanel.Factory(), true, "", OssConfigManagePanel.class));
//	        	 	//项目策划管理
//					menuMap.put(ERPPermissionStatic.PROJECT_PLAN_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "项目策划管理" : "Project Plan Manage", "project_plan_manage", "cwd_menu", "silk/layout_content.png",null, true, "",null));	
//						//任务模板管理
//						menuMap.put(ERPPermissionStatic.TASK_TEMPLATE_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "任务模板管理" : "Task Template Manage", "task_template_manage", "project_plan_manage", "silk/layout_content.png",
//								new ScwdtasktemplatetccorPanel.Factory(), true, "", ScwdtasktemplatetccorPanel.class));	
//					menuMap.put(ERPPermissionStatic.COMPANY_WORKPLACE_MANAGE, new ExplorerTreeNode(localName.equals("zh_CN") ? "公司工作场所管理" : "Company Workplace Manage", "company_workplace_manage", "cwd_menu", "silk/layout_content.png",
//		        			 new CompanyWorkplaceManagePanel.Factory(), true, "", CompanyWorkplaceManagePanel.class));
//        		menuMap.put(ERPPermissionStatic.PROJECT_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "项目管理" : "Project Management", "project_management", "operate_managment", "silk/layout_content.png", null, true, "", null));
//            	menuMap.put(ERPPermissionStatic.PROJECT_PRICE_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "项目价格表" : "Project Price", "project_price", "operate_managment", "silk/layout_content.png",
//                    new SprojectPricePanelPanel.Factory(), true, "", SprojectPricePanelPanel.class));
//                menuMap.put(ERPPermissionStatic.PROJECT_CONTRACT_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "项目合同" : "Project Contract", "project_contract", "operate_managment", "silk/layout_content.png",
//                    new ScontractccorPanel.Factory(), true, "", ScontractccorPanel.class));
//                menuMap.put(ERPPermissionStatic.COMPANY_PROJECT_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "公司项目" : "Company Project", "company_project", "operate_managment", "silk/layout_content.png",
//                    new GContractInfoPanel.Factory(), true, "", GContractInfoPanel.class));

//                    menuMap.put(ERPPermissionStatic.INTEGRAL_TRANSFER_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "积分转移记录" : "Integral Transfer", "integral_transfer", "my_project", "silk/layout_content.png",
//                        new MprojectintegraltransferrecordPanel.Factory(), true, "", MprojectintegraltransferrecordPanel.class));
//                    menuMap.put(ERPPermissionStatic.INTEGRAL_ASSIGN_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "积分发放记录" : "Integral Assign", "integral_assign", "my_project", "silk/layout_content.png",
//                        new SprojectIntegralAssignPanel.Factory(), true, "", SprojectIntegralAssignPanel.class));
//                    menuMap.put(ERPPermissionStatic.PLATE_INTEGRAL_TRANSFER_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "部门积分转移记录" : "Plate Integral Transfer", "plateIntegralTransfer", "my_project", "silk/layout_content.png",
//                        new SplateIntegralTransferRecordPanel.Factory(), true, "", SplateIntegralTransferRecordPanel.class));
//                    menuMap.put(ERPPermissionStatic.PLATE_INTEGRAL_ASSIGN_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "部门积分发放记录" : "Plate Integral Assign", "plateIntegralAssign", "my_project", "silk/layout_content.png",
//                        new SplateIntegralAssignRecordPanel.Factory(), true, "", SplateIntegralAssignRecordPanel.class));
//                menuMap.put(ERPPermissionStatic.PLATE_SEND_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "部门补贴" : "Plate Send", "plate_send", "operate_managment", "silk/layout_content.png",
//                    new PlateIntegralSendPanel.Factory(), true, "", PlateIntegralSendPanel.class));


//	                menuMap.put(ERPPermissionStatic.MAIN_CONTART_ONE_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "承接部门" : "Main Contract One", "main_contract_one", "main_contract_management", "silk/layout_content.png",
//	                        new CustomContractExpansionOnePanel.Factory(), true, "", CustomContractExpansionOnePanel.class));
//	                menuMap.put(ERPPermissionStatic.MAIN_CONTART_TWO_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "运营价格表" : "Main Contract Two", "main_contract_two", "main_contract_management", "silk/layout_content.png",
//	                        new CustomContractExpansionTwoPanel.Factory(), true, "", CustomContractExpansionTwoPanel.class));     

//                menuMap.put(ERPPermissionStatic.INTEGRAL_TOTAL_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "积分汇总" : "Integral Total","plate_integral_total", "report_management", "silk/layout_content.png",
//                    new MplateIntegralTotalPanel.Factory(), true, "", MplateIntegralTotalPanel.class));
//                menuMap.put(ERPPermissionStatic.INTEGRAL_TOTAL_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "积分汇总" : "Integral Total","plate_integral_total", "report_management", "silk/layout_content.png",
//                    new SplateintegralsumrecordpysorPanel.Factory(), true, "", SplateintegralsumrecordpysorPanel.class));原先的
//                menuMap.put(ERPPermissionStatic.INTEGRAL_TOTAL_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "积分汇总" : "Integral Total","plate_integral_total", "report_management", "silk/layout_content.png",
//                        new PlateReportRecordDetailPanel.Factory(), true, "", PlateReportRecordDetailPanel.class));
//                menuMap.put(ERPPermissionStatic.EMPLOYEE_INTEGRAL_TOTAL_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "成员积分汇总" : "Employee Integral Total", "award_total", "report_management", "silk/layout_content.png",
//                    new MemployeeAwardTotalPanel.Factory(), true, "", MemployeeAwardTotalPanel.class));
//                menuMap.put(ERPPermissionStatic.EMPLOYEE_INTEGRAL_TOTAL_MANAGEMENT, new ExplorerTreeNode(localName.equals("zh_CN") ? "成员积分汇总" : "Employee Integral Total", "award_total", "report_management", "silk/layout_content.png",
//                        new MemployeeAwardTotalPanel.Factory(), true, "", MemployeeAwardTotalPanel.class));

    }

    @Override
    public Set<String> getPrivileges() {
        return new HashSet<>();
    }
}
