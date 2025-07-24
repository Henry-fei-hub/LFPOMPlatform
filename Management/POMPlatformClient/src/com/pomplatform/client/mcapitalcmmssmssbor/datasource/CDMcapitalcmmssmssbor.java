package com.pomplatform.client.mcapitalcmmssmssbor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMcapitalcmmssmssbor extends DataSource
{


	public static CDMcapitalcmmssmssbor instance = null;

	public static CDMcapitalcmmssmssbor getInstance() {
		if(instance == null) {
			instance = new CDMcapitalcmmssmssbor("CDMcapitalcmmssmssbor");
		}
		return instance;
	}

	private final DataSourceDateTimeField minHappenDateField;
	private final DataSourceDateTimeField maxHappenDateField;
	private final DataSourceIntegerField selfNameField;
	private final DataSourceTextField selfBankAccountField;
	private final DataSourceTextField bankAddressField;

	public CDMcapitalcmmssmssbor(String dataSourceID) {

		setID(dataSourceID);
		minHappenDateField = new DataSourceDateTimeField("minHappenDate", "最早发生日期");
		minHappenDateField.setRequired(false);
		minHappenDateField.setHidden(false);

		maxHappenDateField = new DataSourceDateTimeField("maxHappenDate", "最晚发生日期");
		maxHappenDateField.setRequired(false);
		maxHappenDateField.setHidden(false);

		selfNameField = new DataSourceIntegerField("selfName", "内部公司(收款方)");
		selfNameField.setRequired(false);
		selfNameField.setLength(11);
		selfNameField.setHidden(false);

		selfBankAccountField = new DataSourceTextField("selfBankAccount", "银行账号(收款方)");
		selfBankAccountField.setRequired(false);
		selfBankAccountField.setLength(128);
		selfBankAccountField.setHidden(false);

		bankAddressField = new DataSourceTextField("bankAddress", "开户行所在地");
		bankAddressField.setRequired(false);
		bankAddressField.setLength(128);
		bankAddressField.setHidden(false);

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


		setFields(minHappenDateField, maxHappenDateField, selfNameField, selfBankAccountField, bankAddressField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

