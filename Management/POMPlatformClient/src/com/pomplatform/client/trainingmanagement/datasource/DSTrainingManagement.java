package com.pomplatform.client.trainingmanagement.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.user.client.ui.DirectionalTextHelper;
import com.delicacy.client.data.DBDataSource;

public class DSTrainingManagement extends DBDataSource
{


	public static DSTrainingManagement instance = null;

	public static DSTrainingManagement getInstance() {
		if(instance == null) {
			instance = new DSTrainingManagement("DSTrainingManagement");
		}
		return instance;
	}

	private final DataSourceIntegerField trainingManagementIdField;
	private final DataSourceTextField subjectField;
	private final DataSourceIntegerField compereTypeField;
	private final DataSourceTextField compereField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField startTimeField;
	private final DataSourceDateTimeField endTimeField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField courseScoreField;
	private final DataSourceIntegerField createPersonIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceFloatField avgScoreField;
	private final DataSourceIntegerField signInCountField;
	private final DataSourceIntegerField signOutCountField;
	private final DataSourceIntegerField trainingFrequencyOneField;
	private final DataSourceIntegerField trainingFrequencyTwoField;
	private final DataSourceIntegerField trainingFrequencyThreeField;
	private final DataSourceIntegerField trainingFrequencyFourField;
	private final DataSourceIntegerField trainingPeriodOneField;
	private final DataSourceIntegerField trainingPeriodTwoField;
	private final DataSourceIntegerField trainingPeriodThreeField;
	private final DataSourceIntegerField trainingPeriodFourField;
	private final DataSourceIntegerField spareTimeTrainingOneField;
	private final DataSourceIntegerField spareTimeTrainingTwoField;
	private final DataSourceIntegerField spareTimeTrainingThreeField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;

	public DSTrainingManagement(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("TrainingManagement");


		trainingManagementIdField = new DataSourceIntegerField("trainingManagementId", "主键编码");
		trainingManagementIdField.setLength(11);
		trainingManagementIdField.setPrimaryKey(true);
		trainingManagementIdField.setRequired(true);
		trainingManagementIdField.setHidden(true);
		trainingManagementIdField.setRootValue("root");
		trainingManagementIdField.setForeignKey("DSTrainingManagement.trainingManagementId");


		subjectField = new DataSourceTextField("subject", "主题");
		subjectField.setLength(255);
		subjectField.setRequired(false);
		subjectField.setHidden(false);


		compereTypeField = new DataSourceIntegerField("compereType", "主持人类型(1公司内部员工2外部人员)");
		compereTypeField.setLength(11);
		compereTypeField.setRequired(false);
		compereTypeField.setHidden(true);
		compereTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_174"));


		compereField = new DataSourceTextField("compere", "主讲人");
		compereField.setLength(32);
		compereField.setRequired(false);
		compereField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		startTimeField = new DataSourceDateTimeField("startTime", "开始时间");
		startTimeField.setRequired(false);
		startTimeField.setHidden(false);


		endTimeField = new DataSourceDateTimeField("endTime", "结束时间");
		endTimeField.setRequired(false);
		endTimeField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(true);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		courseScoreField = new DataSourceIntegerField("courseScore", "课程分数");
		courseScoreField.setLength(11);
		courseScoreField.setRequired(false);
		courseScoreField.setHidden(false);


		createPersonIdField = new DataSourceIntegerField("createPersonId", "创建人");
		createPersonIdField.setLength(11);
		createPersonIdField.setRequired(false);
		createPersonIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "主持人(内部)");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		avgScoreField = new DataSourceFloatField("avgScore", "平均分数");
		avgScoreField.setLength(18);
		avgScoreField.setDecimalPad(2);
		avgScoreField.setFormat("#,###,###,###,###,##0.00");
		avgScoreField.setRequired(true);
		avgScoreField.setHidden(false);


		signInCountField = new DataSourceIntegerField("signInCount", "签到人数");
		signInCountField.setLength(8);
		signInCountField.setRequired(true);
		signInCountField.setHidden(false);


		signOutCountField = new DataSourceIntegerField("signOutCount", "签退人数");
		signOutCountField.setLength(8);
		signOutCountField.setRequired(true);
		signOutCountField.setHidden(false);
		
		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(8);
		statusField.setRequired(true);
		statusField.setHidden(false);


		trainingFrequencyOneField = new DataSourceIntegerField("trainingFrequencyOne", "每月/次");
		trainingFrequencyOneField.setLength(8);
		trainingFrequencyOneField.setRequired(true);
		trainingFrequencyOneField.setHidden(true);


		trainingFrequencyTwoField = new DataSourceIntegerField("trainingFrequencyTwo", "每季/次");
		trainingFrequencyTwoField.setLength(8);
		trainingFrequencyTwoField.setRequired(true);
		trainingFrequencyTwoField.setHidden(true);


		trainingFrequencyThreeField = new DataSourceIntegerField("trainingFrequencyThree", "半年/次");
		trainingFrequencyThreeField.setLength(8);
		trainingFrequencyThreeField.setRequired(true);
		trainingFrequencyThreeField.setHidden(true);


		trainingFrequencyFourField = new DataSourceIntegerField("trainingFrequencyFour", "每年/次");
		trainingFrequencyFourField.setLength(8);
		trainingFrequencyFourField.setRequired(true);
		trainingFrequencyFourField.setHidden(true);


		trainingPeriodOneField = new DataSourceIntegerField("trainingPeriodOne", "半小时/课");
		trainingPeriodOneField.setLength(8);
		trainingPeriodOneField.setRequired(true);
		trainingPeriodOneField.setHidden(true);


		trainingPeriodTwoField = new DataSourceIntegerField("trainingPeriodTwo", "1-2小时/课");
		trainingPeriodTwoField.setLength(8);
		trainingPeriodTwoField.setRequired(true);
		trainingPeriodTwoField.setHidden(true);


		trainingPeriodThreeField = new DataSourceIntegerField("trainingPeriodThree", "3-4/小时没课");
		trainingPeriodThreeField.setLength(8);
		trainingPeriodThreeField.setRequired(true);
		trainingPeriodThreeField.setHidden(true);


		trainingPeriodFourField = new DataSourceIntegerField("trainingPeriodFour", "1天/课");
		trainingPeriodFourField.setLength(8);
		trainingPeriodFourField.setRequired(true);
		trainingPeriodFourField.setHidden(true);


		spareTimeTrainingOneField = new DataSourceIntegerField("spareTimeTrainingOne", "能");
		spareTimeTrainingOneField.setLength(8);
		spareTimeTrainingOneField.setRequired(true);
		spareTimeTrainingOneField.setHidden(true);


		spareTimeTrainingTwoField = new DataSourceIntegerField("spareTimeTrainingTwo", "否");
		spareTimeTrainingTwoField.setLength(8);
		spareTimeTrainingTwoField.setRequired(true);
		spareTimeTrainingTwoField.setHidden(true);


		spareTimeTrainingThreeField = new DataSourceIntegerField("spareTimeTrainingThree", "看课程");
		spareTimeTrainingThreeField.setLength(8);
		spareTimeTrainingThreeField.setRequired(true);
		spareTimeTrainingThreeField.setHidden(true);
		
		
		yearField = new DataSourceIntegerField("year", "年");
		yearField.setLength(15);
		yearField.setRequired(true);
		yearField.setHidden(true);
		
		monthField = new DataSourceIntegerField("month", "月");
		monthField.setLength(15);
		monthField.setRequired(true);
		monthField.setHidden(true);


		setFields(trainingManagementIdField, subjectField, createTimeField, startTimeField, endTimeField, departmentIdField, courseScoreField, createPersonIdField,compereTypeField, compereField,  employeeIdField, avgScoreField, signInCountField, signOutCountField, trainingFrequencyOneField, trainingFrequencyTwoField, trainingFrequencyThreeField, trainingFrequencyFourField, trainingPeriodOneField, trainingPeriodTwoField, trainingPeriodThreeField, trainingPeriodFourField, spareTimeTrainingOneField, spareTimeTrainingTwoField, spareTimeTrainingThreeField,yearField,monthField);
	}


}

