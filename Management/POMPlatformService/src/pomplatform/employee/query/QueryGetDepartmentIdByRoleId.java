package pomplatform.employee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employee.bean.BaseGetDepartmentIdByRoleId;
import pomplatform.employee.bean.ConditionGetDepartmentIdByRoleId;

public class QueryGetDepartmentIdByRoleId extends AbstractQuery<BaseGetDepartmentIdByRoleId, ConditionGetDepartmentIdByRoleId>
{

	private static final Logger __logger = Logger.getLogger(QueryGetDepartmentIdByRoleId.class);

	public QueryGetDepartmentIdByRoleId() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT(child_id) as department_id");
	}

	@Override
	public BaseCollection<BaseGetDepartmentIdByRoleId> executeQuery( KeyValuePair[] replacements, ConditionGetDepartmentIdByRoleId condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getRoleId()
			);
	}

	@Override
	public BaseGetDepartmentIdByRoleId generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetDepartmentIdByRoleId __base = new BaseGetDepartmentIdByRoleId();
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

	private final static String __SQLText = "SELECT DISTINCT(child_id) as department_id from department_ids where department_id in (SELECT department_id from employee_roles where employee_id = ? and role_id = ?)" ;
	private final static String RESULTSETFIELDLIST = "department_id";
	private final static String[] fieldNames = { "employee_id", "role_id"};
}
