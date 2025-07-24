package com.pomplatform.client.contractppspcccfscsiiicpor.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSprojectpcor extends DBDataSource
{


	public static DSSprojectpcor instance = null;

	public static DSSprojectpcor getInstance() {
		if(instance == null) {
			instance = new DSSprojectpcor("DSSprojectpcor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField designTypeField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField designPhaseField;
	private final DataSourceIntegerField projectLevelField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceIntegerField workHoursField;
	private final DataSourceDateField planStartDateField;
	private final DataSourceDateField planEndDateField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceFloatField commonAreaField;
	private final DataSourceFloatField logisticsAreaField;
	private final DataSourceFloatField percentageField;
	private final DataSourceFloatField oldProjectDiscountField;
	private final DataSourceFloatField budgetField;
	private final DataSourceFloatField totalIntegralField;
	private final DataSourceFloatField reserveIntegralField;
	private final DataSourceFloatField totalAmountField;
	private final DataSourceFloatField projectIntegralField;
	private final DataSourceTextField projectProgressField;
	private final DataSourceTextField projectSizeField;
	private final DataSourceTextField projectDescriptionField;
	private final DataSourceTextField auditReasonField;
	private final DataSourceIntegerField departmentManagerIdField;
	private final DataSourceFloatField bimAreaField;
	private final DataSourceFloatField cadAreaField;
	private final DataSourceFloatField humanAmountField;
	private final DataSourceFloatField appendTotalIntegralField;
	private final DataSourceFloatField appendIntegralField;
	private final DataSourceTextField remarkField;
	private final DataSourceFloatField projectFinishPercentField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceFloatField totalFinishPercentField;
	private final DataSourceIntegerField projectGradeTypeField;
	private final DataSourceIntegerField plateManagerIdField;
	private final DataSourceFloatField lastPercentField;
	private final DataSourceFloatField complaintPercentageField;
	private final DataSourceFloatField complaintIntegralField;
	private final DataSourceIntegerField revenuePlateIdField;
	private final DataSourceFloatField sheetAmountField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField projectFlagField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField subContractIdField;
	private final DataSourceBooleanField isEcmcProjectField;
	private final DataSourceFloatField moneySumField;
	private final DataSourceIntegerField projectSetupFlagField;
	private final DataSourceFloatField progressPercentageField;
	private final DataSourceTextField totalPercentStrField;

	public DSSprojectpcor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sprojectpcor");


		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setPrimaryKey(true);
		projectIdField.setRequired(true);
		projectIdField.setHidden(true);


		contractCodeField = new DataSourceTextField("contractCode", "订单编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "订单名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		projectTypeField = new DataSourceIntegerField("projectType", "订单类别");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(true);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		designTypeField = new DataSourceIntegerField("designType", "设计类别");
		designTypeField.setLength(11);
		designTypeField.setRequired(false);
		designTypeField.setHidden(true);


		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(true);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		designPhaseField = new DataSourceIntegerField("designPhase", "设计阶段");
		designPhaseField.setLength(11);
		designPhaseField.setRequired(false);
		designPhaseField.setHidden(true);


		projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级");
		projectLevelField.setLength(11);
		projectLevelField.setRequired(false);
		projectLevelField.setHidden(true);


		statusField = new DataSourceIntegerField("status", "项目状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(true);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_39"));


		projectManageIdField = new DataSourceIntegerField("projectManageId", "专业负责人");
		projectManageIdField.setLength(11);
		projectManageIdField.setRequired(false);
		projectManageIdField.setHidden(false);
		projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		workHoursField = new DataSourceIntegerField("workHours", "预估工时");
		workHoursField.setLength(11);
		workHoursField.setRequired(false);
		workHoursField.setHidden(true);


		planStartDateField = new DataSourceDateField("planStartDate", "项目计划开始日期");
		planStartDateField.setRequired(false);
		planStartDateField.setHidden(true);


		planEndDateField = new DataSourceDateField("planEndDate", "项目计划结束日期");
		planEndDateField.setRequired(false);
		planEndDateField.setHidden(true);


		startDateField = new DataSourceDateField("startDate", "项目开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(true);


		endDateField = new DataSourceDateField("endDate", "项目结束日期");
		endDateField.setRequired(false);
		endDateField.setHidden(true);


		commonAreaField = new DataSourceFloatField("commonArea", "公区面积");
		commonAreaField.setLength(10);
		commonAreaField.setDecimalPad(2);
		commonAreaField.setFormat("##,###,##0.00");
		commonAreaField.setRequired(false);
		commonAreaField.setHidden(true);


		logisticsAreaField = new DataSourceFloatField("logisticsArea", "后勤面积");
		logisticsAreaField.setLength(10);
		logisticsAreaField.setDecimalPad(2);
		logisticsAreaField.setFormat("##,###,##0.00");
		logisticsAreaField.setRequired(false);
		logisticsAreaField.setHidden(true);


		percentageField = new DataSourceFloatField("percentage", "核算比例");
		percentageField.setLength(10);
		percentageField.setDecimalPad(5);
		percentageField.setFormat("##,##0.00000");
		percentageField.setRequired(false);
		percentageField.setHidden(true);


		oldProjectDiscountField = new DataSourceFloatField("oldProjectDiscount", "遗留项目折算");
		oldProjectDiscountField.setLength(10);
		oldProjectDiscountField.setDecimalPad(5);
		oldProjectDiscountField.setFormat("##,##0.00000");
		oldProjectDiscountField.setRequired(false);
		oldProjectDiscountField.setHidden(true);


		budgetField = new DataSourceFloatField("budget", "预算");
		budgetField.setLength(18);
		budgetField.setDecimalPad(2);
		budgetField.setFormat("#,###,###,###,###,##0.00");
		budgetField.setRequired(false);
		budgetField.setHidden(true);


		totalIntegralField = new DataSourceFloatField("totalIntegral", "项目总积分");
		totalIntegralField.setLength(18);
		totalIntegralField.setDecimalPad(2);
		totalIntegralField.setFormat("#,###,###,###,###,##0.00");
		totalIntegralField.setRequired(false);
		totalIntegralField.setHidden(false);


		reserveIntegralField = new DataSourceFloatField("reserveIntegral", "预留积分");
		reserveIntegralField.setLength(18);
		reserveIntegralField.setDecimalPad(2);
		reserveIntegralField.setFormat("#,###,###,###,###,##0.00");
		reserveIntegralField.setRequired(false);
		reserveIntegralField.setHidden(true);


		totalAmountField = new DataSourceFloatField("totalAmount", "项目总金额");
		totalAmountField.setLength(18);
		totalAmountField.setDecimalPad(2);
		totalAmountField.setFormat("#,###,###,###,###,##0.00");
		totalAmountField.setRequired(false);
		totalAmountField.setHidden(true);


		projectIntegralField = new DataSourceFloatField("projectIntegral", "项目积分");
		projectIntegralField.setLength(18);
		projectIntegralField.setDecimalPad(2);
		projectIntegralField.setFormat("#,###,###,###,###,##0.00");
		projectIntegralField.setRequired(false);
		projectIntegralField.setHidden(false);


		projectProgressField = new DataSourceTextField("projectProgress", "项目进度");
		projectProgressField.setLength(64);
		projectProgressField.setRequired(false);
		projectProgressField.setHidden(true);


		projectSizeField = new DataSourceTextField("projectSize", "项目大小");
		projectSizeField.setLength(64);
		projectSizeField.setRequired(false);
		projectSizeField.setHidden(true);


		projectDescriptionField = new DataSourceTextField("projectDescription", "项目描述");
		projectDescriptionField.setLength(2048);
		projectDescriptionField.setRequired(false);
		projectDescriptionField.setHidden(true);


		auditReasonField = new DataSourceTextField("auditReason", "审核意见");
		auditReasonField.setLength(1024);
		auditReasonField.setRequired(false);
		auditReasonField.setHidden(true);


		departmentManagerIdField = new DataSourceIntegerField("departmentManagerId", "部门经理");
		departmentManagerIdField.setLength(11);
		departmentManagerIdField.setRequired(false);
		departmentManagerIdField.setHidden(false);
		departmentManagerIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		bimAreaField = new DataSourceFloatField("bimArea", "BIM面积");
		bimAreaField.setLength(10);
		bimAreaField.setDecimalPad(2);
		bimAreaField.setFormat("##,###,##0.00");
		bimAreaField.setRequired(false);
		bimAreaField.setHidden(true);


		cadAreaField = new DataSourceFloatField("cadArea", "设计面积");
		cadAreaField.setLength(10);
		cadAreaField.setDecimalPad(2);
		cadAreaField.setFormat("##,###,##0.00");
		cadAreaField.setRequired(false);
		cadAreaField.setHidden(true);


		humanAmountField = new DataSourceFloatField("humanAmount", "手工计算积分");
		humanAmountField.setLength(18);
		humanAmountField.setDecimalPad(2);
		humanAmountField.setFormat("#,###,###,###,###,##0.00");
		humanAmountField.setRequired(false);
		humanAmountField.setHidden(true);


		appendTotalIntegralField = new DataSourceFloatField("appendTotalIntegral", "追加总积分");
		appendTotalIntegralField.setLength(10);
		appendTotalIntegralField.setDecimalPad(2);
		appendTotalIntegralField.setFormat("##,###,##0.00");
		appendTotalIntegralField.setRequired(false);
		appendTotalIntegralField.setHidden(true);


		appendIntegralField = new DataSourceFloatField("appendIntegral", "追加积分");
		appendIntegralField.setLength(10);
		appendIntegralField.setDecimalPad(2);
		appendIntegralField.setFormat("##,###,##0.00");
		appendIntegralField.setRequired(false);
		appendIntegralField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(true);
		remarkField.setHidden(true);


		projectFinishPercentField = new DataSourceFloatField("projectFinishPercent", "项目完成百分比");
		projectFinishPercentField.setLength(10);
		projectFinishPercentField.setDecimalPad(2);
		projectFinishPercentField.setFormat("##,###,##0.00");
		projectFinishPercentField.setRequired(false);
		projectFinishPercentField.setHidden(true);


		parentIdField = new DataSourceIntegerField("parentId", "是否为630项目，0是   1不是       默认值为0");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);
//		parentIdField.setValueMap(KeyValueManager.getValueMap("project_types"));
		KeyValueManager.loadValueMap("project_types", parentIdField);


		totalFinishPercentField = new DataSourceFloatField("totalFinishPercent", "项目总完成百分比");
		totalFinishPercentField.setLength(10);
		totalFinishPercentField.setDecimalPad(2);
		totalFinishPercentField.setFormat("##,###,##0.00");
		totalFinishPercentField.setRequired(false);
		totalFinishPercentField.setHidden(true);


		projectGradeTypeField = new DataSourceIntegerField("projectGradeType", "2配合专业项目)");
		projectGradeTypeField.setLength(11);
		projectGradeTypeField.setRequired(false);
		projectGradeTypeField.setHidden(true);


		plateManagerIdField = new DataSourceIntegerField("plateManagerId", "事业部负责人");
		plateManagerIdField.setLength(11);
		plateManagerIdField.setRequired(false);
		plateManagerIdField.setHidden(true);
		plateManagerIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		lastPercentField = new DataSourceFloatField("lastPercent", "上次结算时的百分比");
		lastPercentField.setLength(10);
		lastPercentField.setDecimalPad(2);
		lastPercentField.setFormat("##,###,##0.00");
		lastPercentField.setRequired(false);
		lastPercentField.setHidden(true);


		complaintPercentageField = new DataSourceFloatField("complaintPercentage", "投诉折算比例");
		complaintPercentageField.setLength(10);
		complaintPercentageField.setDecimalPad(5);
		complaintPercentageField.setFormat("##,##0.00000");
		complaintPercentageField.setRequired(false);
		complaintPercentageField.setHidden(true);


		complaintIntegralField = new DataSourceFloatField("complaintIntegral", "投诉保证金");
		complaintIntegralField.setLength(18);
		complaintIntegralField.setDecimalPad(2);
		complaintIntegralField.setFormat("#,###,###,###,###,##0.00");
		complaintIntegralField.setRequired(false);
		complaintIntegralField.setHidden(true);


		revenuePlateIdField = new DataSourceIntegerField("revenuePlateId", "统计营收板块");
		revenuePlateIdField.setLength(11);
		revenuePlateIdField.setRequired(false);
		revenuePlateIdField.setHidden(true);


		sheetAmountField = new DataSourceFloatField("sheetAmount", "订单合同金额");
		sheetAmountField.setLength(18);
		sheetAmountField.setDecimalPad(2);
		sheetAmountField.setFormat("#,###,###,###,###,##0.00");
		sheetAmountField.setRequired(false);
		sheetAmountField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		projectFlagField = new DataSourceIntegerField("projectFlag", "2研发项目)");
		projectFlagField.setLength(11);
		projectFlagField.setRequired(false);
		projectFlagField.setHidden(true);


		businessTypeField = new DataSourceIntegerField("businessType", "业务类别");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);
		contractIdField.setForeignKey("DSMcontractppspcccfscsiiicpor.contractId");


		subContractIdField = new DataSourceIntegerField("subContractId", "子合同编码");
		subContractIdField.setLength(11);
		subContractIdField.setRequired(false);
		subContractIdField.setHidden(true);


		isEcmcProjectField = new DataSourceBooleanField("isEcmcProject", "true是");
		isEcmcProjectField.setRequired(false);
		isEcmcProjectField.setHidden(true);


		moneySumField = new DataSourceFloatField("moneySum", "合同金额");
		moneySumField.setLength(18);
		moneySumField.setDecimalPad(2);
		moneySumField.setFormat("#,###,###,###,###,##0.00");
		moneySumField.setRequired(false);
		moneySumField.setHidden(true);


		projectSetupFlagField = new DataSourceIntegerField("projectSetupFlag", ")");
		projectSetupFlagField.setLength(11);
		projectSetupFlagField.setRequired(false);
		projectSetupFlagField.setHidden(true);
		
		
		progressPercentageField = new DataSourceFloatField("progressPercentage","项目进度(%)");//弃用
		progressPercentageField.setDecimalPad(2);
		progressPercentageField.setFormat("#,###,###,###,###,##0.00");
		progressPercentageField.setRequired(true);
		progressPercentageField.setHidden(true);
		
		totalPercentStrField = new DataSourceTextField("totalPercentStr", "项目进度(%)");
		totalPercentStrField.setLength(18);
		totalPercentStrField.setRequired(true);
		totalPercentStrField.setHidden(false);
		


		setFields(projectIdField, contractCodeField, projectCodeField, projectNameField, projectTypeField, plateIdField, designTypeField, departmentIdField, designPhaseField, projectLevelField, statusField, projectManageIdField, workHoursField, planStartDateField, planEndDateField, startDateField, endDateField, commonAreaField, logisticsAreaField, percentageField, oldProjectDiscountField, budgetField, totalIntegralField, reserveIntegralField, totalAmountField, projectIntegralField, projectProgressField, projectSizeField, projectDescriptionField, auditReasonField, departmentManagerIdField, bimAreaField, cadAreaField, humanAmountField, appendTotalIntegralField, appendIntegralField, remarkField, projectFinishPercentField, parentIdField, totalFinishPercentField, projectGradeTypeField, plateManagerIdField, lastPercentField, complaintPercentageField, complaintIntegralField, revenuePlateIdField, sheetAmountField, createTimeField, projectFlagField, businessTypeField, contractIdField, subContractIdField, isEcmcProjectField, moneySumField, projectSetupFlagField,totalPercentStrField);
	}


}

