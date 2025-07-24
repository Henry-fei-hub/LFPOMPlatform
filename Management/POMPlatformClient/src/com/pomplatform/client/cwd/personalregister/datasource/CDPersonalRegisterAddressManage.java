package com.pomplatform.client.cwd.personalregister.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDPersonalRegisterAddressManage extends DataSource
{


	public static CDPersonalRegisterAddressManage instance = null;

	public static CDPersonalRegisterAddressManage getInstance() {
		if(instance == null) {
			instance = new CDPersonalRegisterAddressManage("CDPersonalRegisterAddressManage");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField ipAddressField;
	private final DataSourceTextField macAddressField;
	private final DataSourceTextField workplaceNameField;

	public CDPersonalRegisterAddressManage(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "员工姓名");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		ipAddressField = new DataSourceTextField("ipAddress", "公网IP地址");
		ipAddressField.setRequired(false);
		ipAddressField.setLength(512);
		ipAddressField.setHidden(false);

		macAddressField = new DataSourceTextField("macAddress", "机器MAC地址");
		macAddressField.setRequired(false);
		macAddressField.setLength(512);
		macAddressField.setHidden(false);

		workplaceNameField = new DataSourceTextField("workplaceName", "工作场所名称");
		workplaceNameField.setRequired(false);
		workplaceNameField.setLength(512);
		workplaceNameField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(employeeIdField, ipAddressField, macAddressField, workplaceNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

