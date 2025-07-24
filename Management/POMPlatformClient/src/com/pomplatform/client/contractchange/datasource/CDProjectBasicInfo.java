package com.pomplatform.client.contractchange.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDProjectBasicInfo extends DataSource
{


	public static CDProjectBasicInfo instance = null;

	public static CDProjectBasicInfo getInstance() {
		if(instance == null) {
			instance = new CDProjectBasicInfo("CDProjectBasicInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;

	public CDProjectBasicInfo(String dataSourceID) {

		setID(dataSourceID);
		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdField);

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

