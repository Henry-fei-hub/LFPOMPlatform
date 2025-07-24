package com.pomplatform.client.receivables.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDInvoiceAndPayment extends DataSource
{


	public static CDInvoiceAndPayment instance = null;

	public static CDInvoiceAndPayment getInstance() {
		if(instance == null) {
			instance = new CDInvoiceAndPayment("CDInvoiceAndPayment");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField otherNameField;
	private final DataSourceTextField otherBankAccountField;
	private final DataSourceIntegerField selfNameField;
	private final DataSourceIntegerField moneyAttributeField;
	private final DataSourceBooleanField hasInvoicesField;
	private final DataSourceBooleanField hasContractReceivableField;
	private final DataSourceBooleanField hasDistributionCollectionField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceFloatField borrowMoneyField;
	private final DataSourceBooleanField haveVoucherField;

	public CDInvoiceAndPayment(String dataSourceID) {

		setID(dataSourceID);
		contractIdField = new DataSourceIntegerField("contractId", "合同id");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);

		otherNameField = new DataSourceTextField("otherName", "对方名称(付款方)");
		otherNameField.setRequired(false);
		otherNameField.setLength(128);
		otherNameField.setHidden(false);

		otherBankAccountField = new DataSourceTextField("otherBankAccount", "银行账号(付款方)");
		otherBankAccountField.setRequired(false);
		otherBankAccountField.setLength(128);
		otherBankAccountField.setHidden(false);

		selfNameField = new DataSourceIntegerField("selfName", "内部公司(收款方)");
		selfNameField.setRequired(false);
		selfNameField.setLength(11);
		selfNameField.setHidden(false);

		moneyAttributeField = new DataSourceIntegerField("moneyAttribute", "款项属性");
		moneyAttributeField.setRequired(false);
		moneyAttributeField.setLength(11);
		moneyAttributeField.setHidden(false);

		hasInvoicesField = new DataSourceBooleanField("hasInvoices", "是否绑定了发票");
		hasInvoicesField.setRequired(false);
		hasInvoicesField.setHidden(false);

		hasContractReceivableField = new DataSourceBooleanField("hasContractReceivable", "是否绑定了合同阶段付款");
		hasContractReceivableField.setRequired(false);
		hasContractReceivableField.setHidden(false);

		hasDistributionCollectionField = new DataSourceBooleanField("hasDistributionCollection", "有分配回款");
		hasDistributionCollectionField.setRequired(false);
		hasDistributionCollectionField.setHidden(false);

		processStatusField = new DataSourceIntegerField("processStatus", "流程状态 0 未处于流程  1审批中 2审批完成");
		processStatusField.setRequired(false);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "主订单编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "主订单名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		borrowMoneyField = new DataSourceFloatField("borrowMoney", "借（增加）");
		borrowMoneyField.setRequired(true);
		borrowMoneyField.setLength(16);
		borrowMoneyField.setHidden(false);

		haveVoucherField = new DataSourceBooleanField("haveVoucher", "是否有凭证");
		haveVoucherField.setRequired(false);
		haveVoucherField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(contractIdField, otherNameField, otherBankAccountField, selfNameField, moneyAttributeField, hasInvoicesField, hasContractReceivableField, hasDistributionCollectionField, processStatusField, contractCodeField, contractNameField, borrowMoneyField, haveVoucherField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

