package com.pomplatform.client.employeedetail.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDManagerProjectIntegralDetail extends DataSource
{


	public static CDManagerProjectIntegralDetail instance = null;

	public static CDManagerProjectIntegralDetail getInstance() {
		if(instance == null) {
			instance = new CDManagerProjectIntegralDetail("CDManagerProjectIntegralDetail");
		}
		return instance;
	}

	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceIntegerField employeeIdField;

	public CDManagerProjectIntegralDetail(String dataSourceID) {

		setID(dataSourceID);
		startDateField = new DataSourceDateField("startDate", "发放日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "发放日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "发放成员");
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

