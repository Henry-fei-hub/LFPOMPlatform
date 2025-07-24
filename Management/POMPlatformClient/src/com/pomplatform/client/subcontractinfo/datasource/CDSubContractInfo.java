package com.pomplatform.client.subcontractinfo.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSubContractInfo extends DataSource
{


	public static CDSubContractInfo instance = null;

	public static CDSubContractInfo getInstance() {
		if(instance == null) {
			instance = new CDSubContractInfo("CDSubContractInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField parentIdField;

	public CDSubContractInfo(String dataSourceID) {

		setID(dataSourceID);
		parentIdField = new DataSourceIntegerField("parentId", "主合同");
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


		setFields(parentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

