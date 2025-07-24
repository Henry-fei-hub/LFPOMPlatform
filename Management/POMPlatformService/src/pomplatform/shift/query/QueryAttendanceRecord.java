package pomplatform.shift.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.shift.bean.BaseAttendanceRecord;
import pomplatform.shift.bean.ConditionAttendanceRecord;

public class QueryAttendanceRecord extends AbstractQuery<BaseAttendanceRecord, ConditionAttendanceRecord>
{

	private static final Logger __logger = Logger.getLogger(QueryAttendanceRecord.class);

	public QueryAttendanceRecord() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("edc.employee_day_check_id");
	}

	@Override
	public BaseCollection<BaseAttendanceRecord> executeQuery( KeyValuePair[] replacements, ConditionAttendanceRecord condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getEndDate(), 
				condition.getStartDate()
			);
	}

	@Override
	public BaseAttendanceRecord generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAttendanceRecord __base = new BaseAttendanceRecord();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeDayCheckId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setShiftManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCheckin(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCheckout(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setLateLeave5m(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLateLeave10m(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLateLeave30m(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLateLeave(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setThingLeaveTimes(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setThingLeaveHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThingLeaveDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIllLeaveTimes(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIllLeaveHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIllLeaveDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOtherLeaveTimes(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOtherLeaveHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOtherLeaveDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNornalOvertimeHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setWeekendOvertimeHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHolidayOvertimeHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAbsenceDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFactDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "select edc.employee_day_check_id, edc.employee_id, edc.year, edc.month, edc.record_date, edc.shift_manage_id, edc.checkin, edc.checkout, edc.late_leave_5m, edc.late_leave_10m, edc.late_leave_30m, edc.late_leave, edc.thing_leave_times, edc.thing_leave_hours, edc.thing_leave_days, edc.ill_leave_times, edc.ill_leave_hours, edc.ill_leave_days, edc.other_leave_times, edc.other_leave_hours, edc.other_leave_days, edc.nornal_overtime_hours, edc.weekend_overtime_hours, edc.holiday_overtime_hours, edc.absence_days, edc.should_days, edc.fact_days, edc.status, edc.operate_employee_id, edc.operate_time, edc.remark from employee_day_checks edc where edc.employee_id = ? and edc.record_date <= ? and edc.record_date >= ? order by edc.record_date" ;
	private final static String RESULTSETFIELDLIST = "employee_day_check_id,employee_id,year,month,record_date,shift_manage_id,checkin,checkout,late_leave_5m,late_leave_10m,late_leave_30m,late_leave,thing_leave_times,thing_leave_hours,thing_leave_days,ill_leave_times,ill_leave_hours,ill_leave_days,other_leave_times,other_leave_hours,other_leave_days,nornal_overtime_hours,weekend_overtime_hours,holiday_overtime_hours,absence_days,should_days,fact_days,status,operate_employee_id,operate_time,remark";
	private final static String[] fieldNames = { "employee_id", "end_date", "start_date"};
}
