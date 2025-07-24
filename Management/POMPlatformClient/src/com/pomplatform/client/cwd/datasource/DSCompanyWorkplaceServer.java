package com.pomplatform.client.cwd.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCompanyWorkplaceServer extends DBDataSource
{


	public static DSCompanyWorkplaceServer instance = null;

	public static DSCompanyWorkplaceServer getInstance() {
		if(instance == null) {
			instance = new DSCompanyWorkplaceServer("DSCompanyWorkplaceServer");
		}
		return instance;
	}

	private final DataSourceIntegerField workplaceServerIdField;
	private final DataSourceIntegerField workplaceIdField;
	private final DataSourceTextField intranetServerAddressField;
	private final DataSourceIntegerField intranetServerPortField;
	private final DataSourceTextField externalServerAddressField;
	private final DataSourceIntegerField externalServerPortField;
	private final DataSourceBooleanField externalServerUseableField;
	private final DataSourceTextField urlField;
	private final DataSourceBooleanField activeField;

	public DSCompanyWorkplaceServer(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("CompanyWorkplaceServer");


		workplaceServerIdField = new DataSourceIntegerField("workplaceServerId", "主键编码");
		workplaceServerIdField.setLength(11);
		workplaceServerIdField.setPrimaryKey(true);
		workplaceServerIdField.setRequired(true);
		workplaceServerIdField.setHidden(true);


		workplaceIdField = new DataSourceIntegerField("workplaceId", "工作场所编码");
		workplaceIdField.setLength(11);
		workplaceIdField.setRequired(false);
		workplaceIdField.setHidden(true);


		intranetServerAddressField = new DataSourceTextField("intranetServerAddress", "服务器内网地址");
		intranetServerAddressField.setLength(64);
		intranetServerAddressField.setRequired(false);
		intranetServerAddressField.setHidden(false);


		intranetServerPortField = new DataSourceIntegerField("intranetServerPort", "服务器内网端口号");
		intranetServerPortField.setLength(11);
		intranetServerPortField.setRequired(false);
		intranetServerPortField.setHidden(false);


		externalServerAddressField = new DataSourceTextField("externalServerAddress", "服务器外网地址");
		externalServerAddressField.setLength(64);
		externalServerAddressField.setRequired(false);
		externalServerAddressField.setHidden(false);


		externalServerPortField = new DataSourceIntegerField("externalServerPort", "服务器外网端口号");
		externalServerPortField.setLength(11);
		externalServerPortField.setRequired(false);
		externalServerPortField.setHidden(false);


		externalServerUseableField = new DataSourceBooleanField("externalServerUseable", "外网服务器是否可用");
		externalServerUseableField.setRequired(false);
		externalServerUseableField.setHidden(false);

		
		urlField = new DataSourceTextField("url", "URL地址");
		urlField.setLength(256);
		urlField.setRequired(false);
		urlField.setHidden(false);

		
		activeField = new DataSourceBooleanField("active", "是否有效");
		activeField.setRequired(false);
		activeField.setHidden(false);


		setFields(workplaceServerIdField, workplaceIdField, intranetServerAddressField, intranetServerPortField, externalServerAddressField, externalServerPortField, externalServerUseableField, urlField, activeField);
	}


}

