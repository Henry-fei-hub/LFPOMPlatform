package com.pomplatform.client.shift.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadEmployeeShiftDetailOfShift extends DataSource
{


	public static CDOnLoadEmployeeShiftDetailOfShift instance = null;

	public static CDOnLoadEmployeeShiftDetailOfShift getInstance() {
		if(instance == null) {
			instance = new CDOnLoadEmployeeShiftDetailOfShift("CDOnLoadEmployeeShiftDetailOfShift");
		}
		return instance;
	}

	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField genderField;

	public CDOnLoadEmployeeShiftDetailOfShift(String dataSourceID) {

		setID(dataSourceID);
		startDateField = new DataSourceDateField("startDate", "记录日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "记录日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setRequired(true);
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		genderField = new DataSourceIntegerField("gender", "性别");
		genderField.setRequired(false);
		genderField.setLength(11);
		genderField.setHidden(false);
		genderField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(startDateField, endDateField, employeeNoField, employeeNameField, departmentIdField, genderField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

