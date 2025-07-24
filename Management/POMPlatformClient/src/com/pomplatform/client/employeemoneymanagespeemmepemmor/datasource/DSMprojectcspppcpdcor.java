package com.pomplatform.client.employeemoneymanagespeemmepemmor.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMprojectcspppcpdcor extends DBDataSource
{


	public static DSMprojectcspppcpdcor instance = null;

	public static DSMprojectcspppcpdcor getInstance() {
		if(instance == null) {
			instance = new DSMprojectcspppcpdcor("DSMprojectcspppcpdcor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceFloatField totalIntegralField;
	private final DataSourceFloatField totalAmountField;
	private final DataSourceFloatField projectIntegralField;
	private final DataSourceFloatField sheetAmountField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField projectFlagField;
	private final DataSourceFloatField moneySumField;
	private final DataSourceIntegerField projectSetupFlagField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField subContractIdField;
	private final DataSourceFloatField returnMoneyField;
	private final DataSourceFloatField returnPercentField;

	public DSMprojectcspppcpdcor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mprojectcspppcpdcor");


		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setPrimaryKey(true);
		projectIdField.setRequired(true);
		projectIdField.setHidden(true);


		contractCodeField = new DataSourceTextField("contractCode", "订单编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "订单名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		plateIdField = new DataSourceIntegerField("plateId", "板块");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(true);


		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(true);


		projectManageIdField = new DataSourceIntegerField("projectManageId", "专业负责人");
		projectManageIdField.setLength(11);
		projectManageIdField.setRequired(false);
		projectManageIdField.setHidden(false);
		projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		statusField = new DataSourceIntegerField("status", "项目状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(true);


		totalIntegralField = new DataSourceFloatField("totalIntegral", "项目总积分");
		totalIntegralField.setLength(18);
		totalIntegralField.setDecimalPad(2);
		totalIntegralField.setFormat("#,###,###,###,###,##0.00");
		totalIntegralField.setRequired(false);
		totalIntegralField.setHidden(false);


		totalAmountField = new DataSourceFloatField("totalAmount", "项目总金额");
		totalAmountField.setLength(18);
		totalAmountField.setDecimalPad(2);
		totalAmountField.setFormat("#,###,###,###,###,##0.00");
		totalAmountField.setRequired(false);
		totalAmountField.setHidden(false);


		projectIntegralField = new DataSourceFloatField("projectIntegral", "项目积分");
		projectIntegralField.setLength(18);
		projectIntegralField.setDecimalPad(2);
		projectIntegralField.setFormat("#,###,###,###,###,##0.00");
		projectIntegralField.setRequired(false);
		projectIntegralField.setHidden(true);


		sheetAmountField = new DataSourceFloatField("sheetAmount", "订单金额");
		sheetAmountField.setLength(18);
		sheetAmountField.setDecimalPad(2);
		sheetAmountField.setFormat("#,###,###,###,###,##0.00");
		sheetAmountField.setRequired(false);
		sheetAmountField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		projectFlagField = new DataSourceIntegerField("projectFlag", "2研发项目)");
		projectFlagField.setLength(11);
		projectFlagField.setRequired(false);
		projectFlagField.setHidden(true);


		moneySumField = new DataSourceFloatField("moneySum", "合同金额");
		moneySumField.setLength(18);
		moneySumField.setDecimalPad(2);
		moneySumField.setFormat("#,###,###,###,###,##0.00");
		moneySumField.setRequired(false);
		moneySumField.setHidden(true);


		projectSetupFlagField = new DataSourceIntegerField("projectSetupFlag", ")");
		projectSetupFlagField.setLength(11);
		projectSetupFlagField.setRequired(false);
		projectSetupFlagField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		subContractIdField = new DataSourceIntegerField("subContractId", "子合同编码");
		subContractIdField.setLength(11);
		subContractIdField.setRequired(false);
		subContractIdField.setHidden(true);


		returnMoneyField = new DataSourceFloatField("returnMoney", "回款金额");
		returnMoneyField.setLength(18);
		returnMoneyField.setDecimalPad(2);
		returnMoneyField.setFormat("#,###,###,###,###,##0.00");
		returnMoneyField.setRequired(true);
		returnMoneyField.setHidden(false);
		
		returnPercentField = new DataSourceFloatField("returnPercent", "回款率(%)");
		returnPercentField.setLength(18);
		returnPercentField.setDecimalPad(2);
		returnPercentField.setFormat("#,###,###,###,###,##0.00");
		returnPercentField.setRequired(true);
		returnPercentField.setHidden(false);


		setFields(projectIdField, contractCodeField, projectCodeField, projectNameField, plateIdField, departmentIdField, projectManageIdField, statusField, totalIntegralField, totalAmountField, projectIntegralField, sheetAmountField, projectFlagField, moneySumField, returnMoneyField, projectSetupFlagField, contractIdField, subContractIdField, createTimeField, returnPercentField);
	}


}

