package pomplatform.workflow.personnelbusiness.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.personnelbusiness.bean.BaseNumberOfPunches;
import pomplatform.workflow.personnelbusiness.bean.ConditionNumberOfPunches;

public class QueryNumberOfPunches extends AbstractQuery<BaseNumberOfPunches, ConditionNumberOfPunches>
{

	private static final Logger __logger = Logger.getLogger(QueryNumberOfPunches.class);

	public QueryNumberOfPunches() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("count(*) from system_process_instances where process_type = 15 and employee_id =:employee_id and process_status in (0");
	}

	@Override
	public BaseCollection<BaseNumberOfPunches> executeQuery( KeyValuePair[] replacements, ConditionNumberOfPunches condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getEmployeeId()
			);
	}

	public BaseCollection<BaseNumberOfPunches> runQuery( KeyValuePair[] replacements, ConditionNumberOfPunches condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getEmployeeId()
			);
	}

	public BaseCollection<BaseNumberOfPunches> execute( KeyValuePair[] replacements, ConditionNumberOfPunches condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseNumberOfPunches generateBase(Object[] __data) throws java.sql.SQLException {
		BaseNumberOfPunches __base = new BaseNumberOfPunches();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCount(GenericBase.__getLong(val));
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

	private final static String __SQLText = "select count(*) from system_process_instances where process_type = 15 and employee_id = ? and process_status in (0,1,3,4)" ;
	private final static String __originalSQL = "select count(*) from system_process_instances where process_type = 15 and employee_id =:employee_id and process_status in (0,1,3,4)";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"process_type = 15 and employee_id =:employee_id and process_status in (0,1,3,4)\",\"startIndex\": 52,\"stopIndex\":130,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"process_type = 15\",\"nextToken\":\"and\",\"startIndex\": 52,\"stopIndex\":68,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"employee_id =:employee_id\",\"fullFieldName\":\"employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 74,\"stopIndex\":98,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"process_status in (0,1,3,4)\",\"startIndex\": 104,\"stopIndex\":130,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "count";
	private final static String[] fieldNames = { "employee_id"};
}
