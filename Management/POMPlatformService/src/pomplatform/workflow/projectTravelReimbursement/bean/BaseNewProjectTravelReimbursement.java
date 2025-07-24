package pomplatform.workflow.projectTravelReimbursement.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;
import com.pomplatform.db.bean.BaseTravelReimbursementDetail;
import com.pomplatform.db.bean.BaseTravelReimbursementLinkProject;

public class BaseNewProjectTravelReimbursement extends GenericBase implements BaseFactory<BaseNewProjectTravelReimbursement>, Comparable<BaseNewProjectTravelReimbursement> 
{


	public static BaseNewProjectTravelReimbursement newInstance(){
		return new BaseNewProjectTravelReimbursement();
	}

	@Override
	public BaseNewProjectTravelReimbursement make(){
		BaseNewProjectTravelReimbursement b = new BaseNewProjectTravelReimbursement();
		return b;
	}

	public final static java.lang.String CS_TRAVEL_REIMBURSEMENT_ID = "travel_reimbursement_id" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_TITLE = "title" ;
	public final static java.lang.String CS_APPLICANT = "applicant" ;
	public final static java.lang.String CS_DRAFTER = "drafter" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_REIMBURSEMENT_TIME = "reimbursement_time" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_STRIKE_A_BALANCE = "strike_a_balance" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_APPLY_TIME = "apply_time" ;
	public final static java.lang.String CS_COMPLETE_TIME = "complete_time" ;
	public final static java.lang.String CS_ATTACHMENT = "attachment" ;
	public final static java.lang.String CS_ATTACHMENT_NUMBER = "attachment_number" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;

	public final static java.lang.String ALL_CAPTIONS = "差旅报销编码,报销编号,流程编码,主题,申请人,起草人,报销部门,报销项目,报销时间,出差开始日期,出差结束日期,报销金额,冲账,报销事由,申请时间,完成时间,附件,附件数量,状态,归属公司";

	public java.lang.Integer getTravelReimbursementId() {
		return this.__travel_reimbursement_id;
	}

	public void setTravelReimbursementId( java.lang.Integer value ) {
		this.__travel_reimbursement_id = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.String getTitle() {
		return this.__title;
	}

	public void setTitle( java.lang.String value ) {
		this.__title = value;
	}

	public java.lang.Integer getApplicant() {
		return this.__applicant;
	}

	public void setApplicant( java.lang.Integer value ) {
		this.__applicant = value;
	}

	public java.lang.Integer getDrafter() {
		return this.__drafter;
	}

	public void setDrafter( java.lang.Integer value ) {
		this.__drafter = value;
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

	public java.util.Date getReimbursementTime() {
		return this.__reimbursement_time;
	}

	public void setReimbursementTime( java.util.Date value ) {
		this.__reimbursement_time = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.lang.Boolean getStrikeABalance() {
		return this.__strike_a_balance;
	}

	public void setStrikeABalance( java.lang.Boolean value ) {
		this.__strike_a_balance = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
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

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.util.List<BaseTravelReimbursementDetail> getDetailTravelReimbursementDetail() {
		return this.__detailTravelReimbursementDetail;
	}

	public void setDetailTravelReimbursementDetail( java.util.List<BaseTravelReimbursementDetail> value ) {
		this.__detailTravelReimbursementDetail = value;
	}

	public java.util.List<BaseTravelReimbursementLinkProject> getDetailTravelReimbursementLinkProject() {
		return this.__detailTravelReimbursementLinkProject;
	}

	public void setDetailTravelReimbursementLinkProject( java.util.List<BaseTravelReimbursementLinkProject> value ) {
		this.__detailTravelReimbursementLinkProject = value;
	}

	public void cloneCopy(BaseNewProjectTravelReimbursement __bean){
		__bean.setTravelReimbursementId(getTravelReimbursementId());
		__bean.setCode(getCode());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setTitle(getTitle());
		__bean.setApplicant(getApplicant());
		__bean.setDrafter(getDrafter());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setProjectId(getProjectId());
		__bean.setReimbursementTime(getReimbursementTime());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
		__bean.setAmount(getAmount());
		__bean.setStrikeABalance(getStrikeABalance());
		__bean.setRemark(getRemark());
		__bean.setApplyTime(getApplyTime());
		__bean.setCompleteTime(getCompleteTime());
		__bean.setAttachment(getAttachment());
		__bean.setAttachmentNumber(getAttachmentNumber());
		__bean.setStatus(getStatus());
		__bean.setCompanyId(getCompanyId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getTravelReimbursementId() == null ? "" : getTravelReimbursementId());
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		sb.append(getTitle() == null ? "" : getTitle());
		sb.append(",");
		String strApplicant = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getApplicant()));
		sb.append(strApplicant == null ? "" : strApplicant);
		sb.append(",");
		String strDrafter = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getDrafter()));
		sb.append(strDrafter == null ? "" : strDrafter);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments_true", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		sb.append(getReimbursementTime() == null ? "" : sdf.format(getReimbursementTime()));
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getStrikeABalance() == null ? "" : getStrikeABalance());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getApplyTime() == null ? "" : sdf.format(getApplyTime()));
		sb.append(",");
		sb.append(getCompleteTime() == null ? "" : sdf.format(getCompleteTime()));
		sb.append(",");
		sb.append(getAttachment() == null ? "" : getAttachment());
		sb.append(",");
		sb.append(getAttachmentNumber() == null ? "" : getAttachmentNumber());
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_16", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseNewProjectTravelReimbursement o) {
		return __travel_reimbursement_id == null ? -1 : __travel_reimbursement_id.compareTo(o.getTravelReimbursementId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__travel_reimbursement_id);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__title);
		hash = 97 * hash + Objects.hashCode(this.__applicant);
		hash = 97 * hash + Objects.hashCode(this.__drafter);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_time);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__strike_a_balance);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__apply_time);
		hash = 97 * hash + Objects.hashCode(this.__complete_time);
		hash = 97 * hash + Objects.hashCode(this.__attachment);
		hash = 97 * hash + Objects.hashCode(this.__attachment_number);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseNewProjectTravelReimbursement o = (BaseNewProjectTravelReimbursement)obj;
		if(!Objects.equals(this.__travel_reimbursement_id, o.getTravelReimbursementId())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__title, o.getTitle())) return false;
		if(!Objects.equals(this.__applicant, o.getApplicant())) return false;
		if(!Objects.equals(this.__drafter, o.getDrafter())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__reimbursement_time, o.getReimbursementTime())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__strike_a_balance, o.getStrikeABalance())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__apply_time, o.getApplyTime())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
		if(!Objects.equals(this.__attachment, o.getAttachment())) return false;
		if(!Objects.equals(this.__attachment_number, o.getAttachmentNumber())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getTravelReimbursementId() != null) sb.append(__wrapNumber(count++, "travelReimbursementId", getTravelReimbursementId()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getTitle() != null) sb.append(__wrapString(count++, "title", getTitle()));
		if(getApplicant() != null) sb.append(__wrapNumber(count++, "applicant", getApplicant()));
		if(getDrafter() != null) sb.append(__wrapNumber(count++, "drafter", getDrafter()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getReimbursementTime() != null) sb.append(__wrapDate(count++, "reimbursementTime", getReimbursementTime()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getStrikeABalance() != null) sb.append(__wrapBoolean(count++, "strikeABalance", getStrikeABalance()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getApplyTime() != null) sb.append(__wrapDate(count++, "applyTime", getApplyTime()));
		if(getCompleteTime() != null) sb.append(__wrapDate(count++, "completeTime", getCompleteTime()));
		if(getAttachment() != null) sb.append(__wrapString(count++, "attachment", getAttachment()));
		if(getAttachmentNumber() != null) sb.append(__wrapNumber(count++, "attachmentNumber", getAttachmentNumber()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getDetailTravelReimbursementDetail() != null)  sb.append(__wrapList(count++, "detailTravelReimbursementDetail", getDetailTravelReimbursementDetail()));
		if(getDetailTravelReimbursementLinkProject() != null)  sb.append(__wrapList(count++, "detailTravelReimbursementLinkProject", getDetailTravelReimbursementLinkProject()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("travelReimbursementId")) != null) setTravelReimbursementId(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("title")) != null) setTitle(__getString(val));
		if((val = values.get("applicant")) != null) setApplicant(__getInt(val)); 
		if((val = values.get("drafter")) != null) setDrafter(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("reimbursementTime")) != null) setReimbursementTime(__getDate(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("strikeABalance")) != null) setStrikeABalance(__getBoolean(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("applyTime")) != null) setApplyTime(__getDate(val)); 
		if((val = values.get("completeTime")) != null) setCompleteTime(__getDate(val)); 
		if((val = values.get("attachment")) != null) setAttachment(__getString(val));
		if((val = values.get("attachmentNumber")) != null) setAttachmentNumber(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("detailTravelReimbursementDetail")) != null) setDetailTravelReimbursementDetail(__getList(val, BaseTravelReimbursementDetail.newInstance()));
		if((val = values.get("detailTravelReimbursementLinkProject")) != null) setDetailTravelReimbursementLinkProject(__getList(val, BaseTravelReimbursementLinkProject.newInstance()));
	}

	protected java.lang.Integer  __travel_reimbursement_id ;
	protected java.lang.String  __code ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.String  __title ;
	protected java.lang.Integer  __applicant ;
	protected java.lang.Integer  __drafter ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __project_id ;
	protected java.util.Date  __reimbursement_time ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected java.math.BigDecimal  __amount ;
	protected java.lang.Boolean  __strike_a_balance ;
	protected java.lang.String  __remark ;
	protected java.util.Date  __apply_time ;
	protected java.util.Date  __complete_time ;
	protected java.lang.String  __attachment ;
	protected java.lang.Integer  __attachment_number ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __company_id ;
	protected java.util.List<BaseTravelReimbursementDetail> __detailTravelReimbursementDetail = null;
	protected java.util.List<BaseTravelReimbursementLinkProject> __detailTravelReimbursementLinkProject = null;
}
