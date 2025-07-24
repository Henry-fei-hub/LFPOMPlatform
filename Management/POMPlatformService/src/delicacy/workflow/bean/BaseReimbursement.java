package delicacy.workflow.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseReimbursement extends GenericBase implements BaseFactory<BaseReimbursement>, Comparable<BaseReimbursement> 
{


	public static BaseReimbursement newInstance(){
		return new BaseReimbursement();
	}

	@Override
	public BaseReimbursement make(){
		BaseReimbursement b = new BaseReimbursement();
		return b;
	}

	public final static java.lang.String CS_REIMBURSEMENT_ID = "reimbursement_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_APPLICATION_DATE = "application_date" ;
	public final static java.lang.String CS_REIMBURSEMENT_TYPE = "reimbursement_type" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_COMPLETE_DATE = "complete_date" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_SUBJECT = "subject" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码 部门角色代码,部门,申请日期,报销类型,状态,报销总金额,完成日期,流程代码,报销事由,报销详细说明";

	public java.lang.Integer getReimbursementId() {
		return this.__reimbursement_id;
	}

	public void setReimbursementId( java.lang.Integer value ) {
		this.__reimbursement_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.util.Date getApplicationDate() {
		return this.__application_date;
	}

	public void setApplicationDate( java.util.Date value ) {
		this.__application_date = value;
	}

	public java.lang.Integer getReimbursementType() {
		return this.__reimbursement_type;
	}

	public void setReimbursementType( java.lang.Integer value ) {
		this.__reimbursement_type = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.util.Date getCompleteDate() {
		return this.__complete_date;
	}

	public void setCompleteDate( java.util.Date value ) {
		this.__complete_date = value;
	}

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.String getSubject() {
		return this.__subject;
	}

	public void setSubject( java.lang.String value ) {
		this.__subject = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseReimbursement __bean){
		__bean.setReimbursementId(getReimbursementId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setApplicationDate(getApplicationDate());
		__bean.setReimbursementType(getReimbursementType());
		__bean.setStatus(getStatus());
		__bean.setAmount(getAmount());
		__bean.setCompleteDate(getCompleteDate());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setSubject(getSubject());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getReimbursementId() == null ? "" : getReimbursementId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getApplicationDate() == null ? "" : sdf.format(getApplicationDate()));
		sb.append(",");
		sb.append(getReimbursementType() == null ? "" : getReimbursementType());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getCompleteDate() == null ? "" : sdf.format(getCompleteDate()));
		sb.append(",");
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		sb.append(getSubject() == null ? "" : getSubject());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReimbursement o) {
		return __reimbursement_id == null ? -1 : __reimbursement_id.compareTo(o.getReimbursementId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__application_date);
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_type);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__complete_date);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__subject);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReimbursement o = (BaseReimbursement)obj;
		if(!Objects.equals(this.__reimbursement_id, o.getReimbursementId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__application_date, o.getApplicationDate())) return false;
		if(!Objects.equals(this.__reimbursement_type, o.getReimbursementType())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__complete_date, o.getCompleteDate())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__subject, o.getSubject())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getReimbursementId() != null) sb.append(__wrapNumber(count++, "reimbursementId", getReimbursementId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getApplicationDate() != null) sb.append(__wrapDate(count++, "applicationDate", getApplicationDate()));
		if(getReimbursementType() != null) sb.append(__wrapNumber(count++, "reimbursementType", getReimbursementType()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getCompleteDate() != null) sb.append(__wrapDate(count++, "completeDate", getCompleteDate()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getSubject() != null) sb.append(__wrapString(count++, "subject", getSubject()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("reimbursementId")) != null) setReimbursementId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("applicationDate")) != null) setApplicationDate(__getDate(val)); 
		if((val = values.get("reimbursementType")) != null) setReimbursementType(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("completeDate")) != null) setCompleteDate(__getDate(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("subject")) != null) setSubject(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __reimbursement_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __application_date ;
	protected java.lang.Integer  __reimbursement_type ;
	protected java.lang.Integer  __status ;
	protected java.math.BigDecimal  __amount ;
	protected java.util.Date  __complete_date ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.String  __subject ;
	protected java.lang.String  __remark ;
}
