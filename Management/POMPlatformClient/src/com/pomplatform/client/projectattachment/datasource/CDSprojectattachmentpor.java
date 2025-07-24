package com.pomplatform.client.projectattachment.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSprojectattachmentpor extends DataSource
{


	public static CDSprojectattachmentpor instance = null;

	public static CDSprojectattachmentpor getInstance() {
		if(instance == null) {
			instance = new CDSprojectattachmentpor("CDSprojectattachmentpor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;

	public CDSprojectattachmentpor(String dataSourceID) {

		setID(dataSourceID);
		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);

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

