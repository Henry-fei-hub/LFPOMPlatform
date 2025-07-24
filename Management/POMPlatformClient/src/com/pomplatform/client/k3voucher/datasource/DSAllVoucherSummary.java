package com.pomplatform.client.k3voucher.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSAllVoucherSummary extends DBDataSource
{


	public static DSAllVoucherSummary instance = null;

	public static DSAllVoucherSummary getInstance() {
		if(instance == null) {
			instance = new DSAllVoucherSummary("DSAllVoucherSummary");
		}
		return instance;
	}

	private final DataSourceIntegerField voucherTypeField;
	private final DataSourceTextField reimbursementPackageCodeField;
	private final DataSourceIntegerField reimbursementPackageIdField;
	private final DataSourceDateField vestingDateField;
	private final DataSourceIntegerField sequenceNumberField;
	private final DataSourceBooleanField lockedField;

	public DSAllVoucherSummary(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("AllVoucherSummary");


		voucherTypeField = new DataSourceIntegerField("voucherType", "凭证类型");
		voucherTypeField.setLength(11);
		voucherTypeField.setRequired(false);
		voucherTypeField.setHidden(false);
		voucherTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_117"));


		reimbursementPackageCodeField = new DataSourceTextField("reimbursementPackageCode", "编号");
		reimbursementPackageCodeField.setLength(64);
		reimbursementPackageCodeField.setRequired(false);
		reimbursementPackageCodeField.setHidden(false);


		reimbursementPackageIdField = new DataSourceIntegerField("reimbursementPackageId", "报销汇总单主表编码");
		reimbursementPackageIdField.setLength(11);
		reimbursementPackageIdField.setRequired(false);
		reimbursementPackageIdField.setHidden(true);


		vestingDateField = new DataSourceDateField("vestingDate", "归属日期");
		vestingDateField.setRequired(false);
		vestingDateField.setHidden(false);


		sequenceNumberField = new DataSourceIntegerField("sequenceNumber", "凭证号");
		sequenceNumberField.setLength(11);
		sequenceNumberField.setRequired(false);
		sequenceNumberField.setHidden(false);


		lockedField = new DataSourceBooleanField("locked", "是否锁定");
		lockedField.setRequired(false);
		lockedField.setHidden(true);


		setFields(voucherTypeField, reimbursementPackageCodeField, reimbursementPackageIdField, vestingDateField, sequenceNumberField, lockedField);
	}


}

