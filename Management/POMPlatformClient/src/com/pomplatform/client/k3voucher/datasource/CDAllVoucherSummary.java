package com.pomplatform.client.k3voucher.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDAllVoucherSummary extends DataSource
{


	public static CDAllVoucherSummary instance = null;

	public static CDAllVoucherSummary getInstance() {
		if(instance == null) {
			instance = new CDAllVoucherSummary("CDAllVoucherSummary");
		}
		return instance;
	}

	private final DataSourceIntegerField voucherTypeField;
	private final DataSourceIntegerField voucherYearField;
	private final DataSourceIntegerField voucherMonthField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField sequenceNumberField;
	private final DataSourceTextField reimbursementPackageCodeField;

	public CDAllVoucherSummary(String dataSourceID) {

		setID(dataSourceID);
		voucherTypeField = new DataSourceIntegerField("voucherType", "凭证类型");
		voucherTypeField.setRequired(false);
		voucherTypeField.setLength(11);
		voucherTypeField.setHidden(false);
		voucherTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		voucherYearField = new DataSourceIntegerField("voucherYear", "凭证年份");
		voucherYearField.setRequired(false);
		voucherYearField.setLength(11);
		voucherYearField.setHidden(false);

		voucherMonthField = new DataSourceIntegerField("voucherMonth", "凭证月份");
		voucherMonthField.setRequired(false);
		voucherMonthField.setLength(11);
		voucherMonthField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));
		
		sequenceNumberField = new DataSourceIntegerField("sequenceNumber", "凭证号");
		sequenceNumberField.setRequired(false);
		sequenceNumberField.setLength(11);
		sequenceNumberField.setHidden(false);
		
		reimbursementPackageCodeField = new DataSourceTextField("reimbursementPackageCode", "编号");
		reimbursementPackageCodeField.setRequired(false);
		reimbursementPackageCodeField.setLength(512);
		reimbursementPackageCodeField.setHidden(false);

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


		setFields(voucherTypeField, voucherYearField, voucherMonthField, companyIdField, sequenceNumberField, reimbursementPackageCodeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

