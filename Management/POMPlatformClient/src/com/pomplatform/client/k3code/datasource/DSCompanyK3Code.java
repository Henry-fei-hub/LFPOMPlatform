package com.pomplatform.client.k3code.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCompanyK3Code extends DBDataSource
{


	public static DSCompanyK3Code instance = null;

	public static DSCompanyK3Code getInstance() {
		if(instance == null) {
			instance = new DSCompanyK3Code("DSCompanyK3Code");
		}
		return instance;
	}

	private final DataSourceIntegerField k3CodeIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField k3CodeField;
	private final DataSourceTextField k3NameField;
	private final DataSourceIntegerField departmentTypeField;

	public DSCompanyK3Code(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("CompanyK3Code");


		k3CodeIdField = new DataSourceIntegerField("k3CodeId", "主键编码");
		k3CodeIdField.setLength(11);
		k3CodeIdField.setPrimaryKey(true);
		k3CodeIdField.setRequired(true);
		k3CodeIdField.setHidden(true);


		typeField = new DataSourceIntegerField("type", " 7收款方类型");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(true);


		businessIdField = new DataSourceIntegerField("businessId", "公司");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(false);
		businessIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


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


		setFields(k3CodeIdField, typeField, businessIdField, k3CodeField, k3NameField, departmentTypeField);
	}


}

