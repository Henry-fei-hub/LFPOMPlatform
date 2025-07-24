package com.pomplatform.client.personnel.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadFlowTravelReimbursementsApplyBuisnessData extends DataSource
{


	public static CDOnLoadFlowTravelReimbursementsApplyBuisnessData instance = null;

	public static CDOnLoadFlowTravelReimbursementsApplyBuisnessData getInstance() {
		if(instance == null) {
			instance = new CDOnLoadFlowTravelReimbursementsApplyBuisnessData("CDOnLoadFlowTravelReimbursementsApplyBuisnessData");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField codeField;

	public CDOnLoadFlowTravelReimbursementsApplyBuisnessData(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "处理人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setRequired(false);
		employeeNoField.setLength(32);
		employeeNoField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

		codeField = new DataSourceTextField("code", "报销编号");
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


		setFields(employeeIdField, processTypeField, statusField, employeeNameField, employeeNoField, companyIdField, departmentIdField, codeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

