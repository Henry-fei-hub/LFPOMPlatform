package com.pomplatform.client.meeting.form;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.SC;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NewMeetingRoomReservationForm extends GenericWizadWindow {

    @Override
    public String getActionName() {

        // 需要根据实际业务修改
        return "EP_MeetingRoomProcessor";

    }

    @Override
    public String getSubaction() {
        return "find";
    }

    @Override
    public boolean checkData(Map data) {

        data.put("optType","reserveMeetingReservationRoom");

        data.put("optType", "reserveMeetingRoom");
        boolean status = true;
        for (AbstractWizadPage wp : __pages) {
            if (!wp.checkData()) {
                status = false;
            }
        }
        return status;
    }

    @Override
    public int getPageCount() {
        return 1;
    }

    @Override
    public List<AbstractWizadPage> getPages() {
        setCallback(new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    //会议室预约成功之后，发送一条消息
                    SC.say("会议室预约成功，请在会议开始前确认，否则会议室将作废");
                }
            }
        });


        List<AbstractWizadPage> res = new ArrayList<>();
        res.add(new MeetingRoomReservationNewForm());
        return res;
    }

}

