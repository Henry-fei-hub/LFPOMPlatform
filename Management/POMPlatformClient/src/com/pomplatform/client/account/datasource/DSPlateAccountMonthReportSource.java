package com.pomplatform.client.account.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSPlateAccountMonthReportSource extends DBDataSource {

	public static DSPlateAccountMonthReportSource instance = null;

	public static DSPlateAccountMonthReportSource getInstance() {
		if (instance == null) {
			instance = new DSPlateAccountMonthReportSource("DSPlateAccountMonthReportSource");
		}
		return instance;
	}

	private final DataSourceIntegerField businessTypeIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceFloatField integralField;

	public DSPlateAccountMonthReportSource(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("AchieveIntegral");
		
		businessTypeIdField = new DataSourceIntegerField("businessTypeId", "业务类型");
		businessTypeIdField.setLength(18);
		businessTypeIdField.setHidden(false);
		businessTypeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_65"));
		
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(18);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		
		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(18);
		yearField.setHidden(false);
		
		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(18);
		monthField.setHidden(false);

		integralField = new DataSourceFloatField("integral", "积分");
		integralField.setLength(18);
		integralField.setDecimalPad(2);
		integralField.setFormat("#,###,###,###,###,##0.00");
		integralField.setRequired(false);
		integralField.setHidden(false);

		setFields(businessTypeIdField,plateIdField,yearField, monthField,integralField);
	}

}
