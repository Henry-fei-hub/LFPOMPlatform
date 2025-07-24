package com.pomplatform.client.plateIntegralAccount.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCompanyFeeSumByMonth extends DBDataSource
{


	public static DSCompanyFeeSumByMonth instance = null;

	public static DSCompanyFeeSumByMonth getInstance() {
		if(instance == null) {
			instance = new DSCompanyFeeSumByMonth("DSCompanyFeeSumByMonth");
		}
		return instance;
	}

	private final DataSourceTextField sendYearField;
	private final DataSourceIntegerField sendMonthField;
	private final DataSourceFloatField sendIntegralField;

	public DSCompanyFeeSumByMonth(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("CompanyFeeSumByMonth");


		sendYearField = new DataSourceTextField("sendYear", "年份");
		sendYearField.setLength(11);
		sendYearField.setRequired(true);
		sendYearField.setHidden(false);


		sendMonthField = new DataSourceIntegerField("sendMonth", "月份");
		sendMonthField.setLength(11);
		sendMonthField.setRequired(true);
		sendMonthField.setHidden(false);


		sendIntegralField = new DataSourceFloatField("sendIntegral", "公司费用");
		sendIntegralField.setLength(18);
		sendIntegralField.setDecimalPad(2);
		sendIntegralField.setFormat("#,###,###,###,###,##0.00");
		sendIntegralField.setRequired(false);
		sendIntegralField.setHidden(false);


		setFields(sendYearField, sendMonthField, sendIntegralField);
	}


}

