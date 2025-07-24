package pomplatform.meeting.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.meeting.bean.BaseMeetingRoomTimeManagement;
import pomplatform.meeting.bean.ConditionMeetingRoomTimeManagement;

public class QueryMeetingRoomTimeManagement extends AbstractQuery<BaseMeetingRoomTimeManagement, ConditionMeetingRoomTimeManagement>
{

	private static final Logger __logger = Logger.getLogger(QueryMeetingRoomTimeManagement.class);

	public QueryMeetingRoomTimeManagement() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("mrt.meeting_room_time_id");
	}

	@Override
	public BaseCollection<BaseMeetingRoomTimeManagement> executeQuery( KeyValuePair[] replacements, ConditionMeetingRoomTimeManagement condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMeetingRoomTime(), 
				condition.getRemark(), 
				condition.getMeetingRoomTimeId(), 
				condition.getStatus(), 
				condition.getDeleteFlag()
			);
	}

	@Override
	public BaseMeetingRoomTimeManagement generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMeetingRoomTimeManagement __base = new BaseMeetingRoomTimeManagement();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setMeetingRoomTimeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMeetingRoomTime(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
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

	private final static String __SQLText = "select mrt.meeting_room_time_id, mrt.meeting_room_time, mrt.status, mrt.remark, mrt.delete_flag from meeting_room_times mrt where mrt.meeting_room_time like ? and mrt.remark like ? and mrt.meeting_room_time_id = ?_id and mrt.status = ? and mrt.delete_flag = ?" ;
	private final static String RESULTSETFIELDLIST = "meeting_room_time_id,meeting_room_time,status,remark,delete_flag";
	private final static String[] fieldNames = { "meeting_room_time", "remark", "meeting_room_time_id", "status", "delete_flag"};
}
