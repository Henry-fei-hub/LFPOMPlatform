package pomplatform.employeerescord.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employeerescord.bean.BaseOnboardEmployee;
import pomplatform.employeerescord.bean.ConditionOnboardEmployee;

public class QueryOnboardEmployee extends AbstractQuery<BaseOnboardEmployee, ConditionOnboardEmployee>
{

	private static final Logger __logger = Logger.getLogger(QueryOnboardEmployee.class);

	public QueryOnboardEmployee() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_id");
	}

	@Override
	public BaseCollection<BaseOnboardEmployee> executeQuery( KeyValuePair[] replacements, ConditionOnboardEmployee condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseOnboardEmployee generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnboardEmployee __base = new BaseOnboardEmployee();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "select employee_id , employee_name , employee_no , plate_id from employees where status = 0 and onboard_date >? and onboard_date <? and employee_id =? and plate_id =?" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_name,employee_no,plate_id";
	private final static String[] fieldNames = { "start_date", "end_date", "employee_id", "plate_id"};
}
