package com.pomplatform.client.contractchange.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDChangeContractInfo extends DataSource
{


	public static CDChangeContractInfo instance = null;

	public static CDChangeContractInfo getInstance() {
		if(instance == null) {
			instance = new CDChangeContractInfo("CDChangeContractInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField flagField;

	public CDChangeContractInfo(String dataSourceID) {

		setID(dataSourceID);
		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdField);

		flagField = new DataSourceIntegerField("flag", "状态");
		flagField.setRequired(false);
		flagField.setLength(11);
		flagField.setHidden(false);

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


		setFields(contractIdField, flagField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

