package com.pomplatform.client.meeting.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

/**
 * 双击弹出来的页面显示数据
 *
 * @author xiaolong
 */
public class MeetingInfoBase extends DBDataSource {
    public static MeetingInfoBase instance = null;

    public static MeetingInfoBase getInstance() {
        if (instance == null) {
            instance = new MeetingInfoBase("MeetingInfoBase");
        }
        return instance;
    }

    private DataSourceIntegerField meetingRecordChartIdField;
    private DataSourceTextField timeZoneField;
    private DataSourceTextField meetingRoomNameField;
    private DataSourceTextField siteField;
    private DataSourceTextField meetingThemeField;
    private DataSourceTextField statusField;
    private DataSourceDateField recordDateField;
    private DataSourceTextField meetingRoomMasterField;
    private DataSourceIntegerField employeeIdField;
    private DataSourceTextField confreeNamesField;
    private DataSourceTextField meetingStatusField;
    private DataSourceDateField meetingRecordInfo;

    public MeetingInfoBase(String dataSourceID) {
        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_CUSTOM);
        setActionName("MeetingInfoProcessor");

        meetingRecordChartIdField = new DataSourceIntegerField("meetingRecordChartId", "主键编码");
        meetingRecordChartIdField.setLength(32);
        meetingRecordChartIdField.setPrimaryKey(true);
        meetingRecordChartIdField.setRequired(true);
        meetingRecordChartIdField.setHidden(true);

        employeeIdField = new DataSourceIntegerField("employeeId", "预约人姓名");
        employeeIdField.setRequired(false);
        employeeIdField.setHidden(false);
        employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        timeZoneField = new DataSourceTextField("meetingRoomTime", "开始时间-结束时间");
        timeZoneField.setLength(128);
        timeZoneField.setRequired(false);
        timeZoneField.setHidden(false);

        meetingRoomNameField = new DataSourceTextField("meetingRoomName", "会议室名称");
        meetingRoomNameField.setLength(128);
        meetingRoomNameField.setRequired(false);
        meetingRoomNameField.setHidden(false);

        siteField = new DataSourceTextField("site", "会议室地址");
        siteField.setLength(128);
        siteField.setRequired(false);
        siteField.setHidden(false);

        meetingRoomMasterField = new DataSourceTextField("meetingRoomMaster", "会议室管理员");
        meetingRoomMasterField.setLength(128);
        meetingRoomMasterField.setRequired(false);
        meetingRoomMasterField.setHidden(false);

        meetingThemeField = new DataSourceTextField("meetingTheme", "会议主题");
        meetingThemeField.setLength(255);
        meetingThemeField.setRequired(false);
        meetingThemeField.setHidden(true);

        statusField = new DataSourceTextField("status", "会议室状态");
        statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_231"));
        statusField.setLength(255);
        statusField.setRequired(false);
        statusField.setHidden(false);

        confreeNamesField = new DataSourceTextField("confreeNames", "与会成员");
        confreeNamesField.setRequired(false);
        confreeNamesField.setHidden(false);

        meetingStatusField = new DataSourceTextField("meetingStatus", "会议类型");
        meetingStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_253"));
        meetingStatusField.setLength(255);
        meetingStatusField.setRequired(false);
        meetingStatusField.setHidden(false);

        meetingRecordInfo = new DataSourceDateField("meetingTime", "会议时间");
        meetingRecordInfo.setLength(255);
        meetingRecordInfo.setRequired(false);
        meetingRecordInfo.setHidden(false);
        setFields(meetingRecordChartIdField, employeeIdField, meetingRoomNameField, meetingRecordInfo, timeZoneField,
                meetingThemeField, statusField, meetingStatusField);
    }

}
