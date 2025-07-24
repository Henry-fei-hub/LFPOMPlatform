package com.pomplatform.client.financialtransactionaccount.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSFinancialTransactionDetail extends DBDataSource
{


	public static DSFinancialTransactionDetail instance = null;

	public static DSFinancialTransactionDetail getInstance() {
		if(instance == null) {
			instance = new DSFinancialTransactionDetail("DSFinancialTransactionDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField financialTransactionDetailIdField;
	private final DataSourceIntegerField financialTransactionAccountIdField;
	private final DataSourceDateField recordDateField;
	private final DataSourceTextField summaryField;
	private final DataSourceIntegerField currencyTypeField;
	private final DataSourceFloatField originalDebitField;
	private final DataSourceFloatField originalCreditField;
	private final DataSourceFloatField exchangeRateField;
	private final DataSourceFloatField standardDebitField;
	private final DataSourceFloatField standardCreditField;
	private final DataSourceIntegerField operatorAccountIdField;
	private final DataSourceBooleanField isLockedField;
	private final DataSourceBooleanField isHumanAddField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField processBillListIdField;
	private final DataSourceBooleanField isCompletedField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField deleteFlagField;

	public DSFinancialTransactionDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("FinancialTransactionDetail");


		financialTransactionDetailIdField = new DataSourceIntegerField("financialTransactionDetailId", "主键编码");
		financialTransactionDetailIdField.setLength(11);
		financialTransactionDetailIdField.setPrimaryKey(true);
		financialTransactionDetailIdField.setRequired(true);
		financialTransactionDetailIdField.setHidden(false);


		financialTransactionAccountIdField = new DataSourceIntegerField("financialTransactionAccountId", "财务往来账户");
		financialTransactionAccountIdField.setLength(11);
		financialTransactionAccountIdField.setRequired(false);
		financialTransactionAccountIdField.setHidden(false);


		recordDateField = new DataSourceDateField("recordDate", "日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);


		summaryField = new DataSourceTextField("summary", "摘要");
		summaryField.setLength(1024);
		summaryField.setRequired(false);
		summaryField.setHidden(false);


		currencyTypeField = new DataSourceIntegerField("currencyType", "货币种类 system_dictionary_40");
		currencyTypeField.setLength(11);
		currencyTypeField.setRequired(false);
		currencyTypeField.setHidden(false);


		originalDebitField = new DataSourceFloatField("originalDebit", "原币借");
		originalDebitField.setLength(18);
		originalDebitField.setDecimalPad(2);
		originalDebitField.setFormat("#,###,###,###,###,##0.00");
		originalDebitField.setRequired(false);
		originalDebitField.setHidden(false);


		originalCreditField = new DataSourceFloatField("originalCredit", "原币贷");
		originalCreditField.setLength(18);
		originalCreditField.setDecimalPad(2);
		originalCreditField.setFormat("#,###,###,###,###,##0.00");
		originalCreditField.setRequired(false);
		originalCreditField.setHidden(false);


		exchangeRateField = new DataSourceFloatField("exchangeRate", "汇率");
		exchangeRateField.setLength(8);
		exchangeRateField.setDecimalPad(4);
		exchangeRateField.setFormat("#,##0.0000");
		exchangeRateField.setRequired(false);
		exchangeRateField.setHidden(false);


		standardDebitField = new DataSourceFloatField("standardDebit", "本币借");
		standardDebitField.setLength(18);
		standardDebitField.setDecimalPad(2);
		standardDebitField.setFormat("#,###,###,###,###,##0.00");
		standardDebitField.setRequired(false);
		standardDebitField.setHidden(false);


		standardCreditField = new DataSourceFloatField("standardCredit", "本币贷");
		standardCreditField.setLength(18);
		standardCreditField.setDecimalPad(2);
		standardCreditField.setFormat("#,###,###,###,###,##0.00");
		standardCreditField.setRequired(false);
		standardCreditField.setHidden(false);


		operatorAccountIdField = new DataSourceIntegerField("operatorAccountId", "经办人");
		operatorAccountIdField.setLength(11);
		operatorAccountIdField.setRequired(false);
		operatorAccountIdField.setHidden(false);


		isLockedField = new DataSourceBooleanField("isLocked", "是否锁定");
		isLockedField.setRequired(false);
		isLockedField.setHidden(false);


		isHumanAddField = new DataSourceBooleanField("isHumanAdd", "是否人为添加");
		isHumanAddField.setRequired(false);
		isHumanAddField.setHidden(false);


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(false);
		processTypeField.setValueMap(KeyValueManager.getValueMap("system_process_types"));


		businessIdField = new DataSourceIntegerField("businessId", "流程业务数据编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(false);
		businessIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程实例编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(true);


		processBillListIdField = new DataSourceIntegerField("processBillListId", "报销收款信息编码");
		processBillListIdField.setLength(11);
		processBillListIdField.setRequired(false);
		processBillListIdField.setHidden(true);


		isCompletedField = new DataSourceBooleanField("isCompleted", "是否完成");
		isCompletedField.setRequired(false);
		isCompletedField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		deleteFlagField = new DataSourceIntegerField("deleteFlag", " 1已删除");
		deleteFlagField.setLength(11);
		deleteFlagField.setRequired(false);
		deleteFlagField.setHidden(true);


		setFields(financialTransactionDetailIdField, financialTransactionAccountIdField, recordDateField, summaryField, currencyTypeField, originalDebitField, originalCreditField, exchangeRateField, standardDebitField, standardCreditField, operatorAccountIdField, isLockedField, isHumanAddField, processTypeField, businessIdField, processInstanceIdField, processBillListIdField, isCompletedField, createTimeField, deleteFlagField);
	}


}

