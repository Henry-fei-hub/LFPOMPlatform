package com.pomplatform.client.cwd.personalregister.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSPersonalRegisterAddressManage extends DBDataSource
{


	public static DSPersonalRegisterAddressManage instance = null;

	public static DSPersonalRegisterAddressManage getInstance() {
		if(instance == null) {
			instance = new DSPersonalRegisterAddressManage("DSPersonalRegisterAddressManage");
		}
		return instance;
	}

	private final DataSourceIntegerField personalRegisterAddressIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField ipAddressField;
	private final DataSourceTextField macAddressField;
	private final DataSourceIntegerField workplaceIdField;
	private final DataSourceTextField workplaceNameField;
	private final DataSourceDateTimeField registerTimeField;
	private final DataSourceBooleanField activeField;

	public DSPersonalRegisterAddressManage(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("PersonalRegisterAddressManage");


		personalRegisterAddressIdField = new DataSourceIntegerField("personalRegisterAddressId", "工作场所编码");
		personalRegisterAddressIdField.setLength(11);
		personalRegisterAddressIdField.setPrimaryKey(true);
		personalRegisterAddressIdField.setRequired(true);
		personalRegisterAddressIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "员工");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		ipAddressField = new DataSourceTextField("ipAddress", "公网IP地址");
		ipAddressField.setLength(512);
		ipAddressField.setRequired(false);
		ipAddressField.setHidden(false);


		macAddressField = new DataSourceTextField("macAddress", "机器MAC地址");
		macAddressField.setLength(512);
		macAddressField.setRequired(false);
		macAddressField.setHidden(false);


		workplaceIdField = new DataSourceIntegerField("workplaceId", "工作场所");
		workplaceIdField.setLength(11);
		workplaceIdField.setRequired(false);
		workplaceIdField.setHidden(true);
		
		
		workplaceNameField = new DataSourceTextField("workplaceName", "工作场所名称");
		workplaceNameField.setLength(512);
		workplaceNameField.setRequired(false);
		workplaceNameField.setHidden(false);


		registerTimeField = new DataSourceDateTimeField("registerTime", "注册时间");
		registerTimeField.setRequired(false);
		registerTimeField.setHidden(false);


		activeField = new DataSourceBooleanField("active", "是否有效");
		activeField.setRequired(false);
		activeField.setHidden(false);


		setFields(personalRegisterAddressIdField, employeeIdField, ipAddressField, macAddressField, workplaceIdField, workplaceNameField, registerTimeField, activeField);
	}


}

