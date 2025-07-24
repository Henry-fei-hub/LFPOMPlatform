package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDReportCapitaProjectDetail extends DataSource
{


	public static CDReportCapitaProjectDetail instance = null;

	public static CDReportCapitaProjectDetail getInstance() {
		if(instance == null) {
			instance = new CDReportCapitaProjectDetail("CDReportCapitaProjectDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceTextField sheetCodeField;
	private final DataSourceTextField projectNameField;

	public CDReportCapitaProjectDetail(String dataSourceID) {

		setID(dataSourceID);
		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(true);
		yearField.setLength(11);
		yearField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(true);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		sheetCodeField = new DataSourceTextField("sheetCode", "订单编号");
		sheetCodeField.setRequired(true);
		sheetCodeField.setLength(0);
		sheetCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "订单名称");
		projectNameField.setRequired(true);
		projectNameField.setLength(0);
		projectNameField.setHidden(false);

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


		setFields(yearField, plateIdField, sheetCodeField, projectNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

