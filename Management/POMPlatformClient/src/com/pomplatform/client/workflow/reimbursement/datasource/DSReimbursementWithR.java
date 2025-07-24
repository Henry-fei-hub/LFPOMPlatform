package com.pomplatform.client.workflow.reimbursement.datasource;

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSReimbursementWithR extends DBDataSource
{


	public static DSReimbursementWithR instance = null;

	public static DSReimbursementWithR getInstance() {
		if(instance == null) {
			instance = new DSReimbursementWithR("DSReimbursementWithR");
		}
		return instance;
	}

	private final DataSourceIntegerField reimbursementIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceDateField applicationDateField;
	private final DataSourceIntegerField reimbursementTypeField;
	private final DataSourceIntegerField statusField;
	private final DataSourceFloatField amountField;
	private final DataSourceDateField completeDateField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceTextField subjectField;
	private final DataSourceTextField remarkField;
	private final DataSourceField detailReimbursementDetail;

	public DSReimbursementWithR(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("ReimbursementWithR");


		reimbursementIdField = new DataSourceIntegerField("reimbursementId", "部门角色代码");
		reimbursementIdField.setLength(11);
		reimbursementIdField.setPrimaryKey(true);
		reimbursementIdField.setRequired(true);
		reimbursementIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "申请人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);


		applicationDateField = new DataSourceDateField("applicationDate", "申请日期");
		applicationDateField.setRequired(false);
		applicationDateField.setHidden(false);


		reimbursementTypeField = new DataSourceIntegerField("reimbursementType", "报销类型");
		reimbursementTypeField.setLength(11);
		reimbursementTypeField.setRequired(false);
		reimbursementTypeField.setHidden(false);
		reimbursementTypeField.setValueMap(KeyValueManager.getValueMap("domain_values_reimbursement_type"));


		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("_reimbursement_status"));


		amountField = new DataSourceFloatField("amount", "报销总金额");
		amountField.setLength(18);
		amountField.setDecimalPad(2);
		amountField.setFormat("#,###,###,###,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);


		completeDateField = new DataSourceDateField("completeDate", "完成日期");
		completeDateField.setRequired(false);
		completeDateField.setHidden(false);


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程代码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(false);


		subjectField = new DataSourceTextField("subject", "报销事由");
		subjectField.setLength(64);
		subjectField.setRequired(false);
		subjectField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "报销详细说明");
		remarkField.setLength(256);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		detailReimbursementDetail = new DataSourceField("detailReimbursementDetail", FieldType.ANY);
		detailReimbursementDetail.setChildrenProperty(true);
		detailReimbursementDetail.setChildTagName("ReimbursementDetail");
		detailReimbursementDetail.setRequired(false);
		detailReimbursementDetail.setHidden(true);

		setFields(reimbursementIdField, employeeIdField, applicationDateField, reimbursementTypeField, statusField, amountField, completeDateField, processInstanceIdField, subjectField, remarkField, detailReimbursementDetail);
	}


}

