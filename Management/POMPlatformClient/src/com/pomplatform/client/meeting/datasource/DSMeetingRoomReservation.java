package com.pomplatform.client.meeting.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMeetingRoomReservation extends DBDataSource
{


	public static DSMeetingRoomReservation instance = null;

	public static DSMeetingRoomReservation getInstance() {
		if(instance == null) {
			instance = new DSMeetingRoomReservation("DSMeetingRoomReservation");
		}
		return instance;
	}

	private final DataSourceIntegerField meetingRoomReservationRecordIdField;
	private final DataSourceIntegerField meetingRoomIdField;
	private final DataSourceIntegerField meetingRoomTimeIdField;
	private final DataSourceTextField meetingRoomTimeField;
	private final DataSourceDateField meetingDateField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField meetingRoomMasterField;

	public DSMeetingRoomReservation(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("MeetingRoomReservation");


		meetingRoomReservationRecordIdField = new DataSourceIntegerField("meetingRoomReservationRecordId", "主键编码");
		meetingRoomReservationRecordIdField.setLength(11);
		meetingRoomReservationRecordIdField.setPrimaryKey(true);
		meetingRoomReservationRecordIdField.setRequired(true);
		meetingRoomReservationRecordIdField.setHidden(false);


		meetingRoomIdField = new DataSourceIntegerField("meetingRoomId", "会议室编码");
		meetingRoomIdField.setLength(11);
		meetingRoomIdField.setRequired(false);
		meetingRoomIdField.setHidden(false);


		meetingRoomTimeIdField = new DataSourceIntegerField("meetingRoomTimeId", "时区编码");
		meetingRoomTimeIdField.setLength(11);
		meetingRoomTimeIdField.setRequired(false);
		meetingRoomTimeIdField.setHidden(false);


		meetingRoomTimeField = new DataSourceTextField("meetingRoomTime", "时间区间");
		meetingRoomTimeField.setLength(128);
		meetingRoomTimeField.setRequired(false);
		meetingRoomTimeField.setHidden(false);


		meetingDateField = new DataSourceDateField("meetingDate", "日期");
		meetingDateField.setRequired(false);
		meetingDateField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "预约人编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		statusField = new DataSourceIntegerField("status", "状态(0,已预约，1，未预约)");
		statusField.setLength(11);
		statusField.setRequired(true);
		statusField.setHidden(false);


		meetingRoomMasterField = new DataSourceTextField("meetingRoomMaster", "会议室负责人");
		meetingRoomMasterField.setLength(128);
		meetingRoomMasterField.setRequired(false);
		meetingRoomMasterField.setHidden(false);


		setFields(meetingRoomReservationRecordIdField, meetingRoomIdField, meetingRoomTimeIdField, meetingRoomTimeField, meetingDateField, employeeIdField, statusField, meetingRoomMasterField);
	}


}

