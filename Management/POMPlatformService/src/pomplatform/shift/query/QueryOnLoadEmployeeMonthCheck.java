package pomplatform.shift.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.shift.bean.BaseOnLoadEmployeeMonthCheck;
import pomplatform.shift.bean.ConditionOnLoadEmployeeMonthCheck;

public class QueryOnLoadEmployeeMonthCheck extends AbstractQuery<BaseOnLoadEmployeeMonthCheck, ConditionOnLoadEmployeeMonthCheck>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadEmployeeMonthCheck.class);

	public QueryOnLoadEmployeeMonthCheck() throws java.sql.SQLException
	{
		setParameterNumber(9);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .employee_id");
	}

	@Override
	public BaseCollection<BaseOnLoadEmployeeMonthCheck> executeQuery( KeyValuePair[] replacements, ConditionOnLoadEmployeeMonthCheck condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements,
				condition.getEmployeeName(),
				condition.getEmployeeNo(),
				condition.getYear(),
				condition.getMonth(),
				condition.getPlateId(),
				condition.getDepartmentId(),
				condition.getEmployeeId(),
				condition.getCompanyId(),
				condition.getRecordDate()
		);
	}

	public BaseCollection<BaseOnLoadEmployeeMonthCheck> runQuery( KeyValuePair[] replacements, ConditionOnLoadEmployeeMonthCheck condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements,
				condition.getEmployeeName(),
				condition.getEmployeeNo(),
				condition.getYear(),
				condition.getMonth(),
				condition.getPlateId(),
				condition.getDepartmentId(),
				condition.getEmployeeId(),
				condition.getCompanyId(),
				condition.getRecordDate()
		);
	}

	public BaseCollection<BaseOnLoadEmployeeMonthCheck> execute( KeyValuePair[] replacements, ConditionOnLoadEmployeeMonthCheck condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements,
				condition.getEmployeeName(),
				condition.getEmployeeNo(),
				condition.getYear(),
				condition.getMonth(),
				condition.getPlateId(),
				condition.getDepartmentId(),
				condition.getEmployeeId(),
				condition.getCompanyId(),
				condition.getRecordDate()
		);
	}

	@Override
	public BaseOnLoadEmployeeMonthCheck generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadEmployeeMonthCheck __base = new BaseOnLoadEmployeeMonthCheck();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLateLeave5m(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setLateLeave10m(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setLateLeave30m(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setLateLeave(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setThingLeaveTimes(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setThingLeaveHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThingLeaveDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIllLeaveTimes(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setIllLeaveHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIllLeaveDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOtherLeaveTimes(GenericBase.__getLong(val));
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
		if(args[8] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[8]));
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

	private final static String __SQLText = "SELECT A .employee_id, b.employee_no, b.employee_name, b.department_id, b.status, A.YEAR, A.MONTH, SUM ( late_leave_5m ) AS late_leave_5m, SUM ( late_leave_10m ) AS late_leave_10m, SUM ( late_leave_30m ) AS late_leave_30m, SUM ( late_leave ) AS late_leave, SUM ( A.thing_leave_times ) AS thing_leave_times, SUM ( A.thing_leave_hours ) AS thing_leave_hours, SUM ( A.thing_leave_days ) AS thing_leave_days, SUM ( A.ill_leave_times ) AS ill_leave_times, SUM ( A.ill_leave_hours ) AS ill_leave_hours, SUM ( A.ill_leave_days ) AS ill_leave_days, SUM ( A.other_leave_times ) AS other_leave_times, SUM ( A.other_leave_hours ) AS other_leave_hours, SUM ( A.other_leave_days ) AS other_leave_days, SUM ( A.nornal_overtime_hours ) AS nornal_overtime_hours, SUM ( A.weekend_overtime_hours ) AS weekend_overtime_hours, SUM ( A.holiday_overtime_hours ) AS holiday_overtime_hours, SUM ( A.absence_days ) AS absence_days, SUM ( A.should_days ) AS should_days, SUM ( A.fact_days ) AS fact_days, SUM ( A.number_of_late ) AS number_of_late, SUM ( A.late_for_minutes ) AS late_for_minutes, SUM ( A.number_of_leave ) AS number_of_leave, SUM ( A.leave_for_minutes ) AS leave_for_minutes, SUM ( A.late_charge ) AS late_charge, SUM ( A.adjust ) AS adjust, SUM ( annual_leave ) AS annual_leave, SUM ( wedding_leave ) AS wedding_leave, SUM ( maternity_leave ) AS maternity_leave, SUM ( prenatal_check_leave ) AS prenatal_check_leave, SUM ( maternity_leave_days ) AS maternity_leave_days, SUM ( funeral_leave ) AS funeral_leave, SUM ( out_for_business ) AS out_for_business, SUM ( overtime_pay ) AS overtime_pay, SUM ( overtime_pay_sub ) AS overtime_pay_sub, SUM ( overtime_pay_before ) AS overtime_pay_before, SUM ( overtime_pay_sub_before ) AS overtime_pay_sub_before, is_locked FROM employee_day_checks A LEFT JOIN employees b ON A.employee_id = b.employee_id WHERE b.employee_name like ? and b.employee_no like ? and A.YEAR = ? and A.MONTH = ? and b.plate_id = ? and b.department_id IN ( SELECT child_id FROM department_ids WHERE department_id = ? ) and b.employee_id = ? and b.company_id = ? and A.record_date <= ? GROUP BY A.employee_id, b.employee_no, b.employee_name, b.department_id, b.status, A.YEAR, A.MONTH, A.is_locked ORDER BY b.department_id, A.employee_id" ;
	private final static String __originalSQL = "SELECT A .employee_id, b.employee_no, b.employee_name, b.department_id, b.status, A.YEAR, A.MONTH, SUM ( late_leave_5m ) AS late_leave_5m, SUM ( late_leave_10m ) AS late_leave_10m, SUM ( late_leave_30m ) AS late_leave_30m, SUM ( late_leave ) AS late_leave, SUM ( A.thing_leave_times ) AS thing_leave_times, SUM ( A.thing_leave_hours ) AS thing_leave_hours, SUM ( A.thing_leave_days ) AS thing_leave_days, SUM ( A.ill_leave_times ) AS ill_leave_times, SUM ( A.ill_leave_hours ) AS ill_leave_hours, SUM ( A.ill_leave_days ) AS ill_leave_days, SUM ( A.other_leave_times ) AS other_leave_times, SUM ( A.other_leave_hours ) AS other_leave_hours, SUM ( A.other_leave_days ) AS other_leave_days, SUM ( A.nornal_overtime_hours ) AS nornal_overtime_hours, SUM ( A.weekend_overtime_hours ) AS weekend_overtime_hours, SUM ( A.holiday_overtime_hours ) AS holiday_overtime_hours, SUM ( A.absence_days ) AS absence_days, SUM ( A.should_days ) AS should_days, SUM ( A.fact_days ) AS fact_days, SUM ( A.number_of_late ) AS number_of_late, SUM ( A.late_for_minutes ) AS late_for_minutes, SUM ( A.number_of_leave ) AS number_of_leave, SUM ( A.leave_for_minutes ) AS leave_for_minutes, SUM ( A.late_charge ) AS late_charge, SUM ( A.adjust ) AS adjust, SUM ( annual_leave ) AS annual_leave, SUM ( wedding_leave ) AS wedding_leave, SUM ( maternity_leave ) AS maternity_leave, SUM ( prenatal_check_leave ) AS prenatal_check_leave, SUM ( maternity_leave_days ) AS maternity_leave_days, SUM ( funeral_leave ) AS funeral_leave, SUM ( out_for_business ) AS out_for_business, SUM ( overtime_pay ) AS overtime_pay, SUM ( overtime_pay_sub ) AS overtime_pay_sub, SUM ( overtime_pay_before ) AS overtime_pay_before, SUM ( overtime_pay_sub_before ) AS overtime_pay_sub_before, is_locked FROM employee_day_checks A LEFT JOIN employees b ON A.employee_id = b.employee_id WHERE b.employee_name LIKE :employee_name AND b.employee_no LIKE :employee_no AND A.YEAR = :year AND A.MONTH = :month AND b.plate_id = :plate_id AND b.department_id IN ( SELECT child_id FROM department_ids WHERE department_id = :department_id ) AND b.employee_id = :employee_id AND b.company_id = :company_id and A.record_date<=:record_date GROUP BY A.employee_id, b.employee_no, b.employee_name, b.department_id, b.status, A.YEAR, A.MONTH, A.is_locked ORDER BY b.department_id, A.employee_id";
	private final static String[] __queryConditions = {
			"[{\"fullCondition\": \"b.employee_name LIKE :employee_name AND b.employee_no LIKE :employee_no AND A.YEAR = :year AND A.MONTH = :month AND b.plate_id = :plate_id AND b.department_id IN ( SELECT child_id FROM department_ids WHERE department_id = :department_id ) AND b.employee_id = :employee_id AND b.company_id = :company_id and A.record_date<=:record_date\",\"startIndex\": 1843,\"stopIndex\":2176,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"b.employee_name LIKE :employee_name\",\"fullFieldName\":\"b.employee_name\",\"operationName\":\"like\",\"variableName\":\"employeeName\",\"nextToken\":\"and\",\"startIndex\": 1843,\"stopIndex\":1877,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.employee_no LIKE :employee_no\",\"fullFieldName\":\"b.employee_no\",\"operationName\":\"like\",\"variableName\":\"employeeNo\",\"nextToken\":\"and\",\"startIndex\": 1883,\"stopIndex\":1913,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.YEAR = :year\",\"fullFieldName\":\"A.YEAR\",\"operationName\":\"=\",\"variableName\":\"year\",\"nextToken\":\"and\",\"startIndex\": 1919,\"stopIndex\":1932,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.MONTH = :month\",\"fullFieldName\":\"A.MONTH\",\"operationName\":\"=\",\"variableName\":\"month\",\"nextToken\":\"and\",\"startIndex\": 1938,\"stopIndex\":1953,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.plate_id = :plate_id\",\"fullFieldName\":\"b.plate_id\",\"operationName\":\"=\",\"variableName\":\"plateId\",\"nextToken\":\"and\",\"startIndex\": 1959,\"stopIndex\":1980,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.department_id IN ( SELECT child_id FROM department_ids WHERE department_id = :department_id )\",\"nextToken\":\"and\",\"startIndex\": 1986,\"stopIndex\":2080,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"department_id = :department_id\",\"startIndex\": 2049,\"stopIndex\":2078,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"department_id = :department_id\",\"fullFieldName\":\"department_id\",\"operationName\":\"=\",\"variableName\":\"departmentId\",\"startIndex\": 2049,\"stopIndex\":2078,\"variableNum\": 5,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]},{\"fullCondition\": \"b.employee_id = :employee_id\",\"fullFieldName\":\"b.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 2086,\"stopIndex\":2113,\"variableNum\": 6,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.company_id = :company_id\",\"fullFieldName\":\"b.company_id\",\"operationName\":\"=\",\"variableName\":\"companyId\",\"nextToken\":\"and\",\"startIndex\": 2119,\"stopIndex\":2144,\"variableNum\": 7,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.record_date<=:record_date\",\"fullFieldName\":\"A.record_date\",\"operationName\":\"<=\",\"variableName\":\"recordDate\",\"startIndex\": 2150,\"stopIndex\":2176,\"variableNum\": 8,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,department_id,status,year,month,late_leave_5m,late_leave_10m,late_leave_30m,late_leave,thing_leave_times,thing_leave_hours,thing_leave_days,ill_leave_times,ill_leave_hours,ill_leave_days,other_leave_times,other_leave_hours,other_leave_days,nornal_overtime_hours,weekend_overtime_hours,holiday_overtime_hours,absence_days,should_days,fact_days,number_of_late,late_for_minutes,number_of_leave,leave_for_minutes,late_charge,adjust,annual_leave,wedding_leave,maternity_leave,prenatal_check_leave,maternity_leave_days,funeral_leave,out_for_business,overtime_pay,overtime_pay_sub,overtime_pay_before,overtime_pay_sub_before,is_locked";
	private final static String[] fieldNames = { "employee_name", "employee_no", "year", "month", "plate_id", "department_id", "employee_id", "company_id", "record_date"};
}
