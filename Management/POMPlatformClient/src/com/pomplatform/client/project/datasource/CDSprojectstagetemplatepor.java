package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSprojectstagetemplatepor extends DataSource
{


	public static CDSprojectstagetemplatepor instance = null;

	public static CDSprojectstagetemplatepor getInstance() {
		if(instance == null) {
			instance = new CDSprojectstagetemplatepor("CDSprojectstagetemplatepor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectTemplateIdField;

	public CDSprojectstagetemplatepor(String dataSourceID) {

		setID(dataSourceID);
		projectTemplateIdField = new DataSourceIntegerField("projectTemplateId", "项目模板id （project_templates）");
		projectTemplateIdField.setRequired(false);
		projectTemplateIdField.setLength(11);
		projectTemplateIdField.setHidden(false);

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


		setFields(projectTemplateIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

