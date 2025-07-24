package com.pomplatform.client.projectperformance.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDFindProjectInfoByContractId extends DataSource
{


	public static CDFindProjectInfoByContractId instance = null;

	public static CDFindProjectInfoByContractId getInstance() {
		if(instance == null) {
			instance = new CDFindProjectInfoByContractId("CDFindProjectInfoByContractId");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;

	public CDFindProjectInfoByContractId(String dataSourceID) {

		setID(dataSourceID);
		contractIdField = new DataSourceIntegerField("contractId", "合同");
		contractIdField.setRequired(true);
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

