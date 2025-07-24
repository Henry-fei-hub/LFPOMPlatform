package com.pomplatform.client.trainingmanagement.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDEmployeeItegral extends DataSource
{


	public static CDEmployeeItegral instance = null;

	public static CDEmployeeItegral getInstance() {
		if(instance == null) {
			instance = new CDEmployeeItegral("CDEmployeeItegral");
		}
		return instance;
	}

	private final DataSourceIntegerField selectYearField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField departmentIdField;

	public CDEmployeeItegral(String dataSourceID) {

		setID(dataSourceID);
		selectYearField = new DataSourceIntegerField("selectYear", "年份");
		selectYearField.setRequired(true);
		selectYearField.setLength(11);
		selectYearField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "签到人编码");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		departmentIdField = new DataSourceIntegerField("departmentId", "部门编码");
		departmentIdField.setRequired(false);
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


		setFields(selectYearField, employeeIdField, departmentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

