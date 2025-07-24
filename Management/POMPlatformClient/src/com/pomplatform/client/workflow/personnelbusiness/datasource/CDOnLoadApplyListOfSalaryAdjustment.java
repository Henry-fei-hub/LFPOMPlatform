package com.pomplatform.client.workflow.personnelbusiness.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadApplyListOfSalaryAdjustment extends DataSource
{


	public static CDOnLoadApplyListOfSalaryAdjustment instance = null;

	public static CDOnLoadApplyListOfSalaryAdjustment getInstance() {
		if(instance == null) {
			instance = new CDOnLoadApplyListOfSalaryAdjustment("CDOnLoadApplyListOfSalaryAdjustment");
		}
		return instance;
	}

	private final DataSourceDateTimeField yearField;
	private final DataSourceDateTimeField monthField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField drafterField;

	public CDOnLoadApplyListOfSalaryAdjustment(String dataSourceID) {

		setID(dataSourceID);
		yearField = new DataSourceDateTimeField("year", "年份");
		yearField.setRequired(false);
		yearField.setHidden(false);

		monthField = new DataSourceDateTimeField("month", "月份");
		monthField.setRequired(false);
		monthField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));

		employeeIdField = new DataSourceIntegerField("employeeId", "调薪员工");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		drafterField = new DataSourceIntegerField("drafter", "起草人");
		drafterField.setRequired(false);
		drafterField.setLength(11);
		drafterField.setHidden(false);
		drafterField.setValueMap(KeyValueManager.getValueMap("employees"));

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


		setFields(yearField, monthField, plateIdField, employeeIdField, drafterField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

