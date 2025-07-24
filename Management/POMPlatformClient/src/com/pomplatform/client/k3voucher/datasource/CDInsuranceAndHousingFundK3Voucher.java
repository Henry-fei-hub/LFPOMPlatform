package com.pomplatform.client.k3voucher.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDInsuranceAndHousingFundK3Voucher extends DataSource
{


	public static CDInsuranceAndHousingFundK3Voucher instance = null;

	public static CDInsuranceAndHousingFundK3Voucher getInstance() {
		if(instance == null) {
			instance = new CDInsuranceAndHousingFundK3Voucher("CDInsuranceAndHousingFundK3Voucher");
		}
		return instance;
	}

	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceBooleanField lockedField;
	private final DataSourceIntegerField voucherTypeField;
	private final DataSourceIntegerField projectIdField;

	public CDInsuranceAndHousingFundK3Voucher(String dataSourceID) {

		setID(dataSourceID);
		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(false);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setRequired(false);
		monthField.setHidden(false);

		lockedField = new DataSourceBooleanField("locked", "是否定稿");
		lockedField.setRequired(false);
		lockedField.setHidden(false);

		voucherTypeField = new DataSourceIntegerField("voucherType", "凭证类型");
		voucherTypeField.setRequired(false);
		voucherTypeField.setLength(11);
		voucherTypeField.setHidden(false);
		
		projectIdField = new DataSourceIntegerField("projectId", "类型");
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);

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


		setFields(companyIdField, yearField, monthField, projectIdField, lockedField, voucherTypeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

