package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDEmployeesOrders extends DataSource
{


	public static CDEmployeesOrders instance = null;

	public static CDEmployeesOrders getInstance() {
		if(instance == null) {
			instance = new CDEmployeesOrders("CDEmployeesOrders");
		}
		return instance;
	}

	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField pstatusField;

	public CDEmployeesOrders(String dataSourceID) {

		setID(dataSourceID);
		departmentIdField = new DataSourceIntegerField("departmentId", "所属部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		projectCodeField = new DataSourceTextField("contractCode", "订单编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "订单名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		pstatusField = new DataSourceIntegerField("pstatus", "订单状态");
		pstatusField.setRequired(false);
		pstatusField.setLength(11);
		pstatusField.setHidden(false);

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


		setFields(departmentIdField, employeeNameField, projectCodeField, projectNameField, pstatusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

