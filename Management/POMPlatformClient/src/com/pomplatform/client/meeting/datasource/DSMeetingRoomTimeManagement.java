package com.pomplatform.client.meeting.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

import java.util.HashMap;
import java.util.Map;

public class DSMeetingRoomTimeManagement extends DBDataSource
{


	public static DSMeetingRoomTimeManagement instance = null;

	public static DSMeetingRoomTimeManagement getInstance() {
		if(instance == null) {
			instance = new DSMeetingRoomTimeManagement("DSMeetingRoomTimeManagement");
		}
		return instance;
	}

	private final DataSourceIntegerField meetingRoomTimeIdField;
	private final DataSourceTextField meetingRoomTimeField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField deleteFlagField;

	public DSMeetingRoomTimeManagement(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("MeetingRoomTimeManagement");


		meetingRoomTimeIdField = new DataSourceIntegerField("meetingRoomTimeId", "id");
		meetingRoomTimeIdField.setLength(11);
		meetingRoomTimeIdField.setPrimaryKey(true);
		meetingRoomTimeIdField.setRequired(true);
		meetingRoomTimeIdField.setHidden(true);


		meetingRoomTimeField = new DataSourceTextField("meetingRoomTime", "时间区间");
		meetingRoomTimeField.setLength(128);
		meetingRoomTimeField.setRequired(false);
		meetingRoomTimeField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(64);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		deleteFlagField = new DataSourceIntegerField("deleteFlag", "是否删除");
		deleteFlagField.setLength(11);
		deleteFlagField.setRequired(false);
		deleteFlagField.setHidden(false);
		Map map2 =new HashMap<Integer, String>();
		map2.put(0, "未删除");
		map2.put(1, "已删除");
		deleteFlagField.setValueMap(map2);	

		setFields(meetingRoomTimeIdField, meetingRoomTimeField, statusField, deleteFlagField, remarkField);
	}


}

