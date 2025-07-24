package com.pomplatform.client.meeting.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.meeting.datasource.DSMeetingRoomManagement;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

import java.util.Map;

public class MeetingRoomManagementNewForm extends AbstractWizadPage
{


	private final TextItem meetingRoomNameItem;
	private final TextItem siteItem;
	private final TextItem containNumItem;
	private final ComboBoxItem companyRecordIdItem;
	private final TextItem remarkItem;
	private final TextItem meetingRoomMaster;

	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";
	public MeetingRoomManagementNewForm() {
		DSMeetingRoomManagement ds = DSMeetingRoomManagement.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		meetingRoomNameItem = new TextItem("meetingRoomName", shouldNotBeNull+"会议室名称");
		meetingRoomNameItem.setWidth("*");
		__formItems.add(meetingRoomNameItem);


		siteItem = new TextItem("site", shouldNotBeNull+"位置");
		siteItem.setWidth("*");
		__formItems.add(siteItem);


		containNumItem = new TextItem("containNum", shouldNotBeNull+"容纳人数");
		containNumItem.setWidth("*");
		__formItems.add(containNumItem);

		companyRecordIdItem = new ComboBoxItem("companyRecordId", shouldNotBeNull+"归属公司");
		companyRecordIdItem.setWidth("*");
		companyRecordIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		companyRecordIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));	
		__formItems.add(companyRecordIdItem);

		meetingRoomMaster = new TextItem("meetingRoomMaster",shouldNotBeNull+"会议室负责人");
		meetingRoomMaster.setWidth("*");
		__formItems.add(meetingRoomMaster);

		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
		__formItems.add(remarkItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSMeetingRoomManagement.getInstance());
		manager.addMember(__form);
	}

	@Override
	public Map getValuesAsMap() {
		return __form.getValues();
	}


}
