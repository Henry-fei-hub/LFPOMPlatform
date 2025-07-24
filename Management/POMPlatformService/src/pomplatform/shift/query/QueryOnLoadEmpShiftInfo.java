package pomplatform.shift.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.shift.bean.BaseOnLoadEmpShiftInfo;
import pomplatform.shift.bean.ConditionOnLoadEmpShiftInfo;

public class QueryOnLoadEmpShiftInfo extends AbstractQuery<BaseOnLoadEmpShiftInfo, ConditionOnLoadEmpShiftInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadEmpShiftInfo.class);

	public QueryOnLoadEmpShiftInfo() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseOnLoadEmpShiftInfo> executeQuery( KeyValuePair[] replacements, ConditionOnLoadEmpShiftInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(),
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseOnLoadEmpShiftInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadEmpShiftInfo __base = new BaseOnLoadEmpShiftInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setShiftManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setShiftTimeManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonday(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setTuesday(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setWednesday(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setThursday(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setFriday(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setSaturday(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setSunday(GenericBase.__getBoolean(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
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

	private final static String __SQLText = "select a.employee_id,a.shift_manage_id,a.record_date,b.shift_time_manage_id,b.monday,b.tuesday,b.wednesday,b.thursday,b.friday,b.saturday,b.sunday from employee_shift_manages a left join time_of_shift_manages b on a.shift_manage_id = b.shift_manage_id where a.record_date BETWEEN ? and ? and a.employee_id = ? ORDER BY a.employee_id,a.record_date asc" ;
	private final static String RESULTSETFIELDLIST = "employee_id,shift_manage_id,record_date,shift_time_manage_id,monday,tuesday,wednesday,thursday,friday,saturday,sunday";
	private final static String[] fieldNames = { "start_date", "end_date","employee_id"};
}
