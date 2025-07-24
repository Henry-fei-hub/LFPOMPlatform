package com.pomplatform.client.settlement.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMprojectemployeeppor extends DBDataSource
{


	public static DSMprojectemployeeppor instance = null;

	public static DSMprojectemployeeppor getInstance() {
		if(instance == null) {
			instance = new DSMprojectemployeeppor("DSMprojectemployeeppor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectEmployeeIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceFloatField planIntegralField;
	private final DataSourceFloatField leftIntegralField;
	private final DataSourceFloatField realIntegralField;
	private final DataSourceFloatField stageSureIntegralField;
	private final DataSourceFloatField sureIntegralField;
	private final DataSourceFloatField costField;
	private final DataSourceFloatField stageProjectCostField;
	private final DataSourceFloatField projectCostField;
	private final DataSourceFloatField realAmountField;
	private final DataSourceIntegerField settlementStatusField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField workContentField;
	private final DataSourceIntegerField flagField;

	public DSMprojectemployeeppor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mprojectemployeeppor");


		projectEmployeeIdField = new DataSourceIntegerField("projectEmployeeId", "项目组建编码");   
		projectEmployeeIdField.setLength(11);
		projectEmployeeIdField.setPrimaryKey(true);
		projectEmployeeIdField.setRequired(true);
		projectEmployeeIdField.setHidden(true);


		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects", projectIdField);


		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);


		planIntegralField = new DataSourceFloatField("planIntegral", "预分配积分");
		planIntegralField.setLength(18);
		planIntegralField.setDecimalPad(2);
		planIntegralField.setFormat("#,###,###,###,###,##0.00");
		planIntegralField.setRequired(false);
		planIntegralField.setHidden(true);


		realIntegralField = new DataSourceFloatField("realIntegral", "本次确认积分");
		realIntegralField.setLength(18);
		realIntegralField.setDecimalPad(2);
		realIntegralField.setFormat("#,###,###,###,###,##0.00");
		realIntegralField.setRequired(true);
		realIntegralField.setHidden(false);

		stageSureIntegralField = new DataSourceFloatField("stageSureIntegral", "阶段历史确认积分");
		stageSureIntegralField.setLength(18);
		stageSureIntegralField.setDecimalPad(2);
		stageSureIntegralField.setFormat("#,###,###,###,###,##0.00");
		stageSureIntegralField.setRequired(true);
		stageSureIntegralField.setHidden(true);
		
		sureIntegralField = new DataSourceFloatField("sureIntegral", "历史确认积分");
		sureIntegralField.setLength(18);
		sureIntegralField.setDecimalPad(2);
		sureIntegralField.setFormat("#,###,###,###,###,##0.00");
		sureIntegralField.setRequired(true);
		sureIntegralField.setHidden(false);


		costField = new DataSourceFloatField("cost", "本次分摊成本");
		costField.setLength(18);
		costField.setDecimalPad(2);
		costField.setFormat("#,###,###,###,###,##0.00");
		costField.setRequired(true);
		costField.setHidden(false);

		stageProjectCostField = new DataSourceFloatField("stageProjectCost", "阶段历史分摊成本");
		stageProjectCostField.setLength(18);
		stageProjectCostField.setDecimalPad(5);
		stageProjectCostField.setFormat("#,###,###,###,##0.00");
		stageProjectCostField.setRequired(false);
		stageProjectCostField.setHidden(true);

		projectCostField = new DataSourceFloatField("projectCost", "历史分摊成本");
		projectCostField.setLength(18);
		projectCostField.setDecimalPad(5);
		projectCostField.setFormat("#,###,###,###,##0.00");
		projectCostField.setRequired(false);
		projectCostField.setHidden(false);


		realAmountField = new DataSourceFloatField("realAmount", "最终结算积分");
		realAmountField.setLength(18);
		realAmountField.setDecimalPad(5);
		realAmountField.setFormat("#,###,###,###,##0.00");
		realAmountField.setRequired(false);
		realAmountField.setHidden(false);


		settlementStatusField = new DataSourceIntegerField("settlementStatus", "结算状态");
		settlementStatusField.setLength(11);
		settlementStatusField.setRequired(false);
		settlementStatusField.setHidden(true);
		settlementStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_97"));


		statusField = new DataSourceIntegerField("status", "在职状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));


		workContentField = new DataSourceTextField("workContent", "工作内容");
		workContentField.setLength(1024);
		workContentField.setRequired(false);
		workContentField.setHidden(false);
		
		
		flagField = new DataSourceIntegerField("flag", "状态（1：草稿保存，2：确认保存）");
		flagField.setLength(11);
		flagField.setRequired(false);
		flagField.setHidden(true);
		
		leftIntegralField = new DataSourceFloatField("leftIntegral", "本阶段未确认积分");
		leftIntegralField.setLength(18);
		leftIntegralField.setDecimalPad(2);
		leftIntegralField.setFormat("#,###,###,###,###,##0.00");
		leftIntegralField.setRequired(true);
		leftIntegralField.setHidden(true);


		setFields(projectEmployeeIdField, projectIdField, employeeIdField, employeeNoField, employeeNameField, planIntegralField, realIntegralField, stageSureIntegralField,sureIntegralField, costField, stageProjectCostField,projectCostField, realAmountField, settlementStatusField, statusField, workContentField,leftIntegralField, flagField);
	}


}

