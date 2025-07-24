package com.pomplatform.client.report.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSReportEmployeeDailyHoursTotal extends DBDataSource
{


	public static DSReportEmployeeDailyHoursTotal instance = null;

	public static DSReportEmployeeDailyHoursTotal getInstance() {
		if(instance == null) {
			instance = new DSReportEmployeeDailyHoursTotal("DSReportEmployeeDailyHoursTotal");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceDateField workDateField;
	private final DataSourceFloatField workHourField;
	private final DataSourceFloatField coefficientField;
	private final DataSourceFloatField statisticalWorkHourField;
	private final DataSourceIntegerField projectNumberField;

	public DSReportEmployeeDailyHoursTotal(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ReportEmployeeDailyHoursTotal");


		employeeIdField = new DataSourceIntegerField("employeeId", "员工姓名");
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(true);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));
		plateIdField.setHidden(false);


		workDateField = new DataSourceDateField("workDate", "日期");
		workDateField.setRequired(false);
		workDateField.setHidden(false);


		workHourField = new DataSourceFloatField("workHour", "填报工时");
		workHourField.setLength(10);
		workHourField.setDecimalPad(1);
		workHourField.setFormat("###,###,##0.0");
		workHourField.setRequired(false);
		workHourField.setHidden(false);


		coefficientField = new DataSourceFloatField("coefficient", "职级系数");
		coefficientField.setLength(32);
		coefficientField.setDecimalPad(2);
		coefficientField.setFormat("###,###,###,###,###,###,###,###,###,##0.00");
		coefficientField.setRequired(false);
		coefficientField.setHidden(false);


		statisticalWorkHourField = new DataSourceFloatField("statisticalWorkHour", "统计工时");
		statisticalWorkHourField.setLength(18);
		statisticalWorkHourField.setDecimalPad(2);
		statisticalWorkHourField.setFormat("#,###,###,###,###,##0.00");
		statisticalWorkHourField.setRequired(true);
		statisticalWorkHourField.setHidden(false);


		projectNumberField = new DataSourceIntegerField("projectNumber", "项目数");
		projectNumberField.setLength(-1);
		projectNumberField.setRequired(true);
		projectNumberField.setHidden(false);


		setFields(employeeIdField, employeeNoField, employeeNameField, plateIdField, workDateField, workHourField, coefficientField, statisticalWorkHourField, projectNumberField);
	}


}

