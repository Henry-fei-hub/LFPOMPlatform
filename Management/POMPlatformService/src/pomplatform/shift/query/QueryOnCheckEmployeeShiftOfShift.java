package pomplatform.shift.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.shift.bean.BaseOnCheckEmployeeShiftOfShift;
import pomplatform.shift.bean.ConditionOnCheckEmployeeShiftOfShift;

public class QueryOnCheckEmployeeShiftOfShift extends AbstractQuery<BaseOnCheckEmployeeShiftOfShift, ConditionOnCheckEmployeeShiftOfShift>
{

	private static final Logger __logger = Logger.getLogger(QueryOnCheckEmployeeShiftOfShift.class);

	public QueryOnCheckEmployeeShiftOfShift() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_shift_manage_id");
	}

	@Override
	public BaseCollection<BaseOnCheckEmployeeShiftOfShift> executeQuery( KeyValuePair[] replacements, ConditionOnCheckEmployeeShiftOfShift condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseOnCheckEmployeeShiftOfShift generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnCheckEmployeeShiftOfShift __base = new BaseOnCheckEmployeeShiftOfShift();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeShiftManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setGender(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setShiftManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "select a.employee_shift_manage_id,a.employee_id,b.employee_no,b.employee_name,b.gender,b.department_id,a.shift_manage_id,a.year,a.month,a.record_date from employee_shift_manages a left join employees b on a.employee_id = b.employee_id where a.employee_id = ? and a.year = ? and a.month = ? ORDER BY a.record_date" ;
	private final static String RESULTSETFIELDLIST = "employee_shift_manage_id,employee_id,employee_no,employee_name,gender,department_id,shift_manage_id,year,month,record_date";
	private final static String[] fieldNames = { "employee_id", "year", "month"};
}
