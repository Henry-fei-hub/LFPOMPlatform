package com.pomplatform.client.bonuspayment.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSbonusSummaryDetail extends DBDataSource
{


	public static DSbonusSummaryDetail instance = null;

	public static DSbonusSummaryDetail getInstance() {
		if(instance == null) {
			instance = new DSbonusSummaryDetail("DSbonusSummaryDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField departmentNameField;
	private final DataSourceFloatField firstPayIntegralField;
	private final DataSourceFloatField secondPayIntegralField;
	private final DataSourceFloatField thirdPayIntegralField;
	private final DataSourceFloatField fourthPayIntegralField;
	private final DataSourceFloatField totalPayIntegralField;
	private final DataSourceTextField yearField;

	public DSbonusSummaryDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("bonusSummaryDetail");


		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门编码");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(true);


		departmentNameField = new DataSourceTextField("departmentName", "部门名称");
		departmentNameField.setLength(64);
		departmentNameField.setRequired(true);
		departmentNameField.setHidden(false);


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


		setFields(departmentIdField, departmentNameField, yearField, firstPayIntegralField, secondPayIntegralField, thirdPayIntegralField, fourthPayIntegralField, totalPayIntegralField, yearField);
	}


}

