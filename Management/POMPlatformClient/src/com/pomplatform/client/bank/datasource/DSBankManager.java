package com.pomplatform.client.bank.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSBankManager extends DBDataSource
{


	public static DSBankManager instance = null;

	public static DSBankManager getInstance() {
		if(instance == null) {
			instance = new DSBankManager("DSBankManager");
		}
		return instance;
	}

	private final DataSourceIntegerField bankIdField;
	private final DataSourceTextField bankNameField;
	private final DataSourceIntegerField orderNumField;
	private final DataSourceDateTimeField createTimeField;

	public DSBankManager(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("BankManager");


		bankIdField = new DataSourceIntegerField("bankId", "bank_id");
		bankIdField.setLength(11);
		bankIdField.setPrimaryKey(true);
		bankIdField.setRequired(true);
		bankIdField.setHidden(true);


		bankNameField = new DataSourceTextField("bankName", "银行名称");
		bankNameField.setLength(255);
		bankNameField.setRequired(false);
		bankNameField.setHidden(false);


		orderNumField = new DataSourceIntegerField("orderNum", "排序 越小排越前");
		orderNumField.setLength(11);
		orderNumField.setRequired(false);
		orderNumField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		setFields(bankIdField, bankNameField, orderNumField, createTimeField);
	}


}

