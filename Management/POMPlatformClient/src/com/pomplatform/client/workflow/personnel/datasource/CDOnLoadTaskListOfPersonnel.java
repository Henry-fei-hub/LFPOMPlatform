package com.pomplatform.client.workflow.personnel.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadTaskListOfPersonnel extends DataSource
{


	public static CDOnLoadTaskListOfPersonnel instance = null;

	public static CDOnLoadTaskListOfPersonnel getInstance() {
		if(instance == null) {
			instance = new CDOnLoadTaskListOfPersonnel("CDOnLoadTaskListOfPersonnel");
		}
		return instance;
	}

	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField departmentIdField;

	public CDOnLoadTaskListOfPersonnel(String dataSourceID) {

		setID(dataSourceID);
		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "申请人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		employeeNameField = new DataSourceTextField("employeeName", "职员姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "职员编号");
		employeeNoField.setRequired(false);
		employeeNoField.setLength(32);
		employeeNoField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

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


		setFields(statusField, processTypeField, employeeIdField, companyIdField, employeeNameField, employeeNoField, departmentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

