package com.pomplatform.client.manageprojectbymonth.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSManageProjectByMonth extends DBDataSource
{


	public static DSManageProjectByMonth instance = null;

	public static DSManageProjectByMonth getInstance() {
		if(instance == null) {
			instance = new DSManageProjectByMonth("DSManageProjectByMonth");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceIntegerField recordYearField;
	private final DataSourceIntegerField recordMonthField;
	private final DataSourceFloatField totalIntegralField;
	private final DataSourceFloatField leftIntegralField;

	public DSManageProjectByMonth(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ManageProjectByMonth");


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


		totalIntegralField = new DataSourceFloatField("totalIntegral", "项目总积分");
		totalIntegralField.setLength(10);
		totalIntegralField.setDecimalPad(2);
		totalIntegralField.setFormat("##,###,##0.00");
		totalIntegralField.setRequired(false);
		totalIntegralField.setHidden(false);


		leftIntegralField = new DataSourceFloatField("leftIntegral", "剩余积分");
		leftIntegralField.setLength(10);
		leftIntegralField.setDecimalPad(2);
		leftIntegralField.setFormat("##,###,##0.00");
		leftIntegralField.setRequired(false);
		leftIntegralField.setHidden(false);


		setFields(plateIdField, recordYearField, recordMonthField, totalIntegralField, leftIntegralField);
	}


}

