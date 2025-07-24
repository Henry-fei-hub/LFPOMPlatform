package com.pomplatform.client.account.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSureIntegralAndProjectCostDetail extends DataSource
{


	public static CDSureIntegralAndProjectCostDetail instance = null;

	public static CDSureIntegralAndProjectCostDetail getInstance() {
		if(instance == null) {
			instance = new CDSureIntegralAndProjectCostDetail("CDSureIntegralAndProjectCostDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField businessTypeIdField;

	public CDSureIntegralAndProjectCostDetail(String dataSourceID) {

		setID(dataSourceID);
		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(true);
		yearField.setLength(11);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setRequired(true);
		monthField.setLength(11);
		monthField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "所在业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		employeeIdField = new DataSourceIntegerField("employeeId", "职员编码");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		businessTypeIdField = new DataSourceIntegerField("businessTypeId", "业务类型");
		businessTypeIdField.setRequired(false);
		businessTypeIdField.setLength(11);
		businessTypeIdField.setHidden(false);

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


		setFields(yearField, monthField, plateIdField, employeeIdField, businessTypeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

