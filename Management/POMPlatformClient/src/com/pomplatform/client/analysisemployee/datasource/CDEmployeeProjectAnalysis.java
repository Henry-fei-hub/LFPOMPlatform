package com.pomplatform.client.analysisemployee.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDEmployeeProjectAnalysis extends DataSource
{


	public static CDEmployeeProjectAnalysis instance = null;

	public static CDEmployeeProjectAnalysis getInstance() {
		if(instance == null) {
			instance = new CDEmployeeProjectAnalysis("CDEmployeeProjectAnalysis");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField isbusyField;

	public CDEmployeeProjectAnalysis(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		departmentIdField = new DataSourceIntegerField("departmentId", "所属部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap(""));

		employeeIdField = new DataSourceIntegerField("employeeId", "员工姓名");
		employeeIdField.setRequired(true);
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		isbusyField = new DataSourceIntegerField("isbusy", "状态");
		isbusyField.setRequired(false);
		isbusyField.setLength(11);
		isbusyField.setHidden(false);

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


		setFields(plateIdField, departmentIdField, employeeIdField, isbusyField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

