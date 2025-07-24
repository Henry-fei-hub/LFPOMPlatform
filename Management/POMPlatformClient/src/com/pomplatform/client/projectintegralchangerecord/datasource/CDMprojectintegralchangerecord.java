package com.pomplatform.client.projectintegralchangerecord.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMprojectintegralchangerecord extends DataSource
{


	public static CDMprojectintegralchangerecord instance = null;

	public static CDMprojectintegralchangerecord getInstance() {
		if(instance == null) {
			instance = new CDMprojectintegralchangerecord("CDMprojectintegralchangerecord");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField plateEmployeeIdField;

	public CDMprojectintegralchangerecord(String dataSourceID) {

		setID(dataSourceID);
		projectIdField = new DataSourceIntegerField("projectId", "项目");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);
		KeyValueManager.loadValueMap("projects",projectIdField);

		plateIdField = new DataSourceIntegerField("plateId", "板块");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		plateEmployeeIdField = new DataSourceIntegerField("plateEmployeeId", "板块负责人");
		plateEmployeeIdField.setRequired(false);
		plateEmployeeIdField.setLength(11);
		plateEmployeeIdField.setHidden(false);

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


		setFields(projectIdField, plateIdField, plateEmployeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

