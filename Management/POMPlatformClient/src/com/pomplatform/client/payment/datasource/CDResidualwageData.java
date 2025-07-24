package com.pomplatform.client.payment.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDResidualwageData extends DataSource
{


	public static CDResidualwageData instance = null;

	public static CDResidualwageData getInstance() {
		if(instance == null) {
			instance = new CDResidualwageData("CDResidualwageData");
		}
		return instance;
	}

	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;

	public CDResidualwageData(String dataSourceID) {

		setID(dataSourceID);
		yearField = new DataSourceIntegerField("year", "undefined");
		yearField.setRequired(true);
		yearField.setLength(11);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "undefined");
		monthField.setRequired(true);
		monthField.setLength(11);
		monthField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "undefined");
		companyIdField.setRequired(true);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "undefined");
		employeeNoField.setRequired(true);
		employeeNoField.setLength(0);
		employeeNoField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "undefined");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(0);
		employeeNameField.setHidden(false);
		employeeNameField.setValueMap(KeyValueManager.getValueMap("departments"));

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

