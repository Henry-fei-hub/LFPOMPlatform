package com.pomplatform.client.financialtransactionaccount.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSTransDetail extends DBDataSource
{


	public static DSTransDetail instance = null;

	public static DSTransDetail getInstance() {
		if(instance == null) {
			instance = new DSTransDetail("DSTransDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField financialTransactionAccountIdField;
	private final DataSourceIntegerField financialTransactionDetailIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField accountTypeField;
	private final DataSourceTextField financeNoField;
	private final DataSourceTextField accountNameField;
	private final DataSourceBooleanField isHumanAddField;
	private final DataSourceBooleanField isCompletedField;
	private final DataSourceIntegerField accountStatusField;
	private final DataSourceDateField recordDateField;
	private final DataSourceTextField summaryField;
	private final DataSourceIntegerField orderNoField;
	private final DataSourceFloatField standardDebitField;
	private final DataSourceFloatField standardCreditField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processTypeField;

	public DSTransDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("TransDetail");


		financialTransactionAccountIdField = new DataSourceIntegerField("financialTransactionAccountId", "主键编码");
		financialTransactionAccountIdField.setLength(11);
		financialTransactionAccountIdField.setPrimaryKey(true);
		financialTransactionAccountIdField.setRequired(true);
		financialTransactionAccountIdField.setHidden(true);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));


		accountTypeField = new DataSourceIntegerField("accountType", "账户类型");
		accountTypeField.setLength(11);
		accountTypeField.setRequired(false);
		accountTypeField.setHidden(false);
		accountTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_230"));

		
		financialTransactionDetailIdField = new DataSourceIntegerField("financialTransactionDetailId", "往来明细ID");
		financialTransactionDetailIdField.setLength(11);
		financialTransactionDetailIdField.setRequired(false);
		financialTransactionDetailIdField.setHidden(true);

		
		financeNoField = new DataSourceTextField("financeNo", "财务编号");
		financeNoField.setLength(64);
		financeNoField.setRequired(false);
		financeNoField.setHidden(false);


		accountNameField = new DataSourceTextField("accountName", "名称");
		accountNameField.setLength(256);
		accountNameField.setRequired(false);
		accountNameField.setHidden(false);


		isHumanAddField = new DataSourceBooleanField("isHumanAdd", "是否人为添加");
		isHumanAddField.setRequired(false);
		isHumanAddField.setHidden(true);
		
		
		isCompletedField = new DataSourceBooleanField("isCompleted", "流程是否已完成");
		isCompletedField.setRequired(false);
		isCompletedField.setHidden(true);


		accountStatusField = new DataSourceIntegerField("accountStatus", "账户状态");
		accountStatusField.setLength(11);
		accountStatusField.setRequired(false);
		accountStatusField.setHidden(false);
		accountStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_217"));


		recordDateField = new DataSourceDateField("recordDate", "日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);


		summaryField = new DataSourceTextField("summary", "摘要");
		summaryField.setLength(255);
		summaryField.setRequired(false);
		summaryField.setHidden(false);


		orderNoField = new DataSourceIntegerField("orderNo", "");
		orderNoField.setLength(11);
		orderNoField.setRequired(true);
		orderNoField.setHidden(true);


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


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程实例ID");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(true);
		
		
		processIdField = new DataSourceIntegerField("processId", "流程ID");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);
		
		
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);


		setFields(financialTransactionAccountIdField, companyIdField, accountTypeField, financialTransactionDetailIdField, financeNoField, accountNameField, isHumanAddField, isCompletedField, accountStatusField, recordDateField, summaryField, orderNoField, standardDebitField, standardCreditField, processInstanceIdField, processIdField, processTypeField);
	}


}

