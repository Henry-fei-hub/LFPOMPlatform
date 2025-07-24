package pomplatform.soutdesignconsiderationoor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.soutdesignconsiderationoor.bean.BaseSoutdesignconsiderationoor2;
import pomplatform.soutdesignconsiderationoor.bean.ConditionSoutdesignconsiderationoor2;

public class QuerySoutdesignconsiderationoor2 extends AbstractQuery<BaseSoutdesignconsiderationoor2, ConditionSoutdesignconsiderationoor2>
{

	private static final Logger __logger = Logger.getLogger(QuerySoutdesignconsiderationoor2.class);

	public QuerySoutdesignconsiderationoor2() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("info_code");
	}

	@Override
	public BaseCollection<BaseSoutdesignconsiderationoor2> executeQuery( KeyValuePair[] replacements, ConditionSoutdesignconsiderationoor2 condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getOutQuotationId()
			);
	}

	public BaseCollection<BaseSoutdesignconsiderationoor2> runQuery( KeyValuePair[] replacements, ConditionSoutdesignconsiderationoor2 condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getOutQuotationId()
			);
	}

	public BaseCollection<BaseSoutdesignconsiderationoor2> execute( KeyValuePair[] replacements, ConditionSoutdesignconsiderationoor2 condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getOutQuotationId()
			);
	}

	@Override
	public BaseSoutdesignconsiderationoor2 generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSoutdesignconsiderationoor2 __base = new BaseSoutdesignconsiderationoor2();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOutQuotationId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDataCount(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setDesignArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInteriorMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNewCreateQuotationName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFinalizedMoney(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT info_code, project_code, out_quotation_id, COUNT ( 1 ) AS data_count, SUM ( design_area ) AS design_area, SUM ( money_sum ) AS money_sum, SUM ( interior_money_sum ) AS interior_money_sum, new_create_quotation_name, MAX ( finalized_money ) AS finalized_money FROM out_design_considerations WHERE out_quotation_id = ? GROUP BY info_code, project_code, out_quotation_id, info_code, new_create_quotation_name" ;
	private final static String __originalSQL = "SELECT info_code, project_code, out_quotation_id, COUNT ( 1 ) AS data_count, SUM ( design_area ) AS design_area, SUM ( money_sum ) AS money_sum, SUM ( interior_money_sum ) AS interior_money_sum, new_create_quotation_name, MAX ( finalized_money ) AS finalized_money FROM out_design_considerations WHERE out_quotation_id =:out_quotation_id GROUP BY info_code, project_code, out_quotation_id, info_code, new_create_quotation_name";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"out_quotation_id =:out_quotation_id\",\"startIndex\": 302,\"stopIndex\":336,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"out_quotation_id =:out_quotation_id\",\"fullFieldName\":\"out_quotation_id\",\"operationName\":\"=\",\"variableName\":\"outQuotationId\",\"startIndex\": 302,\"stopIndex\":336,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "info_code,project_code,out_quotation_id,data_count,design_area,money_sum,interior_money_sum,new_create_quotation_name,finalized_money";
	private final static String[] fieldNames = { "out_quotation_id"};
}
