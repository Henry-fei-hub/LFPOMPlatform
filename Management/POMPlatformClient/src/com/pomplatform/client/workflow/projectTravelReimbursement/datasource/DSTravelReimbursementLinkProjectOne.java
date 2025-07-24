package com.pomplatform.client.workflow.projectTravelReimbursement.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.personnel.datasource.DSOnLoadFlowTravelReimbursementsApplyBuisnessData;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSTravelReimbursementLinkProjectOne extends DBDataSource
{


	public static DSTravelReimbursementLinkProjectOne instance = null;

	public static DSTravelReimbursementLinkProjectOne getInstance() {
		if(instance == null) {
			instance = new DSTravelReimbursementLinkProjectOne("DSTravelReimbursementLinkProject");
		}
		return instance;
	}

	private final DataSourceIntegerField travelReimbursementLinkProjectIdField;
	private final DataSourceIntegerField travelReimbursementIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceFloatField amountField;
	private final DataSourceFloatField inputTaxField;
	private final DataSourceFloatField finalAmountField;

	public DSTravelReimbursementLinkProjectOne(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("TravelReimbursementLinkProject");


		travelReimbursementLinkProjectIdField = new DataSourceIntegerField("travelReimbursementLinkProjectId", "主键编码");
		travelReimbursementLinkProjectIdField.setLength(11);
		travelReimbursementLinkProjectIdField.setPrimaryKey(true);
		travelReimbursementLinkProjectIdField.setRequired(true);
		travelReimbursementLinkProjectIdField.setHidden(true);


		travelReimbursementIdField = new DataSourceIntegerField("travelReimbursementId", "差旅报销详情编码");
		travelReimbursementIdField.setLength(11);
		travelReimbursementIdField.setRequired(false);
		travelReimbursementIdField.setHidden(true);
		travelReimbursementIdField.setForeignKey("DSOnLoadFlowTravelReimbursementsApplyBuisnessData.businessId");


		projectIdField = new DataSourceIntegerField("projectId", "项目");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects", projectIdField);


		contractCodeField = new DataSourceTextField("contractCode", "订单编号");
		contractCodeField.setLength(128);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


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


		setFields(travelReimbursementLinkProjectIdField, travelReimbursementIdField, projectIdField, contractCodeField, plateIdField, amountField, inputTaxField, finalAmountField);
	}


}

