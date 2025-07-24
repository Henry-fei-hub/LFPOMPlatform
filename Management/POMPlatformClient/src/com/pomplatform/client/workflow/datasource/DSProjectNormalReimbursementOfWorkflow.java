package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSProjectNormalReimbursementOfWorkflow extends DBDataSource
{


	public static DSProjectNormalReimbursementOfWorkflow instance = null;

	public static DSProjectNormalReimbursementOfWorkflow getInstance() {
		if(instance == null) {
			instance = new DSProjectNormalReimbursementOfWorkflow("DSProjectNormalReimbursementOfWorkflow");
		}
		return instance;
	}

	private final DataSourceIntegerField projectNormalReimbursementIdField;
	private final DataSourceTextField projectNormalReimbursementNoField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField applyEmployeeIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField reimbursementNameField;
	private final DataSourceDateTimeField reimbursementTimeField;
	private final DataSourceIntegerField statusField;
	private final DataSourceFloatField amountField;
	private final DataSourceDateTimeField applyTimeField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceTextField remarkField;
	private final DataSourceBooleanField strikeABalanceField;
	private final DataSourceLinkField attachmentField;
	private final DataSourceIntegerField attachmentNumberField;
	private final DataSourceField detailProjectNormalReimbursementDetail;
	private final DataSourceTextField codeField;
	private final DataSourceIntegerField companyIdField;

	public DSProjectNormalReimbursementOfWorkflow(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ProjectNormalReimbursementOfWorkflow");


		projectNormalReimbursementIdField = new DataSourceIntegerField("projectNormalReimbursementId", "项目报销编码");
		projectNormalReimbursementIdField.setLength(11);
		projectNormalReimbursementIdField.setRequired(false);
		projectNormalReimbursementIdField.setHidden(true);


		projectNormalReimbursementNoField = new DataSourceTextField("projectNormalReimbursementNo", "报销编号");
		projectNormalReimbursementNoField.setLength(64);
		projectNormalReimbursementNoField.setRequired(false);
		projectNormalReimbursementNoField.setHidden(true);


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(true);

		
		applyEmployeeIdField = new DataSourceIntegerField("applyEmployeeId", "起草人");
		applyEmployeeIdField.setLength(11);
		applyEmployeeIdField.setRequired(false);
		applyEmployeeIdField.setHidden(false);
//		applyEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",applyEmployeeIdField);


		employeeIdField = new DataSourceIntegerField("employeeId", "报销人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
//		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",employeeIdField);


		departmentIdField = new DataSourceIntegerField("departmentId", "报销部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		projectIdField = new DataSourceIntegerField("projectId", "所属项目");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);
		KeyValueManager.loadValueMap("projects",projectIdField);


		reimbursementNameField = new DataSourceTextField("reimbursementName", "主题");
		reimbursementNameField.setLength(256);
		reimbursementNameField.setRequired(false);
		reimbursementNameField.setHidden(false);


		reimbursementTimeField = new DataSourceDateTimeField("reimbursementTime", "报销时间");
		reimbursementTimeField.setRequired(false);
		reimbursementTimeField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);


		amountField = new DataSourceFloatField("amount", "报销金额");
		amountField.setLength(18);
		amountField.setDecimalPad(5);
		amountField.setFormat("#,###,###,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);


		applyTimeField = new DataSourceDateTimeField("applyTime", "申请时间");
		applyTimeField.setRequired(false);
		applyTimeField.setHidden(false);


		completeTimeField = new DataSourceDateTimeField("completeTime", "完成时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		strikeABalanceField = new DataSourceBooleanField("strikeABalance", "冲账");
		strikeABalanceField.setRequired(false);
		strikeABalanceField.setHidden(false);


		attachmentField = new DataSourceLinkField("attachment", "附件");
		attachmentField.setLength(512);
		attachmentField.setRequired(false);
		attachmentField.setHidden(false);


		attachmentNumberField = new DataSourceIntegerField("attachmentNumber", "附件(张)");
		attachmentNumberField.setLength(11);
		attachmentNumberField.setRequired(false);
		attachmentNumberField.setHidden(false);

		
		detailProjectNormalReimbursementDetail = new DataSourceField("detailProjectNormalReimbursementDetail", FieldType.ANY);
		detailProjectNormalReimbursementDetail.setChildrenProperty(true);
		detailProjectNormalReimbursementDetail.setChildTagName("ProjectNormalReimbursementDetail");
		detailProjectNormalReimbursementDetail.setRequired(false);
		detailProjectNormalReimbursementDetail.setHidden(true);
		

		codeField = new DataSourceTextField("code", "编号");
		codeField.setHidden(false);
		
		
		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));

		setFields(projectNormalReimbursementIdField, projectNormalReimbursementNoField, processInstanceIdField, codeField, applyEmployeeIdField, employeeIdField, departmentIdField, projectIdField, reimbursementNameField, companyIdField, reimbursementTimeField, statusField, amountField, applyTimeField, completeTimeField, remarkField, strikeABalanceField, attachmentField, attachmentNumberField, detailProjectNormalReimbursementDetail);
	}


}

