package pomplatform.shift.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.shift.bean.BaseGetShiftInfoByEmployeeId;
import pomplatform.shift.bean.ConditionGetShiftInfoByEmployeeId;

public class QueryGetShiftInfoByEmployeeId extends AbstractQuery<BaseGetShiftInfoByEmployeeId, ConditionGetShiftInfoByEmployeeId>
{

	private static final Logger __logger = Logger.getLogger(QueryGetShiftInfoByEmployeeId.class);

	public QueryGetShiftInfoByEmployeeId() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("c.* from ( SELECT a.record_date");
	}

	@Override
	public BaseCollection<BaseGetShiftInfoByEmployeeId> executeQuery( KeyValuePair[] replacements, ConditionGetShiftInfoByEmployeeId condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseGetShiftInfoByEmployeeId generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetShiftInfoByEmployeeId __base = new BaseGetShiftInfoByEmployeeId();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setShiftTimeManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWeekDay(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSignInTime(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSignOffTime(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT c.* from ( SELECT a.record_date, b.shift_time_manage_id, case when (extract(dow from a.record_date) = 0 and b.sunday = true) then 7  when (extract(dow from a.record_date) = 1 and b.monday = true) then 1 when (extract(dow from a.record_date) = 2 and b.tuesday = true) then 2 when (extract(dow from a.record_date) = 3 and b.wednesday = true) then 3 when (extract(dow from a.record_date) = 4 and b.thursday = true) then 4 when (extract(dow from a.record_date) = 5 and b.friday = true) then 5 when (extract(dow from a.record_date) = 6 and b.saturday = true) then 6 else 8 end as week_day, c.sign_in_time, c.sign_off_time from employee_shift_manages a LEFT JOIN time_of_shift_manages b on a.shift_manage_id = b.shift_manage_id LEFT JOIN shift_time_manages c on b.shift_time_manage_id = c.shift_time_manage_id where a.shift_manage_id not in (1,2) and a.employee_id = ? and a.record_date BETWEEN ? and ? ORDER BY a.record_date ) c where c.week_day < 8 ORDER BY c.record_date" ;
	private final static String RESULTSETFIELDLIST = "record_date,shift_time_manage_id,week_day,sign_in_time,sign_off_time";
	private final static String[] fieldNames = { "employee_id", "start_date", "end_date"};
}
