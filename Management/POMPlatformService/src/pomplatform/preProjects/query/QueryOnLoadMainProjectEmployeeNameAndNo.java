package pomplatform.preProjects.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.preProjects.bean.BaseOnLoadMainProjectEmployeeNameAndNo;
import pomplatform.preProjects.bean.ConditionOnLoadMainProjectEmployeeNameAndNo;

public class QueryOnLoadMainProjectEmployeeNameAndNo extends AbstractQuery<BaseOnLoadMainProjectEmployeeNameAndNo, ConditionOnLoadMainProjectEmployeeNameAndNo>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadMainProjectEmployeeNameAndNo.class);

	public QueryOnLoadMainProjectEmployeeNameAndNo() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT a.employee_id");
	}

	@Override
	public BaseCollection<BaseOnLoadMainProjectEmployeeNameAndNo> executeQuery( KeyValuePair[] replacements, ConditionOnLoadMainProjectEmployeeNameAndNo condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getMainProjectId()
			);
	}

	public BaseCollection<BaseOnLoadMainProjectEmployeeNameAndNo> runQuery( KeyValuePair[] replacements, ConditionOnLoadMainProjectEmployeeNameAndNo condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getMainProjectId()
			);
	}

	public BaseCollection<BaseOnLoadMainProjectEmployeeNameAndNo> execute( KeyValuePair[] replacements, ConditionOnLoadMainProjectEmployeeNameAndNo condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getMainProjectId()
			);
	}

	@Override
	public BaseOnLoadMainProjectEmployeeNameAndNo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadMainProjectEmployeeNameAndNo __base = new BaseOnLoadMainProjectEmployeeNameAndNo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
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

	private final static String __SQLText = "select DISTINCT a.employee_id, concat(b.employee_no,'-',b.employee_name) as employee_name from main_project_employees as a left join employees as b on a.employee_id = b.employee_id where a.employee_id >0 and a.main_project_id >0 and a.main_project_id = ?" ;
	private final static String __originalSQL = "select DISTINCT a.employee_id, concat(b.employee_no,'-',b.employee_name) as employee_name from main_project_employees as a left join employees as b on a.employee_id = b.employee_id where a.employee_id >0 and a.main_project_id >0 and a.main_project_id =:main_project_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"a.employee_id >0 and a.main_project_id >0 and a.main_project_id =:main_project_id\",\"startIndex\": 187,\"stopIndex\":267,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"a.employee_id >0\",\"startIndex\": 187,\"stopIndex\":202,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"a.main_project_id >0\",\"startIndex\": 208,\"stopIndex\":227,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"a.main_project_id =:main_project_id\",\"fullFieldName\":\"a.main_project_id\",\"operationName\":\"=\",\"variableName\":\"mainProjectId\",\"startIndex\": 233,\"stopIndex\":267,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "employee_id,employee_name";
	private final static String[] fieldNames = { "main_project_id"};
}
