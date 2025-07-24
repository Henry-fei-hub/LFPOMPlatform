package pomplatform.employeeProjectCostEachMonth.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employeeProjectCostEachMonth.bean.BaseEmployeeProjectCostEachMonth;
import pomplatform.employeeProjectCostEachMonth.bean.ConditionEmployeeProjectCostEachMonth;

public class QueryEmployeeProjectCostEachMonth extends AbstractQuery<BaseEmployeeProjectCostEachMonth, ConditionEmployeeProjectCostEachMonth>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeProjectCostEachMonth.class);

	public QueryEmployeeProjectCostEachMonth() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseEmployeeProjectCostEachMonth> executeQuery( KeyValuePair[] replacements, ConditionEmployeeProjectCostEachMonth condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseEmployeeProjectCostEachMonth generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeProjectCostEachMonth __base = new BaseEmployeeProjectCostEachMonth();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCost(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select a.employee_id,b.employee_no, extract(year from a.settlement_date) as year, extract(month from a.settlement_date) as month, sum(a.project_cost) as project_cost from project_settlement_details a left join employees b on a.employee_id = b.employee_id where a.project_cost <> 0 and a.settlement_date >= ? and a.settlement_date <= ? and a.employee_id = ? GROUP BY a.employee_id,b.employee_no, year, month ORDER BY year, month, a.employee_id" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,year,month,project_cost";
	private final static String[] fieldNames = { "start_date", "end_date", "employee_id"};
}
