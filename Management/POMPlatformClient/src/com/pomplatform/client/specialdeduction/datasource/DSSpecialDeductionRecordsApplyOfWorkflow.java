package com.pomplatform.client.specialdeduction.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSpecialDeductionRecordsApplyOfWorkflow extends DBDataSource
{


	public static DSSpecialDeductionRecordsApplyOfWorkflow instance = null;

	public static DSSpecialDeductionRecordsApplyOfWorkflow getInstance() {
		if(instance == null) {
			instance = new DSSpecialDeductionRecordsApplyOfWorkflow("DSSpecialDeductionRecordsApplyOfWorkflow");
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
	private final DataSourceIntegerField specialDeductionRecordIdField;
	private final DataSourceIntegerField employeIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceDateTimeField createDateField;
	private final DataSourceBooleanField isEnableField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceTextField phoneField;

	public DSSpecialDeductionRecordsApplyOfWorkflow(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SpecialDeductionRecordsApplyOfWorkflow");


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "主键编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setPrimaryKey(true);
		processInstanceIdField.setRequired(true);
		processInstanceIdField.setHidden(true);


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(false);
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
		processStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_120"));
		

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		completeTimeField = new DataSourceDateTimeField("completeTime", "完成时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(true);


		specialDeductionRecordIdField = new DataSourceIntegerField("specialDeductionRecordId", "id");
		specialDeductionRecordIdField.setLength(11);
		specialDeductionRecordIdField.setPrimaryKey(true);
		specialDeductionRecordIdField.setRequired(true);
		specialDeductionRecordIdField.setHidden(true);


		employeIdField = new DataSourceIntegerField("employeId", "纳税申请人");
		employeIdField.setLength(11);
		employeIdField.setRequired(true);
		employeIdField.setHidden(false);
		employeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNameField = new DataSourceTextField("employeeName", "扣除年度");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(false);


		startDateField = new DataSourceDateField("startDate", "有效开始时间");
		startDateField.setRequired(false);
		startDateField.setHidden(true);


		endDateField = new DataSourceDateField("endDate", "有效结束时间");
		endDateField.setRequired(false);
		endDateField.setHidden(true);

		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
		
		
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));

		phoneField = new DataSourceTextField("phone", "手机号码");
		phoneField.setLength(32);
		phoneField.setRequired(true);
		phoneField.setHidden(false);

		createDateField = new DataSourceDateTimeField("createDate", "创建时间");
		createDateField.setRequired(false);
		createDateField.setHidden(true);


		isEnableField = new DataSourceBooleanField("isEnable", "是否可用");
		isEnableField.setRequired(false);
		isEnableField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(true);


		setFields(processInstanceIdField, specialDeductionRecordIdField, processTypeField, businessIdField, businessNameField, processIdField, processInstanceActivityIdField, processStatusField, completeTimeField, employeeNameField, employeIdField, companyIdField,departmentIdField, plateIdField, phoneField, startDateField, endDateField, createDateField, isEnableField, remarkField, createTimeField);
	}


}

