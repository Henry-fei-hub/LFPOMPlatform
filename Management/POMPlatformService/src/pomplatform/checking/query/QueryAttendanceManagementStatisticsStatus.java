package pomplatform.checking.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.checking.bean.BaseAttendanceManagementStatisticsStatus;
import pomplatform.checking.bean.ConditionAttendanceManagementStatisticsStatus;

public class QueryAttendanceManagementStatisticsStatus extends AbstractQuery<BaseAttendanceManagementStatisticsStatus, ConditionAttendanceManagementStatisticsStatus>
{

	private static final Logger __logger = Logger.getLogger(QueryAttendanceManagementStatisticsStatus.class);

	public QueryAttendanceManagementStatisticsStatus() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("process_type");
	}

	@Override
	public BaseCollection<BaseAttendanceManagementStatisticsStatus> executeQuery( KeyValuePair[] replacements, ConditionAttendanceManagementStatisticsStatus condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getToday(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseAttendanceManagementStatisticsStatus generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAttendanceManagementStatisticsStatus __base = new BaseAttendanceManagementStatisticsStatus();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTypeNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setIsCompleted(GenericBase.__getBoolean(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
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

	private final static String __SQLText = "SELECT process_type,count(process_type) as type_num ,is_completed FROM personnel_business where ? between start_date and end_date and department_id in (select child_id from department_ids where department_id = ?) GROUP BY process_type,is_completed" ;
	private final static String RESULTSETFIELDLIST = "process_type,type_num,is_completed";
	private final static String[] fieldNames = { "today", "department_id"};
}
