package com.pomplatform.client.stagemodel.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDContractStageProcessStatusList extends DataSource
{


	public static CDContractStageProcessStatusList instance = null;

	public static CDContractStageProcessStatusList getInstance() {
		if(instance == null) {
			instance = new CDContractStageProcessStatusList("CDContractStageProcessStatusList");
		}
		return instance;
	}

	private final DataSourceIntegerField processStatusField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField managerIdField;
	private final DataSourceIntegerField designDirectorIdField;

	public CDContractStageProcessStatusList(String dataSourceID) {

		setID(dataSourceID);
		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setRequired(false);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);

		contractIdField = new DataSourceIntegerField("contractId", "合同");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdField);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		managerIdField = new DataSourceIntegerField("managerId", "项目经理");
		managerIdField.setRequired(false);
		managerIdField.setLength(11);
		managerIdField.setHidden(false);

		designDirectorIdField = new DataSourceIntegerField("designDirectorId", "设计总监");
		designDirectorIdField.setRequired(false);
		designDirectorIdField.setLength(11);
		designDirectorIdField.setHidden(false);

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


		setFields(processStatusField, contractIdField, contractCodeField, contractNameField, managerIdField, designDirectorIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

