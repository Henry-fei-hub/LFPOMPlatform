package com.pomplatform.client.getprojectbycontract.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDGetProjectByContract extends DataSource
{


	public static CDGetProjectByContract instance = null;

	public static CDGetProjectByContract getInstance() {
		if(instance == null) {
			instance = new CDGetProjectByContract("CDGetProjectByContract");
		}
		return instance;
	}

	private final DataSourceTextField contractCodeField;

	public CDGetProjectByContract(String dataSourceID) {

		setID(dataSourceID);
		contractCodeField = new DataSourceTextField("contractCode", "合同名称");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);
//		contractCodeField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractCodeField);

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


		setFields(contractCodeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

