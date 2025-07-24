package com.pomplatform.client.workflow.projectNormalReimbursement.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.personnel.datasource.DSOnLoadFlowNormalReimbursementsApplyBuisnessData;
import com.delicacy.client.data.DBDataSource;

public class DSNormalReimbursementLinkProjectOne extends DBDataSource
{


	public static DSNormalReimbursementLinkProjectOne instance = null;

	public static DSNormalReimbursementLinkProjectOne getInstance() {
		if(instance == null) {
			instance = new DSNormalReimbursementLinkProjectOne("DSNormalReimbursementLinkProject");
		}
		return instance;
	}

	private final DataSourceIntegerField normalReimbursementLinkProjectIdField;
	private final DataSourceIntegerField projectNormalReimbursementIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceFloatField amountField;
	private final DataSourceFloatField inputTaxField;
	private final DataSourceFloatField finalAmountField;

	public DSNormalReimbursementLinkProjectOne(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("NormalReimbursementLinkProject");


		normalReimbursementLinkProjectIdField = new DataSourceIntegerField("normalReimbursementLinkProjectId", "主键编码");
		normalReimbursementLinkProjectIdField.setLength(11);
		normalReimbursementLinkProjectIdField.setPrimaryKey(true);
		normalReimbursementLinkProjectIdField.setRequired(true);
		normalReimbursementLinkProjectIdField.setHidden(true);


		projectNormalReimbursementIdField = new DataSourceIntegerField("projectNormalReimbursementId", "日常报销编码");
		projectNormalReimbursementIdField.setLength(11);
		projectNormalReimbursementIdField.setRequired(false);
		projectNormalReimbursementIdField.setHidden(true);
		projectNormalReimbursementIdField.setForeignKey("DSOnLoadFlowNormalReimbursementsApplyBuisnessData.businessId");
//		projectNormalReimbursementIdField.setForeignKey("DSNormalReimbursementsAuditOfWorkflow.businessId");


		projectIdField = new DataSourceIntegerField("projectId", "项目");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects",projectIdField);


		contractCodeField = new DataSourceTextField("contractCode", "订单编号");
		contractCodeField.setLength(128);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);
//		contractCodeField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts", contractCodeField);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


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


		setFields(normalReimbursementLinkProjectIdField, projectNormalReimbursementIdField, projectIdField, contractCodeField, plateIdField, amountField, inputTaxField, finalAmountField);
	}


}

