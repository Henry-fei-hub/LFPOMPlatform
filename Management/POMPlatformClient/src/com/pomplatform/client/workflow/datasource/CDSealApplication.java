package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSealApplication extends DataSource
{


	public static CDSealApplication instance = null;

	public static CDSealApplication getInstance() {
		if(instance == null) {
			instance = new CDSealApplication("CDSealApplication");
		}
		return instance;
	}

	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField employeeIdField;

	public CDSealApplication(String dataSourceID) {

		setID(dataSourceID);
		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "人事业务编码");
		personnelBusinessIdField.setRequired(true);
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setPrimaryKey(true);
		personnelBusinessIdField.setHidden(true);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "申请人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

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


		setFields(personnelBusinessIdField, departmentIdField, employeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

