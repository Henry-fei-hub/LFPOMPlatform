package com.pomplatform.client.trainingmanagement.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSTrainingManagementDetail extends DBDataSource
{


	public static DSTrainingManagementDetail instance = null;

	public static DSTrainingManagementDetail getInstance() {
		if(instance == null) {
			instance = new DSTrainingManagementDetail("DSTrainingManagementDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField trainingManagementDetailIdField;
	private final DataSourceIntegerField trainingManagementIdField;
	private final DataSourceDateTimeField signInTimeField;
	private final DataSourceDateTimeField signOutTimeField;
	private final DataSourceIntegerField signOutFlagField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNumberField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField trainingContentField;
	private final DataSourceIntegerField trainingMethodField;
	private final DataSourceIntegerField trainingFrequencyField;
	private final DataSourceIntegerField trainingPeriodField;
	private final DataSourceIntegerField spareTimeTrainingField;
	private final DataSourceTextField suggestField;
	private final DataSourceIntegerField courseEvaluationField;
	private final DataSourceIntegerField guidingFunctionField;

	public DSTrainingManagementDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("TrainingManagementDetail");


		trainingManagementDetailIdField = new DataSourceIntegerField("trainingManagementDetailId", "主键编码");
		trainingManagementDetailIdField.setLength(11);
		trainingManagementDetailIdField.setRequired(true);
		trainingManagementDetailIdField.setHidden(false);


		trainingManagementIdField = new DataSourceIntegerField("trainingManagementId", "培训管理编码");
		trainingManagementIdField.setLength(11);
		trainingManagementIdField.setRequired(false);
		trainingManagementIdField.setHidden(true);


		signInTimeField = new DataSourceDateTimeField("signInTime", "签到时间");
		signInTimeField.setRequired(false);
		signInTimeField.setHidden(false);


		signOutTimeField = new DataSourceDateTimeField("signOutTime", "签退时间");
		signOutTimeField.setRequired(false);
		signOutTimeField.setHidden(false);


		signOutFlagField = new DataSourceIntegerField("signOutFlag", "是否签退(0签退2没有签退)");
		signOutFlagField.setLength(11);
		signOutFlagField.setRequired(false);
		signOutFlagField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "签到人编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);


		employeeNumberField = new DataSourceTextField("employeeNumber", "签到人工号");
		employeeNumberField.setLength(32);
		employeeNumberField.setRequired(false);
		employeeNumberField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "部门编码");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);


		trainingContentField = new DataSourceIntegerField("trainingContent", "培训内容得分");
		trainingContentField.setLength(11);
		trainingContentField.setRequired(false);
		trainingContentField.setHidden(false);


		trainingMethodField = new DataSourceIntegerField("trainingMethod", "培训方式得分");
		trainingMethodField.setLength(11);
		trainingMethodField.setRequired(false);
		trainingMethodField.setHidden(false);


		trainingFrequencyField = new DataSourceIntegerField("trainingFrequency", "培训频率选择(1每月2每季3半年4每年)");
		trainingFrequencyField.setLength(11);
		trainingFrequencyField.setRequired(false);
		trainingFrequencyField.setHidden(false);


		trainingPeriodField = new DataSourceIntegerField("trainingPeriod", "培训时长(1半个小时21到2个小时33到4个小时4一天)");
		trainingPeriodField.setLength(11);
		trainingPeriodField.setRequired(false);
		trainingPeriodField.setHidden(false);


		spareTimeTrainingField = new DataSourceIntegerField("spareTimeTraining", "是否接受业余时间培训(1是2否3看课程)");
		spareTimeTrainingField.setLength(11);
		spareTimeTrainingField.setRequired(false);
		spareTimeTrainingField.setHidden(false);


		suggestField = new DataSourceTextField("suggest", "建议");
		suggestField.setLength(255);
		suggestField.setRequired(false);
		suggestField.setHidden(false);


		courseEvaluationField = new DataSourceIntegerField("courseEvaluation", "课程评价");
		courseEvaluationField.setLength(11);
		courseEvaluationField.setRequired(false);
		courseEvaluationField.setHidden(false);


		guidingFunctionField = new DataSourceIntegerField("guidingFunction", "指导作用");
		guidingFunctionField.setLength(11);
		guidingFunctionField.setRequired(false);
		guidingFunctionField.setHidden(false);


		setFields(trainingManagementDetailIdField, trainingManagementIdField, signInTimeField, signOutTimeField, signOutFlagField, employeeIdField, employeeNumberField, departmentIdField, trainingContentField, trainingMethodField, trainingFrequencyField, trainingPeriodField, spareTimeTrainingField, suggestField, courseEvaluationField, guidingFunctionField);
	}


}

