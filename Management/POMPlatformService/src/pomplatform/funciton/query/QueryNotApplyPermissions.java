package pomplatform.funciton.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.funciton.bean.BaseNotApplyPermissions;
import pomplatform.funciton.bean.ConditionNotApplyPermissions;

public class QueryNotApplyPermissions extends AbstractQuery<BaseNotApplyPermissions, ConditionNotApplyPermissions>
{

	private static final Logger __logger = Logger.getLogger(QueryNotApplyPermissions.class);

	public QueryNotApplyPermissions() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .function_id");
	}

	@Override
	public BaseCollection<BaseNotApplyPermissions> executeQuery( KeyValuePair[] replacements, ConditionNotApplyPermissions condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getDepartmentId(), 
				condition.getEmployeeId(), 
				condition.getApplicationId()
			);
	}

	@Override
	public BaseNotApplyPermissions generateBase(Object[] __data) throws java.sql.SQLException {
		BaseNotApplyPermissions __base = new BaseNotApplyPermissions();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setFunctionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFunctionCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFunctionName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setApplicationId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFunctionType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPrivilegeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEnabled(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setFunctionStaticName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmpFun(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setRoleFun(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setDepartmentRoleFun(GenericBase.__getBoolean(val));
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

	private final static String __SQLText = "SELECT A .function_id, b.function_code, b.parent_id, b.function_name, b.application_id, b.function_type, b.privilege_type, b.enabled, b.function_static_name, CASE WHEN SUM ( A.emp_fun ) = 0 THEN FALSE ELSE TRUE END AS emp_fun, CASE WHEN SUM ( A.role_fun ) = 0 THEN FALSE ELSE TRUE END AS role_fun, CASE WHEN SUM ( A.department_role_fun ) = 0 THEN FALSE ELSE TRUE END AS department_role_fun FROM ( SELECT function_id, 1 AS emp_fun, 0 AS role_fun, 0 AS department_role_fun FROM employee_functions UNION SELECT function_id, 0 AS emp_fun, 1 AS role_fun, 0 AS department_role_fun FROM employee_roles er LEFT JOIN role_functions rf ON er.role_id = rf.role_id WHERE er.department_id = 0 UNION SELECT function_id, 0 AS emp_fun, 0 AS role_fun, 1 AS department_role_fun FROM employee_roles er LEFT JOIN department_role_functions drf ON er.department_id = drf.department_id AND er.role_id = drf.role_id WHERE er.department_id <> 0 ) AS A LEFT JOIN functions b ON A.function_id = b.function_id WHERE b.application_id = 1 AND A.function_id NOT IN ( SELECT C .function_id FROM ( SELECT function_id, 1 AS emp_fun, 0 AS role_fun, 0 AS department_role_fun FROM employee_functions WHERE employee_id = ? UNION SELECT function_id, 0 AS emp_fun, 1 AS role_fun, 0 AS department_role_fun FROM employee_roles er LEFT JOIN role_functions rf ON er.role_id = rf.role_id WHERE er.employee_id = ? AND er.department_id = ? UNION SELECT function_id, 0 AS emp_fun, 0 AS role_fun, 1 AS department_role_fun FROM employee_roles er LEFT JOIN department_role_functions drf ON er.department_id = drf.department_id AND er.role_id = drf.role_id WHERE er.department_id <> 0 AND er.employee_id = ? ) AS C LEFT JOIN functions d ON C.function_id = d.function_id WHERE d.application_id = ? AND C.function_id <> 0 ) GROUP BY A.function_id, b.function_code, b.parent_id, b.function_name, b.application_id, b.function_type, b.privilege_type, b.enabled, b.function_static_name ORDER BY A.function_id ASC" ;
	private final static String RESULTSETFIELDLIST = "function_id,function_code,parent_id,function_name,application_id,function_type,privilege_type,enabled,function_static_name,emp_fun,role_fun,department_role_fun";
	private final static String[] fieldNames = { "employee_id", "employee_id", "department_id", "employee_id", "application_id"};
}
