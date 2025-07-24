package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnLoadEmpWordDayOfMonth;
import pomplatform.payment.bean.ConditionOnLoadEmpWordDayOfMonth;

public class QueryOnLoadEmpWordDayOfMonth extends AbstractQuery<BaseOnLoadEmpWordDayOfMonth, ConditionOnLoadEmpWordDayOfMonth>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadEmpWordDayOfMonth.class);

	public QueryOnLoadEmpWordDayOfMonth() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseOnLoadEmpWordDayOfMonth> executeQuery( KeyValuePair[] replacements, ConditionOnLoadEmpWordDayOfMonth condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseOnLoadEmpWordDayOfMonth generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadEmpWordDayOfMonth __base = new BaseOnLoadEmpWordDayOfMonth();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCount(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setInt(count++, GenericBase.__getInt(args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
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

	private final static String __SQLText = "select a.employee_id,count(*) as count from employee_shift_manages a left join holiday_manages b on a.record_date = b.record_date and a.year=b.year and a.month = b.month where a.shift_manage_id > 2 and (b.holiday_manage_id is null or b.is_work_day = true) and a.year = ? and a.month = ? and a.employee_id = ? GROUP BY a.employee_id ORDER BY a.employee_id asc" ;
	private final static String RESULTSETFIELDLIST = "employee_id,count";
	private final static String[] fieldNames = { "year", "month", "employee_id"};
}
