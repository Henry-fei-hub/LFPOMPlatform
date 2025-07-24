package pomplatform.shift.query;

import org.apache.log4j.Logger;
import java.util.Map;
import java.util.List;
import delicacy.common.CommonUtils;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.shift.bean.BaseAttendanceAnalyseCheck;
import pomplatform.shift.bean.ConditionAttendanceAnalyseCheck;

public class QueryAttendanceAnalyseCheck extends AbstractQuery<BaseAttendanceAnalyseCheck, ConditionAttendanceAnalyseCheck>
{

	private static final Logger __logger = Logger.getLogger(QueryAttendanceAnalyseCheck.class);

	public QueryAttendanceAnalyseCheck() throws java.sql.SQLException 
	{
		setParameterNumber(12);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_id");
	}

	public static BaseAttendanceAnalyseCheck selectOne(Map params) throws java.sql.SQLException {

		params.put(GenericBase.NAME_CURRENT_PAGE, 1);
		params.put(GenericBase.NAME_PAGE_LINES, 1);
		BaseCollection<BaseAttendanceAnalyseCheck> res = select(params, null, false);
		if(res.getCollections().size() > 0) return res.getCollections().get(0);
		return null;
	}


	public static BaseAttendanceAnalyseCheck selectOne(ConditionAttendanceAnalyseCheck c) throws java.sql.SQLException {

		c.setCurrentPage(1);
		c.setPageLines(1);
		BaseCollection<BaseAttendanceAnalyseCheck> res = select(c, null, false);
		if(res.getCollections().size() > 0) return res.getCollections().get(0);
		return null;
	}


	public static BaseCollection<BaseAttendanceAnalyseCheck> select(Map params) throws java.sql.SQLException {

		return select(params, null);
	}


	public static BaseCollection<BaseAttendanceAnalyseCheck> select(Map params, Map replaces) throws java.sql.SQLException {

		return select(params, replaces, true);
	}


	public static BaseCollection<BaseAttendanceAnalyseCheck> select(Map params, Map replaces, boolean loadTotalPages) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		ConditionAttendanceAnalyseCheck c = new ConditionAttendanceAnalyseCheck();
		c.setDataFromMap(CommonUtils.preprocess(params));
		QueryAttendanceAnalyseCheck dao = new QueryAttendanceAnalyseCheck();
		if(!loadTotalPages) dao.setLoadTotalPages(loadTotalPages);
		return dao.runQuery(replacements, c);
	}


	public static BaseCollection<BaseAttendanceAnalyseCheck> select(ConditionAttendanceAnalyseCheck c, Map replaces, boolean loadTotalPages) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		QueryAttendanceAnalyseCheck dao = new QueryAttendanceAnalyseCheck();
		if(!loadTotalPages) dao.setLoadTotalPages(loadTotalPages);
		return dao.runQuery(replacements, c);
	}


	public static List<BaseAttendanceAnalyseCheck> query() throws java.sql.SQLException {

		return query(new java.util.HashMap(), null);
	}


	public static List<BaseAttendanceAnalyseCheck> query(Map params) throws java.sql.SQLException {

		return query(params, null);
	}


	public static List<BaseAttendanceAnalyseCheck> query(Map params, Map replaces) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		ConditionAttendanceAnalyseCheck c = new ConditionAttendanceAnalyseCheck();
		c.setDataFromMap(CommonUtils.preprocess(params));
		QueryAttendanceAnalyseCheck dao = new QueryAttendanceAnalyseCheck();
		return dao.runQuery(replacements, c).getCollections();
	}


	@Override
	public BaseCollection<BaseAttendanceAnalyseCheck> executeQuery( KeyValuePair[] replacements, ConditionAttendanceAnalyseCheck condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getEmployeeId(), 
				condition.getCompanyId()
			);
	}

	public BaseCollection<BaseAttendanceAnalyseCheck> runQuery( KeyValuePair[] replacements, ConditionAttendanceAnalyseCheck condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getEmployeeId(), 
				condition.getCompanyId()
			);
	}

	public BaseCollection<BaseAttendanceAnalyseCheck> execute( KeyValuePair[] replacements, ConditionAttendanceAnalyseCheck condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getEmployeeId(), 
				condition.getCompanyId()
			);
	}

	@Override
	public BaseAttendanceAnalyseCheck generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAttendanceAnalyseCheck __base = new BaseAttendanceAnalyseCheck();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setResignationDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOnboardDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setIsCheck(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setGender(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setHolidayManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setIsWorkDay(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setCheckinTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCheckoutTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setShiftManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setShiftTimeManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setShiftTimeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCheckSignIn(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setCheckSignOff(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setSignInTime(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSignOffTime(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLateMinutes(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLeaveEarlyTime(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOvertimeStartTime(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentType(GenericBase.__getInt(val));
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
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
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
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	@Override
	public String[] getConditionNames(){
		return fieldNames;
	}

	public final static String __SQLText = "SELECT e.employee_id, e.employee_no, e.employee_name, e.department_id, e.status, e.resignation_date, e.onboard_date, e.is_check, e.gender, s.record_date, h.holiday_manage_id, h.name, h.start_time, h.end_time, h.is_work_day, c.checkin_time, c.checkout_time, s.shift_manage_id, t.shift_time_manage_id, t.shift_time_name, t.check_sign_in, t.check_sign_off, t.sign_in_time, t.sign_off_time, t.late_minutes, t.leave_early_time, t.overtime_start_time, dep.department_type FROM employees AS e LEFT JOIN employee_shift_manages AS s ON e.employee_id = s.employee_id and s.record_date between ? and ? LEFT JOIN holiday_manages AS h ON s.record_date = h.record_date LEFT JOIN ( SELECT employee_id, check_date, MIN(case when check_time > date(to_char(check_date,'YYYY-MM-DD'))+time '06:00' THEN check_time end) AS checkin_time, MAX(case when check_time > date(to_char(check_date,'YYYY-MM-DD'))+time '06:00' THEN check_time end) AS checkout_time FROM employee_checkinout_details WHERE check_date between ? and ? GROUP BY employee_id, check_date ) AS c ON e.employee_id = c.employee_id AND s.record_date = c.check_date LEFT JOIN time_of_shift_manages AS sl ON s.shift_manage_id = sl.shift_manage_id LEFT JOIN shift_time_manages AS t ON sl.shift_time_manage_id = t.shift_time_manage_id LEFT JOIN employee_month_checks AS m ON e.employee_id = m.employee_id and m.year = ? and m.month = ? LEFT JOIN departments AS dep ON e.department_id = dep.department_id WHERE (e.employee_id > 0 and e.status = 0 and e.is_check = TRUE or (EXTRACT( YEAR FROM resignation_date ) = ? and EXTRACT( MONTH FROM resignation_date ) = ?) or (e.is_check = FALSE and (EXTRACT( YEAR FROM onboard_date ) = ? and EXTRACT( MONTH FROM onboard_date ) = ?))) and e.employee_id = ? and e.company_id = ? and ( M.is_locked = FALSE OR M.is_locked IS NULL ) ORDER BY e.employee_id, s.record_date" ;
	public final static String __originalSQL = "SELECT e.employee_id, e.employee_no, e.employee_name, e.department_id, e.status, e.resignation_date, e.onboard_date, e.is_check, e.gender, s.record_date, h.holiday_manage_id, h.name, h.start_time, h.end_time, h.is_work_day, c.checkin_time, c.checkout_time, s.shift_manage_id, t.shift_time_manage_id, t.shift_time_name, t.check_sign_in, t.check_sign_off, t.sign_in_time, t.sign_off_time, t.late_minutes, t.leave_early_time, t.overtime_start_time, dep.department_type FROM employees AS e LEFT JOIN employee_shift_manages AS s ON e.employee_id = s.employee_id AND s.record_date BETWEEN :start_date AND :end_date LEFT JOIN holiday_manages AS h ON s.record_date = h.record_date LEFT JOIN ( SELECT employee_id, check_date, MIN(case when check_time > date(to_char(check_date,'YYYY-MM-DD'))+time '06:00' THEN check_time end) AS checkin_time, MAX(case when check_time > date(to_char(check_date,'YYYY-MM-DD'))+time '06:00' THEN check_time end) AS checkout_time FROM employee_checkinout_details WHERE check_date BETWEEN :start_date AND :end_date GROUP BY employee_id, check_date ) AS c ON e.employee_id = c.employee_id AND s.record_date = c.check_date LEFT JOIN time_of_shift_manages AS sl ON s.shift_manage_id = sl.shift_manage_id LEFT JOIN shift_time_manages AS t ON sl.shift_time_manage_id = t.shift_time_manage_id LEFT JOIN employee_month_checks AS m ON e.employee_id = m.employee_id AND m.year = :year AND m.month = :month LEFT JOIN departments AS dep ON e.department_id = dep.department_id WHERE ( e.employee_id > 0 AND e.status = 0 AND e.is_check = TRUE OR (EXTRACT( YEAR FROM resignation_date ) = :year AND EXTRACT( MONTH FROM resignation_date ) = :month) OR (e.is_check = FALSE AND (EXTRACT( YEAR FROM onboard_date ) = :year AND EXTRACT( MONTH FROM onboard_date ) = :month))) AND e.employee_id = :employee_id AND e.company_id = :company_id AND ( M.is_locked = FALSE OR M.is_locked IS NULL ) ORDER BY e.employee_id, s.record_date";
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,department_id,status,resignation_date,onboard_date,is_check,gender,record_date,holiday_manage_id,name,start_time,end_time,is_work_day,checkin_time,checkout_time,shift_manage_id,shift_time_manage_id,shift_time_name,check_sign_in,check_sign_off,sign_in_time,sign_off_time,late_minutes,leave_early_time,overtime_start_time,department_type";
	private final static String[] fieldNames = { "start_date", "end_date", "start_date", "end_date", "year", "month", "year", "month", "year", "month", "employee_id", "company_id"};
}
