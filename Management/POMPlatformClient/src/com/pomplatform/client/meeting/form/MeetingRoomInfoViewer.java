package com.pomplatform.client.meeting.form;


import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.DelicacyListGrid;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.meeting.datasource.MeetingInfoBase;
import com.pomplatform.client.meeting.panel.MeetingRoomInfoPanel;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;

import java.util.logging.Logger;

/**
 * 会议室详情（弹出框）
 */
public class MeetingRoomInfoViewer extends HLayout implements HasHandlers {
    private static Logger __logger = Logger.getLogger("MeetingRoomInfoViewer");
    private final DelicacyListGrid ActivityMeetGrid = new DelicacyListGrid(true);
    private HLayout mainLayout;
    @SuppressWarnings("deprecation")
    public void initComponents() {
        mainLayout = new HLayout(10);
        mainLayout.setWidth100();
        mainLayout.setHeight100();

        //设置内容的地方
        ActivityMeetGrid.setDataSource(MeetingInfoBase.getInstance());

        ActivityMeetGrid.setData(Records);
        ActivityMeetGrid.setCanEdit(false);
        ActivityMeetGrid.setShowRowNumbers(true);
        ActivityMeetGrid.setCanRemoveRecords(false);
        ActivityMeetGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                if(!ActivityMeetGrid.anySelected()){
                    SC.say("请选择一条数据进行操作");
                    return;
                }
                final ListGridRecord selected = ActivityMeetGrid.getSelectedRecord();
                MeetingRoomInfoPanel roomInfoPanel = new MeetingRoomInfoPanel();
                roomInfoPanel.setTitle("会议详情");
                roomInfoPanel.addDataEditedHandler(new DataEditedHandler() {
                    @Override
                    public void onDataEdited(DataEditEvent event) {
                        DBDataSource.copyRecord(event.getData(), selected);
                        ActivityMeetGrid.redraw();
                    }
                });
                roomInfoPanel.setRecord(selected);
                roomInfoPanel.initComponents();
                roomInfoPanel.setWidth("40%");
                roomInfoPanel.setHeight("80%");
                roomInfoPanel.startEdit();
                roomInfoPanel.centerInPage();
                roomInfoPanel.show();
            }
        });
        mainLayout.addMember(ActivityMeetGrid);
        addMember(ActivityMeetGrid);
    }
    private Record[]  Records;
    public Record[] getRecords() {
        return Records;
    }
    public void setRecords(Record[] records) {
        Records = records;
    }
}
