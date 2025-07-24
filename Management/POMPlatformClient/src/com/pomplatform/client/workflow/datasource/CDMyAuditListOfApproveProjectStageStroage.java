package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMyAuditListOfApproveProjectStageStroage extends DataSource
{


	public static CDMyAuditListOfApproveProjectStageStroage instance = null;

	public static CDMyAuditListOfApproveProjectStageStroage getInstance() {
		if(instance == null) {
			instance = new CDMyAuditListOfApproveProjectStageStroage("CDMyAuditListOfApproveProjectStageStroage");
		}
		return instance;
	}

	private final DataSourceIntegerField processTypeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField plateIdField;

	public CDMyAuditListOfApproveProjectStageStroage(String dataSourceID) {

		setID(dataSourceID);
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(255);
		projectNameField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "板块");
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


		setFields(processTypeField, projectNameField, plateIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

