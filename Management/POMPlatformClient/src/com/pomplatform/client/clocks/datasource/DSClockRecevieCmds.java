package com.pomplatform.client.clocks.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSClockRecevieCmds extends DBDataSource
{


	public static DSClockRecevieCmds instance = null;

	public static DSClockRecevieCmds getInstance() {
		if(instance == null) {
			instance = new DSClockRecevieCmds("DSClockRecevieCmds");
		}
		return instance;
	}

	private final DataSourceTextField deviceNameField;
	private final DataSourceIntegerField clockRecevieCmdIdField;
	private final DataSourceTextField snField;
	private final DataSourceTextField cmdContentField;
	private final DataSourceDateTimeField cmdCommitTimeField;
	private final DataSourceDateTimeField cmdTransTimeField;
	private final DataSourceIntegerField cmdReturnField;
	private final DataSourceIntegerField processCountField;
	private final DataSourceIntegerField successFlagField;
	private final DataSourceTextField receiveDataField;
	private final DataSourceIntegerField cmdTypeField;
	private final DataSourceIntegerField cmdSystemField;
	private final DataSourceDateTimeField cmdOverTimeField;
	private final DataSourceTextField updateDbField;
	private final DataSourceIntegerField userIdField;
	private final DataSourceIntegerField changeOperatorField;
	private final DataSourceDateTimeField changeTimeField;
	private final DataSourceIntegerField createOperatorField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField deleteOperatorField;
	private final DataSourceDateTimeField deleteTimeField;
	private final DataSourceIntegerField statusField;

	public DSClockRecevieCmds(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ClockRecevieCmds");


		deviceNameField = new DataSourceTextField("deviceName", "设备名称");
		deviceNameField.setLength(64);
		deviceNameField.setRequired(false);
		deviceNameField.setHidden(false);


		clockRecevieCmdIdField = new DataSourceIntegerField("clockRecevieCmdId", "主键编码");
		clockRecevieCmdIdField.setLength(11);
		clockRecevieCmdIdField.setPrimaryKey(true);
		clockRecevieCmdIdField.setRequired(true);
		clockRecevieCmdIdField.setHidden(true);


		snField = new DataSourceTextField("sn", "序列号");
		snField.setLength(32);
		snField.setRequired(false);
		snField.setHidden(false);


		cmdContentField = new DataSourceTextField("cmdContent", "命令内容");
		cmdContentField.setLength(96384);
		cmdContentField.setRequired(true);
		cmdContentField.setHidden(false);


		cmdCommitTimeField = new DataSourceDateTimeField("cmdCommitTime", "提交时间");
		cmdCommitTimeField.setRequired(false);
		cmdCommitTimeField.setHidden(false);


		cmdTransTimeField = new DataSourceDateTimeField("cmdTransTime", "传送时间");
		cmdTransTimeField.setRequired(false);
		cmdTransTimeField.setHidden(false);


		cmdReturnField = new DataSourceIntegerField("cmdReturn", "返回值");
		cmdReturnField.setLength(11);
		cmdReturnField.setRequired(false);
		cmdReturnField.setHidden(true);


		processCountField = new DataSourceIntegerField("processCount", "返回条数");
		processCountField.setLength(11);
		processCountField.setRequired(false);
		processCountField.setHidden(true);


		successFlagField = new DataSourceIntegerField("successFlag", "返回成功标志");
		successFlagField.setLength(5);
		successFlagField.setRequired(false);
		successFlagField.setHidden(true);


		receiveDataField = new DataSourceTextField("receiveData", "返回数据");
		receiveDataField.setLength(96384);
		receiveDataField.setRequired(false);
		receiveDataField.setHidden(true);


		cmdTypeField = new DataSourceIntegerField("cmdType", "命令内容");
		cmdTypeField.setLength(5);
		cmdTypeField.setRequired(false);
		cmdTypeField.setHidden(true);


		cmdSystemField = new DataSourceIntegerField("cmdSystem", "系统");
		cmdSystemField.setLength(11);
		cmdSystemField.setRequired(false);
		cmdSystemField.setHidden(true);


		cmdOverTimeField = new DataSourceDateTimeField("cmdOverTime", "返回时间");
		cmdOverTimeField.setRequired(false);
		cmdOverTimeField.setHidden(true);


		updateDbField = new DataSourceTextField("updateDb", "数据库更新标记");
		updateDbField.setLength(32);
		updateDbField.setRequired(false);
		updateDbField.setHidden(true);


		userIdField = new DataSourceIntegerField("userId", "操作人");
		userIdField.setLength(64);
		userIdField.setRequired(false);
		userIdField.setHidden(true);


		changeOperatorField = new DataSourceIntegerField("changeOperator", "修改人");
		changeOperatorField.setLength(11);
		changeOperatorField.setRequired(false);
		changeOperatorField.setHidden(true);


		changeTimeField = new DataSourceDateTimeField("changeTime", "修改时间");
		changeTimeField.setRequired(false);
		changeTimeField.setHidden(true);


		createOperatorField = new DataSourceIntegerField("createOperator", "创建人");
		createOperatorField.setLength(11);
		createOperatorField.setRequired(false);
		createOperatorField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		deleteOperatorField = new DataSourceIntegerField("deleteOperator", "删除人");
		deleteOperatorField.setLength(11);
		deleteOperatorField.setRequired(false);
		deleteOperatorField.setHidden(true);


		deleteTimeField = new DataSourceDateTimeField("deleteTime", "删除时间");
		deleteTimeField.setRequired(false);
		deleteTimeField.setHidden(true);


		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(5);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_88"));


		setFields(clockRecevieCmdIdField, snField, deviceNameField, cmdContentField, cmdCommitTimeField, cmdTransTimeField, cmdReturnField, processCountField, successFlagField, receiveDataField, cmdTypeField, cmdSystemField, cmdOverTimeField, updateDbField, userIdField, changeOperatorField, changeTimeField, createOperatorField, createTimeField, deleteOperatorField, deleteTimeField, statusField);
	}


}

