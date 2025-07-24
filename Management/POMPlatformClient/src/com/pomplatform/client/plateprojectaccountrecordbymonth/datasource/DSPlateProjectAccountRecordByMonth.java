package com.pomplatform.client.plateprojectaccountrecordbymonth.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSPlateProjectAccountRecordByMonth extends DBDataSource
{


	public static DSPlateProjectAccountRecordByMonth instance = null;

	public static DSPlateProjectAccountRecordByMonth getInstance() {
		if(instance == null) {
			instance = new DSPlateProjectAccountRecordByMonth("DSPlateProjectAccountRecordByMonth");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceIntegerField recordYearField;
	private final DataSourceIntegerField recordMonthField;
	private final DataSourceFloatField accountIntegralField;

	public DSPlateProjectAccountRecordByMonth(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("PlateProjectAccountRecordByMonth");


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


		accountIntegralField = new DataSourceFloatField("accountIntegral", "结算积分");
		accountIntegralField.setLength(15);
		accountIntegralField.setDecimalPad(2);
		accountIntegralField.setFormat("#,###,###,##0.00");
		accountIntegralField.setRequired(false);
		accountIntegralField.setHidden(false);


		setFields(plateIdField, recordYearField, recordMonthField, accountIntegralField);
	}


}

