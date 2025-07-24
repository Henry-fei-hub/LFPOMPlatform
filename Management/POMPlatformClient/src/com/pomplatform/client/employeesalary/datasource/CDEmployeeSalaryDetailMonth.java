package com.pomplatform.client.employeesalary.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDEmployeeSalaryDetailMonth extends DataSource
{


	public static CDEmployeeSalaryDetailMonth instance = null;

	public static CDEmployeeSalaryDetailMonth getInstance() {
		if(instance == null) {
			instance = new CDEmployeeSalaryDetailMonth("CDEmployeeSalaryDetailMonth");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField startYearField;
	private final DataSourceIntegerField startYearStartMonthField;
	private final DataSourceIntegerField startYearEndMonthField;
	private final DataSourceIntegerField bigThenStartYearField;
	private final DataSourceIntegerField lessThenEndYearField;
	private final DataSourceIntegerField endYearField;
	private final DataSourceIntegerField endMonthField;

	public CDEmployeeSalaryDetailMonth(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "职员编码");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		startYearField = new DataSourceIntegerField("startYear", "开始年份");
		startYearField.setRequired(false);
		startYearField.setLength(11);
		startYearField.setHidden(false);
		startYearField.setValueMap(KeyValueManager.getValueMap("employees"));

		startYearStartMonthField = new DataSourceIntegerField("startYearStartMonth", "开始年份的开始月份");
		startYearStartMonthField.setRequired(false);
		startYearStartMonthField.setLength(11);
		startYearStartMonthField.setHidden(false);

		startYearEndMonthField = new DataSourceIntegerField("startYearEndMonth", "开始年份的结束月份");
		startYearEndMonthField.setRequired(false);
		startYearEndMonthField.setLength(11);
		startYearEndMonthField.setHidden(false);

		bigThenStartYearField = new DataSourceIntegerField("bigThenStartYear", "大于开始年份");
		bigThenStartYearField.setRequired(false);
		bigThenStartYearField.setLength(11);
		bigThenStartYearField.setHidden(false);
		bigThenStartYearField.setValueMap(KeyValueManager.getValueMap("employees"));

		lessThenEndYearField = new DataSourceIntegerField("lessThenEndYear", "小于结束年份");
		lessThenEndYearField.setRequired(false);
		lessThenEndYearField.setLength(11);
		lessThenEndYearField.setHidden(false);
		lessThenEndYearField.setValueMap(KeyValueManager.getValueMap("employees"));

		endYearField = new DataSourceIntegerField("endYear", "结束年份");
		endYearField.setRequired(false);
		endYearField.setLength(11);
		endYearField.setHidden(false);
		endYearField.setValueMap(KeyValueManager.getValueMap("employees"));

		endMonthField = new DataSourceIntegerField("endMonth", "结束月份");
		endMonthField.setRequired(false);
		endMonthField.setLength(11);
		endMonthField.setHidden(false);
		endMonthField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

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


		setFields(employeeIdField, startYearField, startYearStartMonthField, startYearEndMonthField, bigThenStartYearField, lessThenEndYearField, endYearField, endMonthField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

