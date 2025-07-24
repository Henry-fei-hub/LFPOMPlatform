package com.pomplatform.client.preprojects.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSApplyListOfMainProjectReport extends DBDataSource
{


	public static DSApplyListOfMainProjectReport instance = null;

	public static DSApplyListOfMainProjectReport getInstance() {
		if(instance == null) {
			instance = new DSApplyListOfMainProjectReport("DSApplyListOfMainProjectReport");
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
	private final DataSourceTextField provinceField;
	private final DataSourceTextField cityField;
	private final DataSourceTextField projectTypeField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField projectOriginationField;
	private final DataSourceTextField contactNameField;
	private final DataSourceTextField contactPhoneField;
	private final DataSourceTextField detailAddressField;
	private final DataSourceTextField totalBuildingAreasField;
	private final DataSourceIntegerField clientIdField;
	private final DataSourceIntegerField customerTypeField;
	private final DataSourceBooleanField isWarehousField;
	private final DataSourceBooleanField isApplyQuoteField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceIntegerField customerContactIdField;
	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceIntegerField mainProjectStageIdField;
	private final DataSourceBooleanField isModifyProjectField;
	private final DataSourceTextField projectCodeField;

	public DSApplyListOfMainProjectReport(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ApplyListOfMainProjectReport");


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
		processStatusField.setValueMap(KeyValueManager.getValueMap("process_status"));

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		completeTimeField = new DataSourceDateTimeField("completeTime", "完成时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "立项人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


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
		projectTypeField.setHidden(false);
		KeyValueManager.loadValueMap("pre_business_type",projectTypeField);
		

		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setLength(50);
		customerNameField.setRequired(false);
		customerNameField.setHidden(true);
		customerNameField.setValueMap(KeyValueManager.getValueMap("customers_name"));


		projectOriginationField = new DataSourceTextField("projectOrigination", "项目来源渠道");
		projectOriginationField.setLength(512);
		projectOriginationField.setRequired(false);
		projectOriginationField.setHidden(false);
		projectOriginationField.setValueMap(KeyValueManager.getValueMap("system_dictionary_156"));


		contactNameField = new DataSourceTextField("contactName", "客户联系人");
		contactNameField.setLength(32);
		contactNameField.setRequired(false);
		contactNameField.setHidden(true);


		contactPhoneField = new DataSourceTextField("contactPhone", "客户联系人电话");
		contactPhoneField.setLength(64);
		contactPhoneField.setRequired(false);
		contactPhoneField.setHidden(true);


		detailAddressField = new DataSourceTextField("detailAddress", "详细地址");
		detailAddressField.setLength(64);
		detailAddressField.setRequired(false);
		detailAddressField.setHidden(true);


		totalBuildingAreasField = new DataSourceTextField("totalBuildingAreas", "建筑总面积");
		totalBuildingAreasField.setLength(100);
		totalBuildingAreasField.setRequired(false);
		totalBuildingAreasField.setHidden(true);


		clientIdField = new DataSourceIntegerField("clientId", "客户id");
		clientIdField.setLength(11);
		clientIdField.setRequired(false);
		clientIdField.setHidden(true);


		customerTypeField = new DataSourceIntegerField("customerType", "4接洽过未合作客户)(对应于字典表151)");
		customerTypeField.setLength(11);
		customerTypeField.setRequired(false);
		customerTypeField.setHidden(true);


		isWarehousField = new DataSourceBooleanField("isWarehous", "是否入库");
		isWarehousField.setRequired(false);
		isWarehousField.setHidden(true);


		isApplyQuoteField = new DataSourceBooleanField("isApplyQuote", "是否已提供战略报价");
		isApplyQuoteField.setRequired(false);
		isApplyQuoteField.setHidden(true);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(false);


		customerContactIdField = new DataSourceIntegerField("customerContactId", "联系人id");
		customerContactIdField.setLength(11);
		customerContactIdField.setRequired(false);
		customerContactIdField.setHidden(true);


		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "主键编码");
		mainProjectIdField.setLength(11);
		mainProjectIdField.setPrimaryKey(true);
		mainProjectIdField.setRequired(true);
		mainProjectIdField.setHidden(true);


		mainProjectStageIdField = new DataSourceIntegerField("mainProjectStageId", "立项类型");
		mainProjectStageIdField.setLength(11);
		mainProjectStageIdField.setRequired(false);
		mainProjectStageIdField.setHidden(false);
		mainProjectStageIdField.setValueMap(KeyValueManager.getValueMap("main_project_stages"));


		isModifyProjectField = new DataSourceBooleanField("isModifyProject", "是否修改项目");
		isModifyProjectField.setRequired(false);
		isModifyProjectField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		setFields(processInstanceIdField, mainProjectIdField, processTypeField, businessIdField, businessNameField, processIdField, processInstanceActivityIdField, processStatusField, projectCodeField, projectNameField, provinceField, cityField, projectTypeField, customerNameField, projectOriginationField, contactNameField, contactPhoneField, detailAddressField, totalBuildingAreasField, clientIdField, customerTypeField, isWarehousField, isApplyQuoteField, infoCodeField, customerContactIdField, mainProjectStageIdField, isModifyProjectField,employeeIdField, createTimeField, completeTimeField);
	}


}

