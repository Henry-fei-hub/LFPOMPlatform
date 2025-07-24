package com.pomplatform.client.mcapitalemployeeecceedor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMcapitalemployeeecceedor extends DataSource
{


	public static CDMcapitalemployeeecceedor instance = null;

	public static CDMcapitalemployeeecceedor getInstance() {
		if(instance == null) {
			instance = new CDMcapitalemployeeecceedor("CDMcapitalemployeeecceedor");
		}
		return instance;
	}

	private final DataSourceIntegerField capitalEmployeeIdField;
	private final DataSourceIntegerField capitalIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField departmentIdField;

	public CDMcapitalemployeeecceedor(String dataSourceID) {

		setID(dataSourceID);
		capitalEmployeeIdField = new DataSourceIntegerField("capitalEmployeeId", "主键");
		capitalEmployeeIdField.setRequired(true);
		capitalEmployeeIdField.setLength(11);
		capitalEmployeeIdField.setPrimaryKey(true);
		capitalEmployeeIdField.setHidden(true);

		capitalIdField = new DataSourceIntegerField("capitalId", "回款编码");
		capitalIdField.setRequired(false);
		capitalIdField.setLength(11);
		capitalIdField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "员工主键");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

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


		setFields(capitalEmployeeIdField, capitalIdField, employeeIdField, employeeNameField, departmentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

