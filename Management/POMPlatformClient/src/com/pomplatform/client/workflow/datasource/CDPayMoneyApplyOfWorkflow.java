package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDPayMoneyApplyOfWorkflow extends DataSource
{


	public static CDPayMoneyApplyOfWorkflow instance = null;

	public static CDPayMoneyApplyOfWorkflow getInstance() {
		if(instance == null) {
			instance = new CDPayMoneyApplyOfWorkflow("CDPayMoneyApplyOfWorkflow");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField codeField;

	public CDPayMoneyApplyOfWorkflow(String dataSourceID) {

		setID(dataSourceID);
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

		departmentIdField = new DataSourceIntegerField("departmentId", "部门编码");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		codeField = new DataSourceTextField("code", "编号");
		codeField.setRequired(false);
		codeField.setLength(64);
		codeField.setHidden(false);

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


		setFields(employeeIdField, companyIdField, departmentIdField, codeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

