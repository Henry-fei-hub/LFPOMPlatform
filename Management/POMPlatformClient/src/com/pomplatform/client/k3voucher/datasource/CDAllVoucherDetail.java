package com.pomplatform.client.k3voucher.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDAllVoucherDetail extends DataSource
{


	public static CDAllVoucherDetail instance = null;

	public static CDAllVoucherDetail getInstance() {
		if(instance == null) {
			instance = new CDAllVoucherDetail("CDAllVoucherDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField voucherYearField;
	private final DataSourceIntegerField voucherMonthField;
	private final DataSourceIntegerField voucherTypeField;
	private final DataSourceIntegerField sequenceNumberField;
	private final DataSourceDateField vestingDateField;

	public CDAllVoucherDetail(String dataSourceID) {

		setID(dataSourceID);
		voucherYearField = new DataSourceIntegerField("voucherYear", "凭证年份");
		voucherYearField.setRequired(false);
		voucherYearField.setLength(11);
		voucherYearField.setHidden(false);

		voucherMonthField = new DataSourceIntegerField("voucherMonth", "凭证月份");
		voucherMonthField.setRequired(false);
		voucherMonthField.setLength(11);
		voucherMonthField.setHidden(false);

		voucherTypeField = new DataSourceIntegerField("voucherType", "凭证类型");
		voucherTypeField.setRequired(false);
		voucherTypeField.setLength(11);
		voucherTypeField.setHidden(false);
		voucherTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		sequenceNumberField = new DataSourceIntegerField("sequenceNumber", "凭证号");
		sequenceNumberField.setRequired(false);
		sequenceNumberField.setLength(11);
		sequenceNumberField.setHidden(false);

		vestingDateField = new DataSourceDateField("vestingDate", "归属日期");
		vestingDateField.setRequired(false);
		vestingDateField.setHidden(false);

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


		setFields(voucherYearField, voucherMonthField, voucherTypeField, sequenceNumberField, vestingDateField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

