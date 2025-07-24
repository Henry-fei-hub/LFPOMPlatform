package pomplatform.clocks.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.clocks.bean.BaseClockRecevieCmds;
import pomplatform.clocks.bean.ConditionClockRecevieCmds;

public class QueryClockRecevieCmds extends AbstractQuery<BaseClockRecevieCmds, ConditionClockRecevieCmds>
{

	private static final Logger __logger = Logger.getLogger(QueryClockRecevieCmds.class);

	public QueryClockRecevieCmds() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("c.device_name");
	}

	@Override
	public BaseCollection<BaseClockRecevieCmds> executeQuery( KeyValuePair[] replacements, ConditionClockRecevieCmds condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStatus(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getDeviceName()
			);
	}

	@Override
	public BaseClockRecevieCmds generateBase(Object[] __data) throws java.sql.SQLException {
		BaseClockRecevieCmds __base = new BaseClockRecevieCmds();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDeviceName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setClockRecevieCmdId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSn(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCmdContent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCmdCommitTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCmdTransTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCmdReturn(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessCount(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSuccessFlag(GenericBase.__getShort(val));
		if((val = __data[count++]) != null) __base.setReceiveData(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCmdType(GenericBase.__getShort(val));
		if((val = __data[count++]) != null) __base.setCmdSystem(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCmdOverTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUpdateDb(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setUserId(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setChangeOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setChangeTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCreateOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDeleteOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDeleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getShort(val));
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
		if(args[0] != null) __statement.setShort(count++, GenericBase.__getShort(args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
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

	private final static String __SQLText = "SELECT c.device_name,crc.* FROM clock_recevie_cmds crc LEFT JOIN clocks c ON crc.sn = c.sn where crc.status = ? and crc.cmd_commit_time between ? and ? and c.device_name like ?" ;
	private final static String RESULTSETFIELDLIST = "device_name,clock_recevie_cmd_id,sn,cmd_content,cmd_commit_time,cmd_trans_time,cmd_return,process_count,success_flag,receive_data,cmd_type,cmd_system,cmd_over_time,update_db,user_id,change_operator,change_time,create_operator,create_time,delete_operator,delete_time,status";
	private final static String[] fieldNames = { "status", "start_date", "end_date", "device_name"};
}
