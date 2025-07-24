package pomplatform.department.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.department.bean.BaseOnLoadDepartmentByParentId;
import pomplatform.department.bean.ConditionOnLoadDepartmentByParentId;

public class QueryOnLoadDepartmentByParentId extends AbstractQuery<BaseOnLoadDepartmentByParentId, ConditionOnLoadDepartmentByParentId>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadDepartmentByParentId.class);

	public QueryOnLoadDepartmentByParentId() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("");
	}

	@Override
	public BaseCollection<BaseOnLoadDepartmentByParentId> executeQuery( KeyValuePair[] replacements, ConditionOnLoadDepartmentByParentId condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getDepartmentId()
			);
	}

	public BaseCollection<BaseOnLoadDepartmentByParentId> runQuery( KeyValuePair[] replacements, ConditionOnLoadDepartmentByParentId condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getDepartmentId()
			);
	}

	public BaseCollection<BaseOnLoadDepartmentByParentId> execute( KeyValuePair[] replacements, ConditionOnLoadDepartmentByParentId condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseOnLoadDepartmentByParentId generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadDepartmentByParentId __base = new BaseOnLoadDepartmentByParentId();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "WITH RECURSIVE le (department_id,department_name,parent_id,path,depath) as ( select department_id,department_name,parent_id ,ARRAY[department_id] AS path,1 AS depath from departments where department_id = ? union all select e2.department_id,e2.department_name,e2.parent_id,le.path || e2.department_id, le.depath + 1 AS depath from departments e2,le where e2.parent_id=le.department_id ) select department_id,department_name,parent_id from le" ;
	private final static String __originalSQL = "WITH RECURSIVE le (department_id,department_name,parent_id,path,depath) as ( select department_id,department_name,parent_id ,ARRAY[department_id] AS path,1 AS depath from departments where department_id =:department_id union all select e2.department_id,e2.department_name,e2.parent_id,le.path || e2.department_id, le.depath + 1 AS depath from departments e2,le where e2.parent_id=le.department_id ) select department_id,department_name,parent_id from le";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"department_id =:department_id\",\"startIndex\": 189,\"stopIndex\":217,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"department_id =:department_id\",\"fullFieldName\":\"department_id\",\"operationName\":\"=\",\"variableName\":\"departmentId\",\"startIndex\": 189,\"stopIndex\":217,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "department_id,department_name,parent_id";
	private final static String[] fieldNames = { "department_id"};
}
