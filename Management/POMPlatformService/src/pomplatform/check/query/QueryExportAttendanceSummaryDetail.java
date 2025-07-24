package pomplatform.check.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.check.bean.BaseExportAttendanceSummaryDetail;
import pomplatform.check.bean.ConditionExportAttendanceSummaryDetail;

public class QueryExportAttendanceSummaryDetail extends AbstractQuery<BaseExportAttendanceSummaryDetail, ConditionExportAttendanceSummaryDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryExportAttendanceSummaryDetail.class);

	public QueryExportAttendanceSummaryDetail() throws java.sql.SQLException
	{
		setParameterNumber(9);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("e.employee_id");
	}

	@Override
	public BaseCollection<BaseExportAttendanceSummaryDetail> executeQuery( KeyValuePair[] replacements, ConditionExportAttendanceSummaryDetail condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements,
				condition.getPlateId(),
				condition.getYear(),
				condition.getMonth(),
				condition.getEmployeeId(),
				condition.getEmployeeNo(),
				condition.getRecordDate(),
				condition.getEmployeeName(),
				condition.getDepartmentId(),
				condition.getResignationDate()
		);
	}

	public BaseCollection<BaseExportAttendanceSummaryDetail> runQuery( KeyValuePair[] replacements, ConditionExportAttendanceSummaryDetail condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements,
				condition.getPlateId(),
				condition.getYear(),
				condition.getMonth(),
				condition.getEmployeeId(),
				condition.getEmployeeNo(),
				condition.getRecordDate(),
				condition.getEmployeeName(),
				condition.getDepartmentId(),
				condition.getResignationDate()
		);
	}

	public BaseCollection<BaseExportAttendanceSummaryDetail> execute( KeyValuePair[] replacements, ConditionExportAttendanceSummaryDetail condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements,
				condition.getPlateId(),
				condition.getYear(),
				condition.getMonth(),
				condition.getEmployeeId(),
				condition.getEmployeeNo(),
				condition.getRecordDate(),
				condition.getEmployeeName(),
				condition.getDepartmentId(),
				condition.getResignationDate()
		);
	}

	@Override
	public BaseExportAttendanceSummaryDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseExportAttendanceSummaryDetail __base = new BaseExportAttendanceSummaryDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeDayCheckId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setShiftManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCheckin(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCheckout(GenericBase.__getDateFromSQL(val));
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
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsLocked(GenericBase.__getBoolean(val));
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
		if((val = __data[count++]) != null) __base.setOvertimePaySubBefore(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOvertimePayBefore(GenericBase.__getDecimal(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
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

	private final static String __SQLText = "SELECT e.employee_id, e.department_id, e.employee_no, mdc.* FROM employee_day_checks mdc LEFT JOIN employees e ON e.employee_id = mdc.employee_id WHERE e.plate_id = ? and mdc.YEAR = ? and mdc.MONTH = ? and mdc.employee_id = ? and e.employee_no = ? and mdc.record_date <= ? and e.employee_name like ? and e.department_id IN ( SELECT child_id FROM department_ids WHERE department_id = ? ) and ( (e.status = 0 or ( (e.status = 1 and e.resignation_date >= ?) )) ) ORDER BY e.department_id, e.employee_id, mdc.record_date" ;
	private final static String __originalSQL = "SELECT e.employee_id, e.department_id, e.employee_no, mdc.* FROM employee_day_checks mdc LEFT JOIN employees e ON e.employee_id = mdc.employee_id WHERE e.plate_id = :plate_id AND mdc.YEAR = :year AND mdc.MONTH = :month AND mdc.employee_id = :employee_id AND e.employee_no = :employee_no and mdc.record_date<=:record_date AND e.employee_name LIKE :employee_name AND e.department_id IN ( SELECT child_id FROM department_ids WHERE department_id = :department_id ) AND ( e.status = 0 OR ( e.status = 1 AND e.resignation_date >= :resignation_date ) ) ORDER BY e.department_id, e.employee_id, mdc.record_date";
	private final static String[] __queryConditions = {
			"[{\"fullCondition\": \"e.plate_id = :plate_id AND mdc.YEAR = :year AND mdc.MONTH = :month AND mdc.employee_id = :employee_id AND e.employee_no = :employee_no and mdc.record_date<=:record_date AND e.employee_name LIKE :employee_name AND e.department_id IN ( SELECT child_id FROM department_ids WHERE department_id = :department_id ) AND ( e.status = 0 OR ( e.status = 1 AND e.resignation_date >= :resignation_date ) )\",\"startIndex\": 152,\"stopIndex\":544,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"e.plate_id = :plate_id\",\"fullFieldName\":\"e.plate_id\",\"operationName\":\"=\",\"variableName\":\"plateId\",\"nextToken\":\"and\",\"startIndex\": 152,\"stopIndex\":173,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mdc.YEAR = :year\",\"fullFieldName\":\"mdc.YEAR\",\"operationName\":\"=\",\"variableName\":\"year\",\"nextToken\":\"and\",\"startIndex\": 179,\"stopIndex\":194,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mdc.MONTH = :month\",\"fullFieldName\":\"mdc.MONTH\",\"operationName\":\"=\",\"variableName\":\"month\",\"nextToken\":\"and\",\"startIndex\": 200,\"stopIndex\":217,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mdc.employee_id = :employee_id\",\"fullFieldName\":\"mdc.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 223,\"stopIndex\":252,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"e.employee_no = :employee_no\",\"fullFieldName\":\"e.employee_no\",\"operationName\":\"=\",\"variableName\":\"employeeNo\",\"nextToken\":\"and\",\"startIndex\": 258,\"stopIndex\":285,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mdc.record_date<=:record_date\",\"fullFieldName\":\"mdc.record_date\",\"operationName\":\"<=\",\"variableName\":\"recordDate\",\"nextToken\":\"and\",\"startIndex\": 291,\"stopIndex\":319,\"variableNum\": 5,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"e.employee_name LIKE :employee_name\",\"fullFieldName\":\"e.employee_name\",\"operationName\":\"like\",\"variableName\":\"employeeName\",\"nextToken\":\"and\",\"startIndex\": 325,\"stopIndex\":359,\"variableNum\": 6,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"e.department_id IN ( SELECT child_id FROM department_ids WHERE department_id = :department_id )\",\"nextToken\":\"and\",\"startIndex\": 365,\"stopIndex\":459,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"department_id = :department_id\",\"startIndex\": 428,\"stopIndex\":457,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"department_id = :department_id\",\"fullFieldName\":\"department_id\",\"operationName\":\"=\",\"variableName\":\"departmentId\",\"startIndex\": 428,\"stopIndex\":457,\"variableNum\": 7,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]},{\"fullCondition\": \"( e.status = 0 OR ( e.status = 1 AND e.resignation_date >= :resignation_date ) )\",\"startIndex\": 465,\"stopIndex\":544,\"variableNum\": 0,\"variableCount\": 0,\"isor\":true,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"e.status = 0\",\"nextToken\":\"or\",\"startIndex\": 467,\"stopIndex\":478,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": []},{\"fullCondition\": \"( e.status = 1 AND e.resignation_date >= :resignation_date )\",\"startIndex\": 483,\"stopIndex\":542,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"e.status = 1\",\"nextToken\":\"and\",\"startIndex\": 485,\"stopIndex\":496,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": []},{\"fullCondition\": \"e.resignation_date >= :resignation_date\",\"fullFieldName\":\"e.resignation_date\",\"operationName\":\">=\",\"variableName\":\"resignationDate\",\"startIndex\": 502,\"stopIndex\":540,\"variableNum\": 8,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]}]}]"
	};
	private final static String RESULTSETFIELDLIST = "employee_id,department_id,employee_no,employee_day_check_id,employee_id,year,month,record_date,shift_manage_id,checkin,checkout,late_leave_5m,late_leave_10m,late_leave_30m,late_leave,thing_leave_times,thing_leave_hours,thing_leave_days,ill_leave_times,ill_leave_hours,ill_leave_days,other_leave_times,other_leave_hours,other_leave_days,nornal_overtime_hours,weekend_overtime_hours,holiday_overtime_hours,absence_days,should_days,fact_days,status,operate_employee_id,operate_time,remark,is_locked,number_of_late,late_for_minutes,number_of_leave,leave_for_minutes,late_charge,adjust,annual_leave,wedding_leave,maternity_leave,prenatal_check_leave,maternity_leave_days,funeral_leave,out_for_business,overtime_pay,overtime_pay_sub,overtime_pay_sub_before,overtime_pay_before";
	private final static String[] fieldNames = { "plate_id", "year", "month", "employee_id", "employee_no", "record_date", "employee_name", "department_id", "resignation_date"};
}