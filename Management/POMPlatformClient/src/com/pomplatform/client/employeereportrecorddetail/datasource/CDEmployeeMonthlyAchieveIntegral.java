package com.pomplatform.client.employeereportrecorddetail.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDEmployeeMonthlyAchieveIntegral extends DataSource
{


	public static CDEmployeeMonthlyAchieveIntegral instance = null;

	public static CDEmployeeMonthlyAchieveIntegral getInstance() {
		if(instance == null) {
			instance = new CDEmployeeMonthlyAchieveIntegral("CDEmployeeMonthlyAchieveIntegral");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceDateField recordDateField;

	public CDEmployeeMonthlyAchieveIntegral(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		recordDateField = new DataSourceDateField("recordDate", "记录产生时间");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);

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


		setFields(plateIdField, recordDateField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

