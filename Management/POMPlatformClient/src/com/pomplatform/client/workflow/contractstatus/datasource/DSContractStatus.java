package com.pomplatform.client.workflow.contractstatus.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSContractStatus extends DBDataSource
{


	public static DSContractStatus instance = null;

	public static DSContractStatus getInstance() {
		if(instance == null) {
			instance = new DSContractStatus("DSContractStatus");
		}
		return instance;
	}

	private final DataSourceIntegerField contractLogIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField originalStatusField;
	private final DataSourceIntegerField newStatusField;
	private final DataSourceTextField contentField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceIntegerField deleteFlagField;
	private final DataSourceIntegerField attachmentIdField;
	private final DataSourceTextField fileNameField;
	private final DataSourceLinkField fileUrlField;

	public DSContractStatus(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ContractStatus");


		contractLogIdField = new DataSourceIntegerField("contractLogId", "主键编码");
		contractLogIdField.setLength(11);
		contractLogIdField.setPrimaryKey(true);
		contractLogIdField.setRequired(true);
		contractLogIdField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);
		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		originalStatusField = new DataSourceIntegerField("originalStatus", "原始合同状态");
		originalStatusField.setLength(11);
		originalStatusField.setRequired(false);
		originalStatusField.setHidden(false);
		originalStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_35"));


		newStatusField = new DataSourceIntegerField("newStatus", "新合同状态");
		newStatusField.setLength(11);
		newStatusField.setRequired(false);
		newStatusField.setHidden(false);
		newStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_35"));


		contentField = new DataSourceTextField("content", "原因");
		contentField.setLength(1024);
		contentField.setRequired(false);
		contentField.setHidden(false);
		
		
		remarkField = new DataSourceTextField("remark", "下一步计划");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(true);


		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(false);
		operatorField.setValueMap(KeyValueManager.getValueMap("employees"));


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除状态");
		deleteFlagField.setLength(11);
		deleteFlagField.setRequired(false);
		deleteFlagField.setHidden(true);


		attachmentIdField = new DataSourceIntegerField("attachmentId", "附件编码");
		attachmentIdField.setLength(11);
		attachmentIdField.setRequired(false);
		attachmentIdField.setHidden(true);


		fileNameField = new DataSourceTextField("fileName", "附件名称");
		fileNameField.setLength(512);
		fileNameField.setRequired(false);
		fileNameField.setHidden(false);


		fileUrlField = new DataSourceLinkField("fileUrl", "附件路径");
		fileUrlField.setLength(1024);
		fileUrlField.setRequired(false);
		fileUrlField.setHidden(false);


		setFields(contractLogIdField, contractIdField, contractCodeField, contractNameField, originalStatusField, newStatusField, contentField, remarkField, operatorField, operateTimeField, deleteFlagField, attachmentIdField, fileNameField, fileUrlField);
	}


}

