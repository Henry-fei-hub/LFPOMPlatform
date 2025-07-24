package pomplatform.checking.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.checking.bean.BaseEmployeeShouldAndFactCheck;
import pomplatform.checking.bean.ConditionEmployeeShouldAndFactCheck;

public class QueryEmployeeShouldAndFactCheck extends AbstractQuery<BaseEmployeeShouldAndFactCheck, ConditionEmployeeShouldAndFactCheck>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeShouldAndFactCheck.class);

	public QueryEmployeeShouldAndFactCheck() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("SUM(should_days) AS should_days");
	}

	@Override
	public BaseCollection<BaseEmployeeShouldAndFactCheck> executeQuery( KeyValuePair[] replacements, ConditionEmployeeShouldAndFactCheck condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseEmployeeShouldAndFactCheck generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeShouldAndFactCheck __base = new BaseEmployeeShouldAndFactCheck();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setShouldDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFactDays(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT SUM(should_days) AS should_days,sum(fact_days) AS fact_days FROM employee_day_checks edc LEFT JOIN employees e ON edc.employee_id = e.employee_id WHERE record_date = ? AND e.department_id in (select child_id from department_ids where department_id = ? )" ;
	private final static String RESULTSETFIELDLIST = "should_days,fact_days";
	private final static String[] fieldNames = { "start_date", "department_id"};
}
