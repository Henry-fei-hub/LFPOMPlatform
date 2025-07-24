package pomplatform.role.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.role.bean.BaseEmployeeRoleInfo;
import pomplatform.role.bean.ConditionEmployeeRoleInfo;

public class QueryEmployeeRoleInfo extends AbstractQuery<BaseEmployeeRoleInfo, ConditionEmployeeRoleInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeRoleInfo.class);

	public QueryEmployeeRoleInfo() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseEmployeeRoleInfo> executeQuery( KeyValuePair[] replacements, ConditionEmployeeRoleInfo condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getRoleId()
			);
	}

	public BaseCollection<BaseEmployeeRoleInfo> runQuery( KeyValuePair[] replacements, ConditionEmployeeRoleInfo condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getRoleId()
			);
	}

	public BaseCollection<BaseEmployeeRoleInfo> execute( KeyValuePair[] replacements, ConditionEmployeeRoleInfo condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getEmployeeId(), 
				condition.getRoleId()
			);
	}

	@Override
	public BaseEmployeeRoleInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeRoleInfo __base = new BaseEmployeeRoleInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRoleId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRoleName(GenericBase.__getString(val));
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
		return __SQLText;
	}

	@Override
	public String getOriginalSQLText() {
		return __originalSQL;
	}

	@Override
	public String[] getQueryStringArray()  {
		return __queryConditions;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	@Override
	public String[] getConditionNames(){
		return fieldNames;
	}

	private final static String __SQLText = "select a.employee_id, a.role_id, b.role_name from employee_roles a LEFT JOIN roles b on a.role_id = b.role_id where a.employee_id = ? and a.role_id = ?" ;
	private final static String __originalSQL = "select a.employee_id, a.role_id, b.role_name from employee_roles a LEFT JOIN roles b on a.role_id = b.role_id where a.employee_id = :employee_id and a.role_id = :role_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"a.employee_id = :employee_id and a.role_id = :role_id\",\"startIndex\": 116,\"stopIndex\":168,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"a.employee_id = :employee_id\",\"fullFieldName\":\"a.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 116,\"stopIndex\":143,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"a.role_id = :role_id\",\"fullFieldName\":\"a.role_id\",\"operationName\":\"=\",\"variableName\":\"roleId\",\"startIndex\": 149,\"stopIndex\":168,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "employee_id,role_id,role_name";
	private final static String[] fieldNames = { "employee_id", "role_id"};
}
