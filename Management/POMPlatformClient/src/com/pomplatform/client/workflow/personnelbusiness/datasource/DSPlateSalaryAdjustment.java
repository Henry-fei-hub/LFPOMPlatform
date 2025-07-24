package com.pomplatform.client.workflow.personnelbusiness.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSPlateSalaryAdjustment extends DBDataSource
{


	public static DSPlateSalaryAdjustment instance = null;

	public static DSPlateSalaryAdjustment getInstance() {
		if(instance == null) {
			instance = new DSPlateSalaryAdjustment("DSPlateSalaryAdjustment");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceFloatField originalPayField;
	private final DataSourceIntegerField changePayField;
	private final DataSourceFloatField monthPayField;
	private final DataSourceFloatField percentField;

	public DSPlateSalaryAdjustment(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("PlateSalaryAdjustment");


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		originalPayField = new DataSourceFloatField("originalPay", "现薪资");
		originalPayField.setLength(18);
		originalPayField.setDecimalPad(2);
		originalPayField.setFormat("#,###,###,###,###,##0.00");
		originalPayField.setRequired(true);
		originalPayField.setHidden(false);


		changePayField = new DataSourceIntegerField("changePay", "调整金额");
		changePayField.setLength(8);
		changePayField.setRequired(true);
		changePayField.setHidden(false);


		monthPayField = new DataSourceFloatField("monthPay", "调整后薪资总额");
		monthPayField.setLength(18);
		monthPayField.setDecimalPad(2);
		monthPayField.setFormat("#,###,###,###,###,##0.00");
		monthPayField.setRequired(true);
		monthPayField.setHidden(false);


		percentField = new DataSourceFloatField("percent", "调薪比例");
		percentField.setLength(18);
		percentField.setDecimalPad(2);
		percentField.setFormat("#,###,###,###,###,##0.00");
		percentField.setRequired(true);
		percentField.setHidden(false);


		setFields(plateIdField, originalPayField, changePayField, monthPayField, percentField);
	}


}

