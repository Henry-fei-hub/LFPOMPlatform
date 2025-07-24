package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDCooperateStatisticsTotal extends DataSource
{


	public static CDCooperateStatisticsTotal instance = null;

	public static CDCooperateStatisticsTotal getInstance() {
		if(instance == null) {
			instance = new CDCooperateStatisticsTotal("CDCooperateStatisticsTotal");
		}
		return instance;
	}

	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField typeField;

	public CDCooperateStatisticsTotal(String dataSourceID) {

		setID(dataSourceID);
		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(255);
		projectCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(255);
		projectNameField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		typeField = new DataSourceIntegerField("type", "配合部门");
		typeField.setRequired(false);
		typeField.setLength(11);
		typeField.setHidden(false);
		typeField.setValueMap(KeyValueManager.getValueMap("departments"));


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


		setFields(projectCodeField, projectNameField, departmentIdField, typeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

