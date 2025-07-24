package com.pomplatform.client.platereportrecorddetail.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSAchieveIntegralSource extends DBDataSource {

	public static DSAchieveIntegralSource instance = null;

	public static DSAchieveIntegralSource getInstance() {
		if (instance == null) {
			instance = new DSAchieveIntegralSource("DSAchieveIntegralSource");
		}
		return instance;
	}

	private final DataSourceTextField achieveIntegralNameField;
	private final DataSourceFloatField achieveIntegralField;
	private final DataSourceIntegerField flagField;

	public DSAchieveIntegralSource(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("AchieveIntegral");

		achieveIntegralNameField = new DataSourceTextField("achieveIntegralName", "收入");
		achieveIntegralNameField.setLength(64);
		achieveIntegralNameField.setRequired(false);
		achieveIntegralNameField.setHidden(false);

		achieveIntegralField = new DataSourceFloatField("achieveIntegral", "积分");
		achieveIntegralField.setLength(18);
		achieveIntegralField.setDecimalPad(2);
		achieveIntegralField.setFormat("#,###,###,###,###,##0.00");
		achieveIntegralField.setRequired(false);
		achieveIntegralField.setHidden(false);

		flagField = new DataSourceIntegerField("flag", "标示");
		flagField.setLength(18);
		flagField.setHidden(true);

		setFields(achieveIntegralNameField, achieveIntegralField, flagField);
	}

}
