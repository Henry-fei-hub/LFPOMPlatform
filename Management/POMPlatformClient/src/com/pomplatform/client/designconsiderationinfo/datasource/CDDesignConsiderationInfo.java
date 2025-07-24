package com.pomplatform.client.designconsiderationinfo.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDDesignConsiderationInfo extends DataSource
{


	public static CDDesignConsiderationInfo instance = null;

	public static CDDesignConsiderationInfo getInstance() {
		if(instance == null) {
			instance = new CDDesignConsiderationInfo("CDDesignConsiderationInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField subContractIdField;

	public CDDesignConsiderationInfo(String dataSourceID) {

		setID(dataSourceID);
		subContractIdField = new DataSourceIntegerField("subContractId", "子合同编码");
		subContractIdField.setRequired(false);
		subContractIdField.setLength(11);
		subContractIdField.setHidden(false);

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


		setFields(subContractIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

