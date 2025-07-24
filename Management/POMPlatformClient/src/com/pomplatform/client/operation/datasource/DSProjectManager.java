package com.pomplatform.client.operation.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSProjectManager extends DBDataSource {

	public static DSProjectManager instance = null;

	public static DSProjectManager getInstance() {
		if (instance == null) {
			instance = new DSProjectManager("DSProjectManager");
		}
		return instance;
	}

	private final DataSourceTextField subContractNameField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceIntegerField designTypeField;
	private final DataSourceIntegerField projectLevelField;
	private final DataSourceTextField projectManageIdField;
	private final DataSourceFloatField commonAreaField;
	private final DataSourceFloatField logisticsAreaField;
	private final DataSourceFloatField bimAreaField;
	private final DataSourceFloatField cadAreaField;
	private final DataSourceFloatField totalIntegralField;
	private final DataSourceFloatField reserveIntegralField;
	private final DataSourceFloatField sureIntegralField;
	private final DataSourceFloatField projectIntegralField;
	private final DataSourceFloatField totalAmountField;
	private final DataSourceFloatField percentageField;
	private final DataSourceFloatField humanAmountField;
	private final DataSourceFloatField oldProjectDiscountField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField designPhaseField;
	private final DataSourceIntegerField workHoursField;
	private final DataSourceDateField planStartDateField;
	private final DataSourceDateField planEndDateField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceFloatField budgetField;
	private final DataSourceTextField projectProgressField;
	private final DataSourceTextField projectSizeField;
	private final DataSourceTextField projectDescriptionField;
	private final DataSourceTextField auditReasonField;
	private final DataSourceIntegerField departmentManagerIdField;
	private final DataSourceFloatField appendTotalIntegralField;
	private final DataSourceFloatField appendIntegralField;
	private final DataSourceTextField remarkField;
	private final DataSourceFloatField projectFinishPercentField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceFloatField totalFinishPercentField;
	private final DataSourceIntegerField plateManagerIdField;
	private final DataSourceFloatField lastPercentField;
	private final DataSourceIntegerField projectGradeTypeField;
	private final DataSourceFloatField complaintIntegralField;
	private final DataSourceFloatField complaintPercentageField;
	private final DataSourceTextField projectNameField;
	private final DataSourceFloatField sheetAmountField;
	private final DataSourceIntegerField projectFlagField;
	private final DataSourceFloatField leftSureIntegralField;
	private final DataSourceFloatField plateSureIntegralField;
	private final DataSourceFloatField leftPlateSureIntegralField;
	private final DataSourceFloatField progressPercentageField;
	private final DataSourceFloatField percentSumField;
	private final DataSourceDateField createTimeField;
	private final DataSourceIntegerField msgCountField;
	private final DataSourceIntegerField msgStatusField;
	private final DataSourceTextField employeeNameTostring3Field;
	private final DataSourceTextField employeeNameTostring5Field;
	private final DataSourceIntegerField preProjectTypeField;

	public DSProjectManager(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ProjectManager");

		subContractNameField = new DataSourceTextField("subContractName", "合同名称");
		subContractNameField.setLength(64);
		subContractNameField.setRequired(false);
		subContractNameField.setHidden(true);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);

		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setPrimaryKey(true);
		projectIdField.setRequired(true);
		projectIdField.setHidden(true);
//		KeyValueManager.loadValueMap("projects",projectIdField);

		projectIdField.setRootValue("root");
		projectIdField.setForeignKey("DSProjectManager.projectId");

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		projectTypeField = new DataSourceIntegerField("projectType", "项目类别");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));

		designTypeField = new DataSourceIntegerField("designType", "业务类别");
		designTypeField.setLength(11);
		designTypeField.setRequired(false);
		designTypeField.setHidden(true);
		designTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));

		projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级");
		projectLevelField.setLength(11);
		projectLevelField.setRequired(false);
		projectLevelField.setHidden(false);
		projectLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));

		projectManageIdField = new DataSourceTextField("projectManageId", "专业负责人");
		projectManageIdField.setLength(11);
		projectManageIdField.setRequired(false);
		projectManageIdField.setHidden(false);
		projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));

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
		reserveIntegralField.setHidden(false);

		projectIntegralField = new DataSourceFloatField("projectIntegral", "项目积分");
		projectIntegralField.setLength(18);
		projectIntegralField.setDecimalPad(2);
		projectIntegralField.setFormat("#,###,###,###,###,##0.00");
		projectIntegralField.setRequired(false);
		projectIntegralField.setHidden(false);

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

		totalAmountField = new DataSourceFloatField("totalAmount", "项目总金额");
		totalAmountField.setLength(18);
		totalAmountField.setDecimalPad(2);
		totalAmountField.setFormat("#,###,###,###,###,##0.00");
		totalAmountField.setRequired(false);
		totalAmountField.setHidden(true);

		percentageField = new DataSourceFloatField("percentage", "核算比例%");
		percentageField.setLength(10);
		percentageField.setDecimalPad(2);
		percentageField.setFormat("##,##0.00");
		percentageField.setRequired(false);
		percentageField.setHidden(false);

		oldProjectDiscountField = new DataSourceFloatField("oldProjectDiscount", "遗留项目折算%");
		oldProjectDiscountField.setLength(10);
		oldProjectDiscountField.setDecimalPad(5);
		oldProjectDiscountField.setFormat("##,##0.00000");
		oldProjectDiscountField.setRequired(false);
		oldProjectDiscountField.setHidden(true);

		statusField = new DataSourceIntegerField("status", "项目状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_4"));

		contractCodeField = new DataSourceTextField("contractCode", "订单编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);
//		contractCodeField.setValueMap(KeyValueManager.getValueMap("sub_contract_codes"));
		KeyValueManager.loadValueMap("sub_contract_codes", contractCodeField);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(true);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		designPhaseField = new DataSourceIntegerField("designPhase", "设计阶段");
		designPhaseField.setLength(11);
		designPhaseField.setRequired(false);
		designPhaseField.setHidden(true);
		designPhaseField.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));

		workHoursField = new DataSourceIntegerField("workHours", "预估工时");
		workHoursField.setLength(11);
		workHoursField.setRequired(false);
		workHoursField.setHidden(true);

		planStartDateField = new DataSourceDateField("planStartDate", "计划开始日期");
		planStartDateField.setRequired(false);
		planStartDateField.setHidden(true);

		planEndDateField = new DataSourceDateField("planEndDate", "计划结束日期");
		planEndDateField.setRequired(false);
		planEndDateField.setHidden(true);

		startDateField = new DataSourceDateField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(true);

		endDateField = new DataSourceDateField("endDate", "结束日期");
		endDateField.setRequired(false);
		endDateField.setHidden(true);

		budgetField = new DataSourceFloatField("budget", "预算");
		budgetField.setLength(18);
		budgetField.setDecimalPad(2);
		budgetField.setFormat("#,###,###,###,###,##0.00");
		budgetField.setRequired(false);
		budgetField.setHidden(true);

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

		appendTotalIntegralField = new DataSourceFloatField("appendTotalIntegral", "追加总积分");
		appendTotalIntegralField.setLength(18);
		appendTotalIntegralField.setDecimalPad(2);
		appendTotalIntegralField.setFormat("#,###,###,###,###,##0.00");
		appendTotalIntegralField.setRequired(false);
		appendTotalIntegralField.setHidden(true);

		appendIntegralField = new DataSourceFloatField("appendIntegral", "追加积分");
		appendIntegralField.setLength(18);
		appendIntegralField.setDecimalPad(2);
		appendIntegralField.setFormat("#,###,###,###,###,##0.00");
		appendIntegralField.setRequired(false);
		appendIntegralField.setHidden(true);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(true);

		projectFinishPercentField = new DataSourceFloatField("projectFinishPercent", "项目进度比(%)");
		projectFinishPercentField.setLength(18);
		projectFinishPercentField.setDecimalPad(2);
		projectFinishPercentField.setFormat("#,###,###,###,###,##0.00");
		projectFinishPercentField.setRequired(false);
		projectFinishPercentField.setHidden(false);

		parentIdField = new DataSourceIntegerField("parentId", "父级项目");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);
//		parentIdField.setValueMap(KeyValueManager.getValueMap("projects"));
		KeyValueManager.loadValueMap("projects",parentIdField);

		totalFinishPercentField = new DataSourceFloatField("totalFinishPercent", "合同完成百分比(%)");
		totalFinishPercentField.setLength(18);
		totalFinishPercentField.setDecimalPad(2);
		totalFinishPercentField.setFormat("#,###,###,###,###,##0.00");
		totalFinishPercentField.setRequired(false);
		totalFinishPercentField.setHidden(true);

		plateManagerIdField = new DataSourceIntegerField("plateManagerId", "事业部负责人");
		plateManagerIdField.setLength(11);
		plateManagerIdField.setRequired(false);
		plateManagerIdField.setHidden(true);
		plateManagerIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		projectGradeTypeField = new DataSourceIntegerField("projectGradeType", "项目级别类型");
		projectGradeTypeField.setLength(64);
		projectGradeTypeField.setRequired(false);
		projectGradeTypeField.setHidden(true);
		projectGradeTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_25"));

		lastPercentField = new DataSourceFloatField("lastPercent", "1231完工比(%)");
		lastPercentField.setLength(10);
		lastPercentField.setDecimalPad(2);
		lastPercentField.setFormat("##,###,##0.00");
		lastPercentField.setRequired(false);
		lastPercentField.setHidden(true);

		humanAmountField = new DataSourceFloatField("humanAmount", "手工计算积分");
		humanAmountField.setLength(18);
		humanAmountField.setDecimalPad(2);
		humanAmountField.setFormat("#,###,###,###,###,##0.00");
		humanAmountField.setRequired(false);
		humanAmountField.setHidden(true);

		sureIntegralField = new DataSourceFloatField("sureIntegral", "确认积分");
		sureIntegralField.setLength(18);
		sureIntegralField.setDecimalPad(2);
		sureIntegralField.setFormat("#,###,###,###,###,##0.00");
		sureIntegralField.setRequired(true);
		sureIntegralField.setHidden(false);

		complaintIntegralField = new DataSourceFloatField("complaintIntegral", "投诉保证金");
		complaintIntegralField.setLength(18);
		complaintIntegralField.setDecimalPad(2);
		complaintIntegralField.setFormat("#,###,###,###,###,##0.00");
		complaintIntegralField.setRequired(false);
		complaintIntegralField.setHidden(false);
		
		percentSumField = new DataSourceFloatField("percentSum", "阶段比例(%)");
		percentSumField.setLength(18);
		percentSumField.setDecimalPad(2);
		percentSumField.setFormat("#,###,###,###,###,##0.00");
		percentSumField.setRequired(false);
		percentSumField.setHidden(false);

		complaintPercentageField = new DataSourceFloatField("complaintPercentage", "投诉折算比例");
		complaintPercentageField.setLength(10);
		complaintPercentageField.setDecimalPad(5);
		complaintPercentageField.setFormat("##,##0.00000");
		complaintPercentageField.setRequired(false);
		complaintPercentageField.setHidden(true);
		
		sheetAmountField = new DataSourceFloatField("sheetAmount", "订单合同金额");
		sheetAmountField.setLength(18);
		sheetAmountField.setDecimalPad(2);
		sheetAmountField.setFormat("##,##0.00000");
		sheetAmountField.setRequired(false);
		sheetAmountField.setHidden(true);
		
		projectFlagField = new DataSourceIntegerField("projectFlag", "订单类别");
		projectFlagField.setLength(64);
		projectFlagField.setRequired(false);
		projectFlagField.setHidden(false);
		projectFlagField.setValueMap(KeyValueManager.getValueMap("system_dictionary_71"));
		
		leftSureIntegralField = new DataSourceFloatField("leftSureIntegral","剩余确认积分");
		leftSureIntegralField.setLength(18);
		leftSureIntegralField.setDecimalPad(2);
		leftSureIntegralField.setFormat("#,###,###,###,###,##0.00");
		leftSureIntegralField.setRequired(true);
		leftSureIntegralField.setHidden(false);
		
		plateSureIntegralField = new DataSourceFloatField("plateSureIntegral","部门确认积分");
		plateSureIntegralField.setLength(18);
		plateSureIntegralField.setDecimalPad(2);
		plateSureIntegralField.setFormat("#,###,###,###,###,##0.00");
		plateSureIntegralField.setRequired(true);
		plateSureIntegralField.setHidden(false);
		
		leftPlateSureIntegralField = new DataSourceFloatField("leftPlateSureIntegral","部门剩余确认积分");
		leftPlateSureIntegralField.setLength(18);
		leftPlateSureIntegralField.setDecimalPad(2);
		leftPlateSureIntegralField.setFormat("#,###,###,###,###,##0.00");
		leftPlateSureIntegralField.setRequired(true);
		leftPlateSureIntegralField.setHidden(false);
		
		progressPercentageField = new DataSourceFloatField("progressPercentage","项目进度百分比(%)");
		progressPercentageField.setDecimalPad(2);
		progressPercentageField.setFormat("#,###,###,###,###,##0.00");
		progressPercentageField.setRequired(true);
		progressPercentageField.setHidden(false);
		
		createTimeField = new DataSourceDateField("createTime", "订单下达日期");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);

		msgCountField = new DataSourceIntegerField("msgCount", "消息推送次数");
		msgCountField.setLength(11);
		msgCountField.setRequired(false);
		msgCountField.setHidden(false);

		msgStatusField = new DataSourceIntegerField("msgStatus", "消息状态 ");
		msgStatusField.setLength(11);
		msgStatusField.setRequired(false);
		msgStatusField.setHidden(false);
		msgStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_243"));
		
		preProjectTypeField = new DataSourceIntegerField("preProjectType", "立项项目类型");
		preProjectTypeField.setLength(11);
		preProjectTypeField.setRequired(false);
		preProjectTypeField.setHidden(false);
		preProjectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_244"));

		employeeNameTostring3Field = new DataSourceTextField("employeeNameTostring3", "项目经理");
		employeeNameTostring3Field.setLength(32);
		employeeNameTostring3Field.setRequired(true);
		employeeNameTostring3Field.setHidden(false);
		
		employeeNameTostring5Field = new DataSourceTextField("employeeNameTostring5", "项目负责人");
		employeeNameTostring5Field.setLength(32);
		employeeNameTostring5Field.setRequired(true);
		employeeNameTostring5Field.setHidden(false);



		setFields(projectIdField, contractCodeField, subContractNameField, projectCodeField, projectNameField,
				parentIdField, plateIdField, designTypeField,preProjectTypeField, projectTypeField, projectLevelField, plateManagerIdField,
				departmentManagerIdField, projectManageIdField,employeeNameTostring3Field,employeeNameTostring5Field, commonAreaField, logisticsAreaField, bimAreaField,
				cadAreaField, totalIntegralField, appendTotalIntegralField, percentageField, oldProjectDiscountField,
				projectIntegralField, reserveIntegralField, complaintIntegralField,percentSumField, sureIntegralField,leftSureIntegralField,
				lastPercentField,progressPercentageField,projectFinishPercentField,plateSureIntegralField,leftPlateSureIntegralField, totalFinishPercentField, totalAmountField, statusField, departmentIdField,
				designPhaseField, workHoursField, planStartDateField, planEndDateField, startDateField, endDateField,
				budgetField, projectProgressField, projectSizeField, projectDescriptionField, auditReasonField,
				humanAmountField, projectGradeTypeField, appendIntegralField, remarkField, complaintPercentageField,
				sheetAmountField, projectFlagField,createTimeField,	msgCountField,msgStatusField);
	}
}
