package com.pomplatform.client.account.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSEmpAccountMonthReportSource extends DBDataSource {

	public static DSEmpAccountMonthReportSource instance = null;

	public static DSEmpAccountMonthReportSource getInstance() {
		if (instance == null) {
			instance = new DSEmpAccountMonthReportSource("DSEmpAccountMonthReportSource");
		}
		return instance;
	}

	private final DataSourceIntegerField businessTypeIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceFloatField integralField;

	public DSEmpAccountMonthReportSource(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("AchieveIntegral");
		
		businessTypeIdField = new DataSourceIntegerField("businessTypeId", "业务类型");
		businessTypeIdField.setLength(18);
		businessTypeIdField.setHidden(false);
		businessTypeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_66"));
		
		employeeIdField = new DataSourceIntegerField("employeeId", "职员ID");
		employeeIdField.setLength(18);
		employeeIdField.setHidden(true);

		employeeNoField = new DataSourceTextField("employeeNo", "职员编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);
		
		employeeNameField = new DataSourceTextField("employeeName", "职员姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(false);
		
		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(18);
		yearField.setHidden(false);
		
		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(18);
		monthField.setHidden(false);

		integralField = new DataSourceFloatField("integral", "积分");
		integralField.setLength(18);
		integralField.setDecimalPad(2);
		integralField.setFormat("#,###,###,###,###,##0.00");
		integralField.setRequired(false);
		integralField.setHidden(false);

		setFields(businessTypeIdField,employeeIdField,employeeNoField, employeeNameField,yearField, monthField,integralField);
	}

}
