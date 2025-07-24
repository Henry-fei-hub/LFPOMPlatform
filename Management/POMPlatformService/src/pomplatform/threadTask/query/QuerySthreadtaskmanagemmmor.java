package pomplatform.threadTask.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.threadTask.bean.BaseSthreadtaskmanagemmmor;
import pomplatform.threadTask.bean.ConditionSthreadtaskmanagemmmor;

public class QuerySthreadtaskmanagemmmor extends AbstractQuery<BaseSthreadtaskmanagemmmor, ConditionSthreadtaskmanagemmmor>
{

	private static final Logger __logger = Logger.getLogger(QuerySthreadtaskmanagemmmor.class);

	public QuerySthreadtaskmanagemmmor() throws java.sql.SQLException 
	{
		setParameterNumber(13);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ttm.thread_task_manage_id");
	}

	@Override
	public BaseCollection<BaseSthreadtaskmanagemmmor> executeQuery( KeyValuePair[] replacements, ConditionSthreadtaskmanagemmmor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMinBeginTime(), 
				condition.getMaxBeginTime(), 
				condition.getMinEndTime(), 
				condition.getMaxEndTime(), 
				condition.getMinCreateTime(), 
				condition.getMaxCreateTime(), 
				condition.getErrorMsg(), 
				condition.getRemark(), 
				condition.getThreadTaskManageId(), 
				condition.getTaskType(), 
				condition.getStatus(), 
				condition.getOperator(), 
				condition.getOperationType()
			);
	}

	@Override
	public BaseSthreadtaskmanagemmmor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSthreadtaskmanagemmmor __base = new BaseSthreadtaskmanagemmmor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setThreadTaskManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTaskType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setErrorMsg(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperationType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBeginTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
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

	private final static String __SQLText = "select ttm.thread_task_manage_id, ttm.task_type, ttm.status, ttm.error_msg, ttm.operator, ttm.operation_type, ttm.begin_time, ttm.end_time, ttm.create_time, ttm.remark from thread_task_manages ttm where ttm.begin_time between ? and ? and ttm.end_time between ? and ? and ttm.create_time between ? and ? and ttm.error_msg like ? and ttm.remark like ? and ttm.thread_task_manage_id = ? and ttm.task_type = ? and ttm.status = ? and ttm.operator = ? and ttm.operation_type = ?" ;
	private final static String RESULTSETFIELDLIST = "thread_task_manage_id,task_type,status,error_msg,operator,operation_type,begin_time,end_time,create_time,remark";
	private final static String[] fieldNames = { "min_begin_time", "max_begin_time", "min_end_time", "max_end_time", "min_create_time", "max_create_time", "error_msg", "remark", "thread_task_manage_id", "task_type", "status", "operator", "operation_type"};
}
