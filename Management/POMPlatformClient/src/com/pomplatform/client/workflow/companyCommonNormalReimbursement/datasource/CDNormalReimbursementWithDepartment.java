package com.pomplatform.client.workflow.companyCommonNormalReimbursement.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDNormalReimbursementWithDepartment extends DataSource
{


	public static CDNormalReimbursementWithDepartment instance = null;

	public static CDNormalReimbursementWithDepartment getInstance() {
		if(instance == null) {
			instance = new CDNormalReimbursementWithDepartment("CDNormalReimbursementWithDepartment");
		}
		return instance;
	}

	private final DataSourceIntegerField projectNormalReimbursementIdField;

	public CDNormalReimbursementWithDepartment(String dataSourceID) {

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

