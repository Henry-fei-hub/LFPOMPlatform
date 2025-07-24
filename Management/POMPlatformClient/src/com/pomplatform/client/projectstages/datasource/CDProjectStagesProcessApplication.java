package com.pomplatform.client.projectstages.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDProjectStagesProcessApplication extends DataSource
{


	public static CDProjectStagesProcessApplication instance = null;

	public static CDProjectStagesProcessApplication getInstance() {
		if(instance == null) {
			instance = new CDProjectStagesProcessApplication("CDProjectStagesProcessApplication");
		}
		return instance;
	}

	private final DataSourceIntegerField projectStageProcessRecordIdField;
	private final DataSourceIntegerField contractIdField;

	public CDProjectStagesProcessApplication(String dataSourceID) {

		setID(dataSourceID);
		projectStageProcessRecordIdField = new DataSourceIntegerField("projectStageProcessRecordId", "id");
		projectStageProcessRecordIdField.setRequired(true);
		projectStageProcessRecordIdField.setLength(11);
		projectStageProcessRecordIdField.setPrimaryKey(true);
		projectStageProcessRecordIdField.setHidden(true);

		contractIdField = new DataSourceIntegerField("contractId", "contract_id");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);

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


		setFields(projectStageProcessRecordIdField, contractIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

