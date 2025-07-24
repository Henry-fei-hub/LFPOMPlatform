package pomplatform.mobile.applywork.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.mobile.applywork.bean.BaseMyApplyWork;
import pomplatform.mobile.applywork.bean.ConditionMyApplyWork;

public class QueryMyApplyWork extends AbstractQuery<BaseMyApplyWork, ConditionMyApplyWork>
{

	private static final Logger __logger = Logger.getLogger(QueryMyApplyWork.class);

	public QueryMyApplyWork() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("process_type");
	}

	@Override
	public BaseCollection<BaseMyApplyWork> executeQuery( KeyValuePair[] replacements, ConditionMyApplyWork condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessStatus(), 
				condition.getEmployeeId(), 
				condition.getDeleteFlag()
			);
	}

	@Override
	public BaseMyApplyWork generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMyApplyWork __base = new BaseMyApplyWork();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNum(GenericBase.__getLong(val));
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

	private final static String __SQLText = "SELECT process_type,COUNT(1) AS num FROM system_process_instances WHERE process_status = ? AND employee_id = ? AND delete_flag = ? GROUP BY process_type" ;
	private final static String RESULTSETFIELDLIST = "process_type,num";
	private final static String[] fieldNames = { "process_status", "employee_id", "delete_flag"};
}
