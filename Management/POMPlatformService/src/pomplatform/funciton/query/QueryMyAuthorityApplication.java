package pomplatform.funciton.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.funciton.bean.BaseMyAuthorityApplication;
import pomplatform.funciton.bean.ConditionMyAuthorityApplication;


public class QueryMyAuthorityApplication extends AbstractQuery<BaseMyAuthorityApplication, ConditionMyAuthorityApplication>
{

	private static final Logger __logger = Logger.getLogger(QueryMyAuthorityApplication.class);

	public QueryMyAuthorityApplication() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("fb.employee_id");
	}

	@Override
	public BaseCollection<BaseMyAuthorityApplication> executeQuery( KeyValuePair[] replacements, ConditionMyAuthorityApplication condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPersonnelBusinessId()
			);
	}

	@Override
	public BaseMyAuthorityApplication generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMyAuthorityApplication __base = new BaseMyAuthorityApplication();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFunctionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFunctionCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFunctionName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setApplicationId(GenericBase.__getInt(val));
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
		__logger.info(__SQLText);
		return __SQLText;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	private final static String __SQLText = "SELECT fb.employee_id,f.function_id,f.function_code,f.parent_id,f.function_name,f.application_id FROM function_business fb LEFT JOIN functions f ON f.function_id = fb.function_id WHERE fb.personnel_business_id= ?" ;
	private final static String RESULTSETFIELDLIST = "employee_id,function_id,function_code,parent_id,function_name,application_id";
	private final static String[] fieldNames = { "personnel_business_id"};
}
