package com.pomplatform.client.mcapitaldepartmentdccddor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMcapitaldepartmentdccddor extends DataSource
{


	public static CDMcapitaldepartmentdccddor instance = null;

	public static CDMcapitaldepartmentdccddor getInstance() {
		if(instance == null) {
			instance = new CDMcapitaldepartmentdccddor("CDMcapitaldepartmentdccddor");
		}
		return instance;
	}

	private final DataSourceIntegerField capitalDepartmentIdField;
	private final DataSourceIntegerField capitalIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField departmentNameField;

	public CDMcapitaldepartmentdccddor(String dataSourceID) {

		setID(dataSourceID);
		capitalDepartmentIdField = new DataSourceIntegerField("capitalDepartmentId", "主键");
		capitalDepartmentIdField.setRequired(true);
		capitalDepartmentIdField.setLength(11);
		capitalDepartmentIdField.setPrimaryKey(true);
		capitalDepartmentIdField.setHidden(true);

		capitalIdField = new DataSourceIntegerField("capitalId", "回款编码");
		capitalIdField.setRequired(false);
		capitalIdField.setLength(11);
		capitalIdField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门编码");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

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


		setFields(capitalDepartmentIdField, capitalIdField, departmentIdField, departmentNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

