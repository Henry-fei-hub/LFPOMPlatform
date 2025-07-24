package com.pomplatform.client.mcapitalcmmssmssbor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDScapitalssmor extends DataSource
{


	public static CDScapitalssmor instance = null;

	public static CDScapitalssmor getInstance() {
		if(instance == null) {
			instance = new CDScapitalssmor("CDScapitalssmor");
		}
		return instance;
	}

	private final DataSourceIntegerField selfNameField;
	private final DataSourceTextField selfBankAccountField;
	private final DataSourceDateTimeField minHappenDateField;
	private final DataSourceDateTimeField maxHappenDateField;

	public CDScapitalssmor(String dataSourceID) {

		setID(dataSourceID);
		selfNameField = new DataSourceIntegerField("selfName", "内部公司");
		selfNameField.setRequired(true);
		selfNameField.setLength(11);
		selfNameField.setHidden(false);

		selfBankAccountField = new DataSourceTextField("selfBankAccount", "银行账号");
		selfBankAccountField.setRequired(true);
		selfBankAccountField.setLength(30);
		selfBankAccountField.setHidden(false);

		minHappenDateField = new DataSourceDateTimeField("minHappenDate", "最小发生日期");
		minHappenDateField.setRequired(true);
		minHappenDateField.setHidden(false);

		maxHappenDateField = new DataSourceDateTimeField("maxHappenDate", "最大发生日期");
		maxHappenDateField.setRequired(true);
		maxHappenDateField.setHidden(false);

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


		setFields(selfNameField, selfBankAccountField, minHappenDateField, maxHappenDateField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

