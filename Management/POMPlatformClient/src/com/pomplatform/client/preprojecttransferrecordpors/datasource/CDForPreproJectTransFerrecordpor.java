package com.pomplatform.client.preprojecttransferrecordpors.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDForPreproJectTransFerrecordpor extends DataSource
{


	public static CDForPreproJectTransFerrecordpor instance = null;

	public static CDForPreproJectTransFerrecordpor getInstance() {
		if(instance == null) {
			instance = new CDForPreproJectTransFerrecordpor("CDForPreproJectTransFerrecordpor");
		}
		return instance;
	}

	private final DataSourceIntegerField preProjectIdField;
	private final DataSourceIntegerField employeeIdField;

	public CDForPreproJectTransFerrecordpor(String dataSourceID) {

		setID(dataSourceID);
		preProjectIdField = new DataSourceIntegerField("preProjectId", "项目id");
		preProjectIdField.setRequired(false);
		preProjectIdField.setLength(11);
		preProjectIdField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "原报备人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

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


		setFields(preProjectIdField, employeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

