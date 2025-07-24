package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseProjectAttachment extends GenericBase implements BaseFactory<BaseProjectAttachment>, Comparable<BaseProjectAttachment> 
{


	public static BaseProjectAttachment newInstance(){
		return new BaseProjectAttachment();
	}

	@Override
	public BaseProjectAttachment make(){
		BaseProjectAttachment b = new BaseProjectAttachment();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ATTACHMENT_ID = "project_attachment_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_STAGE_ID = "stage_id" ;
	public final static java.lang.String CS_UPLOAD_TIME = "upload_time" ;
	public final static java.lang.String CS_ATTACHMENT_FILE = "attachment_file" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_IS_HANDLE = "is_handle" ;
	public final static java.lang.String CS_IS_SAME_CONTRACT = "is_same_contract" ;
	public final static java.lang.String CS_IS_SAME_STAGE = "is_same_stage" ;
	public final static java.lang.String CS_IS_HAS_SIGN = "is_has_sign" ;
	public final static java.lang.String CS_IS_HAS_SEAL = "is_has_seal" ;
	public final static java.lang.String CS_IS_SURE = "is_sure" ;
	public final static java.lang.String CS_IS_QUALIFIED = "is_qualified" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_IS_EMAIL_SURE = "is_email_sure" ;
	public final static java.lang.String CS_IS_OTHER_SURE = "is_other_sure" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,项目编码,项目阶段,上传时间,附件,备注,附件是否处理,是否是同一个合同,是否是同一个阶段,是否有对方的签字,是否有对方的盖章,对方是否明确确认,是否合格,操作人,操作时间,邮件确认,其它确认";

	public java.lang.Integer getProjectAttachmentId() {
		return this.__project_attachment_id;
	}

	public void setProjectAttachmentId( java.lang.Integer value ) {
		this.__project_attachment_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getStageId() {
		return this.__stage_id;
	}

	public void setStageId( java.lang.Integer value ) {
		this.__stage_id = value;
	}

	public java.util.Date getUploadTime() {
		return this.__upload_time;
	}

	public void setUploadTime( java.util.Date value ) {
		this.__upload_time = value;
	}

	public java.lang.String getAttachmentFile() {
		return this.__attachment_file;
	}

	public void setAttachmentFile( java.lang.String value ) {
		this.__attachment_file = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Boolean getIsHandle() {
		return this.__is_handle;
	}

	public void setIsHandle( java.lang.Boolean value ) {
		this.__is_handle = value;
	}

	public java.lang.Boolean getIsSameContract() {
		return this.__is_same_contract;
	}

	public void setIsSameContract( java.lang.Boolean value ) {
		this.__is_same_contract = value;
	}

	public java.lang.Boolean getIsSameStage() {
		return this.__is_same_stage;
	}

	public void setIsSameStage( java.lang.Boolean value ) {
		this.__is_same_stage = value;
	}

	public java.lang.Boolean getIsHasSign() {
		return this.__is_has_sign;
	}

	public void setIsHasSign( java.lang.Boolean value ) {
		this.__is_has_sign = value;
	}

	public java.lang.Boolean getIsHasSeal() {
		return this.__is_has_seal;
	}

	public void setIsHasSeal( java.lang.Boolean value ) {
		this.__is_has_seal = value;
	}

	public java.lang.Boolean getIsSure() {
		return this.__is_sure;
	}

	public void setIsSure( java.lang.Boolean value ) {
		this.__is_sure = value;
	}

	public java.lang.Boolean getIsQualified() {
		return this.__is_qualified;
	}

	public void setIsQualified( java.lang.Boolean value ) {
		this.__is_qualified = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.Boolean getIsEmailSure() {
		return this.__is_email_sure;
	}

	public void setIsEmailSure( java.lang.Boolean value ) {
		this.__is_email_sure = value;
	}

	public java.lang.Boolean getIsOtherSure() {
		return this.__is_other_sure;
	}

	public void setIsOtherSure( java.lang.Boolean value ) {
		this.__is_other_sure = value;
	}

	public void cloneCopy(BaseProjectAttachment __bean){
		__bean.setProjectAttachmentId(getProjectAttachmentId());
		__bean.setProjectId(getProjectId());
		__bean.setStageId(getStageId());
		__bean.setUploadTime(getUploadTime());
		__bean.setAttachmentFile(getAttachmentFile());
		__bean.setRemark(getRemark());
		__bean.setIsHandle(getIsHandle());
		__bean.setIsSameContract(getIsSameContract());
		__bean.setIsSameStage(getIsSameStage());
		__bean.setIsHasSign(getIsHasSign());
		__bean.setIsHasSeal(getIsHasSeal());
		__bean.setIsSure(getIsSure());
		__bean.setIsQualified(getIsQualified());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setIsEmailSure(getIsEmailSure());
		__bean.setIsOtherSure(getIsOtherSure());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectAttachmentId() == null ? "" : getProjectAttachmentId());
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		String strStageId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_7", String.valueOf(getStageId()));
		sb.append(strStageId == null ? "" : strStageId);
		sb.append(",");
		sb.append(getUploadTime() == null ? "" : sdf.format(getUploadTime()));
		sb.append(",");
		sb.append(getAttachmentFile() == null ? "" : getAttachmentFile());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getIsHandle() == null ? "" : getIsHandle());
		sb.append(",");
		sb.append(getIsSameContract() == null ? "" : getIsSameContract());
		sb.append(",");
		sb.append(getIsSameStage() == null ? "" : getIsSameStage());
		sb.append(",");
		sb.append(getIsHasSign() == null ? "" : getIsHasSign());
		sb.append(",");
		sb.append(getIsHasSeal() == null ? "" : getIsHasSeal());
		sb.append(",");
		sb.append(getIsSure() == null ? "" : getIsSure());
		sb.append(",");
		sb.append(getIsQualified() == null ? "" : getIsQualified());
		sb.append(",");
		String strOperateEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getOperateEmployeeId()));
		sb.append(strOperateEmployeeId == null ? "" : strOperateEmployeeId);
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getIsEmailSure() == null ? "" : getIsEmailSure());
		sb.append(",");
		sb.append(getIsOtherSure() == null ? "" : getIsOtherSure());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectAttachment o) {
		return __project_attachment_id == null ? -1 : __project_attachment_id.compareTo(o.getProjectAttachmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_attachment_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__stage_id);
		hash = 97 * hash + Objects.hashCode(this.__upload_time);
		hash = 97 * hash + Objects.hashCode(this.__attachment_file);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__is_handle);
		hash = 97 * hash + Objects.hashCode(this.__is_same_contract);
		hash = 97 * hash + Objects.hashCode(this.__is_same_stage);
		hash = 97 * hash + Objects.hashCode(this.__is_has_sign);
		hash = 97 * hash + Objects.hashCode(this.__is_has_seal);
		hash = 97 * hash + Objects.hashCode(this.__is_sure);
		hash = 97 * hash + Objects.hashCode(this.__is_qualified);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__is_email_sure);
		hash = 97 * hash + Objects.hashCode(this.__is_other_sure);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectAttachment o = (BaseProjectAttachment)obj;
		if(!Objects.equals(this.__project_attachment_id, o.getProjectAttachmentId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__stage_id, o.getStageId())) return false;
		if(!Objects.equals(this.__upload_time, o.getUploadTime())) return false;
		if(!Objects.equals(this.__attachment_file, o.getAttachmentFile())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__is_handle, o.getIsHandle())) return false;
		if(!Objects.equals(this.__is_same_contract, o.getIsSameContract())) return false;
		if(!Objects.equals(this.__is_same_stage, o.getIsSameStage())) return false;
		if(!Objects.equals(this.__is_has_sign, o.getIsHasSign())) return false;
		if(!Objects.equals(this.__is_has_seal, o.getIsHasSeal())) return false;
		if(!Objects.equals(this.__is_sure, o.getIsSure())) return false;
		if(!Objects.equals(this.__is_qualified, o.getIsQualified())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__is_email_sure, o.getIsEmailSure())) return false;
		if(!Objects.equals(this.__is_other_sure, o.getIsOtherSure())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectAttachmentId() != null) sb.append(__wrapNumber(count++, "projectAttachmentId", getProjectAttachmentId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getStageId() != null) sb.append(__wrapNumber(count++, "stageId", getStageId()));
		if(getUploadTime() != null) sb.append(__wrapDate(count++, "uploadTime", getUploadTime()));
		if(getAttachmentFile() != null) sb.append(__wrapString(count++, "attachmentFile", getAttachmentFile()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getIsHandle() != null) sb.append(__wrapBoolean(count++, "isHandle", getIsHandle()));
		if(getIsSameContract() != null) sb.append(__wrapBoolean(count++, "isSameContract", getIsSameContract()));
		if(getIsSameStage() != null) sb.append(__wrapBoolean(count++, "isSameStage", getIsSameStage()));
		if(getIsHasSign() != null) sb.append(__wrapBoolean(count++, "isHasSign", getIsHasSign()));
		if(getIsHasSeal() != null) sb.append(__wrapBoolean(count++, "isHasSeal", getIsHasSeal()));
		if(getIsSure() != null) sb.append(__wrapBoolean(count++, "isSure", getIsSure()));
		if(getIsQualified() != null) sb.append(__wrapBoolean(count++, "isQualified", getIsQualified()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getIsEmailSure() != null) sb.append(__wrapBoolean(count++, "isEmailSure", getIsEmailSure()));
		if(getIsOtherSure() != null) sb.append(__wrapBoolean(count++, "isOtherSure", getIsOtherSure()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectAttachmentId")) != null) setProjectAttachmentId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("stageId")) != null) setStageId(__getInt(val)); 
		if((val = values.get("uploadTime")) != null) setUploadTime(__getDate(val)); 
		if((val = values.get("attachmentFile")) != null) setAttachmentFile(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("isHandle")) != null) setIsHandle(__getBoolean(val));
		if((val = values.get("isSameContract")) != null) setIsSameContract(__getBoolean(val));
		if((val = values.get("isSameStage")) != null) setIsSameStage(__getBoolean(val));
		if((val = values.get("isHasSign")) != null) setIsHasSign(__getBoolean(val));
		if((val = values.get("isHasSeal")) != null) setIsHasSeal(__getBoolean(val));
		if((val = values.get("isSure")) != null) setIsSure(__getBoolean(val));
		if((val = values.get("isQualified")) != null) setIsQualified(__getBoolean(val));
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("isEmailSure")) != null) setIsEmailSure(__getBoolean(val));
		if((val = values.get("isOtherSure")) != null) setIsOtherSure(__getBoolean(val));
	}

	protected java.lang.Integer  __project_attachment_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __stage_id ;
	protected java.util.Date  __upload_time ;
	protected java.lang.String  __attachment_file ;
	protected java.lang.String  __remark ;
	protected java.lang.Boolean  __is_handle ;
	protected java.lang.Boolean  __is_same_contract ;
	protected java.lang.Boolean  __is_same_stage ;
	protected java.lang.Boolean  __is_has_sign ;
	protected java.lang.Boolean  __is_has_seal ;
	protected java.lang.Boolean  __is_sure ;
	protected java.lang.Boolean  __is_qualified ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.Boolean  __is_email_sure ;
	protected java.lang.Boolean  __is_other_sure ;
}
