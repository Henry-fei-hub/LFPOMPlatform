package com.pomplatform.client.workflow.projectNormalReimbursement.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDNormalReimbursementWithProject extends DataSource
{


	public static CDNormalReimbursementWithProject instance = null;

	public static CDNormalReimbursementWithProject getInstance() {
		if(instance == null) {
			instance = new CDNormalReimbursementWithProject("CDNormalReimbursementWithProject");
		}
		return instance;
	}

	private final DataSourceIntegerField projectNormalReimbursementIdField;

	public CDNormalReimbursementWithProject(String dataSourceID) {

		setID(dataSourceID);
		projectNormalReimbursementIdField = new DataSourceIntegerField("projectNormalReimbursementId", "主键编码");
		projectNormalReimbursementIdField.setRequired(true);
		projectNormalReimbursementIdField.setLength(11);
		projectNormalReimbursementIdField.setPrimaryKey(true);
		projectNormalReimbursementIdField.setHidden(true);

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


		setFields(projectNormalReimbursementIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

