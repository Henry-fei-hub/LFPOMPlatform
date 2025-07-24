package com.pomplatform.client.settle.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSprojectsettlementpor extends DataSource
{


	public static CDSprojectsettlementpor instance = null;

	public static CDSprojectsettlementpor getInstance() {
		if(instance == null) {
			instance = new CDSprojectsettlementpor("CDSprojectsettlementpor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;

	public CDSprojectsettlementpor(String dataSourceID) {

		setID(dataSourceID);
		projectIdField = new DataSourceIntegerField("projectId", "项目代码");
		projectIdField.setRequired(true);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);
//		KeyValueManager.loadValueMap("projects",projectIdField);
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

