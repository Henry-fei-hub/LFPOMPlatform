package com.pomplatform.client.department.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSdepartmentdor extends DataSource
{


	public static CDSdepartmentdor instance = null;

	public static CDSdepartmentdor getInstance() {
		if(instance == null) {
			instance = new CDSdepartmentdor("CDSdepartmentdor");
		}
		return instance;
	}

	private final DataSourceTextField departmentNameField;

	public CDSdepartmentdor(String dataSourceID) {

		setID(dataSourceID);
		departmentNameField = new DataSourceTextField("departmentName", "部门名称");
		departmentNameField.setRequired(true);
		departmentNameField.setLength(64);
		departmentNameField.setHidden(false);

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


		setFields(departmentNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

