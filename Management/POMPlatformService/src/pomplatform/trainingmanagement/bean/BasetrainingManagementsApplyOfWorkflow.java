package pomplatform.trainingmanagement.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasetrainingManagementsApplyOfWorkflow extends GenericBase implements BaseFactory<BasetrainingManagementsApplyOfWorkflow>, Comparable<BasetrainingManagementsApplyOfWorkflow> 
{


	public static BasetrainingManagementsApplyOfWorkflow newInstance(){
		return new BasetrainingManagementsApplyOfWorkflow();
	}

	@Override
	public BasetrainingManagementsApplyOfWorkflow make(){
		BasetrainingManagementsApplyOfWorkflow b = new BasetrainingManagementsApplyOfWorkflow();
		return b;
	}

	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_BUSINESS_NAME = "business_name" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ACTIVITY_ID = "process_instance_activity_id" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_COMPLETE_TIME = "complete_time" ;
	public final static java.lang.String CS_TRAINING_MANAGEMENT_ID = "training_management_id" ;
	public final static java.lang.String CS_SUBJECT = "subject" ;
	public final static java.lang.String CS_START_TIME = "start_time" ;
	public final static java.lang.String CS_END_TIME = "end_time" ;
	public final static java.lang.String CS_COMPERE_TYPE = "compere_type" ;
	public final static java.lang.String CS_COMPERE = "compere" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_SIGN_IN_DELAY = "sign_in_delay" ;
	public final static java.lang.String CS_SIGN_OUT_DELAY = "sign_out_delay" ;
	public final static java.lang.String CS_COURSE_SCORE = "course_score" ;
	public final static java.lang.String CS_DETAIL = "detail" ;
	public final static java.lang.String CS_CREATE_PERSON_ID = "create_person_id" ;
	public final static java.lang.String CS_FILE_MANAGE_ID = "file_manage_id" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_SITE = "site" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_IS_SITE = "is_site" ;
	public final static java.lang.String CS_TRAINING_TYPE = "training_type" ;
	public final static java.lang.String CS_TRAINING_FEE = "training_fee" ;
	public final static java.lang.String CS_FILE_ID = "file_id" ;
	public final static java.lang.String CS_FILE_URL = "file_url" ;
	public final static java.lang.String CS_IS_SEND = "is_send" ;
	public final static java.lang.String CS_PLATEIDS = "plateids" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,流程类型,业务编码,业务名称,流程编码,活动实列编码,流程状态 0 发起中  1,创建时间,完成时间,主键编码,主题,开始时间,结束时间,主持人类型(1公司内部员工2外部人员),主持人,创建人,部门编码,签到允许延迟时间,签退允许延迟时间,课程分数,详情,创建人编码,文件编码,1(未开始)2(进行中)3(已结束),培训地点名称,业务部门,培训地点  0内部 1外部,培训类型  0内部 1外部,外部培训预计费用 内部可不填,fileId,课程附件,是否进行消息推送 0是 1否,需要推送的业务部门ids";

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
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

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getCompleteTime() {
		return this.__complete_time;
	}

	public void setCompleteTime( java.util.Date value ) {
		this.__complete_time = value;
	}

	public java.lang.Integer getTrainingManagementId() {
		return this.__training_management_id;
	}

	public void setTrainingManagementId( java.lang.Integer value ) {
		this.__training_management_id = value;
	}

	public java.lang.String getSubject() {
		return this.__subject;
	}

	public void setSubject( java.lang.String value ) {
		this.__subject = value;
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

	public java.lang.Integer getCompereType() {
		return this.__compere_type;
	}

	public void setCompereType( java.lang.Integer value ) {
		this.__compere_type = value;
	}

	public java.lang.String getCompere() {
		return this.__compere;
	}

	public void setCompere( java.lang.String value ) {
		this.__compere = value;
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

	public java.lang.Integer getSignInDelay() {
		return this.__sign_in_delay;
	}

	public void setSignInDelay( java.lang.Integer value ) {
		this.__sign_in_delay = value;
	}

	public java.lang.Integer getSignOutDelay() {
		return this.__sign_out_delay;
	}

	public void setSignOutDelay( java.lang.Integer value ) {
		this.__sign_out_delay = value;
	}

	public java.lang.Integer getCourseScore() {
		return this.__course_score;
	}

	public void setCourseScore( java.lang.Integer value ) {
		this.__course_score = value;
	}

	public java.lang.String getDetail() {
		return this.__detail;
	}

	public void setDetail( java.lang.String value ) {
		this.__detail = value;
	}

	public java.lang.Integer getCreatePersonId() {
		return this.__create_person_id;
	}

	public void setCreatePersonId( java.lang.Integer value ) {
		this.__create_person_id = value;
	}

	public java.lang.Integer getFileManageId() {
		return this.__file_manage_id;
	}

	public void setFileManageId( java.lang.Integer value ) {
		this.__file_manage_id = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.String getSite() {
		return this.__site;
	}

	public void setSite( java.lang.String value ) {
		this.__site = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getIsSite() {
		return this.__is_site;
	}

	public void setIsSite( java.lang.Integer value ) {
		this.__is_site = value;
	}

	public java.lang.Integer getTrainingType() {
		return this.__training_type;
	}

	public void setTrainingType( java.lang.Integer value ) {
		this.__training_type = value;
	}

	public java.lang.Integer getTrainingFee() {
		return this.__training_fee;
	}

	public void setTrainingFee( java.lang.Integer value ) {
		this.__training_fee = value;
	}

	public java.lang.Integer getFileId() {
		return this.__file_id;
	}

	public void setFileId( java.lang.Integer value ) {
		this.__file_id = value;
	}

	public java.lang.String getFileUrl() {
		return this.__file_url;
	}

	public void setFileUrl( java.lang.String value ) {
		this.__file_url = value;
	}

	public java.lang.Integer getIsSend() {
		return this.__is_send;
	}

	public void setIsSend( java.lang.Integer value ) {
		this.__is_send = value;
	}

	public java.lang.String getPlateids() {
		return this.__plateids;
	}

	public void setPlateids( java.lang.String value ) {
		this.__plateids = value;
	}

	public void cloneCopy(BasetrainingManagementsApplyOfWorkflow __bean){
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setProcessType(getProcessType());
		__bean.setBusinessId(getBusinessId());
		__bean.setBusinessName(getBusinessName());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceActivityId(getProcessInstanceActivityId());
		__bean.setProcessStatus(getProcessStatus());
		__bean.setCreateTime(getCreateTime());
		__bean.setCompleteTime(getCompleteTime());
		__bean.setTrainingManagementId(getTrainingManagementId());
		__bean.setSubject(getSubject());
		__bean.setStartTime(getStartTime());
		__bean.setEndTime(getEndTime());
		__bean.setCompereType(getCompereType());
		__bean.setCompere(getCompere());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setSignInDelay(getSignInDelay());
		__bean.setSignOutDelay(getSignOutDelay());
		__bean.setCourseScore(getCourseScore());
		__bean.setDetail(getDetail());
		__bean.setCreatePersonId(getCreatePersonId());
		__bean.setFileManageId(getFileManageId());
		__bean.setStatus(getStatus());
		__bean.setSite(getSite());
		__bean.setPlateId(getPlateId());
		__bean.setIsSite(getIsSite());
		__bean.setTrainingType(getTrainingType());
		__bean.setTrainingFee(getTrainingFee());
		__bean.setFileId(getFileId());
		__bean.setFileUrl(getFileUrl());
		__bean.setIsSend(getIsSend());
		__bean.setPlateids(getPlateids());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		sb.append(getBusinessName() == null ? "" : getBusinessName());
		sb.append(",");
		sb.append(getProcessId() == null ? "" : getProcessId());
		sb.append(",");
		sb.append(getProcessInstanceActivityId() == null ? "" : getProcessInstanceActivityId());
		sb.append(",");
		sb.append(getProcessStatus() == null ? "" : getProcessStatus());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getCompleteTime() == null ? "" : sdf.format(getCompleteTime()));
		sb.append(",");
		sb.append(getTrainingManagementId() == null ? "" : getTrainingManagementId());
		sb.append(",");
		sb.append(getSubject() == null ? "" : getSubject());
		sb.append(",");
		sb.append(getStartTime() == null ? "" : sdf.format(getStartTime()));
		sb.append(",");
		sb.append(getEndTime() == null ? "" : sdf.format(getEndTime()));
		sb.append(",");
		sb.append(getCompereType() == null ? "" : getCompereType());
		sb.append(",");
		sb.append(getCompere() == null ? "" : getCompere());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getSignInDelay() == null ? "" : getSignInDelay());
		sb.append(",");
		sb.append(getSignOutDelay() == null ? "" : getSignOutDelay());
		sb.append(",");
		sb.append(getCourseScore() == null ? "" : getCourseScore());
		sb.append(",");
		sb.append(getDetail() == null ? "" : getDetail());
		sb.append(",");
		sb.append(getCreatePersonId() == null ? "" : getCreatePersonId());
		sb.append(",");
		sb.append(getFileManageId() == null ? "" : getFileManageId());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getSite() == null ? "" : getSite());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getIsSite() == null ? "" : getIsSite());
		sb.append(",");
		sb.append(getTrainingType() == null ? "" : getTrainingType());
		sb.append(",");
		sb.append(getTrainingFee() == null ? "" : getTrainingFee());
		sb.append(",");
		sb.append(getFileId() == null ? "" : getFileId());
		sb.append(",");
		sb.append(getFileUrl() == null ? "" : getFileUrl());
		sb.append(",");
		sb.append(getIsSend() == null ? "" : getIsSend());
		sb.append(",");
		sb.append(getPlateids() == null ? "" : getPlateids());
		return sb.toString();
	}

	@Override
	public int compareTo(BasetrainingManagementsApplyOfWorkflow o) {
		return __process_instance_id == null ? -1 : __process_instance_id.compareTo(o.getProcessInstanceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__business_name);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__complete_time);
		hash = 97 * hash + Objects.hashCode(this.__training_management_id);
		hash = 97 * hash + Objects.hashCode(this.__subject);
		hash = 97 * hash + Objects.hashCode(this.__start_time);
		hash = 97 * hash + Objects.hashCode(this.__end_time);
		hash = 97 * hash + Objects.hashCode(this.__compere_type);
		hash = 97 * hash + Objects.hashCode(this.__compere);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__sign_in_delay);
		hash = 97 * hash + Objects.hashCode(this.__sign_out_delay);
		hash = 97 * hash + Objects.hashCode(this.__course_score);
		hash = 97 * hash + Objects.hashCode(this.__detail);
		hash = 97 * hash + Objects.hashCode(this.__create_person_id);
		hash = 97 * hash + Objects.hashCode(this.__file_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__site);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__is_site);
		hash = 97 * hash + Objects.hashCode(this.__training_type);
		hash = 97 * hash + Objects.hashCode(this.__training_fee);
		hash = 97 * hash + Objects.hashCode(this.__file_id);
		hash = 97 * hash + Objects.hashCode(this.__file_url);
		hash = 97 * hash + Objects.hashCode(this.__is_send);
		hash = 97 * hash + Objects.hashCode(this.__plateids);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasetrainingManagementsApplyOfWorkflow o = (BasetrainingManagementsApplyOfWorkflow)obj;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_activity_id, o.getProcessInstanceActivityId())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
		if(!Objects.equals(this.__training_management_id, o.getTrainingManagementId())) return false;
		if(!Objects.equals(this.__subject, o.getSubject())) return false;
		if(!Objects.equals(this.__start_time, o.getStartTime())) return false;
		if(!Objects.equals(this.__end_time, o.getEndTime())) return false;
		if(!Objects.equals(this.__compere_type, o.getCompereType())) return false;
		if(!Objects.equals(this.__compere, o.getCompere())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__sign_in_delay, o.getSignInDelay())) return false;
		if(!Objects.equals(this.__sign_out_delay, o.getSignOutDelay())) return false;
		if(!Objects.equals(this.__course_score, o.getCourseScore())) return false;
		if(!Objects.equals(this.__detail, o.getDetail())) return false;
		if(!Objects.equals(this.__create_person_id, o.getCreatePersonId())) return false;
		if(!Objects.equals(this.__file_manage_id, o.getFileManageId())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__site, o.getSite())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__is_site, o.getIsSite())) return false;
		if(!Objects.equals(this.__training_type, o.getTrainingType())) return false;
		if(!Objects.equals(this.__training_fee, o.getTrainingFee())) return false;
		if(!Objects.equals(this.__file_id, o.getFileId())) return false;
		if(!Objects.equals(this.__file_url, o.getFileUrl())) return false;
		if(!Objects.equals(this.__is_send, o.getIsSend())) return false;
		if(!Objects.equals(this.__plateids, o.getPlateids())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessInstanceActivityId() != null) sb.append(__wrapNumber(count++, "processInstanceActivityId", getProcessInstanceActivityId()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getCompleteTime() != null) sb.append(__wrapDate(count++, "completeTime", getCompleteTime()));
		if(getTrainingManagementId() != null) sb.append(__wrapNumber(count++, "trainingManagementId", getTrainingManagementId()));
		if(getSubject() != null) sb.append(__wrapString(count++, "subject", getSubject()));
		if(getStartTime() != null) sb.append(__wrapDate(count++, "startTime", getStartTime()));
		if(getEndTime() != null) sb.append(__wrapDate(count++, "endTime", getEndTime()));
		if(getCompereType() != null) sb.append(__wrapNumber(count++, "compereType", getCompereType()));
		if(getCompere() != null) sb.append(__wrapString(count++, "compere", getCompere()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getSignInDelay() != null) sb.append(__wrapNumber(count++, "signInDelay", getSignInDelay()));
		if(getSignOutDelay() != null) sb.append(__wrapNumber(count++, "signOutDelay", getSignOutDelay()));
		if(getCourseScore() != null) sb.append(__wrapNumber(count++, "courseScore", getCourseScore()));
		if(getDetail() != null) sb.append(__wrapString(count++, "detail", getDetail()));
		if(getCreatePersonId() != null) sb.append(__wrapNumber(count++, "createPersonId", getCreatePersonId()));
		if(getFileManageId() != null) sb.append(__wrapNumber(count++, "fileManageId", getFileManageId()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getSite() != null) sb.append(__wrapString(count++, "site", getSite()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getIsSite() != null) sb.append(__wrapNumber(count++, "isSite", getIsSite()));
		if(getTrainingType() != null) sb.append(__wrapNumber(count++, "trainingType", getTrainingType()));
		if(getTrainingFee() != null) sb.append(__wrapNumber(count++, "trainingFee", getTrainingFee()));
		if(getFileId() != null) sb.append(__wrapNumber(count++, "fileId", getFileId()));
		if(getFileUrl() != null) sb.append(__wrapString(count++, "fileUrl", getFileUrl()));
		if(getIsSend() != null) sb.append(__wrapNumber(count++, "isSend", getIsSend()));
		if(getPlateids() != null) sb.append(__wrapString(count++, "plateids", getPlateids()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProcessInstanceId() != null) res.put("processInstanceId", getProcessInstanceId());
		if(getProcessType() != null) res.put("processType", getProcessType());
		if(getBusinessId() != null) res.put("businessId", getBusinessId());
		if(getBusinessName() != null) res.put("businessName", getBusinessName());
		if(getProcessId() != null) res.put("processId", getProcessId());
		if(getProcessInstanceActivityId() != null) res.put("processInstanceActivityId", getProcessInstanceActivityId());
		if(getProcessStatus() != null) res.put("processStatus", getProcessStatus());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getCompleteTime() != null) res.put("completeTime", getCompleteTime());
		if(getTrainingManagementId() != null) res.put("trainingManagementId", getTrainingManagementId());
		if(getSubject() != null) res.put("subject", getSubject());
		if(getStartTime() != null) res.put("startTime", getStartTime());
		if(getEndTime() != null) res.put("endTime", getEndTime());
		if(getCompereType() != null) res.put("compereType", getCompereType());
		if(getCompere() != null) res.put("compere", getCompere());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getSignInDelay() != null) res.put("signInDelay", getSignInDelay());
		if(getSignOutDelay() != null) res.put("signOutDelay", getSignOutDelay());
		if(getCourseScore() != null) res.put("courseScore", getCourseScore());
		if(getDetail() != null) res.put("detail", getDetail());
		if(getCreatePersonId() != null) res.put("createPersonId", getCreatePersonId());
		if(getFileManageId() != null) res.put("fileManageId", getFileManageId());
		if(getStatus() != null) res.put("status", getStatus());
		if(getSite() != null) res.put("site", getSite());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getIsSite() != null) res.put("isSite", getIsSite());
		if(getTrainingType() != null) res.put("trainingType", getTrainingType());
		if(getTrainingFee() != null) res.put("trainingFee", getTrainingFee());
		if(getFileId() != null) res.put("fileId", getFileId());
		if(getFileUrl() != null) res.put("fileUrl", getFileUrl());
		if(getIsSend() != null) res.put("isSend", getIsSend());
		if(getPlateids() != null) res.put("plateids", getPlateids());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val));
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("processInstanceActivityId")) != null) setProcessInstanceActivityId(__getInt(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("completeTime")) != null) setCompleteTime(__getDate(val)); 
		if((val = values.get("trainingManagementId")) != null) setTrainingManagementId(__getInt(val)); 
		if((val = values.get("subject")) != null) setSubject(__getString(val));
		if((val = values.get("startTime")) != null) setStartTime(__getDate(val)); 
		if((val = values.get("endTime")) != null) setEndTime(__getDate(val)); 
		if((val = values.get("compereType")) != null) setCompereType(__getInt(val)); 
		if((val = values.get("compere")) != null) setCompere(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("signInDelay")) != null) setSignInDelay(__getInt(val)); 
		if((val = values.get("signOutDelay")) != null) setSignOutDelay(__getInt(val)); 
		if((val = values.get("courseScore")) != null) setCourseScore(__getInt(val)); 
		if((val = values.get("detail")) != null) setDetail(__getString(val));
		if((val = values.get("createPersonId")) != null) setCreatePersonId(__getInt(val)); 
		if((val = values.get("fileManageId")) != null) setFileManageId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("site")) != null) setSite(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("isSite")) != null) setIsSite(__getInt(val)); 
		if((val = values.get("trainingType")) != null) setTrainingType(__getInt(val)); 
		if((val = values.get("trainingFee")) != null) setTrainingFee(__getInt(val)); 
		if((val = values.get("fileId")) != null) setFileId(__getInt(val)); 
		if((val = values.get("fileUrl")) != null) setFileUrl(__getString(val));
		if((val = values.get("isSend")) != null) setIsSend(__getInt(val)); 
		if((val = values.get("plateids")) != null) setPlateids(__getString(val));
	}

	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.String  __business_name ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_instance_activity_id ;
	protected java.lang.Integer  __process_status ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __complete_time ;
	protected java.lang.Integer  __training_management_id ;
	protected java.lang.String  __subject ;
	protected java.util.Date  __start_time ;
	protected java.util.Date  __end_time ;
	protected java.lang.Integer  __compere_type ;
	protected java.lang.String  __compere ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __sign_in_delay ;
	protected java.lang.Integer  __sign_out_delay ;
	protected java.lang.Integer  __course_score ;
	protected java.lang.String  __detail ;
	protected java.lang.Integer  __create_person_id ;
	protected java.lang.Integer  __file_manage_id ;
	protected java.lang.Integer  __status ;
	protected java.lang.String  __site ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __is_site ;
	protected java.lang.Integer  __training_type ;
	protected java.lang.Integer  __training_fee ;
	protected java.lang.Integer  __file_id ;
	protected java.lang.String  __file_url ;
	protected java.lang.Integer  __is_send ;
	protected java.lang.String  __plateids ;
}
