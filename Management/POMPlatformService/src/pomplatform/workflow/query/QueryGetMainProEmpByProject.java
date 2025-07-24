package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseGetMainProEmpByProject;
import pomplatform.workflow.bean.ConditionGetMainProEmpByProject;

public class QueryGetMainProEmpByProject extends AbstractQuery<BaseGetMainProEmpByProject, ConditionGetMainProEmpByProject>
{

	private static final Logger __logger = Logger.getLogger(QueryGetMainProEmpByProject.class);

	public QueryGetMainProEmpByProject() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("distinct d.employee_id");
	}

	@Override
	public BaseCollection<BaseGetMainProEmpByProject> executeQuery( KeyValuePair[] replacements, ConditionGetMainProEmpByProject condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getRelation()
			);
	}

	public BaseCollection<BaseGetMainProEmpByProject> runQuery( KeyValuePair[] replacements, ConditionGetMainProEmpByProject condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getProjectId(), 
				condition.getRelation()
			);
	}

	public BaseCollection<BaseGetMainProEmpByProject> execute( KeyValuePair[] replacements, ConditionGetMainProEmpByProject condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getProjectId(), 
				condition.getRelation()
			);
	}

	@Override
	public BaseGetMainProEmpByProject generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetMainProEmpByProject __base = new BaseGetMainProEmpByProject();
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

	private final static String __SQLText = "select distinct d.employee_id from projects a LEFT JOIN contracts b on a.contract_id = b.contract_id LEFT JOIN main_projects c on b.info_code = c.info_code LEFT JOIN main_project_employees d on c.main_project_id = d.main_project_id LEFT JOIN employees e on d.employee_id = e.employee_id where a.project_id = ? and d.relation = ? and d.employee_id is not null and e.status = 0" ;
	private final static String __originalSQL = "select distinct d.employee_id from projects a LEFT JOIN contracts b on a.contract_id = b.contract_id LEFT JOIN main_projects c on b.info_code = c.info_code LEFT JOIN main_project_employees d on c.main_project_id = d.main_project_id LEFT JOIN employees e on d.employee_id = e.employee_id where a.project_id = :project_id and d.relation = :relation and d.employee_id is not null and e.status = 0";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"a.project_id = :project_id and d.relation = :relation and d.employee_id is not null and e.status = 0\",\"startIndex\": 293,\"stopIndex\":392,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"a.project_id = :project_id\",\"fullFieldName\":\"a.project_id\",\"operationName\":\"=\",\"variableName\":\"projectId\",\"nextToken\":\"and\",\"startIndex\": 293,\"stopIndex\":318,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"d.relation = :relation\",\"fullFieldName\":\"d.relation\",\"operationName\":\"=\",\"variableName\":\"relation\",\"nextToken\":\"and\",\"startIndex\": 324,\"stopIndex\":345,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"d.employee_id is not null\",\"nextToken\":\"and\",\"startIndex\": 351,\"stopIndex\":375,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"e.status = 0\",\"startIndex\": 381,\"stopIndex\":392,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "employee_id";
	private final static String[] fieldNames = { "project_id", "relation"};
}
