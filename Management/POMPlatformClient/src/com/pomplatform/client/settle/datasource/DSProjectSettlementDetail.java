package com.pomplatform.client.settle.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSProjectSettlementDetail extends DBDataSource {

	public static DSProjectSettlementDetail instance = null;

	public static DSProjectSettlementDetail getInstance() {
		if (instance == null) {
			instance = new DSProjectSettlementDetail("DSProjectSettlementDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField settlementDetailIdField;
	private final DataSourceIntegerField settlementIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField employeeIdField;
	private final DataSourceTextField workContentField;
	private final DataSourceDateField settlementDateField;
	private final DataSourceFloatField planAmountField;
	private final DataSourceFloatField realAmountField;
	private final DataSourceFloatField realAmountPercentField;
	private final DataSourceFloatField projectCostField;
	private final DataSourceFloatField projectCostPercentField;
	private final DataSourceFloatField finalAmountField;
	private final DataSourceTextField settlementStatusField;

	public DSProjectSettlementDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("ProjectSettlementDetail");

		settlementDetailIdField = new DataSourceIntegerField("settlementDetailId", "结算详细代码");
		settlementDetailIdField.setLength(11);
		settlementDetailIdField.setPrimaryKey(true);
		settlementDetailIdField.setRequired(true);
		settlementDetailIdField.setHidden(true);

		settlementIdField = new DataSourceIntegerField("settlementId", "结算代码");
		settlementIdField.setLength(11);
		settlementIdField.setRequired(true);
		settlementIdField.setHidden(true);

		projectIdField = new DataSourceIntegerField("projectId", "项目代码");
		projectIdField.setLength(11);
		projectIdField.setRequired(true);
		projectIdField.setHidden(true);

		employeeIdField = new DataSourceTextField("employeeId", "设计师");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		workContentField = new DataSourceTextField("workContent", "工作内容");
		workContentField.setLength(1024);
		workContentField.setRequired(false);
		workContentField.setHidden(false);

		settlementDateField = new DataSourceDateField("settlementDate", "结算日期");
		settlementDateField.setRequired(false);
		settlementDateField.setHidden(true);

		planAmountField = new DataSourceFloatField("planAmount", "预分配积分");
		planAmountField.setLength(18);
		planAmountField.setDecimalPad(2);
		planAmountField.setFormat("#,###,###,###,###,##0.00");
		planAmountField.setRequired(false);
		planAmountField.setHidden(false);

		realAmountField = new DataSourceFloatField("realAmount", "分配积分");
		realAmountField.setLength(18);
		realAmountField.setDecimalPad(2);
		realAmountField.setFormat("#,###,###,###,###,##0.00");
		realAmountField.setRequired(false);
		realAmountField.setHidden(false);
		
		realAmountPercentField = new DataSourceFloatField("realAmountPercent", "分配积分占比(%)");
		realAmountPercentField.setLength(18);
		realAmountPercentField.setDecimalPad(2);
		realAmountPercentField.setFormat("#,###,###,###,###,##0.00");
		realAmountPercentField.setRequired(false);
		realAmountPercentField.setHidden(false);

		projectCostField = new DataSourceFloatField("projectCost", "分摊费用");
		projectCostField.setLength(18);
		projectCostField.setDecimalPad(2);
		projectCostField.setFormat("#,###,###,###,###,##0.00");
		projectCostField.setRequired(false);
		projectCostField.setHidden(false);
		
		projectCostPercentField = new DataSourceFloatField("projectCostPercent", "分摊费用占比(%)");
		projectCostPercentField.setLength(18);
		projectCostPercentField.setDecimalPad(2);
		projectCostPercentField.setFormat("#,###,###,###,###,##0.00");
		projectCostPercentField.setRequired(false);
		projectCostPercentField.setHidden(false);

		finalAmountField = new DataSourceFloatField("finalAmount", "最终获得");
		finalAmountField.setLength(18);
		finalAmountField.setDecimalPad(2);
		finalAmountField.setFormat("#,###,###,###,###,##0.00");
		finalAmountField.setRequired(false);
		finalAmountField.setHidden(false);

		settlementStatusField = new DataSourceTextField("settlementStatus", "结算状态");
		settlementStatusField.setLength(11);
		settlementStatusField.setRequired(false);
		settlementStatusField.setHidden(false);
		settlementStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_97"));

		setFields(settlementDetailIdField, settlementIdField, projectIdField, employeeIdField, settlementDateField, planAmountField, realAmountField,realAmountPercentField, projectCostField,projectCostPercentField, finalAmountField, settlementStatusField, workContentField);
	}

}
