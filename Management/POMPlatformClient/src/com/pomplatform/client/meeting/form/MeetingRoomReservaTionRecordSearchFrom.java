package com.pomplatform.client.meeting.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.meeting.datasource.MeetingInfoBase;
import com.smartgwt.client.docs.Date;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;


/**
 * 会议室预约的查询条件页面
 * @author xiaolong
 */
public class MeetingRoomReservaTionRecordSearchFrom extends SearchForm {
    private final DateItem recordDateItem;
    private final SelectItem meetRoomNameItem;

    public MeetingRoomReservaTionRecordSearchFrom() {

        setWidth100();
        setHeight100();
        setDataSource(MeetingInfoBase.getInstance());

        recordDateItem = new DateItem("recordDate", "会议时间");
        recordDateItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent changedEvent) {
                Date val = (Date) changedEvent.getValue();
                ClientUtil.searchDateFormat((java.util.Date) val, recordDateItem);
            }
        });

        recordDateItem.setWidth("*");
        recordDateItem.setHidden(false);
        meetRoomNameItem = new SelectItem("meetingRoomId", "会议室名称");
        KeyValueManager.loadValueMap("meeting_rooms", meetRoomNameItem);
        meetRoomNameItem.setWidth("*");

        setItems(meetRoomNameItem, recordDateItem);
        setNumCols(4);
        ClientUtil.searchFormProcessAccordingToDevice(this);

    }

    @Override
    public void setHeight(int height) {
        height = 50;
        super.setHeight(height);
    }
}
