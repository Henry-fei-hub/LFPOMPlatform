package com.pomplatform.client.employeereportrecorddetail.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSAchieveIntegralToSource extends DBDataSource {

	public static DSAchieveIntegralToSource instance = null;

	public static DSAchieveIntegralToSource getInstance() {
		if (instance == null) {
			instance = new DSAchieveIntegralToSource("DSAchieveIntegralSource");
		}
		return instance;
	}

	private final DataSourceTextField achieveIntegralNameField;
	private final DataSourceFloatField achieveIntegralField;
	private final DataSourceIntegerField flagField;

	public DSAchieveIntegralToSource(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("AchieveIntegral");

		achieveIntegralNameField = new DataSourceTextField("achieveIntegralName", "支出");
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
