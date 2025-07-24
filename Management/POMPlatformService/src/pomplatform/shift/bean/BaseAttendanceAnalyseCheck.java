package pomplatform.shift.bean;

import java.util.*;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseAttendanceAnalyseCheck extends GenericBase implements BaseFactory<BaseAttendanceAnalyseCheck>, Comparable<BaseAttendanceAnalyseCheck> 
{


	public static BaseAttendanceAnalyseCheck newInstance(){
		return new BaseAttendanceAnalyseCheck();
	}

	@Override
	public BaseAttendanceAnalyseCheck make(){
		BaseAttendanceAnalyseCheck b = new BaseAttendanceAnalyseCheck();
		return b;
	}

	public final static String CS_EMPLOYEE_ID = "employee_id" ;
	public final static String CS_EMPLOYEE_NO = "employee_no" ;
	public final static String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static String CS_DEPARTMENT_ID = "department_id" ;
	public final static String CS_STATUS = "status" ;
	public final static String CS_RESIGNATION_DATE = "resignation_date" ;
	public final static String CS_ONBOARD_DATE = "onboard_date" ;
	public final static String CS_IS_CHECK = "is_check" ;
	public final static String CS_GENDER = "gender" ;
	public final static String CS_RECORD_DATE = "record_date" ;
	public final static String CS_HOLIDAY_MANAGE_ID = "holiday_manage_id" ;
	public final static String CS_NAME = "name" ;
	public final static String CS_START_TIME = "start_time" ;
	public final static String CS_END_TIME = "end_time" ;
	public final static String CS_IS_WORK_DAY = "is_work_day" ;
	public final static String CS_CHECKIN_TIME = "checkin_time" ;
	public final static String CS_CHECKOUT_TIME = "checkout_time" ;
	public final static String CS_SHIFT_MANAGE_ID = "shift_manage_id" ;
	public final static String CS_SHIFT_TIME_MANAGE_ID = "shift_time_manage_id" ;
	public final static String CS_SHIFT_TIME_NAME = "shift_time_name" ;
	public final static String CS_CHECK_SIGN_IN = "check_sign_in" ;
	public final static String CS_CHECK_SIGN_OFF = "check_sign_off" ;
	public final static String CS_SIGN_IN_TIME = "sign_in_time" ;
	public final static String CS_SIGN_OFF_TIME = "sign_off_time" ;
	public final static String CS_LATE_MINUTES = "late_minutes" ;
	public final static String CS_LEAVE_EARLY_TIME = "leave_early_time" ;
	public final static String CS_OVERTIME_START_TIME = "overtime_start_time" ;
	public final static String CS_DEPARTMENT_TYPE = "department_type" ;

	public final static String NAME_EMPLOYEE_ID = "employeeId" ;
	public final static String NAME_EMPLOYEE_NO = "employeeNo" ;
	public final static String NAME_EMPLOYEE_NAME = "employeeName" ;
	public final static String NAME_DEPARTMENT_ID = "departmentId" ;
	public final static String NAME_STATUS = "status" ;
	public final static String NAME_RESIGNATION_DATE = "resignationDate" ;
	public final static String NAME_ONBOARD_DATE = "onboardDate" ;
	public final static String NAME_IS_CHECK = "isCheck" ;
	public final static String NAME_GENDER = "gender" ;
	public final static String NAME_RECORD_DATE = "recordDate" ;
	public final static String NAME_HOLIDAY_MANAGE_ID = "holidayManageId" ;
	public final static String NAME_NAME = "name" ;
	public final static String NAME_START_TIME = "startTime" ;
	public final static String NAME_END_TIME = "endTime" ;
	public final static String NAME_IS_WORK_DAY = "isWorkDay" ;
	public final static String NAME_CHECKIN_TIME = "checkinTime" ;
	public final static String NAME_CHECKOUT_TIME = "checkoutTime" ;
	public final static String NAME_SHIFT_MANAGE_ID = "shiftManageId" ;
	public final static String NAME_SHIFT_TIME_MANAGE_ID = "shiftTimeManageId" ;
	public final static String NAME_SHIFT_TIME_NAME = "shiftTimeName" ;
	public final static String NAME_CHECK_SIGN_IN = "checkSignIn" ;
	public final static String NAME_CHECK_SIGN_OFF = "checkSignOff" ;
	public final static String NAME_SIGN_IN_TIME = "signInTime" ;
	public final static String NAME_SIGN_OFF_TIME = "signOffTime" ;
	public final static String NAME_LATE_MINUTES = "lateMinutes" ;
	public final static String NAME_LEAVE_EARLY_TIME = "leaveEarlyTime" ;
	public final static String NAME_OVERTIME_START_TIME = "overtimeStartTime" ;
	public final static String NAME_DEPARTMENT_TYPE = "departmentType" ;

	public final static java.lang.String ALL_CAPTIONS = "申请人,员工编号,员工姓名,部门,4删除),离职日期,入职日期,参与考勤,性别,记录日期,主键编码,节日名称,开始时间,结束时间,是否计工作日,,,班次编码,时段id,时段名称,是否需要签到,是否需要签退,上班时间（格式如0900）,下班时间（格式如0900）,计迟到时间（分钟）,计早退时间（分钟）,开始算加班时间（格式如2200）, 2业务部门";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.util.Date getResignationDate() {
		return this.__resignation_date;
	}

	public void setResignationDate( java.util.Date value ) {
		this.__resignation_date = value;
	}

	public java.util.Date getOnboardDate() {
		return this.__onboard_date;
	}

	public void setOnboardDate( java.util.Date value ) {
		this.__onboard_date = value;
	}

	public java.lang.Boolean getIsCheck() {
		return this.__is_check;
	}

	public void setIsCheck( java.lang.Boolean value ) {
		this.__is_check = value;
	}

	public java.lang.Integer getGender() {
		return this.__gender;
	}

	public void setGender( java.lang.Integer value ) {
		this.__gender = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.lang.Integer getHolidayManageId() {
		return this.__holiday_manage_id;
	}

	public void setHolidayManageId( java.lang.Integer value ) {
		this.__holiday_manage_id = value;
	}

	public java.lang.String getName() {
		return this.__name;
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.util.Date getStartTime() {
		return this.__start_time;
	}

	public void setStartTime( java.util.Date value ) {
		this.__start_time = value;
	}

	public java.util.Date getEndTime() {
		return this.__end_time;
	}

	public void setEndTime( java.util.Date value ) {
		this.__end_time = value;
	}

	public java.lang.Boolean getIsWorkDay() {
		return this.__is_work_day;
	}

	public void setIsWorkDay( java.lang.Boolean value ) {
		this.__is_work_day = value;
	}

	public java.util.Date getCheckinTime() {
		return this.__checkin_time;
	}

	public void setCheckinTime( java.util.Date value ) {
		this.__checkin_time = value;
	}

	public java.util.Date getCheckoutTime() {
		return this.__checkout_time;
	}

	public void setCheckoutTime( java.util.Date value ) {
		this.__checkout_time = value;
	}

	public java.lang.Integer getShiftManageId() {
		return this.__shift_manage_id;
	}

	public void setShiftManageId( java.lang.Integer value ) {
		this.__shift_manage_id = value;
	}

	public java.lang.Integer getShiftTimeManageId() {
		return this.__shift_time_manage_id;
	}

	public void setShiftTimeManageId( java.lang.Integer value ) {
		this.__shift_time_manage_id = value;
	}

	public java.lang.String getShiftTimeName() {
		return this.__shift_time_name;
	}

	public void setShiftTimeName( java.lang.String value ) {
		this.__shift_time_name = value;
	}

	public java.lang.Boolean getCheckSignIn() {
		return this.__check_sign_in;
	}

	public void setCheckSignIn( java.lang.Boolean value ) {
		this.__check_sign_in = value;
	}

	public java.lang.Boolean getCheckSignOff() {
		return this.__check_sign_off;
	}

	public void setCheckSignOff( java.lang.Boolean value ) {
		this.__check_sign_off = value;
	}

	public java.lang.String getSignInTime() {
		return this.__sign_in_time;
	}

	public void setSignInTime( java.lang.String value ) {
		this.__sign_in_time = value;
	}

	public java.lang.String getSignOffTime() {
		return this.__sign_off_time;
	}

	public void setSignOffTime( java.lang.String value ) {
		this.__sign_off_time = value;
	}

	public java.lang.Integer getLateMinutes() {
		return this.__late_minutes;
	}

	public void setLateMinutes( java.lang.Integer value ) {
		this.__late_minutes = value;
	}

	public java.lang.Integer getLeaveEarlyTime() {
		return this.__leave_early_time;
	}

	public void setLeaveEarlyTime( java.lang.Integer value ) {
		this.__leave_early_time = value;
	}

	public java.lang.String getOvertimeStartTime() {
		return this.__overtime_start_time;
	}

	public void setOvertimeStartTime( java.lang.String value ) {
		this.__overtime_start_time = value;
	}

	public java.lang.Integer getDepartmentType() {
		return this.__department_type;
	}

	public void setDepartmentType( java.lang.Integer value ) {
		this.__department_type = value;
	}

	public static String getKeyColumnName() {
		String name ="";
		name = CS_HOLIDAY_MANAGE_ID;
		return name;
	}

	public void cloneCopy(BaseAttendanceAnalyseCheck __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setStatus(getStatus());
		__bean.setResignationDate(getResignationDate());
		__bean.setOnboardDate(getOnboardDate());
		__bean.setIsCheck(getIsCheck());
		__bean.setGender(getGender());
		__bean.setRecordDate(getRecordDate());
		__bean.setHolidayManageId(getHolidayManageId());
		__bean.setName(getName());
		__bean.setStartTime(getStartTime());
		__bean.setEndTime(getEndTime());
		__bean.setIsWorkDay(getIsWorkDay());
		__bean.setCheckinTime(getCheckinTime());
		__bean.setCheckoutTime(getCheckoutTime());
		__bean.setShiftManageId(getShiftManageId());
		__bean.setShiftTimeManageId(getShiftTimeManageId());
		__bean.setShiftTimeName(getShiftTimeName());
		__bean.setCheckSignIn(getCheckSignIn());
		__bean.setCheckSignOff(getCheckSignOff());
		__bean.setSignInTime(getSignInTime());
		__bean.setSignOffTime(getSignOffTime());
		__bean.setLateMinutes(getLateMinutes());
		__bean.setLeaveEarlyTime(getLeaveEarlyTime());
		__bean.setOvertimeStartTime(getOvertimeStartTime());
		__bean.setDepartmentType(getDepartmentType());
		__bean.setPageLines(getPageLines());
		__bean.setCurrentPage(getCurrentPage());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		String strEmployeeName = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getEmployeeName()));
		sb.append(strEmployeeName == null ? "" : strEmployeeName);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_11", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		sb.append(getResignationDate() == null ? "" : sdf.format(getResignationDate()));
		sb.append(",");
		sb.append(getOnboardDate() == null ? "" : sdf.format(getOnboardDate()));
		sb.append(",");
		sb.append(getIsCheck() == null ? "" : getIsCheck());
		sb.append(",");
		sb.append(getGender() == null ? "" : getGender());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getHolidayManageId() == null ? "" : getHolidayManageId());
		sb.append(",");
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		sb.append(getStartTime() == null ? "" : sdf.format(getStartTime()));
		sb.append(",");
		sb.append(getEndTime() == null ? "" : sdf.format(getEndTime()));
		sb.append(",");
		sb.append(getIsWorkDay() == null ? "" : getIsWorkDay());
		sb.append(",");
		sb.append(getCheckinTime() == null ? "" : sdf.format(getCheckinTime()));
		sb.append(",");
		sb.append(getCheckoutTime() == null ? "" : sdf.format(getCheckoutTime()));
		sb.append(",");
		sb.append(getShiftManageId() == null ? "" : getShiftManageId());
		sb.append(",");
		String strShiftTimeManageId = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getShiftTimeManageId()));
		sb.append(strShiftTimeManageId == null ? "" : strShiftTimeManageId);
		sb.append(",");
		sb.append(getShiftTimeName() == null ? "" : getShiftTimeName());
		sb.append(",");
		sb.append(getCheckSignIn() == null ? "" : getCheckSignIn());
		sb.append(",");
		sb.append(getCheckSignOff() == null ? "" : getCheckSignOff());
		sb.append(",");
		String strSignInTime = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getSignInTime()));
		sb.append(strSignInTime == null ? "" : strSignInTime);
		sb.append(",");
		sb.append(getSignOffTime() == null ? "" : getSignOffTime());
		sb.append(",");
		sb.append(getLateMinutes() == null ? "" : getLateMinutes());
		sb.append(",");
		sb.append(getLeaveEarlyTime() == null ? "" : getLeaveEarlyTime());
		sb.append(",");
		sb.append(getOvertimeStartTime() == null ? "" : getOvertimeStartTime());
		sb.append(",");
		String strDepartmentType = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentType()));
		sb.append(strDepartmentType == null ? "" : strDepartmentType);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAttendanceAnalyseCheck o) {
		return __holiday_manage_id == null || o.getHolidayManageId() == null ? -1 : __holiday_manage_id.compareTo(o.getHolidayManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__resignation_date);
		hash = 97 * hash + Objects.hashCode(this.__onboard_date);
		hash = 97 * hash + Objects.hashCode(this.__is_check);
		hash = 97 * hash + Objects.hashCode(this.__gender);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__holiday_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__start_time);
		hash = 97 * hash + Objects.hashCode(this.__end_time);
		hash = 97 * hash + Objects.hashCode(this.__is_work_day);
		hash = 97 * hash + Objects.hashCode(this.__checkin_time);
		hash = 97 * hash + Objects.hashCode(this.__checkout_time);
		hash = 97 * hash + Objects.hashCode(this.__shift_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__shift_time_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__shift_time_name);
		hash = 97 * hash + Objects.hashCode(this.__check_sign_in);
		hash = 97 * hash + Objects.hashCode(this.__check_sign_off);
		hash = 97 * hash + Objects.hashCode(this.__sign_in_time);
		hash = 97 * hash + Objects.hashCode(this.__sign_off_time);
		hash = 97 * hash + Objects.hashCode(this.__late_minutes);
		hash = 97 * hash + Objects.hashCode(this.__leave_early_time);
		hash = 97 * hash + Objects.hashCode(this.__overtime_start_time);
		hash = 97 * hash + Objects.hashCode(this.__department_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAttendanceAnalyseCheck o = (BaseAttendanceAnalyseCheck)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__resignation_date, o.getResignationDate())) return false;
		if(!Objects.equals(this.__onboard_date, o.getOnboardDate())) return false;
		if(!Objects.equals(this.__is_check, o.getIsCheck())) return false;
		if(!Objects.equals(this.__gender, o.getGender())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__holiday_manage_id, o.getHolidayManageId())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__start_time, o.getStartTime())) return false;
		if(!Objects.equals(this.__end_time, o.getEndTime())) return false;
		if(!Objects.equals(this.__is_work_day, o.getIsWorkDay())) return false;
		if(!Objects.equals(this.__checkin_time, o.getCheckinTime())) return false;
		if(!Objects.equals(this.__checkout_time, o.getCheckoutTime())) return false;
		if(!Objects.equals(this.__shift_manage_id, o.getShiftManageId())) return false;
		if(!Objects.equals(this.__shift_time_manage_id, o.getShiftTimeManageId())) return false;
		if(!Objects.equals(this.__shift_time_name, o.getShiftTimeName())) return false;
		if(!Objects.equals(this.__check_sign_in, o.getCheckSignIn())) return false;
		if(!Objects.equals(this.__check_sign_off, o.getCheckSignOff())) return false;
		if(!Objects.equals(this.__sign_in_time, o.getSignInTime())) return false;
		if(!Objects.equals(this.__sign_off_time, o.getSignOffTime())) return false;
		if(!Objects.equals(this.__late_minutes, o.getLateMinutes())) return false;
		if(!Objects.equals(this.__leave_early_time, o.getLeaveEarlyTime())) return false;
		if(!Objects.equals(this.__overtime_start_time, o.getOvertimeStartTime())) return false;
		if(!Objects.equals(this.__department_type, o.getDepartmentType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		return toJSONString(false);
	}

	@Override
	public java.lang.String toJSONString(boolean outDefault) {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_EMPLOYEE_ID, getEmployeeId()));
		if(getEmployeeNo() != null || outDefault) sb.append(__wrapString(count++, NAME_EMPLOYEE_NO, getEmployeeNo()));
		if(getEmployeeName() != null || outDefault) sb.append(__wrapString(count++, NAME_EMPLOYEE_NAME, getEmployeeName()));
		if(getDepartmentId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_DEPARTMENT_ID, getDepartmentId()));
		if(getStatus() != null || outDefault) sb.append(__wrapNumber(count++, NAME_STATUS, getStatus()));
		if(getResignationDate() != null || outDefault) sb.append(__wrapDate(count++, NAME_RESIGNATION_DATE, getResignationDate()));
		if(getOnboardDate() != null || outDefault) sb.append(__wrapDate(count++, NAME_ONBOARD_DATE, getOnboardDate()));
		if(getIsCheck() != null || outDefault) sb.append(__wrapBoolean(count++, NAME_IS_CHECK, getIsCheck()));
		if(getGender() != null || outDefault) sb.append(__wrapNumber(count++, NAME_GENDER, getGender()));
		if(getRecordDate() != null || outDefault) sb.append(__wrapDate(count++, NAME_RECORD_DATE, getRecordDate()));
		if(getHolidayManageId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_HOLIDAY_MANAGE_ID, getHolidayManageId()));
		if(getName() != null || outDefault) sb.append(__wrapString(count++, NAME_NAME, getName()));
		if(getStartTime() != null || outDefault) sb.append(__wrapDate(count++, NAME_START_TIME, getStartTime()));
		if(getEndTime() != null || outDefault) sb.append(__wrapDate(count++, NAME_END_TIME, getEndTime()));
		if(getIsWorkDay() != null || outDefault) sb.append(__wrapBoolean(count++, NAME_IS_WORK_DAY, getIsWorkDay()));
		if(getCheckinTime() != null || outDefault) sb.append(__wrapDate(count++, NAME_CHECKIN_TIME, getCheckinTime()));
		if(getCheckoutTime() != null || outDefault) sb.append(__wrapDate(count++, NAME_CHECKOUT_TIME, getCheckoutTime()));
		if(getShiftManageId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_SHIFT_MANAGE_ID, getShiftManageId()));
		if(getShiftTimeManageId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_SHIFT_TIME_MANAGE_ID, getShiftTimeManageId()));
		if(getShiftTimeName() != null || outDefault) sb.append(__wrapString(count++, NAME_SHIFT_TIME_NAME, getShiftTimeName()));
		if(getCheckSignIn() != null || outDefault) sb.append(__wrapBoolean(count++, NAME_CHECK_SIGN_IN, getCheckSignIn()));
		if(getCheckSignOff() != null || outDefault) sb.append(__wrapBoolean(count++, NAME_CHECK_SIGN_OFF, getCheckSignOff()));
		if(getSignInTime() != null || outDefault) sb.append(__wrapString(count++, NAME_SIGN_IN_TIME, getSignInTime()));
		if(getSignOffTime() != null || outDefault) sb.append(__wrapString(count++, NAME_SIGN_OFF_TIME, getSignOffTime()));
		if(getLateMinutes() != null || outDefault) sb.append(__wrapNumber(count++, NAME_LATE_MINUTES, getLateMinutes()));
		if(getLeaveEarlyTime() != null || outDefault) sb.append(__wrapNumber(count++, NAME_LEAVE_EARLY_TIME, getLeaveEarlyTime()));
		if(getOvertimeStartTime() != null || outDefault) sb.append(__wrapString(count++, NAME_OVERTIME_START_TIME, getOvertimeStartTime()));
		if(getDepartmentType() != null || outDefault) sb.append(__wrapNumber(count++, NAME_DEPARTMENT_TYPE, getDepartmentType()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeId() != null) res.put(NAME_EMPLOYEE_ID, getEmployeeId());
		if(getEmployeeNo() != null) res.put(NAME_EMPLOYEE_NO, getEmployeeNo());
		if(getEmployeeName() != null) res.put(NAME_EMPLOYEE_NAME, getEmployeeName());
		if(getDepartmentId() != null) res.put(NAME_DEPARTMENT_ID, getDepartmentId());
		if(getStatus() != null) res.put(NAME_STATUS, getStatus());
		if(getResignationDate() != null) res.put(NAME_RESIGNATION_DATE, getResignationDate());
		if(getOnboardDate() != null) res.put(NAME_ONBOARD_DATE, getOnboardDate());
		if(getIsCheck() != null) res.put(NAME_IS_CHECK, getIsCheck());
		if(getGender() != null) res.put(NAME_GENDER, getGender());
		if(getRecordDate() != null) res.put(NAME_RECORD_DATE, getRecordDate());
		if(getHolidayManageId() != null) res.put(NAME_HOLIDAY_MANAGE_ID, getHolidayManageId());
		if(getName() != null) res.put(NAME_NAME, getName());
		if(getStartTime() != null) res.put(NAME_START_TIME, getStartTime());
		if(getEndTime() != null) res.put(NAME_END_TIME, getEndTime());
		if(getIsWorkDay() != null) res.put(NAME_IS_WORK_DAY, getIsWorkDay());
		if(getCheckinTime() != null) res.put(NAME_CHECKIN_TIME, getCheckinTime());
		if(getCheckoutTime() != null) res.put(NAME_CHECKOUT_TIME, getCheckoutTime());
		if(getShiftManageId() != null) res.put(NAME_SHIFT_MANAGE_ID, getShiftManageId());
		if(getShiftTimeManageId() != null) res.put(NAME_SHIFT_TIME_MANAGE_ID, getShiftTimeManageId());
		if(getShiftTimeName() != null) res.put(NAME_SHIFT_TIME_NAME, getShiftTimeName());
		if(getCheckSignIn() != null) res.put(NAME_CHECK_SIGN_IN, getCheckSignIn());
		if(getCheckSignOff() != null) res.put(NAME_CHECK_SIGN_OFF, getCheckSignOff());
		if(getSignInTime() != null) res.put(NAME_SIGN_IN_TIME, getSignInTime());
		if(getSignOffTime() != null) res.put(NAME_SIGN_OFF_TIME, getSignOffTime());
		if(getLateMinutes() != null) res.put(NAME_LATE_MINUTES, getLateMinutes());
		if(getLeaveEarlyTime() != null) res.put(NAME_LEAVE_EARLY_TIME, getLeaveEarlyTime());
		if(getOvertimeStartTime() != null) res.put(NAME_OVERTIME_START_TIME, getOvertimeStartTime());
		if(getDepartmentType() != null) res.put(NAME_DEPARTMENT_TYPE, getDepartmentType());
		if(getCurrentPage() > 0) {
			res.put(NAME_CURRENT_PAGE, getCurrentPage());
			res.put(NAME_PAGE_LINES, getPageLines());
		}
		return res;
	}

	public static List<Map<String, Object>> GenerateMapList(List<BaseAttendanceAnalyseCheck> ol) {
		List<Map<String, Object>> res = new ArrayList<>();
		for(BaseAttendanceAnalyseCheck b : ol) res.add(b.toMap());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if(values.containsKey(NAME_CURRENT_PAGE) && (val = values.get(NAME_CURRENT_PAGE)) != null) setCurrentPage(__getInt(val));
		if(values.containsKey(NAME_PAGE_LINES) && (val = values.get(NAME_PAGE_LINES)) != null) setPageLines(__getInt(val));
		if(values.containsKey(NAME_EMPLOYEE_ID) && (val = values.get(NAME_EMPLOYEE_ID)) != null) setEmployeeId(__getInt(val)); 
		if(values.containsKey(NAME_EMPLOYEE_NO) && (val = values.get(NAME_EMPLOYEE_NO)) != null) setEmployeeNo(__getString(val));
		if(values.containsKey(NAME_EMPLOYEE_NAME) && (val = values.get(NAME_EMPLOYEE_NAME)) != null) setEmployeeName(__getString(val));
		if(values.containsKey(NAME_DEPARTMENT_ID) && (val = values.get(NAME_DEPARTMENT_ID)) != null) setDepartmentId(__getInt(val)); 
		if(values.containsKey(NAME_STATUS) && (val = values.get(NAME_STATUS)) != null) setStatus(__getInt(val)); 
		if(values.containsKey(NAME_RESIGNATION_DATE) && (val = values.get(NAME_RESIGNATION_DATE)) != null) setResignationDate(__getDate(val)); 
		if(values.containsKey(NAME_ONBOARD_DATE) && (val = values.get(NAME_ONBOARD_DATE)) != null) setOnboardDate(__getDate(val)); 
		if(values.containsKey(NAME_IS_CHECK) && (val = values.get(NAME_IS_CHECK)) != null) setIsCheck(__getBoolean(val));
		if(values.containsKey(NAME_GENDER) && (val = values.get(NAME_GENDER)) != null) setGender(__getInt(val)); 
		if(values.containsKey(NAME_RECORD_DATE) && (val = values.get(NAME_RECORD_DATE)) != null) setRecordDate(__getDate(val)); 
		if(values.containsKey(NAME_HOLIDAY_MANAGE_ID) && (val = values.get(NAME_HOLIDAY_MANAGE_ID)) != null) setHolidayManageId(__getInt(val)); 
		if(values.containsKey(NAME_NAME) && (val = values.get(NAME_NAME)) != null) setName(__getString(val));
		if(values.containsKey(NAME_START_TIME) && (val = values.get(NAME_START_TIME)) != null) setStartTime(__getDate(val)); 
		if(values.containsKey(NAME_END_TIME) && (val = values.get(NAME_END_TIME)) != null) setEndTime(__getDate(val)); 
		if(values.containsKey(NAME_IS_WORK_DAY) && (val = values.get(NAME_IS_WORK_DAY)) != null) setIsWorkDay(__getBoolean(val));
		if(values.containsKey(NAME_CHECKIN_TIME) && (val = values.get(NAME_CHECKIN_TIME)) != null) setCheckinTime(__getDate(val)); 
		if(values.containsKey(NAME_CHECKOUT_TIME) && (val = values.get(NAME_CHECKOUT_TIME)) != null) setCheckoutTime(__getDate(val)); 
		if(values.containsKey(NAME_SHIFT_MANAGE_ID) && (val = values.get(NAME_SHIFT_MANAGE_ID)) != null) setShiftManageId(__getInt(val)); 
		if(values.containsKey(NAME_SHIFT_TIME_MANAGE_ID) && (val = values.get(NAME_SHIFT_TIME_MANAGE_ID)) != null) setShiftTimeManageId(__getInt(val)); 
		if(values.containsKey(NAME_SHIFT_TIME_NAME) && (val = values.get(NAME_SHIFT_TIME_NAME)) != null) setShiftTimeName(__getString(val));
		if(values.containsKey(NAME_CHECK_SIGN_IN) && (val = values.get(NAME_CHECK_SIGN_IN)) != null) setCheckSignIn(__getBoolean(val));
		if(values.containsKey(NAME_CHECK_SIGN_OFF) && (val = values.get(NAME_CHECK_SIGN_OFF)) != null) setCheckSignOff(__getBoolean(val));
		if(values.containsKey(NAME_SIGN_IN_TIME) && (val = values.get(NAME_SIGN_IN_TIME)) != null) setSignInTime(__getString(val));
		if(values.containsKey(NAME_SIGN_OFF_TIME) && (val = values.get(NAME_SIGN_OFF_TIME)) != null) setSignOffTime(__getString(val));
		if(values.containsKey(NAME_LATE_MINUTES) && (val = values.get(NAME_LATE_MINUTES)) != null) setLateMinutes(__getInt(val)); 
		if(values.containsKey(NAME_LEAVE_EARLY_TIME) && (val = values.get(NAME_LEAVE_EARLY_TIME)) != null) setLeaveEarlyTime(__getInt(val)); 
		if(values.containsKey(NAME_OVERTIME_START_TIME) && (val = values.get(NAME_OVERTIME_START_TIME)) != null) setOvertimeStartTime(__getString(val));
		if(values.containsKey(NAME_DEPARTMENT_TYPE) && (val = values.get(NAME_DEPARTMENT_TYPE)) != null) setDepartmentType(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __status ;
	protected java.util.Date  __resignation_date ;
	protected java.util.Date  __onboard_date ;
	protected java.lang.Boolean  __is_check ;
	protected java.lang.Integer  __gender ;
	protected java.util.Date  __record_date ;
	protected java.lang.Integer  __holiday_manage_id ;
	protected java.lang.String  __name ;
	protected java.util.Date  __start_time ;
	protected java.util.Date  __end_time ;
	protected java.lang.Boolean  __is_work_day ;
	protected java.util.Date  __checkin_time ;
	protected java.util.Date  __checkout_time ;
	protected java.lang.Integer  __shift_manage_id ;
	protected java.lang.Integer  __shift_time_manage_id ;
	protected java.lang.String  __shift_time_name ;
	protected java.lang.Boolean  __check_sign_in ;
	protected java.lang.Boolean  __check_sign_off ;
	protected java.lang.String  __sign_in_time ;
	protected java.lang.String  __sign_off_time ;
	protected java.lang.Integer  __late_minutes ;
	protected java.lang.Integer  __leave_early_time ;
	protected java.lang.String  __overtime_start_time ;
	protected java.lang.Integer  __department_type ;
}
