package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnBusinessLineRevenueDetailData extends DataSource
{


	public static CDOnBusinessLineRevenueDetailData instance = null;

	public static CDOnBusinessLineRevenueDetailData getInstance() {
		if(instance == null) {
			instance = new CDOnBusinessLineRevenueDetailData("CDOnBusinessLineRevenueDetailData");
		}
		return instance;
	}

	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField businessLineField;
	private final DataSourceTextField sheetCodeField;
	private final DataSourceTextField projectNameField;

	public CDOnBusinessLineRevenueDetailData(String dataSourceID) {

		setID(dataSourceID);
		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		businessLineField = new DataSourceIntegerField("businessLine", "业务条线");
		businessLineField.setRequired(false);
		businessLineField.setLength(11);
		businessLineField.setHidden(false);
//		businessLineField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));
		businessLineField.setValueMap(KeyValueManager.getValueMap("system_dictionary_205"));

		sheetCodeField = new DataSourceTextField("sheetCode", "合同编号");
		sheetCodeField.setRequired(false);
		sheetCodeField.setLength(64);
		sheetCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
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


		setFields(yearField, plateIdField, businessLineField, sheetCodeField, projectNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

