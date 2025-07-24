package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadApplyListOfApproveProjectStageStroage extends DBDataSource
{


	public static DSOnLoadApplyListOfApproveProjectStageStroage instance = null;

	public static DSOnLoadApplyListOfApproveProjectStageStroage getInstance() {
		if(instance == null) {
			instance = new DSOnLoadApplyListOfApproveProjectStageStroage("DSOnLoadApplyListOfApproveProjectStageStroage");
		}
		return instance;
	}

	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField businessNameField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceActivityIdField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceIntegerField otherOperationField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceIntegerField plateManagerIdField;
	private final DataSourceIntegerField departmentManagerIdField;
	private final DataSourceIntegerField approveProjectStageStorageIdField;
	private final DataSourceIntegerField empStatusField;

	public DSOnLoadApplyListOfApproveProjectStageStroage(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadApplyListOfApproveProjectStageStroage");


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "主键编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setPrimaryKey(true);
		processInstanceIdField.setRequired(true);
		processInstanceIdField.setHidden(true);

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
		processStatusField.setHidden(true);



		completeTimeField = new DataSourceDateTimeField("completeTime", "完成时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(true);




		otherOperationField = new DataSourceIntegerField("otherOperation", "流程走完之后，是否执行了其他操作   0未执行   1已执行");
		otherOperationField.setLength(11);
		otherOperationField.setRequired(false);
		otherOperationField.setHidden(true);


		projectIdField = new DataSourceIntegerField("projectId", "项目主键");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(255);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(255);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(255);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		projectTypeField = new DataSourceIntegerField("projectType", "项目类别");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
        plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		projectManageIdField = new DataSourceIntegerField("projectManageId", "专业负责人");
		projectManageIdField.setLength(11);
		projectManageIdField.setRequired(false);
		projectManageIdField.setHidden(true);


		plateManagerIdField = new DataSourceIntegerField("plateManagerId", "事业部负责人");
		plateManagerIdField.setLength(11);
		plateManagerIdField.setRequired(false);
		plateManagerIdField.setHidden(true);


		departmentManagerIdField = new DataSourceIntegerField("departmentManagerId", "部门经理");
		departmentManagerIdField.setLength(11);
		departmentManagerIdField.setRequired(false);
		departmentManagerIdField.setHidden(true);


		approveProjectStageStorageIdField = new DataSourceIntegerField("approveProjectStageStorageId", "id");
		approveProjectStageStorageIdField.setLength(11);
		approveProjectStageStorageIdField.setPrimaryKey(true);
		approveProjectStageStorageIdField.setRequired(true);
		approveProjectStageStorageIdField.setHidden(true);



		empStatusField = new DataSourceIntegerField("empStatus", "empStatus");
		empStatusField.setLength(11);
		empStatusField.setRequired(true);
		empStatusField.setHidden(true);


		setFields(processInstanceIdField, approveProjectStageStorageIdField, businessIdField, businessNameField, processIdField, processInstanceActivityIdField, processStatusField, completeTimeField, otherOperationField, projectIdField, contractCodeField, projectCodeField, projectNameField, projectTypeField, plateIdField, projectManageIdField, plateManagerIdField, departmentManagerIdField, empStatusField);
	}


}

