package com.pomplatform.client.projectintegraltransferrecord.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMprojectintegraltransferrecord extends DataSource
{


	public static CDMprojectintegraltransferrecord instance = null;

	public static CDMprojectintegraltransferrecord getInstance() {
		if(instance == null) {
			instance = new CDMprojectintegraltransferrecord("CDMprojectintegraltransferrecord");
		}
		return instance;
	}

	private final DataSourceIntegerField fromProjectIdField;
	private final DataSourceIntegerField toProjectIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField plateEmployeeIdField;

	public CDMprojectintegraltransferrecord(String dataSourceID) {

		setID(dataSourceID);
		fromProjectIdField = new DataSourceIntegerField("fromProjectId", "目标项目");
		fromProjectIdField.setRequired(false);
		fromProjectIdField.setLength(11);
		fromProjectIdField.setHidden(false);
		fromProjectIdField.setValueMap(KeyValueManager.getValueMap("projects"));
		KeyValueManager.loadValueMap("projects", fromProjectIdField);

		toProjectIdField = new DataSourceIntegerField("toProjectId", "归属项目");
		toProjectIdField.setRequired(false);
		toProjectIdField.setLength(11);
		toProjectIdField.setHidden(false);
//		toProjectIdField.setValueMap(KeyValueManager.getValueMap("projects"));
		KeyValueManager.loadValueMap("projects", toProjectIdField);

		plateIdField = new DataSourceIntegerField("plateId", "板块");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		plateEmployeeIdField = new DataSourceIntegerField("plateEmployeeId", "板块负责人");
		plateEmployeeIdField.setRequired(false);
		plateEmployeeIdField.setLength(11);
		plateEmployeeIdField.setHidden(false);
		plateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

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


		setFields(fromProjectIdField, toProjectIdField, plateIdField, plateEmployeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

