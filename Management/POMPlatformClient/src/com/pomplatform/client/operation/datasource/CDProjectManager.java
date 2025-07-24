package com.pomplatform.client.operation.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDProjectManager extends DataSource
{


	public static CDProjectManager instance = null;

	public static CDProjectManager getInstance() {
		if(instance == null) {
			instance = new CDProjectManager("CDProjectManager");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceIntegerField designTypeField;
	private final DataSourceIntegerField projectLevelField;
	private final DataSourceIntegerField statusField;

	public CDProjectManager(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "板块");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);
//		contractCodeField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractCodeField);

		designTypeField = new DataSourceIntegerField("designType", "设计类型");
		designTypeField.setRequired(false);
		designTypeField.setLength(11);
		designTypeField.setHidden(false);

		projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级");
		projectLevelField.setRequired(false);
		projectLevelField.setLength(11);
		projectLevelField.setHidden(false);
		projectLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));

		statusField = new DataSourceIntegerField("status", "项目状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_4"));

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


		setFields(plateIdField, contractCodeField, designTypeField, projectLevelField, statusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

