package com.pomplatform.client.contract.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDContractDistributionChild extends DataSource
{


	public static CDContractDistributionChild instance = null;

	public static CDContractDistributionChild getInstance() {
		if(instance == null) {
			instance = new CDContractDistributionChild("CDContractDistributionChild");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceTextField businessTypeField;
	private final DataSourceIntegerField plateIdField;

	public CDContractDistributionChild(String dataSourceID) {

		setID(dataSourceID);
		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);

		startDateField = new DataSourceDateField("startDate", "提成的时间");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "提成的时间");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		businessTypeField = new DataSourceTextField("businessType", "业态");
		businessTypeField.setRequired(false);
		businessTypeField.setLength(32);
		businessTypeField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "归属部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

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


		setFields(contractIdField, startDateField, endDateField, businessTypeField, plateIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

