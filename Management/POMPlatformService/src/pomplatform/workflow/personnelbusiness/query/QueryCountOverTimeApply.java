package pomplatform.workflow.personnelbusiness.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.personnelbusiness.bean.BaseCountOverTimeApply;
import pomplatform.workflow.personnelbusiness.bean.ConditionCountOverTimeApply;

public class QueryCountOverTimeApply extends AbstractQuery<BaseCountOverTimeApply, ConditionCountOverTimeApply>
{

	private static final Logger __logger = Logger.getLogger(QueryCountOverTimeApply.class);

	public QueryCountOverTimeApply() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("count(*) from personnel_business a LEFT JOIN system_process_instances b on a.personnel_business_id = b.business_id where a.process_type = 17 and b.process_status in (0");
	}

	@Override
	public BaseCollection<BaseCountOverTimeApply> executeQuery( KeyValuePair[] replacements, ConditionCountOverTimeApply condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getTime(), 
				condition.getTime(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseCountOverTimeApply generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCountOverTimeApply __base = new BaseCountOverTimeApply();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCount(GenericBase.__getLong(val));
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
		__logger.info(__SQLText);
		return __SQLText;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	private final static String __SQLText = "SELECT count(*) from personnel_business a LEFT JOIN system_process_instances b on a.personnel_business_id = b.business_id where a.process_type = 17 and b.process_status in (0,1,3) and b.delete_flag = 0 and a.start_date <= ? and a.end_date >= ? and a.employee_id = ?" ;
	private final static String RESULTSETFIELDLIST = "count";
	private final static String[] fieldNames = { "time", "time", "employee_id"};
}
