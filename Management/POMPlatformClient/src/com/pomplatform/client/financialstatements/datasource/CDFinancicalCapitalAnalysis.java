package com.pomplatform.client.financialstatements.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDFinancicalCapitalAnalysis extends DataSource
{


	public static CDFinancicalCapitalAnalysis instance = null;

	public static CDFinancicalCapitalAnalysis getInstance() {
		if(instance == null) {
			instance = new CDFinancicalCapitalAnalysis("CDFinancicalCapitalAnalysis");
		}
		return instance;
	}

	private final DataSourceIntegerField companyIdField;

	public CDFinancicalCapitalAnalysis(String dataSourceID) {

		setID(dataSourceID);
		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

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


		setFields(companyIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

