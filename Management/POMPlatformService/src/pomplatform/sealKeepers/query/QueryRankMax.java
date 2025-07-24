package pomplatform.sealKeepers.query;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import org.apache.log4j.Logger;
import pomplatform.sealKeepers.bean.BaseRankMax;
import pomplatform.sealKeepers.bean.ConditionRankMax;

public class QueryRankMax extends AbstractQuery<BaseRankMax, ConditionRankMax>
{

	private static final Logger __logger = Logger.getLogger(QueryRankMax.class);

	public QueryRankMax() throws java.sql.SQLException 
	{
		setParameterNumber(0);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("max(dic_type_value_id)");
	}

	@Override
	public BaseCollection<BaseRankMax> executeQuery( KeyValuePair[] replacements, ConditionRankMax condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements
			);
	}

	public BaseCollection<BaseRankMax> runQuery( KeyValuePair[] replacements, ConditionRankMax condition ) throws java.sql.SQLException {
		return runQuery(replacements
			);
	}

	public BaseCollection<BaseRankMax> execute( KeyValuePair[] replacements, ConditionRankMax condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements
			);
	}

	@Override
	public BaseRankMax generateBase(Object[] __data) throws java.sql.SQLException {
		BaseRankMax __base = new BaseRankMax();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setMax(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select max(dic_type_value_id) from system_dictionary where dic_type_id = 3" ;
	private final static String __originalSQL = "select max(dic_type_value_id) from system_dictionary where dic_type_id = 3";
	private final static String[] __queryConditions = new String[0];
	private final static String RESULTSETFIELDLIST = "max";
	private final static String[] fieldNames = { };
}
