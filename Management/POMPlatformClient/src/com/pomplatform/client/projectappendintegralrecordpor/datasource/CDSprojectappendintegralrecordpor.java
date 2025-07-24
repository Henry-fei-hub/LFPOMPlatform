package com.pomplatform.client.projectappendintegralrecordpor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSprojectappendintegralrecordpor extends DataSource
{


	public static CDSprojectappendintegralrecordpor instance = null;

	public static CDSprojectappendintegralrecordpor getInstance() {
		if(instance == null) {
			instance = new CDSprojectappendintegralrecordpor("CDSprojectappendintegralrecordpor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;

	public CDSprojectappendintegralrecordpor(String dataSourceID) {

		setID(dataSourceID);
		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);
		KeyValueManager.loadValueMap("projects",projectIdField);

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


		setFields(projectIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

