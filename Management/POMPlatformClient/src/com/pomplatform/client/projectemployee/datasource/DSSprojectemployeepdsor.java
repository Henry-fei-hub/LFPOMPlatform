package com.pomplatform.client.projectemployee.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSprojectemployeepdsor extends DBDataSource
{


	public static DSSprojectemployeepdsor instance = null;

	public static DSSprojectemployeepdsor getInstance() {
		if(instance == null) {
			instance = new DSSprojectemployeepdsor("DSSprojectemployeepdsor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectEmployeeIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField workContentField;
	private final DataSourceTextField planIntegralField;
	private final DataSourceFloatField realIntegralField;
	private final DataSourceFloatField costField;
	private final DataSourceFloatField settlementField;
	private final DataSourceDateField planStartDateField;
	private final DataSourceDateField planEndDateField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceIntegerField statusField;

	public DSSprojectemployeepdsor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sprojectemployeepdsor");


		projectEmployeeIdField = new DataSourceIntegerField("projectEmployeeId", "项目组建编码");
		projectEmployeeIdField.setLength(11);
		projectEmployeeIdField.setPrimaryKey(true);
		projectEmployeeIdField.setRequired(true);
		projectEmployeeIdField.setHidden(true);


		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		workContentField = new DataSourceTextField("workContent", "工作内容");
		workContentField.setLength(1024);
		workContentField.setRequired(false);
		workContentField.setHidden(false);


		planIntegralField = new DataSourceTextField("planIntegral", "预分配积分");
		planIntegralField.setLength(64);
		planIntegralField.setRequired(false);
		planIntegralField.setHidden(false);


		realIntegralField = new DataSourceFloatField("realIntegral", "实际获得积分");
		realIntegralField.setLength(0);
		realIntegralField.setDecimalPad(0);
		realIntegralField.setFormat("");
		realIntegralField.setRequired(false);
		realIntegralField.setHidden(false);


		costField = new DataSourceFloatField("cost", "费用");
		costField.setLength(10);
		costField.setDecimalPad(2);
		costField.setFormat("##,###,##0.00");
		costField.setRequired(false);
		costField.setHidden(false);


		settlementField = new DataSourceFloatField("settlement", "结算积分");
		settlementField.setLength(10);
		settlementField.setDecimalPad(2);
		settlementField.setFormat("##,###,##0.00");
		settlementField.setRequired(false);
		settlementField.setHidden(false);


		planStartDateField = new DataSourceDateField("planStartDate", "计划开始日期");
		planStartDateField.setRequired(false);
		planStartDateField.setHidden(false);


		planEndDateField = new DataSourceDateField("planEndDate", "计划结束日期");
		planEndDateField.setRequired(false);
		planEndDateField.setHidden(false);


		startDateField = new DataSourceDateField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);


		endDateField = new DataSourceDateField("endDate", "结束日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_4"));


		setFields(projectEmployeeIdField, projectIdField, employeeIdField, workContentField, planIntegralField, realIntegralField, costField, settlementField, planStartDateField, planEndDateField, startDateField, endDateField, statusField);
	}


}

