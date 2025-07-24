package com.pomplatform.client.meeting.panel;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.pomplatform.client.meeting.form.MeetingRoomInfoViewer;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceSequenceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.util.DateUtil;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.client.widgets.calendar.events.DateChangedEvent;
import com.smartgwt.client.widgets.calendar.events.DateChangedHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.layout.HLayout;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 会议室日历表
 *
 * @author xiaolong
 */
public class MeetingRoomDateDesignPanel extends AbstractWizadPage {
    private final Logger logger = Logger.getLogger("MeetingRoomDateDesignPanel");
    private HLayout mainLayout;
    private DataSource eventDS;
    private Calendar calendar;

    public MeetingRoomDateDesignPanel() {

        mainLayout = new HLayout(10);
        mainLayout.setWidth100();
        mainLayout.setHeight100();
        eventDS = new DataSource();

        DataSourceSequenceField eventIdField = new DataSourceSequenceField("meetingRecordChartId");
        eventIdField.setPrimaryKey(true);

        DataSourceTextField descField = new DataSourceTextField("meetingTheme");
        DataSourceDateTimeField startDateField = new DataSourceDateTimeField("startTime");
        DataSourceDateTimeField endDateField = new DataSourceDateTimeField("endTime");
        DataSourceTextField viewTitleField = new DataSourceTextField("viewTitle");
        viewTitleField.setHidden(true);

        eventDS.setFields(descField, eventIdField, startDateField, endDateField);
        eventDS.setClientOnly(true);
        eventDS.setTitleField("viewTitle");

        calendar = new Calendar();
        calendar.setAutoFetchData(false);
        calendar.setShowWeekView(false);
        calendar.setShowDayView(false);

        calendar.setEventNameFieldTitle("会议主题");
        calendar.setEventStartDateFieldTitle("开始时间");
        calendar.setEventEndDateFieldTitle("结束时间");
        calendar.setSaveButtonTitle("保存");
        calendar.setDataSource(eventDS);

        calendar.setStartDateField("startTime");
        calendar.setEndDateField("endTime");
        calendar.setCanRemoveEvents(false);
        //设置不能编辑，取消初始化事件
        calendar.setCanEditEvents(false);
        calendar.setCanCreateEvents(false);

        calendar.addDateChangedHandler(new DateChangedHandler() {
            @Override
            public void onDateChanged(DateChangedEvent event) {
                getRecords();
            }
        });

        //双击弹出显示框
        calendar.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                getDetailsRecords();
            }
        });
        mainLayout.addMember(calendar);
        addMember(mainLayout);
    }

    /**
     * 填充记录
     */
    public void getRecords() {
        Date chosenDate = calendar.getChosenDate();
        DateTimeFormat dfYear = DateTimeFormat.getFormat("yyyy");
        String year = dfYear.format(chosenDate);
        DateTimeFormat dfMonth = DateTimeFormat.getFormat("MM");
        String month = dfMonth.format(chosenDate);
        DateTimeFormat dfDay = DateTimeFormat.getFormat("HH");
        String day = dfDay.format(chosenDate);
        Map<String, Object> param = new HashMap<>(0);

        param.put("year", year);
        param.put("month", month);
        param.put("flagStatus",1);
        param.put("optType", "getMeetingAndEmployeeInformation");
        param.put("userId", ClientUtil.getUserId());
        DBDataSource.callOperation("EP_MeetingInfoProcessor", "find", param, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    String meetTheme = "";
                    String meetingRoomName = "";
                    String site = "";
                    String endTime = "";
                    String meetingRoomMaster = "";
                    String employeeId = "";
                    Record[] records = dsResponse.getData();

                    if (records.length > 0) {

                        for (Record r : records) {
                            if (!BaseHelpUtils.isNullOrEmpty(r.getAttribute("meetingTheme"))) {
                                meetTheme = r.getAttribute("meetingTheme");
                            }

                            if (!BaseHelpUtils.isNullOrEmpty(r.getAttribute("meetingRoomName"))) {
                                meetingRoomName = r.getAttribute("meetingRoomName");
                            }

                            if (!BaseHelpUtils.isNullOrEmpty(r.getAttribute("site"))) {
                                site = r.getAttribute("site");
                            }

                            if (!BaseHelpUtils.isNullOrEmpty(r.getAttribute("endTime"))) {
                                Date d = r.getAttributeAsDate("endTime");
                                endTime = DateUtil.format(d, "HH:mm");
                            }

                            if (!BaseHelpUtils.isNullOrEmpty(r.getAttribute("meetingRoomMaster"))) {
                                meetingRoomMaster = r.getAttribute("meetingRoomMaster");
                            }

                            if (!BaseHelpUtils.isNullOrEmpty(r.getAttribute("employeeId"))) {
                                employeeId = r.getAttribute("employeeId");
                                employeeId = KeyValueManager.getValue("employees", employeeId);
                            }

                            r.setAttribute("viewTitle", "- " + endTime + "<br/>会议主题：" + meetTheme + "<br/>会议室名称：" + meetingRoomName +
                                    "<br/>会议室地址：" + site + "<br/>会议室负责人：" + meetingRoomMaster + "<br/>预约人：" + employeeId + "<br/>________________________<br/>");
                        }
                        eventDS.setTestData(records);
                        calendar.setData(records);
                        calendar.redraw();
                    }
                } else {
                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                }
            }
        });
    }

    /**
     * 双击弹出显示信息的弹框
     */
    public void getDetailsRecords() {
        Date chosenDate = calendar.getChosenDate();
        DateTimeFormat dfYear = DateTimeFormat.getFormat("yyyy");
        String year = dfYear.format(chosenDate);
        DateTimeFormat dfMonth = DateTimeFormat.getFormat("MM");
        String month = dfMonth.format(chosenDate);

        Map<String, Object> param = new HashMap<>(0);
        param.put("recordDate", chosenDate);

        param.put("optType", "getMeetingAndEmployeeInformation");
        param.put("flagStatus",1);
        param.put("userId", ClientUtil.getUserId());
        DBDataSource.callOperation("EP_MeetingInfoProcessor", "find", param, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    Record[] records = dsResponse.getData();
                    if (records.length > 0) {
                        if (records.length == 1) {
                            GWT.runAsync(new RunAsyncCallback() {
                                @Override
                                public void onFailure(Throwable reason) {
                                    SC.say("failure to download");
                                }

                                @Override
                                public void onSuccess() {
                                    MeetingRoomInfoPanel roomInfoPanel = new MeetingRoomInfoPanel();
                                    roomInfoPanel.setTitle("会议详情");
                                    roomInfoPanel.setSearchForm(searchForm);
                                    roomInfoPanel.setRecord(records[0]);
                                    roomInfoPanel.initComponents();
                                    roomInfoPanel.startEdit();
                                    roomInfoPanel.setWidth("80%");
                                    roomInfoPanel.setHeight("80%");
                                    roomInfoPanel.centerInPage();
                                    roomInfoPanel.show();
                                }
                            });
                        } else {
                            /**
                             * 双击弹出窗口显示信息
                             */
                            PopupWindow pw = new PopupWindow();
                            MeetingRoomInfoViewer roomInfoPanel = new MeetingRoomInfoViewer();
                            pw.addItem(roomInfoPanel);
                            roomInfoPanel.setRecords(records);
                            roomInfoPanel.initComponents();
                            pw.setTitle("会议详情");
                            pw.setWidth("80%");
                            pw.setHeight("80%");
                            pw.centerInPage();
                            pw.show();
                        }

                    }
                }
            }
        });
    }

    @Override
    public void startEdit() {
    }

    @Override
    public void setValueManage(ValuesManager manager) {
        manager.addMember(__form);
    }

    @Override
    public boolean checkData() {
        return true;
    }

    @Override
    public Map getValuesAsMap() {
        Map values = __form.getValues();
        return values;
    }

    public String getActionName() {
        // 需要根据实际业务修改
        return "ST_Meeting";
    }

}
