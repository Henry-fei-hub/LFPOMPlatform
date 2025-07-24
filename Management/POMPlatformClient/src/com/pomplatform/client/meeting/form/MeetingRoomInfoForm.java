package com.pomplatform.client.meeting.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.meeting.datasource.MeetingInfoBase;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

import java.util.Map;
import java.util.logging.Logger;

/**
 * 会议室双击弹出的信息显示
 */
public class MeetingRoomInfoForm extends AbstractWizadPage {
    private static final Logger __logger = Logger.getLogger("");
    private final IntegerItem meetingRecodeChartIdItem;
    private final DateTimeItem startTimeItem;
    private final DateTimeItem endTimeItem;
    private final TextItem meetingRoomNameItem;
    private final TextItem siteItem;
    private final TextItem containNumItem;
    private final TextItem meetingRoomMasterItem;
//    private final TextItem confreeNameItem;
    private final TextItem employeeIdItem;
    private final TextItem statusItem;

    public MeetingRoomInfoForm() {
        MeetingInfoBase ds = MeetingInfoBase.getInstance();
        __form.setWidth100();
        __form.setHeight100();

        meetingRecodeChartIdItem = new IntegerItem("meetingRecodeChartId", "主键ID");
        meetingRecodeChartIdItem.setCanEdit(false);
        meetingRecodeChartIdItem.setHidden(true);
        __formItems.add(meetingRecodeChartIdItem);



        startTimeItem = new DateTimeItem("startTime", "开始时间");
        startTimeItem.setWidth("*");
        startTimeItem.setCanEdit(false);
        __formItems.add(startTimeItem);

        endTimeItem = new DateTimeItem("endTime", "结束时间");
        endTimeItem.setWidth("*");
        endTimeItem.setCanEdit(false);
        __formItems.add(endTimeItem);


        meetingRoomNameItem = new TextItem("meetingRoomName", "会议室名称");
        meetingRoomNameItem.setWidth("*");
        meetingRoomNameItem.setCanEdit(false);
        __formItems.add(meetingRoomNameItem);


        siteItem = new TextItem("site", "会议室地址");
        siteItem.setWidth("*");
        siteItem.setCanEdit(false);
        __formItems.add(siteItem);

        containNumItem = new TextItem("containNum", "容纳人数");
        containNumItem.setWidth("*");
        containNumItem.setCanEdit(false);
        __formItems.add(containNumItem);

        meetingRoomMasterItem = new TextItem("meetingRoomMaster", "会议室负责人");
        meetingRoomMasterItem.setWidth("*");
        meetingRoomMasterItem.setCanEdit(false);
        __formItems.add(meetingRoomMasterItem);

        employeeIdItem = new TextItem("employeeId", "预约人");
        employeeIdItem.setWidth("*");
        employeeIdItem.setCanEdit(false);
        __formItems.add(employeeIdItem);

//        confreeNameItem = new TextItem("confreeNames", "与会成员");
//        confreeNameItem.setWidth("*");
//        confreeNameItem.setCanEdit(false);
//        __formItems.add(confreeNameItem);

        statusItem = new TextItem("status", "状态");
        statusItem.setWidth("*");
        statusItem.setCanEdit(false);
        __formItems.add(statusItem);

        __form.setItems(getFormItemArray());
        __form.setDataSource(ds);
        __form.setNumCols(4);
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);
        addMember(__form);

        meetingRoomNameItem.setColSpan(4);
        siteItem.setColSpan(4);
        __form.setDisabled(true);
    }

    @Override
    public Map getValuesAsMap() {
        Map params = __form.getValues();
        return params;
    }

    @Override
    public boolean checkData() {
        return true;
    }

    @Override
    public void startEdit() {
        if (getRecord() != null) {
            Record record = getRecord();
            String idStr = record.getAttribute("ourEmployees");
            if (!BaseHelpUtils.isNullOrEmpty(idStr)) {
                String[] strArra = idStr.split(",");
                record.setAttribute("ourEmployees", strArra);
            }
            __form.editRecord(record);
        } else {
            __form.editNewRecord();
        }
    }
}
