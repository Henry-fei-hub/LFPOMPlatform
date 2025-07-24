package com.pomplatform.client.meeting.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMeetingRelevanceInfo extends DBDataSource
{


	public static DSMeetingRelevanceInfo instance = null;

	public static DSMeetingRelevanceInfo getInstance() {
		if(instance == null) {
			instance = new DSMeetingRelevanceInfo("DSMeetingRelevanceInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField meetingRelevanceIdField;
	private final DataSourceTextField meetingRoomNameField;
	private final DataSourceIntegerField meetingRoomIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField meetingRoomTimeField;
	private final DataSourceDateField recordDateField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField meetingThemeField;
	private final DataSourceIntegerField startTimeField;
	private final DataSourceIntegerField endTimeField;

	public DSMeetingRelevanceInfo(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("MeetingRelevanceInfo");


		meetingRelevanceIdField = new DataSourceIntegerField("meetingRelevanceId", "主键");
		meetingRelevanceIdField.setLength(11);
		meetingRelevanceIdField.setPrimaryKey(true);
		meetingRelevanceIdField.setRequired(true);
		meetingRelevanceIdField.setHidden(false);


		meetingRoomNameField = new DataSourceTextField("meetingRoomName", "会议室名称");
		meetingRoomNameField.setLength(255);
		meetingRoomNameField.setRequired(false);
		meetingRoomNameField.setHidden(false);


		meetingRoomIdField = new DataSourceIntegerField("meetingRoomId", "会议室编码");
		meetingRoomIdField.setLength(11);
		meetingRoomIdField.setRequired(false);
		meetingRoomIdField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "预约人编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		meetingRoomTimeField = new DataSourceTextField("meetingRoomTime", "时间区间");
		meetingRoomTimeField.setLength(128);
		meetingRoomTimeField.setRequired(false);
		meetingRoomTimeField.setHidden(false);


		recordDateField = new DataSourceDateField("recordDate", "操作日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "状态 ( 0未预约，1已预约，2使用中，3已作废 ,4已完成)");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);


		meetingThemeField = new DataSourceTextField("meetingTheme", "会议室主题");
		meetingThemeField.setLength(255);
		meetingThemeField.setRequired(false);
		meetingThemeField.setHidden(false);


		startTimeField = new DataSourceIntegerField("startTime", "开始时间");
		startTimeField.setLength(11);
		startTimeField.setRequired(false);
		startTimeField.setHidden(false);


		endTimeField = new DataSourceIntegerField("endTime", "结束时间");
		endTimeField.setLength(11);
		endTimeField.setRequired(false);
		endTimeField.setHidden(false);


		setFields(meetingRelevanceIdField, meetingRoomNameField, meetingRoomIdField, employeeIdField, meetingRoomTimeField, recordDateField, statusField, meetingThemeField, startTimeField, endTimeField);
	}


}

