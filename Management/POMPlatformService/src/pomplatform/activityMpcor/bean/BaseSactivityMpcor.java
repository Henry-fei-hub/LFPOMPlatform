package pomplatform.activityMpcor.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSactivityMpcor extends GenericBase implements BaseFactory<BaseSactivityMpcor>, Comparable<BaseSactivityMpcor> 
{


	public static BaseSactivityMpcor newInstance(){
		return new BaseSactivityMpcor();
	}

	@Override
	public BaseSactivityMpcor make(){
		BaseSactivityMpcor b = new BaseSactivityMpcor();
		return b;
	}

	public final static java.lang.String CS_ACTIVITIE_ID = "activitie_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_CUSTOMER_ID = "customer_id" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_MEET_TYPE = "meet_type" ;
	public final static java.lang.String CS_MEET_TIME = "meet_time" ;
	public final static java.lang.String CS_MEET_ADDRESS = "meet_address" ;
	public final static java.lang.String CS_MEET_TITLE = "meet_title" ;
	public final static java.lang.String CS_MEET_TARGET = "meet_target" ;
	public final static java.lang.String CS_CONTACT_NAME = "contact_name" ;
	public final static java.lang.String CS_THEIR_REQUIRE = "their_require" ;
	public final static java.lang.String CS_THEIR_EMPLOYEES = "their_employees" ;
	public final static java.lang.String CS_OUR_EMPLOYEES = "our_employees" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_OUR_DESIGNER_EMPLOYEES = "our_designer_employees" ;
	public final static java.lang.String CS_OUT_TIME_START = "out_time_start" ;
	public final static java.lang.String CS_OUT_TIME_END = "out_time_end" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,项目编码,客户Id,客户名称,项目名称,2我司出差拜访),会议时间,会议地址,会议主题,会议目标,联系人,甲方要求,甲方出席人员,我方出席人员,操作人,操作时间,备注,部门";
	public final static java.lang.String EXPORT_CAPTIONS = "部门,日期,星期,会议时间,外出开始时间,外出结束时间,会议地址（省）,会议地址（市）,会议详细地址,客户名称,客户出席人员,我司营销出席人员,我司设计出席人员,对接项目事宜(主要洽谈事项)";

	public java.lang.Integer getActivitieId() {
		return this.__activitie_id;
	}

	public void setActivitieId( java.lang.Integer value ) {
		this.__activitie_id = value;
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

	public java.lang.String getCustomerName() {
		return this.__customer_name;
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.Integer getMeetType() {
		return this.__meet_type;
	}

	public void setMeetType( java.lang.Integer value ) {
		this.__meet_type = value;
	}

	public java.util.Date getMeetTime() {
		return this.__meet_time;
	}

	public void setMeetTime( java.util.Date value ) {
		this.__meet_time = value;
	}

	public java.lang.String getMeetAddress() {
		return this.__meet_address;
	}

	public void setMeetAddress( java.lang.String value ) {
		this.__meet_address = value;
	}

	public java.lang.String getMeetTitle() {
		return this.__meet_title;
	}

	public void setMeetTitle( java.lang.String value ) {
		this.__meet_title = value;
	}

	public java.lang.String getMeetTarget() {
		return this.__meet_target;
	}

	public void setMeetTarget( java.lang.String value ) {
		this.__meet_target = value;
	}

	public java.lang.String getContactName() {
		return this.__contact_name;
	}

	public void setContactName( java.lang.String value ) {
		this.__contact_name = value;
	}

	public java.lang.String getTheirRequire() {
		return this.__their_require;
	}

	public void setTheirRequire( java.lang.String value ) {
		this.__their_require = value;
	}

	public java.lang.String getTheirEmployees() {
		return this.__their_employees;
	}

	public void setTheirEmployees( java.lang.String value ) {
		this.__their_employees = value;
	}

	public java.lang.String getOurEmployees() {
		return this.__our_employees;
	}

	public void setOurEmployees( java.lang.String value ) {
		this.__our_employees = value;
	}
	
	

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}
	public void setOurDesignerEmployees( java.lang.String value ) {
		this.__our_designer_employees=value;
		
	}
	public java.lang.String getOurDesignerEmployees() {
		return this.__our_designer_employees;
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

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}
	

	public java.lang.String getProvince() {
		return __province;
	}

	public void setProvince(java.lang.String value) {
		this.__province = value;
	}

	public java.lang.String getCity() {
		return __city;
	}

	public void setCity(java.lang.String value) {
		this.__city = value;
	}
	
	public java.util.Date getOutTimeStart() {
		return this.__out_time_start;
	}

	public void setOutTimeStart( java.util.Date value ) {
		this.__out_time_start = value;
	}

	public java.util.Date getOutTimeEnd() {
		return this.__out_time_end;
	}

	public void setOutTimeEnd( java.util.Date value ) {
		this.__out_time_end = value;
	}

	public void cloneCopy(BaseSactivityMpcor __bean){
		__bean.setActivitieId(getActivitieId());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setCustomerId(getCustomerId());
		__bean.setCustomerName(getCustomerName());
		__bean.setProjectName(getProjectName());
		__bean.setMeetType(getMeetType());
		__bean.setMeetTime(getMeetTime());
		__bean.setMeetAddress(getMeetAddress());
		__bean.setMeetTitle(getMeetTitle());
		__bean.setMeetTarget(getMeetTarget());
		__bean.setContactName(getContactName());
		__bean.setTheirRequire(getTheirRequire());
		__bean.setTheirEmployees(getTheirEmployees());
		__bean.setOurEmployees(getOurEmployees());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setOurDesignerEmployees(getOurDesignerEmployees());
		__bean.setProvince(getProvince());
		__bean.setCity(getCity());
		__bean.setOutTimeStart(getOutTimeStart());
		__bean.setOutTimeEnd(getOutTimeEnd());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getActivitieId() == null ? "" : getActivitieId());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getCustomerId() == null ? "" : getCustomerId());
		sb.append(",");
		sb.append(getCustomerName() == null ? "" : getCustomerName());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getMeetType() == null ? "" : getMeetType());
		sb.append(",");
		sb.append(getMeetTime() == null ? "" : sdf.format(getMeetTime()));
		sb.append(",");
		sb.append(getProvince() == null ? "" : getProvince());
		sb.append(",");
		sb.append(getCity() == null ? "" : getCity());
		sb.append(",");
		sb.append(getMeetAddress() == null ? "" : getMeetAddress().replaceAll(",", "，"));
		sb.append(",");
		sb.append(getMeetTitle() == null ? "" : getMeetTitle());
		sb.append(",");
		sb.append(getMeetTarget() == null ? "" : getMeetTarget());
		sb.append(",");
		sb.append(getContactName() == null ? "" : getContactName());
		sb.append(",");
		sb.append(getTheirRequire() == null ? "" : getTheirRequire());
		sb.append(",");
		sb.append(getTheirEmployees() == null ? "" : getTheirEmployees());
		sb.append(",");
		sb.append(getOurEmployees() == null ? "" : getOurEmployees());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getOurDesignerEmployees() == null ? "" : getOurDesignerEmployees());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSactivityMpcor o) {
		return __activitie_id == null ? -1 : __activitie_id.compareTo(o.getActivitieId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__activitie_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__customer_id);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__meet_type);
		hash = 97 * hash + Objects.hashCode(this.__meet_time);
		hash = 97 * hash + Objects.hashCode(this.__meet_address);
		hash = 97 * hash + Objects.hashCode(this.__meet_title);
		hash = 97 * hash + Objects.hashCode(this.__meet_target);
		hash = 97 * hash + Objects.hashCode(this.__contact_name);
		hash = 97 * hash + Objects.hashCode(this.__their_require);
		hash = 97 * hash + Objects.hashCode(this.__their_employees);
		hash = 97 * hash + Objects.hashCode(this.__our_employees);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__our_designer_employees);
		hash = 97 * hash + Objects.hashCode(this.__province);
		hash = 97 * hash + Objects.hashCode(this.__city);
		hash = 97 * hash + Objects.hashCode(this.__out_time_start);
		hash = 97 * hash + Objects.hashCode(this.__out_time_end);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSactivityMpcor o = (BaseSactivityMpcor)obj;
		if(!Objects.equals(this.__activitie_id, o.getActivitieId())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__customer_id, o.getCustomerId())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__meet_type, o.getMeetType())) return false;
		if(!Objects.equals(this.__meet_time, o.getMeetTime())) return false;
		if(!Objects.equals(this.__meet_address, o.getMeetAddress())) return false;
		if(!Objects.equals(this.__meet_title, o.getMeetTitle())) return false;
		if(!Objects.equals(this.__meet_target, o.getMeetTarget())) return false;
		if(!Objects.equals(this.__contact_name, o.getContactName())) return false;
		if(!Objects.equals(this.__their_require, o.getTheirRequire())) return false;
		if(!Objects.equals(this.__their_employees, o.getTheirEmployees())) return false;
		if(!Objects.equals(this.__our_employees, o.getOurEmployees())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__our_designer_employees, o.getOurDesignerEmployees())) return false;
		if(!Objects.equals(this.__province, o.getProvince())) return false;
		if(!Objects.equals(this.__city, o.getCity())) return false;
		if(!Objects.equals(this.__out_time_start, o.getOutTimeStart())) return false;
		if(!Objects.equals(this.__out_time_end, o.getOutTimeEnd())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getActivitieId() != null) sb.append(__wrapNumber(count++, "activitieId", getActivitieId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getCustomerId() != null) sb.append(__wrapNumber(count++, "customerId", getCustomerId()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getMeetType() != null) sb.append(__wrapNumber(count++, "meetType", getMeetType()));
		if(getMeetTime() != null) sb.append(__wrapDate(count++, "meetTime", getMeetTime()));
		if(getMeetAddress() != null) sb.append(__wrapString(count++, "meetAddress", getMeetAddress()));
		if(getMeetTitle() != null) sb.append(__wrapString(count++, "meetTitle", getMeetTitle()));
		if(getMeetTarget() != null) sb.append(__wrapString(count++, "meetTarget", getMeetTarget()));
		if(getContactName() != null) sb.append(__wrapString(count++, "contactName", getContactName()));
		if(getTheirRequire() != null) sb.append(__wrapString(count++, "theirRequire", getTheirRequire()));
		if(getTheirEmployees() != null) sb.append(__wrapString(count++, "theirEmployees", getTheirEmployees()));
		if(getOurEmployees() != null) sb.append(__wrapString(count++, "ourEmployees", getOurEmployees()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getOurDesignerEmployees() != null) sb.append(__wrapString(count++, "ourDesignerEmployees", getOurDesignerEmployees()));
		if(getProvince() != null) sb.append(__wrapString(count++, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapString(count++, "city", getCity()));
		if(getOutTimeStart() != null) sb.append(__wrapDate(count++, "outTimeStart", getOutTimeStart()));
		if(getOutTimeEnd() != null) sb.append(__wrapDate(count++, "outTimeEnd", getOutTimeEnd()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("activitieId")) != null) setActivitieId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("customerId")) != null) setCustomerId(__getInt(val)); 
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("meetType")) != null) setMeetType(__getInt(val)); 
		if((val = values.get("meetTime")) != null) setMeetTime(__getDate(val)); 
		if((val = values.get("meetAddress")) != null) setMeetAddress(__getString(val));
		if((val = values.get("meetTitle")) != null) setMeetTitle(__getString(val));
		if((val = values.get("meetTarget")) != null) setMeetTarget(__getString(val));
		if((val = values.get("contactName")) != null) setContactName(__getString(val));
		if((val = values.get("theirRequire")) != null) setTheirRequire(__getString(val));
		if((val = values.get("theirEmployees")) != null) setTheirEmployees(__getString(val));
		if((val = values.get("ourEmployees")) != null) setOurEmployees(__getString(val));
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("ourDesignerEmployees")) != null) setOurDesignerEmployees(__getString(val));
		if((val = values.get("province")) != null) setProvince(__getString(val));
		if((val = values.get("city")) != null) setCity(__getString(val));
		if((val = values.get("outTimeStart")) != null) setOutTimeStart(__getDate(val)); 
		if((val = values.get("outTimeEnd")) != null) setOutTimeEnd(__getDate(val)); 
	}

	protected java.lang.Integer  __activitie_id ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.Integer  __customer_id ;
	protected java.lang.String  __customer_name ;
	protected java.lang.String  __project_name ;
	protected java.lang.Integer  __meet_type ;
	protected java.util.Date  __meet_time ;
	protected java.lang.String  __meet_address ;
	protected java.lang.String  __meet_title ;
	protected java.lang.String  __meet_target ;
	protected java.lang.String  __contact_name ;
	protected java.lang.String  __their_require ;
	protected java.lang.String  __their_employees ;
	protected java.lang.String  __our_employees ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.String __our_designer_employees;
	private java.lang.String __province ;
	private java.lang.String __city ;
	protected java.util.Date  __out_time_start ;
	protected java.util.Date  __out_time_end ;
}
