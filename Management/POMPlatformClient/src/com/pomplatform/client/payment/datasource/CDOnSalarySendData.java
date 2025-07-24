package com.pomplatform.client.payment.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnSalarySendData extends DataSource
{


	public static CDOnSalarySendData instance = null;

	public static CDOnSalarySendData getInstance() {
		if(instance == null) {
			instance = new CDOnSalarySendData("CDOnSalarySendData");
		}
		return instance;
	}

	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;

	public CDOnSalarySendData(String dataSourceID) {

		setID(dataSourceID);
		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(true);
		yearField.setLength(11);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setRequired(true);
		monthField.setLength(11);
		monthField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setRequired(true);
		employeeNoField.setLength(0);
		employeeNoField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(0);
		employeeNameField.setHidden(false);

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


		setFields(yearField, monthField, companyIdField, employeeNoField, employeeNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

