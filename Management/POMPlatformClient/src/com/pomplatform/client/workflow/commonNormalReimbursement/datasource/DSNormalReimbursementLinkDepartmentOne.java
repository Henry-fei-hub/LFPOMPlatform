package com.pomplatform.client.workflow.commonNormalReimbursement.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.personnel.datasource.DSOnLoadFlowNormalReimbursementsApplyBuisnessData;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSNormalReimbursementLinkDepartmentOne extends DBDataSource
{


	public static DSNormalReimbursementLinkDepartmentOne instance = null;

	public static DSNormalReimbursementLinkDepartmentOne getInstance() {
		if(instance == null) {
			instance = new DSNormalReimbursementLinkDepartmentOne("DSNormalReimbursementLinkDepartment");
		}
		return instance;
	}

	private final DataSourceIntegerField normalReimbursementLinkDepartmentIdField;
	private final DataSourceIntegerField projectNormalReimbursementIdField;
	private final DataSourceTextField departmentIdField;
	private final DataSourceFloatField amountField;
	private final DataSourceFloatField inputTaxField;
	private final DataSourceFloatField finalAmountField;

	public DSNormalReimbursementLinkDepartmentOne(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("NormalReimbursementLinkDepartment");


		normalReimbursementLinkDepartmentIdField = new DataSourceIntegerField("normalReimbursementLinkDepartmentId", "主键编码");
		normalReimbursementLinkDepartmentIdField.setLength(11);
		normalReimbursementLinkDepartmentIdField.setPrimaryKey(true);
		normalReimbursementLinkDepartmentIdField.setRequired(true);
		normalReimbursementLinkDepartmentIdField.setHidden(true);


		projectNormalReimbursementIdField = new DataSourceIntegerField("projectNormalReimbursementId", "日常报销编码");
		projectNormalReimbursementIdField.setLength(11);
		projectNormalReimbursementIdField.setRequired(false);
		projectNormalReimbursementIdField.setHidden(true);
//		projectNormalReimbursementIdField.setForeignKey("DSNormalReimbursementsAuditOfWorkflow.businessId");
		projectNormalReimbursementIdField.setForeignKey("DSOnLoadFlowNormalReimbursementsApplyBuisnessData.businessId");


		departmentIdField = new DataSourceTextField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		amountField = new DataSourceFloatField("amount", "费用");
		amountField.setLength(18);
		amountField.setDecimalPad(5);
		amountField.setFormat("#,###,###,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);
		
		
		inputTaxField = new DataSourceFloatField("inputTax", "进项税");
		inputTaxField.setLength(18);
		inputTaxField.setDecimalPad(5);
		inputTaxField.setFormat("#,###,###,###,##0.00");
		inputTaxField.setRequired(false);
		inputTaxField.setHidden(false);
		
		
		finalAmountField = new DataSourceFloatField("finalAmount", "成本");
		finalAmountField.setLength(18);
		finalAmountField.setDecimalPad(5);
		finalAmountField.setFormat("#,###,###,###,##0.00");
		finalAmountField.setRequired(false);
		finalAmountField.setHidden(false);


		setFields(normalReimbursementLinkDepartmentIdField, projectNormalReimbursementIdField, departmentIdField, amountField, inputTaxField, finalAmountField);
	}


}

