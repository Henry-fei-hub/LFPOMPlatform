package com.pomplatform.client.account.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

public class DSPlateAccountSource extends DBDataSource {

	public static DSPlateAccountSource instance = null;

	public static DSPlateAccountSource getInstance() {
		if (instance == null) {
			instance = new DSPlateAccountSource("DSPlateAccountSource");
		}
		return instance;
	}

	private final DataSourceIntegerField businessTypeIdField;
	private final DataSourceFloatField integralField;

	public DSPlateAccountSource(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("AchieveIntegral");

		integralField = new DataSourceFloatField("integral", "积分");
		integralField.setLength(64);
		integralField.setDecimalPad(2);
		integralField.setFormat("#,###,###,###,###,##0.00");
		integralField.setRequired(false);
		integralField.setHidden(false);

		businessTypeIdField = new DataSourceIntegerField("businessTypeId", "业务类型");
		businessTypeIdField.setLength(18);
		businessTypeIdField.setHidden(false);
		businessTypeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_65"));
		
		setFields(businessTypeIdField, integralField);
	}

}
