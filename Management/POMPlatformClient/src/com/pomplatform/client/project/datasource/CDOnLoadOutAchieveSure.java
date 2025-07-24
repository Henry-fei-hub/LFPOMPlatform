package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadOutAchieveSure extends DataSource
{


	public static CDOnLoadOutAchieveSure instance = null;

	public static CDOnLoadOutAchieveSure getInstance() {
		if(instance == null) {
			instance = new CDOnLoadOutAchieveSure("CDOnLoadOutAchieveSure");
		}
		return instance;
	}

	private final DataSourceIntegerField lastYearField;
	private final DataSourceIntegerField lastMonthField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;

	public CDOnLoadOutAchieveSure(String dataSourceID) {

		setID(dataSourceID);
		lastYearField = new DataSourceIntegerField("lastYear", "年份");
		lastYearField.setRequired(false);
		lastYearField.setLength(11);
		lastYearField.setHidden(false);

		lastMonthField = new DataSourceIntegerField("lastMonth", "月份");
		lastMonthField.setRequired(false);
		lastMonthField.setLength(11);
		lastMonthField.setHidden(false);

		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setRequired(false);
		monthField.setLength(11);
		monthField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

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


		setFields(lastYearField, lastMonthField, contractIdField, yearField, monthField, contractCodeField, contractNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

