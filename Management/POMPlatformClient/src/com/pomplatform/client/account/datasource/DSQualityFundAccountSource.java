package com.pomplatform.client.account.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

public class DSQualityFundAccountSource extends DBDataSource {

	public static DSQualityFundAccountSource instance = null;

	public static DSQualityFundAccountSource getInstance() {
		if (instance == null) {
			instance = new DSQualityFundAccountSource("DSQualityFundAccountSource");
		}
		return instance;
	}

	private final DataSourceIntegerField businessTypeIdField;
	private final DataSourceFloatField integralField;

	public DSQualityFundAccountSource(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("OnLoadQualityFundDataOfAccount");

		integralField = new DataSourceFloatField("integral", "积分");
		integralField.setLength(64);
		integralField.setDecimalPad(2);
		integralField.setFormat("#,###,###,###,###,##0.00");
		integralField.setRequired(false);
		integralField.setHidden(false);

		businessTypeIdField = new DataSourceIntegerField("businessTypeId", "业务类型");
		businessTypeIdField.setLength(18);
		businessTypeIdField.setHidden(true);
		businessTypeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_85"));
		
		setFields(businessTypeIdField, integralField);
	}

}
