package pomplatform.workflow.personnelbusiness.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.personnelbusiness.bean.BaseFillcheckApplyTimes;
import pomplatform.workflow.personnelbusiness.bean.ConditionFillcheckApplyTimes;

public class QueryFillcheckApplyTimes extends AbstractQuery<BaseFillcheckApplyTimes, ConditionFillcheckApplyTimes>
{

	private static final Logger __logger = Logger.getLogger(QueryFillcheckApplyTimes.class);

	public QueryFillcheckApplyTimes() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("count(*) as sum from system_process_instances a LEFT JOIN personnel_business b on a.business_id = b.personnel_business_id where a.process_type = 15 and a.process_status in (0");
	}

	@Override
	public BaseCollection<BaseFillcheckApplyTimes> executeQuery( KeyValuePair[] replacements, ConditionFillcheckApplyTimes condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getType(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getAtThisDate()
			);
	}

	@Override
	public BaseFillcheckApplyTimes generateBase(Object[] __data) throws java.sql.SQLException {
		BaseFillcheckApplyTimes __base = new BaseFillcheckApplyTimes();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSum(GenericBase.__getLong(val));
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
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
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

	private final static String __SQLText = "SELECT count(*) as sum from system_process_instances a LEFT JOIN personnel_business b on a.business_id = b.personnel_business_id where a.process_type = 15 and a.delete_flag = 0 and b.delete_flag = 0 and a.process_status in (0,1,3) and b.employee_id = ? and b.type = ? and ((b.start_date >= ? and b.start_date < ? ) or b.start_date = ?)" ;
	private final static String RESULTSETFIELDLIST = "sum";
	private final static String[] fieldNames = { "employee_id", "type", "start_date", "end_date", "at_this_date"};
}
