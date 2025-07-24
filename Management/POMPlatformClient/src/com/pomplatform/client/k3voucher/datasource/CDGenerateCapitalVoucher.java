package com.pomplatform.client.k3voucher.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDGenerateCapitalVoucher extends DataSource
{


	public static CDGenerateCapitalVoucher instance = null;

	public static CDGenerateCapitalVoucher getInstance() {
		if(instance == null) {
			instance = new CDGenerateCapitalVoucher("CDGenerateCapitalVoucher");
		}
		return instance;
	}

	private final DataSourceIntegerField moneyAttributeField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceBooleanField haveVoucherField;
	private final DataSourceIntegerField selfNameField;

	public CDGenerateCapitalVoucher(String dataSourceID) {

		setID(dataSourceID);
		moneyAttributeField = new DataSourceIntegerField("moneyAttribute", "款项属性");
		moneyAttributeField.setRequired(false);
		moneyAttributeField.setLength(11);
		moneyAttributeField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "发生年份");
		yearField.setRequired(true);
		yearField.setLength(11);
		yearField.setHidden(false);
		yearField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		monthField = new DataSourceIntegerField("month", "发生月份");
		monthField.setRequired(true);
		monthField.setLength(11);
		monthField.setHidden(false);
		monthField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		haveVoucherField = new DataSourceBooleanField("haveVoucher", "是否有凭证");
		haveVoucherField.setRequired(false);
		haveVoucherField.setHidden(false);

		selfNameField = new DataSourceIntegerField("selfName", "内部公司(收款方)");
		selfNameField.setRequired(false);
		selfNameField.setLength(11);
		selfNameField.setHidden(false);
		selfNameField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

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


		setFields(moneyAttributeField, yearField, monthField, haveVoucherField, selfNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

