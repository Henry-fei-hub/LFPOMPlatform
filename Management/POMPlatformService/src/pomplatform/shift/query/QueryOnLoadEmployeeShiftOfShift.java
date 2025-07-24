package pomplatform.shift.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.shift.bean.BaseOnLoadEmployeeShiftOfShift;
import pomplatform.shift.bean.ConditionOnLoadEmployeeShiftOfShift;

public class QueryOnLoadEmployeeShiftOfShift extends AbstractQuery<BaseOnLoadEmployeeShiftOfShift, ConditionOnLoadEmployeeShiftOfShift>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadEmployeeShiftOfShift.class);

	public QueryOnLoadEmployeeShiftOfShift() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseOnLoadEmployeeShiftOfShift> executeQuery( KeyValuePair[] replacements, ConditionOnLoadEmployeeShiftOfShift condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getDepartmentId(), 
				condition.getGender()
			);
	}

	@Override
	public BaseOnLoadEmployeeShiftOfShift generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadEmployeeShiftOfShift __base = new BaseOnLoadEmployeeShiftOfShift();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setGender(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsShift(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setCount(GenericBase.__getInt(val));
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
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
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

	private final static String __SQLText = "select a.employee_id,a.employee_no,a.employee_name,a.gender,a.department_id,b.year,b.month,case when b.year is null then false else true end as is_shift,0 as count from employees a LEFT JOIN employee_shift_manages b on a.employee_id= b.employee_id and b.year = ? and b.month = ? where (A.status = 0 OR b.employee_shift_manage_id > 0) and a.employee_no like ? and a.employee_name like ? and a.department_id in(select child_id from department_ids where department_id = ?) and a.gender = ? GROUP BY a.employee_id,a.employee_no,a.employee_name,a.gender,a.department_id,b.year,b.month order by a.department_id,a.employee_no" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,gender,department_id,year,month,is_shift,count";
	private final static String[] fieldNames = { "year", "month", "employee_no", "employee_name", "department_id", "gender"};
}
