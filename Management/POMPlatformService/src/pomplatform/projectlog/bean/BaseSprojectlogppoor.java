package pomplatform.projectlog.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSprojectlogppoor extends GenericBase implements BaseFactory<BaseSprojectlogppoor>, Comparable<BaseSprojectlogppoor> 
{


	public static BaseSprojectlogppoor newInstance(){
		return new BaseSprojectlogppoor();
	}

	@Override
	public BaseSprojectlogppoor make(){
		BaseSprojectlogppoor b = new BaseSprojectlogppoor();
		return b;
	}

	public final static java.lang.String CS_PROJECT_LOG_ID = "project_log_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_OPERATE_ID = "operate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_MANAGER_ID = "manager_id" ;
	public final static java.lang.String CS_DESIGN_PHASE = "design_phase" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_LOG_TYPE = "log_type" ;
	public final static java.lang.String CS_LOG_CONTENT = "log_content" ;
	public final static java.lang.String CS_ALTERNATE_FIELD1 = "alternate_field1" ;
	public final static java.lang.String CS_ALTERNATE_FIELD2 = "alternate_field2" ;
	public final static java.lang.String CS_ALTERNATE_FIELD3 = "alternate_field3" ;
	public final static java.lang.String CS_STATUS = "status" ;

	public final static java.lang.String ALL_CAPTIONS = "项目日志编码,项目,操作人,归属部门,板块负责人,设计阶段,操作时间,日志类型,日志内容,备用字段1,备用字段2,备用字段3,状态";

	public java.lang.Integer getProjectLogId() {
		return this.__project_log_id;
	}

	public void setProjectLogId( java.lang.Integer value ) {
		this.__project_log_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getOperateId() {
		return this.__operate_id;
	}

	public void setOperateId( java.lang.Integer value ) {
		this.__operate_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getManagerId() {
		return this.__manager_id;
	}

	public void setManagerId( java.lang.Integer value ) {
		this.__manager_id = value;
	}

	public java.lang.Integer getDesignPhase() {
		return this.__design_phase;
	}

	public void setDesignPhase( java.lang.Integer value ) {
		this.__design_phase = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.Integer getLogType() {
		return this.__log_type;
	}

	public void setLogType( java.lang.Integer value ) {
		this.__log_type = value;
	}

	public java.lang.String getLogContent() {
		return this.__log_content;
	}

	public void setLogContent( java.lang.String value ) {
		this.__log_content = value;
	}

	public java.lang.String getAlternateField1() {
		return this.__alternate_field1;
	}

	public void setAlternateField1( java.lang.String value ) {
		this.__alternate_field1 = value;
	}

	public java.lang.String getAlternateField2() {
		return this.__alternate_field2;
	}

	public void setAlternateField2( java.lang.String value ) {
		this.__alternate_field2 = value;
	}

	public java.lang.String getAlternateField3() {
		return this.__alternate_field3;
	}

	public void setAlternateField3( java.lang.String value ) {
		this.__alternate_field3 = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public void cloneCopy(BaseSprojectlogppoor __bean){
		__bean.setProjectLogId(getProjectLogId());
		__bean.setProjectId(getProjectId());
		__bean.setOperateId(getOperateId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setManagerId(getManagerId());
		__bean.setDesignPhase(getDesignPhase());
		__bean.setOperateTime(getOperateTime());
		__bean.setLogType(getLogType());
		__bean.setLogContent(getLogContent());
		__bean.setAlternateField1(getAlternateField1());
		__bean.setAlternateField2(getAlternateField2());
		__bean.setAlternateField3(getAlternateField3());
		__bean.setStatus(getStatus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectLogId() == null ? "" : getProjectLogId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getOperateId() == null ? "" : getOperateId());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getManagerId() == null ? "" : getManagerId());
		sb.append(",");
		sb.append(getDesignPhase() == null ? "" : getDesignPhase());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getLogType() == null ? "" : getLogType());
		sb.append(",");
		sb.append(getLogContent() == null ? "" : getLogContent());
		sb.append(",");
		sb.append(getAlternateField1() == null ? "" : getAlternateField1());
		sb.append(",");
		sb.append(getAlternateField2() == null ? "" : getAlternateField2());
		sb.append(",");
		sb.append(getAlternateField3() == null ? "" : getAlternateField3());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSprojectlogppoor o) {
		return __project_log_id == null ? -1 : __project_log_id.compareTo(o.getProjectLogId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_log_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__manager_id);
		hash = 97 * hash + Objects.hashCode(this.__design_phase);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__log_type);
		hash = 97 * hash + Objects.hashCode(this.__log_content);
		hash = 97 * hash + Objects.hashCode(this.__alternate_field1);
		hash = 97 * hash + Objects.hashCode(this.__alternate_field2);
		hash = 97 * hash + Objects.hashCode(this.__alternate_field3);
		hash = 97 * hash + Objects.hashCode(this.__status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSprojectlogppoor o = (BaseSprojectlogppoor)obj;
		if(!Objects.equals(this.__project_log_id, o.getProjectLogId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__operate_id, o.getOperateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__manager_id, o.getManagerId())) return false;
		if(!Objects.equals(this.__design_phase, o.getDesignPhase())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__log_type, o.getLogType())) return false;
		if(!Objects.equals(this.__log_content, o.getLogContent())) return false;
		if(!Objects.equals(this.__alternate_field1, o.getAlternateField1())) return false;
		if(!Objects.equals(this.__alternate_field2, o.getAlternateField2())) return false;
		if(!Objects.equals(this.__alternate_field3, o.getAlternateField3())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectLogId() != null) sb.append(__wrapNumber(count++, "projectLogId", getProjectLogId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getOperateId() != null) sb.append(__wrapNumber(count++, "operateId", getOperateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getManagerId() != null) sb.append(__wrapNumber(count++, "managerId", getManagerId()));
		if(getDesignPhase() != null) sb.append(__wrapNumber(count++, "designPhase", getDesignPhase()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getLogType() != null) sb.append(__wrapNumber(count++, "logType", getLogType()));
		if(getLogContent() != null) sb.append(__wrapString(count++, "logContent", getLogContent()));
		if(getAlternateField1() != null) sb.append(__wrapString(count++, "alternateField1", getAlternateField1()));
		if(getAlternateField2() != null) sb.append(__wrapString(count++, "alternateField2", getAlternateField2()));
		if(getAlternateField3() != null) sb.append(__wrapString(count++, "alternateField3", getAlternateField3()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectLogId")) != null) setProjectLogId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("operateId")) != null) setOperateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("managerId")) != null) setManagerId(__getInt(val)); 
		if((val = values.get("designPhase")) != null) setDesignPhase(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("logType")) != null) setLogType(__getInt(val)); 
		if((val = values.get("logContent")) != null) setLogContent(__getString(val));
		if((val = values.get("alternateField1")) != null) setAlternateField1(__getString(val));
		if((val = values.get("alternateField2")) != null) setAlternateField2(__getString(val));
		if((val = values.get("alternateField3")) != null) setAlternateField3(__getString(val));
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
	}

	protected java.lang.Integer  __project_log_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __operate_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __manager_id ;
	protected java.lang.Integer  __design_phase ;
	protected java.util.Date  __operate_time ;
	protected java.lang.Integer  __log_type ;
	protected java.lang.String  __log_content ;
	protected java.lang.String  __alternate_field1 ;
	protected java.lang.String  __alternate_field2 ;
	protected java.lang.String  __alternate_field3 ;
	protected java.lang.Integer  __status ;
}
