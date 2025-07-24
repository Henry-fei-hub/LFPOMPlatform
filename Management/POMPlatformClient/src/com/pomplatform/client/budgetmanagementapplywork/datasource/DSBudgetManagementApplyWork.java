package com.pomplatform.client.budgetmanagementapplywork.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSBudgetManagementApplyWork extends DBDataSource
{


	public static DSBudgetManagementApplyWork instance = null;

	public static DSBudgetManagementApplyWork getInstance() {
		if(instance == null) {
			instance = new DSBudgetManagementApplyWork("DSBudgetManagementApplyWork");
		}
		return instance;
	}

	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField businessNameField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceActivityIdField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField budgetManagementIdField;
	private final DataSourceTextField bdCodeField;
	private final DataSourceIntegerField bdTypeField;
	private final DataSourceFloatField bdTotalAmountField;
	private final DataSourceFloatField bdUseAmountField;
	private final DataSourceFloatField bdRestAmountField;
	private final DataSourceIntegerField bdApplyEmployeeIdField;
	private final DataSourceDateTimeField bdApplyTimeField;
	private final DataSourceDateTimeField bdEstimatecloseTimeField;
	private final DataSourceIntegerField bdStatusField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField bdRemarkField;
	private final DataSourceIntegerField inputTaxInvoiceIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField companyIdField;

	public DSBudgetManagementApplyWork(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("BudgetManagementApplyWork");


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "主键编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setPrimaryKey(true);
		processInstanceIdField.setRequired(true);
		processInstanceIdField.setHidden(true);


		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);


		businessNameField = new DataSourceTextField("businessName", "业务名称");
		businessNameField.setLength(256);
		businessNameField.setRequired(false);
		businessNameField.setHidden(true);


		processIdField = new DataSourceIntegerField("processId", "流程编码");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);


		processInstanceActivityIdField = new DataSourceIntegerField("processInstanceActivityId", "活动实列编码");
		processInstanceActivityIdField.setLength(11);
		processInstanceActivityIdField.setRequired(false);
		processInstanceActivityIdField.setHidden(true);


		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_120"));
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(false);


		completeTimeField = new DataSourceDateTimeField("completeTime", "完成时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(false);


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setValueMap(KeyValueManager.getValueMap("system_process_types"));
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(false);


		budgetManagementIdField = new DataSourceIntegerField("budgetManagementId", "主键id");
		budgetManagementIdField.setLength(11);
		budgetManagementIdField.setPrimaryKey(true);
		budgetManagementIdField.setRequired(true);
		budgetManagementIdField.setHidden(true);


		bdCodeField = new DataSourceTextField("bdCode", "预算编号");
		bdCodeField.setLength(1024);
		bdCodeField.setRequired(false);
		bdCodeField.setHidden(false);


		bdTypeField = new DataSourceIntegerField("bdType", "预算类型");
		bdTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_191"));
		bdTypeField.setLength(11);
		bdTypeField.setRequired(false);
		bdTypeField.setHidden(false);


		bdTotalAmountField = new DataSourceFloatField("bdTotalAmount", "预算总金额");
		bdTotalAmountField.setLength(18);
		bdTotalAmountField.setDecimalPad(2);
		bdTotalAmountField.setFormat("#,###,###,###,###,##0.00");
		bdTotalAmountField.setRequired(false);
		bdTotalAmountField.setHidden(false);


		bdUseAmountField = new DataSourceFloatField("bdUseAmount", "预算已用金额");
		bdUseAmountField.setLength(18);
		bdUseAmountField.setDecimalPad(2);
		bdUseAmountField.setFormat("#,###,###,###,###,##0.00");
		bdUseAmountField.setRequired(false);
		bdUseAmountField.setHidden(false);


		bdRestAmountField = new DataSourceFloatField("bdRestAmount", "预算剩余金额");
		bdRestAmountField.setLength(18);
		bdRestAmountField.setDecimalPad(2);
		bdRestAmountField.setFormat("#,###,###,###,###,##0.00");
		bdRestAmountField.setRequired(false);
		bdRestAmountField.setHidden(false);


		bdApplyEmployeeIdField = new DataSourceIntegerField("bdApplyEmployeeId", "申请人");
		bdApplyEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		bdApplyEmployeeIdField.setLength(11);
		bdApplyEmployeeIdField.setRequired(false);
		bdApplyEmployeeIdField.setHidden(false);


		bdApplyTimeField = new DataSourceDateTimeField("bdApplyTime", "申请时间");
		bdApplyTimeField.setRequired(false);
		bdApplyTimeField.setHidden(false);


		bdEstimatecloseTimeField = new DataSourceDateTimeField("bdEstimatecloseTime", "预期关闭时间");
		bdEstimatecloseTimeField.setRequired(false);
		bdEstimatecloseTimeField.setHidden(true);


		bdStatusField = new DataSourceIntegerField("bdStatus", "预算单状态");
		bdStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_195"));
		bdStatusField.setLength(11);
		bdStatusField.setRequired(false);
		bdStatusField.setHidden(false);


		projectIdField = new DataSourceIntegerField("projectId", "项目名称");
		KeyValueManager.loadValueMap("projects",projectIdField);
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);


		bdRemarkField = new DataSourceTextField("bdRemark", "预算备注");
		bdRemarkField.setLength(2048);
		bdRemarkField.setRequired(false);
		bdRemarkField.setHidden(false);


		inputTaxInvoiceIdField = new DataSourceIntegerField("inputTaxInvoiceId", "发票编码");
		inputTaxInvoiceIdField.setLength(11);
		inputTaxInvoiceIdField.setRequired(false);
		inputTaxInvoiceIdField.setHidden(true);


		departmentIdField = new DataSourceIntegerField("departmentId", "承接部门");
		departmentIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);


		setFields(processTypeField,processInstanceIdField, budgetManagementIdField, businessIdField, businessNameField, processIdField, processInstanceActivityIdField, processStatusField, completeTimeField, bdCodeField, bdTypeField, bdTotalAmountField, bdUseAmountField, bdRestAmountField,  bdApplyTimeField, bdEstimatecloseTimeField, bdStatusField, projectIdField, bdApplyEmployeeIdField,departmentIdField, companyIdField,bdRemarkField,inputTaxInvoiceIdField);
	}


}

