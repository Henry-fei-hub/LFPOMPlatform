package com.pomplatform.client.revenuecapitalsinfo.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSRevenueCapitalsInfo extends DBDataSource
{


	public static DSRevenueCapitalsInfo instance = null;

	public static DSRevenueCapitalsInfo getInstance() {
		if(instance == null) {
			instance = new DSRevenueCapitalsInfo("DSRevenueCapitalsInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField customerNameField;
	private final DataSourceFloatField revenueAmountStartField;
	private final DataSourceFloatField capitalAmountStartField;
	private final DataSourceFloatField revenueAmountEndField;
	private final DataSourceFloatField capitalAmountEndField;
	private final DataSourceFloatField revenueOneQuarterField;
	private final DataSourceFloatField revenueTwoQuarterField;
	private final DataSourceFloatField revenueTreeQuarterField;
	private final DataSourceFloatField revenueFourQuarterField;
	private final DataSourceFloatField capitalOneQuarterField;
	private final DataSourceFloatField capitalTwoQuarterField;
	private final DataSourceFloatField capitalTreeQuarterField;
	private final DataSourceFloatField capitalFourQuarterField;

	public DSRevenueCapitalsInfo(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("RevenueCapitalsInfo");


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		contractIdField = new DataSourceIntegerField("contractId", "合同编号");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(false);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(120);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setLength(512);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);


		revenueAmountStartField = new DataSourceFloatField("revenueAmountStart", "营收");
		revenueAmountStartField.setLength(18);
		revenueAmountStartField.setDecimalPad(2);
		revenueAmountStartField.setFormat("#,###,###,###,###,##0.00");
		revenueAmountStartField.setRequired(true);
		revenueAmountStartField.setHidden(false);


		capitalAmountStartField = new DataSourceFloatField("capitalAmountStart", "回款");
		capitalAmountStartField.setLength(18);
		capitalAmountStartField.setDecimalPad(2);
		capitalAmountStartField.setFormat("#,###,###,###,###,##0.00");
		capitalAmountStartField.setRequired(true);
		capitalAmountStartField.setHidden(false);


		revenueAmountEndField = new DataSourceFloatField("revenueAmountEnd", "营收");
		revenueAmountEndField.setLength(18);
		revenueAmountEndField.setDecimalPad(2);
		revenueAmountEndField.setFormat("#,###,###,###,###,##0.00");
		revenueAmountEndField.setRequired(true);
		revenueAmountEndField.setHidden(false);


		capitalAmountEndField = new DataSourceFloatField("capitalAmountEnd", "回款");
		capitalAmountEndField.setLength(18);
		capitalAmountEndField.setDecimalPad(2);
		capitalAmountEndField.setFormat("#,###,###,###,###,##0.00");
		capitalAmountEndField.setRequired(true);
		capitalAmountEndField.setHidden(false);


		revenueOneQuarterField = new DataSourceFloatField("revenueOneQuarter", "营收");
		revenueOneQuarterField.setLength(18);
		revenueOneQuarterField.setDecimalPad(2);
		revenueOneQuarterField.setFormat("#,###,###,###,###,##0.00");
		revenueOneQuarterField.setRequired(true);
		revenueOneQuarterField.setHidden(false);


		revenueTwoQuarterField = new DataSourceFloatField("revenueTwoQuarter", "营收");
		revenueTwoQuarterField.setLength(18);
		revenueTwoQuarterField.setDecimalPad(2);
		revenueTwoQuarterField.setFormat("#,###,###,###,###,##0.00");
		revenueTwoQuarterField.setRequired(true);
		revenueTwoQuarterField.setHidden(false);


		revenueTreeQuarterField = new DataSourceFloatField("revenueTreeQuarter", "营收");
		revenueTreeQuarterField.setLength(18);
		revenueTreeQuarterField.setDecimalPad(2);
		revenueTreeQuarterField.setFormat("#,###,###,###,###,##0.00");
		revenueTreeQuarterField.setRequired(true);
		revenueTreeQuarterField.setHidden(false);


		revenueFourQuarterField = new DataSourceFloatField("revenueFourQuarter", "营收");
		revenueFourQuarterField.setLength(18);
		revenueFourQuarterField.setDecimalPad(2);
		revenueFourQuarterField.setFormat("#,###,###,###,###,##0.00");
		revenueFourQuarterField.setRequired(true);
		revenueFourQuarterField.setHidden(false);


		capitalOneQuarterField = new DataSourceFloatField("capitalOneQuarter", "回款");
		capitalOneQuarterField.setLength(18);
		capitalOneQuarterField.setDecimalPad(2);
		capitalOneQuarterField.setFormat("#,###,###,###,###,##0.00");
		capitalOneQuarterField.setRequired(true);
		capitalOneQuarterField.setHidden(false);


		capitalTwoQuarterField = new DataSourceFloatField("capitalTwoQuarter", "回款");
		capitalTwoQuarterField.setLength(18);
		capitalTwoQuarterField.setDecimalPad(2);
		capitalTwoQuarterField.setFormat("#,###,###,###,###,##0.00");
		capitalTwoQuarterField.setRequired(true);
		capitalTwoQuarterField.setHidden(false);


		capitalTreeQuarterField = new DataSourceFloatField("capitalTreeQuarter", "回款");
		capitalTreeQuarterField.setLength(18);
		capitalTreeQuarterField.setDecimalPad(2);
		capitalTreeQuarterField.setFormat("#,###,###,###,###,##0.00");
		capitalTreeQuarterField.setRequired(true);
		capitalTreeQuarterField.setHidden(true);


		capitalFourQuarterField = new DataSourceFloatField("capitalFourQuarter", "回款");
		capitalFourQuarterField.setLength(18);
		capitalFourQuarterField.setDecimalPad(2);
		capitalFourQuarterField.setFormat("#,###,###,###,###,##0.00");
		capitalFourQuarterField.setRequired(true);
		capitalFourQuarterField.setHidden(true);


		setFields(yearField, contractIdField, contractCodeField, contractNameField, customerNameField, revenueAmountStartField, capitalAmountStartField, revenueAmountEndField, capitalAmountEndField, revenueOneQuarterField, revenueTwoQuarterField, revenueTreeQuarterField, revenueFourQuarterField, capitalOneQuarterField, capitalTwoQuarterField, capitalTreeQuarterField, capitalFourQuarterField);
	}


}

