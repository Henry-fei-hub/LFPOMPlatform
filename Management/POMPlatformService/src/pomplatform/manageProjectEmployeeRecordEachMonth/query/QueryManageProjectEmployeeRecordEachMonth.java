package pomplatform.manageProjectEmployeeRecordEachMonth.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.manageProjectEmployeeRecordEachMonth.bean.BaseManageProjectEmployeeRecordEachMonth;
import pomplatform.manageProjectEmployeeRecordEachMonth.bean.ConditionManageProjectEmployeeRecordEachMonth;

public class QueryManageProjectEmployeeRecordEachMonth extends AbstractQuery<BaseManageProjectEmployeeRecordEachMonth, ConditionManageProjectEmployeeRecordEachMonth>
{

	private static final Logger __logger = Logger.getLogger(QueryManageProjectEmployeeRecordEachMonth.class);

	public QueryManageProjectEmployeeRecordEachMonth() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseManageProjectEmployeeRecordEachMonth> executeQuery( KeyValuePair[] replacements, ConditionManageProjectEmployeeRecordEachMonth condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartdate(), 
				condition.getEnddate(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseManageProjectEmployeeRecordEachMonth generateBase(Object[] __data) throws java.sql.SQLException {
		BaseManageProjectEmployeeRecordEachMonth __base = new BaseManageProjectEmployeeRecordEachMonth();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAssignedIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT a.employee_id,b.employee_no, extract(year from a.assign_date) as year, extract(month from a.assign_date) as month, sum(a.assigned_integral) as assigned_integral from manage_project_employee_records a left join employees b on a.employee_id = b.employee_id where a.assign_date >= ? and a.assign_date <= ? and a.employee_id = ? GROUP BY a.employee_id,b.employee_no,year,month ORDER BY year,month,a.employee_id" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,year,month,assigned_integral";
	private final static String[] fieldNames = { "startDate", "endDate", "employee_id"};
}
