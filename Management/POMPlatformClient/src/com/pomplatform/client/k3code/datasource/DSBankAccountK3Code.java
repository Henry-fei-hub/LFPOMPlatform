package com.pomplatform.client.k3code.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSBankAccountK3Code extends DBDataSource
{


	public static DSBankAccountK3Code instance = null;

	public static DSBankAccountK3Code getInstance() {
		if(instance == null) {
			instance = new DSBankAccountK3Code("DSBankAccountK3Code");
		}
		return instance;
	}

	private final DataSourceTextField bankAccountField;
	private final DataSourceTextField bankAddressField;
	private final DataSourceIntegerField k3CodeIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField k3CodeField;
	private final DataSourceTextField k3NameField;

	public DSBankAccountK3Code(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("BankAccountK3Code");


		bankAccountField = new DataSourceTextField("bankAccount", "银行账号");
		bankAccountField.setLength(64);
		bankAccountField.setRequired(false);
		bankAccountField.setHidden(false);


		bankAddressField = new DataSourceTextField("bankAddress", "开户行所在地");
		bankAddressField.setLength(128);
		bankAddressField.setRequired(false);
		bankAddressField.setHidden(false);


		k3CodeIdField = new DataSourceIntegerField("k3CodeId", "主键编码");
		k3CodeIdField.setLength(11);
		k3CodeIdField.setPrimaryKey(true);
		k3CodeIdField.setRequired(true);
		k3CodeIdField.setHidden(true);


		typeField = new DataSourceIntegerField("type", " 7收款方类型");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(true);


		businessIdField = new DataSourceIntegerField("businessId", "部门");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);
		businessIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		k3CodeField = new DataSourceTextField("k3Code", "K3代码");
		k3CodeField.setLength(64);
		k3CodeField.setRequired(false);
		k3CodeField.setHidden(false);


		k3NameField = new DataSourceTextField("k3Name", "K3名称");
		k3NameField.setLength(128);
		k3NameField.setRequired(false);
		k3NameField.setHidden(false);


		setFields(k3CodeIdField, bankAccountField, bankAddressField, typeField, businessIdField, k3CodeField, k3NameField);
	}


}

