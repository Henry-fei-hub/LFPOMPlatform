package com.pomplatform.client.k3code.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSk3codetpor extends DataSource
{


	public static CDSk3codetpor instance = null;

	public static CDSk3codetpor getInstance() {
		if(instance == null) {
			instance = new CDSk3codetpor("CDSk3codetpor");
		}
		return instance;
	}

	private final DataSourceIntegerField typeField;
	private final DataSourceIntegerField parentIdField;

	public CDSk3codetpor(String dataSourceID) {

		setID(dataSourceID);
		typeField = new DataSourceIntegerField("type", " 7收款方类型");
		typeField.setRequired(false);
		typeField.setLength(11);
		typeField.setHidden(false);

		parentIdField = new DataSourceIntegerField("parentId", "父级id");
		parentIdField.setRequired(false);
		parentIdField.setLength(11);
		parentIdField.setHidden(false);
//		parentIdField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",parentIdField);


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


		setFields(typeField, parentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

