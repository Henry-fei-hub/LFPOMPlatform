package com.pomplatform.client.meeting.panel;

import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.meeting.datasource.MeetingInfoBase;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

import java.util.Map;


/**
 * 会议室主界面入口
 * @author xiaolong
 */
public class MeetingRoomReservaTionRecordDesignPanel extends AbstractWizadPage {
    public MeetingRoomReservaTionRecordDesignPanel() {
        HLayout mainLayout = new HLayout(10);
        mainLayout.setWidth100();
        mainLayout.setHeight100();

        TabSet topTabSet = new TabSet();
        topTabSet.setTabBarPosition(Side.TOP);


        MeetingRoomStatusPanel roomStatusPanel = new MeetingRoomStatusPanel();
        MeetingRoomRecordShiftPanel roomRecordShiftPanel = new MeetingRoomRecordShiftPanel();
        MeetingRoomDateDesignPanel roomDateDesignPanel = new MeetingRoomDateDesignPanel();

        Tab tTab1 = new Tab("会议室预约表", "pieces/16/pawn_green.png");
        tTab1.setPane(roomStatusPanel);

        Tab tTab2 = new Tab("会议室记录表", "pieces/16/pawn_red.png");
        tTab2.setPane(roomRecordShiftPanel);

        Tab tTab3 = new Tab("会议室日历表", "pieces/16/pawn_blue.png");
        tTab3.setPane(roomDateDesignPanel);

        topTabSet.addTab(tTab1);
        topTabSet.addTab(tTab2);
        topTabSet.addTab(tTab3);
        mainLayout.addMember(topTabSet);
        addMember(mainLayout);

    }

    @Override
    public Map getValuesAsMap() {
        Map values = __form.getValues();
        return values;
    }

    @Override
    public void startEdit() {

    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.setDataSource(MeetingInfoBase.getInstance());
        manager.addMember(__form);
    }

    public String getActionName() {
        // 需要根据实际业务修改
        return "ST_Metting";
    }

    @Override
    public boolean checkData() {
        return true;
    }

}
