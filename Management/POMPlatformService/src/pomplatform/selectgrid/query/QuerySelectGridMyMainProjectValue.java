package pomplatform.selectgrid.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.selectgrid.bean.BaseSelectGridMyMainProjectValue;
import pomplatform.selectgrid.bean.ConditionSelectGridMyMainProjectValue;

public class QuerySelectGridMyMainProjectValue extends AbstractQuery<BaseSelectGridMyMainProjectValue, ConditionSelectGridMyMainProjectValue>
{

	private static final Logger __logger = Logger.getLogger(QuerySelectGridMyMainProjectValue.class);

	public QuerySelectGridMyMainProjectValue() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("mp.main_project_id");
	}

	@Override
	public BaseCollection<BaseSelectGridMyMainProjectValue> executeQuery( KeyValuePair[] replacements, ConditionSelectGridMyMainProjectValue condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getEmployeeId()
			);
	}

	public BaseCollection<BaseSelectGridMyMainProjectValue> runQuery( KeyValuePair[] replacements, ConditionSelectGridMyMainProjectValue condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getEmployeeId()
			);
	}

	public BaseCollection<BaseSelectGridMyMainProjectValue> execute( KeyValuePair[] replacements, ConditionSelectGridMyMainProjectValue condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseSelectGridMyMainProjectValue generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSelectGridMyMainProjectValue __base = new BaseSelectGridMyMainProjectValue();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT mp.main_project_id, mp.project_code, mp.project_name FROM main_projects mp WHERE mp.main_project_id IN ( SELECT main_project_id FROM main_project_employees WHERE employee_id = ? ) and process_status =2" ;
	private final static String __originalSQL = "SELECT mp.main_project_id, mp.project_code, mp.project_name FROM main_projects mp WHERE mp.main_project_id IN ( SELECT main_project_id FROM main_project_employees WHERE employee_id =:employee_id ) and process_status =2";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"mp.main_project_id IN ( SELECT main_project_id FROM main_project_employees WHERE employee_id =:employee_id ) and process_status =2\",\"startIndex\": 88,\"stopIndex\":217,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"mp.main_project_id IN ( SELECT main_project_id FROM main_project_employees WHERE employee_id =:employee_id )\",\"nextToken\":\"and\",\"startIndex\": 88,\"stopIndex\":195,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"employee_id =:employee_id\",\"startIndex\": 169,\"stopIndex\":193,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"employee_id =:employee_id\",\"fullFieldName\":\"employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"startIndex\": 169,\"stopIndex\":193,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]},{\"fullCondition\": \"process_status =2\",\"startIndex\": 201,\"stopIndex\":217,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "main_project_id,project_code,project_name";
	private final static String[] fieldNames = { "employee_id"};
}
