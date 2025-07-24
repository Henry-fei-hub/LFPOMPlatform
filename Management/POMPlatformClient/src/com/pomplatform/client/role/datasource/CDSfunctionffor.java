package com.pomplatform.client.role.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSfunctionffor extends DataSource
{


	public static CDSfunctionffor instance = null;

	public static CDSfunctionffor getInstance() {
		if(instance == null) {
			instance = new CDSfunctionffor("CDSfunctionffor");
		}
		return instance;
	}

	private final DataSourceTextField functionNameField;
	private final DataSourceTextField functionCodeField;

	public CDSfunctionffor(String dataSourceID) {

		setID(dataSourceID);
		functionNameField = new DataSourceTextField("functionName", "功能名称");
		functionNameField.setRequired(false);
		functionNameField.setLength(64);
		functionNameField.setHidden(false);

		functionCodeField = new DataSourceTextField("functionCode", "功能编号");
		functionCodeField.setRequired(false);
		functionCodeField.setLength(64);
		functionCodeField.setHidden(false);

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


		setFields(functionNameField, functionCodeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

