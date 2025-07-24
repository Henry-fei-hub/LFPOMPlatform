package com.pomplatform.client.personnel.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadFlowPayMoneyApplyBuisnessData extends DataSource
{


	public static CDOnLoadFlowPayMoneyApplyBuisnessData instance = null;

	public static CDOnLoadFlowPayMoneyApplyBuisnessData getInstance() {
		if(instance == null) {
			instance = new CDOnLoadFlowPayMoneyApplyBuisnessData("CDOnLoadFlowPayMoneyApplyBuisnessData");
		}
		return instance;
	}

	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField codeField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField departmentIdField;

	public CDOnLoadFlowPayMoneyApplyBuisnessData(String dataSourceID) {

		setID(dataSourceID);
		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "处理人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		codeField = new DataSourceTextField("code", "编号");
		codeField.setRequired(false);
		codeField.setLength(64);
		codeField.setHidden(false);

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


		setFields(statusField, employeeIdField, companyIdField, codeField, employeeNameField, employeeNoField, departmentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

