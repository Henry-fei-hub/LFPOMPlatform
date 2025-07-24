package com.pomplatform.client.purchase.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadRefuseListOfProductInquiry extends DataSource
{


	public static CDOnLoadRefuseListOfProductInquiry instance = null;

	public static CDOnLoadRefuseListOfProductInquiry getInstance() {
		if(instance == null) {
			instance = new CDOnLoadRefuseListOfProductInquiry("CDOnLoadRefuseListOfProductInquiry");
		}
		return instance;
	}

	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceIntegerField createEmployeeIdField;
	private final DataSourceTextField majorTitleField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField departmentIdField;

	public CDOnLoadRefuseListOfProductInquiry(String dataSourceID) {

		setID(dataSourceID);
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setRequired(false);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);

		createEmployeeIdField = new DataSourceIntegerField("createEmployeeId", "创建人");
		createEmployeeIdField.setRequired(false);
		createEmployeeIdField.setLength(11);
		createEmployeeIdField.setHidden(false);

		majorTitleField = new DataSourceTextField("majorTitle", "主题");
		majorTitleField.setRequired(false);
		majorTitleField.setLength(128);
		majorTitleField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "申请人工号");
		employeeNoField.setRequired(false);
		employeeNoField.setLength(32);
		employeeNoField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "申请人部门");
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


		setFields(processTypeField, processStatusField, createEmployeeIdField, majorTitleField, employeeNoField, employeeNameField, departmentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

