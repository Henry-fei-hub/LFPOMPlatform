package com.pomplatform.client.onemployeedayplaterecords.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnEmployeeDayPlateRecords extends DataSource
{


	public static CDOnEmployeeDayPlateRecords instance = null;

	public static CDOnEmployeeDayPlateRecords getInstance() {
		if(instance == null) {
			instance = new CDOnEmployeeDayPlateRecords("CDOnEmployeeDayPlateRecords");
		}
		return instance;
	}

	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceDateField recordDateField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;

	public CDOnEmployeeDayPlateRecords(String dataSourceID) {

		setID(dataSourceID);
		employeeNoField = new DataSourceTextField("employeeNo", "职员工号");
		employeeNoField.setRequired(false);
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "职员id");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
//		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",employeeIdField);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		recordDateField = new DataSourceDateField("recordDate", "记录日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setRequired(false);
		monthField.setLength(11);
		monthField.setHidden(false);

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


		setFields(employeeNoField, employeeIdField, plateIdField, recordDateField, yearField, monthField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

