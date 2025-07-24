package com.pomplatform.client.check.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSCheckInOutEmployee extends DBDataSource {

    public static DSCheckInOutEmployee instance = null;

    public static DSCheckInOutEmployee getInstance() {
        if (instance == null) {
            instance = new DSCheckInOutEmployee("DSCheckInOutEmployee");
        }
        return instance;
    }

    private final DataSourceIntegerField employeeIdField;
    private final DataSourceTextField employeeNoField;
    private final DataSourceTextField employeeNameField;
    private final DataSourceDateField checkDateField;
    private final DataSourceIntegerField dayOfWeekField;
    private final DataSourceTextField checkInField;
    private final DataSourceTextField checkOutField;
    private final DataSourceIntegerField statusField;
    private final DataSourceFloatField thingHoursField;
    private final DataSourceFloatField thingDaysField;

    private final DataSourceBooleanField finalStatusField;
    private final DataSourceTextField commentsField;

    public DSCheckInOutEmployee(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("Memployeecheckinouteeseor");

        employeeIdField = new DataSourceIntegerField("employeeId", "员工代码");
        employeeIdField.setLength(11);
        employeeIdField.setRequired(false);
        employeeIdField.setHidden(true);
        employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        employeeNoField = new DataSourceTextField("employeeNo", "员工号");
        employeeNoField.setLength(10);
        employeeNoField.setRequired(false);
        employeeNoField.setHidden(true);

        employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
        employeeNameField.setLength(64);
        employeeNameField.setRequired(true);
        employeeNameField.setHidden(true);

        checkDateField = new DataSourceDateField("checkDate", "考勤日期");
        checkDateField.setRequired(false);
        checkDateField.setHidden(false);

        dayOfWeekField = new DataSourceIntegerField("dayOfWeek", "星期");
        dayOfWeekField.setLength(11);
        dayOfWeekField.setRequired(false);
        dayOfWeekField.setHidden(false);
        dayOfWeekField.setValueMap(KeyValueManager.getValueMap("system_dictionary_23"));

        checkInField = new DataSourceTextField("checkIn", "上班");
        checkInField.setLength(20);
        checkInField.setRequired(true);
        checkInField.setHidden(false);

        checkOutField = new DataSourceTextField("checkOut", "下班");
        checkOutField.setLength(20);
        checkOutField.setRequired(true);
        checkOutField.setHidden(false);

        statusField = new DataSourceIntegerField("status", "考勤状态");
        statusField.setLength(11);
        statusField.setRequired(false);
        statusField.setHidden(false);
        statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_22"));

        thingHoursField = new DataSourceFloatField("leaveHours", "请假小时");
        thingHoursField.setLength(10);
        thingHoursField.setDecimalPad(2);
        thingHoursField.setFormat("##,###,##0.00");
        thingHoursField.setRequired(false);
        thingHoursField.setHidden(false);

        thingDaysField = new DataSourceFloatField("leaveDays", "请假天数");
        thingDaysField.setLength(10);
        thingDaysField.setDecimalPad(2);
        thingDaysField.setFormat("##,###,##0.00");
        thingDaysField.setRequired(false);
        thingDaysField.setHidden(false);

        finalStatusField = new DataSourceBooleanField("finalStatus", "正常");
        finalStatusField.setRequired(false);
        finalStatusField.setHidden(false);

        commentsField = new DataSourceTextField("comments", "备注");
        commentsField.setLength(512);
        commentsField.setRequired(false);
        commentsField.setHidden(false);

        setFields(employeeIdField, employeeNoField, employeeNameField, checkDateField, dayOfWeekField, checkInField, checkOutField, statusField, thingHoursField, thingDaysField, finalStatusField, commentsField);
    }

}
