package pomplatform.funciton.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.funciton.bean.BaseGetDepartmentIdByEmployeeIdAndFunctionCode;
import pomplatform.funciton.bean.ConditionGetDepartmentIdByEmployeeIdAndFunctionCode;

public class QueryGetDepartmentIdByEmployeeIdAndFunctionCode extends AbstractQuery<BaseGetDepartmentIdByEmployeeIdAndFunctionCode, ConditionGetDepartmentIdByEmployeeIdAndFunctionCode>
{

	private static final Logger __logger = Logger.getLogger(QueryGetDepartmentIdByEmployeeIdAndFunctionCode.class);

	public QueryGetDepartmentIdByEmployeeIdAndFunctionCode() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT child_id as department_id");
	}

	@Override
	public BaseCollection<BaseGetDepartmentIdByEmployeeIdAndFunctionCode> executeQuery( KeyValuePair[] replacements, ConditionGetDepartmentIdByEmployeeIdAndFunctionCode condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getFunctionCode(),
				condition.getApplicationId(),
				condition.getEmployeeId(),
				condition.getFunctionCode(),
				condition.getApplicationId()
			);
	}

	@Override
	public BaseGetDepartmentIdByEmployeeIdAndFunctionCode generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetDepartmentIdByEmployeeIdAndFunctionCode __base = new BaseGetDepartmentIdByEmployeeIdAndFunctionCode();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "SELECT DISTINCT child_id as department_id from department_ids where (department_id in (select department_id from employee_roles where employee_id = ? and role_id in (SELECT role_id from role_functions where function_id in (SELECT function_id from functions where function_code = ? and application_id = ?)) and department_id is not null) or department_id in (SELECT DISTINCT b.department_id from employee_roles a left join department_role_functions b on a.role_id = b.role_id and a.department_id = b.department_id where a.employee_id = ? and b.function_id in (SELECT function_id from functions where function_code = ? and application_id = ?) and b.department_id is not null)) and child_id is not null" ;
	private final static String RESULTSETFIELDLIST = "department_id";
	private final static String[] fieldNames = { "employee_id", "function_code", "application_id", "employee_id", "function_code", "application_id"};
}
