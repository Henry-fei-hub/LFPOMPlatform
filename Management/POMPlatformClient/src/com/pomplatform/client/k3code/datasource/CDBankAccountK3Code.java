package com.pomplatform.client.k3code.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDBankAccountK3Code extends DataSource
{


	public static CDBankAccountK3Code instance = null;

	public static CDBankAccountK3Code getInstance() {
		if(instance == null) {
			instance = new CDBankAccountK3Code("CDBankAccountK3Code");
		}
		return instance;
	}

	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField k3CodeField;

	public CDBankAccountK3Code(String dataSourceID) {

		setID(dataSourceID);
		businessIdField = new DataSourceIntegerField("businessId", "银行账号");
		businessIdField.setRequired(false);
		businessIdField.setLength(11);
		businessIdField.setHidden(false);

		k3CodeField = new DataSourceTextField("k3Code", "K3代码");
		k3CodeField.setRequired(false);
		k3CodeField.setLength(64);
		k3CodeField.setHidden(false);

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


		setFields(businessIdField, k3CodeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

