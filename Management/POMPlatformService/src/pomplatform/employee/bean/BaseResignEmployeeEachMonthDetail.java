package pomplatform.employee.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseResignEmployeeEachMonthDetail extends GenericBase implements BaseFactory<BaseResignEmployeeEachMonthDetail>, Comparable<BaseResignEmployeeEachMonthDetail> 
{


	public static BaseResignEmployeeEachMonthDetail newInstance(){
		return new BaseResignEmployeeEachMonthDetail();
	}

	@Override
	public BaseResignEmployeeEachMonthDetail make(){
		BaseResignEmployeeEachMonthDetail b = new BaseResignEmployeeEachMonthDetail();
		return b;
	}

	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_RESIGN_DATE = "resign_date" ;
	public final static java.lang.String CS_REASON = "reason" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DUTY_ID = "duty_id" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,归属部门,离职员工,岗位,离职日期,离职原因";

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.util.Date getResignDate() {
		return this.__resign_date;
	}

	public void setResignDate( java.util.Date value ) {
		this.__resign_date = value;
	}

	public java.lang.String getReason() {
		return this.__reason;
	}

	public void setReason( java.lang.String value ) {
		this.__reason = value;
	}

	public java.lang.Integer getProcessId() {
		return this.__process_id;
	}

	public void setProcessId( java.lang.Integer value ) {
		this.__process_id = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.Integer getPlateId() {
		return __plate_id;
	}

	public void setPlateId(java.lang.Integer value) {
		this.__plate_id = value;
	}

	public java.lang.Integer getDutyId() {
		return __duty_id;
	}

	public void setDutyId(java.lang.Integer value) {
		this.__duty_id = value;
	}

	public void cloneCopy(BaseResignEmployeeEachMonthDetail __bean){
		__bean.setDepartmentId(getDepartmentId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setResignDate(getResignDate());
		__bean.setReason(getReason());
		__bean.setProcessId(getProcessId());
		__bean.setBusinessId(getBusinessId());
		__bean.setProcessType(getProcessType());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setPlateId(getPlateId());
		__bean.setDutyId(getDutyId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("plate_records", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("all_departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		String strDutyId = delicacy.system.executor.SelectValueCache.getSelectValue("duties", String.valueOf(getDutyId()));
		sb.append(strDutyId == null ? "" : strDutyId);
		sb.append(",");
		sb.append(getResignDate() == null ? "" : sdf.format(getResignDate()));
		sb.append(",");
		sb.append(getReason() == null ? "" : getReason());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseResignEmployeeEachMonthDetail o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__resign_date);
		hash = 97 * hash + Objects.hashCode(this.__reason);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__duty_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseResignEmployeeEachMonthDetail o = (BaseResignEmployeeEachMonthDetail)obj;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__resign_date, o.getResignDate())) return false;
		if(!Objects.equals(this.__reason, o.getReason())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__duty_id, o.getDutyId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getResignDate() != null) sb.append(__wrapDate(count++, "resignDate", getResignDate()));
		if(getReason() != null) sb.append(__wrapString(count++, "reason", getReason()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getDutyId() != null) sb.append(__wrapNumber(count++, "dutyId", getDutyId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("resignDate")) != null) setResignDate(__getDate(val)); 
		if((val = values.get("reason")) != null) setReason(__getString(val));
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("dutyId")) != null) setDutyId(__getInt(val)); 
	}

	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __resign_date ;
	protected java.lang.String  __reason ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __duty_id ;
}
