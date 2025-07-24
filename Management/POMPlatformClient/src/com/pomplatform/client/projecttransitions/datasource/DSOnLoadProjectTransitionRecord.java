package com.pomplatform.client.projecttransitions.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadProjectTransitionRecord extends DBDataSource
{


	public static DSOnLoadProjectTransitionRecord instance = null;

	public static DSOnLoadProjectTransitionRecord getInstance() {
		if(instance == null) {
			instance = new DSOnLoadProjectTransitionRecord("DSOnLoadProjectTransitionRecord");
		}
		return instance;
	}
	private final DataSourceIntegerField projectTransitionIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField newProjectManageIdField;
	private final DataSourceIntegerField oldNewProjectManageIdField;
	private final DataSourceFloatField newPercentageField;
	private final DataSourceFloatField oldPercentageField;
	private final DataSourceIntegerField initiateDesignField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField msgCountField;
	private final DataSourceIntegerField msgStatusField;

	public DSOnLoadProjectTransitionRecord(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadProjectTransitionRecord");
		

		projectTransitionIdField = new DataSourceIntegerField("projectTransitionId", "id");
		projectTransitionIdField.setLength(11);
		projectTransitionIdField.setPrimaryKey(true);
		projectTransitionIdField.setRequired(true);
		projectTransitionIdField.setHidden(true);


		projectIdField = new DataSourceIntegerField("projectId", "项目id");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(true);
		
		contractCodeField = new DataSourceTextField("contractCode", "订单编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		newProjectManageIdField = new DataSourceIntegerField("newProjectManageId", "新专业负责人");
		newProjectManageIdField.setLength(11);
		newProjectManageIdField.setRequired(true);
		newProjectManageIdField.setHidden(false);
		newProjectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		oldNewProjectManageIdField = new DataSourceIntegerField("oldNewProjectManageId", "原专业负责人");
		oldNewProjectManageIdField.setLength(11);
		oldNewProjectManageIdField.setRequired(true);
		oldNewProjectManageIdField.setHidden(false);
		oldNewProjectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		newPercentageField = new DataSourceFloatField("newPercentage", "新核算比例(%)");
		newPercentageField.setLength(12);
		newPercentageField.setDecimalPad(2);
		newPercentageField.setFormat("#,###,###,##0.00");
		newPercentageField.setRequired(true);
		newPercentageField.setHidden(false);


		oldPercentageField = new DataSourceFloatField("oldPercentage", "原核算比例(%)");
		oldPercentageField.setLength(10);
		oldPercentageField.setDecimalPad(2);
		oldPercentageField.setFormat("##,##0.00");
		oldPercentageField.setRequired(true);
		oldPercentageField.setHidden(false);


		initiateDesignField = new DataSourceIntegerField("initiateDesign", "方案主创审批人");
		initiateDesignField.setLength(11);
		initiateDesignField.setRequired(false);
		initiateDesignField.setHidden(false);
		initiateDesignField.setValueMap(KeyValueManager.getValueMap("employees"));

		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_241"));

		operatorField = new DataSourceIntegerField("operator", "申请人");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(false);
		operatorField.setValueMap(KeyValueManager.getValueMap("employees"));


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);
		
		
		msgCountField = new DataSourceIntegerField("msgCount", "消息推送次数");
		msgCountField.setLength(11);
		msgCountField.setRequired(false);
		msgCountField.setHidden(false);

		
		msgStatusField = new DataSourceIntegerField("msgStatus", "消息状态");
		msgStatusField.setLength(11);
		msgStatusField.setRequired(false);
		msgStatusField.setHidden(false);
		msgStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_243"));


		setFields(projectTransitionIdField,projectIdField,contractCodeField, projectCodeField, projectNameField, newProjectManageIdField, oldNewProjectManageIdField, newPercentageField, oldPercentageField, initiateDesignField, statusField, operatorField, createTimeField,msgCountField,msgStatusField);
	}


}

