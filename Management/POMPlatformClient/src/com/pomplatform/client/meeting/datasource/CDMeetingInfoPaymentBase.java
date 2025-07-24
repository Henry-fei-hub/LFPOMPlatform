package com.pomplatform.client.meeting.datasource;

import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class CDMeetingInfoPaymentBase extends DataSource {


    public static CDMeetingInfoPaymentBase instance = null;

    public static CDMeetingInfoPaymentBase getInstance() {
        if (instance == null) {
            instance = new CDMeetingInfoPaymentBase("CDMeetingInfoPaymentBase");
        }
        return instance;
    }

    private final DataSourceFloatField yearField;
    private final DataSourceFloatField monthField;
    private final DataSourceDateField recordDateField;
    private final DataSourceIntegerField employeeIdField;
    private final DataSourceIntegerField meetingRoomIdField;
    private final DataSourceTextField meetingThemeField;

    public CDMeetingInfoPaymentBase(String dataSourceID) {

        setID(dataSourceID);
        yearField = new DataSourceFloatField("year", "年");
        yearField.setRequired(true);
        yearField.setLength(0);
        yearField.setHidden(false);

        monthField = new DataSourceFloatField("month", "月");
        monthField.setRequired(true);
        monthField.setLength(0);
        monthField.setHidden(false);

        recordDateField = new DataSourceDateField("recordDate", "创建日期");
        recordDateField.setRequired(false);
        recordDateField.setHidden(false);

        employeeIdField = new DataSourceIntegerField("employeeId", "预约人编码");
        employeeIdField.setRequired(true);
        employeeIdField.setLength(11);
        employeeIdField.setHidden(false);
        employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        meetingRoomIdField = new DataSourceIntegerField("meetingRoomId", "会议室编码");
        meetingRoomIdField.setRequired(true);
        meetingRoomIdField.setLength(11);
        meetingRoomIdField.setHidden(false);

        meetingThemeField = new DataSourceTextField("meetingTheme", "会议主题");
        meetingThemeField.setRequired(false);
        meetingThemeField.setLength(255);
        meetingThemeField.setHidden(false);

        DataSourceIntegerField currentPageField
                = new DataSourceIntegerField("currentPage", "当前页");
        currentPageField.setRequired(true);
        currentPageField.setLength(10);
        currentPageField.setHidden(true);

        DataSourceIntegerField pageLinesField
                = new DataSourceIntegerField("pageLines", "每页行数");
        pageLinesField.setRequired(true);
        pageLinesField.setLength(10);
        pageLinesField.setHidden(true);


        setFields(yearField, monthField, recordDateField, employeeIdField, meetingRoomIdField, meetingThemeField, currentPageField, pageLinesField);

        setClientOnly(true);
    }


}

