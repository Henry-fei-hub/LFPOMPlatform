package com.pomplatform.client.workflow.personnelbusiness.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDEmployeeSalaryAdjustmentDetail extends DataSource
{


	public static CDEmployeeSalaryAdjustmentDetail instance = null;

	public static CDEmployeeSalaryAdjustmentDetail getInstance() {
		if(instance == null) {
			instance = new CDEmployeeSalaryAdjustmentDetail("CDEmployeeSalaryAdjustmentDetail");
		}
		return instance;
	}

	private final DataSourceDateTimeField yearField;
	private final DataSourceDateTimeField monthField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField employeeIdField;

	public CDEmployeeSalaryAdjustmentDetail(String dataSourceID) {

		setID(dataSourceID);
		yearField = new DataSourceDateTimeField("year", "年份");
		yearField.setRequired(false);
		yearField.setHidden(false);

		monthField = new DataSourceDateTimeField("month", "月份");
		monthField.setRequired(false);
		monthField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(true);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		employeeIdField = new DataSourceIntegerField("employeeId", "姓名");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

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


		setFields(yearField, monthField, plateIdField, employeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

