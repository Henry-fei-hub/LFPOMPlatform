package com.pomplatform.client.operation.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMProjectSettlementForProject extends DBDataSource
{


	public static DSMProjectSettlementForProject instance = null;

	public static DSMProjectSettlementForProject getInstance() {
		if(instance == null) {
			instance = new DSMProjectSettlementForProject("DSMProjectSettlementForProject");
		}
		return instance;
	}

	private final DataSourceIntegerField settlementIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField managerField;
	private final DataSourceTextField remarkField;
	private final DataSourceDateField settlementDateField;
	private final DataSourceFloatField totalAmountField;
	private final DataSourceFloatField totalCostField;
	private final DataSourceFloatField projectAmountField;
	private final DataSourceFloatField leftAmountField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField workContentField;
	private final DataSourceFloatField planAmountField;
	private final DataSourceFloatField realAmountField;
	private final DataSourceFloatField projectCostField;
	private final DataSourceFloatField finalAmountField;

	public DSMProjectSettlementForProject(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("MProjectSettlementForProject");


		settlementIdField = new DataSourceIntegerField("settlementId", "结算代码");
		settlementIdField.setLength(11);
		settlementIdField.setPrimaryKey(true);
		settlementIdField.setRequired(true);
		settlementIdField.setHidden(false);


		projectIdField = new DataSourceIntegerField("projectId", "项目");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);
		KeyValueManager.loadValueMap("projects",projectIdField);


		managerField = new DataSourceIntegerField("manager", "结算人");
		managerField.setLength(11);
		managerField.setRequired(true);
		managerField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "结算原因");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		settlementDateField = new DataSourceDateField("settlementDate", "结算日期");
		settlementDateField.setRequired(false);
		settlementDateField.setHidden(false);


		totalAmountField = new DataSourceFloatField("totalAmount", "总金额");
		totalAmountField.setLength(18);
		totalAmountField.setDecimalPad(2);
		totalAmountField.setFormat("#,###,###,###,###,##0.00");
		totalAmountField.setRequired(false);
		totalAmountField.setHidden(false);


		totalCostField = new DataSourceFloatField("totalCost", "总费用");
		totalCostField.setLength(18);
		totalCostField.setDecimalPad(2);
		totalCostField.setFormat("#,###,###,###,###,##0.00");
		totalCostField.setRequired(false);
		totalCostField.setHidden(false);


		projectAmountField = new DataSourceFloatField("projectAmount", "项目总金额");
		projectAmountField.setLength(18);
		projectAmountField.setDecimalPad(2);
		projectAmountField.setFormat("#,###,###,###,###,##0.00");
		projectAmountField.setRequired(false);
		projectAmountField.setHidden(false);


		leftAmountField = new DataSourceFloatField("leftAmount", "项目结余");
		leftAmountField.setLength(18);
		leftAmountField.setDecimalPad(2);
		leftAmountField.setFormat("#,###,###,###,###,##0.00");
		leftAmountField.setRequired(false);
		leftAmountField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_16"));


		employeeIdField = new DataSourceIntegerField("employeeId", "设计师");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		workContentField = new DataSourceTextField("workContent", "工作内容");
		workContentField.setLength(1024);
		workContentField.setRequired(false);
		workContentField.setHidden(false);


		planAmountField = new DataSourceFloatField("planAmount", "计划分配");
		planAmountField.setLength(18);
		planAmountField.setDecimalPad(2);
		planAmountField.setFormat("#,###,###,###,###,##0.00");
		planAmountField.setRequired(false);
		planAmountField.setHidden(false);


		realAmountField = new DataSourceFloatField("realAmount", "实际分配");
		realAmountField.setLength(18);
		realAmountField.setDecimalPad(2);
		realAmountField.setFormat("#,###,###,###,###,##0.00");
		realAmountField.setRequired(false);
		realAmountField.setHidden(false);


		projectCostField = new DataSourceFloatField("projectCost", "分摊费用");
		projectCostField.setLength(18);
		projectCostField.setDecimalPad(2);
		projectCostField.setFormat("#,###,###,###,###,##0.00");
		projectCostField.setRequired(false);
		projectCostField.setHidden(false);


		finalAmountField = new DataSourceFloatField("finalAmount", "最终获得");
		finalAmountField.setLength(18);
		finalAmountField.setDecimalPad(2);
		finalAmountField.setFormat("#,###,###,###,###,##0.00");
		finalAmountField.setRequired(false);
		finalAmountField.setHidden(true);


		setFields(settlementIdField, projectIdField, managerField, remarkField, settlementDateField, totalAmountField, totalCostField, projectAmountField, leftAmountField, statusField, employeeIdField, workContentField, planAmountField, realAmountField, projectCostField, finalAmountField);
	}


}

