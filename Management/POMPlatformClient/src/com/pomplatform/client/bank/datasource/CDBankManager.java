package com.pomplatform.client.bank.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDBankManager extends DataSource
{


	public static CDBankManager instance = null;

	public static CDBankManager getInstance() {
		if(instance == null) {
			instance = new CDBankManager("CDBankManager");
		}
		return instance;
	}

	private final DataSourceTextField bankNameField;

	public CDBankManager(String dataSourceID) {

		setID(dataSourceID);
		bankNameField = new DataSourceTextField("bankName", "银行名称");
		bankNameField.setRequired(false);
		bankNameField.setLength(255);
		bankNameField.setHidden(false);

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


		setFields(bankNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

