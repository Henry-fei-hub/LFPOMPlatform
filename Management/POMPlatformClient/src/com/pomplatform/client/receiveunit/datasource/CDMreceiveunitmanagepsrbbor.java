package com.pomplatform.client.receiveunit.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMreceiveunitmanagepsrbbor extends DataSource
{


	public static CDMreceiveunitmanagepsrbbor instance = null;

	public static CDMreceiveunitmanagepsrbbor getInstance() {
		if(instance == null) {
			instance = new CDMreceiveunitmanagepsrbbor("CDMreceiveunitmanagepsrbbor");
		}
		return instance;
	}

	private final DataSourceTextField receiveUnitField;
	private final DataSourceTextField bankAccountField;
	private final DataSourceTextField bankNameField;

	public CDMreceiveunitmanagepsrbbor(String dataSourceID) {

		setID(dataSourceID);
		receiveUnitField = new DataSourceTextField("receiveUnit", "收款单位");
		receiveUnitField.setRequired(false);
		receiveUnitField.setLength(128);
		receiveUnitField.setHidden(false);

		bankAccountField = new DataSourceTextField("bankAccount", "银行账号");
		bankAccountField.setRequired(false);
		bankAccountField.setLength(64);
		bankAccountField.setHidden(false);

		bankNameField = new DataSourceTextField("bankName", "开户行");
		bankNameField.setRequired(false);
		bankNameField.setLength(128);
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


		setFields(receiveUnitField, bankAccountField, bankNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

