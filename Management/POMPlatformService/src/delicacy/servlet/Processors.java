package delicacy.servlet;


public class Processors extends AbstractProcessores {

    @Override
    public void initTables() {
        QUERIES.put("CalculateAnnualLeaveNew", "pomplatform.salary.handler.CalculateAnnualLeaveNewHandler");
        QUERIES.put("AttendanceCheckinoutData", "pomplatform.shift.handler.AttendanceCheckinoutDataHandler");
        QUERIES.put("ProjectStagesProcessApplication", "pomplatform.ProjectStages.handler.ProjectStagesProcessApplicationHandler");
        QUERIES.put("LoadCurrentProjectStageProcessDetail", "pomplatform.ProjectStages.handler.LoadCurrentProjectStageProcessDetailHandler");
        QUERIES.put("SearchReimbursementInfo", "pomplatform.reimbursement.handler.SearchReimbursementInfoHandler");
        QUERIES.put("AttendanceAnalyseCheck", "pomplatform.shift.handler.AttendanceAnalyseCheckHandler");
        QUERIES.put("AttendancePersonnelData", "pomplatform.shift.handler.AttendancePersonnelDataHandler");
        QUERIES.put("CalculateAnnualLeave", "pomplatform.salary.handler.CalculateAnnualLeaveHandler");
        QUERIES.put("Sprojectstagecor", "pomplatform.ProjectStages.handler.SprojectstagecorHandler");
        QUERIES.put("ProjectManager", "pomplatform.operation.handler.ProjectManagerHandler");
        QUERIES.put("OnJobEmployees", "pomplatform.employeerescord.handler.OnJobEmployeesHandler");
        PROCESSORS.put("OnCommonCustomSelectProcess", "pomplatform.common.business.OnCommonCustomSelectProcess");
        QUERIES.put("OnLoadAuditListOfProfessionalApproval", "pomplatform.workflow.professional.handler.OnLoadAuditListOfProfessionalApprovalHandler");
        QUERIES.put("EquipmentDetail", "pomplatform.equipment.handler.EquipmentDetailHandler");
        DOWNLOADPROCESSORS.put("EquipmentDetail", "pomplatform.equipment.handler.EquipmentDetailHandler");
        QUERIES.put("PlateDeployDetails", "pomplatform.account.handler.PlateDeployDetailsHandler");
        QUERIES.put("EmployeeStructureOverview2", "pomplatform.report.handler.EmployeeStructureOverview2Handler");
        QUERIES.put("EmployeeStructureOverview1", "pomplatform.report.handler.EmployeeStructureOverview1Handler");
        QUERIES.put("EmployeeStructureOverview", "pomplatform.report.handler.EmployeeStructureOverviewHandler");
        DOWNLOADPROCESSORS.put("EmployeeStructureOverview", "pomplatform.report.handler.EmployeeStructureOverviewHandler");
        QUERIES.put("Moutquotationooor", "pomplatform.outQuotations.handler.MoutquotationooorHandler");
        QUERIES.put("ProjectCostRecord", "pomplatform.projectCost.handler.ProjectCostRecordHandler");
        QUERIES.put("EmployeesOrders", "pomplatform.report.handler.EmployeesOrdersHandler");
        DOWNLOADPROCESSORS.put("EmployeesOrders", "pomplatform.report.handler.EmployeesOrdersHandlerCustom");
        QUERIES.put("BillingInfo", "pomplatform.report.handler.BillingInfoHandler");
        QUERIES.put("CooperateStatisticsTotal", "pomplatform.report.handler.CooperateStatisticsTotalHandler");
        DOWNLOADPROCESSORS.put("CooperateStatisticsTotal", "pomplatform.report.handler.CooperateStatisticsTotalHandler");

        QUERIES.put("ContractPrice", "pomplatform.ht.handler.ContractPriceHandler");
        DOWNLOADPROCESSORS.put("ContractPrice", "pomplatform.ht.handler.ContractPriceHandler");

        QUERIES.put("OnLoadApplyListOfOrderInfo", "pomplatform.orderplacement.handler.OnLoadApplyListOfOrderInfoHandler");
        QUERIES.put("OnLoadApproveContractRunDry", "pomplatform.orderplacement.handler.OnLoadApproveContractRunDryHandler");
        QUERIES.put("OnLoadAttentionListOfOrderInfo", "pomplatform.orderplacement.handler.OnLoadAttentionListOfOrderInfoHandler");
        QUERIES.put("Msystemprocessattentionposmoespeccor", "pomplatform.orderplacement.handler.MsystemprocessattentionposmoespeccorHandler");
        DAOS.put("OrderInfoWithO", "pomplatform.orderplacement.handler.OrderInfoWithOHandler");
        WORKFLOWPROCESSORS.put("Order_Placement", "pomplatform.orderplacement.handler.OrderPlacementWorker");
        QUERIES.put("OrderPlacement", "pomplatform.orderplacement.handler.OrderPlacementHandler");

        QUERIES.put("OutQuotationApplication", "pomplatform.ht.handler.OutQuotationApplicationHandler");
        QUERIES.put("OnLoadAuditListOfOutQuotations", "pomplatform.outQuotations.handler.OnLoadAuditListOfOutQuotationsHandler");
        QUERIES.put("OnLoadAttentionListOfOutQuotations", "pomplatform.outQuotations.handler.OnLoadAttentionListOfOutQuotationsHandler");
        QUERIES.put("OnLoadApplyListOfOutQuotations", "pomplatform.outQuotations.handler.OnLoadApplyListOfOutQuotationsHandler");
        QUERIES.put("OnLoadContractMessageByEmployeeId", "pomplatform.contractMessage.handler.OnLoadContractMessageByEmployeeIdHandler");

        PROCESSORS.put("ArealProcess", "pomplatform.areas.business.ArealProcess");
        QUERIES.put("Scontractppcor", "pomplatform.newcontractppcor.handler.ScontractppcorHandler");
        QUERIES.put("MeetingRoomReservaTionRecordPaymentBase", "pomplatform.meeting.handler.MeetingRoomReservaTionRecordPaymentBaseHandler");
        QUERIES.put("SelectGridMyMainProjectValue", "pomplatform.selectgrid.handler.SelectGridMyMainProjectValueHandler");
        DOWNLOADPROCESSORS.put("OnGetFullTimeEmployeeData", "pomplatform.shift.handler.OnGetFullTimeEmployeeDataHandler");
        QUERIES.put("OnGetFullTimeEmployeeData", "pomplatform.shift.handler.OnGetFullTimeEmployeeDataHandler");
        DOWNLOADPROCESSORS.put("OnGetEmployeeMonthCheck", "pomplatform.shift.handler.OnGetEmployeeMonthCheckHandlerCustom");
        QUERIES.put("OnGetEmployeeMonthCheck", "pomplatform.shift.handler.OnGetEmployeeMonthCheckHandler");
        //员工日工时统计表
        QUERIES.put("ReportEmployeeDailyHoursTotal", "pomplatform.report.handler.ReportEmployeeDailyHoursTotalHandler");
        DOWNLOADPROCESSORS.put("ReportEmployeeDaily", "pomplatform.report.handler.ReportEmployeeDailyHoursTotalHandler");
        //项目工时统计表
        QUERIES.put("ReportProjectWorkTimeDetail","pomplatform.report.handler.ReportProjectWorkTimeDetailHandler");
        QUERIES.put("ReportProjectWorkTime","pomplatform.report.handler.ReportProjectWorkTimeHandler");
        DOWNLOADPROCESSORS.put("ProjectWorkTimeExport","pomplatform.report.handler.ReportProjectWorkTimeHandler");

        DOWNLOADPROCESSORS.put("ExportAttendanceSummaryDetail", "pomplatform.check.handler.ExportAttendanceSummaryDetailHandler");
        QUERIES.put("ExportAttendanceSummaryDetail", "pomplatform.check.handler.ExportAttendanceSummaryDetailHandler");
        WORKFLOWPROCESSORS.put("Working_hours", "pomplatform.workflow.personnel.handler.WorkingHoursLinkPersonnelBusinessWorker");
        QUERIES.put("WorkingHoursLinkPersonnelBusiness", "pomplatform.workflow.personnel.handler.WorkingHoursLinkPersonnelBusinessHandler");
        DOWNLOADPROCESSORS.put("ContractDistributionNew", "pomplatform.employee.handler.ContractDistributionNewHandler");
        QUERIES.put("OnLoadMainProjectEmployeeByOutQuotations", "pomplatform.project.handler.OnLoadMainProjectEmployeeByOutQuotationsHandler");
        QUERIES.put("OnLoadMainProjectEmployee", "pomplatform.project.handler.OnLoadMainProjectEmployeeHandler");
        QUERIES.put("OnLoadEmployeeMonthCheck", "pomplatform.shift.handler.OnLoadEmployeeMonthCheckHandler");
        QUERIES.put("OnLoadMainProjectEmployeeByContractId", "pomplatform.project.handler.OnLoadMainProjectEmployeeByContractIdHandler");
        QUERIES.put("RankMaintenance", "pomplatform.sealKeepers.handler.RankMaintenanceHandler");
        QUERIES.put("RankMax", "pomplatform.sealkeepers.handler.RankMaxHandler");
        QUERIES.put("getAllTables", "pomplatform.tablemaintain.handler.getAllTablesHandler");
        QUERIES.put("TableMaintain", "pomplatform.tablemaintain.handler.TableMaintainHandler");
        QUERIES.put("EmployeeRoleInfo", "pomplatform.role.handler.EmployeeRoleInfoHandler");
        QUERIES.put("OnLoadMainProjectEmployeeNameAndNo", "pomplatform.preProjects.handler.OnLoadMainProjectEmployeeNameAndNoHandler");
        QUERIES.put("OnLoadContractMessageDetail", "pomplatform.contractMessage.handler.OnLoadContractMessageDetailHandler");
        QUERIES.put("Mcontractmor", "pomplatform.contractMessage.handler.McontractmorHandler");
        QUERIES.put("OnLoadEmployeeAccountByBusinessTypeData", "pomplatform.account.handler.OnLoadEmployeeAccountByBusinessTypeDataHandler");
        QUERIES.put("OnLoadContractByMainProjectEmployeeId", "pomplatform.subContractInfo.handler.OnLoadContractByMainProjectEmployeeIdHandler");
        QUERIES.put("OnLoadCapitalAndContractPercent", "pomplatform.ht.handler.OnLoadCapitalAndContractPercentHandler");
        QUERIES.put("OnLoadPreProjectById", "pomplatform.preProjects.handler.OnLoadPreProjectByIdHandler");
        QUERIES.put("ConfirmablePhasesList", "pomplatform.ProjectStages.handler.ConfirmablePhasesListHandler");
        QUERIES.put("PersonnelBusinessLinkProcessInstance", "pomplatform.workflow.personnelbusiness.handler.PersonnelBusinessLinkProcessInstanceHandler");
        WORKFLOWPROCESSORS.put("Return_of_items", "pomplatform.workflow.personnelbusiness.handler.ReturnOfItemsWorker");
        QUERIES.put("ReturnOfItems", "pomplatform.workflow.personnelbusiness.handler.ReturnOfItemsHandler");
        QUERIES.put("OnLoadDepartmentByParentId", "pomplatform.department.handler.OnLoadDepartmentByParentIdHandler");
        QUERIES.put("UsedVacationLeave", "pomplatform.workflow.personnelbusiness.handler.UsedVacationLeaveHandler");
        QUERIES.put("SettlementApplicationProject", "pomplatform.settlementapplicationproject.handler.SettlementApplicationProjectHandler");
        QUERIES.put("OnLoadSubContractRemark", "pomplatform.subContractInfo.handler.OnLoadSubContractRemarkHandler");
        QUERIES.put("SearchMainProjectEmployeeDataByProjectId", "pomplatform.preProjects.handler.SearchMainProjectEmployeeDataByProjectIdHandler");
        QUERIES.put("OnLoadMainProjectStageByParentId", "pomplatform.stage.handler.OnLoadMainProjectStageByParentIdHandler");
        QUERIES.put("OnLoadProjectTransitionRecord", "pomplatform.ProjectTransitions.handler.OnLoadProjectTransitionRecordHandler");
        QUERIES.put("OnLoadEmployeeCheckTime", "pomplatform.shift.handler.OnLoadEmployeeCheckTimeHandler");
        QUERIES.put("ProjectReportRecordDetail", "pomplatform.projectReportRecordDetail.handler.ProjectReportRecordDetailHandler");
        QUERIES.put("OnLoadProjectEmpByProcess", "pomplatform.projectEmployee.handler.OnLoadProjectEmpByProcessHandler");
        DOWNLOADPROCESSORS.put("CalculateAnnualLeave", "pomplatform.salary.handler.CalculateAnnualLeaveHandler");
        PROCESSORS.put("ProjectCommonProcess", "pomplatform.project.business.ProjectCommonProcess");
        QUERIES.put("SearchProjectType16Data", "pomplatform.project.handler.SearchProjectType16DataHandler");
        PROCESSORS.put("MainProjectProcessor", "pomplatform.mainProjectInfo.handler.MainProjectProcessor");
        QUERIES.put("GetRole93Employees", "pomplatform.employeeRole.handler.GetRole93EmployeesHandler");
        QUERIES.put("OnLoadAuditListOfProjectSettlement", "pomplatform.projectSettlement.handler.OnLoadAuditListOfProjectSettlementHandler");
        QUERIES.put("OnLoadAuditListOfProjectEmployees", "pomplatform.projectEmployee.handler.OnLoadAuditListOfProjectEmployeesHandler");
        QUERIES.put("OnLoadAuditListOfProjectStages", "pomplatform.ProjectStages.handler.OnLoadAuditListOfProjectStagesHandler");
        QUERIES.put("Mcontractreceivablecipcor", "pomplatform.contractreceivablecipor.handler.McontractreceivablecipcorHandler");
        PROCESSORS.put("ContractReceivableProcessor", "pomplatform.contractreceivablecipor.handler.ContractReceivableProcessor");
        QUERIES.put("OnLoadProjectStageInProcess", "pomplatform.ProjectStages.handler.OnLoadProjectStageInProcessHandler");
        QUERIES.put("NumberOfPunches", "pomplatform.workflow.personnelbusiness.handler.NumberOfPunchesHandler");
        QUERIES.put("MakeEmployeeNo", "pomplatform.workflow.personnelbusiness.handler.MakeEmployeeNoHandler");
        QUERIES.put("OnLoadContractMessageRecord", "pomplatform.contractMessage.handler.OnLoadContractMessageRecordHandler");
        PROCESSORS.put("WorkingHourProcessor", "pomplatform.workinghour.handler.WorkingHourProcessor");
        DAOS.put("CustomWorkingHour", "pomplatform.workinghour.handler.CustomWorkingHourHandler");
        DOWNLOADPROCESSORS.put("WorkingHourManage", "pomplatform.workinghour.handler.WorkingHourManageHandler");
        QUERIES.put("WorkingHourManage", "pomplatform.workinghour.handler.WorkingHourManageHandler");
        QUERIES.put("OnLoadSettlementEmployees", "pomplatform.projectSettlement.handler.OnLoadSettlementEmployeesHandler");
        QUERIES.put("OnLoadProjectSettlementEmployees", "pomplatform.projectSettlement.handler.OnLoadProjectSettlementEmployeesHandler");
        QUERIES.put("OnLoadAttentionListOfProjectSettlement", "pomplatform.projectSettlement.handler.OnLoadAttentionListOfProjectSettlementHandler");
        QUERIES.put("OnLoadApplyListOfProjectSettlement", "pomplatform.projectSettlement.handler.OnLoadApplyListOfProjectSettlementHandler");
        //结算申请
        WORKFLOWPROCESSORS.put("Settlement_Apply", "pomplatform.workflow.personnelbusiness.handler.SettlementApplyWorker");
        //配合申请
        WORKFLOWPROCESSORS.put("Cooperate_Apply", "pomplatform.workflow.personnelbusiness.handler.CooperateApplyWorker");
        QUERIES.put("OnLoadProjectOverview", "pomplatform.project.handler.OnLoadProjectOverviewHandler");
        QUERIES.put("GetCountProjectSettlementCountByProjectId", "pomplatform.projectSettlement.handler.GetCountProjectSettlementCountByProjectIdHandler");
        DAOS.put("ProjectSettlementWithP", "pomplatform.projectSettlement.handler.ProjectSettlementWithPHandler");
        WORKFLOWPROCESSORS.put("Project_Settlement_Process_Application", "pomplatform.projectSettlement.handler.ProjectSettlementProcessApplicationWorker");
        QUERIES.put("ProjectSettlementProcessApplication", "pomplatform.projectSettlement.handler.ProjectSettlementProcessApplicationHandler");
        //我的出图
        WORKFLOWPROCESSORS.put("Output_Drawing", "pomplatform.workflow.personnelbusiness.handler.OutputDrawingWorker");
        QUERIES.put("GetMainProEmpByProject", "pomplatform.workflow.handler.GetMainProEmpByProjectHandler");
        QUERIES.put("OnCheckProjectEmployeesProcess", "pomplatform.projectEmployee.handler.OnCheckProjectEmployeesProcessHandler");
        QUERIES.put("OnLoadAttentionListOfProjectEmployees", "pomplatform.projectEmployee.handler.OnLoadAttentionListOfProjectEmployeesHandler");
        QUERIES.put("OnLoadApplyListOfProjectEmployees", "pomplatform.projectEmployee.handler.OnLoadApplyListOfProjectEmployeesHandler");
        DAOS.put("PersonnelBusinesWithP", "pomplatform.personnelbusiness.handler.PersonnelBusinesWithPHandler");
        WORKFLOWPROCESSORS.put("Project_Employee_Process_Application", "pomplatform.personnelbusiness.handler.ProjectEmployeeProcessApplicationWorker");
        QUERIES.put("ProjectEmployeeProcessApplication", "pomplatform.personnelbusiness.handler.ProjectEmployeeProcessApplicationHandler");
        PROCESSORS.put("ProjectTransitionUpdate", "pomplatform.ProjectTransitions.handler.ProjectTransitionUpdate");
        QUERIES.put("OnLoadAttentionListOfProjectStages", "pomplatform.ProjectStages.handler.OnLoadAttentionListOfProjectStagesHandler");
        QUERIES.put("OnLoadApplyListOfProjectStages", "pomplatform.ProjectStages.handler.OnLoadApplyListOfProjectStagesHandler");
        DAOS.put("ProjectStageProcessRecordWithP", "pomplatform.ProjectStages.handler.ProjectStageProcessRecordWithPHandler");
        WORKFLOWPROCESSORS.put("Project_Stages_Process_Application", "pomplatform.ProjectStages.handler.ProjectStagesProcessApplicationWorker");
        QUERIES.put("OnLoadMainProjectBusinessTypeByContract", "pomplatform.outQuotations.handler.OnLoadMainProjectBusinessTypeByContractHandler");
        PROCESSORS.put("CheckQuotationStatus", "pomplatform.ht.handler.CheckQuotationStatus");
        QUERIES.put("Soutdesignconsiderationoor2", "pomplatform.soutdesignconsiderationoor.handler.Soutdesignconsiderationoor2Handler");
        DAOS.put("OutQuotationWithO", "pomplatform.ht.handler.OutQuotationWithOHandler");
        WORKFLOWPROCESSORS.put("Out_Quotation_Application", "pomplatform.ht.handler.OutQuotationApplicationWorker");
        QUERIES.put("AttentionListOfMainProjectReport", "pomplatform.workflow.handler.AttentionListOfMainProjectReportHandler");
        QUERIES.put("RefuseListOfMainProjectReport", "pomplatform.workflow.handler.RefuseListOfMainProjectReportHandler");
        QUERIES.put("ApplyListOfMainProjectReport", "pomplatform.workflow.handler.ApplyListOfMainProjectReportHandler");
        QUERIES.put("LoadCompetitionUnitsData", "pomplatform.preProjects.handler.LoadCompetitionUnitsDataHandler");
        QUERIES.put("MainProjectApply", "pomplatform.mainProjects.handler.MainProjectApplyHandler");
        QUERIES.put("OnLoadFlowAuditListOfMainProjectBuisnessData", "pomplatform.workflow.handler.OnLoadFlowAuditListOfMainProjectBuisnessDataHandler");
        QUERIES.put("Ssystemdictionaryor", "pomplatform.stage.handler.SsystemdictionaryorHandler");
        QUERIES.put("SumOutQuotationInteriorMoney", "pomplatform.outquotation.handler.SumOutQuotationInteriorMoneyHandler");
        QUERIES.put("ProcessInfoInTransDetail", "pomplatform.financialtransactionaccount.handler.ProcessInfoInTransDetailHandler");
        DOWNLOADPROCESSORS.put("OnLoadBidPaySheetProjectSummary", "pomplatform.mainProjectInfo.handler.OnLoadBidPaySheetProjectSummaryHandler");
        QUERIES.put("EmployeeFinancialTransSum", "pomplatform.employee.handler.EmployeeFinancialTransSumHandler");
        QUERIES.put("sealKeepersWorkflow", "pomplatform.sealKeepers.handler.sealKeepersWorkflowHandler");
        QUERIES.put("OnCheckSpecialCountByYear", "pomplatform.specialDeduction.handler.OnCheckSpecialCountByYearHandler");
        QUERIES.put("OnLoadBidPaySheetProjectSummary", "pomplatform.mainProjectInfo.handler.OnLoadBidPaySheetProjectSummaryHandler");
        QUERIES.put("ProcessInfoInTransDetail", "pomplatform.financialtransactionaccount.handler.ProcessInfoInTransDetailHandler");
        DOWNLOADPROCESSORS.put("OnLoadBidPaySheetProjectSummary", "pomplatform.mainProjectInfo.handler.OnLoadBidPaySheetProjectSummaryHandler");
        //产值系数管理界面
        DAOS.put("ProductionValueCoefficientTypeWithP", "pomplatform.plateproductionvalue.handler.ProductionValueCoefficientTypeWithPHandler");
        QUERIES.put("ProductionValueCoefficientType", "pomplatform.plateproductionvalue.handler.ProductionValueCoefficientTypeHandler");
        QUERIES.put("Sproductionvaluecoefficienttypepor", "pomplatform.plateproductionvalue.handler.SproductionvaluecoefficienttypeporHandler");
        QUERIES.put("ProductionValueCoefficient", "pomplatform.plateproductionvalue.handler.ProductionValueCoefficientHandler");
        PROCESSORS.put("ProductionValueProcessor", "pomplatform.plateproductionvalue.business.ProductionValueProcessor");
        QUERIES.put("SearchMainProjectEmployeeData", "pomplatform.preProjects.handler.SearchMainProjectEmployeeDataHandler");
        QUERIES.put("Msystemprocessinstanceppcmor", "pomplatform.mainProjectInfo.handler.MsystemprocessinstanceppcmorHandler");
        QUERIES.put("Mcontractpmcior", "pomplatform.mainProjectInfo.handler.McontractpmciorHandler");
        QUERIES.put("OnLoadAttentionListOfBidPaySheetProject", "pomplatform.mainProjectInfo.handler.OnLoadAttentionListOfBidPaySheetProjectHandler");
        QUERIES.put("OnLoadAuditListOfBidPaySheetProject", "pomplatform.mainProjectInfo.handler.OnLoadAuditListOfBidPaySheetProjectHandler");
        QUERIES.put("OnLoadApplyListOfBidPaySheetProject", "pomplatform.mainProjectInfo.handler.OnLoadApplyListOfBidPaySheetProjectHandler");
        PROCESSORS.put("BudgetProcessor", "pomplatform.budgetmanagement.business.BudgetProcessor");
        UPLOADPROCESSORS.put("employeeSalaryType", "pomplatform.report.business.EmployeeSalaryTypeProcess");
        QUERIES.put("EmployeeCost", "pomplatform.report.handler.EmployeeCostHandler");
        QUERIES.put("Test01", "pomplatform.test.handler.Test01Handler");
        QUERIES.put("OnloadPreprojectDataForMobile2", "pomplatform.preProjects.handler.OnloadPreprojectDataForMobile2Handler");
        QUERIES.put("Sspecialdeductionmonthdetailedpor", "pomplatform.specialDeduction.handler.SspecialdeductionmonthdetailedporHandler");
        WORKFLOWPROCESSORS.put("Bid_Pay_Sheet_Project", "pomplatform.mainProjectInfo.handler.BidPaySheetProjectWorker");
        QUERIES.put("BidPaySheetProject", "pomplatform.mainProjectInfo.handler.BidPaySheetProjectHandler");
        DOWNLOADPROCESSORS.put("BudgetAttachmentDetail", "pomplatform.BudgetAttachmentDetail.handler.BudgetAttachmentDetailHandler");
        QUERIES.put("ChangeContractStatus", "pomplatform.workflow.contractstatus.handler.ChangeContractStatusHandler");
        QUERIES.put("Msoftwareoperationlogeoseedor", "pomplatform.cwd.softoperate.handler.MsoftwareoperationlogeoseedorHandler");
        QUERIES.put("MemployeeSoftInstall", "pomplatform.cwd.softoperate.handler.MemployeeSoftInstallHandler");
        DOWNLOADPROCESSORS.put("Mreimbursementinvoiceinformationrsrmmpror", "pomplatform.rmimburseementinvoice.handler.MreimbursementinvoiceinformationrsrmmprorHandler");
        QUERIES.put("Mreimbursementinvoiceinformationrsrmmpror", "pomplatform.rmimburseementinvoice.handler.MreimbursementinvoiceinformationrsrmmprorHandler");
        QUERIES.put("OnLoadProjectStageSettlement2", "pomplatform.project.handler.OnLoadProjectStageSettlement2Handler");
        QUERIES.put("OnLoadProjectStage", "pomplatform.project.handler.OnLoadProjectStageHandler");
        QUERIES.put("ContractThatHaveCostInWorkflow", "pomplatform.workflow.contractstatus.handler.ContractThatHaveCostInWorkflowHandler");
        QUERIES.put("ContractThatCanEnd", "pomplatform.workflow.contractstatus.handler.ContractThatCanEndHandler");
        PROCESSORS.put("ContractStatusProcessor", "pomplatform.workflow.contractstatus.business.ContractStatusProcessor");
        QUERIES.put("ContractWithoutSureIntegral", "pomplatform.workflow.contractstatus.handler.ContractWithoutSureIntegralHandler");
        QUERIES.put("ContractStatusMonth", "pomplatform.workflow.contractstatus.handler.ContractStatusMonthHandler");
        QUERIES.put("GetAttenEmpByContractStatus", "pomplatform.workflow.contractstatus.handler.GetAttenEmpByContractStatusHandler");
        QUERIES.put("AttentionListOfChangeContractStatus", "pomplatform.workflow.contractstatus.handler.AttentionListOfChangeContractStatusHandler");
        QUERIES.put("AuditListOfChangeContractStatus", "pomplatform.workflow.contractstatus.handler.AuditListOfChangeContractStatusHandler");
        QUERIES.put("ApplyListOfChangeContractStatus", "pomplatform.workflow.contractstatus.handler.ApplyListOfChangeContractStatusHandler");
        QUERIES.put("SelectContracts", "pomplatform.workflow.contractstatus.handler.SelectContractsHandler");
        QUERIES.put("ContractStatus", "pomplatform.workflow.contractstatus.handler.ContractStatusHandler");
        //合同状态变更
        WORKFLOWPROCESSORS.put("Change_Contract_Status", "pomplatform.workflow.contractstatus.handler.ChangeContractStatusWorker");
        //项目暂停
        WORKFLOWPROCESSORS.put("Pause_project", "pomplatform.workflow.contractstatus.handler.PauseProjectWorker");
        //项目重启
        WORKFLOWPROCESSORS.put("Restart_project", "pomplatform.workflow.contractstatus.handler.RestartProjectWorker");
        //项目终止
        WORKFLOWPROCESSORS.put("Stop_project", "pomplatform.workflow.contractstatus.handler.StopProjectWorker");
        //合同暂停
        WORKFLOWPROCESSORS.put("Pause_contract", "pomplatform.workflow.contractstatus.handler.PauseContractWorker");
        //合同重启
        WORKFLOWPROCESSORS.put("Restart_contract", "pomplatform.workflow.contractstatus.handler.RestartContractWorker");
        //合同终止
        WORKFLOWPROCESSORS.put("Stop_contract", "pomplatform.workflow.contractstatus.handler.StopContractWorker");
        //合同结束
        WORKFLOWPROCESSORS.put("End_contract", "pomplatform.workflow.contractstatus.handler.EndContractWorker");
        QUERIES.put("OnloadPoolEmployeeData", "pomplatform.poolmanage.handler.OnloadPoolEmployeeDataHandler");
        QUERIES.put("OnloadPoolData", "pomplatform.poolmanage.handler.OnloadPoolDataHandler");
        DOWNLOADPROCESSORS.put("Mreimbursementinvoiceinformationrsrmmpror", "pomplatform.rmimburseementinvoice.handler.MreimbursementinvoiceinformationrsrmmprorHandler");
        QUERIES.put("Mreimbursementinvoiceinformationrsrmmpror", "pomplatform.rmimburseementinvoice.handler.MreimbursementinvoiceinformationrsrmmprorHandler");
        QUERIES.put("OnLoadProjectStageSettlement2", "pomplatform.project.handler.OnLoadProjectStageSettlement2Handler");
        QUERIES.put("OnLoadProjectStage", "pomplatform.project.handler.OnLoadProjectStageHandler");
        QUERIES.put("OnloadPoolEmployeeData", "pomplatform.poolmanage.handler.OnloadPoolEmployeeDataHandler");
        QUERIES.put("OnloadPoolData", "pomplatform.poolmanage.handler.OnloadPoolDataHandler");
        //获取用户未申请的权限
        QUERIES.put("NotApplyPermission", "pomplatform.funciton.handler.NotApplyPermissionsHandler");
        //获取用户准备申请的权限
        QUERIES.put("MyAuthorityApplication", "pomplatform.funciton.handler.MyAuthorityApplicationHandler");
        DOWNLOADPROCESSORS.put("Mreimbursementinvoiceinformationrsrmmpror", "pomplatform.rmimburseementinvoice.handler.MreimbursementinvoiceinformationrsrmmprorHandler");
        QUERIES.put("Mreimbursementinvoiceinformationrsrmmpror", "pomplatform.rmimburseementinvoice.handler.MreimbursementinvoiceinformationrsrmmprorHandler");
        QUERIES.put("OnLoadProjectStageSettlement2", "pomplatform.project.handler.OnLoadProjectStageSettlement2Handler");
        QUERIES.put("OnLoadProjectStage", "pomplatform.project.handler.OnLoadProjectStageHandler");
        QUERIES.put("OnloadPoolEmployeeData", "pomplatform.poolmanage.handler.OnloadPoolEmployeeDataHandler");
        QUERIES.put("OnloadPoolData", "pomplatform.poolmanage.handler.OnloadPoolDataHandler");
        DOWNLOADPROCESSORS.put("DepartmentIncomeDetailReport", "pomplatform.report.handler.DepartmentIncomeDetailReportHandler");
        QUERIES.put("DepartmentIncomeDetailReport", "pomplatform.report.handler.DepartmentIncomeDetailReportHandler");
        QUERIES.put("EmployeeIncomeReport", "pomplatform.report.handler.EmployeeIncomeReportHandler");
        QUERIES.put("DepartmentIncomeReport", "pomplatform.report.handler.DepartmentIncomeReportHandler");
        DOWNLOADPROCESSORS.put("DepartmentIncomeReport", "pomplatform.report.handler.DepartmentIncomeReportHandler");
        QUERIES.put("ProjectAccountIncome", "pomplatform.report.handler.ProjectAccountIncomeHandler");
        QUERIES.put("EmployeeAccountIncome", "pomplatform.report.handler.EmployeeAccountIncomeHandler");
        QUERIES.put("DepartmentAccountIncome", "pomplatform.report.handler.DepartmentAccountIncomeHandler");
        QUERIES.put("ContractSaveAndRevenue", "pomplatform.report.handler.ContractSaveAndRevenueHandler");

        QUERIES.put("BusinessCategory", "pomplatform.workflow.handler.BusinessCategoryHandler");
        QUERIES.put("OnLoadProjectEmpAndStage", "pomplatform.project.handler.OnLoadProjectEmpAndStageHandler");
        QUERIES.put("DesignerProjectDetail", "pomplatform.operation.handler.DesignerProjectDetailHandler");

        DAOS.put("MeetingWithConfree", "pomplatform.meeting.handler.MeetingWithConfreeHandler");
        PROCESSORS.put("MeetingRoomProcessor", "pomplatform.meeting.business.MeetingRoomProcessor");
        PROCESSORS.put("MeetingInfoProcessor", "pomplatform.meeting.business.MeetingInfoProcessor");
        QUERIES.put("MeetingInfo", "pomplatform.meeting.handler.MeetingInfoPaymentBaseHandler");
        QUERIES.put("MeetingRecordListHandler", "pomplatform.meeting.handler.MeetingRecordListHandler");

        QUERIES.put("OnLoadProjectEmpAndStageWithB", "pomplatform.project.handler.OnLoadProjectEmpAndStageWithBHandler");
        QUERIES.put("DesignerProjectDetail", "pomplatform.operation.handler.DesignerProjectDetailHandler");

        QUERIES.put("OnLoadProjectEmpAndStageInfo", "pomplatform.project.handler.OnLoadProjectEmpAndStageInfoHandler");
        QUERIES.put("OnLoadProjectStageSettlement", "pomplatform.project.handler.OnLoadProjectStageSettlementHandler");
        QUERIES.put("ProjectEmployeePlanIntegralProgress", "pomplatform.projectteambuild.handler.ProjectEmployeePlanIntegralProgressHandler");
        //对于跨阶段流程审批进行限制
        PROCESSORS.put("ModificationLimitationofStageProportionProcess", "pomplatform.workflow.handler.ModificationLimitationofStageProportionProcess");
        PROCESSORS.put("OnEmployeeCardManageProcess", "pomplatform.cardManage.business.OnEmployeeCardManageProcess");
        //调档人员明细信息
        PROCESSORS.put("FileDetailsProcess", "pomplatform.workflow.handler.FileDetailsProcess");
        PROCESSORS.put("CustomWorkflowBusinessProcessor", "pomplatform.workflow.handler.CustomWorkflowBusinessProcessor");
        QUERIES.put("SelectGridInvoiceTypeValue", "pomplatform.selectgrid.handler.SelectGridInvoiceTypeValueHandler");
        UPLOADPROCESSORS.put("OnUploadOtherDeductionData", "pomplatform.upload.OnUploadOtherDeductionData");
        QUERIES.put("OnOtherDeductionData", "pomplatform.payment.handler.OnOtherDeductionDataHandler");
        QUERIES.put("OnLoadSpecialDeductionYear", "pomplatform.specialDeduction.handler.OnLoadSpecialDeductionYearHandler");
        QUERIES.put("OnCheckSpecialDeduction", "pomplatform.specialDeduction.handler.OnCheckSpecialDeductionHandler");
        QUERIES.put("OnLoadSalaryTotalMonthData", "pomplatform.payment.handler.OnLoadSalaryTotalMonthDataHandler");
        PROCESSORS.put("WrokflowProcessor", "pomplatform.workflow.business.WrokflowProcessor");
        QUERIES.put("EmployeeContractAttentionOfWorkflow", "pomplatform.personnelbusiness.handler.EmployeeContractAttentionOfWorkflowHandler");
        QUERIES.put("EmployeeContract", "pomplatform.personnelbusiness.handler.EmployeeContractHandler");
        QUERIES.put("NormalSalaryCommon", "pomplatform.payment.handler.NormalSalaryCommonHandler");
        QUERIES.put("SalaryCommon", "pomplatform.payment.handler.SalaryCommonHandler");
        QUERIES.put("NormalBonusCommon", "pomplatform.payment.handler.NormalBonusCommonHandler");
        QUERIES.put("BonusCommon", "pomplatform.payment.handler.BonusCommonHandler");
        QUERIES.put("ResidualwageData", "pomplatform.payment.handler.ResidualwageDataHandler");
        QUERIES.put("OnSalarySendData", "pomplatform.payment.handler.OnSalarySendDataHandler");
        QUERIES.put("EmployeeContractAttentionOfWorkflow", "pomplatform.personnelbusiness.handler.EmployeeContractAttentionOfWorkflowHandler");
        QUERIES.put("EmployeeContract", "pomplatform.personnelbusiness.handler.EmployeeContractHandler");
        QUERIES.put("CurrentMonthSalaryType", "pomplatform.payment.handler.CurrentMonthSalaryTypeHandler");
        PROCESSORS.put("EmployeeSalaryType", "pomplatform.employeerescord.handler.EmployeeSalaryTypeProcess");
        QUERIES.put("OnboardEmployee", "pomplatform.employeerescord.handler.OnboardEmployeeHandler");
        QUERIES.put("EmployeeSalaryType", "pomplatform.handler.EmployeeSalaryTypeHandler");
        QUERIES.put("BonusPaymentApplyOfWorkflow", "pomplatform.bonusPayment.handler.BonusPaymentApplyOfWorkflowHandler");
        QUERIES.put("Memployeeaccountrecordeeeor", "pomplatform.bonusPayment.handler.MemployeeaccountrecordeeeorHandler");
        QUERIES.put("ApplicationInForFilingListOf", "pomplatform.workflow.handler.ApplicationInForFilingListOfHandler");
        QUERIES.put("FileManages", "pomplatform.workflow.handler.FileManagesHandler");
        //加水印的方法
        PROCESSORS.put("FileManagesWatermarkProcess", "pomplatform.workflow.handler.FileManagesWatermarkProcess");
        //查看员工档案明细
        QUERIES.put("ApplicationForFiling", "pomplatform.workflow.personnel.handler.ApplicationForFilingHandler");

        QUERIES.put("ApplicationInForFiling", "pomplatform.workflow.personnel.handler.ApplicationInForFilingHandler");

        WORKFLOWPROCESSORS.put("Application_Filing", "pomplatform.personnelbusiness.handler.ApplicationFilingWorker");
        QUERIES.put("Application_Filing", "pomplatform.personnelbusiness.handler.ApplicationFilingHandler");
        //调档流程
        QUERIES.put("Application_Filing", "pomplatform.personnelbusiness.handler.ApplicationFilingHandler");
        //盖章申请流程
        WORKFLOWPROCESSORS.put("Seal_Application", "pomplatform.personnelbusiness.handler.SealApplicationWorker");
        QUERIES.put("Seal_Application", "pomplatform.personnelbusiness.handler.SealApplicationHandler");
        QUERIES.put("BonusPaymentAttentionOfWorkflow", "pomplatform.bonusPayment.handler.BonusPaymentAttentionOfWorkflowHandler");
        QUERIES.put("BonusPaymentAuditOfWorkflow", "pomplatform.bonusPayment.handler.BonusPaymentAuditOfWorkflowHandler");
        DAOS.put("BonusPaymentRecordWithB", "pomplatform.workflow.handler.BonusPaymentRecordWithBHandler");
        WORKFLOWPROCESSORS.put("Bonus_Application", "pomplatform.workflow.handler.BonusApplicationWorker");
        QUERIES.put("BonusApplication", "pomplatform.workflow.handler.BonusApplicationHandler");
        QUERIES.put("ReportOnEmployeeSeniorityTotalByDepartment", "pomplatform.report.handler.ReportOnEmployeeSeniorityTotalByDepartmentHandler");
        QUERIES.put("ReportOnEmployeeEducationTotalByDepartment", "pomplatform.report.handler.ReportOnEmployeeEducationTotalByDepartmentHandler");
        QUERIES.put("ReportOnEmployeeSeniorityTotal", "pomplatform.report.handler.ReportOnEmployeeSeniorityTotalHandler");
        QUERIES.put("ReportOnEmployeeEducationTotal", "pomplatform.report.handler.ReportOnEmployeeEducationTotalHandler");
        QUERIES.put("ReportOnEmployeeAgeTotalByDepartment", "pomplatform.report.handler.ReportOnEmployeeAgeTotalByDepartmentHandler");
        QUERIES.put("ReportOnEmployeeAgeTotal", "pomplatform.report.handler.ReportOnEmployeeAgeTotalHandler");
        QUERIES.put("EmployeeContractAuditOfWorkflow", "pomplatform.personnelbusiness.handler.EmployeeContractAuditOfWorkflowHandler");
        WORKFLOWPROCESSORS.put("Labor_contract_renewal", "pomplatform.personnelbusiness.handler.EmployeeContractAttachmentWorker");
        QUERIES.put("EmployeeContractAttachment", "pomplatform.personnelbusiness.handler.EmployeeContractAttachmentHandler");
        QUERIES.put("ContractDistributionChild", "pomplatform.employee.handler.ContractDistributionChildHandler");
        QUERIES.put("ContractDistributionNew", "pomplatform.employee.handler.ContractDistributionNewHandler");
        QUERIES.put("LastMarketingCommission", "pomplatform.employee.handler.LastMarketingCommissionHandler");
        QUERIES.put("FiveInsuranceOneGoldsPaymentBase", "pomplatform.payment.handler.FiveInsuranceOneGoldsPaymentBaseHandler");
        DOWNLOADPROCESSORS.put("FiveInsuranceOneGoldsPaymentBase", "pomplatform.payment.handler.FiveInsuranceOneGoldsPaymentBaseHandler");
        QUERIES.put("MeetingRoomTimeManagement", "pomplatform.meeting.handler.MeetingRoomTimeManagementHandler");
        QUERIES.put("MeetingRoomManagement", "pomplatform.meeting.handler.MeetingRoomManagementHandler");
        QUERIES.put("OnLoadSpecialExpireData", "pomplatform.specialDeduction.handler.OnLoadSpecialExpireDataHandler");
        WORKFLOWPROCESSORS.put("Seal_Application", "pomplatform.personnelbusiness.handler.SealApplicationWorker");
        QUERIES.put("Seal_Application", "pomplatform.personnelbusiness.handler.SealApplicationHandler");
        QUERIES.put("ReportOnEmployeeBenefitTotalByDepartment", "pomplatform.report.handler.ReportOnEmployeeBenefitTotalByDepartmentHandler");
        QUERIES.put("ReportOnEmployeeBenefitTotal", "pomplatform.report.handler.ReportOnEmployeeBenefitTotalHandler");
        QUERIES.put("ReportOnEmployeeTurnoverTotalByDepartment", "pomplatform.report.handler.ReportOnEmployeeTurnoverTotalByDepartmentHandler");
        QUERIES.put("ReportOnEmployeeTurnoverTotal", "pomplatform.report.handler.ReportOnEmployeeTurnoverTotalHandler");
        QUERIES.put("ReportOnEmployeeGradeTotal", "pomplatform.report.handler.ReportOnEmployeeGradeTotalHandler");
        QUERIES.put("ReportOnEmployeeGradeTotalByDepartment", "pomplatform.report.handler.ReportOnEmployeeGradeTotalByDepartmentHandler");
        PROCESSORS.put("FinancicalTransAccountProcessor", "pomplatform.financialtransactionaccount.business.FinancicalTransAccountProcessor");
        QUERIES.put("NormalReimbursementSummary", "pomplatform.reimbursement.handler.NormalReimbursementSummaryHandler");
        QUERIES.put("Smainprojectpppor", "pomplatform.handler.SmainprojectppporHandler");
        QUERIES.put("HandingTransDetailSummary", "pomplatform.financialtransactionaccount.handler.HandingTransDetailSummaryHandler");
        DOWNLOADPROCESSORS.put("HandingTransDetailSummary", "pomplatform.financialtransactionaccount.handler.HandingTransDetailSummaryHandler");
        PROCESSORS.put("ExchangeRateUtils", "pomplatform.exchangerate.utils.ExchangeRateUtils");
        QUERIES.put("TransDetail", "pomplatform.financialtransactionaccount.handler.TransDetailHandler");
        DAOS.put("CustomFinancialAccountInitAmount", "pomplatform.financialtransactionaccount.business.CustomFinancialAccountInitAmount");
        QUERIES.put("TransDetailSummary", "pomplatform.financialtransactionaccount.handler.TransDetailSummaryHandler");
        DOWNLOADPROCESSORS.put("TransDetailSummary", "pomplatform.financialtransactionaccount.handler.TransDetailSummaryHandler");
        QUERIES.put("GetTransDetailsNeedToDelete", "pomplatform.financialtransactionaccount.handler.GetTransDetailsNeedToDeleteHandler");
        QUERIES.put("TransDetailNeedToUpdateRate", "pomplatform.financialtransactionaccount.handler.TransDetailNeedToUpdateRateHandler");
        QUERIES.put("ExchangeRateList", "pomplatform.exchangerate.handler.ExchangeRateListHandler");
        QUERIES.put("ReceiveUnitRepaymentTrans", "pomplatform.financialtransactionaccount.handler.ReceiveUnitRepaymentTransHandler");
        QUERIES.put("EmployeeRepaymentTrans", "pomplatform.financialtransactionaccount.handler.EmployeeRepaymentTransHandler");
        QUERIES.put("ProcessInstWithoutTransDetails", "pomplatform.financialtransactionaccount.handler.ProcessInstWithoutTransDetailsHandler");
        QUERIES.put("TravelReimbursementTrans", "pomplatform.financialtransactionaccount.handler.TravelReimbursementTransHandler");
        QUERIES.put("NormalReimbursementTrans", "pomplatform.financialtransactionaccount.handler.NormalReimbursementTransHandler");
        QUERIES.put("BorrowMoneyTrans", "pomplatform.financialtransactionaccount.handler.BorrowMoneyTransHandler");
        QUERIES.put("PayMoneyManageTrans", "pomplatform.financialtransactionaccount.handler.PayMoneyManageTransHandler");
        QUERIES.put("LoadSalaryTotal3", "pomplatform.payment.handler.LoadSalaryTotal3Handler");
        UPLOADPROCESSORS.put("OnUploadReplacementTaxData", "pomplatform.upload.OnUploadReplacementTaxData");
        QUERIES.put("OnReplacementTaxData", "pomplatform.payment.handler.OnReplacementTaxDataHandler");
        QUERIES.put("LoadSalaryTotal", "pomplatform.payment.handler.LoadSalaryTotalHandler");
        QUERIES.put("QueryLoadSalaryTotal2", "pomplatform.payment.handler.QueryLoadSalaryTotal2Handler");
        DOWNLOADPROCESSORS.put("OnLoadEmployeePayment", "pomplatform.payment.handler.OnLoadEmployeePaymentHandler");
        DOWNLOADPROCESSORS.put("bonusSummaryDetail", "pomplatform.bonusPayment.handler.bonusSummaryDetailHandler");
        DOWNLOADPROCESSORS.put("bonusSummary", "pomplatform.bonusPayment.handler.bonusSummaryHandler");
        DOWNLOADPROCESSORS.put("PerCapitaSalaryAnalysisByDepartment", "pomplatform.report.handler.PerCapitaSalaryAnalysisByDepartmentHandler");
        DOWNLOADPROCESSORS.put("PerCapitaSalaryAnalysis", "pomplatform.report.handler.PerCapitaSalaryAnalysisHandler");
        DOWNLOADPROCESSORS.put("SalaryBonusAnalysisByEmployee", "pomplatform.report.handler.SalaryBonusAnalysisByEmployeeHandler");
        DOWNLOADPROCESSORS.put("SalaryBonusAnalysisByDepartment", "pomplatform.report.handler.SalaryBonusAnalysisByDepartmentHandler");
        DOWNLOADPROCESSORS.put("SalaryBonusAnalysis", "pomplatform.report.handler.SalaryBonusAnalysisHandler");
        //培训导出
        DOWNLOADPROCESSORS.put("TrainingManagement", "pomplatform.trainingmanagement.handler.TrainingmanagementHandler");
        QUERIES.put("PerCapitaSalaryAnalysisByDepartment", "pomplatform.report.handler.PerCapitaSalaryAnalysisByDepartmentHandler");
        QUERIES.put("PerCapitaSalaryAnalysis", "pomplatform.report.handler.PerCapitaSalaryAnalysisHandler");
        QUERIES.put("SalaryBonusAnalysisByEmployee", "pomplatform.report.handler.SalaryBonusAnalysisByEmployeeHandler");
        QUERIES.put("SalaryBonusAnalysisByDepartment", "pomplatform.report.handler.SalaryBonusAnalysisByDepartmentHandler");
        QUERIES.put("SalaryBonusAnalysis", "pomplatform.report.handler.SalaryBonusAnalysisHandler");
        QUERIES.put("bonusSummaryDetail", "pomplatform.bonusPayment.handler.bonusSummaryDetailHandler");
        QUERIES.put("bonusSummary", "pomplatform.bonusPayment.handler.bonusSummaryHandler");
        QUERIES.put("GetCompanyBankAccountK3Code", "pomplatform.k3voucher.handler.GetCompanyBankAccountK3CodeHandler");
        QUERIES.put("BankTransVoucherInfo", "pomplatform.k3voucher.handler.BankTransVoucherInfoHandler");
        UPLOADPROCESSORS.put("OnUploadSupplierInfo", "pomplatform.supplierworkflow.handler.OnUploadSupplierInfo");
        PROCESSORS.put("GetSupplierInfo", "pomplatform.supplierworkflow.handler.GetSupplierInfo");
        WORKFLOWPROCESSORS.put("Apply_Functions", "pomplatform.applyfunctions.handler.ApplyFunctionsWorker");
        QUERIES.put("OnStorageData", "pomplatform.purchase.handler.OnStorageDataHandler");
        QUERIES.put("Mppsppsppsoiior", "pomplatform.purchase.handler.MppsppsppsoiiorHandler");
        QUERIES.put("GetPurchaseProductAndSumData", "pomplatform.purchase.handler.GetPurchaseProductAndSumDataHandler");
        // 采购入库申请
        WORKFLOWPROCESSORS.put("Purchase_warehousing_apply", "pomplatform.workflow.purchase.handler.PurchaseWarehousingWorker");
        QUERIES.put("Mpurchasecontractppmssmor", "pomplatform.purchase.handler.MpurchasecontractppmssmorHandler");
        DAOS.put("PurchaseContractWithPp", "pomplatform.purchase.handler.PurchaseContractWithPpHandler");
        QUERIES.put("PurchaseContractWithPp", "pomplatform.purchase.handler.PurchaseContractWithPpHandler");
        QUERIES.put("Spurchasepaymentor", "pomplatform.purchase.handler.SpurchasepaymentorHandler");
        QUERIES.put("Mpurchaseplanmsommpmosror", "pomplatform.purchase.handler.MpurchaseplanmsommpmosrorHandler");
        PROCESSORS.put("PurchaseActionProcessor", "pomplatform.purchase.handler.PurchaseActionProcessor");
        QUERIES.put("onLoadPurchaseProductBySupplier", "pomplatform.workflow.handler.onLoadPurchaseProductBySupplierHandler");
        // 采购实施申请
        WORKFLOWPROCESSORS.put("Purchase_action_apply", "pomplatform.workflow.purchase.handler.SpurchaseactionporWorker");
        DAOS.put("PaymentTemplateWithP", "pomplatform.purchase.handler.PaymentTemplateWithPHandler");
        QUERIES.put("OnLoadProductInquirySupplierDetail", "pomplatform.purchase.handler.OnLoadProductInquirySupplierDetailHandler");
        PROCESSORS.put("ProductInquiryProcessor", "pomplatform.purchase.handler.ProductInquiryProcessor");
        //采购申请
        WORKFLOWPROCESSORS.put("Product_purchase_apply", "pomplatform.workflow.personnelbusiness.handler.ProductPurchaseApplyWorker");
        QUERIES.put("OnLoadTaskListOfProductInquiry", "pomplatform.purchase.handler.OnLoadTaskListOfProductInquiryHandler");
        QUERIES.put("OnLoadAttentionListOfProductInquiry", "pomplatform.purchase.handler.OnLoadAttentionListOfProductInquiryHandler");
        QUERIES.put("MyAuditListOfProductInquiry", "pomplatform.purchase.handler.MyAuditListOfProductInquiryHandler");
        QUERIES.put("OnLoadAuditListOfProductInquiry", "pomplatform.purchase.handler.OnLoadAuditListOfProductInquiryHandler");
        QUERIES.put("OnLoadRefuseListOfProductInquiry", "pomplatform.purchase.handler.OnLoadRefuseListOfProductInquiryHandler");
        QUERIES.put("OnLoadApplyListOfProductInquiry", "pomplatform.purchase.handler.OnLoadApplyListOfProductInquiryHandler");
        DAOS.put("ProductWithP", "pomplatform.purchase.handler.ProductWithPHandler");
        QUERIES.put("ProductWithP", "pomplatform.purchase.handler.ProductWithPHandler");
        WORKFLOWPROCESSORS.put("Product_inquiry_apply", "pomplatform.workflow.purchase.handler.SproductinquirytotalporWorker");
        QUERIES.put("Sproductinquirytotalpor", "pomplatform.workflow.purchase.handler.SproductinquirytotalporHandler");
        QUERIES.put("Sproductmmpor", "pomplatform.purchase.handler.SproductmmporHandler");
        PROCESSORS.put("OnPurchaseProcess", "pomplatform.purchase.business.OnPurchaseProcess");
        QUERIES.put("OnLoadSupplierData", "pomplatform.purchase.handler.OnLoadSupplierDataHandler");
        DOWNLOADPROCESSORS.put("ExportEmployeeSalaryAdjustment", "pomplatform.workflow.handler.OnLoadFlowEmployeeSalaryAdjustmentBuisnessDataHandler");
        QUERIES.put("OnLoadSpecialDeductionYear", "pomplatform.specialDeduction.handler.OnLoadSpecialDeductionYearHandler");
        QUERIES.put("Mspecialdeductionrecordssyeseeshsppcor", "pomplatform.specialDeduction.handler.MspecialdeductionrecordssyeseeshsppcorHandler");
        DAOS.put("SpecialDeductionRecordWithS", "pomplatform.client.workflow.specialDeduction.handler.SpecialDeductionRecordWithSHandler");
        WORKFLOWPROCESSORS.put("special_deduction_information", "pomplatform.client.workflow.specialDeduction.handler.SpecialDeductionInformationWorker");
        PROCESSORS.put("UpdateSpecialDeductionInformation", "pomplatform.client.workflow.specialDeduction.handler.UpdateSpecialDeductionInformation");
        QUERIES.put("specialDeductionInformation", "pomplatform.client.workflow.specialDeduction.handler.specialDeductionInformationHandler");
        QUERIES.put("GetRevenueByCompany", "pomplatform.k3voucher.handler.GetRevenueByCompanyHandler");
        DOWNLOADPROCESSORS.put("MainProject", "pomplatform.ht.handler.CustomMainProjectHandler");
        DOWNLOADPROCESSORS.put("ExportReportOfSalaryTotalByDepartment", "pomplatform.report.handler.ReportOfSalaryTotalByDepartmentHandler");
        DOWNLOADPROCESSORS.put("ExportReportOnEmployeeNumTotal", "pomplatform.report.handler.ReportOnEmployeeNumTotalByDepartmentHandler");
        DOWNLOADPROCESSORS.put("ExportContractIncomeLedgerList", "pomplatform.contractincome.handler.ContractIncomeLedgerListHandler");
        QUERIES.put("ContractIncomeLedgerList", "pomplatform.contractincome.handler.ContractIncomeLedgerListHandler");
        QUERIES.put("ContractIncomeBasicInfo", "pomplatform.contractincome.handler.ContractIncomeBasicInfoHandler");
        QUERIES.put("GetContractStageByInvoice", "pomplatform.contractincome.handler.GetContractStageByInvoiceHandler");
        QUERIES.put("GetInvoiceContactsInfo", "pomplatform.contractincome.handler.GetInvoiceContactsInfoHandler");
        PROCESSORS.put("ContractIncomeLedgerProcessor", "pomplatform.contractincome.business.ContractIncomeLedgerProcessor");
        DAOS.put("ContractCustom", "pomplatform.custom.handler.ContractCustomHandler");
        DAOS.put("PlateRecordCustom", "com.pomplatform.db.handler.PlateRecordCustomHandler");
        QUERIES.put("MemployeeNew", "delicacy.system.handler.MemployeeNewHandler");
        QUERIES.put("Msystemconfigeedsppedseor", "pomplatform.employee.handler.MsystemconfigeedsppedseorHandler");
        QUERIES.put("OnLoadSaleIntegralFromPlate", "pomplatform.revenue.handler.OnLoadSaleIntegralFromPlateHandler");
        QUERIES.put("ContractCommissionDetail", "pomplatform.contract.handler.ContractCommissionDetailHandler");
//		QUERIES.put("OnLoadSpecialDeductionYear", "pomplatform.specialdeduction.handler.OnLoadSpecialDeductionYearHandler");
//		QUERIES.put("OnLoadSpecialDeductionYear", "pomplatform.client.specialdeduction.handler.OnLoadSpecialDeductionYearHandler");
        PROCESSORS.put("GetSystemProcessDepartmentTree", "pomplatform.business.query.GetSystemProcessDepartmentTree");
        PROCESSORS.put("GenerateSourceDepartmentTree", "pomplatform.business.query.GenerateSourceDepartmentTree");
        DAOS.put("SystemProcessWithS", "pomplatform.business.handler.SystemProcessWithSHandler");
        PROCESSORS.put("GenerateMainFunctionTree", "pomplatform.business.query.GenerateMainFunctionTree");
        PROCESSORS.put("GenerateSourceMainFunctionTree", "pomplatform.business.query.GenerateSourceMainFunctionTree");
        QUERIES.put("Mcapitalhyhor", "pomplatform.receivables.handler.McapitalhyhorHandler");
        QUERIES.put("trainingManagementAttentionOfWorkflow", "pomplatform.trainingmanagement.handler.trainingManagementAttentionOfWorkflowHandler");
        QUERIES.put("trainingManagementAuditOfWorkflow", "pomplatform.trainingmanagement.handler.trainingManagementAuditOfWorkflowHandler");
        QUERIES.put("trainingManagementsApplyOfWorkflow", "pomplatform.trainingmanagement.handler.trainingManagementsApplyOfWorkflowHandler");
        WORKFLOWPROCESSORS.put("training_management_information", "pomplatform.trainingmanagement.handler.TrainingManagementInformationWorker");
        QUERIES.put("TrainingManagementInformation", "pomplatform.trainingmanagement.handler.TrainingManagementInformationHandler");
        DAOS.put("TrainingManagementWithT", "pomplatform.trainingmanagement.handler.TrainingManagementWithTHandler");
        QUERIES.put("OnLoadFlowPersonnelBuisnessData", "pomplatform.workflow.handler.OnLoadFlowPersonnelBuisnessDataHandler");
        QUERIES.put("TotalTrainingManagement", "pomplatform.totaltrainingmanagement.handler.TotalTrainingManagementHandler");
        QUERIES.put("Sspecialdeductionsepor", "pomplatform.specialDeduction.handler.SspecialdeductionseporHandler");
        QUERIES.put("Mspecialdeductionrecordsor", "pomplatform.specialDeduction.handler.MspecialdeductionrecordsorHandler");
        QUERIES.put("Sspecialdeductiontypessor", "pomplatform.specialDeduction.handler.SspecialdeductiontypessorHandler");
        QUERIES.put("SpecialDeductionRecordsAttentionOfWorkflow", "pomplatform.specialDeduction.handler.SpecialDeductionRecordsAttentionOfWorkflowHandler");
        QUERIES.put("SpecialDeductionRecordsAuditOfWorkflow", "pomplatform.specialDeduction.handler.SpecialDeductionRecordsAuditOfWorkflowHandler");
        QUERIES.put("SpecialDeductionRecordsApplyOfWorkflow", "pomplatform.specialDeduction.handler.SpecialDeductionRecordsApplyOfWorkflowHandler");
        QUERIES.put("Sspecialdeductiondetailor", "pomplatform.specialDeduction.handler.SspecialdeductiondetailorHandler");
        QUERIES.put("Sspecialdeductionrecordsssor", "pomplatform.specialDeduction.handler.SspecialdeductionrecordsssorHandler");
//		WORKFLOWPROCESSORS.put("special_deduction_information", "pomplatform.client.workflow.specialDeduction.handler.SpecialDeductionInformationWorker");
//		QUERIES.put("SpecialDeductionInformation", "pomplatform.client.workflow.specialDeduction.handler.SpecialDeductionInformationHandler");
        QUERIES.put("AboutInputTaxRecordInfo", "pomplatform.aboutinputtaxrecordinfo.handler.AboutInputTaxRecordInfoHandler");
        QUERIES.put("Memployeeeor", "pomplatform.client.handler.MemployeeeorHandler");
        QUERIES.put("AboutTrainingManagement", "pomplatform.abouttrainingmanagement.handler.AboutTrainingManagementHandler");
        DOWNLOADPROCESSORS.put("Minvoicecseccor", "pomplatform.receivables.handler.MinvoicecseccorHandler");
        QUERIES.put("Minvoicecseccor", "pomplatform.receivables.handler.MinvoicecseccorHandler");
        QUERIES.put("Collectionrevenueanalysis", "pomplatform.report.handler.CollectionrevenueanalysisHandler");
        QUERIES.put("InvoiceReport", "pomplatform.capatialandinvoice.handler.InvoiceReportHandler");
        QUERIES.put("BuggetDetailInfo", "pomplatform.buggetdetailinfo.handler.BuggetDetailInfoHandler");
        DAOS.put("CustomEmployee", "pomplatform.employee.handler.CustomEmployeeHandler");
        DAOS.put("CustomWebsiteNew", "pomplatform.websitenews.handler.CustomWebsiteNewHandler");
        QUERIES.put("OnSupplierInfo", "pomplatform.onsupplierinfo.handler.OnSupplierInfoHandler");
        QUERIES.put("AttentionSupplierInfo", "pomplatform.attentionsupplierinfo.handler.AttentionSupplierInfoHandler");
        QUERIES.put("AuditSupplierInfo", "pomplatform.auditsupplierinfo.handler.AuditSupplierInfoHandler");
        QUERIES.put("RefuseSupplierInfo", "pomplatform.applysupplierinfo.handler.RefuseSupplierInfoHandler");
        QUERIES.put("ApplySupplierInfo", "pomplatform.applysupplierinfo.handler.ApplySupplierInfoHandler");
        DAOS.put("SupplierWithSs", "pomplatform.supplierworkflow.handler.SupplierWithSsHandler");
        WORKFLOWPROCESSORS.put("Supplier_Come_In", "pomplatform.supplierworkflow.handler.SupplierComeInWorker");
        QUERIES.put("SupplierComeIn", "pomplatform.supplierworkflow.handler.SupplierComeInHandler");
        QUERIES.put("OnLoadMsgEmployeeBusinessData", "pomplatform.workflow.handler.OnLoadMsgEmployeeBusinessDataHandler");
        QUERIES.put("Mcontractppspcccfscsiiicpor", "pomplatform.contractppspcccfscsiiicpor.handler.McontractppspcccfscsiiicporHandler");
        QUERIES.put("AllOtherDetail", "pomplatform.account.handler.AllOtherDetailHandler");
        PROCESSORS.put("FileManageProcessor", "pomplatform.filemanage.business.FileManageProcessor");
        QUERIES.put("OnSalaryDepartmentBonusByPlate", "pomplatform.payment.handler.OnSalaryDepartmentBonusByPlateHandler");
        QUERIES.put("OnSalaryPlateBonusByCompany", "pomplatform.payment.handler.OnSalaryPlateBonusByCompanyHandler");
        QUERIES.put("OnSalaryPlateBonusByPlate", "pomplatform.payment.handler.OnSalaryPlateBonusByPlateHandler");
        QUERIES.put("ReportEmployeeWorkYearsByDepartment", "pomplatform.report.handler.ReportEmployeeWorkYearsByDepartmentHandler");
        DOWNLOADPROCESSORS.put("Mprojectppppppbppipor", "pomplatform.report.handler.MprojectppppppbppiporHandler");
        QUERIES.put("Mprojectppppppbppipor", "pomplatform.report.handler.MprojectppppppbppiporHandler");
        QUERIES.put("projectPreInfomations", "pomplatform.preProjects.handler.projectPreInfomationsHandler");
        // 提交报价单后向拆分价维护人员企业微信发送消息/拆分价完成后企业微信通知运营中心人员（订单下达维护人员）
        PROCESSORS.put("OutQuotationMSG", "pomplatform.ht.handler.OutQuotationMSG");
        UPLOADPROCESSORS.put("ProjectsDWProcess", "pomplatform.project.business.ProjectsDWProcess");
        QUERIES.put("Stargetrecordbytor", "pomplatform.project.handler.StargetrecordbytorHandler");
        QUERIES.put("Mprojecttrcccsyyyseyymmymmor", "pomplatform.project.handler.MprojecttrcccsyyyseyymmymmorHandler");
        DOWNLOADPROCESSORS.put("ProjectsDWProcess", "pomplatform.project.business.ProjectsDWProcess");
        QUERIES.put("UpdateFrozenIntegral", "pomplatform.employee.handler.UpdateFrozenIntegralHandler");
        QUERIES.put("InServiceEmployeeResignationInfo", "pomplatform.employee.handler.InServiceEmployeeResignationInfoHandler");
        QUERIES.put("GenerateCapitalVoucher", "pomplatform.k3voucher.handler.GenerateCapitalVoucherHandler");
        PROCESSORS.put("AllK3VoucherProcessor", "pomplatform.reimbursement.business.AllK3VoucherProcessor");
        DOWNLOADPROCESSORS.put("DownloadVoucher", "pomplatform.k3voucher.handler.DownloadVoucherHandler");
        QUERIES.put("AllVoucherDetail", "pomplatform.k3voucher.handler.AllVoucherDetailHandler");
        QUERIES.put("AllVoucherSummary", "pomplatform.k3voucher.handler.AllVoucherSummaryHandler");
        DOWNLOADPROCESSORS.put("K3VoucherErrorList", "pomplatform.reimbursement.handler.K3VoucherErrorListHandler");
        DAOS.put("K3CodeAutoUpdateTime", "pomplatform.k3code.handler.K3CodeAutoUpdateTimeHandler");
        QUERIES.put("ContractAmountAnalyzeDetail", "pomplatform.contract.handler.ContractAmountAnalyzeDetailHandler");
        QUERIES.put("ContractsRecords", "pomplatform.contractsRecords.handler.ContractsRecordsHandler");
        QUERIES.put("AboutContractsRecord", "pomplatform.aboutcontractsrecord.handler.AboutContractsRecordHandler");
        QUERIES.put("JobManager", "pomplatform.company.handler.JobManagerHandler");
        QUERIES.put("JobManagement", "pomplatform.company.handler.JobManagementHandler");
        QUERIES.put("PlateIntegralSends", "pomplatform.plateIntegralSends.handler.PlateIntegralSendsHandler");
        QUERIES.put("Sprojectpricechangedrecordgroupor", "pomplatform.project.handler.SprojectpricechangedrecordgrouporHandler");
        QUERIES.put("Sprojectpricechangedrecordcppor", "pomplatform.project.handler.SprojectpricechangedrecordcpporHandler");
        QUERIES.put("GetBudgetUplodaNews", "pomplatform.getbudgetuplodanews.handler.GetBudgetUplodaNewsHandler");
        QUERIES.put("Sprojectpbpor", "pomplatform.project.handler.SprojectpbporHandler");
        DOWNLOADPROCESSORS.put("Sprojectpbpor", "pomplatform.project.handler.SprojectpbporHandler");
        QUERIES.put("MDepartmentDirector", "pomplatform.departmentDirector.handler.MDepartmentDirectorHandler");
        QUERIES.put("projectAdvanceDetail", "pomplatform.sProjectAdvanceRecord.handler.projectAdvanceDetailHandler");
        QUERIES.put("NonconformityAttachmentDetail", "pomplatform.projectAttachmentManage.handler.NonconformityAttachmentDetailHandler");
        QUERIES.put("AuditProjectQuoteTemplate", "pomplatform.auditprojectquotetemplate.handler.AuditProjectQuoteTemplateHandler");
        QUERIES.put("AttentionProjectQuoteTemplate", "pomplatform.attentionprojectquotetemplate.handler.AttentionProjectQuoteTemplateHandler");
        QUERIES.put("RefuseProjectQuoteTemplate", "pomplatform.refuseprojectquotetemplate.handler.RefuseProjectQuoteTemplateHandler");
        QUERIES.put("RefuseProjectQuoteTemplatePanel", "pomplatform.refuseprojectquotetemplatepanel.handler.RefuseProjectQuoteTemplatePanelHandler");
        QUERIES.put("GetprojectQuoteAreaRange", "pomplatform.getprojectquotearearange.handler.GetprojectQuoteAreaRangeHandler");
        QUERIES.put("ApplyProjectQuoteTemplate", "pomplatform.applyprojectquotetemplate.handler.ApplyProjectQuoteTemplateHandler");
        DAOS.put("ProjectQuoteWithP", "pomplatform.onprojectquotetemplateworkflow.handler.ProjectQuoteWithPHandler");
        WORKFLOWPROCESSORS.put("On_Project_Quote_Template", "pomplatform.onprojectquotetemplateworkflow.handler.OnProjectQuoteTemplateWorker");
        QUERIES.put("OnProjectQuoteTemplate", "pomplatform.onprojectquotetemplateworkflow.handler.OnProjectQuoteTemplateHandler");
        QUERIES.put("AboutProjectQuoteTemplatesParent", "pomplatform.aboutprojectquotetemplatesparent.handler.AboutProjectQuoteTemplatesParentHandler");
        QUERIES.put("BankManager", "pomplatform.bank.handler.BankManagerHandler");
        QUERIES.put("ReportOfGenderAnalysisByDepartment", "pomplatform.report.handler.ReportOfGenderAnalysisByDepartmentHandler");
        QUERIES.put("ReportOnEmployeeNumTotalByDepartment", "pomplatform.report.handler.ReportOnEmployeeNumTotalByDepartmentHandler");
        PROCESSORS.put("TestSystemProcess", "pomplatform.workflow.business.TestSystemProcess");
        QUERIES.put("OnSalaryTotalDataSummarize", "pomplatform.payment.handler.OnSalaryTotalDataSummarizeHandler");
        QUERIES.put("ProjectEmployeeReport", "pomplatform.projectEmployee.handler.ProjectEmployeeReportHandler");
        PROCESSORS.put("ProjectEmployeeProcessor", "pomplatform.projectEmployee.business.ProjectEmployeeProcessor");
        QUERIES.put("ProjectEmployeeAudit", "pomplatform.projectEmployee.handler.ProjectEmployeeAuditHandler");
        QUERIES.put("ReportOfSalaryTotalByDepartment", "pomplatform.report.handler.ReportOfSalaryTotalByDepartmentHandler");
        QUERIES.put("contractSaveAnalyze", "pomplatform.revenueStatistical.handler.contractSaveAnalyzeHandler");
        DOWNLOADPROCESSORS.put("contractSaveAnalyze", "pomplatform.revenueStatistical.handler.contractSaveAnalyzeHandler");
        QUERIES.put("OnLoadFlowAuditListOfCostAllocationBuisnessData", "pomplatform.workflow.handler.OnLoadFlowAuditListOfCostAllocationBuisnessDataHandler");
        QUERIES.put("OnLoadFlowRefuseListOfCostAllocationBuisnessData", "pomplatform.workflow.handler.OnLoadFlowRefuseListOfCostAllocationBuisnessDataHandler");
        QUERIES.put("OnLoadFlowAuditListOfPreProjectReportBuisnessData", "pomplatform.workflow.handler.OnLoadFlowAuditListOfPreProjectReportBuisnessDataHandler");
        QUERIES.put("OnLoadFlowAttachmentApprovalUpcomingBuisnessData", "pomplatform.workflow.handler.OnLoadFlowAttachmentApprovalUpcomingBuisnessDataHandler");
        QUERIES.put("OnLoadFlowBudgetManagementApplyBuisnessData", "pomplatform.workflow.handler.OnLoadFlowBudgetManagementApplyBuisnessDataHandler");
        QUERIES.put("OnLoadFlowTravelReimbursementsApplyBuisnessData", "pomplatform.workflow.handler.OnLoadFlowTravelReimbursementsApplyBuisnessDataHandler");
        QUERIES.put("OnLoadFlowNormalReimbursementsApplyBuisnessData", "pomplatform.workflow.handler.OnLoadFlowNormalReimbursementsApplyBuisnessDataHandler");
        QUERIES.put("OnLoadFlowPayMoneyApplyBuisnessData", "pomplatform.workflow.handler.OnLoadFlowPayMoneyApplyBuisnessDataHandler");
        QUERIES.put("OnLoadFlowEmployeeMoneyApplyBuisnessData", "pomplatform.workflow.handler.OnLoadFlowEmployeeMoneyApplyBuisnessDataHandler");
        QUERIES.put("OnLoadFlowTravelReimbursementsBuisnessData", "pomplatform.workflow.handler.OnLoadFlowTravelReimbursementsBuisnessDataHandler");
        QUERIES.put("OnLoadFlowNormalReimbursementsBuisnessData", "pomplatform.workflow.handler.OnLoadFlowNormalReimbursementsBuisnessDataHandler");
        QUERIES.put("OnLoadFlowAuditOfEmployeeOnboardBuisnessData", "pomplatform.workflow.handler.OnLoadFlowAuditOfEmployeeOnboardBuisnessDataHandler");
        QUERIES.put("OnLoadFlowEmployeeSalaryAdjustmentBuisnessData", "pomplatform.workflow.handler.OnLoadFlowEmployeeSalaryAdjustmentBuisnessDataHandler");
        QUERIES.put("OnLaborPaymentData", "pomplatform.payment.handler.OnLaborPaymentDataHandler");
        QUERIES.put("OnSalaryTotalData", "pomplatform.payment.handler.OnSalaryTotalDataHandler");
        QUERIES.put("GetApproveTimeAndDepIdByProjectId", "pomplatform.projectstageauditinfo.handler.GetApproveTimeAndDepIdByProjectIdHandler");
        PROCESSORS.put("CapitalAndInvoiceProcessor", "pomplatform.capitaldistribution.business.CapitalAndInvoiceProcessor");
        QUERIES.put("AbountPaymentSequenceinfo", "pomplatform.abountpaymentsequenceinfo.handler.AbountPaymentSequenceinfoHandler");
        DOWNLOADPROCESSORS.put("AbountPaymentSequenceinfo", "pomplatform.abountpaymentsequenceinfo.handler.AbountPaymentSequenceinfoHandler");
        DOWNLOADPROCESSORS.put("ContractAmountAnalyze", "pomplatform.contract.handler.ContractAmountAnalyzeHandler");
        DOWNLOADPROCESSORS.put("ContractAmountAnalyzeDetail", "pomplatform.contract.handler.ContractAmountAnalyzeDetailHandler");
        QUERIES.put("ContractAmountAnalyze", "pomplatform.contract.handler.ContractAmountAnalyzeHandler");
        QUERIES.put("CollaborativeFeeDetailOfPlateAccount", "pomplatform.account.handler.CollaborativeFeeDetailOfPlateAccountHandler");
        QUERIES.put("Scwdfilingmaintemplatetrcor", "pomplatform.cwd.handler.ScwdfilingmaintemplatetrcorHandler");
        QUERIES.put("OnLoadFlowProcessTypeNum", "pomplatform.workflow.handler.OnLoadFlowProcessTypeNumHandler");
        QUERIES.put("DictionartManagenment", "pomplatform.employee.handler.DictionartManagenmentHandler");
        QUERIES.put("CapitalAndInvoiceTwo", "pomplatform.capatialandinvoice.handler.CapitalAndInvoiceTwoHandler");
        QUERIES.put("InvoiceReportDetail", "pomplatform.capatialandinvoice.handler.InvoiceReportDetailHandler");
        QUERIES.put("CapitalAndInvoiceOne", "pomplatform.capatialandinvoice.handler.CapitalAndInvoiceOneHandler");
        DOWNLOADPROCESSORS.put("ExportReckonRevenueCapitals", "pomplatform.revenuecapitalsinfo.handler.RevenueCapitalsInfoHandler");
        DOWNLOADPROCESSORS.put("InvoiceReportDetail", "pomplatform.capatialandinvoice.handler.InvoiceReportDetailHandler");
        QUERIES.put("AboutRevenueAmount", "pomplatform.aboutrevenueamount.handler.AboutRevenueAmountHandler");
        QUERIES.put("RevenueInfo", "pomplatform.revenueinfo.handler.RevenueInfoHandler");
        QUERIES.put("CapitalsInfo", "pomplatform.capitalsinfo.handler.CapitalsInfoHandler");
        QUERIES.put("RevenueCapitalsInfo", "pomplatform.revenuecapitalsinfo.handler.RevenueCapitalsInfoHandler");
        QUERIES.put("StageInvoiceAttachment", "pomplatform.stageinvoiceattachment.handler.StageInvoiceAttachmentHandler");
        // 本地文件服务/本地存储更系统发布控制
        PROCESSORS.put("LocalSystemUpdateProcessor", "pomplatform.cwd.business.LocalSystemUpdateProcessor");
        DAOS.put("SoftwareUpdateVersionWithS", "pomplatform.cwd.handler.SoftwareUpdateVersionWithSHandler");
        QUERIES.put("SoftwareUpdateVersionWithS", "pomplatform.cwd.handler.SoftwareUpdateVersionWithSHandler");
        DOWNLOADPROCESSORS.put("ExportReckonRevenueCapitals", "pomplatform.revenuecapitalsinfo.handler.RevenueCapitalsInfoHandler");
        QUERIES.put("AboutRevenueAmount", "pomplatform.aboutrevenueamount.handler.AboutRevenueAmountHandler");
        QUERIES.put("RevenueInfo", "pomplatform.revenueinfo.handler.RevenueInfoHandler");
        QUERIES.put("CapitalsInfo", "pomplatform.capitalsinfo.handler.CapitalsInfoHandler");
        PROCESSORS.put("ReckonRevenueCapitals", "pomplatform.revenuecapitalsinfo.handler.ReckonRevenueCapitals");
        QUERIES.put("RevenueCapitalsInfo", "pomplatform.revenuecapitalsinfo.handler.RevenueCapitalsInfoHandler");
        QUERIES.put("StageInvoiceAttachment", "pomplatform.stageinvoiceattachment.handler.StageInvoiceAttachmentHandler");
        DAOS.put("CompanyAreaWithCa", "pomplatform.companyarea.handler.CompanyAreaWithCaHandler");
        QUERIES.put("Companyarea", "pomplatform.companyarea.handler.CompanyareaHandler");
        QUERIES.put("BooleanApprovalProcess", "pomplatform.approveProjectStageStorage.handler.BooleanApprovalProcessHandler");
        QUERIES.put("OnLoadTaskListOfApproveProjectStageStroage", "pomplatform.workflow.handler.OnLoadTaskListOfApproveProjectStageStroageHandler");
        QUERIES.put("OnLoadAttentionListOfApproveProjectStageStroage", "pomplatform.workflow.handler.OnLoadAttentionListOfApproveProjectStageStroageHandler");
        QUERIES.put("MyAuditListOfApproveProjectStageStroage", "pomplatform.workflow.handler.MyAuditListOfApproveProjectStageStroageHandler");
        QUERIES.put("OnLoadRefuseListOfApproveProjectStageStroage", "pomplatform.workflow.handler.OnLoadRefuseListOfApproveProjectStageStroageHandler");
        QUERIES.put("OnLoadAuditListOfApproveProjectStageStroage", "pomplatform.workflow.handler.OnLoadAuditListOfApproveProjectStageStroageHandler");
        QUERIES.put("OnLoadApplyListOfApproveProjectStageStroage", "pomplatform.workflow.handler.OnLoadApplyListOfApproveProjectStageStroageHandler");
        QUERIES.put("onLoadCapitalAmountOfContract", "pomplatform.itemCollection.custom.handler.onLoadCapitalAmountOfContractHandler");
        QUERIES.put("OnEmployeeDayPlateRecords", "pomplatform.OnEmployeeDayPlateRecords.handler.OnEmployeeDayPlateRecordsHandler");
        PROCESSORS.put("GenerateCwdFilingTemplateDetailTree", "pomplatform.cwd .query.GenerateCwdFilingTemplateDetailTree");
        PROCESSORS.put("FilingTemplateProcessor", "pomplatform.cwd.business.FilingTemplateProcessor");
        DAOS.put("ApproveProjectStageStorageWithPp", "pomplatform.approveProjectStageStorage.handler.ApproveProjectStageStorageWithPpHandler");
        WORKFLOWPROCESSORS.put("Project_stages_process", "pomplatform.approveProjectStageStorage.handler.approveprojectstagestoragecorWorker");
        QUERIES.put("approveprojectstagestoragecor", "pomplatform.approveProjectStageStorage.handler.approveprojectstagestoragecorHandler");
        QUERIES.put("Sprojectstagestoragepor", "pomplatform.projectStages.handler.SprojectstagestorageporHandler");
        QUERIES.put("Sprojectstagestorageor", "pomplatform.projectStageStorage.handler.SprojectstagestorageorHandler");
        QUERIES.put("InvoiceAndPayment", "pomplatform.finance.handler.InvoiceAndPaymentHandler");
        PROCESSORS.put("DictionartManagementProcessor", "pomplatform.employee.business.DictionartManagementProcessor");
        QUERIES.put("Sprojecttemplateor", "pomplatform.projectTemplate.handler.SprojecttemplateorHandler");
        PROCESSORS.put("GenerateProjectQuoteTemplateTree", "pomplatform.project.query.GenerateProjectQuoteTemplateTree");
        QUERIES.put("Sprojecttemplateor", "pomplatform.projectTemplate.handler.SprojecttemplateorHandler");
        PROCESSORS.put("GenerateProjectQuoteTemplateTree", "pomplatform.project.query.GenerateProjectQuoteTemplateTree");
        QUERIES.put("PaySeqAddInfo", "pomplatform.payseqaddinfo.handler.PaySeqAddInfoHandler");
        DOWNLOADPROCESSORS.put("ExportPaySeqInfo", "pomplatform.payseqaddinfo.handler.PaySeqAddInfoHandler");
        PROCESSORS.put("AboutProjectStageAudit", "pomplatform.projectstageauditinfo.handler.AboutProjectStageAudit");
        WORKFLOWPROCESSORS.put("Project_stage_audit", "pomplatform.projectstageauditinfo.handler.ProjectStageAuditInfoWorker");
        QUERIES.put("ProjectStageAuditInfo", "pomplatform.projectstageauditinfo.handler.ProjectStageAuditInfoHandler");
        QUERIES.put("BudgetEndCode", "pomplatform.budgetendcode.handler.BudgetEndCodeHandler");
        QUERIES.put("TaskAttachmentApprovals", "pomplatform.taskattachmentapprovals.handler.TaskAttachmentApprovalsHandler");
        QUERIES.put("BudgetAttachmentDetail", "pomplatform.BudgetAttachmentDetail.handler.BudgetAttachmentDetailHandler");
        QUERIES.put("KnowAttachmentApproval", "pomplatform.knowattachmentapproval.handler.KnowAttachmentApprovalHandler");
        QUERIES.put("AttachmentApprovalAlready", "pomplatform.attachmentapprovalalready.handler.AttachmentApprovalAlreadyHandler");
        QUERIES.put("AttachmentApprovalUpcoming", "pomplatform.attachmentapprovalupcoming.handler.AttachmentApprovalUpcomingHandler");
        QUERIES.put("AttachmentApprovalApply", "pomplatform.attachmentapprovalapply.handler.AttachmentApprovalApplyHandler");
        WORKFLOWPROCESSORS.put("Attachment_Approval", "pomplatform.attachmentapproval.handler.AttachmentApprovalWorker");
        QUERIES.put("AttachmentApproval", "pomplatform.attachmentapproval.handler.AttachmentApprovalHandler");
        PROCESSORS.put("EidtPaymentSequence", "pomplatform.abountpaymentsequenceinfo.handler.EidtPaymentSequence");
        QUERIES.put("AboutReimbursementPayseq", "pomplatform.aboutreimbursementpayseq.handler.AboutReimbursementPayseqHandler");
        DAOS.put("BudgetManagementWithB", "pomplatform.budgetmanagementworkflow.handler.BudgetManagementWithBHandler");
        WORKFLOWPROCESSORS.put("Budget_Management", "pomplatform.budgetmanagementworkflow.handler.BudgetManagementWorkFlowWorker");
        QUERIES.put("BudgetManagementWorkFlow", "pomplatform.budgetmanagementworkflow.handler.BudgetManagementWorkFlowHandler");
        QUERIES.put("TaskApprovalBudgetManagementApplyWork", "pomplatform.taskapprovalbudgetManagementapplyWork.handler.TaskApprovalBudgetManagementApplyWorkHandler");
        QUERIES.put("knowApprovalBudgetManagementApplyWork", "pomplatform.knowapprovalbudgetmanagementapplywork.handler.knowApprovalBudgetManagementApplyWorkHandler");
        QUERIES.put("AlreadyApprovalBudgetManagementApplyWork", "pomplatform.alreadyapprovalbudgetmanagementapplywork.handler.AlreadyApprovalBudgetManagementApplyWorkHandler");
        QUERIES.put("ApprovalBudgetManagementApplyWork", "pomplatform.approvalbudgetmanagementapplywork.handler.ApprovalBudgetManagementApplyWorkHandler");
        QUERIES.put("BudgetManagementApplyWork", "pomplatform.budgetmanagementapplywork.handler.BudgetManagementApplyWorkHandler");
        QUERIES.put("SupplierWorkflow", "pomplatform.supplierworkflow.handler.SupplierWorkflowHandler");
        QUERIES.put("OnBudgetManagement", "pomplatform.budgetmanagement.handler.OnBudgetManagementHandler");
        PROCESSORS.put("BudetAboutUpload", "pomplatform.budgetmanagement.handler.BudgetAboutInfoHandler");
        QUERIES.put("PayMoneyProject", "pomplatform.paymoneyproject.handler.PayMoneyProjectHandler");
        QUERIES.put("Sprojecttemplateor", "pomplatform.projectTemplate.handler.SprojecttemplateorHandler");
        QUERIES.put("Mprojectemployeeppor", "pomplatform.operation.handler.MprojectemployeepporHandler");
        QUERIES.put("Semployeeaccountrecordor", "pomplatform.account.handler.SemployeeaccountrecordorHandler");
        PROCESSORS.put("CompanyWorkplaceProcessor", "pomplatform.cwd.business.CompanyWorkplaceProcessor");
        QUERIES.put("ShowContractDistributionNew", "pomplatform.contract.handler.ShowContractDistributionNewHandler");
        QUERIES.put("PersonalRegisterAddressManage", "pomplatform.cwd.personalregister.handler.PersonalRegisterAddressManageHandler");
        DAOS.put("CompanyWorkplaceWithC", "pomplatform.cwd.handler.CompanyWorkplaceWithCHandler");
        QUERIES.put("CompanyWorkplaceAndServerManage", "pomplatform.cwd.handler.CompanyWorkplaceAndServerManageHandler");
        QUERIES.put("WorkplacePublicIPManage", "pomplatform.cwd.handler.WorkplacePublicIPManageHandler");
        QUERIES.put("OssConfigManage", "pomplatform.cwd.handler.OssConfigManageHandler");
        QUERIES.put("OnGetEmpCheckTimeData", "pomplatform.shift.handler.OnGetEmpCheckTimeDataHandler");
        QUERIES.put("ContractProjectPerformance", "pomplatform.projectperformance.handler.ContractProjectPerformanceHandler");
        PROCESSORS.put("MakeFileNumberProcess", "pomplatform.workflow.personnelbusiness.handler.MakeFileNumberProcess");
        QUERIES.put("ShowOldProjectRevenue", "pomplatform.contract.handler.ShowOldProjectRevenueHandler");
        QUERIES.put("TeamMembers", "pomplatform.contract.handler.TeamMembersHandler");
        QUERIES.put("ShowContractDistribution", "pomplatform.contract.handler.ShowContractDistributionHandler");
        PROCESSORS.put("NewContractDistributionProcess", "pomplatform.contract.business.NewContractDistributionProcess");
        DOWNLOADPROCESSORS.put("ExportContractsRecords", "pomplatform.contractsRecords.handler.ContractsRecordsHandler");
        PROCESSORS.put("AddContractsRecords", "pomplatform.contractsRecords.handler.AddContractsRecords");
        QUERIES.put("OnLoadAttachmentBindContract", "pomplatform.contract.handler.OnLoadAttachmentBindContractHandler");
        QUERIES.put("OnLoadContractAttachmentData", "pomplatform.contract.handler.OnLoadContractAttachmentDataHandler");
        PROCESSORS.put("OnCommonContractProcess", "pomplatform.contract.business.OnCommonContractProcess");
        QUERIES.put("PreProjectAnalysisData", "pomplatform.project.handler.PreProjectAnalysisDataHandler");
        DOWNLOADPROCESSORS.put("ExportPreProjectAnalysisData", "pomplatform.project.handler.PreProjectAnalysisDataHandler");
        QUERIES.put("PreProjectMyRecords", "pomplatform.project.handler.PreProjectMyRecordsHandler");
        DOWNLOADPROCESSORS.put("ExportPreProjectMyRecords", "pomplatform.project.handler.PreProjectMyRecordsHandler");
        QUERIES.put("preProjectRecordRemark", "pomplatform.project.handler.preProjectRecordRemarkHandler");
        DOWNLOADPROCESSORS.put("ExportpreProjectRecordRemark", "pomplatform.project.handler.preProjectRecordRemarkHandler");
        PROCESSORS.put("ProjectInit", "pomplatform.preProjects.handler.ProjectInit");
        PROCESSORS.put("InputTaxInvoiceLinkFinanceProcess", "pomplatform.workflow.query.InputTaxInvoiceLinkFinanceProcess");
        QUERIES.put("NewContractDistribution", "pomplatform.contract.handler.NewContractDistributionHandler");
        QUERIES.put("EmployeeItegral", "pomplatform.trainingmanagement.handler.EmployeeItegralHandler");
        QUERIES.put("GetPlateManagers", "pomplatform.preProjects.handler.GetPlateManagersHandler");
        PROCESSORS.put("NewAccountProcess", "pomplatform.newaccount.business.NewAccountProcess");
        PROCESSORS.put("NewAccountTransactionsProcess", "pomplatform.newaccount.business.NewAccountTransactionsProcess");
        QUERIES.put("OnRevenueSureWarn", "pomplatform.project.handler.OnRevenueSureWarnHandler");
        PROCESSORS.put("CustomTaskManageProcess", "pomplatform.taskmanage.handler.CustomTaskManageProcess");
        UPLOADPROCESSORS.put("CustomTaskManageProcess", "pomplatform.taskmanage.handler.CustomTaskManageProcess");
        QUERIES.put("Scwdtasktemplatetccor", "pomplatform.taskmanage.handler.ScwdtasktemplatetccorHandler");
        QUERIES.put("OneNewAccountsTransationsInfo", "pomplatform.OnLoadNewAccounts.handler.OneNewAccountsTransationsInfoHandler");
        QUERIES.put("NewAccountsTransactionInfo", "pomplatform.OnLoadNewAccountsTransactionInfo.handler.NewAccountsTransactionInfoHandler");
        QUERIES.put("NewAccountsInfo", "pomplatform.OnLoadNewAccounts.handler.NewAccountsInfoHandler");
        QUERIES.put("EmployeeCardManage", "pomplatform.cardManage.handler.EmployeeCardManageHandler");
        PROCESSORS.put("TrainingManagementProcess", "pomplatform.trainingmanagement.handler.TrainingManagementProcess");
        PROCESSORS.put("GoodsReceiveProcess", "pomplatform.goodsreceive.handler.GoodsReceiveProcess");
        QUERIES.put("TrainingManagement", "pomplatform.trainingmanagement.handler.TrainingmanagementHandler");
        DAOS.put("GoodsReceiveNew", "pomplatform.preProjects.handler.GoodsReceiveNewHandler");
        DAOS.put("TrainingManagementnewProcess", "pomplatform.preProjects.handler.TrainingManagementNewHandler");
        QUERIES.put("Goodsreceivedetail", "pomplatform.goodsreceive.handler.GoodsreceivedetailHandler");
        QUERIES.put("Goodsreceive", "pomplatform.goodsreceive.handler.GoodsreceiveHandler");
        QUERIES.put("Strainingmanagementdetailor", "pomplatform.trainingManagementdetailor.handler.StrainingmanagementdetailorHandler");
        //导出培训主题下的详细信息
        DOWNLOADPROCESSORS.put("Strainingmanagement", "pomplatform.trainingManagementdetailor.handler.StrainingmanagementdetailorHandler");
        QUERIES.put("GetYearTotalContractAndRentMoney", "pomplatform.receivables.handler.GetYearTotalContractAndRentMoneyHandler");
        QUERIES.put("OnLoadRefuseListOfCostAllocationPanelNewFour", "pomplatform.workflow.operation.handler.OnLoadRefuseListOfCostAllocationPanelNewFourHandler");
        QUERIES.put("OnLoadRefuseListOfCostAllocationPanelNewThree", "pomplatform.workflow.operation.handler.OnLoadRefuseListOfCostAllocationPanelNewThreeHandler");
        QUERIES.put("OnLoadRefuseListOfCostAllocationPanelNewFive", "pomplatform.workflow.operation.handler.OnLoadRefuseListOfCostAllocationPanelNewFiveHandler");
        QUERIES.put("OnLoadRefuseListOfCostAllocationPanelNewTwo", "pomplatform.workflow.operation.handler.OnLoadRefuseListOfCostAllocationPanelNewTwoHandler");
        QUERIES.put("OnLoadApplyListOfCostAllocationSerchEmplyeeID", "pomplatform.workflow.operation.handler.OnLoadApplyListOfCostAllocationSerchEmplyeeIDHandler");
        QUERIES.put("OnLoadApplyListOfCostAllocationNew", "pomplatform.workflow.operation.handler.OnLoadApplyListOfCostAllocationNewHandler");
        QUERIES.put("ForPreproJectTransFerrecordporDate", "pomplatform.preprojecttransferrecordpors.handler.ForPreproJectTransFerrecordporDateHandler");
        WORKFLOWPROCESSORS.put("Prepro_JectTransFerrecordpor", "pomplatform.preprojecttransferrecordpors.handler.ForPreproJectTransFerrecordporWorker");
        QUERIES.put("ForPreproJectTransFerrecordpor", "pomplatform.preprojecttransferrecordpors.handler.ForPreproJectTransFerrecordporHandler");
        QUERIES.put("OnSalaryExceptionData", "pomplatform.salaryexceptions.handler.OnSalaryExceptionDataHandler");
        //DAOS.put("EmployeePaymentDetailWithS", "pomplatform.salaryexceptions.handler.EmployeePaymentDetailWithSHandler");		DAOS.put("PersonnelBusinesWithS", "pomplatform.salaryexceptions.handler.PersonnelBusinesWithSHandler");
        WORKFLOWPROCESSORS.put("Salary_Exceptions", "pomplatform.salaryexceptions.handler.OnSalaryExceptionsWorker");
        QUERIES.put("OnSalaryExceptions", "pomplatform.salaryexceptions.handler.OnSalaryExceptionsHandler");
        PROCESSORS.put("CustomPreProjectName",
                "pomplatform.PreProjectReimbursementNumber.handler.CustomPreProjectName");
        DOWNLOADPROCESSORS.put("ExportTravelAndMeetingData", "pomplatform.activityMpcor.handler.SactivityMpcorHandler");
        QUERIES.put("SactivityMpcor", "pomplatform.activityMpcor.handler.SactivityMpcorHandler");
        QUERIES.put("OnloadPreprojectDataForMobile", "pomplatform.preProjects.handler.OnloadPreprojectDataForMobileHandler");
        QUERIES.put("OnProjectManageStatus", "pomplatform.project.handler.OnProjectManageStatusHandler");
        DOWNLOADPROCESSORS.put("ExportPreProjectData", "pomplatform.preProjects.handler.projectPreInfomationsHandler");
        QUERIES.put("Mcmbcpaydetailcctyrrosoowwwppor", "pomplatform.sreimbursementpackagemmror.handler.McmbcpaydetailcctyrrosoowwwpporHandler");
        DAOS.put("PreProjectRecord", "pomplatform.preProjects.handler.CustomPreProjectRecordHandler");
        QUERIES.put("MainProjectCompetitionInfo", "pomplatform.preProjects.handler.MainProjectCompetitionInfoHandler");
        QUERIES.put("GetProjectECMCEmployeeInfo", "pomplatform.preProjects.handler.GetProjectECMCEmployeeInfoHandler");
        QUERIES.put("GetECMCDepartmentByPlate", "pomplatform.department.handler.GetECMCDepartmentByPlateHandler");
        QUERIES.put("SpreProjectRecordRrtor", "pomplatform.preProjectRecord.handler.SpreProjectRecordRrtorHandler");
        DOWNLOADPROCESSORS.put("OnBusinessLineRevenueDetailDataDownLoad", "pomplatform.report.handler.OnBusinessLineRevenueDetailDataHandler");
        QUERIES.put("OnBusinessLineRevenueDetailData", "pomplatform.report.handler.OnBusinessLineRevenueDetailDataHandler");
        DOWNLOADPROCESSORS.put("OnBusinessLineRevenueDataDownLoad", "pomplatform.report.handler.OnBusinessLineRevenueDataHandler");
        QUERIES.put("OnBusinessLineRevenueData", "pomplatform.report.handler.OnBusinessLineRevenueDataHandler");
        DOWNLOADPROCESSORS.put("OnExportSalaryTotal", "pomplatform.payment.business.OnExportSalaryTotal");
        DOWNLOADPROCESSORS.put("OnExportEmpDayPlateRecord", "pomplatform.OnEmployeeDayPlateRecords.handler.OnEmployeeDayPlateRecordsHandler");
        QUERIES.put("GetEmployeeByRoleAndPlate", "pomplatform.employees.handler.GetEmployeeByRoleAndPlateHandler");
        QUERIES.put("GetContractCodeNum", "pomplatform.preProjects.handler.GetContractCodeNumHandler");
        QUERIES.put("Sthreadtaskmanagemmmor", "pomplatform.threadTask.handler.SthreadtaskmanagemmmorHandler");
        DOWNLOADPROCESSORS.put("ExportPlateSalaryAdjustmentSummary", "pomplatform.workflow.personnelbusiness.handler.PlateSalaryAdjustmentSummaryHandler");
        DOWNLOADPROCESSORS.put("ExportEmpSalaryAdjustmentDetail", "pomplatform.workflow.personnelbusiness.handler.EmployeeSalaryAdjustmentDetailHandler");
        QUERIES.put("OnSalaryAnnualBonusByDepartment", "pomplatform.payment.handler.OnSalaryAnnualBonusByDepartmentHandler");
        QUERIES.put("OnSalaryAnnualBonusByPlate", "pomplatform.payment.handler.OnSalaryAnnualBonusByPlateHandler");
        QUERIES.put("OnSalaryAnnualBonusByCompany", "pomplatform.payment.handler.OnSalaryAnnualBonusByCompanyHandler");
        QUERIES.put("SalaryAnnualbonus", "pomplatform.salary.handler.SalaryAnnualbonusHandler");
        DOWNLOADPROCESSORS.put("SalaryAnnualbonus", "pomplatform.salary.handler.SalaryAnnualbonusHandler");
        PROCESSORS.put("BankCapitalCheckProcess", "pomplatform.cmbcinfo.handler.BankCapitalCheckProcess");
        QUERIES.put("Mcmbctransinfolinktattlor", "pomplatform.cmbcinfo.handler.McmbctransinfolinktattlorHandler");
        QUERIES.put("Mcapitalbccoccmsssoooblpommmmlor", "pomplatform.cmbcinfo.handler.McapitalbccoccmsssoooblpommmmlorHandler");
        DOWNLOADPROCESSORS.put("ContractLogList", "pomplatform.contract.handler.ContractLogListHandler");
        QUERIES.put("ContractLogList", "pomplatform.contract.handler.ContractLogListHandler");
        DOWNLOADPROCESSORS.put("DownLoadEmployeePaymentMonthDetail", "pomplatform.payment.handler.OnloadEmployeePaymentMonthDetailHandler");
        PROCESSORS.put("ToCalculateEmployeePaymentMonth", "pomplatform.payment.business.ToCalculateEmployeePaymentMonth");
        PROCESSORS.put("ToCalculateWorkYears", "pomplatform.salary.business.ToCalculateWorkYears");
        QUERIES.put("GetContractActualMoneyByPlateIdAndBusinessType", "pomplatform.contract.handler.GetContractActualMoneyByPlateIdAndBusinessTypeHandler");
        QUERIES.put("Mcmbctransinfoctator", "pomplatform.cmbcinfo.handler.McmbctransinfoctatorHandler");
        PROCESSORS.put("CmbcInfoProcessor", "pomplatform.cmbcinfo.business.CmbcInfoProcessor");
        QUERIES.put("Mcmbcaccoutinfoccacbscor", "pomplatform.cmbcinfo.handler.McmbcaccoutinfoccacbscorHandler");
        QUERIES.put("ProjectSettlement", "pomplatform.updatedata.handler.ProjectSettlementHandler");
        QUERIES.put("SumDepartmentCapitalDistribution", "pomplatform.capitaldistribution.handler.SumDepartmentCapitalDistributionHandler");
        DOWNLOADPROCESSORS.put("CapitalDifference", "pomplatform.capitaldistribution.handler.CapitalDifferenceHandler");
        QUERIES.put("CapitalDifference", "pomplatform.capitaldistribution.handler.CapitalDifferenceHandler");
        QUERIES.put("SumCapitalDistribution", "pomplatform.capitaldistribution.handler.SumCapitalDistributionHandler");
        QUERIES.put("SumCapitalBorrowMoney", "pomplatform.capitaldistribution.handler.SumCapitalBorrowMoneyHandler");
        DOWNLOADPROCESSORS.put("Scontractppcor", "pomplatform.newcontractppcor.handler.ScontractppcorHandler");
        PROCESSORS.put("LoginProcessor", "pomplatform.employeenew.business.LoginProcessor");
        DOWNLOADPROCESSORS.put("OnDownLoadWorkMoney", "pomplatform.salary.handler.OnDownLoadWorkMoneyHandler");
        QUERIES.put("OnDownLoadWorkMoney", "pomplatform.salary.handler.OnDownLoadWorkMoneyHandler");
        QUERIES.put("ApplyListOfPreProjectReport", "pomplatform.preProjects.handler.ApplyListOfPreProjectReportHandler");
        DAOS.put("PreProjectWithMmm", "pomplatform.preProjects.handler.PreProjectWithMmmHandler");
        WORKFLOWPROCESSORS.put("Close_project_apply", "pomplatform.preProjects.handler.CloseProjectApplyWorker");
        QUERIES.put("CloseProjectApply", "pomplatform.preProjects.handler.CloseProjectApplyHandler");
        WORKFLOWPROCESSORS.put("Be_project_apply", "pomplatform.preProjects.handler.BeProjectApplyWorker");
        QUERIES.put("BeProjectApply", "pomplatform.preProjects.handler.BeProjectApplyHandler");
        QUERIES.put("ContractStageProcessStatusList", "pomplatform.stagemodel.handler.ContractStageProcessStatusListHandler");
        QUERIES.put("ContractStageAuditDesigner", "pomplatform.stagemodel.handler.ContractStageAuditDesignerHandler");
        QUERIES.put("ContractStageAuditManager", "pomplatform.stagemodel.handler.ContractStageAuditManagerHandler");
        QUERIES.put("ContractStageAudit", "pomplatform.stagemodel.handler.ContractStageAuditHandler");
        QUERIES.put("GetContractStageModelByParentId", "pomplatform.stagemodel.handler.GetContractStageModelByParentIdHandler");
        QUERIES.put("GetRevenueByContractId", "pomplatform.stagemodel.handler.GetRevenueByContractIdHandler");
        DAOS.put("ContractStageModel", "pomplatform.stagemodel.handler.CustomContractStageModelHandler");
        PROCESSORS.put("StageModelProcessor", "pomplatform.stagemodel.business.StageModelProcessor");
        QUERIES.put("GetStageModelByParentId", "pomplatform.stagemodel.handler.GetStageModelByParentIdHandler");
        QUERIES.put("StageContractInfoList", "pomplatform.stagemodel.handler.StageContractInfoListHandler");
        QUERIES.put("TaskListOfPreProjectReport", "pomplatform.preProjects.handler.TaskListOfPreProjectReportHandler");
        QUERIES.put("RefuseListOfPreProjectReport", "pomplatform.preProjects.handler.RefuseListOfPreProjectReportHandler");
        QUERIES.put("AuditListOfPreProjectReport", "pomplatform.preProjects.handler.AuditListOfPreProjectReportHandler");
        QUERIES.put("AttentionListOfPreProjectReport", "pomplatform.preProjects.handler.AttentionListOfPreProjectReportHandler");
        WORKFLOWPROCESSORS.put("Pre_project_report", "pomplatform.preProjects.handler.PreProjectReportWorker");
        QUERIES.put("Sannoucementaaaor", "pomplatform.annoucement.handler.SannoucementaaaorHandler");
        PROCESSORS.put("OtherAnnoucementProcess", "pomplatform.annoucement.handler.OtherAnnoucementProcess");
        PROCESSORS.put("GetActivityDetailsProcess", "pomplatform.activityMpcor.handler.GetActivityDetailsProcess");
        QUERIES.put("OnLoadCustomerData", "pomplatform.customer.handler.OnLoadCustomerDataHandler");
        PROCESSORS.put("OnCustomerProcess", "pomplatform.customer.business.OnCustomerProcess");
        PROCESSORS.put("AddPreProjectRecordProcess", "pomplatform.preProjectRecord.handler.AddPreProjectRecordProcess");
        PROCESSORS.put("PreProjectProcess", "pomplatform.preProjects.business.PreProjectProcess");
        QUERIES.put("ProjectOfProjectManager", "pomplatform.project.handler.ProjectOfProjectManagerHandler");
        PROCESSORS.put("OnCompanyProjectAdvanceRecordSave", "pomplatform.common.business.OnCompanyProjectAdvanceRecordSave");
        //		QUERIES.put("RevenueStatisticalOfRevenue", "pomplatform.revenueStatistical.handler.RevenueStatisticalOfRevenueHandler");
        DOWNLOADPROCESSORS.put("OnExportIncomeWeekMoney", "pomplatform.receivables.query.OnExportIncomeWeekMoney");
        QUERIES.put("GetTotalContractAndRentMoney", "pomplatform.receivables.handler.GetTotalContractAndRentMoneyHandler");
        QUERIES.put("AttachmentManageMeetingTor", "pomplatform.attachmentManageMeeting.handler.AttachmentManageMeetingTorHandler");
        PROCESSORS.put("SponsorAttachment", "pomplatform.attachmentManageMeeting.handler.SponsorAttachmentProcessor");
        QUERIES.put("Ssysteminitloglstor", "pomplatform.systeminitloglstor.handler.SsysteminitloglstorHandler");
        PROCESSORS.put("DeleteSystemInitData", "pomplatform.systeminitloglstor.handler.DeleteSystemInitData");
        UPLOADPROCESSORS.put("UploadInitSystemDataProcess", "pomplatform.salaryemployeeevaluationrmmor.handler.UploadInitSystemDataProcess");
        QUERIES.put("LoadEmployeeForSendBonusTwo", "pomplatform.bonusPayment.handler.LoadEmployeeForSendBonusTwoHandler");
        QUERIES.put("LoadEmployeeForSendBonus", "pomplatform.bonusPayment.handler.LoadEmployeeForSendBonusHandler");
        QUERIES.put("EmployeeProjectAnalysis", "pomplatform.analysisemployee.handler.EmployeeProjectAnalysisHandler");
        QUERIES.put("IncomeMoneyForWeek", "pomplatform.receivables.handler.IncomeMoneyForWeekHandler");
        QUERIES.put("ContractDistributionMonthlyDetail", "pomplatform.contract.handler.ContractDistributionMonthlyDetailHandler");
        DOWNLOADPROCESSORS.put("ContractStatusHistory", "pomplatform.contract.handler.ContractStatusHistoryHandler");
        QUERIES.put("ContractStatusHistory", "pomplatform.contract.handler.ContractStatusHistoryHandler");
        PROCESSORS.put("ContractDistributionProcessor", "pomplatform.contract.business.ContractDistributionProcessor");
        QUERIES.put("SumPlateContractDistribution", "pomplatform.contract.handler.SumPlateContractDistributionHandler");
        QUERIES.put("ContractDistribution", "pomplatform.contract.handler.ContractDistributionHandler");
        DOWNLOADPROCESSORS.put("ContractDistribution", "pomplatform.contract.handler.ContractDistributionHandler");
        QUERIES.put("SearchCostData", "pomplatform.payment.handler.SearchCostDataHandler");
        UPLOADPROCESSORS.put("OnUploadReimbursementDataProcess", "pomplatform.reimbursementpackage.handler.OnUploadReimbursementDataProcess");
        QUERIES.put("GetDepartmentIdByEmployeeIdAndFunctionCode", "pomplatform.funciton.handler.GetDepartmentIdByEmployeeIdAndFunctionCodeHandler");
        QUERIES.put("GetPlateIdByEmployeeIdAndFunctionCode", "pomplatform.funciton.handler.GetPlateIdByEmployeeIdAndFunctionCodeHandler");
        QUERIES.put("MprojectemployeeForQuery", "pomplatform.operation.handler.MprojectemployeeForQueryHandler");
        DOWNLOADPROCESSORS.put("Mcontractppspcccfscsiiicpor", "pomplatform.contractppspcccfscsiiicpor.handler.McontractppspcccfscsiiicporHandler");
        PROCESSORS.put("OnWebsitenewsProcess", "pomplatform.websitenews.business.OnWebsitenewsProcess");
        QUERIES.put("MprojectEmployeeGrades", "pomplatform.projectteambuild.handler.MprojectEmployeeGradesHandler");
        QUERIES.put("Mcmbcpaydetailctswoowycoor", "pomplatform.reimbursementpackage.handler.McmbcpaydetailctswoowycoorHandler");
        QUERIES.put("MCmbcPaymentDetailpor", "pomplatform.reimbursementpackage.handler.MCmbcPaymentDetailporHandler");
        QUERIES.put("Mprojectstageppor", "pomplatform.projectteambuild.handler.MprojectstagepporHandler");
        QUERIES.put("AllCapitalDistributionInfo", "pomplatform.projectCost.handler.AllCapitalDistributionInfoHandler");
        DOWNLOADPROCESSORS.put("AllCapitalDistributionInfo", "pomplatform.projectCost.handler.AllCapitalDistributionInfoHandler");
        QUERIES.put("AutoFitInfo", "pomplatform.capitaldistribution.handler.AutoFitInfoHandler");
        QUERIES.put("LeftCapitalAmount", "pomplatform.capitaldistribution.handler.LeftCapitalAmountHandler");
        QUERIES.put("MCmbcPaymentDetailpor", "pomplatform.reimbursementpackage.handler.MCmbcPaymentDetailporHandler");
        QUERIES.put("Mreimbursementpackagesummarycrtppor", "pomplatform.reimbursementpackage.handler.MreimbursementpackagesummarycrtpporHandler");
        QUERIES.put("Scmbcpaydetailctyor", "pomplatform.reimbursementpackage.handler.ScmbcpaydetailctyorHandler");
        QUERIES.put("SprojectcorDetail", "pomplatform.company.handler.SprojectcorDetailHandler");
        QUERIES.put("CompanyAccountGetSheetTotal", "pomplatform.company.handler.CompanyAccountGetSheetTotalHandler");
        QUERIES.put("SalaryBonusSendDataPay", "pomplatform.reimbursementpackage.handler.SalaryBonusSendDataPayHandler");
        QUERIES.put("SalarySendDataPay", "pomplatform.reimbursementpackage.handler.SalarySendDataPayHandler");
        QUERIES.put("CapitalLogDetail", "pomplatform.capitaldistribution.handler.CapitalLogDetailHandler");
        QUERIES.put("GetProjectManagerByContractId", "pomplatform.project.handler.GetProjectManagerByContractIdHandler");
        PROCESSORS.put("GetAreaChildData", "pomplatform.areas.business.GetAreaChildData");
        QUERIES.put("OnLoadStandardQuoteData", "pomplatform.project.handler.OnLoadStandardQuoteDataHandler");
        QUERIES.put("Sareaaaor", "pomplatform.areas.handler.SareaaaorHandler");
        PROCESSORS.put("ProjectOfChangeBuyIntegral", "pomplatform.projectReportRecordDetail.business.ProjectOfChangeBuyIntegral");
        QUERIES.put("SearchProjectCostSum", "pomplatform.projectReportRecordDetail.handler.SearchProjectCostSumHandler");
        QUERIES.put("ProjectBuyCosts", "pomplatform.projectReportRecordDetail.handler.ProjectBuyCostsHandler");
        QUERIES.put("Scardmanagecdcor", "pomplatform.cardmanagecdcor.handler.ScardmanagecdcorHandler");
        QUERIES.put("PersonnelBusinessSalary", "pomplatform.workflow.personnelbusiness.handler.PersonnelBusinessSalaryHandler");
        QUERIES.put("PlateSalaryAdjustmentSummary", "pomplatform.workflow.personnelbusiness.handler.PlateSalaryAdjustmentSummaryHandler");
        QUERIES.put("OnLoadAttentionListOfSalaryAdjustment", "pomplatform.workflow.personnelbusiness.handler.OnLoadAttentionListOfSalaryAdjustmentHandler");
        QUERIES.put("OnLoadTaskListOfSalaryAdjustment", "pomplatform.workflow.personnelbusiness.handler.OnLoadTaskListOfSalaryAdjustmentHandler");
        QUERIES.put("OnLoadApplyListOfSalaryAdjustment", "pomplatform.workflow.personnelbusiness.handler.OnLoadApplyListOfSalaryAdjustmentHandler");
        QUERIES.put("EmployeeSalaryAdjustmentDetail", "pomplatform.workflow.personnelbusiness.handler.EmployeeSalaryAdjustmentDetailHandler");
        //根据流程类型和部门ID，来获取适用的流程
        QUERIES.put("GetProcessByTypeAndDepartment", "pomplatform.workflow.handler.GetProcessByTypeAndDepartmentHandler");
        QUERIES.put("EmployeeInfoOfNoSalaryAdjustment", "pomplatform.employee.handler.EmployeeInfoOfNoSalaryAdjustmentHandler");
        QUERIES.put("OnLoadShiftAndDayPayment", "pomplatform.payment.handler.OnLoadShiftAndDayPaymentHandler");
        DOWNLOADPROCESSORS.put("DownloadEmployeeCostAnalysy", "pomplatform.report.business.onDownloadEmployeeCostAnalysy");
        //财务会记扫描收单
        PROCESSORS.put("CustomFinanceReceiveBillProcess", "pomplatform.financereceivebills.handler.CustomFinanceReceiveBillProcess");
        QUERIES.put("Mfinancereceivebillspor", "pomplatform.financereceivebills.handler.MfinancereceivebillsporHandler");
        QUERIES.put("SumSalaryAndInsuranceCost", "pomplatform.report.handler.SumSalaryAndInsuranceCostHandler");
        QUERIES.put("ReportOfEmployeeCostAnalysis", "pomplatform.report.handler.ReportOfEmployeeCostAnalysisHandler");
        QUERIES.put("SendIntegralOfEmpPaymentDetail", "pomplatform.payment.handler.SendIntegralOfEmpPaymentDetailHandler");
        QUERIES.put("OnLoadSaleIntegralFromPlate", "pomplatform.revenue.handler.OnLoadSaleIntegralFromPlateHandler");
        QUERIES.put("OnboardEmployeeEachYear", "pomplatform.employee.handler.OnboardEmployeeEachYearHandler");
        DOWNLOADPROCESSORS.put("DownloadOnboardEmployees", "pomplatform.employee.handler.OnboardEmployeeEachMonthDetailHandler");
        QUERIES.put("OnboardEmployeeEachMonth", "pomplatform.employee.handler.OnboardEmployeeEachMonthHandler");
        QUERIES.put("OnboardEmployeeEachMonthDetail", "pomplatform.employee.handler.OnboardEmployeeEachMonthDetailHandler");
        DAOS.put("Capital", "pomplatform.capital.handler.CustomCapitalHandler");
        QUERIES.put("RegularEmployeeInfo", "pomplatform.personnelbusiness.handler.RegularEmployeeInfoHandler");
        //手机端薪资与奖金流程 备注
        PROCESSORS.put("CustomMobileProcess", "pomplatform.mobile.approvalcount.handler.CustomMobileProcess");
        QUERIES.put("Minputtaxinvoicelinkfinancesippciiymssor", "pomplatform.inputtaxinvoiceabpor.handler.MinputtaxinvoicelinkfinancesippciiymssorHandler");
        DOWNLOADPROCESSORS.put("CustomInputtaxinvoiceProcess", "pomplatform.inputtaxinvoiceabpor.handler.CustomInputtaxinvoiceProcess");
        PROCESSORS.put("CustomInputtaxinvoiceProcess", "pomplatform.inputtaxinvoiceabpor.handler.CustomInputtaxinvoiceProcess");
        UPLOADPROCESSORS.put("CustomInputtaxinvoiceProcess", "pomplatform.inputtaxinvoiceabpor.handler.CustomInputtaxinvoiceProcess");
        QUERIES.put("Sinputtaxinvoiceabpor", "pomplatform.inputtaxinvoiceabpor.handler.SinputtaxinvoiceabporHandler");
        QUERIES.put("OnLoadEmployeePaymentDetail", "pomplatform.payment.handler.OnLoadEmployeePaymentDetailHandler");
        QUERIES.put("GetProjects", "pomplatform.project.handler.GetProjectsHandler");
        QUERIES.put("DecryptPersonnelBusiness", "pomplatform.personnelbusiness.handler.DecryptPersonnelBusinessHandler");
        QUERIES.put("PositiveEmployeeInfo", "pomplatform.employee.handler.PositiveEmployeeInfoHandler");
        QUERIES.put("ReportOfResignationApplyEmp", "pomplatform.report.handler.ReportOfResignationApplyEmpHandler");
        QUERIES.put("ReportOfTransferEmp", "pomplatform.report.handler.ReportOfTransferEmpHandler");
        QUERIES.put("ReportPayChangeOnboardEmp", "pomplatform.report.handler.ReportPayChangeOnboardEmpHandler");
        QUERIES.put("CapitalDistributionOfProject", "pomplatform.capitaldistribution.handler.CapitalDistributionOfProjectHandler");
        DOWNLOADPROCESSORS.put("CapitalDistributionOfProject", "pomplatform.capitaldistribution.handler.CapitalDistributionOfProjectHandler");
        QUERIES.put("OnLoadAttendanceStatusDetial", "pomplatform.shift.handler.OnLoadAttendanceStatusDetialHandler");
        QUERIES.put("OnLoadAttendanceStatus", "pomplatform.shift.handler.OnLoadAttendanceStatusHandler");
        QUERIES.put("OnLoadAttendanceTotal", "pomplatform.shift.handler.OnLoadAttendanceTotalHandler");
        PROCESSORS.put("ExchangeRateProcessor", "pomplatform.exchangerate.business.ExchangeRateProcessor");
        //获取订单的基本信息和该订单剩余的可分配的订单合同金额
        QUERIES.put("GetProjectInfoAndLeftAmount", "pomplatform.capitaldistribution.handler.GetProjectInfoAndLeftAmountHandler");
        QUERIES.put("MyAttentions", "pomplatform.mobile.approvalcount.handler.MyAttentionsHandler");
        QUERIES.put("GetReimbursementCost", "pomplatform.reimbursement.handler.GetReimbursementCostHandler");
        QUERIES.put("CapitalDistributionOfDepartment", "pomplatform.capitaldistribution.handler.CapitalDistributionOfDepartmentHandler");
        DOWNLOADPROCESSORS.put("CapitalDistributionOfDepartment", "pomplatform.capitaldistribution.handler.CapitalDistributionOfDepartmentHandler");
        QUERIES.put("SimpleCapitalList", "pomplatform.capitaldistribution.handler.SimpleCapitalListHandler");
        QUERIES.put("PlateOrProjectCapitalDistribution", "pomplatform.capitaldistribution.handler.PlateOrProjectCapitalDistributionHandler");
        PROCESSORS.put("CapitalDistributionProcessor", "pomplatform.capitaldistribution.business.CapitalDistributionProcessor");
        QUERIES.put("GetProjectSureAndLeftInteger", "pomplatform.capitaldistribution.handler.GetProjectSureAndLeftIntegerHandler");
        QUERIES.put("SearchProjectCapitalDistribution", "pomplatform.capitaldistribution.handler.SearchProjectCapitalDistributionHandler");
        QUERIES.put("OnSalaryEmpBonusByDepartment", "pomplatform.payment.handler.OnSalaryEmpBonusByDepartmentHandler");
        DOWNLOADPROCESSORS.put("Memployeeaaccadpppccor", "pomplatform.attachment.handler.MemployeeaaccadpppccorHandler");
        QUERIES.put("Memployeeaaccadpppccor", "pomplatform.attachment.handler.MemployeeaaccadpppccorHandler");
        //财务: 查询在流程中的所有确认函申请
        QUERIES.put("Mpersonnelbusinessdddemmpor", "pomplatform.attachment.handler.MpersonnelbusinessdddemmporHandler");
        QUERIES.put("ReportOfGenderPlateMonth", "pomplatform.report.handler.ReportOfGenderPlateMonthHandler");
        QUERIES.put("ReportEmployeeWorkYears", "pomplatform.report.handler.ReportEmployeeWorkYearsHandler");
        QUERIES.put("Memployeepsrreereeedpor", "pomplatform.receiveunit.handler.MemployeepsrreereeedporHandler");
        QUERIES.put("ReportOfGenderAnalysis", "pomplatform.report.handler.ReportOfGenderAnalysisHandler");
        QUERIES.put("MyApplyWork", "pomplatform.mobile.applywork.handler.MyApplyWorkHandler");
        QUERIES.put("ForEmpManageExportData", "pomplatform.hr.handler.ForEmpManageExportDataHandler");
        //财务：报销查询
        DOWNLOADPROCESSORS.put("SearchReimbursementInfo", "pomplatform.reimbursement.handler.SearchReimbursementInfoExport");
        //报表：成本明细表
        DOWNLOADPROCESSORS.put("ReportCostDetailByMonth", "pomplatform.report.handler.ReportCostDetailByMonthHandler");
        QUERIES.put("ReportCostDetailByMonth", "pomplatform.report.handler.ReportCostDetailByMonthHandler");
        //报表：成本总表
        DOWNLOADPROCESSORS.put("ReportCostTotal", "pomplatform.report.handler.ReportCostTotalHandler");
        QUERIES.put("ReportCostTotal", "pomplatform.report.handler.ReportCostTotalHandler");
        //调节后的成本查询
        DOWNLOADPROCESSORS.put("ReportCostDetail", "pomplatform.report.handler.ReportCostDetailHandler");
        QUERIES.put("ReportCostDetail", "pomplatform.report.handler.ReportCostDetailHandler");
        QUERIES.put("OnLoadContractSaveAmount", "pomplatform.payment.handler.OnLoadContractSaveAmountHandler");
        QUERIES.put("EmployeeShouldAndFactCheck", "pomplatform.checking.handler.EmployeeShouldAndFactCheckHandler");
        QUERIES.put("EmployeeCheckStatus", "pomplatform.checking.handler.EmployeeCheckStatusHandler");
        PROCESSORS.put("OnReportProcess", "pomplatform.report.business.OnReportProcess");
        //知会同类型  批量已阅
        PROCESSORS.put("AttentionBatchProcessor", "pomplatform.workflow.handler.AttentionBatchProcessor");
        QUERIES.put("ReportTotals", "pomplatform.report.handler.ReportTotalsHandler");
        DOWNLOADPROCESSORS.put("OnDownloadReportTotals", "pomplatform.report.business.OnDownloadReportTotals");
        DOWNLOADPROCESSORS.put("OnDownloadReportOnEmployeeNumTotal", "pomplatform.report.business.OnDownloadReportOnEmployeeNumTotal");
        QUERIES.put("ReportOnEmployeeNumTotal", "pomplatform.report.handler.ReportOnEmployeeNumTotalHandler");
        DOWNLOADPROCESSORS.put("OnDownloadReportNewContractTotal", "pomplatform.report.business.OnDownloadReportNewContractTotal");
        QUERIES.put("ReportNewContractTotal", "pomplatform.report.handler.ReportNewContractTotalHandler");
        QUERIES.put("SalaryVoucherInfo", "pomplatform.salarytotalrecord.handler.SalaryVoucherInfoHandler");
        DOWNLOADPROCESSORS.put("OnDownloadReportOfSalaryTotal", "pomplatform.report.business.OnDownloadReportOfSalaryTotal");
        QUERIES.put("ReportOfSalaryTotal", "pomplatform.report.handler.ReportOfSalaryTotalHandler");
        DOWNLOADPROCESSORS.put("InsuranceAndHousingFundK3Voucher", "pomplatform.k3voucher.handler.InsuranceAndHousingFundK3VoucherHandler");
        QUERIES.put("InsuranceAndHousingFundK3Voucher", "pomplatform.k3voucher.handler.InsuranceAndHousingFundK3VoucherHandler");
        QUERIES.put("InsuranceAndHousingFundVoucherInfo", "pomplatform.insuranceandhousingfund.handler.InsuranceAndHousingFundVoucherInfoHandler");
        UPLOADPROCESSORS.put("OnCommonImportProcess", "pomplatform.common.business.OnCommonImportProcess");
        QUERIES.put("ReportCapitaDepartmentDetail", "pomplatform.report.handler.ReportCapitaDepartmentDetailHandler");
        QUERIES.put("ReportCapitaProjectDetail", "pomplatform.report.handler.ReportCapitaProjectDetailHandler");
        DOWNLOADPROCESSORS.put("OnDownloadReportCapitalTotal", "pomplatform.report.business.OnDownloadReportCapitalTotal");
        QUERIES.put("ReportCapitalTotal", "pomplatform.report.handler.ReportCapitalTotalHandler");
        //预付对账导出
        DOWNLOADPROCESSORS.put("Mprocessbilllistsmmeor", "pomplatform.receiveunit.handler.MprocessbilllistsmmeorHandler");
        QUERIES.put("Mprocessbilllistsmmeor", "pomplatform.receiveunit.handler.MprocessbilllistsmmeorHandler");
        QUERIES.put("Mreceiveunitmanagepsrbbor", "pomplatform.receiveunit.handler.MreceiveunitmanagepsrbborHandler");
        QUERIES.put("ReportOfSumRevenueYearRecordDetail", "pomplatform.report.handler.ReportOfSumRevenueYearRecordDetailHandler");
        DOWNLOADPROCESSORS.put("ReportOfSumRevenueYearRecordDetail", "pomplatform.report.handler.ReportOfSumRevenueYearRecordDetailHandler");
        DOWNLOADPROCESSORS.put("ProjectManager", "pomplatform.operation.handler.ProjectManagerHandler");
        //报销打包汇总详情查询
        DOWNLOADPROCESSORS.put("Sreimbursementpackagesummarymmmor", "pomplatform.reimbursement.handler.SreimbursementpackagesummarymmmorHandler");
        QUERIES.put("Sreimbursementpackagesummarymmmor", "pomplatform.reimbursement.handler.SreimbursementpackagesummarymmmorHandler");
        QUERIES.put("ReportSureIntegralDetail", "pomplatform.report.handler.ReportSureIntegralDetailHandler");
        DOWNLOADPROCESSORS.put("OnDownloadReportSureIntegralTotal", "pomplatform.report.business.OnDownloadReportSureIntegralTotal");
        QUERIES.put("ReportSureIntegralTotal", "pomplatform.report.handler.ReportSureIntegralTotalHandler");
        //按条件导出用车成本明细
        DOWNLOADPROCESSORS.put("CarCostAllocationEachMonthDetail", "pomplatform.costallocation.handler.CarCostAllocationEachMonthDetailHandler");
        QUERIES.put("CarCostAllocationEachMonthDetail", "pomplatform.costallocation.handler.CarCostAllocationEachMonthDetailHandler");
        QUERIES.put("CarCostAllocationEachMonth", "pomplatform.costallocation.handler.CarCostAllocationEachMonthHandler");
        QUERIES.put("ReportOfSumRevenueYearRecords", "pomplatform.report.handler.ReportOfSumRevenueYearRecordsHandler");
        //营收统计表导出
        DOWNLOADPROCESSORS.put("OnDownloadSumRevenueYearRecords", "pomplatform.report.business.OnDownloadSumRevenueYearRecords");
        QUERIES.put("Mprojectcrymor", "pomplatform.revenuevoucher.handler.MprojectcrymorHandler");
        //导出每月的离职员工明细
        DOWNLOADPROCESSORS.put("ResignEmployeeEachMonthDetail", "pomplatform.employee.handler.ResignEmployeeEachMonthDetailHandler");
        //职员管理明细
        QUERIES.put("Memployeeeeedor", "pomplatform.employeeInformationDetails.handler.MemployeeeeedorHandler");
        //导出职员管理明细
        DOWNLOADPROCESSORS.put("Memployeeeeedor", "pomplatform.employeeInformationDetails.handler.MemployeeeeedorHandler");
        //导出某段时间内的离职员工明细
        DOWNLOADPROCESSORS.put("DownloadResignEmployees", "pomplatform.employee.handler.DownloadResignEmployeesHandler");
        QUERIES.put("DownloadResignEmployees", "pomplatform.employee.handler.DownloadResignEmployeesHandler");
        //汇总某个部门、某个月份的离职人员明细
        QUERIES.put("ResignEmployeeEachMonthDetail", "pomplatform.employee.handler.ResignEmployeeEachMonthDetailHandler");
        //汇总某段时间内，以月为单位的各部门离职人员数量
        QUERIES.put("ResignEmployeeEachMonth", "pomplatform.employee.handler.ResignEmployeeEachMonthHandler");
        //汇总某段时间内，以年为单位的各部门离职人员数量
        QUERIES.put("ResignEmployeeEachYear", "pomplatform.employee.handler.ResignEmployeeEachYearHandler");
        //确认函凭证
        DOWNLOADPROCESSORS.put("AttachmentVoucher", "pomplatform.attachmentVoucher.handler.AttachmentVoucherHandler");
        QUERIES.put("AttachmentVoucher", "pomplatform.attachmentVoucher.handler.AttachmentVoucherHandler");
        QUERIES.put("CountEmployeeIntegralBusinessStatus", "pomplatform.employeeAward.handler.CountEmployeeIntegralBusinessStatusHandler");
        QUERIES.put("OnLoadSalaryPaymentChange", "pomplatform.payment.handler.OnLoadSalaryPaymentChangeHandler");
        QUERIES.put("OnLoadSalaryPaymentByCompany", "pomplatform.payment.handler.OnLoadSalaryPaymentByCompanyHandler");
        QUERIES.put("FiveinsuranceSummaryPlate", "pomplatform.payment.handler.FiveinsuranceSummaryPlateHandler");
        QUERIES.put("Sprojectccpor", "pomplatform.project.handler.SprojectccporHandler");
        //网络权限
        WORKFLOWPROCESSORS.put("Network_privileges", "pomplatform.workflow.personnelbusiness.handler.NetworkPrivilegesWorker");
        QUERIES.put("Network_privileges", "pomplatform.workflow.personnelbusiness.handler.NetworkPrivilegesHandler");
        QUERIES.put("OnLoadTaskListOfCostAllocation", "pomplatform.workflow.operation.handler.OnLoadTaskListOfCostAllocationHandler");
        QUERIES.put("OnLoadAttentionListOfCostAllocation", "pomplatform.workflow.operation.handler.OnLoadAttentionListOfCostAllocationHandler");
        QUERIES.put("OnLoadRefuseListOfCostAllocation", "pomplatform.workflow.operation.handler.OnLoadRefuseListOfCostAllocationHandler");
        QUERIES.put("OnLoadAuditListOfCostAllocation", "pomplatform.workflow.operation.handler.OnLoadAuditListOfCostAllocationHandler");
        QUERIES.put("OnLoadApplyListOfCostAllocation", "pomplatform.workflow.operation.handler.OnLoadApplyListOfCostAllocationHandler");
        DAOS.put("ResetCostWithC", "pomplatform.costallocation.handler.ResetCostWithCHandler");
        //成本调节
        WORKFLOWPROCESSORS.put("Cost_allocation", "pomplatform.costallocation.handler.CostAllocationApplyWorker");
        QUERIES.put("CostAllocationApply", "pomplatform.costallocation.handler.CostAllocationApplyHandler");
        QUERIES.put("MyApprovalSummary", "pomplatform.mobile.approvalcount.handler.MyApprovalSummaryHandler");
        //收入凭证
        DOWNLOADPROCESSORS.put("RevenueVoucher", "pomplatform.k3voucher.handler.RevenueVoucherHandler");
        QUERIES.put("RevenueVoucher", "pomplatform.k3voucher.handler.RevenueVoucherHandler");
        DOWNLOADPROCESSORS.put("ResetAllReimbursementCost", "pomplatform.reimbursement.handler.ResetAllReimbursementCostHandler");
        QUERIES.put("ResetAllReimbursementCost", "pomplatform.reimbursement.handler.ResetAllReimbursementCostHandler");
        QUERIES.put("GetProjectManagerByProjectId", "pomplatform.project.handler.GetProjectManagerByProjectIdHandler");
        QUERIES.put("GetUseCarPrice", "pomplatform.usecarprices.handler.GetUseCarPriceHandler");
        DAOS.put("PersonnelBusinesWithC", "pomplatform.workflow.personnelbusiness.handler.PersonnelBusinesWithCHandler");
        //用车申请（新版）
        WORKFLOWPROCESSORS.put("Cars_apply", "pomplatform.workflow.personnelbusiness.handler.CarApplyWorker");
        QUERIES.put("Cars_apply", "pomplatform.workflow.personnelbusiness.handler.CarApplyHandler");
        //获取每月部门应发工资
        PROCESSORS.put("CustomDepartmentSelectInfoProcess", "pomplatform.department.handler.CustomDepartmentSelectInfoProcess");
        //微信自动登录ERP手机端检测
        PROCESSORS.put("CheckUserinfoToLogin", "pomplatform.employee.handler.CheckUserinfoToLoginProcess");
        QUERIES.put("Sreceiveunitmanagemmror", "pomplatform.sreceiveunitmanagemmror.handler.SreceiveunitmanagemmrorHandler");
        QUERIES.put("GetResignationIntegral", "pomplatform.workflow.personnelbusiness.handler.GetResignationIntegralHandler");
        QUERIES.put("onLoadAccountInfoOfPlateAccount", "pomplatform.account.handler.onLoadAccountInfoOfPlateAccountHandler");
        UPLOADPROCESSORS.put("OnUploadEmpDeductIllData", "pomplatform.upload.OnUploadEmpDeductIllData");
        DOWNLOADPROCESSORS.put("OnDownloadCheckinout", "pomplatform.check.business.OnDownloadCheckinout");
        QUERIES.put("EmployeeViolationCharges", "pomplatform.employeeReportRecordDetail.handler.EmployeeViolationChargesHandler");
        PROCESSORS.put("OnEmpIntegralBusinessProcessor",
                "pomplatform.employeeReportRecordDetail.business.OnEmpIntegralBusinessProcessor");
        QUERIES.put("OnEmployeeIntegralBusiness", "pomplatform.employeeAward.handler.OnEmployeeIntegralBusinessHandler");
        QUERIES.put("CountOverTimeApply", "pomplatform.workflow.personnelbusiness.handler.CountOverTimeApplyHandler");
        QUERIES.put("CustomerK3Code", "pomplatform.k3code.handler.CustomerK3CodeHandler");
        QUERIES.put("CustomerInfo", "pomplatform.customer.handler.CustomerInfoHandler");
        DOWNLOADPROCESSORS.put("IncomeVoucher", "pomplatform.k3voucher.handler.IncomeVoucherHandler");
        QUERIES.put("IncomeVoucher", "pomplatform.k3voucher.handler.IncomeVoucherHandler");
        QUERIES.put("CapitalVoucher", "pomplatform.capital.handler.CapitalVoucherHandler");
        QUERIES.put("InvoiceVoucher", "pomplatform.invoice.handler.InvoiceVoucherHandler");
        UPLOADPROCESSORS.put("OnUploadEmployeeDayPayment", "pomplatform.upload.OnUploadEmployeeDayPayment");
        //手机端数据检索
        QUERIES.put("MyApprovalProcessDetail", "pomplatform.mobile.approvalcount.handler.MyApprovalProcessDetailHandler");
        //薪资发放流程
        WORKFLOWPROCESSORS.put("Payroll_apply", "pomplatform.workflow.personnelbusiness.handler.PayrollApplyWorker");
        QUERIES.put("FiveInsuranceOneGolds", "pomplatform.payment.handler.FiveInsuranceOneGoldsHandler");
        QUERIES.put("OnloadEmployeePaymentMonthDetail", "pomplatform.payment.handler.OnloadEmployeePaymentMonthDetailHandler");
        //员工月薪表解密
        DOWNLOADPROCESSORS.put("OnSalaryBonusSendData", "pomplatform.payment.handler.OnSalaryBonusSendDataHandler");
        QUERIES.put("DecryptEmployeePaymentMonthDetails", "pomplatform.salarydecrypt.handler.DecryptEmployeePaymentMonthDetailsHandler");
        QUERIES.put("OnSalaryBonusSendData", "pomplatform.payment.handler.OnSalaryBonusSendDataHandler");
        QUERIES.put("OnSalaryBonusTotalData", "pomplatform.payment.handler.OnSalaryBonusTotalDataHandler");
        DOWNLOADPROCESSORS.put("OnDownloadInsurance", "pomplatform.payment.business.OnDownloadInsurance");

        //流程结束修改确认函数据
        QUERIES.put("OnUpdateAttachmentLinkInvoices", "pomplatform.attachment.handler.OnUpdateAttachmentLinkInvoicesHandler");
        QUERIES.put("OnUpdateAttachmentLinkContractReceivables", "pomplatform.attachment.handler.OnUpdateAttachmentLinkContractReceivablesHandler");
        QUERIES.put("OnUpdateAttachmentLinkInvoiceApplys", "pomplatform.attachment.handler.OnUpdateAttachmentLinkInvoiceApplysHandler");
        //合同确认函资金汇总
        QUERIES.put("SattachmentmanageCapital", "pomplatform.attachment.handler.SattachmentmanageCapitalHandler");
        QUERIES.put("McontractAttachmentCapitalCount", "pomplatform.attachment.handler.McontractAttachmentCapitalCountHandler");
        QUERIES.put("GetRunningReimbursementAmountByContract", "pomplatform.project.handler.GetRunningReimbursementAmountByContractHandler");
        QUERIES.put("GetRunningReimbursementAmountByProject", "pomplatform.project.handler.GetRunningReimbursementAmountByProjectHandler");
        QUERIES.put("GetProjectAndSettlementIntegralByContract", "pomplatform.project.handler.GetProjectAndSettlementIntegralByContractHandler");
        QUERIES.put("GetProjectAndSettlementIntegralByProject", "pomplatform.project.handler.GetProjectAndSettlementIntegralByProjectHandler");
        PROCESSORS.put("ProjectProcessor", "pomplatform.project.business.ProjectProcessor");
        QUERIES.put("FiveinsuranceSummary", "pomplatform.payment.handler.FiveinsuranceSummaryHandler");
        //工资表导出
        DOWNLOADPROCESSORS.put("OnSalarySendData", "pomplatform.payment.handler.OnSalarySendDataHandler");
        QUERIES.put("OnSalarySendData", "pomplatform.payment.handler.OnSalarySendDataHandler");
        QUERIES.put("OnSalaryReportByEmployee", "pomplatform.payment.handler.OnSalaryReportByEmployeeHandler");
        QUERIES.put("OnSalaryReportByDepartment", "pomplatform.payment.handler.OnSalaryReportByDepartmentHandler");
        QUERIES.put("OnSalaryReportByPlate", "pomplatform.payment.handler.OnSalaryReportByPlateHandler");
        //工资总表导出
        DOWNLOADPROCESSORS.put("OnSalaryReportByCompany", "pomplatform.payment.handler.OnSalaryReportByCompanyHandler");
        DOWNLOADPROCESSORS.put("OnSalaryTotalData", "pomplatform.payment.handler.OnSalaryTotalDataHandler");
        QUERIES.put("OnSalaryReportByCompany", "pomplatform.payment.handler.OnSalaryReportByCompanyHandler");
        QUERIES.put("OnSalaryTotalData", "pomplatform.payment.handler.OnSalaryTotalDataHandler");
        QUERIES.put("SalaryOfFactBonus", "pomplatform.salary.handler.SalaryOfFactBonusHandler");
        QUERIES.put("SalaryOfOtherBonus", "pomplatform.salary.handler.SalaryOfOtherBonusHandler");
        QUERIES.put("SalaryOfShouldBonus", "pomplatform.salary.handler.SalaryOfShouldBonusHandler");
        QUERIES.put("OnInsteadDeductIllData", "pomplatform.payment.handler.OnInsteadDeductIllDataHandler");
        QUERIES.put("OnInsteadDeductData", "pomplatform.payment.handler.OnInsteadDeductDataHandler");
        QUERIES.put("EmployeeContractAttachment", "pomplatform.hr.handler.EmployeeContractAttachmentHandler");
        //采购申请
        WORKFLOWPROCESSORS.put("Purchase_apply", "pomplatform.workflow.personnelbusiness.handler.PurchaseApplyWorker");
        QUERIES.put("PurchaseApply", "pomplatform.workflow.personnelbusiness.handler.PurchaseApplyHandler");
        //物品申请
        WORKFLOWPROCESSORS.put("Goods_apply", "pomplatform.workflow.personnelbusiness.handler.GoodsApplyWorker");
        DAOS.put("PersonnelBusinesWithP", "pomplatform.workflow.personnelbusiness.handler.PersonnelBusinesWithPHandler");
        QUERIES.put("GoodsApply", "pomplatform.workflow.personnelbusiness.handler.GoodsApplyHandler");
        //确认函导出
        DOWNLOADPROCESSORS.put("Mcontractcacccccaaaraabbifiior", "pomplatform.attachment.handler.McontractcacccccaaaraabbifiiorHandler");
        QUERIES.put("OnLoadProjectEmployeePerformance", "pomplatform.project.handler.OnLoadProjectEmployeePerformanceHandler");
        //员工资金对冲
        PROCESSORS.put("CustomCapitalEquivalentNumberProcess", "pomplatform.employeemoneymanagespeemmepemmor.handler.CustomCapitalEquivalentNumberProcess");
        QUERIES.put("OnLoadSalaryTotalMonthData", "pomplatform.payment.handler.OnLoadSalaryTotalMonthDataHandler");
        UPLOADPROCESSORS.put("OnUploadAnnualBonus", "pomplatform.common.business.OnUploadAnnualBonus");
        //名片申请
        WORKFLOWPROCESSORS.put("Business_card_apply", "pomplatform.workflow.personnelbusiness.handler.BusinessCardApplyWorker");
        QUERIES.put("Business_card_apply", "pomplatform.workflow.personnelbusiness.handler.BusinessCardApplyHandler");
        //刻章申请
        WORKFLOWPROCESSORS.put("Stamp_carving_apply", "pomplatform.workflow.personnelbusiness.handler.StampCarvingApplyWorker");
        QUERIES.put("Stamp_carving_apply", "pomplatform.workflow.personnelbusiness.handler.StampCarvingApplyHandler");
        //用车申请
        //		WORKFLOWPROCESSORS.put("Cars_apply", "pomplatform.workflow.personnelbusiness.handler.CarsApplyWorker");
        //		QUERIES.put("Cars_apply", "pomplatform.workflow.personnelbusiness.handler.CarsApplyHandler");
        //员工绩效查询
        PROCESSORS.put("CustomEmployeePerformanceProcess", "pomplatform.salaryemployeeevaluationrmmor.handler.CustomEmployeePerformanceProcess");
        //绩效导出
        DOWNLOADPROCESSORS.put("Ssalaryemployeeperformancemmeor", "pomplatform.salaryemployeeevaluationrmmor.handler.SsalaryemployeeperformancemmeorHandler");
        QUERIES.put("Ssalaryemployeeperformancemmeor", "pomplatform.salaryemployeeevaluationrmmor.handler.SsalaryemployeeperformancemmeorHandler");
        QUERIES.put("OnLeaveSubsidysData", "pomplatform.payment.handler.OnLeaveSubsidysDataHandler");
        QUERIES.put("OnJobSubsidysData", "pomplatform.payment.handler.OnJobSubsidysDataHandler");
        QUERIES.put("OnFillSendDeductData", "pomplatform.payment.handler.OnFillSendDeductDataHandler");
        //上传补发补扣数据
        UPLOADPROCESSORS.put("OnUploadFillSendDeductData", "pomplatform.upload.OnUploadFillSendDeductData");
        //上传岗位补贴数据
        UPLOADPROCESSORS.put("OnUploadJobSubsidysData", "pomplatform.upload.OnUploadJobSubsidysData");
        //上传代扣款项数据
        UPLOADPROCESSORS.put("OnUploadInsteadDeductData", "pomplatform.upload.OnUploadInsteadDeductData");
        //上传绩效评定数据
        UPLOADPROCESSORS.put("OnUploadEmployeeEvaluationProcess", "pomplatform.salaryemployeeevaluationrmmor.handler.OnUploadEmployeeEvaluationProcess");
        QUERIES.put("Ssalaryemployeeevaluationrmmor", "pomplatform.salaryemployeeevaluationrmmor.handler.SsalaryemployeeevaluationrmmorHandler");
        QUERIES.put("SelectEmployee", "pomplatform.employee.handler.SelectEmployeeHandler");
        QUERIES.put("GetDepartmentIdByRoleId", "pomplatform.employee.handler.GetDepartmentIdByRoleIdHandler");
        PROCESSORS.put("OnLoadMemployeeData", "pomplatform.common.business.OnLoadMemployeeData");
        UPLOADPROCESSORS.put("OnUploadBonusProcess", "pomplatform.common.business.OnUploadBonusProcess");
        QUERIES.put("SalaryOfWorkYears", "pomplatform.salary.handler.SalaryOfWorkYearsHandler");
        QUERIES.put("GetProcessComment", "pomplatform.workflow.personnelbusiness.handler.GetProcessCommentHandler");
        QUERIES.put("CheckWorkHandover", "pomplatform.workflow.personnelbusiness.handler.CheckWorkHandoverHandler");
        DOWNLOADPROCESSORS.put("OnDownloadEmployeeInfo", "pomplatform.employee.business.OnDownloadEmployeeInfo");
        //修改员工座机同步至企业微信与企业邮箱
        PROCESSORS.put("CustomSemployeeProcess", "pomplatform.employeenew.handler.CustomSemployeeProcess");
        //收款阶段模板
        PROCESSORS.put("CustomReceivableTemplateProcess", "pomplatform.scontractreceivabletemplaterrcor.handler.CustomReceivableTemplateProcess");
        QUERIES.put("Scontractreceivabletemplaterrcor", "pomplatform.scontractreceivabletemplaterrcor.handler.ScontractreceivabletemplaterrcorHandler");
        PROCESSORS.put("OnEmployeeInfoEdit", "pomplatform.workflow.personnelbusiness.business.OnEmployeeInfoEdit");
        QUERIES.put("GetPersonnelProcessId", "pomplatform.check.handler.GetPersonnelProcessIdHandler");
        QUERIES.put("AttendanceManagementStatistics", "pomplatform.check.handler.AttendanceManagementStatisticsHandler");
        QUERIES.put("AttendanceManagementStatisticsStatus", "pomplatform.checking.handler.AttendanceManagementStatisticsStatusHandler");
        QUERIES.put("AttendanceManagementPersonNum", "pomplatform.checking.handler.AttendanceManagementPersonNumHandler");
        //调薪申请
        WORKFLOWPROCESSORS.put("Salary_adjustment_apply", "pomplatform.workflow.personnelbusiness.handler.SalaryAdjustmentApplyWorker");
        QUERIES.put("SalaryAdjustmentApply", "pomplatform.workflow.personnelbusiness.handler.SalaryAdjustmentApplyHandler");
        //员工转正申请
        WORKFLOWPROCESSORS.put("Regular_employee_apply", "pomplatform.workflow.personnelbusiness.handler.RegularEmployeeApplyWorker");
        QUERIES.put("RegularEmployeeApply", "pomplatform.workflow.personnelbusiness.handler.RegularEmployeeApplyHandler");
        QUERIES.put("Sprojectsettlementpor", "pomplatform.operation.handler.SprojectsettlementporHandler");
        QUERIES.put("MakeFileNumber", "pomplatform.workflow.personnelbusiness.handler.MakeFileNumberHandler");
        QUERIES.put("OnLoadInAchieveDetail", "pomplatform.project.handler.OnLoadInAchieveDetailHandler");
        DOWNLOADPROCESSORS.put("OnLoadInAchieveDetail", "pomplatform.project.handler.OnLoadInAchieveDetailHandler");
        QUERIES.put("OnLoadOutAchieveSure", "pomplatform.project.handler.OnLoadOutAchieveSureHandler");
        DOWNLOADPROCESSORS.put("OnLoadOutAchieveSure", "pomplatform.project.handler.OnLoadOutAchieveSureHandler");
        QUERIES.put("AttendanceRecord", "pomplatform.shift.handler.AttendanceRecordHandler");
        QUERIES.put("ContractManage", "pomplatform.contract.handler.ContractManageHandler");
        //收款单位还款申请
        WORKFLOWPROCESSORS.put("Receive_unit_apply", "pomplatform.workflow.personnelbusiness.handler.ReceiveUnitRepaymentWorker");
        //员工还款申请
        WORKFLOWPROCESSORS.put("Employee_repayment_apply", "pomplatform.workflow.personnelbusiness.handler.EmployeeRepaymentWorker");
        QUERIES.put("Swebsitenewntfor", "pomplatform.websitenews.handler.SwebsitenewntforHandler");
        QUERIES.put("OnLoadPerformanceIntegralOfEmployee", "pomplatform.account.handler.OnLoadPerformanceIntegralOfEmployeeHandler");
        QUERIES.put("MyAttendanceDetail", "pomplatform.checking.handler.MyAttendanceDetailHandler");
        QUERIES.put("OnLoadUnitFundAndInsurance", "pomplatform.payment.handler.OnLoadUnitFundAndInsuranceHandler");
        QUERIES.put("OnLoadEmpWordDayOfMonth", "pomplatform.payment.handler.OnLoadEmpWordDayOfMonthHandler");
        QUERIES.put("OnLoadEmployeePayment", "pomplatform.payment.handler.OnLoadEmployeePaymentHandler");
        //转岗申请
        WORKFLOWPROCESSORS.put("Apply_for_transfer", "pomplatform.workflow.personnelbusiness.handler.ApplyForTransferWorker");
        PROCESSORS.put("OnHrManageProcess", "pomplatform.hr.business.OnHrManageProcess");
        DOWNLOADPROCESSORS.put("OnHrManageProcess", "pomplatform.hr.business.OnHrManageProcess");
        //上传五险一金数据
        UPLOADPROCESSORS.put("OnUploadEmpFiveInsuranceOneGold", "pomplatform.upload.OnUploadEmpFiveInsuranceOneGold");
        QUERIES.put("PreProjectNormalRemarkAndAmount", "pomplatform.reimbursement.handler.PreProjectNormalRemarkAndAmountHandler");
        PROCESSORS.put("OnPaymentManageProcess", "pomplatform.payment.business.OnPaymentManageProcess");
        QUERIES.put("OnLoadFinishStagePercent", "pomplatform.project.handler.OnLoadFinishStagePercentHandler");
        DAOS.put("CustomReceiveUnitManage", "com.pomplatform.db.handler.CustomReceiveUnitManageHandler");
        //离职流程
        WORKFLOWPROCESSORS.put("Resignation_apply", "pomplatform.workflow.personnelbusiness.handler.ResignationApplyWorker");
        QUERIES.put("ResignationApply", "pomplatform.workflow.personnelbusiness.handler.ResignationApplyHandler");
        QUERIES.put("EmployeeRealtimeChecking", "pomplatform.checking.handler.EmployeeRealtimeCheckingHandler");
        QUERIES.put("ReceiveUnitK3Code", "pomplatform.k3code.handler.ReceiveUnitK3CodeHandler");
        QUERIES.put("SubjectTypeK3Code", "pomplatform.k3code.handler.SubjectTypeK3CodeHandler");
        QUERIES.put("OnLoadEmployeeCheckDetail", "pomplatform.shift.handler.OnLoadEmployeeCheckDetailHandler");
        PROCESSORS.put("OnEmployeeContractAttachment", "pomplatform.hr.business.OnEmployeeContractAttachment");
        QUERIES.put("DepartmentIdFindPlate", "pomplatform.workflow.personnelbusiness.handler.DepartmentIdFindPlateHandler");
        //确认函管理  --开始
        QUERIES.put("Mcontractcacccccaaaraabbifiior", "pomplatform.attachment.handler.McontractcacccccaaaraabbifiiorHandler");
        PROCESSORS.put("CustomAttachmentWorkProcess", "pomplatform.attachment.handler.CustomAttachmentWorkProcess");
        //确认函管理 --结束
        DOWNLOADPROCESSORS.put("OnLoadEmployeeMonthCheck", "pomplatform.shift.handler.OnLoadEmployeeMonthCheckHandler");
        //财务资金报表 -- 开始
        PROCESSORS.put("FinancicalCapitalAnalysis", "pomplatform.financialStatements.handler.FinancicalCapitalAnalysisProcess");
        QUERIES.put("Scapitalipcor", "pomplatform.financialStatements.handler.ScapitalipcorHandler");
        QUERIES.put("FinancialInternalPayment", "pomplatform.financialStatements.handler.FinancialInternalPaymentHandler");
        QUERIES.put("FinancialCapitals", "pomplatform.financialStatements.handler.FinancialCapitalsHandler");
        QUERIES.put("FinancialCompanyBalance", "pomplatform.financialStatements.handler.FinancialCompanyBalanceHandler");
        QUERIES.put("FinancialEmpAndPayMoney", "pomplatform.financialStatements.handler.FinancialEmpAndPayMoneyHandler");
        QUERIES.put("FinancialSubjectMoney", "pomplatform.financialStatements.handler.FinancialSubjectMoneyHandler");
        QUERIES.put("FinancialContractMoney", "pomplatform.financialStatements.handler.FinancialContractMoneyHandler");
        QUERIES.put("FinancialBankAccountInternalPayment", "pomplatform.financialStatements.handler.FinancialBankAccountInternalPaymentHandler");
        QUERIES.put("FinancialBankAccountBalance", "pomplatform.financialStatements.handler.FinancialBankAccountBalanceHandler");
        QUERIES.put("FinancialBankAccountReceivables", "pomplatform.financialStatements.handler.FinancialBankAccountReceivablesHandler");
        QUERIES.put("FinancialBankAccountPayment", "pomplatform.financialStatements.handler.FinancialBankAccountPaymentHandler");
        //财务资金报表 -- 结束
        QUERIES.put("Sk3codetpor", "pomplatform.k3code.handler.Sk3codetporHandler");
        QUERIES.put("AllCardManage", "pomplatform.k3code.handler.AllCardManageHandler");
        QUERIES.put("BankAccountK3Code", "pomplatform.k3code.handler.BankAccountK3CodeHandler");
        QUERIES.put("EmployeeK3Code", "pomplatform.k3code.handler.EmployeeK3CodeHandler");
        DOWNLOADPROCESSORS.put("K3VoucherList", "pomplatform.reimbursement.handler.K3VoucherListHandler");
        DOWNLOADPROCESSORS.put("K3VoucherList_ini", "pomplatform.reimbursement.handler.K3VoucherListIniHandler");
        QUERIES.put("CompanyK3Code", "pomplatform.k3code.handler.CompanyK3CodeHandler");
        QUERIES.put("K3VoucherSummary", "pomplatform.reimbursement.handler.K3VoucherSummaryHandler");
        QUERIES.put("OnLoadProjectChangeEmployee", "pomplatform.project.handler.OnLoadProjectChangeEmployeeHandler");
        QUERIES.put("OnLoadProjectChangeList", "pomplatform.project.handler.OnLoadProjectChangeListHandler");
        QUERIES.put("SelectGridMyProjectValue", "pomplatform.selectgrid.handler.SelectGridMyProjectValueHandler");
        QUERIES.put("EmployeeFaces", "pomplatform.clocks.handler.EmployeeFacesHandler");
        QUERIES.put("ClockRecevieCmds", "pomplatform.clocks.handler.ClockRecevieCmdsHandler");
        QUERIES.put("Reimbursementpackagemmror",
                "pomplatform.reimbursement.handler.ReimbursementpackagemmrorHandler");
        PROCESSORS.put("K3VoucherProcess", "pomplatform.reimbursement.business.K3VoucherProcess");
        QUERIES.put("K3VoucherList", "pomplatform.reimbursement.handler.K3VoucherListHandler");
        QUERIES.put("CommonNormalRemarkAndAmount", "pomplatform.reimbursement.handler.CommonNormalRemarkAndAmountHandler");
        QUERIES.put("ProjectNormalRemarkAndAmount", "pomplatform.reimbursement.handler.ProjectNormalRemarkAndAmountHandler");
        QUERIES.put("projectNormalRemarkAndAmount", "pomplatform.reimbursement.handler.projectNormalRemarkAndAmountHandler");
        QUERIES.put("PreProjectTravelRemarkAndAmount", "pomplatform.reimbursement.handler.PreProjectTravelRemarkAndAmountHandler");
        QUERIES.put("CommonTravelRemarkAndAmount", "pomplatform.reimbursement.handler.CommonTravelRemarkAndAmountHandler");
        QUERIES.put("ProjectTravelRemarkAndAmount", "pomplatform.reimbursement.handler.ProjectTravelRemarkAndAmountHandler");
        QUERIES.put("BorrowMoneyRemarkAndAmount", "pomplatform.reimbursement.handler.BorrowMoneyRemarkAndAmountHandler");
        QUERIES.put("PayMoneyRemarkAndAmount", "pomplatform.reimbursement.handler.PayMoneyRemarkAndAmountHandler");
        QUERIES.put("SelectGridEmployeeInDepartment", "pomplatform.selectgrid.handler.SelectGridEmployeeInDepartmentHandler");
        PROCESSORS.put("ClockMsgProcess", "pomplatform.clocks.business.ClockMsgProcess");
        QUERIES.put("Awaitingapproval", "pomplatform.awaitingapproval.handler.AwaitingapprovalHandler");
        QUERIES.put("getEmployeeByRoleIdAndDepartmentId", "pomplatform.getEmployeeIdByRoleId.handler.getEmployeeByRoleIdAndDepartmentIdHandler");
        QUERIES.put("EmployeeFingers", "pomplatform.clocks.handler.EmployeeFingersHandler");
        QUERIES.put("ClockList", "pomplatform.clocks.handler.ClockListHandler");
        PROCESSORS.put("ProjectPerformanceProcess", "pomplatform.projectperformance.business.ProjectPerformanceProcess");
        QUERIES.put("ProjectPerformanceDetail", "pomplatform.projectperformance.handler.ProjectPerformanceDetailHandler");
        QUERIES.put("FindProjectInfoByContractId", "pomplatform.projectperformance.handler.FindProjectInfoByContractIdHandler");
        QUERIES.put("OnLoadMonthDetailOfAccount", "pomplatform.account.handler.OnLoadMonthDetailOfAccountHandler");
        QUERIES.put("OnLoadMonthDataOfAccount", "pomplatform.account.handler.OnLoadMonthDataOfAccountHandler");
        QUERIES.put("OnLoadLeftIntegralOfAccount", "pomplatform.account.handler.OnLoadLeftIntegralOfAccountHandler");
        QUERIES.put("OnLoadBusinessTypeDataOfAccount", "pomplatform.account.handler.OnLoadBusinessTypeDataOfAccountHandler");
        QUERIES.put("Mcontracticcccsprfiiibaadicrbbior", "pomplatform.minvocieapplydedaocor.handler.McontracticcccsprfiiibaadicrbbiorHandler");
        QUERIES.put("MakeEmployeeNo", "pomplatform.workflow.personnelbusiness.handler.MakeEmployeeNoHandler");
        DAOS.put("EmployeeWithEeeee", "pomplatform.workflow.personnelbusiness.handler.EmployeeWithEeeeeHandler");
        //入职申请
        WORKFLOWPROCESSORS.put("Employee_onboard_apply", "pomplatform.workflow.personnelbusiness.handler.EmployeeOnboardInformationWorker");
        QUERIES.put("EmployeeOnboardInformation", "pomplatform.workflow.personnelbusiness.handler.EmployeeOnboardInformationHandler");
        QUERIES.put("EmployeeWithEeeee", "pomplatform.workflow.personnelbusiness.handler.EmployeeWithEeeeeHandler");
        UPLOADPROCESSORS.put("OnCommonUploadFileProcess",
                "pomplatform.common.business.OnCommonUploadFileProcess");
        //合同下拉GRID选择
        QUERIES.put("SelectGridContractValue", "pomplatform.selectgrid.handler.SelectGridContractValueHandler");
        QUERIES.put("Mprojectccpor", "pomplatform.attachment.handler.MprojectccporHandler");
        //确认函申请
        WORKFLOWPROCESSORS.put("Attachment_apply", "pomplatform.workflow.personnelbusiness.handler.AttachmentApplyWorker");
        //确认函流程 子表关联查询
        QUERIES.put("OnAttachmentLinkInvoices", "pomplatform.attachment.handler.OnAttachmentLinkInvoicesHandler");
        QUERIES.put("OnAttachmentLinkInvoiceApplys", "pomplatform.attachment.handler.OnAttachmentLinkInvoiceApplysHandler");
        QUERIES.put("OnAttachmentLinkContractReceivables", "pomplatform.attachment.handler.OnAttachmentLinkContractReceivablesHandler");
        //人员积分调整计算
        PROCESSORS.put("CustomIntegralAnalysisProcess", "pomplatform.attachment.handler.CustomIntegralAnalysisProcess");
        QUERIES.put("ContractChangeList", "pomplatform.contractchange.handler.ContractChangeListHandler");
        PROCESSORS.put("ContractChangeProcess", "pomplatform.contractchange.business.ContractChangeProcess");
        QUERIES.put("ProjectChangeRecord", "pomplatform.contractchange.handler.ProjectChangeRecordHandler");
        QUERIES.put("ChangeProjectInfo", "pomplatform.contractchange.handler.ChangeProjectInfoHandler");
        QUERIES.put("ProjectBasicInfo", "pomplatform.contractchange.handler.ProjectBasicInfoHandler");
        QUERIES.put("ChangeContractInfo", "pomplatform.contractchange.handler.ChangeContractInfoHandler");
        QUERIES.put("Sattachmentmanageaaaor", "pomplatform.attachment.handler.SattachmentmanageaaaorHandler");
        DOWNLOADPROCESSORS.put("OnLoadAttachmentDataOfAttachment", "pomplatform.attachment.handler.OnLoadAttachmentDataOfAttachmentHandler");
        QUERIES.put("OnLoadAttachmentDataOfAttachment", "pomplatform.attachment.handler.OnLoadAttachmentDataOfAttachmentHandler");
        QUERIES.put("TaskOfEmployeeOnboard", "pomplatform.workflow.personnel.handler.TaskOfEmployeeOnboardHandler");
        QUERIES.put("AuditListOfEmployeeOnboard", "pomplatform.workflow.personnel.handler.AuditListOfEmployeeOnboardHandler");
        QUERIES.put("RefuseOfEmployeeOnboard", "pomplatform.workflow.personnel.handler.RefuseOfEmployeeOnboardHandler");
        QUERIES.put("AttentionOfEmployeeOnboard", "pomplatform.workflow.personnel.handler.AttentionOfEmployeeOnboardHandler");
        QUERIES.put("AuditOfEmployeeOnboard", "pomplatform.workflow.personnel.handler.AuditOfEmployeeOnboardHandler");
        QUERIES.put("ApplyOfEmployeeOnboard", "pomplatform.workflow.personnel.handler.ApplyOfEmployeeOnboardHandler");
        //合同与订单关联/解绑
        PROCESSORS.put("CustomSprojectpcorProcess", "pomplatform.contractppspcccfscsiiicpor.handler.CustomSprojectpcorProcess");
        QUERIES.put("Sprojectpcor", "pomplatform.contractppspcccfscsiiicpor.handler.SprojectpcorHandler");
        QUERIES.put("Memployeeaccountrecordespemmor", "pomplatform.capitalDsitributionemployee.handler.MemployeeaccountrecordespemmorHandler");
        QUERIES.put("CapitalDsitributionemployee", "pomplatform.capitalDsitributionemployee.handler.CapitalDsitributionemployeeHandler");
        QUERIES.put("Memployeeaccountrecordeeppccmmpebor", "pomplatform.employeeaccountrecordeeppccmmpebor.handler.MemployeeaccountrecordeeppccmmpeborHandler");
        QUERIES.put("PersonalLeaveType", "pomplatform.leavetype.handler.PersonalLeaveTypeHandler");
        QUERIES.put("GetOvertimeApplyHours", "pomplatform.workflow.personnelbusiness.handler.GetOvertimeApplyHoursHandler");
        QUERIES.put("SearchLeaveTypes", "pomplatform.leavetype.handler.SearchLeaveTypesHandler");
        QUERIES.put("LinkOfLeaveTypeAndArea", "pomplatform.leavetype.handler.LinkOfLeaveTypeAndAreaHandler");
        QUERIES.put("LeaveTypeLinkProvinceDetail", "pomplatform.leavetype.handler.LeaveTypeLinkProvinceDetailHandler");
        //查询某段时间内未被驳回的事假的天数和小时数
        QUERIES.put("QueryLeaveApplyDays", "pomplatform.workflow.personnelbusiness.handler.QueryLeaveApplyDaysHandler");
        QUERIES.put("OnLoadPlateDataOfAccount", "pomplatform.account.handler.OnLoadPlateDataOfAccountHandler");
        QUERIES.put("OnLoadAuditListOfPersonnel", "pomplatform.workflow.personnel.handler.OnLoadAuditListOfPersonnelHandler");
        //我的人事上传附件
        UPLOADPROCESSORS.put("UploadPersonnelBusinessAttachments",
                "pomplatform.common.business.OnUploadPersonnelBusinessAttachments");
        QUERIES.put("GetShiftInfoByEmployeeId", "pomplatform.shift.handler.GetShiftInfoByEmployeeIdHandler");
        PROCESSORS.put("MyPersonnelProcessor", "pomplatform.workflow.personnelbusiness.business.MyPersonnelProcessor");

        //请假申请
        WORKFLOWPROCESSORS.put("Leave_apply", "pomplatform.workflow.personnelbusiness.handler.LeaveApplyWorker");
        QUERIES.put("LeaveApply", "pomplatform.workflow.personnelbusiness.handler.LeaveApplyHandler");
        //项目派驻申请
        WORKFLOWPROCESSORS.put("Project_accredit_apply", "pomplatform.workflow.personnelbusiness.handler.SpersonnelbusinespporWorker");
        //延期项目派驻申请
        WORKFLOWPROCESSORS.put("Delay_project_accredit_apply", "pomplatform.workflow.personnelbusiness.handler.SpersonnelbusinespporWorker");
        //确认派驻结束 申请加班日期
        WORKFLOWPROCESSORS.put("Confirm_project_accredit_apply", "pomplatform.workflow.personnelbusiness.handler.SpersonnelbusinespporWorker");

        QUERIES.put("Spersonnelbusinesppor", "pomplatform.workflow.personnelbusiness.handler.SpersonnelbusinespporHandler");
        //收款单位查询下拉GRID数据
        QUERIES.put("SelectGridReceiveUnitValue", "pomplatform.selectgrid.handler.SelectGridReceiveUnitValueHandler");
        QUERIES.put("OnLoadIntegralAdvanceOfAccount", "pomplatform.account.handler.OnLoadIntegralAdvanceOfAccountHandler");
        QUERIES.put("SelectGridPreProjectValue", "pomplatform.selectgrid.handler.SelectGridPreProjectValueHandler");
        QUERIES.put("SelectGridProjectValue", "pomplatform.selectgrid.handler.SelectGridProjectValueHandler");
        QUERIES.put("OnLoadIntegralReturnOfAccount", "pomplatform.account.handler.OnLoadIntegralReturnOfAccountHandler");
        //订单回款汇总
        DOWNLOADPROCESSORS.put("Mprojectcspppcpdcor", "pomplatform.employeemoneymanagespeemmepemmor.handler.MprojectcspppcpdcorHandler");
        QUERIES.put("Mprojectcspppcpdcor", "pomplatform.employeemoneymanagespeemmepemmor.handler.MprojectcspppcpdcorHandler");
        QUERIES.put("CapitalprojectSearch", "pomplatform.employeemoneymanagespeemmepemmor.handler.CapitalprojectSearchHandler");
        QUERIES.put("Mcapitaldistributionlinksubcontractpcor", "pomplatform.employeemoneymanagespeemmepemmor.handler.McapitaldistributionlinksubcontractpcorHandler");
        QUERIES.put("Mcapitaldistributionlinkdepartmentdcor", "pomplatform.employeemoneymanagespeemmepemmor.handler.McapitaldistributionlinkdepartmentdcorHandler");
        QUERIES.put("OnGetBenefitsOfEmployee", "pomplatform.account.handler.OnGetBenefitsOfEmployeeHandler");
        QUERIES.put("OnGetLeftIntegralOfEmployee", "pomplatform.account.handler.OnGetLeftIntegralOfEmployeeHandler");
        QUERIES.put("OnGetLeftIntegralOfPlate", "pomplatform.account.handler.OnGetLeftIntegralOfPlateHandler");
        QUERIES.put("OnloadPlateSalaryAdvanceInfo", "pomplatform.account.handler.OnloadPlateSalaryAdvanceInfoHandler");
        QUERIES.put("EmployeecheckinPerson", "pomplatform.checking.handler.EmployeecheckinPersonHandler");
        QUERIES.put("EmployeeShouldCheckinPersonNum", "pomplatform.checking.handler.EmployeeShouldCheckinPersonNumHandler");
        QUERIES.put("EmployeeCaptionInfoSearch", "pomplatform.employeemoneymanagespeemmepemmor.handler.EmployeeCaptionInfoSearchHandler");
        QUERIES.put("Memployeemoneymanagespeemmepemmor", "pomplatform.employeemoneymanagespeemmepemmor.handler.MemployeemoneymanagespeemmepemmorHandler");
        QUERIES.put("OnLoadEmpShiftInfo", "pomplatform.shift.handler.OnLoadEmpShiftInfoHandler");
        //用于做下拉GRID  员工数据的查询
        QUERIES.put("SelectGridEmployeeValue", "pomplatform.selectGridEmployeeValue.handler.SelectGridEmployeeValueHandler");

        //用于做下拉GRID  员工数据的查询,排除离职的人员
        QUERIES.put("SelectGridEmployeeValues", "pomplatform.workflow.handler.SelectGridEmployeeValuesHandler");
        //预付款申请已审批页面
        QUERIES.put("AuditedPayMoney", "pomplatform.workflow.handler.AuditedPayMoneyHandler");
        //借款申请已审批页面
        QUERIES.put("AuditedEmployeeBorrowMoney", "pomplatform.workflow.handler.AuditedEmployeeBorrowMoneyHandler");
        //差旅报销已审批页面
        QUERIES.put("AuditedTravelReimbursement", "pomplatform.workflow.handler.AuditedTravelReimbursementHandler");
        //普通报销已审批页面
        QUERIES.put("AuditedNormalReimbursement", "pomplatform.workflow.handler.AuditedNormalReimbursementHandler");
        //我的人事已审批页面
        QUERIES.put("MyAuditListOfPersonnel", "pomplatform.workflow.personnel.handler.MyAuditListOfPersonnelHandler");
        QUERIES.put("ShiftmanageDetail", "pomplatform.shift.handler.ShiftmanageDetailHandler");
        QUERIES.put("Sshiftmanagesor", "pomplatform.shift.handler.SshiftmanagesorHandler");
        DAOS.put("CustomEmployeeWithRole", "pomplatform.employee.handler.CustomEmployeeWithRoleHandler");
        QUERIES.put("OnCheckEmployeeShiftOfShift", "pomplatform.shift.handler.OnCheckEmployeeShiftOfShiftHandler");
        QUERIES.put("OnLoadEmployeeShiftDetailOfShift", "pomplatform.shift.handler.OnLoadEmployeeShiftDetailOfShiftHandler");
        QUERIES.put("OnLoadEmployeeShiftOfShift", "pomplatform.shift.handler.OnLoadEmployeeShiftOfShiftHandler");
        QUERIES.put("ManageShiftTime", "pomplatform.shift.handler.ManageShiftTimeHandler");
        //通过职员ID来获取他参与的所有项目的项目经理
        QUERIES.put("GetProjectManagersByEmployeeId", "pomplatform.role.handler.GetProjectManagersByEmployeeIdHandler");
        PROCESSORS.put("OnShiftManageProcess", "pomplatform.shift.business.OnShiftManageProcess");
        //我的人事的驳回和已完成的查询
        QUERIES.put("OnLoadRefuseListOfPersonnel", "pomplatform.workflow.personnel.handler.OnLoadRefuseListOfPersonnelHandler");
        //报销入账指定 (查询出所有完成的报销单)
        QUERIES.put("MfinancialAccounting", "pomplatform.financialAccounting.handler.MfinancialAccountingHandler");
        DOWNLOADPROCESSORS.put("MfinancialAccounting", "pomplatform.financialAccounting.handler.MfinancialAccountingHandler");
        //资金对账
        PROCESSORS.put("CustomMcapitalReconciliation", "pomplatform.mcapitalcmmssmssbor.handler.CustomMcapitalReconciliationProcess");
        //查询用户某段时间内没有被驳回的打卡申请数量
        QUERIES.put("FillcheckApplyTimes", "pomplatform.workflow.personnelbusiness.handler.FillcheckApplyTimesHandler");
        QUERIES.put("Stracktalentsminimumarrangementmmpor", "pomplatform.project.handler.StracktalentsminimumarrangementmmporHandler");
        QUERIES.put("OnLoadTaskListOfPersonnel", "pomplatform.workflow.personnel.handler.OnLoadTaskListOfPersonnelHandler");
        QUERIES.put("OnLoadAttentionListOfPersonnel", "pomplatform.workflow.personnel.handler.OnLoadAttentionListOfPersonnelHandler");
        QUERIES.put("OnLoadApplyListOfPersonnel", "pomplatform.workflow.personnel.handler.OnLoadApplyListOfPersonnelHandler");
        //加班申请
        WORKFLOWPROCESSORS.put("Overtime_apply", "pomplatform.workflow.personnelbusiness.handler.OvertimeApplyWorker");
        QUERIES.put("OvertimeApply", "pomplatform.workflow.personnelbusiness.handler.OvertimeApplyHandler");
        //外出申请
        WORKFLOWPROCESSORS.put("Stayaway_apply", "pomplatform.workflow.personnelbusiness.handler.StayawayApplyWorker");
        QUERIES.put("StayawayApply", "pomplatform.workflow.personnelbusiness.handler.StayawayApplyHandler");
        //打卡申请
        WORKFLOWPROCESSORS.put("Fillcheck_apply", "pomplatform.workflow.personnelbusiness.handler.FillcheckApplyWorker");
        QUERIES.put("FillcheckApply", "pomplatform.workflow.personnelbusiness.handler.FillcheckApplyHandler");
        //非项目出差申请
        WORKFLOWPROCESSORS.put("Business_trip_apply", "pomplatform.workflow.personnelbusiness.handler.BusinessTripApplyWorker");
        //项目出差申请
        WORKFLOWPROCESSORS.put("Business_project_trip_apply", "pomplatform.workflow.personnelbusiness.handler.BusinessTripApplyWorker");
        //出差延期申请
        WORKFLOWPROCESSORS.put("Delay_business_project_trip_apply", "pomplatform.workflow.personnelbusiness.handler.BusinessTripApplyWorker");
        //出差变更行程申请
        WORKFLOWPROCESSORS.put("Change_travel_business_project_trip_apply", "pomplatform.workflow.personnelbusiness.handler.BusinessTripApplyWorker");
        PROCESSORS.put("CustomPersonnelBusinessProcess", "pomplatform.workflow.personnelbusiness.handler.CustomPersonnelBusinessProcess");
        QUERIES.put("BusinessTripApply", "pomplatform.workflow.personnelbusiness.handler.BusinessTripApplyHandler");
        QUERIES.put("OnLoadPersonnelFlowDetail", "pomplatform.workflow.handler.OnLoadPersonnelFlowDetailHandler");
        //查询知会的回款分配流程
        QUERIES.put("CapitalDistributionsAttentionOfWorkflow", "pomplatform.scapitaldistributionor.handler.CapitalDistributionsAttentionOfWorkflowHandler");
        //查询线程池待的回款分配流程
        QUERIES.put("CapitalDistributionsPoolOfWorkflow", "pomplatform.scapitaldistributionor.handler.CapitalDistributionsPoolOfWorkflowHandler");
        //查询已审批与待审批的回款分配流程
        QUERIES.put("CapitalDistributionsAuditOfWorkflow", "pomplatform.scapitaldistributionor.handler.CapitalDistributionsAuditOfWorkflowHandler");
        PROCESSORS.put("CustomCapitalDistributionProcess", "pomplatform.scapitaldistributionor.handler.CustomCapitalDistributionProcess");
        //查询申请回款分配流程
        QUERIES.put("CapitalDistributionsApplyOfWorkflow", "pomplatform.scapitaldistributionor.handler.CapitalDistributionsApplyOfWorkflowHandler");
        DAOS.put("CapitalDistributionWithCc", "pomplatform.scapitaldistributionor.handler.CapitalDistributionWithCcHandler");
        //回款分配
        WORKFLOWPROCESSORS.put("Capital_distribution", "pomplatform.scapitaldistributionor.handler.ScapitaldistributionorWorker");
        QUERIES.put("Scapitaldistributionor", "pomplatform.scapitaldistributionor.handler.ScapitaldistributionorHandler");
        //通过职员ID来查找该职员可以使用的流程ID
        QUERIES.put("SearchProcessIdByUserId", "pomplatform.workflow.handler.SearchProcessIdByUserIdHandler");
        QUERIES.put("OnLoadOtherProjectDetailOfPlateAccount", "pomplatform.account.handler.OnLoadOtherProjectDetailOfPlateAccountHandler");
        //保存公司补贴数据，并同步数据到部门账户记录表
        PROCESSORS.put("PlateIntegralSendProcessor", "pomplatform.plateIntegralSendRecord.business.PlateIntegralSendProcessor");
        QUERIES.put("OnDevelopProject", "pomplatform.project.handler.OnDevelopProjectHandler");
        //导出详细数据
        DOWNLOADPROCESSORS.put("Scapitalssmor", "pomplatform.mcapitalcmmssmssbor.handler.ScapitalssmorHandler");
        //资金详细流水 包括余额
        QUERIES.put("Scapitalssmor", "pomplatform.mcapitalcmmssmssbor.handler.ScapitalssmorHandler");
        //资金按账号统计数据
        QUERIES.put("Mcapitalcmmssmssbor", "pomplatform.mcapitalcmmssmssbor.handler.McapitalcmmssmssborHandler");
        QUERIES.put("CompanyRepayment", "pomplatform.CompanyRepayment.handler.CompanyRepaymentHandler");
        QUERIES.put("Mcompanyintegralrecordpor", "pomplatform.CompanyRepayment.handler.McompanyintegralrecordporHandler");
        QUERIES.put("OnLoadCommonTwoDetailOfPlateAccount", "pomplatform.account.handler.OnLoadCommonTwoDetailOfPlateAccountHandler");
        QUERIES.put("OnLoadCommonOneDetailOfPlateAccount", "pomplatform.account.handler.OnLoadCommonOneDetailOfPlateAccountHandler");
        QUERIES.put("OnLoadBonusAdvanceDetailOfPlateAccount", "pomplatform.account.handler.OnLoadBonusAdvanceDetailOfPlateAccountHandler");
        QUERIES.put("OnLoadProjectAdvanceDetailOfPlateAccount", "pomplatform.account.handler.OnLoadProjectAdvanceDetailOfPlateAccountHandler");
        QUERIES.put("OnLoadProjectSettlementDetailOfPlateAccount", "pomplatform.account.handler.OnLoadProjectSettlementDetailOfPlateAccountHandler");
        QUERIES.put("OnLoadMonthStatisticOfPlateAccount", "pomplatform.account.handler.OnLoadMonthStatisticOfPlateAccountHandler");
        //部门成本按月汇总明细项展示
        QUERIES.put("PlateCostMonthlyDetail", "pomplatform.plateCostRecord.handler.PlateCostMonthlyDetailHandler");
        //部门成本按月汇总
        QUERIES.put("PlateCostMonthly", "pomplatform.plateCostRecord.handler.PlateCostMonthlyHandler");
        //查询员工借款数据
        QUERIES.put("Memployeemoneymanageeeedcieftrcvmmor", "pomplatform.spaymoneymanagemmcor.handler.MemployeemoneymanageeeedcieftrcvmmorHandler");
        //查询单位预付款数据
        QUERIES.put("Spaymoneymanagemmcor", "pomplatform.spaymoneymanagemmcor.handler.SpaymoneymanagemmcorHandler");
        //流程结束之后，获取冲账数据，用以记录
        QUERIES.put("StrikeABalance", "pomplatform.plateCostRecord.handler.StrikeABalanceHandler");
        //流程结束之后，获取成本数据，关联到部门或者项目
        QUERIES.put("ReimbursementCost", "pomplatform.plateCostRecord.handler.ReimbursementCostHandler");
        //财务入账日期指定
        PROCESSORS.put("CustomMfinancialAccountingProcess", "pomplatform.financialAccounting.handler.CustomMfinancialAccountingProcess");
        //报销汇总补全导出（报销汇总的收款信息补全页面只是临时时候，等数据补全之后就弃用删除）
        DOWNLOADPROCESSORS.put("ReimbursementInfoDownload", "pomplatform.reimbursementinfo.business.ReimbursementInfoDownloadProcessor");
        QUERIES.put("IntegralReturnOfPlate", "pomplatform.IntegralReturnOfPlate.handler.IntegralReturnOfPlateHandler");
        QUERIES.put("Employee", "pomplatform.IntegralReturnOfPlate.handler.EmployeeHandler");
        //财务打包汇总查询出所有报销单(财务经理通过且正在运行中的报销)
        QUERIES.put("MnewReimbursementPackagepecdcbor",
                "pomplatform.reimbursementpackage.handler.MnewReimbursementPackagepecdcborHandler");
        QUERIES.put("Mcapitalsubcontractscoor",
                "pomplatform.mcapitalsubcontractscoor.handler.McapitalsubcontractscoorHandler");
        QUERIES.put("Ssubcontractsspor", "pomplatform.ssubcontractsspor.handler.SsubcontractssporHandler");
        DOWNLOADPROCESSORS.put("AccountManageProcess", "pomplatform.account.business.AccountManageProcess");
        DOWNLOADPROCESSORS.put("RevenueStatisticalOfRevenue",
                "pomplatform.revenueStatistical.handler.CustomRevenueStatisticalOfRevenueHandler");
        QUERIES.put("ProjectSubsidyDetail", "pomplatform.account.handler.ProjectSubsidyDetailHandler");
        QUERIES.put("BonusSubsidyDetail", "pomplatform.account.handler.BonusSubsidyDetailHandler");
        QUERIES.put("SureIntegralAndProjectCostDetail",
                "pomplatform.account.handler.SureIntegralAndProjectCostDetailHandler");
        DOWNLOADPROCESSORS.put("ExportSureIntegralAndProjectCostDetail",
                "pomplatform.account.handler.SureIntegralAndProjectCostDetailHandler");
        QUERIES.put("OnLoadMonthReportData", "pomplatform.account.handler.OnLoadMonthReportDataHandler");
        QUERIES.put("OnLoadBenefitsData", "pomplatform.account.handler.OnLoadBenefitsDataHandler");
        QUERIES.put("OnLoadEmployeeAccountData", "pomplatform.account.handler.OnLoadEmployeeAccountDataHandler");
        PROCESSORS.put("OnProjectCommonProcess", "pomplatform.project.business.OnProjectCommonProcess");
        PROCESSORS.put("ReimbursementInfo", "pomplatform.reimbursementinfo.business.ReimbursementInfoProcessor");
        QUERIES.put("Sreimbursementpackagemmror",
                "pomplatform.sreimbursementpackagemmror.handler.SreimbursementpackagemmrorHandler");
        QUERIES.put("Sreimbursementpackagesummaryrror",
                "pomplatform.sreimbursementpackagesummaryrror.handler.SreimbursementpackagesummaryrrorHandler");
        QUERIES.put("Sreimbursementpackagedetailrror",
                "pomplatform.sreimbursementpackagedetailrror.handler.SreimbursementpackagedetailrrorHandler");
        PROCESSORS.put("ReimbursementPackageProcessor",
                "pomplatform.reimbursementpackage.business.ReimbursementPackageProcessor");
        DOWNLOADPROCESSORS.put("ReimbursementPackageProcessor",
                "pomplatform.reimbursementpackage.business.ReimbursementPackageProcessor");
        QUERIES.put("NewReimbursementPackage",
                "pomplatform.reimbursementpackage.handler.NewReimbursementPackageHandler");
        QUERIES.put("TravelReimbursementStatus2",
                "pomplatform.reimbursementpackage.handler.TravelReimbursementStatus2Handler");
        QUERIES.put("NormalReimbursementStatus2",
                "pomplatform.reimbursementpackage.handler.NormalReimbursementStatus2Handler");
        QUERIES.put("BorrowMoneyStatus2", "pomplatform.reimbursementpackage.handler.BorrowMoneyStatus2Handler");
        QUERIES.put("PayMoneyStatus2", "pomplatform.reimbursementpackage.handler.PayMoneyStatus2Handler");
        PROCESSORS.put("CustomInspectionReport", "pomplatform.InspectionReport.handler.CustomInspectionReport");
        QUERIES.put("PooledInspectionReport",
                "pomplatform.PooledInspectionReport.handler.PooledInspectionReportHandler");
        QUERIES.put("InspectionReport", "pomplatform.InspectionReport.handler.InspectionReportHandler");
        PROCESSORS.put("OnCommonProcess", "pomplatform.common.business.OnCommonProcess");
        QUERIES.put("RevenueYearStatisticalOfRevenue",
                "pomplatform.revenueStatistical.handler.RevenueYearStatisticalOfRevenueHandler");
        PROCESSORS.put("OnRevenueStatisticalProcess",
                "pomplatform.revenueStatistical.business.OnRevenueStatisticalProcess");
        QUERIES.put("RevenueStatisticalOfRevenue",
                "pomplatform.revenueStatistical.handler.CustomRevenueStatisticalOfRevenueHandler");
        PROCESSORS.put("SelectIntegrationManager", "pomplatform.domain.handler.SelectIntegrationManager");
        QUERIES.put("Memployeeerpor", "pomplatform.Memployeeerpor.handler.MemployeeerporHandler");
        QUERIES.put("EmployeeTotalAchieveIntegral", "pomplatform.aaaa.handler.EmployeeTotalAchieveIntegralHandler");
        QUERIES.put("PlateGetViolationChargesMonthlyDetail",
                "pomplatform.employeeReportRecordDetail.handler.PlateGetViolationChargesMonthlyDetailHandler");
        PROCESSORS.put("CustomPreProject", "pomplatform.PreProjectReimbursementNumber.handler.CustomPreProject");
        PROCESSORS.put("CustomPreCodeProjectName",
                "pomplatform.PreProjectReimbursementNumber.handler.CustomPreCodeProjectName");
        PROCESSORS.put("CustomPreInfoCodeProjectName",
                "pomplatform.PreProjectReimbursementNumber.handler.CustomPreInfoCodeProjectName");
        PROCESSORS.put("CustomProjectManager",
                "pomplatform.PreProjectReimbursementNumber.handler.CustomProjectManager");
        //项目立项自定控制
        PROCESSORS.put("CustomProjectManagerProcess",
                "pomplatform.operation.handler.CustomProjectManagerProcess");
        QUERIES.put("PreProjectReimbursementNumbers",
                "pomplatform.PreProjectReimbursementNumber.handler.PreProjectReimbursementNumbersHandler");
        QUERIES.put("Sprocessbilllistpppor", "pomplatform.sprocessbilllistpppor.handler.SprocessbilllistppporHandler");
        QUERIES.put("EmployeeViolationChargesMonthly",
                "pomplatform.employeeReportRecordDetail.handler.EmployeeViolationChargesMonthlyHandler");
        PROCESSORS.put("PlateGetViolationChargesProcessor",
                "pomplatform.employeeReportRecordDetail.business.PlateGetViolationChargesProcessor");
        QUERIES.put("EmployeeMonthlyAchieveIntegral",
                "pomplatform.employeeReportRecordDetail.handler.EmployeeMonthlyAchieveIntegralHandler");
        QUERIES.put("CompanyFeeMonthlyDetail",
                "pomplatform.plateIntegralAccount.handler.CompanyFeeMonthlyDetailHandler");
        QUERIES.put("CompanyFeeSumByMonth", "pomplatform.plateIntegralAccount.handler.CompanyFeeSumByMonthHandler");
        QUERIES.put("QualityFeeMonthlyDetail",
                "pomplatform.plateIntegralAccount.handler.QualityFeeMonthlyDetailHandler");
        QUERIES.put("QualityFeeSumByMonth", "pomplatform.plateIntegralAccount.handler.QualityFeeSumByMonthHandler");
        QUERIES.put("QualityFeeDetail", "pomplatform.plateIntegralAccount.handler.QualityFeeDetailHandler");
        PROCESSORS.put("InsertProjectCostProcessor", "pomplatform.workflow.business.InsertProjectCostProcessor");
        DAOS.put("TravelReimbursementWithTt", "pomplatform.workflow.handler.TravelReimbursementWithTtHandler");
        //前期项目差旅报销
        WORKFLOWPROCESSORS.put("Pre_project_travel_reimbursement",
                "pomplatform.workflow.handler.PreProjectTravelReimbursementWorker");
        QUERIES.put("PreProjectTravelReimbursement",
                "pomplatform.workflow.handler.PreProjectTravelReimbursementHandler");
        QUERIES.put("Stravelreimbursementmmmor", "pomplatform.workflow.handler.StravelreimbursementmmmorHandler");
        DAOS.put("ProjectNormalReimbursementWithPn",
                "pomplatform.workflow.handler.ProjectNormalReimbursementWithPnHandler");
        //前期项目日常报销
        WORKFLOWPROCESSORS.put("Pre_project_normal_reimbursement",
                "pomplatform.workflow.handler.PreProjectNormalReimbursementWorker");
        QUERIES.put("PreProjectNormalReimbursement",
                "pomplatform.workflow.handler.PreProjectNormalReimbursementHandler");
        QUERIES.put("OnloadPlateIntegralData", "pomplatform.account.handler.OnloadPlateIntegralDataHandler");
        PROCESSORS.put("AccountManageProcess", "pomplatform.account.business.AccountManageProcess");
        PROCESSORS.put("DeleteWrokflowProcessor", "pomplatform.workflow.business.DeleteWrokflowProcessor");
        QUERIES.put("AadvanceprojectOnOtherPlateIntegral",
                "pomplatform.operating.handler.AadvanceprojectOnOtherPlateIntegralHandler");
        DAOS.put("ProjectNormalReimbursementWithPn",
                "pomplatform.workflow.commonNormalReimbursement.handler.ProjectNormalReimbursementWithPnHandler");
        //普通日常报销
        WORKFLOWPROCESSORS.put("Common_normal_reimbursement",
                "pomplatform.workflow.commonNormalReimbursement.handler.NormalReimbursementWithDepartmentWorker");
        QUERIES.put("NormalReimbursementWithDepartment",
                "pomplatform.workflow.commonNormalReimbursement.handler.NormalReimbursementWithDepartmentHandler");
        // DAOS.put("TravelReimbursementWithTt",
        // "pomplatform.workflow.commonTravelReimbursement.handler.TravelReimbursementWithTtHandler");
        //普通差旅报销
        WORKFLOWPROCESSORS.put("Common_travel_reimbursement",
                "pomplatform.workflow.commonTravelReimbursement.handler.TravelReimbursementWithDepartmentWorker");
        QUERIES.put("TravelReimbursementWithDepartment",
                "pomplatform.workflow.commonTravelReimbursement.handler.TravelReimbursementWithDepartmentHandler");
        QUERIES.put("Mcapitalemployeeecceedor",
                "pomplatform.mcapitalemployeeecceedor.handler.McapitalemployeeecceedorHandler");
        QUERIES.put("Mcapitaldepartmentdccddor",
                "pomplatform.mcapitaldepartmentdccddor.handler.McapitaldepartmentdccddorHandler");
        PROCESSORS.put("CustomMinvocieapplydedaocor",
                "pomplatform.minvocieapplydedaocor.handler.CustomMinvocieapplydedaocorHandler");
        QUERIES.put("Mcontractreceivableiicor",
                "pomplatform.mcontractreceivableiicor.handler.McontractreceivableiicorHandler");
        QUERIES.put("Mcontractisubccacccor", "pomplatform.mcontractisubccacccor.handler.McontractisubccacccorHandler");
        QUERIES.put("Minvocieapplydedaocor", "pomplatform.minvocieapplydedaocor.handler.MinvocieapplydedaocorHandler");
        DOWNLOADPROCESSORS.put("Minvocieapplydedaocor", "pomplatform.minvocieapplydedaocor.handler.MinvocieapplydedaocorHandler");
        DAOS.put("ProjectNormalReimbursementWithPn",
                "pomplatform.workflow.projectNormalReimbursement.handler.ProjectNormalReimbursementWithPnHandler");
        //项目日常报销
        WORKFLOWPROCESSORS.put("Project_normal_reimbursement",
                "pomplatform.workflow.projectNormalReimbursement.handler.NormalReimbursementWithProjectWorker");
        QUERIES.put("NormalReimbursementWithProject",
                "pomplatform.workflow.projectNormalReimbursement.handler.NormalReimbursementWithProjectHandler");
        DAOS.put("TravelReimbursementWithTt",
                "pomplatform.workflow.projectTravelReimbursement.handler.TravelReimbursementWithTtHandler");
        //项目差旅报销
        WORKFLOWPROCESSORS.put("Project_travel_reimbursement",
                "pomplatform.workflow.projectTravelReimbursement.handler.NewProjectTravelReimbursementWorker");
        QUERIES.put("NewProjectTravelReimbursement",
                "pomplatform.workflow.projectTravelReimbursement.handler.NewProjectTravelReimbursementHandler");
        DAOS.put("TravelReimbursementDetailWithT",
                "pomplatform.workflow.projectTravelReimbursement.handler.TravelReimbursementDetailWithTHandler");
        DAOS.put("TravelReimbursementWithT",
                "pomplatform.workflow.projectTravelReimbursement.handler.TravelReimbursementWithTHandler");
        DAOS.put("TravelReimbursementWithT", "pomplatform.workflow.handler.TravelReimbursementWithTHandler");
        QUERIES.put("NewProjectTravelReimbursement",
                "pomplatform.workflow.projectTravelReimbursement.handler.NewProjectTravelReimbursementHandler");
        DAOS.put("TravelReimbursementDetailWithT",
                "pomplatform.workflow.handler.TravelReimbursementDetailWithTHandler");
        DAOS.put("TravelReimbursementWithProject",
                "pomplatform.workflow.handler.TravelReimbursementWithProjectHandler");
        QUERIES.put("TravelReimbursementsPoolOfWorkflow",
                "pomplatform.workflow.handler.TravelReimbursementsPoolOfWorkflowHandler");
        QUERIES.put("NormalReimbursementsPoolOfWorkflow",
                "pomplatform.workflow.handler.NormalReimbursementsPoolOfWorkflowHandler");
        QUERIES.put("PayMoneyPoolOfWorkflow", "pomplatform.workflow.handler.PayMoneyPoolOfWorkflowHandler");
        QUERIES.put("EmployeeMoneyPoolOfWorkflow", "pomplatform.workflow.handler.EmployeeMoneyPoolOfWorkflowHandler");
        QUERIES.put("TravelReimbursementsAttentionOfWorkflow",
                "pomplatform.workflow.handler.TravelReimbursementsAttentionOfWorkflowHandler");
        QUERIES.put("NormalReimbursementsAttentionOfWorkflow",
                "pomplatform.workflow.handler.NormalReimbursementsAttentionOfWorkflowHandler");
        QUERIES.put("PayMoneyAttentionOfWorkflow", "pomplatform.workflow.handler.PayMoneyAttentionOfWorkflowHandler");
        QUERIES.put("EmployeeMoneyAttentionOfWorkflow",
                "pomplatform.workflow.handler.EmployeeMoneyAttentionOfWorkflowHandler");
        QUERIES.put("TravelReimbursementsAuditOfWorkflow",
                "pomplatform.workflow.handler.TravelReimbursementsAuditOfWorkflowHandler");
        QUERIES.put("NormalReimbursementsAuditOfWorkflow",
                "pomplatform.workflow.handler.NormalReimbursementsAuditOfWorkflowHandler");
        QUERIES.put("PayMoneyAuditOfWorkflow", "pomplatform.workflow.handler.PayMoneyAuditOfWorkflowHandler");
        QUERIES.put("EmployeeMoneyAuditOfWorkflow", "pomplatform.workflow.handler.EmployeeMoneyAuditOfWorkflowHandler");
        QUERIES.put("TravelReimbursementsApplyOfWorkflow",
                "pomplatform.workflow.handler.TravelReimbursementsApplyOfWorkflowHandler");
        QUERIES.put("NormalReimbursementsApplyOfWorkflow",
                "pomplatform.workflow.handler.NormalReimbursementsApplyOfWorkflowHandler");
        QUERIES.put("PayMoneyApplyOfWorkflow", "pomplatform.workflow.handler.PayMoneyApplyOfWorkflowHandler");
        QUERIES.put("EmployeeMoneyApplyOfWorkflow", "pomplatform.workflow.handler.EmployeeMoneyApplyOfWorkflowHandler");
        //借款申请
        WORKFLOWPROCESSORS.put("Borrow_money_manage",
                "pomplatform.workflow.handler.EmployeeBorrowMoneyByWorkflowWorker");
        QUERIES.put("EmployeeBorrowMoneyByWorkflow",
                "pomplatform.workflow.handler.EmployeeBorrowMoneyByWorkflowHandler");
        //预付款申请
        WORKFLOWPROCESSORS.put("Pay_money_manage", "pomplatform.workflow.handler.PayMoneyManageOfWorkflowWorker");
        QUERIES.put("PayMoneyManageOfWorkflow", "pomplatform.workflow.handler.PayMoneyManageOfWorkflowHandler");
        QUERIES.put("Mcontracticcacccor", "pomplatform.mcontracticcacccor.handler.McontracticcacccorHandler");
        DOWNLOADPROCESSORS.put("Mcontracticcacccor",
                "pomplatform.mcontracticcacccor.handler.McontracticcacccorHandler");
        QUERIES.put("ProjectAttachmentManage",
                "pomplatform.projectAttachmentManage.handler.ProjectAttachmentManageHandler");
        QUERIES.put("Mcecscreeor", "pomplatform.mcecscreeor.handler.McecscreeorHandler");
        QUERIES.put("OnPayMoneyManageBusiness", "pomplatform.workflow.handler.OnPayMoneyManageBusinessHandler");
        QUERIES.put("Mclientctractor", "pomplatform.clientctractor.handler.MclientctractorHandler");
        PROCESSORS.put("GetEmployeeMoneyHistoryRecord",
                "pomplatform.employee.business.GetEmployeeMoneyHistoryRecordProcessor");
        PROCESSORS.put("GetSubTypeByProcessAndDepartment",
                "pomplatform.project.business.GetSubTypeByProcessAndDepartmentProcessor");
        // WORKFLOWPROCESSORS.put("Common_travel_reimbursement",
        // "pomplatform.workflow.handler.CommonTravelReimbursementWorker");
        // WORKFLOWPROCESSORS.put("Project_travel_reimbursement",
        // "pomplatform.workflow.handler.ProjectTravelReimbursementWorker");
        QUERIES.put("ProjectTravelReimbursement", "pomplatform.workflow.handler.ProjectTravelReimbursementHandler");
        QUERIES.put("SubjectTypeLinkDepartment", "pomplatform.subjectType.handler.SubjectTypeLinkDepartmentHandler");
        QUERIES.put("SubjectLinkSystemProcessType",
                "pomplatform.subjectType.handler.SubjectLinkSystemProcessTypeHandler");
        QUERIES.put("OutPriceListItem", "pomplatform.outPriceListItem.handler.OutPriceListItemHandler");
        PROCESSORS.put("OnWrokflowProcess", "pomplatform.workflow.business.OnWrokflowProcess");
        UPLOADPROCESSORS.put("UploadReimbursementAttachments",
                "pomplatform.common.business.OnUploadReimbursementAttachments");
        // WORKFLOWPROCESSORS.put("Common_normal_reimbursement",
        // "pomplatform.workflow.handler.CommonNormalReimbursementWithPWorker");
        // WORKFLOWPROCESSORS.put("Project_normal_reimbursement",
        // "pomplatform.workflow.handler.ProjectNormalReimbursementWithPWorker");
        DAOS.put("ProjectNormalReimbursementWithP",
                "pomplatform.workflow.handler.ProjectNormalReimbursementWithPHandler");
        QUERIES.put("ProjectNormalReimbursementOfWorkflow",
                "pomplatform.workflow.handler.ProjectNormalReimbursementOfWorkflowHandler");
        PROCESSORS.put("GetUserInfoById", "pomplatform.common.business.GetUserInfoByIdProcessor");
        PROCESSORS.put("GetProjectByProjectName", "pomplatform.project.business.GetProjectByProjectNameProcessor");
        QUERIES.put("BorrowMoneyManage", "pomplatform.borrowMoneyManage.handler.BorrowMoneyManageHandler");
        QUERIES.put("Scontractcccor", "pomplatform.scontractcccor.handler.ScontractcccorHandler");
        DAOS.put("SubjectTypeWithS", "pomplatform.subjectType.handler.SubjectTypeWithSHandler");
        DOWNLOADPROCESSORS.put("RevenueYearRecordSubOfRevenue",
                "pomplatform.OnRevenue.handler.RevenueYearRecordSubOfRevenueHandler");
        DOWNLOADPROCESSORS.put("RevenueYearRecordOfRevenue",
                "pomplatform.OnRevenue.handler.RevenueYearRecordOfRevenueHandler");
        DOWNLOADPROCESSORS.put("RevenueRecordOfOnRevenue",
                "pomplatform.OnRevenue.handler.RevenueRecordOfOnRevenueHandler");
        PROCESSORS.put("OnAboutSubjectType", "pomplatform.subjectType.business.OnAboutSubjectType");
        QUERIES.put("Sinvoiceorusecount", "pomplatform.sinvoiceitior.handler.SinvoiceorusecountHandler");
        PROCESSORS.put("CustomContractClassifty", "pomplatform.ht.handler.CustomContractClassifty");
        QUERIES.put("RevenueRecordOfOnRevenue", "pomplatform.OnRevenue.handler.RevenueRecordOfOnRevenueHandler");
        QUERIES.put("OnBusinessStateOfRevenue", "pomplatform.OnRevenue.handler.OnBusinessStateOfRevenueHandler");
        QUERIES.put("OnSheetAttachmentOfRevenue", "pomplatform.OnRevenue.handler.OnSheetAttachmentOfRevenueHandler");
        PROCESSORS.put("GetUserInfo", "pomplatform.common.business.GetUserInfoProcessor");
        QUERIES.put("GetUnsettledProjectCost", "pomplatform.projectCost.handler.GetUnsettledProjectCostHandler");
        QUERIES.put("Sinvoiceitiorcount", "pomplatform.sinvoiceitior.handler.SinvoiceitiorcountHandler");
        DOWNLOADPROCESSORS.put("Sinvoiceitiorcount", "pomplatform.sinvoiceitior.handler.SinvoiceitiorcountHandler");
        QUERIES.put("RevenueRecordOfOnRevenue", "pomplatform.OnRevenue.handler.RevenueRecordOfOnRevenueHandler");
        QUERIES.put("RevenueYearRecordSubOfRevenue",
                "pomplatform.OnRevenue.handler.RevenueYearRecordSubOfRevenueHandler");
        QUERIES.put("RevenueYearRecordOfRevenue", "pomplatform.OnRevenue.handler.RevenueYearRecordOfRevenueHandler");
        QUERIES.put("Minvoicettorunusecount", "pomplatform.sinvoiceitior.handler.MinvoicettorunusecountHandler");
        DOWNLOADPROCESSORS.put("Minvoicettorunusecount",
                "pomplatform.sinvoiceitior.handler.MinvoicettorunusecountHandler");
        QUERIES.put("SumDesignconsideration",
                "pomplatform.sumDesignconsideration.handler.SumDesignconsiderationHandler");
        QUERIES.put("GroupOutdesignconsiderationior",
                "pomplatform.groupOutdesignconsiderationior.handler.GroupOutdesignconsiderationiorHandler");
        PROCESSORS.put("OnAboutRevenue", "pomplatform.OnRevenue.business.OnAboutRevenue");
        QUERIES.put("OnFinishPercentOfRevenue", "pomplatform.OnRevenue.handler.OnFinishPercentOfRevenueHandler");
        QUERIES.put("ContractInfoOfRevenue", "pomplatform.OnRevenue.handler.ContractInfoOfRevenueHandler");
        QUERIES.put("SheetStageFinishPercentOfRevenue",
                "pomplatform.OnRevenue.handler.SheetStageFinishPercentOfRevenueHandler");
        QUERIES.put("AccountWeightOfRevenue", "pomplatform.OnRevenue.handler.AccountWeightOfRevenueHandler");
        QUERIES.put("AllSheetDataOfRevenue", "pomplatform.OnRevenue.handler.AllSheetDataOfRevenueHandler");
        PROCESSORS.put("EmployeeIntegralReturn",
                "pomplatform.employeeintegralReturn.business.EmployeeIntegralReturnProcessor");
        QUERIES.put("GetPlateSalaryAdvanceInfo",
                "pomplatform.getPlateSalaryAdvanceInfo.handler.GetPlateSalaryAdvanceInfoHandler");
        QUERIES.put("Soutdesignconsiderationor",
                "pomplatform.newOutdesignconsiderationor.handler.SoutdesignconsiderationorHandler");
        QUERIES.put("Scontract", "pomplatform.Scontract.handler.ScontractHandler");
        DOWNLOADPROCESSORS.put("Scontract", "pomplatform.Scontract.handler.ScontractHandler");
        QUERIES.put("MHasOutQuotation", "pomplatform.hasOutQuotation.handler.MHasOutQuotationHandler");
        DOWNLOADPROCESSORS.put("Minvoiceexpresitssccmisiior",
                "pomplatform.invoiceexpresitssccmisiior.handler.MinvoiceexpresitssccmisiiorHandler");
        QUERIES.put("Minvoiceexpresitssccmisiior",
                "pomplatform.invoiceexpresitssccmisiior.handler.MinvoiceexpresitssccmisiiorHandler");
        QUERIES.put("GetPlateEmployeeIdByTime",
                "pomplatform.getEmployeeIdByRoleId.handler.GetPlateEmployeeIdByTimeHandler");
        QUERIES.put("getEmployeeIdByRoleId", "pomplatform.getEmployeeIdByRoleId.handler.getEmployeeIdByRoleIdHandler");
        PROCESSORS.put("PlateEmployeeAchieveIntegralReturn",
                "pomplatform.project.business.PlateEmployeeAchieveIntegralReturn");
        PROCESSORS.put("ProjectUpdate123", "pomplatform.project.business.ProjectUpdate123");
        QUERIES.put("ProjectSureDateRecord", "pomplatform.projectSureDateRecord.handler.ProjectSureDateRecordHandler");
        QUERIES.put("Scontractreceivablecipor",
                "pomplatform.contractreceivablecipor.handler.ScontractreceivableciporHandler");
        QUERIES.put("MItemCollection", "pomplatform.itemCollection.handler.MItemCollectionHandler");
        QUERIES.put("Mcontracticcisiior", "pomplatform.contracticcisiior.handler.McontracticcisiiorHandler");
        QUERIES.put("Sinvoiceitior", "pomplatform.sinvoiceitior.handler.SinvoiceitiorHandler");
        QUERIES.put("Mcapitalecoosmeor", "pomplatform.finance.handler.McapitalecoosmeorHandler");
        DOWNLOADPROCESSORS.put("Mcapitalecoosmeor", "pomplatform.finance.handler.McapitalecoosmeorHandler");
        QUERIES.put("Memployeeworkor", "delicacy.oa.handler.MemployeeworkorHandler");
        QUERIES.put("Mclasstypecior", "delicacy.oa.handler.MclasstypeciorHandler");
        DOWNLOADPROCESSORS.put("OnAboutOperatingIntegral", "pomplatform.operating.business.OnAboutOperatingIntegral");
        DOWNLOADPROCESSORS.put("ProjectCostRecord", "pomplatform.projectCost.handler.ProjectCostRecordHandler");
        PROCESSORS.put("EmployeeSalaryDetailMonthProcessor",
                "pomplatform.employeeSalary.business.EmployeeSalaryDetailMonthProcessor");
        QUERIES.put("EmployeeSalaryDetailMonth", "pomplatform.employeeSalary.handler.EmployeeSalaryDetailMonthHandler");
        DOWNLOADPROCESSORS.put("BonusPaymentDetailDownload",
                "pomplatform.bonusPayment.handler.BonusPaymentDetailDownloadHandler");
        QUERIES.put("BonusPaymentDetail", "pomplatform.bonusPayment.handler.BonusPaymentDetailHandler");
        QUERIES.put("PrepareBonusPaymentApplyInfo",
                "pomplatform.bonusPayment.handler.PrepareBonusPaymentApplyInfoHandler");
        PROCESSORS.put("BonusPaymentProcessor", "pomplatform.bonusPayment.business.BonusPaymentProcessor");
        QUERIES.put("BonusPaymentRecord", "pomplatform.bonusPayment.handler.BonusPaymentRecordHandler");
        QUERIES.put("BonusPaymentByDetail", "pomplatform.bonusPaymentByDetail.handler.BonusPaymentByDetailHandler");
        QUERIES.put("BonusPaymentByMonth", "pomplatform.bonusPaymentByMonth.handler.BonusPaymentByMonthHandler");
        QUERIES.put("Soutdesignconsiderationoor",
                "pomplatform.soutdesignconsiderationoor.handler.SoutdesignconsiderationoorHandler");
        QUERIES.put("OperatingOnOtherPlateIntegral",
                "pomplatform.operating.handler.OperatingOnOtherPlateIntegralHandler");
        QUERIES.put("OperatingOnPayCommonPlateIntegral",
                "pomplatform.operating.handler.OperatingOnPayCommonPlateIntegralHandler");
        PROCESSORS.put("OnAboutOperatingIntegral", "pomplatform.operating.business.OnAboutOperatingIntegral");
        QUERIES.put("SheetTotalByBusinessProjectPlate",
                "pomplatform.company.handler.SheetTotalByBusinessProjectPlateHandler");
        QUERIES.put("CompanyIntegralSubcontract", "pomplatform.company.handler.CompanyIntegralSubcontractHandler");
        QUERIES.put("SheetTotalByPlateId", "pomplatform.company.handler.SheetTotalByPlateIdHandler");
        QUERIES.put("SheetTotalByProjectType", "pomplatform.company.handler.SheetTotalByProjectTypeHandler");
        QUERIES.put("SheetTotalByBusinessType", "pomplatform.company.handler.SheetTotalByBusinessTypeHandler");
        QUERIES.put("OutTemplet", "pomplatform.templet.handler.OutTempletHandler");
        PROCESSORS.put("OnAboutCompanyIntegral", "pomplatform.company.business.OnAboutCompanyIntegral");
        QUERIES.put("EmployeeProjectCostEachMonth",
                "pomplatform.employeeProjectCostEachMonth.handler.EmployeeProjectCostEachMonthHandler");
        QUERIES.put("ManageProjectEmployeeRecordEachMonth",
                "pomplatform.manageProjectEmployeeRecordEachMonth.handler.ManageProjectEmployeeRecordEachMonthHandler");
        QUERIES.put("ManageProjectByProject",
                "pomplatform.ManageProjectByProject.handler.ManageProjectByProjectHandler");
        QUERIES.put("ManageProjectByMonth", "pomplatform.ManageProjectByMonth.handler.ManageProjectByMonthHandler");
        QUERIES.put("EmployeeAchieveIntegralReturnRecordByProject",
                "pomplatform.EmployeeAchieveIntegralReturnRecordByProject.handler.EmployeeAchieveIntegralReturnRecordByProjectHandler");
        QUERIES.put("EmployeeAchieveIntegralReturnRecordByEmoloyee",
                "pomplatform.EmployeeAchieveIntegralReturnRecordByEmoloyee.handler.EmployeeAchieveIntegralReturnRecordByEmoloyeeHandler");
        QUERIES.put("EmployeeAchieveIntegralReturnRecordByMonth",
                "pomplatform.EmployeeAchieveIntegralReturnRecordByMonth.handler.EmployeeAchieveIntegralReturnRecordByMonthHandler");
        QUERIES.put("PlateProjectAccountRecordByProject",
                "pomplatform.PlateProjectAccountRecordByProject.handler.PlateProjectAccountRecordByProjectHandler");
        QUERIES.put("PlateProjectAccountRecordByMonth",
                "pomplatform.PlateProjectAccountRecordByMonth.handler.PlateProjectAccountRecordByMonthHandler");
        DOWNLOADPROCESSORS.put("EmployeeReportRecordDetail",
                "pomplatform.employeeReportRecordDetail.handler.EmployeeReportRecordDetailHandler");
        PROCESSORS.put("OnSaveOrUpdateManageProject", "pomplatform.common.business.OnSaveOrUpdateManageProject");
        DAOS.put("FormalContractWithO", "pomplatform.ht2.handler.FormalContractWithOHandler");
        QUERIES.put("Sformalcontractcccor", "pomplatform.ht2.handler.SformalcontractcccorHandler");
        DOWNLOADPROCESSORS.put("ProjectReportRecordDetailHandler",
                "pomplatform.projectReportRecordDetail.handler.ProjectReportRecordDetailHandler");
        QUERIES.put("ProjectEmployeeAdvanceEachPersonDetail",
                "pomplatform.sProjectEmployeeAdvanceRecordpor.handler.ProjectEmployeeAdvanceEachPersonDetailHandler");
        QUERIES.put("SProjectEmployeeAdvanceRecordpor",
                "pomplatform.sProjectEmployeeAdvanceRecordpor.handler.SProjectEmployeeAdvanceRecordporHandler");
        QUERIES.put("SProjectEmployeeAdvanceRecordDetail",
                "pomplatform.sProjectEmployeeAdvanceRecord.handler.SProjectEmployeeAdvanceRecordDetailHandler");
        QUERIES.put("SProjectEmployeeAdvanceRecord",
                "pomplatform.sProjectEmployeeAdvanceRecord.handler.SProjectEmployeeAdvanceRecordHandler");
        QUERIES.put("SProjectAdvanceRecord", "pomplatform.sProjectAdvanceRecord.handler.SProjectAdvanceRecordHandler");
        QUERIES.put("SProjectAdvanceRecordEachMonth",
                "pomplatform.sProjectAdvanceRecordEachMonth.handler.SProjectAdvanceRecordEachMonthHandler");
        PROCESSORS.put("OnProjectEmployeeAdvanceSave", "pomplatform.common.business.OnProjectEmployeeAdvanceSave");
        PROCESSORS.put("OnGetProjectEmployeeAdvanceRecord",
                "pomplatform.common.business.OnGetProjectEmployeeAdvanceRecord");
        PROCESSORS.put("OnGetProjectAdvanceItem", "pomplatform.common.business.OnGetProjectAdvanceItem");
        PROCESSORS.put("OnProjectAdvanceRecordSave", "pomplatform.common.business.OnProjectAdvanceRecordSave");
        PROCESSORS.put("OnGetProjectAdvanceIntegral", "pomplatform.common.business.OnGetProjectAdvanceIntegral");
        QUERIES.put("SProjectSettlementDetailEachMonth",
                "pomplatform.sProjectSettlementDetailEachMonth.handler.SProjectSettlementDetailEachMonthHandler");
        QUERIES.put("SEmployeeSalaryReturnEachMonthRecord",
                "pomplatform.sEmployeeSalaryReturnEachMonthRecord.handler.SEmployeeSalaryReturnEachMonthRecordHandler");
        QUERIES.put("SPlateSalaryAdvanceEachMonthRecord",
                "pomplatform.sPlateSalaryAdvanceEachMonthRecord.handler.SPlateSalaryAdvanceEachMonthRecordHandler");
        PROCESSORS.put("OnIntegralReturnOfPlate", "pomplatform.common.business.OnIntegralReturnOfPlate");
        QUERIES.put("ProjectCostDetail", "pomplatform.EmployeeDetail.handler.ProjectCostDetailHandler");
        QUERIES.put("SalaryReturnDetail", "pomplatform.EmployeeDetail.handler.SalaryReturnDetailHandler");
        QUERIES.put("SalaryAdvanceDetail", "pomplatform.EmployeeDetail.handler.SalaryAdvanceDetailHandler");
        QUERIES.put("ManagerProjectIntegralDetail",
                "pomplatform.EmployeeDetail.handler.ManagerProjectIntegralDetailHandler");
        QUERIES.put("SureIntegralDetail", "pomplatform.EmployeeDetail.handler.SureIntegralDetailHandler");
        QUERIES.put("ProjectReportRecordDetail",
                "pomplatform.projectReportRecordDetail.handler.ProjectReportRecordDetailHandler");
        QUERIES.put("PlateCostRecord", "pomplatform.plateCostRecord.handler.PlateCostRecordHandler");
        QUERIES.put("PlateIntegralAssignRecord",
                "pomplatform.plateIntegralAssignRecord.handler.PlateIntegralAssignRecordHandler");
        QUERIES.put("PlateSalaryAdvanceRecord",
                "pomplatform.plateSalaryAdvanceRecord.handler.PlateSalaryAdvanceRecordHandler");
        QUERIES.put("EmployeeSalaryReturnRecord",
                "pomplatform.employeeSalaryReturnRecord.handler.EmployeeSalaryReturnRecordHandler");
        QUERIES.put("PlateIntegralSendRecord",
                "pomplatform.plateIntegralSendRecord.handler.PlateIntegralSendRecordHandler");
        DOWNLOADPROCESSORS.put("PlateReportRecordDetail",
                "pomplatform.plateReportRecordDetail.handler.PlateReportRecordDetailHandler");
        QUERIES.put("EmployeeReportRecordDetail",
                "pomplatform.employeeReportRecordDetail.handler.EmployeeReportRecordDetailHandler");
        QUERIES.put("PlateReportRecordDetail",
                "pomplatform.plateReportRecordDetail.handler.PlateReportRecordDetailHandler");
        QUERIES.put("Sformalcontractcccor", "pomplatform.ht.handler.SformalcontractcccorHandler");
        PROCESSORS.put("OnManageProjectIntegralAssign", "pomplatform.common.business.OnManageProjectIntegralAssign");
        QUERIES.put("ManageProjectEmployee", "pomplatform.ManageProjectEmployee.handler.ManageProjectEmployeeHandler");
        QUERIES.put("MainProject", "pomplatform.ht.handler.CustomMainProjectHandler");
        QUERIES.put("NewContract", "pomplatform.contract.handler.NewContractHandler");
        // 上传报价单的原附件
        UPLOADPROCESSORS.put("UploadQuotationImage", "pomplatform.ht.handler.UploadImage");
        // 上传服务建议书
        UPLOADPROCESSORS.put("UploadServiceFiles", "pomplatform.ht.handler.UploadServiceFiles");
        //
        PROCESSORS.put("CustomFormalContractHandler", "pomplatform.ht.handler.CustomFormalContractHandler");
        // 有没有报价单
        PROCESSORS.put("CheckDesignConsideration", "pomplatform.ht.handler.CheckDesignConsideration");
        // 获取报价单的编号
        PROCESSORS.put("CustomQuotationNumber", "pomplatform.ht.handler.CustomQuotationNumber");
        // 获取报价单的状态
        PROCESSORS.put("CustomQuotationStatus", "pomplatform.ht.handler.CustomQuotationStatus");
        PROCESSORS.put("HasDesignConsiderationHistory", "pomplatform.api.HasDesignConsiderationHistory");
        QUERIES.put("SplateIntegralAssignRecord",
                "pomplatform.plateIntegralAssignRecord.handler.SplateIntegralAssignRecordHandler");
        PROCESSORS.put("OnPlateReserveIntegralAssign", "pomplatform.common.business.OnPlateReserveIntegralAssign");
        QUERIES.put("SplateIntegralTransferRecord",
                "pomplatform.plateIntegralTransferRecord.handler.SplateIntegralTransferRecordHandler");
        PROCESSORS.put("OnPlateReserveIntegral", "pomplatform.common.business.OnPlateReserveIntegral");
        PROCESSORS.put("OnGetPlateReserveIntegral", "pomplatform.common.business.OnGetPlateReserveIntegral");
        QUERIES.put("NewMainprojectInfo", "pomplatform.newMainprojectInfo.handler.NewMainprojectInfoHandler");
        DOWNLOADPROCESSORS.put("Memployeechangeplaterecordeeepyseor",
                "pomplatform.employeechangeplaterecord.handler.MemployeechangeplaterecordeeepyseorHandler");
        QUERIES.put("Memployeechangeplaterecordeeepyseor",
                "pomplatform.employeechangeplaterecord.handler.MemployeechangeplaterecordeeepyseorHandler");
        DOWNLOADPROCESSORS.put("MemployeeAwardTotal",
                "pomplatform.employeeAwardTotal.handler.CustomMemployeeAwardTotalHandler");
        DOWNLOADPROCESSORS.put("SplateProjectOrDepartmentIntegralSumRecordpysor",
                "pomplatform.SplateProjectOrDepartmentIntegralSumRecordpysor.handler.CustomSplateProjectOrDepartmentIntegralSumRecordpysorHandler");
        DOWNLOADPROCESSORS.put("Sprojectintegralsumrecordpysor",
                "pomplatform.Sprojectintegralsumrecordpysor.handler.SprojectintegralsumrecordpysorHandler");
        QUERIES.put("MEmployeeChangePlateDetail",
                "pomplatform.memployeechangeplatedetail.handler.MEmployeeChangePlateDetailHandler");
        DAOS.put("CustomEmployeeChangePlateDetail",
                "pomplatform.memployeechangeplatedetail.handler.CustomEmployeeChangePlateDetailHandler");
        QUERIES.put("Sprojectintegralsumrecordpysor",
                "pomplatform.Sprojectintegralsumrecordpysor.handler.SprojectintegralsumrecordpysorHandler");
        PROCESSORS.put("ProjectIntegralAccount", "pomplatform.project.business.ProjectIntegralAccount");
        PROCESSORS.put("ProjectIntegralLock", "pomplatform.project.business.ProjectIntegralLock");
        PROCESSORS.put("ProjectIntegralMoveLock", "pomplatform.project.business.ProjectIntegralMoveLock");
        // 提交报价单
        PROCESSORS.put("CustomSubmitQuotation", "pomplatform.ht.handler.CustomSubmitQuotation");
        QUERIES.put("MaddProjectEmpSalary", "pomplatform.addProjectEmpSalary.handler.MaddProjectEmpSalaryHandler");
        QUERIES.put("Splateintegralsumrecordpysor",
                "pomplatform.splateintegralsumrecordpysor.handler.CustomSplateintegralsumrecordpysorHandler");
        QUERIES.put("SplateProjectOrDepartmentIntegralSumRecordpysor",
                "pomplatform.SplateProjectOrDepartmentIntegralSumRecordpysor.handler.CustomSplateProjectOrDepartmentIntegralSumRecordpysorHandler");
        QUERIES.put("Sprojectintegralsumrecordpymor",
                "pomplatform.sprojectintegralsumrecordpymor.handler.SprojectintegralsumrecordpymorHandler");
        DAOS.put("CustomDesignConsideration",
                "pomplatform.designConsiderationInfo.handler.CustomDesignConsiderationHandler");
        DAOS.put("CustomContract", "pomplatform.contract.handler.CustomContractHandler");
        QUERIES.put("MemployeeWorkClassType", "pomplatform.employeeWorkClassType.handler.EmployeeWorkClassTypeHandler");
        QUERIES.put("SprojectIntegralAssign",
                "pomplatform.projectIntegralAssign.handler.SprojectIntegralAssignHandler");
        PROCESSORS.put("OnSetProjectIntegralAssign", "pomplatform.common.business.OnSetProjectIntegralAssign");
        PROCESSORS.put("DefaultSetRole", "pomplatform.common.expand.DefaultSetRole");
        PROCESSORS.put("DefaultSetEmpRole", "pomplatform.common.expand.DefaultSetEmpRole");
        PROCESSORS.put("CustomDeptIdEmployeeProcessor", "pomplatform.employee.business.CustomDeptIdEmployeeProcessor");
        QUERIES.put("MprojectEmployeeSureIntegrl",
                "pomplatform.sureIntegrl.handler.MprojectEmployeeSureIntegrlHandler");
        PROCESSORS.put("ProjectSure", "pomplatform.project.business.ProjectSure");
        QUERIES.put("MprojectStageIntegralTotal",
                "pomplatform.stageIntegral.handler.CustomMprojectStageIntegralTotalHandler");
        QUERIES.put("MprojectStageIntegral", "pomplatform.sureIntegral.handler.CustomMprojectStageIntegralHandler");
        QUERIES.put("DesignConsiderationInfo",
                "pomplatform.designConsiderationInfo.handler.DesignConsiderationInfoHandler");
        DAOS.put("SaveClientAndMainProjectClient", "com.pomplatform.db.handler.SaveClientAndMainProjectClientHandler");
        QUERIES.put("GContractInfo", "pomplatform.gcontractinfo.handler.GContractInfoHandler");
        QUERIES.put("Mmainprojectclientccmor", "pomplatform.mainProjectInfo.handler.MmainprojectclientccmorHandler");
        QUERIES.put("MainProjectInfo", "pomplatform.mainProjectInfo.handler.MainProjectInfoHandler");
        DAOS.put("MainProject", "com.pomplatform.db.handler.MainProjectHandler");
        QUERIES.put("GetProjectByContract", "pomplatform.getProjectByContract.handler.GetProjectByContractHandler");
        QUERIES.put("ProjectCostList", "pomplatform.subContractInfo.handler.ProjectCostListHandler");
        QUERIES.put("Semployeemonthlycheckymor", "pomplatform.check.handler.SemployeemonthlycheckymorHandler");
        QUERIES.put("MgetProjectCost", "pomplatform.getProjectCost.handler.MgetProjectCostHandler");
        QUERIES.put("MplateProjectIntegralDetail",
                "pomplatform.plateProjectIntegralDetail.handler.CustomMplateProjectIntegralDetailHandler");
        QUERIES.put("MplateProjectCost", "pomplatform.plateProjectCost.handler.MplateProjectCostHandler");
        QUERIES.put("MplateIntegralTotal", "pomplatform.plateIntegralTotal.handler.CustomMplateIntegralTotalHandler");
        QUERIES.put("MplateIntegralDetail",
                "pomplatform.plateIntegralDetail.handler.CustomMplateIntegralDetailHandler");
        QUERIES.put("SubContractInfo", "pomplatform.subContractInfo.handler.SubContractInfoHandler");
        QUERIES.put("ContractInfo", "pomplatform.contractInfo.handler.ContractInfoHandler");
        DAOS.put("ContractInfoUpdate", "pomplatform.contractInfo.handler.ContractInfoUpdateHandler");
        QUERIES.put("Memployeecheckinouteeseor", "pomplatform.checking.handler.MemployeecheckinouteeseorHandler");
        QUERIES.put("MemployeeAwardDetail", "pomplatform.employeeAwardDetail.handler.MemployeeAwardDetailHandler");
        QUERIES.put("MemployeeAwardTotal", "pomplatform.employeeAwardTotal.handler.CustomMemployeeAwardTotalHandler");
        QUERIES.put("GetEmployeesByRole", "pomplatform.role.handler.GetEmployeesByRoleHandler");
        PROCESSORS.put("XieTongProjectInfoProcessor", "pomplatform.api.XieTongProjectInfoProcessor");
        DAOS.put("CustomMainProject", "pomplatform.mainProjectInfo.handler.CustomMainProjectInfoHandler");
        UPLOADPROCESSORS.put("UploadSubContract", "pomplatform.upload.UploadSubContract");
        QUERIES.put("Mprojectintegralchangerecord",
                "pomplatform.projectintegralchangerecord.handler.MprojectintegralchangerecordHandler");
        QUERIES.put("Mprojectintegraltransferrecord",
                "pomplatform.projectintegraltransferrecord.handler.MprojectintegraltransferrecordHandler");
        PROCESSORS.put("OnSetProjectIntegralChange", "pomplatform.common.business.OnSetProjectIntegralChange");
        QUERIES.put("SprojectItem", "pomplatform.projectItem.handler.SprojectItemHandler");
        PROCESSORS.put("OnProjectReserveIntegral", "pomplatform.common.business.OnProjectReserveIntegral");
        PROCESSORS.put("OnGetProjectReserveIntegral", "pomplatform.common.business.OnGetProjectReserveIntegral");
        PROCESSORS.put("ResetKeyValue", "pomplatform.common.business.OnResetKeyValue");
        PROCESSORS.put("CheckKeyValue", "pomplatform.common.business.OnCheckKeyValue");
        PROCESSORS.put("DepartmentEmployee", "pomplatform.department.business.DepartmentEmployee");
        PROCESSORS.put("DepartmentRole", "pomplatform.department.business.DepartmentRole");
        PROCESSORS.put("RoleEmployee", "pomplatform.department.business.RoleEmployee");
        PROCESSORS.put("RoleFuns", "pomplatform.department.business.RoleFuns");
        PROCESSORS.put("DepartmentRoleEmployee", "pomplatform.department.business.DepartmentRoleEmployee");
        PROCESSORS.put("DepartmentRoleFuns", "pomplatform.department.business.DepartmentRoleFuns");
        QUERIES.put("MemployeeSalary", "pomplatform.employeeSalary.handler.CustomMemployeeSalaryHandler");
        DOWNLOADPROCESSORS.put("MemployeeSalaryNew", "pomplatform.employeeSalary.handler.CustomMemployeeSalaryHandler");
        UPLOADPROCESSORS.put("UploadEmpSalary", "pomplatform.upload.OnUploadEmpSalary");
        QUERIES.put("MemployeeAward", "pomplatform.employeeAward.handler.CustomMemployeeAwardHandler");
        QUERIES.put("Sprojectattachmentpor", "pomplatform.projectattachment.handler.SprojectattachmentporHandler");
        UPLOADPROCESSORS.put("UploadProjectAttachment", "pomplatform.common.business.OnUpdateProjectAttachment");
        PROCESSORS.put("OnSetProjectAppendIntegral", "pomplatform.common.business.OnSetProjectAppendIntegral");
        QUERIES.put("Sprojectappendintegralrecordpor",
                "pomplatform.projectappendintegralrecordpor.handler.SprojectappendintegralrecordporHandler");
        QUERIES.put("Mprojectstageppsspor", "pomplatform.stagesettlement.handler.MprojectstageppssporHandler");
        DOWNLOADPROCESSORS.put("Semployeemonthlycheckymor",
                "pomplatform.check.handler.SemployeemonthlycheckymorHandler");
        QUERIES.put("Scheckinfoseor", "pomplatform.oa.handler.ScheckinfoseorHandler");
        QUERIES.put("SprojectcostporForProject", "pomplatform.operation.handler.SprojectcostporForProjectHandler");
        QUERIES.put("Mprojectppor", "pomplatform.operation.handler.MprojectpporHandler");
        QUERIES.put("Mprojectemployeeepor", "pomplatform.operation.handler.MprojectemployeeeporHandler");
        QUERIES.put("Mprojectemployeepor", "pomplatform.designer.invitation.handler.MprojectemployeeporHandler");
        DAOS.put("ProjectSettlementWithP", "pomplatform.operation.handler.ProjectSettlementWithPHandler");
        QUERIES.put("SemployeeForHR", "pomplatform.hr.handler.SemployeeForHRBiz");
        QUERIES.put("MProjectSettlementForProject",
                "pomplatform.operation.handler.MProjectSettlementForProjectHandler");
        DAOS.put("Project", "com.pomplatform.db.handler.ProjectHandler");
        QUERIES.put("Sprojectunitpricepagor", "pomplatform.projectprice.handler.SprojectunitpricepagorHandler");
        QUERIES.put("EmployeeRealAmount", "pomplatform.project.handler.EmployeeRealAmountHandler");
        QUERIES.put("Mprojectemployeeppedor", "pomplatform.myInvite.handler.MprojectemployeeppedorBiz");

        PROCESSORS.put("Mprojectemployeeepor", "pomplatform.operation.handler.MprojectemployeeeporBiz");
        QUERIES.put("Sprojectemployeepdsor", "pomplatform.projectEmployee.handler.SprojectemployeepdsorHandler");
        QUERIES.put("Semployeeedror", "pomplatform.projectteambuild.handler.SemployeeedrorHandler");
        QUERIES.put("MManagementTeamProject",
                "pomplatform.managementTeamProject.handler.MManagementTeamProjectHandler");
        QUERIES.put("SemployeeNew", "pomplatform.employeenew.handler.SemployeeNewBiz");
        QUERIES.put("Sprojectcostpor", "pomplatform.cost.handler.SprojectcostporHandler");
        QUERIES.put("MDepartmentManagerProject",
                "pomplatform.departmentManagerProject.handler.MDepartmentManagerProjectHandler");
        QUERIES.put("Semployeepdror", "pomplatform.domain.handler.SemployeepdrorHandler");

        // 项目价格表
        QUERIES.put("SprojectPricePanel", "pomplatform.projectPriceIntegral.handler.SprojectPricePanelHandler");
        PROCESSORS.put("ProjectPriceDelete", "pomplatform.projectPriceIntegral.business.ProjectPriceDelete");
        PROCESSORS.put("CreateEmployee", "pomplatform.employeenew.business.CreateEmployee");
        PROCESSORS.put("RecalculateCheckingData", "pomplatform.check.handler.RecalculateCheckingData");
        // 项目价格计算
        // 项目相关信息
        DAOS.put("ProjectWithPp", "pomplatform.projectView.handler.ProjectWithPpHandler");
        QUERIES.put("SprojectView", "pomplatform.projectView.handler.SprojectViewHandler");

        // 职位
        QUERIES.put("SemployeeDuty", "pomplatform.duty.handler.SemployeeDutyHandler");
        // 职位移除
        PROCESSORS.put("DutyDelete", "pomplatform.duty.business.DutyDelete");
        // 获取设计师项目和积分
        PROCESSORS.put("DesignerGetMsg", "pomplatform.employeenew.business.DesignerGetMsg");
        // 头像上传
        UPLOADPROCESSORS.put("FileUpLoadToImage", "pomplatform.employeenew.business.DesignerUploadPhoto");
        // 板块负责人项目
        // 运营负责人和高管项目
        // 板块运营负责人项目
        // 设计师
        // 项目团队邀请
        DAOS.put("ProjectWithP", "pomplatform.projectteambuild.handler.ProjectWithPHandler");
        QUERIES.put("Sprojectteambuild", "pomplatform.projectteambuild.handler.SprojectteambuildHandler");
        // 项目进度
        QUERIES.put("Sprojectprogrespppor", "pomplatform.projectprogress.handler.SprojectprogresppporHandler");
        // 项目日志
        QUERIES.put("Sprojectlogppoor", "pomplatform.projectlog.handler.SprojectlogppoorHandler");
        // 项目合同
        QUERIES.put("Scontractccor", "pomplatform.contract.handler.ScontractccorHandler");
        // 项目合同删除
        PROCESSORS.put("ContractDelete", "pomplatform.contract.business.ContractDelete");
        // 我的项目
        QUERIES.put("Mprojectemployeeppedsesor", "pomplatform.myProject.handler.MprojectemployeeppedsesorHandler");
        // 我的邀请
        PROCESSORS.put("ProjectInvite", "pomplatform.myInvite.business.ProjectInvite");
        // 项目费用
        QUERIES.put("Sprojectcostpcor", "pomplatform.projectCost.handler.SprojectcostpcorHandler");
        // 项目费用删除
        PROCESSORS.put("ProjectCostDelete", "pomplatform.projectCost.business.ProjectCostDelete");
        PROCESSORS.put("EmployeeCheckDetail", "pomplatform.check.handler.EmployeeCheckDetail");
        PROCESSORS.put("EmployeeCheckinout", "pomplatform.check.handler.EmployeeCheckinout");
        // 项目团队组建
        // 删除团队队员
        PROCESSORS.put("ProjectEmployeeDelete", "pomplatform.projectEmployee.business.ProjectEmployeeDelete");
        PROCESSORS.put("UpdateProjectWithStage", "pomplatform.stage.handler.UpdateProjectWithStage");
        PROCESSORS.put("OnProjectWithStageCommon", "pomplatform.stage.handler.OnProjectWithStageCommon");
        PROCESSORS.put("StageSettlementDataQuery", "pomplatform.operation.handler.StageSettlementDataQuery");
        // 项目管理
        PROCESSORS.put("ProjectNewCreate", "pomplatform.project.business.ProjectNewCreate");
        PROCESSORS.put("ProjectUpdate", "pomplatform.project.business.ProjectUpdate");
        PROCESSORS.put("ChangeIntegralProjectUpdate", "pomplatform.project.business.ChangeIntegralProjectUpdate");
        // 项目删除
        PROCESSORS.put("ProjectDelete", "pomplatform.project.business.ProjectDelete");
        // 项目积分核算
        PROCESSORS.put("ProjectIntegralExcel", "pomplatform.project.business.ProjectIntegralExcel");
        // 项目提交审核
        PROCESSORS.put("ProjectSubmitAudit", "pomplatform.project.business.ProjectSubmitAudit");
        // 项目状态操作
        PROCESSORS.put("ProjectStatus", "pomplatform.project.business.ProjectStatus");
        // 项目转移
        PROCESSORS.put("ProjectTransfer", "pomplatform.project.business.ProjectTransfer");
        // 检索邀请的队员是否都同意通过
        PROCESSORS.put("ProjectInviteCheck", "pomplatform.project.business.ProjectInviteCheck");
        // 项目经理项目立项的同时，默认把自己分配在该项目的团队中去
        PROCESSORS.put("SetProjectEmployee", "pomplatform.project.business.SetProjectEmployee");
        // 项目进入下一设计阶段
        PROCESSORS.put("ProjectEnterNext", "pomplatform.project.business.ProjectEnterNext");
        // 项目费用结算
        PROCESSORS.put("ProjectAccount", "pomplatform.project.business.ProjectAccount");
        // 项目人员释放
        PROCESSORS.put("ProjectRealIntegral", "pomplatform.projectEmployee.business.ProjectRealIntegral");
        // 员工管理
        // DAOS.put("EmployeeWithE",
        // "pomplatform.employee.handler.EmployeeWithEHandler");
        QUERIES.put("Sroleror", "pomplatform.employee.handler.SrolerorHandler");
        QUERIES.put("Semployeedsuor", "pomplatform.employee.handler.SemployeedsuorHandler");
        // 角色管理
        // DAOS.put("RoleWithR", "pomplatform.role.handler.RoleWithRHandler");
        // QUERIES.put("Sfunctionffor",
        // "pomplatform.role.handler.SfunctionfforHandler");
        // QUERIES.put("Sroleror", "pomplatform.role.handler.SrolerorHandler");
        // 角色删除
        // PROCESSORS.put("RoleDelete", "pomplatform.role.business.RoleDelete");
        // 功能管理
        QUERIES.put("Sfunctionffor", "pomplatform.funciton.handler.SfunctionfforHandler");
        // 功能删除
        PROCESSORS.put("FunctionDelete", "pomplatform.funciton.business.FunctionDelete");
        // 部门管理
        QUERIES.put("Sdepartmentdor", "pomplatform.department.handler.SdepartmentdorHandler");
        // 部门删除
        PROCESSORS.put("DepartmentDelete", "pomplatform.department.business.DepartmentDelete");
        // 员工登录
        PROCESSORS.put("EmployeeLogin", "pomplatform.employeenew.business.DefaultLoginProcessor");
        // 职员列表
        // 职员删除
        PROCESSORS.put("EmployeeDelete", "pomplatform.employeenew.business.EmployeeDelete");
        // 管理员重置密码
        PROCESSORS.put("EmployeePwdReset", "pomplatform.employeenew.business.EmployeePwdReset");
        // 职员离职设置
        PROCESSORS.put("EmployeeSetLeave", "pomplatform.employeenew.business.EmployeeSetLeave");
        // 修改密码
        PROCESSORS.put("ModifyUserPwdBiz", "pomplatform.employeenew.business.ModifyUserPwdBiz");
        // 设计师-我的邀请
        PROCESSORS.put("DesignerInvitationProcess", "pomplatform.designer.invitation.biz.DesignerInvitationProcess");
        // 设计师-我的项目
        PROCESSORS.put("DesignerRejectionProcess", "pomplatform.designer.invitation.biz.DesignerRejectionProcess");

        // 对报价单子项的操作
        PROCESSORS.put("CustomOutDesigneConsiderationHandler",
                "pomplatform.ht.handler.CustomOutDesigneConsiderationHandler");
        DOWNLOADPROCESSORS.put("CustomOutDesigneConsiderationHandler",
                "pomplatform.ht.handler.CustomOutDesigneConsiderationHandler");
        PROCESSORS.put("CustomOutRedesigneConsiderationHandler",
                "pomplatform.ht.handler.CustomOutRedesigneConsiderationHandler");
        // 对拆分价的操作
        PROCESSORS.put("CustomDesigneConsiderationHandler", "pomplatform.ht.handler.CustomDesigneConsiderationHandler");
        DOWNLOADPROCESSORS.put("CustomDesigneConsiderationHandler",
                "pomplatform.ht.handler.CustomDesigneConsiderationHandler");

        // 主子合同关联
        PROCESSORS.put("CustomSubContractHandler", "pomplatform.contract.handler.CustomSubContractHandler");
        PROCESSORS.put("CustomSubContractFlowHandler", "pomplatform.contract.handler.CustomSubContractFlowHandler");

        PROCESSORS.put("CustomMainContractHandler", "pomplatform.contract.handler.CustomMainContractHandler");

        // 发票管理
        PROCESSORS.put("CustomSinvoiceitiorHandler", "pomplatform.sinvoiceitior.handler.CustomSinvoiceitiorHandler");
        DOWNLOADPROCESSORS.put("CustomSinvoiceitiorHandler",
                "pomplatform.sinvoiceitior.handler.CustomSinvoiceitiorHandler");

        // CustomItemCollectionHandler 合同回款
        PROCESSORS.put("CustomItemCollectionHandler",
                "pomplatform.itemCollection.custom.query.CustomItemCollectionHandler");

        // 发票管理
        PROCESSORS.put("CustomerMinvoiceexpresitssccmisiiorHandler",
                "pomplatform.invoiceexpresitssccmisiior.handler.CustomerMinvoiceexpresitssccmisiiorHandler");
        DOWNLOADPROCESSORS.put("CustomerMinvoiceexpresitssccmisiiorHandler",
                "pomplatform.invoiceexpresitssccmisiior.handler.CustomerMinvoiceexpresitssccmisiiorHandler");

        WORKFLOWPROCESSORS.put("Reimbursement_travel", "delicacy.workflow.handler.ReimbursementWithRExecutor");
        DAOS.put("ReimbursementWithR", "delicacy.workflow.handler.ReimbursementWithRHandler");

        // 收款分配
        PROCESSORS.put("CollectionDistribution", "pomplatform.finance.handler.CollectionDistributionHandler");
        // 预付款数据处理
        PROCESSORS.put("PayMoneyHistoryRecordProcessor", "pomplatform.workflow.handler.PayMoneyHistoryRecordProcessor");
        // 公司日常报销
        WORKFLOWPROCESSORS.put("Company_normal_reimbursement",
                "pomplatform.workflow.commonNormalReimbursement.handler.CompanyNormalReimbursementWithDepartmentWorker");
        // DAOS.put("PlateIntegralSend",
        // "pomplatform.account.business.CustomPlateIntegralSendHandler");
        // 流程账单流水处理
        PROCESSORS.put("CustomSprocessbilllistppporProcess",
                "pomplatform.sprocessbilllistpppor.handler.CustomSprocessbilllistppporProcess");
        //专业负责人审批
        WORKFLOWPROCESSORS.put("Professional_Approval_Application", "pomplatform.projectSettlement.handler.ProfessionalApprovalApplicationWorker");
        QUERIES.put("ProfessionalApprovalApplication", "pomplatform.report.handler.ProfessionalApprovalApplicationHandler");
        QUERIES.put("OnLoadApplyListOfProfessionalApproval", "pomplatform.workflow.professional.handler.OnLoadApplyListOfProfessionalApprovalHandler");
        QUERIES.put("OnLoadAttentionListOfProfessionalApproval", "pomplatform.workflow.professional.handler.OnLoadAttentionListOfProfessionalApprovalHandler");
        //部门经理项目专业负责人审批状态
        QUERIES.put("DepartmentManagerProjectStatus", "pomplatform.operation.handler.DepartmentManagerProjectStatusHandler");
        QUERIES.put("SystemProcessInstanceActivities", "pomplatform.report.handler.SystemProcessInstanceActivitiesHandler");
        //出图统计表
        QUERIES.put("ReportMapTotals", "pomplatform.report.handler.ReportMapTotalsHandler");
        DOWNLOADPROCESSORS.put("ReportMapTotals", "pomplatform.report.handler.ReportMapTotalsHandler");
        //流程节点人员修改
        QUERIES.put("UpdateActivityEmployee", "pomplatform.workflow.handler.UpdateActivityEmployeeHandler");
        //物品管理
        QUERIES.put("Mequipmenttypeedeeeor","pomplatform.equipment.handler.MequipmenttypeedeeeorHandler");
        QUERIES.put("Mequipmentrecordedeor","pomplatform.equipment.handler.MequipmentrecordedeorHandler");
        PROCESSORS.put("UpdateEquipmentProcess","pomplatform.equipment.handler.UpdateEquipmentProcess");
        PROCESSORS.put("AddEquipmentProcess","pomplatform.equipment.handler.AddEquipmentProcess");
        DOWNLOADPROCESSORS.put("Mequipmenttypeedeeeor","pomplatform.equipment.handler.MequipmenttypeedeeeorHandler");
    }

}
