package com.pomplatform.client.k3voucher.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSIncomeVoucher extends DBDataSource
{


	public static DSIncomeVoucher instance = null;

	public static DSIncomeVoucher getInstance() {
		if(instance == null) {
			instance = new DSIncomeVoucher("DSIncomeVoucher");
		}
		return instance;
	}

	private final DataSourceIntegerField k3VoucherIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField sequenceNumberField;
	private final DataSourceIntegerField internalSequenceNumberField;
	private final DataSourceIntegerField codeTypeField;
	private final DataSourceIntegerField codeIdField;
	private final DataSourceTextField codeField;
	private final DataSourceTextField nameField;
	private final DataSourceIntegerField secondaryCodeTypeField;
	private final DataSourceIntegerField secondaryCodeIdField;
	private final DataSourceTextField secondaryCodeField;
	private final DataSourceTextField secondaryNameField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField simplifyRemarkField;
	private final DataSourceFloatField debitSideField;
	private final DataSourceFloatField creditSideField;
	private final DataSourceDateField vestingDateField;
	private final DataSourceBooleanField lockedField;
	private final DataSourceIntegerField voucherTypeField;
	private final DataSourceIntegerField linkIdField;
	private final DataSourceTextField invoiceNumberField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField contractAreaField;
	private final DataSourceIntegerField customerIdField;

	public DSIncomeVoucher(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("IncomeVoucher");


		k3VoucherIdField = new DataSourceIntegerField("k3VoucherId", "主键编码");
		k3VoucherIdField.setLength(11);
		k3VoucherIdField.setPrimaryKey(true);
		k3VoucherIdField.setRequired(true);
		k3VoucherIdField.setHidden(false);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		sequenceNumberField = new DataSourceIntegerField("sequenceNumber", "凭证号");
		sequenceNumberField.setLength(11);
		sequenceNumberField.setRequired(false);
		sequenceNumberField.setHidden(false);


		internalSequenceNumberField = new DataSourceIntegerField("internalSequenceNumber", "凭证内序号");
		internalSequenceNumberField.setLength(11);
		internalSequenceNumberField.setRequired(false);
		internalSequenceNumberField.setHidden(false);


		codeTypeField = new DataSourceIntegerField("codeType", "科目类型");
		codeTypeField.setLength(11);
		codeTypeField.setRequired(false);
		codeTypeField.setHidden(false);


		codeIdField = new DataSourceIntegerField("codeId", "科目编码");
		codeIdField.setLength(11);
		codeIdField.setRequired(false);
		codeIdField.setHidden(false);


		codeField = new DataSourceTextField("code", "科目代码");
		codeField.setLength(64);
		codeField.setRequired(false);
		codeField.setHidden(false);


		nameField = new DataSourceTextField("name", "科目名称");
		nameField.setLength(128);
		nameField.setRequired(false);
		nameField.setHidden(false);


		secondaryCodeTypeField = new DataSourceIntegerField("secondaryCodeType", "辅助核算类型");
		secondaryCodeTypeField.setLength(11);
		secondaryCodeTypeField.setRequired(false);
		secondaryCodeTypeField.setHidden(false);


		secondaryCodeIdField = new DataSourceIntegerField("secondaryCodeId", "辅助核算编码");
		secondaryCodeIdField.setLength(11);
		secondaryCodeIdField.setRequired(false);
		secondaryCodeIdField.setHidden(false);


		secondaryCodeField = new DataSourceTextField("secondaryCode", "辅助核算代码");
		secondaryCodeField.setLength(64);
		secondaryCodeField.setRequired(false);
		secondaryCodeField.setHidden(false);


		secondaryNameField = new DataSourceTextField("secondaryName", "辅助核算名称");
		secondaryNameField.setLength(128);
		secondaryNameField.setRequired(false);
		secondaryNameField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		simplifyRemarkField = new DataSourceTextField("simplifyRemark", "简化备注");
		simplifyRemarkField.setLength(200);
		simplifyRemarkField.setRequired(false);
		simplifyRemarkField.setHidden(false);


		debitSideField = new DataSourceFloatField("debitSide", "借方");
		debitSideField.setLength(18);
		debitSideField.setDecimalPad(2);
		debitSideField.setFormat("#,###,###,###,###,##0.00");
		debitSideField.setRequired(false);
		debitSideField.setHidden(false);


		creditSideField = new DataSourceFloatField("creditSide", "贷方");
		creditSideField.setLength(18);
		creditSideField.setDecimalPad(2);
		creditSideField.setFormat("#,###,###,###,###,##0.00");
		creditSideField.setRequired(false);
		creditSideField.setHidden(true);


		vestingDateField = new DataSourceDateField("vestingDate", "归属日期");
		vestingDateField.setRequired(false);
		vestingDateField.setHidden(true);


		lockedField = new DataSourceBooleanField("locked", "是否定稿");
		lockedField.setRequired(false);
		lockedField.setHidden(true);


		voucherTypeField = new DataSourceIntegerField("voucherType", "凭证类型(system_dictionary_117) 1报销  2发票  3回款");
		voucherTypeField.setLength(11);
		voucherTypeField.setRequired(false);
		voucherTypeField.setHidden(true);


		linkIdField = new DataSourceIntegerField("linkId", "关联编码");
		linkIdField.setLength(11);
		linkIdField.setRequired(false);
		linkIdField.setHidden(true);


		invoiceNumberField = new DataSourceTextField("invoiceNumber", "发票号码");
		invoiceNumberField.setLength(64);
		invoiceNumberField.setRequired(false);
		invoiceNumberField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同id");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts", contractIdField);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(true);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(true);


		contractAreaField = new DataSourceIntegerField("contractArea", "合同区域");
		contractAreaField.setLength(11);
		contractAreaField.setRequired(false);
		contractAreaField.setHidden(true);
		contractAreaField.setValueMap(KeyValueManager.getValueMap("system_dictionary_116"));


		customerIdField = new DataSourceIntegerField("customerId", "客户");
		customerIdField.setLength(11);
		customerIdField.setRequired(false);
		customerIdField.setHidden(true);
		customerIdField.setValueMap(KeyValueManager.getValueMap("customers"));


		setFields(k3VoucherIdField, companyIdField, sequenceNumberField, internalSequenceNumberField, codeTypeField, codeIdField, codeField, nameField, secondaryCodeTypeField, secondaryCodeIdField, secondaryCodeField, secondaryNameField, remarkField, simplifyRemarkField, debitSideField, creditSideField, vestingDateField, lockedField, voucherTypeField, linkIdField, invoiceNumberField, contractIdField, contractCodeField, contractNameField, contractAreaField, customerIdField);
	}


}

