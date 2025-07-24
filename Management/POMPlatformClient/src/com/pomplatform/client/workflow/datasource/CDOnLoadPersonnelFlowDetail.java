package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadPersonnelFlowDetail extends DataSource
{


	public static CDOnLoadPersonnelFlowDetail instance = null;

	public static CDOnLoadPersonnelFlowDetail getInstance() {
		if(instance == null) {
			instance = new CDOnLoadPersonnelFlowDetail("CDOnLoadPersonnelFlowDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField parentProcessTypeIdField;
	private final DataSourceIntegerField activityTypeField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField departmentIdField;

	public CDOnLoadPersonnelFlowDetail(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "人员");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		parentProcessTypeIdField = new DataSourceIntegerField("parentProcessTypeId", "父级类型");
		parentProcessTypeIdField.setRequired(false);
		parentProcessTypeIdField.setLength(11);
		parentProcessTypeIdField.setHidden(false);

		activityTypeField = new DataSourceIntegerField("activityType", "事件类型");
		activityTypeField.setRequired(true);
		activityTypeField.setLength(11);
		activityTypeField.setHidden(false);

		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(true);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setRequired(false);
		employeeNoField.setLength(32);
		employeeNoField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
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


		setFields(employeeIdField, parentProcessTypeIdField, activityTypeField, processTypeField, employeeNameField, employeeNoField, departmentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

