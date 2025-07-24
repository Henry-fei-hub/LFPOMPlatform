package com.pomplatform.client.getbudgetuplodanews.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDGetBudgetUplodaNews extends DataSource
{


	public static CDGetBudgetUplodaNews instance = null;

	public static CDGetBudgetUplodaNews getInstance() {
		if(instance == null) {
			instance = new CDGetBudgetUplodaNews("CDGetBudgetUplodaNews");
		}
		return instance;
	}

	private final DataSourceIntegerField budgetManagementIdField;
	private final DataSourceIntegerField fileIdField;

	public CDGetBudgetUplodaNews(String dataSourceID) {

		setID(dataSourceID);
		budgetManagementIdField = new DataSourceIntegerField("budgetManagementId", "主键id");
		budgetManagementIdField.setRequired(true);
		budgetManagementIdField.setLength(11);
		budgetManagementIdField.setPrimaryKey(true);
		budgetManagementIdField.setHidden(true);

		fileIdField = new DataSourceIntegerField("fileId", "附件编码");
		fileIdField.setRequired(false);
		fileIdField.setLength(11);
		fileIdField.setHidden(false);

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


		setFields(budgetManagementIdField, fileIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

