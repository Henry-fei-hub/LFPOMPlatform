package com.pomplatform.client.k3code.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSk3codetpor extends DBDataSource
{


	public static DSSk3codetpor instance = null;

	public static DSSk3codetpor getInstance() {
		if(instance == null) {
			instance = new DSSk3codetpor("DSSk3codetpor");
		}
		return instance;
	}

	private final DataSourceIntegerField k3CodeIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField k3CodeField;
	private final DataSourceTextField k3NameField;
	private final DataSourceIntegerField departmentTypeField;

	public DSSk3codetpor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sk3codetpor");


		k3CodeIdField = new DataSourceIntegerField("k3CodeId", "主键编码");
		k3CodeIdField.setLength(11);
		k3CodeIdField.setPrimaryKey(true);
		k3CodeIdField.setRequired(true);
		k3CodeIdField.setHidden(false);


		typeField = new DataSourceIntegerField("type", " 7收款方类型");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(false);


		businessIdField = new DataSourceIntegerField("businessId", "原有业务表的编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(false);
		businessIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		k3CodeField = new DataSourceTextField("k3Code", "K3编号");
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
		departmentTypeField.setHidden(false);
		departmentTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_93"));


		setFields(k3CodeIdField, typeField, businessIdField, k3CodeField, k3NameField, departmentTypeField);
	}


}

