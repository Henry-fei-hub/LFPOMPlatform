package pomplatform.checking.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.checking.bean.BaseMemployeecheckinouteeseor;
import pomplatform.checking.bean.ConditionMemployeecheckinouteeseor;

public class QueryMemployeecheckinouteeseor extends AbstractQuery<BaseMemployeecheckinouteeseor, ConditionMemployeecheckinouteeseor>
{

	private static final Logger __logger = Logger.getLogger(QueryMemployeecheckinouteeseor.class);

	public QueryMemployeecheckinouteeseor() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("e.employee_id");
	}

	@Override
	public BaseCollection<BaseMemployeecheckinouteeseor> executeQuery( KeyValuePair[] replacements, ConditionMemployeecheckinouteeseor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getDepartmentId(), 
				condition.getPlateId(), 
				condition.getEmployeeId(),
				condition.getStatus(),
				condition.getStartTime(), 
				condition.getEndTime()
			);
	}

	@Override
	public BaseMemployeecheckinouteeseor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMemployeecheckinouteeseor __base = new BaseMemployeecheckinouteeseor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCheckDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDayOfWeek(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCheckIn(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCheckOut(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLeaveHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeaveDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinalStatus(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setComments(GenericBase.__getString(val));
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

	private final static String __SQLText = "select e.department_id,e.employee_id, e.employee_no, e.employee_name, ec.check_date, ec.day_of_week, to_char(ec.check_in_time,'YYYY-MM-DD HH24:MI') as check_in, to_char(ec.check_out_time,'YYYY-MM-DD HH24:MI') as check_out, ec.status, ec.leave_hours, ec.leave_days, ec.final_status, ec.comments from employee_checkinouts ec left join employees e on e.employee_id = ec.employee_id where e.department_id in (select child_id from department_ids where department_id = ? ) and e.plate_id = ? and e.is_headcount = true and e.employee_id = ? and ec.status = ? and ec.check_date between ? and ? order by e.employee_id, ec.check_date" ;
	private final static String RESULTSETFIELDLIST = "department_id,employee_id,employee_no,employee_name,check_date,day_of_week,check_in,check_out,status,leave_hours,leave_days,final_status,comments";
	private final static String[] fieldNames = { "department_id", "plate_id", "employee_id", "status", "start_time", "end_time"};
}
