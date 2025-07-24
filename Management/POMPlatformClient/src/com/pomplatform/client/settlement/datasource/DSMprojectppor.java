package com.pomplatform.client.settlement.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

public class DSMprojectppor extends DBDataSource {

	public static DSMprojectppor instance = null;

	public static DSMprojectppor getInstance() {
		if (instance == null) {
			instance = new DSMprojectppor("DSMprojectppor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
    private final DataSourceIntegerField stageIdField;
	private final DataSourceFloatField projectIntegralField;
	private final DataSourceFloatField totalAmountField;
	private final DataSourceIntegerField totalcountField;
	private final DataSourceFloatField leftAmountField;

	public DSMprojectppor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mprojectppor");

		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setPrimaryKey(true);
		projectIdField.setRequired(true);
		projectIdField.setHidden(false);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects", projectIdField);
                
        stageIdField = new DataSourceIntegerField("stageId", "项目阶段");
		stageIdField.setLength(11);
		stageIdField.setPrimaryKey(true);
		stageIdField.setRequired(true);
		stageIdField.setHidden(false);
		stageIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));

		projectIntegralField = new DataSourceFloatField("projectAmount", "阶段积分");
		projectIntegralField.setLength(18);
		projectIntegralField.setDecimalPad(2);
		projectIntegralField.setFormat("#,###,###,###,###,##0.00");
		projectIntegralField.setRequired(false);
		projectIntegralField.setHidden(false);

		totalAmountField = new DataSourceFloatField("totalAmount", "已结算积分");
		totalAmountField.setLength(18);
		totalAmountField.setDecimalPad(2);
		totalAmountField.setRequired(true);
		totalAmountField.setHidden(false);

		totalcountField = new DataSourceIntegerField("totalcount", "已结算次数");
		totalcountField.setLength(8);
		totalcountField.setRequired(true);
		totalcountField.setHidden(false);

		leftAmountField = new DataSourceFloatField("leftAmount", "剩余积分");
		leftAmountField.setLength(18);
		leftAmountField.setDecimalPad(2);
		leftAmountField.setRequired(true);
		leftAmountField.setHidden(false);

		setFields(projectIdField, stageIdField, projectIntegralField, totalAmountField, totalcountField, leftAmountField);
	}

}
