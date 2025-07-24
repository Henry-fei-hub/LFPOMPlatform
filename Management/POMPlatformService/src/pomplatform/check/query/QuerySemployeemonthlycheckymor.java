package pomplatform.check.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.check.bean.BaseSemployeemonthlycheckymor;
import pomplatform.check.bean.ConditionSemployeemonthlycheckymor;

public class QuerySemployeemonthlycheckymor extends AbstractQuery<BaseSemployeemonthlycheckymor, ConditionSemployeemonthlycheckymor>
{

	private static final Logger __logger = Logger.getLogger(QuerySemployeemonthlycheckymor.class);

	public QuerySemployeemonthlycheckymor() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("emc.employee_no");
	}

	@Override
	public BaseCollection<BaseSemployeemonthlycheckymor> executeQuery( KeyValuePair[] replacements, ConditionSemployeemonthlycheckymor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getEmployeeId(), 
				condition.getDepartmentId(),
				condition.getResignationDate()
			);
	}

	@Override
	public BaseSemployeemonthlycheckymor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSemployeemonthlycheckymor __base = new BaseSemployeemonthlycheckymor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOnBoard(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDutyDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setLate5m(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLate10m(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLate30m(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLate(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setThingLeave(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setThingHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThingDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIllLeave(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIllDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIllHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOtherLeave(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOtherDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOtherHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setWorkDays(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNormalOvertime(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWeekendOvertime(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHolidayOvertime(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNornalOvertimeHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setWeekendOvertimeHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHolidayOvertimeHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAbsenceDays(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setInt(count++, (java.lang.Integer)args[0]);
		if(args[1] != null) __statement.setInt(count++, (java.lang.Integer)args[1]);
		if(args[2] != null) __statement.setInt(count++, (java.lang.Integer)args[2]);
		if(args[3] != null) __statement.setInt(count++, (java.lang.Integer)args[3]);
		if(args[4] != null) __statement.setInt(count++, (java.lang.Integer)args[4]);
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

	private final static String __SQLText = "select emc.employee_no, emc.employee_id, emc.department_id, emc.employee_type, emc.on_board, emc.duty_date, emc.late_5m, emc.late_10m, emc.late_30m, emc.late, emc.thing_leave, emc.thing_hours, emc.thing_days, emc.ill_leave,emc.ill_days,emc.ill_hours, emc.other_leave,emc.other_days,emc.other_hours, emc.work_days, emc.normal_overtime, emc.weekend_overtime, emc.holiday_overtime, emc.nornal_overtime_hours, emc.weekend_overtime_hours, emc.holiday_overtime_hours, emc.absence_days from employee_monthly_check emc,employees e where e.plate_id = ? and emc.employee_id = e.employee_id and emc.year = ? and emc.month = ? and emc.employee_id = ? and emc.department_id in (select child_id from department_ids where department_id = ? ) and (e.status = 0 or (e.status = 1 and e.resignation_date >= ?)) order by emc.department_id" ;
	private final static String RESULTSETFIELDLIST = "employee_no,employee_id,department_id,employee_type,on_board,duty_date,late_5m,late_10m,late_30m,late,thing_leave,thing_hours,thing_days,ill_leave,ill_days,ill_hours,other_leave,other_days,other_hours,work_days,normal_overtime,weekend_overtime,holiday_overtime,nornal_overtime_hours,weekend_overtime_hours,holiday_overtime_hours,absence_days";
	private final static String[] fieldNames = { "plate_id", "year", "month", "employee_id", "department_id", "resignation_date"};
}
