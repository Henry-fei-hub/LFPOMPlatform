package com.pomplatform.client.aboutcontractsrecord.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDAboutContractsRecord extends DataSource
{


	public static CDAboutContractsRecord instance = null;

	public static CDAboutContractsRecord getInstance() {
		if(instance == null) {
			instance = new CDAboutContractsRecord("CDAboutContractsRecord");
		}
		return instance;
	}

	private final DataSourceTextField infoCodeField;
	private final DataSourceIntegerField contractIdField;

	public CDAboutContractsRecord(String dataSourceID) {

		setID(dataSourceID);
		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setRequired(false);
		infoCodeField.setLength(32);
		infoCodeField.setHidden(false);

		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);

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


		setFields(infoCodeField, contractIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

