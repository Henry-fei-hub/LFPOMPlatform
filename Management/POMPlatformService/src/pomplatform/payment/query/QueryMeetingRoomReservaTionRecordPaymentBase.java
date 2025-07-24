package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseMeetingRoomReservaTionRecordPaymentBase;
import pomplatform.payment.bean.ConditionMeetingRoomReservaTionRecordPaymentBase;

public class QueryMeetingRoomReservaTionRecordPaymentBase extends AbstractQuery<BaseMeetingRoomReservaTionRecordPaymentBase, ConditionMeetingRoomReservaTionRecordPaymentBase> {

    private static final Logger __logger = Logger.getLogger(QueryMeetingRoomReservaTionRecordPaymentBase.class);

    public QueryMeetingRoomReservaTionRecordPaymentBase() throws java.sql.SQLException {
        setParameterNumber(5);
        setConnection(ThreadConnection.getConnection());
        setOrderByFields("A .meeting_room_id");
    }

    @Override
    public BaseCollection<BaseMeetingRoomReservaTionRecordPaymentBase> executeQuery(KeyValuePair[] replacements, ConditionMeetingRoomReservaTionRecordPaymentBase condition) throws java.sql.SQLException {
        return executeQuery(replacements,
                condition.getStartDate(),
                condition.getEndDate(),
                condition.getStartDate(),
                condition.getEndDate(),
                condition.getRoomId()
        );
    }

    @Override
    public BaseMeetingRoomReservaTionRecordPaymentBase generateBase(Object[] __data) throws java.sql.SQLException {
        BaseMeetingRoomReservaTionRecordPaymentBase __base = new BaseMeetingRoomReservaTionRecordPaymentBase();
        int count = 0;
        Object val;
        if ((val = __data[count++]) != null) __base.setMeetingRoomId(GenericBase.__getInt(val));
        if ((val = __data[count++]) != null) __base.setMeetingRoomName(GenericBase.__getString(val));
        if ((val = __data[count++]) != null) __base.setSite(GenericBase.__getString(val));
        if ((val = __data[count++]) != null) __base.setContainNum(GenericBase.__getInt(val));
        if ((val = __data[count++]) != null) __base.setMeetingDate(GenericBase.__getString(val));
        if ((val = __data[count++]) != null) __base.setTime1(GenericBase.__getString(val));
        if ((val = __data[count++]) != null) __base.setTime2(GenericBase.__getString(val));
        if ((val = __data[count++]) != null) __base.setTime3(GenericBase.__getString(val));
        if ((val = __data[count++]) != null) __base.setTime4(GenericBase.__getString(val));
        if ((val = __data[count++]) != null) __base.setTime5(GenericBase.__getString(val));
        if ((val = __data[count++]) != null) __base.setTime6(GenericBase.__getString(val));
        if ((val = __data[count++]) != null) __base.setTime7(GenericBase.__getString(val));
        if ((val = __data[count++]) != null) __base.setTime8(GenericBase.__getString(val));
        if ((val = __data[count++]) != null) __base.setTime9(GenericBase.__getString(val));
        if ((val = __data[count++]) != null) __base.setTime10(GenericBase.__getString(val));
        if ((val = __data[count++]) != null) __base.setTime11(GenericBase.__getString(val));
        if ((val = __data[count++]) != null) __base.setTime12(GenericBase.__getString(val));
        if ((val = __data[count++]) != null) __base.setTime13(GenericBase.__getString(val));
        if ((val = __data[count++]) != null) __base.setTime14(GenericBase.__getString(val));
        if ((val = __data[count++]) != null) __base.setTime15(GenericBase.__getString(val));
        return __base;
    }

    @Override
    public int setStatementParameters(int count, java.lang.Object... args) throws java.sql.SQLException {

        int index = 0;
        for (int ii = 0; ii < args.length; ii++) {
            if (args[ii] == null) continue;
            index++;
            __logger.info(String.format("%1$s = [%2$s]", fieldNames[ii], args[ii]));
        }
        if (index > 0) __logger.info("=================================================");
        if (args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date) args[0]));
        if (args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date) args[1]));
        if (args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date) args[2]));
        if (args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date) args[3]));
        if (args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
        return count;
    }

    @Override
    public String getSQLText() {
        __logger.info(__SQLText);
        return __SQLText;
    }

    @Override
    public String getFieldList() {
        return RESULTSETFIELDLIST;
    }
    private final static String __SQLText = "SELECT A.meeting_room_id, A.meeting_room_name, A.site, A.contain_num, C.meeting_date, case when C.meeting_date = to_char(b.record_date,'yyyy-mm-dd') then SUM ( CASE b.meeting_room_time WHEN '07:00-08:00' THEN b.status ELSE 0 END ) else 0 end AS time_1, case when C.meeting_date = to_char(b.record_date,'yyyy-mm-dd') then SUM ( CASE b.meeting_room_time WHEN '08:00-09:00' THEN b.status ELSE 0 END ) else 0 end AS time_2, case when C.meeting_date = to_char(b.record_date,'yyyy-mm-dd') then SUM ( CASE b.meeting_room_time WHEN '09:00-10:00' THEN b.status ELSE 0 END ) else 0 end AS time_3, case when C.meeting_date = to_char(b.record_date,'yyyy-mm-dd') then SUM ( CASE b.meeting_room_time WHEN '10:00-11:00' THEN b.status ELSE 0 END ) else 0 end AS time_4, case when C.meeting_date = to_char(b.record_date,'yyyy-mm-dd') then SUM ( CASE b.meeting_room_time WHEN '11:00-12:00' THEN b.status ELSE 0 END ) else 0 end AS time_5, case when C.meeting_date = to_char(b.record_date,'yyyy-mm-dd') then SUM ( CASE b.meeting_room_time WHEN '12:00-13:00' THEN b.status ELSE 0 END ) else 0 end AS time_6, case when C.meeting_date = to_char(b.record_date,'yyyy-mm-dd') then SUM ( CASE b.meeting_room_time WHEN '13:00-14:00' THEN b.status ELSE 0 END ) else 0 end AS time_7, case when C.meeting_date = to_char(b.record_date,'yyyy-mm-dd') then SUM ( CASE b.meeting_room_time WHEN '14:00-15:00' THEN b.status ELSE 0 END ) else 0 end AS time_8, case when C.meeting_date = to_char(b.record_date,'yyyy-mm-dd') then SUM ( CASE b.meeting_room_time WHEN '15:00-16:00' THEN b.status ELSE 0 END ) else 0 end AS time_9, case when C.meeting_date = to_char(b.record_date,'yyyy-mm-dd') then SUM ( CASE b.meeting_room_time WHEN '16:00-17:00' THEN b.status ELSE 0 END ) else 0 end AS time_10, case when C.meeting_date = to_char(b.record_date,'yyyy-mm-dd') then SUM ( CASE b.meeting_room_time WHEN '17:00-18:00' THEN b.status ELSE 0 END ) else 0 end AS time_11, case when C.meeting_date = to_char(b.record_date,'yyyy-mm-dd') then SUM ( CASE b.meeting_room_time WHEN '18:00-19:00' THEN b.status ELSE 0 END ) else 0 end AS time_12, case when C.meeting_date = to_char(b.record_date,'yyyy-mm-dd') then SUM ( CASE b.meeting_room_time WHEN '19:00-20:00' THEN b.status ELSE 0 END ) else 0 end AS time_13, case when C.meeting_date = to_char(b.record_date,'yyyy-mm-dd') then SUM ( CASE b.meeting_room_time WHEN '20:00-21:00' THEN b.status ELSE 0 END ) else 0 end AS time_14, case when C.meeting_date = to_char(b.record_date,'yyyy-mm-dd') then SUM ( CASE b.meeting_room_time WHEN '21:00-22:00' THEN b.status ELSE 0 END ) else 0 end AS time_15 FROM meeting_rooms A LEFT JOIN meetings b ON A.meeting_room_id = b.meeting_room_id AND b.record_date BETWEEN ? AND ? LEFT JOIN ( SELECT to_char( generate_series (? :: DATE,?, '1 day' ), 'yyyy-mm-dd' ) AS meeting_date ) AS C on 1=1 WHERE A.meeting_room_id =? GROUP BY A.meeting_room_id, A.meeting_room_name, A.site, A.contain_num, C.meeting_date, b.record_date ORDER BY C.meeting_date";
    private final static String RESULTSETFIELDLIST = "meeting_room_id,meeting_room_name,site,contain_num,meeting_date,time_1,time_2,time_3,time_4,time_5,time_6,time_7,time_8,time_9,time_10,time_11,time_12,time_13,time_14,time_15";
    private final static String[] fieldNames = {"start_date", "end_date", "start_date", "end_date", "room_id"};
}
