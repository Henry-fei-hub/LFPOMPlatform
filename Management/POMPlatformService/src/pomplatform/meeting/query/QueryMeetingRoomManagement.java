package pomplatform.meeting.query;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import org.apache.log4j.Logger;
import pomplatform.meeting.bean.BaseMeetingRoomManagement;
import pomplatform.meeting.bean.ConditionMeetingRoomManagement;

public class QueryMeetingRoomManagement extends AbstractQuery<BaseMeetingRoomManagement, ConditionMeetingRoomManagement>
{

	private static final Logger __logger = Logger.getLogger(QueryMeetingRoomManagement.class);

	public QueryMeetingRoomManagement() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("mr.meeting_room_id");
	}

	@Override
	public BaseCollection<BaseMeetingRoomManagement> executeQuery(KeyValuePair[] replacements, ConditionMeetingRoomManagement condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMeetingRoomName(), 
				condition.getRemark(), 
				condition.getMeetingRoomId(), 
				condition.getCompanyRecordId()
			);
	}


	@Override
	public BaseMeetingRoomManagement generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMeetingRoomManagement __base = new BaseMeetingRoomManagement();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setMeetingRoomId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMeetingRoomName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSite(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContainNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMeetingRoomMaster(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "SELECT mr.meeting_room_id, mr.meeting_room_name, mr.site, mr.contain_num, mr.company_record_id, mr.meeting_room_master, mr.remark FROM meeting_rooms mr WHERE mr.meeting_room_name LIKE ? AND mr.remark LIKE ? AND mr.meeting_room_id = ? AND mr.company_record_id = ?" ;
	private final static String RESULTSETFIELDLIST = "meeting_room_id,meeting_room_name,site,contain_num,company_record_id,meeting_room_master,remark";
	private final static String[] fieldNames = { "meeting_room_name", "remark", "meeting_room_id", "company_record_id"};
}
