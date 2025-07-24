package com.pomplatform.client.costallocation.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDCostAllocationApply extends DataSource
{


	public static CDCostAllocationApply instance = null;

	public static CDCostAllocationApply getInstance() {
		if(instance == null) {
			instance = new CDCostAllocationApply("CDCostAllocationApply");
		}
		return instance;
	}

	private final DataSourceIntegerField resetCostIdField;

	public CDCostAllocationApply(String dataSourceID) {

		setID(dataSourceID);
		resetCostIdField = new DataSourceIntegerField("resetCostId", "成本重新归集表编码");
		resetCostIdField.setRequired(true);
		resetCostIdField.setLength(11);
		resetCostIdField.setPrimaryKey(true);
		resetCostIdField.setHidden(true);

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


		setFields(resetCostIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

