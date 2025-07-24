package com.pomplatform.client.subcontractinfo.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadSubContractRemark extends DataSource
{


	public static CDOnLoadSubContractRemark instance = null;

	public static CDOnLoadSubContractRemark getInstance() {
		if(instance == null) {
			instance = new CDOnLoadSubContractRemark("CDOnLoadSubContractRemark");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;

	public CDOnLoadSubContractRemark(String dataSourceID) {

		setID(dataSourceID);
		contractIdField = new DataSourceIntegerField("contractId", "主订单编码");
		contractIdField.setRequired(true);
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setHidden(true);

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

