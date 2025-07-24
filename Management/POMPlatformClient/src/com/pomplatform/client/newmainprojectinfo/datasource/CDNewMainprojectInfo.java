package com.pomplatform.client.newmainprojectinfo.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDNewMainprojectInfo extends DataSource
{


	public static CDNewMainprojectInfo instance = null;

	public static CDNewMainprojectInfo getInstance() {
		if(instance == null) {
			instance = new CDNewMainprojectInfo("CDNewMainprojectInfo");
		}
		return instance;
	}

	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField projectBaseOnField;
	private final DataSourceBooleanField hasContractField;

	public CDNewMainprojectInfo(String dataSourceID) {

		setID(dataSourceID);
		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		projectBaseOnField = new DataSourceIntegerField("projectBaseOn", "立项依据");
		projectBaseOnField.setRequired(false);
		projectBaseOnField.setLength(11);
		projectBaseOnField.setHidden(false);
		projectBaseOnField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		hasContractField = new DataSourceBooleanField("hasContract", "是否有合同");
		hasContractField.setRequired(false);
		hasContractField.setHidden(false);

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


		setFields(projectCodeField, projectNameField, projectBaseOnField, hasContractField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

