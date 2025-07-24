package com.pomplatform.client.budgetmanagementworkflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSBudgetManagementWorkFlow extends DBDataSource
{


	public static DSBudgetManagementWorkFlow instance = null;

	public static DSBudgetManagementWorkFlow getInstance() {
		if(instance == null) {
			instance = new DSBudgetManagementWorkFlow("DSBudgetManagementWorkFlow");
		}
		return instance;
	}

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
	private final DataSourceField detailBudgetManagementDetail;

	public DSBudgetManagementWorkFlow(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("BudgetManagementWorkFlow");


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
		bdTypeField.setLength(11);
		bdTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_187"));
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
		bdApplyEmployeeIdField.setLength(11);
		bdApplyEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		bdApplyEmployeeIdField.setRequired(false);
		bdApplyEmployeeIdField.setHidden(false);


		bdApplyTimeField = new DataSourceDateTimeField("bdApplyTime", "申请时间");
		bdApplyTimeField.setRequired(false);
		bdApplyTimeField.setHidden(false);


		bdEstimatecloseTimeField = new DataSourceDateTimeField("bdEstimatecloseTime", "预期关闭时间");
		bdEstimatecloseTimeField.setRequired(false);
		bdEstimatecloseTimeField.setHidden(false);


		bdStatusField = new DataSourceIntegerField("bdStatus", "预算单状态");
		bdStatusField.setLength(11);
		bdStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_189"));
		bdStatusField.setRequired(false);
		bdStatusField.setHidden(false);


		projectIdField = new DataSourceIntegerField("projectId", "项目名称");
//		KeyValueManager.loadValueMap("projects",projectIdField);
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
		inputTaxInvoiceIdField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "申请人归属部门");
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);


		companyIdField = new DataSourceIntegerField("companyId", "申请人归属公司");
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);

		detailBudgetManagementDetail = new DataSourceField("detailBudgetManagementDetail", FieldType.ANY);
		detailBudgetManagementDetail.setChildrenProperty(true);
		detailBudgetManagementDetail.setChildTagName("BudgetManagementDetail");
		detailBudgetManagementDetail.setRequired(false);
		detailBudgetManagementDetail.setHidden(true);

		setFields(budgetManagementIdField, bdCodeField, bdTypeField, bdTotalAmountField, bdUseAmountField, bdRestAmountField, bdApplyEmployeeIdField, bdApplyTimeField, bdEstimatecloseTimeField, bdStatusField, projectIdField, bdRemarkField, inputTaxInvoiceIdField, departmentIdField, companyIdField, detailBudgetManagementDetail);
	}


}

