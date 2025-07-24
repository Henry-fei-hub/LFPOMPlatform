package pomplatform.checking.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.checking.bean.BaseEmployeeCheckStatus;
import pomplatform.checking.bean.ConditionEmployeeCheckStatus;

public class QueryEmployeeCheckStatus extends AbstractQuery<BaseEmployeeCheckStatus, ConditionEmployeeCheckStatus>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeCheckStatus.class);

	public QueryEmployeeCheckStatus() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("edc.status");
	}

	@Override
	public BaseCollection<BaseEmployeeCheckStatus> executeQuery( KeyValuePair[] replacements, ConditionEmployeeCheckStatus condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseEmployeeCheckStatus generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeCheckStatus __base = new BaseEmployeeCheckStatus();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNum(GenericBase.__getLong(val));
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

	private final static String __SQLText = "SELECT edc.status,count(edc.status) as num FROM employee_day_checks edc LEFT JOIN employees e ON edc.employee_id = e.employee_id WHERE edc.record_date BETWEEN ? and ? AND e.is_check = true and e.status = 0 and e.employee_id > 0 and department_id in (select child_id from department_ids where department_id = ? ) AND edc.status > 0 GROUP BY edc.status ORDER BY edc.status" ;
	private final static String RESULTSETFIELDLIST = "status,num";
	private final static String[] fieldNames = { "start_date", "end_date", "department_id"};
}
