package com.pomplatform.client.meeting.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class CDMeetingRoomTimeManagement extends DataSource
{


	public static CDMeetingRoomTimeManagement instance = null;

	public static CDMeetingRoomTimeManagement getInstance() {
		if(instance == null) {
			instance = new CDMeetingRoomTimeManagement("CDMeetingRoomTimeManagement");
		}
		return instance;
	}

	private final DataSourceTextField meetingRoomTimeField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField meetingRoomTimeIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField deleteFlagField;

	public CDMeetingRoomTimeManagement(String dataSourceID) {

		setID(dataSourceID);
		meetingRoomTimeField = new DataSourceTextField("meetingRoomTime", "时间区间");
		meetingRoomTimeField.setRequired(false);
		meetingRoomTimeField.setLength(128);
		meetingRoomTimeField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(64);
		remarkField.setHidden(false);

		meetingRoomTimeIdField = new DataSourceIntegerField("meetingRoomTimeId", "id");
		meetingRoomTimeIdField.setRequired(true);
		meetingRoomTimeIdField.setLength(11);
		meetingRoomTimeIdField.setPrimaryKey(true);
		meetingRoomTimeIdField.setHidden(true);

		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

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


		setFields(meetingRoomTimeField, remarkField, meetingRoomTimeIdField, statusField, deleteFlagField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

