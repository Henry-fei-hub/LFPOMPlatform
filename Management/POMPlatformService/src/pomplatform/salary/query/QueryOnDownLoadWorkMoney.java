package pomplatform.salary.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.salary.bean.BaseOnDownLoadWorkMoney;
import pomplatform.salary.bean.ConditionOnDownLoadWorkMoney;

public class QueryOnDownLoadWorkMoney extends AbstractQuery<BaseOnDownLoadWorkMoney, ConditionOnDownLoadWorkMoney>
{

	private static final Logger __logger = Logger.getLogger(QueryOnDownLoadWorkMoney.class);

	public QueryOnDownLoadWorkMoney() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("e.employee_no");
	}

	@Override
	public BaseCollection<BaseOnDownLoadWorkMoney> executeQuery( KeyValuePair[] replacements, ConditionOnDownLoadWorkMoney condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getEmployeeId(), 
				condition.getEmployeeNo(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseOnDownLoadWorkMoney generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnDownLoadWorkMoney __base = new BaseOnDownLoadWorkMoney();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWorkYears(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWorkMoney(GenericBase.__getString(val));
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
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
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

	private final static String __SQLText = "SELECT e.employee_no,e.employee_name,a.year,a.month,a.work_years,a.work_money FROM salary_of_work_years a LEFT JOIN employees e ON a.employee_id = e.employee_id WHERE a.year = ? AND a.month = ? AND e.employee_id = ? AND e.employee_no like ? AND e.department_id in (select child_id from department_ids where department_id = ?) ORDER BY e.employee_id,a.month" ;
	private final static String RESULTSETFIELDLIST = "employee_no,employee_name,year,month,work_years,work_money";
	private final static String[] fieldNames = { "year", "month", "employee_id", "employee_no", "department_id"};
}
