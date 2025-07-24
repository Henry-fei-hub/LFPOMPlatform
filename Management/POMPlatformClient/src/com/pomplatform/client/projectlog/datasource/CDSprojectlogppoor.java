package com.pomplatform.client.projectlog.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSprojectlogppoor extends DataSource
{


	public static CDSprojectlogppoor instance = null;

	public static CDSprojectlogppoor getInstance() {
		if(instance == null) {
			instance = new CDSprojectlogppoor("CDSprojectlogppoor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectLogIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField operateIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField managerIdField;
	private final DataSourceIntegerField designPhaseField;
	private final DataSourceIntegerField logTypeField;

	public CDSprojectlogppoor(String dataSourceID) {

		setID(dataSourceID);
		projectLogIdField = new DataSourceIntegerField("projectLogId", "项目日志编码");
		projectLogIdField.setRequired(true);
		projectLogIdField.setLength(11);
		projectLogIdField.setPrimaryKey(true);
		projectLogIdField.setHidden(true);

		projectIdField = new DataSourceIntegerField("projectId", "项目");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);

		operateIdField = new DataSourceIntegerField("operateId", "操作人");
		operateIdField.setRequired(false);
		operateIdField.setLength(11);
		operateIdField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

		managerIdField = new DataSourceIntegerField("managerId", "板块负责人");
		managerIdField.setRequired(false);
		managerIdField.setLength(11);
		managerIdField.setHidden(false);

		designPhaseField = new DataSourceIntegerField("designPhase", "设计阶段");
		designPhaseField.setRequired(false);
		designPhaseField.setLength(11);
		designPhaseField.setHidden(false);
		designPhaseField.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));

		logTypeField = new DataSourceIntegerField("logType", "日志类型");
		logTypeField.setRequired(false);
		logTypeField.setLength(11);
		logTypeField.setHidden(false);

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


		setFields(projectLogIdField, projectIdField, operateIdField, departmentIdField, managerIdField, designPhaseField, logTypeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

