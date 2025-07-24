package pomplatform.shift.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.shift.bean.BaseManageShiftTime;
import pomplatform.shift.bean.ConditionManageShiftTime;

public class QueryManageShiftTime extends AbstractQuery<BaseManageShiftTime, ConditionManageShiftTime>
{

	private static final Logger __logger = Logger.getLogger(QueryManageShiftTime.class);

	public QueryManageShiftTime() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("stm.shift_time_manage_id");
	}

	@Override
	public BaseCollection<BaseManageShiftTime> executeQuery( KeyValuePair[] replacements, ConditionManageShiftTime condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getShiftTimeName()
			);
	}

	@Override
	public BaseManageShiftTime generateBase(Object[] __data) throws java.sql.SQLException {
		BaseManageShiftTime __base = new BaseManageShiftTime();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setShiftTimeManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setShiftTimeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCheckSignIn(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setSignInTime(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCheckSignOff(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setSignOffTime(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLateMinutes(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLeaveEarlyTime(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSignInStartTime(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSignInEndTime(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSignOffStartTime(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSignOffEndTime(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMinutes(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOvertimeStartTime(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
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

	private final static String __SQLText = "select stm.shift_time_manage_id, stm.shift_time_name, stm.check_sign_in, stm.sign_in_time, stm.check_sign_off, stm.sign_off_time, stm.late_minutes, stm.leave_early_time, stm.sign_in_start_time, stm.sign_in_end_time, stm.sign_off_start_time, stm.sign_off_end_time, stm.days, stm.minutes, stm.overtime_start_time, stm.create_time, stm.update_time from shift_time_manages stm where stm.shift_time_name like ?" ;
	private final static String RESULTSETFIELDLIST = "shift_time_manage_id,shift_time_name,check_sign_in,sign_in_time,check_sign_off,sign_off_time,late_minutes,leave_early_time,sign_in_start_time,sign_in_end_time,sign_off_start_time,sign_off_end_time,days,minutes,overtime_start_time,create_time,update_time";
	private final static String[] fieldNames = { "shift_time_name"};
}
