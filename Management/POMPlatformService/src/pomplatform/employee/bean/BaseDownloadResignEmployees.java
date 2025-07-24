package pomplatform.employee.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseDownloadResignEmployees extends GenericBase implements BaseFactory<BaseDownloadResignEmployees>, Comparable<BaseDownloadResignEmployees> 
{


	public static BaseDownloadResignEmployees newInstance(){
		return new BaseDownloadResignEmployees();
	}

	@Override
	public BaseDownloadResignEmployees make(){
		BaseDownloadResignEmployees b = new BaseDownloadResignEmployees();
		return b;
	}

	public final static String CS_PARENT_ID = "parent_id" ;
	public final static String CS_EMPLOYEE_ID = "employee_id" ;
	public final static String CS_RESIGN_DATE = "resign_date" ;
	public final static String CS_REASON = "reason" ;
	public final static String CS_DEPARTMENT_ID = "department_id" ;
	public final static String CS_DUTY_ID = "duty_id" ;

	public final static String ALL_CAPTIONS = "业务部门,员工编码,离职日期,离职缘由,归属部门,职位名称";

	public Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( Integer value ) {
		this.__parent_id = value;
	}

	public Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( Integer value ) {
		this.__employee_id = value;
	}

	public java.util.Date getResignDate() {
		return this.__resign_date;
	}

	public void setResignDate( java.util.Date value ) {
		this.__resign_date = value;
	}

	public String getReason() {
		return this.__reason;
	}

	public void setReason( String value ) {
		this.__reason = value;
	}

	public Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( Integer value ) {
		this.__department_id = value;
	}

	public Integer getDutyId() {
		return this.__duty_id;
	}

	public void setDutyId( Integer value ) {
		this.__duty_id = value;
	}

	public void cloneCopy(BaseDownloadResignEmployees __bean){
		__bean.setParentId(getParentId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setResignDate(getResignDate());
		__bean.setReason(getReason());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setDutyId(getDutyId());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getParentId()));
		sb.append(getParentId() == null ? "" : strPlateId);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(getEmployeeId() == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getResignDate() == null ? "" : sdf.format(getResignDate()));
		sb.append(",");
		sb.append(getReason() == null ? "" : getReason());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("all_departments", String.valueOf(getDepartmentId()));
		sb.append(getDepartmentId() == null ? "" : strDepartmentId);
		sb.append(",");
		String strDutyId = delicacy.system.executor.SelectValueCache.getSelectValue("duties", String.valueOf(getDutyId()));
		sb.append(getDutyId() == null ? "" : strDutyId);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseDownloadResignEmployees o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__resign_date);
		hash = 97 * hash + Objects.hashCode(this.__reason);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__duty_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseDownloadResignEmployees o = (BaseDownloadResignEmployees)obj;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__resign_date, o.getResignDate())) return false;
		if(!Objects.equals(this.__reason, o.getReason())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__duty_id, o.getDutyId())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getResignDate() != null) sb.append(__wrapDate(count++, "resignDate", getResignDate()));
		if(getReason() != null) sb.append(__wrapString(count++, "reason", getReason()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getDutyId() != null) sb.append(__wrapNumber(count++, "dutyId", getDutyId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getParentId() != null) res.put("parentId", getParentId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getResignDate() != null) res.put("resignDate", getResignDate());
		if(getReason() != null) res.put("reason", getReason());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getDutyId() != null) res.put("dutyId", getDutyId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("resignDate")) != null) setResignDate(__getDate(val)); 
		if((val = values.get("reason")) != null) setReason(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("dutyId")) != null) setDutyId(__getInt(val)); 
	}

	protected Integer  __parent_id ;
	protected Integer  __employee_id ;
	protected java.util.Date  __resign_date ;
	protected String  __reason ;
	protected Integer  __department_id ;
	protected Integer  __duty_id ;
}
