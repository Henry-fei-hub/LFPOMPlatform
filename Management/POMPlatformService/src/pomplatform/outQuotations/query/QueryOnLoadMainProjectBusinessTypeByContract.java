package pomplatform.outQuotations.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.outQuotations.bean.BaseOnLoadMainProjectBusinessTypeByContract;
import pomplatform.outQuotations.bean.ConditionOnLoadMainProjectBusinessTypeByContract;

public class QueryOnLoadMainProjectBusinessTypeByContract extends AbstractQuery<BaseOnLoadMainProjectBusinessTypeByContract, ConditionOnLoadMainProjectBusinessTypeByContract>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadMainProjectBusinessTypeByContract.class);

	public QueryOnLoadMainProjectBusinessTypeByContract() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .contract_id");
	}

	@Override
	public BaseCollection<BaseOnLoadMainProjectBusinessTypeByContract> executeQuery( KeyValuePair[] replacements, ConditionOnLoadMainProjectBusinessTypeByContract condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getProjectCode(), 
				condition.getContractName(), 
				condition.getStatus()
			);
	}

	public BaseCollection<BaseOnLoadMainProjectBusinessTypeByContract> runQuery( KeyValuePair[] replacements, ConditionOnLoadMainProjectBusinessTypeByContract condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getContractId(), 
				condition.getProjectCode(), 
				condition.getContractName(), 
				condition.getStatus()
			);
	}

	public BaseCollection<BaseOnLoadMainProjectBusinessTypeByContract> execute( KeyValuePair[] replacements, ConditionOnLoadMainProjectBusinessTypeByContract condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getContractId(), 
				condition.getProjectCode(), 
				condition.getContractName(), 
				condition.getStatus()
			);
	}

	@Override
	public BaseOnLoadMainProjectBusinessTypeByContract generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadMainProjectBusinessTypeByContract __base = new BaseOnLoadMainProjectBusinessTypeByContract();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOutQuotationId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOutputValueSum(GenericBase.__getDecimal(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "SELECT A .contract_id, b.main_project_id, C.out_quotation_id, b.project_code, b.project_name, CASE WHEN A.signing_money_sum >= 0 THEN signing_money_sum ELSE 0 END AS signing_money_sum, CASE WHEN SUM ( d.output_value ) >= 0 THEN SUM ( d.output_value ) ELSE 0 END AS output_value_sum FROM contracts AS A LEFT JOIN main_projects AS b ON A.project_code = b.project_code LEFT JOIN out_quotations AS C ON A.project_code = C.project_code AND C.quotation_status = 1 LEFT JOIN main_project_business_types AS d ON d.out_quotation_id = C.out_quotation_id AND d.main_project_id = b.main_project_id WHERE A.contract_id > 0 and A.contract_id = ? and A.project_code like ? and A.contract_name like ? and d.status = ? GROUP BY A.contract_id, b.main_project_id, C.out_quotation_id, b.project_code, b.project_name, A.signing_money_sum" ;
	private final static String __originalSQL = "SELECT A .contract_id, b.main_project_id, C.out_quotation_id, b.project_code, b.project_name, CASE WHEN A.signing_money_sum >= 0 THEN signing_money_sum ELSE 0 END AS signing_money_sum, CASE WHEN SUM ( d.output_value ) >= 0 THEN SUM ( d.output_value ) ELSE 0 END AS output_value_sum FROM contracts AS A LEFT JOIN main_projects AS b ON A.project_code = b.project_code LEFT JOIN out_quotations AS C ON A.project_code = C.project_code AND C.quotation_status = 1 LEFT JOIN main_project_business_types AS d ON d.out_quotation_id = C.out_quotation_id AND d.main_project_id = b.main_project_id WHERE A.contract_id > 0 AND A.contract_id =:contract_id AND A.project_code LIKE :project_code AND A.contract_name LIKE :contract_name AND d.status =:status GROUP BY A.contract_id, b.main_project_id, C.out_quotation_id, b.project_code, b.project_name, A.signing_money_sum";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"A.contract_id > 0 AND A.contract_id =:contract_id AND A.project_code LIKE :project_code AND A.contract_name LIKE :contract_name AND d.status =:status\",\"startIndex\": 592,\"stopIndex\":740,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"A.contract_id > 0\",\"startIndex\": 592,\"stopIndex\":608,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.contract_id =:contract_id\",\"fullFieldName\":\"A.contract_id\",\"operationName\":\"=\",\"variableName\":\"contractId\",\"startIndex\": 614,\"stopIndex\":640,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.project_code LIKE :project_code\",\"fullFieldName\":\"A.project_code\",\"operationName\":\"like\",\"variableName\":\"projectCode\",\"startIndex\": 646,\"stopIndex\":678,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.contract_name LIKE :contract_name\",\"fullFieldName\":\"A.contract_name\",\"operationName\":\"like\",\"variableName\":\"contractName\",\"startIndex\": 684,\"stopIndex\":718,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"d.status =:status\",\"fullFieldName\":\"d.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"startIndex\": 724,\"stopIndex\":740,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "contract_id,main_project_id,out_quotation_id,project_code,project_name,signing_money_sum,output_value_sum";
	private final static String[] fieldNames = { "contract_id", "project_code", "contract_name", "status"};
}
