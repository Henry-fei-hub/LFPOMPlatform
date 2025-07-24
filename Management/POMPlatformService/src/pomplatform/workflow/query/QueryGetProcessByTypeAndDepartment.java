package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseGetProcessByTypeAndDepartment;
import pomplatform.workflow.bean.ConditionGetProcessByTypeAndDepartment;

public class QueryGetProcessByTypeAndDepartment extends AbstractQuery<BaseGetProcessByTypeAndDepartment, ConditionGetProcessByTypeAndDepartment>
{

	private static final Logger __logger = Logger.getLogger(QueryGetProcessByTypeAndDepartment.class);

	public QueryGetProcessByTypeAndDepartment() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.process_id");
	}

	@Override
	public BaseCollection<BaseGetProcessByTypeAndDepartment> executeQuery( KeyValuePair[] replacements, ConditionGetProcessByTypeAndDepartment condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessTypeId(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseGetProcessByTypeAndDepartment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetProcessByTypeAndDepartment __base = new BaseGetProcessByTypeAndDepartment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCountersign(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setDescription(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT a.process_id, a.process_type_id, a.process_name, a.countersign, a.description from system_processes a LEFT JOIN system_process_departments b on a.process_id = b.process_id and b.is_enable = true where a.enable = true and a.process_type_id = ? and b.department_id = ?" ;
	private final static String RESULTSETFIELDLIST = "process_id,process_type_id,process_name,countersign,description";
	private final static String[] fieldNames = { "process_type_id", "department_id"};
}
