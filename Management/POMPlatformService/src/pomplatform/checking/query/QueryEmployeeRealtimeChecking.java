package pomplatform.checking.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.checking.bean.BaseEmployeeRealtimeChecking;
import pomplatform.checking.bean.ConditionEmployeeRealtimeChecking;

public class QueryEmployeeRealtimeChecking extends AbstractQuery<BaseEmployeeRealtimeChecking, ConditionEmployeeRealtimeChecking>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeRealtimeChecking.class);

	public QueryEmployeeRealtimeChecking() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("edc.employee_id");
	}

	@Override
	public BaseCollection<BaseEmployeeRealtimeChecking> executeQuery( KeyValuePair[] replacements, ConditionEmployeeRealtimeChecking condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getDepartmentId(), 
				condition.getPlateId(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseEmployeeRealtimeChecking generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeRealtimeChecking __base = new BaseEmployeeRealtimeChecking();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCheckin(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCheckout(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setShouldDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFactDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
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

	private final static String __SQLText = "SELECT edc.employee_id,e.employee_no,e.department_id,edc.year,edc.month,edc.record_date,to_char(edc.checkin,'YYYY-MM-DD HH24:MI') as checkin,to_char(edc.checkout,'YYYY-MM-DD HH24:MI') AS checkout,edc.should_days,edc.fact_days,edc.status,edc.remark FROM employee_day_checks edc LEFT JOIN employees e ON edc.employee_id = e.employee_id where e.department_id in (select child_id from department_ids where department_id = ? ) and e.plate_id = ? and edc.employee_id = ? AND e.status = 0 AND e.is_check = true AND e.employee_id > 0 and edc.status = ? and edc.record_date between ? and ?" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,department_id,year,month,record_date,checkin,checkout,should_days,fact_days,status,remark";
	private final static String[] fieldNames = { "department_id", "plate_id", "employee_id", "status", "start_date", "end_date"};
}
