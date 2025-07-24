package pomplatform.role.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.role.bean.BaseSroleror;
import pomplatform.role.bean.ConditionSroleror;

public class QuerySroleror extends AbstractQuery<BaseSroleror, ConditionSroleror>
{

	private static final Logger __logger = Logger.getLogger(QuerySroleror.class);

	public QuerySroleror() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("r.role_id");
	}

	@Override
	public BaseCollection<BaseSroleror> executeQuery( KeyValuePair[] replacements, ConditionSroleror condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getRoleName()
			);
	}

	@Override
	public BaseSroleror generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSroleror __base = new BaseSroleror();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setRoleId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRoleName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setApplicationId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRoleType(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select r.role_id, r.role_name, r.application_id, r.role_type, r.enabled from roles r where r.role_name like ? and r.application_id = 1" ;
	private final static String RESULTSETFIELDLIST = "role_id,role_name,application_id,role_type,enabled";
	private final static String[] fieldNames = { "role_name"};
}
