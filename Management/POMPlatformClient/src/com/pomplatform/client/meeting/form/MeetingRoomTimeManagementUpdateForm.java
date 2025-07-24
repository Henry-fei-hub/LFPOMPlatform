package com.pomplatform.client.meeting.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.meeting.datasource.DSMeetingRoomTimeManagement;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;

import java.util.HashMap;
import java.util.Map;

public class MeetingRoomTimeManagementUpdateForm extends AbstractWizadPage
{


	private final TextItem meetingRoomTimeIdItem;
//	private final TextItem meetingRoomTimeItem;
	private final TextItem statusItem;
	private final TextItem remarkItem;
	private final SelectItem deleteFlagItem;
	private final DateTimeItem startDateItem;
	private final DateTimeItem endDateItem;

	public MeetingRoomTimeManagementUpdateForm() {
		DSMeetingRoomTimeManagement ds = DSMeetingRoomTimeManagement.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		meetingRoomTimeIdItem = new TextItem("meetingRoomTimeId", "id");
		meetingRoomTimeIdItem.setDisabled(true);
		meetingRoomTimeIdItem.setRequired(true);
		meetingRoomTimeIdItem.hide();
		IsIntegerValidator meetingRoomTimeIdValidator = new IsIntegerValidator();
		meetingRoomTimeIdItem.setValidators(meetingRoomTimeIdValidator);
		__formItems.add(meetingRoomTimeIdItem);
		startDateItem =new DateTimeItem("startDate","开始时间");
		startDateItem.setFormat("HH:mm");
		__formItems.add(startDateItem);
		endDateItem =new DateTimeItem("endDate","结束时间");
		endDateItem.setFormat("HH:mm");
		__formItems.add(endDateItem);
		statusItem = new TextItem("status", "状态");
		statusItem.hide();
		__formItems.add(statusItem);
		remarkItem = new TextItem("remark", "备注");
		__formItems.add(remarkItem);
		deleteFlagItem = new SelectItem("deleteFlag", "是否删除");
		deleteFlagItem.setDefaultValue(0);
		Map map2 =new HashMap<Integer, String>();
		map2.put(0, "未删除");
		map2.put(1, "已删除");
		deleteFlagItem.setValueMap(map2);	
		__formItems.add(deleteFlagItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSMeetingRoomTimeManagement.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		Record record = __form.getValuesAsRecord();
		if(BaseHelpUtils.isNullOrEmpty(record.getAttribute("startDate"))) {
			SC.say("提示","开始时间不能为空");
			return false;
		}
		
		if(BaseHelpUtils.isNullOrEmpty(record.getAttribute("endDate"))) {
			SC.say("提示","结束时间不能为空");
			return false;
		}
		return true;
	}

	@Override
	public Map getValuesAsMap() {
		SC.debugger();
		Record record = __form.getValuesAsRecord();
		String startDate = record.getAttributeAsString("startDate");
		String endDate = record.getAttributeAsString("endDate");
		 Map values = __form.getValues();
		 values.put("meetingRoomTime", startDate+"-"+endDate);
		return values;
	}


}
