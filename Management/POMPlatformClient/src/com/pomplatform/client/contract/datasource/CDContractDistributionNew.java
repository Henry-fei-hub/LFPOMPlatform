package com.pomplatform.client.contract.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDContractDistributionNew extends DataSource
{


	public static CDContractDistributionNew instance = null;

	public static CDContractDistributionNew getInstance() {
		if(instance == null) {
			instance = new CDContractDistributionNew("CDContractDistributionNew");
		}
		return instance;
	}

	private final DataSourceTextField contractCodeField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceTextField businessTypeField;

	public CDContractDistributionNew(String dataSourceID) {

		setID(dataSourceID);
		contractCodeField = new DataSourceTextField("contractCode", "主订单编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		startDateField = new DataSourceDateField("startDate", "提成的时间");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "提成的时间");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "主订单名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "归属部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		businessTypeField = new DataSourceTextField("businessType", "业态");
		businessTypeField.setRequired(false);
		businessTypeField.setLength(32);
		businessTypeField.setHidden(false);

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


		setFields(contractCodeField, startDateField, endDateField, contractNameField, plateIdField, businessTypeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

