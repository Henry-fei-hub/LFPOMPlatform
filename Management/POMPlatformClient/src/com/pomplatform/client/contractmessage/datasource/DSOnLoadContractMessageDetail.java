package com.pomplatform.client.contractmessage.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadContractMessageDetail extends DBDataSource
{


	public static DSOnLoadContractMessageDetail instance = null;

	public static DSOnLoadContractMessageDetail getInstance() {
		if(instance == null) {
			instance = new DSOnLoadContractMessageDetail("DSOnLoadContractMessageDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField contractMessageDetailIdField;
	private final DataSourceIntegerField contractMessageIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField remarkField;

	public DSOnLoadContractMessageDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadContractMessageDetail");


		contractMessageDetailIdField = new DataSourceIntegerField("contractMessageDetailId", "id");
		contractMessageDetailIdField.setLength(11);
		contractMessageDetailIdField.setPrimaryKey(true);
		contractMessageDetailIdField.setRequired(true);
		contractMessageDetailIdField.setHidden(true);


		contractMessageIdField = new DataSourceIntegerField("contractMessageId", "id");
		contractMessageIdField.setLength(11);
		contractMessageIdField.setPrimaryKey(true);
		contractMessageIdField.setRequired(true);
		contractMessageIdField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同id");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(false);
		operatorField.setValueMap(KeyValueManager.getValueMap("employees"));


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "消息推送人员");
		remarkField.setLength(256);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(contractMessageDetailIdField, contractMessageIdField, contractIdField, operatorField, remarkField, createTimeField);
	}


}

