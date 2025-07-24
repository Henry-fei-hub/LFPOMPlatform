package pomplatform.meeting.query;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import org.apache.log4j.Logger;
import pomplatform.meeting.bean.BaseMeetingInfoPaymentBase;
import pomplatform.meeting.bean.ConditionMeetingInfoPaymentBase;

public class QueryMeetingInfoPaymentBase extends AbstractQuery<BaseMeetingInfoPaymentBase, ConditionMeetingInfoPaymentBase>
{

	private static final Logger __logger = Logger.getLogger(QueryMeetingInfoPaymentBase.class);

	public QueryMeetingInfoPaymentBase() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("mt.meeting_record_chart_id");
	}

	@Override
	public BaseCollection<BaseMeetingInfoPaymentBase> executeQuery(KeyValuePair[] replacements, ConditionMeetingInfoPaymentBase condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getRecordDate(), 
				condition.getEmployeeId(), 
				condition.getMeetingRoomId(), 
				condition.getMeetingTheme()
			);
	}


	public BaseCollection<BaseMeetingInfoPaymentBase> execute(KeyValuePair[] replacements, ConditionMeetingInfoPaymentBase condition ) throws java.sql.SQLException {
		return execute(condition, replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getRecordDate(), 
				condition.getEmployeeId(), 
				condition.getMeetingRoomId(), 
				condition.getMeetingTheme()
			);
	}

	@Override
	public BaseMeetingInfoPaymentBase generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMeetingInfoPaymentBase __base = new BaseMeetingInfoPaymentBase();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setMeetingRecordChartId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMeetingTheme(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStartTimes(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEndTimes(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMeetingRoomName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSite(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContainNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMeetingRoomMaster(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMeetingRoomTime(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMeetingRoomId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setMeetingRelevanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMeetingStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMeetingTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setConfreeNames(GenericBase.__getString(val));
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
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		return count;
	}

	@Override
	public String getSQLText() {
		__logger.info(__SQLText);
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

	private final static String __SQLText = "SELECT mt.meeting_record_chart_id, mt.status, mt.meeting_theme, mt.start_time, mt.end_time, mt.start_times, mt.end_times, mr.meeting_room_name, mr.site, mr.contain_num, mr.meeting_room_master, mt.employee_id, mt.meeting_room_time, mt.meeting_room_id, mt.record_date, mt.meeting_relevance_id, mt.meeting_status, mt.meeting_time, string_agg ( e.employee_name, ',' ) AS confree_names FROM meetings mt LEFT JOIN meeting_rooms mr ON mt.meeting_room_id = mr.meeting_room_id LEFT JOIN confrees cr ON mt.meeting_relevance_id = cr.meeting_relevance_id LEFT JOIN employees e ON cr.employee_id = e.employee_id WHERE mt.status > 0 AND EXTRACT ( YEAR FROM mt.meeting_time ) = ? AND EXTRACT ( MONTH FROM mt.meeting_time ) = ? AND mt.record_date = ? AND mt.employee_id = ? AND mt.meeting_room_id = ? AND mt.meeting_theme = ? GROUP BY mt.meeting_record_chart_id, mt.status, mt.meeting_room_time, mt.meeting_theme, mt.meeting_room_id, mt.start_time, mt.end_time, mt.start_times, mt.end_times, mr.meeting_room_name, mr.site, mr.contain_num, mr.meeting_room_master, mt.employee_id, mt.record_date, mt.meeting_relevance_id, mt.meeting_status, mt.meeting_time" ;
	private final static String __originalSQL = "SELECT mt.meeting_record_chart_id, mt.status, mt.meeting_theme, mt.start_time, mt.end_time, mt.start_times, mt.end_times, mr.meeting_room_name, mr.site, mr.contain_num, mr.meeting_room_master, mt.employee_id, mt.meeting_room_time, mt.meeting_room_id, mt.record_date, mt.meeting_relevance_id, mt.meeting_status, mt.meeting_time, string_agg ( e.employee_name, ',' ) AS confree_names FROM meetings mt LEFT JOIN meeting_rooms mr ON mt.meeting_room_id = mr.meeting_room_id LEFT JOIN confrees cr ON mt.meeting_relevance_id = cr.meeting_relevance_id LEFT JOIN employees e ON cr.employee_id = e.employee_id WHERE mt.status > 0 AND EXTRACT ( YEAR FROM mt.meeting_time ) = :YEAR AND EXTRACT ( MONTH FROM mt.meeting_time ) = :MONTH AND mt.record_date = :record_date AND mt.employee_id = :employee_id AND mt.meeting_room_id = :meeting_room_id AND mt.meeting_theme = :meeting_theme GROUP BY mt.meeting_record_chart_id, mt.status, mt.meeting_room_time, mt.meeting_theme, mt.meeting_room_id, mt.start_time, mt.end_time, mt.start_times, mt.end_times, mr.meeting_room_name, mr.site, mr.contain_num, mr.meeting_room_master, mt.employee_id, mt.record_date, mt.meeting_relevance_id, mt.meeting_status, mt.meeting_time ";
	private final static String[] __queryConditions = {
		"{\"fullCondition\": \"mt.status > 0 AND EXTRACT ( YEAR FROM mt.meeting_time ) = @YEAR AND EXTRACT ( MONTH FROM mt.meeting_time ) = @MONTH AND mt.record_date = @record_date AND mt.employee_id = @employee_id AND mt.meeting_room_id = @meeting_room_id AND mt.meeting_theme = @meeting_theme\",\"startIndex\": 605,\"stopIndex\":867,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"mt.status > 0\",\"startIndex\": 605,\"stopIndex\":617,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"EXTRACT ( YEAR FROM mt.meeting_time ) = @YEAR\",\"fullFieldName\":\"EXTRACT ( YEAR FROM mt.meeting_time )\",\"operationName\":\"=\",\"variableName\":\"year\",\"startIndex\": 623,\"stopIndex\":667,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"EXTRACT ( MONTH FROM mt.meeting_time ) = @MONTH\",\"fullFieldName\":\"EXTRACT ( MONTH FROM mt.meeting_time )\",\"operationName\":\"=\",\"variableName\":\"month\",\"startIndex\": 673,\"stopIndex\":719,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mt.record_date = @record_date\",\"fullFieldName\":\"mt.record_date\",\"operationName\":\"=\",\"variableName\":\"recordDate\",\"startIndex\": 725,\"stopIndex\":753,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mt.employee_id = @employee_id\",\"fullFieldName\":\"mt.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"startIndex\": 759,\"stopIndex\":787,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mt.meeting_room_id = @meeting_room_id\",\"fullFieldName\":\"mt.meeting_room_id\",\"operationName\":\"=\",\"variableName\":\"meetingRoomId\",\"startIndex\": 793,\"stopIndex\":829,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mt.meeting_theme = @meeting_theme\",\"fullFieldName\":\"mt.meeting_theme\",\"operationName\":\"=\",\"variableName\":\"meetingTheme\",\"startIndex\": 835,\"stopIndex\":867,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}"
	};
	private final static String RESULTSETFIELDLIST = "meeting_record_chart_id,status,meeting_theme,start_time,end_time,start_times,end_times,meeting_room_name,site,contain_num,meeting_room_master,employee_id,meeting_room_time,meeting_room_id,record_date,meeting_relevance_id,meeting_status,meeting_time,confree_names";
	private final static String[] fieldNames = { "YEAR", "MONTH", "record_date", "employee_id", "meeting_room_id", "meeting_theme"};
}
