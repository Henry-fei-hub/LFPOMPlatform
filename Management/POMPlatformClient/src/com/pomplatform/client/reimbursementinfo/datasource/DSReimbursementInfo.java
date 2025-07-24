package com.pomplatform.client.reimbursementinfo.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSReimbursementInfo extends DBDataSource
{


	public static DSReimbursementInfo instance = null;

	public static DSReimbursementInfo getInstance() {
		if(instance == null) {
			instance = new DSReimbursementInfo("DSNewReimbursementPackage");
		}
		return instance;
	}

	private final DataSourceIntegerField processTypeIdField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField codeField;
	private final DataSourceIntegerField drafterIdField;
	private final DataSourceTextField titleField;
	private final DataSourceFloatField amountField;

	public DSReimbursementInfo(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("ReimbursementInfo");


		processTypeIdField = new DataSourceIntegerField("processTypeId", "流程类型");
		processTypeIdField.setLength(11);
		processTypeIdField.setRequired(false);
		processTypeIdField.setHidden(false);
		processTypeIdField.setValueMap(KeyValueManager.getValueMap("system_process_types"));


		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);


		codeField = new DataSourceTextField("code", "编号");
		codeField.setLength(64);
		codeField.setRequired(false);
		codeField.setHidden(false);


		drafterIdField = new DataSourceIntegerField("drafterId", "发起人");
		drafterIdField.setLength(11);
		drafterIdField.setRequired(false);
		drafterIdField.setHidden(false);
		drafterIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		amountField = new DataSourceFloatField("amount", "金额");
		amountField.setLength(18);
		amountField.setDecimalPad(5);
		amountField.setFormat("#,###,###,###,##0.00");
		amountField.setRequired(true);
		amountField.setHidden(false);


		titleField = new DataSourceTextField("code", "主题");
		titleField.setLength(216);
		titleField.setRequired(false);
		titleField.setHidden(false);

		setFields(processTypeIdField, businessIdField, codeField, drafterIdField, amountField, titleField);
	}


}

