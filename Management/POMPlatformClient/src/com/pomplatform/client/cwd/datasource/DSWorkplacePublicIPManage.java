package com.pomplatform.client.cwd.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSWorkplacePublicIPManage extends DBDataSource
{


	public static DSWorkplacePublicIPManage instance = null;

	public static DSWorkplacePublicIPManage getInstance() {
		if(instance == null) {
			instance = new DSWorkplacePublicIPManage("DSWorkplacePublicIPManage");
		}
		return instance;
	}

	private final DataSourceIntegerField companyWorkplacePublicIpIdField;
	private final DataSourceIntegerField companyWorkplaceIdField;
	private final DataSourceTextField workplaceNameField;
	private final DataSourceTextField ipAddressField;
	private final DataSourceBooleanField activeField;

	public DSWorkplacePublicIPManage(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("WorkplacePublicIPManage");


		companyWorkplacePublicIpIdField = new DataSourceIntegerField("companyWorkplacePublicIpId", "工作场所编码");
		companyWorkplacePublicIpIdField.setLength(11);
		companyWorkplacePublicIpIdField.setPrimaryKey(true);
		companyWorkplacePublicIpIdField.setRequired(true);
		companyWorkplacePublicIpIdField.setHidden(true);


		companyWorkplaceIdField = new DataSourceIntegerField("companyWorkplaceId", "工作场所ID");
		companyWorkplaceIdField.setLength(11);
		companyWorkplaceIdField.setRequired(false);
		companyWorkplaceIdField.setHidden(true);


		workplaceNameField = new DataSourceTextField("workplaceName", "工作场所");
		workplaceNameField.setLength(512);
		workplaceNameField.setRequired(false);
		workplaceNameField.setHidden(false);


		ipAddressField = new DataSourceTextField("ipAddress", "公网IP地址");
		ipAddressField.setLength(512);
		ipAddressField.setRequired(false);
		ipAddressField.setHidden(false);


		activeField = new DataSourceBooleanField("active", "是否有效");
		activeField.setRequired(false);
		activeField.setHidden(false);


		setFields(companyWorkplacePublicIpIdField, companyWorkplaceIdField, workplaceNameField, ipAddressField, activeField);
	}


}

