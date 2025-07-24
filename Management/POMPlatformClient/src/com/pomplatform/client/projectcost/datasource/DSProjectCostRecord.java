package com.pomplatform.client.projectcost.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.*;

public class DSProjectCostRecord extends DBDataSource
{


	public static DSProjectCostRecord instance = null;

	public static DSProjectCostRecord getInstance() {
		if(instance == null) {
			instance = new DSProjectCostRecord("DSProjectCostRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField projectCostIdField;
	private final DataSourceIntegerField costTypeField;
	private final DataSourceDateField costDateField;
	private final DataSourceIntegerField settlementIdField;
	private final DataSourceFloatField amountField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField designTeamField;
	private final DataSourceIntegerField mainProjectStageIdField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceTextField employeeNameToStringField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField departmentIdField;

	public DSProjectCostRecord(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ProjectCostRecord");




		projectCostIdField = new DataSourceIntegerField("projectCostId", "项目费用编码");
		projectCostIdField.setLength(11);
		projectCostIdField.setPrimaryKey(true);
		projectCostIdField.setRequired(true);
		projectCostIdField.setHidden(true);



		employeeIdField = new DataSourceIntegerField("employeeId", "报销人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		costTypeField = new DataSourceIntegerField("costType", "费用类型");
		costTypeField.setLength(11);
		costTypeField.setRequired(false);
		costTypeField.setHidden(true);
		costTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_9"));


		costDateField = new DataSourceDateField("costDate", "日期");
		costDateField.setRequired(false);
		costDateField.setHidden(true);


		settlementIdField = new DataSourceIntegerField("settlementId", "结算代码");
		settlementIdField.setLength(11);
		settlementIdField.setRequired(false);
		settlementIdField.setHidden(true);


		amountField = new DataSourceFloatField("amount", "金额");
		amountField.setLength(18);
		amountField.setDecimalPad(2);
		amountField.setFormat("#,###,###,###,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "结算状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(true);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_16"));

		processTypeField = new DataSourceIntegerField("processType", "费用类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(false);
		processTypeField.setValueMap(KeyValueManager.getValueMap("system_process_types"));

		businessIdField = new DataSourceIntegerField("businessId", "业务ID");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);

		processIdField = new DataSourceIntegerField("businessId", "业务ID");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);

		processInstanceIdField = new DataSourceIntegerField("businessId", "业务ID");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(true);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(512);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(1024);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		designTeamField = new DataSourceIntegerField("designTeam", "主办设计团队");
		designTeamField.setLength(11);
		designTeamField.setRequired(false);
		designTeamField.setHidden(false);
		designTeamField.setValueMap(KeyValueManager.getValueMap("departments"));

		mainProjectStageIdField = new DataSourceIntegerField("mainProjectStageId", "立项类型");
		mainProjectStageIdField.setLength(11);
		mainProjectStageIdField.setRequired(false);
		mainProjectStageIdField.setHidden(false);
		mainProjectStageIdField.setValueMap(KeyValueManager.getValueMap("main_project_stages"));

		completeTimeField = new DataSourceDateTimeField("completeTime", "报销完成时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(false);


		employeeNameToStringField = new DataSourceTextField("employeeNameToString", "项目经理");
		employeeNameToStringField.setLength(16);
		employeeNameToStringField.setRequired(true);
		employeeNameToStringField.setHidden(false);



		departmentIdField = new DataSourceIntegerField("departmentId", "报销部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		setFields(projectCodeField,projectNameField,projectNameField,projectCostIdField,mainProjectStageIdField, designTeamField,employeeNameToStringField,processTypeField,amountField,completeTimeField,  employeeIdField,employeeIdField,departmentIdField, costTypeField, costDateField, settlementIdField, statusField, businessIdField, processIdField, processInstanceIdField);
	}


}

