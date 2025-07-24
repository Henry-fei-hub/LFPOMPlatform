package com.pomplatform.client.employeemoneymanagespeemmepemmor.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMemployeemoneymanagespeemmepemmor extends DBDataSource
{


	public static DSMemployeemoneymanagespeemmepemmor instance = null;

	public static DSMemployeemoneymanagespeemmepemmor getInstance() {
		if(instance == null) {
			instance = new DSMemployeemoneymanagespeemmepemmor("DSMemployeemoneymanagespeemmepemmor");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceFloatField moneyField;
	private final DataSourceFloatField returnMoneyField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField businessNameField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceTextField equivalentNumberField;
	private final DataSourceIntegerField mTypeField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField processTypeField;

	public DSMemployeemoneymanagespeemmepemmor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Memployeemoneymanagespeemmepemmor");


		employeeIdField = new DataSourceIntegerField("employeeId", "姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		moneyField = new DataSourceFloatField("money", "金额");
		moneyField.setLength(18);
		moneyField.setDecimalPad(2);
		moneyField.setFormat("#,###,###,###,###,##0.00");
		moneyField.setRequired(true);
		moneyField.setHidden(false);


		returnMoneyField = new DataSourceFloatField("returnMoney", "还款金额");
		returnMoneyField.setLength(18);
		returnMoneyField.setDecimalPad(5);
		returnMoneyField.setFormat("#,###,###,###,###.##");
		returnMoneyField.setRequired(false);
		returnMoneyField.setHidden(true);


		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);


		businessNameField = new DataSourceTextField("businessName", "备注");
		businessNameField.setLength(256);
		businessNameField.setRequired(false);
		businessNameField.setHidden(false);


		completeTimeField = new DataSourceDateTimeField("completeTime", "时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(false);


		equivalentNumberField = new DataSourceTextField("equivalentNumber", "对冲号");
		equivalentNumberField.setLength(64);
		equivalentNumberField.setRequired(false);
		equivalentNumberField.setHidden(false);


		mTypeField = new DataSourceIntegerField("mType", "款项类型");
		mTypeField.setLength(11);
		mTypeField.setRequired(true);
		mTypeField.setHidden(false);

		java.util.Map<String,String> mTypeValues = new java.util.HashMap<String,String>();
		mTypeValues.put("1", "借款");
		mTypeValues.put("2", "冲账");
		mTypeValues.put("3", "还款");
		mTypeValues.put("4", "系统期初");
		mTypeField.setValueMap(mTypeValues);


		processIdField = new DataSourceIntegerField("processId", "流程编码");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "主键编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setPrimaryKey(true);
		processInstanceIdField.setRequired(true);
		processInstanceIdField.setHidden(true);


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);


		setFields(processInstanceIdField, employeeIdField, moneyField, returnMoneyField, mTypeField, businessIdField, completeTimeField, equivalentNumberField, processIdField, processTypeField, businessNameField);
	}


}

