package com.pomplatform.client.workflow.operation.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnLoadApplyListOfCostAllocation extends DBDataSource
{


	public static DSOnLoadApplyListOfCostAllocation instance = null;

	public static DSOnLoadApplyListOfCostAllocation getInstance() {
		if(instance == null) {
			instance = new DSOnLoadApplyListOfCostAllocation("DSOnLoadApplyListOfCostAllocation");
		}
		return instance;
	}

	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField businessNameField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceActivityIdField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceIntegerField costTypeField;
	private final DataSourceTextField codeField;
	private final DataSourceTextField nameField;
	private final DataSourceFloatField costField;
	private final DataSourceIntegerField drafterField;
	private final DataSourceTextField reasonField;

	public DSOnLoadApplyListOfCostAllocation(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadApplyListOfCostAllocation");


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "主键编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setPrimaryKey(true);
		processInstanceIdField.setRequired(true);
		processInstanceIdField.setHidden(true);


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);
		processTypeField.setValueMap(KeyValueManager.getValueMap("system_process_types"));


		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);
		businessIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		businessNameField = new DataSourceTextField("businessName", "业务名称");
		businessNameField.setLength(256);
		businessNameField.setRequired(false);
		businessNameField.setHidden(true);


		processIdField = new DataSourceIntegerField("processId", "流程编码");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);


		processInstanceActivityIdField = new DataSourceIntegerField("processInstanceActivityId", "活动实列编码");
		processInstanceActivityIdField.setLength(11);
		processInstanceActivityIdField.setRequired(false);
		processInstanceActivityIdField.setHidden(true);


		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(true);
		processStatusField.setValueMap(new java.util.HashMap());


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		completeTimeField = new DataSourceDateTimeField("completeTime", "完成时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(true);


		costTypeField = new DataSourceIntegerField("costType", "原成本类型");
		costTypeField.setLength(11);
		costTypeField.setRequired(false);
		costTypeField.setHidden(false);
		costTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_121"));


		codeField = new DataSourceTextField("code", "编号");
		codeField.setLength(256);
		codeField.setRequired(false);
		codeField.setHidden(false);


		nameField = new DataSourceTextField("name", "费用承担主体");
		nameField.setLength(256);
		nameField.setRequired(false);
		nameField.setHidden(false);


		costField = new DataSourceFloatField("cost", "成本");
		costField.setLength(18);
		costField.setDecimalPad(2);
		costField.setFormat("#,###,###,###,###,##0.00");
		costField.setRequired(false);
		costField.setHidden(false);


		drafterField = new DataSourceIntegerField("drafter", "起草人");
		drafterField.setLength(11);
		drafterField.setRequired(false);
		drafterField.setHidden(false);
		drafterField.setValueMap(KeyValueManager.getValueMap("employees"));


		reasonField = new DataSourceTextField("reason", "申请缘由");
		reasonField.setLength(1024);
		reasonField.setRequired(false);
		reasonField.setHidden(false);


		setFields(processInstanceIdField, processTypeField, businessIdField, businessNameField, processIdField, processInstanceActivityIdField, processStatusField, drafterField, costTypeField, codeField, nameField, costField, createTimeField, completeTimeField, reasonField);
	}


}

