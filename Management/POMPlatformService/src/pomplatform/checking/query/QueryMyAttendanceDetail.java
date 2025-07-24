package pomplatform.checking.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.checking.bean.BaseMyAttendanceDetail;
import pomplatform.checking.bean.ConditionMyAttendanceDetail;

public class QueryMyAttendanceDetail extends AbstractQuery<BaseMyAttendanceDetail, ConditionMyAttendanceDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryMyAttendanceDetail.class);

	public QueryMyAttendanceDetail() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ecd.employee_id");
	}

	@Override
	public BaseCollection<BaseMyAttendanceDetail> executeQuery( KeyValuePair[] replacements, ConditionMyAttendanceDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getCheckDate()
			);
	}

	@Override
	public BaseMyAttendanceDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMyAttendanceDetail __base = new BaseMyAttendanceDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCheckDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCheckTime(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "SELECT ecd.employee_id,e.employee_no,e.employee_name,e.department_id,ecd.check_date,ecd.check_time FROM employee_checkinout_details ecd LEFT JOIN employees e ON ecd.employee_id = e.employee_id WHERE ecd.employee_id = ? AND ecd.check_date = ? ORDER BY check_time" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,department_id,check_date,check_time";
	private final static String[] fieldNames = { "employee_id", "check_date"};
}
