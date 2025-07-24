package com.pomplatform.client.mcecscreeor.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMcecscreeor extends DBDataSource
{


	public static DSMcecscreeor instance = null;

	public static DSMcecscreeor getInstance() {
		if(instance == null) {
			instance = new DSMcecscreeor("DSMcecscreeor");
		}
		return instance;
	}

	private final DataSourceIntegerField contractCodeIdField;
	private final DataSourceIntegerField signCompanyField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField employeeNameField;

	public DSMcecscreeor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mcecscreeor");


		contractCodeIdField = new DataSourceIntegerField("contractCodeId", "主键");
		contractCodeIdField.setLength(11);
		contractCodeIdField.setPrimaryKey(true);
		contractCodeIdField.setRequired(true);
		contractCodeIdField.setHidden(true);


		signCompanyField = new DataSourceIntegerField("signCompany", "签约公司");
		signCompanyField.setLength(11);
		signCompanyField.setRequired(false);
		signCompanyField.setHidden(true);
		signCompanyField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(255);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "合同名称");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "操作人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "操作人");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(true);


		setFields(contractCodeIdField, signCompanyField, contractCodeField, remarkField, employeeIdField, createTimeField, employeeNameField);
	}


}

