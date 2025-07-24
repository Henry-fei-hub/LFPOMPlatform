package com.pomplatform.client.selectgrid.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSelectGridProjectValue extends DataSource
{


	public static CDSelectGridProjectValue instance = null;

	public static CDSelectGridProjectValue getInstance() {
		if(instance == null) {
			instance = new CDSelectGridProjectValue("CDSelectGridProjectValue");
		}
		return instance;
	}

	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField projectSetupFlagField;

	public CDSelectGridProjectValue(String dataSourceID) {

		setID(dataSourceID);
		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setRequired(true);
		projectIdField.setLength(11);
		projectIdField.setPrimaryKey(true);
		projectIdField.setHidden(true);

		projectTypeField = new DataSourceIntegerField("projectType", "项目类别");
		projectTypeField.setRequired(false);
		projectTypeField.setLength(11);
		projectTypeField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "板块");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "项目状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);

		projectSetupFlagField = new DataSourceIntegerField("projectSetupFlag", ")");
		projectSetupFlagField.setRequired(false);
		projectSetupFlagField.setLength(11);
		projectSetupFlagField.setHidden(false);

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


		setFields(contractCodeField, projectCodeField, projectNameField, projectIdField, projectTypeField, plateIdField, statusField, contractIdField, projectSetupFlagField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

