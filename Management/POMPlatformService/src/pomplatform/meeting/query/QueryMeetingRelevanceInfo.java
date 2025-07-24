package pomplatform.meeting.query;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import org.apache.log4j.Logger;
import pomplatform.meeting.bean.BaseMeetingRelevanceInfo;
import pomplatform.meeting.bean.ConditionMeetingRelevanceInfo;

public class QueryMeetingRelevanceInfo extends AbstractQuery<BaseMeetingRelevanceInfo, ConditionMeetingRelevanceInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryMeetingRelevanceInfo.class);

	public QueryMeetingRelevanceInfo() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("meeting_relevance_id");
	}



	@Override
	public BaseCollection<BaseMeetingRelevanceInfo> executeQuery(KeyValuePair[] replacements, ConditionMeetingRelevanceInfo condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getMeetingRoomName(), 
				condition.getMeetingTime(), 
				condition.getEmployeeId(), 
				condition.getMeetingRoomId(), 
				condition.getMeetingTheme()
			);
	}


	public BaseCollection<BaseMeetingRelevanceInfo> execute(KeyValuePair[] replacements, ConditionMeetingRelevanceInfo condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getMeetingRoomName(), 
				condition.getMeetingTime(), 
				condition.getEmployeeId(), 
				condition.getMeetingRoomId(), 
				condition.getMeetingTheme()
			);
	}

	@Override
	public BaseMeetingRelevanceInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMeetingRelevanceInfo __base = new BaseMeetingRelevanceInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setMeetingRelevanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMeetingRoomName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMeetingRoomId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMeetingRoomTime(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMeetingTheme(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartTime(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEndTime(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMeetingStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWeekTime(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHowManyWeeks(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMeetingInfo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMeetingTime(GenericBase.__getDateFromSQL(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, Object ... args) throws java.sql.SQLException {

		int index = 0;
		for(int ii = 0; ii < args.length; ii++){
			if(args[ii] == null) continue;
			index++;
			__logger.info(String.format("%1$s = [%2$s]", fieldNames[ii], args[ii]));
		}
		if( index > 0 ) __logger.info("=================================================");
		if(args[0] != null) __statement.setDouble(count++, GenericBase.__getDouble(args[0]));
		if(args[1] != null) __statement.setDouble(count++, GenericBase.__getDouble(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
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

	private final static String __SQLText = "SELECT meeting_relevance_id, meeting_room_name, meeting_room_id, employee_id, meeting_room_time, record_date, status, meeting_theme, start_time, end_time, meeting_status, week_time, how_many_weeks, meeting_info, meeting_time FROM meeting_relevance WHERE EXTRACT ( YEAR FROM meeting_time ) = ? AND EXTRACT ( MONTH FROM meeting_time ) = ? AND meeting_room_name = ? AND meeting_time = ? AND employee_id = ? AND meeting_room_id = ? AND meeting_theme = ?" ;
	private final static String __originalSQL = "SELECT meeting_relevance_id, meeting_room_name, meeting_room_id, employee_id, meeting_room_time, record_date, status, meeting_theme, start_time, end_time, meeting_status, week_time, how_many_weeks, meeting_info, meeting_time FROM meeting_relevance WHERE EXTRACT ( YEAR FROM meeting_time ) = :YEAR AND EXTRACT ( MONTH FROM meeting_time ) = :MONTH AND meeting_room_name = :meeting_room_name AND meeting_time =:meeting_time AND employee_id = :employee_id AND meeting_room_id = :meeting_room_id AND meeting_theme = :meeting_theme    ";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"EXTRACT ( YEAR FROM meeting_time ) = :YEAR AND EXTRACT ( MONTH FROM meeting_time ) = :MONTH AND meeting_room_name = :meeting_room_name AND meeting_time =:meeting_time AND employee_id = :employee_id AND meeting_room_id = :meeting_room_id AND meeting_theme = :meeting_theme\",\"startIndex\": 254,\"stopIndex\":524,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"EXTRACT ( YEAR FROM meeting_time ) = :YEAR\",\"fullFieldName\":\"EXTRACT ( YEAR FROM meeting_time )\",\"operationName\":\"=\",\"variableName\":\"year\",\"startIndex\": 254,\"stopIndex\":295,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"EXTRACT ( MONTH FROM meeting_time ) = :MONTH\",\"fullFieldName\":\"EXTRACT ( MONTH FROM meeting_time )\",\"operationName\":\"=\",\"variableName\":\"month\",\"startIndex\": 301,\"stopIndex\":344,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"meeting_room_name = :meeting_room_name\",\"fullFieldName\":\"meeting_room_name\",\"operationName\":\"=\",\"variableName\":\"meetingRoomName\",\"startIndex\": 350,\"stopIndex\":387,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"meeting_time =:meeting_time\",\"fullFieldName\":\"meeting_time\",\"operationName\":\"=\",\"variableName\":\"meetingTime\",\"startIndex\": 393,\"stopIndex\":419,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"employee_id = :employee_id\",\"fullFieldName\":\"employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"startIndex\": 425,\"stopIndex\":450,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"meeting_room_id = :meeting_room_id\",\"fullFieldName\":\"meeting_room_id\",\"operationName\":\"=\",\"variableName\":\"meetingRoomId\",\"startIndex\": 456,\"stopIndex\":489,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"meeting_theme = :meeting_theme\",\"fullFieldName\":\"meeting_theme\",\"operationName\":\"=\",\"variableName\":\"meetingTheme\",\"startIndex\": 495,\"stopIndex\":524,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "meeting_relevance_id,meeting_room_name,meeting_room_id,employee_id,meeting_room_time,record_date,status,meeting_theme,start_time,end_time,meeting_status,week_time,how_many_weeks,meeting_info,meeting_time";
	private final static String[] fieldNames = { "year", "month", "meeting_room_name", "meeting_time", "employee_id", "meeting_room_id", "meeting_theme"};
}
