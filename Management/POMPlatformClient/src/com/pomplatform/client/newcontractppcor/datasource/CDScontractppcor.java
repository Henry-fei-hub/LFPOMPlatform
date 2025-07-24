package com.pomplatform.client.newcontractppcor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDScontractppcor extends DataSource
{


	public static CDScontractppcor instance = null;

	public static CDScontractppcor getInstance() {
		if(instance == null) {
			instance = new CDScontractppcor("CDScontractppcor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectLevelField;
	private final DataSourceTextField projectTypeField;
	private final DataSourceIntegerField contractStatusField;
	private final DataSourceTextField clientContractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField customerIdField;
	private final DataSourceTextField projectCodeField;

	public CDScontractppcor(String dataSourceID) {

		setID(dataSourceID);
		projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级");
		projectLevelField.setRequired(false);
		projectLevelField.setLength(11);
		projectLevelField.setHidden(false);
		projectLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		projectTypeField = new DataSourceTextField("projectType", "项目类别");
		projectTypeField.setRequired(false);
		projectTypeField.setLength(128);
		projectTypeField.setHidden(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		contractStatusField = new DataSourceIntegerField("contractStatus", "合同状态");
		contractStatusField.setRequired(false);
		contractStatusField.setLength(11);
		contractStatusField.setHidden(false);
		contractStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		clientContractIdField = new DataSourceTextField("clientContractId", "客户合同编号");
		clientContractIdField.setRequired(false);
		clientContractIdField.setLength(64);
		clientContractIdField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		customerIdField = new DataSourceIntegerField("customerId", "客户名称");
		customerIdField.setRequired(false);
		customerIdField.setLength(11);
		customerIdField.setHidden(false);
		KeyValueManager.loadValueMap("customers", customerIdField);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);

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


		setFields(projectLevelField, projectTypeField, contractStatusField, clientContractIdField, contractCodeField, contractNameField, customerIdField, projectCodeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

