package com.pomplatform.client.platecostrecord.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSPlateCostMonthly extends DBDataSource
{


	public static DSPlateCostMonthly instance = null;

	public static DSPlateCostMonthly getInstance() {
		if(instance == null) {
			instance = new DSPlateCostMonthly("DSPlateCostMonthly");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceIntegerField recordYearField;
	private final DataSourceIntegerField recordMonthField;
	private final DataSourceFloatField integralField;

	public DSPlateCostMonthly(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("PlateCostMonthly");


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		recordYearField = new DataSourceIntegerField("recordYear", "年份");
		recordYearField.setLength(11);
		recordYearField.setRequired(true);
		recordYearField.setHidden(false);


		recordMonthField = new DataSourceIntegerField("recordMonth", "月份");
		recordMonthField.setLength(11);
		recordMonthField.setRequired(true);
		recordMonthField.setHidden(false);


		integralField = new DataSourceFloatField("integral", "运营成本");
		integralField.setLength(18);
		integralField.setDecimalPad(2);
		integralField.setFormat("#,###,###,###,###,##0.00");
		integralField.setRequired(false);
		integralField.setHidden(false);


		setFields(plateIdField, recordYearField, recordMonthField, integralField);
	}


}

