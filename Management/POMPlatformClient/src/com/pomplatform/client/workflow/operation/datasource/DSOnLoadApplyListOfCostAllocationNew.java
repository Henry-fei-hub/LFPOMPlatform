package com.pomplatform.client.workflow.operation.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadApplyListOfCostAllocationNew extends DBDataSource
{


	public static DSOnLoadApplyListOfCostAllocationNew instance = null;

	public static DSOnLoadApplyListOfCostAllocationNew getInstance() {
		if(instance == null) {
			instance = new DSOnLoadApplyListOfCostAllocationNew("DSOnLoadApplyListOfCostAllocationNew");
		}
		return instance;
	}

	private final DataSourceTextField customerNameField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField provinceField;
	private final DataSourceTextField cityField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField businessNameField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceActivityIdField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField transferEmployeeIdField;
	private final DataSourceIntegerField preProjectIdField;
	private final DataSourceIntegerField preProjectTransferRecordIdField;
	private final DataSourceDateTimeField operateTimeField;
	public DSOnLoadApplyListOfCostAllocationNew(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadApplyListOfCostAllocationNew");
		
		customerNameField = new DataSourceTextField("customerName", "开发商名称");
		customerNameField.setLength(512);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		provinceField = new DataSourceTextField("province", "项目地址（省）");
		provinceField.setLength(32);
		provinceField.setRequired(false);
		provinceField.setHidden(false);


		cityField = new DataSourceTextField("city", "项目地址（市）");
		cityField.setLength(32);
		cityField.setRequired(false);
		cityField.setHidden(false);


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "主键编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setPrimaryKey(true);
		processInstanceIdField.setRequired(true);
		processInstanceIdField.setHidden(true);


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);


		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);


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
		processStatusField.setHidden(false);
		processStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_120"));


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		completeTimeField = new DataSourceDateTimeField("completeTime", "完成时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "原报备人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		transferEmployeeIdField = new DataSourceIntegerField("transferEmployeeId", "转交人");
		transferEmployeeIdField.setLength(11);
		transferEmployeeIdField.setRequired(false);
		transferEmployeeIdField.setHidden(false);
		transferEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		preProjectIdField = new DataSourceIntegerField("preProjectId", "项目id");
		preProjectIdField.setLength(11);
		preProjectIdField.setRequired(false);
		preProjectIdField.setHidden(true);


		preProjectTransferRecordIdField = new DataSourceIntegerField("preProjectTransferRecordId", "主键编码");
		preProjectTransferRecordIdField.setLength(11);
		preProjectTransferRecordIdField.setPrimaryKey(true);
		preProjectTransferRecordIdField.setRequired(true);
		preProjectTransferRecordIdField.setHidden(true);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);

		setFields(processInstanceIdField, preProjectTransferRecordIdField, customerNameField, projectNameField, provinceField, cityField, employeeIdField, transferEmployeeIdField,processTypeField, businessIdField, businessNameField, processIdField, processInstanceActivityIdField, processStatusField, createTimeField, completeTimeField, preProjectIdField, operateTimeField);
	}


}

