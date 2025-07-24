package com.pomplatform.client.employee.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSelectEmployee extends DataSource
{


	public static CDSelectEmployee instance = null;

	public static CDSelectEmployee getInstance() {
		if(instance == null) {
			instance = new CDSelectEmployee("CDSelectEmployee");
		}
		return instance;
	}

	private final DataSourceIntegerField statusField;
	private final DataSourceBooleanField lockedField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField roleIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField dutyIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField employeeIdField;

	public CDSelectEmployee(String dataSourceID) {

		setID(dataSourceID);
		statusField = new DataSourceIntegerField("status", "4删除)");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		lockedField = new DataSourceBooleanField("locked", "是否锁定");
		lockedField.setRequired(false);
		lockedField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		roleIdField = new DataSourceIntegerField("roleId", "角色");
		roleIdField.setRequired(false);
		roleIdField.setLength(11);
		roleIdField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "板块");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		dutyIdField = new DataSourceIntegerField("dutyId", "职位名称");
		dutyIdField.setRequired(false);
		dutyIdField.setLength(11);
		dutyIdField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setRequired(true);
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);
		employeeNameField.setValueMap(KeyValueManager.getValueMap("employees"));

		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setRequired(true);
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

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


		setFields(statusField, lockedField, departmentIdField, roleIdField, plateIdField, dutyIdField, companyIdField, employeeNoField, employeeNameField, employeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

