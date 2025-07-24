package pomplatform.contractMessage.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contractMessage.bean.BaseOnLoadContractMessageByEmployeeId;
import pomplatform.contractMessage.bean.ConditionOnLoadContractMessageByEmployeeId;

public class QueryOnLoadContractMessageByEmployeeId extends AbstractQuery<BaseOnLoadContractMessageByEmployeeId, ConditionOnLoadContractMessageByEmployeeId>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadContractMessageByEmployeeId.class);

	public QueryOnLoadContractMessageByEmployeeId() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("AA.employee_id");
	}

	@Override
	public BaseCollection<BaseOnLoadContractMessageByEmployeeId> executeQuery( KeyValuePair[] replacements, ConditionOnLoadContractMessageByEmployeeId condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getEmployeeId()
			);
	}

	public BaseCollection<BaseOnLoadContractMessageByEmployeeId> runQuery( KeyValuePair[] replacements, ConditionOnLoadContractMessageByEmployeeId condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getContractId(), 
				condition.getEmployeeId()
			);
	}

	public BaseCollection<BaseOnLoadContractMessageByEmployeeId> execute( KeyValuePair[] replacements, ConditionOnLoadContractMessageByEmployeeId condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getContractId(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseOnLoadContractMessageByEmployeeId generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadContractMessageByEmployeeId __base = new BaseOnLoadContractMessageByEmployeeId();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStringAgg(GenericBase.__getString(val));
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

	private final static String __SQLText = "select AA.employee_id, string_agg(AA.code_name,';') from (SELECT concat ( A.contract_code, '---', A.contract_name) AS code_name, d.employee_id FROM contract_messages C LEFT JOIN contracts AS A ON C.contract_id = A.contract_id AND C.msg_status = 1 LEFT JOIN main_projects b ON A.contract_code = b.project_code LEFT JOIN main_project_employees d on b.main_project_id = d.main_project_id WHERE b.main_project_id > 0 and A.contract_id >0 and A.contract_id = ? and D.employee_id = ? order by a.contract_id asc ) as AA GROUP BY aa.employee_id" ;
	private final static String __originalSQL = "select AA.employee_id, string_agg(AA.code_name,';') from (SELECT concat ( A.contract_code, '---', A.contract_name) AS code_name, d.employee_id FROM contract_messages C LEFT JOIN contracts AS A ON C.contract_id = A.contract_id AND C.msg_status = 1 LEFT JOIN main_projects b ON A.contract_code = b.project_code LEFT JOIN main_project_employees d on b.main_project_id = d.main_project_id WHERE b.main_project_id > 0 AND A.contract_id >0 AND A.contract_id =:contract_id AND D.employee_id =:employee_id order by a.contract_id asc ) as AA GROUP BY aa.employee_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"b.main_project_id > 0 AND A.contract_id >0 AND A.contract_id =:contract_id AND D.employee_id =:employee_id\",\"startIndex\": 391,\"stopIndex\":496,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"b.main_project_id > 0\",\"nextToken\":\"and\",\"startIndex\": 391,\"stopIndex\":411,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.contract_id >0\",\"nextToken\":\"and\",\"startIndex\": 417,\"stopIndex\":432,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.contract_id =:contract_id\",\"fullFieldName\":\"A.contract_id\",\"operationName\":\"=\",\"variableName\":\"contractId\",\"nextToken\":\"and\",\"startIndex\": 438,\"stopIndex\":464,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"D.employee_id =:employee_id\",\"fullFieldName\":\"D.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"startIndex\": 470,\"stopIndex\":496,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "employee_id,string_agg";
	private final static String[] fieldNames = { "contract_id", "employee_id"};
}
