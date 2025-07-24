package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSProjectEmployee extends DBDataSource
{


	public static DSProjectEmployee instance = null;

	public static DSProjectEmployee getInstance() {
		if(instance == null) {
			instance = new DSProjectEmployee("DSProjectEmployee");
		}
		return instance;
	}

	private final DataSourceIntegerField projectEmployeeIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField designPhaseField;
	private final DataSourceIntegerField planWorkHoursField;
	private final DataSourceIntegerField realWorkHoursField;
	private final DataSourceFloatField planIntegralField;
	private final DataSourceFloatField realIntegralField;
	private final DataSourceDateField planStartDateField;
	private final DataSourceDateField planEndDateField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceTextField workContentField;
	private final DataSourceTextField alternateField1Field;
	private final DataSourceTextField alternateField2Field;
	private final DataSourceTextField alternateField3Field;
	private final DataSourceIntegerField statusField;
	private final DataSourceFloatField costField;
	private final DataSourceFloatField settlementField;
	private final DataSourceFloatField employeeAchieveIntegralReturnField;
	private final DataSourceIntegerField stageIdField;
	private final DataSourceIntegerField flagField;
	private final DataSourceIntegerField businessIdField;

	public DSProjectEmployee(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("ProjectEmployee");


		projectEmployeeIdField = new DataSourceIntegerField("projectEmployeeId", "项目组建编码");
		projectEmployeeIdField.setLength(11);
		projectEmployeeIdField.setPrimaryKey(true);
		projectEmployeeIdField.setRequired(true);
		projectEmployeeIdField.setHidden(true);


		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "员工名称");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		designPhaseField = new DataSourceIntegerField("designPhase", "设计阶段");
		designPhaseField.setLength(11);
		designPhaseField.setRequired(false);
		designPhaseField.setHidden(true);


		planWorkHoursField = new DataSourceIntegerField("planWorkHours", "预估工时");
		planWorkHoursField.setLength(11);
		planWorkHoursField.setRequired(false);
		planWorkHoursField.setHidden(true);


		realWorkHoursField = new DataSourceIntegerField("realWorkHours", "实际工时");
		realWorkHoursField.setLength(11);
		realWorkHoursField.setRequired(false);
		realWorkHoursField.setHidden(true);


		planIntegralField = new DataSourceFloatField("planIntegral", "预分配积分");
		planIntegralField.setLength(0);
		planIntegralField.setDecimalPad(0);
		planIntegralField.setFormat("");
		planIntegralField.setRequired(false);
		planIntegralField.setHidden(true);


		realIntegralField = new DataSourceFloatField("realIntegral", "实际获得积分");
		realIntegralField.setLength(0);
		realIntegralField.setDecimalPad(0);
		realIntegralField.setFormat("");
		realIntegralField.setRequired(false);
		realIntegralField.setHidden(true);


		planStartDateField = new DataSourceDateField("planStartDate", "计划开始日期");
		planStartDateField.setRequired(false);
		planStartDateField.setHidden(true);


		planEndDateField = new DataSourceDateField("planEndDate", "计划结束日期");
		planEndDateField.setRequired(false);
		planEndDateField.setHidden(true);


		startDateField = new DataSourceDateField("startDate", "实际开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(true);


		endDateField = new DataSourceDateField("endDate", "实际结束日期");
		endDateField.setRequired(false);
		endDateField.setHidden(true);


		workContentField = new DataSourceTextField("workContent", "工作内容");
		workContentField.setLength(1024);
		workContentField.setRequired(false);
		workContentField.setHidden(true);


		alternateField1Field = new DataSourceTextField("alternateField1", "备用字段1");
		alternateField1Field.setLength(512);
		alternateField1Field.setRequired(false);
		alternateField1Field.setHidden(true);


		alternateField2Field = new DataSourceTextField("alternateField2", "备用字段2");
		alternateField2Field.setLength(512);
		alternateField2Field.setRequired(false);
		alternateField2Field.setHidden(true);


		alternateField3Field = new DataSourceTextField("alternateField3", "备用字段3");
		alternateField3Field.setLength(512);
		alternateField3Field.setRequired(false);
		alternateField3Field.setHidden(true);


		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(true);


		costField = new DataSourceFloatField("cost", "费用");
		costField.setLength(13);
		costField.setDecimalPad(5);
		costField.setFormat("##,###,##0.00000");
		costField.setRequired(false);
		costField.setHidden(true);


		settlementField = new DataSourceFloatField("settlement", "结算积分");
		settlementField.setLength(13);
		settlementField.setDecimalPad(5);
		settlementField.setFormat("##,###,##0.00000");
		settlementField.setRequired(false);
		settlementField.setHidden(true);


		employeeAchieveIntegralReturnField = new DataSourceFloatField("employeeAchieveIntegralReturn", "积分回流");
		employeeAchieveIntegralReturnField.setLength(13);
		employeeAchieveIntegralReturnField.setDecimalPad(5);
		employeeAchieveIntegralReturnField.setFormat("##,###,##0.00000");
		employeeAchieveIntegralReturnField.setRequired(false);
		employeeAchieveIntegralReturnField.setHidden(true);


		stageIdField = new DataSourceIntegerField("stageId", "阶段Id");
		stageIdField.setLength(11);
		stageIdField.setRequired(false);
		stageIdField.setHidden(true);


		flagField = new DataSourceIntegerField("flag", "状态（1草稿保存，2确认保存）");
		flagField.setLength(11);
		flagField.setRequired(false);
		flagField.setHidden(true);


		businessIdField = new DataSourceIntegerField("businessId", "流程主表id");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);


		setFields(projectEmployeeIdField, projectIdField, employeeIdField, designPhaseField, planWorkHoursField, realWorkHoursField, planIntegralField, realIntegralField, planStartDateField, planEndDateField, startDateField, endDateField, workContentField, alternateField1Field, alternateField2Field, alternateField3Field, statusField, costField, settlementField, employeeAchieveIntegralReturnField, stageIdField, flagField, businessIdField);
	}


}

