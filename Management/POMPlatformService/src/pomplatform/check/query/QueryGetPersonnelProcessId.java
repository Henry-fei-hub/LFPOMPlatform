package pomplatform.check.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.check.bean.BaseGetPersonnelProcessId;
import pomplatform.check.bean.ConditionGetPersonnelProcessId;

public class QueryGetPersonnelProcessId extends AbstractQuery<BaseGetPersonnelProcessId, ConditionGetPersonnelProcessId>
{

	private static final Logger __logger = Logger.getLogger(QueryGetPersonnelProcessId.class);

	public QueryGetPersonnelProcessId() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("process_id");
	}

	@Override
	public BaseCollection<BaseGetPersonnelProcessId> executeQuery( KeyValuePair[] replacements, ConditionGetPersonnelProcessId condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getBusinessId(), 
				condition.getProcessType()
			);
	}

	@Override
	public BaseGetPersonnelProcessId generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetPersonnelProcessId __base = new BaseGetPersonnelProcessId();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
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

	private final static String __SQLText = " SELECT process_id,process_instance_id FROM system_process_instances WHERE business_id = ? AND process_type = ?" ;
	private final static String RESULTSETFIELDLIST = "process_id,process_instance_id";
	private final static String[] fieldNames = { "business_id", "process_type"};
}
