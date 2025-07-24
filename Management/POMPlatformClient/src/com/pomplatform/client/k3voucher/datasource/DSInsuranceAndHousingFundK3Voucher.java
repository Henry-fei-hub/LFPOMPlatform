package com.pomplatform.client.k3voucher.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSInsuranceAndHousingFundK3Voucher extends DBDataSource
{


	public static DSInsuranceAndHousingFundK3Voucher instance = null;

	public static DSInsuranceAndHousingFundK3Voucher getInstance() {
		if(instance == null) {
			instance = new DSInsuranceAndHousingFundK3Voucher("DSInsuranceAndHousingFundK3Voucher");
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
	private final DataSourceFloatField debitSideField;
	private final DataSourceFloatField creditSideField;
	private final DataSourceTextField simplifyRemarkField;
	private final DataSourceDateField vestingDateField;
	private final DataSourceBooleanField lockedField;

	public DSInsuranceAndHousingFundK3Voucher(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("InsuranceAndHousingFundK3Voucher");


		k3VoucherIdField = new DataSourceIntegerField("k3VoucherId", "主键编码");
		k3VoucherIdField.setLength(11);
		k3VoucherIdField.setPrimaryKey(true);
		k3VoucherIdField.setRequired(true);
		k3VoucherIdField.setHidden(true);


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
		creditSideField.setHidden(false);


		simplifyRemarkField = new DataSourceTextField("simplifyRemark", "摘要");
		simplifyRemarkField.setLength(200);
		simplifyRemarkField.setRequired(false);
		simplifyRemarkField.setHidden(false);


		vestingDateField = new DataSourceDateField("vestingDate", "归属日期");
		vestingDateField.setRequired(false);
		vestingDateField.setHidden(false);


		lockedField = new DataSourceBooleanField("locked", "是否锁定");
		lockedField.setRequired(false);
		lockedField.setHidden(true);


		setFields(k3VoucherIdField, companyIdField, sequenceNumberField, internalSequenceNumberField, codeTypeField, codeIdField, codeField, nameField, debitSideField, creditSideField, simplifyRemarkField, vestingDateField, lockedField);
	}


}

