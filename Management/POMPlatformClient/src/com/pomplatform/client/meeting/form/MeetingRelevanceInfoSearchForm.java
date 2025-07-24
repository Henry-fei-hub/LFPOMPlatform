package com.pomplatform.client.meeting.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.meeting.datasource.CDMeetingRelevanceInfo;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

import java.util.Date;

public class MeetingRelevanceInfoSearchForm extends SearchForm
{


	private final TextItem yearItem;
	private final TextItem monthItem;
	private final TextItem meetingRoomNameItem;
	private final DateItem recordDateItem;
	private final SelectItem employeeIdItem;
	private final TextItem meetingRoomIdItem;
	private final TextItem meetingThemeItem;

	public MeetingRelevanceInfoSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMeetingRelevanceInfo.getInstance());
		yearItem = new TextItem("year", "年");
		monthItem = new TextItem("month", "月");
		meetingRoomNameItem = new TextItem("meetingRoomName", "会议室名称");
		recordDateItem = new DateItem("meetingTime", "创建日期");
		recordDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				ClientUtil.searchDateFormat(val, recordDateItem);
			}
		});
		employeeIdItem = new SelectItem("employeeId", "预约人编码");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		meetingRoomIdItem = new TextItem("meetingRoomId", "会议室编码");
		meetingThemeItem = new TextItem("meetingTheme", "undefined");

		setItems(yearItem, monthItem, meetingRoomNameItem, recordDateItem, employeeIdItem, meetingRoomIdItem, meetingThemeItem);

		setNumCols(14);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
