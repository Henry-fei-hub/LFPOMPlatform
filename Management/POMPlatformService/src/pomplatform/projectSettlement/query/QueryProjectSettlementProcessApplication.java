package pomplatform.projectSettlement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectSettlement.bean.BaseProjectSettlementProcessApplication;
import pomplatform.projectSettlement.bean.ConditionProjectSettlementProcessApplication;

public class QueryProjectSettlementProcessApplication extends AbstractQuery<BaseProjectSettlementProcessApplication, ConditionProjectSettlementProcessApplication>
{

	private static final Logger __logger = Logger.getLogger(QueryProjectSettlementProcessApplication.class);

	public QueryProjectSettlementProcessApplication() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ps.settlement_id");
	}

	@Override
	public BaseCollection<BaseProjectSettlementProcessApplication> executeQuery( KeyValuePair[] replacements, ConditionProjectSettlementProcessApplication condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getSettlementId()
			);
	}

	public BaseCollection<BaseProjectSettlementProcessApplication> runQuery( KeyValuePair[] replacements, ConditionProjectSettlementProcessApplication condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getSettlementId()
			);
	}

	public BaseCollection<BaseProjectSettlementProcessApplication> execute( KeyValuePair[] replacements, ConditionProjectSettlementProcessApplication condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getSettlementId()
			);
	}

	@Override
	public BaseProjectSettlementProcessApplication generateBase(Object[] __data) throws java.sql.SQLException {
		BaseProjectSettlementProcessApplication __base = new BaseProjectSettlementProcessApplication();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSettlementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSettlementDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeftAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSettlementStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFlag(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select ps.settlement_id, ps.project_id, ps.employee_id, ps.remark, ps.settlement_date, ps.total_amount, ps.total_cost, ps.project_amount, ps.left_amount, ps.status, ps.stage_id, ps.settlement_status, ps.flag from project_settlements ps where ps.settlement_id = ?" ;
	private final static String __originalSQL = "select ps.settlement_id, ps.project_id, ps.employee_id, ps.remark, ps.settlement_date, ps.total_amount, ps.total_cost, ps.project_amount, ps.left_amount, ps.status, ps.stage_id, ps.settlement_status, ps.flag from project_settlements ps where ps.settlement_id = :settlement_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"ps.settlement_id = :settlement_id\",\"startIndex\": 242,\"stopIndex\":274,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"ps.settlement_id = :settlement_id\",\"fullFieldName\":\"ps.settlement_id\",\"operationName\":\"=\",\"variableName\":\"settlementId\",\"startIndex\": 242,\"stopIndex\":274,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "settlement_id,project_id,employee_id,remark,settlement_date,total_amount,total_cost,project_amount,left_amount,status,stage_id,settlement_status,flag";
	private final static String[] fieldNames = { "settlement_id"};
}
