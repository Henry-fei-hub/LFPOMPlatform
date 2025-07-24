package com.pomplatform.client.account.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadProjectSettlementDetailOfPlateAccount extends DataSource
{


	public static CDOnLoadProjectSettlementDetailOfPlateAccount instance = null;

	public static CDOnLoadProjectSettlementDetailOfPlateAccount getInstance() {
		if(instance == null) {
			instance = new CDOnLoadProjectSettlementDetailOfPlateAccount("CDOnLoadProjectSettlementDetailOfPlateAccount");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField businessTypeIdField;
	private final DataSourceTextField sheetCodeField;
	private final DataSourceTextField sheetNameField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;

	public CDOnLoadProjectSettlementDetailOfPlateAccount(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		businessTypeIdField = new DataSourceIntegerField("businessTypeId", "11绩效奖金)");
		businessTypeIdField.setRequired(false);
		businessTypeIdField.setLength(11);
		businessTypeIdField.setHidden(false);

		sheetCodeField = new DataSourceTextField("sheetCode", "订单编号");
		sheetCodeField.setRequired(false);
		sheetCodeField.setLength(64);
		sheetCodeField.setHidden(false);
//		sheetCodeField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts", sheetCodeField);

		sheetNameField = new DataSourceTextField("sheetName", "订单名称");
		sheetNameField.setRequired(false);
		sheetNameField.setLength(512);
		sheetNameField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(true);
		yearField.setLength(11);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setRequired(true);
		monthField.setLength(11);
		monthField.setHidden(false);

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


		setFields(plateIdField, businessTypeIdField, sheetCodeField, sheetNameField, yearField, monthField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

