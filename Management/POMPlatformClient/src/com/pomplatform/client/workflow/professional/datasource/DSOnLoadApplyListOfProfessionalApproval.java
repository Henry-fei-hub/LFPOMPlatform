package com.pomplatform.client.workflow.professional.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadApplyListOfProfessionalApproval extends DBDataSource
{


	public static DSOnLoadApplyListOfProfessionalApproval instance = null;

	public static DSOnLoadApplyListOfProfessionalApproval getInstance() {
		if(instance == null) {
			instance = new DSOnLoadApplyListOfProfessionalApproval("DSOnLoadApplyListOfProfessionalApproval");
		}
		return instance;
	}

	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField businessNameField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceActivityIdField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceIntegerField professionalApproval_idField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceDateTimeField startDateField;
	private final DataSourceIntegerField deleteFlagField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField designTypeField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceIntegerField plateManagerIdField;
	private final DataSourceIntegerField projectLevelField;
	private final DataSourceIntegerField departmentManagerIdField;
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceTextField projectManageNameField;
	private final DataSourceIntegerField projectManageDepartmentIdField;
	private final DataSourceFloatField commonAreaField;
	private final DataSourceFloatField logisticsAreaField;
	private final DataSourceFloatField cadAreaField;
	private final DataSourceFloatField totalIntegralField;
	private final DataSourceFloatField projectIntegralField;
	private final DataSourceFloatField reserveIntegralField;
	private final DataSourceFloatField percentageField;

	public DSOnLoadApplyListOfProfessionalApproval(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadApplyListOfProfessionalApproval");


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "主键编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setPrimaryKey(true);
		processInstanceIdField.setRequired(true);
		processInstanceIdField.setHidden(true);


		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);


		businessNameField = new DataSourceTextField("businessName", "业务名称");
		businessNameField.setLength(256);
		businessNameField.setRequired(false);
		businessNameField.setHidden(true);


		processIdField = new DataSourceIntegerField("processId", "流程编码");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);


		processInstanceActivityIdField = new DataSourceIntegerField("processInstanceActivityId", "活动实列编码");
		processInstanceActivityIdField.setLength(11);
		processInstanceActivityIdField.setRequired(false);
		processInstanceActivityIdField.setHidden(true);


		processStatusField = new DataSourceIntegerField("processStatus", "流程状态 0 发起中  1");
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(true);


		completeTimeField = new DataSourceDateTimeField("completeTime", "完成时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(true);


		professionalApproval_idField = new DataSourceIntegerField("professionalApproval_id", "专业负责人审批编码");
		professionalApproval_idField.setLength(11);
		professionalApproval_idField.setPrimaryKey(true);
		professionalApproval_idField.setRequired(true);
		professionalApproval_idField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "创建人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(32);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);
		employeeNoField.setValueMap(KeyValueManager.getValueMap(""));


		startDateField = new DataSourceDateTimeField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);


		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除状态  0未删除    1已删除");
		deleteFlagField.setLength(11);
		deleteFlagField.setRequired(false);
		deleteFlagField.setHidden(true);


		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(true);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(true);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		designTypeField = new DataSourceIntegerField("designType", "业务类别");
		designTypeField.setLength(11);
		designTypeField.setRequired(false);
		designTypeField.setHidden(false);
		designTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));


		projectTypeField = new DataSourceIntegerField("projectType", "项目类别");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));


		plateManagerIdField = new DataSourceIntegerField("plateManagerId", "事业部负责人");
		plateManagerIdField.setLength(11);
		plateManagerIdField.setRequired(false);
		plateManagerIdField.setHidden(false);


		projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级");
		projectLevelField.setLength(11);
		projectLevelField.setRequired(false);
		projectLevelField.setHidden(false);
		projectLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));


		departmentManagerIdField = new DataSourceIntegerField("departmentManagerId", "部门经理");
		departmentManagerIdField.setLength(11);
		departmentManagerIdField.setRequired(false);
		departmentManagerIdField.setHidden(false);
		departmentManagerIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		projectManageIdField = new DataSourceIntegerField("projectManageId", "积分管理员");
		projectManageIdField.setLength(11);
		projectManageIdField.setRequired(false);
		projectManageIdField.setHidden(true);
		projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		projectManageNameField = new DataSourceTextField("projectManageName", "专业负责人");
		projectManageNameField.setLength(512);
		projectManageNameField.setRequired(false);
		projectManageNameField.setHidden(false);


		projectManageDepartmentIdField = new DataSourceIntegerField("projectManageDepartmentId", "专业负责人部门");
		projectManageDepartmentIdField.setLength(11);
		projectManageDepartmentIdField.setRequired(false);
		projectManageDepartmentIdField.setHidden(false);
		projectManageDepartmentIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


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


		cadAreaField = new DataSourceFloatField("cadArea", "设计面积");
		cadAreaField.setLength(10);
		cadAreaField.setDecimalPad(2);
		cadAreaField.setFormat("##,###,##0.00");
		cadAreaField.setRequired(false);
		cadAreaField.setHidden(false);


		totalIntegralField = new DataSourceFloatField("totalIntegral", "项目总积分");
		totalIntegralField.setLength(18);
		totalIntegralField.setDecimalPad(2);
		totalIntegralField.setFormat("#,###,###,###,###,##0.00");
		totalIntegralField.setRequired(false);
		totalIntegralField.setHidden(false);


		projectIntegralField = new DataSourceFloatField("projectIntegral", "项目积分");
		projectIntegralField.setLength(18);
		projectIntegralField.setDecimalPad(2);
		projectIntegralField.setFormat("#,###,###,###,###,##0.00");
		projectIntegralField.setRequired(false);
		projectIntegralField.setHidden(false);


		reserveIntegralField = new DataSourceFloatField("reserveIntegral", "预留积分");
		reserveIntegralField.setLength(18);
		reserveIntegralField.setDecimalPad(2);
		reserveIntegralField.setFormat("#,###,###,###,###,##0.00");
		reserveIntegralField.setRequired(false);
		reserveIntegralField.setHidden(false);


		percentageField = new DataSourceFloatField("percentage", "核算比例%");
		percentageField.setLength(10);
		percentageField.setDecimalPad(5);
		percentageField.setFormat("##,##0.00");
		percentageField.setRequired(false);
		percentageField.setHidden(false);

		setFields(processInstanceIdField, professionalApproval_idField, businessIdField, businessNameField, processIdField, processInstanceActivityIdField, processStatusField, completeTimeField, employeeIdField, employeeNoField, startDateField, deleteFlagField, projectIdField, projectCodeField, projectNameField, contractIdField, contractCodeField, contractNameField, plateIdField, designTypeField, projectTypeField, plateManagerIdField, projectLevelField, departmentManagerIdField, projectManageIdField, projectManageNameField, projectManageDepartmentIdField, commonAreaField, logisticsAreaField, cadAreaField, totalIntegralField, projectIntegralField, reserveIntegralField, percentageField);
	}


}

