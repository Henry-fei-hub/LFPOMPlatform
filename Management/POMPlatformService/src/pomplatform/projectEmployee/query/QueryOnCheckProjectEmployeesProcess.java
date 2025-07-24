package pomplatform.projectEmployee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectEmployee.bean.BaseOnCheckProjectEmployeesProcess;
import pomplatform.projectEmployee.bean.ConditionOnCheckProjectEmployeesProcess;

public class QueryOnCheckProjectEmployeesProcess extends AbstractQuery<BaseOnCheckProjectEmployeesProcess, ConditionOnCheckProjectEmployeesProcess>
{

	private static final Logger __logger = Logger.getLogger(QueryOnCheckProjectEmployeesProcess.class);

	public QueryOnCheckProjectEmployeesProcess() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.project_id");
	}

	@Override
	public BaseCollection<BaseOnCheckProjectEmployeesProcess> executeQuery( KeyValuePair[] replacements, ConditionOnCheckProjectEmployeesProcess condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	public BaseCollection<BaseOnCheckProjectEmployeesProcess> runQuery( KeyValuePair[] replacements, ConditionOnCheckProjectEmployeesProcess condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getProjectId()
			);
	}

	public BaseCollection<BaseOnCheckProjectEmployeesProcess> execute( KeyValuePair[] replacements, ConditionOnCheckProjectEmployeesProcess condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseOnCheckProjectEmployeesProcess generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnCheckProjectEmployeesProcess __base = new BaseOnCheckProjectEmployeesProcess();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select b.project_id, a.process_status from system_process_instances as a left join personnel_business as b on a.business_id =b.personnel_business_id and a.process_type = b.process_type where a.business_id>0 and b.project_id >0 and a.process_type = 79 and b.project_id = ? and a.process_status NOT in (3,5)" ;
	private final static String __originalSQL = "select b.project_id, a.process_status from system_process_instances as a left join personnel_business as b on a.business_id =b.personnel_business_id and a.process_type = b.process_type where a.business_id>0 and b.project_id >0 and a.process_type = 79 and b.project_id =:project_id and a.process_status NOT in (3,5)";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"a.business_id>0 and b.project_id >0 and a.process_type = 79 and b.project_id =:project_id and a.process_status NOT in (3,5)\",\"startIndex\": 191,\"stopIndex\":313,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"a.business_id>0\",\"startIndex\": 191,\"stopIndex\":205,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.project_id >0\",\"startIndex\": 211,\"stopIndex\":225,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"a.process_type = 79\",\"startIndex\": 231,\"stopIndex\":249,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.project_id =:project_id\",\"fullFieldName\":\"b.project_id\",\"operationName\":\"=\",\"variableName\":\"projectId\",\"startIndex\": 255,\"stopIndex\":279,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"a.process_status NOT in (3,5)\",\"startIndex\": 285,\"stopIndex\":313,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "project_id,process_status";
	private final static String[] fieldNames = { "project_id"};
}
