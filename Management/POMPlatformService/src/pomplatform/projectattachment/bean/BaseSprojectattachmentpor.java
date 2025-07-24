package pomplatform.projectattachment.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSprojectattachmentpor extends GenericBase implements BaseFactory<BaseSprojectattachmentpor>, Comparable<BaseSprojectattachmentpor> 
{


	public static BaseSprojectattachmentpor newInstance(){
		return new BaseSprojectattachmentpor();
	}

	@Override
	public BaseSprojectattachmentpor make(){
		BaseSprojectattachmentpor b = new BaseSprojectattachmentpor();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ATTACHMENT_ID = "project_attachment_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_STAGE_ID = "stage_id" ;
	public final static java.lang.String CS_UPLOAD_TIME = "upload_time" ;
	public final static java.lang.String CS_ATTACHMENT_FILE = "attachment_file" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,项目编码,项目阶段,上传时间,附件,备注";

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

	public void cloneCopy(BaseSprojectattachmentpor __bean){
		__bean.setProjectAttachmentId(getProjectAttachmentId());
		__bean.setProjectId(getProjectId());
		__bean.setStageId(getStageId());
		__bean.setUploadTime(getUploadTime());
		__bean.setAttachmentFile(getAttachmentFile());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectAttachmentId() == null ? "" : getProjectAttachmentId());
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		sb.append(getStageId() == null ? "" : getStageId());
		sb.append(",");
		sb.append(getUploadTime() == null ? "" : sdf.format(getUploadTime()));
		sb.append(",");
		sb.append(getAttachmentFile() == null ? "" : getAttachmentFile());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSprojectattachmentpor o) {
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
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSprojectattachmentpor o = (BaseSprojectattachmentpor)obj;
		if(!Objects.equals(this.__project_attachment_id, o.getProjectAttachmentId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__stage_id, o.getStageId())) return false;
		if(!Objects.equals(this.__upload_time, o.getUploadTime())) return false;
		if(!Objects.equals(this.__attachment_file, o.getAttachmentFile())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
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
	}

	protected java.lang.Integer  __project_attachment_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __stage_id ;
	protected java.util.Date  __upload_time ;
	protected java.lang.String  __attachment_file ;
	protected java.lang.String  __remark ;
}
