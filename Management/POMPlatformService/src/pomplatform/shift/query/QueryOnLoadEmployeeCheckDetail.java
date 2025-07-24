package pomplatform.shift.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.shift.bean.BaseOnLoadEmployeeCheckDetail;
import pomplatform.shift.bean.ConditionOnLoadEmployeeCheckDetail;

public class QueryOnLoadEmployeeCheckDetail extends AbstractQuery<BaseOnLoadEmployeeCheckDetail, ConditionOnLoadEmployeeCheckDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadEmployeeCheckDetail.class);

	public QueryOnLoadEmployeeCheckDetail() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseOnLoadEmployeeCheckDetail> executeQuery( KeyValuePair[] replacements, ConditionOnLoadEmployeeCheckDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseOnLoadEmployeeCheckDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadEmployeeCheckDetail __base = new BaseOnLoadEmployeeCheckDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCheckDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCheckTimeDetails(GenericBase.__getString(val));
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
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "select a.employee_id,b.employee_no,b.employee_name,b.department_id,a.check_date ,(SELECT array_to_string(array(SELECT to_char(check_time, 'HH24:MI:SS') FROM employee_checkinout_details where employee_id = a.employee_id and check_date = a.check_date ),',')) as check_time_details from employee_checkinout_details a left join employees b on a.employee_id = b.employee_id where a.check_date BETWEEN ? AND ? and a.employee_id = ? and b.employee_no like ? and b.employee_name like ? and b.department_id in(select child_id from department_ids where department_id = ?) and b.status = 0 GROUP BY a.employee_id,b.employee_no,b.employee_name,b.department_id,a.check_date ORDER BY a.check_date,b.department_id,a.employee_id" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,department_id,check_date,check_time_details";
	private final static String[] fieldNames = { "start_date", "end_date", "employee_id", "employee_no", "employee_name", "department_id"};
}
