package pomplatform.annoucement.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSannoucementaaaor extends GenericBase implements BaseFactory<BaseSannoucementaaaor>, Comparable<BaseSannoucementaaaor> 
{


	public static BaseSannoucementaaaor newInstance(){
		return new BaseSannoucementaaaor();
	}

	@Override
	public BaseSannoucementaaaor make(){
		BaseSannoucementaaaor b = new BaseSannoucementaaaor();
		return b;
	}

	public final static java.lang.String CS_ANNOUCEMENT_ID = "annoucement_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_CUSTOMER_ID = "customer_id" ;
	public final static java.lang.String CS_ANNOUCEMENT_TITLE = "annoucement_title" ;
	public final static java.lang.String CS_ANNOUCEMENT_CONTENT = "annoucement_content" ;
	public final static java.lang.String CS_ANNOUCEMENT_TIME = "annoucement_time" ;
	public final static java.lang.String CS_ANNOUCEMENT_EMPLOYEE_IDS = "annoucement_employee_ids" ;
	public final static java.lang.String CS_ANNOUCEMENT_EMPLOYEE_NAMES = "annoucement_employee_names" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_STATUS = "status" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,项目编码,客户Id,公告主题,公告内容,公告时间,公告人员Id集,公告人员姓名集,发起人,操作时间,备注,公告状态（1已发布  2已发布）";

	public java.lang.Integer getAnnoucementId() {
		return this.__annoucement_id;
	}

	public void setAnnoucementId( java.lang.Integer value ) {
		this.__annoucement_id = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.Integer getCustomerId() {
		return this.__customer_id;
	}

	public void setCustomerId( java.lang.Integer value ) {
		this.__customer_id = value;
	}

	public java.lang.String getAnnoucementTitle() {
		return this.__annoucement_title;
	}

	public void setAnnoucementTitle( java.lang.String value ) {
		this.__annoucement_title = value;
	}

	public java.lang.String getAnnoucementContent() {
		return this.__annoucement_content;
	}

	public void setAnnoucementContent( java.lang.String value ) {
		this.__annoucement_content = value;
	}

	public java.util.Date getAnnoucementTime() {
		return this.__annoucement_time;
	}

	public void setAnnoucementTime( java.util.Date value ) {
		this.__annoucement_time = value;
	}

	public java.lang.String getAnnoucementEmployeeIds() {
		return this.__annoucement_employee_ids;
	}

	public void setAnnoucementEmployeeIds( java.lang.String value ) {
		this.__annoucement_employee_ids = value;
	}

	public java.lang.String getAnnoucementEmployeeNames() {
		return this.__annoucement_employee_names;
	}

	public void setAnnoucementEmployeeNames( java.lang.String value ) {
		this.__annoucement_employee_names = value;
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

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public void cloneCopy(BaseSannoucementaaaor __bean){
		__bean.setAnnoucementId(getAnnoucementId());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setCustomerId(getCustomerId());
		__bean.setAnnoucementTitle(getAnnoucementTitle());
		__bean.setAnnoucementContent(getAnnoucementContent());
		__bean.setAnnoucementTime(getAnnoucementTime());
		__bean.setAnnoucementEmployeeIds(getAnnoucementEmployeeIds());
		__bean.setAnnoucementEmployeeNames(getAnnoucementEmployeeNames());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
		__bean.setStatus(getStatus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getAnnoucementId() == null ? "" : getAnnoucementId());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getCustomerId() == null ? "" : getCustomerId());
		sb.append(",");
		sb.append(getAnnoucementTitle() == null ? "" : getAnnoucementTitle());
		sb.append(",");
		sb.append(getAnnoucementContent() == null ? "" : getAnnoucementContent());
		sb.append(",");
		sb.append(getAnnoucementTime() == null ? "" : sdf.format(getAnnoucementTime()));
		sb.append(",");
		sb.append(getAnnoucementEmployeeIds() == null ? "" : getAnnoucementEmployeeIds());
		sb.append(",");
		sb.append(getAnnoucementEmployeeNames() == null ? "" : getAnnoucementEmployeeNames());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSannoucementaaaor o) {
		return __annoucement_id == null ? -1 : __annoucement_id.compareTo(o.getAnnoucementId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__annoucement_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__customer_id);
		hash = 97 * hash + Objects.hashCode(this.__annoucement_title);
		hash = 97 * hash + Objects.hashCode(this.__annoucement_content);
		hash = 97 * hash + Objects.hashCode(this.__annoucement_time);
		hash = 97 * hash + Objects.hashCode(this.__annoucement_employee_ids);
		hash = 97 * hash + Objects.hashCode(this.__annoucement_employee_names);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSannoucementaaaor o = (BaseSannoucementaaaor)obj;
		if(!Objects.equals(this.__annoucement_id, o.getAnnoucementId())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__customer_id, o.getCustomerId())) return false;
		if(!Objects.equals(this.__annoucement_title, o.getAnnoucementTitle())) return false;
		if(!Objects.equals(this.__annoucement_content, o.getAnnoucementContent())) return false;
		if(!Objects.equals(this.__annoucement_time, o.getAnnoucementTime())) return false;
		if(!Objects.equals(this.__annoucement_employee_ids, o.getAnnoucementEmployeeIds())) return false;
		if(!Objects.equals(this.__annoucement_employee_names, o.getAnnoucementEmployeeNames())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getAnnoucementId() != null) sb.append(__wrapNumber(count++, "annoucementId", getAnnoucementId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getCustomerId() != null) sb.append(__wrapNumber(count++, "customerId", getCustomerId()));
		if(getAnnoucementTitle() != null) sb.append(__wrapString(count++, "annoucementTitle", getAnnoucementTitle()));
		if(getAnnoucementContent() != null) sb.append(__wrapString(count++, "annoucementContent", getAnnoucementContent()));
		if(getAnnoucementTime() != null) sb.append(__wrapDate(count++, "annoucementTime", getAnnoucementTime()));
		if(getAnnoucementEmployeeIds() != null) sb.append(__wrapString(count++, "annoucementEmployeeIds", getAnnoucementEmployeeIds()));
		if(getAnnoucementEmployeeNames() != null) sb.append(__wrapString(count++, "annoucementEmployeeNames", getAnnoucementEmployeeNames()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("annoucementId")) != null) setAnnoucementId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("customerId")) != null) setCustomerId(__getInt(val)); 
		if((val = values.get("annoucementTitle")) != null) setAnnoucementTitle(__getString(val));
		if((val = values.get("annoucementContent")) != null) setAnnoucementContent(__getString(val));
		if((val = values.get("annoucementTime")) != null) setAnnoucementTime(__getDate(val)); 
		if((val = values.get("annoucementEmployeeIds")) != null) setAnnoucementEmployeeIds(__getString(val));
		if((val = values.get("annoucementEmployeeNames")) != null) setAnnoucementEmployeeNames(__getString(val));
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
	}

	protected java.lang.Integer  __annoucement_id ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.Integer  __customer_id ;
	protected java.lang.String  __annoucement_title ;
	protected java.lang.String  __annoucement_content ;
	protected java.util.Date  __annoucement_time ;
	protected java.lang.String  __annoucement_employee_ids ;
	protected java.lang.String  __annoucement_employee_names ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __status ;
}
