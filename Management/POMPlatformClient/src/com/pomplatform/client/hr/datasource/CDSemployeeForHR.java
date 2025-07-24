package com.pomplatform.client.hr.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSemployeeForHR extends DataSource
{


	public static CDSemployeeForHR instance = null;

	public static CDSemployeeForHR getInstance() {
		if(instance == null) {
			instance = new CDSemployeeForHR("CDSemployeeForHR");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField dutyIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField roleIdField;
	private final DataSourceIntegerField gradeIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceBooleanField isDepartmentField;
	private final DataSourceIntegerField genderField;

	public CDSemployeeForHR(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "板块");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		dutyIdField = new DataSourceIntegerField("dutyId", "职位名称");
		dutyIdField.setRequired(false);
		dutyIdField.setLength(11);
		dutyIdField.setHidden(false);
		dutyIdField.setValueMap(KeyValueManager.getValueMap("duties"));

		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setRequired(true);
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "角色编码");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		roleIdField = new DataSourceIntegerField("roleId", "部门编码");
		roleIdField.setRequired(false);
		roleIdField.setLength(11);
		roleIdField.setHidden(false);
//		roleIdField.setValueMap(KeyValueManager.getValueMap("roles"));
		KeyValueManager.loadValueMap("roles",roleIdField);

		gradeIdField = new DataSourceIntegerField("gradeId", "等级");
		gradeIdField.setRequired(false);
		gradeIdField.setLength(11);
		gradeIdField.setHidden(false);
		gradeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		isDepartmentField = new DataSourceBooleanField("isDepartment", "是否为部门负责人");
		isDepartmentField.setRequired(false);
		isDepartmentField.setHidden(false);

		genderField = new DataSourceIntegerField("gender", "性别");
		genderField.setRequired(false);
		genderField.setLength(11);
		genderField.setHidden(false);
		genderField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

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


		setFields(plateIdField, dutyIdField, employeeNoField, employeeNameField, departmentIdField, roleIdField, gradeIdField, statusField, isDepartmentField, genderField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

