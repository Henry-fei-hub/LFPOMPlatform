package com.pomplatform.client.employee.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnboardEmployeeEachMonth extends DataSource
{


	public static CDOnboardEmployeeEachMonth instance = null;

	public static CDOnboardEmployeeEachMonth getInstance() {
		if(instance == null) {
			instance = new CDOnboardEmployeeEachMonth("CDOnboardEmployeeEachMonth");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceIntegerField yearField;

	public CDOnboardEmployeeEachMonth(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		startDateField = new DataSourceDateField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "截止日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(true);
		yearField.setLength(11);
		yearField.setHidden(false);

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


		setFields(plateIdField, startDateField, endDateField, yearField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

