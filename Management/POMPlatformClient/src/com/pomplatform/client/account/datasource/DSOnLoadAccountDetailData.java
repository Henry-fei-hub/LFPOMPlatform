package com.pomplatform.client.account.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnLoadAccountDetailData extends DBDataSource
{


	public static DSOnLoadAccountDetailData instance = null;

	public static DSOnLoadAccountDetailData getInstance() {
		if(instance == null) {
			instance = new DSOnLoadAccountDetailData("DSOnLoadAccountDetailData");
		}
		return instance;
	}

	private final DataSourceIntegerField accountTypeIdField;
	private final DataSourceIntegerField accountIdField;
	private final DataSourceIntegerField businessTypeIdField;
	private final DataSourceFloatField achieveIntegralField;
	private final DataSourceFloatField payIntegralField;
	private final DataSourceDateField recordDateField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;

	public DSOnLoadAccountDetailData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadMonthDetailOfAccount");


		accountTypeIdField = new DataSourceIntegerField("accountTypeId", "账户类型");
		accountTypeIdField.setLength(11);
		accountTypeIdField.setPrimaryKey(true);
		accountTypeIdField.setRequired(true);
		accountTypeIdField.setHidden(true);


		accountIdField = new DataSourceIntegerField("accountId", "账户ID");
		accountIdField.setLength(11);
		accountIdField.setRequired(false);
		accountIdField.setHidden(true);


		businessTypeIdField = new DataSourceIntegerField("businessTypeId", "业务类型");
		businessTypeIdField.setLength(11);
		businessTypeIdField.setRequired(false);
		businessTypeIdField.setHidden(false);
		businessTypeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_85"));


		achieveIntegralField = new DataSourceFloatField("achieveIntegral", "收入积分");
		achieveIntegralField.setLength(18);
		achieveIntegralField.setDecimalPad(2);
		achieveIntegralField.setFormat("#,###,###,###,###,##0.00");
		achieveIntegralField.setRequired(false);
		achieveIntegralField.setHidden(false);
		
		payIntegralField = new DataSourceFloatField("payIntegral", "支出积分");
		payIntegralField.setLength(18);
		payIntegralField.setDecimalPad(2);
		payIntegralField.setFormat("#,###,###,###,###,##0.00");
		payIntegralField.setRequired(false);
		payIntegralField.setHidden(false);


		recordDateField = new DataSourceDateField("recordDate", "日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(false);
		operateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(accountTypeIdField, accountIdField, businessTypeIdField, achieveIntegralField,payIntegralField, recordDateField, operateEmployeeIdField, operateTimeField, remarkField);
	}


}

