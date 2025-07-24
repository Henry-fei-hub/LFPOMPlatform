package pomplatform.sealKeepers.query;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import org.apache.log4j.Logger;
import pomplatform.sealKeepers.bean.BaseRankMaintenance;
import pomplatform.sealKeepers.bean.ConditionRankMaintenance;

public class QueryRankMaintenance extends AbstractQuery<BaseRankMaintenance, ConditionRankMaintenance>
{

	private static final Logger __logger = Logger.getLogger(QueryRankMaintenance.class);

	public QueryRankMaintenance() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("dic_type_id");
	}

	@Override
	public BaseCollection<BaseRankMaintenance> executeQuery( KeyValuePair[] replacements, ConditionRankMaintenance condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getDicTypeValueId()
			);
	}

	public BaseCollection<BaseRankMaintenance> runQuery( KeyValuePair[] replacements, ConditionRankMaintenance condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getDicTypeValueId()
			);
	}

	public BaseCollection<BaseRankMaintenance> execute( KeyValuePair[] replacements, ConditionRankMaintenance condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getDicTypeValueId()
			);
	}

	@Override
	public BaseRankMaintenance generateBase(Object[] __data) throws java.sql.SQLException {
		BaseRankMaintenance __base = new BaseRankMaintenance();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDicTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDicTypeValueId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDicTypeValue(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCoefficient(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT dic_type_id, dic_type_value_id, dic_type_value, rf.coefficient FROM system_dictionary sd LEFT JOIN rank_factor_maintenances rf ON rf.rank_id = sd.dic_type_value_id WHERE sd.dic_type_id = 3 and dic_type_value_id = ? order by dic_type_value_id desc" ;
	private final static String __originalSQL = "SELECT dic_type_id, dic_type_value_id, dic_type_value, rf.coefficient FROM system_dictionary sd LEFT JOIN rank_factor_maintenances rf ON rf.rank_id = sd.dic_type_value_id WHERE sd.dic_type_id = 3 AND dic_type_value_id = :dic_type_value_id order by dic_type_value_id desc";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"sd.dic_type_id = 3 AND dic_type_value_id = :dic_type_value_id\",\"startIndex\": 177,\"stopIndex\":237,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"sd.dic_type_id = 3\",\"nextToken\":\"and\",\"startIndex\": 177,\"stopIndex\":194,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"dic_type_value_id = :dic_type_value_id\",\"fullFieldName\":\"dic_type_value_id\",\"operationName\":\"=\",\"variableName\":\"dicTypeValueId\",\"startIndex\": 200,\"stopIndex\":237,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "dic_type_id,dic_type_value_id,dic_type_value,coefficient";
	private final static String[] fieldNames = { "dic_type_value_id"};
}
