package com.pomplatform.client.account.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

public class DSQualityFundAccountMonthSource extends DBDataSource {

	public static DSQualityFundAccountMonthSource instance = null;

	public static DSQualityFundAccountMonthSource getInstance() {
		if (instance == null) {
			instance = new DSQualityFundAccountMonthSource("DSQualityFundAccountMonthSource");
		}
		return instance;
	}

	private final DataSourceIntegerField accountTypeIdField;
	private final DataSourceIntegerField accountIdField;
	private final DataSourceIntegerField businessTypeIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceFloatField achieveIntegralField;
	private final DataSourceFloatField payIntegralField;

	public DSQualityFundAccountMonthSource(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("AchieveIntegral");
		
		accountTypeIdField = new DataSourceIntegerField("accountTypeId", "账户类型");
		accountTypeIdField.setLength(18);
		accountTypeIdField.setHidden(true);
		
		accountIdField = new DataSourceIntegerField("accountId", "账户ID");
		accountIdField.setLength(18);
		accountIdField.setHidden(true);
		
		businessTypeIdField = new DataSourceIntegerField("businessTypeId", "业务类型");
		businessTypeIdField.setLength(18);
		businessTypeIdField.setHidden(false);
		businessTypeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_85"));
		
		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(18);
		yearField.setHidden(false);
		
		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(18);
		monthField.setHidden(false);

		achieveIntegralField = new DataSourceFloatField("achieveIntegral", "收入积分");
		achieveIntegralField.setLength(18);
		achieveIntegralField.setDecimalPad(2);
		achieveIntegralField.setFormat("#,###,###,###,###,##0.00");
		achieveIntegralField.setRequired(false);
		achieveIntegralField.setHidden(false);
		
		payIntegralField = new DataSourceFloatField("payIntegral", "支出积分");
		payIntegralField.setLength(18);
		payIntegralField.setDecimalPad(2);
		payIntegralField.setFormat("#,###,###,###,###,##0.00");
		payIntegralField.setRequired(false);
		payIntegralField.setHidden(false);

		setFields(accountTypeIdField,accountIdField,businessTypeIdField,yearField, monthField,achieveIntegralField,payIntegralField);
	}

}
