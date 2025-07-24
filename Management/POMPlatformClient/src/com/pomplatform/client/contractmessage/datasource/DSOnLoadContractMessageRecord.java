package com.pomplatform.client.contractmessage.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;

public class DSOnLoadContractMessageRecord extends DBDataSource
{


	public static DSOnLoadContractMessageRecord instance = null;

	public static DSOnLoadContractMessageRecord getInstance() {
		if(instance == null) {
			instance = new DSOnLoadContractMessageRecord("DSOnLoadContractMessageRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField contractMessageIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceIntegerField msgCountField;
	private final DataSourceIntegerField msgStatusField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField remarkField;

	public DSOnLoadContractMessageRecord(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadContractMessageRecord");


		contractMessageIdField = new DataSourceIntegerField("contractMessageId", "id");
		contractMessageIdField.setLength(11);
		contractMessageIdField.setPrimaryKey(true);
		contractMessageIdField.setRequired(true);
		contractMessageIdField.setHidden(true);
		contractMessageIdField.setForeignKey("DSOnLoadContractMessageRecord.contractMessageId");

		contractIdField = new DataSourceIntegerField("contractId", "合同id");
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


		businessIdField = new DataSourceIntegerField("businessId", "业务id");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);


		msgCountField = new DataSourceIntegerField("msgCount", "消息推送次数");
		msgCountField.setLength(11);
		msgCountField.setRequired(false);
		msgCountField.setHidden(false);
		
		msgStatusField = new DataSourceIntegerField("msgStatus", "消息状态");
		msgStatusField.setLength(11);
		msgStatusField.setRequired(false);
		msgStatusField.setHidden(false);
		msgStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_243"));

		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(false);
		operatorField.setValueMap(KeyValueManager.getValueMap("employees"));

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(128);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(contractMessageIdField, contractIdField, contractCodeField, contractNameField, businessIdField, msgCountField, msgStatusField, operatorField, remarkField, createTimeField);
	}


}

