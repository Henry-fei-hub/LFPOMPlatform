package com.pomplatform.client.projectsettlement.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDProfessionalApprovalApplication extends DataSource
{


	public static CDProfessionalApprovalApplication instance = null;

	public static CDProfessionalApprovalApplication getInstance() {
		if(instance == null) {
			instance = new CDProfessionalApprovalApplication("CDProfessionalApprovalApplication");
		}
		return instance;
	}

	private final DataSourceIntegerField professionalApproval_idField;

	public CDProfessionalApprovalApplication(String dataSourceID) {

		setID(dataSourceID);
		professionalApproval_idField = new DataSourceIntegerField("professionalApproval_id", "专业负责人审批编码");
		professionalApproval_idField.setRequired(true);
		professionalApproval_idField.setLength(11);
		professionalApproval_idField.setPrimaryKey(true);
		professionalApproval_idField.setHidden(false);

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


		setFields(professionalApproval_idField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

