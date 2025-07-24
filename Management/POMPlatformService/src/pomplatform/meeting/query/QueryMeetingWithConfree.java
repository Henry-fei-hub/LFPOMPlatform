package pomplatform.meeting.query;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import org.apache.log4j.Logger;
import pomplatform.meeting.bean.BaseMeetingWithConfree;
import pomplatform.meeting.bean.ConditionMeetingWithConfree;

public class QueryMeetingWithConfree extends AbstractQuery<BaseMeetingWithConfree, ConditionMeetingWithConfree>
{


	private static final Logger __logger = Logger.getLogger(QueryMeetingWithConfree.class);


	public QueryMeetingWithConfree() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("M.meeting_record_chart_id");
	}

	@Override
	public BaseCollection<BaseMeetingWithConfree> executeQuery(KeyValuePair[] replacements, ConditionMeetingWithConfree condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMeetingRecordChartId()
			);
	}

	public BaseCollection<BaseMeetingWithConfree> execute(KeyValuePair[] replacements, ConditionMeetingWithConfree condition ) throws java.sql.SQLException {
		return execute(condition, replacements, 
				condition.getMeetingRecordChartId()
			);
	}

	@Override
	public BaseMeetingWithConfree generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMeetingWithConfree __base = new BaseMeetingWithConfree();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setMeetingRecordChartId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMeetingRoomId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMeetingTheme(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setMeetingRoomTimeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMeetingRoomTime(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMeetingRelevanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStartTimes(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEndTimes(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setInt(count++, GenericBase.__getInt(args[0]));
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

	private final static String __SQLText = "SELECT M.meeting_record_chart_id, M.meeting_room_id, M.employee_id, M.start_time, M.end_time, M.status, M.meeting_theme, M.record_date, M.meeting_room_time_id, M.meeting_room_time, M.meeting_relevance_id, M.start_times, M.end_times, M.meeting_time FROM meetings M WHERE M.meeting_record_chart_id = ?" ;
	private final static String __originalSQL = "SELECT M.meeting_record_chart_id, M.meeting_room_id, M.employee_id, M.start_time, M.end_time, M.status, M.meeting_theme, M.record_date, M.meeting_room_time_id, M.meeting_room_time, M.meeting_relevance_id, M.start_times, M.end_times, M.meeting_time  FROM meetings M WHERE M.meeting_record_chart_id = :meeting_record_chart_id ";
	private final static String[] __queryConditions = {
		"{\"fullCondition\": \"M.meeting_record_chart_id = @meeting_record_chart_id\",\"fullFieldName\":\"M.meeting_record_chart_id\",\"operationName\":\"=\",\"variableName\":\"meetingRecordChartId\",\"startIndex\": 271,\"stopIndex\":322,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": []}"
	};
	private final static String RESULTSETFIELDLIST = "meeting_record_chart_id,meeting_room_id,employee_id,start_time,end_time,status,meeting_theme,record_date,meeting_room_time_id,meeting_room_time,meeting_relevance_id,start_times,end_times,meeting_time";
	private final static String[] fieldNames = { "meeting_record_chart_id"};
}
