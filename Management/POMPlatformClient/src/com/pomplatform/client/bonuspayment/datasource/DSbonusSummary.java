package com.pomplatform.client.bonuspayment.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSbonusSummary extends DBDataSource
{


	public static DSbonusSummary instance = null;

	public static DSbonusSummary getInstance() {
		if(instance == null) {
			instance = new DSbonusSummary("DSbonusSummary");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceTextField plateNameField;
	private final DataSourceFloatField firstPayIntegralField;
	private final DataSourceFloatField secondPayIntegralField;
	private final DataSourceFloatField thirdPayIntegralField;
	private final DataSourceFloatField fourthPayIntegralField;
	private final DataSourceFloatField totalPayIntegralField;
	private final DataSourceTextField yearField;

	public DSbonusSummary(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("bonusSummary");


		plateIdField = new DataSourceIntegerField("plateId", "业务部门编码");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(true);


		plateNameField = new DataSourceTextField("plateName", "业务部门");
		plateNameField.setLength(64);
		plateNameField.setRequired(false);
		plateNameField.setHidden(false);


		firstPayIntegralField = new DataSourceFloatField("firstPayIntegral", "第一季度");
		firstPayIntegralField.setLength(18);
		firstPayIntegralField.setDecimalPad(2);
		firstPayIntegralField.setFormat("#,###,###,###,###,##0.00");
		firstPayIntegralField.setRequired(true);
		firstPayIntegralField.setHidden(false);


		secondPayIntegralField = new DataSourceFloatField("secondPayIntegral", "第二季度");
		secondPayIntegralField.setLength(18);
		secondPayIntegralField.setDecimalPad(2);
		secondPayIntegralField.setFormat("#,###,###,###,###,##0.00");
		secondPayIntegralField.setRequired(true);
		secondPayIntegralField.setHidden(false);


		thirdPayIntegralField = new DataSourceFloatField("thirdPayIntegral", "第三季度");
		thirdPayIntegralField.setLength(18);
		thirdPayIntegralField.setDecimalPad(2);
		thirdPayIntegralField.setFormat("#,###,###,###,###,##0.00");
		thirdPayIntegralField.setRequired(true);
		thirdPayIntegralField.setHidden(false);


		fourthPayIntegralField = new DataSourceFloatField("fourthPayIntegral", "第四季度");
		fourthPayIntegralField.setLength(18);
		fourthPayIntegralField.setDecimalPad(2);
		fourthPayIntegralField.setFormat("#,###,###,###,###,##0.00");
		fourthPayIntegralField.setRequired(true);
		fourthPayIntegralField.setHidden(false);


		totalPayIntegralField = new DataSourceFloatField("totalPayIntegral", "合计");
		totalPayIntegralField.setLength(18);
		totalPayIntegralField.setDecimalPad(2);
		totalPayIntegralField.setFormat("#,###,###,###,###,##0.00");
		totalPayIntegralField.setRequired(true);
		totalPayIntegralField.setHidden(false);


		yearField = new DataSourceTextField("year", "年份");
		yearField.setLength(18);
		yearField.setRequired(true);
		yearField.setHidden(false);


		setFields(plateIdField, plateNameField, yearField, firstPayIntegralField, secondPayIntegralField, thirdPayIntegralField, fourthPayIntegralField, totalPayIntegralField);
	}


}

