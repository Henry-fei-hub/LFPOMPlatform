package com.pomplatform.client.revenuevoucher.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSRevenueVoucher extends DBDataSource
{


	public static DSRevenueVoucher instance = null;

	public static DSRevenueVoucher getInstance() {
		if(instance == null) {
			instance = new DSRevenueVoucher("DSRevenueVoucher");
		}
		return instance;
	}

	private final DataSourceIntegerField k3VoucherIdField;
	private final DataSourceIntegerField projectIdField;
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
	private final DataSourceTextField reimbursementPackageCodeField;
	private final DataSourceFloatField amountOfReimbursementField;
	private final DataSourceFloatField inputTaxField;
	private final DataSourceTextField selfBankAccountField;
	private final DataSourceTextField otherBankAccountField;
	private final DataSourceBooleanField needToChangeField;
	private final DataSourceDateField vestingDateField;
	private final DataSourceBooleanField lockedField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField updateTimeField;
	private final DataSourceDateTimeField lockedTimeField;
	private final DataSourceIntegerField linkIdField;
	private final DataSourceIntegerField voucherTypeField;
	private final DataSourceIntegerField additionalLinkIdField;
	private final DataSourceTextField showNameField;
	private final DataSourceIntegerField customerIdField;

	public DSRevenueVoucher(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("RevenueVoucher");


		k3VoucherIdField = new DataSourceIntegerField("k3VoucherId", "主键编码");
		k3VoucherIdField.setLength(11);
		k3VoucherIdField.setPrimaryKey(true);
		k3VoucherIdField.setRequired(true);
		k3VoucherIdField.setHidden(true);


		projectIdField = new DataSourceIntegerField("projectId", "项目");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(true);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		sequenceNumberField = new DataSourceIntegerField("sequenceNumber", "凭证号");
		sequenceNumberField.setLength(11);
		sequenceNumberField.setRequired(false);
		sequenceNumberField.setHidden(false);


		internalSequenceNumberField = new DataSourceIntegerField("internalSequenceNumber", "凭证内序号");
		internalSequenceNumberField.setLength(11);
		internalSequenceNumberField.setRequired(false);
		internalSequenceNumberField.setHidden(true);


		codeTypeField = new DataSourceIntegerField("codeType", "科目类型");
		codeTypeField.setLength(11);
		codeTypeField.setRequired(false);
		codeTypeField.setHidden(true);


		codeIdField = new DataSourceIntegerField("codeId", "科目编码");
		codeIdField.setLength(11);
		codeIdField.setRequired(false);
		codeIdField.setHidden(true);


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
		secondaryCodeTypeField.setHidden(true);


		secondaryCodeIdField = new DataSourceIntegerField("secondaryCodeId", "辅助核算编码");
		secondaryCodeIdField.setLength(11);
		secondaryCodeIdField.setRequired(false);
		secondaryCodeIdField.setHidden(true);


		secondaryCodeField = new DataSourceTextField("secondaryCode", "辅助核算代码");
		secondaryCodeField.setLength(64);
		secondaryCodeField.setRequired(false);
		secondaryCodeField.setHidden(true);


		secondaryNameField = new DataSourceTextField("secondaryName", "辅助核算名称");
		secondaryNameField.setLength(128);
		secondaryNameField.setRequired(false);
		secondaryNameField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "摘要");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		simplifyRemarkField = new DataSourceTextField("simplifyRemark", "简化备注");
		simplifyRemarkField.setLength(200);
		simplifyRemarkField.setRequired(false);
		simplifyRemarkField.setHidden(true);


		debitSideField = new DataSourceFloatField("debitSide", "借方");
		debitSideField.setLength(18);
		debitSideField.setDecimalPad(2);
		debitSideField.setFormat("#,###,###,###,###,##0.00");
		debitSideField.setRequired(false);
		debitSideField.setHidden(true);


		creditSideField = new DataSourceFloatField("creditSide", "贷方");
		creditSideField.setLength(18);
		creditSideField.setDecimalPad(2);
		creditSideField.setFormat("#,###,###,###,###,##0.00");
		creditSideField.setRequired(false);
		creditSideField.setHidden(true);


		reimbursementPackageCodeField = new DataSourceTextField("reimbursementPackageCode", "报销汇总编号");
		reimbursementPackageCodeField.setLength(64);
		reimbursementPackageCodeField.setRequired(false);
		reimbursementPackageCodeField.setHidden(true);


		amountOfReimbursementField = new DataSourceFloatField("amountOfReimbursement", "报销金额");
		amountOfReimbursementField.setLength(18);
		amountOfReimbursementField.setDecimalPad(2);
		amountOfReimbursementField.setFormat("#,###,###,###,###,##0.00");
		amountOfReimbursementField.setRequired(false);
		amountOfReimbursementField.setHidden(true);


		inputTaxField = new DataSourceFloatField("inputTax", "进项税");
		inputTaxField.setLength(18);
		inputTaxField.setDecimalPad(2);
		inputTaxField.setFormat("#,###,###,###,###,##0.00");
		inputTaxField.setRequired(false);
		inputTaxField.setHidden(true);


		selfBankAccountField = new DataSourceTextField("selfBankAccount", "我方银行账号");
		selfBankAccountField.setLength(128);
		selfBankAccountField.setRequired(false);
		selfBankAccountField.setHidden(true);


		otherBankAccountField = new DataSourceTextField("otherBankAccount", "对方银行账号");
		otherBankAccountField.setLength(128);
		otherBankAccountField.setRequired(false);
		otherBankAccountField.setHidden(true);


		needToChangeField = new DataSourceBooleanField("needToChange", "需要调整");
		needToChangeField.setRequired(false);
		needToChangeField.setHidden(true);


		vestingDateField = new DataSourceDateField("vestingDate", "归属日期");
		vestingDateField.setRequired(false);
		vestingDateField.setHidden(true);


		lockedField = new DataSourceBooleanField("locked", "是否锁定");
		lockedField.setRequired(false);
		lockedField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(true);


		lockedTimeField = new DataSourceDateTimeField("lockedTime", "定稿时间");
		lockedTimeField.setRequired(false);
		lockedTimeField.setHidden(true);


		linkIdField = new DataSourceIntegerField("linkId", "关联编码");
		linkIdField.setLength(11);
		linkIdField.setRequired(false);
		linkIdField.setHidden(true);


		voucherTypeField = new DataSourceIntegerField("voucherType", "凭证类型 1报销  2发票  3回款 4收入");
		voucherTypeField.setLength(11);
		voucherTypeField.setRequired(false);
		voucherTypeField.setHidden(true);


		additionalLinkIdField = new DataSourceIntegerField("additionalLinkId", "区域");
		additionalLinkIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_116"));
		additionalLinkIdField.setLength(11);
		additionalLinkIdField.setRequired(false);
		additionalLinkIdField.setHidden(true);


		showNameField = new DataSourceTextField("showName", "名称");
		showNameField.setLength(128);
		showNameField.setRequired(true);
		showNameField.setHidden(false);


		customerIdField = new DataSourceIntegerField("customerId", "客户编码");
		customerIdField.setLength(11);
		customerIdField.setRequired(false);
		customerIdField.setHidden(false);


		setFields(k3VoucherIdField, projectIdField, companyIdField, sequenceNumberField, internalSequenceNumberField, codeTypeField, codeIdField, codeField, nameField, secondaryCodeTypeField, secondaryCodeIdField, secondaryCodeField, secondaryNameField, remarkField, simplifyRemarkField, debitSideField, creditSideField, reimbursementPackageCodeField, amountOfReimbursementField, inputTaxField, selfBankAccountField, otherBankAccountField, needToChangeField, vestingDateField, lockedField, createTimeField, updateTimeField, lockedTimeField, linkIdField, voucherTypeField, additionalLinkIdField, showNameField, customerIdField);
	}


}

