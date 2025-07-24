package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSEmployeesOrders extends DBDataSource
{


	public static DSEmployeesOrders instance = null;

	public static DSEmployeesOrders getInstance() {
		if(instance == null) {
			instance = new DSEmployeesOrders("DSEmployeesOrders");
		}
		return instance;
	}

	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField estatusField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField pstatusField;

	public DSEmployeesOrders(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("EmployeesOrders");


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "所属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		estatusField = new DataSourceIntegerField("estatus", "在职状态");
		estatusField.setLength(11);
		estatusField.setRequired(true);
		estatusField.setHidden(false);
		estatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));


		contractCodeField = new DataSourceTextField("contractCode", "订单编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "订单名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		pstatusField = new DataSourceIntegerField("pstatus", "订单状态");
		pstatusField.setLength(11);
		pstatusField.setRequired(true);
		pstatusField.setHidden(false);
		pstatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_4"));


		setFields(employeeNoField, employeeNameField, departmentIdField, estatusField, contractCodeField, projectNameField, pstatusField);
	}


}

