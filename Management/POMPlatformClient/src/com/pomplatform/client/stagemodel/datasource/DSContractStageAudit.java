package com.pomplatform.client.stagemodel.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSContractStageAudit extends DBDataSource
{


	public static DSContractStageAudit instance = null;

	public static DSContractStageAudit getInstance() {
		if(instance == null) {
			instance = new DSContractStageAudit("DSContractStageAudit");
		}
		return instance;
	}

	private final DataSourceIntegerField contractStageModelIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField stageModelNameField;
	private final DataSourceBooleanField lockedField;

	public DSContractStageAudit(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ContractStageAudit");


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


		lockedField = new DataSourceBooleanField("locked", "是否锁定");
		lockedField.setRequired(false);
		lockedField.setHidden(false);


		setFields(contractStageModelIdField, contractIdField, contractCodeField, contractNameField, stageModelNameField, lockedField);
	}


}

