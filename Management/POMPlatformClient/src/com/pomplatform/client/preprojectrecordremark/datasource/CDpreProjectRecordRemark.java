package com.pomplatform.client.preprojectrecordremark.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDpreProjectRecordRemark extends DataSource
{


	public static CDpreProjectRecordRemark instance = null;

	public static CDpreProjectRecordRemark getInstance() {
		if(instance == null) {
			instance = new CDpreProjectRecordRemark("CDpreProjectRecordRemark");
		}
		return instance;
	}

	private final DataSourceTextField projectSalesTeamField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField projectStatusField;
	private final DataSourceIntegerField projectBaseOnField;

	public CDpreProjectRecordRemark(String dataSourceID) {

		setID(dataSourceID);
		projectSalesTeamField = new DataSourceTextField("projectSalesTeam", "营销团队");
		projectSalesTeamField.setRequired(false);
		projectSalesTeamField.setLength(64);
		projectSalesTeamField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "项目流程状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

		projectStatusField = new DataSourceTextField("projectStatus", "项目状态");
		projectStatusField.setRequired(false);
		projectStatusField.setLength(64);
		projectStatusField.setHidden(false);

		projectBaseOnField = new DataSourceIntegerField("projectBaseOn", "立项依据");
		projectBaseOnField.setRequired(false);
		projectBaseOnField.setLength(11);
		projectBaseOnField.setHidden(false);

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


		setFields(projectSalesTeamField, statusField, projectStatusField, projectBaseOnField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

