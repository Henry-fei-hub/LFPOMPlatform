package pomplatform.employeeSalary.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employeeSalary.bean.BaseEmployeeSalaryDetailMonth;
import pomplatform.employeeSalary.bean.ConditionEmployeeSalaryDetailMonth;

public class QueryEmployeeSalaryDetailMonth extends AbstractQuery<BaseEmployeeSalaryDetailMonth, ConditionEmployeeSalaryDetailMonth>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeSalaryDetailMonth.class);

	public QueryEmployeeSalaryDetailMonth() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_id");
	}

	@Override
	public BaseCollection<BaseEmployeeSalaryDetailMonth> executeQuery( KeyValuePair[] replacements, ConditionEmployeeSalaryDetailMonth condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getStartYear(), 
				condition.getStartMonth(), 
				condition.getSameYearEndMonth(), 
				condition.getBiggerStartYear(), 
				condition.getSmallerEndYear(), 
				condition.getEndYear(), 
				condition.getEndMonth()
			);
	}

	@Override
	public BaseEmployeeSalaryDetailMonth generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeSalaryDetailMonth __base = new BaseEmployeeSalaryDetailMonth();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSalaryYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSalaryMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBasicSalary(GenericBase.__getString(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
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

	private final static String __SQLText = "SELECT employee_id, salary_year, salary_month, basic_salary FROM employee_salary_details WHERE employee_id = ? AND ((salary_year = ? AND salary_month >= ? AND salary_month <= ?) or (salary_year > ? and salary_year < ?) or (salary_year=? and salary_month <= ?) ) ORDER BY salary_year, salary_month" ;
	private final static String RESULTSETFIELDLIST = "employee_id,salary_year,salary_month,basic_salary";
	private final static String[] fieldNames = { "employee_id", "start_year", "start_month", "same_year_end_month", "bigger_start_year", "smaller_end_year", "end_year", "end_month"};
}
