package pomplatform.ProjectStages.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.ProjectStages.bean.BaseConfirmablePhasesList;
import pomplatform.ProjectStages.bean.ConditionConfirmablePhasesList;

public class QueryConfirmablePhasesList extends AbstractQuery<BaseConfirmablePhasesList, ConditionConfirmablePhasesList>
{

	private static final Logger __logger = Logger.getLogger(QueryConfirmablePhasesList.class);

	public QueryConfirmablePhasesList() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .contract_id");
	}

	@Override
	public BaseCollection<BaseConfirmablePhasesList> executeQuery( KeyValuePair[] replacements, ConditionConfirmablePhasesList condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getInfoCode(), 
				condition.getStatus(), 
				condition.getEmployeeId()
			);
	}

	public BaseCollection<BaseConfirmablePhasesList> runQuery( KeyValuePair[] replacements, ConditionConfirmablePhasesList condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getInfoCode(), 
				condition.getStatus(), 
				condition.getEmployeeId()
			);
	}

	public BaseCollection<BaseConfirmablePhasesList> execute( KeyValuePair[] replacements, ConditionConfirmablePhasesList condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getInfoCode(), 
				condition.getStatus(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseConfirmablePhasesList generateBase(Object[] __data) throws java.sql.SQLException {
		BaseConfirmablePhasesList __base = new BaseConfirmablePhasesList();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectAmountSum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPercentSum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBorrowMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNoBorrowMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNoPercent(GenericBase.__getDecimal(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
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

	private final static String __SQLText = "SELECT A .contract_id, A.contract_code AS project_code, A.contract_name AS project_name, A.info_code, SUM ( CASE WHEN b.project_amount ISNULL THEN 0 ELSE b.project_amount END ) AS project_amount_sum, CASE WHEN d.percent_sum ISNULL THEN 0 ELSE d.percent_sum END AS percent_sum , e.borrow_money_sum, e.percent, e.signing_money_sum - e.borrow_money_sum AS no_borrow_money_sum, 1 - e.percent AS no_percent FROM contracts AS A LEFT JOIN project_stages AS b ON A.contract_id = b.contract_id LEFT JOIN main_project_employees AS C ON b.main_project_id = C.main_project_id AND relation = 3 LEFT JOIN ( SELECT contract_id, SUM ( CASE WHEN percent ISNULL THEN 0 ELSE percent END ) AS percent_sum FROM project_stages WHERE status = 2 GROUP BY contract_id ) AS d ON A.contract_id = d.contract_id LEFT JOIN ( SELECT B.contract_id, CASE WHEN A.borrow_money_sum ISNULL THEN 0 ELSE A.borrow_money_sum END AS borrow_money_sum, CASE WHEN b.signing_money_sum ISNULL THEN 0 ELSE b.signing_money_sum END AS signing_money_sum, CASE WHEN b.signing_money_sum > 0 AND A.borrow_money_sum > 0 THEN round( A.borrow_money_sum / b.signing_money_sum, 4 ) WHEN ( b.signing_money_sum <= 0 OR b.signing_money_sum ISNULL ) AND A.borrow_money_sum > 0 THEN 1 ELSE 0 END AS percent FROM contracts AS B LEFT JOIN ( SELECT contract_id, SUM ( CASE WHEN borrow_money ISNULL THEN 0 ELSE borrow_money END ) AS borrow_money_sum FROM capitals WHERE contract_id > 0 AND borrow_money NOTNULL GROUP BY contract_id ORDER BY contract_id ) AS A ON A.contract_id = b.contract_id ) as e ON A.contract_id = e.contract_id WHERE A.contract_id > 0 and A.contract_code like ? and A.contract_name like ? and A.info_code like ? and b.status = ? and C.employee_id = ? GROUP BY A.contract_id, A.contract_code, A.contract_name, A.info_code, d.percent_sum , e.borrow_money_sum, e.percent, no_borrow_money_sum, no_percent ORDER BY A.contract_id DESC" ;
	private final static String __originalSQL = "SELECT A .contract_id, A.contract_code AS project_code, A.contract_name AS project_name, A.info_code, SUM ( CASE WHEN b.project_amount ISNULL THEN 0 ELSE b.project_amount END ) AS project_amount_sum, CASE WHEN d.percent_sum ISNULL THEN 0 ELSE d.percent_sum END AS percent_sum , e.borrow_money_sum, e.percent, e.signing_money_sum - e.borrow_money_sum AS no_borrow_money_sum, 1 - e.percent AS no_percent FROM contracts AS A LEFT JOIN project_stages AS b ON A.contract_id = b.contract_id LEFT JOIN main_project_employees AS C ON b.main_project_id = C.main_project_id AND relation = 3 LEFT JOIN ( SELECT contract_id, SUM ( CASE WHEN percent ISNULL THEN 0 ELSE percent END ) AS percent_sum FROM project_stages WHERE status = 2 GROUP BY contract_id ) AS d ON A.contract_id = d.contract_id LEFT JOIN ( SELECT B.contract_id, CASE WHEN A.borrow_money_sum ISNULL THEN 0 ELSE A.borrow_money_sum END AS borrow_money_sum, CASE WHEN b.signing_money_sum ISNULL THEN 0 ELSE b.signing_money_sum END AS signing_money_sum, CASE WHEN b.signing_money_sum > 0 AND A.borrow_money_sum > 0 THEN round( A.borrow_money_sum / b.signing_money_sum, 4 ) WHEN ( b.signing_money_sum <= 0 OR b.signing_money_sum ISNULL ) AND A.borrow_money_sum > 0 THEN 1 ELSE 0 END AS percent FROM contracts AS B LEFT JOIN ( SELECT contract_id, SUM ( CASE WHEN borrow_money ISNULL THEN 0 ELSE borrow_money END ) AS borrow_money_sum FROM capitals WHERE contract_id > 0 AND borrow_money NOTNULL GROUP BY contract_id ORDER BY contract_id ) AS A ON A.contract_id = b.contract_id ) as e ON A.contract_id = e.contract_id WHERE A.contract_id > 0 AND A.contract_code LIKE :contract_code AND A.contract_name LIKE :contract_name AND A.info_code LIKE :info_code AND b.status =:status AND C.employee_id =:employee_id GROUP BY A.contract_id, A.contract_code, A.contract_name, A.info_code, d.percent_sum , e.borrow_money_sum, e.percent, no_borrow_money_sum, no_percent ORDER BY A.contract_id DESC";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"A.contract_id > 0 AND A.contract_code LIKE :contract_code AND A.contract_name LIKE :contract_name AND A.info_code LIKE :info_code AND b.status =:status AND C.employee_id =:employee_id\",\"startIndex\": 1571,\"stopIndex\":1753,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"A.contract_id > 0\",\"startIndex\": 1571,\"stopIndex\":1587,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.contract_code LIKE :contract_code\",\"fullFieldName\":\"A.contract_code\",\"operationName\":\"like\",\"variableName\":\"contractCode\",\"startIndex\": 1593,\"stopIndex\":1627,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.contract_name LIKE :contract_name\",\"fullFieldName\":\"A.contract_name\",\"operationName\":\"like\",\"variableName\":\"contractName\",\"startIndex\": 1633,\"stopIndex\":1667,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.info_code LIKE :info_code\",\"fullFieldName\":\"A.info_code\",\"operationName\":\"like\",\"variableName\":\"infoCode\",\"startIndex\": 1673,\"stopIndex\":1699,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.status =:status\",\"fullFieldName\":\"b.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"startIndex\": 1705,\"stopIndex\":1721,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"C.employee_id =:employee_id\",\"fullFieldName\":\"C.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"startIndex\": 1727,\"stopIndex\":1753,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "contract_id,project_code,project_name,info_code,project_amount_sum,percent_sum,borrow_money_sum,percent,no_borrow_money_sum,no_percent";
	private final static String[] fieldNames = { "contract_code", "contract_name", "info_code", "status", "employee_id"};
}
