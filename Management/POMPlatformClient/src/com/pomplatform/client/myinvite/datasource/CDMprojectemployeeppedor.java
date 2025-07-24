package com.pomplatform.client.myinvite.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMprojectemployeeppedor extends DataSource
{


	public static CDMprojectemployeeppedor instance = null;

	public static CDMprojectemployeeppedor getInstance() {
		if(instance == null) {
			instance = new CDMprojectemployeeppedor("CDMprojectemployeeppedor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField designPhaseField;

	public CDMprojectemployeeppedor(String dataSourceID) {

		setID(dataSourceID);
		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		designPhaseField = new DataSourceIntegerField("designPhase", "设计阶段");
		designPhaseField.setRequired(false);
		designPhaseField.setLength(11);
		designPhaseField.setHidden(false);
		designPhaseField.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));

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


		setFields(projectIdField, employeeIdField, designPhaseField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

