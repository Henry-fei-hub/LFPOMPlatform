package pomplatform.meeting.query;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import org.apache.log4j.Logger;
import pomplatform.meeting.bean.BaseMeetingInsertRecord;
import pomplatform.meeting.bean.ConditionMeetingInsertRecord;

public class QueryMeetingInsertRecord extends AbstractQuery<BaseMeetingInsertRecord, ConditionMeetingInsertRecord>
{

	private static final Logger __logger = Logger.getLogger(QueryMeetingInsertRecord.class);

	public QueryMeetingInsertRecord() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("*");
	}



	@Override
	public BaseCollection<BaseMeetingInsertRecord> executeQuery(KeyValuePair[] replacements, ConditionMeetingInsertRecord condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMeetingRoomId(), 
				condition.getStartTime(), 
				condition.getEndTime(), 
				condition.getStartTime(), 
				condition.getEndTime(), 
				condition.getStartTime(), 
				condition.getEndTime()
			);
	}

	@Override
	public BaseMeetingInsertRecord generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMeetingInsertRecord __base = new BaseMeetingInsertRecord();
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
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[6]));
		return count;
	}

	@Override
	public String getSQLText() {
		__logger.info(__SQLText);
		return __SQLText;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	private final static String __SQLText = "select * from meetings where meeting_room_id =? and ((start_time > ? and start_time <?) or (start_time <= ? and end_time >= ?) or (end_time >= ? and end_time < ?) )" ;
	private final static String RESULTSETFIELDLIST = "meeting_record_chart_id,meeting_room_id,employee_id,start_time,end_time,status,meeting_theme,record_date";
	private final static String[] fieldNames = { "meeting_room_id", "start_time", "end_time", "start_time", "end_time", "start_time", "end_time"};
}
