package com.pomplatform.client.employeemoneymanagespeemmepemmor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMemployeepsrreereeedpor extends DataSource
{


	public static CDMemployeepsrreereeedpor instance = null;

	public static CDMemployeepsrreereeedpor getInstance() {
		if(instance == null) {
			instance = new CDMemployeepsrreereeedpor("CDMemployeepsrreereeedpor");
		}
		return instance;
	}

	private final DataSourceTextField receiveUnitNameField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField plateIdField;

	public CDMemployeepsrreereeedpor(String dataSourceID) {

		setID(dataSourceID);
		receiveUnitNameField = new DataSourceTextField("receiveUnitName", "收款方");
		receiveUnitNameField.setRequired(false);
		receiveUnitNameField.setLength(128);
		receiveUnitNameField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "创建人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setRequired(true);
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		plateIdField = new DataSourceIntegerField("plateId", "板块");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

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


		setFields(receiveUnitNameField, employeeIdField, employeeNameField, employeeNoField, departmentIdField, plateIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

