package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDApplicationInForFilingListOf extends DataSource
{


	public static CDApplicationInForFilingListOf instance = null;

	public static CDApplicationInForFilingListOf getInstance() {
		if(instance == null) {
			instance = new CDApplicationInForFilingListOf("CDApplicationInForFilingListOf");
		}
		return instance;
	}

	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField departmentIdField;

	public CDApplicationInForFilingListOf(String dataSourceID) {

		setID(dataSourceID);
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(true);

		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(true);

		employeeIdField = new DataSourceIntegerField("employeeId", "申请人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(true);

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
		departmentIdField.setHidden(true);

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


		setFields(processTypeField, statusField, employeeIdField, companyIdField, employeeNameField, employeeNoField, departmentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

