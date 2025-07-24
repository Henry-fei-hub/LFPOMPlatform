package com.pomplatform.client.meeting.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMeetingRoomManagement extends DBDataSource
{


	public static DSMeetingRoomManagement instance = null;

	public static DSMeetingRoomManagement getInstance() {
		if(instance == null) {
			instance = new DSMeetingRoomManagement("DSMeetingRoomManagement");
		}
		return instance;
	}

	private final DataSourceIntegerField meetingRoomIdField;
	private final DataSourceTextField meetingRoomNameField;
	private final DataSourceTextField siteField;
	private final DataSourceIntegerField containNumField;
//	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField companyRecordIdField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField meetingmaster;
//	private final DataSourceIntegerField deleteFlagField;

	public DSMeetingRoomManagement(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("MeetingRoomManagement");


		meetingRoomIdField = new DataSourceIntegerField("meetingRoomId", "id");
		meetingRoomIdField.setLength(11);
		meetingRoomIdField.setPrimaryKey(true);
		meetingRoomIdField.setRequired(true);
		meetingRoomIdField.setHidden(true);


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


		meetingmaster = new DataSourceTextField("meetingRoomMaster","会议室负责人");
		meetingmaster.setHidden(false);
		meetingmaster.setLength(128);
		meetingmaster.setRequired(false);

//		statusField = new DataSourceIntegerField("status", "状态");
//		statusField.setLength(11);
//		statusField.setRequired(false);
//		statusField.setHidden(false);
//		Map map1 =new HashMap<Integer, String>();
//		map1.put(0, "未预约");
//		map1.put(1, "使用中");
//		map1.put(2,"禁止预约");
//		statusField.setValueMap(map1);


		companyRecordIdField = new DataSourceIntegerField("companyRecordId", "归属公司");
		companyRecordIdField.setLength(11);
		companyRecordIdField.setRequired(false);
		companyRecordIdField.setHidden(false);
		companyRecordIdField.setValueMap(KeyValueManager.getValueMap("company_records"));

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(64);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


//		deleteFlagField = new DataSourceIntegerField("deleteFlag", "是否删除");
//		deleteFlagField.setLength(11);
//		deleteFlagField.setRequired(false);
//		deleteFlagField.setHidden(false);
//		Map map2 =new HashMap<Integer, String>();
//		map2.put(0, "未删除");
//		map2.put(1, "已删除");
//		deleteFlagField.setValueMap(map2);

		setFields(meetingRoomIdField, meetingRoomNameField, siteField, containNumField, meetingmaster, companyRecordIdField, remarkField);
	}


}

