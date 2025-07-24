package com.pomplatform.client.manageprojectemployeerecordeachmonth.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSManageProjectEmployeeRecordEachMonth extends DBDataSource
{


	public static DSManageProjectEmployeeRecordEachMonth instance = null;

	public static DSManageProjectEmployeeRecordEachMonth getInstance() {
		if(instance == null) {
			instance = new DSManageProjectEmployeeRecordEachMonth("DSManageProjectEmployeeRecordEachMonth");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceFloatField assignedIntegralField;

	public DSManageProjectEmployeeRecordEachMonth(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ManageProjectEmployeeRecordEachMonth");


		employeeIdField = new DataSourceIntegerField("employeeId", "员工姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(true);
		yearField.setHidden(false);
		yearField.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));


		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(true);
		monthField.setHidden(false);
		monthField.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));


		assignedIntegralField = new DataSourceFloatField("assignedIntegral", "补贴奖金");
		assignedIntegralField.setLength(10);
		assignedIntegralField.setDecimalPad(2);
		assignedIntegralField.setFormat("##,###,##0.00");
		assignedIntegralField.setRequired(false);
		assignedIntegralField.setHidden(false);


		setFields(employeeIdField, employeeNoField, yearField, monthField, assignedIntegralField);
	}


}

