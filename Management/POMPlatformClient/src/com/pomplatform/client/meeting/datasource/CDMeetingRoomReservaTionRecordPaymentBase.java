package com.pomplatform.client.meeting.datasource;

import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

public class CDMeetingRoomReservaTionRecordPaymentBase extends DataSource
{


	public static CDMeetingRoomReservaTionRecordPaymentBase instance = null;

	public static CDMeetingRoomReservaTionRecordPaymentBase getInstance() {
		if(instance == null) {
			instance = new CDMeetingRoomReservaTionRecordPaymentBase("CDMeetingRoomReservaTionRecordPaymentBase");
		}
		return instance;
	}

	private final DataSourceDateField meetingDateField;
	private final DataSourceIntegerField employeeIdField;

	public CDMeetingRoomReservaTionRecordPaymentBase(String dataSourceID) {

		setID(dataSourceID);
		meetingDateField = new DataSourceDateField("meetingDate", "日期");
		meetingDateField.setRequired(false);
		meetingDateField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "预约人id");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

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


		setFields(meetingDateField, employeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

