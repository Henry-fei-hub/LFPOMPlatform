package com.pomplatform.client.preprojects.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSRefuseListOfPreProjectReport extends DBDataSource
{


	public static DSRefuseListOfPreProjectReport instance = null;

	public static DSRefuseListOfPreProjectReport getInstance() {
		if(instance == null) {
			instance = new DSRefuseListOfPreProjectReport("DSRefuseListOfPreProjectReport");
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
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField projectNameOneField;
	private final DataSourceTextField provinceField;
	private final DataSourceTextField cityField;
	private final DataSourceTextField projectTypeField;
	private final DataSourceIntegerField customerNameField;
	private final DataSourceTextField projectOriginationField;

	public DSRefuseListOfPreProjectReport(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("RefuseListOfPreProjectReport");


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "主键编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setPrimaryKey(true);
		processInstanceIdField.setRequired(true);
		processInstanceIdField.setHidden(true);
		processInstanceIdField.setValueMap(new java.util.HashMap());


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);
		processTypeField.setValueMap(KeyValueManager.getValueMap("system_process_types"));


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
		processStatusField.setValueMap(KeyValueManager.getValueMap("process_status"));


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		completeTimeField = new DataSourceDateTimeField("completeTime", "完成时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "报备人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);

		projectNameOneField = new DataSourceTextField("projectName", "项目名称(报备后有修改显示原项目名称)");
		projectNameOneField.setLength(512);
		projectNameOneField.setRequired(false);
		projectNameOneField.setHidden(false);


		provinceField = new DataSourceTextField("province", "省份");
		provinceField.setLength(32);
		provinceField.setRequired(false);
		provinceField.setHidden(false);


		cityField = new DataSourceTextField("city", "城市");
		cityField.setLength(32);
		cityField.setRequired(false);
		cityField.setHidden(false);


		projectTypeField = new DataSourceTextField("projectType", "项目业态");
		projectTypeField.setLength(128);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(true);
//		projectTypeField.setValueMap(KeyValueManager.getValueMap("pre_business_type"));
		KeyValueManager.loadValueMap("pre_business_type",projectTypeField);


		customerNameField = new DataSourceIntegerField("customerName", "客户名称");
		customerNameField.setLength(50);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);
		customerNameField.setValueMap(KeyValueManager.getValueMap("customers_name"));


		projectOriginationField = new DataSourceTextField("projectOrigination", "项目来源渠道");
		projectOriginationField.setLength(512);
		projectOriginationField.setRequired(false);
		projectOriginationField.setHidden(false);
		projectOriginationField.setValueMap(KeyValueManager.getValueMap("system_dictionary_156"));


		setFields(processInstanceIdField, processTypeField, businessIdField, businessNameField, processIdField, processInstanceActivityIdField, createTimeField, employeeIdField, projectNameField,projectNameOneField, provinceField, cityField, projectTypeField, customerNameField, projectOriginationField, completeTimeField, processStatusField);
	}


}

