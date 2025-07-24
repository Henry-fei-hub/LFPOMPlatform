package com.pomplatform.client.k3code.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSpecificK3Code extends DBDataSource {

	public static DSSpecificK3Code instance = null;

	public static DSSpecificK3Code getInstance() {
		if (instance == null) {
			instance = new DSSpecificK3Code("DSPlateAreaK3Code");
		}
		return instance;
	}

	private final DataSourceIntegerField k3CodeIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField k3CodeField;
	private final DataSourceTextField k3NameField;
	private final DataSourceIntegerField departmentTypeField;
	private final DataSourceIntegerField additionalBusinessIdField;

	public DSSpecificK3Code(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("K3Code");

		k3CodeIdField = new DataSourceIntegerField("k3CodeId", "主键编码");
		k3CodeIdField.setLength(11);
		k3CodeIdField.setPrimaryKey(true);
		k3CodeIdField.setRequired(true);
		k3CodeIdField.setHidden(true);

		typeField = new DataSourceIntegerField("type", " 7收款方类型");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(true);

		businessIdField = new DataSourceIntegerField("businessId", "特定科目");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(false);
		businessIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_210"));

		k3CodeField = new DataSourceTextField("k3Code", "K3代码");
		k3CodeField.setLength(64);
		k3CodeField.setRequired(false);
		k3CodeField.setHidden(false);

		k3NameField = new DataSourceTextField("k3Name", "K3名称");
		k3NameField.setLength(128);
		k3NameField.setRequired(false);
		k3NameField.setHidden(false);

		departmentTypeField = new DataSourceIntegerField("departmentType", "部门类型");
		departmentTypeField.setLength(11);
		departmentTypeField.setRequired(false);
		departmentTypeField.setHidden(true);
		departmentTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_93"));

		additionalBusinessIdField = new DataSourceIntegerField("additionalBusinessId", "区域");
		additionalBusinessIdField.setLength(11);
		additionalBusinessIdField.setRequired(false);
		additionalBusinessIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_116"));
		additionalBusinessIdField.setHidden(true);

		setFields(k3CodeIdField, typeField, businessIdField, additionalBusinessIdField, k3CodeField, k3NameField,
				departmentTypeField);
	}

}
