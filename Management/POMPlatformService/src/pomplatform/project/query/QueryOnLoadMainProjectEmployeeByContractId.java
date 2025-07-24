package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseOnLoadMainProjectEmployeeByContractId;
import pomplatform.project.bean.ConditionOnLoadMainProjectEmployeeByContractId;

public class QueryOnLoadMainProjectEmployeeByContractId extends AbstractQuery<BaseOnLoadMainProjectEmployeeByContractId, ConditionOnLoadMainProjectEmployeeByContractId>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadMainProjectEmployeeByContractId.class);

	public QueryOnLoadMainProjectEmployeeByContractId() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT mpe.employee_id");
	}

	@Override
	public BaseCollection<BaseOnLoadMainProjectEmployeeByContractId> executeQuery( KeyValuePair[] replacements, ConditionOnLoadMainProjectEmployeeByContractId condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getRelation()
			);
	}

	public BaseCollection<BaseOnLoadMainProjectEmployeeByContractId> runQuery( KeyValuePair[] replacements, ConditionOnLoadMainProjectEmployeeByContractId condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getRelation()
			);
	}

	public BaseCollection<BaseOnLoadMainProjectEmployeeByContractId> execute( KeyValuePair[] replacements, ConditionOnLoadMainProjectEmployeeByContractId condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getRelation()
			);
	}

	@Override
	public BaseOnLoadMainProjectEmployeeByContractId generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadMainProjectEmployeeByContractId __base = new BaseOnLoadMainProjectEmployeeByContractId();
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
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

	private final static String __SQLText = "SELECT DISTINCT mpe.employee_id FROM contracts AS C LEFT JOIN main_projects AS mp ON C.project_code = mp.project_code LEFT JOIN main_project_employees AS mpe ON mp.main_project_id = mpe.main_project_id WHERE mp.main_project_id > 0 and C.contract_id = ? and C.contract_code = ? and mpe.relation = ? and mp.process_status = 2" ;
	private final static String __originalSQL = "SELECT DISTINCT mpe.employee_id FROM contracts AS C LEFT JOIN main_projects AS mp ON C.project_code = mp.project_code LEFT JOIN main_project_employees AS mpe ON mp.main_project_id = mpe.main_project_id WHERE mp.main_project_id > 0 AND C.contract_id =:contract_id AND C.contract_code =:contract_code AND mpe.relation =:relation AND mp.process_status = 2";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"mp.main_project_id > 0 AND C.contract_id =:contract_id AND C.contract_code =:contract_code AND mpe.relation =:relation AND mp.process_status = 2\",\"startIndex\": 208,\"stopIndex\":351,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"mp.main_project_id > 0\",\"startIndex\": 208,\"stopIndex\":229,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"C.contract_id =:contract_id\",\"fullFieldName\":\"C.contract_id\",\"operationName\":\"=\",\"variableName\":\"contractId\",\"startIndex\": 235,\"stopIndex\":261,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"C.contract_code =:contract_code\",\"fullFieldName\":\"C.contract_code\",\"operationName\":\"=\",\"variableName\":\"contractCode\",\"startIndex\": 267,\"stopIndex\":297,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mpe.relation =:relation\",\"fullFieldName\":\"mpe.relation\",\"operationName\":\"=\",\"variableName\":\"relation\",\"startIndex\": 303,\"stopIndex\":325,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.process_status = 2\",\"startIndex\": 331,\"stopIndex\":351,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "employee_id";
	private final static String[] fieldNames = { "contract_id", "contract_code", "relation"};
}
