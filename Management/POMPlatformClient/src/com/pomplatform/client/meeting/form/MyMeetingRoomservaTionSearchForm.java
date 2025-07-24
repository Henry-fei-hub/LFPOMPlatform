package com.pomplatform.client.meeting.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.meeting.datasource.CDMeetingRelevanceInfo;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

import java.util.Date;


public class MyMeetingRoomservaTionSearchForm extends SearchForm {
    private final SelectItem meetingRoomNameItem;
    private final DateItem recordDateItem;
    public MyMeetingRoomservaTionSearchForm() {
        setWidth100();
        setHeight100();
        setDataSource(CDMeetingRelevanceInfo.getInstance());

        meetingRoomNameItem = new SelectItem("meetingRoomId", "会议室名称");
        KeyValueManager.loadValueMap("meeting_rooms", meetingRoomNameItem);
        meetingRoomNameItem.setWidth("*");

        recordDateItem = new DateItem("meetingTime", "会议时间");
        recordDateItem.setUseTextField(true);
        recordDateItem.setUseMask(true);
        recordDateItem.setWidth("*");
        recordDateItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                Date val = (Date) event.getValue();
                ClientUtil.searchDateFormat(val, recordDateItem);
            }
        });
        setItems(meetingRoomNameItem, recordDateItem);

        setNumCols(5);
        ClientUtil.searchFormProcessAccordingToDevice(this);
    }

    @Override
    public void setHeight(int height) {
        height = 60;
        super.setHeight(height);
    }


}
