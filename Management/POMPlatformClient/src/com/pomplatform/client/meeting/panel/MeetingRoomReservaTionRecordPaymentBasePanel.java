package com.pomplatform.client.meeting.panel;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.widgets.Canvas;

import java.util.logging.Logger;

/**
 * 会议室预约的功能模块界面MeetingRoomReservaTionRecordPaymentBase
 * @author xiaolong
 */
public class MeetingRoomReservaTionRecordPaymentBasePanel extends DelicacyPanel {

    private static Logger __logger = Logger.getLogger("");

    /**
     * 会议室预约的展示界面
     */
    protected MeetingRoomReservaTionRecordDesignPanel detailForm;

    @Override
    public Canvas getViewPanel() {
        detailForm = new MeetingRoomReservaTionRecordDesignPanel();
        detailForm.setKeepInParentRect(true);
        return detailForm;
    }

    public static class Factory implements PanelFactory{
        private  String id;

        @Override
        public Canvas create() {

            MeetingRoomReservaTionRecordPaymentBasePanel mp= new MeetingRoomReservaTionRecordPaymentBasePanel();
            id=mp.getID();
            return mp;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "MeetingRoomReservaTionRecordPaymentBasePanel";
        }
    }

}

