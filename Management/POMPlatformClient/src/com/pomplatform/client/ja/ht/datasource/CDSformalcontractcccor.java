package com.pomplatform.client.ja.ht.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSformalcontractcccor extends DataSource
{


	public static CDSformalcontractcccor instance = null;

	public static CDSformalcontractcccor getInstance() {
		if(instance == null) {
			instance = new CDSformalcontractcccor("CDSformalcontractcccor");
		}
		return instance;
	}

	private final DataSourceTextField contractNameField;
	private final DataSourceTextField clientContractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceIntegerField projectLevelField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField businessTypeField;
	private final DataSourceTextField projectTypeField;

	public CDSformalcontractcccor(String dataSourceID) {

		setID(dataSourceID);
		contractNameField = new DataSourceTextField("contractName", "正式合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		clientContractIdField = new DataSourceTextField("clientContractId", "客户合同编号");
		clientContractIdField.setRequired(false);
		clientContractIdField.setLength(64);
		clientContractIdField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "正式合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);

		projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级");
		projectLevelField.setRequired(false);
		projectLevelField.setLength(11);
		projectLevelField.setHidden(false);
		projectLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);

		businessTypeField = new DataSourceTextField("businessType", "业务类别");
		businessTypeField.setRequired(false);
		businessTypeField.setLength(120);
		businessTypeField.setHidden(false);
		businessTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		projectTypeField = new DataSourceTextField("projectType", "项目类别");
		projectTypeField.setRequired(false);
		projectTypeField.setLength(128);
		projectTypeField.setHidden(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

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


		setFields(contractNameField, clientContractIdField, contractCodeField, projectCodeField, projectLevelField, createTimeField, businessTypeField, projectTypeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

