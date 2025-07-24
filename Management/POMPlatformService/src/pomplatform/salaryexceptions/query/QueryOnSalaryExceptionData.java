package pomplatform.salaryexceptions.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.salaryexceptions.bean.BaseOnSalaryExceptionData;
import pomplatform.salaryexceptions.bean.ConditionOnSalaryExceptionData;

public class QueryOnSalaryExceptionData extends AbstractQuery<BaseOnSalaryExceptionData, ConditionOnSalaryExceptionData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnSalaryExceptionData.class);

	public QueryOnSalaryExceptionData() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .employee_id");
	}

	@Override
	public BaseCollection<BaseOnSalaryExceptionData> executeQuery( KeyValuePair[] replacements, ConditionOnSalaryExceptionData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseOnSalaryExceptionData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnSalaryExceptionData __base = new BaseOnSalaryExceptionData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAttendanceDeduction(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFactDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIsApply(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsisApply(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setActuallyDeduction(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT A .employee_id, e.employee_no, e.employee_name, A .day_attendance_deduction AS attendance_deduction, A .detail_date AS record_date, edc.remark AS reason, edc.fact_days, CASE WHEN (s.salary_exception_id IS NULL or s.is_apply = false) THEN FALSE ELSE TRUE END AS is_apply, s.remark, edc. YEAR, edc. MONTH, s.is_apply as isis_apply ,s.actually_deduction FROM employee_payment_details A LEFT JOIN employees e ON A .employee_id = e.employee_id AND A .day_attendance_deduction < 0 LEFT JOIN employee_day_checks edc ON e.employee_id = edc.employee_id AND A .detail_date = edc.record_date LEFT JOIN salary_exceptions s ON A .employee_id = s.employee_id AND A .detail_date = s.record_date and s.is_apply = true WHERE edc. YEAR =? AND edc. MONTH =? AND edc.status IN (2, 3, 4) AND A .employee_id =? ORDER BY A .employee_id, A .detail_date;" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,attendance_deduction,record_date,reason,fact_days,is_apply,remark,year,month,isis_apply,actually_deduction";
	private final static String[] fieldNames = { "YEAR", "MONTH", "employee_id"};
}
