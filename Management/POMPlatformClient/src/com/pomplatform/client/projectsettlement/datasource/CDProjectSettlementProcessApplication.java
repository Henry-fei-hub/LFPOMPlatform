package com.pomplatform.client.projectsettlement.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDProjectSettlementProcessApplication extends DataSource
{


	public static CDProjectSettlementProcessApplication instance = null;

	public static CDProjectSettlementProcessApplication getInstance() {
		if(instance == null) {
			instance = new CDProjectSettlementProcessApplication("CDProjectSettlementProcessApplication");
		}
		return instance;
	}

	private final DataSourceIntegerField settlementIdField;

	public CDProjectSettlementProcessApplication(String dataSourceID) {

		setID(dataSourceID);
		settlementIdField = new DataSourceIntegerField("settlementId", "结算代码");
		settlementIdField.setRequired(true);
		settlementIdField.setLength(11);
		settlementIdField.setPrimaryKey(true);
		settlementIdField.setHidden(true);

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


		setFields(settlementIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

