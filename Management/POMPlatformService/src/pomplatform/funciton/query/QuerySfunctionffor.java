package pomplatform.funciton.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.funciton.bean.BaseSfunctionffor;
import pomplatform.funciton.bean.ConditionSfunctionffor;

public class QuerySfunctionffor extends AbstractQuery<BaseSfunctionffor, ConditionSfunctionffor>
{

	private static final Logger __logger = Logger.getLogger(QuerySfunctionffor.class);

	public QuerySfunctionffor() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("f.function_id");
	}

	@Override
	public BaseCollection<BaseSfunctionffor> executeQuery( KeyValuePair[] replacements, ConditionSfunctionffor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getFunctionName(), 
				condition.getFunctionCode()
			);
	}

	@Override
	public BaseSfunctionffor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSfunctionffor __base = new BaseSfunctionffor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setFunctionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFunctionCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFunctionName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setApplicationId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFunctionType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPrivilegeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEnabled(GenericBase.__getBoolean(val));
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
		if(args[0] != null) __statement.setString(count++, (java.lang.String)args[0]);
		if(args[1] != null) __statement.setString(count++, (java.lang.String)args[1]);
		return count;
	}

	@Override
	public String getSQLText() {
		__logger.info(__SQLText);
		return __SQLText;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	private final static String __SQLText = "select f.function_id, f.function_code, f.parent_id, f.function_name, f.application_id, f.function_type, f.privilege_type, f.enabled from functions f where f.function_name like ? and f.function_code = ? and f.application_id = 1" ;
	private final static String RESULTSETFIELDLIST = "function_id,function_code,parent_id,function_name,application_id,function_type,privilege_type,enabled";
	private final static String[] fieldNames = { "function_name", "function_code"};
}
