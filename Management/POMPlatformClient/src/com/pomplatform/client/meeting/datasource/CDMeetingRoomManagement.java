package com.pomplatform.client.meeting.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class CDMeetingRoomManagement extends DataSource
{


	public static CDMeetingRoomManagement instance = null;

	public static CDMeetingRoomManagement getInstance() {
		if(instance == null) {
			instance = new CDMeetingRoomManagement("CDMeetingRoomManagement");
		}
		return instance;
	}

	private final DataSourceTextField meetingRoomNameField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField meetingRoomIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField companyRecordIdField;
	private final DataSourceIntegerField deleteFlagField;

	public CDMeetingRoomManagement(String dataSourceID) {

		setID(dataSourceID);
		meetingRoomNameField = new DataSourceTextField("meetingRoomName", "会议室名称");
		meetingRoomNameField.setRequired(false);
		meetingRoomNameField.setLength(128);
		meetingRoomNameField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(64);
		remarkField.setHidden(false);

		meetingRoomIdField = new DataSourceIntegerField("meetingRoomId", "id");
		meetingRoomIdField.setRequired(true);
		meetingRoomIdField.setLength(11);
		meetingRoomIdField.setPrimaryKey(true);
		meetingRoomIdField.setHidden(true);

		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

		companyRecordIdField = new DataSourceIntegerField("companyRecordId", "归属公司");
		companyRecordIdField.setRequired(false);
		companyRecordIdField.setLength(11);
		companyRecordIdField.setHidden(false);

		deleteFlagField = new DataSourceIntegerField("deleteFlag", "是否删除");
		deleteFlagField.setRequired(false);
		deleteFlagField.setLength(11);
		deleteFlagField.setHidden(false);

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


		setFields(meetingRoomNameField, remarkField, meetingRoomIdField, statusField, companyRecordIdField, deleteFlagField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

