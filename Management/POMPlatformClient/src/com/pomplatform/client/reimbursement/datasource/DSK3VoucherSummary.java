package com.pomplatform.client.reimbursement.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSK3VoucherSummary extends DBDataSource
{


	public static DSK3VoucherSummary instance = null;

	public static DSK3VoucherSummary getInstance() {
		if(instance == null) {
			instance = new DSK3VoucherSummary("DSK3VoucherSummary");
		}
		return instance;
	}

	private final DataSourceTextField reimbursementPackageCodeField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceFloatField debitSideField;
	private final DataSourceFloatField creditSideField;
	private final DataSourceDateField vestingDateField;
	private final DataSourceBooleanField lockedField;

	public DSK3VoucherSummary(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("K3VoucherSummary");


		reimbursementPackageCodeField = new DataSourceTextField("reimbursementPackageCode", "报销汇总编号");
		reimbursementPackageCodeField.setLength(64);
		reimbursementPackageCodeField.setRequired(false);
		reimbursementPackageCodeField.setHidden(false);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


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


		vestingDateField = new DataSourceDateField("vestingDate", "归属日期");
		vestingDateField.setRequired(false);
		vestingDateField.setHidden(false);
		
		lockedField = new DataSourceBooleanField("locked", "是否定稿");
		lockedField.setRequired(false);
		lockedField.setHidden(true);


		setFields(reimbursementPackageCodeField, companyIdField, debitSideField, creditSideField, vestingDateField, lockedField);
	}


}

