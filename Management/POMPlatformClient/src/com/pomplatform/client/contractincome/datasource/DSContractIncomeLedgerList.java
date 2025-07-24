package com.pomplatform.client.contractincome.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSContractIncomeLedgerList extends DBDataSource
{


	public static DSContractIncomeLedgerList instance = null;

	public static DSContractIncomeLedgerList getInstance() {
		if(instance == null) {
			instance = new DSContractIncomeLedgerList("DSContractIncomeLedgerList");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIncomeLedgerIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField clientIdField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField projectManagerField;
	private final DataSourceTextField plateManagerField;
	private final DataSourceFloatField signingMoneySumField;
	private final DataSourceFloatField receiveContractAmountField;
	private final DataSourceFloatField unreceivedContractAmountField;
	private final DataSourceTextField invoiceDateField;
	private final DataSourceTextField invoiceNumberField;
	private final DataSourceTextField invoiceStageField;
	private final DataSourceFloatField invoiceAmountField;
	private final DataSourceFloatField currentReceiveAmountField;
	private final DataSourceTextField currentReceiveDateField;
	private final DataSourceTextField currentReceiveRemarkField;
	private final DataSourceTextField projectStatusField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField contactsField;
	private final DataSourceIntegerField ledgerYearField;
	private final DataSourceIntegerField ledgerMonthField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField updateTimeField;
	private final DataSourceBooleanField isLockedField;
	private final DataSourceIntegerField incomeLedgerNumberField;

	public DSContractIncomeLedgerList(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ContractIncomeLedgerList");


		contractIncomeLedgerIdField = new DataSourceIntegerField("contractIncomeLedgerId", "主键编码");
		contractIncomeLedgerIdField.setLength(11);
		contractIncomeLedgerIdField.setPrimaryKey(true);
		contractIncomeLedgerIdField.setRequired(true);
		contractIncomeLedgerIdField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);
		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		companyIdField = new DataSourceIntegerField("companyId", "合同签约公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		clientIdField = new DataSourceIntegerField("clientId", "客户");
		clientIdField.setLength(11);
		clientIdField.setRequired(false);
		clientIdField.setHidden(true);
		clientIdField.setValueMap(KeyValueManager.getValueMap("customers"));


		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setLength(512);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);


		projectManagerField = new DataSourceTextField("projectManager", "项目经理");
		projectManagerField.setLength(128);
		projectManagerField.setRequired(false);
		projectManagerField.setHidden(false);


		plateManagerField = new DataSourceTextField("plateManager", "项目负责人");
		plateManagerField.setLength(128);
		plateManagerField.setRequired(false);
		plateManagerField.setHidden(false);


		signingMoneySumField = new DataSourceFloatField("signingMoneySum", "合同签约金额");
		signingMoneySumField.setLength(18);
		signingMoneySumField.setDecimalPad(2);
		signingMoneySumField.setFormat("#,###,###,###,###,##0.00");
		signingMoneySumField.setRequired(false);
		signingMoneySumField.setHidden(false);


		receiveContractAmountField = new DataSourceFloatField("receiveContractAmount", "累计收款");
		receiveContractAmountField.setLength(18);
		receiveContractAmountField.setDecimalPad(2);
		receiveContractAmountField.setFormat("#,###,###,###,###,##0.00");
		receiveContractAmountField.setRequired(false);
		receiveContractAmountField.setHidden(false);


		unreceivedContractAmountField = new DataSourceFloatField("unreceivedContractAmount", "未收款");
		unreceivedContractAmountField.setLength(18);
		unreceivedContractAmountField.setDecimalPad(2);
		unreceivedContractAmountField.setFormat("#,###,###,###,###,##0.00");
		unreceivedContractAmountField.setRequired(false);
		unreceivedContractAmountField.setHidden(false);


		invoiceDateField = new DataSourceTextField("invoiceDate", "开票日期");
		invoiceDateField.setLength(512);
		invoiceDateField.setRequired(false);
		invoiceDateField.setHidden(false);


		invoiceNumberField = new DataSourceTextField("invoiceNumber", "发票号码");
		invoiceNumberField.setLength(512);
		invoiceNumberField.setRequired(false);
		invoiceNumberField.setHidden(false);


		invoiceStageField = new DataSourceTextField("invoiceStage", "开票阶段");
		invoiceStageField.setLength(512);
		invoiceStageField.setRequired(false);
		invoiceStageField.setHidden(false);


		invoiceAmountField = new DataSourceFloatField("invoiceAmount", "开票金额");
		invoiceAmountField.setLength(18);
		invoiceAmountField.setDecimalPad(2);
		invoiceAmountField.setFormat("#,###,###,###,###,##0.00");
		invoiceAmountField.setRequired(false);
		invoiceAmountField.setHidden(false);


		currentReceiveAmountField = new DataSourceFloatField("currentReceiveAmount", "当月收款金额");
		currentReceiveAmountField.setLength(18);
		currentReceiveAmountField.setDecimalPad(2);
		currentReceiveAmountField.setFormat("#,###,###,###,###,##0.00");
		currentReceiveAmountField.setRequired(false);
		currentReceiveAmountField.setHidden(false);


		currentReceiveDateField = new DataSourceTextField("currentReceiveDate", "当月收款日期");
		currentReceiveDateField.setLength(512);
		currentReceiveDateField.setRequired(false);
		currentReceiveDateField.setHidden(false);


		currentReceiveRemarkField = new DataSourceTextField("currentReceiveRemark", "当月收款备注");
		currentReceiveRemarkField.setLength(1024);
		currentReceiveRemarkField.setRequired(false);
		currentReceiveRemarkField.setHidden(true);


		projectStatusField = new DataSourceTextField("projectStatus", "项目状态");
		projectStatusField.setLength(256);
		projectStatusField.setRequired(false);
		projectStatusField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(true);


		contactsField = new DataSourceTextField("contacts", "联系人");
		contactsField.setLength(256);
		contactsField.setRequired(false);
		contactsField.setHidden(true);


		ledgerYearField = new DataSourceIntegerField("ledgerYear", "台账年份");
		ledgerYearField.setLength(11);
		ledgerYearField.setRequired(false);
		ledgerYearField.setHidden(true);


		ledgerMonthField = new DataSourceIntegerField("ledgerMonth", "台账月份");
		ledgerMonthField.setLength(11);
		ledgerMonthField.setRequired(false);
		ledgerMonthField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(true);


		isLockedField = new DataSourceBooleanField("isLocked", "是否锁定");
		isLockedField.setRequired(false);
		isLockedField.setHidden(true);


		incomeLedgerNumberField = new DataSourceIntegerField("incomeLedgerNumber", "收入台账序号");
		incomeLedgerNumberField.setLength(11);
		incomeLedgerNumberField.setRequired(false);
		incomeLedgerNumberField.setHidden(true);


		setFields(contractIncomeLedgerIdField, contractIdField, contractCodeField, contractNameField, clientIdField, signingMoneySumField, receiveContractAmountField, unreceivedContractAmountField, invoiceDateField, invoiceNumberField, invoiceStageField, invoiceAmountField, currentReceiveAmountField, currentReceiveDateField, currentReceiveRemarkField, projectStatusField, remarkField, contactsField, ledgerYearField, ledgerMonthField, createTimeField, updateTimeField, isLockedField, incomeLedgerNumberField, companyIdField, customerNameField, projectManagerField, plateManagerField);
	}


}

