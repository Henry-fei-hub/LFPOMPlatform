package com.pomplatform.client.account.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDCollaborativeFeeDetailOfPlateAccount extends DataSource
{


	public static CDCollaborativeFeeDetailOfPlateAccount instance = null;

	public static CDCollaborativeFeeDetailOfPlateAccount getInstance() {
		if(instance == null) {
			instance = new CDCollaborativeFeeDetailOfPlateAccount("CDCollaborativeFeeDetailOfPlateAccount");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField businessTypeIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;

	public CDCollaborativeFeeDetailOfPlateAccount(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		businessTypeIdField = new DataSourceIntegerField("businessTypeId", "业务类别");
		businessTypeIdField.setRequired(false);
		businessTypeIdField.setLength(11);
		businessTypeIdField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(true);
		yearField.setLength(11);
		yearField.setHidden(false);
		yearField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setRequired(true);
		monthField.setLength(11);
		monthField.setHidden(false);
		monthField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

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


		setFields(plateIdField, businessTypeIdField, yearField, monthField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

