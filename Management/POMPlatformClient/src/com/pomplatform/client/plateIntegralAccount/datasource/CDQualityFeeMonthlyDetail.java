package com.pomplatform.client.plateIntegralAccount.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDQualityFeeMonthlyDetail extends DataSource
{


	public static CDQualityFeeMonthlyDetail instance = null;

	public static CDQualityFeeMonthlyDetail getInstance() {
		if(instance == null) {
			instance = new CDQualityFeeMonthlyDetail("CDQualityFeeMonthlyDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField fromPlateIdField;
	private final DataSourceDateField yearField;
	private final DataSourceDateField monthField;

	public CDQualityFeeMonthlyDetail(String dataSourceID) {

		setID(dataSourceID);
		fromPlateIdField = new DataSourceIntegerField("fromPlateId", "积分提取部门");
		fromPlateIdField.setRequired(false);
		fromPlateIdField.setLength(11);
		fromPlateIdField.setHidden(false);
		fromPlateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));

		yearField = new DataSourceDateField("year", "发放日期");
		yearField.setRequired(false);
		yearField.setHidden(false);

		monthField = new DataSourceDateField("month", "发放日期");
		monthField.setRequired(false);
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


		setFields(fromPlateIdField, yearField, monthField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

