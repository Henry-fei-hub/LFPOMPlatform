package com.pomplatform.client.account.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadQualityFundDetailData extends DataSource
{


	public static CDOnLoadQualityFundDetailData instance = null;

	public static CDOnLoadQualityFundDetailData getInstance() {
		if(instance == null) {
			instance = new CDOnLoadQualityFundDetailData("CDOnLoadQualityFundDetailData");
		}
		return instance;
	}

	private final DataSourceIntegerField businessTypeIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;

	public CDOnLoadQualityFundDetailData(String dataSourceID) {

		setID(dataSourceID);
		businessTypeIdField = new DataSourceIntegerField("businessTypeId", "业务类型");
		businessTypeIdField.setRequired(false);
		businessTypeIdField.setLength(11);
		businessTypeIdField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(true);
		yearField.setLength(11);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setRequired(true);
		monthField.setLength(11);
		monthField.setHidden(false);

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


		setFields(businessTypeIdField, yearField, monthField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

