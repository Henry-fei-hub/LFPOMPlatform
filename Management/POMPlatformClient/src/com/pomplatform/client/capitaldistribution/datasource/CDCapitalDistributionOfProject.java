package com.pomplatform.client.capitaldistribution.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDCapitalDistributionOfProject extends DataSource
{


	public static CDCapitalDistributionOfProject instance = null;

	public static CDCapitalDistributionOfProject getInstance() {
		if(instance == null) {
			instance = new CDCapitalDistributionOfProject("CDCapitalDistributionOfProject");
		}
		return instance;
	}

	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField projectContractCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceDateTimeField startDateField;
	private final DataSourceDateTimeField endDateField;

	public CDCapitalDistributionOfProject(String dataSourceID) {

		setID(dataSourceID);
		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		projectContractCodeField = new DataSourceTextField("projectContractCode", "订单编号");
		projectContractCodeField.setRequired(false);
		projectContractCodeField.setLength(64);
		projectContractCodeField.setHidden(false);
//		projectContractCodeField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractCodeField);

		projectNameField = new DataSourceTextField("projectName", "订单名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		startDateField = new DataSourceDateTimeField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateTimeField("endDate", "截止日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

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


		setFields(contractCodeField, contractNameField, projectContractCodeField, projectNameField, startDateField, endDateField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

