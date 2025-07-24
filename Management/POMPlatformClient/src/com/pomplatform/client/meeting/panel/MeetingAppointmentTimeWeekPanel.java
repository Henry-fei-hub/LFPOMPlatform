package com.pomplatform.client.meeting.panel;

import com.delicacy.client.*;
import com.delicacy.client.data.*;
import com.delicacy.client.ui.DelicacyListGrid;
import com.delicacy.client.ui.LoadingWindow;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.pomplatform.client.employeerescord.datasource.DSEmployee;
import com.smartgwt.client.data.*;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DoubleClickEvent;
import com.smartgwt.client.widgets.events.DoubleClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.util.*;
import java.util.logging.Logger;

/**
 * @author: xiaolong
 * @Date: 2019/8/24 18:44
 */
public class MeetingAppointmentTimeWeekPanel extends DelicacyPanel implements HasHandlers {
    private static final Logger __LOGGER = Logger.getLogger("MeetingRoomRecordPanel的返回值");
    private VLayout allLayout;
    private HLayout meetingLayout;
    private HLayout leftButtonLayout;
    private HLayout leftSearchLayout;
    private VLayout employeeLeftLayout;
    private HLayout employeeLayout;
    private HLayout buttonLayout;
    private HLayout leftGridLayout;
    private HLayout formLayout;
    private TextItem employeeNoItem;
    private TextItem employeeNameItem;
    private IPickTreeItem departmentIdItem;
    private SelectItem plateIdItem;
    private DelicacyListGrid employeeGrid;
    private DynamicForm dateForm;
    private DynamicForm meetingForm;
    private DelicacyListGrid employeeResultGrid;

    private SelectItem meetingRoomNameItem;
    private TextItem meetingThemeItem;

    //星期
    private SelectItem weekSelectItem;
    //开始时间
    private SelectItem wm_startTimeItem;
    //结束时间
    private SelectItem wm_endTimeItem;

    private DateItem meetingDateItemStart;

    private int meetingRelevanceIds;
    private int mstatus;
    private int mmeetingStatus;
    Date myMeetingTime;

    public void MeetingRoomRecordWeek(int status, int meetingStatus, int meetingRelevanceId, int meetingRoomId,
                                      String meetingTheme, int startTime, int endTime, int weekTime, Date meetingTime) {
        meetingRelevanceIds = meetingRelevanceId;
        mstatus = status;
        meetingRoomNameItem.setValue(meetingRoomId);
        meetingThemeItem.setValue(meetingTheme);
        wm_startTimeItem.setValue(startTime);
        wm_endTimeItem.setValue(endTime);
        mmeetingStatus = meetingStatus;
        weekSelectItem.setValue(weekTime);
        myMeetingTime = meetingTime;
    }

    @Override
    public Canvas getViewPanel() {
        allLayout = new VLayout(10);
        allLayout.setWidth100();
        allLayout.setHeight100();

        meetingLayout = new HLayout(10);
        meetingLayout.setWidth100();
        meetingLayout.setHeight("3%");
        meetingLayout.setLayoutMargin(5);

        employeeLayout = new HLayout(10);
        employeeLayout.setWidth100();
        employeeLayout.setHeight("48%");
        employeeLayout.setLayoutMargin(10);

        buttonLayout = new HLayout(10);
        buttonLayout.setWidth100();
        buttonLayout.setHeight("4%");
        buttonLayout.setAlign(Alignment.RIGHT);
        buttonLayout.setLayoutMargin(10);
        buttonLayout.setMembersMargin(10);

        leftSearchLayout = new HLayout(10);
        leftSearchLayout.setWidth100();
        leftSearchLayout.setHeight("3%");

        employeeLeftLayout = new VLayout(10);
        employeeLeftLayout.setWidth100();
        employeeLeftLayout.setHeight100();

        leftGridLayout = new HLayout(10);
        leftGridLayout.setWidth100();
        leftGridLayout.setHeight("97%");

        leftButtonLayout = new HLayout(10);
        leftButtonLayout.setWidth("2%");
        leftButtonLayout.setHeight100();
        leftButtonLayout.setLayoutTopMargin(30);

        formLayout = new HLayout(10);
        formLayout.setWidth("98%");
        formLayout.setHeight100();

        meetingRoomNameItem = new SelectItem("meetingRoomId", "会议室名称");
        KeyValueManager.loadValueMap("meeting_rooms", meetingRoomNameItem);
        meetingRoomNameItem.setWidth("*");

        meetingThemeItem = new TextItem("meetingTheme", "会议主题");
        meetingThemeItem.setValueMap(KeyValueManager.getValueMap("meeting_theme"));
        meetingThemeItem.setWidth("*");

        wm_startTimeItem = new SelectItem("wm_startTime", "开始时间");
        wm_startTimeItem.setWidth("*");
        wm_startTimeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_232"));

        wm_endTimeItem = new SelectItem("wm_endTime", "结束时间");
        wm_endTimeItem.setWidth("*");
        wm_endTimeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_232"));


        weekSelectItem = new SelectItem("weekSelect", "周例会时间");
        weekSelectItem.setWidth("*");
        weekSelectItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_23"));
        weekSelectItem.setHidden(true);

        meetingDateItemStart = new DateItem("startDate", "开始日期");
        meetingDateItemStart.setWidth("*");
        meetingDateItemStart.setUseTextField(true);
        meetingDateItemStart.setDisabled(true);
        meetingDateItemStart.setDefaultValue(new Date());
        meetingDateItemStart.setUseMask(true);
        meetingDateItemStart.setHidden(true);


        meetingForm = new DynamicForm();
        meetingForm.setWidth100();
        meetingForm.setHeight100();
        meetingForm.setNumCols(4);
        meetingForm.setMargin(10);

        /**
         * 显示form表单
         */
        meetingForm.setItems(meetingRoomNameItem, meetingThemeItem, wm_startTimeItem, wm_endTimeItem, weekSelectItem, meetingDateItemStart);
        meetingLayout.addMember(meetingForm);

        employeeNoItem = new TextItem("employeeNo", "与会员工编号");
        employeeNameItem = new TextItem("employeeName", "与会员工姓名");
        departmentIdItem = new IPickTreeItem("departmentId", "归属部门");
        departmentIdItem.setCanSelectParentItems(true);
        departmentIdItem.setValueField("treeId");
        departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));

        plateIdItem = new SelectItem("plateId", "业务部门");
        plateIdItem.setAllowEmptyValue(true);
        plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));

        dateForm = new DynamicForm();
        dateForm.setTitleAlign(Alignment.LEFT);
        dateForm.setTitleOrientation(TitleOrientation.TOP);
        dateForm.setWidth100();
        dateForm.setHeight100();
        dateForm.setNumCols(8);
        dateForm.setMargin(10);
        dateForm.setItems(employeeNoItem, employeeNameItem, plateIdItem, departmentIdItem);
        formLayout.addMember(dateForm);
        leftSearchLayout.addMember(formLayout);

        IButton searchButton = new IButton("搜索");
        leftButtonLayout.addMember(searchButton);
        leftSearchLayout.addMember(leftButtonLayout);
        employeeLeftLayout.addMember(leftSearchLayout);

        //搜索可以添加的员工
        searchButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                loadEmployee();
            }
        });

        employeeGrid = new DelicacyListGrid();
        employeeGrid.setShowRowNumbers(true);
        employeeGrid.setAutoFitFieldWidths(false);

        int index = 0;
        ListGridField[] fields = new ListGridField[5];
        fields[index] = new ListGridField("employeeId");
        fields[index].setShowGridSummary(false);
        index++;
        fields[index] = new ListGridField("employeeNo");
        fields[index].setShowGridSummary(false);
        index++;
        fields[index] = new ListGridField("employeeName");
        fields[index].setShowGridSummary(false);
        index++;
        fields[index] = new ListGridField("departmentId");
        index++;
        fields[index] = new ListGridField("plateId");
        employeeGrid.setDataSource(DSEmployee.getInstance());
        employeeGrid.setFields(fields);
        employeeGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);
        leftGridLayout.addMember(employeeGrid);
        employeeLeftLayout.addMember(leftGridLayout);
        employeeLayout.addMember(employeeLeftLayout);

        TransferImgBt addToButton2 = new TransferImgBt(TransferImgBt.RIGHT);
        employeeLayout.addMember(addToButton2);

        addToButton2.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (!employeeGrid.anySelected()) {
                    return;
                }
                addSelectedEmployeeToTarget(employeeGrid, employeeResultGrid);
            }
        });

        employeeGrid.addDoubleClickHandler(new DoubleClickHandler() {
            @Override
            public void onDoubleClick(DoubleClickEvent event) {
                addSelectedEmployeeToTarget(employeeGrid, employeeResultGrid);
            }
        });

        employeeResultGrid = new DelicacyListGrid();
        employeeResultGrid.setShowRowNumbers(true);
        employeeResultGrid.setAutoFitFieldWidths(false);
        index = 0;
        fields = new ListGridField[5];
        fields[index] = new ListGridField("employeeId");
        fields[index].setShowGridSummary(false);
        index++;
        fields[index] = new ListGridField("employeeNo");
        fields[index].setShowGridSummary(false);
        index++;
        fields[index] = new ListGridField("employeeName");
        fields[index].setShowGridSummary(false);
        index++;
        fields[index] = new ListGridField("departmentId");
        index++;
        fields[index] = new ListGridField("plateId");
        employeeResultGrid.setDataSource(DSEmployee.getInstance());
        employeeResultGrid.setFields(fields);
        employeeResultGrid.setShowRowNumbers(true);
        employeeResultGrid.setCanRemoveRecords(true);
        employeeLayout.addMember(employeeResultGrid);

        IButton saveButton = new IButton("保存");
        saveButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {

                /**
                 *  将相应的字段插入到会议室记录中
                 */
                Map<String, Object> param = new HashMap<>(0);

                if (!BaseHelpUtils.isNullOrEmpty(weekSelectItem.getValue())) {
                    param.put("weekSelect", weekSelectItem.getValue());
                } else {
                    SC.say("周例会时间不能为空");
                }

                if (!BaseHelpUtils.isNullOrEmpty(wm_startTimeItem.getValue())) {
                    param.put("wmStartTime", wm_startTimeItem.getValue());
                } else {
                    SC.say("开始时间不能为空");
                }

                if (!BaseHelpUtils.isNullOrEmpty(wm_endTimeItem.getValue())) {
                    param.put("wmEndTime", wm_endTimeItem.getValue());
                } else {
                    SC.say("结束时间不能为空");
                }

                if (!BaseHelpUtils.isNullOrEmpty(meetingThemeItem.getValue())) {
                    param.put("meetingTheme", meetingThemeItem.getValue());
                } else {
                    SC.say("会议主题不能为空");
                }

                if (!BaseHelpUtils.isNullOrEmpty(meetingRoomNameItem.getValue())) {
                    param.put("meetingRoomId", meetingRoomNameItem.getValue());
                } else {
                    SC.say("会议室不能为空");
                }
                param.put("employeeId", ClientUtil.getEmployeeId());
                param.put("status", 1);
                param.put("recordDate", new Date());

                //设置要下发的人员列表
                MapUtils.convertRecordToMap(employeeResultGrid.getDataSource(), employeeResultGrid.getRecords(), param,
                        "detailConfree");
                int startTime = Integer.parseInt(wm_startTimeItem.getValue().toString());
                int endTime = Integer.parseInt(wm_endTimeItem.getValue().toString());

                __LOGGER.info("startTime" + startTime + "endTime" + endTime);


                if (startTime >= endTime) {
                    SC.say("结束时间不能小于或等于开始时间");
                } else {
                    final LoadingWindow loading = new LoadingWindow();
                    saveButton.setDisabled(true);
                    param.put("status", mstatus);
                    param.put("meetingStatus", mmeetingStatus);
                    param.put("meetingTime", myMeetingTime);
                    param.put("meetingRelevanceId", meetingRelevanceIds);
                    param.put("optType", "updateMeetingRecord");
                    DBDataSource.callOperation("EP_MeetingInfoProcessor", param, new DSCallback() {
                        @Override
                        public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
                            saveButton.setDisabled(false);
                            loading.destroy();
                            if (dsResponse.getStatus() >= 0) {
                                SC.say("保存成功");
                                getParentWindow().destroy();
                                DataEditEvent dee = new DataEditEvent();
                                fireEvent(dee);
                            } else {
                                SC.say(dsResponse.getErrors().get("errorMsg").toString());
                            }
                        }
                    });
                }
            }
        });


        IButton cancelButton = new IButton("取消");
        cancelButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                getParentWindow().destroy();
            }
        });
        buttonLayout.addMember(saveButton);
        buttonLayout.addMember(cancelButton);
        allLayout.addMember(meetingLayout);
        allLayout.addMember(employeeLayout);
        allLayout.addMember(buttonLayout);
        return allLayout;

    }

    /**
     * 加载所有的与会成员的数据,然后填充到右边
     */
    public void loadConfrees() {

        Map<String, Object> param = new HashMap<>(0);
        param.put("meetingRelevanceId", meetingRelevanceIds);
        param.put("optType", "getMeetingConfrees");
        DBDataSource.callOperation("EP_MeetingInfoProcessor", param, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    employeeResultGrid.setData(dsResponse.getData());
                } else {
                    SC.say(dsResponse.getErrors().get("errorMsg").toString());
                }
            }
        });
    }


    //加载员工信息
    @SuppressWarnings("rawtypes")
    public void loadEmployee() {
        Map<String, Object> param = new HashMap<>();
        param.put("status", 0);
        if (!BaseHelpUtils.isNullOrEmpty(employeeNoItem.getValue())) {
            param.put("employeeNo", employeeNoItem.getValue());
        }
        if (!BaseHelpUtils.isNullOrEmpty(employeeNameItem.getValue())) {
            param.put("employeeName", employeeNameItem.getValue());
        }
        if (!BaseHelpUtils.isNullOrEmpty(departmentIdItem.getValue())) {
            param.put("departmentId", departmentIdItem.getValue());
        }
        if (!BaseHelpUtils.isNullOrEmpty(plateIdItem.getValue())) {
            param.put("plateId", plateIdItem.getValue());
        }

        List<Map> keyvalues = new ArrayList<>();
        Map<String, String> kv = new HashMap<>();
        kv.put("key", "(EXTRACT(YEAR from onboard_date))");
        kv.put("value", "1");
        keyvalues.add(kv);

        Map<String, String> kv1 = new HashMap<>();
        kv1.put("key", "(EXTRACT(MONTH from onboard_date))");
        kv1.put("value", "1");
        keyvalues.add(kv1);

        Map<String, String> kv2 = new HashMap<>();
        kv2.put("key", "(EXTRACT(YEAR from resignation_date))");
        kv2.put("value", "1");
        keyvalues.add(kv2);

        Map<String, String> kv3 = new HashMap<>();
        kv3.put("key", "(EXTRACT(MONTH from resignation_date))");
        kv3.put("value", "1");
        keyvalues.add(kv3);

        Map<String, String> kv4 = new HashMap<>();
        kv4.put("key", "(EXTRACT(MONTH from birth))");
        kv4.put("value", "1");
        keyvalues.add(kv4);

        param.put("keyValues", keyvalues);
        DBDataSource.callOperation("NQ_Memployee", "find", param, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    employeeGrid.setData(dsResponse.getData());
                    employeeGrid.redraw();
                }
            }
        });
    }


    //添加要下发的人员
    private void addSelectedEmployeeToTarget(ListGrid source, ListGrid target) {
        ListGridRecord[] selectedRecords = source.getSelectedRecords();
        RecordList originalList = target.getDataAsRecordList();
        int originalLength = originalList.getLength();
        RecordList newList = new RecordList();
        if (originalLength > 0) {
            newList.addList(originalList.getRange(0, originalLength));
        }
        for (ListGridRecord selectedRecord : selectedRecords) {
            Map<String, Object> searchMap = new HashMap<>();
            searchMap.put("employeeId", selectedRecord.getAttribute("employeeId"));
            searchMap.put("employeeNo", selectedRecord.getAttribute("employeeNo"));
            searchMap.put("employeeName", selectedRecord.getAttribute("employeeName"));
            searchMap.put("departmentId", selectedRecord.getAttribute("departmentId"));
            searchMap.put("plateId", selectedRecord.getAttribute("plateId"));
            if (originalLength > 0) {
                int index = originalList.findIndex(searchMap);
                if (index != -1) {
                    continue;
                }
            }
            newList.add(new Record(searchMap));
        }
        target.setData(newList);
    }

    public class Factory implements PanelFactory {
        private String id;

        @Override
        public Canvas create() {
            MeetingAppointmentTimeWeekPanel cm = new MeetingAppointmentTimeWeekPanel();
            id = cm.getID();
            return cm;
        }

        @Override
        public String getID() {
            return id;
        }

        @Override
        public String getDescription() {
            return "clockList";
        }
    }

    private PopupWindow parentWindow;

    public PopupWindow getParentWindow() {
        return parentWindow;
    }

    public void setParentWindow(PopupWindow parentWindow) {
        this.parentWindow = parentWindow;
    }


    protected final HandlerManager handlerManager = new HandlerManager(this);
    protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

    @Override
    public void fireEvent(GwtEvent<?> event) {
        handlerManager.fireEvent(event);
    }

    public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
        return handlerManager.addHandler(DataEditEvent.TYPE, handler);
    }


}
