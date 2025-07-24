package com.pomplatform.client.aboutrevenueamount.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSAboutRevenueAmount extends DBDataSource
{


	public static DSAboutRevenueAmount instance = null;

	public static DSAboutRevenueAmount getInstance() {
		if(instance == null) {
			instance = new DSAboutRevenueAmount("DSAboutRevenueAmount");
		}
		return instance;
	}

	private final DataSourceIntegerField revenueCapitalsIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceFloatField capitalAmountField;
	private final DataSourceFloatField revenueAmountField;
	private final DataSourceBooleanField isTrueField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField customerNameField;

	public DSAboutRevenueAmount(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("AboutRevenueAmount");


		revenueCapitalsIdField = new DataSourceIntegerField("revenueCapitalsId", "主键id");
		revenueCapitalsIdField.setLength(11);
		revenueCapitalsIdField.setPrimaryKey(true);
		revenueCapitalsIdField.setRequired(true);
		revenueCapitalsIdField.setHidden(false);


		yearField = new DataSourceIntegerField("year", "年");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		monthField = new DataSourceIntegerField("month", "月");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(false);


		contractIdField = new DataSourceIntegerField("contractId", "合同ID");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(false);


		capitalAmountField = new DataSourceFloatField("capitalAmount", "回款金额");
		capitalAmountField.setLength(18);
		capitalAmountField.setDecimalPad(2);
		capitalAmountField.setFormat("#,###,###,###,###,##0.00");
		capitalAmountField.setRequired(false);
		capitalAmountField.setHidden(false);


		revenueAmountField = new DataSourceFloatField("revenueAmount", "营收金额");
		revenueAmountField.setLength(18);
		revenueAmountField.setDecimalPad(2);
		revenueAmountField.setFormat("#,###,###,###,###,##0.00");
		revenueAmountField.setRequired(false);
		revenueAmountField.setHidden(false);


		isTrueField = new DataSourceBooleanField("isTrue", "是否定稿");
		isTrueField.setRequired(false);
		isTrueField.setHidden(false);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(false);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setLength(512);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);


		setFields(revenueCapitalsIdField, yearField, monthField, contractIdField, capitalAmountField, revenueAmountField, isTrueField, operateEmployeeIdField, operateTimeField, contractCodeField, contractNameField, customerNameField);
	}


}

