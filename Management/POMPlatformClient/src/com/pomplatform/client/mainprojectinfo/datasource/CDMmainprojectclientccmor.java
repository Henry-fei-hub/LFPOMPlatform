package com.pomplatform.client.mainprojectinfo.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMmainprojectclientccmor extends DataSource
{


	public static CDMmainprojectclientccmor instance = null;

	public static CDMmainprojectclientccmor getInstance() {
		if(instance == null) {
			instance = new CDMmainprojectclientccmor("CDMmainprojectclientccmor");
		}
		return instance;
	}

	private final DataSourceIntegerField clientRoleField;
	private final DataSourceIntegerField mainProjectIdField;

	public CDMmainprojectclientccmor(String dataSourceID) {

		setID(dataSourceID);
		clientRoleField = new DataSourceIntegerField("clientRole", "联系人角色");
		clientRoleField.setRequired(false);
		clientRoleField.setLength(11);
		clientRoleField.setHidden(false);

		java.util.Map<String,String> clientRoleValues = new java.util.HashMap<String,String>();
		clientRoleValues.put("0", "客户");
		clientRoleValues.put("1", "建筑设计单位联系人");
		clientRoleField.setValueMap(clientRoleValues);

		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "主项目编码");
		mainProjectIdField.setRequired(true);
		mainProjectIdField.setLength(11);
		mainProjectIdField.setPrimaryKey(true);
		mainProjectIdField.setHidden(false);

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


		setFields(clientRoleField, mainProjectIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

