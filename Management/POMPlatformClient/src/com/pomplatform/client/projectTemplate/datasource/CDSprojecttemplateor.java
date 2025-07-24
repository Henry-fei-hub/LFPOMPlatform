package com.pomplatform.client.projectTemplate.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSprojecttemplateor extends DataSource
{


	public static CDSprojecttemplateor instance = null;

	public static CDSprojecttemplateor getInstance() {
		if(instance == null) {
			instance = new CDSprojecttemplateor("CDSprojecttemplateor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectTypeField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField businessTypeField;

	public CDSprojecttemplateor(String dataSourceID) {

		setID(dataSourceID);
		projectTypeField = new DataSourceIntegerField("projectType", "项目类别");
		projectTypeField.setRequired(false);
		projectTypeField.setLength(11);
		projectTypeField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门id");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		businessTypeField = new DataSourceIntegerField("businessType", "业务类别");
		businessTypeField.setRequired(false);
		businessTypeField.setLength(11);
		businessTypeField.setHidden(false);

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


		setFields(projectTypeField, plateIdField, businessTypeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

