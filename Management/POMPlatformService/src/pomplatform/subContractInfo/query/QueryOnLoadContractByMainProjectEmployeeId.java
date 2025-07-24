package pomplatform.subContractInfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.subContractInfo.bean.BaseOnLoadContractByMainProjectEmployeeId;
import pomplatform.subContractInfo.bean.ConditionOnLoadContractByMainProjectEmployeeId;

public class QueryOnLoadContractByMainProjectEmployeeId extends AbstractQuery<BaseOnLoadContractByMainProjectEmployeeId, ConditionOnLoadContractByMainProjectEmployeeId>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadContractByMainProjectEmployeeId.class);

	public QueryOnLoadContractByMainProjectEmployeeId() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .contract_id");
	}

	@Override
	public BaseCollection<BaseOnLoadContractByMainProjectEmployeeId> executeQuery( KeyValuePair[] replacements, ConditionOnLoadContractByMainProjectEmployeeId condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getRelation()
			);
	}

	public BaseCollection<BaseOnLoadContractByMainProjectEmployeeId> runQuery( KeyValuePair[] replacements, ConditionOnLoadContractByMainProjectEmployeeId condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getRelation()
			);
	}

	public BaseCollection<BaseOnLoadContractByMainProjectEmployeeId> execute( KeyValuePair[] replacements, ConditionOnLoadContractByMainProjectEmployeeId condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getEmployeeId(), 
				condition.getRelation()
			);
	}

	@Override
	public BaseOnLoadContractByMainProjectEmployeeId generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadContractByMainProjectEmployeeId __base = new BaseOnLoadContractByMainProjectEmployeeId();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRelation(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainProjectEmployeeId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT A .contract_id, b.main_project_id, A.contract_code, A.contract_name, C.relation, C.employee_id, C.main_project_employee_id FROM ( SELECT * FROM main_project_employees WHERE employee_id = ? and relation = ? ) AS C LEFT JOIN main_projects AS b ON b.main_project_id = C.main_project_id LEFT JOIN contracts AS A ON A.project_code = b.project_code WHERE A.contract_id > 0 AND C.main_project_id > 0 ORDER BY A.contract_id DESC" ;
	private final static String __originalSQL = "SELECT A .contract_id, b.main_project_id, A.contract_code, A.contract_name, C.relation, C.employee_id, C.main_project_employee_id FROM ( SELECT * FROM main_project_employees WHERE employee_id =:employee_id AND relation =:relation ) AS C LEFT JOIN main_projects AS b ON b.main_project_id = C.main_project_id LEFT JOIN contracts AS A ON A.project_code = b.project_code WHERE A.contract_id > 0 AND C.main_project_id > 0 ORDER BY A.contract_id DESC";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"employee_id =:employee_id AND relation =:relation\",\"startIndex\": 180,\"stopIndex\":228,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"employee_id =:employee_id\",\"fullFieldName\":\"employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"startIndex\": 180,\"stopIndex\":204,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"relation =:relation\",\"fullFieldName\":\"relation\",\"operationName\":\"=\",\"variableName\":\"relation\",\"startIndex\": 210,\"stopIndex\":228,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "contract_id,main_project_id,contract_code,contract_name,relation,employee_id,main_project_employee_id";
	private final static String[] fieldNames = { "employee_id", "relation"};
}
