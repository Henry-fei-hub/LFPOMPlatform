package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadApplyListOfOrderInfo extends DBDataSource
{


	public static DSOnLoadApplyListOfOrderInfo instance = null;

	public static DSOnLoadApplyListOfOrderInfo getInstance() {
		if(instance == null) {
			instance = new DSOnLoadApplyListOfOrderInfo("DSOnLoadApplyListOfOrderInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField businessNameField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField fileIdField;
	private final DataSourceLinkField fileUrlField;
	private final DataSourceTextField flieNameField;

	public DSOnLoadApplyListOfOrderInfo(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadApplyListOfOrderInfo");


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程实列编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(true);


		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);


		businessNameField = new DataSourceTextField("businessName", "业务名称");
		businessNameField.setLength(11);
		businessNameField.setRequired(false);
		businessNameField.setHidden(true);


		processIdField = new DataSourceIntegerField("processId", "流程编码");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);


		processStatusField = new DataSourceIntegerField("processStatus", "流程状态 0 发起中  1");
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "创建人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		completeTimeField = new DataSourceDateTimeField("completeTime", "完成时间");
		completeTimeField.setLength(11);
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setLength(11);
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		contractIdField = new DataSourceIntegerField("contractId", "主订单编码");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		contractCodeField = new DataSourceTextField("contractCode", "主订单编号");
		contractCodeField.setLength(11);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(11);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(false);


		contractNameField = new DataSourceTextField("contractName", "主订单名称");
		contractNameField.setLength(11);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		fileIdField = new DataSourceIntegerField("fileId", "附件id");
		fileIdField.setLength(11);
		fileIdField.setRequired(false);
		fileIdField.setHidden(true);


		fileUrlField = new DataSourceLinkField("fileUrl", "启动函");
		fileUrlField.setLength(128);
		fileUrlField.setRequired(false);
		fileUrlField.setHidden(false);


		flieNameField = new DataSourceTextField("flieName", "附件名");
		flieNameField.setLength(512);
		flieNameField.setRequired(false);
		flieNameField.setHidden(true);


		setFields(contractIdField, contractCodeField,contractNameField, infoCodeField ,processInstanceIdField, businessIdField, businessNameField, processIdField, processStatusField, completeTimeField, createTimeField,employeeIdField,fileIdField,fileUrlField,flieNameField);
	}


}

