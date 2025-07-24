package pomplatform.workflow.personnelbusiness.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.personnelbusiness.bean.BaseGetOvertimeApplyHours;
import pomplatform.workflow.personnelbusiness.bean.ConditionGetOvertimeApplyHours;

public class QueryGetOvertimeApplyHours extends AbstractQuery<BaseGetOvertimeApplyHours, ConditionGetOvertimeApplyHours>
{

	private static final Logger __logger = Logger.getLogger(QueryGetOvertimeApplyHours.class);

	public QueryGetOvertimeApplyHours() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.hours from system_process_instances a LEFT JOIN personnel_business b on a.business_id = b.personnel_business_id where a.process_type = 17 and a.process_status in (0");
	}

	@Override
	public BaseCollection<BaseGetOvertimeApplyHours> executeQuery( KeyValuePair[] replacements, ConditionGetOvertimeApplyHours condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getStartTime(), 
				condition.getEndTime()
			);
	}

	@Override
	public BaseGetOvertimeApplyHours generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetOvertimeApplyHours __base = new BaseGetOvertimeApplyHours();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setHours(GenericBase.__getDecimal(val));
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
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
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

	private final static String __SQLText = "SELECT sum(b.hours) from system_process_instances a LEFT JOIN personnel_business b on a.business_id = b.personnel_business_id where a.process_type in (17,22,23) and a.process_status in (0,1,3) and b.employee_id = ? and (b.create_time between ? and ? ) and a.delete_flag = 0 and b.delete_flag = 0" ;
	private final static String RESULTSETFIELDLIST = "hours";
	private final static String[] fieldNames = { "employee_id", "start_time", "end_time"};
}
