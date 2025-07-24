package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseOnLoadMainProjectEmployee;
import pomplatform.project.bean.ConditionOnLoadMainProjectEmployee;

public class QueryOnLoadMainProjectEmployee extends AbstractQuery<BaseOnLoadMainProjectEmployee, ConditionOnLoadMainProjectEmployee>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadMainProjectEmployee.class);

	public QueryOnLoadMainProjectEmployee() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT mpe.employee_id");
	}

	@Override
	public BaseCollection<BaseOnLoadMainProjectEmployee> executeQuery( KeyValuePair[] replacements, ConditionOnLoadMainProjectEmployee condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getRelation()
			);
	}

	public BaseCollection<BaseOnLoadMainProjectEmployee> runQuery( KeyValuePair[] replacements, ConditionOnLoadMainProjectEmployee condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getProjectId(), 
				condition.getRelation()
			);
	}

	public BaseCollection<BaseOnLoadMainProjectEmployee> execute( KeyValuePair[] replacements, ConditionOnLoadMainProjectEmployee condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getProjectId(), 
				condition.getRelation()
			);
	}

	@Override
	public BaseOnLoadMainProjectEmployee generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadMainProjectEmployee __base = new BaseOnLoadMainProjectEmployee();
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

	private final static String __SQLText = "SELECT DISTINCT mpe.employee_id FROM projects AS P LEFT JOIN contracts AS C ON P.project_code = C.project_code LEFT JOIN main_projects AS mp ON C.project_code = mp.project_code LEFT JOIN main_project_employees AS mpe ON mp.main_project_id = mpe.main_project_id WHERE mp.main_project_id > 0 and mpe.employee_id > 0 and P.project_id = ? and mpe.relation = ? and mp.process_status = 2" ;
	private final static String __originalSQL = "SELECT DISTINCT mpe.employee_id FROM projects AS P LEFT JOIN contracts AS C ON P.project_code = C.project_code LEFT JOIN main_projects AS mp ON C.project_code = mp.project_code LEFT JOIN main_project_employees AS mpe ON mp.main_project_id = mpe.main_project_id WHERE mp.main_project_id > 0 AND mpe.employee_id > 0 AND P.project_id =:project_id AND mpe.relation =:relation AND mp.process_status = 2";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"mp.main_project_id > 0 AND mpe.employee_id > 0 AND P.project_id =:project_id AND mpe.relation =:relation AND mp.process_status = 2\",\"startIndex\": 267,\"stopIndex\":396,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"mp.main_project_id > 0\",\"startIndex\": 267,\"stopIndex\":288,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mpe.employee_id > 0\",\"startIndex\": 294,\"stopIndex\":312,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"P.project_id =:project_id\",\"fullFieldName\":\"P.project_id\",\"operationName\":\"=\",\"variableName\":\"projectId\",\"startIndex\": 318,\"stopIndex\":342,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mpe.relation =:relation\",\"fullFieldName\":\"mpe.relation\",\"operationName\":\"=\",\"variableName\":\"relation\",\"startIndex\": 348,\"stopIndex\":370,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.process_status = 2\",\"startIndex\": 376,\"stopIndex\":396,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "employee_id";
	private final static String[] fieldNames = { "project_id", "relation"};
}
