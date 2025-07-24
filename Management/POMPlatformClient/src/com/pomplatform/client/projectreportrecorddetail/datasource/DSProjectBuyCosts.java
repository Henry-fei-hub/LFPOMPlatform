package com.pomplatform.client.projectreportrecorddetail.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSProjectBuyCosts extends DBDataSource
{


	public static DSProjectBuyCosts instance = null;

	public static DSProjectBuyCosts getInstance() {
		if(instance == null) {
			instance = new DSProjectBuyCosts("DSProjectBuyCosts");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField designPhaseField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceDateField planStartDateField;
	private final DataSourceDateField planEndDateField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceIntegerField statusField;
	private final DataSourceFloatField commonAreaField;
	private final DataSourceFloatField logisticsAreaField;
	private final DataSourceFloatField percentageField;
	private final DataSourceFloatField totalIntegralField;
	private final DataSourceFloatField reserveIntegralField;
	private final DataSourceFloatField costIntegralField;
	private final DataSourceFloatField leftIntegralField;
	private final DataSourceTextField projectDescriptionField;
	private final DataSourceIntegerField projectLevelField;
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceIntegerField departmentManagerIdField;
	private final DataSourceIntegerField plateManagerIdField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField customerNameField;
	
	public DSProjectBuyCosts(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ProjectBuyCosts");


		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setPrimaryKey(true);
		projectIdField.setRequired(true);
		projectIdField.setHidden(true);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "合同名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		designPhaseField = new DataSourceIntegerField("designPhase", "设计阶段");
		designPhaseField.setLength(11);
		designPhaseField.setRequired(false);
		designPhaseField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		planStartDateField = new DataSourceDateField("planStartDate", "项目计划开始日期");
		planStartDateField.setRequired(false);
		planStartDateField.setHidden(false);


		planEndDateField = new DataSourceDateField("planEndDate", "项目计划结束日期");
		planEndDateField.setRequired(false);
		planEndDateField.setHidden(false);


		startDateField = new DataSourceDateField("startDate", "项目开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);


		endDateField = new DataSourceDateField("endDate", "项目结束日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "项目状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_4"));


		commonAreaField = new DataSourceFloatField("commonArea", "公区面积");
		commonAreaField.setLength(10);
		commonAreaField.setDecimalPad(2);
		commonAreaField.setFormat("##,###,##0.00");
		commonAreaField.setRequired(false);
		commonAreaField.setHidden(false);


		logisticsAreaField = new DataSourceFloatField("logisticsArea", "后勤面积");
		logisticsAreaField.setLength(10);
		logisticsAreaField.setDecimalPad(2);
		logisticsAreaField.setFormat("##,###,##0.00");
		logisticsAreaField.setRequired(false);
		logisticsAreaField.setHidden(false);


		percentageField = new DataSourceFloatField("percentage", "核算比例");
		percentageField.setLength(10);
		percentageField.setDecimalPad(5);
		percentageField.setFormat("##,##0.00000");
		percentageField.setRequired(false);
		percentageField.setHidden(false);


		totalIntegralField = new DataSourceFloatField("totalIntegral", "订单额度");
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


		costIntegralField = new DataSourceFloatField("costIntegral", "订单成本");
		costIntegralField.setLength(18);
		costIntegralField.setDecimalPad(2);
		costIntegralField.setFormat("#,###,###,###,###,##0.00");
		costIntegralField.setRequired(true);
		costIntegralField.setHidden(false);


		leftIntegralField = new DataSourceFloatField("leftIntegral", "订单剩余额度");
		leftIntegralField.setLength(18);
		leftIntegralField.setDecimalPad(2);
		leftIntegralField.setFormat("#,###,###,###,###,##0.00");
		leftIntegralField.setRequired(true);
		leftIntegralField.setHidden(false);


		projectDescriptionField = new DataSourceTextField("projectDescription", "项目描述");
		projectDescriptionField.setLength(2048);
		projectDescriptionField.setRequired(false);
		projectDescriptionField.setHidden(false);


		projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级");
		projectLevelField.setLength(11);
		projectLevelField.setRequired(false);
		projectLevelField.setHidden(false);
		projectLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));


		projectManageIdField = new DataSourceIntegerField("projectManageId", "专业负责人");
		projectManageIdField.setLength(11);
		projectManageIdField.setRequired(false);
		projectManageIdField.setHidden(false);
		projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		departmentManagerIdField = new DataSourceIntegerField("departmentManagerId", "部门经理");
		departmentManagerIdField.setLength(11);
		departmentManagerIdField.setRequired(false);
		departmentManagerIdField.setHidden(false);
		departmentManagerIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		

		plateManagerIdField = new DataSourceIntegerField("plateManagerId", "事业部负责人");
		plateManagerIdField.setLength(11);
		plateManagerIdField.setRequired(false);
		plateManagerIdField.setHidden(true);
		plateManagerIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		contractNameField = new DataSourceTextField("contractName", "项目名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);
		
		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setLength(512);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);
		

		setFields(projectIdField, contractCodeField, projectNameField,customerNameField, plateIdField, departmentIdField, designPhaseField, projectCodeField,contractNameField, planStartDateField, planEndDateField, startDateField, endDateField, statusField, commonAreaField, logisticsAreaField, percentageField, totalIntegralField, reserveIntegralField, costIntegralField, leftIntegralField, projectDescriptionField, projectLevelField, projectManageIdField, departmentManagerIdField, plateManagerIdField);
	}


}

