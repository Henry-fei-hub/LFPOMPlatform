package com.pomplatform.client.projectperformance.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSFindProjectInfoByContractId extends DBDataSource
{


	public static DSFindProjectInfoByContractId instance = null;

	public static DSFindProjectInfoByContractId getInstance() {
		if(instance == null) {
			instance = new DSFindProjectInfoByContractId("DSFindProjectInfoByContractId");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField sheetCodeField;
	private final DataSourceTextField sheetNameField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceFloatField sheetAmountField;
	private final DataSourceFloatField totalIntegralField;
	private final DataSourceFloatField projectIntegralField;
	private final DataSourceFloatField reserveIntegralField;
	private final DataSourceFloatField complaintIntegralField;
	private final DataSourceFloatField sureIntegralField;
	private final DataSourceFloatField projectCostField;
	private final DataSourceFloatField deductIntegralField;
	private final DataSourceFloatField awardIntegralField;
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceTextField finishPercentField;
	private final DataSourceFloatField totalRevenueField;
	private final DataSourceFloatField leftIntegralField;

	public DSFindProjectInfoByContractId(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("FindProjectInfoByContractId");


		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);
		contractIdField.setForeignKey("DSContractProjectPerformance.contractId");


		projectIdField = new DataSourceIntegerField("projectId", "项目代码");
		projectIdField.setLength(11);
		projectIdField.setRequired(true);
		projectIdField.setHidden(true);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		
		statusField = new DataSourceIntegerField("status", "项目状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(true);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_4"));
		
		
		sheetCodeField = new DataSourceTextField("sheetCode", "订单编号");
		sheetCodeField.setLength(64);
		sheetCodeField.setRequired(true);
		sheetCodeField.setHidden(false);


		sheetNameField = new DataSourceTextField("sheetName", "订单名称");
		sheetNameField.setLength(512);
		sheetNameField.setRequired(true);
		sheetNameField.setHidden(false);


		businessTypeField = new DataSourceIntegerField("businessType", "业务类别");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(false);
		businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));


		projectTypeField = new DataSourceIntegerField("projectType", "项目类别");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		sheetAmountField = new DataSourceFloatField("sheetAmount", "订单合同金额");
		sheetAmountField.setLength(18);
		sheetAmountField.setDecimalPad(2);
		sheetAmountField.setFormat("#,###,###,###,###,##0.00");
		sheetAmountField.setRequired(false);
		sheetAmountField.setHidden(false);


		totalIntegralField = new DataSourceFloatField("totalIntegral", "订单总积分");
		totalIntegralField.setLength(18);
		totalIntegralField.setDecimalPad(2);
		totalIntegralField.setFormat("#,###,###,###,###,##0.00");
		totalIntegralField.setRequired(false);
		totalIntegralField.setHidden(true);


		projectIntegralField = new DataSourceFloatField("projectIntegral", "项目积分");
		projectIntegralField.setLength(18);
		projectIntegralField.setDecimalPad(2);
		projectIntegralField.setFormat("#,###,###,###,###,##0.00");
		projectIntegralField.setRequired(false);
		projectIntegralField.setHidden(true);


		reserveIntegralField = new DataSourceFloatField("reserveIntegral", "预留积分");
		reserveIntegralField.setLength(18);
		reserveIntegralField.setDecimalPad(2);
		reserveIntegralField.setFormat("#,###,###,###,###,##0.00");
		reserveIntegralField.setRequired(false);
		reserveIntegralField.setHidden(true);


		complaintIntegralField = new DataSourceFloatField("complaintIntegral", "质量保证金");
		complaintIntegralField.setLength(18);
		complaintIntegralField.setDecimalPad(2);
		complaintIntegralField.setFormat("#,###,###,###,###,##0.00");
		complaintIntegralField.setRequired(false);
		complaintIntegralField.setHidden(false);


		sureIntegralField = new DataSourceFloatField("sureIntegral", "确认积分");
		sureIntegralField.setLength(18);
		sureIntegralField.setDecimalPad(2);
		sureIntegralField.setFormat("#,###,###,###,###,##0.00");
		sureIntegralField.setRequired(true);
		sureIntegralField.setHidden(true);


		projectCostField = new DataSourceFloatField("projectCost", "项目成本");
		projectCostField.setLength(18);
		projectCostField.setDecimalPad(2);
		projectCostField.setFormat("#,###,###,###,###,##0.00");
		projectCostField.setRequired(true);
		projectCostField.setHidden(true);


		deductIntegralField = new DataSourceFloatField("deductIntegral", "已扣积分");
		deductIntegralField.setLength(18);
		deductIntegralField.setDecimalPad(2);
		deductIntegralField.setEmptyDisplayValue("0.00");
		deductIntegralField.setFormat("#,###,###,###,###,##0.00");
		deductIntegralField.setRequired(true);
		deductIntegralField.setHidden(false);


		awardIntegralField = new DataSourceFloatField("awardIntegral", "已奖积分");
		awardIntegralField.setLength(18);
		awardIntegralField.setDecimalPad(2);
		awardIntegralField.setEmptyDisplayValue("0.00");
		awardIntegralField.setFormat("#,###,###,###,###,##0.00");
		awardIntegralField.setRequired(true);
		awardIntegralField.setHidden(true);


		projectManageIdField = new DataSourceIntegerField("projectManageId", "专业负责人");
		projectManageIdField.setLength(11);
		projectManageIdField.setRequired(false);
		projectManageIdField.setHidden(true);
//		projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",projectManageIdField);

		finishPercentField = new DataSourceTextField("finishPercent", "累计完工比");
		finishPercentField.setLength(-1);
		finishPercentField.setRequired(true);
		finishPercentField.setHidden(true);


		totalRevenueField = new DataSourceFloatField("totalRevenue", "累计营收");
		totalRevenueField.setLength(18);
		totalRevenueField.setDecimalPad(2);
		totalRevenueField.setFormat("#,###,###,###,###,##0.00");
		totalRevenueField.setRequired(true);
		totalRevenueField.setHidden(true);
		
		leftIntegralField = new DataSourceFloatField("leftIntegral", "剩余积分");
		leftIntegralField.setLength(18);
		leftIntegralField.setDecimalPad(2);
		leftIntegralField.setFormat("#,###,###,###,###,##0.00");
		leftIntegralField.setRequired(true);
		leftIntegralField.setHidden(false);


		setFields(contractIdField, projectIdField, plateIdField, statusField, sheetCodeField, sheetNameField, businessTypeField, projectTypeField, sheetAmountField, totalIntegralField, projectIntegralField, reserveIntegralField, complaintIntegralField, sureIntegralField, projectCostField, deductIntegralField, awardIntegralField, projectManageIdField, finishPercentField, totalRevenueField,leftIntegralField);
	}


}

