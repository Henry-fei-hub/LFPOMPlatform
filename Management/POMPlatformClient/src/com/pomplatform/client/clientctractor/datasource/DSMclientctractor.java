package com.pomplatform.client.clientctractor.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMclientctractor extends DBDataSource
{


	public static DSMclientctractor instance = null;

	public static DSMclientctractor getInstance() {
		if(instance == null) {
			instance = new DSMclientctractor("DSMclientctractor");
		}
		return instance;
	}

	private final DataSourceIntegerField clientIdField;
	private final DataSourceTextField clientNameField;
	private final DataSourceTextField clientPhoneField;
	private final DataSourceTextField clientCompanyField;
	private final DataSourceTextField clientAddressField;
	private final DataSourceTextField clientJobField;
	private final DataSourceTextField clientWeixinField;
	private final DataSourceTextField clientQqField;
	private final DataSourceTextField clientEmailField;
	private final DataSourceIntegerField clientRoleField;

	public DSMclientctractor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mclientctractor");


		clientIdField = new DataSourceIntegerField("clientId", "客户编码");
		clientIdField.setLength(11);
		clientIdField.setPrimaryKey(true);
		clientIdField.setRequired(true);
		clientIdField.setHidden(false);


		clientNameField = new DataSourceTextField("clientName", "联系人姓名");
		clientNameField.setLength(64);
		clientNameField.setRequired(false);
		clientNameField.setHidden(false);


		clientPhoneField = new DataSourceTextField("clientPhone", "联系人手机");
		clientPhoneField.setLength(64);
		clientPhoneField.setRequired(false);
		clientPhoneField.setHidden(false);


		clientCompanyField = new DataSourceTextField("clientCompany", "单位名称");
		clientCompanyField.setLength(64);
		clientCompanyField.setRequired(false);
		clientCompanyField.setHidden(false);


		clientAddressField = new DataSourceTextField("clientAddress", "单位地址");
		clientAddressField.setLength(64);
		clientAddressField.setRequired(false);
		clientAddressField.setHidden(false);


		clientJobField = new DataSourceTextField("clientJob", "职务");
		clientJobField.setLength(32);
		clientJobField.setRequired(false);
		clientJobField.setHidden(false);


		clientWeixinField = new DataSourceTextField("clientWeixin", "微信");
		clientWeixinField.setLength(32);
		clientWeixinField.setRequired(false);
		clientWeixinField.setHidden(false);


		clientQqField = new DataSourceTextField("clientQq", "QQ");
		clientQqField.setLength(20);
		clientQqField.setRequired(false);
		clientQqField.setHidden(false);


		clientEmailField = new DataSourceTextField("clientEmail", "邮箱");
		clientEmailField.setLength(64);
		clientEmailField.setRequired(false);
		clientEmailField.setHidden(false);


		clientRoleField = new DataSourceIntegerField("clientRole", "联系人角色");
		clientRoleField.setLength(11);
		clientRoleField.setRequired(false);
		clientRoleField.setHidden(false);

		
		java.util.Map<String, String> clientRoleValues = new java.util.HashMap<>();
        clientRoleValues.put("0", "客户");
        clientRoleValues.put("1", "建筑设计单位联系人");
        clientRoleField.setValueMap(clientRoleValues);
		
		setFields(clientIdField, clientNameField, clientPhoneField, clientCompanyField, clientAddressField, clientJobField, clientWeixinField, clientQqField, clientEmailField, clientRoleField);
	}


}

