package pomplatform.stage.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.stage.bean.BaseSsystemdictionaryor;
import pomplatform.stage.bean.ConditionSsystemdictionaryor;

public class QuerySsystemdictionaryor extends AbstractQuery<BaseSsystemdictionaryor, ConditionSsystemdictionaryor>
{

	private static final Logger __logger = Logger.getLogger(QuerySsystemdictionaryor.class);

	public QuerySsystemdictionaryor() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sd.dic_type_value_id");
	}

	@Override
	public BaseCollection<BaseSsystemdictionaryor> executeQuery( KeyValuePair[] replacements, ConditionSsystemdictionaryor condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getParentId()
			);
	}

	public BaseCollection<BaseSsystemdictionaryor> runQuery( KeyValuePair[] replacements, ConditionSsystemdictionaryor condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getParentId()
			);
	}

	public BaseCollection<BaseSsystemdictionaryor> execute( KeyValuePair[] replacements, ConditionSsystemdictionaryor condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getParentId()
			);
	}

	@Override
	public BaseSsystemdictionaryor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSsystemdictionaryor __base = new BaseSsystemdictionaryor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDicTypeValueId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDicTypeValue(GenericBase.__getString(val));
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

	private final static String __SQLText = "select sd.dic_type_value_id, sd.dic_type_value from system_dictionary sd where sd.dic_type_id = 7 and sd.parent_id = ? AND sd.dic_type_value_id NOT IN (14,30,31,32) order by sd.dic_type_value_id" ;
	private final static String __originalSQL = "select sd.dic_type_value_id, sd.dic_type_value from system_dictionary sd where sd.dic_type_id = 7 and sd.parent_id=:parent_id AND sd.dic_type_value_id NOT IN (14,30,31,32) order by sd.dic_type_value_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"sd.dic_type_id = 7 and sd.parent_id=:parent_id\",\"startIndex\": 79,\"stopIndex\":124,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"sd.dic_type_id = 7\",\"startIndex\": 79,\"stopIndex\":96,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"sd.parent_id=:parent_id\",\"fullFieldName\":\"sd.parent_id\",\"operationName\":\"=\",\"variableName\":\"parentId\",\"startIndex\": 102,\"stopIndex\":124,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "dic_type_value_id,dic_type_value";
	private final static String[] fieldNames = { "parent_id"};
}
