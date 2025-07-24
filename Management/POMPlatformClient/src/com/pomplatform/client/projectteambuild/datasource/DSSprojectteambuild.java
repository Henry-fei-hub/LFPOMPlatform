package com.pomplatform.client.projectteambuild.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSprojectteambuild extends DBDataSource
{


	public static DSSprojectteambuild instance = null;

	public static DSSprojectteambuild getInstance() {
		if(instance == null) {
			instance = new DSSprojectteambuild("DSSprojectteambuild");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField workHoursField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField designPhaseField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceDateField planStartDateField;
	private final DataSourceDateField planEndDateField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField projectProgressField;
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceTextField projectManageNameField;
	private final DataSourceTextField projectSizeField;
	private final DataSourceTextField projectIntegralField;
	private final DataSourceTextField projectDescriptionField;
	private final DataSourceTextField budgetField;
	private final DataSourceTextField auditReasonField;
	private final DataSourceIntegerField projectLevelField;
	private final DataSourceField detailProjectEmployee;

	public DSSprojectteambuild(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sprojectteambuild");


		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setPrimaryKey(true);
		projectIdField.setRequired(true);
		projectIdField.setHidden(false);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setLength(512);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);


		workHoursField = new DataSourceTextField("workHours", "预估工时");
		workHoursField.setLength(64);
		workHoursField.setRequired(false);
		workHoursField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);


		designPhaseField = new DataSourceIntegerField("designPhase", "设计阶段");
		designPhaseField.setLength(11);
		designPhaseField.setRequired(false);
		designPhaseField.setHidden(false);


		projectTypeField = new DataSourceIntegerField("projectType", "项目类型");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


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


		projectProgressField = new DataSourceTextField("projectProgress", "项目进度");
		projectProgressField.setLength(64);
		projectProgressField.setRequired(false);
		projectProgressField.setHidden(true);


		projectManageIdField = new DataSourceIntegerField("projectManageId", "项目负责人编码");
		projectManageIdField.setLength(11);
		projectManageIdField.setRequired(false);
		projectManageIdField.setHidden(true);


		projectManageNameField = new DataSourceTextField("projectManageName", "项目负责人姓名");
		projectManageNameField.setLength(64);
		projectManageNameField.setRequired(false);
		projectManageNameField.setHidden(true);


		projectSizeField = new DataSourceTextField("projectSize", "项目大小");
		projectSizeField.setLength(64);
		projectSizeField.setRequired(false);
		projectSizeField.setHidden(true);


		projectIntegralField = new DataSourceTextField("projectIntegral", "项目积分");
		projectIntegralField.setLength(64);
		projectIntegralField.setRequired(false);
		projectIntegralField.setHidden(true);


		projectDescriptionField = new DataSourceTextField("projectDescription", "项目描述");
		projectDescriptionField.setLength(512);
		projectDescriptionField.setRequired(false);
		projectDescriptionField.setHidden(true);


		budgetField = new DataSourceTextField("budget", "预算");
		budgetField.setLength(50);
		budgetField.setRequired(false);
		budgetField.setHidden(true);


		auditReasonField = new DataSourceTextField("auditReason", "审核意见");
		auditReasonField.setLength(1024);
		auditReasonField.setRequired(false);
		auditReasonField.setHidden(true);


		projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级");
		projectLevelField.setLength(11);
		projectLevelField.setRequired(false);
		projectLevelField.setHidden(true);

		detailProjectEmployee = new DataSourceField("detailProjectEmployee", FieldType.ANY);
		detailProjectEmployee.setChildrenProperty(true);
		detailProjectEmployee.setChildTagName("ProjectEmployee");
		detailProjectEmployee.setRequired(false);
		detailProjectEmployee.setHidden(true);

		setFields(projectIdField, contractCodeField, contractNameField, customerNameField, workHoursField, departmentIdField, designPhaseField, projectTypeField, projectCodeField, projectNameField, planStartDateField, planEndDateField, startDateField, endDateField, statusField, projectProgressField, projectManageIdField, projectManageNameField, projectSizeField, projectIntegralField, projectDescriptionField, budgetField, auditReasonField, projectLevelField, detailProjectEmployee);
	}


}

