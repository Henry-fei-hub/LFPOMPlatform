package com.pomplatform.client.onemployeedayplaterecords.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;

public class DSOnEmployeeDayPlateRecords extends DBDataSource
{


	public static DSOnEmployeeDayPlateRecords instance = null;

	public static DSOnEmployeeDayPlateRecords getInstance() {
		if(instance == null) {
			instance = new DSOnEmployeeDayPlateRecords("DSOnEmployeeDayPlateRecords");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeDayPlateRecordIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceDateField recordDateField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField onboardStatusField;

	public DSOnEmployeeDayPlateRecords(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnEmployeeDayPlateRecords");


		employeeDayPlateRecordIdField = new DataSourceIntegerField("employeeDayPlateRecordId", "主键编码");
		employeeDayPlateRecordIdField.setLength(11);
		employeeDayPlateRecordIdField.setPrimaryKey(true);
		employeeDayPlateRecordIdField.setRequired(false);
		employeeDayPlateRecordIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "职员姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(false);
		ComboBoxItem employeeIdItem = new ComboBoxItem("employeeId");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdField.setEditorProperties(employeeIdItem);
//		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",employeeIdField);
		employeeIdField.setCanEdit(false);


		employeeNoField = new DataSourceTextField("employeeNo", "职员工号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);
		employeeNoField.setCanEdit(false);


		employeeNameField = new DataSourceTextField("employeeName", "职员姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(true);


		recordDateField = new DataSourceDateField("recordDate", "记录日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);
		recordDateField.setCanEdit(false);


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);
		yearField.setCanEdit(false);


		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(false);
		monthField.setCanEdit(false);


		companyIdField = new DataSourceIntegerField("companyId", "所属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		KeyValueManager.loadValueMap("company_records", companyIdField);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		departmentIdField = new DataSourceIntegerField("departmentId", "所属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
		
		onboardStatusField = new DataSourceIntegerField("onboardStatus", "人事状态");
		onboardStatusField.setLength(11);
		onboardStatusField.setRequired(false);
		onboardStatusField.setHidden(false);
		onboardStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_96"));


		setFields(employeeDayPlateRecordIdField, employeeNoField, employeeIdField, employeeNameField, recordDateField, yearField, monthField, companyIdField, plateIdField, departmentIdField,onboardStatusField);
	}


}

