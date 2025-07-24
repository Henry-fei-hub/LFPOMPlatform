package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseOnLoadProjectOverview;
import pomplatform.project.bean.ConditionOnLoadProjectOverview;

public class QueryOnLoadProjectOverview extends AbstractQuery<BaseOnLoadProjectOverview, ConditionOnLoadProjectOverview>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadProjectOverview.class);

	public QueryOnLoadProjectOverview() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .contract_id");
	}

	@Override
	public BaseCollection<BaseOnLoadProjectOverview> executeQuery( KeyValuePair[] replacements, ConditionOnLoadProjectOverview condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getSettlementStatus(), 
				condition.getContractId(), 
				condition.getProjectId()
			);
	}

	public BaseCollection<BaseOnLoadProjectOverview> runQuery( KeyValuePair[] replacements, ConditionOnLoadProjectOverview condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getSettlementStatus(), 
				condition.getContractId(), 
				condition.getProjectId()
			);
	}

	public BaseCollection<BaseOnLoadProjectOverview> execute( KeyValuePair[] replacements, ConditionOnLoadProjectOverview condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getSettlementStatus(), 
				condition.getContractId(), 
				condition.getProjectId()
			);
	}

	@Override
	public BaseOnLoadProjectOverview generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadProjectOverview __base = new BaseOnLoadProjectOverview();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalCount(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeftAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReserveAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSureAmount(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT A .contract_id, b.project_id, b.total_integral, b.reserve_integral, b.project_integral, ( SELECT CASE WHEN SUM ( percent ) ISNULL THEN 0 ELSE SUM ( percent ) END AS percent FROM project_stages WHERE percent > 0 AND contract_id = A.contract_id AND status = 2 ), ( SELECT COUNT ( settlement_id ) AS total_count FROM project_settlements WHERE settlement_status = 2 AND project_id = B.project_id ), ( SELECT CASE WHEN SUM ( total_amount ) ISNULL THEN 0 ELSE SUM ( total_amount ) END AS total_amount FROM project_settlements WHERE project_id = B.project_id and settlement_status = ? ), ( SELECT CASE WHEN SUM ( amount ) ISNULL THEN 0 ELSE SUM ( amount ) END AS final_amount FROM project_cost WHERE project_id = B.project_id AND status = 0 ), ( SELECT CASE WHEN SUM ( amount ) ISNULL THEN 0 ELSE SUM ( amount ) END AS total_cost FROM project_cost WHERE project_id = B.project_id AND status = 1 ), 0 AS project_amount, 0 AS left_amount, 0 AS reserve_amount, 0 AS sure_amount FROM contracts AS A LEFT JOIN projects AS B ON A.contract_id = B.contract_id WHERE A.contract_id > 0 and B.project_id > 0 and A.contract_id = ? and B.project_id = ?" ;
	private final static String __originalSQL = "SELECT A .contract_id, b.project_id, b.total_integral, b.reserve_integral, b.project_integral, ( SELECT CASE WHEN SUM ( percent ) ISNULL THEN 0 ELSE SUM ( percent ) END AS percent FROM project_stages WHERE percent > 0 AND contract_id = A.contract_id AND status = 2 ), ( SELECT COUNT ( settlement_id ) AS total_count FROM project_settlements WHERE settlement_status = 2 AND project_id = B.project_id ), ( SELECT CASE WHEN SUM ( total_amount ) ISNULL THEN 0 ELSE SUM ( total_amount ) END AS total_amount FROM project_settlements WHERE project_id = B.project_id AND settlement_status =:settlement_status ), ( SELECT CASE WHEN SUM ( amount ) ISNULL THEN 0 ELSE SUM ( amount ) END AS final_amount FROM project_cost WHERE project_id = B.project_id AND status = 0 ), ( SELECT CASE WHEN SUM ( amount ) ISNULL THEN 0 ELSE SUM ( amount ) END AS total_cost FROM project_cost WHERE project_id = B.project_id AND status = 1 ), 0 AS project_amount, 0 AS left_amount, 0 AS reserve_amount, 0 AS sure_amount FROM contracts AS A LEFT JOIN projects AS B ON A.contract_id = B.contract_id WHERE A.contract_id > 0 AND B.project_id > 0 AND A.contract_id =:contract_id AND B.project_id =:project_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"project_id = B.project_id AND settlement_status =:settlement_status\",\"startIndex\": 533,\"stopIndex\":599,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"project_id = B.project_id\",\"startIndex\": 533,\"stopIndex\":557,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"settlement_status =:settlement_status\",\"fullFieldName\":\"settlement_status\",\"operationName\":\"=\",\"variableName\":\"settlementStatus\",\"startIndex\": 563,\"stopIndex\":599,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]},{\"fullCondition\": \"A.contract_id > 0 AND B.project_id > 0 AND A.contract_id =:contract_id AND B.project_id =:project_id\",\"startIndex\": 1074,\"stopIndex\":1173,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"A.contract_id > 0\",\"startIndex\": 1074,\"stopIndex\":1090,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"B.project_id > 0\",\"startIndex\": 1096,\"stopIndex\":1111,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.contract_id =:contract_id\",\"fullFieldName\":\"A.contract_id\",\"operationName\":\"=\",\"variableName\":\"contractId\",\"startIndex\": 1117,\"stopIndex\":1143,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"B.project_id =:project_id\",\"fullFieldName\":\"B.project_id\",\"operationName\":\"=\",\"variableName\":\"projectId\",\"startIndex\": 1149,\"stopIndex\":1173,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "contract_id,project_id,total_integral,reserve_integral,project_integral,percent,total_count,total_amount,final_amount,total_cost,project_amount,left_amount,reserve_amount,sure_amount";
	private final static String[] fieldNames = { "settlement_status", "contract_id", "project_id"};
}
