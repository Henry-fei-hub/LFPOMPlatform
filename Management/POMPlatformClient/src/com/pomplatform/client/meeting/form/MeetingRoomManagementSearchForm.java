package com.pomplatform.client.meeting.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.meeting.datasource.CDMeetingRoomManagement;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

import java.util.HashMap;
import java.util.Map;

public class MeetingRoomManagementSearchForm extends SearchForm
{
	private final SelectItem meetingRoomNameItem;
	private final TextItem remarkItem;
	private final SelectItem statusItem;
	private final ComboBoxItem companyRecordIdItem;
	private final SelectItem deleteFlagItem;

	public MeetingRoomManagementSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMeetingRoomManagement.getInstance());

		meetingRoomNameItem = new SelectItem("meetingRoomId", "会议室名称");
		KeyValueManager.loadValueMap("meeting_rooms", meetingRoomNameItem);
		meetingRoomNameItem.setWidth("*");

		statusItem = new SelectItem("status", "状态");
		statusItem.setWidth("*");
		Map map1 =new HashMap<Integer, String>();
		map1.put(0, "待预约");
		map1.put(1, "使用中");
		statusItem.setValueMap(map1);
		companyRecordIdItem = new ComboBoxItem("companyRecordId", "归属公司");
		companyRecordIdItem.setWidth("*");
		companyRecordIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		companyRecordIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));	
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
		deleteFlagItem = new SelectItem("deleteFlag", "是否删除");
		deleteFlagItem.setWidth("*");
		deleteFlagItem.setDefaultValue(0);
		Map map2 =new HashMap<Integer, String>();
		map2.put(0, "未删除");
		map2.put(1, "已删除");
		deleteFlagItem.setValueMap(map2);	
		setItems(companyRecordIdItem,meetingRoomNameItem, remarkItem);

		setNumCols(11);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
