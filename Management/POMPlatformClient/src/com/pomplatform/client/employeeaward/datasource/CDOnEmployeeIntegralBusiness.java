package com.pomplatform.client.employeeaward.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnEmployeeIntegralBusiness extends DataSource
{


	public static CDOnEmployeeIntegralBusiness instance = null;

	public static CDOnEmployeeIntegralBusiness getInstance() {
		if(instance == null) {
			instance = new CDOnEmployeeIntegralBusiness("CDOnEmployeeIntegralBusiness");
		}
		return instance;
	}

	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField businessTypeNameField;

	public CDOnEmployeeIntegralBusiness(String dataSourceID) {

		setID(dataSourceID);
		startDateField = new DataSourceDateField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "截止日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		businessTypeNameField = new DataSourceTextField("businessTypeName", "业务功能名称");
		businessTypeNameField.setRequired(false);
		businessTypeNameField.setLength(64);
		businessTypeNameField.setHidden(false);

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


		setFields(startDateField, endDateField, statusField, businessTypeNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

