package pomplatform.tablemaintain.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.tablemaintain.bean.BaseTableMaintain;
import pomplatform.tablemaintain.bean.ConditionTableMaintain;

public class QueryTableMaintain extends AbstractQuery<BaseTableMaintain, ConditionTableMaintain>
{

	private static final Logger __logger = Logger.getLogger(QueryTableMaintain.class);

	public QueryTableMaintain() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("table_maintain_id");
	}

	@Override
	public BaseCollection<BaseTableMaintain> executeQuery( KeyValuePair[] replacements, ConditionTableMaintain condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getTableName(), 
				condition.getRemark()
			);
	}

	public BaseCollection<BaseTableMaintain> runQuery( KeyValuePair[] replacements, ConditionTableMaintain condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getTableName(), 
				condition.getRemark()
			);
	}

	public BaseCollection<BaseTableMaintain> execute( KeyValuePair[] replacements, ConditionTableMaintain condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getTableName(), 
				condition.getRemark()
			);
	}

	@Override
	public BaseTableMaintain generateBase(Object[] __data) throws java.sql.SQLException {
		BaseTableMaintain __base = new BaseTableMaintain();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setTableMaintainId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTableName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
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

	private final static String __SQLText = "SELECT table_maintain_id, table_name, remark FROM table_maintains WHERE table_name = ? and remark like ?" ;
	private final static String __originalSQL = "SELECT table_maintain_id, table_name, remark FROM table_maintains WHERE table_name = :table_name and remark like :remark";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"table_name = :table_name and remark like :remark\",\"startIndex\": 72,\"stopIndex\":119,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"table_name = :table_name\",\"fullFieldName\":\"table_name\",\"operationName\":\"=\",\"variableName\":\"tableName\",\"nextToken\":\"and\",\"startIndex\": 72,\"stopIndex\":95,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"remark like :remark\",\"fullFieldName\":\"remark\",\"operationName\":\"like\",\"variableName\":\"remark\",\"startIndex\": 101,\"stopIndex\":119,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "table_maintain_id,table_name,remark";
	private final static String[] fieldNames = { "table_name", "remark"};
}
