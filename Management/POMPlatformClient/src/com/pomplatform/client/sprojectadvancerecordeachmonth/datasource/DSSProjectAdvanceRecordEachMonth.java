package com.pomplatform.client.sprojectadvancerecordeachmonth.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSProjectAdvanceRecordEachMonth extends DBDataSource
{


	public static DSSProjectAdvanceRecordEachMonth instance = null;

	public static DSSProjectAdvanceRecordEachMonth getInstance() {
		if(instance == null) {
			instance = new DSSProjectAdvanceRecordEachMonth("DSSProjectAdvanceRecordEachMonth");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceIntegerField advanceYearField;
	private final DataSourceIntegerField advanceMonthField;
	private final DataSourceFloatField advanceIntegralField;
	private final DataSourceFloatField leftIntegralField;

	public DSSProjectAdvanceRecordEachMonth(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SProjectAdvanceRecordEachMonth");


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(32);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		advanceYearField = new DataSourceIntegerField("advanceYear", "年份");
		advanceYearField.setLength(11);
		advanceYearField.setRequired(true);
		advanceYearField.setHidden(false);


		advanceMonthField = new DataSourceIntegerField("advanceMonth", "月份");
		advanceMonthField.setLength(11);
		advanceMonthField.setRequired(true);
		advanceMonthField.setHidden(false);


		advanceIntegralField = new DataSourceFloatField("advanceIntegral", "补贴积分");
		advanceIntegralField.setLength(18);
		advanceIntegralField.setDecimalPad(2);
		advanceIntegralField.setFormat("#,###,###,###,###,##0.00");
		advanceIntegralField.setRequired(false);
		advanceIntegralField.setHidden(false);


		leftIntegralField = new DataSourceFloatField("leftIntegral", "剩余积分");
		leftIntegralField.setLength(18);
		leftIntegralField.setDecimalPad(2);
		leftIntegralField.setFormat("#,###,###,###,###,##0.00");
		leftIntegralField.setRequired(false);
		leftIntegralField.setHidden(false);


		setFields(plateIdField, advanceYearField, advanceMonthField, advanceIntegralField, leftIntegralField);
	}


}

