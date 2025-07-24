package com.pomplatform.client.meeting.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMeetingRoomReservaTionRecordPaymentBase extends DBDataSource {
    public static DSMeetingRoomReservaTionRecordPaymentBase instance = null;

    public static DSMeetingRoomReservaTionRecordPaymentBase getInstance() {
        if (instance == null) {
            instance = new DSMeetingRoomReservaTionRecordPaymentBase("DSMeetingRoomReservaTionRecordPaymentBase");
        }
        return instance;
    }

    private final DataSourceIntegerField meetingRoomIdField;
    private final DataSourceTextField meetingRoomNameField;
    private final DataSourceTextField siteField;
    private final DataSourceTextField containNumField;
    private final DataSourceTextField meetingDateField;
//    private final DataSourceTextField time1Field;
    private final DataSourceTextField time2Field;
    private final DataSourceTextField time3Field;
    private final DataSourceTextField time4Field;
    private final DataSourceTextField time5Field;
    private final DataSourceTextField time6Field;
    private final DataSourceTextField time7Field;
    private final DataSourceTextField time8Field;
    private final DataSourceTextField time9Field;
    private final DataSourceTextField time10Field;
    private final DataSourceTextField time11Field;
    private final DataSourceTextField time12Field;
//    private final DataSourceTextField time13Field;
//    private final DataSourceTextField time14Field;
//    private final DataSourceTextField time15Field;

    public DSMeetingRoomReservaTionRecordPaymentBase(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("MeetingRoomReservaTionRecordPaymentBase");


        meetingRoomIdField = new DataSourceIntegerField("meetingRoomId", "id");
        meetingRoomIdField.setLength(11);
        meetingRoomIdField.setPrimaryKey(true);
        meetingRoomIdField.setRequired(true);
        meetingRoomIdField.setHidden(true);

        meetingRoomNameField = new DataSourceTextField("meetingRoomName", "会议室名称");
        meetingRoomNameField.setLength(128);
        meetingRoomNameField.setRequired(false);
        meetingRoomNameField.setHidden(false);


        siteField = new DataSourceTextField("site", "位置");
        siteField.setImageWidth(50);
        siteField.setLength(128);
        siteField.setRequired(false);
        siteField.setHidden(false);


        containNumField = new DataSourceTextField("containNum", "容纳人数");
        containNumField.setLength(11);
        containNumField.setRequired(false);
        containNumField.setHidden(false);


        meetingDateField = new DataSourceTextField("meetingMonthDate", "日期");
        meetingDateField.setLength(11);
        meetingDateField.setRequired(true);
        meetingDateField.setHidden(false);


//        time1Field = new DataSourceTextField("time1", "07:00-08:00");
//        time1Field.setLength(8);
//        time1Field.setRequired(true);
//        time1Field.setHidden(false);
//        time1Field.setValueMap(KeyValueManager.getValueMap("system_dictionary_231"));


        time2Field = new DataSourceTextField("time2", "08:00-09:00");
        time2Field.setLength(8);
        time2Field.setRequired(true);
        time2Field.setHidden(false);
//        time2Field.setValueMap(KeyValueManager.getValueMap("system_dictionary_231"));

        time3Field = new DataSourceTextField("time3", "09:00-10:00");
        time3Field.setLength(8);
        time3Field.setRequired(true);
        time3Field.setHidden(false);
//        time3Field.setValueMap(KeyValueManager.getValueMap("system_dictionary_231"));

        time4Field = new DataSourceTextField("time4", "10:00-11:00");
        time4Field.setLength(8);
        time4Field.setRequired(true);
        time4Field.setHidden(false);
//        time4Field.setValueMap(KeyValueManager.getValueMap("system_dictionary_231"));

        time5Field = new DataSourceTextField("time5", "11:00-12:00");
        time5Field.setLength(8);
        time5Field.setRequired(true);
        time5Field.setHidden(false);
//        time5Field.setValueMap(KeyValueManager.getValueMap("system_dictionary_231"));

        time6Field = new DataSourceTextField("time6", "12:00-13:00");
        time6Field.setLength(8);
        time6Field.setRequired(true);
        time6Field.setHidden(false);
//        time6Field.setValueMap(KeyValueManager.getValueMap("system_dictionary_231"));

        time7Field = new DataSourceTextField("time7", "13:00-14:00");
        time7Field.setLength(8);
        time7Field.setRequired(true);
        time7Field.setHidden(false);
//        time7Field.setValueMap(KeyValueManager.getValueMap("system_dictionary_231"));

        time8Field = new DataSourceTextField("time8", "14:00-15:00");
        time8Field.setLength(8);
        time8Field.setRequired(true);
        time8Field.setHidden(false);
//        time8Field.setValueMap(KeyValueManager.getValueMap("system_dictionary_231"));

        time9Field = new DataSourceTextField("time9", "15:00-16:00");
        time9Field.setLength(8);
        time9Field.setRequired(true);
        time9Field.setHidden(false);
//        time9Field.setValueMap(KeyValueManager.getValueMap("system_dictionary_231"));

        time10Field = new DataSourceTextField("time10", "16:00-17:00");
        time10Field.setLength(8);
        time10Field.setRequired(true);
        time10Field.setHidden(false);
//        time10Field.setValueMap(KeyValueManager.getValueMap("system_dictionary_231"));

        time11Field = new DataSourceTextField("time11", "17:00-18:00");
        time11Field.setLength(8);
        time11Field.setRequired(true);
        time11Field.setHidden(false);
//        time11Field.setValueMap(KeyValueManager.getValueMap("system_dictionary_231"));

        time12Field = new DataSourceTextField("time12", "18:00-19:00");
        time12Field.setLength(8);
        time12Field.setRequired(true);
        time12Field.setHidden(false);
//        time12Field.setValueMap(KeyValueManager.getValueMap("system_dictionary_231"));

//        time13Field = new DataSourceTextField("time13", "19:00-20:00");
//        time13Field.setLength(8);
//        time13Field.setRequired(true);
//        time13Field.setHidden(false);
//        time13Field.setValueMap(KeyValueManager.getValueMap("system_dictionary_231"));

//        time14Field = new DataSourceTextField("time14", "20:00-21:00");
//        time14Field.setLength(8);
//        time14Field.setRequired(true);
//        time14Field.setHidden(false);
//        time14Field.setValueMap(KeyValueManager.getValueMap("system_dictionary_231"));

//        time15Field = new DataSourceTextField("time15", "21:00-22:00");
//        time15Field.setLength(8);
//        time15Field.setRequired(true);
//        time15Field.setHidden(false);
//        time15Field.setValueMap(KeyValueManager.getValueMap("system_dictionary_231"));

        setFields(meetingRoomIdField, meetingRoomNameField, siteField, containNumField, meetingDateField, time2Field, time3Field, time4Field, time5Field, time6Field, time7Field, time8Field, time9Field, time10Field, time11Field, time12Field);
    }


}

