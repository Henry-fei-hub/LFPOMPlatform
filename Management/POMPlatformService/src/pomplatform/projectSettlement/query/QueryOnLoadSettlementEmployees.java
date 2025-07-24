package pomplatform.projectSettlement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectSettlement.bean.BaseOnLoadSettlementEmployees;
import pomplatform.projectSettlement.bean.ConditionOnLoadSettlementEmployees;

public class QueryOnLoadSettlementEmployees extends AbstractQuery<BaseOnLoadSettlementEmployees, ConditionOnLoadSettlementEmployees>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadSettlementEmployees.class);

	public QueryOnLoadSettlementEmployees() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("psd.settlement_detail_id");
	}

	@Override
	public BaseCollection<BaseOnLoadSettlementEmployees> executeQuery( KeyValuePair[] replacements, ConditionOnLoadSettlementEmployees condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getSettlementId()
			);
	}

	public BaseCollection<BaseOnLoadSettlementEmployees> runQuery( KeyValuePair[] replacements, ConditionOnLoadSettlementEmployees condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getSettlementId()
			);
	}

	public BaseCollection<BaseOnLoadSettlementEmployees> execute( KeyValuePair[] replacements, ConditionOnLoadSettlementEmployees condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getSettlementId()
			);
	}

	@Override
	public BaseOnLoadSettlementEmployees generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadSettlementEmployees __base = new BaseOnLoadSettlementEmployees();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSettlementDetailId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSettlementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWorkContent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSettlementDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPlanAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRealAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFinishPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIsReturn(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setAdjustedAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSettlementStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT psd.settlement_detail_id, psd.settlement_id, psd.project_id, psd.employee_id, psd.work_content, psd.settlement_date, psd.plan_amount, psd.real_amount, psd.project_cost, psd.final_amount, psd.status, psd.finish_percent, psd.is_return, psd.adjusted_amount, psd.settlement_status, psd.sure_integral, psd.COST, e.employee_no, e.employee_name FROM project_settlement_details psd left join employees e on psd.employee_id = e.employee_id where psd.employee_id >0 and psd.project_id>0 and psd.settlement_id = ?" ;
	private final static String __originalSQL = "SELECT psd.settlement_detail_id, psd.settlement_id, psd.project_id, psd.employee_id, psd.work_content, psd.settlement_date, psd.plan_amount, psd.real_amount, psd.project_cost, psd.final_amount, psd.status, psd.finish_percent, psd.is_return, psd.adjusted_amount, psd.settlement_status, psd.sure_integral, psd.COST, e.employee_no, e.employee_name FROM project_settlement_details psd left join employees e on psd.employee_id = e.employee_id where psd.employee_id >0 and psd.project_id>0 and psd.settlement_id =:settlement_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"psd.employee_id >0 and psd.project_id>0 and psd.settlement_id =:settlement_id\",\"startIndex\": 444,\"stopIndex\":520,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"psd.employee_id >0\",\"startIndex\": 444,\"stopIndex\":461,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"psd.project_id>0\",\"startIndex\": 467,\"stopIndex\":482,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"psd.settlement_id =:settlement_id\",\"fullFieldName\":\"psd.settlement_id\",\"operationName\":\"=\",\"variableName\":\"settlementId\",\"startIndex\": 488,\"stopIndex\":520,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "settlement_detail_id,settlement_id,project_id,employee_id,work_content,settlement_date,plan_amount,real_amount,project_cost,final_amount,status,finish_percent,is_return,adjusted_amount,settlement_status,sure_integral,cost,employee_no,employee_name";
	private final static String[] fieldNames = { "settlement_id"};
}
