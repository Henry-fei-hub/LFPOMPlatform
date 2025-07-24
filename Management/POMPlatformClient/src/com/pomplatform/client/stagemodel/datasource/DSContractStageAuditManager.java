package com.pomplatform.client.stagemodel.datasource;

import java.util.LinkedHashMap;

import com.delicacy.client.data.DBDataSource;
import com.pomplatform.client.common.ClientStaticUtils;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSContractStageAuditManager extends DBDataSource
{


	public static DSContractStageAuditManager instance = null;

	public static DSContractStageAuditManager getInstance() {
		if(instance == null) {
			instance = new DSContractStageAuditManager("DSContractStageAuditManager");
		}
		return instance;
	}

	private final DataSourceIntegerField contractStageModelIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField stageModelNameField;
	private final DataSourceBooleanField lockedField;
	private final DataSourceTextField auditStatusField;

	public DSContractStageAuditManager(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ContractStageAuditManager");


		contractStageModelIdField = new DataSourceIntegerField("contractStageModelId", "主键编码");
		contractStageModelIdField.setLength(11);
		contractStageModelIdField.setPrimaryKey(true);
		contractStageModelIdField.setRequired(true);
		contractStageModelIdField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


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


		lockedField = new DataSourceBooleanField("locked", "是否锁定");
		lockedField.setRequired(false);
		lockedField.setHidden(false);


		auditStatusField = new DataSourceTextField("auditStatus", "审批状态");
		auditStatusField.setLength(4);
		auditStatusField.setRequired(true);
		auditStatusField.setHidden(false);
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put(ClientStaticUtils.CONTRACT_STAGE_AUDIT_STATUS_1, "未审批");
		map.put(ClientStaticUtils.CONTRACT_STAGE_AUDIT_STATUS_2, "已审批");
		auditStatusField.setValueMap(map);


		setFields(contractStageModelIdField, contractIdField, contractCodeField, contractNameField, stageModelNameField, auditStatusField, lockedField);
	}


}

