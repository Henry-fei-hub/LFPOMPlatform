package pomplatform.getEmployeeIdByRoleId.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.getEmployeeIdByRoleId.bean.BasegetEmployeeByRoleIdAndDepartmentId;
import pomplatform.getEmployeeIdByRoleId.bean.ConditiongetEmployeeByRoleIdAndDepartmentId;

public class QuerygetEmployeeByRoleIdAndDepartmentId extends AbstractQuery<BasegetEmployeeByRoleIdAndDepartmentId, ConditiongetEmployeeByRoleIdAndDepartmentId>
{

	private static final Logger __logger = Logger.getLogger(QuerygetEmployeeByRoleIdAndDepartmentId.class);

	public QuerygetEmployeeByRoleIdAndDepartmentId() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_id");
	}

	@Override
	public BaseCollection<BasegetEmployeeByRoleIdAndDepartmentId> executeQuery( KeyValuePair[] replacements, ConditiongetEmployeeByRoleIdAndDepartmentId condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getRoleId(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BasegetEmployeeByRoleIdAndDepartmentId generateBase(Object[] __data) throws java.sql.SQLException {
		BasegetEmployeeByRoleIdAndDepartmentId __base = new BasegetEmployeeByRoleIdAndDepartmentId();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT DISTINCT employee_id FROM employee_roles WHERE role_id = ? AND department_id IN (SELECT child_id FROM department_ids WHERE department_id = ?)" ;
	private final static String RESULTSETFIELDLIST = "employee_id";
	private final static String[] fieldNames = { "role_id", "department_id"};
}
