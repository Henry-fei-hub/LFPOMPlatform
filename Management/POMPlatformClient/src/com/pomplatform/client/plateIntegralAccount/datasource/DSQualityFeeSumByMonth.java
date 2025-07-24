package com.pomplatform.client.plateIntegralAccount.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSQualityFeeSumByMonth extends DBDataSource
{


	public static DSQualityFeeSumByMonth instance = null;

	public static DSQualityFeeSumByMonth getInstance() {
		if(instance == null) {
			instance = new DSQualityFeeSumByMonth("DSQualityFeeSumByMonth");
		}
		return instance;
	}

	private final DataSourceTextField sendYearField;
	private final DataSourceIntegerField sendMonthField;
	private final DataSourceFloatField sendIntegralField;

	public DSQualityFeeSumByMonth(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("QualityFeeSumByMonth");


		sendYearField = new DataSourceTextField("sendYear", "年份");
		sendYearField.setLength(11);
		sendYearField.setRequired(true);
		sendYearField.setHidden(false);


		sendMonthField = new DataSourceIntegerField("sendMonth", "月份");
		sendMonthField.setLength(11);
		sendMonthField.setRequired(true);
		sendMonthField.setHidden(false);


		sendIntegralField = new DataSourceFloatField("sendIntegral", "发放积分");
		sendIntegralField.setLength(18);
		sendIntegralField.setDecimalPad(2);
		sendIntegralField.setFormat("#,###,###,###,###,##0.00");
		sendIntegralField.setRequired(false);
		sendIntegralField.setHidden(false);


		setFields(sendYearField, sendMonthField, sendIntegralField);
	}


}

