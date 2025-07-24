package pomplatform.tablemaintain.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.tablemaintain.bean.BasegetAllTables;
import pomplatform.tablemaintain.bean.ConditiongetAllTables;

public class QuerygetAllTables extends AbstractQuery<BasegetAllTables, ConditiongetAllTables>
{

	private static final Logger __logger = Logger.getLogger(QuerygetAllTables.class);

	public QuerygetAllTables() throws java.sql.SQLException 
	{
		setParameterNumber(0);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("*");
	}

	@Override
	public BaseCollection<BasegetAllTables> executeQuery( KeyValuePair[] replacements, ConditiongetAllTables condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements
			);
	}

	public BaseCollection<BasegetAllTables> runQuery( KeyValuePair[] replacements, ConditiongetAllTables condition ) throws java.sql.SQLException {
		return runQuery(replacements
			);
	}

	public BaseCollection<BasegetAllTables> execute( KeyValuePair[] replacements, ConditiongetAllTables condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements
			);
	}

	@Override
	public BasegetAllTables generateBase(Object[] __data) throws java.sql.SQLException {
		BasegetAllTables __base = new BasegetAllTables();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSchemaname(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTablename(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTableowner(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTablespace(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setHasindexes(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setHasrules(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setHastriggers(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setRowsecurity(GenericBase.__getBoolean(val));
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

	private final static String __SQLText = "select * from pg_tables where schemaname = 'public'" ;
	private final static String __originalSQL = "select * from pg_tables where schemaname = 'public'";
	private final static String[] __queryConditions = new String[0];
	private final static String RESULTSETFIELDLIST = "schemaname,tablename,tableowner,tablespace,hasindexes,hasrules,hastriggers,rowsecurity";
	private final static String[] fieldNames = { };
}
