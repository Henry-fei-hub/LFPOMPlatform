package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDEmployeeContract extends DataSource
{


	public static CDEmployeeContract instance = null;

	public static CDEmployeeContract getInstance() {
		if(instance == null) {
			instance = new CDEmployeeContract("CDEmployeeContract");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceDateField startDateField;

	public CDEmployeeContract(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "员工id");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		startDateField = new DataSourceDateField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

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


		setFields(employeeIdField, startDateField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

