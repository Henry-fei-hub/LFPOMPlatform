package pomplatform.workflow.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;
import com.pomplatform.db.bean.BaseProjectNormalReimbursementDetail;

public class BaseProjectNormalReimbursementOfWorkflow extends GenericBase implements BaseFactory<BaseProjectNormalReimbursementOfWorkflow>, Comparable<BaseProjectNormalReimbursementOfWorkflow> 
{


	public static BaseProjectNormalReimbursementOfWorkflow newInstance(){
		return new BaseProjectNormalReimbursementOfWorkflow();
	}

	@Override
	public BaseProjectNormalReimbursementOfWorkflow make(){
		BaseProjectNormalReimbursementOfWorkflow b = new BaseProjectNormalReimbursementOfWorkflow();
		return b;
	}

	public final static java.lang.String CS_PROJECT_NORMAL_REIMBURSEMENT_ID = "project_normal_reimbursement_id" ;
	public final static java.lang.String CS_PROJECT_NORMAL_REIMBURSEMENT_NO = "project_normal_reimbursement_no" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_APPLY_EMPLOYEE_ID = "apply_employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_REIMBURSEMENT_NAME = "reimbursement_name" ;
	public final static java.lang.String CS_REIMBURSEMENT_TIME = "reimbursement_time" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_APPLY_TIME = "apply_time" ;
	public final static java.lang.String CS_COMPLETE_TIME = "complete_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_STRIKE_A_BALANCE = "strike_a_balance" ;
	public final static java.lang.String CS_ATTACHMENT = "attachment" ;
	public final static java.lang.String CS_ATTACHMENT_NUMBER = "attachment_number" ;

	public final static java.lang.String ALL_CAPTIONS = "项目报销编码,报销编号,流程编码,起草人,报销人,报销部门,所属项目,主题,报销时间,状态,报销金额,申请时间,完成时间,备注,冲账,附件,附件(张)";

	public java.lang.Integer getProjectNormalReimbursementId() {
		return this.__project_normal_reimbursement_id;
	}

	public void setProjectNormalReimbursementId( java.lang.Integer value ) {
		this.__project_normal_reimbursement_id = value;
	}

	public java.lang.String getProjectNormalReimbursementNo() {
		return this.__project_normal_reimbursement_no;
	}

	public void setProjectNormalReimbursementNo( java.lang.String value ) {
		this.__project_normal_reimbursement_no = value;
	}

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.Integer getApplyEmployeeId() {
		return this.__apply_employee_id;
	}

	public void setApplyEmployeeId( java.lang.Integer value ) {
		this.__apply_employee_id = value;
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

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.String getReimbursementName() {
		return this.__reimbursement_name;
	}

	public void setReimbursementName( java.lang.String value ) {
		this.__reimbursement_name = value;
	}

	public java.util.Date getReimbursementTime() {
		return this.__reimbursement_time;
	}

	public void setReimbursementTime( java.util.Date value ) {
		this.__reimbursement_time = value;
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

	public java.util.Date getApplyTime() {
		return this.__apply_time;
	}

	public void setApplyTime( java.util.Date value ) {
		this.__apply_time = value;
	}

	public java.util.Date getCompleteTime() {
		return this.__complete_time;
	}

	public void setCompleteTime( java.util.Date value ) {
		this.__complete_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Boolean getStrikeABalance() {
		return this.__strike_a_balance;
	}

	public void setStrikeABalance( java.lang.Boolean value ) {
		this.__strike_a_balance = value;
	}

	public java.lang.String getAttachment() {
		return this.__attachment;
	}

	public void setAttachment( java.lang.String value ) {
		this.__attachment = value;
	}

	public java.lang.Integer getAttachmentNumber() {
		return this.__attachment_number;
	}

	public void setAttachmentNumber( java.lang.Integer value ) {
		this.__attachment_number = value;
	}

	public java.util.List<BaseProjectNormalReimbursementDetail> getDetailProjectNormalReimbursementDetail() {
		return this.__detailProjectNormalReimbursementDetail;
	}

	public void setDetailProjectNormalReimbursementDetail( java.util.List<BaseProjectNormalReimbursementDetail> value ) {
		this.__detailProjectNormalReimbursementDetail = value;
	}

	public void cloneCopy(BaseProjectNormalReimbursementOfWorkflow __bean){
		__bean.setProjectNormalReimbursementId(getProjectNormalReimbursementId());
		__bean.setProjectNormalReimbursementNo(getProjectNormalReimbursementNo());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setApplyEmployeeId(getApplyEmployeeId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setProjectId(getProjectId());
		__bean.setReimbursementName(getReimbursementName());
		__bean.setReimbursementTime(getReimbursementTime());
		__bean.setStatus(getStatus());
		__bean.setAmount(getAmount());
		__bean.setApplyTime(getApplyTime());
		__bean.setCompleteTime(getCompleteTime());
		__bean.setRemark(getRemark());
		__bean.setStrikeABalance(getStrikeABalance());
		__bean.setAttachment(getAttachment());
		__bean.setAttachmentNumber(getAttachmentNumber());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectNormalReimbursementId() == null ? "" : getProjectNormalReimbursementId());
		sb.append(",");
		sb.append(getProjectNormalReimbursementNo() == null ? "" : getProjectNormalReimbursementNo());
		sb.append(",");
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		sb.append(getApplyEmployeeId() == null ? "" : getApplyEmployeeId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		sb.append(getReimbursementName() == null ? "" : getReimbursementName());
		sb.append(",");
		sb.append(getReimbursementTime() == null ? "" : sdf.format(getReimbursementTime()));
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_16", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getApplyTime() == null ? "" : sdf.format(getApplyTime()));
		sb.append(",");
		sb.append(getCompleteTime() == null ? "" : sdf.format(getCompleteTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getStrikeABalance() == null ? "" : getStrikeABalance());
		sb.append(",");
		sb.append(getAttachment() == null ? "" : getAttachment());
		sb.append(",");
		sb.append(getAttachmentNumber() == null ? "" : getAttachmentNumber());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectNormalReimbursementOfWorkflow o) {
		return __project_normal_reimbursement_id == null ? -1 : __project_normal_reimbursement_id.compareTo(o.getProjectNormalReimbursementId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_normal_reimbursement_id);
		hash = 97 * hash + Objects.hashCode(this.__project_normal_reimbursement_no);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__apply_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_name);
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_time);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__apply_time);
		hash = 97 * hash + Objects.hashCode(this.__complete_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__strike_a_balance);
		hash = 97 * hash + Objects.hashCode(this.__attachment);
		hash = 97 * hash + Objects.hashCode(this.__attachment_number);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectNormalReimbursementOfWorkflow o = (BaseProjectNormalReimbursementOfWorkflow)obj;
		if(!Objects.equals(this.__project_normal_reimbursement_id, o.getProjectNormalReimbursementId())) return false;
		if(!Objects.equals(this.__project_normal_reimbursement_no, o.getProjectNormalReimbursementNo())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__apply_employee_id, o.getApplyEmployeeId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__reimbursement_name, o.getReimbursementName())) return false;
		if(!Objects.equals(this.__reimbursement_time, o.getReimbursementTime())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__apply_time, o.getApplyTime())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__strike_a_balance, o.getStrikeABalance())) return false;
		if(!Objects.equals(this.__attachment, o.getAttachment())) return false;
		if(!Objects.equals(this.__attachment_number, o.getAttachmentNumber())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectNormalReimbursementId() != null) sb.append(__wrapNumber(count++, "projectNormalReimbursementId", getProjectNormalReimbursementId()));
		if(getProjectNormalReimbursementNo() != null) sb.append(__wrapString(count++, "projectNormalReimbursementNo", getProjectNormalReimbursementNo()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getApplyEmployeeId() != null) sb.append(__wrapNumber(count++, "applyEmployeeId", getApplyEmployeeId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getReimbursementName() != null) sb.append(__wrapString(count++, "reimbursementName", getReimbursementName()));
		if(getReimbursementTime() != null) sb.append(__wrapDate(count++, "reimbursementTime", getReimbursementTime()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getApplyTime() != null) sb.append(__wrapDate(count++, "applyTime", getApplyTime()));
		if(getCompleteTime() != null) sb.append(__wrapDate(count++, "completeTime", getCompleteTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getStrikeABalance() != null) sb.append(__wrapBoolean(count++, "strikeABalance", getStrikeABalance()));
		if(getAttachment() != null) sb.append(__wrapString(count++, "attachment", getAttachment()));
		if(getAttachmentNumber() != null) sb.append(__wrapNumber(count++, "attachmentNumber", getAttachmentNumber()));
		if(getDetailProjectNormalReimbursementDetail() != null)  sb.append(__wrapList(count++, "detailProjectNormalReimbursementDetail", getDetailProjectNormalReimbursementDetail()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectNormalReimbursementId")) != null) setProjectNormalReimbursementId(__getInt(val)); 
		if((val = values.get("projectNormalReimbursementNo")) != null) setProjectNormalReimbursementNo(__getString(val));
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("applyEmployeeId")) != null) setApplyEmployeeId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("reimbursementName")) != null) setReimbursementName(__getString(val));
		if((val = values.get("reimbursementTime")) != null) setReimbursementTime(__getDate(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("applyTime")) != null) setApplyTime(__getDate(val)); 
		if((val = values.get("completeTime")) != null) setCompleteTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("strikeABalance")) != null) setStrikeABalance(__getBoolean(val));
		if((val = values.get("attachment")) != null) setAttachment(__getString(val));
		if((val = values.get("attachmentNumber")) != null) setAttachmentNumber(__getInt(val)); 
		if((val = values.get("detailProjectNormalReimbursementDetail")) != null) setDetailProjectNormalReimbursementDetail(__getList(val, BaseProjectNormalReimbursementDetail.newInstance()));
	}

	protected java.lang.Integer  __project_normal_reimbursement_id ;
	protected java.lang.String  __project_normal_reimbursement_no ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __apply_employee_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.String  __reimbursement_name ;
	protected java.util.Date  __reimbursement_time ;
	protected java.lang.Integer  __status ;
	protected java.math.BigDecimal  __amount ;
	protected java.util.Date  __apply_time ;
	protected java.util.Date  __complete_time ;
	protected java.lang.String  __remark ;
	protected java.lang.Boolean  __strike_a_balance ;
	protected java.lang.String  __attachment ;
	protected java.lang.Integer  __attachment_number ;
	protected java.util.List<BaseProjectNormalReimbursementDetail> __detailProjectNormalReimbursementDetail = null;
}
