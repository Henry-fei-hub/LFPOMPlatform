package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadInAchieveDetail extends DataSource
{


	public static CDOnLoadInAchieveDetail instance = null;

	public static CDOnLoadInAchieveDetail getInstance() {
		if(instance == null) {
			instance = new CDOnLoadInAchieveDetail("CDOnLoadInAchieveDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField lastYearField;
	private final DataSourceIntegerField lastMonthField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField sheetCodeField;
	private final DataSourceTextField sheetNameField;

	public CDOnLoadInAchieveDetail(String dataSourceID) {

		setID(dataSourceID);
		lastYearField = new DataSourceIntegerField("lastYear", "年份");
		lastYearField.setRequired(false);
		lastYearField.setLength(11);
		lastYearField.setHidden(false);

		lastMonthField = new DataSourceIntegerField("lastMonth", "月份");
		lastMonthField.setRequired(false);
		lastMonthField.setLength(11);
		lastMonthField.setHidden(false);

		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects", projectIdField);
		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setRequired(false);
		monthField.setLength(11);
		monthField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		sheetCodeField = new DataSourceTextField("sheetCode", "订单编号");
		sheetCodeField.setRequired(false);
		sheetCodeField.setLength(64);
		sheetCodeField.setHidden(false);

		sheetNameField = new DataSourceTextField("sheetName", "订单名称");
		sheetNameField.setRequired(false);
		sheetNameField.setLength(512);
		sheetNameField.setHidden(false);

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


		setFields(lastYearField, lastMonthField, projectIdField, yearField, monthField, plateIdField, contractCodeField, contractNameField, sheetCodeField, sheetNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

