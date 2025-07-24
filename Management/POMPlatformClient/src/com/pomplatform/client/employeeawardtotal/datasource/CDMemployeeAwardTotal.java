package com.pomplatform.client.employeeawardtotal.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMemployeeAwardTotal extends DataSource
{


	public static CDMemployeeAwardTotal instance = null;

	public static CDMemployeeAwardTotal getInstance() {
		if(instance == null) {
			instance = new CDMemployeeAwardTotal("CDMemployeeAwardTotal");
		}
		return instance;
	}

	private final DataSourceDateField startMonthField;
	private final DataSourceDateField endMonthField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField employeeNameField;

	public CDMemployeeAwardTotal(String dataSourceID) {

		setID(dataSourceID);
		startMonthField = new DataSourceDateField("startMonth", "开始月份");
		startMonthField.setRequired(false);
		startMonthField.setHidden(false);

		endMonthField = new DataSourceDateField("endMonth", "截止月份");
		endMonthField.setRequired(false);
		endMonthField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "员工姓名");
		employeeIdField.setRequired(true);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		plateIdField = new DataSourceIntegerField("plateId", "板块");
		plateIdField.setRequired(true);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setRequired(true);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

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


		setFields(startMonthField, endMonthField, employeeIdField, plateIdField, departmentIdField, employeeNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

