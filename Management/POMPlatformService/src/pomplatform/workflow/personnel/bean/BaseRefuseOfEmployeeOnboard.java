package pomplatform.workflow.personnel.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseRefuseOfEmployeeOnboard extends GenericBase implements BaseFactory<BaseRefuseOfEmployeeOnboard>, Comparable<BaseRefuseOfEmployeeOnboard> 
{


	public static BaseRefuseOfEmployeeOnboard newInstance(){
		return new BaseRefuseOfEmployeeOnboard();
	}

	@Override
	public BaseRefuseOfEmployeeOnboard make(){
		BaseRefuseOfEmployeeOnboard b = new BaseRefuseOfEmployeeOnboard();
		return b;
	}

	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_BUSINESS_NAME = "business_name" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ACTIVITY_ID = "process_instance_activity_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;
	public final static java.lang.String CS_COMPLETE_TIME = "complete_time" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_ONBOARD_DATE = "onboard_date" ;
	public final static java.lang.String CS_OWNED_COMPANY = "owned_company" ;
	public final static java.lang.String CS_DUTY_ID = "duty_id" ;
	public final static java.lang.String CS_APPLY_EMPLOYEE_ID = "apply_employee_id" ;
	public final static java.lang.String CS_EMP_STATUS = "emp_status" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务编码,业务名称,流程编码,活动实列编码,创建时间,流程状态,完成时间,部门,员工编号,员工姓名,入职日期,所属公司,职位名称,发起人,在职状态";

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	public java.lang.String getBusinessName() {
		return this.__business_name;
	}

	public void setBusinessName( java.lang.String value ) {
		this.__business_name = value;
	}

	public java.lang.Integer getProcessId() {
		return this.__process_id;
	}

	public void setProcessId( java.lang.Integer value ) {
		this.__process_id = value;
	}

	public java.lang.Integer getProcessInstanceActivityId() {
		return this.__process_instance_activity_id;
	}

	public void setProcessInstanceActivityId( java.lang.Integer value ) {
		this.__process_instance_activity_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.util.Date getCompleteTime() {
		return this.__complete_time;
	}

	public void setCompleteTime( java.util.Date value ) {
		this.__complete_time = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
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

	public java.util.Date getOnboardDate() {
		return this.__onboard_date;
	}

	public void setOnboardDate( java.util.Date value ) {
		this.__onboard_date = value;
	}

	public java.lang.String getOwnedCompany() {
		return this.__owned_company;
	}

	public void setOwnedCompany( java.lang.String value ) {
		this.__owned_company = value;
	}

	public java.lang.Integer getDutyId() {
		return this.__duty_id;
	}

	public void setDutyId( java.lang.Integer value ) {
		this.__duty_id = value;
	}

	public java.lang.Integer getApplyEmployeeId() {
		return this.__apply_employee_id;
	}

	public void setApplyEmployeeId( java.lang.Integer value ) {
		this.__apply_employee_id = value;
	}

	public java.lang.Integer getEmpStatus() {
		return this.__emp_status;
	}

	public void setEmpStatus( java.lang.Integer value ) {
		this.__emp_status = value;
	}

	public void cloneCopy(BaseRefuseOfEmployeeOnboard __bean){
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setBusinessId(getBusinessId());
		__bean.setBusinessName(getBusinessName());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceActivityId(getProcessInstanceActivityId());
		__bean.setCreateTime(getCreateTime());
		__bean.setProcessStatus(getProcessStatus());
		__bean.setCompleteTime(getCompleteTime());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setOnboardDate(getOnboardDate());
		__bean.setOwnedCompany(getOwnedCompany());
		__bean.setDutyId(getDutyId());
		__bean.setApplyEmployeeId(getApplyEmployeeId());
		__bean.setEmpStatus(getEmpStatus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strProcessInstanceId = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getProcessInstanceId()));
		sb.append(strProcessInstanceId == null ? "" : strProcessInstanceId);
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		sb.append(getBusinessName() == null ? "" : getBusinessName());
		sb.append(",");
		sb.append(getProcessId() == null ? "" : getProcessId());
		sb.append(",");
		sb.append(getProcessInstanceActivityId() == null ? "" : getProcessInstanceActivityId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getProcessStatus() == null ? "" : getProcessStatus());
		sb.append(",");
		sb.append(getCompleteTime() == null ? "" : sdf.format(getCompleteTime()));
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getOnboardDate() == null ? "" : sdf.format(getOnboardDate()));
		sb.append(",");
		sb.append(getOwnedCompany() == null ? "" : getOwnedCompany());
		sb.append(",");
		sb.append(getDutyId() == null ? "" : getDutyId());
		sb.append(",");
		sb.append(getApplyEmployeeId() == null ? "" : getApplyEmployeeId());
		sb.append(",");
		sb.append(getEmpStatus() == null ? "" : getEmpStatus());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseRefuseOfEmployeeOnboard o) {
		return __process_instance_id == null ? -1 : __process_instance_id.compareTo(o.getProcessInstanceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__business_name);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		hash = 97 * hash + Objects.hashCode(this.__complete_time);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__onboard_date);
		hash = 97 * hash + Objects.hashCode(this.__owned_company);
		hash = 97 * hash + Objects.hashCode(this.__duty_id);
		hash = 97 * hash + Objects.hashCode(this.__apply_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__emp_status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseRefuseOfEmployeeOnboard o = (BaseRefuseOfEmployeeOnboard)obj;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_activity_id, o.getProcessInstanceActivityId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__onboard_date, o.getOnboardDate())) return false;
		if(!Objects.equals(this.__owned_company, o.getOwnedCompany())) return false;
		if(!Objects.equals(this.__duty_id, o.getDutyId())) return false;
		if(!Objects.equals(this.__apply_employee_id, o.getApplyEmployeeId())) return false;
		if(!Objects.equals(this.__emp_status, o.getEmpStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessInstanceActivityId() != null) sb.append(__wrapNumber(count++, "processInstanceActivityId", getProcessInstanceActivityId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		if(getCompleteTime() != null) sb.append(__wrapDate(count++, "completeTime", getCompleteTime()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getOnboardDate() != null) sb.append(__wrapDate(count++, "onboardDate", getOnboardDate()));
		if(getOwnedCompany() != null) sb.append(__wrapString(count++, "ownedCompany", getOwnedCompany()));
		if(getDutyId() != null) sb.append(__wrapNumber(count++, "dutyId", getDutyId()));
		if(getApplyEmployeeId() != null) sb.append(__wrapNumber(count++, "applyEmployeeId", getApplyEmployeeId()));
		if(getEmpStatus() != null) sb.append(__wrapNumber(count++, "empStatus", getEmpStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val));
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("processInstanceActivityId")) != null) setProcessInstanceActivityId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("completeTime")) != null) setCompleteTime(__getDate(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("onboardDate")) != null) setOnboardDate(__getDate(val)); 
		if((val = values.get("ownedCompany")) != null) setOwnedCompany(__getString(val));
		if((val = values.get("dutyId")) != null) setDutyId(__getInt(val)); 
		if((val = values.get("applyEmployeeId")) != null) setApplyEmployeeId(__getInt(val)); 
		if((val = values.get("empStatus")) != null) setEmpStatus(__getInt(val)); 
	}

	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.String  __business_name ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_instance_activity_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __process_status ;
	protected java.util.Date  __complete_time ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.util.Date  __onboard_date ;
	protected java.lang.String  __owned_company ;
	protected java.lang.Integer  __duty_id ;
	protected java.lang.Integer  __apply_employee_id ;
	protected java.lang.Integer  __emp_status ;
}
