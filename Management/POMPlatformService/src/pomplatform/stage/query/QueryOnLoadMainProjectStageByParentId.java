package pomplatform.stage.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.stage.bean.BaseOnLoadMainProjectStageByParentId;
import pomplatform.stage.bean.ConditionOnLoadMainProjectStageByParentId;

public class QueryOnLoadMainProjectStageByParentId extends AbstractQuery<BaseOnLoadMainProjectStageByParentId, ConditionOnLoadMainProjectStageByParentId>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadMainProjectStageByParentId.class);

	public QueryOnLoadMainProjectStageByParentId() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("main_stage_id as dic_type_value_id");
	}

	@Override
	public BaseCollection<BaseOnLoadMainProjectStageByParentId> executeQuery( KeyValuePair[] replacements, ConditionOnLoadMainProjectStageByParentId condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getParentId()
			);
	}

	public BaseCollection<BaseOnLoadMainProjectStageByParentId> runQuery( KeyValuePair[] replacements, ConditionOnLoadMainProjectStageByParentId condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getParentId()
			);
	}

	public BaseCollection<BaseOnLoadMainProjectStageByParentId> execute( KeyValuePair[] replacements, ConditionOnLoadMainProjectStageByParentId condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getParentId()
			);
	}

	@Override
	public BaseOnLoadMainProjectStageByParentId generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadMainProjectStageByParentId __base = new BaseOnLoadMainProjectStageByParentId();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDicTypeValueId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDicTypeValue(GenericBase.__getString(val));
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

	private final static String __SQLText = "select main_stage_id as dic_type_value_id, main_stage_name as dic_type_value, percent from main_project_stages where parent_id = ? and parent_id >0 order by main_project_stage_id asc" ;
	private final static String __originalSQL = "select main_stage_id as dic_type_value_id, main_stage_name as dic_type_value, percent from main_project_stages where parent_id =:parent_id and parent_id >0  order by main_project_stage_id asc";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"parent_id =:parent_id\",\"startIndex\": 117,\"stopIndex\":137,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"parent_id =:parent_id\",\"fullFieldName\":\"parent_id\",\"operationName\":\"=\",\"variableName\":\"parentId\",\"startIndex\": 117,\"stopIndex\":137,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "dic_type_value_id,dic_type_value,percent";
	private final static String[] fieldNames = { "parent_id"};
}
