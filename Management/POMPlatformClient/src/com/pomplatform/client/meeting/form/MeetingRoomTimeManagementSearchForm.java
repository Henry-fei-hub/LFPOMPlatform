package com.pomplatform.client.meeting.form;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.meeting.datasource.CDMeetingRoomTimeManagement;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

import java.util.HashMap;
import java.util.Map;

public class MeetingRoomTimeManagementSearchForm extends SearchForm
{
	private final TextItem meetingRoomTimeItem;
	private final TextItem remarkItem;
	private final TextItem meetingRoomTimeIdItem;
	private final TextItem statusItem;
	private final SelectItem deleteFlagItem;

	public MeetingRoomTimeManagementSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMeetingRoomTimeManagement.getInstance());
		meetingRoomTimeItem = new TextItem("meetingRoomTime", "时间区间");
		meetingRoomTimeItem.hide();
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
		meetingRoomTimeIdItem = new TextItem("meetingRoomTimeId", "id");
		meetingRoomTimeIdItem.hide();
		statusItem = new TextItem("status", "状态");
		statusItem.hide();
		deleteFlagItem = new SelectItem("deleteFlag", "是否删除");
		deleteFlagItem.setWidth("*");
		deleteFlagItem.setDefaultValue(0);
		Map map2 =new HashMap<Integer, String>();
		map2.put(0, "未删除");
		map2.put(1, "已删除");
		deleteFlagItem.setValueMap(map2);	

		setItems(meetingRoomTimeItem, remarkItem, meetingRoomTimeIdItem, statusItem, deleteFlagItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
