package com.pomplatform.client.contract.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class CDShowContractDistribution extends DataSource
{


	public static CDShowContractDistribution instance = null;

	public static CDShowContractDistribution getInstance() {
		if(instance == null) {
			instance = new CDShowContractDistribution("CDShowContractDistribution");
		}
		return instance;
	}

	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField orderIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField operationManagerIdField;

	public CDShowContractDistribution(String dataSourceID) {

		setID(dataSourceID);
		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(true);
		contractCodeField.setLength(128);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "undefined");
		contractNameField.setRequired(true);
		contractNameField.setLength(128);
		contractNameField.setHidden(false);

		orderIdField = new DataSourceTextField("orderId", "订单号");
		orderIdField.setRequired(false);
		orderIdField.setLength(128);
		orderIdField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		operationManagerIdField = new DataSourceIntegerField("operationManagerId", "部门经理");
		operationManagerIdField.setRequired(false);
		operationManagerIdField.setLength(11);
		operationManagerIdField.setHidden(false);

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


		setFields(contractCodeField, contractNameField, orderIdField, plateIdField, operationManagerIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

