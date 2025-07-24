package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDReportSureIntegralDetail extends DataSource
{


	public static CDReportSureIntegralDetail instance = null;

	public static CDReportSureIntegralDetail getInstance() {
		if(instance == null) {
			instance = new CDReportSureIntegralDetail("CDReportSureIntegralDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceTextField sheetCodeField;
	private final DataSourceTextField projectNameField;

	public CDReportSureIntegralDetail(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(true);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(true);
		yearField.setLength(11);
		yearField.setHidden(false);

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


		setFields(plateIdField, yearField, sheetCodeField, projectNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

