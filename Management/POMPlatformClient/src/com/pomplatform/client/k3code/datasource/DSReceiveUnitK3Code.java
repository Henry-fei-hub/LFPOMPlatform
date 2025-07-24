package com.pomplatform.client.k3code.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSReceiveUnitK3Code extends DBDataSource
{


	public static DSReceiveUnitK3Code instance = null;

	public static DSReceiveUnitK3Code getInstance() {
		if(instance == null) {
			instance = new DSReceiveUnitK3Code("DSReceiveUnitK3Code");
		}
		return instance;
	}

	private final DataSourceIntegerField k3CodeIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField k3CodeField;
	private final DataSourceTextField k3NameField;
	private final DataSourceTextField bankAccountField;
	private final DataSourceTextField receiveUnitField;
	private final DataSourceDateField operateTimeField;

	public DSReceiveUnitK3Code(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ReceiveUnitK3Code");


		k3CodeIdField = new DataSourceIntegerField("k3CodeId", "主键编码");
		k3CodeIdField.setLength(11);
		k3CodeIdField.setPrimaryKey(true);
		k3CodeIdField.setRequired(true);
		k3CodeIdField.setHidden(true);


		typeField = new DataSourceIntegerField("type", " 7收款方类型");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(true);


		businessIdField = new DataSourceIntegerField("businessId", "收款单位");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);
//		businessIdField.setValueMap(KeyValueManager.getValueMap("receive_unit_manages_company"));
		KeyValueManager.loadValueMap("receive_unit_manages_company",businessIdField);


		k3CodeField = new DataSourceTextField("k3Code", "K3代码");
		k3CodeField.setLength(64);
		k3CodeField.setRequired(false);
		k3CodeField.setHidden(false);


		k3NameField = new DataSourceTextField("k3Name", "K3名称");
		k3NameField.setLength(128);
		k3NameField.setRequired(false);
		k3NameField.setHidden(false);


		bankAccountField = new DataSourceTextField("bankAccount", "银行账号");
		bankAccountField.setLength(64);
		bankAccountField.setRequired(false);
		bankAccountField.setHidden(false);


		receiveUnitField = new DataSourceTextField("receiveUnit", "收款单位");
		receiveUnitField.setLength(128);
		receiveUnitField.setRequired(false);
		receiveUnitField.setHidden(false);

		
		operateTimeField = new DataSourceDateField("operateTime", "创建时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);
		
		
		setFields(k3CodeIdField, typeField, businessIdField, receiveUnitField, bankAccountField, operateTimeField, k3CodeField, k3NameField);
	}


}

