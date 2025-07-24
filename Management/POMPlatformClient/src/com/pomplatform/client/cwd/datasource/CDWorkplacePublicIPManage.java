package com.pomplatform.client.cwd.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDWorkplacePublicIPManage extends DataSource
{


	public static CDWorkplacePublicIPManage instance = null;

	public static CDWorkplacePublicIPManage getInstance() {
		if(instance == null) {
			instance = new CDWorkplacePublicIPManage("CDWorkplacePublicIPManage");
		}
		return instance;
	}

	private final DataSourceBooleanField activeField;
	private final DataSourceIntegerField companyWorkplaceIdField;
	private final DataSourceTextField ipAddressField;

	public CDWorkplacePublicIPManage(String dataSourceID) {

		setID(dataSourceID);
		activeField = new DataSourceBooleanField("active", "是否有效");
		activeField.setRequired(false);
		activeField.setHidden(false);

		companyWorkplaceIdField = new DataSourceIntegerField("companyWorkplaceId", "工作场所");
		companyWorkplaceIdField.setRequired(false);
		companyWorkplaceIdField.setLength(11);
		companyWorkplaceIdField.setHidden(false);

		ipAddressField = new DataSourceTextField("ipAddress", "公网IP地址");
		ipAddressField.setRequired(false);
		ipAddressField.setLength(512);
		ipAddressField.setHidden(false);

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


		setFields(activeField, companyWorkplaceIdField, ipAddressField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

