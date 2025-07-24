package pomplatform.projectSettlement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectSettlement.bean.BaseGetCountProjectSettlementCountByProjectId;
import pomplatform.projectSettlement.bean.ConditionGetCountProjectSettlementCountByProjectId;

public class QueryGetCountProjectSettlementCountByProjectId extends AbstractQuery<BaseGetCountProjectSettlementCountByProjectId, ConditionGetCountProjectSettlementCountByProjectId>
{

	private static final Logger __logger = Logger.getLogger(QueryGetCountProjectSettlementCountByProjectId.class);

	public QueryGetCountProjectSettlementCountByProjectId() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.settlement_id");
	}

	@Override
	public BaseCollection<BaseGetCountProjectSettlementCountByProjectId> executeQuery( KeyValuePair[] replacements, ConditionGetCountProjectSettlementCountByProjectId condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	public BaseCollection<BaseGetCountProjectSettlementCountByProjectId> runQuery( KeyValuePair[] replacements, ConditionGetCountProjectSettlementCountByProjectId condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getProjectId()
			);
	}

	public BaseCollection<BaseGetCountProjectSettlementCountByProjectId> execute( KeyValuePair[] replacements, ConditionGetCountProjectSettlementCountByProjectId condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseGetCountProjectSettlementCountByProjectId generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetCountProjectSettlementCountByProjectId __base = new BaseGetCountProjectSettlementCountByProjectId();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSettlementId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select b.settlement_id from system_process_instances as a left join project_settlements as b on a.business_id = b.settlement_id where a.process_type = 80 and b.project_id = ? and b.settlement_status =1" ;
	private final static String __originalSQL = "select b.settlement_id from system_process_instances as a left join project_settlements as b on a.business_id = b.settlement_id where a.process_type = 80 and b.project_id =:project_id and b.settlement_status =1";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"a.process_type = 80 and b.project_id =:project_id and b.settlement_status =1\",\"startIndex\": 134,\"stopIndex\":209,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"a.process_type = 80\",\"startIndex\": 134,\"stopIndex\":152,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.project_id =:project_id\",\"fullFieldName\":\"b.project_id\",\"operationName\":\"=\",\"variableName\":\"projectId\",\"startIndex\": 158,\"stopIndex\":182,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.settlement_status =1\",\"startIndex\": 188,\"stopIndex\":209,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "settlement_id";
	private final static String[] fieldNames = { "project_id"};
}
