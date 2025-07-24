package com.pomplatform.client.meeting.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.meeting.datasource.DSMeetingRoomManagement;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;

import java.util.HashMap;
import java.util.Map;

public class MeetingRoomManagementUpdateForm extends AbstractWizadPage
{
	private final TextItem meetingRoomIdItem;
	private final TextItem meetingRoomNameItem;
	private final TextItem siteItem;
	private final TextItem containNumItem;
	private final ComboBoxItem companyRecordIdItem;
	private final TextItem remarkItem;
	private final SelectItem deleteFlagItem;
	private final TextItem meetingRoomMaster;
	
	public MeetingRoomManagementUpdateForm() {
		DSMeetingRoomManagement ds = DSMeetingRoomManagement.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		meetingRoomIdItem = new TextItem("meetingRoomId", "id");
		meetingRoomIdItem.setDisabled(true);
		meetingRoomIdItem.setRequired(true);
		IsIntegerValidator meetingRoomIdValidator = new IsIntegerValidator();
		meetingRoomIdItem.setValidators(meetingRoomIdValidator);
		meetingRoomIdItem.hide();
		__formItems.add(meetingRoomIdItem);


		meetingRoomNameItem = new TextItem("meetingRoomName", "会议室名称");
		meetingRoomNameItem.setWidth("*");
		__formItems.add(meetingRoomNameItem);

		siteItem = new TextItem("site", "位置");
		siteItem.setWidth("*");
		__formItems.add(siteItem);

		containNumItem = new TextItem("containNum", "容纳人数");
		containNumItem.setWidth("*");
		__formItems.add(containNumItem);

		companyRecordIdItem = new ComboBoxItem("companyRecordId", "归属公司");
		companyRecordIdItem.setWidth("*");
		companyRecordIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		companyRecordIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));	
		__formItems.add(companyRecordIdItem);

		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);

		meetingRoomMaster = new TextItem("meetingRoomMaster","会议室负责人");
		meetingRoomMaster.setWidth("*");
		__formItems.add(meetingRoomMaster);

		deleteFlagItem = new SelectItem("deleteFlag", "是否删除");
		deleteFlagItem.setWidth("*");
		deleteFlagItem.setValueMap();
		Map map2 =new HashMap<Integer, String>();
		map2.put(0, "未删除");
		map2.put(1, "已删除");
		deleteFlagItem.setValueMap(map2);
//		__formItems.add(deleteFlagItem);


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
		manager.setDataSource(DSMeetingRoomManagement.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public Map getValuesAsMap() {
		return __form.getValues();
	}


}
