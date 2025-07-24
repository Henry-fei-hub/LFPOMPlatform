package com.pomplatform.client.meeting.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMeetingInfoPaymentBase extends DBDataSource
{


	public static DSMeetingInfoPaymentBase instance = null;

	public static DSMeetingInfoPaymentBase getInstance() {
		if(instance == null) {
			instance = new DSMeetingInfoPaymentBase("DSMeetingInfoPaymentBase");
		}
		return instance;
	}

	private final DataSourceIntegerField meetingRecordChartIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField meetingThemeField;
	private final DataSourceDateTimeField startTimeField;
	private final DataSourceDateTimeField endTimeField;
	private final DataSourceTextField meetingRoomNameField;
	private final DataSourceTextField siteField;
	private final DataSourceIntegerField containNumField;
	private final DataSourceTextField meetingRoomMasterField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField meetingRoomTimeField;
	private final DataSourceIntegerField meetingRoomIdField;
	private final DataSourceDateField recordDateField;
	private final DataSourceIntegerField meetingRelevanceIdField;
	private final DataSourceIntegerField meetingStatusField;
	private final DataSourceDateField meetingTimeField;
	private final DataSourceTextField confreeNamesField;

	public DSMeetingInfoPaymentBase(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("MeetingInfoPaymentBase");


		meetingRecordChartIdField = new DataSourceIntegerField("meetingRecordChartId", "主键编码");
		meetingRecordChartIdField.setLength(11);
		meetingRecordChartIdField.setPrimaryKey(true);
		meetingRecordChartIdField.setRequired(true);
		meetingRecordChartIdField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "状态 ( 0未预约，1已预约，2使用中，3已作废 ,4已完成)");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);


		meetingThemeField = new DataSourceTextField("meetingTheme", "会议主题");
		meetingThemeField.setLength(255);
		meetingThemeField.setRequired(false);
		meetingThemeField.setHidden(false);


		startTimeField = new DataSourceDateTimeField("startTime", "开始时间");
		startTimeField.setRequired(false);
		startTimeField.setHidden(false);


		endTimeField = new DataSourceDateTimeField("endTime", "结束时间");
		endTimeField.setRequired(false);
		endTimeField.setHidden(false);


		meetingRoomNameField = new DataSourceTextField("meetingRoomName", "会议室名称");
		meetingRoomNameField.setLength(128);
		meetingRoomNameField.setRequired(false);
		meetingRoomNameField.setHidden(false);


		siteField = new DataSourceTextField("site", "位置");
		siteField.setLength(128);
		siteField.setRequired(false);
		siteField.setHidden(false);


		containNumField = new DataSourceIntegerField("containNum", "容纳人数");
		containNumField.setLength(11);
		containNumField.setRequired(false);
		containNumField.setHidden(false);


		meetingRoomMasterField = new DataSourceTextField("meetingRoomMaster", "会议室负责人");
		meetingRoomMasterField.setLength(128);
		meetingRoomMasterField.setRequired(false);
		meetingRoomMasterField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "预约人编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		meetingRoomTimeField = new DataSourceTextField("meetingRoomTime", "时间区间");
		meetingRoomTimeField.setLength(128);
		meetingRoomTimeField.setRequired(false);
		meetingRoomTimeField.setHidden(false);


		meetingRoomIdField = new DataSourceIntegerField("meetingRoomId", "会议室编码");
		meetingRoomIdField.setLength(11);
		meetingRoomIdField.setRequired(true);
		meetingRoomIdField.setHidden(false);


		recordDateField = new DataSourceDateField("recordDate", "创建日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);


		meetingRelevanceIdField = new DataSourceIntegerField("meetingRelevanceId", "关联id");
		meetingRelevanceIdField.setLength(11);
		meetingRelevanceIdField.setRequired(false);
		meetingRelevanceIdField.setHidden(false);


		meetingStatusField = new DataSourceIntegerField("meetingStatus", "会议记录的类型（1普通会议  2周例会  3月例会 )");
		meetingStatusField.setLength(11);
		meetingStatusField.setRequired(false);
		meetingStatusField.setHidden(false);


		meetingTimeField = new DataSourceDateField("meetingTime", "会议时间");
		meetingTimeField.setRequired(false);
		meetingTimeField.setHidden(true);


		confreeNamesField = new DataSourceTextField("confreeNames", "confreeNames");
		confreeNamesField.setLength(-1);
		confreeNamesField.setRequired(true);
		confreeNamesField.setHidden(true);


		setFields(meetingRecordChartIdField, statusField, meetingThemeField, startTimeField, endTimeField, meetingRoomNameField, siteField, containNumField, meetingRoomMasterField, employeeIdField, meetingRoomTimeField, meetingRoomIdField, recordDateField, meetingRelevanceIdField, meetingStatusField, meetingTimeField, confreeNamesField);
	}


}

