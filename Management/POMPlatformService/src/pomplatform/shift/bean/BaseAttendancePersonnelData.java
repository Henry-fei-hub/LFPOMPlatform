package pomplatform.shift.bean;

import java.util.*;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseAttendancePersonnelData extends GenericBase implements BaseFactory<BaseAttendancePersonnelData>, Comparable<BaseAttendancePersonnelData> 
{


	public static BaseAttendancePersonnelData newInstance(){
		return new BaseAttendancePersonnelData();
	}

	@Override
	public BaseAttendancePersonnelData make(){
		BaseAttendancePersonnelData b = new BaseAttendancePersonnelData();
		return b;
	}

	public final static String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static String CS_PROCESS_TYPE = "process_type" ;
	public final static String CS_EMPLOYEE_ID = "employee_id" ;
	public final static String CS_DEPARTMENT_ID = "department_id" ;
	public final static String CS_START_DATE = "start_date" ;
	public final static String CS_START_DATE_DETAIL = "start_date_detail" ;
	public final static String CS_END_DATE = "end_date" ;
	public final static String CS_END_DATE_DETAIL = "end_date_detail" ;
	public final static String CS_TYPE = "type" ;
	public final static String CS_PROCESS_TYPE_NAME = "process_type_name" ;
	public final static String CS_DUTY_ID = "duty_id" ;
	public final static String CS_PROCESS_STATUS = "process_status" ;

	public final static String NAME_PERSONNEL_BUSINESS_ID = "personnelBusinessId" ;
	public final static String NAME_PROCESS_TYPE = "processType" ;
	public final static String NAME_EMPLOYEE_ID = "employeeId" ;
	public final static String NAME_DEPARTMENT_ID = "departmentId" ;
	public final static String NAME_START_DATE = "startDate" ;
	public final static String NAME_START_DATE_DETAIL = "startDateDetail" ;
	public final static String NAME_END_DATE = "endDate" ;
	public final static String NAME_END_DATE_DETAIL = "endDateDetail" ;
	public final static String NAME_TYPE = "type" ;
	public final static String NAME_PROCESS_TYPE_NAME = "processTypeName" ;
	public final static String NAME_DUTY_ID = "dutyId" ;
	public final static String NAME_PROCESS_STATUS = "processStatus" ;

	public final static java.lang.String ALL_CAPTIONS = "人事业务编码,类型 13请假  14出差  15打卡  16外出  17加班,申请人,部门,开始日期,0上午   1下午,截止日期,0上午   1下午,假期类型,流程类型名称,职务,流程状态 0 发起中  1";

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.lang.Integer getStartDateDetail() {
		return this.__start_date_detail;
	}

	public void setStartDateDetail( java.lang.Integer value ) {
		this.__start_date_detail = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.lang.Integer getEndDateDetail() {
		return this.__end_date_detail;
	}

	public void setEndDateDetail( java.lang.Integer value ) {
		this.__end_date_detail = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.String getProcessTypeName() {
		return this.__process_type_name;
	}

	public void setProcessTypeName( java.lang.String value ) {
		this.__process_type_name = value;
	}

	public java.lang.Integer getDutyId() {
		return this.__duty_id;
	}

	public void setDutyId( java.lang.Integer value ) {
		this.__duty_id = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public static String getKeyColumnName() {
		String name ="";
		name = CS_PERSONNEL_BUSINESS_ID;
		return name;
	}

	public void cloneCopy(BaseAttendancePersonnelData __bean){
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setProcessType(getProcessType());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setStartDate(getStartDate());
		__bean.setStartDateDetail(getStartDateDetail());
		__bean.setEndDate(getEndDate());
		__bean.setEndDateDetail(getEndDateDetail());
		__bean.setType(getType());
		__bean.setProcessTypeName(getProcessTypeName());
		__bean.setDutyId(getDutyId());
		__bean.setProcessStatus(getProcessStatus());
		__bean.setPageLines(getPageLines());
		__bean.setCurrentPage(getCurrentPage());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		sb.append(",");
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getStartDateDetail() == null ? "" : getStartDateDetail());
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getEndDateDetail() == null ? "" : getEndDateDetail());
		sb.append(",");
		String strType = delicacy.system.executor.SelectValueCache.getSelectValue("areas", String.valueOf(getType()));
		sb.append(strType == null ? "" : strType);
		sb.append(",");
		sb.append(getProcessTypeName() == null ? "" : getProcessTypeName());
		sb.append(",");
		sb.append(getDutyId() == null ? "" : getDutyId());
		sb.append(",");
		sb.append(getProcessStatus() == null ? "" : getProcessStatus());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAttendancePersonnelData o) {
		return __personnel_business_id == null || o.getPersonnelBusinessId() == null ? -1 : __personnel_business_id.compareTo(o.getPersonnelBusinessId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__start_date_detail);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date_detail);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__process_type_name);
		hash = 97 * hash + Objects.hashCode(this.__duty_id);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAttendancePersonnelData o = (BaseAttendancePersonnelData)obj;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__start_date_detail, o.getStartDateDetail())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__end_date_detail, o.getEndDateDetail())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__process_type_name, o.getProcessTypeName())) return false;
		if(!Objects.equals(this.__duty_id, o.getDutyId())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
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
		if(getPersonnelBusinessId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_PERSONNEL_BUSINESS_ID, getPersonnelBusinessId()));
		if(getProcessType() != null || outDefault) sb.append(__wrapNumber(count++, NAME_PROCESS_TYPE, getProcessType()));
		if(getEmployeeId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_EMPLOYEE_ID, getEmployeeId()));
		if(getDepartmentId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_DEPARTMENT_ID, getDepartmentId()));
		if(getStartDate() != null || outDefault) sb.append(__wrapDate(count++, NAME_START_DATE, getStartDate()));
		if(getStartDateDetail() != null || outDefault) sb.append(__wrapNumber(count++, NAME_START_DATE_DETAIL, getStartDateDetail()));
		if(getEndDate() != null || outDefault) sb.append(__wrapDate(count++, NAME_END_DATE, getEndDate()));
		if(getEndDateDetail() != null || outDefault) sb.append(__wrapNumber(count++, NAME_END_DATE_DETAIL, getEndDateDetail()));
		if(getType() != null || outDefault) sb.append(__wrapNumber(count++, NAME_TYPE, getType()));
		if(getProcessTypeName() != null || outDefault) sb.append(__wrapString(count++, NAME_PROCESS_TYPE_NAME, getProcessTypeName()));
		if(getDutyId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_DUTY_ID, getDutyId()));
		if(getProcessStatus() != null || outDefault) sb.append(__wrapNumber(count++, NAME_PROCESS_STATUS, getProcessStatus()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPersonnelBusinessId() != null) res.put(NAME_PERSONNEL_BUSINESS_ID, getPersonnelBusinessId());
		if(getProcessType() != null) res.put(NAME_PROCESS_TYPE, getProcessType());
		if(getEmployeeId() != null) res.put(NAME_EMPLOYEE_ID, getEmployeeId());
		if(getDepartmentId() != null) res.put(NAME_DEPARTMENT_ID, getDepartmentId());
		if(getStartDate() != null) res.put(NAME_START_DATE, getStartDate());
		if(getStartDateDetail() != null) res.put(NAME_START_DATE_DETAIL, getStartDateDetail());
		if(getEndDate() != null) res.put(NAME_END_DATE, getEndDate());
		if(getEndDateDetail() != null) res.put(NAME_END_DATE_DETAIL, getEndDateDetail());
		if(getType() != null) res.put(NAME_TYPE, getType());
		if(getProcessTypeName() != null) res.put(NAME_PROCESS_TYPE_NAME, getProcessTypeName());
		if(getDutyId() != null) res.put(NAME_DUTY_ID, getDutyId());
		if(getProcessStatus() != null) res.put(NAME_PROCESS_STATUS, getProcessStatus());
		if(getCurrentPage() > 0) {
			res.put(NAME_CURRENT_PAGE, getCurrentPage());
			res.put(NAME_PAGE_LINES, getPageLines());
		}
		return res;
	}

	public static List<Map<String, Object>> GenerateMapList(List<BaseAttendancePersonnelData> ol) {
		List<Map<String, Object>> res = new ArrayList<>();
		for(BaseAttendancePersonnelData b : ol) res.add(b.toMap());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if(values.containsKey(NAME_CURRENT_PAGE) && (val = values.get(NAME_CURRENT_PAGE)) != null) setCurrentPage(__getInt(val));
		if(values.containsKey(NAME_PAGE_LINES) && (val = values.get(NAME_PAGE_LINES)) != null) setPageLines(__getInt(val));
		if(values.containsKey(NAME_PERSONNEL_BUSINESS_ID) && (val = values.get(NAME_PERSONNEL_BUSINESS_ID)) != null) setPersonnelBusinessId(__getInt(val)); 
		if(values.containsKey(NAME_PROCESS_TYPE) && (val = values.get(NAME_PROCESS_TYPE)) != null) setProcessType(__getInt(val)); 
		if(values.containsKey(NAME_EMPLOYEE_ID) && (val = values.get(NAME_EMPLOYEE_ID)) != null) setEmployeeId(__getInt(val)); 
		if(values.containsKey(NAME_DEPARTMENT_ID) && (val = values.get(NAME_DEPARTMENT_ID)) != null) setDepartmentId(__getInt(val)); 
		if(values.containsKey(NAME_START_DATE) && (val = values.get(NAME_START_DATE)) != null) setStartDate(__getDate(val)); 
		if(values.containsKey(NAME_START_DATE_DETAIL) && (val = values.get(NAME_START_DATE_DETAIL)) != null) setStartDateDetail(__getInt(val)); 
		if(values.containsKey(NAME_END_DATE) && (val = values.get(NAME_END_DATE)) != null) setEndDate(__getDate(val)); 
		if(values.containsKey(NAME_END_DATE_DETAIL) && (val = values.get(NAME_END_DATE_DETAIL)) != null) setEndDateDetail(__getInt(val)); 
		if(values.containsKey(NAME_TYPE) && (val = values.get(NAME_TYPE)) != null) setType(__getInt(val)); 
		if(values.containsKey(NAME_PROCESS_TYPE_NAME) && (val = values.get(NAME_PROCESS_TYPE_NAME)) != null) setProcessTypeName(__getString(val));
		if(values.containsKey(NAME_DUTY_ID) && (val = values.get(NAME_DUTY_ID)) != null) setDutyId(__getInt(val)); 
		if(values.containsKey(NAME_PROCESS_STATUS) && (val = values.get(NAME_PROCESS_STATUS)) != null) setProcessStatus(__getInt(val)); 
	}

	protected java.lang.Integer  __personnel_business_id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __department_id ;
	protected java.util.Date  __start_date ;
	protected java.lang.Integer  __start_date_detail ;
	protected java.util.Date  __end_date ;
	protected java.lang.Integer  __end_date_detail ;
	protected java.lang.Integer  __type ;
	protected java.lang.String  __process_type_name ;
	protected java.lang.Integer  __duty_id ;
	protected java.lang.Integer  __process_status ;
}
