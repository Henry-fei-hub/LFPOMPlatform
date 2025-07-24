package com.pomplatform.client.trainingmanagementdetailor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDStrainingmanagementdetailor extends DataSource
{


	public static CDStrainingmanagementdetailor instance = null;

	public static CDStrainingmanagementdetailor getInstance() {
		if(instance == null) {
			instance = new CDStrainingmanagementdetailor("CDStrainingmanagementdetailor");
		}
		return instance;
	}

	private final DataSourceIntegerField trainingManagementDetailIdField;
	private final DataSourceIntegerField trainingManagementIdField;
	private final DataSourceIntegerField signOutFlagField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNumberField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField trainingContentField;
	private final DataSourceIntegerField trainingMethodField;
	private final DataSourceIntegerField trainingFrequencyField;
	private final DataSourceIntegerField trainingPeriodField;
	private final DataSourceIntegerField spareTimeTrainingField;
	private final DataSourceIntegerField courseEvaluationField;
	private final DataSourceIntegerField guidingFunctionField;

	public CDStrainingmanagementdetailor(String dataSourceID) {

		setID(dataSourceID);
		trainingManagementDetailIdField = new DataSourceIntegerField("trainingManagementDetailId", "主键ID");
		trainingManagementDetailIdField.setRequired(true);
		trainingManagementDetailIdField.setLength(11);
		trainingManagementDetailIdField.setPrimaryKey(true);
		trainingManagementDetailIdField.setHidden(true);

		trainingManagementIdField = new DataSourceIntegerField("trainingManagementId", "培训管理ID");
		trainingManagementIdField.setRequired(false);
		trainingManagementIdField.setLength(11);
		trainingManagementIdField.setHidden(false);

		signOutFlagField = new DataSourceIntegerField("signOutFlag", "是否签退(1签退2没有签退)");
		signOutFlagField.setRequired(false);
		signOutFlagField.setLength(11);
		signOutFlagField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "签到人ID");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		employeeNumberField = new DataSourceTextField("employeeNumber", "签到人工号");
		employeeNumberField.setRequired(false);
		employeeNumberField.setLength(32);
		employeeNumberField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门编码");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		trainingContentField = new DataSourceIntegerField("trainingContent", "培训内容得分");
		trainingContentField.setRequired(false);
		trainingContentField.setLength(11);
		trainingContentField.setHidden(false);

		trainingMethodField = new DataSourceIntegerField("trainingMethod", "培训方式得分");
		trainingMethodField.setRequired(false);
		trainingMethodField.setLength(11);
		trainingMethodField.setHidden(false);

		trainingFrequencyField = new DataSourceIntegerField("trainingFrequency", "培训频率选择(1每月2每季3半年4每年)");
		trainingFrequencyField.setRequired(false);
		trainingFrequencyField.setLength(11);
		trainingFrequencyField.setHidden(false);

		trainingPeriodField = new DataSourceIntegerField("trainingPeriod", "培训时长(1半个小时21到2个小时33到4个小时4一天)");
		trainingPeriodField.setRequired(false);
		trainingPeriodField.setLength(11);
		trainingPeriodField.setHidden(false);

		spareTimeTrainingField = new DataSourceIntegerField("spareTimeTraining", "是否接受业余时间培训(1是2否3看课程)");
		spareTimeTrainingField.setRequired(false);
		spareTimeTrainingField.setLength(11);
		spareTimeTrainingField.setHidden(false);

		courseEvaluationField = new DataSourceIntegerField("courseEvaluation", "课程评价");
		courseEvaluationField.setRequired(false);
		courseEvaluationField.setLength(11);
		courseEvaluationField.setHidden(false);

		guidingFunctionField = new DataSourceIntegerField("guidingFunction", "指导作用");
		guidingFunctionField.setRequired(false);
		guidingFunctionField.setLength(11);
		guidingFunctionField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(trainingManagementDetailIdField, trainingManagementIdField, signOutFlagField, employeeIdField, employeeNumberField, departmentIdField, trainingContentField, trainingMethodField, trainingFrequencyField, trainingPeriodField, spareTimeTrainingField, courseEvaluationField, guidingFunctionField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

