package com.pomplatform.client.ja.ht.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDContractPrice extends DataSource
{


	public static CDContractPrice instance = null;

	public static CDContractPrice getInstance() {
		if(instance == null) {
			instance = new CDContractPrice("CDContractPrice");
		}
		return instance;
	}

	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField mainProjectStageIdField;
	private final DataSourceIntegerField clientIdField;
	private final DataSourceTextField customerNameField;
	private final DataSourceIntegerField customerIdField;

	public CDContractPrice(String dataSourceID) {

		setID(dataSourceID);
		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		mainProjectStageIdField = new DataSourceIntegerField("mainProjectStageId", "项目立项阶段id");
		mainProjectStageIdField.setRequired(false);
		mainProjectStageIdField.setLength(11);
		mainProjectStageIdField.setHidden(false);

		clientIdField = new DataSourceIntegerField("clientId", "客户id");
		clientIdField.setRequired(false);
		clientIdField.setLength(11);
		clientIdField.setHidden(false);

		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setRequired(false);
		customerNameField.setLength(50);
		customerNameField.setHidden(false);

		customerIdField = new DataSourceIntegerField("customerId", "主键编码");
		customerIdField.setRequired(true);
		customerIdField.setLength(11);
		customerIdField.setPrimaryKey(true);
		customerIdField.setHidden(true);

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


		setFields(projectCodeField, projectNameField, mainProjectStageIdField, clientIdField, customerNameField, customerIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

