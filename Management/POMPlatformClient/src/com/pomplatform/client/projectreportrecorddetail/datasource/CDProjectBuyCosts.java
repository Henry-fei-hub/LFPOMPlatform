package com.pomplatform.client.projectreportrecorddetail.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDProjectBuyCosts extends DataSource
{


	public static CDProjectBuyCosts instance = null;

	public static CDProjectBuyCosts getInstance() {
		if(instance == null) {
			instance = new CDProjectBuyCosts("CDProjectBuyCosts");
		}
		return instance;
	}

	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField projectIdField;

	public CDProjectBuyCosts(String dataSourceID) {

		setID(dataSourceID);
		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "项目状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setRequired(true);
		projectIdField.setLength(11);
		projectIdField.setPrimaryKey(true);
		projectIdField.setHidden(true);

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


		setFields(contractCodeField, projectNameField, statusField, projectIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

