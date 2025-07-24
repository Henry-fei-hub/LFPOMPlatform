package com.pomplatform.client.workflow.projectTravelReimbursement.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDNewProjectTravelReimbursement extends DataSource
{


	public static CDNewProjectTravelReimbursement instance = null;

	public static CDNewProjectTravelReimbursement getInstance() {
		if(instance == null) {
			instance = new CDNewProjectTravelReimbursement("CDNewProjectTravelReimbursement");
		}
		return instance;
	}

	private final DataSourceIntegerField travelReimbursementIdField;

	public CDNewProjectTravelReimbursement(String dataSourceID) {

		setID(dataSourceID);
		travelReimbursementIdField = new DataSourceIntegerField("travelReimbursementId", "差旅报销编码");
		travelReimbursementIdField.setRequired(true);
		travelReimbursementIdField.setLength(11);
		travelReimbursementIdField.setPrimaryKey(true);
		travelReimbursementIdField.setHidden(true);

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


		setFields(travelReimbursementIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

