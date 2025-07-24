package pomplatform.checking.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.checking.bean.BaseEmployeecheckinoutStatusCount;
import pomplatform.checking.bean.ConditionEmployeecheckinoutStatusCount;

public class QueryEmployeecheckinoutStatusCount extends AbstractQuery<BaseEmployeecheckinoutStatusCount, ConditionEmployeecheckinoutStatusCount>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeecheckinoutStatusCount.class);

	public QueryEmployeecheckinoutStatusCount() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ec.status");
	}

	@Override
	public BaseCollection<BaseEmployeecheckinoutStatusCount> executeQuery( KeyValuePair[] replacements, ConditionEmployeecheckinoutStatusCount condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getToday(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseEmployeecheckinoutStatusCount generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeecheckinoutStatusCount __base = new BaseEmployeecheckinoutStatusCount();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNum(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT ec.status,count(ec.status) as num FROM employee_checkinouts ec LEFT JOIN employees e ON ec.employee_id = e.employee_id WHERE ec.check_date = ? AND e.is_check = true and e.status = 0 and e.employee_id > 0 AND e.department_id in(select child_id from department_ids where department_id = ? ) GROUP BY ec.status ORDER BY ec.status" ;
	private final static String RESULTSETFIELDLIST = "status,num";
	private final static String[] fieldNames = { "today", "department_id"};
}
