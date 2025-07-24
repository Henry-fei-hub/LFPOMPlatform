package com.pomplatform.client.revenuecapitalsinfo.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDRevenueCapitalsInfo extends DataSource
{


	public static CDRevenueCapitalsInfo instance = null;

	public static CDRevenueCapitalsInfo getInstance() {
		if(instance == null) {
			instance = new CDRevenueCapitalsInfo("CDRevenueCapitalsInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField yearsField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField customerNameField;

	public CDRevenueCapitalsInfo(String dataSourceID) {

		setID(dataSourceID);
		yearsField = new DataSourceIntegerField("years", "undefined");
		yearsField.setRequired(true);
		yearsField.setLength(11);
		yearsField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);

		contractIdField = new DataSourceIntegerField("contractId", "contract_id");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "主订单编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "主订单名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setRequired(false);
		customerNameField.setLength(512);
		customerNameField.setHidden(false);

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


		setFields(yearsField, yearField, contractIdField, contractCodeField, contractNameField, customerNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

