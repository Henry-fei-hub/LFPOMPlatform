package com.pomplatform.client.cdcmanage.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSmainprojectpppor extends DataSource
{


	public static CDSmainprojectpppor instance = null;

	public static CDSmainprojectpppor getInstance() {
		if(instance == null) {
			instance = new CDSmainprojectpppor("CDSmainprojectpppor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectBaseOnField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceBooleanField onlyCDCField;

	public CDSmainprojectpppor(String dataSourceID) {

		setID(dataSourceID);
		projectBaseOnField = new DataSourceIntegerField("projectBaseOn", "立项依据");
		projectBaseOnField.setRequired(false);
		projectBaseOnField.setLength(11);
		projectBaseOnField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setRequired(false);
		infoCodeField.setLength(32);
		infoCodeField.setHidden(false);
		
		onlyCDCField = new DataSourceBooleanField("onlyCDC", "只显示在CDC存在的项目");
		onlyCDCField.setRequired(false);
		onlyCDCField.setHidden(false);

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


		setFields(projectBaseOnField, projectCodeField, projectNameField, infoCodeField, onlyCDCField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

