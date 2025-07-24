package com.pomplatform.client.workflow.personnelbusiness.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDPlateSalaryAdjustmentSummary extends DataSource
{


	public static CDPlateSalaryAdjustmentSummary instance = null;

	public static CDPlateSalaryAdjustmentSummary getInstance() {
		if(instance == null) {
			instance = new CDPlateSalaryAdjustmentSummary("CDPlateSalaryAdjustmentSummary");
		}
		return instance;
	}

	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceIntegerField plateIdField;

	public CDPlateSalaryAdjustmentSummary(String dataSourceID) {

		setID(dataSourceID);
		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);
		yearField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setRequired(false);
		monthField.setLength(11);
		monthField.setHidden(false);
		monthField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(true);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

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


		setFields(yearField, monthField, plateIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

