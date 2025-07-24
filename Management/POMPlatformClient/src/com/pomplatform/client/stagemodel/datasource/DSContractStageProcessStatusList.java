package com.pomplatform.client.stagemodel.datasource;

import java.util.LinkedHashMap;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.common.ClientStaticUtils;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSContractStageProcessStatusList extends DBDataSource
{


	public static DSContractStageProcessStatusList instance = null;

	public static DSContractStageProcessStatusList getInstance() {
		if(instance == null) {
			instance = new DSContractStageProcessStatusList("DSContractStageProcessStatusList");
		}
		return instance;
	}

	private final DataSourceIntegerField contractStageModelIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField stageModelNameField;
	private final DataSourceTextField managerIdField;
	private final DataSourceTextField manageAuditStatusField;
	private final DataSourceTextField designDirectorIdField;
	private final DataSourceTextField designDirectorAuditStatusField;
	private final DataSourceIntegerField processStatusField;

	public DSContractStageProcessStatusList(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ContractStageProcessStatusList");


		contractStageModelIdField = new DataSourceIntegerField("contractStageModelId", "主键编码");
		contractStageModelIdField.setLength(11);
		contractStageModelIdField.setPrimaryKey(true);
		contractStageModelIdField.setRequired(true);
		contractStageModelIdField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdField);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		stageModelNameField = new DataSourceTextField("stageModelName", "节点名称");
		stageModelNameField.setLength(256);
		stageModelNameField.setRequired(false);
		stageModelNameField.setHidden(false);


		managerIdField = new DataSourceTextField("managerId", "项目经理");
		managerIdField.setLength(128);
		managerIdField.setRequired(true);
		managerIdField.setHidden(false);
		managerIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		manageAuditStatusField = new DataSourceTextField("manageAuditStatus", "审批状态");
		manageAuditStatusField.setLength(128);
		manageAuditStatusField.setRequired(true);
		manageAuditStatusField.setHidden(false);


		designDirectorIdField = new DataSourceTextField("designDirectorId", "驻场人员/设计总监");
		designDirectorIdField.setLength(128);
		designDirectorIdField.setRequired(true);
		designDirectorIdField.setHidden(false);
		designDirectorIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		designDirectorAuditStatusField = new DataSourceTextField("designDirectorAuditStatus", "审批状态");
		designDirectorAuditStatusField.setLength(128);
		designDirectorAuditStatusField.setRequired(true);
		designDirectorAuditStatusField.setHidden(false);


		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(false);
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put(ClientStaticUtils.CONTRACT_STAGE_PROCESS_STATUS_1, "运行中");
		map.put(ClientStaticUtils.CONTRACT_STAGE_PROCESS_STATUS_3, "已完成");
		processStatusField.setValueMap(map);


		setFields(contractStageModelIdField, contractIdField, contractCodeField, contractNameField, stageModelNameField, managerIdField, manageAuditStatusField, designDirectorIdField, designDirectorAuditStatusField, processStatusField);
	}


}

