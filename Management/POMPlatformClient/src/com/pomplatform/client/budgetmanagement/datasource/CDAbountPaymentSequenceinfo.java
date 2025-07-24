package com.pomplatform.client.budgetmanagement.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDAbountPaymentSequenceinfo extends DataSource
{


	public static CDAbountPaymentSequenceinfo instance = null;

	public static CDAbountPaymentSequenceinfo getInstance() {
		if(instance == null) {
			instance = new CDAbountPaymentSequenceinfo("CDAbountPaymentSequenceinfo");
		}
		return instance;
	}

	private final DataSourceIntegerField budgetManagementIdField;

	public CDAbountPaymentSequenceinfo(String dataSourceID) {

		setID(dataSourceID);
		budgetManagementIdField = new DataSourceIntegerField("budgetManagementId", "预算管理id");
		budgetManagementIdField.setRequired(false);
		budgetManagementIdField.setLength(11);
		budgetManagementIdField.setHidden(false);

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


		setFields(budgetManagementIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

