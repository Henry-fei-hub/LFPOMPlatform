package com.pomplatform.client.getprojectbycontract.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSGetProjectByContract extends DBDataSource
{


	public static DSGetProjectByContract instance = null;

	public static DSGetProjectByContract getInstance() {
		if(instance == null) {
			instance = new DSGetProjectByContract("DSGetProjectByContract");
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

	public DSGetProjectByContract(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("GetProjectByContract");


		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setPrimaryKey(true);
		projectIdField.setRequired(true);
		projectIdField.setHidden(false);
		KeyValueManager.loadValueMap("projects",projectIdField);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		projectTypeField = new DataSourceIntegerField("projectType", "项目类型");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		plateIdField = new DataSourceIntegerField("plateId", "板块");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);


		designTypeField = new DataSourceIntegerField("designType", "设计类型");
		designTypeField.setLength(11);
		designTypeField.setRequired(false);
		designTypeField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		designPhaseField = new DataSourceIntegerField("designPhase", "设计阶段");
		designPhaseField.setLength(11);
		designPhaseField.setRequired(false);
		designPhaseField.setHidden(false);
		designPhaseField.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));


		projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级");
		projectLevelField.setLength(11);
		projectLevelField.setRequired(false);
		projectLevelField.setHidden(false);
		projectLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));


		statusField = new DataSourceIntegerField("status", "项目状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_16"));


		projectManageIdField = new DataSourceIntegerField("projectManageId", "专业负责人");
		projectManageIdField.setLength(11);
		projectManageIdField.setRequired(false);
		projectManageIdField.setHidden(false);


		workHoursField = new DataSourceIntegerField("workHours", "预估工时");
		workHoursField.setLength(11);
		workHoursField.setRequired(false);
		workHoursField.setHidden(false);


		planStartDateField = new DataSourceDateField("planStartDate", "项目计划开始日期");
		planStartDateField.setRequired(false);
		planStartDateField.setHidden(false);


		planEndDateField = new DataSourceDateField("planEndDate", "项目计划结束日期");
		planEndDateField.setRequired(false);
		planEndDateField.setHidden(false);


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
		totalIntegralField.setHidden(true);


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
		projectIntegralField.setHidden(true);


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
		departmentManagerIdField.setHidden(true);


		bimAreaField = new DataSourceFloatField("bimArea", "BIM面积");
		bimAreaField.setLength(10);
		bimAreaField.setDecimalPad(2);
		bimAreaField.setFormat("##,###,##0.00");
		bimAreaField.setRequired(false);
		bimAreaField.setHidden(true);


		cadAreaField = new DataSourceFloatField("cadArea", "CAD面积");
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


		parentIdField = new DataSourceIntegerField("parentId", "父级项目");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);
//		parentIdField.setValueMap(KeyValueManager.getValueMap("contracts_1"));
		KeyValueManager.loadValueMap("contracts_1", parentIdField);

		totalFinishPercentField = new DataSourceFloatField("totalFinishPercent", "项目总完成百分比");
		totalFinishPercentField.setLength(10);
		totalFinishPercentField.setDecimalPad(2);
		totalFinishPercentField.setFormat("##,###,##0.00");
		totalFinishPercentField.setRequired(false);
		totalFinishPercentField.setHidden(true);


		projectGradeTypeField = new DataSourceIntegerField("projectGradeType", "项目级别类型");
		projectGradeTypeField.setLength(11);
		projectGradeTypeField.setRequired(false);
		projectGradeTypeField.setHidden(true);


		plateManagerIdField = new DataSourceIntegerField("plateManagerId", "事业部负责人");
		plateManagerIdField.setLength(11);
		plateManagerIdField.setRequired(false);
		plateManagerIdField.setHidden(true);


		lastPercentField = new DataSourceFloatField("lastPercent", "上次结算时的百分比");
		lastPercentField.setLength(10);
		lastPercentField.setDecimalPad(2);
		lastPercentField.setFormat("##,###,##0.00");
		lastPercentField.setRequired(false);
		lastPercentField.setHidden(true);


		setFields(projectIdField, contractCodeField, projectCodeField, projectNameField, projectTypeField, plateIdField, designTypeField, departmentIdField, designPhaseField, projectLevelField, statusField, projectManageIdField, workHoursField, planStartDateField, planEndDateField, startDateField, endDateField, commonAreaField, logisticsAreaField, percentageField, oldProjectDiscountField, budgetField, totalIntegralField, reserveIntegralField, totalAmountField, projectIntegralField, projectProgressField, projectSizeField, projectDescriptionField, auditReasonField, departmentManagerIdField, bimAreaField, cadAreaField, humanAmountField, appendTotalIntegralField, appendIntegralField, remarkField, projectFinishPercentField, parentIdField, totalFinishPercentField, projectGradeTypeField, plateManagerIdField, lastPercentField);
	}


}

