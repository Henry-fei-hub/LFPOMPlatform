package com.pomplatform.client.employeesalary.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMemployeeSalary extends DataSource
{


	public static CDMemployeeSalary instance = null;

	public static CDMemployeeSalary getInstance() {
		if(instance == null) {
			instance = new CDMemployeeSalary("CDMemployeeSalary");
		}
		return instance;
	}

	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField yearsField;
	private final DataSourceTextField startMonthField;
	private final DataSourceTextField endMonthField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField departmentIdField;

	public CDMemployeeSalary(String dataSourceID) {

		setID(dataSourceID);
		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		yearsField = new DataSourceTextField("years", "年份");
		yearsField.setRequired(false);
		yearsField.setLength(64);
		yearsField.setHidden(false);

		startMonthField = new DataSourceTextField("startMonth", "开始月份");
		startMonthField.setRequired(false);
		startMonthField.setLength(64);
		startMonthField.setHidden(false);

		endMonthField = new DataSourceTextField("endMonth", "截止月份");
		endMonthField.setRequired(false);
		endMonthField.setLength(64);
		endMonthField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "职员编码");
		employeeIdField.setRequired(false);
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


		setFields(employeeNameField, yearsField, startMonthField, endMonthField, employeeIdField, plateIdField, departmentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

