package pomplatform.check.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.check.bean.BaseAttendanceManagementStatistics;
import pomplatform.check.bean.ConditionAttendanceManagementStatistics;

public class QueryAttendanceManagementStatistics extends AbstractQuery<BaseAttendanceManagementStatistics, ConditionAttendanceManagementStatistics>
{

	private static final Logger __logger = Logger.getLogger(QueryAttendanceManagementStatistics.class);

	public QueryAttendanceManagementStatistics() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pb.personnel_business_id");
	}

	@Override
	public BaseCollection<BaseAttendanceManagementStatistics> executeQuery( KeyValuePair[] replacements, ConditionAttendanceManagementStatistics condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getDepartmentId(), 
				condition.getEmployeeId(), 
				condition.getEmployeeNo(), 
				condition.getToday()
			);
	}

	@Override
	public BaseAttendanceManagementStatistics generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAttendanceManagementStatistics __base = new BaseAttendanceManagementStatistics();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
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

	private final static String __SQLText = "select pb.personnel_business_id, pb.process_type, pb.employee_id, pb.employee_no, pb.department_id, pb.create_time from personnel_business pb where pb.process_type in (13,14,16,18,19,20,21,22,23) and pb.department_id in (select child_id from department_ids where department_id=?) and pb.employee_id = ? and pb.employee_no like ? and ? between pb.start_date and pb.end_date and pb.delete_flag = 0" ;
	private final static String RESULTSETFIELDLIST = "personnel_business_id,process_type,employee_id,employee_no,department_id,create_time";
	private final static String[] fieldNames = { "department_id", "employee_id", "employee_no", "today"};
}
