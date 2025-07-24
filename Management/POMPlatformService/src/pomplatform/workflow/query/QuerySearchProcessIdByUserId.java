package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseSearchProcessIdByUserId;
import pomplatform.workflow.bean.ConditionSearchProcessIdByUserId;

public class QuerySearchProcessIdByUserId extends AbstractQuery<BaseSearchProcessIdByUserId, ConditionSearchProcessIdByUserId>
{

	private static final Logger __logger = Logger.getLogger(QuerySearchProcessIdByUserId.class);

	public QuerySearchProcessIdByUserId() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("c.process_execute_name");
	}

	@Override
	public BaseCollection<BaseSearchProcessIdByUserId> executeQuery( KeyValuePair[] replacements, ConditionSearchProcessIdByUserId condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getParentProcessTypeId()
			);
	}

	@Override
	public BaseSearchProcessIdByUserId generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSearchProcessIdByUserId __base = new BaseSearchProcessIdByUserId();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessExecuteName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIcon(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setParentProcessTypeId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT c.process_execute_name,a.process_id,c.icon,c.parent_process_type_id from system_process_departments a LEFT JOIN system_processes b on a.process_id = b.process_id LEFT JOIN system_process_types c on b.process_type_id = c.process_type_id where a.department_id = (SELECT department_id from employees where employee_id = ?) and a.is_enable = true and b.process_id in (SELECT process_id from system_processes where process_type_id in (SELECT process_type_id from system_process_types where parent_process_type_id = ? )) order by c.process_type_id" ;
	private final static String RESULTSETFIELDLIST = "process_execute_name,process_id,icon,parent_process_type_id";
	private final static String[] fieldNames = { "employee_id", "parent_process_type_id"};
}
