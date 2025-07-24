package com.pomplatform.client.workflow.commonTravelReimbursement.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDTravelReimbursementWithDepartment extends DataSource
{


	public static CDTravelReimbursementWithDepartment instance = null;

	public static CDTravelReimbursementWithDepartment getInstance() {
		if(instance == null) {
			instance = new CDTravelReimbursementWithDepartment("CDTravelReimbursementWithDepartment");
		}
		return instance;
	}

	private final DataSourceIntegerField travelReimbursementIdField;

	public CDTravelReimbursementWithDepartment(String dataSourceID) {

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

