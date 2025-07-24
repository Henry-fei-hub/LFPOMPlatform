package pomplatform.employee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employee.bean.BaseResignEmployeeEachMonthDetail;
import pomplatform.employee.bean.ConditionResignEmployeeEachMonthDetail;

public class QueryResignEmployeeEachMonthDetail extends AbstractQuery<BaseResignEmployeeEachMonthDetail, ConditionResignEmployeeEachMonthDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryResignEmployeeEachMonthDetail.class);

	public QueryResignEmployeeEachMonthDetail() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.department_id");
	}

	@Override
	public BaseCollection<BaseResignEmployeeEachMonthDetail> executeQuery( KeyValuePair[] replacements, ConditionResignEmployeeEachMonthDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getDepartmentId(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseResignEmployeeEachMonthDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseResignEmployeeEachMonthDetail __base = new BaseResignEmployeeEachMonthDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setResignDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDutyId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT a.department_id, a.employee_id, case when b.end_date is null then a.resignation_date else b.end_date end as resign_date, b.reason, c.process_id, c.business_id, c.process_type, c.process_instance_id, a.plate_id, a.duty_id from employees a LEFT JOIN personnel_business b on a.employee_id = b.employee_id and b.process_type = 25 and b.delete_flag = 0 and b.is_completed = true LEFT JOIN system_process_instances c on b.personnel_business_id = c.business_id and b.process_type = c.process_type and c.delete_flag = 0 and c.process_status = 3 where a.status = 1 and a.department_id = ? and EXTRACT(YEAR from a.resignation_date) = ? and EXTRACT(MONTH from a.resignation_date) = ? order by resign_date, employee_id" ;
	private final static String RESULTSETFIELDLIST = "department_id,employee_id,resign_date,reason,process_id,business_id,process_type,process_instance_id,plate_id,duty_id";
	private final static String[] fieldNames = { "department_id", "year", "month"};
}
