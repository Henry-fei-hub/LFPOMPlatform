package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDReportOnEmployeeNumTotal extends DataSource
{


	public static CDReportOnEmployeeNumTotal instance = null;

	public static CDReportOnEmployeeNumTotal getInstance() {
		if(instance == null) {
			instance = new CDReportOnEmployeeNumTotal("CDReportOnEmployeeNumTotal");
		}
		return instance;
	}

	private final DataSourceTextField yearField;
	private final DataSourceIntegerField plateIdField;

	public CDReportOnEmployeeNumTotal(String dataSourceID) {

		setID(dataSourceID);
		yearField = new DataSourceTextField("year", "年份");
		yearField.setRequired(true);
		yearField.setLength(11);
		yearField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(true);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));

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


		setFields(yearField, plateIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

