package com.pomplatform.client.account.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

public class DSEmployeeAccountSource extends DBDataSource {

	public static DSEmployeeAccountSource instance = null;

	public static DSEmployeeAccountSource getInstance() {
		if (instance == null) {
			instance = new DSEmployeeAccountSource("DSEmployeeAccountSource");
		}
		return instance;
	}

	private final DataSourceIntegerField businessTypeIdField;
	private final DataSourceFloatField integralField;

	public DSEmployeeAccountSource(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("AchieveIntegral");
		
		businessTypeIdField = new DataSourceIntegerField("businessTypeId", "业务类型");
		businessTypeIdField.setLength(18);
		businessTypeIdField.setHidden(false);
		businessTypeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_66"));

		integralField = new DataSourceFloatField("integral", "积分");
		integralField.setLength(64);
		integralField.setDecimalPad(2);
		integralField.setFormat("#,###,###,###,###,##0.00");
		integralField.setRequired(false);
		integralField.setHidden(false);
		
		setFields(businessTypeIdField, integralField);
	}

}
