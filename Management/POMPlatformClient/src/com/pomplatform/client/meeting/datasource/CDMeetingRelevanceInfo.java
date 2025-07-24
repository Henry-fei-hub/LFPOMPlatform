package com.pomplatform.client.meeting.datasource;

import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class CDMeetingRelevanceInfo extends DataSource
{


	public static CDMeetingRelevanceInfo instance = null;

	public static CDMeetingRelevanceInfo getInstance() {
		if(instance == null) {
			instance = new CDMeetingRelevanceInfo("CDMeetingRelevanceInfo");
		}
		return instance;
	}

	private final DataSourceTextField meetingRoomNameField;
	private final DataSourceDateField recordDateField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField meetingRoomIdField;
	private final DataSourceTextField meetingThemeField;

	public CDMeetingRelevanceInfo(String dataSourceID) {

		setID(dataSourceID);
		meetingRoomNameField = new DataSourceTextField("meetingRoomName", "会议室名称");
		meetingRoomNameField.setRequired(false);
		meetingRoomNameField.setLength(255);
		meetingRoomNameField.setHidden(false);

		recordDateField = new DataSourceDateField("recordDate", "操作日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "预约人编码");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		meetingRoomIdField = new DataSourceIntegerField("meetingRoomId", "会议室编码");
		meetingRoomIdField.setRequired(false);
		meetingRoomIdField.setLength(11);
		meetingRoomIdField.setHidden(false);

		meetingThemeField = new DataSourceTextField("meetingTheme", "会议室主题");
		meetingThemeField.setRequired(false);
		meetingThemeField.setLength(255);
		meetingThemeField.setHidden(false);

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


		setFields(meetingRoomNameField, recordDateField, employeeIdField, meetingRoomIdField, meetingThemeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

