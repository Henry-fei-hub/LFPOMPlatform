package com.pomplatform.client.projectstages.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSprojectstagecor extends DataSource
{


	public static CDSprojectstagecor instance = null;

	public static CDSprojectstagecor getInstance() {
		if(instance == null) {
			instance = new CDSprojectstagecor("CDSprojectstagecor");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;

	public CDSprojectstagecor(String dataSourceID) {

		setID(dataSourceID);
		contractIdField = new DataSourceIntegerField("contractId", "合同id");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);

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


		setFields(contractIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

