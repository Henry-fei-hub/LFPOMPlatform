package com.pomplatform.client.tablemaintain.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDTableMaintain extends DataSource
{


	public static CDTableMaintain instance = null;

	public static CDTableMaintain getInstance() {
		if(instance == null) {
			instance = new CDTableMaintain("CDTableMaintain");
		}
		return instance;
	}

	private final DataSourceTextField tableNameField;
	private final DataSourceTextField remarkField;

	public CDTableMaintain(String dataSourceID) {

		setID(dataSourceID);
		tableNameField = new DataSourceTextField("tableName", "tablename");
		tableNameField.setRequired(true);
		tableNameField.setLength(0);
		tableNameField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(255);
		remarkField.setHidden(false);

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


		setFields(tableNameField, remarkField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

