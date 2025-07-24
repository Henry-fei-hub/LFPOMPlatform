
package com.pomplatform.client.data;

import com.delicacy.client.ui.Workflows;
import com.pomplatform.client.applyfunctions.form.ApplyFunctionsWorkflowProcessor;
import com.pomplatform.client.attachmentapproval.form.AttachmentApprovalWorkflowProcessor;
import com.pomplatform.client.budgetmanagementworkflow.form.BudgetManagementWorkFlowWorkflowProcessor;
import com.pomplatform.client.client.workflow.specialdeduction.form.SpecialDeductionInformationWorkflowProcessor;
import com.pomplatform.client.costallocation.form.CostAllocationApplyWorkflowProcessor;
import com.pomplatform.client.ja.ht.form.OutQuotationApplicationWorkflowProcessor;
import com.pomplatform.client.mainprojectinfo.form.BidPaySheetProjectWorkflowProcessor;
import com.pomplatform.client.onprojectquotetemplateworkflow.form.OnProjectQuoteTemplateWorkflowProcessor;
import com.pomplatform.client.preprojectnormalreimbursement.form.PreProjectNormalReimbursementWorkflowProcessor;
import com.pomplatform.client.preprojects.form.BeProjectApplyWorkflowProcessor;
import com.pomplatform.client.preprojects.form.CloseProjectApplyWorkflowProcessor;
import com.pomplatform.client.preprojects.form.PreProjectReportWorkflowProcessor;
import com.pomplatform.client.preprojecttransferrecordpors.form.ForPreproJectTransFerrecordporWorkflowProcessor;
import com.pomplatform.client.preprojecttravelreimbursement.form.PreProjectTravelReimbursementWorkflowProcessor;
import com.pomplatform.client.projectsettlement.form.ProfessionalApprovalApplicationWorkflowProcessor;
import com.pomplatform.client.projectsettlement.form.ProjectSettlementProcessApplicationWorkflowProcessor;
import com.pomplatform.client.projectstageauditinfo.form.ProjectStageAuditInfoWorkflowProcessor;
import com.pomplatform.client.projectstages.form.ProjectStagesProcessApplicationWorkflowProcessor;
import com.pomplatform.client.salaryexceptions.form.OnSalaryExceptionsWorkflowProcessor;
import com.pomplatform.client.scapitaldistributionor.form.ScapitaldistributionorWorkflowProcessor;
import com.pomplatform.client.supplierworkflow.form.SupplierComeInWorkflowProcessor;
import com.pomplatform.client.trainingmanagement.form.TrainingManagementInformationWorkflowProcessor;
import com.pomplatform.client.workflow.commonNormalReimbursement.form.NormalReimbursementWithDepartmentWorkflowProcessor;
import com.pomplatform.client.workflow.commonTravelReimbursement.form.TravelReimbursementWithDepartmentWorkflowProcessor;
import com.pomplatform.client.workflow.companyCommonNormalReimbursement.form.CompanyNormalReimbursementWorkflowProcessor;
import com.pomplatform.client.workflow.contractstatus.form.ContractStatusWorkflowProcessor;
import com.pomplatform.client.workflow.form.*;
import com.pomplatform.client.workflow.personnel.form.WorkingHoursLinkPersonnelBusinessWorkflowProcessor;
import com.pomplatform.client.workflow.personnelbusiness.form.*;
import com.pomplatform.client.workflow.projectNormalReimbursement.form.NormalReimbursementWithProjectWorkflowProcessor;
import com.pomplatform.client.workflow.projectTravelReimbursement.form.NewProjectTravelReimbursementWorkflowProcessor;

public class WorkflowProcessors {
	
	public static void initTables() {
		//预付款申请OK
		Workflows.addProcessor("Pay_money_manage", new PayMoneyManageOfWorkflowWorkflowProcessor());
		//		Workflows.addProcessor("Reimbursement_travel", new ReimbursementWithRWorkflowProcessor());
		//借款申请OK
		Workflows.addProcessor("Borrow_money_manage", new EmployeeBorrowMoneyByWorkflowWorkflowProcessor());
		//		Workflows.addProcessor("Project_normal_reimbursement", new ProjectNormalReimbursementOfWorkflowWorkflowProcessor());
		//		Workflows.addProcessor("Common_normal_reimbursement", new CommonNormalReimbursementOfWorkflowWorkflowProcessor());
		//项目差旅报销OK
		Workflows.addProcessor("Project_travel_reimbursement", new NewProjectTravelReimbursementWorkflowProcessor());
		//项目日常报销OK
		Workflows.addProcessor("Project_normal_reimbursement", new NormalReimbursementWithProjectWorkflowProcessor());
		//普通差旅报销OK
		Workflows.addProcessor("Common_travel_reimbursement", new TravelReimbursementWithDepartmentWorkflowProcessor());
		//普通日常报销OK
		Workflows.addProcessor("Common_normal_reimbursement", new NormalReimbursementWithDepartmentWorkflowProcessor());
		//前期项目日常报销OK
		Workflows.addProcessor("Pre_project_normal_reimbursement", new PreProjectNormalReimbursementWorkflowProcessor());
		//前期项目差旅报销OK
		Workflows.addProcessor("Pre_project_travel_reimbursement", new PreProjectTravelReimbursementWorkflowProcessor());
		//公司日常报销OK
		Workflows.addProcessor("Company_normal_reimbursement", new CompanyNormalReimbursementWorkflowProcessor());
		//回款分配OK
		Workflows.addProcessor("Capital_distribution", new ScapitaldistributionorWorkflowProcessor());
		//非项目出差申请OK
		Workflows.addProcessor("Business_trip_apply", new BusinessTripApplyWorkflowProcessor());
		//打卡申请
		Workflows.addProcessor("Fillcheck_apply", new FillcheckApplyWorkflowProcessor());
		//外出申请OK
		Workflows.addProcessor("Stayaway_apply", new StayawayApplyWorkflowProcessor());
		//加班申请OK
		Workflows.addProcessor("Overtime_apply", new OvertimeApplyWorkflowProcessor());
		//请假申请OK
		Workflows.addProcessor("Leave_apply", new LeaveApplyWorkflowProcessor());
		//项目出差申请OK
		Workflows.addProcessor("Business_project_trip_apply", new BusinessProjectTripApplyWorkflowProcessor());
		//入职申请OK wait
		Workflows.addProcessor("Employee_onboard_apply", new EmployeeOnboardInformationWorkflowProcessor());		
		//出差延期申请OK
		Workflows.addProcessor("Delay_business_project_trip_apply", new DelayBusinessTripApplyWorkflowProcessor());
		//出差变更行程申请OK
		Workflows.addProcessor("Change_travel_business_project_trip_apply", new ChangeTravelBusinessTripApplyWorkflowProcessor());
		//项目派驻申请OK
		Workflows.addProcessor("Project_accredit_apply", new SpersonnelbusinespporWorkflowProcessor());
		//延期项目派驻申请OK wait
		Workflows.addProcessor("Delay_project_accredit_apply", new DelaySpersonnelbusinespporWorkflowProcessor());
		//确认派驻结束 申请加班日期OK
		Workflows.addProcessor("Confirm_project_accredit_apply", new ConfirmSpersonnelbusinespporWorkflowProcessor());
		//确认函申请OK
		Workflows.addProcessor("Attachment_apply", new AttachmentApplyWorkflowProcessor());
		//转岗申请OK
		Workflows.addProcessor("Apply_for_transfer", new ApplyForTransferWorkflowProcessor());
		//离职申请OK
		Workflows.addProcessor("Resignation_apply", new ResignationApplyWorkflowProcessor());
		//员工还款申请OK
		Workflows.addProcessor("Employee_repayment_apply", new EmployeeRepaymentWorkflowProcessor());
		//员工转正申请-OK
		Workflows.addProcessor("Regular_employee_apply", new RegularEmployeeApplyWorkflowProcessor());
		//调薪申请OK
		Workflows.addProcessor("Salary_adjustment_apply", new SalaryAdjustmentApplyWorkflowProcessor());
		//物品申请OK
		Workflows.addProcessor("Goods_apply", new GoodsApplyWorkflowProcessor());
		//用车申请OK
		Workflows.addProcessor("Cars_apply", new CarApplyWorkflowProcessor());
		//刻章申请OK
		Workflows.addProcessor("Stamp_carving_apply", new StampCarvingApplyWorkflowProcessor());
		//名片申请OK
		Workflows.addProcessor("Business_card_apply", new BusinessCardApplyWorkflowProcessor());
		//采购申请OK wait
		Workflows.addProcessor("Purchase_apply", new PurchaseApplyWorkflowProcessor());
		//薪资发放申请OK
		Workflows.addProcessor("Payroll_apply", new PayrollApplyWorkflowProcessor());
		//成本调节OK wait
		Workflows.addProcessor("Cost_allocation", new CostAllocationApplyWorkflowProcessor());
		//网络权限OK wait
		Workflows.addProcessor("Network_privileges", new NetworkPrivilegesWorkflowProcessor());
		//收款单位还款申请
		Workflows.addProcessor("Receive_unit_apply", new ReceiveUnitRepaymentWorkflowProcessor());
		//项目报备流程
		Workflows.addProcessor("Pre_project_report", new PreProjectReportWorkflowProcessor());
		//前期项目立项流程
		Workflows.addProcessor("Be_project_apply", new BeProjectApplyWorkflowProcessor());
		//前期项目关闭流程DSEmployee
		Workflows.addProcessor("Close_project_apply", new CloseProjectApplyWorkflowProcessor());
		//工资异常申请
		Workflows.addProcessor("Salary_Exceptions", new OnSalaryExceptionsWorkflowProcessor());
		//前期项目转单
		Workflows.addProcessor("Prepro_JectTransFerrecordpor", new ForPreproJectTransFerrecordporWorkflowProcessor());
		//预算单立项
		Workflows.addProcessor("Budget_Management", new BudgetManagementWorkFlowWorkflowProcessor());
		//供应商入库申请
		Workflows.addProcessor("Supplier_Come_In", new SupplierComeInWorkflowProcessor());
		//预算附件审批流程
		Workflows.addProcessor("Attachment_Approval", new AttachmentApprovalWorkflowProcessor());
		//订单跨阶段评审流程
		Workflows.addProcessor("Project_stage_audit", new ProjectStageAuditInfoWorkflowProcessor());
		//项目报价流程
		Workflows.addProcessor("On_Project_Quote_Template", new OnProjectQuoteTemplateWorkflowProcessor());
		//个税专项扣除流程
		Workflows.addProcessor("special_deduction_information", new SpecialDeductionInformationWorkflowProcessor());
		//培训申请流程
		Workflows.addProcessor("training_management_information", new TrainingManagementInformationWorkflowProcessor());
		//权限申请流程
		Workflows.addProcessor("Apply_Functions", new ApplyFunctionsWorkflowProcessor());
		//劳动合同续签流程
		Workflows.addProcessor("Labor_contract_renewal", new EmployeeContractAttachmentWorkflowProcessor ());
		//盖章申请流程
		Workflows.addProcessor("Seal_Application", new SealApplicationWorkflowProcessor());
		//奖金发放申请流程
		Workflows.addProcessor("Bonus_Application", new BonusPaymentRecordWithBWorkflowProcessor());
		//调档申请流程
		Workflows.addProcessor("Application_Filing", new ApplicationFilingWorkflowProcessor());
		//合同状态变更
		Workflows.addProcessor("Change_Contract_Status", new ContractStatusWorkflowProcessor());
		//落标申请流程
		Workflows.addProcessor("Bid_Pay_Sheet_Project", new BidPaySheetProjectWorkflowProcessor());
		//报价单提交申请流程
		Workflows.addProcessor("Out_Quotation_Application", new OutQuotationApplicationWorkflowProcessor());
		//可分配阶段申请流程
		Workflows.addProcessor("Project_Stages_Process_Application", new ProjectStagesProcessApplicationWorkflowProcessor());
		//团队组建流程
		Workflows.addProcessor("Project_Employee_Process_Application", new ProjectEmployeeProcessApplicationWorkflowProcessor());
		//我的出图申请
		Workflows.addProcessor("Output_Drawing", new OutputDrawingWorkflowProcessor());
		//经费结算申请
		Workflows.addProcessor("Project_Settlement_Process_Application", new ProjectSettlementProcessApplicationWorkflowProcessor());
		//配合申请
		Workflows.addProcessor("Cooperate_Apply", new CooperateApplyWorkflowProcessor());
		//结算申请
		Workflows.addProcessor("Settlement_Apply", new SettlementApplyWorkflowProcessor());
		//物品归还
		Workflows.addProcessor("Return_of_items", new ReturnOfItemsWorkflowProcessor());
		//我的工时
		Workflows.addProcessor("Working_hours", new WorkingHoursLinkPersonnelBusinessWorkflowProcessor());
		//专业负责人审批
		Workflows.addProcessor("Professional_Approval_Application", new ProfessionalApprovalApplicationWorkflowProcessor());
		//订单下达
		Workflows.addProcessor("Order_Placement", new OrderPlacementWorkflowProcessor());
	}

}
