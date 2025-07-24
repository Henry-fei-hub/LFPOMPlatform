package com.pomplatform.client.employeeawarddetail.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMemployeeAwardDetail extends DataSource
{


	public static CDMemployeeAwardDetail instance = null;

	public static CDMemployeeAwardDetail getInstance() {
		if(instance == null) {
			instance = new CDMemployeeAwardDetail("CDMemployeeAwardDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField yearsField;
	private final DataSourceIntegerField monthsField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceTextField employeeNameField;

	public CDMemployeeAwardDetail(String dataSourceID) {

		setID(dataSourceID);
		yearsField = new DataSourceIntegerField("years", "年份");
		yearsField.setRequired(true);
		yearsField.setLength(11);
		yearsField.setHidden(false);

		monthsField = new DataSourceIntegerField("months", "月份");
		monthsField.setRequired(true);
		monthsField.setLength(11);
		monthsField.setHidden(false);

		projectIdField = new DataSourceIntegerField("projectId", "项目");
		projectIdField.setRequired(true);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);
		KeyValueManager.loadValueMap("projects",projectIdField);

		employeeIdField = new DataSourceIntegerField("employeeId", "员工姓名");
		employeeIdField.setRequired(true);
		employeeIdField.setLength(5);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		plateIdField = new DataSourceIntegerField("plateId", "板块");
		plateIdField.setRequired(true);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(0);
		employeeNameField.setHidden(false);

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


		setFields(yearsField, monthsField, projectIdField, employeeIdField, plateIdField, employeeNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

