package pomplatform.role.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.role.bean.BaseGetProjectManagersByEmployeeId;
import pomplatform.role.bean.ConditionGetProjectManagersByEmployeeId;

public class QueryGetProjectManagersByEmployeeId extends AbstractQuery<BaseGetProjectManagersByEmployeeId, ConditionGetProjectManagersByEmployeeId>
{

	private static final Logger __logger = Logger.getLogger(QueryGetProjectManagersByEmployeeId.class);

	public QueryGetProjectManagersByEmployeeId() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT a.project_manage_id");
	}

	@Override
	public BaseCollection<BaseGetProjectManagersByEmployeeId> executeQuery( KeyValuePair[] replacements, ConditionGetProjectManagersByEmployeeId condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getExcluder()
			);
	}

	@Override
	public BaseGetProjectManagersByEmployeeId generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetProjectManagersByEmployeeId __base = new BaseGetProjectManagersByEmployeeId();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
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

	private final static String __SQLText = "SELECT a.* from (SELECT DISTINCT project_manage_id from projects where project_id in (SELECT project_id from project_employees where employee_id = ?) and project_manage_id <> ?) a left join employees b on a.project_manage_id = b.employee_id where a.project_manage_id <> ? and b.status = 0" ;
	private final static String RESULTSETFIELDLIST = "project_manage_id";
	private final static String[] fieldNames = { "employee_id", "employee_id", "excluder"};
}
