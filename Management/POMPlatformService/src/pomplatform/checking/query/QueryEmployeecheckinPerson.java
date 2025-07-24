package pomplatform.checking.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.checking.bean.BaseEmployeecheckinPerson;
import pomplatform.checking.bean.ConditionEmployeecheckinPerson;

public class QueryEmployeecheckinPerson extends AbstractQuery<BaseEmployeecheckinPerson, ConditionEmployeecheckinPerson>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeecheckinPerson.class);

	public QueryEmployeecheckinPerson() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("count(abc.employee_id) as checkin_person from ( select employee_id from employee_checkinouts where check_date = :todate and (check_in_time is NOT NULL or check_out_time is not null) UNION ALL select employee_id from personnel_business where start_date BETWEEN :todate and :todate or end_date BETWEEN :todate and :todate  and process_type in(13");
	}

	@Override
	public BaseCollection<BaseEmployeecheckinPerson> executeQuery( KeyValuePair[] replacements, ConditionEmployeecheckinPerson condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getTodate(), 
				condition.getTodate(), 
				condition.getTodate(), 
				condition.getTodate(), 
				condition.getTodate(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseEmployeecheckinPerson generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeecheckinPerson __base = new BaseEmployeecheckinPerson();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCheckinPerson(GenericBase.__getLong(val));
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
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
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

	private final static String __SQLText = " select count(abc.employee_id) as checkin_person from ( select employee_id from employee_checkinouts where check_date = ? and (check_in_time is NOT NULL or check_out_time is not null) UNION ALL select employee_id from personnel_business where start_date BETWEEN ? and ? or end_date BETWEEN ? and ? and process_type in(13,14,15) ) as abc left join employees b on abc.employee_id = b.employee_id where b.is_check = true and b.status = 0 and b.employee_id > 0 and b.department_id in (select child_id from department_ids where department_id = ?)" ;
	private final static String RESULTSETFIELDLIST = "checkin_person";
	private final static String[] fieldNames = { "todate", "todate", "todate", "todate", "todate", "department_id"};
}
