package com.pomplatform.client.employeedetail.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSureIntegralDetail extends DataSource
{


	public static CDSureIntegralDetail instance = null;

	public static CDSureIntegralDetail getInstance() {
		if(instance == null) {
			instance = new CDSureIntegralDetail("CDSureIntegralDetail");
		}
		return instance;
	}

	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceIntegerField employeeIdField;

	public CDSureIntegralDetail(String dataSourceID) {

		setID(dataSourceID);
		startDateField = new DataSourceDateField("startDate", "结算日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "结算日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "人员");
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


		setFields(startDateField, endDateField, employeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

