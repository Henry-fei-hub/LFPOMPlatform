package com.pomplatform.client.shift.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSManageShiftTime extends DBDataSource
{


	public static DSManageShiftTime instance = null;

	public static DSManageShiftTime getInstance() {
		if(instance == null) {
			instance = new DSManageShiftTime("DSManageShiftTime");
		}
		return instance;
	}

	private final DataSourceIntegerField shiftTimeManageIdField;
	private final DataSourceTextField shiftTimeNameField;
	private final DataSourceBooleanField checkSignInField;
	private final DataSourceTextField signInTimeField;
	private final DataSourceBooleanField checkSignOffField;
	private final DataSourceTextField signOffTimeField;
	private final DataSourceIntegerField lateMinutesField;
	private final DataSourceIntegerField leaveEarlyTimeField;
	private final DataSourceTextField signInStartTimeField;
	private final DataSourceTextField signInEndTimeField;
	private final DataSourceTextField signOffStartTimeField;
	private final DataSourceTextField signOffEndTimeField;
	private final DataSourceFloatField daysField;
	private final DataSourceIntegerField minutesField;
	private final DataSourceTextField overtimeStartTimeField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField updateTimeField;

	public DSManageShiftTime(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ManageShiftTime");


		shiftTimeManageIdField = new DataSourceIntegerField("shiftTimeManageId", "班次时段维护表编码");
		shiftTimeManageIdField.setLength(11);
		shiftTimeManageIdField.setPrimaryKey(true);
		shiftTimeManageIdField.setRequired(true);
		shiftTimeManageIdField.setHidden(true);


		shiftTimeNameField = new DataSourceTextField("shiftTimeName", "时段名称");
		shiftTimeNameField.setLength(64);
		shiftTimeNameField.setRequired(false);
		shiftTimeNameField.setHidden(false);


		checkSignInField = new DataSourceBooleanField("checkSignIn", "是否需要签到");
		checkSignInField.setRequired(false);
		checkSignInField.setHidden(false);


		signInTimeField = new DataSourceTextField("signInTime", "上班时间");
		signInTimeField.setLength(32);
		signInTimeField.setRequired(false);
		signInTimeField.setHidden(false);


		checkSignOffField = new DataSourceBooleanField("checkSignOff", "是否需要签退");
		checkSignOffField.setRequired(false);
		checkSignOffField.setHidden(false);


		signOffTimeField = new DataSourceTextField("signOffTime", "下班时间");
		signOffTimeField.setLength(32);
		signOffTimeField.setRequired(false);
		signOffTimeField.setHidden(false);


		lateMinutesField = new DataSourceIntegerField("lateMinutes", "计迟到时间（分钟）");
		lateMinutesField.setLength(11);
		lateMinutesField.setRequired(false);
		lateMinutesField.setHidden(false);


		leaveEarlyTimeField = new DataSourceIntegerField("leaveEarlyTime", "计早退时间（分钟）");
		leaveEarlyTimeField.setLength(11);
		leaveEarlyTimeField.setRequired(false);
		leaveEarlyTimeField.setHidden(false);


		signInStartTimeField = new DataSourceTextField("signInStartTime", "签到开始时间");
		signInStartTimeField.setLength(32);
		signInStartTimeField.setRequired(false);
		signInStartTimeField.setHidden(true);


		signInEndTimeField = new DataSourceTextField("signInEndTime", "签到结束时间");
		signInEndTimeField.setLength(32);
		signInEndTimeField.setRequired(false);
		signInEndTimeField.setHidden(true);


		signOffStartTimeField = new DataSourceTextField("signOffStartTime", "签退开始时间");
		signOffStartTimeField.setLength(32);
		signOffStartTimeField.setRequired(false);
		signOffStartTimeField.setHidden(true);


		signOffEndTimeField = new DataSourceTextField("signOffEndTime", "签退结束时间");
		signOffEndTimeField.setLength(32);
		signOffEndTimeField.setRequired(false);
		signOffEndTimeField.setHidden(true);


		daysField = new DataSourceFloatField("days", "计多少工作日");
		daysField.setLength(5);
		daysField.setDecimalPad(2);
		daysField.setFormat("##0.00");
		daysField.setRequired(false);
		daysField.setHidden(false);


		minutesField = new DataSourceIntegerField("minutes", "计多少分钟");
		minutesField.setLength(11);
		minutesField.setRequired(false);
		minutesField.setHidden(false);


		overtimeStartTimeField = new DataSourceTextField("overtimeStartTime", "开始算加班时间");
		overtimeStartTimeField.setLength(32);
		overtimeStartTimeField.setRequired(false);
		overtimeStartTimeField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(true);


		setFields(shiftTimeManageIdField, shiftTimeNameField, checkSignInField, signInTimeField, checkSignOffField, signOffTimeField, lateMinutesField, leaveEarlyTimeField, signInStartTimeField, signInEndTimeField, signOffStartTimeField, signOffEndTimeField, daysField, minutesField, overtimeStartTimeField, createTimeField, updateTimeField);
	}


}

