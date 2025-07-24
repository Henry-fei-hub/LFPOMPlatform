package com.pomplatform.client.customer.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCustomerResources extends DBDataSource
{

	public static DSCustomerResources instance = null;
	public static DSCustomerResources getInstance() {
		if(instance == null) {
			instance = new DSCustomerResources("DSCustomerResources");
		}
		return instance;
	}

	private final DataSourceIntegerField customerResourceIdField;
	private final DataSourceTextField companyNameField;
	private final DataSourceTextField companyAddressField;
	private final DataSourceTextField nameField;
	private final DataSourceTextField gradeField;
	private final DataSourceTextField telephoneField;
	private final DataSourceTextField emailField;
	private final DataSourceDateField birthDateField;
	private final DataSourceTextField genderField;
	private final DataSourceDateTimeField operateTimeField;
	public DSCustomerResources(String dataSourceID) {
		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("CustomerResource");

		customerResourceIdField = new DataSourceIntegerField("customerResourceId", "主键编码");
		customerResourceIdField.setLength(11);
		customerResourceIdField.setPrimaryKey(true);
		customerResourceIdField.setRequired(true);
		customerResourceIdField.setHidden(true);

		companyNameField = new DataSourceTextField("companyName", "公司名称");
		companyNameField.setLength(128);
		companyNameField.setRequired(false);
		companyNameField.setHidden(false);
		
		companyAddressField = new DataSourceTextField("companyAddress", "公司地址");
		companyAddressField.setLength(128);
		companyAddressField.setRequired(false);
		companyAddressField.setHidden(false);
		
		nameField = new DataSourceTextField("name", "客户姓名");
		nameField.setLength(64);
		nameField.setRequired(false);
		nameField.setHidden(false);
		
		gradeField = new DataSourceTextField("grade", "职位");
		gradeField.setLength(64);
		gradeField.setRequired(false);
		gradeField.setHidden(false);
		
		telephoneField = new DataSourceTextField("telephone", "电话");
		telephoneField.setLength(64);
		telephoneField.setRequired(false);
		telephoneField.setHidden(false);
		
		emailField = new DataSourceTextField("email", "邮箱");
		emailField.setLength(64);
		emailField.setRequired(false);
		emailField.setHidden(false);
		
		birthDateField = new DataSourceDateField("birthDate", "生日日期");
		birthDateField.setLength(64);
		birthDateField.setRequired(false);
		birthDateField.setHidden(false);

		genderField = new DataSourceTextField("gender", "性别");
		genderField.setLength(64);
		genderField.setRequired(false);
		genderField.setHidden(false);
		genderField.setValueMap(KeyValueManager.getValueMap("system_dictionary_12"));
		
		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);

		setFields(customerResourceIdField,companyNameField,companyAddressField,nameField,gradeField,telephoneField
		,emailField,birthDateField,genderField,operateTimeField);
	}


}

