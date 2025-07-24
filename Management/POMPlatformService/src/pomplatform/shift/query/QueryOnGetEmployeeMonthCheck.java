package pomplatform.shift.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.shift.bean.BaseOnGetEmployeeMonthCheck;
import pomplatform.shift.bean.ConditionOnGetEmployeeMonthCheck;

public class QueryOnGetEmployeeMonthCheck extends AbstractQuery<BaseOnGetEmployeeMonthCheck, ConditionOnGetEmployeeMonthCheck>
{

	private static final Logger __logger = Logger.getLogger(QueryOnGetEmployeeMonthCheck.class);

	public QueryOnGetEmployeeMonthCheck() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .employee_id");
	}

	@Override
	public BaseCollection<BaseOnGetEmployeeMonthCheck> executeQuery( KeyValuePair[] replacements, ConditionOnGetEmployeeMonthCheck condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getEmployeeName(), 
				condition.getEmployeeNo(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getPlateId(), 
				condition.getDepartmentId(), 
				condition.getEmployeeId(), 
				condition.getCompanyId()
			);
	}

	public BaseCollection<BaseOnGetEmployeeMonthCheck> runQuery( KeyValuePair[] replacements, ConditionOnGetEmployeeMonthCheck condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getEmployeeName(), 
				condition.getEmployeeNo(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getPlateId(), 
				condition.getDepartmentId(), 
				condition.getEmployeeId(), 
				condition.getCompanyId()
			);
	}

	public BaseCollection<BaseOnGetEmployeeMonthCheck> execute( KeyValuePair[] replacements, ConditionOnGetEmployeeMonthCheck condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getEmployeeName(), 
				condition.getEmployeeNo(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getPlateId(), 
				condition.getDepartmentId(), 
				condition.getEmployeeId(), 
				condition.getCompanyId()
			);
	}

	@Override
	public BaseOnGetEmployeeMonthCheck generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnGetEmployeeMonthCheck __base = new BaseOnGetEmployeeMonthCheck();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLateLeave5m(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLateLeave10m(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLateLeave30m(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLateLeave(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setThingLeaveTimes(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setThingLeaveHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThingLeaveDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIllLeaveTimes(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIllLeaveHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIllLeaveDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOtherLeaveTimes(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOtherLeaveHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOtherLeaveDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNornalOvertimeHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setWeekendOvertimeHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHolidayOvertimeHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAbsenceDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFactDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNumberOfLate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLateForMinutes(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNumberOfLeave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeaveForMinutes(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLateCharge(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAdjust(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAnnualLeave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setWeddingLeave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaternityLeave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPrenatalCheckLeave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaternityLeaveDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFuneralLeave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOutForBusiness(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOvertimePay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOvertimePaySub(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOvertimePayBefore(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOvertimePaySubBefore(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIsFullTime(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsLocked(GenericBase.__getBoolean(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		return count;
	}

	@Override
	public String getSQLText() {
		return __SQLText;
	}

	@Override
	public String getOriginalSQLText() {
		return __originalSQL;
	}

	@Override
	public String[] getQueryStringArray()  {
		return __queryConditions;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	@Override
	public String[] getConditionNames(){
		return fieldNames;
	}

	private final static String __SQLText = "SELECT A .employee_id, b.employee_no, b.employee_name, b.department_id, b.status, A.YEAR, A.MONTH, late_leave_5m, late_leave_10m, late_leave_30m, late_leave, thing_leave_times, thing_leave_hours, thing_leave_days, ill_leave_times, ill_leave_hours, ill_leave_days, other_leave_times, other_leave_hours, other_leave_days, nornal_overtime_hours, weekend_overtime_hours, holiday_overtime_hours, absence_days, should_days, fact_days, number_of_late, late_for_minutes, number_of_leave, leave_for_minutes, late_charge, adjust, annual_leave, wedding_leave, maternity_leave, prenatal_check_leave, maternity_leave_days, funeral_leave, out_for_business, overtime_pay, overtime_pay_sub, overtime_pay_before, overtime_pay_sub_before, is_full_time, is_locked FROM employee_month_checks A LEFT JOIN employees b ON A.employee_id = b.employee_id WHERE b.employee_name like ? and b.employee_no like ? and A.YEAR = ? and A.MONTH = ? and b.plate_id = ? and b.department_id IN ( SELECT child_id FROM department_ids WHERE department_id = ? ) and b.employee_id = ? and b.company_id = ? ORDER BY b.department_id, A.employee_id" ;
	private final static String __originalSQL = "SELECT A .employee_id, b.employee_no, b.employee_name, b.department_id, b.status, A.YEAR, A.MONTH, late_leave_5m, late_leave_10m, late_leave_30m, late_leave, thing_leave_times, thing_leave_hours, thing_leave_days, ill_leave_times, ill_leave_hours, ill_leave_days, other_leave_times, other_leave_hours, other_leave_days, nornal_overtime_hours, weekend_overtime_hours, holiday_overtime_hours, absence_days, should_days, fact_days, number_of_late, late_for_minutes, number_of_leave, leave_for_minutes, late_charge, adjust, annual_leave, wedding_leave, maternity_leave, prenatal_check_leave, maternity_leave_days, funeral_leave, out_for_business, overtime_pay, overtime_pay_sub, overtime_pay_before, overtime_pay_sub_before, is_full_time, is_locked FROM employee_month_checks A LEFT JOIN employees b ON A.employee_id = b.employee_id WHERE b.employee_name LIKE :employee_name AND b.employee_no LIKE :employee_no AND A.YEAR = :year AND A.MONTH = :month AND b.plate_id = :plate_id AND b.department_id IN ( SELECT child_id FROM department_ids WHERE department_id = :department_id ) AND b.employee_id = :employee_id AND b.company_id = :company_id ORDER BY b.department_id, A.employee_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"b.employee_name LIKE :employee_name AND b.employee_no LIKE :employee_no AND A.YEAR = :year AND A.MONTH = :month AND b.plate_id = :plate_id AND b.department_id IN ( SELECT child_id FROM department_ids WHERE department_id = :department_id ) AND b.employee_id = :employee_id AND b.company_id = :company_id\",\"startIndex\": 835,\"stopIndex\":1136,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"b.employee_name LIKE :employee_name\",\"fullFieldName\":\"b.employee_name\",\"operationName\":\"like\",\"variableName\":\"employeeName\",\"nextToken\":\"and\",\"startIndex\": 835,\"stopIndex\":869,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.employee_no LIKE :employee_no\",\"fullFieldName\":\"b.employee_no\",\"operationName\":\"like\",\"variableName\":\"employeeNo\",\"nextToken\":\"and\",\"startIndex\": 875,\"stopIndex\":905,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.YEAR = :year\",\"fullFieldName\":\"A.YEAR\",\"operationName\":\"=\",\"variableName\":\"year\",\"nextToken\":\"and\",\"startIndex\": 911,\"stopIndex\":924,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.MONTH = :month\",\"fullFieldName\":\"A.MONTH\",\"operationName\":\"=\",\"variableName\":\"month\",\"nextToken\":\"and\",\"startIndex\": 930,\"stopIndex\":945,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.plate_id = :plate_id\",\"fullFieldName\":\"b.plate_id\",\"operationName\":\"=\",\"variableName\":\"plateId\",\"nextToken\":\"and\",\"startIndex\": 951,\"stopIndex\":972,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.department_id IN ( SELECT child_id FROM department_ids WHERE department_id = :department_id )\",\"nextToken\":\"and\",\"startIndex\": 978,\"stopIndex\":1072,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"department_id = :department_id\",\"startIndex\": 1041,\"stopIndex\":1070,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"department_id = :department_id\",\"fullFieldName\":\"department_id\",\"operationName\":\"=\",\"variableName\":\"departmentId\",\"startIndex\": 1041,\"stopIndex\":1070,\"variableNum\": 5,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]},{\"fullCondition\": \"b.employee_id = :employee_id\",\"fullFieldName\":\"b.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 1078,\"stopIndex\":1105,\"variableNum\": 6,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.company_id = :company_id\",\"fullFieldName\":\"b.company_id\",\"operationName\":\"=\",\"variableName\":\"companyId\",\"startIndex\": 1111,\"stopIndex\":1136,\"variableNum\": 7,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,department_id,status,year,month,late_leave_5m,late_leave_10m,late_leave_30m,late_leave,thing_leave_times,thing_leave_hours,thing_leave_days,ill_leave_times,ill_leave_hours,ill_leave_days,other_leave_times,other_leave_hours,other_leave_days,nornal_overtime_hours,weekend_overtime_hours,holiday_overtime_hours,absence_days,should_days,fact_days,number_of_late,late_for_minutes,number_of_leave,leave_for_minutes,late_charge,adjust,annual_leave,wedding_leave,maternity_leave,prenatal_check_leave,maternity_leave_days,funeral_leave,out_for_business,overtime_pay,overtime_pay_sub,overtime_pay_before,overtime_pay_sub_before,is_full_time,is_locked";
	private final static String[] fieldNames = { "employee_name", "employee_no", "year", "month", "plate_id", "department_id", "employee_id", "company_id"};
}
