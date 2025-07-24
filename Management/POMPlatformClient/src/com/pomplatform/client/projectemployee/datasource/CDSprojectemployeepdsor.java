package com.pomplatform.client.projectemployee.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSprojectemployeepdsor extends DataSource
{


	public static CDSprojectemployeepdsor instance = null;

	public static CDSprojectemployeepdsor getInstance() {
		if(instance == null) {
			instance = new CDSprojectemployeepdsor("CDSprojectemployeepdsor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField designPhaseField;
	private final DataSourceIntegerField statusField;

	public CDSprojectemployeepdsor(String dataSourceID) {

		setID(dataSourceID);
		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);

		designPhaseField = new DataSourceIntegerField("designPhase", "设计阶段");
		designPhaseField.setRequired(false);
		designPhaseField.setLength(11);
		designPhaseField.setHidden(false);
		designPhaseField.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));

		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_4"));

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


		setFields(projectIdField, designPhaseField, statusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

