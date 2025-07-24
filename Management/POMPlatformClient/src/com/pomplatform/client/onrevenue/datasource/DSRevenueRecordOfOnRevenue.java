package com.pomplatform.client.onrevenue.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSRevenueRecordOfOnRevenue extends DBDataSource
{


	public static DSRevenueRecordOfOnRevenue instance = null;

	public static DSRevenueRecordOfOnRevenue getInstance() {
		if(instance == null) {
			instance = new DSRevenueRecordOfOnRevenue("DSRevenueRecordOfOnRevenue");
		}
		return instance;
	}

	private final DataSourceIntegerField revenueRecordIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField codeField;
	private final DataSourceTextField nameField;
	private final DataSourceFloatField moneyField;
	private final DataSourceFloatField finishPercentField;
	private final DataSourceTextField finishPercentViewField;
	private final DataSourceFloatField revenueMoneyField;
	private final DataSourceFloatField invoiceAmountField;
	private final DataSourceFloatField borrowMoneyField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceIntegerField signingCompanyField;
	private final DataSourceBooleanField isFinishField;
	private final DataSourceDateField accountDateField;
	private final DataSourceIntegerField monthField;
	private final DataSourceIntegerField flagField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField finishPercentDetailViewField;

	public DSRevenueRecordOfOnRevenue(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("RevenueRecordOfOnRevenue");


		revenueRecordIdField = new DataSourceIntegerField("revenueRecordId", "主键编码");
		revenueRecordIdField.setLength(11);
		revenueRecordIdField.setPrimaryKey(true);
		revenueRecordIdField.setRequired(true);
		revenueRecordIdField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		codeField = new DataSourceTextField("code", "编号");
		codeField.setLength(64);
		codeField.setRequired(true);
		codeField.setHidden(false);


		nameField = new DataSourceTextField("name", "名称");
		nameField.setLength(512);
		nameField.setRequired(false);
		nameField.setHidden(false);


		moneyField = new DataSourceFloatField("money", "金额");
		moneyField.setLength(18);
		moneyField.setDecimalPad(5);
		moneyField.setFormat("#,###,###,###,##0.00");
		moneyField.setRequired(false);
		moneyField.setHidden(false);


		finishPercentField = new DataSourceFloatField("finishPercent", "完工比");
		finishPercentField.setLength(18);
		finishPercentField.setDecimalPad(5);
		finishPercentField.setFormat("#,###,###,###,##0.00");
		finishPercentField.setRequired(false);
		finishPercentField.setHidden(true);


		finishPercentViewField = new DataSourceTextField("finishPercentView", "完工比");
		finishPercentViewField.setLength(64);
		finishPercentViewField.setRequired(false);
		finishPercentViewField.setHidden(false);
		
		finishPercentDetailViewField = new DataSourceTextField("finishPercentDetailView", "完工比明细");
		finishPercentDetailViewField.setLength(64);
		finishPercentDetailViewField.setRequired(false);
		finishPercentDetailViewField.setHidden(false);


		revenueMoneyField = new DataSourceFloatField("revenueMoney", "营收金额");
		revenueMoneyField.setLength(18);
		revenueMoneyField.setDecimalPad(5);
		revenueMoneyField.setFormat("#,###,###,###,##0.00");
		revenueMoneyField.setRequired(false);
		revenueMoneyField.setHidden(false);


		invoiceAmountField = new DataSourceFloatField("invoiceAmount", "发票金额");
		invoiceAmountField.setLength(18);
		invoiceAmountField.setDecimalPad(5);
		invoiceAmountField.setFormat("#,###,###,###,##0.00");
		invoiceAmountField.setRequired(false);
		invoiceAmountField.setHidden(false);


		borrowMoneyField = new DataSourceFloatField("borrowMoney", "回款金额");
		borrowMoneyField.setLength(18);
		borrowMoneyField.setDecimalPad(5);
		borrowMoneyField.setFormat("#,###,###,###,##0.00");
		borrowMoneyField.setRequired(false);
		borrowMoneyField.setHidden(false);


		parentIdField = new DataSourceIntegerField("parentId", "父级编码");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);


		signingCompanyField = new DataSourceIntegerField("signingCompany", "签约公司");
		signingCompanyField.setLength(11);
		signingCompanyField.setRequired(false);
		signingCompanyField.setHidden(false);
		signingCompanyField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		isFinishField = new DataSourceBooleanField("isFinish", "合同是否完成");
		isFinishField.setRequired(false);
		isFinishField.setHidden(true);


		accountDateField = new DataSourceDateField("accountDate", "结算日期");
		accountDateField.setRequired(false);
		accountDateField.setHidden(true);


		monthField = new DataSourceIntegerField("month", "记录月份");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(true);


		flagField = new DataSourceIntegerField("flag", "2月末计算");
		flagField.setLength(11);
		flagField.setRequired(false);
		flagField.setHidden(true);
		flagField.setValueMap(KeyValueManager.getValueMap("system_dictionary_34"));


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(false);
//		operateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		setFields(revenueRecordIdField, contractIdField, codeField, nameField, moneyField, finishPercentField, finishPercentViewField,finishPercentDetailViewField, revenueMoneyField, invoiceAmountField, borrowMoneyField, parentIdField, signingCompanyField, isFinishField, accountDateField, monthField, flagField, operateEmployeeIdField, operateTimeField);
	}


}

