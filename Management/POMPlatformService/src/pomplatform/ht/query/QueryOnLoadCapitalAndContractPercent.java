package pomplatform.ht.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.ht.bean.BaseOnLoadCapitalAndContractPercent;
import pomplatform.ht.bean.ConditionOnLoadCapitalAndContractPercent;

public class QueryOnLoadCapitalAndContractPercent extends AbstractQuery<BaseOnLoadCapitalAndContractPercent, ConditionOnLoadCapitalAndContractPercent>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadCapitalAndContractPercent.class);

	public QueryOnLoadCapitalAndContractPercent() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.contract_id");
	}

	@Override
	public BaseCollection<BaseOnLoadCapitalAndContractPercent> executeQuery( KeyValuePair[] replacements, ConditionOnLoadCapitalAndContractPercent condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getInfoCode(), 
				condition.getProjectCode(), 
				condition.getContractId()
			);
	}

	public BaseCollection<BaseOnLoadCapitalAndContractPercent> runQuery( KeyValuePair[] replacements, ConditionOnLoadCapitalAndContractPercent condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getInfoCode(), 
				condition.getProjectCode(), 
				condition.getContractId()
			);
	}

	public BaseCollection<BaseOnLoadCapitalAndContractPercent> execute( KeyValuePair[] replacements, ConditionOnLoadCapitalAndContractPercent condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getInfoCode(), 
				condition.getProjectCode(), 
				condition.getContractId()
			);
	}

	@Override
	public BaseOnLoadCapitalAndContractPercent generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadCapitalAndContractPercent __base = new BaseOnLoadCapitalAndContractPercent();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPercent(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select a.contract_id , a.info_code , a.project_code, Round(b.borrow_money/a.signing_money_sum,4) as percent from contracts as a left join (select contract_id, sum(CASE WHEN borrow_money ISNULL THEN 0 ELSE borrow_money END ) as borrow_money from capitals where contract_id > 0 GROUP BY contract_id ) as b on a.contract_id = b.contract_id where a.contract_id > 0 and b.contract_id > 0 and a.signing_money_sum >0 and a.info_code like ? and a.project_code like ? and a.contract_id = ?" ;
	private final static String __originalSQL = "select a.contract_id , a.info_code , a.project_code, Round(b.borrow_money/a.signing_money_sum,4) as percent from contracts as a left join (select contract_id, sum(CASE WHEN borrow_money ISNULL THEN 0 ELSE borrow_money END ) as borrow_money from capitals where contract_id > 0 GROUP BY contract_id ) as b on a.contract_id = b.contract_id where a.contract_id > 0 and b.contract_id > 0 and a.signing_money_sum >0 and a.info_code like :info_code and a.project_code like :project_code and a.contract_id =:contract_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"a.contract_id > 0 and b.contract_id > 0 and a.signing_money_sum >0 and a.info_code like :info_code and a.project_code like :project_code and a.contract_id =:contract_id\",\"startIndex\": 343,\"stopIndex\":510,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"a.contract_id > 0\",\"startIndex\": 343,\"stopIndex\":359,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.contract_id > 0\",\"startIndex\": 365,\"stopIndex\":381,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"a.signing_money_sum >0\",\"startIndex\": 387,\"stopIndex\":408,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"a.info_code like :info_code\",\"fullFieldName\":\"a.info_code\",\"operationName\":\"like\",\"variableName\":\"infoCode\",\"startIndex\": 414,\"stopIndex\":440,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"a.project_code like :project_code\",\"fullFieldName\":\"a.project_code\",\"operationName\":\"like\",\"variableName\":\"projectCode\",\"startIndex\": 446,\"stopIndex\":478,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"a.contract_id =:contract_id\",\"fullFieldName\":\"a.contract_id\",\"operationName\":\"=\",\"variableName\":\"contractId\",\"startIndex\": 484,\"stopIndex\":510,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "contract_id,info_code,project_code,percent";
	private final static String[] fieldNames = { "info_code", "project_code", "contract_id"};
}
