package com.pomplatform.client.manageprojectbyproject.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDManageProjectByProject extends DataSource
{


	public static CDManageProjectByProject instance = null;

	public static CDManageProjectByProject getInstance() {
		if(instance == null) {
			instance = new CDManageProjectByProject("CDManageProjectByProject");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField recordYearField;
	private final DataSourceIntegerField recordMonthField;
	private final DataSourceTextField manageProjectNameField;

	public CDManageProjectByProject(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		recordYearField = new DataSourceIntegerField("recordYear", "年份");
		recordYearField.setRequired(true);
		recordYearField.setLength(11);
		recordYearField.setHidden(false);

		recordMonthField = new DataSourceIntegerField("recordMonth", "月份");
		recordMonthField.setRequired(true);
		recordMonthField.setLength(11);
		recordMonthField.setHidden(false);

		manageProjectNameField = new DataSourceTextField("manageProjectName", "项目名称");
		manageProjectNameField.setRequired(false);
		manageProjectNameField.setLength(512);
		manageProjectNameField.setHidden(false);

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


		setFields(plateIdField, recordYearField, recordMonthField, manageProjectNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

