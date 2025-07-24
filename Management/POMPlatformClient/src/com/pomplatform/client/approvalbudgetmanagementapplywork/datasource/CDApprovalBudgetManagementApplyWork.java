package com.pomplatform.client.approvalbudgetmanagementapplywork.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDApprovalBudgetManagementApplyWork extends DataSource
{


	public static CDApprovalBudgetManagementApplyWork instance = null;

	public static CDApprovalBudgetManagementApplyWork getInstance() {
		if(instance == null) {
			instance = new CDApprovalBudgetManagementApplyWork("CDApprovalBudgetManagementApplyWork");
		}
		return instance;
	}

	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField bdTypeField;
	private final DataSourceTextField bdCodeField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField bdApplyEmployeeIdField;
	private final DataSourceDateTimeField bdApplyTimeField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField departmentIdField;

	public CDApprovalBudgetManagementApplyWork(String dataSourceID) {

		setID(dataSourceID);
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "处理人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		bdTypeField = new DataSourceIntegerField("bdType", "预算类型");
		bdTypeField.setRequired(false);
		bdTypeField.setLength(11);
		bdTypeField.setHidden(false);

		bdCodeField = new DataSourceTextField("bdCode", "预算编号");
		bdCodeField.setRequired(false);
		bdCodeField.setLength(1024);
		bdCodeField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "申请人归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		bdApplyEmployeeIdField = new DataSourceIntegerField("bdApplyEmployeeId", "申请人id");
		bdApplyEmployeeIdField.setRequired(false);
		bdApplyEmployeeIdField.setLength(11);
		bdApplyEmployeeIdField.setHidden(false);

		bdApplyTimeField = new DataSourceDateTimeField("bdApplyTime", "申请时间");
		bdApplyTimeField.setRequired(false);
		bdApplyTimeField.setHidden(false);

		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "申请人归属部门");
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


		setFields(processTypeField, statusField, employeeIdField, bdTypeField, bdCodeField, companyIdField, bdApplyEmployeeIdField, bdApplyTimeField, projectIdField, departmentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

