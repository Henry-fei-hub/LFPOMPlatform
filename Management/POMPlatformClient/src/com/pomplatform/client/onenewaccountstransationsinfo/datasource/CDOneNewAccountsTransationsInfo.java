package com.pomplatform.client.onenewaccountstransationsinfo.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOneNewAccountsTransationsInfo extends DataSource
{


	public static CDOneNewAccountsTransationsInfo instance = null;

	public static CDOneNewAccountsTransationsInfo getInstance() {
		if(instance == null) {
			instance = new CDOneNewAccountsTransationsInfo("CDOneNewAccountsTransationsInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField accountIdField;

	public CDOneNewAccountsTransationsInfo(String dataSourceID) {

		setID(dataSourceID);
		accountIdField = new DataSourceIntegerField("accountId", "关联账户编码");
		accountIdField.setRequired(false);
		accountIdField.setLength(11);
		accountIdField.setHidden(false);

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


		setFields(accountIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

