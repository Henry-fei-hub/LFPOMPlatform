package pomplatform.meeting.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.meeting.bean.BaseMeetingRoomReservaTionRecordPaymentBase;
import pomplatform.meeting.bean.ConditionMeetingRoomReservaTionRecordPaymentBase;

public class QueryMeetingRoomReservaTionRecordPaymentBase extends AbstractQuery<BaseMeetingRoomReservaTionRecordPaymentBase, ConditionMeetingRoomReservaTionRecordPaymentBase>
{

	private static final Logger __logger = Logger.getLogger(QueryMeetingRoomReservaTionRecordPaymentBase.class);

	public QueryMeetingRoomReservaTionRecordPaymentBase() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .meeting_room_id");
	}

	@Override
	public BaseCollection<BaseMeetingRoomReservaTionRecordPaymentBase> executeQuery( KeyValuePair[] replacements, ConditionMeetingRoomReservaTionRecordPaymentBase condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getMeetingRoomId()
			);
	}

	public BaseCollection<BaseMeetingRoomReservaTionRecordPaymentBase> runQuery( KeyValuePair[] replacements, ConditionMeetingRoomReservaTionRecordPaymentBase condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getMeetingRoomId()
			);
	}

	public BaseCollection<BaseMeetingRoomReservaTionRecordPaymentBase> execute( KeyValuePair[] replacements, ConditionMeetingRoomReservaTionRecordPaymentBase condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getMeetingRoomId()
			);
	}

	@Override
	public BaseMeetingRoomReservaTionRecordPaymentBase generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMeetingRoomReservaTionRecordPaymentBase __base = new BaseMeetingRoomReservaTionRecordPaymentBase();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setMeetingRoomId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMeetingRoomName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSite(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContainNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMeetingMonthDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setTime2(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTime3(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTime4(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTime5(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTime6(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTime7(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTime8(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTime9(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTime10(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTime11(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTime12(GenericBase.__getString(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, java.lang.Object ... args) throws java.sql.SQLException {

		int index = 0;
		for(int ii = 0; ii < args.length; ii++){
			if(args[ii] == null) continue;
			index++;
			__logger.info(String.format("%1$s = [%2$s]", fieldNames[ii], args[ii]));
		}
		if( index > 0 ) __logger.info("=================================================");
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		return count;
	}

	@Override
	public String getSQLText() {
		return __SQLText;
	}

	@Override
	public String getOriginalSQLText() {
		return __originalSQL;
	}

	@Override
	public String[] getQueryStringArray()  {
		return __queryConditions;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	@Override
	public String[] getConditionNames(){
		return fieldNames;
	}

	private final static String __SQLText = "SELECT A .meeting_room_id, A.meeting_room_name, A.site, A.contain_num, A.meeting_month_date, string_agg ( A.time_2, ',' ) AS time_2, string_agg ( A.time_3, ',' ) AS time_3, string_agg ( A.time_4, ',' ) AS time_4, string_agg ( A.time_5, ',' ) AS time_5, string_agg ( A.time_6, ',' ) AS time_6, string_agg ( A.time_7, ',' ) AS time_7, string_agg ( A.time_8, ',' ) AS time_8, string_agg ( A.time_9, ',' ) AS time_9, string_agg ( A.time_10, ',' ) AS time_10, string_agg ( A.time_11, ',' ) AS time_11, string_agg ( A.time_12, ',' ) AS time_12 FROM ( SELECT A .meeting_room_id, A.meeting_room_name, A.site, A.contain_num, C.meeting_month_date, CASE WHEN mt.time_flag = 2 AND COALESCE ( b.status, 0 ) > 0 THEN COALESCE ( b.status, 0 ) || '&&' || e.employee_name || '&&' || d.department_name || '&&' || b.meeting_theme ELSE NULL END time_2, CASE WHEN mt.time_flag = 3 AND COALESCE ( b.status, 0 ) > 0 THEN COALESCE ( b.status, 0 ) || '&&' || e.employee_name || '&&' || d.department_name || '&&' || b.meeting_theme ELSE NULL END time_3, CASE WHEN mt.time_flag = 4 AND COALESCE ( b.status, 0 ) > 0 THEN COALESCE ( b.status, 0 ) || '&&' || e.employee_name || '&&' || d.department_name || '&&' || b.meeting_theme ELSE NULL END time_4, CASE WHEN mt.time_flag = 5 AND COALESCE ( b.status, 0 ) > 0 THEN COALESCE ( b.status, 0 ) || '&&' || e.employee_name || '&&' || d.department_name || '&&' || b.meeting_theme ELSE NULL END time_5, CASE WHEN mt.time_flag = 6 AND COALESCE ( b.status, 0 ) > 0 THEN COALESCE ( b.status, 0 ) || '&&' || e.employee_name || '&&' || d.department_name || '&&' || b.meeting_theme ELSE NULL END time_6, CASE WHEN mt.time_flag = 7 AND COALESCE ( b.status, 0 ) > 0 THEN COALESCE ( b.status, 0 ) || '&&' || e.employee_name || '&&' || d.department_name || '&&' || b.meeting_theme ELSE NULL END time_7, CASE WHEN mt.time_flag = 8 AND COALESCE ( b.status, 0 ) > 0 THEN COALESCE ( b.status, 0 ) || '&&' || e.employee_name || '&&' || d.department_name || '&&' || b.meeting_theme ELSE NULL END time_8, CASE WHEN mt.time_flag = 9 AND COALESCE ( b.status, 0 ) > 0 THEN COALESCE ( b.status, 0 ) || '&&' || e.employee_name || '&&' || d.department_name || '&&' || b.meeting_theme ELSE NULL END time_9, CASE WHEN mt.time_flag = 10 AND COALESCE ( b.status, 0 ) > 0 THEN COALESCE ( b.status, 0 ) || '&&' || e.employee_name || '&&' || d.department_name || '&&' || b.meeting_theme ELSE NULL END time_10, CASE WHEN mt.time_flag = 11 AND COALESCE ( b.status, 0 ) > 0 THEN COALESCE ( b.status, 0 ) || '&&' || e.employee_name || '&&' || d.department_name || '&&' || b.meeting_theme ELSE NULL END time_11, CASE WHEN mt.time_flag = 12 AND COALESCE ( b.status, 0 ) > 0 THEN COALESCE ( b.status, 0 ) || '&&' || e.employee_name || '&&' || d.department_name || '&&' || b.meeting_theme ELSE NULL END time_12 FROM meeting_rooms A LEFT JOIN meeting_month_time C ON C.meeting_month_date between ? and ? LEFT JOIN meeting_timers mt ON 1 = 1 LEFT JOIN meetings b ON A.meeting_room_id = b.meeting_room_id AND C.meeting_month_date = b.meeting_time AND mt.meeting_room_time = b.meeting_room_time LEFT JOIN employees e ON b.employee_id = e.employee_id LEFT JOIN departments d ON e.department_id = d.department_id WHERE A.meeting_room_id = ? ORDER BY C.meeting_month_date, A.meeting_room_id ) A GROUP BY A.meeting_room_id, A.meeting_room_name, A.site, A.contain_num, A.meeting_month_date" ;
	private final static String __originalSQL = "SELECT A .meeting_room_id, A.meeting_room_name, A.site, A.contain_num, A.meeting_month_date, string_agg ( A.time_2, ',' ) AS time_2, string_agg ( A.time_3, ',' ) AS time_3, string_agg ( A.time_4, ',' ) AS time_4, string_agg ( A.time_5, ',' ) AS time_5, string_agg ( A.time_6, ',' ) AS time_6, string_agg ( A.time_7, ',' ) AS time_7, string_agg ( A.time_8, ',' ) AS time_8, string_agg ( A.time_9, ',' ) AS time_9, string_agg ( A.time_10, ',' ) AS time_10, string_agg ( A.time_11, ',' ) AS time_11, string_agg ( A.time_12, ',' ) AS time_12 FROM ( SELECT A .meeting_room_id, A.meeting_room_name, A.site, A.contain_num, C.meeting_month_date, CASE WHEN mt.time_flag = 2 AND COALESCE ( b.status, 0 ) > 0 THEN COALESCE ( b.status, 0 ) || '&&' || e.employee_name || '&&' || d.department_name || '&&' || b.meeting_theme ELSE NULL END time_2, CASE WHEN mt.time_flag = 3 AND COALESCE ( b.status, 0 ) > 0 THEN COALESCE ( b.status, 0 ) || '&&' || e.employee_name || '&&' || d.department_name || '&&' || b.meeting_theme ELSE NULL END time_3, CASE WHEN mt.time_flag = 4 AND COALESCE ( b.status, 0 ) > 0 THEN COALESCE ( b.status, 0 ) || '&&' || e.employee_name || '&&' || d.department_name || '&&' || b.meeting_theme ELSE NULL END time_4, CASE WHEN mt.time_flag = 5 AND COALESCE ( b.status, 0 ) > 0 THEN COALESCE ( b.status, 0 ) || '&&' || e.employee_name || '&&' || d.department_name || '&&' || b.meeting_theme ELSE NULL END time_5, CASE WHEN mt.time_flag = 6 AND COALESCE ( b.status, 0 ) > 0 THEN COALESCE ( b.status, 0 ) || '&&' || e.employee_name || '&&' || d.department_name || '&&' || b.meeting_theme ELSE NULL END time_6, CASE WHEN mt.time_flag = 7 AND COALESCE ( b.status, 0 ) > 0 THEN COALESCE ( b.status, 0 ) || '&&' || e.employee_name || '&&' || d.department_name || '&&' || b.meeting_theme ELSE NULL END time_7, CASE WHEN mt.time_flag = 8 AND COALESCE ( b.status, 0 ) > 0 THEN COALESCE ( b.status, 0 ) || '&&' || e.employee_name || '&&' || d.department_name || '&&' || b.meeting_theme ELSE NULL END time_8, CASE WHEN mt.time_flag = 9 AND COALESCE ( b.status, 0 ) > 0 THEN COALESCE ( b.status, 0 ) || '&&' || e.employee_name || '&&' || d.department_name || '&&' || b.meeting_theme ELSE NULL END time_9, CASE WHEN mt.time_flag = 10 AND COALESCE ( b.status, 0 ) > 0 THEN COALESCE ( b.status, 0 ) || '&&' || e.employee_name || '&&' || d.department_name || '&&' || b.meeting_theme ELSE NULL END time_10, CASE WHEN mt.time_flag = 11 AND COALESCE ( b.status, 0 ) > 0 THEN COALESCE ( b.status, 0 ) || '&&' || e.employee_name || '&&' || d.department_name || '&&' || b.meeting_theme ELSE NULL END time_11, CASE WHEN mt.time_flag = 12 AND COALESCE ( b.status, 0 ) > 0 THEN COALESCE ( b.status, 0 ) || '&&' || e.employee_name || '&&' || d.department_name || '&&' || b.meeting_theme ELSE NULL END time_12 FROM meeting_rooms A LEFT JOIN meeting_month_time C ON C.meeting_month_date BETWEEN :start_date AND :end_date LEFT JOIN meeting_timers mt ON 1 = 1 LEFT JOIN meetings b ON A.meeting_room_id = b.meeting_room_id AND C.meeting_month_date = b.meeting_time AND mt.meeting_room_time = b.meeting_room_time LEFT JOIN employees e ON b.employee_id = e.employee_id LEFT JOIN departments d ON e.department_id = d.department_id WHERE A.meeting_room_id =:meeting_room_id ORDER BY C.meeting_month_date, A.meeting_room_id ) A GROUP BY A.meeting_room_id, A.meeting_room_name, A.site, A.contain_num, A.meeting_month_date";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"C.meeting_month_date BETWEEN :start_date AND :end_date\",\"startIndex\": 2843,\"stopIndex\":2896,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"C.meeting_month_date BETWEEN :start_date AND :end_date\",\"fullFieldName\":\"C.meeting_month_date\",\"operationName\":\"between\",\"variableName\":\"startDate\",\"secondName\":\"endDate\",\"startIndex\": 2843,\"stopIndex\":2896,\"variableNum\": 0,\"variableCount\": 2,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]},{\"fullCondition\": \"A.meeting_room_id =:meeting_room_id\",\"startIndex\": 3208,\"stopIndex\":3242,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"A.meeting_room_id =:meeting_room_id\",\"fullFieldName\":\"A.meeting_room_id\",\"operationName\":\"=\",\"variableName\":\"meetingRoomId\",\"startIndex\": 3208,\"stopIndex\":3242,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "meeting_room_id,meeting_room_name,site,contain_num,meeting_month_date,time_2,time_3,time_4,time_5,time_6,time_7,time_8,time_9,time_10,time_11,time_12";
	private final static String[] fieldNames = { "start_date", "end_date", "meeting_room_id"};
}
