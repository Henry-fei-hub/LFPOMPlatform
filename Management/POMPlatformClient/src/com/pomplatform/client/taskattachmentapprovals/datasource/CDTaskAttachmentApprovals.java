package com.pomplatform.client.taskattachmentapprovals.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDTaskAttachmentApprovals extends DataSource
{


	public static CDTaskAttachmentApprovals instance = null;

	public static CDTaskAttachmentApprovals getInstance() {
		if(instance == null) {
			instance = new CDTaskAttachmentApprovals("CDTaskAttachmentApprovals");
		}
		return instance;
	}

	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField budgetManagementIdField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceIntegerField uploadEmployeeIdField;
	private final DataSourceDateTimeField uploadTimeField;
	private final DataSourceTextField uploadRemarkField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField bddTypeField;
	private final DataSourceIntegerField isApprovalField;
	private final DataSourceIntegerField departmentIdField;

	public CDTaskAttachmentApprovals(String dataSourceID) {

		setID(dataSourceID);
		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "处理人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		budgetManagementIdField = new DataSourceIntegerField("budgetManagementId", "预算管理id");
		budgetManagementIdField.setRequired(false);
		budgetManagementIdField.setLength(11);
		budgetManagementIdField.setHidden(false);

		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setRequired(false);
		attachmentNameField.setLength(1024);
		attachmentNameField.setHidden(false);

		uploadEmployeeIdField = new DataSourceIntegerField("uploadEmployeeId", "上传人员");
		uploadEmployeeIdField.setRequired(false);
		uploadEmployeeIdField.setLength(11);
		uploadEmployeeIdField.setHidden(false);

		uploadTimeField = new DataSourceDateTimeField("uploadTime", "上传时间");
		uploadTimeField.setRequired(false);
		uploadTimeField.setHidden(false);

		uploadRemarkField = new DataSourceTextField("uploadRemark", "附件备注");
		uploadRemarkField.setRequired(false);
		uploadRemarkField.setLength(2048);
		uploadRemarkField.setHidden(false);

		projectIdField = new DataSourceIntegerField("projectId", "项目id");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);

		bddTypeField = new DataSourceTextField("bddType", "预算类别  budget_detail_type");
		bddTypeField.setRequired(false);
		bddTypeField.setLength(255);
		bddTypeField.setHidden(false);

		isApprovalField = new DataSourceIntegerField("isApproval", "是否审批 0.未审批 1.审批进行中,2.已审批");
		isApprovalField.setRequired(false);
		isApprovalField.setLength(11);
		isApprovalField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "上传人员归属部门");
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


		setFields(statusField, processTypeField, employeeIdField, budgetManagementIdField, attachmentNameField, uploadEmployeeIdField, uploadTimeField, uploadRemarkField, projectIdField, bddTypeField, isApprovalField, departmentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

