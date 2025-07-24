package com.pomplatform.client.workflow.personnel.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSApplicationInForFiling extends DBDataSource
{


	public static DSApplicationInForFiling instance = null;

	public static DSApplicationInForFiling getInstance() {
		if(instance == null) {
			instance = new DSApplicationInForFiling("DSApplicationInForFiling");
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
	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField nextAuditorField;
	private final DataSourceTextField salary1Field;
	private final DataSourceTextField salary2Field;
	private final DataSourceIntegerField empStatusField;
	private final DataSourceTextField attachmentField;

	public DSApplicationInForFiling(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ApplicationInForFiling");


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


		processStatusField = new DataSourceIntegerField("processStatus", "流程状态 0 发起中  1");
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(true);


		completeTimeField = new DataSourceDateTimeField("completeTime", "完成时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(true);


		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "人事业务编码");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setPrimaryKey(true);
		personnelBusinessIdField.setRequired(true);
		personnelBusinessIdField.setHidden(true);


		processTypeField = new DataSourceIntegerField("processType", "类型 13请假  14出差  15打卡  16外出  17加班");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "申请人");
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "申请人部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		companyIdField = new DataSourceIntegerField("companyId", "申请人归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		nextAuditorField = new DataSourceIntegerField("nextAuditor", "调档人");
		nextAuditorField.setLength(11);
		nextAuditorField.setRequired(false);
		nextAuditorField.setHidden(true);
		nextAuditorField.setValueMap(KeyValueManager.getValueMap("employees"));

		attachmentField = new DataSourceTextField("attachment", "调档人");
		attachmentField.setLength(255);
		attachmentField.setRequired(false);
		attachmentField.setHidden(false);



		salary1Field = new DataSourceTextField("salary1", "调档人归属公司");
		salary1Field.setLength(256);
		salary1Field.setRequired(false);
		salary1Field.setHidden(false);


		salary2Field = new DataSourceTextField("salary2", "调档人归属部门");
		salary2Field.setLength(256);
		salary2Field.setRequired(false);
		salary2Field.setHidden(false);


		empStatusField = new DataSourceIntegerField("empStatus", "empStatus");
		empStatusField.setLength(11);
		empStatusField.setRequired(true);
		empStatusField.setHidden(true);


		setFields(processInstanceIdField, personnelBusinessIdField, employeeIdField, businessIdField, businessNameField, processIdField, processInstanceActivityIdField, processStatusField, completeTimeField, processTypeField, employeeNoField, departmentIdField, companyIdField, attachmentField, salary1Field, salary2Field, empStatusField);
	}


}

