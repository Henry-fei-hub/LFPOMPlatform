package com.pomplatform.client.company.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDJobManagement extends DataSource
{


	public static CDJobManagement instance = null;

	public static CDJobManagement getInstance() {
		if(instance == null) {
			instance = new CDJobManagement("CDJobManagement");
		}
		return instance;
	}

	private final DataSourceTextField dutyNameField;

	public CDJobManagement(String dataSourceID) {

		setID(dataSourceID);
		dutyNameField = new DataSourceTextField("dutyName", "职位名称");
		dutyNameField.setRequired(false);
		dutyNameField.setLength(128);
		dutyNameField.setHidden(false);

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


		setFields(dutyNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

