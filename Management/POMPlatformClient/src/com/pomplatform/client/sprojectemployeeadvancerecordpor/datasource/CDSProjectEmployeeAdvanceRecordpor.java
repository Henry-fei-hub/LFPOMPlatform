package com.pomplatform.client.sprojectemployeeadvancerecordpor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSProjectEmployeeAdvanceRecordpor extends DataSource
{


	public static CDSProjectEmployeeAdvanceRecordpor instance = null;

	public static CDSProjectEmployeeAdvanceRecordpor getInstance() {
		if(instance == null) {
			instance = new CDSProjectEmployeeAdvanceRecordpor("CDSProjectEmployeeAdvanceRecordpor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;

	public CDSProjectEmployeeAdvanceRecordpor(String dataSourceID) {

		setID(dataSourceID);
		projectIdField = new DataSourceIntegerField("projectId", "补贴项目");
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

